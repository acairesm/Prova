public class BRPagamento implements Pagamento {
    double valor;
    String formaPagamento;

    public BRPagamento(double valor, String formaPagamento) {
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    @Override
    public void processarPagamento() {
        if ("Pix".equalsIgnoreCase(formaPagamento)) {
            System.out.printf("Pagamento: Pix com 5%% de desconto | total R$ %.2f%n", valor * 0.95);
        } else if ("Boleto".equalsIgnoreCase(formaPagamento)) {
            System.out.printf("Pagamento: Boleto | total R$ %.2f | compensação em 3 dias úteis%n", valor);
        } else {
            System.out.println("Pagamento: forma de pagamento inválida");
        }
    }
}
