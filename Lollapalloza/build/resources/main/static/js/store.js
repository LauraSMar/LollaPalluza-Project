const app = Vue.createApp({
    data() {
        return {
            products:[],
            activeNavbar: false,
            activeMenu: false,
        }
    },
    created(){
        axios.get("/api/products")
            .then(res=>{
                this.products = res.data
            })
    },
    methods: {

        productDetails(id){
            window.location="./productDetails.html?productId="+id
        }

    },
}).mount("#app")

