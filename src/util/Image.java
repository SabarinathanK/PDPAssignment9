package util;

/**
 * An interface for {@code Image}.
 */
public interface Image {
  int getHeight();

  int getWidth();

  void setPixel(int x, int y, Pixel pixel);

  Pixel getPixel(int x, int y);
}
