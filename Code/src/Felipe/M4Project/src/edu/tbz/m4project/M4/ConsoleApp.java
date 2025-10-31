package edu.tbz.m4project.M4;

import edu.tbz.m4project.M4.User.User;
import edu.tbz.m4project.M4.User.UserRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class ConsoleApp {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ExpenseRepository expenseRepository;
    private final ExpenseManager expenseManager;

    public ConsoleApp(UserRepository userRepository,
                      CategoryRepository categoryRepository,
                      ExpenseRepository expenseRepository,
                      ExpenseManager expenseManager) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.expenseRepository = expenseRepository;
        this.expenseManager = expenseManager;
    }

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Personal Finance Manager (Console) ===");
            User currentUser = ensureUser(scanner);

            boolean exit = false;
            while (!exit) {
                printMenu(currentUser);
                System.out.print("Select an option: ");
                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        listCategories();
                        break;
                    case "2":
                        createCategory(scanner);
                        break;
                    case "3":
                        addExpense(scanner, currentUser);
                        break;
                    case "4":
                        listExpenses(currentUser);
                        break;
                    case "5":
                        currentUser = ensureUser(scanner);
                        break;
                    case "0":
                        exit = true;
                        break;
                    default:
                        System.out.println("Unknown option. Please try again.");
                }
            }
            System.out.println("Goodbye!");
        }
    }

    private void printMenu(User currentUser) {
        System.out.println();
        System.out.println("Logged in as: " + currentUser.getName() + " <" + currentUser.getEmail() + ">");
        System.out.println("1) List categories");
        System.out.println("2) Create category");
        System.out.println("3) Add expense");
        System.out.println("4) List my expenses");
        System.out.println("5) Switch user");
        System.out.println("0) Exit");
    }

    private User ensureUser(Scanner scanner) {
        while (true) {
            System.out.print("Enter your email (will create user if missing): ");
            String email = scanner.nextLine().trim();
            if (email.isEmpty()) {
                System.out.println("Email cannot be empty.");
                continue;
            }
            Optional<User> existing = userRepository.findByEmail(email);
            if (existing.isPresent()) {
                return existing.get();
            }
            System.out.print("Enter your name: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                name = email; // fallback
            }
            User u = new User(name, email, false);
            u = userRepository.save(u);
            System.out.println("Created new user with id " + u.getUserId());
            return u;
        }
    }

    private void listCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            System.out.println("No categories yet. Create one with option 2.");
            return;
        }
        System.out.println("Categories:");
        for (Category c : categories) {
            System.out.println("- [" + c.getCategoryId() + "] " + c.getName());
        }
    }

    private void createCategory(Scanner scanner) {
        System.out.print("New category name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }
        if (categoryRepository.findByName(name).isPresent()) {
            System.out.println("Category already exists.");
            return;
        }
        Category c = new Category(name);
        categoryRepository.save(c);
        System.out.println("Category created: " + name);
    }

    private void addExpense(Scanner scanner, User user) {
        Category category = null;
        List<Category> cats = categoryRepository.findAll();
        if (!cats.isEmpty()) {
            System.out.println("Select category id (or leave empty for none):");
            for (Category c : cats) {
                System.out.println("- [" + c.getCategoryId() + "] " + c.getName());
            }
            System.out.print("Category id: ");
            String catIdStr = scanner.nextLine().trim();
            if (!catIdStr.isEmpty()) {
                try {
                    int catId = Integer.parseInt(catIdStr);
                    category = categoryRepository.findById(catId).orElse(null);
                    if (category == null) {
                        System.out.println("No category with id " + catId + ", will proceed without category.") ;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Proceeding without category.");
                }
            }
        }

        BigDecimal amount;
        while (true) {
            System.out.print("Amount (e.g., 12.34): ");
            String amt = scanner.nextLine().trim();
            try {
                amount = new BigDecimal(amt);
                if (amount.signum() <= 0) {
                    System.out.println("Amount must be positive.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid amount, try again.");
            }
        }

        System.out.print("Description (optional): ");
        String desc = scanner.nextLine().trim();

        Expense expense = new Expense(user, category, amount, desc.isEmpty() ? null : desc);
        expenseManager.addExpense(expense);
        System.out.println("Expense saved with id: " + expense.getExpenseId());
    }

    private void listExpenses(User user) {
        List<Expense> expenses = expenseRepository.findByUser(user);
        if (expenses.isEmpty()) {
            System.out.println("You have no expenses yet.");
            return;
        }
        System.out.println("Your expenses:");
        for (Expense e : expenses) {
            String cat = e.getCategory() != null ? e.getCategory().getName() : "(none)";
            System.out.println("- [" + e.getExpenseId() + "] " + cat + " | " + e.getAmount() + " | " + e.getDate() +
                    (e.getDescription() != null ? (" | " + e.getDescription()) : ""));
        }
    }
}
