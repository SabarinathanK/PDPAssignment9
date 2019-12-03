package controller;

import io.ImageReader;
import io.ImageWriter;
import util.Image;

/**
 * An interface for an {@code ImageController}.
 */
public interface ImageController {
  Image run(ImageReader imageReader,String... command);
}
