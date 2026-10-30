public class FreteEmpresaA implements FreteStrategy {
    @Override
    public double calcularFrete(Endereco endereco, double[] dimensoes, double peso) {
        return 10.00;
    }
}
