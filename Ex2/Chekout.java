public class Chekout {
    PaisFabrica fabrica;

    public Chekout(PaisFabrica fabrica) {
        this.fabrica = fabrica;
    }

    // não sabe qual é o país: os 3 artefatos vêm sempre da mesma fábrica
    public void resumo() {
        System.out.println("===== RESUMO DO PEDIDO =====");
        fabrica.gerarDocumentoFiscal().gerarDocumento();
        fabrica.processarPagamento().processarPagamento();
        fabrica.gerarEtiqueta().gerarEtiqueta();
    }
}
