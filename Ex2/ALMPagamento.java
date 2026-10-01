public class ALMPagamento implements Pagamento {
    double valor;

    public ALMPagamento(double valor) {
        this.valor = valor;
    }

    @Override
    public void processarPagamento() {
        System.out.printf("Pagamento: SEPA Direct Debit | total € %.2f%n", valor);
    }
}
