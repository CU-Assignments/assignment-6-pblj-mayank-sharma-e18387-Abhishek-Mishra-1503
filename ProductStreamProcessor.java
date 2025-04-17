import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.concurrent.ThreadLocalRandom;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("Product{name='%s', category='%s', price=%.2f}", name, category, price);
    }
}

public class ProductStreamProcessor {
    public static void main(String[] args) {
        List<Product> products = generateLargeProductList(100); // Simulate large dataset

        // 1️⃣ Filter products with price > 1000
        System.out.println("🔍 Filtered Products (Price > 1000):");
        products.stream()
                .filter(p -> p.getPrice() > 1000)
                .forEach(System.out::println);

        // 2️⃣ Sort products by price
        System.out.println("\n📊 Products Sorted by Price:");
        products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .limit(10) // Display first 10 for brevity
                .forEach(System.out::println);

        // 3️⃣ Map to product names
        System.out.println("\n📝 Product Names (Price > 1000):");
        products.stream()
                .filter(p -> p.getPrice() > 1000)
                .map(Product::getName)
                .distinct()
                .forEach(System.out::println);

        // 4️⃣ Group products by category
        System.out.println("\n📦 Products Grouped by Category:");
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        grouped.forEach((category, prodList) -> {
            System.out.println("Category: " + category);
            prodList.forEach(System.out::println);
        });

        // 5️⃣ Average price of all products
        double avgPrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);
        System.out.printf("\n💰 Average Product Price: ₹%.2f\n", avgPrice);
    }

    // Utility method to generate random products
    public static List<Product> generateLargeProductList(int count) {
        String[] sampleNames = {"Phone", "Laptop", "Tablet", "TV", "Headphones", "Mouse", "Keyboard", "Speaker"};
        String[] categories = {"Electronics", "Appliances", "Accessories"};

        return IntStream.range(0, count)
                .mapToObj(i -> new Product(
                        sampleNames[i % sampleNames.length] + " " + (i + 1),
                        categories[i % categories.length],
                        ThreadLocalRandom.current().nextDouble(500, 5000)
                ))
                .collect(Collectors.toList());
    }
}
