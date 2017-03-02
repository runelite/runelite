import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("db")
public class class115 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1497476215
   )
   public static volatile int field1795 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -894667937
   )
   public static int field1796 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 728776057
   )
   public static volatile int field1797 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -23107803
   )
   public static int field1798 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 870939093
   )
   public static volatile int field1799 = -1;
   @ObfuscatedName("b")
   @Export("mouse")
   public static class115 mouse = new class115();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1759348643
   )
   public static int field1801 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1905867073
   )
   public static int field1802 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1362296981
   )
   public static volatile int field1803 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -770440453
   )
   public static volatile int field1804 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2123722711
   )
   public static volatile int field1805 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 8625911448981548763L
   )
   public static volatile long field1806 = 0L;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -807420575
   )
   @Export("mouseIdleTicks")
   static volatile int mouseIdleTicks = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -853143893
   )
   public static int field1808 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -658241749
   )
   public static int field1809 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -2009401284947084665L
   )
   public static long field1810 = 0L;

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1804 = var1.getX();
         field1805 = var1.getY();
         field1806 = ChatMessages.method935();
         if(var1.isAltDown()) {
            field1803 = 4;
            field1797 = 4;
         } else if(var1.isMetaDown()) {
            field1803 = 2;
            field1797 = 2;
         } else {
            field1803 = 1;
            field1797 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1795 = -1;
         field1799 = -1;
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1795 = var1.getX();
         field1799 = var1.getY();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1795 = var1.getX();
         field1799 = var1.getY();
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1795 = var1.getX();
         field1799 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field1797 = 0;
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1797 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("b")
   public static final void method2301(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            class105.method2050(var0 - 1L);
            class105.method2050(1L);
         } else {
            class105.method2050(var0);
         }

      }
   }
}
