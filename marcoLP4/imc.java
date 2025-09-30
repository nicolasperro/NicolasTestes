public class CalculadoraIMC {

    // Dados estáticos do paciente
    static double peso = 70.0;       // em kg
    static double altura = 1.75;     // em metros
    static String sexo = "F";        

    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public static String determinarCondicao(double imc, String sexo) {
        if (sexo.equalsIgnoreCase("F")) { // Mulher
            if (imc < 19.1) return "Abaixo do peso";
            else if (imc < 25.8) return "Peso normal";
            else if (imc < 27.3) return "Marginalmente acima do peso";
            else if (imc < 32.3) return "Acima do peso ideal";
            else return "Obesa";
        } else { // Homem
            if (imc < 20.7) return "Abaixo do peso";
            else if (imc < 26.4) return "Peso normal";
            else if (imc < 27.8) return "Marginalmente acima do peso";
            else if (imc < 31.1) return "Acima do peso ideal";
            else return "Obeso";
        }
    }

    public static void main(String[] args) {
        double imc = calcularIMC(peso, altura);
        String condicao = determinarCondicao(imc, sexo);
        System.out.printf("IMC: %.2f%n", imc);
        System.out.println("Condição corporal: " + condicao);
    }
}
