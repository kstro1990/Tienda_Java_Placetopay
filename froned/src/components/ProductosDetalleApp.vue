<template>
    <div class="card">
        <DataView :value="productos" :layout="layout" :paginator="true" :rows="9" :sortOrder="sortOrder" :sortField="sortField">
			<template #header>
                <div class="p-grid p-nogutter">
                    <div class="p-col-6" style="text-align: left">
                        <Dropdown v-model="sortKey" :options="sortOptions" optionLabel="label" placeholder="Sort By Price" @change="onSortChange($event)"/>
                    </div>
                    <div class="p-col-6" style="text-align: right">
                        <Button label="Plain" class="p-button-text p-button-help" @click="openResponsive" >
                            <span  class="pi pi-shopping-cart" style="fontSize: 2rem" v-badge=cantidadCard></span>
                        </Button>
                    </div>
                </div>
			</template>

			<template #list="slotProps">
				<div class="p-col-12">
					<div class="product-list-item">
						<img src="https://www.primefaces.org/wp-content/uploads/2020/05/placeholder.png" :alt="slotProps.data.reference"/>
						<div class="product-list-detail">
							<div class="product-reference">{{slotProps.data.reference}}</div>
							<div class="product-description">{{slotProps.data.description}}</div>
							<Rating :modelValue="slotProps.data.rating" :readonly="true" :cancel="false"></Rating>
							<i class="pi pi-tag product-category-icon"></i><span class="product-category">{{slotProps.data.category}}</span>
						</div>
						<div class="product-list-action">
							<span class="product-price">${{slotProps.data.price}}</span>
							<Button icon="pi pi-shopping-cart" label="Add to Cart" :disabled="slotProps.data.status === 'OUTOFSTOCK'"></Button>
							<span :class="'product-badge status-'+slotProps.data.status.toLowerCase()">{{slotProps.data.status}}</span>
						</div>
					</div>
				</div>
			</template>

			<template #grid="slotProps">
				<div class="p-col-12 p-md-4">
					<div class="product-grid-item card">
						<div class="product-grid-item-top">
							<div>
								<i class="pi pi-tag product-category-icon"></i>
								<span class="product-category">{{slotProps.data.category}}</span>
							</div>
							<span :class="'product-badge status-'+slotProps.data.status.toLowerCase()">{{slotProps.data.status}}</span>
						</div>
						<div class="product-grid-item-content">
							<img :src="slotProps.data.imagen" style="width: 80%;" alt="https://www.primefaces.org/wp-content/uploads/2020/05/placeholder.png" />
							<div class="product-reference">{{slotProps.data.reference}}</div>
							<div class="product-description">{{slotProps.data.description}}</div>
							<Rating :modelValue="slotProps.data.rating" :readonly="true" :cancel="false"></Rating>
						</div>
						<div class="product-grid-item-bottom">
							<span class="product-price">${{slotProps.data.price}}</span>            
							<Button v-on:click="shopCar(slotProps.data.id)" icon="pi pi-shopping-cart" :disabled="slotProps.data.status === 'OUTOFSTOCK'"></Button>
						</div>
					</div>
				</div>
			</template>
		</DataView>
	</div>
            <Dialog header="Header" v-model:visible="displayResponsive" :breakpoints="{'960px': '75vw'}" :style="{width: '50vw'}">
            <div class="p-fluid">
                <div class="p-field">
                    <h3>Total productos</h3>
                    <h4>{{totalProduct}}</h4>
                </div>
                <div class="p-field">
                    <h3>Total</h3>
                    <h4>USD : {{totalCar}}</h4>
                </div>
            </div>

            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            <template #footer>
                <Button label="Pagar" class="p-button-text" @click="callP2P"></Button>
                <Button label="Yes" icon="pi pi-check" @click="closeResponsive" autofocus />
            </template>
        </Dialog>
</template>

<script>
import productosSevice from '@/service/ProductosSerivice';

export default {
    data() {
        return {
            displayResponsive: false,
            cantidadCard: 0,
            totalCar: 0,
            totalProduct : 0,
            cars: null,
            productos: null,
            listarP : null,
            layout: 'grid',
            sortKey: null,
            sortOrder: null,
            sortField: null,
            sortOptions: [
                {label: 'Price High to Low', value: '!price'},
                {label: 'Price Low to High', value: 'price'},
            ]
        }
    },
    productService: null,
    carService: null,
    created() {
        this.productoSevice = new productosSevice();

    },
    mounted() {
        this.productoSevice.getAll().then(
            data=>{
            this.productos = data.data
        });
        localStorage.customer = 42;
        this.productoSevice.carTemp(localStorage.getItem('customer'))
            .then(data =>{
                this.cantidadCard = data.data.totalProduct;
                console.log(data.data);
            })
    },
    methods: {
        onSortChange(event){
            const value = event.value.value;
            const sortValue = event.value;

            if (value.indexOf('!') === 0) {
                this.sortOrder = -1;
                this.sortField = value.substring(1, value.length);
                this.sortKey = sortValue;
            }
            else {
                this.sortOrder = 1;
                this.sortField = value;
                this.sortKey = sortValue;
            }
        },
        shopCar(productID){
            console.log(productID);
            this.cantidadCard = this.cantidadCard +1;
            this.productoSevice.addCar(productID, localStorage.getItem('customer'))
            .then(resq=>{
                console.log(resq.data);
            });
        },
        cartTempGet(){
            this.productoSevice.carTemp(localStorage.getItem('customer'))
            .then(resq =>{
                this.cantidadCard = resq.data.totalProduct;
                console.log(resq.data);
            })
        },
        openResponsive() {
            this.displayResponsive = true;
            this.productoSevice.carTemp(localStorage.getItem('customer'))
            .then(resq =>{
                this.totalProduct = resq.data.totalProduct;
                this.totalCar =  resq.data.totalAmout;
                console.log(resq.data);
            })
        },
        closeResponsive() {
            this.displayResponsive = false;
        },
        callP2P(){
            //alert("Aqui toy Compadre");
            this.productoSevice.pagarTemp(localStorage.getItem('customer'))
        }
    }
}
</script>

<style scoped>
.card {
    background: #ffffff;
    padding: 2rem;
    box-shadow: 0 2px 1px -1px rgba(0,0,0,.2), 0 1px 1px 0 rgba(0,0,0,.14), 0 1px 3px 0 rgba(0,0,0,.12);
    border-radius: 4px;
    margin-bottom: 2rem;
}

.p-dropdown {
    width: 14rem;
    font-weight: normal;
}

.product-name {
	font-size: 1.5rem;
	font-weight: 700;
}

.product-description {
	margin: 0 0 1rem 0;
}

.product-category-icon {
	vertical-align: middle;
	margin-right: .5rem;
}

.product-category {
	font-weight: 600;
	vertical-align: middle;
}

.product-grid-item{
    margin: .5rem;
    border: 1px solid #dee2e6;
}

.product-grid-item-top,
.product-grid-item-bottom {
    display: flex;
    align-items: center;
    justify-content: space-between;
}

.product-grid-item-content {
    text-align: center;
}

    .product-price {
    font-size: 1.5rem;
    font-weight: 600;
}
</style>