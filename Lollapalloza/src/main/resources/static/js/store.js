const app = Vue.createApp({
    data() {
        return {
            products:[],
            activeNavbar: false,
            activeMenu: false,

            /* Cart */
            cart:{
                cartdtos: [],
                ticketDtos: [],
            },

            /* HARDCODEANDO DE LO LINDO*/
            eventos:[{
                day: 1,
                date: "27-11-2021",
                location: "Casa Rosada"
            },
            {
                day: 2,
                date: "28-11-2021",
                location: "Hipodromo de Palermo"
            },
            {
                day: 3,
                date: "29-11-2021",
                location: "Velez Sarsfield"
            },
            {
                day: 4,
                date: "30-11-2021",
                location: "Luna Park"
            }
            ]  

            
        }
    },
    created(){
        axios.get("/api/products")
            .then(res=>{
                this.products = res.data
                console.log(this.products)
            })
        if (JSON.parse(sessionStorage.getItem("cart"))) {
            this.cart = JSON.parse(sessionStorage.getItem("cart"))
            } else {
            sessionStorage.setItem("cart", JSON.stringify(this.cart))
            }
    },
    methods: {

        productDetails(id){
            window.location="./productDetails.html?productId="+id
        },
        formatBalance(balance) {
            if (balance == null) {
              return
            }
            let amount = new Intl.NumberFormat('en-US', {
              style: 'currency',
              currency: 'USD',
            })
            return amount.format(balance)
          },
        ticketTitle(ticket){
            console.log(ticket)
        }
    },
    computed: {
        totalCart(){
            let prodCounter = 0
            let tktCounter = 0
            this.cart.cartdtos.map(e => prodCounter += e.quantity)
            this.cart.ticketDtos.map(e => tktCounter += e.idEvents.length)
            return prodCounter + tktCounter
        },
        totalPrice(){
            if(this.products){
                return
            }
            let ids = this.cart.cartdtos.map(e=> e.idItem)

            let counter = 0
            let total = 0

            for ( let i = 0; i < ids.length; i++){
                counter = this.products.filter(e=> e.id == ids[i])[0].price * this.cart.cartdtos[i].quantity
                total += counter
            } 

            let tktCounter = 0
            this.cart.ticketDtos.map(e =>{ 
                tktCounter += e.idEvents.length
            })
            total = total + (tktCounter * 3000)
            return total
        }
    }
}).mount("#app")

