package model;

import util.Image;

/**
 * An interface for a {@code ImageCommand} added on a {@code Image}.
 */
public interface ImageCommand {
  Image execute(Image image);
}
