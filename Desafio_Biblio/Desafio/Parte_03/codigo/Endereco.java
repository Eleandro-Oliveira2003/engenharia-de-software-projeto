import java.util.Objects;

/** Endereco de entrega associado ao usuario que solicita o emprestimo. */
public class Endereco {
    private final int numero;
    private final String rua;
    private final String cidade;

    public Endereco(int numero, String rua, String cidade) {
        if (numero < 0) {
            throw new IllegalArgumentException("O numero do endereco nao pode ser negativo.");
        }
        this.numero = numero;
        this.rua = Objects.requireNonNull(rua, "rua");
        this.cidade = Objects.requireNonNull(cidade, "cidade");
    }

    public int getNumero() { return numero; }
    public String getRua() { return rua; }
    public String getCidade() { return cidade; }
}
