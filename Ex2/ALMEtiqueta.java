public class ALMEtiqueta implements Etiqueta {
    String plz;

    public ALMEtiqueta(String plz) {
        this.plz = plz;
    }

    // Deutsche Post, PLZ de 5 dígitos
    @Override
    public void gerarEtiqueta() {
        System.out.println("Etiqueta: Deutsche Post | PLZ " + plz);
    }
}
