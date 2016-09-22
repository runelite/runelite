import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ej")
public final class class140 implements KeyListener, FocusListener {
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 230540117
   )
   public static int field2174 = 0;
   @ObfuscatedName("a")
   @Export("keyboard")
   public static class140 keyboard = new class140();
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 842690037
   )
   static int field2185 = 0;
   @ObfuscatedName("cz")
   public static boolean[] field2190 = new boolean[112];
   @ObfuscatedName("ct")
   static int[] field2191 = new int[128];
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 1922086165
   )
   static int field2192 = 0;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1019919421
   )
   public static int field2193 = 0;
   @ObfuscatedName("cp")
   static char[] field2194 = new char[128];
   @ObfuscatedName("cc")
   static int[] field2195 = new int[128];
   @ObfuscatedName("cl")
   public static int[] field2196 = new int[128];
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 1590446267
   )
   static int field2197 = 0;
   @ObfuscatedName("cv")
   public static int[] field2199 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = -1129806461
   )
   @Export("keyboardIdleTicks")
   static volatile int keyboardIdleTicks = 0;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 711467229
   )
   static int field2202 = 0;

   public final synchronized void keyReleased(KeyEvent var1) {
      if(null != keyboard) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2199.length) {
            var2 = field2199[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2193 >= 0 && var2 >= 0) {
            field2191[field2193] = ~var2;
            field2193 = 1 + field2193 & 127;
            if(field2193 == field2192) {
               field2193 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != keyboard) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2199.length) {
            var2 = field2199[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2193 >= 0 && var2 >= 0) {
            field2191[field2193] = var2;
            field2193 = field2193 + 1 & 127;
            if(field2192 == field2193) {
               field2193 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field2202 + 1 & 127;
            if(field2185 != var3) {
               field2195[field2202] = var2;
               field2194[field2202] = 0;
               field2202 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != keyboard) {
         field2193 = -1;
      }

   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff' && class47.method991(var2)) {
            int var3 = 1 + field2202 & 127;
            if(field2185 != var3) {
               field2195[field2202] = -1;
               field2194[field2202] = var2;
               field2202 = var3;
            }
         }
      }

      var1.consume();
   }
}
