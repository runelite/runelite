import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public final class class140 implements KeyListener, FocusListener {
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -1806873619
   )
   public static int field2160 = 0;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 1575314623
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks = 0;
   @ObfuscatedName("ce")
   public static boolean[] field2163 = new boolean[112];
   @ObfuscatedName("cp")
   public static int[] field2164 = new int[128];
   @ObfuscatedName("co")
   static char[] field2165 = new char[128];
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 1401859043
   )
   public static int field2166 = 0;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -661216177
   )
   public static int field2167 = 0;
   @ObfuscatedName("cj")
   static int[] field2168 = new int[128];
   @ObfuscatedName("ck")
   public static int[] field2169 = new int[128];
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -1380493265
   )
   public static int field2170 = 0;
   @ObfuscatedName("k")
   @Export("keyboard")
   public static class140 keyboard = new class140();
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -52248791
   )
   public static int field2173 = 0;
   @ObfuscatedName("cl")
   public static int[] field2175 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -1749963169
   )
   public static int field2177 = 0;
   @ObfuscatedName("ec")
   static SpritePixels[] field2179;

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != keyboard) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2175.length) {
            var2 = field2175[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2166 >= 0 && var2 >= 0) {
            field2164[field2166] = var2;
            field2166 = 1 + field2166 & 127;
            if(field2160 == field2166) {
               field2166 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field2177 + 1 & 127;
            if(var3 != field2173) {
               field2168[field2177] = var2;
               field2165[field2177] = 0;
               field2177 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != keyboard) {
         field2166 = -1;
      }

   }

   public final void keyTyped(KeyEvent var1) {
      if(null != keyboard) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label70: {
                  if(var2 != 0) {
                     char[] var4 = class168.field2705;

                     for(int var5 = 0; var5 < var4.length; ++var5) {
                        char var6 = var4[var5];
                        if(var2 == var6) {
                           var3 = true;
                           break label70;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var7 = 1 + field2177 & 127;
               if(field2173 != var7) {
                  field2168[field2177] = -1;
                  field2165[field2177] = var2;
                  field2177 = var7;
               }
            }
         }
      }

      var1.consume();
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(null != keyboard) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2175.length) {
            var2 = field2175[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2166 >= 0 && var2 >= 0) {
            field2164[field2166] = ~var2;
            field2166 = field2166 + 1 & 127;
            if(field2160 == field2166) {
               field2166 = -1;
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "890641920"
   )
   static final int method2959(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class43.method893(var3, var5);
      int var8 = class43.method893(1 + var3, var5);
      int var9 = class43.method893(var3, 1 + var5);
      int var10 = class43.method893(1 + var3, var5 + 1);
      int var11 = class49.method1015(var7, var8, var4, var2);
      int var12 = class49.method1015(var9, var10, var4, var2);
      return class49.method1015(var11, var12, var6, var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BB)Ljava/lang/String;",
      garbageValue = "65"
   )
   public static String method2960(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < var2 + 0; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class164.field2680[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class164.field2680[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class164.field2680[(var6 & 15) << 2 | var7 >>> 6]).append(class164.field2680[var7 & 63]);
            } else {
               var3.append(class164.field2680[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class164.field2680[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIIZI)V",
      garbageValue = "602759602"
   )
   public static void method2961(class170 var0, int var1, int var2, int var3, boolean var4) {
      class186.field3007 = 1;
      class133.field2114 = var0;
      NPC.field794 = var1;
      class116.field2023 = var2;
      class28.field666 = var3;
      class93.field1626 = var4;
      class165.field2689 = 10000;
   }
}
