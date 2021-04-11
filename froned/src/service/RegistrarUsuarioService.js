import axios from 'axios'; 

export default class RegistrarUsuarioService{
    url = 'http://localhost:8080/V1';
    
    getAll(){
        return axios.get( this.url+'/personas/personas');
    }

    guardarUsuario(dataJson){
        let respuesta = axios({
            method: 'post',
            url: this.url+'/personas/guardar',
            data: dataJson
          });
          console.log(dataJson);
        return respuesta;
    }
}