import java.util.Objects;

/** Usuario que seleciona a forma de entrega do emprestimo. */
public class Usuario {
    private final int codigo;
    private final String nome;
    private final Endereco endereco;

    public Usuario(int codigo, String nome, Endereco endereco) {
        if (codigo < 0) {
            throw new IllegalArgumentException("O codigo do usuario nao pode ser negativo.");
        }
        this.codigo = codigo;
        this.nome = Objects.requireNonNull(nome, "nome");
        this.endereco = Objects.requireNonNull(endereco, "endereco");
    }

    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public Endereco getEndereco() { return endereco; }
}
