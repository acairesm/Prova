public class Main {
    public static void main(String[] args) {
        // valor, tipoOperacao, formaPagamento, cep
        System.out.println("[Brasil]");
        new Chekout(new BRFabrica(200.0, "Estadual", "Pix", "01310100")).resumo();

        // valor, estado, zip
        System.out.println("\n[EUA]");
        new Chekout(new EUAFabrica(200.0, "California", "902101234")).resumo();

        // valor, essencial, plz
        System.out.println("\n[Alemanha]");
        new Chekout(new ALMFabrica(200.0, true, "10115")).resumo();
    }
}
