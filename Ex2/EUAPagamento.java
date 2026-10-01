public class EUAPagamento implements Pagamento {
    double valor;
    String zip;

    public EUAPagamento(double valor, String zip) {
        this.valor = valor;
        this.zip = zip;
    }

    // cartão de crédito com verificação AVS (confere o endereço de cobrança pelo ZIP)
    @Override
    public void processarPagamento() {
        System.out.printf("Pagamento: Cartão de crédito | AVS aprovado (ZIP %s) | total US$ %.2f%n", zip, valor);
    }
}
