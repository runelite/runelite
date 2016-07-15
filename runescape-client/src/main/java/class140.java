import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public final class class140 implements KeyListener, FocusListener {
   @ObfuscatedName("e")
   @Export("keyboard")
   public static class140 field2155 = new class140();
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 787907137
   )
   public static int field2156 = 0;
   @ObfuscatedName("ct")
   public static boolean[] field2160 = new boolean[112];
   @ObfuscatedName("cq")
   public static int[] field2166 = new int[128];
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 618097437
   )
   public static int field2167 = 0;
   @ObfuscatedName("ci")
   static char[] field2169 = new char[128];
   @ObfuscatedName("cw")
   static int[] field2170 = new int[128];
   @ObfuscatedName("cy")
   public static int[] field2171 = new int[128];
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1807967917
   )
   public static int field2172 = 0;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -1979343357
   )
   public static int field2173 = 0;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -993330811
   )
   public static int field2174 = 0;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -830113675
   )
   public static int field2175 = 0;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 957177751
   )
   @Export("keyboardIdleTicks")
   public static volatile int field2176 = 0;
   @ObfuscatedName("cj")
   static int[] field2177 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != field2155) {
         field2176 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2177.length) {
            var2 = field2177[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2156 >= 0 && var2 >= 0) {
            field2166[field2156] = var2;
            field2156 = 1 + field2156 & 127;
            if(field2167 == field2156) {
               field2156 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = 1 + field2174 & 127;
            if(field2173 != var3) {
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
      if(null != field2155) {
         field2176 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2177.length) {
            var2 = field2177[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2156 >= 0 && var2 >= 0) {
            field2166[field2156] = ~var2;
            field2156 = 1 + field2156 & 127;
            if(field2156 == field2167) {
               field2156 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != field2155) {
         field2156 = -1;
      }

   }

   public final void keyTyped(KeyEvent var1) {
      if(null != field2155) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label71: {
                  if(var2 != 0) {
                     char[] var7 = class168.field2699;

                     for(int var5 = 0; var5 < var7.length; ++var5) {
                        char var6 = var7[var5];
                        if(var2 == var6) {
                           var3 = true;
                           break label71;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var4 = field2174 + 1 & 127;
               if(var4 != field2173) {
                  field2170[field2174] = -1;
                  field2169[field2174] = var2;
                  field2174 = var4;
               }
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "413715547"
   )
   public static boolean method3024(char var0) {
      return var0 >= 48 && var0 <= 57;
   }
}
