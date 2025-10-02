public class CalculadoraIMC {

    private double peso;
    private double altura;
    private String sexo;

    public CalculadoraIMC(double peso, double altura, String sexo) {
        if (peso < 0) {
            throw new IllegalArgumentException("Peso deve ser maior ou igual a zero");
        }
        if (altura < 0) {
            throw new IllegalArgumentException("Altura deve ser maior ou igual a zero");
        }
        if (!sexo.equalsIgnoreCase("F") && !sexo.equalsIgnoreCase("M")) {
            throw new IllegalArgumentException("Sexo deve ser apenas F ou M");
        }
        
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo.toUpperCase();
    }

    public double calcularIMC() {
        return peso / (altura * altura);
    }

    public String determinarCondicao() {
        double imc = calcularIMC();
        
        if (sexo.equals("F")) {
            // Mulher
            if (imc < 19.1) {
                return "Abaixo do peso";
            } else if (imc < 25.8) {
                return "Peso normal";
            } else if (imc < 27.3) {
                return "Marginalmente acima do peso";
            } else if (imc < 32.3) {
                return "Acima do peso ideal";
            } else {
                return "Obesa";
            }
        } else {
            // Homem
            if (imc < 20.7) {
                return "Abaixo do peso";
            } else if (imc < 26.4) {
                return "Peso normal";
            } else if (imc < 27.8) {
                return "Marginalmente acima do peso";
            } else if (imc < 31.1) {
                return "Acima do peso ideal";
            } else {
                return "Obeso";
            }
        }
    }

    public static void main(String[] args) {
        CalculadoraIMC calculadora = new CalculadoraIMC(70.0, 1.75, "F");
        
        double imc = calculadora.calcularIMC();
        String condicao = calculadora.determinarCondicao();
        
        System.out.printf("IMC: %.2f%n", imc);
        System.out.println("Condição corporal: " + condicao);
    }
}