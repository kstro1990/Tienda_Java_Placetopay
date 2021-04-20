<template>
<div class="p-grid p-jc-center" >
<Card style="width: 25rem; margin-bottom: 2em">
    <template #title>
        Registrar Usuario
        <Divider />
        <img alt="Logo" src="https://static.placetopay.com/placetopay-logo.png" style="width: 20rem; margin-bottom: 1em">
        <Divider />
    </template>
    <template #content>
        <form v-on:submit.prevent="guardarUsuarioFun">
            
                <div class="p-field">
                    <label for="nombre" class="p-sr-only">Nombre</label>
                    <InputText id="nombre" type="text" placeholder="Nombre" v-model="nombre"/>
                </div>
                
                <div class="p-field">
                    <label for="apellido" class="p-sr-only">Apellido</label>
                    <InputText id="apellido" type="text" placeholder="Apellido" v-model="apellido"/>
                </div>

                <div class="p-field">
                    <label for="email" class="p-sr-only">Email</label>
                    <InputText id="email" type="text" placeholder="Email" v-model="email"/>
                </div>

                <div class="p-field">
                    <label for="mobile" class="p-sr-only">Celular</label>
                    <InputText id="mobile" type="text" placeholder="Celular" v-model="mobile"/>
                </div>

                <Button type="submit" label="Registrar" />
            
        </form>
    </template>
</Card>
</div>
</template>

<script>
import registrarUsuario from '../service/RegistrarUsuarioService'

const newLocal='RegistrarUsuarioApp';

export default ({
    name : newLocal,
    data(){
        return {
            usuario : null,
            nombre : null,
            apellido : null,
            email : null, 
            mobile : null,
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
        let Datajson = {
            "nombre" : this.nombre,
            "apellido": this.apellido,
            "email" : this.email, 
            "mobile" : this.mobile,
            "created_at": Date.now().toString(),
        };
            let respuesta = this.registrarUsuario.guardarUsuario(Datajson);

            respuesta.then(data =>{
                if (data.status ==200) {
                    console.log(data.status);
                    console.log(data);
                }else{
                    console.log("Ocurrio un problema en el Registro de Usuario : "+ data.status);
                }
            })
           
        }
    }

})
</script>


<style>

</style>


