import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Apolice {

    // contador compartilhado por todas as apólices: garante número único (RNF02)
    private static int contador = 0;

    protected String prefixo;
    protected String numero;
    protected String segurado;
    protected LocalDate dataEmissao;
    protected double premio;
    protected String documentosExigidos;

    // cada tipo passa seu prefixo: AUTO, RES, VID, VIA
    public Apolice(String prefixo, String segurado) {
        this.prefixo = prefixo;
        this.segurado = segurado;
    }

    public abstract void CalculoDoPremio();
    public abstract boolean ValidacaoDeCobertura();
    public abstract void ListagemDocumento();

    // resumo padronizado, igual para todos os tipos (RNF03)
    public void GeracaoResumo() {
        // número e data só são gerados quando a apólice é emitida
        contador++;
        numero = prefixo + "-" + String.format("%04d", contador);
        dataEmissao = LocalDate.now();

        System.out.println("===== RESUMO DA APÓLICE =====");
        System.out.println("Número: " + numero);
        System.out.println("Segurado: " + segurado);
        System.out.println("Data de emissão: " + dataEmissao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Prêmio: R$ " + String.format("%.2f", premio));
        System.out.println("Documentos exigidos: " + documentosExigidos);
    }

}
