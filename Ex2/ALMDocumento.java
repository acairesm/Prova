public class ALMDocumento implements Documento {
    double valor;
    boolean essencial;

    public ALMDocumento(double valor, boolean essencial) {
        this.valor = valor;
        this.essencial = essencial;
    }

    // Umsatzsteuer: 19%, ou 7% para produtos essenciais
    @Override
    public void gerarDocumento() {
        double taxa;
        if (essencial) {
            taxa = 0.07;
        } else {
            taxa = 0.19;
        }
        System.out.printf("Documento fiscal: VAT Invoice | VAT-ID DE123456789 | Umsatzsteuer %.0f%% = € %.2f%n",
                taxa * 100, valor * taxa);
    }
}
