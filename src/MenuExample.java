import java.awt.BorderLayout;
import java.beans.Visibility;
import java.io.File;
import java.io.IOException;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.plaf.FileChooserUI;
import javax.swing.text.html.ImageView;

public class MenuExample implements ActionListener{
  JFrame f;

  JMenuBar mb;
  JMenu file,edit,help;
  JMenuItem cut,copy,paste,selectAll;
  JTextArea ta;
  ImageIcon imageIcon;
  MenuExample(){
    f=new JFrame();

    cut=new JMenuItem("Load");
    copy=new JMenuItem("Save");
    paste=new JMenuItem("Quit");
    //selectAll=new JMenuItem("selectAll");
    cut.addActionListener(this);
    copy.addActionListener(this);
    paste.addActionListener(this);
    imageIcon = new ImageIcon();
//    selectAll.addActionListener(this);
   mb=new JMenuBar();
   file=new JMenu("File");
   file.add(cut);file.add(copy);file.add(paste);//edit.add(selectAll);
   mb.add(file);//mb.add(edit);mb.add(help);
   // ta=new JTextArea();
   // ta.setBounds(5,5,360,320);
    f.add(mb);

    //f.add(ta);
    f.setJMenuBar(mb);
    f.setLayout(null);
    f.setSize(400,400);
    f.setVisible(true);
  }
  public void actionPerformed(ActionEvent e) {
    if(e.getSource()==cut)
    {
      JFileChooser jFileChooser= new JFileChooser();
      jFileChooser.showOpenDialog(null);
      File file = new File(jFileChooser.getSelectedFile().getAbsolutePath());
      //f.setVisible(false);

      String fileName = file.getAbsolutePath();
      ImageIcon icon = new ImageIcon(fileName);
      JLabel label = new JLabel();
      label.setIcon(icon);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.getContentPane().add(label, BorderLayout.CENTER);
    //  f.setSize(400,400);
 //     f.setLocation(200,200);
   //   f.setVisible(true);

      try {
        imageIcon.setImage(ImageIO.read(file));
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      // f.setVisible(true);

    }
    if(e.getSource()==paste)
      ta.paste();
    if(e.getSource()==copy)
      ta.copy();
    if(e.getSource()==selectAll)
      ta.selectAll();
  }
  public static void main(String[] args) {
    new MenuExample();
  }


  public void showNextFrame()
  {
    JFrame jFrame = new JFrame();




  }
}