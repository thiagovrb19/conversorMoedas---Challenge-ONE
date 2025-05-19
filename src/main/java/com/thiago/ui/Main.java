package main.java.com.thiago.ui;

import main.java.com.thiago.api.ApiService;
import main.java.com.thiago.model.RateResponse;

import java.util.Map;
import java.util.Scanner;

public class Main {
    // Mapa de códigos para nomes legíveis
    private static final Map<String, String> CURRENCY_NAMES = Map.of(
            "ARS", "Peso Argentino",
            "BOB", "Boliviano",
            "BRL", "Real Brasileiro",
            "CLP", "Peso Chileno",
            "COP", "Peso Colombiano",
            "USD", "Dólar Americano"
    );

    // Pares conforme solicitado
    private static final String[][] PAIRS = {
            {"BRL", "ARS"},  // 1 BRL -> ARS
            {"USD", "BRL"},  // 2 USD -> BRL
            {"CLP", "BOB"},  // 3 CLP -> BOB
            {"COP", "USD"},  // 4 COP -> USD
            {"ARS", "BRL"},  // 5 ARS -> BRL
            {"BRL", "CLP"}   // 6 BRL -> CLP
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiService api = new ApiService();

        while (true) {
            System.out.println("=== Conversor de Moedas ===");
            for (int i = 0; i < PAIRS.length; i++) {
                String fromCode = PAIRS[i][0];
                String toCode = PAIRS[i][1];
                String fromName = CURRENCY_NAMES.get(fromCode);
                String toName = CURRENCY_NAMES.get(toCode);
                System.out.printf("%d. %s (%s) → %s (%s)%n",
                        i + 1,
                        fromName, fromCode,
                        toName, toCode);
            }
            System.out.printf("%d. Sair%n", PAIRS.length + 1);
            System.out.print("Escolha uma opção: ");

            int opc = scanner.nextInt();
            if (opc == PAIRS.length + 1) break;
            if (opc < 1 || opc > PAIRS.length) {
                System.out.println("Opção inválida. Tente novamente.\n");
                continue;
            }

            System.out.print("Digite o valor a converter: ");
            double valor = scanner.nextDouble();

            String from = PAIRS[opc - 1][0];
            String to   = PAIRS[opc - 1][1];

            try {
                RateResponse rates = api.getRates(from);
                Map<String, Double> cr = rates.getConversion_rates();

                double rateFrom   = cr.get(from);
                double rateTarget = cr.get(to);
                double result     = Converter.convert(valor, rateFrom, rateTarget);

                System.out.printf("%.2f %s (%s) = %.2f %s (%s)%n\n",
                        valor, CURRENCY_NAMES.get(from), from,
                        result, CURRENCY_NAMES.get(to), to);
            } catch (Exception e) {
                System.err.println("Erro ao converter: " + e.getMessage() + "\n");
            }
        }

        scanner.close();
        System.out.println("Obrigado por usar o Conversor de Moedas!");
    }
}