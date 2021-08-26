const app = Vue.createApp({
    data() {
        return {
            events: [],
            selEvents: [],
            disabled: 0,
            check: [],


            /* Add To Cart*/
            cart:{
                cartdtos: [],
                ticketDtos: [],
            },
            quantity: 1,
            activeNavbar: false,
            activeMenu: false,
        }
    },
    created() {
        axios.get("/api/events")
            .then(res => {
                this.events = res.data
                console.log(this.events)

            })
        if (JSON.parse(sessionStorage.getItem("cart"))) {
            this.cart = JSON.parse(sessionStorage.getItem("cart"))
        } else {
            sessionStorage.setItem("eze", JSON.stringify(this.cart))
        }    
    },
    methods: {
        selectEvent(event) {
            this.selEvents.push(event);
            console.log(this.selEvents.length)

        },
        addToCart(){
            let ticketId = this.check.map(e => e.id)
            let ticketToCart = {
                idEvents: ticketId
            }
            for(let i = 0; i < this.quantity; i++){
                this.cart.ticketDtos.push(ticketToCart)
                sessionStorage.setItem("cart", JSON.stringify(this.cart))
            }
            this.check = []
        }

    },
    computed: {
        // datesTicket(){
        //     this.selEvents
        // }
    }
}).mount("#app")