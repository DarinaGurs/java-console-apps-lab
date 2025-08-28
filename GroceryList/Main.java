import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> salesData = new HashMap<>();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                break;
            }
            String[] parts = input.split(" ");
            String buyer = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            salesData.putIfAbsent(buyer, new HashMap<>());
            Map<String, Integer> buyerProducts = salesData.get(buyer);
            buyerProducts.put(product, buyerProducts.getOrDefault(product, 0) + quantity);
        }

        List<String> buyers = new ArrayList<>(salesData.keySet());
        Collections.sort(buyers);

        for (String buyer : buyers) {
            System.out.println(buyer + ":");
            Map<String, Integer> products = salesData.get(buyer);
            List<String> productNames = new ArrayList<>(products.keySet());
            Collections.sort(productNames);

            for (String product : productNames) {
                System.out.println(product + " " + products.get(product));
            }
        }
        scanner.close();
    }

}
