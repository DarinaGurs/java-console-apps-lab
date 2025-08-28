import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Customer implements Comparable<Customer> {
    private String name;
    private String email;
    private double Amount;

    public Customer(String name, String email, double Amount) {
        this.name = name;
        this.email = email;
        this.Amount = Amount;
    }

    abstract double getDiscount();

    @Override
    public int compareTo(Customer other) {
        return Double.compare(this.getDiscount(), other.getDiscount());
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public double getAmount() {
        return Amount;
    }
}

class RegularCustomer extends Customer {
    private int nomberOfOrders;
    public RegularCustomer(String name, String email, double Amount, int nomberOfOrders) {
        super(name, email, Amount);
        this.nomberOfOrders = nomberOfOrders;
    }
    public int getNomberOfOrders() {
        return nomberOfOrders;
    }

    @Override
    double getDiscount() {
        if (getNomberOfOrders() > 5) {
            return getAmount() * 0.1;
        } else {
            return 0;
        }
    }
}

class VIPCustomer extends Customer {
    private String membershipStatus;
    public VIPCustomer(String name, String email, double Amount, String membershipStatus) {
        super(name, email, Amount);
        this.membershipStatus = membershipStatus;
    }
    public String getMembershipStatus() {
        return membershipStatus;
    }

    @Override
    double getDiscount() {
        switch (getMembershipStatus()) {
            case "Gold":
                return getAmount() * 0.2; // 20% скидка для Gold
            case "Silver":
                return getAmount() * 0.15;// 15% скидка для Silver
            default:
                return getAmount() * 0.10; // 10% скидка для остальных
        }
    }
}

class NewCustomer extends Customer {
    private LocalDate registrationDate;

    public NewCustomer(String name, String email, double Amount, LocalDate registrationDate) {
        super(name, email, Amount);
        this.registrationDate = registrationDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    public boolean isRegisteredToday() {
        LocalDate today = LocalDate.now(); // Получаем сегодняшнюю дату
        return registrationDate.isEqual(today); // Сравниваем даты
    }

    @Override
    double getDiscount() {
        if (isRegisteredToday()) {
            return getAmount() * 0.05;
        }
        return 0;
    }
}

    public class Main {
        public static void main(String[] args) {
            List<Customer> customers = new ArrayList<>();
            customers.add(new RegularCustomer("Иван Иванов", "ivan@example.com", 1000, 6));
            customers.add(new VIPCustomer("Петр Петров", "petr@example.com", 5500, "Gold"));
            customers.add(new NewCustomer("Мария Орлова", "maria@example.com", 1200, LocalDate.of(2022, 10, 10)));

            Collections.sort(customers);

            for (Customer customer : customers) {
                System.out.println("Скидка клиента: " + customer.getName() + " составила " + customer.getDiscount() + " руб.");
            }
        }
    }
