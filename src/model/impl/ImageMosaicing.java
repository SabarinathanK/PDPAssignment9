package model.impl;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import model.ImageCommand;
import util.Image;
import util.Pixel;
import util.impl.SimplePixel;

/**
 * An implementation for image mosaic.
 */
public class ImageMosaicing implements ImageCommand {
  private final int seed;

  public ImageMosaicing(Integer seed) {
    this.seed = seed;
  }

  private static int getDistance(int x1, int y1, Map.Entry<Integer, Integer> entry) {
    return Math.abs(x1 - entry.getKey()) + Math.abs(y1 - entry.getValue());
  }

  /**
   * Mosaicing the image.
   *
   * @param image the image that needs to be mosaiced
   * @return itself after mosaicing
   */
  public Image execute(Image image) {
    final List<Map.Entry<Integer, Integer>> seeds = getSeeds(image);

    List<List<Integer>> category = new ArrayList<>();
    while (category.size() < image.getHeight()) {
      category.add(new ArrayList<>(Collections.nCopies(image.getWidth(), -1)));
    }
    Map<Integer, List<Pixel>> cluster = new HashMap<>();

    for (int i = 0, cat; i < image.getWidth(); ++i) {
      for (int j = 0; j < image.getHeight(); ++j) {
        cat = getCategory(i, j, seeds);
        category.get(j).set(i, cat);
        if (!cluster.containsKey(cat)) {
          cluster.put(cat, new ArrayList<>());
        }
        cluster.get(cat).add(image.getPixel(i, j));
      }
    }

    Map<Integer, Pixel> averagePixels = getAveragePixels(cluster);

    for (int i = 0; i < image.getWidth(); ++i) {
      for (int j = 0; j < image.getHeight(); ++j) {
        image.setPixel(i, j, new SimplePixel(averagePixels.get(category.get(j).get(i)).getARGB()));
      }
    }
    return image;
  }

  private List<Map.Entry<Integer, Integer>> getSeeds(Image image) {
    List<Map.Entry<Integer, Integer>> seeds = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    Random r = new Random();
    int tmp;
    while (set.size() != seed) {
      tmp = r.nextInt(image.getWidth() * image.getHeight());
      if (!set.contains(tmp)) {
        set.add(tmp);
        seeds.add(new AbstractMap.SimpleEntry<>(tmp % image.getWidth(), tmp / image.getWidth()));
      }
    }
    return seeds;
  }

  private Integer getCategory(int x, int y, List<Map.Entry<Integer, Integer>> seeds) {
    int dist = 0x3f3f3f3f;
    int index = -1;
    for (int i = 0, tmp; i < seeds.size(); ++i) {
      tmp = getDistance(x, y, seeds.get(i));
      if (tmp < dist) {
        dist = tmp;
        index = i;
      }
    }
    return index;
  }

  private Map<Integer, Pixel> getAveragePixels(Map<Integer, List<Pixel>> cluster) {
    Map<Integer, Pixel> averagePixels = new HashMap<>();
    for (Map.Entry<Integer, List<Pixel>> entry : cluster.entrySet()) {
      int averR = 0;
      int averG = 0;
      int averB = 0;
      for (Pixel pixel : entry.getValue()) {
        averR += pixel.getR();
        averG += pixel.getG();
        averB += pixel.getB();
      }
      averR /= entry.getValue().size();
      averG /= entry.getValue().size();
      averB /= entry.getValue().size();
      averagePixels.put(entry.getKey(), new SimplePixel(averR, averG, averB));
    }
    return averagePixels;
  }
}
