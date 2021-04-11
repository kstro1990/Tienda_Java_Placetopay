<template>
<Card>
    <template #title>
        Usuarios
    </template>
    <template #content>    
    <div>
        <DataTable :value="personas" :paginator="true" :rows="10"
            paginatorTemplate="CurrentPageReport FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink RowsPerPageDropdown"
            :rowsPerPageOptions="[10,20,50]" responsiveLayout="scroll"
            currentPageReportTemplate="Showing {first} to {last} of {totalRecords}">
            <Column field="id" header="ID"></Column>
            <Column field="nombre" header="Nombre"></Column>
            <Column field="apellido" header="Apellido"></Column>
        </DataTable>
    </div>
    </template>
</Card>
</template>

<script>
import PersonaSevice from '@/service/PerosonaService';

const newLocal='PersonasApp';
export default {
    name : newLocal,
    data(){
        return {
            personas : null
        }
    },
    PersonaSevice : null,
    created(){
        this.PersonaSevice = new PersonaSevice(); 

    },
    mounted(){
        this.PersonaSevice.getAll().then(
            data=>{
            this.personas = data.data
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
