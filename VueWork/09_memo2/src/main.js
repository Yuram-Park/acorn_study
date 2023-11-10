import { createApp } from 'vue'
import App from './step6/App.vue'

import HeaderComponent from './components/HeaderComponent.vue'
import FooterComponent from './components/HeaderComponent.vue'

const app = createApp(App)
app.component("HeaderComponent", HeaderComponent)
app.component("FooterComponent", FooterComponent)

app.mount('#app')
