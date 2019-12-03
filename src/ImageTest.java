import controller.ImageController;
import controller.impl.SimpleController;
import io.ImageFileReader;
import io.ImageFileWriter;
import io.ImageReader;
import io.ImageWriter;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.embed.swt.SWTFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class ImageTest extends Application {

  public static void main(String[] args) {
    launch(args);
  }
Stage s;
util.Image image;
Image image1;
ImageReader imageReader;
boolean loadprocessedImage=false;
  @FXML ImageView loadimage;
  @FXML ImageView processimage;
  @Override
  public void start(Stage primaryStage) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
    s=primaryStage;

    primaryStage.setTitle("Image Processing Test");
    primaryStage.setScene(new Scene(root));
    primaryStage.show();

  }

  public void testLoad() throws IOException {
    FileChooser fileChooser = new FileChooser();
    File file = fileChooser.showOpenDialog(s);
    Image image = SwingFXUtils.toFXImage(ImageIO.read(file),null);
  imageReader= new ImageFileReader(file.getAbsolutePath());
    loadimage.setImage(image);
  }


  public void testBlur() throws IOException {
    ImageController imageController = new SimpleController();
    util.Image image;
    if(!loadprocessedImage) {
      image = imageController.run(imageReader, "ib");
    }
    else
    {
      ImageFileReader imageReader=new ImageFileReader("");
      imageReader.setImage(SwingFXUtils.fromFXImage(image1,null));
      image=imageController.run(imageReader,"ib");
      loadprocessedImage=false;
    }
    BufferedImage image2=ImageFileWriter.imageToBufferedImage(image);
    Image image3=SwingFXUtils.toFXImage(image2,null);
    processimage.setImage(image3);

  }

  public void testGrayScale() throws IOException {
    ImageController imageController = new SimpleController();
    util.Image image;
    if(!loadprocessedImage) {
      image = imageController.run(imageReader, "gt");
    }
    else
    {
      ImageFileReader imageReader=new ImageFileReader("");
      imageReader.setImage(SwingFXUtils.fromFXImage(image1,null));
      image=imageController.run(imageReader,"gt");
      loadprocessedImage=false;
    }
    BufferedImage image2=ImageFileWriter.imageToBufferedImage(image);
    Image image3=SwingFXUtils.toFXImage(image2,null);
    processimage.setImage(image3);

  }
  public void testSepia() throws IOException {
    ImageController imageController = new SimpleController();
    util.Image image;
    if(!loadprocessedImage) {
      image = imageController.run(imageReader, "st");
    }
    else
    {
      ImageFileReader imageReader=new ImageFileReader("");
      imageReader.setImage(SwingFXUtils.fromFXImage(image1,null));
      image=imageController.run(imageReader,"st");
      loadprocessedImage=false;
    }
    BufferedImage image2=ImageFileWriter.imageToBufferedImage(image);
    Image image3=SwingFXUtils.toFXImage(image2,null);
    processimage.setImage(image3);

  }
  public void testSharpen() throws IOException {
    ImageController imageController = new SimpleController();
    util.Image image;
    if(!loadprocessedImage) {
      image = imageController.run(imageReader, "is");
    }
    else
    {
      ImageFileReader imageReader=new ImageFileReader("");
      imageReader.setImage(SwingFXUtils.fromFXImage(image1,null));
      image=imageController.run(imageReader,"is");
      loadprocessedImage=false;
    }
    BufferedImage image2=ImageFileWriter.imageToBufferedImage(image);
    Image image3=SwingFXUtils.toFXImage(image2,null);
    processimage.setImage(image3);

  }

  public void testLoadProcessedImage()
  {
     loadprocessedImage=true;
    image1=processimage.getImage();


  }


  public BufferedImage convertToBufferedImage(Image image)
  {
    /*BufferedImage bufferedImage = new BufferedImage((int)image.getWidth(),(int)image.getHeight(),BufferedImage.TYPE_INT_ARGB);
    Graphics graphics= bufferedImage.getGraphics();
    graphics.drawImage(image,0,0,null);
    graphics.dispose();
    return bufferedImage;*/
    return null;
  }

  public void testSave() throws IOException {
    FileChooser fileChooser = new FileChooser();
    File file = fileChooser.showSaveDialog(null);

    String[] strings = file.getName().split("\\.");

    System.out.println(ImageIO.
        write(SwingFXUtils.fromFXImage(processimage.getImage(),null), strings[strings.length - 1], file));

  }
}
