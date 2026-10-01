public class ALMFabrica implements PaisFabrica {
    double valor;
    boolean essencial; // produto essencial paga 7% de imposto
    String plz;        // 5 dígitos, ex: "10115"

    public ALMFabrica(double valor, boolean essencial, String plz) {
        this.valor = valor;
        this.essencial = essencial;
        this.plz = plz;
    }

    @Override
    public Documento gerarDocumentoFiscal() {
        return new ALMDocumento(valor, essencial);
    }

    @Override
    public Pagamento processarPagamento() {
        return new ALMPagamento(valor);
    }

    @Override
    public Etiqueta gerarEtiqueta() {
        return new ALMEtiqueta(plz);
    }
}
