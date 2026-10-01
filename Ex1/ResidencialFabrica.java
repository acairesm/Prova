public class ResidencialFabrica  extends ApoliceFabrica {
    @Override
    public Apolice criarApolice() {
        // segurado, valorImovel, altoPadrao, escritura, contratoLocacao, comprovanteResidencia
        return new Residencial("Maria Souza", 500000.00, true, true, false, true);
    }

}
