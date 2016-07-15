import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public class class143 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("e")
   @Export("mouse")
   public static class143 field2194 = new class143();
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1706928853
   )
   public static volatile int field2196 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1116759599
   )
   static volatile int field2197 = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -120531411
   )
   public static int field2198 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -907835521
   )
   public static int field2199 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -209294319
   )
   @Export("mouseIdleTicks")
   public static volatile int field2200 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 93185481
   )
   public static int field2201 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1720644071
   )
   static volatile int field2203 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 930461619
   )
   static volatile int field2204 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 7742943097353478567L
   )
   static volatile long field2205 = 0L;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -441347367
   )
   static volatile int field2206 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1537050835
   )
   public static int field2207 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -669248693
   )
   public static int field2208 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -684925489863418469L
   )
   public static long field2209 = 0L;
   @ObfuscatedName("s")
   static int[] field2210;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 378875483
   )
   static volatile int field2211 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1242929943
   )
   public static int field2213 = 0;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != field2194) {
         field2200 = 0;
         field2203 = var1.getX();
         field2204 = var1.getY();
         field2205 = client.method424();
         if(var1.isAltDown()) {
            field2206 = 4;
            field2196 = 4;
         } else if(var1.isMetaDown()) {
            field2206 = 2;
            field2196 = 2;
         } else {
            field2206 = 1;
            field2196 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(field2194 != null) {
         field2200 = 0;
         field2196 = 0;
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

   public final synchronized void mouseExited(MouseEvent var1) {
      if(null != field2194) {
         field2200 = 0;
         field2197 = -1;
         field2211 = -1;
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(null != field2194) {
         field2200 = 0;
         field2197 = var1.getX();
         field2211 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(field2194 != null) {
         field2196 = 0;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(null != field2194) {
         field2200 = 0;
         field2197 = var1.getX();
         field2211 = var1.getY();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(field2194 != null) {
         field2200 = 0;
         field2197 = var1.getX();
         field2211 = var1.getY();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-9"
   )
   public static void method3070() {
      class44.field1021.method3835();
      class44.field1022.method3835();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass0;I)V",
      garbageValue = "1020870884"
   )
   static void method3071(class0 var0) {
      class39.method803(var0, 200000);
   }
}
