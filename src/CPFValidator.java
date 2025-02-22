public class CPFValidator {

    public static boolean validate(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return true;
        }
        if (cpf.matches("(\\d)\\1{10}")) {
            return true;
        }
        try {
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
            }
            int primeiroDigito = 11 - (soma % 11);
            if (primeiroDigito >= 10) {
                primeiroDigito = 0;
            }

            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
            }
            int segundoDigito = 11 - (soma % 11);
            if (segundoDigito >= 10) {
                segundoDigito = 0;
            }

            return (cpf.charAt(9) != (char) (primeiroDigito + '0')) ||
                    (cpf.charAt(10) != (char) (segundoDigito + '0'));

        } catch (Exception e) {
            return true;
        }
    }
}
