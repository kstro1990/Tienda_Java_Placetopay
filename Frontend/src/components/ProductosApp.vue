<template>
<Card>
    <template #title>
        Productos
    </template>
    <template #content>    
    <div>
        <DataTable :value="productos" :paginator="true" :rows="20"
            paginatorTemplate="CurrentPageReport FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink RowsPerPageDropdown"
            :rowsPerPageOptions="[10,20,50]" responsiveLayout="scroll"
            currentPageReportTemplate="Showing {first} to {last} of {totalRecords}">
            <Column field="id" header="ID"></Column>
            <Column field="reference" header="Referencia"></Column>
            <Column field="price" header="Procio"></Column>
            <Column header="Status">
                <template #body="productos">
                    <span :class="'product-badge status-'+ productos.data.status">{{productos.data.status}}</span>
                </template>
            </Column>
        </DataTable>
    </div>
    </template>
</Card>
</template>

<script>
import productosSevice from '@/service/ProductosSerivice';

const newLocal='productosApp';
export default {
    name : newLocal,
    data(){
        return {
            productos : null
        }
    },
    productos : null,
    created(){
        this.productosevice = new productosSevice(); 

    },
    mounted(){
        this.productosevice.getAll().then(
            data=>{
            this.productos = data.data
        }
            /*data=>{
                console.log(data.data);
            }*/
        )
    }
}
</script>

<style>

</style>
