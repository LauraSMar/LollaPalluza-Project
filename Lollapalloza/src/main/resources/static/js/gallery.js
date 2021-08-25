const app = Vue.createApp({
    data() {
        return {
            email: "",
            password: "",
            commentId: "",
            imageId: "",
            commentText: "",
            error: false,
            comments: [],
        }
    },
    created(){
        this.allComments()
    },
    methods: {
        login() {
            axios.post('/api/login', "email=" + this.email + "&password=" + this.password, { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
                .then(() => {
                    if (this.email == "admin@admin.com") {
                        window.location.href = "/admin.html"
                    } else window.location.href = "/index.html"
                })
                .catch(() => swal('Email o contraseña incorrectos'))
        },
        postComment(){
            axios.post('/api/images'+this.imageId+'/comments',{
                text: this.commentText})
                .then(()=> swal("Comentario enviado exitosamente", {
                    icon: "success",
                  })
                .then(() => location.reload))
                .catch(() => {swal('Necesitas estar logueado para poder comentar');
                 this.error = !this.error});
        },
        allComments(){
            axios.get('/api/images/1/comments')
            .then(res=> 
                this.comments = res.data)
        },

        fetch(){
            axios.get('/api/comments'+this.commentId)
        },

        editComment(){
            axios.post('/api/comments'+this.commentId,{
                newText: this.commentText})
                .then(()=> swal("Comentario editado exitosamente", {
                    icon: "success",
                  })
                .then(() => location.reload))
        },
        deleteComment(){
            axios.delete('/api/comments'+this.commentId)
                .then(()=> swal("success deleting your comment", {
                    icon: "success",
                  })
                .then(() => location.reload))
        },
    }
});
