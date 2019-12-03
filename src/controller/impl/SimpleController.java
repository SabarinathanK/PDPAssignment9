package controller.impl;

import java.util.Scanner;

import controller.ImageController;
import io.ImageReader;
import io.ImageWriter;
import model.ImageCommand;
import model.ImageCommandFactory;
import util.Image;

/**
 * A simple implementation for a {@code ImageController}.
 */
public class SimpleController implements ImageController {
  /**
   * Run with a reader and a writer. This controller used for test if processing algorithms works
   * well.
   *
   * @param imageReader an imageReader

   */
  public Image run(ImageReader imageReader,String... command) {
    try {
      Image image = imageReader.getImage();
      Scanner scanner = new Scanner(System.in);
      ImageCommand imageCommand = null;

        imageCommand = ImageCommandFactory.getFactory().getCommand(command);
        if (imageCommand != null) {
          image = imageCommand.execute(image);
          return image;
        } else {
          System.out.println("Unknown command\n");
        }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
