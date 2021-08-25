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
      }
    },
  
    computed: {},
  });
  