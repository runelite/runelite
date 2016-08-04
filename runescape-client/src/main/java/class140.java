import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public final class class140 implements KeyListener, FocusListener {
   @ObfuscatedName("co")
   static int[] field2155 = new int[128];
   @ObfuscatedName("l")
   @Export("keyboard")
   public static class140 field2157 = new class140();
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -189681713
   )
   public static int field2159 = 0;
   @ObfuscatedName("ct")
   public static int[] field2161 = new int[128];
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -2054548289
   )
   public static int field2168 = 0;
   @ObfuscatedName("cy")
   public static boolean[] field2171 = new boolean[112];
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -1494859861
   )
   public static int field2173 = 0;
   @ObfuscatedName("cj")
   static char[] field2175 = new char[128];
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 1800388443
   )
   public static int field2178 = 0;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 1740150079
   )
   public static int field2179 = 0;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -727454407
   )
   public static int field2180 = 0;
   @ObfuscatedName("cs")
   public static int[] field2181 = new int[128];
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 985856869
   )
   @Export("keyboardIdleTicks")
   public static volatile int field2182 = 0;
   @ObfuscatedName("cd")
   static int[] field2183 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1117461677
   )
   public static int field2184;

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "202205226"
   )
   static final int method3052(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & 16711935) * var3 + var2 * (var1 & 16711935) & -16711936) + (var2 * (var1 & '\uff00') + var3 * (var0 & '\uff00') & 16711680) >> 8;
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != field2157) {
         field2182 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2183.length) {
            var2 = field2183[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2168 >= 0 && var2 >= 0) {
            field2181[field2168] = var2;
            field2168 = field2168 + 1 & 127;
            if(field2173 == field2168) {
               field2168 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = 1 + field2180 & 127;
            if(var3 != field2179) {
               field2155[field2180] = var2;
               field2175[field2180] = 0;
               field2180 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final void keyTyped(KeyEvent var1) {
      if(field2157 != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label70: {
                  if(var2 != 0) {
                     char[] var7 = class168.field2718;

                     for(int var5 = 0; var5 < var7.length; ++var5) {
                        char var6 = var7[var5];
                        if(var6 == var2) {
                           var3 = true;
                           break label70;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var4 = field2180 + 1 & 127;
               if(field2179 != var4) {
                  field2155[field2180] = -1;
                  field2175[field2180] = var2;
                  field2180 = var4;
               }
            }
         }
      }

      var1.consume();
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(field2157 != null) {
         field2182 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2183.length) {
            var2 = field2183[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2168 >= 0 && var2 >= 0) {
            field2181[field2168] = ~var2;
            field2168 = field2168 + 1 & 127;
            if(field2173 == field2168) {
               field2168 = -1;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(field2157 != null) {
         field2168 = -1;
      }

   }
}
