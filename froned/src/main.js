import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import 'primevue/resources/themes/saga-blue/theme.css'      //theme
import 'primevue/resources/primevue.min.css'             //core css
import 'primeicons/primeicons.css'                           //icons

import 'primeflex/primeflex.css';


import PrimeVue from 'primevue/config';
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';
import ColumnGroup from 'primevue/columngroup';
import Card from 'primevue/card';
import Menu from 'primevue/menu';
import InputText from 'primevue/inputtext';
import Button from 'primevue/button';
import Panel from 'primevue/panel';
import Fieldset from 'primevue/fieldset';
import Divider from 'primevue/divider';
import DataView from 'primevue/dataview';
import Dropdown from 'primevue/dropdown';
import Rating from 'primevue/rating';
import DataViewLayoutOptions from 'primevue/dataviewlayoutoptions';

 

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
app.component('Fieldset',Fieldset);
app.component('Divider',Divider);
app.component('DataView',DataView);
app.component('Dropdown',Dropdown);
app.component('Rating',Rating);
app.component('DataViewLayoutOptions',DataViewLayoutOptions);

app.mount('#app')
