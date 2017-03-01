import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public class class115 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1804336787
   )
   public static volatile int field1799 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -491023629
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -952424519
   )
   public static volatile int field1801 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1824749711
   )
   public static int field1802 = 0;
   @ObfuscatedName("n")
   @Export("mouse")
   public static class115 mouse = new class115();
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 573316163
   )
   public static volatile int field1804 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 771996831
   )
   public static int field1805 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -486317005
   )
   public static int field1806 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1887072837
   )
   public static volatile int field1807 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -208068727
   )
   public static volatile int field1808 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1001291911
   )
   public static volatile int field1809 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -8380702662899762015L
   )
   public static volatile long field1810 = 0L;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -915382315
   )
   public static int field1811 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1596320571
   )
   public static int field1812 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1917643703
   )
   public static int field1813 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -9049085113200714445L
   )
   public static long field1814 = 0L;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = -1982792481
   )
   static int field1815;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1808 = var1.getX();
         field1809 = var1.getY();
         field1810 = WallObject.method1985();
         if(var1.isAltDown()) {
            field1804 = 4;
            field1801 = 4;
         } else if(var1.isMetaDown()) {
            field1804 = 2;
            field1801 = 2;
         } else {
            field1804 = 1;
            field1801 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1801 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1799 = var1.getX();
         field1807 = var1.getY();
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1799 = var1.getX();
         field1807 = var1.getY();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1799 = var1.getX();
         field1807 = var1.getY();
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != mouse) {
         field1801 = 0;
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1799 = -1;
         field1807 = -1;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2034801023"
   )
   static int method2329(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2437((long)var0);
      return null == var2?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-797430407"
   )
   static void method2330(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      class181 var4 = (class181)class185.field2754.method2437(var2);
      if(null != var4) {
         class185.field2756.method2390(var4);
      }
   }
}
