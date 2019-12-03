package io;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A factory class for generating a {@code ImageGenerator}.
 */
public class ImageGeneratorFactory {
  private static ImageGeneratorFactory imageGeneratorFactory = null;
  private static Map<String, String> map = null;

  private ImageGeneratorFactory() {
    try {
      map = new HashMap<>();
      Scanner scanner = new Scanner(new FileReader(new File("res\\gen.txt")));
      while (scanner.hasNext()) {
        map.put(scanner.next(), scanner.next());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Return the only instance.
   *
   * @return a singleton of {@code ImageGeneratorFactor}.
   */
  public static ImageGeneratorFactory getInstance() {
    if (imageGeneratorFactory == null) {
      imageGeneratorFactory = new ImageGeneratorFactory();
    }
    return imageGeneratorFactory;
  }

  /**
   * Get a {@code ImageGenerator} by command written in gen.txt and a scanner.
   *
   * @param generator the command
   * @param in        the scanner
   * @return A new {@code ImageGenerator}
   */
  public ImageGenerator getGenerator(String generator,String input) {
    String values[]=input.split(",");

    try {
      String className = map.getOrDefault(generator, null);
      if (className != null) {
        if (className.contains("Flag")) {
          return (ImageGenerator) Class.forName(className).
                  getConstructor(Integer.TYPE, Integer.TYPE)
                  .newInstance(Integer.valueOf(values[0]), Integer.valueOf(values[1]));
        } else {
          return (ImageGenerator) Class.forName(className).
                  getConstructor(Integer.TYPE, Integer.TYPE, Integer.TYPE)
                  .newInstance(Integer.valueOf(values[0]), values[1], values[1]);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
