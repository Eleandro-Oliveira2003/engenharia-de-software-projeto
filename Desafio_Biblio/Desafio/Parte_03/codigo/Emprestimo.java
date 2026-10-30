import java.time.LocalDate;
import java.util.Objects;

/** Contexto do Strategy: cada emprestimo possui um exemplar e uma cotacao selecionada. */
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
        if (dataEntregaPrevista.isBefore(dataRetirada)) {
            throw new IllegalArgumentException("A entrega prevista nao pode anteceder a retirada.");
        }
        this.exemplar = Objects.requireNonNull(exemplar, "exemplar");
        this.usuario = Objects.requireNonNull(usuario, "usuario");
        this.freteStrategy = freteStrategy;
    }

    /** Define a empresa escolhida pelo usuario na confirmacao do emprestimo. */
    public void setFreteStrategy(FreteStrategy freteStrategy) {
        this.freteStrategy = Objects.requireNonNull(freteStrategy, "freteStrategy");
    }

    /** Calcula a cotacao usando endereco, dimensoes e peso do exemplar atual. */
    public double calcularFrete() {
        if (freteStrategy == null) {
            throw new IllegalStateException("Selecione uma empresa de entrega antes de calcular o frete.");
        }
        return freteStrategy.calcularFrete(usuario.getEndereco(), exemplar.getDimensoes(), exemplar.getPeso());
    }

    public LocalDate getDataRetirada() { return dataRetirada; }
    public LocalDate getDataEntregaPrevista() { return dataEntregaPrevista; }
    public LocalDate getDataEntregaRealizada() { return dataEntregaRealizada; }

    public void setDataEntregaRealizada(LocalDate dataEntregaRealizada) {
        if (dataEntregaRealizada != null && dataEntregaRealizada.isBefore(dataRetirada)) {
            throw new IllegalArgumentException("A entrega realizada nao pode anteceder a retirada.");
        }
        this.dataEntregaRealizada = dataEntregaRealizada;
    }

    public Exemplar getExemplar() { return exemplar; }
    public Usuario getUsuario() { return usuario; }
}
