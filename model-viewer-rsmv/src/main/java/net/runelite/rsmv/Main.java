package net.runelite.rsmv;

import net.runelite.rsmv.ui.RSMVListSelectionListener;
import net.runelite.rsmv.ui.RSMVMouseMotionAdapter;
import net.runelite.rsmv.ui.RSMVActionListener3;
import net.runelite.rsmv.ui.RSMVMouseWheelListener;
import net.runelite.rsmv.ui.RSMVWindowAdapter;
import net.runelite.rsmv.ui.RSMVAbstractListModel2;
import net.runelite.rsmv.ui.RSMVComponentAdapter;
import net.runelite.rsmv.ui.RSMVMouseAdapter;
import net.runelite.rsmv.ui.RSMVAbstractListModel;
import net.runelite.rsmv.ui.RSMVActionListener2;
import net.runelite.rsmv.ui.class8;
import net.runelite.rsmv.ui.RSMVActionListener;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;

public class Main extends JFrame implements Runnable {
   public static boolean field32 = false;
   private int field33 = 0;
   private int field34 = 0;
   private int field35 = 500;
   private int field36 = -1;
   private int field37 = -1;
   private String field38 = "";
   private static long field39 = 0L;
   private Model field40;
   private JFileChooser field41;
   private JFileChooser field42;
   private static class13 field43;
   private JList field44;
   private JMenu field45;
   private JMenuBar field46;
   private JMenuItem field47;
   private JScrollPane field48;
   private JMenuItem field49;
   private JMenuItem field50;
   private JCheckBox field51;
   private JPanel field52;

   public Main() {
      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception var3) {
         ;
      }

