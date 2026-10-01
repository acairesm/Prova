public interface PaisFabrica {
    public Documento gerarDocumentoFiscal();
    public Pagamento processarPagamento();
    public Etiqueta gerarEtiqueta();
}
