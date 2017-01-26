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

@ObfuscatedName("dz")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 394243569
   )
   protected static int field1770;
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      longValue = -7989380841261842105L
   )
   static long field1771 = 0L;
   @ObfuscatedName("pr")
   static boolean field1772 = false;
   @ObfuscatedName("qu")
   protected static long[] field1773 = new long[32];
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = -1214779879
   )
   static int field1774 = 0;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = -267340823
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("py")
   boolean field1777 = false;
   @ObfuscatedName("qi")
   protected static long[] field1778 = new long[32];
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 217297303
   )
   protected static int field1779 = 0;
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = -126138865
   )
   protected static int field1780 = 0;
   @ObfuscatedName("qp")
   public static volatile boolean field1781 = true;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = 914001919
   )
   static int field1782 = 500;
   @ObfuscatedName("qz")
   protected static boolean field1783 = false;
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = 1097008297
   )
   static int field1784 = 1;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      longValue = -2282103983929324903L
   )
   static volatile long field1785 = 0L;
   @ObfuscatedName("rx")
   static volatile boolean field1786 = true;
   @ObfuscatedName("qy")
   protected static volatile boolean field1787 = false;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = 954675249
   )
   @Export("FPS")
   protected static int FPS = 0;
   @ObfuscatedName("pb")
   static GameEngine field1789 = null;
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      intValue = 178251409
   )
   static int field1790 = 20;

   @ObfuscatedName("qi")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "213226758"
   )
   protected final void method2102(int var1, int var2, int var3) {
      try {
         if(null != field1789) {
            ++field1774;
            if(field1774 >= 3) {
               this.method2116("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field1789 = this;
         class26.field577 = var1;
         class187.field2776 = var2;
         class101.field1654 = var3;
         class101.field1658 = this;
         if(class45.field899 == null) {
            class45.field899 = new class103();
         }

         class45.field899.method1968(this, 1);
      } catch (Exception var5) {
         class65.method1151((String)null, var5);
         this.method2116("crash");
      }

   }

   @ObfuscatedName("qk")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-316621223"
   )
   protected final boolean method2104() {
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
                     this.method2116("invalidhost");
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

   @ObfuscatedName("qj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "18"
   )
   void method2106() {
      long var1 = FrameMap.method1695();
      long var3 = field1778[class6.field61];
      field1778[class6.field61] = var1;
      class6.field61 = class6.field61 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class177.field2668 = field1786;
      }

      this.packetHandler();
   }

   @ObfuscatedName("ql")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "55"
   )
   void method2107() {
      Container var1 = this.method2114();
      long var2 = FrameMap.method1695();
      long var4 = field1773[class31.field712];
      field1773[class31.field712] = var2;
      class31.field712 = 1 + class31.field712 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = (32000 + (var6 >> 1)) / var6;
      }

      if(++field1782 - 1 > 50) {
         field1782 -= 50;
         field1781 = true;
         class157.canvas.setSize(class26.field577, class187.field2776);
         class157.canvas.setVisible(true);
         if(var1 == class15.field163) {
            Insets var7 = class15.field163.getInsets();
            class157.canvas.setLocation(field1779 + var7.left, field1780 + var7.top);
         } else {
            class157.canvas.setLocation(field1779, field1780);
         }
      }

      this.vmethod2111();
   }

   @ObfuscatedName("qm")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   final synchronized void method2108() {
      if(!field1772) {
         field1772 = true;

         try {
            class157.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod2115();
         } catch (Exception var4) {
            ;
         }

         if(null != class15.field163) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != class45.field899) {
            try {
               class45.field899.method1948();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod2119();
      }
   }

   public void stop() {
      if(this == field1789 && !field1772) {
         field1771 = FrameMap.method1695() + 4000L;
      }
   }

   public void start() {
      if(this == field1789 && !field1772) {
         field1771 = 0L;
      }
   }

   public void run() {
      try {
         int var3;
         if(null != class103.field1671) {
            String var1 = class103.field1671.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class103.field1678;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method2116("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  for(var3 = 6; var3 < var2.length() && Tile.method1551(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(class44.method803(var4) && class205.method3806(var4) < 10) {
                     this.method2116("wrongjava");
                     return;
                  }
               }

               field1784 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method2137();
         this.vmethod2112();
         class159.field2127 = class105.method2002();

         label77:
         while(true) {
            class103 var7;
            Canvas var8;
            do {
               if(0L != field1771 && FrameMap.method1695() >= field1771) {
                  break label77;
               }

               class33.field740 = class159.field2127.vmethod2041(field1790, field1784);

               for(int var5 = 0; var5 < class33.field740; ++var5) {
                  this.method2106();
               }

               this.method2107();
               var7 = class45.field899;
               var8 = class157.canvas;
            } while(null == var7.field1674);

            for(var3 = 0; var3 < 50 && var7.field1674.peekEvent() != null; ++var3) {
               class104.method1988(1L);
            }

            if(var8 != null) {
               var7.field1674.postEvent(new ActionEvent(var8, 1001, "dummy"));
            }
         }
      } catch (Exception var6) {
         class65.method1151((String)null, var6);
         this.method2116("crash");
      }

      this.method2108();
   }

   public final synchronized void paint(Graphics var1) {
      if(field1789 == this && !field1772) {
         field1781 = true;
         if(class103.field1678 != null && class103.field1678.startsWith("1.5") && FrameMap.method1695() - field1785 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= class26.field577 && var2.height >= class187.field2776) {
               field1787 = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      field1786 = true;
      field1781 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field1786 = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "352057780"
   )
   protected abstract void vmethod2111();

   public final void windowOpened(WindowEvent var1) {
   }

   public abstract void init();

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-684342026"
   )
   protected abstract void vmethod2112();

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-8"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("qe")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Container;",
      garbageValue = "-55"
   )
   protected Container method2114() {
      return (Container)(class15.field163 != null?class15.field163:this);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-35"
   )
   protected abstract void vmethod2115();

   @ObfuscatedName("qo")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "1"
   )
   protected void method2116(String var1) {
      if(!this.field1777) {
         this.field1777 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("qt")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "-1706506797"
   )
   protected Dimension method2118() {
      Container var1 = this.method2114();
      int var2 = Math.max(var1.getWidth(), field1770);
      int var3 = Math.max(var1.getHeight(), class97.field1637);
      if(class15.field163 != null) {
         Insets var4 = class15.field163.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "436819917"
   )
   protected abstract void vmethod2119();

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("qv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   protected final synchronized void method2137() {
      Container var1 = this.method2114();
      if(null != class157.canvas) {
         class157.canvas.removeFocusListener(this);
         var1.remove(class157.canvas);
      }

      class26.field577 = Math.max(var1.getWidth(), field1770);
      class187.field2776 = Math.max(var1.getHeight(), class97.field1637);
      Insets var2;
      if(class15.field163 != null) {
         var2 = class15.field163.getInsets();
         class26.field577 -= var2.right + var2.left;
         class187.field2776 -= var2.bottom + var2.top;
      }

      class157.canvas = new RSCanvas(this);
      var1.add(class157.canvas);
      class157.canvas.setSize(class26.field577, class187.field2776);
      class157.canvas.setVisible(true);
      if(class15.field163 == var1) {
         var2 = class15.field163.getInsets();
         class157.canvas.setLocation(var2.left + field1779, var2.top + field1780);
      } else {
         class157.canvas.setLocation(field1779, field1780);
      }

      class157.canvas.addFocusListener(this);
      class157.canvas.requestFocus();
      field1781 = true;
      int var3 = class26.field577;
      int var4 = class187.field2776;
      Canvas var5 = class157.canvas;

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

      if(class57.bufferProvider != null) {
         class57.bufferProvider.draw(((BufferProvider)var9).image.getGraphics(), 0, 0);
      }

      class57.bufferProvider = (BufferProvider)var9;
      field1787 = false;
      field1785 = FrameMap.method1695();
   }

   public void destroy() {
      if(field1789 == this && !field1772) {
         field1771 = FrameMap.method1695();
         class104.method1988(5000L);
         this.method2108();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2137421760"
   )
   public static int method2193(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "-2008865859"
   )
   static boolean method2194(String var0, boolean var1) {
      if(null == var0) {
         return false;
      } else {
         String var2 = FrameMap.method1697(var0, FaceNormal.field1561);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(FrameMap.method1697(Client.friends[var3].name, FaceNormal.field1561)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(FrameMap.method1697(class16.localPlayer.name, FaceNormal.field1561))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-110"
   )
   public static int method2195(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1169422943"
   )
   public static void method2196() {
      FloorUnderlayDefinition.field2806.reset();
   }
}
