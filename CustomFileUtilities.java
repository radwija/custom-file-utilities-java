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

  private static String pesanBerhasilBuatFile(String namaFile) {
    return ValidasiInput.inputOutputViews("outputSpace") + "File baru dengan nama \"" + namaFile
        + "\" telah dibuat.";
  }

  public static String buatFile(String basePath, String path, Boolean isRepeated) {
    try {
      File file;
      while (true) {
        if (!isRepeated) {
          String namaFile = UserInput.inputNamaFile(scanner);
          file = new File(path += namaFile);
          if (file.createNewFile()) {
            System.out.println(pesanBerhasilBuatFile(file.getName()));
            return path;
          } else {
            path = basePath;
            System.out
                .println(ValidasiInput.inputOutputViews("outputSpace") + "Nama file \"" + file.getName()
                    + "\" telah digunakan. Silakan gunakan nama lain.");
            continue;
          }
        } else {
          File newFile = new File(path);
          newFile.createNewFile();
          System.out.println(pesanBerhasilBuatFile(newFile.getName()));
          return path;
        }
      }
    } catch (Exception e) {
      if (e.getMessage().contains("No such file or directory")) {
        /*
         * Blok kode if ini berfungsi untuk membuat folder baru dan membuat file
         * berdasarkan nama file yang sudah ditentukan jika folder "file-tersimpan"
         * secara tidak sengaja hilang.
         */
        buatFolder(basePath);
        buatFile(basePath, path, true);
      } else {
        System.out.println("Error dalam pembuatan file: " + e.getMessage());
      }
    }

    if (path != basePath) {
      return path;
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
      tulisDataPadaFile(buatFile(basePath, path, false), data);
      scanner.close();
    } catch (Exception e) {
      System.out.println("Error dalam menulis dan membuat file: " + e.getMessage());
    }
  }
}