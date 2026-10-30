public class FreteEmpresaB implements FreteStrategy {
    @Override
    public double calcularFrete(Endereco endereco, double[] dimensoes, double peso) {
        return 12.00;
    }
}
