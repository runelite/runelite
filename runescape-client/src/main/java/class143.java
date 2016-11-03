import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public class class143 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("q")
   @Export("mouse")
   public static class143 mouse = new class143();
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1806175963
   )
   public static int field2196 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1542389653
   )
   public static volatile int field2197 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1899035389
   )
   public static volatile int field2198 = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -251988781
   )
   public static int field2199 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 631017937
   )
   public static int field2200 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 3590104797921246589L
   )
   public static volatile long field2201 = 0L;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1434017779
   )
   public static volatile int field2202 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1591896539
   )
   public static volatile int field2203 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1873238509
   )
   public static int field2204 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1827233351
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -216259337
   )
   public static int field2206 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 672477859
   )
   public static int field2207 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 526162075
   )
   public static volatile int field2208 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 6268177508468929491L
   )
   public static long field2209 = 0L;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1173584513
   )
   public static volatile int field2211 = 0;

   public final synchronized void mouseExited(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field2197 = -1;
         field2198 = -1;
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field2211 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2197 = var1.getX();
         field2198 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field2211 = 0;
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field2197 = var1.getX();
         field2198 = var1.getY();
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2197 = var1.getX();
         field2198 = var1.getY();
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)Ljava/lang/String;",
      garbageValue = "59675201"
   )
   public static String method2981(Buffer var0) {
      return Tile.method2352(var0, 32767);
   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field2203 = var1.getX();
         field2208 = var1.getY();
         field2201 = class169.method3276();
         if(var1.isAltDown()) {
            field2202 = 4;
            field2211 = 4;
         } else if(var1.isMetaDown()) {
            field2202 = 2;
            field2211 = 2;
         } else {
            field2202 = 1;
            field2211 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "31"
   )
   public static int method3003(CharSequence var0) {
      return class22.method584(var0, 10, true);
   }
}
