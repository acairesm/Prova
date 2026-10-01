public class VidaFabrica extends ApoliceFabrica {
    String segurado;
    double capitalSegurado;
    int idade;
    boolean fumante;
    boolean documentoIdentidade;
    boolean cpf;
    boolean atestadoMedico;

    public VidaFabrica(String segurado, double capitalSegurado, int idade, boolean fumante,
            boolean documentoIdentidade, boolean cpf, boolean atestadoMedico) {
        this.segurado = segurado;
        this.capitalSegurado = capitalSegurado;
        this.idade = idade;
        this.fumante = fumante;
        this.documentoIdentidade = documentoIdentidade;
        this.cpf = cpf;
        this.atestadoMedico = atestadoMedico;
    }

    @Override
    public Apolice criarApolice() {
        return new Vida(segurado, capitalSegurado, idade, fumante, documentoIdentidade, cpf, atestadoMedico);
    }

}
