package io;

import java.io.IOException;

import util.Image;

/**
 * An interface for {@code ImageWriter}.
 */
public interface ImageWriter {
  void writeImage(Image image) throws IOException;
}
