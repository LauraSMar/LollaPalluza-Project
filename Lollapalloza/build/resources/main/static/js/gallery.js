const app = Vue.createApp({
    data() {
        return {
            email: "",
            password: "",
            commentId: "",
            imageId: 1,
            commentText: "",
            error: false,
            comments: [],
            images: [],
            newText: "",
        }
    },
    created(){
        this.allImages();
        this.allComments(1);
    },
    methods: {
        login() {
            axios.post('/api/login', "email=" + this.email + "&password=" + this.password, { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
<<<<<<< Updated upstream
                .then(()=> swal({icon: "success"}))
                .then(this.email = "", this.password = "")
=======
                .then(() => {
                    location.reload();
                })
>>>>>>> Stashed changes
                .catch(() => swal('Email o contraseña incorrectos'))
        },

        //COMENTARIOS//
        postComment(){
            axios.post('/api/images/'+this.imageId+'/comments',
                "text="+this.commentText)
                .then(()=> swal("Comentario enviado exitosamente", {
                    icon: "success",
                  })
                .then(() => this.allComments(this.imageId))
                .then(this.commentText= ""))
                .catch(() => {swal('Necesitas estar logueado para poder comentar');
                 this.error = !this.error, this.commentText = ""});
        },

        editComment(){
            axios.post('/api/comments/'+this.commentId,
                "newText="+this.newText)
                .then(()=> swal("Comentario editado exitosamente", {
                    icon: "success",
                  })
                  .then(() => this.allComments(this.imageId))
                  .then(this.newText= ""))
                  .catch(() => {swal('Solo puedes editar tus propios comentarios')})
        },
        deleteComment(id){
            swal({
                title: "Estas segur@?",
                text: "Una vez eliminado el comentario no se podra recuperar",
                icon: "warning",
                buttons: true,
                dangerMode: true,
              })
                 .then((willDelete) => {
                if (willDelete) {axios.delete('/api/comments/'+id)
                .then(swal("Comentario eliminado exitosamente", {
                    icon: "success",
                  }))
                  .then(() => this.allComments(this.imageId))
                  .catch(() => {swal('Solo puedes eliminar tus propios comentarios')})
                } else {
                  swal("Comentario a salvo");
                }
              });
        },
        // PETICIONES 
        allImages(){
            axios.get('/api/images')
            .then(res => {
<<<<<<< Updated upstream
                this.images = res.data
                this.images.sort((a, b) => a.id - b.id)
            })
=======
                this.images = res.data,
                this.imageId= res.data.id})
>>>>>>> Stashed changes
        },

        allComments(id){
            axios.get('/api/images/'+id+'/comments')
            .then(res=> {
                this.comments = res.data
                this.comments.sort((a, b) => a.id - b.id)
                console.log(this.comments)
            })
        },
        // FUNCIONES EXTRA
        showText(info){
            this.newText = info.text
            this.commentId = info.id
        },

        formatDate: function(date){
            return new Date(date).toLocaleDateString('en-gb');
        },  
    }
});
