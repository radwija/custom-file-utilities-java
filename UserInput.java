import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInput {
  public static String inputNamaFile(Scanner scanner) {
    while (true) {
      System.out.print(ValidasiInput.inputOutputViews("input") + "Masukkan nama file: ");
      String namaFile = scanner.nextLine();
      if (!namaFile.isBlank()) {
        return namaFile;
      }
      System.out.println(ValidasiInput.inputOutputViews("outputSpace") + "Input tidak valid.");
      continue;
    }
  }

  public static String inputData() {
    StringBuilder sb = new StringBuilder();
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter your multiline input (terminate with an emptyline):");
      String line;
      while ((line = reader.readLine()) != null && !line.isEmpty()) {
        sb.append(line).append("\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(sb.toString());
    return sb.toString();
  }
}
