const app = Vue.createApp({
    data() {
        return {
            name: "",
            numberCard: "",
            date: "",
            date2: "",
            cvv: 0,
            urlSelect: "",
            description: "Lollapalooza-market",
            amount: 3000,
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

            var url = this.urlSelect;
            var data = {
                cardNumber: this.numberCard,
                cvv: this.cvv,
                description: "Lolapalloza-market",
                amount: this.amount
            };
            fetch(url, {
                    method: 'POST',
                    mode: 'no-cors', // or 'PUT'
                    body: JSON.stringify(data), // data can be `string` or {object}!                
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                /* .then(res => console.log(res.json())) */
                /*.then(response => alert(data.response))*/
                .then(res => {
                    console.log("compra realizada")
                        // if (res.status == 200 || res.status == 202) {
                        //     return swal('Pago Procesado Correctamente')
                        // }
                        // return swal('No se pudo procesar el pago, revise los datos de la tarjeta')
                })
                .catch(error => console.log(error))
                // axios({
                //         method: 'post',
                //         mode: 'no-cors',
                //         url: this.urlSelect,
                //         data: {
                //             cardNumber: this.numberCard, //string
                //             cvv: this.cvv, //int
                //             // thruDate: this.date + "/" + this.date2,
                //             description: this.description,
                //             amount: this.amount, //amount
                //         }
                //     })
                //     .then(res => {
                //         swal("Genial", "Pago procesado con exito", "success")
                //             // if (res.status == 200) {
                //             //     axios.post("/api/users/current/payment", this.cart)
                //             //         .then(res => {
                //             //             swal("Genial", "Pago procesado con exito", "success")
                //             //                 .then(res => location.reload());
                //             //         })
                //             //         .catch(err => swal("Opss", "Pago no procesado con exito", "error"))
                //             // }
                //     })
                //     .catch(err => {
                //         swal("Opss", "todo mal", "warning")
                //     })
        }
    },
    computed: {

    }
}).mount("#app")