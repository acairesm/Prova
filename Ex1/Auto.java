public class Auto extends Apolice {

    double premioMensal;
    double premioAnual;
    double valorTabelaFipe;
    int idadeCondutor;
    int tempoHabilitacao;
    double coberturaTerceiros;
    boolean cnh;
    boolean crlv;
    boolean comprovanteResidencia;

    public Auto(String segurado, double valorTabelaFipe, int idadeCondutor, int tempoHabilitacao, double coberturaTerceiros,
            boolean cnh, boolean crlv, boolean comprovanteResidencia) {
        super("AUTO", segurado);
        this.valorTabelaFipe = valorTabelaFipe;
        this.idadeCondutor = idadeCondutor;
        this.tempoHabilitacao = tempoHabilitacao;
        this.coberturaTerceiros = coberturaTerceiros;
        this.cnh = cnh;
        this.crlv = crlv;
        this.comprovanteResidencia = comprovanteResidencia;
    }

    @Override
    public void CalculoDoPremio() {
        // 8% da FIPE ao ano
        premioAnual = valorTabelaFipe * 0.08;

        // menos de 25 anos: acréscimo de 30% no prêmio anual
        if (idadeCondutor < 25) {
            premioAnual *= 1.30;
            System.out.println("Condutor com menos de 25 anos: acréscimo de 30%.");
        }

        // menos de 2 anos de habilitação: acréscimo adicional de 20%
        if (tempoHabilitacao < 2) {
            premioAnual *= 1.20;
            System.out.println("Habilitação com menos de 2 anos: acréscimo de 20%.");
        }

        premioMensal = premioAnual / 12;
        premio = premioAnual;

        System.out.println("Prêmio mensal do seguro de automóvel: R$ " + premioMensal);
        System.out.println("Prêmio anual do seguro de automóvel: R$ " + premioAnual);
    }

    @Override
    public boolean ValidacaoDeCobertura() {
        // cobertura contra terceiros de no mínimo R$ 50.000,00
        if (coberturaTerceiros >= 50000) {
            System.out.println("Validação de cobertura aprovada.");
            return true;
        } else {
            System.out.println("Contratação rejeitada: cobertura contra terceiros deve ser de no mínimo R$ 50.000,00.");
            return false;
        }
    }

    @Override
    public void ListagemDocumento() {
        documentosExigidos = "CNH, CRLV e comprovante de residência";
        System.out.println("Documentos exigidos: " + documentosExigidos);

        if (cnh && crlv && comprovanteResidencia) {
            System.out.println("Documentação completa.");
        } else {
            System.out.println("Documentação incompleta:");
            if (!cnh) {
                System.out.println("- falta CNH");
            }
            if (!crlv) {
                System.out.println("- falta CRLV");
            }
            if (!comprovanteResidencia) {
                System.out.println("- falta comprovante de residência");
            }
        }
    }

}
