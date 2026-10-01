public class EUAFabrica implements PaisFabrica {
    double valor;
    String estado; // "California", "Texas" ou "Oregon"
    String zip;    // só números, ex: "902101234"

    public EUAFabrica(double valor, String estado, String zip) {
        this.valor = valor;
        this.estado = estado;
        this.zip = zip;
    }

    @Override
    public Documento gerarDocumentoFiscal() {
        return new EUADocumento(valor, estado);
    }

    @Override
    public Pagamento processarPagamento() {
        return new EUAPagamento(valor, zip);
    }

    @Override
    public Etiqueta gerarEtiqueta() {
        return new EUAEtiqueta(zip);
    }
}
