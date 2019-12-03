package model;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A factory class for building a {@code ImageCommand}.
 */
public class ImageCommandFactory {
  private static ImageCommandFactory imageCommandFactory = null;
  private static Map<String, String> map;

  private ImageCommandFactory() {
    try {
      map = new HashMap<>();
      Scanner in = new Scanner(new FileReader(new File("res\\commands.txt")));
      while (in.hasNext()) {
        map.put(in.next(), in.next());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Get the only factory.
   *
   * @return {@code ImageCommandFactory}
   */
  public static ImageCommandFactory getFactory() {
    if (imageCommandFactory == null) {
      imageCommandFactory = new ImageCommandFactory();
    }
    return imageCommandFactory;
  }

  /**
   * Get a {@code ImageCommand} class by a command.
   *
   * @param command the command written in commands.txt
   * @return the corresponding {@code ImageCommand} class.
   */
  public ImageCommand getCommand(String... args) throws Exception {
    String command = args[0];
    String className = map.getOrDefault(command, null);
    if (className != null) {
      Constructor constructor = Class.forName(className).getConstructors()[0];
      Class[] classes = constructor.getParameterTypes();
      Object[] oargs = new Object[args.length - 1];
      for (int i = 1; i < args.length; ++i) {
        oargs[i - 1] = classes[i - 1].getConstructor(String.class).newInstance(args[i]);
      }
      return (ImageCommand) constructor.newInstance(oargs);
    }
    return null;
  }
}
