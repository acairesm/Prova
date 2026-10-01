public class Vida  extends Apolice {

    double premioMensal;
    double premioAnual;
    int idadeSegurador;
    double capitalSegurado;
    boolean seguradorFumante;
    boolean documentoIdentidade;
    boolean cpf;
    boolean atestadoMedico;

    public Vida(String segurado, double capitalSegurado, int idadeSegurador, boolean seguradorFumante,
         boolean documentoIdentidade, boolean cpf, boolean atestadoMedico) {
        super("VID", segurado);
        this.capitalSegurado = capitalSegurado;
        this.idadeSegurador = idadeSegurador;
        this.seguradorFumante = seguradorFumante;
        this.documentoIdentidade = documentoIdentidade;
        this.cpf = cpf;
        this.atestadoMedico = atestadoMedico;
    }

    @Override
    public void CalculoDoPremio() {
        premioMensal = (idadeSegurador * 12) + (capitalSegurado * 0.002);

        // fumante: acréscimo de 50% sobre o prêmio
        if (seguradorFumante == true) {
            premioMensal *= 1.50;
            System.out.println("Segurado fumante: acréscimo de 50% no prêmio.");
        }

        premioAnual = premioMensal * 12;
        premio = premioAnual;

        System.out.println("Prêmio mensal do seguro de vida: R$ " + premioMensal);
        System.out.println("Prêmio anual do seguro de vida: R$ " + premioAnual);
    }

    @Override
    public boolean ValidacaoDeCobertura() {
        if (capitalSegurado > 500_000 && !atestadoMedico) {
            System.out.println("Contratação rejeitada: capital acima de R$ 500.000,00 exige atestado médico.");
            return false;
        } else {
            System.out.println("Validação de cobertura aprovada.");
            return true;
        }
    }

    @Override
    public void ListagemDocumento() {
        if (capitalSegurado > 500_000) {
            documentosExigidos = "documento de identidade, CPF e atestado médico";
        } else {
            documentosExigidos = "documento de identidade e CPF";
        }
        System.out.println("Documentos exigidos: " + documentosExigidos);
        System.out.println("Documento de identidade: " + (documentoIdentidade == true ? "apresentado" : "não apresentado"));
        System.out.println("CPF: " + (cpf  ? "apresentado" : "não apresentado"));
        if (capitalSegurado > 500_000) {
            System.out.println("Atestado médico: " + (atestadoMedico ? "apresentado" : "não apresentado"));
        }

        if (documentacaoCompleta()) {
            System.out.println("Documentação completa.");
        } else {
            System.out.println("Documentação incompleta:");
            if (!documentoIdentidade) {
                System.out.println("- falta documento de identidade");
            }
            if (!cpf) {
                System.out.println("- falta CPF");
            }
            if (capitalSegurado > 500_000 && !atestadoMedico) {
                System.out.println("- falta atestado médico");
            }
        }
    }

    boolean documentacaoCompleta() {
        return documentoIdentidade && cpf && (capitalSegurado <= 500_000 || atestadoMedico);
    }

}
