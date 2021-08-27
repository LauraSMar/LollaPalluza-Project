const app = Vue.createApp({
  data() {
    return {
      /* Navbar */
      activeNavbar: false,
      activeMenu: false,

      toastCount: 0,

      /* Products */
      selectedProduct: "",
      activeImg: 0,
      selectedSize: "",
      quantity: 1,
      ticketPrice: 3000,
      products: [],
      check: [],

      /* Cart */
      cart: {
        cartdtos: [],
        ticketDtos: [],
      },

      /*user*/
      userEmail: "",
    };
  },
  created() {
    axios.get("/api/products")
      .then(res => {
        let params = new URLSearchParams(document.location.search.substring(1));
        let productId = params.get("productId")
        console.log(productId)
        this.selectedProduct = res.data.filter(p => p.id == productId)[0]
        console.log(this.selectedProduct)
        this.products = res.data
      })
    if (JSON.parse(sessionStorage.getItem("cart"))) {
      this.cart = JSON.parse(sessionStorage.getItem("cart"))
    } else {
      sessionStorage.setItem("cart", JSON.stringify(this.cart))
    }
    this.user();
  },


  methods: {
    selectImg(i) {
      this.activeImg = i;
    },
    selectSize(i) {
      this.selectedSize = i;
    },
    formatBalance(balance) {
      if (balance == null) {
        return
      }
      let amount = new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'USD',
      })
      return amount.format(balance)
    },

    addToCart() {
      let productToCart = {
        "idItem": this.selectedProduct.id,
        "category": this.selectedProduct.category,
        "quantity": this.quantity
      }
      if (this.cart.cartdtos.length == 0) {
        this.cart.cartdtos.push(productToCart)
        sessionStorage.setItem("cart", JSON.stringify(this.cart))
        return
      }
      let arrayAux = this.cart.cartdtos.map(e => e.idItem)
      if (arrayAux.indexOf(productToCart.idItem) == -1) {
        console.log(arrayAux)
        this.cart.cartdtos.push(productToCart)
      }
      if (arrayAux.indexOf(productToCart.idItem) > -1) {
        this.cart.cartdtos.map((e) => {
          if (e.idItem == productToCart.idItem) {
            e.quantity += productToCart.quantity
          }
        })
      }

      sessionStorage.setItem("cart", JSON.stringify(this.cart))
      console.log(this.cart.cartdtos)
    },

    deleteTicket(index) {
      this.cart.ticketDtos.splice(index, 1)
      sessionStorage.setItem("cart", JSON.stringify(this.cart))
    },
    deleteProduct(index) {
      this.cart.cartdtos.splice(index, 1)
      sessionStorage.setItem("cart", JSON.stringify(this.cart))
    },

    formatBalance(balance) {
      if (balance == null) {
        return
      }
      let amount = new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'USD',
      })
      return amount.format(balance)
    },
    getImg(id) {
      if (this.products.length == 0) {
        return
      }
      return this.products.filter(e => e.id == id)[0].img[0]
    },
    getName(id) {
      if (this.products.length == 0) {
        return
      }
      return this.products.filter(e => e.id == id)[0].description
    },
    getPrice(id) {
      if (this.products.length == 0) {
        return
      }
      return this.products.filter(e => e.id == id)[0].price
    },
    user() {
      axios.get('/api/users/current')
        .then(res => {
          this.userEmail = res.data.email
          console.log(this.userEmail)
        })
    },
    goToPay() {
      if (this.userEmail != "") {
        window.location.href = "/payCard.html"
      } else (swal('Necesitas estar logueado para poder comprar', { icon: "warning" })
        .then(() => window.location.href = "/login.html"))
    },

  },

  computed: {
    calculatePrice() {
      let price = 0
      if (this.cart.ticketDtos.length == 2) {
        price = this.ticketPrice - (this.ticketPrice * 0.10)
      } else if (this.cart.ticketDtos.length > 2) {
        price = this.ticketPrice - (this.ticketPrice * 0.20)
      }
      return price
    },
    totalCart() {
      let prodCounter = 0
      let tktCounter = this.cart.ticketDtos.length
      if (!this.cart.cartdtos && !this.cart.ticketDtos) {
        return
      }

      this.cart.cartdtos.map(e => prodCounter += e.quantity)
      return prodCounter + tktCounter
    },
    totalPrice() {

      if (this.products.length == 0) {
        return
      }
      let price = 0
      if (this.cart.ticketDtos.length == 2) {
        price = this.ticketPrice - (this.ticketPrice * 0.10)
      } else if (this.cart.ticketDtos.length > 2) {
        price = this.ticketPrice - (this.ticketPrice * 0.20)
      }

      let ids = this.cart.cartdtos.map(e => e.idItem)

      let counter = 0
      let total = 0

      for (let i = 0; i < ids.length; i++) {
        counter = this.products.filter(e => e.id == ids[i])[0].price * this.cart.cartdtos[i].quantity
        total += counter
      }

      let tktCounter = this.cart.ticketDtos.length * price
      return total + tktCounter
    },

  },
}).mount("#app")
