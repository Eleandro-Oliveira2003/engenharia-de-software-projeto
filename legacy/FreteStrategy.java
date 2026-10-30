public interface FreteStrategy {

    double calcularFrete(
            Endereco endereco,
            double[] dimensoes,
            double peso
    );
}