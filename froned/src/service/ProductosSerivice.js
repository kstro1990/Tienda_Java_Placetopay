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
    };
    addCar(productID, customerID){
        var endpoint = 'http://localhost:8080/V1/products/buscar/'+ productID;
        var urlAddCard = 'http://localhost:8080/V1/car/guardar';
        var prductByID = axios.get(endpoint);

        prductByID.then(data=>{
            var json = {
                customer: customerID,
                producto: data.data.id,
                precio: data.data.price,
                cantidad: 1
            }
            axios.post(urlAddCard,json);
        });
        return prductByID;
    };
    carTemp(IdCustomer){
        var endpoint = 'http://localhost:8080/V1/car/listarPorUsuario/'+ IdCustomer;
        return axios.get(endpoint);
    };
    pagarTemp(IdCustomer){
        var endpoint = 'http://localhost:8080/V1/pagar/p2p';
        var endpointCarritoTemp = 'http://localhost:8080/V1/car/listarPorUsuario/'+ IdCustomer;

        axios.get(endpointCarritoTemp)
        .then(data=>{
            var jsonCarTemp = {
                customerID: IdCustomer,
                totalAmout: data.data.totalAmout,
                totalProduct: data.data.totalProduct
            }
            console.log(jsonCarTemp);
            var testear = axios.post(endpoint,jsonCarTemp);
            testear.then(data=>{
                console.log(data.data);
            })
        })
        
        //return axios.get(endpoint,jsonCarTemp);
    }
}