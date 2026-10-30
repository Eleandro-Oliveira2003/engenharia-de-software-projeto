import java.util.Arrays;

public class Exemplar {
    private final int codigo;
    private final double[] dimensoes;
    private final double peso;
    private final Livro livro;

    public Exemplar(int codigo, double[] dimensoes, double peso, Livro livro) {
        if (dimensoes == null || dimensoes.length != 3) {
            throw new IllegalArgumentException("Informe comprimento, largura e altura.");
        }
        this.codigo = codigo;
        this.dimensoes = Arrays.copyOf(dimensoes, dimensoes.length);
        this.peso = peso;
        this.livro = livro;
    }

    public int getCodigo() { return codigo; }
    public double[] getDimensoes() { return Arrays.copyOf(dimensoes, dimensoes.length); }
    public double getPeso() { return peso; }
    public Livro getLivro() { return livro; }
}
