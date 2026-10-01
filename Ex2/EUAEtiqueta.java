public class EUAEtiqueta implements Etiqueta {
    String zip;

    public EUAEtiqueta(String zip) {
        this.zip = zip;
    }

    // USPS, formato ZIP+4: 00000-0000
    @Override
    public void gerarEtiqueta() {
        System.out.println("Etiqueta: USPS | ZIP+4 " + zip.substring(0, 5) + "-" + zip.substring(5));
    }
}
