import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public final class class137 implements KeyListener, FocusListener {
   @ObfuscatedName("cu")
   static char[] field2126 = new char[128];
   @ObfuscatedName("co")
   public static boolean[] field2133 = new boolean[112];
   @ObfuscatedName("t")
   @Export("keyboard")
   public static class137 field2137 = new class137();
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 1064430501
   )
   public static int field2139 = 0;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -2136452501
   )
   public static int field2142;
   @ObfuscatedName("cy")
   public static int[] field2143 = new int[128];
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -2007833525
   )
   public static int field2144 = 0;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 1964624245
   )
   public static int field2145 = 0;
   @ObfuscatedName("ck")
   public static int[] field2146 = new int[128];
   @ObfuscatedName("cw")
   static int[] field2147 = new int[128];
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 967923717
   )
   public static int field2148 = 0;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -741814231
   )
   public static int field2149 = 0;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 1180083319
   )
   public static int field2150 = 0;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 2086974983
   )
   @Export("keyboardIdleTicks")
   public static volatile int field2153 = 0;
   @ObfuscatedName("ca")
   static int[] field2154 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != field2137) {
         field2153 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2154.length) {
            var2 = field2154[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2145 >= 0 && var2 >= 0) {
            field2143[field2145] = var2;
            field2145 = 1 + field2145 & 127;
            if(field2148 == field2145) {
               field2145 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = 1 + field2144 & 127;
            if(field2150 != var3) {
               field2147[field2144] = var2;
               field2126[field2144] = 0;
               field2144 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final void keyTyped(KeyEvent var1) {
      if(field2137 != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff' && class31.method676(var2)) {
            int var3 = field2144 + 1 & 127;
            if(field2150 != var3) {
               field2147[field2144] = -1;
               field2126[field2144] = var2;
               field2144 = var3;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(field2137 != null) {
         field2153 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2154.length) {
            var2 = field2154[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2145 >= 0 && var2 >= 0) {
            field2143[field2145] = ~var2;
            field2145 = 1 + field2145 & 127;
            if(field2145 == field2148) {
               field2145 = -1;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != field2137) {
         field2145 = -1;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;ZB)V",
      garbageValue = "92"
   )
   public static void method2896(class167 var0, class167 var1, boolean var2) {
      class211.field3140 = var0;
      class40.field934 = var1;
      class40.field933 = var2;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1503699160"
   )
   static final void method2900(int var0) {
      int[] var1 = class101.field1767.field1409;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = (103 - var3) * 2048 + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class5.field83[var0][var5][var3] & 24) == 0) {
               class214.field3161.method2040(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class5.field83[var0 + 1][var5][var3] & 8) != 0) {
               class214.field3161.method2040(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class101.field1767.method1665();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class5.field83[var0][var6][var5] & 24) == 0) {
               class40.method828(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class5.field83[1 + var0][var6][var5] & 8) != 0) {
               class40.method828(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      client.field310 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class214.field3161.method1899(class32.field754, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class49.method980(var7).field942;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                     int[][] var13 = client.field344[class32.field754].field1906;

                     for(int var14 = 0; var14 < 10; ++var14) {
                        int var15 = (int)(Math.random() * 4.0D);
                        if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                           --var9;
                        }

                        if(var15 == 1 && var9 < 103 && var9 < var5 + 3 && (var13[1 + var9][var10] & 19136896) == 0) {
                           ++var9;
                        }

                        if(var15 == 2 && var10 > 0 && var10 > var6 - 3 && (var13[var9][var10 - 1] & 19136770) == 0) {
                           --var10;
                        }

                        if(var15 == 3 && var10 < 103 && var10 < var6 + 3 && (var13[var9][1 + var10] & 19136800) == 0) {
                           ++var10;
                        }
                     }
                  }

                  client.field464[client.field310] = class75.field1379[var8];
                  client.field411[client.field310] = var9;
                  client.field492[client.field310] = var10;
                  ++client.field310;
               }
            }
         }
      }

      class96.field1646.method1658();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "-58"
   )
   static final byte[] method2904(byte[] var0) {
      class119 var1 = new class119(var0);
      int var2 = var1.method2494();
      int var3 = var1.method2505();
      if(var3 >= 0 && (class167.field2700 == 0 || var3 <= class167.field2700)) {
         if(var2 == 0) {
            byte[] var4 = new byte[var3];
            var1.method2479(var4, 0, var3);
            return var4;
         } else {
            int var6 = var1.method2505();
            if(var6 < 0 || class167.field2700 != 0 && var6 > class167.field2700) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var6];
               if(var2 == 1) {
                  class117.method2440(var5, var6, var0, var3, 9);
               } else {
                  class167.field2706.method2412(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }
}
