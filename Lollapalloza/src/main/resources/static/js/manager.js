const app = Vue.createApp({
  data() {
    return {
      products: [],
      description: "",
      stock: "",
      price: "",
      img1: "",
      img2: "",
      img3: "",
      img: [],
      sizeList: [],
      SizeNames: [],
      unico: false,
      idProd: "",
      found: [],
      myprod: [],
      error: [],
      ok: true,
      emailF: [],
      email: "",
      users: [],
      emailnF: "",
      idUser: "",

      events: [],
      selectedEvent: {},
    };
  },
  created() {
    //axios.get("api/products")
    axios.get("http://localhost:8080/api/products").then((res) => {
      this.products = res.data;
      // console.log(this.products)
    });

    axios.get("http://localhost:8080/api/users").then((res) => {
      this.users = res.data;
      console.log(this.users);
    });
    this.getEvents();
  },
  methods: {
    add() {
      let aux = [];
      aux.push(this.img1);
      aux.push(this.img2);
      aux.push(this.img3);
      this.img = aux;

      console.log(this.img);

      if (!this.UNICO) {
        this.sizeList = this.SizeNames;
      } else {
        this.sizeList = ["UNICO"];
      }

      console.log(this.sizeList);

      axios
        .post("api/products", {
          category: "PRO",
          description: this.description,
          stock: this.stock,
          price: this.price,
          img: this.img,
          sizeList: this.sizeList,
        })

        .then((response) => {
          console.log(response.data);
          Swal.fire({
            position: "center",
            icon: "success",
            title: "Productos Creado!",
            showConfirmButton: false,
            timer: 1500,
          });

          location.reload();
        })
        .catch((err) => {
          console.log(err);
        });
    },

    erase(idproduct) {
      console.log(idproduct);
      axios
        .post("/api/products/erase", "id=" + idproduct)
        .then((response) => {
          console.log(response.data);

          Swal.fire({
            position: "center",
            icon: "success",
            title: "Productos Eliminado!",
            showConfirmButton: false,
            timer: 1500,
          });

          location.reload();
        })
        .catch((err) => {
          console.log(err);
        });
    },

    searchProduct(id) {
      this.found = this.products.filter((e) => e.id === id);
      if (this.found != "") {
        this.ok = false;

        return this.found;
      }
      this.ok = true;
      return (this.found = "No existe el producto");
    },

    searchEmail(email) {
      console.log(this.email);

      this.emailF = this.users.filter((e) => e.email === email);

      if (this.emailF != "") {
        this.idUser = this.emailF.id;
        return this.emailF;
      }
      this.emailnF = "No existe!";
      document.getElementById("email").getfocus();
      return;
    },

    editarProd(idProd) {
      console.log(idProd);

      if (idProd != 0 || idProd != "") {
        let myprod = this.products.filter((e) => e.id === idProd);
        console.log(myprod[0]);

        this.description = myprod[0].description;
        this.price = myprod[0].price;
        this.stock = myprod[0].stock;
        this.img1 = "";
        this.img2 = "";
        this.img3 = "";

        console.log(this.error);

        if (this.error.length == 0) {
          axios
            .post("api/products/updates", {
              category: "PRO",
              description: this.description,
              stock: this.stock,
              price: this.price,
              img: this.img,
              sizeList: this.sizeList,
            })
            .then((response) => {
              console.log(response.data);
              this.ok = true;

              Swal.fire({
                position: "center",
                icon: "success",
                title: "Producto Actualizado!",
                showConfirmButton: false,
                timer: 1500,
              });
            })
            .catch((err) => {
              console.log(err);
            });
        }
      }

      console.log("Editar Ahora!");
    },

    chequearItems() {
      this.error = [];
      if (this.img1 == "") {
        alert("El producto necesita mínimo tres imágenes");
        this.error.push("Complete img1");

        document.getElementById("img1").focus();
      }

      if (this.img2 == "") {
        alert("El producto necesita mínimo tres imágenes");
        this.error.push("Complete img2");
        document.getElementById("img2").focus();
      }
      if (this.img3 == "") {
        alert("El producto necesita mínimo tres imágenes");
        this.error.push("Complete img3");
        document.getElementById("img3").focus();
      }

      if (this.SizeNames == "") {
        alert("Elija un Tipo de Talle");
        this.error.push("Talle es obligatorio");
        this.SizeNames.value = "UNICO";
        document.getElementById("UNICO").focus();
      }
    },

    LimpiarForm() {
      this.emailF = [];
      location.reload();
    },

    Eliminar(idUser) {
      Swal.fire({
        title: "Seguro?",
        text: "Vas a borrar a " + this.emailF.email + "ahora! ",
        icon: "info",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Si, Chau!",
      }).then((result) => {
        if (result.isConfirmed) {
          if (this.emailF != "") {
            axios
              .post("/api/users/erase", "id=" + this.idUser)
              .then((res) => {
                console.log("Borrando...");

                Swal.fire("Usuario borrado!.", "success");
                location.reload();
              })

              .catch((error) => {
                console.log(error);
                Swal.fire({
                  icon: "error",
                  title: "Oops...",
                  text: "Algo salió mal",
                });
              });
          }
        }
      });
    },

    // metodos para los eventos
    getEvents(){
        axios.get("/api/events")
        .then(response=>{
            this.events = response.data;
            console.log(this.events)
        })
        .catch(error => console.log(error.response))
    },
    updateEvent(){
        axios.post("/api/events/update?"+
        "idEvent="+ this.selectedEvent.id +
        "&date="+ this.selectedEvent.date +
        "&start=" + this.selectedEvent.start +
        "&end=" + this.selectedEvent.end
    ).then(response=>{
        console.log(response);
        this.getEvents();
    })
    .catch(error => console.log(error.response))
    },
    dateFormat(str){
        return date = new Date(str+"T00:00:00").toLocaleDateString();
    },
    editar(event){
        this.selectedEvent = {...event};
        console.log(this.selectedEvent)
    }
  },
});

app.mount("#app");
