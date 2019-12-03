import controller.ImageController;
import controller.impl.SimpleController;
import io.ImageFileReader;
import io.ImageFileWriter;
import io.ImageGeneratorFactory;
import io.ImageWriter;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import util.Image;

public class ImageDemo implements ActionListener
{
  JMenuBar mb;

  JMenu file;
  JMenu processImage;
  JMenu generate;
  JMenuItem load,save,quit;
  JMenuItem blur,sharpen,sepia,grayscale,dither,mosaic,checkboard,franceflag,greeceflag,horizontalrainbow,swizerlandflag,verticalrainbow;
  ImageFileReader imageFileReader;
  Image processedimage;
  public static void main(String[] args) throws Exception
  {
    new ImageDemo().show();
  }
  public ImageDemo()
  {

  }

  public void show()
  {

    mb= new JMenuBar();
    file=new JMenu("File");
    processImage=new JMenu("Operations");
    generate=new JMenu("Genreate");
    load= new JMenuItem("Load");
    save= new JMenuItem("Save");
    quit= new JMenuItem("Quit");
    blur= new JMenuItem("Blur");
    sharpen= new JMenuItem("Sharpen");
    sepia= new JMenuItem("Sepia");
    grayscale= new JMenuItem("grayscale");
    dither= new JMenuItem("dither");
    mosaic= new JMenuItem("mosaic");
    checkboard = new JMenuItem("checkboard");
    franceflag = new JMenuItem("franceflag");
    greeceflag = new JMenuItem("greeceflag");
    horizontalrainbow = new JMenuItem("Horizontalrainbow");
    verticalrainbow= new JMenuItem("VerticalRainbow");
    swizerlandflag= new JMenuItem("Swizerlandflag");


    file.add(load);
    file.add(save);
    file.add(quit);
    processImage.add(blur);
    processImage.add(sharpen);
    processImage.add(grayscale);
    processImage.add(sepia);
    processImage.add(dither);
    processImage.add(mosaic);
    generate.add(checkboard);
    generate.add(franceflag);
    generate.add(greeceflag);
    generate.add(horizontalrainbow);
    generate.add(swizerlandflag);
    generate.add(verticalrainbow);
    load.addActionListener(this);
    mb.add(file);
    mb.add(processImage);
    mb.add(generate);
    blur.addActionListener(this);
    grayscale.addActionListener(this);
    sharpen.addActionListener(this);
    sepia.addActionListener(this);
    dither.addActionListener(this);
    mosaic.addActionListener(this);
    checkboard.addActionListener(this);
    franceflag.addActionListener(this);
    greeceflag.addActionListener(this);
    horizontalrainbow.addActionListener(this);
    swizerlandflag.addActionListener(this);
    verticalrainbow.addActionListener(this);
    editorFrame = new JFrame("Image Demo");
    editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    editorFrame.add(mb);
    editorFrame.setJMenuBar(mb);
    editorFrame.setSize(500,500);
    editorFrame.setVisible(true);
  }

  JFrame editorFrame;
  JLabel jLabel = new JLabel();

  public ImageDemo(final String filename) throws Exception
  {
imageFileReader= new ImageFileReader(filename);

    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
       // editorFrame = new JFrame("Image Demo");
        //editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //editorFrame.add(mb);
        //editorFrame.setJMenuBar(mb);
        BufferedImage image = null;
        try
        {
          image = ImageIO.read(new File(filename));
        }
        catch (Exception e)
        {
          e.printStackTrace();
          System.exit(1);
        }
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);

        editorFrame.getContentPane().add(jLabel);

