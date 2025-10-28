package Simon.D3;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    private final FxService fx;
    private final Scanner in = new Scanner(System.in);
    private final DecimalFormat df = new DecimalFormat("#,##0.00");
    private String from = "CHF";
    private String to = "USD";

    public App(FxService fx) { this.fx = fx; }

    public void run() {
        while (true) {
            boxHeader();
            printCombinedRates();
            System.out.println("+" + "-".repeat(stateWidth - 2) + "+");
            boxInfo("From: " + pad(from) + "    To: " + pad(to));
            menuLine("1","Set FROM");
            menuLine("2","Set TO");
            menuLine("3","Convert amount");
            menuLine("4","Show rate");
            menuLine("5","Swap");
            menuLine("6","Exit");
            boxFooter();
            String c = prompt("Select");
            switch (c) {
                case "1" -> setFrom();
                case "2" -> setTo();
                case "3" -> convert();
                case "4" -> showRate();
                case "5" -> swap();
                case "6" -> { return; }
                default -> errBox("Invalid choice");
            }
        }
    }

    private void printCombinedRates() {
        BigDecimal pair = null;
        try { pair = fx.rate(from, to); } catch (Exception ignored) {}
        String pairLine = pair == null ? ("1 " + from + " = ? " + to) : ("1 " + from + " = " + df.format(pair) + " " + to);
        System.out.println("|" + left(" " + pairLine, stateWidth - 2) + "|");
        String base = "CHF";
        String[] list = {"CHF","USD","EUR","GBP","JPY"};
        for (String c : list) {
            BigDecimal r = null;
            try { r = fx.rate(base, c); } catch (Exception ignored) {}
            String line = r == null ? ("1 " + base + " = ? " + c) : ("1 " + base + " = " + df.format(r) + " " + c);
            System.out.println("|" + left(" " + line, stateWidth - 2) + "|");
        }
    }

    private void setFrom() {
        String v = prompt("FROM");
        from = v.trim().toUpperCase();
        okBox("From set to " + from);
    }

    private void setTo() {
        String v = prompt("TO");
        to = v.trim().toUpperCase();
        okBox("To set to " + to);
    }

    private void convert() {
        try {
            String a = prompt("Amount");
            BigDecimal res = fx.convert(new BigDecimal(a), from, to);
            resultBox(df.format(new BigDecimal(a)) + " " + from + " = " + df.format(res) + " " + to);
        } catch (Exception e) {
            errBox(e.getMessage());
        }
    }

    private void showRate() {
        try {
            BigDecimal r = fx.rate(from, to);
            resultBox("1 " + from + " = " + df.format(r) + " " + to);
        } catch (Exception e) {
            errBox(e.getMessage());
        }
    }

    private void swap() {
        String t = from;
        from = to;
        to = t;
        okBox("Swapped: from=" + from + " to=" + to);
    }

    private String prompt(String label) {
        System.out.print(">> " + label + ": ");
        return in.nextLine().trim();
    }

    private String pad(String s) {
        String x = s == null ? "" : s;
        if (x.length() >= 3) return x.substring(0, 3);
        return x + " ".repeat(3 - x.length());
    }

    private void boxHeader() {
        String t = " " + "Currency Exchange" + " ";
        int w = 36;
        System.out.println("+" + "-".repeat(w - 2) + "+");
        System.out.println("|" + center(t, w - 2) + "|");
        System.out.println("+" + "-".repeat(w - 2) + "+");
        stateWidth = w;
    }

    private void boxInfo(String line) {
        System.out.println("|" + left(" " + line, stateWidth - 2) + "|");
    }

    private void menuLine(String key, String text) {
        String s = " " + key + "  " + text;
        System.out.println("|" + left(s, stateWidth - 2) + "|");
    }

    private void boxFooter() {
        System.out.println("+" + "-".repeat(stateWidth - 2) + "+");
    }

    private void resultBox(String msg) {
        int w = Math.max(stateWidth, msg.length() + 8);
        System.out.println("+" + "=".repeat(w - 2) + "+");
        System.out.println("|" + center(" RESULT ", w - 2) + "|");
        System.out.println("+" + "=".repeat(w - 2) + "+");
        System.out.println("|" + left(" " + msg, w - 2) + "|");
        System.out.println("+" + "=".repeat(w - 2) + "+");
    }

    private void errBox(String msg) {
        int w = Math.max(stateWidth, msg.length() + 8);
        System.out.println("+" + "*".repeat(w - 2) + "+");
        System.out.println("|" + center(" ERROR ", w - 2) + "|");
        System.out.println("+" + "*".repeat(w - 2) + "+");
        System.out.println("|" + left(" " + msg, w - 2) + "|");
        System.out.println("+" + "*".repeat(w - 2) + "+");
    }

    private void okBox(String msg) {
        int w = Math.max(stateWidth, msg.length() + 8);
        System.out.println("+" + "-".repeat(w - 2) + "+");
        System.out.println("|" + center(" OK ", w - 2) + "|");
        System.out.println("+" + "-".repeat(w - 2) + "+");
        System.out.println("|" + left(" " + msg, w - 2) + "|");
        System.out.println("+" + "-".repeat(w - 2) + "+");
    }

    private String center(String s, int width) {
        if (s.length() >= width) return s.substring(0, width);
        int left = (width - s.length()) / 2;
        int right = width - s.length() - left;
        return " ".repeat(left) + s + " ".repeat(right);
    }

    private String left(String s, int width) {
        if (s.length() >= width) return s.substring(0, width);
        return s + " ".repeat(width - s.length());
    }

    private int stateWidth = 44;
}
