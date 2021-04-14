import axios from 'axios'; 

export default class ProductosSerivice{
    url = 'http://localhost:8080/V1';
    
    getAll(){
        return axios.get( this.url+'/products/listar');
    }

    addCar(productID){
        var endpoint = 'http://localhost:8080/V1/products/buscar/'+ productID;
        console.log(endpoint);
        return axios.get(endpoint);
    }
}