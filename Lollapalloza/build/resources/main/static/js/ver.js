const app = Vue.createApp({
  data() {
    return {
      details: [],
      date: "",
      invoices: [],
    };
  },
  created() {
    axios
      .get("/api/users/current")
      .then((response) => {
        this.invoices = response.data.invoices;
      })
      .catch((error) => console.log(error.response));
  },
  methods: {
    downloadAll() {
      this.invoices.forEach((invoice) => {
        this.showPdf(invoice);
      });
    },
    async showPdf(invoice) {
      let dd = {
        header: {
          text: " Lollapalloza Argentina S.A. Argentina",
          margin: 30,
        },
        footer: {
          columns: [
            {
              qr: "30-70963344-5",
              foreground: "red",
              background: "yellow",
              alignment: "left",
              margin: 30,
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
            columns: [
              {
                image: await this.getBase64ImageFromURL(
                  "http://localhost:8080/img/logo_block.png"
                ),
                fit: [100, 100],
                alignment: "right",
              },
            ],
          },
          {
            layout: "lightHorizontalLines",
            margin: [0, 30],
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

      invoice.details.forEach((h) => {
        let aux = [];
        aux.push(h.quantity);
        aux.push(h.description);
        aux.push(h.priceUnitary);
        aux.push({ text: h.discount, bold: true });
        aux.push(this.formatARS(h.subtotal));
        dd.content[1].table.body.push(aux);
      });

      // parte del subtotal y total en la tabla

      dd.content[1].table.body.push([
        {
          colSpan: 3,
          fillColor: "#d6f8f2",
          text: "Descuento total",
          bold: true,
        },
        "",
        "",
        {
          text: this.formatARS(invoice.discount),
          fillColor: "#d6f8f2",
          bold: true,
        },
        { text: "", fillColor: "#d6f8f2" },
      ]);
      dd.content[1].table.body.push([
        { colSpan: 3, fillColor: "#d6f8f2", text: "Total", bold: true },
        "",
        "",
        { text: "", fillColor: "#d6f8f2" },
        {
          text: this.formatARS(invoice.total),
          fillColor: "#d6f8f2",
          bold: true,
        },
      ]);

      // info en la parte superior de la factura
      let table1 = {
        style: "tableExample",
        table: {
          body: [],
        },
        alignment: "left",
        layout: "noBorders",
      };

      table1.table.body.push(["Factura Número ", invoice.invoiceNumber]);
      table1.table.body.push(["Razon Social ", invoice.businessName]);

      table1.table.body.push([
        "creada el dia ",
        new Date(invoice.date).toLocaleDateString(),
      ]);

      table1.table.body.push(["Descuento ", this.formatARS(invoice.discount)]);
      table1.table.body.push(["Total ", this.formatARS(invoice.total)]);

      dd.content[0].columns.unshift(table1);

      // se crea el pdf y se abre en una nueva pestaña
      pdfMake.createPdf(dd).open();
    },

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
    getBase64ImageFromURL(url) {
      return new Promise((resolve, reject) => {
        var img = new Image();
        img.setAttribute("crossOrigin", "anonymous");
        img.onload = () => {
          var canvas = document.createElement("canvas");
          canvas.width = img.width;
          canvas.height = img.height;
          var ctx = canvas.getContext("2d");
          ctx.drawImage(img, 0, 0);
          var dataURL = canvas.toDataURL("image/png");
          resolve(dataURL);
        };
        img.onerror = (error) => {
          reject(error);
        };
        img.src = url;
      });
    },
  },
}).mount("#app");
