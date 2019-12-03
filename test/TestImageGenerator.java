import java.util.Scanner;

import io.ImageFileWriter;
import io.ImageGeneratorFactory;
import io.ImageWriter;

/**
 * A test class for {@code ImageGenerator}.
 */
public class TestImageGenerator {
  /**
   * test main function.
   *
   * @param args args
   */
  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(System.in);
      ImageWriter imageWriter = new ImageFileWriter("res\\greeceFlag.png");
      imageWriter.writeImage(ImageGeneratorFactory.
              getInstance().getGenerator(scanner.next(), "").getImage());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
