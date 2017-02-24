import java.awt.datatransfer.Clipboard;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class115 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1651938133
   )
   public static int field1792 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1004915497
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1085691767
   )
   public static int field1794 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1002171183
   )
   public static volatile int field1795 = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1303006513
   )
   public static int field1796 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1324229093
   )
   public static volatile int field1797 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1650991597
   )
   public static int field1799 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1805633631
   )
   public static volatile int field1800 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1986849573
   )
   public static volatile int field1801 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1351610121
   )
   public static volatile int field1802 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -2257201929765624065L
   )
   public static volatile long field1803 = 0L;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 511449347
   )
   public static int field1804 = 0;
   @ObfuscatedName("mo")
   static byte field1805;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 994424001
   )
   public static int field1806 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -5547707588586175639L
   )
   public static long field1807 = 0L;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1376285333
   )
   public static volatile int field1809 = 0;
   @ObfuscatedName("pj")
   static Clipboard field1810;
   @ObfuscatedName("q")
   @Export("mouse")
   public static class115 mouse = new class115();

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1801 = var1.getX();
         field1797 = var1.getY();
         field1803 = class0.method11();
         if(var1.isAltDown()) {
            field1800 = 4;
            field1809 = 4;
         } else if(var1.isMetaDown()) {
            field1800 = 2;
            field1809 = 2;
         } else {
            field1800 = 1;
            field1809 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1809 = 0;
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
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1795 = -1;
         field1802 = -1;
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1795 = var1.getX();
         field1802 = var1.getY();
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field1809 = 0;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1795 = var1.getX();
         field1802 = var1.getY();
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1795 = var1.getX();
         field1802 = var1.getY();
      }

   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "14690457"
   )
   @Export("addMenuEntry")
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      GroundObject.method1595(var0, var1, var2, var3, var4, var5, false);
   }

   @ObfuscatedName("q")
   public static final void method2292(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            class112.method2147(var0 - 1L);
            class112.method2147(1L);
         } else {
            class112.method2147(var0);
         }

      }
   }
}
