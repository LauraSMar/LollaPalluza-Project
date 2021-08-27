const app = Vue.createApp({
    data() {
        return {
            products: [],
            activeNavbar: false,
            activeMenu: false,

            /* Cart */
            cart: {
                cartdtos: [],
                ticketDtos: [],
            },
            ticketPrice: 3000,


        }
    },
    created() {
        axios.get("/api/products")
            .then(res => {
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

        productDetails(id) {
            window.location = "./productDetails.html?productId=" + id
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
        getImg(id) {
            if (this.products.length == 0) {
                return
            }
            return this.products.filter(e => e.id == id)[0].img[0]
        },
        getName(id) {
            if (this.products.length == 0) {
                return
            }
            return this.products.filter(e => e.id == id)[0].description
        },
        getPrice(id){
            if (this.products.length == 0) {
                return
            }
            return this.products.filter(e => e.id == id)[0].price
        }
    },
    computed: {
        calculatePrice(){
            let price = 0
            if (this.cart.ticketDtos.length == 2){
                price =  this.ticketPrice - ( this.ticketPrice * 0.10 )
            } else if(this.cart.ticketDtos.length > 2 ){
                price =  this.ticketPrice - ( this.ticketPrice * 0.20 )
            }
            return price
        },
        totalCart() {
            let prodCounter = 0
            let tktCounter = this.cart.ticketDtos.length
            if (!this.cart.cartdtos && !this.cart.ticketDtos) {
                return
            }

            this.cart.cartdtos.map(e => prodCounter += e.quantity)
            return prodCounter + tktCounter
        },
        totalPrice() {
            
            if (this.products.length == 0) {
                return
            }
            let price = 0
            if (this.cart.ticketDtos.length == 2){
                price =  this.ticketPrice - ( this.ticketPrice * 0.10 )
            } else if(this.cart.ticketDtos.length > 2 ){
                price =  this.ticketPrice - ( this.ticketPrice * 0.20 )
            }

            let ids = this.cart.cartdtos.map(e => e.idItem)

            let counter = 0
            let total = 0

            for (let i = 0; i < ids.length; i++) {
                counter = this.products.filter(e => e.id == ids[i])[0].price * this.cart.cartdtos[i].quantity
                total += counter
            }

            let tktCounter = this.cart.ticketDtos.length * price
            return total + tktCounter
        },

    }
}).mount("#app")

