public class BRFabrica implements PaisFabrica {
    double valor;
    String tipoOperacao;   // "Estadual" ou "Interestadual"
    String formaPagamento; // "Pix" ou "Boleto"
    String cep;            // só números, ex: "01310100"

    public BRFabrica(double valor, String tipoOperacao, String formaPagamento, String cep) {
        this.valor = valor;
        this.tipoOperacao = tipoOperacao;
        this.formaPagamento = formaPagamento;
        this.cep = cep;
    }

    @Override
    public Documento gerarDocumentoFiscal() {
        return new BRDocumento(valor, tipoOperacao);
    }

    @Override
    public Pagamento processarPagamento() {
        return new BRPagamento(valor, formaPagamento);
    }

    @Override
    public Etiqueta gerarEtiqueta() {
        return new BREtiqueta(cep);
    }
}
