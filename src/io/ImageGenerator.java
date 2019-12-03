package io;

import java.io.IOException;

import util.Image;

/**
 * An abstract class for {@code ImageGenerator}.
 */
public abstract class ImageGenerator implements ImageReader {
  private final int width;
  private final int height;

  protected ImageGenerator(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public abstract Image getImage() throws IOException;
}
