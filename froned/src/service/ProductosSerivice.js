import axios from 'axios'; 

export default class ProductosSerivice{
    url = 'http://localhost:8080/V1';
    
    getAll(){
        return axios.get( this.url+'/products/listar');
    }
}