        editorFrame.pack();
        //editorFrame.setLocationRelativeTo(null);
    //    editorFrame.setVisible(true);
      }
    });
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource()==load)
    {
      processImage=null;
      JFileChooser jFileChooser = new JFileChooser();
      jFileChooser.showOpenDialog(null);
      editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      editorFrame.add(mb);
      editorFrame.setJMenuBar(mb);
      BufferedImage image = null;
       imageFileReader = new ImageFileReader(jFileChooser.getSelectedFile().getAbsolutePath());
      try
      {
        image = ImageIO.read(new File(jFileChooser.getSelectedFile().getAbsolutePath()));
      }
      catch (Exception e1)
      {
        e1.printStackTrace();
        System.exit(1);
      }
      ImageIcon imageIcon = new ImageIcon(image);

      jLabel.setIcon(imageIcon);

      editorFrame.getContentPane().add(jLabel);

      editorFrame.pack();
      editorFrame.setLocationRelativeTo(null);
      editorFrame.setVisible(true);
    }
    if(e.getSource()==blur)
    {

      if(processedimage!=null)
      {
        File file=null;
        try {
           file= File.createTempFile("temp",".png");
           ImageWriter imageWriter = new ImageFileWriter(file.getAbsolutePath());
           imageWriter.writeImage(processedimage);
           imageFileReader=new ImageFileReader(file.getAbsolutePath());
        } catch (IOException ex) {
          ex.printStackTrace();
        }
       // imageFileReader= new ImageFileReader("");
      //imageFileReader.setImage(processedimage);
      }
      ImageController simpleController = new SimpleController();
      processedimage= simpleController.run(imageFileReader,"blur");
      BufferedImage bufferedImage = ImageFileWriter.imageToBufferedImage(processedimage);
      ImageIcon imageIcon = new ImageIcon(bufferedImage);
      jLabel.setIcon(imageIcon);
      editorFrame.getContentPane().add(jLabel);

      editorFrame.pack();
      editorFrame.setLocationRelativeTo(null);
      editorFrame.setVisible(true);
    }

    if(e.getSource()==grayscale)
    {
      if(processedimage!=null)
      {
        File file=null;
        try {
          file= File.createTempFile("temp",".png");
          ImageWriter imageWriter = new ImageFileWriter(file.getAbsolutePath());
          imageWriter.writeImage(processedimage);
          imageFileReader=new ImageFileReader(file.getAbsolutePath());
        } catch (IOException ex) {
          ex.printStackTrace();
        }
        // imageFileReader= new ImageFileReader("");
        //imageFileReader.setImage(processedimage);
      }
      ImageController simpleController = new SimpleController();
      processedimage= simpleController.run(imageFileReader,"grayscale");
      BufferedImage bufferedImage = ImageFileWriter.imageToBufferedImage(processedimage);
      ImageIcon imageIcon = new ImageIcon(bufferedImage);
      jLabel.setIcon(imageIcon);
      editorFrame.getContentPane().add(jLabel);

      editorFrame.pack();
      editorFrame.setLocationRelativeTo(null);
      editorFrame.setVisible(true);
    }

    if(e.getSource()==sepia)
    {
      if(processedimage!=null)
      {
        File file=null;
        try {
          file= File.createTempFile("temp",".png");
          ImageWriter imageWriter = new ImageFileWriter(file.getAbsolutePath());
          imageWriter.writeImage(processedimage);
          imageFileReader=new ImageFileReader(file.getAbsolutePath());
        } catch (IOException ex) {
          ex.printStackTrace();
        }
        // imageFileReader= new ImageFileReader("");
        //imageFileReader.setImage(processedimage);
      }
      ImageController simpleController = new SimpleController();
      processedimage= simpleController.run(imageFileReader,"sepia");
      BufferedImage bufferedImage = ImageFileWriter.imageToBufferedImage(processedimage);
      ImageIcon imageIcon = new ImageIcon(bufferedImage);
      jLabel.setIcon(imageIcon);
      editorFrame.getContentPane().add(jLabel);

      editorFrame.pack();
      editorFrame.setLocationRelativeTo(null);
      editorFrame.setVisible(true);
    }

    if(e.getSource()==sharpen)
    {
      if(processedimage!=null)
      {
        File file=null;
        try {
          file= File.createTempFile("temp",".png");
          ImageWriter imageWriter = new ImageFileWriter(file.getAbsolutePath());
          imageWriter.writeImage(processedimage);
          imageFileReader=new ImageFileReader(file.getAbsolutePath());
        } catch (IOException ex) {
          ex.printStackTrace();
        }
        // imageFileReader= new ImageFileReader("");
        //imageFileReader.setImage(processedimage);
      }
      ImageController simpleController = new SimpleController();
      processedimage= simpleController.run(imageFileReader,"sharpen");
      BufferedImage bufferedImage = ImageFileWriter.imageToBufferedImage(processedimage);
      ImageIcon imageIcon = new ImageIcon(bufferedImage);
      jLabel.setIcon(imageIcon);
      editorFrame.getContentPane().add(jLabel);

      editorFrame.pack();
      editorFrame.setLocationRelativeTo(null);
      editorFrame.setVisible(true);
    }

    if(e.getSource()==dither)
    {
      if(processedimage!=null)
      {
        File file=null;
        try {
          file= File.createTempFile("temp",".png");
          ImageWriter imageWriter = new ImageFileWriter(file.getAbsolutePath());
          imageWriter.writeImage(processedimage);
          imageFileReader=new ImageFileReader(file.getAbsolutePath());
        } catch (IOException ex) {
          ex.printStackTrace();
        }
        // imageFileReader= new ImageFileReader("");
        //imageFileReader.setImage(processedimage);
      }
      ImageController simpleController = new SimpleController();
      processedimage= simpleController.run(imageFileReader,"dither");
      BufferedImage bufferedImage = ImageFileWriter.imageToBufferedImage(processedimage);
      ImageIcon imageIcon = new ImageIcon(bufferedImage);
      jLabel.setIcon(imageIcon);
      editorFrame.getContentPane().add(jLabel);

      editorFrame.pack();
      editorFrame.setLocationRelativeTo(null);
      editorFrame.setVisible(true);
    }

    if(e.getSource()==mosaic)
    {

      if(processedimage!=null)
      {
        File file=null;
        try {
          file= File.createTempFile("temp",".png");
          ImageWriter imageWriter = new ImageFileWriter(file.getAbsolutePath());
          imageWriter.writeImage(processedimage);
          imageFileReader=new ImageFileReader(file.getAbsolutePath());
        } catch (IOException ex) {
          ex.printStackTrace();
        }
        // imageFileReader= new ImageFileReader("");
        //imageFileReader.setImage(processedimage);
      }
      String seeds= JOptionPane.showInputDialog("Enter the number of seeds");
      ImageController simpleController = new SimpleController();
      processedimage= simpleController.run(imageFileReader,"mosaic",seeds);
      BufferedImage bufferedImage = ImageFileWriter.imageToBufferedImage(processedimage);
      ImageIcon imageIcon = new ImageIcon(bufferedImage);
      jLabel.setIcon(imageIcon);
      editorFrame.getContentPane().add(jLabel);

      editorFrame.pack();
      editorFrame.setLocationRelativeTo(null);
      editorFrame.setVisible(true);
    }

    if(e.getSource()==checkboard)
    {

      if(processedimage!=null)
      {
        File file=null;
        try {
          file= File.createTempFile("temp",".png");
          ImageWriter imageWriter = new ImageFileWriter(file.getAbsolutePath());
          imageWriter.writeImage(processedimage);
          imageFileReader=new ImageFileReader(file.getAbsolutePath());
        } catch (IOException ex) {
          ex.printStackTrace();
        }
        // imageFileReader= new ImageFileReader("");
        //imageFileReader.setImage(processedimage);
      }
      JTextField xField = new JTextField(5);
      JTextField yField = new JTextField(5);
      JTextField boards = new JTextField(5);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("x:"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("y:"));
      myPanel.add(yField);

      int result = JOptionPane.showConfirmDialog(null, myPanel,
          "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
      Scanner scanner =null;
      if (result == JOptionPane.OK_OPTION) {
        System.out.println("x value: " + xField.getText());
        System.out.println("y value: " + yField.getText());
        scanner = new Scanner(xField.getText()+" "+yField.getText());
      }
      ImageController simpleController = new SimpleController();
      try {
        processedimage= ImageGeneratorFactory.
            getInstance().getGenerator("checkerboard", "").getImage();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      BufferedImage bufferedImage = ImageFileWriter.imageToBufferedImage(processedimage);
      ImageIcon imageIcon = new ImageIcon(bufferedImage);
      jLabel.setIcon(imageIcon);
      editorFrame.getContentPane().add(jLabel);

      editorFrame.pack();
      editorFrame.setLocationRelativeTo(null);
      editorFrame.setVisible(true);
    }
    if(e.getSource()==franceflag)
    {

      if(processedimage!=null)
      {
        File file=null;
        try {
          file= File.createTempFile("temp",".png");
          ImageWriter imageWriter = new ImageFileWriter(file.getAbsolutePath());
          imageWriter.writeImage(processedimage);
          imageFileReader=new ImageFileReader(file.getAbsolutePath());
        } catch (IOException ex) {
          ex.printStackTrace();
        }
        // imageFileReader= new ImageFileReader("");
        //imageFileReader.setImage(processedimage);
      }
      JTextField xField = new JTextField(5);
      JTextField yField = new JTextField(5);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("x:"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("y:"));
      myPanel.add(yField);

      int result = JOptionPane.showConfirmDialog(null, myPanel,
          "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
      Scanner scanner =null;
      if (result == JOptionPane.OK_OPTION) {
        System.out.println("x value: " + xField.getText());
        System.out.println("y value: " + yField.getText());
        scanner = new Scanner(xField.getText()+","+yField.getText());
      }
      ImageController simpleController = new SimpleController();
      try {
        processedimage= ImageGeneratorFactory.
            getInstance().getGenerator("f", xField.getText()+","+yField.getText()).getImage();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      BufferedImage bufferedImage = ImageFileWriter.imageToBufferedImage(processedimage);
      ImageIcon imageIcon = new ImageIcon(bufferedImage);
      jLabel.setIcon(imageIcon);
      editorFrame.getContentPane().add(jLabel);

      editorFrame.pack();
      editorFrame.setLocationRelativeTo(null);
      editorFrame.setVisible(true);
    }
    if(e.getSource()==swizerlandflag)
    {

      if(processedimage!=null)
      {
        File file=null;
        try {
          file= File.createTempFile("temp",".png");
          ImageWriter imageWriter = new ImageFileWriter(file.getAbsolutePath());
          imageWriter.writeImage(processedimage);
          imageFileReader=new ImageFileReader(file.getAbsolutePath());
        } catch (IOException ex) {
          ex.printStackTrace();
        }
        // imageFileReader= new ImageFileReader("");
        //imageFileReader.setImage(processedimage);
      }
      JTextField xField = new JTextField(5);
      JTextField yField = new JTextField(5);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("x:"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("y:"));
      myPanel.add(yField);

      int result = JOptionPane.showConfirmDialog(null, myPanel,
          "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
      Scanner scanner =null;
      if (result == JOptionPane.OK_OPTION) {
        System.out.println("x value: " + xField.getText());
        System.out.println("y value: " + yField.getText());
        scanner = new Scanner(xField.getText()+","+yField.getText());
      }
      ImageController simpleController = new SimpleController();
      try {
        processedimage= ImageGeneratorFactory.
            getInstance().getGenerator("s", xField.getText()+","+yField.getText()).getImage();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      BufferedImage bufferedImage = ImageFileWriter.imageToBufferedImage(processedimage);
      ImageIcon imageIcon = new ImageIcon(bufferedImage);
      jLabel.setIcon(imageIcon);
      editorFrame.getContentPane().add(jLabel);

      editorFrame.pack();
      editorFrame.setLocationRelativeTo(null);
      editorFrame.setVisible(true);
    }
    if(e.getSource()==horizontalrainbow)
    {

      if(processedimage!=null)
      {
        File file=null;
        try {
          file= File.createTempFile("temp",".png");
          ImageWriter imageWriter = new ImageFileWriter(file.getAbsolutePath());
          imageWriter.writeImage(processedimage);
          imageFileReader=new ImageFileReader(file.getAbsolutePath());
        } catch (IOException ex) {
          ex.printStackTrace();
        }
        // imageFileReader= new ImageFileReader("");
        //imageFileReader.setImage(processedimage);
      }
      JTextField xField = new JTextField(5);
      JTextField yField = new JTextField(5);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("x:"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("y:"));
      myPanel.add(yField);

      int result = JOptionPane.showConfirmDialog(null, myPanel,
          "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
      Scanner scanner =null;
      if (result == JOptionPane.OK_OPTION) {
        System.out.println("x value: " + xField.getText());
        System.out.println("y value: " + yField.getText());
        scanner = new Scanner(xField.getText()+","+yField.getText());
      }
      ImageController simpleController = new SimpleController();
      try {
        processedimage= ImageGeneratorFactory.
            getInstance().getGenerator("h", xField.getText()+","+yField.getText()).getImage();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      BufferedImage bufferedImage = ImageFileWriter.imageToBufferedImage(processedimage);
      ImageIcon imageIcon = new ImageIcon(bufferedImage);
      jLabel.setIcon(imageIcon);
      editorFrame.getContentPane().add(jLabel);

      editorFrame.pack();
      editorFrame.setLocationRelativeTo(null);
      editorFrame.setVisible(true);
    }

    if(e.getSource()==verticalrainbow)
    {

      if(processedimage!=null)
      {
        File file=null;
        try {
          file= File.createTempFile("temp",".png");
          ImageWriter imageWriter = new ImageFileWriter(file.getAbsolutePath());
          imageWriter.writeImage(processedimage);
          imageFileReader=new ImageFileReader(file.getAbsolutePath());
        } catch (IOException ex) {
          ex.printStackTrace();
        }
        // imageFileReader= new ImageFileReader("");
        //imageFileReader.setImage(processedimage);
      }
      JTextField xField = new JTextField(5);
      JTextField yField = new JTextField(5);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("x:"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("y:"));
      myPanel.add(yField);

      int result = JOptionPane.showConfirmDialog(null, myPanel,
          "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
      Scanner scanner =null;
      if (result == JOptionPane.OK_OPTION) {
        System.out.println("x value: " + xField.getText());
        System.out.println("y value: " + yField.getText());
        scanner = new Scanner(xField.getText()+","+yField.getText());
      }
      ImageController simpleController = new SimpleController();
      try {
        processedimage= ImageGeneratorFactory.
            getInstance().getGenerator("v", xField.getText()+","+yField.getText()).getImage();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      BufferedImage bufferedImage = ImageFileWriter.imageToBufferedImage(processedimage);
      ImageIcon imageIcon = new ImageIcon(bufferedImage);
      jLabel.setIcon(imageIcon);
      editorFrame.getContentPane().add(jLabel);

      editorFrame.pack();
      editorFrame.setLocationRelativeTo(null);
      editorFrame.setVisible(true);
    }
  }
}




