import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public final class class140 implements KeyListener, FocusListener {
   @ObfuscatedName("cv")
   public static int[] field2156 = new int[128];
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1517364389
   )
   public static int field2159 = 0;
   @ObfuscatedName("cx")
   public static int[] field2160 = new int[128];
   @ObfuscatedName("cl")
   public static boolean[] field2165 = new boolean[112];
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 1833448703
   )
   public static int field2167 = 0;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 207246239
   )
   public static int field2168 = 0;
   @ObfuscatedName("cn")
   static char[] field2169 = new char[128];
   @ObfuscatedName("cf")
   static int[] field2170 = new int[128];
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -1727387989
   )
   public static int field2172 = 0;
   @ObfuscatedName("i")
   @Export("keyboard")
   public static class140 keyboard = new class140();
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -871064089
   )
   public static int field2174 = 0;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 884736215
   )
   public static int field2175 = 0;
   @ObfuscatedName("ct")
   public static int[] field2176 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("bj")
   static class171 field2179;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -405431435
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks = 0;

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != keyboard) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2176.length) {
            var2 = field2176[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2168 >= 0 && var2 >= 0) {
            field2160[field2168] = var2;
            field2168 = field2168 + 1 & 127;
            if(field2167 == field2168) {
               field2168 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field2174 + 1 & 127;
            if(var3 != field2159) {
               field2170[field2174] = var2;
               field2169[field2174] = 0;
               field2174 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2176.length) {
            var2 = field2176[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2168 >= 0 && var2 >= 0) {
            field2160[field2168] = ~var2;
            field2168 = 1 + field2168 & 127;
            if(field2167 == field2168) {
               field2168 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff' && GameEngine.method3089(var2)) {
            int var3 = 1 + field2174 & 127;
            if(var3 != field2159) {
               field2170[field2174] = -1;
               field2169[field2174] = var2;
               field2174 = var3;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != keyboard) {
         field2168 = -1;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[Lclass193;",
      garbageValue = "-176019119"
   )
   public static class193[] method2942() {
      return new class193[]{class193.field3118, class193.field3110, class193.field3115, class193.field3113, class193.field3122, class193.field3121, class193.field3117, class193.field3116, class193.field3111, class193.field3123, class193.field3114, class193.field3112, class193.field3124, class193.field3120, class193.field3119};
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Lclass115;II)Lclass115;",
      garbageValue = "-232077779"
   )
   public static class115 method2957(class115[] var0, int var1) {
      class115[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class115 var4 = var2[var3];
         if(var1 == var4.vmethod3197()) {
            return var4;
         }
      }

      return null;
   }
}
