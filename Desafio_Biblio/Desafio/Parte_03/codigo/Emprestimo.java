import java.time.LocalDate;
import java.util.Objects;

public class Emprestimo {
    private final LocalDate dataRetirada;
    private final LocalDate dataEntregaPrevista;
    private LocalDate dataEntregaRealizada;
    private FreteStrategy freteStrategy;
    private final Exemplar exemplar;
    private final Usuario usuario;

    public Emprestimo(LocalDate dataRetirada, LocalDate dataEntregaPrevista,
                      Exemplar exemplar, Usuario usuario, FreteStrategy freteStrategy) {
        this.dataRetirada = Objects.requireNonNull(dataRetirada, "dataRetirada");
        this.dataEntregaPrevista = Objects.requireNonNull(dataEntregaPrevista, "dataEntregaPrevista");
        this.exemplar = Objects.requireNonNull(exemplar, "exemplar");
        this.usuario = Objects.requireNonNull(usuario, "usuario");
        this.freteStrategy = freteStrategy;
    }

    public void setFreteStrategy(FreteStrategy freteStrategy) {
        this.freteStrategy = Objects.requireNonNull(freteStrategy, "freteStrategy");
    }

    public double calcularFrete() {
        if (freteStrategy == null) {
            throw new IllegalStateException("Estrategia de frete nao definida.");
        }
        return freteStrategy.calcularFrete(usuario.getEndereco(), exemplar.getDimensoes(), exemplar.getPeso());
    }

    public LocalDate getDataRetirada() { return dataRetirada; }
    public LocalDate getDataEntregaPrevista() { return dataEntregaPrevista; }
    public LocalDate getDataEntregaRealizada() { return dataEntregaRealizada; }
    public void setDataEntregaRealizada(LocalDate dataEntregaRealizada) { this.dataEntregaRealizada = dataEntregaRealizada; }
    public Exemplar getExemplar() { return exemplar; }
    public Usuario getUsuario() { return usuario; }
}
