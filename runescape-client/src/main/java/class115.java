import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public class class115 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -6807887161151982967L
   )
   public static long field1796 = 0L;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -887618925964779761L
   )
   static volatile long field1797 = 0L;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -596496117
   )
   static volatile int field1798 = 0;
   @ObfuscatedName("n")
   @Export("mouse")
   public static class115 mouse = new class115();
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -47139051
   )
   static volatile int field1800 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1045772707
   )
   public static int field1801 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -328019831
   )
   static volatile int field1802 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 378342499
   )
   static volatile int field1803 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -961091053
   )
   static volatile int field1804 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 998905451
   )
   @Export("mouseIdleTicks")
   static volatile int mouseIdleTicks = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -116489471
   )
   public static int field1806 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1158105625
   )
   static volatile int field1807 = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 611904587
   )
   public static int field1808 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -825154227
   )
   public static int field1809 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1078458213
   )
   public static int field1810 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 104323431
   )
   public static int field1811 = 0;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1802 = var1.getX();
         field1803 = var1.getY();
         field1797 = class202.method3838();
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

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1798 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1807 = var1.getX();
         field1800 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1807 = -1;
         field1800 = -1;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1807 = var1.getX();
         field1800 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1807 = var1.getX();
         field1800 = var1.getY();
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "-1924561354"
   )
   static char method2271(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != mouse) {
         field1798 = 0;
      }

   }
}
