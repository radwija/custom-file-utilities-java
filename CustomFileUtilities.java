import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class CustomFileUtilities {
  private static final Scanner scanner = new Scanner(System.in);

  public static void buatFolder(String nama) {
    File tempatPenyimpanFile = new File(nama);
    if (!tempatPenyimpanFile.exists()) {
      tempatPenyimpanFile.mkdirs();
    }
  }

  public static String buatFile(String basePath, String path) {
    try {
      File file;
      while (true) {
        String namaFile = UserInput.inputNamaFile(scanner);
        file = new File(path += namaFile);
        if (file.createNewFile()) {
          System.out
              .println(ValidasiInput.inputOutputViews("outputSpace") + "File baru dengan nama \"" + file.getName()
                  + "\" telah dibuat.");
          return path;
        } else {
          path = basePath;
          System.out
              .println(ValidasiInput.inputOutputViews("outputSpace") + "Nama file \"" + file.getName()
                  + "\" telah digunakan. Silakan gunakan nama lain.");
          continue;
        }
      }
    } catch (Exception e) {
      if (e.getMessage().contains("No such file or directory")) {
        buatFolder(basePath);
        buatFile(basePath, path);
      }
      System.out.println("Error dalam pembuatan file: " + e.getMessage());
    }
    return null;
  }

  public static void tulisDataPadaFile(String path, String data) {
    try {
      FileWriter fileWriter = new FileWriter(path);
      fileWriter.write(data);
      System.out.println(ValidasiInput.inputOutputViews("outputSpace")
          + "Data telah berhasil ditulis pada file. Silakan cek file Anda di " + "\"" + path + "\"" + ".");
      fileWriter.close();
    } catch (Exception e) {
      System.out.println("Error dalam menulis pada file: " + e.getMessage());
    }
  }

  public static void buatDanTulisFile() {
    String data = UserInput.inputData();
    String basePath = "file-tersimpan/";
    String path = basePath;
    try {
      buatFolder(basePath);
      tulisDataPadaFile(buatFile(basePath, path), data);
      scanner.close();
    } catch (Exception e) {
      System.out.println("Error dalam menulis dan membuat file: " + e.getMessage());
    }
  }
}