const app = Vue.createApp({
    data() {
        return {
            email: "",
            password: "",
            notLogged: false,
        }
    },
    methods: {
        login() {
            axios.post('/api/login', "email=" + this.email + "&password=" + this.password, { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
                .then(() => {
                    if (this.email == "admin@admin.com") {
                        window.location.href = "/admin.html"
                    } else window.location.href = "/index.html"
                })
                .catch(() => swal('Wrong mail or password'))
        },
    },
})