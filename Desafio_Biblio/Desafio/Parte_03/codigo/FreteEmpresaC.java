public class FreteEmpresaC implements FreteStrategy {
    @Override
    public double calcularFrete(Endereco endereco, double[] dimensoes, double peso) {
        return 11.00;
    }
}
