const app = Vue.createApp({
    data() {
        return {
            events: [],
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

    },
}).mount("#app")