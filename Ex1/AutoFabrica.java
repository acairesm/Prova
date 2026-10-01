public class AutoFabrica  extends ApoliceFabrica {
    @Override
    public Apolice criarApolice(  ) {
        // segurado, valorTabelaFipe, idadeCondutor, tempoHabilitacao, coberturaTerceiros, cnh, crlv, comprovanteResidencia
        return new Auto("João Silva", 80000.0, 22, 1, 50000.0, true, true, true);
    }

}
