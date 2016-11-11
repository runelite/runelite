import java.awt.Container;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class143 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 6298244608262342681L
   )
   public static long field2198 = 0L;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 874749667
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -13062541
   )
   public static volatile int field2200 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1774142159
   )
   public static volatile int field2201 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1249307875
   )
   public static volatile int field2202 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 420116239
   )
   public static int field2203 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2112711067
   )
   public static int field2204 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1993582027
   )
   public static volatile int field2205 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -920372697
   )
   public static int field2206 = 0;
   @ObfuscatedName("i")
   @Export("mouse")
   public static class143 mouse = new class143();
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1452220333
   )
   public static volatile int field2208 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -2576548740352855429L
   )
   public static volatile long field2209 = 0L;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -89917761
   )
   public static int field2210 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 109269405
   )
   public static int field2211 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 997557345
   )
   public static int field2212 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1328123093
   )
   public static volatile int field2213 = 0;

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2201 = var1.getX();
         field2202 = var1.getY();
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2213 = var1.getX();
         field2208 = var1.getY();
         field2209 = class34.method738();
         if(var1.isAltDown()) {
            field2200 = 4;
            field2205 = 4;
         } else if(var1.isMetaDown()) {
            field2200 = 2;
            field2205 = 2;
         } else {
            field2200 = 1;
            field2205 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1685597731"
   )
   public static int method2984(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2201 = var1.getX();
         field2202 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2201 = -1;
         field2202 = -1;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field2201 = var1.getX();
         field2202 = var1.getY();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(CS)Z",
      garbageValue = "67"
   )
   static final boolean method2985(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else {
         boolean var1 = var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
         if(var1) {
            return true;
         } else {
            char[] var2 = class167.field2701;

            int var3;
            char var4;
            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3];
               if(var4 == var0) {
                  return true;
               }
            }

            var2 = class167.field2704;

            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3];
               if(var0 == var4) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass23;",
      garbageValue = "-1352408235"
   )
   static class23 method3004(int var0) {
      class23 var1 = (class23)class23.field621.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class116.field2015.method3292(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new class23();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 12;
            int var4 = var3.method2549();
            var1.field619 = var3.method2546();
            var1.field620 = var3.method2546();
            var1.field618 = var3.method2546();
            var1.field623 = var3.method2546();
            var3.offset = 0;
            var3.method2532();
            var1.field615 = new int[var4];
            var1.field617 = new int[var4];
            var1.field622 = new String[var4];

            int var6;
            for(int var5 = 0; var3.offset < var3.payload.length - 12; var1.field615[var5++] = var6) {
               var6 = var3.method2546();
               if(var6 == 3) {
                  var1.field622[var5] = var3.method2552();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field617[var5] = var3.method2549();
               } else {
                  var1.field617[var5] = var3.method2544();
               }
            }

            class23.field621.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "35"
   )
   static void method3010() {
      Client var0 = class168.field2706;
      synchronized(class168.field2706) {
         Container var1 = class168.field2706.method3081();
         if(var1 != null) {
            class116.field2012 = Math.max(var1.getSize().width, class116.field2014);
            class18.field276 = Math.max(var1.getSize().height, class130.field2102);
            if(var1 == class0.field15) {
               Insets var2 = class0.field15.getInsets();
               class116.field2012 -= var2.right + var2.left;
               class18.field276 -= var2.top + var2.bottom;
            }

            if(class116.field2012 <= 0) {
               class116.field2012 = 1;
            }

            if(class18.field276 <= 0) {
               class18.field276 = 1;
            }

            int var5 = Client.isResized?2:1;
            if(var5 == 1) {
               class62.field1267 = Client.field515;
               class77.field1428 = Client.field315 * 503;
            } else {
               class62.field1267 = Math.min(class116.field2012, 7680);
               class77.field1428 = Math.min(class18.field276, 2160);
            }

            GameEngine.field2241 = (class116.field2012 - class62.field1267) / 2;
            GameEngine.field2252 = 0;
            class164.canvas.setSize(class62.field1267, class77.field1428);
            class220.bufferProvider = class47.method980(class62.field1267, class77.field1428, class164.canvas);
            if(class0.field15 == var1) {
               Insets var3 = class0.field15.getInsets();
               class164.canvas.setLocation(var3.left + GameEngine.field2241, GameEngine.field2252 + var3.top);
            } else {
               class164.canvas.setLocation(GameEngine.field2241, GameEngine.field2252);
            }

            ItemLayer.method2243();
            if(Client.widgetRoot != -1) {
               BufferProvider.method1732(true);
            }

            Buffer.method2743();
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-47"
   )
   public static boolean method3011(char var0) {
      return var0 >= 48 && var0 <= 57;
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field2205 = 0;
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field2205 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }
}
