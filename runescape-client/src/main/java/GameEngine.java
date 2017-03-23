import java.applet.Applet;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
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

@ObfuscatedName("dn")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = -1570241849
   )
   protected static int field1782 = 0;
   @ObfuscatedName("qk")
   static boolean field1783 = false;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      longValue = -536266487825698271L
   )
   static long field1784 = 0L;
   @ObfuscatedName("pc")
   static GameEngine field1785 = null;
   @ObfuscatedName("qh")
   boolean field1786 = false;
   @ObfuscatedName("rg")
   public static volatile boolean field1787 = true;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = -698375659
   )
   static int field1788 = 1;
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = 637728447
   )
   @Export("FPS")
   protected static int FPS = 0;
   @ObfuscatedName("qn")
   static long[] field1791 = new long[32];
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = -2034130403
   )
   protected static int field1792 = 0;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = 904288891
   )
   static int field1793 = 0;
   @ObfuscatedName("rn")
   protected static volatile boolean field1794 = false;
   @ObfuscatedName("qv")
   static long[] field1795 = new long[32];
   @ObfuscatedName("rf")
   @ObfuscatedGetter(
      intValue = -1387238309
   )
   static int field1796 = 500;
   @ObfuscatedName("ro")
   protected static boolean field1797 = false;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = 245435579
   )
   static int field1798 = 20;
   @ObfuscatedName("ru")
   @ObfuscatedGetter(
      longValue = 5473854353783659355L
   )
   static volatile long field1799 = 0L;
   @ObfuscatedName("rr")
   static volatile boolean field1800 = true;
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = -1311938613
   )
   protected static int field1802;

   @ObfuscatedName("qa")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "106"
   )
   protected final void method2147(int var1, int var2, int var3) {
      try {
         if(field1785 != null) {
            ++field1793;
            if(field1793 >= 3) {
               this.method2162("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field1785 = this;
         class32.field755 = var1;
         class168.field2207 = var2;
         class101.revision = var3;
         class101.field1680 = this;
         if(class108.field1755 == null) {
            class108.field1755 = new class103();
         }

         class108.field1755.method2004(this, 1);
      } catch (Exception var5) {
         GameObject.method1958((String)null, var5);
         this.method2162("crash");
      }

   }

   @ObfuscatedName("qi")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-29"
   )
   protected final boolean method2149() {
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
                     this.method2162("invalidhost");
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

   public void run() {
      try {
         if(class103.field1700 != null) {
            String var1 = class103.field1700.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class103.field1692;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method2162("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class204.method3835(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(RSSocket.method2121(var4)) {
                     int var5 = FloorUnderlayDefinition.method3548(var4, 10, true);
                     if(var5 < 10) {
                        this.method2162("wrongjava");
                        return;
                     }
                  }
               }

               field1788 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method2196();
         this.vmethod2159();

         Object var9;
         try {
            var9 = new class98();
         } catch (Throwable var7) {
            var9 = new class99();
         }

         FaceNormal.field1590 = (class109)var9;

         while(field1784 == 0L || class45.method867() < field1784) {
            FaceNormal.field1583 = FaceNormal.field1590.vmethod2091(field1798, field1788);

            for(int var6 = 0; var6 < FaceNormal.field1583; ++var6) {
               this.method2150();
            }

            this.method2158();
            class183.method3415(class108.field1755, Projectile.canvas);
         }
      } catch (Exception var8) {
         GameObject.method1958((String)null, var8);
         this.method2162("crash");
      }

      this.method2180();
   }

   @ObfuscatedName("qz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1373336391"
   )
   void method2150() {
      long var1 = class45.method867();
      long var3 = field1795[XClanMember.field293];
      field1795[XClanMember.field293] = var1;
      XClanMember.field293 = XClanMember.field293 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class114.field1803 = field1800;
      }

      this.packetHandler();
   }

   public final void focusGained(FocusEvent var1) {
      field1800 = true;
      field1787 = true;
   }

   public void stop() {
      if(field1785 == this && !field1783) {
         field1784 = class45.method867() + 4000L;
      }
   }

   public void destroy() {
      if(field1785 == this && !field1783) {
         field1784 = class45.method867();
         class115.method2300(5000L);
         this.method2180();
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusLost(FocusEvent var1) {
      field1800 = false;
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("qn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1863437905"
   )
   void method2158() {
      Container var1 = this.method2163();
      long var2 = class45.method867();
      long var4 = field1791[class41.field834];
      field1791[class41.field834] = var2;
      class41.field834 = class41.field834 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var7 = (int)(var2 - var4);
         FPS = ((var7 >> 1) + 32000) / var7;
      }

      if(++field1796 - 1 > 50) {
         field1796 -= 50;
         field1787 = true;
         Projectile.canvas.setSize(class32.field755, class168.field2207);
         Projectile.canvas.setVisible(true);
         if(CollisionData.field1860 == var1) {
            Insets var6 = CollisionData.field1860.getInsets();
            Projectile.canvas.setLocation(var6.left + field1792, field1782 + var6.top);
         } else {
            Projectile.canvas.setLocation(field1792, field1782);
         }
      }

      this.vmethod2161();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   protected abstract void vmethod2159();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2113440280"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "262506472"
   )
   protected abstract void vmethod2161();

   public final synchronized void paint(Graphics var1) {
      if(this == field1785 && !field1783) {
         field1787 = true;
         if(class103.field1692 != null && class103.field1692.startsWith("1.5") && class45.method867() - field1799 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class32.field755 && var2.height >= class168.field2207) {
               field1794 = true;
            }
         }

      }
   }

   @ObfuscatedName("qt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "4672"
   )
   protected void method2162(String var1) {
      if(!this.field1786) {
         this.field1786 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("qx")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "609547159"
   )
   protected Container method2163() {
      return (Container)(CollisionData.field1860 != null?CollisionData.field1860:this);
   }

   @ObfuscatedName("qe")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "1825329222"
   )
   protected Dimension method2164() {
      Container var1 = this.method2163();
      int var2 = Math.max(var1.getWidth(), class40.field831);
      int var3 = Math.max(var1.getHeight(), field1802);
      if(CollisionData.field1860 != null) {
         Insets var4 = CollisionData.field1860.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   public abstract void init();

   @ObfuscatedName("qj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "45"
   )
   final synchronized void method2180() {
      if(!field1783) {
         field1783 = true;

         try {
            Projectile.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod2198();
         } catch (Exception var4) {
            ;
         }

         if(CollisionData.field1860 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != class108.field1755) {
            try {
               class108.field1755.method2001();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod2188();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1046868510"
   )
   protected abstract void vmethod2188();

   @ObfuscatedName("qw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2056945757"
   )
   protected final synchronized void method2196() {
      Container var1 = this.method2163();
      if(Projectile.canvas != null) {
         Projectile.canvas.removeFocusListener(this);
         var1.remove(Projectile.canvas);
      }

      class32.field755 = Math.max(var1.getWidth(), class40.field831);
      class168.field2207 = Math.max(var1.getHeight(), field1802);
      Insets var2;
      if(null != CollisionData.field1860) {
         var2 = CollisionData.field1860.getInsets();
         class32.field755 -= var2.right + var2.left;
         class168.field2207 -= var2.bottom + var2.top;
      }

      Projectile.canvas = new RSCanvas(this);
      var1.add(Projectile.canvas);
      Projectile.canvas.setSize(class32.field755, class168.field2207);
      Projectile.canvas.setVisible(true);
      if(CollisionData.field1860 == var1) {
         var2 = CollisionData.field1860.getInsets();
         Projectile.canvas.setLocation(var2.left + field1792, var2.top + field1782);
      } else {
         Projectile.canvas.setLocation(field1792, field1782);
      }

      Projectile.canvas.addFocusListener(this);
      Projectile.canvas.requestFocus();
      field1787 = true;
      BufferProvider var3 = class5.method69(class32.field755, class168.field2207, Projectile.canvas);
      if(class115.bufferProvider != null) {
         class115.bufferProvider.draw(var3.image.getGraphics(), 0, 0);
      }

      class115.bufferProvider = var3;
      field1794 = false;
      field1799 = class45.method867();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-272138860"
   )
   protected abstract void vmethod2198();

   public void start() {
      if(field1785 == this && !field1783) {
         field1784 = 0L;
      }
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowActivated(WindowEvent var1) {
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1125739403"
   )
   static final void method2242(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = Player.field282.method3908(var0, 250);
      int var6 = Player.field282.method3921(var0, 250) * 13;
      Rasterizer2D.method4007(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2, 0);
      Rasterizer2D.method4013(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
      Player.field282.method3905(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class137.method2541(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);
      if(var1) {
         try {
            Graphics var7 = Projectile.canvas.getGraphics();
            class115.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var8) {
            Projectile.canvas.repaint();
         }
      } else {
         class10.method105(var3, var4, var5, var6);
      }

   }
}
