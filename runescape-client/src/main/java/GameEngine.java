import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = -1409652063
   )
   static int field1765 = 0;
   @ObfuscatedName("po")
   static GameEngine field1766 = null;
   @ObfuscatedName("pt")
   static boolean field1767 = false;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      longValue = -5794771538753610207L
   )
   static long field1768 = 0L;
   @ObfuscatedName("ps")
   @ObfuscatedGetter(
      intValue = 1865831767
   )
   static int field1769 = 20;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = 1136137059
   )
   static int field1770 = 1;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = 493958019
   )
   @Export("FPS")
   protected static int FPS = 0;
   @ObfuscatedName("qu")
   static long[] field1773 = new long[32];
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = -1409019955
   )
   protected static int field1774 = 0;
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = 1953152373
   )
   protected static int field1775 = 0;
   @ObfuscatedName("qo")
   public static volatile boolean field1776 = true;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = -1815628939
   )
   static int field1777 = 500;
   @ObfuscatedName("ql")
   protected static boolean field1778 = false;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      longValue = 7338698987713931771L
   )
   static volatile long field1779 = 0L;
   @ObfuscatedName("qt")
   static long[] field1780 = new long[32];
   @ObfuscatedName("rz")
   static volatile boolean field1781 = true;
   @ObfuscatedName("qi")
   protected static volatile boolean field1782 = false;
   @ObfuscatedName("pg")
   boolean field1783 = false;

   public void start() {
      if(field1766 == this && !field1767) {
         field1768 = 0L;
      }
   }

   @ObfuscatedName("rf")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2120272454"
   )
   protected final void method2093(int var1, int var2, int var3) {
      try {
         if(field1766 != null) {
            ++field1765;
            if(field1765 >= 3) {
               this.method2107("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field1766 = this;
         XItemContainer.field123 = var1;
         class143.field1999 = var2;
         class101.field1659 = var3;
         class101.field1657 = this;
         if(class63.field1093 == null) {
            class63.field1093 = new class103();
         }

         class63.field1093.method1945(this, 1);
      } catch (Exception var5) {
         class32.method709((String)null, var5);
         this.method2107("crash");
      }

   }

   @ObfuscatedName("sk")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-55"
   )
   protected final synchronized void method2094() {
      Container var1 = this.method2170();
      if(class32.canvas != null) {
         class32.canvas.removeFocusListener(this);
         var1.remove(class32.canvas);
      }

      XItemContainer.field123 = Math.max(var1.getWidth(), RSCanvas.field1755);
      class143.field1999 = Math.max(var1.getHeight(), RSCanvas.field1759);
      Insets var2;
      if(Tile.field1351 != null) {
         var2 = Tile.field1351.getInsets();
         XItemContainer.field123 -= var2.right + var2.left;
         class143.field1999 -= var2.top + var2.bottom;
      }

      class32.canvas = new RSCanvas(this);
      var1.add(class32.canvas);
      class32.canvas.setSize(XItemContainer.field123, class143.field1999);
      class32.canvas.setVisible(true);
      if(Tile.field1351 == var1) {
         var2 = Tile.field1351.getInsets();
         class32.canvas.setLocation(var2.left + field1774, var2.top + field1775);
      } else {
         class32.canvas.setLocation(field1774, field1775);
      }

      class32.canvas.addFocusListener(this);
      class32.canvas.requestFocus();
      field1776 = true;
      int var3 = XItemContainer.field123;
      int var4 = class143.field1999;
      Canvas var5 = class32.canvas;

      Object var9;
      try {
         MainBufferProvider var6 = new MainBufferProvider();
         var6.init(var3, var4, var5);
         var9 = var6;
      } catch (Throwable var8) {
         SecondaryBufferProvider var7 = new SecondaryBufferProvider();
         var7.init(var3, var4, var5);
         var9 = var7;
      }

      if(class13.bufferProvider != null) {
         class13.bufferProvider.draw(((BufferProvider)var9).image.getGraphics(), 0, 0);
      }

      class13.bufferProvider = (BufferProvider)var9;
      field1782 = false;
      field1779 = class22.method224();
   }

   public void run() {
      try {
         int var3;
         if(null != class103.field1687) {
            String var1 = class103.field1687.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class45.field904;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method2107("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  for(var3 = 6; var3 < var2.length() && RSCanvas.method2075(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(class163.method3149(var4) && class221.method4058(var4) < 10) {
                     this.method2107("wrongjava");
                     return;
                  }
               }

               field1770 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method2094();
         this.vmethod2142();
         class94.field1589 = class72.method1387();

         label77:
         while(true) {
            class103 var7;
            Canvas var8;
            do {
               if(0L != field1768 && class22.method224() >= field1768) {
                  break label77;
               }

               class49.field958 = class94.field1589.vmethod2040(field1769, field1770);

               for(int var5 = 0; var5 < class49.field958; ++var5) {
                  this.method2125();
               }

               this.method2097();
               var7 = class63.field1093;
               var8 = class32.canvas;
            } while(var7.field1681 == null);

            for(var3 = 0; var3 < 50 && var7.field1681.peekEvent() != null; ++var3) {
               class195.method3560(1L);
            }

            if(var8 != null) {
               var7.field1681.postEvent(new ActionEvent(var8, 1001, "dummy"));
            }
         }
      } catch (Exception var6) {
         class32.method709((String)null, var6);
         this.method2107("crash");
      }

      this.method2121();
   }

   @ObfuscatedName("sn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-580923378"
   )
   void method2097() {
      Container var1 = this.method2170();
      long var2 = class22.method224();
      long var4 = field1780[NPCComposition.field3005];
      field1780[NPCComposition.field3005] = var2;
      NPCComposition.field3005 = 1 + NPCComposition.field3005 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = (32000 + (var6 >> 1)) / var6;
      }

      if(++field1777 - 1 > 50) {
         field1777 -= 50;
         field1776 = true;
         class32.canvas.setSize(XItemContainer.field123, class143.field1999);
         class32.canvas.setVisible(true);
         if(var1 == Tile.field1351) {
            Insets var7 = Tile.field1351.getInsets();
            class32.canvas.setLocation(var7.left + field1774, var7.top + field1775);
         } else {
            class32.canvas.setLocation(field1774, field1775);
         }
      }

      this.vmethod2105();
   }

   public abstract void init();

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field1766 && !field1767) {
         field1776 = true;
         if(null != class45.field904 && class45.field904.startsWith("1.5") && class22.method224() - field1779 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= XItemContainer.field123 && var2.height >= class143.field1999) {
               field1782 = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      field1781 = true;
      field1776 = true;
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-690063341"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   protected abstract void vmethod2105();

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1010859480"
   )
   protected abstract void vmethod2106();

   @ObfuscatedName("sa")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "2137738950"
   )
   protected void method2107(String var1) {
      if(!this.field1783) {
         this.field1783 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   @ObfuscatedName("si")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Dimension;",
      garbageValue = "-39"
   )
   protected Dimension method2108() {
      Container var1 = this.method2170();
      int var2 = Math.max(var1.getWidth(), RSCanvas.field1755);
      int var3 = Math.max(var1.getHeight(), RSCanvas.field1759);
      if(null != Tile.field1351) {
         Insets var4 = Tile.field1351.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.bottom + var4.top;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1583108828"
   )
   protected abstract void vmethod2109();

   @ObfuscatedName("sg")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "4000"
   )
   final synchronized void method2121() {
      if(!field1767) {
         field1767 = true;

         try {
            class32.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod2106();
         } catch (Exception var4) {
            ;
         }

         if(Tile.field1351 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != class63.field1093) {
            try {
               class63.field1093.method1952();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod2109();
      }
   }

   @ObfuscatedName("sh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-448391893"
   )
   void method2125() {
      long var1 = class22.method224();
      long var3 = field1773[class20.field213];
      field1773[class20.field213] = var1;
      class20.field213 = class20.field213 + 1 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class97.field1630 = field1781;
      }

      this.packetHandler();
   }

   public final void focusLost(FocusEvent var1) {
      field1781 = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1373799363"
   )
   protected abstract void vmethod2142();

   public void destroy() {
      if(field1766 == this && !field1767) {
         field1768 = class22.method224();
         class195.method3560(5000L);
         this.method2121();
      }
   }

   public void stop() {
      if(this == field1766 && !field1767) {
         field1768 = class22.method224() + 4000L;
      }
   }

   @ObfuscatedName("su")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-21"
   )
   protected final boolean method2169() {
      String var1 = this.getDocumentBase().getHost().toLowerCase();
      if(!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
         if(!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
            if(!var1.equals("mechscape.com") && !var1.endsWith(".mechscape.com")) {
               if(var1.endsWith("127.0.0.1")) {
                  return true;
               } else {
                  while(var1.length() > 0 && var1.charAt(var1.length() - 1) >= 48 && var1.charAt(var1.length() - 1) <= 57) {
                     var1 = var1.substring(0, var1.length() - 1);
                  }

                  if(var1.endsWith("192.168.1.")) {
                     return true;
                  } else {
                     this.method2107("invalidhost");
                     return false;
                  }
               }
            } else {
               return true;
            }
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   @ObfuscatedName("sc")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-1204670094"
   )
   protected Container method2170() {
      return (Container)(null != Tile.field1351?Tile.field1351:this);
   }
}
