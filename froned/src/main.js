import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import 'primevue/resources/themes/saga-blue/theme.css'      //theme
import 'primevue/resources/primevue.min.css'             //core css
import 'primeicons/primeicons.css'                           //icons

import PrimeVue from 'primevue/config';
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';
import ColumnGroup from 'primevue/columngroup';
import Card from 'primevue/card';
import Menu from 'primevue/menu';
import InputText from 'primevue/inputtext';
import Button from 'primevue/button';
import Panel from 'primevue/panel';
import vueConfig from '../vue.config';



const app =  createApp(App).use(store).use(router).use(PrimeVue);


app.component('DataTable',DataTable);
app.component('Column',Column);
app.component('ColumnGroup',ColumnGroup);
app.component('vueConfig',vueConfig);
app.component('Card',Card);
app.component('Menu',Menu);
app.component('InputText',InputText);
app.component('Button',Button);
app.component('Panel',Panel);

app.mount('#app')
