import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public class class115 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 6635026687705576721L
   )
   public static long field1799 = 0L;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1314701209
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1045915553
   )
   public static volatile int field1801 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -974314927
   )
   public static volatile int field1802 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1070112099
   )
   public static volatile int field1803 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1143202487
   )
   public static int field1804 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -838092083
   )
   public static int field1805 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1729744697
   )
   public static volatile int field1806 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1582900949
   )
   public static volatile int field1807 = 0;
   @ObfuscatedName("p")
   @Export("mouse")
   public static class115 mouse = new class115();
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -42885927
   )
   public static volatile int field1809 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -8503308870490456179L
   )
   public static volatile long field1810 = 0L;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 305375247
   )
   public static int field1811 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 942486457
   )
   public static int field1812 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 407917603
   )
   public static int field1813 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1881506773
   )
   public static int field1814 = 0;
   @ObfuscatedName("pv")
   static short[] field1815;

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1801 = var1.getX();
         field1809 = var1.getY();
         field1810 = FrameMap.method1695();
         if(var1.isAltDown()) {
            field1807 = 4;
            field1806 = 4;
         } else if(var1.isMetaDown()) {
            field1807 = 2;
            field1806 = 2;
         } else {
            field1807 = 1;
            field1806 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1802 = -1;
         field1803 = -1;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1802 = var1.getX();
         field1803 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field1806 = 0;
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1802 = var1.getX();
         field1803 = var1.getY();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1806 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1802 = var1.getX();
         field1803 = var1.getY();
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;B)V",
      garbageValue = "21"
   )
   public static void method2239(class182 var0, class182 var1, class182 var2) {
      class196.field2865 = var0;
      class196.field2878 = var1;
      class196.field2883 = var2;
   }
}
