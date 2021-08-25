const app = Vue.createApp({
  data() {
    return {
      invoice: [],
      clientName: "",
      details: [],
      params: {},
      date: "",
      totalfact: [],

    };
  },
  created() {
    const urlSearchParams = new URLSearchParams(window.location.search);
    this.params = Object.fromEntries(urlSearchParams.entries());
    console.log( this.params);


    axios
      .get("/api/users/current")
      .then((response) => {
        this.totalfact = response.data.invoices;
        console.log(this.totalfact.length);

        for (i = 0; i < this.totalfact.length ; i++) {
          this.invoice = response.data.invoices[i];
          this.clientName = this.invoice.businessName;
          this.openPdf();
        }
       

      

      })
      .catch((error) => console.log(error.response));



  },
  methods: {


    dateAndTime(creationdate) {
      let date = new Date(creationdate);
      return date.toLocaleString();
    },
    formatDate(str) {
      return new Date(str + " ").toLocaleDateString();
    },
    formatARS(balance) {
      if (balance == null) {
        return "";
      }
      let amount = new Intl.NumberFormat("es-AR", {
        style: "currency",
        currency: "ARS",
      });
      return amount.format(balance);
    },
    openPdf() {
      var dd = {
        header: {
          text: ' Lollapalloza Argentina S.A. Argentina',
          image: 'logo_block.jpg',
          margin: 30,
        },
        footer: {
          columns: [
            {
              qr: '30-70963344-5' , foreground: 'red', background: 'yellow',
              alignment:"left",
              margin:30,
            },
            {
              text: "impreso el " + new Date().toLocaleDateString(),
              alignment: "right",
              margin: 30,
            },
          ],
        },
        content: [
          {
            layout: "lightHorizontalLines", // optional
            margin: [0, 20],
            table: {
              headerRows: 1,
              widths: ["auto", "auto", "*", "auto", "auto"],

              body: [
                [
                  "Cantidad",
                  "Descripción",
                  "Precio Unitario",
                  "Descuento",
                  "Subtotal",
                ],
              ],
            },
          },
        ],
        pageSize: "A4",
        pageMargins: [40, 60, 40, 60],
      };



      this.invoice.details.forEach((h) => {
        let aux = [];

        aux.push(h.quantity);
        aux.push(h.description);

        aux.push(h.priceUnitary);
        aux.push({ text: h.discount, bold: true });
        aux.push(this.formatARS(h.subtotal));
        dd.content[0].table.body.push(aux);


      });

      dd.content.unshift({


        text:
          "creada el dia : " +
          new Date(this.invoice.date).toLocaleDateString(),
        bold: true,
      });
      dd.content.unshift("Razon Social : " + this.invoice.businessName);
      dd.content.unshift("Factura Número : " + this.invoice.invoiceNumber);
      dd.content.unshift("Descuento " + this.formatARS(this.invoice.discount));
      dd.content.unshift("Total " + this.formatARS(this.invoice.total));


      pdfMake.createPdf(dd).open();
    },
  },
  computed: {
    hasTransactions() {
      return this.details.length > 0;
    },
  },
}).mount("#app");
