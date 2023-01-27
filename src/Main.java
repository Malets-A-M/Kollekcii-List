import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> market = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean i = true;
        while (i) {
            System.out.print("""
                    Список команд:
                    1) Добавить;
                    2) Показать;
                    3) Удалить;
                    4) Поиск;
                    ->""");
            String  numberCommandString = scanner.nextLine();
            try {
                int numberCommand = Integer.parseInt(numberCommandString);
                switch (numberCommand) {
                    case 1 -> {
                        addProduct(market, scanner);
                    }
                    case 2 -> {
                        shoppingList(market);
                    }
                    case 3 -> {
                        shoppingList(market);
                        deleteProduct(market, scanner);
                    }
                    case 4 -> {
                        searchProduct(market, scanner);
                    }
                }
            } catch (NumberFormatException exception){
                continue;
            }
        }
    }

    private static void searchProduct(List<String> market, Scanner scanner) {
        System.out.println("Введите текст для поиска:");
        String text = scanner.nextLine();
        System.out.println("Найдено:");
        for (int a = 0; a < market.size(); a++) {
            String itemLower = text.toLowerCase();
            String queryLower = market.get(a).toLowerCase();
            if (queryLower.contains(itemLower)) {
                System.out.println(a + 1 + ". " + market.get(a));
                continue;
            }
        }
    }

    private static void deleteProduct(List<String> market, Scanner scanner) {
        System.out.println("Какую хотите удалить? Введите номер или название");
        String text = scanner.nextLine();
        try {
            int t = Integer.parseInt(text);
            System.out.println("Покупка \"" + market.get(t - 1) + "\" удалена, список покупок:");
            market.remove(t - 1);
            for (int a = 0; a < market.size(); a++) {
                System.out.println(a + 1 + ". " + market.get(a));
            }
        } catch (NumberFormatException exception) {
            market.remove(text);
            System.out.println("Покупка \"" + text + "\" удалена, список покупок:");
            for (int a = 0; a < market.size(); a++) {
                System.out.println(a + 1 + ". " + market.get(a));
            }
        }
    }

    private static void addProduct(List<String> market, Scanner scanner) {
        System.out.println("Какую покупку хотите добавить?");
        market.add(scanner.nextLine());
        System.out.println("Итого в списке покупок: " + market.size());
    }

    private static void shoppingList(List<String> market) {
        System.out.println("Список покупок:");
        for (int a = 0; a < market.size(); a++) {
            System.out.println(a + 1 + ". " + market.get(a));
        }
    }
}


