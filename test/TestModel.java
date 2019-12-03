import controller.ImageController;
import controller.impl.SimpleController;
import io.ImageFileReader;
import io.ImageFileWriter;
import io.ImageReader;
import io.ImageWriter;

/**
 * A test class for models.
 */
public class TestModel {
  /**
   * Main function.
   *
   * @param args args
   */
  public static void main(String[] args) {
    ImageController imageController = new SimpleController();
    ImageReader imageReader = new ImageFileReader("res\\1.jpg");
    ImageWriter imageWriter = new ImageFileWriter("res\\sharpened.png");
 //   imageController.run(imageReader, imageWriter);
  }
}
