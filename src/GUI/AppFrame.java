package GUI;
import CompAndDecomp.compressor;
import CompAndDecomp.decompressor;

import java.awt.Color;
import java.awt.Panel;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.io.File;


public class AppFrame extends JFrame implements ActionListener{
    JButton compress;
    JButton decompress;

    Panel comp, decomp, heading, divider, upperBorder, lowerBorder;

    JLabel label1, label2, label3;




    AppFrame(String s){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(s);

        //logo for the main frame
        ImageIcon img = new ImageIcon("winRAR.png");


//      labels for comp,decomp,heading panels
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();

        //compress button
         compress = new JButton("Select file to Compress");
         compress.setSize(200, 30);
         compress.setLocation(150, 180);
         compress.setBackground(new Color(63, 81, 181));
         compress.setForeground(Color.white);
         compress.addActionListener(this);

//       decompress button
         decompress = new JButton("Select file to Decompress");
         decompress.setSize(200, 30);
         decompress.setLocation(650, 180);
         decompress.setBackground(new Color(63, 81, 181));
         decompress.setForeground(Color.white);
         decompress.addActionListener(this);


         //heading panel
        heading = new Panel();
        heading.setLocation(0, 5);
        heading.setSize(1000, 29);
        heading.setBackground(Color.CYAN);
        label3.setText("Compression and Decompression of Files");
        label3.setLocation(420, 0);
        heading.add(label3);

        //borders & divider panels
        divider = new Panel();
        divider.setLocation(498, 30);
        divider.setSize(4, 400);
        divider.setBackground(Color.black);

        upperBorder = new Panel();
        upperBorder.setLocation(0, 1);
        upperBorder.setSize(1000, 4);
        upperBorder.setBackground(Color.black);

        lowerBorder = new Panel();
        lowerBorder.setLocation(0, 33);
        lowerBorder.setSize(1000,4);
        lowerBorder.setBackground(Color.black);


         //compress button panel
        comp = new Panel();
        comp.setBackground(Color.red);
        comp.setBounds(0, 37, 498, 370);
        comp.setBackground(new Color(109, 155, 195));
        comp.add(compress);
        comp.add(label1);


        //decompress button panel
        decomp = new Panel();
        decomp.setBounds(502, 37, 498, 370);
        decomp.setBackground(new Color(229, 243, 214));
        decomp.add(decompress);
        decomp.add(label2);

        //image Insertion for comp panel
        ImageIcon zip = new ImageIcon("zip.png");
        Image zipImg = zip.getImage();
        Image scale1 = zipImg.getScaledInstance(comp.getWidth(), comp.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconForZip = new ImageIcon(scale1);
        label1.setIcon(scaledIconForZip);

        //Image Insertion for decomp panel
        ImageIcon unzip = new ImageIcon("unzip.png");
        Image unzipImg = unzip.getImage();
        Image scale2 = unzipImg.getScaledInstance(decomp.getWidth(), decomp.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconForUnzip = new ImageIcon(scale2);
        label2.setIcon(scaledIconForUnzip);

        //adding all the elements to the main frame
         this.setLayout(null);
         this.setSize(1000, 400);
         this.add(compress);
         this.add(decompress);
         this.setVisible(true);
         this.setResizable(false);
         this.setIconImage(img.getImage());
         this.add(comp);
         this.add(decomp);
         this.add(heading);
         this.add(upperBorder);
         this.add(lowerBorder);
         this.add(divider);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==compress){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
        if(ae.getSource() == decompress) {
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
    }
}
