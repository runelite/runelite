import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FontMetrics;
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

@ObfuscatedName("de")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("qt")
   protected static boolean field1770 = false;
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = -264190681
   )
   static int field1771 = 0;
   @ObfuscatedName("pk")
   @ObfuscatedGetter(
      longValue = 8049989456847018329L
   )
   static long field1772 = 0L;
   @ObfuscatedName("ph")
   static boolean field1773 = false;
   @ObfuscatedName("pj")
   boolean field1774;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 1508750471
   )
   @Export("FPS")
   protected static int FPS = 0;
   @ObfuscatedName("py")
   static GameEngine field1776 = null;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = 364945153
   )
   static int field1777 = 1;
   @ObfuscatedName("qg")
   protected static long[] field1778 = new long[32];
   @ObfuscatedName("qq")
   protected static long[] field1779 = new long[32];
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = -668761709
   )
   protected static int field1780 = 0;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = 1138296665
   )
   protected static int field1781 = 0;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = -60408455
   )
   static int field1782 = 500;
   @ObfuscatedName("qx")
   protected static volatile boolean field1783 = true;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = -1338588555
   )
   static int field1784 = 20;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      longValue = -6585483484785574639L
   )
   static volatile long field1785 = 0L;
   @ObfuscatedName("qp")
   protected static volatile boolean field1786 = false;
   @ObfuscatedName("bf")
   protected static FontMetrics field1787;
   @ObfuscatedName("rd")
   static volatile boolean field1788 = true;

   @ObfuscatedName("rg")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-12"
   )
   protected final void method2049(int var1, int var2, int var3) {
      try {
         if(field1776 != null) {
            ++field1771;
            if(field1771 >= 3) {
               this.method2063("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field1776 = this;
         class16.field186 = var1;
         ChatMessages.field907 = var2;
         class101.field1653 = var3;
         class101.field1652 = this;
         if(null == class22.field252) {
            class22.field252 = new class103();
         }

         class22.field252.method1912(this, 1);
      } catch (Exception var5) {
         NPC.method695((String)null, var5);
         this.method2063("crash");
      }

   }

   @ObfuscatedName("ro")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "875867393"
   )
   protected final synchronized void method2051() {
      Container var1 = this.method2088();
      if(null != class25.canvas) {
         class25.canvas.removeFocusListener(this);
         var1.remove(class25.canvas);
      }

      class16.field186 = Math.max(var1.getWidth(), class155.field2118);
      ChatMessages.field907 = Math.max(var1.getHeight(), class72.field1187);
      Insets var2;
      if(class118.field1855 != null) {
         var2 = class118.field1855.getInsets();
         class16.field186 -= var2.right + var2.left;
         ChatMessages.field907 -= var2.bottom + var2.top;
      }

      class25.canvas = new RSCanvas(this);
      var1.add(class25.canvas);
      class25.canvas.setSize(class16.field186, ChatMessages.field907);
      class25.canvas.setVisible(true);
      if(class118.field1855 == var1) {
         var2 = class118.field1855.getInsets();
         class25.canvas.setLocation(var2.left + field1780, field1781 + var2.top);
      } else {
         class25.canvas.setLocation(field1780, field1781);
      }

      class25.canvas.addFocusListener(this);
      class25.canvas.requestFocus();
      field1783 = true;
      int var3 = class16.field186;
      int var4 = ChatMessages.field907;
      Canvas var5 = class25.canvas;

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

      if(null != class57.bufferProvider) {
         class57.bufferProvider.draw(((BufferProvider)var9).image.getGraphics(), 0, 0);
      }

      class57.bufferProvider = (BufferProvider)var9;
      field1786 = false;
      field1785 = class2.method27();
   }

   @ObfuscatedName("rc")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "49"
   )
   protected final boolean method2052() {
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
                     this.method2063("invalidhost");
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

   @ObfuscatedName("rp")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "60"
   )
   void method2054() {
      long var1 = class2.method27();
      long var3 = field1779[class168.field2196];
      field1779[class168.field2196] = var1;
      class168.field2196 = 1 + class168.field2196 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class49.field956 = field1788;
      }

      this.packetHandler();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1498655735"
   )
   protected abstract void vmethod2055();

   @ObfuscatedName("rw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "92"
   )
   final synchronized void method2056() {
      if(!field1773) {
         field1773 = true;

         try {
            class25.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod2062();
         } catch (Exception var4) {
            ;
         }

         if(class118.field1855 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(class22.field252 != null) {
            try {
               class22.field252.method1931();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod2055();
      }
   }

   public void start() {
      if(field1776 == this && !field1773) {
         field1772 = 0L;
      }
   }

   public void stop() {
      if(field1776 == this && !field1773) {
         field1772 = class2.method27() + 4000L;
      }
   }

   public void destroy() {
      if(field1776 == this && !field1773) {
         field1772 = class2.method27();
         Projectile.method757(5000L);
         this.method2056();
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final synchronized void paint(Graphics var1) {
      if(field1776 == this && !field1773) {
         field1783 = true;
         if(null != class103.field1669 && class103.field1669.startsWith("1.5") && class2.method27() - field1785 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= class16.field186 && var2.height >= ChatMessages.field907) {
               field1786 = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      field1788 = true;
      field1783 = true;
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public abstract void init();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "559281869"
   )
   protected abstract void vmethod2062();

   @ObfuscatedName("re")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "59"
   )
   protected void method2063(String var1) {
      if(!this.field1774) {
         this.field1774 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   public void run() {
      try {
         if(null != class103.field1670) {
            String var1 = class103.field1670.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class103.field1669;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method2063("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class183.method3268(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  boolean var5 = class174.method3153(var4, 10, true);
                  if(var5) {
                     int var6 = ChatMessages.method831(var4, 10, true);
                     if(var6 < 10) {
                        this.method2063("wrongjava");
                        return;
                     }
                  }
               }

               field1777 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method2051();
         this.vmethod2079();
         class101.field1654 = Frames.method1837();

         while(field1772 == 0L || class2.method27() < field1772) {
            class45.field895 = class101.field1654.vmethod1991(field1784, field1777);

            for(int var7 = 0; var7 < class45.field895; ++var7) {
               this.method2054();
            }

            this.method2095();
            Item.method775(class22.field252, class25.canvas);
         }
      } catch (Exception var8) {
         NPC.method695((String)null, var8);
         this.method2063("crash");
      }

      this.method2056();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1666793926"
   )
   protected abstract void vmethod2075();

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-82"
   )
   protected abstract void vmethod2079();

   @ObfuscatedName("rf")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "1090659747"
   )
   protected Dimension method2083() {
      Container var1 = this.method2088();
      int var2 = Math.max(var1.getWidth(), class155.field2118);
      int var3 = Math.max(var1.getHeight(), class72.field1187);
      if(class118.field1855 != null) {
         Insets var4 = class118.field1855.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("rq")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-703980845"
   )
   protected Container method2088() {
      return (Container)(class118.field1855 != null?class118.field1855:this);
   }

   @ObfuscatedName("rt")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method2095() {
      Container var1 = this.method2088();
      long var2 = class2.method27();
      long var4 = field1778[class44.field886];
      field1778[class44.field886] = var2;
      class44.field886 = class44.field886 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = (32000 + (var6 >> 1)) / var6;
      }

      if(++field1782 - 1 > 50) {
         field1782 -= 50;
         field1783 = true;
         class25.canvas.setSize(class16.field186, ChatMessages.field907);
         class25.canvas.setVisible(true);
         if(class118.field1855 == var1) {
            Insets var7 = class118.field1855.getInsets();
            class25.canvas.setLocation(field1780 + var7.left, field1781 + var7.top);
         } else {
            class25.canvas.setLocation(field1780, field1781);
         }
      }

      this.vmethod2075();
   }

   public final void focusLost(FocusEvent var1) {
      field1788 = false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-782581470"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "39410123"
   )
   static final void method2113(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = class84.field1444[var6];
         var12 = class84.field1453[var6];
         var13 = var9 * var12 - var11 * var5 >> 16;
         var10 = var5 * var12 + var11 * var9 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = class84.field1444[var7];
         var12 = class84.field1453[var7];
         var13 = var12 * var8 + var10 * var11 >> 16;
         var10 = var10 * var12 - var11 * var8 >> 16;
         var8 = var13;
      }

      XItemContainer.cameraX = var0 - var8;
      class11.cameraZ = var1 - var9;
      class20.cameraY = var2 - var10;
      class13.cameraPitch = var3;
      class105.cameraYaw = var4;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILRegion;[LCollisionData;I)V",
      garbageValue = "-285244355"
   )
   static final void method2128(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method2735();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.method2735();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var4 == var17 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < 8 + var6) {
               ObjectComposition var21 = class143.getObjectDefinition(var11);
               int var24 = var16 & 7;
               int var25 = var15 & 7;
               int var27 = var21.sizeX;
               int var28 = var21.sizeY;
               int var29;
               if((var20 & 1) == 1) {
                  var29 = var27;
                  var27 = var28;
                  var28 = var29;
               }

               int var26 = var7 & 3;
               int var23;
               if(var26 == 0) {
                  var23 = var24;
               } else if(var26 == 1) {
                  var23 = var25;
               } else if(var26 == 2) {
                  var23 = 7 - var24 - (var27 - 1);
               } else {
                  var23 = 7 - var25 - (var28 - 1);
               }

               var29 = var23 + var2;
               int var30 = var3 + class48.method849(var16 & 7, var15 & 7, var7, var21.sizeX, var21.sizeY, var20);
               if(var29 > 0 && var30 > 0 && var29 < 103 && var30 < 103) {
                  int var31 = var1;
                  if((class10.tileSettings[1][var29][var30] & 2) == 2) {
                     var31 = var1 - 1;
                  }

                  CollisionData var32 = null;
                  if(var31 >= 0) {
                     var32 = var9[var31];
                  }

                  class63.method1105(var1, var29, var30, var11, var7 + var20 & 3, var19, var8, var32);
               }
            }
         }
      }
   }
}
