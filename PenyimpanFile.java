import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class PenyimpanFile {
  private static final Scanner scanner = new Scanner(System.in);

  public static void buatFile() {
    String data = UserInput.inputData();
    try {
      File file;
      String basePath = "file-tersimpan/";
      String path = basePath;
      while (true) {
        String namaFile = UserInput.inputNamaFile(scanner);
        file = new File(path += namaFile);
        if (file.createNewFile()) {
          System.out
              .println(ValidasiInput.inputOutputViews("outputSpace") + "File baru dengan nama \"" + file.getName()
                  + "\" telah dibuat.");
          break;
        } else {
          path = basePath;
          System.out
              .println(ValidasiInput.inputOutputViews("outputSpace") + "Nama file \"" + file.getName()
                  + "\" telah digunakan. Silakan gunakan nama lain.");
          continue;
        }
      }

      FileWriter fileWriter = new FileWriter(path);
      fileWriter.write(data);
      fileWriter.close();
      scanner.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
