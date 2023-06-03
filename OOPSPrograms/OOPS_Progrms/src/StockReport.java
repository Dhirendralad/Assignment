import java.util.Scanner;

public class StockReport {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Read the number of stocks
            System.out.println("Enter the number of stocks: ");
            int numberOfStocks = scanner.nextInt();

            // Create an array to store the stock data
            Stock[] stocks = new Stock[numberOfStocks];

            // Read the data for each stock
            for (int i = 0; i < numberOfStocks; i++) {
                System.out.println("Enter the name of stock " + (i + 1) + ": ");
                String name = scanner.next();

                System.out.println("Enter the number of shares of " + name + ": ");
                int shares = scanner.nextInt();

                System.out.println("Enter the share price of " + name + ": ");
                double price = scanner.nextDouble();

                stocks[i] = new Stock(name, shares, price);
            }

            // Calculate the total value of each stock
            for (Stock stock : stocks) {
                stock.setTotalValue(stock.getShares() * stock.getPrice());
            }

            // Calculate the total value of all stocks
            double totalValue = 0;
            for (Stock stock : stocks) {
                totalValue += stock.getTotalValue();
            }

            // Print the stock report
            System.out.println("Stock Report");
            System.out.println("----------------");
            for (Stock stock : stocks) {
                System.out.println(stock);
            }
            System.out.println("Total Value: " + totalValue);
        }
    }
}

class Stock {

    private String name;
    private int shares;
    private double price;
    private double totalValue;

    public Stock(String name, int shares, double price) {
        this.name = name;
        this.shares = shares;
        this.price = price;
        this.totalValue = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        return String.format("%-20s %10d %10.2f %10.2f", name, shares, price, totalValue);
    }
}
