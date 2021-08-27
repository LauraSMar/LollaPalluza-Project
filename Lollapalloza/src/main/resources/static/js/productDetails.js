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

      /* Cart */
      cart: {
        cartdtos: [],
        ticketDtos: [],
      },
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
      })
    if (JSON.parse(sessionStorage.getItem("cart"))) {
      this.cart = JSON.parse(sessionStorage.getItem("cart"))
    } else {
      sessionStorage.setItem("cart", JSON.stringify(this.cart))
    }

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
    }
  },

  computed: {},
});
