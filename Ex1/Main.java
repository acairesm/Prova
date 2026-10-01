public class Main {
    

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
    
        
        
       System.out.println("\nContratando apólice de automóvel ...");
       cliente.contratar(new AutoFabrica(  ));

        System.out.println("\nContratando apólice residencial ...");
        cliente.contratar(new ResidencialFabrica());

        // segurado, capitalSegurado, idade, fumante, documentoIdentidade, cpf, atestadoMedico
        System.out.println("\nContratando apólice de vida 1 ...");
        cliente.contratar(new VidaFabrica("Ana Costa", 600000.0, 30, false, true, true, true));

        System.out.println("\nContratando apólice de vida 2 ...");
        cliente.contratar(new VidaFabrica("Pedro Alves", 700000.0, 45, true, true, true, false));
       
        System.out.println("\nContratando apolice de viagem");
        cliente.contratar(new ViagemFabrica());
    
    
       
       
       
       
    }
}
