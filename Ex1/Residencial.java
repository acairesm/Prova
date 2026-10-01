public class Residencial extends Apolice {

    double premioMensal;
    double premioAnual;
    double valorImovel;
    boolean altoPadrao;
    boolean escritura;
    boolean contratoLocacao;
    boolean comprovanteResidencia;

    public Residencial(String segurado, double valorImovel, boolean altoPadrao, boolean escritura, boolean contratoLocacao, boolean comprovanteResidencia) {
        super("RES", segurado);
        this.valorImovel = valorImovel;
        this.altoPadrao = altoPadrao;
        this.escritura = escritura;
        this.contratoLocacao = contratoLocacao;
        this.comprovanteResidencia = comprovanteResidencia;
    }


    @Override
    public void CalculoDoPremio() {
        // 1,5% do valor do imóvel ao ano
        premioAnual = valorImovel * 0.015;

        // alto padrão: acréscimo de 25% sobre o prêmio anual
        if (altoPadrao == true) {
            premioAnual += premioAnual * 0.25;
            System.out.println("Imóvel de alto padrão: acréscimo de 25% no prêmio anual.");
        }

        premioMensal = premioAnual / 12;
        premio = premioAnual;

        System.out.println("Prêmio mensal do seguro residencial: R$ " + premioMensal);
        System.out.println("Prêmio anual do seguro residencial: R$ " + premioAnual);
    }

    @Override
    public boolean ValidacaoDeCobertura() {
        // exige escritura OU contrato de locação
        if (escritura == true|| contratoLocacao == true) {
            System.out.println("Validação de cobertura aprovada.");
            return true;
        } else {
            System.out.println("Contratação rejeitada: é necessário apresentar escritura ou contrato de locação.");
            return false;
        }
    }

    @Override
    public void ListagemDocumento() {
        documentosExigidos = "escritura ou contrato de locação e comprovante de residência";
        System.out.println("Documentos exigidos: " + documentosExigidos);
        System.out.println("Escritura: " + (escritura ? "apresentada" : "não apresentada"));
        System.out.println("Contrato de locação: " + (contratoLocacao ? "apresentado" : "não apresentado"));
        System.out.println("Comprovante de residência: " + (comprovanteResidencia ? "apresentado" : "não apresentado"));

        if ((escritura == true || contratoLocacao == true) && comprovanteResidencia == true) {
            System.out.println("Documentação completa.");
        } else {
            System.out.println("Documentação incompleta:");
            if (!escritura && !contratoLocacao) {
                System.out.println("- falta escritura ou contrato de locação");
            }
            if (!comprovanteResidencia) {
                System.out.println("- falta comprovante de residência");
            }
        }
    }

}
