import java.util.Arrays;
import java.util.Objects;

/** Exemplar fisico: seus dados de dimensoes e peso alimentam a cotacao do frete. */
public class Exemplar {
    private final int codigo;
    private final double[] dimensoes;
    private final double peso;
    private final Livro livro;

    /** @param dimensoes comprimento, largura e altura, em centimetros */
    public Exemplar(int codigo, double[] dimensoes, double peso, Livro livro) {
        if (codigo < 0) {
            throw new IllegalArgumentException("O codigo do exemplar nao pode ser negativo.");
        }
        if (dimensoes == null || dimensoes.length != 3) {
            throw new IllegalArgumentException("Informe comprimento, largura e altura do exemplar.");
        }
        for (double dimensao : dimensoes) {
            if (!Double.isFinite(dimensao) || dimensao <= 0) {
                throw new IllegalArgumentException("As dimensoes devem ser valores positivos e finitos.");
            }
        }
        if (!Double.isFinite(peso) || peso <= 0) {
            throw new IllegalArgumentException("O peso deve ser um valor positivo e finito.");
        }
        this.codigo = codigo;
        this.dimensoes = Arrays.copyOf(dimensoes, dimensoes.length);
        this.peso = peso;
        this.livro = Objects.requireNonNull(livro, "livro");
    }

    public int getCodigo() { return codigo; }
    public double[] getDimensoes() { return Arrays.copyOf(dimensoes, dimensoes.length); }
    public double getPeso() { return peso; }
    public Livro getLivro() { return livro; }
}
