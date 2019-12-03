package io;

import java.io.IOException;

import util.Image;

/**
 * An interface for {@code ImageReader}.
 */
public interface ImageReader {
  Image getImage() throws IOException;
}
