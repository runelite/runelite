import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dc")
public class class115 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1849167647
   )
   public static int field1811 = 0;
   @ObfuscatedName("f")
   @Export("mouse")
   static class115 mouse = new class115();
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -748841687
   )
   public static int field1813 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1062777405
   )
   static volatile int field1814 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 650175881
   )
   static volatile int field1815 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -6934454371986998873L
   )
   static volatile long field1816 = 0L;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1656095671
   )
   public static int field1817 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 381584175
   )
   public static int field1818 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 305271899
   )
   static volatile int field1819 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -315635181
   )
   static volatile int field1820 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 23467981
   )
   static volatile int field1821 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 782871861
   )
   @Export("mouseIdleTicks")
   static volatile int mouseIdleTicks = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -922634109
   )
   public static int field1823 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1284989949
   )
   public static int field1825 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 2286521883365685577L
   )
   public static long field1826 = 0L;
   @ObfuscatedName("qu")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1399692107
   )
   static volatile int field1829 = 0;

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1820 = var1.getX();
         field1821 = var1.getY();
         field1816 = class45.method867();
         if(var1.isAltDown()) {
            field1819 = 4;
            field1829 = 4;
         } else if(var1.isMetaDown()) {
            field1819 = 2;
            field1829 = 2;
         } else {
            field1819 = 1;
            field1829 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1814 = var1.getX();
         field1815 = var1.getY();
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1814 = var1.getX();
         field1815 = var1.getY();
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1814 = var1.getX();
         field1815 = var1.getY();
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field1829 = 0;
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1814 = -1;
         field1815 = -1;
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1829 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("f")
   public static final void method2300(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var7) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var6) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

   }
}
