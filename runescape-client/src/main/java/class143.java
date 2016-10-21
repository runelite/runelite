import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class143 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -872235989
   )
   public static int field2192 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1677147637
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 466497941
   )
   public static volatile int field2194 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 3785745122430269511L
   )
   public static long field2195 = 0L;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1935340997
   )
   public static volatile int field2196 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1375912813
   )
   public static int field2197 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2062192491
   )
   public static int field2198 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1978674009
   )
   public static int field2199 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1615564591
   )
   public static volatile int field2200 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -563178467
   )
   public static volatile int field2201 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -210569133
   )
   public static volatile int field2202 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 2070703150870657335L
   )
   public static volatile long field2203 = 0L;
   @ObfuscatedName("f")
   @Export("mouse")
   public static class143 mouse = new class143();
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2134166365
   )
   public static int field2205 = 0;
   @ObfuscatedName("dp")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2141973007
   )
   public static int field2207 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1173707719
   )
   public static volatile int field2208 = -1;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2201 = var1.getX();
         field2202 = var1.getY();
         field2203 = class11.method139();
         if(var1.isAltDown()) {
            field2200 = 4;
            field2194 = 4;
         } else if(var1.isMetaDown()) {
            field2200 = 2;
            field2194 = 2;
         } else {
            field2200 = 1;
            field2194 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field2194 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field2208 = var1.getX();
         field2196 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field2208 = -1;
         field2196 = -1;
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2208 = var1.getX();
         field2196 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "-356683533"
   )
   public static void method2972(class170 var0) {
      class56.field1208 = var0;
      class56.field1211 = class56.field1208.method3321(16);
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field2194 = 0;
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field2208 = var1.getX();
         field2196 = var1.getY();
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "-323569407"
   )
   static final void method2998(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2656();
            if(var7 == 0) {
               if(var1 == 0) {
                  class5.tileHeights[0][var2][var3] = -ChatLineBuffer.method667(932731 + var2 + var4, 556238 + var3 + var5) * 8;
               } else {
                  class5.tileHeights[var1][var2][var3] = class5.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.method2656();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class5.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class5.tileHeights[var1][var2][var3] = class5.tileHeights[var1 - 1][var2][var3] - 8 * var8;
               }
               break;
            }

            if(var7 <= 49) {
               class177.field2924[var1][var2][var3] = var0.method2534();
               class5.field76[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class5.field80[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class5.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class54.field1144[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2656();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.method2656();
               break;
            }

            if(var7 <= 49) {
               var0.method2656();
            }
         }
      }

   }
}
