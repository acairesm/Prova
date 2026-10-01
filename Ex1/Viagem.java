public class Viagem extends Apolice {

    int diasViagem;
    boolean internacional;
    double assistenciaMedica;
    boolean passaporte;
    boolean itinerario;

    public Viagem(String segurado, int diasViagem, boolean internacional, double assistenciaMedica, boolean passaporte, boolean itinerario) {
        super("VIA", segurado);
        this.diasViagem = diasViagem;
        this.internacional = internacional;
        this.assistenciaMedica = assistenciaMedica;
        this.passaporte = passaporte;
        this.itinerario = itinerario;
    }

    @Override
    public void CalculoDoPremio() {
        // R$ 15,00 por dia de viagem
        premio = diasViagem * 15.0;

        // internacional: mais R$ 100,00
        if (internacional) {
            premio += 100.0;
            System.out.println("Viagem internacional: acréscimo de R$ 100,00.");
        }

        System.out.println("Prêmio do seguro de viagem: R$ " + premio);
    }

    @Override
    public boolean ValidacaoDeCobertura() {
        // internacional exige assistência médica de no mínimo US$ 30.000,00 e passaporte
        if (internacional && assistenciaMedica < 30000) {
            System.out.println("Contratação rejeitada: viagem internacional exige assistência médica de no mínimo US$ 30.000,00.");
            return false;
        } else if (internacional && !passaporte) {
            System.out.println("Contratação rejeitada: viagem internacional exige passaporte.");
            return false;
        } else {
            System.out.println("Validação de cobertura aprovada.");
            return true;
        }
    }

    @Override
    public void ListagemDocumento() {
        if (internacional) {
            documentosExigidos = "itinerário de viagem e passaporte";
        } else {
            documentosExigidos = "itinerário de viagem";
        }
        System.out.println("Documentos exigidos: " + documentosExigidos);

        if (itinerario && (!internacional || passaporte)) {
            System.out.println("Documentação completa.");
        } else {
            System.out.println("Documentação incompleta:");
            if (!itinerario) {
                System.out.println("- falta itinerário de viagem");
            }
            if (internacional && !passaporte) {
                System.out.println("- falta passaporte");
            }
        }
    }

}
