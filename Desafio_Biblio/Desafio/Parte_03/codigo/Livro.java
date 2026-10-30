import java.util.Objects;

/** Dados bibliograficos do titulo ao qual o exemplar pertence. */
public class Livro {
    private final String titulo;
    private final String autor;

    public Livro(String titulo, String autor) {
        this.titulo = Objects.requireNonNull(titulo, "titulo");
        this.autor = Objects.requireNonNull(autor, "autor");
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
}
