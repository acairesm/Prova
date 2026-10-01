public class Cliente {

public void contratar(ApoliceFabrica fabrica) {
    Apolice apolice = fabrica.criarApolice();
    apolice.CalculoDoPremio();
    apolice.ListagemDocumento();

    // resumo só para contratação bem-sucedida (RNF03)
    if (apolice.ValidacaoDeCobertura()) {
        apolice.GeracaoResumo();
    } else {
        System.out.println("Apólice não emitida.");
    }

    }

}
