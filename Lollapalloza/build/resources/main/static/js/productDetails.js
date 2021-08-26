const app = Vue.createApp({
    data() {
      return {
        /* Navbar */ 
        activeNavbar: false,
        activeMenu: false,
        
        /* Products */
        selectedProduct: "",
        activeImg: 0,
        selectedSize: "",
        quantity: 0,
      };
    },
    created(){
        axios.get("/api/products")
        .then(res => {
          let params = new URLSearchParams(document.location.search.substring(1));
          let productId = params.get("productId")
          console.log(productId)
          this.selectedProduct = res.data.filter(p => p.id == productId)[0]
          console.log(this.selectedProduct)
        })
    },
    methods: {
      selectImg(i){
        this.activeImg = i;
      },
      selectSize(i){
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
    },
  
    computed: {},
  });
  