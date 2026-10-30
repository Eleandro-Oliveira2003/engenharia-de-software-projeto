public class Usuario {
    private final int codigo;
    private final String nome;
    private final Endereco endereco;

    public Usuario(int codigo, String nome, Endereco endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
    }

    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public Endereco getEndereco() { return endereco; }
}
