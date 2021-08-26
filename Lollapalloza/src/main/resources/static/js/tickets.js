const app = Vue.createApp({
    data() {
        return {
            events: [],
            selEvents: [],
            disabled: 0,
            check: [],



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
    },
    methods: {
        selectEvent(event) {
            this.selEvents.push(event);
            console.log(this.selEvents.length)

        },


    },
    computed: {
        // datesTicket(){
        //     this.selEvents
        // }
    }
}).mount("#app")