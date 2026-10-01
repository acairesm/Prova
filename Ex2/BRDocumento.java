import java.util.Random;

public class BRDocumento implements Documento {

/*  o documento fiscal é uma nota fiscal eletrônica, com CFOP 5.102 para operações
dentro do estado e 6.102 para operações interestaduais, ICMS de 18% (ou 12% em operações
interestaduais) e chave de acesso simulada de 44 dígitos */
    double valor;
    String tipoOperacao;

    public BRDocumento(double valor, String tipoOperacao) {
        this.valor = valor;
        this.tipoOperacao = tipoOperacao;
    }

    @Override
    public void gerarDocumento() {
        if ("Estadual".equalsIgnoreCase(tipoOperacao)) {
            System.out.printf("Documento fiscal: NF-e | CFOP 5.102 | ICMS 18%% = R$ %.2f%n", valor * 0.18);
        } else if ("Interestadual".equalsIgnoreCase(tipoOperacao)) {
            System.out.printf("Documento fiscal: NF-e | CFOP 6.102 | ICMS 12%% = R$ %.2f%n", valor * 0.12);
        } else {
            System.out.println("Documento fiscal: Nota Fiscal Inválida");
            return;
        }
        System.out.println("Chave de acesso: " + gerarChaveAcesso());
    }

    private String gerarChaveAcesso() {
        Random random = new Random();
        StringBuilder chave = new StringBuilder();
        for (int i = 0; i < 44; i++) {
            chave.append(random.nextInt(10));
        }
        return chave.toString();
    }
}
