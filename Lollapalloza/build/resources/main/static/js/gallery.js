const app = Vue.createApp({
    data() {
        return {
            email: "",
            password: "",
<<<<<<< Updated upstream
            commentId: "",
            imageId: "",
            commentText: "",
            error: false,
            comments: [],
            images: [],
        }
    },
    created(){
        this.allImages();
        this.allComments(1);
    },
=======
            notLogged: false,
        }
    },
>>>>>>> Stashed changes
    methods: {
        login() {
            axios.post('/api/login', "email=" + this.email + "&password=" + this.password, { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
                .then(() => {
<<<<<<< Updated upstream
                    location.reload;
                })
                .catch(() => swal('Email o contraseña incorrectos'))
        },
        postComment(){
            axios.post('/api/images/'+this.imageId+'/comments',
                this.commentText)
                .then(()=> swal("Comentario enviado exitosamente", {
                    icon: "success",
                  })
                .then(() => location.reload))
                .catch(() => {swal('Necesitas estar logueado para poder comentar');
                 this.error = !this.error});
        },

        allImages(){
            axios.get('/api/images')
            .then(res => {
                this.images = res.data,
                this.imageId= res.data.id,
                console.log(this.imageId)})
        },

        allComments(id){
            axios.get('/api/images/'+id+'/comments')
            .then(res=> {
                this.comments = res.data
            })
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
        formatDate: function(date){
            return new Date(date).toLocaleDateString('en-gb');
        },  
    }
});
=======
                    if (this.email == "admin@admin.com") {
                        window.location.href = "/admin.html"
                    } else window.location.href = "/index.html"
                })
                .catch(() => swal('Wrong mail or password'))
        },
    },
})
>>>>>>> Stashed changes
