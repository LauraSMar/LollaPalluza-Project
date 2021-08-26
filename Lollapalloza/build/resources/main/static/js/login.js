const app = Vue.createApp({
    data() {
        return {
            email: "",
            password: "",
            postFname: "",
            postLname: "",
            postEmail: "",
            postPassword: "",
            documentId:"",
            isUser: true,
            options: false,
        }
    },
    methods: {
        login() {
            axios.post('/api/login', "email=" + this.email + "&password=" + this.password, { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
                .then(()=> this.options = !this.options)
                .then(() => {
                    if (this.email == "admin@admin.com") {
                        window.location.href = "/admin.html"
                    } else window.location.href = "/index.html"
                })
                
                .catch(() => swal('Wrong mail or password'))
        },
        register() {
            axios.post('/api/users', "firstName=" + this.postFname + "&lastName=" + this.postLname + "&documentId="+ this.documentId+"&email=" + this.postEmail + "&password=" + this.postPassword + "&type=AHORRO", { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
                .then(() => swal('Hi ' + this.postFname + ', Bienvenido a Lollapalooza !!!'))
                .then(() => {
                    this.isUser = !this.isUser
                    axios.post('/api/login', "email=" + this.postEmail + "&password=" + this.postPassword, { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
                        .then(() => window.location.href = "/index.html")

                })
                .catch(err => swal('Datos Incorrectos ' + err))

        }
    },
})