import java.time.LocalDate;

public class MainTeste {
    public static void main(String[] args) {
        Endereco endereco = new Endereco(100, "Rua das Flores", "Porto Alegre");
        Livro livro = new Livro("Engenharia de Software", "Ian Sommerville");
        Exemplar exemplar = new Exemplar(1, new double[] {20.0, 15.0, 5.0}, 0.85, livro);
        Usuario usuario = new Usuario(1, "Eleandro Oliveira", endereco);
        Emprestimo emprestimo = new Emprestimo(
                LocalDate.now(), LocalDate.now().plusDays(14), exemplar, usuario, new FreteEmpresaA());

        imprimirFrete(emprestimo, "Empresa A", new FreteEmpresaA());
        imprimirFrete(emprestimo, "Empresa B", new FreteEmpresaB());
        imprimirFrete(emprestimo, "Empresa C", new FreteEmpresaC());
        imprimirFrete(emprestimo, "Empresa D", new FreteEmpresaD());
    }

    private static void imprimirFrete(Emprestimo emprestimo, String empresa, FreteStrategy strategy) {
        emprestimo.setFreteStrategy(strategy);
        System.out.printf("Valor do frete (%s): R$ %.2f%n", empresa, emprestimo.calcularFrete());
    }
}
