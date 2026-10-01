public class BREtiqueta implements Etiqueta {
    String cep;

    public BREtiqueta(String cep) {
        this.cep = cep;
    }

    // Correios, CEP no formato 00000-000
    @Override
    public void gerarEtiqueta() {
        System.out.println("Etiqueta: Correios | CEP " + cep.substring(0, 5) + "-" + cep.substring(5));
    }
}