      this.field41 = new JFileChooser();
      this.field42 = new JFileChooser();
      this.field52 = new JPanel();
      this.field48 = new JScrollPane();
      this.field44 = new JList();
      this.field51 = new JCheckBox();
      this.field46 = new JMenuBar();
      this.field45 = new JMenu();
      this.field50 = new JMenuItem();
      this.field49 = new JMenuItem();
      this.field47 = new JMenuItem();
      this.setDefaultCloseOperation(3);
      this.setTitle("Runescape Model Viewer");
      this.addWindowListener(new RSMVWindowAdapter(this));
      this.field52.setBackground(new Color(0, 0, 0));
      this.field52.addMouseWheelListener(new RSMVMouseWheelListener(this));
      this.field52.addMouseListener(new RSMVMouseAdapter(this));
      this.field52.addComponentListener(new RSMVComponentAdapter(this));
      this.field52.addMouseMotionListener(new RSMVMouseMotionAdapter(this));
      GroupLayout var2 = new GroupLayout(this.field52);
      this.field52.setLayout(var2);
      var2.setHorizontalGroup(var2.createParallelGroup(Alignment.LEADING).addGap(0, 536, 32767));
      var2.setVerticalGroup(var2.createParallelGroup(Alignment.LEADING).addGap(0, 318, 32767));
      this.field44.addListSelectionListener(new RSMVListSelectionListener(this));
      this.field48.setViewportView(this.field44);
      this.field51.setText("Optimized Rendering");
      this.field51.addActionListener(new RSMVActionListener3(this));
      this.field45.setText("File");
      this.field50.setText("Load");
      this.field50.addActionListener(new RSMVActionListener(this));
      this.field45.add(this.field50);
      this.field49.setText("Load Folder");
      this.field49.addActionListener(new RSMVActionListener2(this));
      this.field45.add(this.field49);
      this.field47.setText("Exit");
      this.field45.add(this.field47);
      this.field46.add(this.field45);
      this.setJMenuBar(this.field46);
      var2 = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(var2);
      var2.setHorizontalGroup(var2.createParallelGroup(Alignment.LEADING).addGroup(var2.createSequentialGroup().addContainerGap().addComponent(this.field48, -2, 133, -2).addGap(18, 18, 18).addGroup(var2.createParallelGroup(Alignment.LEADING).addComponent(this.field51).addComponent(this.field52, -1, -1, 32767)).addContainerGap()));
      var2.setVerticalGroup(var2.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, var2.createSequentialGroup().addContainerGap().addGroup(var2.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING, var2.createSequentialGroup().addComponent(this.field51).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.field52, -1, -1, 32767)).addComponent(this.field48, -1, 343, 32767)).addContainerGap()));
      this.pack();
      SwingUtilities.updateComponentTreeUI(this);
   }

   public static void main(String[] var0) {
      EventQueue.invokeLater(new class8());
   }

   public void run() {
      while(true) {
         if(this.field40 != null) {
            int var1 = 1000;

            while(var1 > -1000) {
               try {
                  field43.method25(this.field40, 0, this.field34, 0, this.field33, this.field35);
                  field43.method23(0, 0, this.field52.getGraphics());
                  field43.method26();
               } catch (Exception var5) {
                  var5.printStackTrace();
               }

               var1 -= 32;

               try {
                  Thread.sleep(100L);
               } catch (InterruptedException var4) {
                  ;
               }
            }
         }

         try {
            Thread.sleep(100L);
         } catch (InterruptedException var3) {
            ;
         }

         if(System.currentTimeMillis() - field39 > 60000L) {
            System.gc();
            field39 = System.currentTimeMillis();
         }
      }
   }

   public final void method9() {
      field43 = new class13(this.field52.getWidth(), this.field52.getHeight(), this.field52);
   }

   public final void method10() {
      try {
         FileInputStream var1 = new FileInputStream(System.getProperty("user.home") + System.getProperty("file.separator") + "RSMV.settings");
         Properties var2;
         (var2 = new Properties()).load(var1);
         String var3 = var2.getProperty("path");
         String var8;
         if((var8 = var2.getProperty("optimize")) != null) {
            field32 = Boolean.valueOf(var8).booleanValue();
         }

         this.field51.setSelected(field32);
         if(var3 != null) {
            this.field38 = var3;
            File var9;
            if((var9 = new File(this.field38)).isDirectory()) {
               System.out.println("" + this.field38);
               int var6;
               File[] var10;
               String[] var4 = new String[var6 = (var10 = var9.listFiles()).length];

               for(int var5 = 0; var5 < var6; ++var5) {
                  var4[var5] = var10[var5].getName();
               }

               this.field44.setModel(new RSMVAbstractListModel2(this, var6, var4));
            }

            var1.close();
         }
      } catch (Exception var7) {
         ;
      }
   }

   private void method11() {
      try {
         Properties var1;
         (var1 = new Properties()).setProperty("path", this.field38);
         var1.setProperty("optimize", Boolean.toString(field32));
         var1.store(new FileOutputStream(System.getProperty("user.home") + System.getProperty("file.separator") + "RSMV.settings"), "RSMV");
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }

   private static byte[] method12(String var0) {
      try {
         int var2;
         byte[] var1 = new byte[var2 = (int)(new File(var0)).length()];
         DataInputStream var4;
         (var4 = new DataInputStream(new BufferedInputStream(new FileInputStream(var0)))).readFully(var1, 0, var2);
         var4.close();
         return var1;
      } catch (Exception var3) {
         return null;
      }
   }

   // $FF: synthetic method
   public static void windowClosingCallback(Main var0, WindowEvent var1) {
      var0.method11();
   }

   // $FF: synthetic method
   public static void mouseWheelMoved(Main var0, MouseWheelEvent var1) {
      int var2 = var1.getWheelRotation();
      var0.field35 += var2 * 10;
   }

   // $FF: synthetic method
   public static void mouseReleasedCallback(Main var0, MouseEvent var1) {
      var0.field37 = var0.field36 = -1;
   }

   // $FF: synthetic method
   public static void componentResizedCallback(Main var0, ComponentEvent var1) {
      if(var0.field52.getWidth() > 0 && var0.field52.getHeight() > 0) {
         var0.method9();
      }
   }

   // $FF: synthetic method
   public static void mouseDragged(Main var0, MouseEvent var1) {
      int var2 = var1.getX();
      int var3 = var1.getY();
      if(var0.field36 != -1 || var0.field37 != -1) {
         var0.field33 += var0.field36 - var2;
         if(var0.field33 < 0) {
            var0.field33 += 2048;
         } else if(var0.field33 >= 2048) {
            var0.field33 = 2048 - var0.field33;
         }

         var0.field34 -= var0.field37 - var3;
         if(var0.field34 < 0) {
            var0.field34 += 2048;
         } else if(var0.field34 >= 2048) {
            var0.field34 = 2048 - var0.field34;
         }
      }

      var0.field36 = var2;
      var0.field37 = var3;
   }

   // $FF: synthetic method
   public static void listSelectionValueChanged(Main var0, ListSelectionEvent var1) {
      if(!var1.getValueIsAdjusting()) {
         String var2 = var0.field44.getModel().getElementAt(var0.field44.getAnchorSelectionIndex()).toString();
         byte[] var3;
         Model var4;
         if((var3 = method12(var0.field38 + System.getProperty("file.separator") + var2))[var3.length - 1] == -1 && var3[var3.length - 2] == -1) {
            if((var4 = Model.method36(var3)).field91) {
               var4.method37(4);
            }
         } else {
            Model.method34(var3, 0);
            var4 = Model.method35(0);
         }

         var4.method38(64, 768, -50, -10, -50, true);
         var0.field40 = var4;
      }

   }

   // $FF: synthetic method
   public static void actionListenerCallback3(Main var0, ActionEvent var1) {
      field32 = var0.field51.isSelected();
   }

   // $FF: synthetic method
   public static void actionListenerCallback(Main var0, ActionEvent var1) {
      var0.field41.setFileSelectionMode(0);
      File var2;
      if(var0.field41.showOpenDialog(var0) == 0 && (var2 = var0.field41.getSelectedFile()).isFile()) {
         byte[] var3;
         Model var4;
         if((var3 = method12(var2.getAbsolutePath()))[var3.length - 1] == -1 && var3[var3.length - 2] == -1) {
            if((var4 = Model.method36(var3)).field91) {
               var4.method37(4);
            }
         } else {
            Model.method34(var3, 0);
            var4 = Model.method35(0);
         }

         var4.method38(64, 768, -50, -10, -50, true);
         var0.field40 = var4;
      }

   }

   // $FF: synthetic method
   public static void actionListenerCallback2(Main var0, ActionEvent var1) {
      var0.field42.setFileSelectionMode(1);
      File var5;
      if(var0.field42.showOpenDialog(var0) == 0 && (var5 = var0.field42.getSelectedFile()).isDirectory()) {
         var0.field38 = var5.getAbsolutePath();
         System.out.println("" + var0.field38);
         int var2;
         File[] var6;
         String[] var3 = new String[var2 = (var6 = var5.listFiles()).length];

         for(int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = var6[var4].getName();
         }

         var0.field44.setModel(new RSMVAbstractListModel(var0, var2, var3));
         var0.method11();
      }

   }
}
