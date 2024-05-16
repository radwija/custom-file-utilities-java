import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ValidasiInput {
  private ValidasiInput() {
  }

  public static String inputOutputViews(String kind) {
    switch (kind) {
      case "outputSpace":
        return "   ";
      case "input":
        return ">> ";
      case "process":
        return "** ";
      default:
        return null;
    }
  }

  public static Integer inputInteger(Scanner scanner, String pesan) {
    while (true) {
      System.out.print(inputOutputViews("input") + pesan + ": ");
      try {
        return Integer.parseInt(scanner.nextLine());
      } catch (Exception e) {
        System.out.println(inputOutputViews("outputSpace") + "Input tidak valid.");
        continue;
      }
    }
  }

  public static Integer inputInteger(Scanner scanner, String pesan, Integer start, Integer end,
      HashMap<Integer, String> list) {
    while (true) {
      System.out.println(inputOutputViews("input") + pesan + " (" + start + "-" + end + ")" + ": ");
      for (Map.Entry<Integer, String> entry : list.entrySet()) {
        System.out
            .println(ValidasiInput.inputOutputViews("outputSpace") + entry.getKey() + ") " + entry.getValue());
      }
      System.out.print(inputOutputViews("input"));
      try {
        Integer number = Integer.parseInt(scanner.nextLine());
        if (number < start || number > end) {
          System.out.println(inputOutputViews("outputSpace") + "Input di luar jangkauan.");
        } else {
          return number;
        }
      } catch (Exception e) {
        System.out.println(inputOutputViews("outputSpace") + "Input tidak valid.");
        continue;
      }
    }
  }

  public static Double inputDouble(Scanner scanner, String pesan) {
    while (true) {
      System.out.print(inputOutputViews("input") + pesan + ": ");
      try {
        Double nilaiInput = Double.parseDouble(scanner.nextLine());
        return nilaiInput;
      } catch (Exception e) {
        System.out.println(inputOutputViews("outputSpace") + "Input tidak valid.");
        continue;
      }
    }
  }
}