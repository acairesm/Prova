public class ViagemFabrica extends ApoliceFabrica {
    @Override
    public Apolice criarApolice() {
        // segurado, diasViagem, internacional, assistenciaMedica, passaporte, itinerario
        return new Viagem("Carlos Lima", 10, true, 30000.0, true, true);
    }

}
