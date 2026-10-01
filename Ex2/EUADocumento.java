public class EUADocumento implements Documento {
    double valor;
    String estado;

    public EUADocumento(double valor, String estado) {
        this.valor = valor;
        this.estado = estado;
    }

    // sales tax pelo estado: California 7,25%, Texas 6,25%, Oregon isento
    @Override
    public void gerarDocumento() {
        double taxa;
        if ("California".equalsIgnoreCase(estado)) {
            taxa = 0.0725;
        } else if ("Texas".equalsIgnoreCase(estado)) {
            taxa = 0.0625;
        } else if ("Oregon".equalsIgnoreCase(estado)) {
            taxa = 0.0;
        } else {
            System.out.println("Documento fiscal: estado não atendido");
            return;
        }
        System.out.printf("Documento fiscal: Sales Invoice | EIN 12-3456789 | %s | Sales tax %.2f%% = US$ %.2f%n",
                estado, taxa * 100, valor * taxa);
    }
}
