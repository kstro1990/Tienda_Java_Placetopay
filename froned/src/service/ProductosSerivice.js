import axios from 'axios'; 

export default class ProductosSerivice{

    data(){
        return{
        customer:0,
        producto:0,
        precio:0,
        cantidad:0
    }
    }
    url = 'http://localhost:8080/V1';
    
    getAll(){
        return axios.get( this.url+'/products/listar');
    }

    addCar(productID){
        var endpoint = 'http://localhost:8080/V1/products/buscar/'+ productID;
        console.log(endpoint);
        var urlAddCard = 'http://localhost:8080/V1/car/guardar';
        var prductByID = axios.get(endpoint);

        prductByID.then(data=>{
            var json = {
                customer: 43,
                producto: data.data.id,
                precio: data.data.price,
                cantidad: 1
            }
            var requestCard = axios.post(urlAddCard,json);

            console.log(requestCard);
        });

        

        return 2;
    }
}