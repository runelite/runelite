import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public class class115 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 687858089
   )
   public static int field1796 = 0;
   @ObfuscatedName("s")
   @Export("mouse")
   public static class115 mouse = new class115();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 948246849
   )
   public static volatile int field1798 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1415218283
   )
   public static volatile int field1799 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1516273741
   )
   public static volatile int field1800 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -476911407
   )
   public static int field1801 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1036918637
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1180922193
   )
   public static int field1803 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -180709479
   )
   public static volatile int field1804 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -7686707105259146319L
   )
   public static volatile long field1805 = 0L;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1694870589
   )
   public static volatile int field1806 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1974852359
   )
   public static int field1807 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2047875659
   )
   public static volatile int field1808 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1876513025
   )
   public static int field1809 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -551918433
   )
   public static int field1810 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -8713727678770825245L
   )
   public static long field1811 = 0L;
   @ObfuscatedName("d")
   public static String field1812;

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1799 = var1.getX();
         field1800 = var1.getY();
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1808 = var1.getX();
         field1806 = var1.getY();
         field1805 = class2.method27();
         if(var1.isAltDown()) {
            field1804 = 4;
            field1798 = 4;
         } else if(var1.isMetaDown()) {
            field1804 = 2;
            field1798 = 2;
         } else {
            field1804 = 1;
            field1798 = 1;
         }
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

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1799 = var1.getX();
         field1800 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1799 = -1;
         field1800 = -1;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1799 = var1.getX();
         field1800 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != mouse) {
         field1798 = 0;
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1798 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/String;",
      garbageValue = "-52"
   )
   public static String method2169(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = class156.method2942(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
