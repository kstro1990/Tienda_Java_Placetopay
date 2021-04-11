<template>
<Card>
    <template #title>
        Registrar Usuario
    </template>
    <template #content>
        <form v-on:submit.prevent="guardarUsuarioFun">
            <div class="p-formgroup-inline">
                <div class="p-field">
                    <label for="nombre" class="p-sr-only">Nombre</label>
                    <InputText id="nombre" type="text" placeholder="Nombre" v-model="nombre"/>
                </div>
                <div class="p-field">
                    <label for="apellido" class="p-sr-only">Apellido</label>
                    <InputText id="apellido" type="text" placeholder="Apellido" v-model="apellido"/>
                </div>
                <Button type="submit" label="Submit" />
            </div>
        </form>
    </template>
</Card>
</template>

<script>
import registrarUsuario from '../service/RegistarUsuarioService'

const newLocal='RegistarUsuarioApp';

export default ({
    name : newLocal,
    data(){
        return {
            usuario : null,
            nombre : null,
            apellido : null,
            error: false,
            error_msg: "",
        }
    },
    usuario : null,
    created(){
        this.registrarUsuario = new registrarUsuario(); 

    },
    mounted() {      
        console.log("hola mundo");
    },
    methods :{
        guardarUsuarioFun(){
        let json = {
          "nombre" : this.nombre,
          "apellido": this.apellido
        };
            let respuesta = this.registrarUsuario.guardarUsuario(json);
            //console.log(respuesta);
        }
    }

})
</script>


<style>

</style>


