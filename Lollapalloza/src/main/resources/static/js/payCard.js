const app = Vue.createApp({
    data() {
        return {
            name: "",
            numberCard: "",
            date: "",
            date2: "",
            cvv: null,
            urlSelect: "",
            /* Add To Cart*/
            cart: {
                cartdtos: [],
                ticketDtos: [],
            },

            activeNavbar: false,
            activeMenu: false,
        }
    },
    created() {},
    methods: {
        pay() {
            console.log(this.amount)
            console.log(this.description)
            console.log(this.urlSelect)
            console.log(this.cvv)

            var url = 'http://localhost:8080/api/payment';
            var data = {
                name: this.name,
                number: this.numberCard,
                cvv: parseInt(this.cvv),
                thruDate: "20" + this.cardVto.replace("/", "-") + "-29",
                description: "Lollapalooza-market",
                amount: parseInt(this.cardMonto)
            };
            fetch(url, {
                    method: 'POST', // or 'PUT'
                    body: JSON.stringify(data), // data can be `string` or {object}!                
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                /* .then(res => console.log(res.json())) */
                /*.then(response => alert(data.response))*/
                .then(res => {
                    if (res.status == 200 || res.status == 202) {
                        axios.post("/api/users/current/payment", this.cart)
                            .then(res => {
                                swal("Genial", "Compra exitosa ", "success").then(res => location.href = 'http://localhost:8080/index.html');
                            })
                    }
                    return swal('No se pudo procesar el pago, revise los datos de la tarjeta')
                })
                .catch(error => {
                    swal("Error", "Error para procesar pago con su banco", "error");
                })
        }
    },
    computed: {

    }
}).mount("#app")