import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public final class class140 implements KeyListener, FocusListener {
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1711407395
   )
   static int field2150 = 0;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -290048431
   )
   @Export("keyboardIdleTicks")
   static volatile int keyboardIdleTicks = 0;
   @ObfuscatedName("s")
   @Export("keyboard")
   static class140 keyboard = new class140();
   @ObfuscatedName("cu")
   public static int[] field2156 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("co")
   public static boolean[] field2157 = new boolean[112];
   @ObfuscatedName("ce")
   static int[] field2158 = new int[128];
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -1044085847
   )
   static int field2159 = 0;
   @ObfuscatedName("cr")
   static char[] field2161 = new char[128];
   @ObfuscatedName("cq")
   static int[] field2162 = new int[128];
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -1611668547
   )
   public static int field2164 = 0;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 1867211755
   )
   static int field2165 = 0;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 49707033
   )
   static int field2166 = 0;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 1825498639
   )
   static int field2167 = 0;
   @ObfuscatedName("cf")
   public static int[] field2168 = new int[128];

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2156.length) {
            var2 = field2156[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2150 >= 0 && var2 >= 0) {
            field2158[field2150] = var2;
            field2150 = field2150 + 1 & 127;
            if(field2159 == field2150) {
               field2150 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field2166 + 1 & 127;
            if(var3 != field2165) {
               field2162[field2166] = var2;
               field2161[field2166] = 0;
               field2166 = var3;
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
         if(var2 >= 0 && var2 < field2156.length) {
            var2 = field2156[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2150 >= 0 && var2 >= 0) {
            field2158[field2150] = ~var2;
            field2150 = field2150 + 1 & 127;
            if(field2150 == field2159) {
               field2150 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void keyTyped(KeyEvent var1) {
      if(null != keyboard) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label71: {
                  if(var2 != 0) {
                     char[] var4 = class168.field2709;

                     for(int var5 = 0; var5 < var4.length; ++var5) {
                        char var6 = var4[var5];
                        if(var6 == var2) {
                           var3 = true;
                           break label71;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var7 = field2166 + 1 & 127;
               if(var7 != field2165) {
                  field2162[field2166] = -1;
                  field2161[field2166] = var2;
                  field2166 = var7;
               }
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(CIB)C",
      garbageValue = "46"
   )
   static char method2900(char var0, int var1) {
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
      if(null != keyboard) {
         field2150 = -1;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass178;I)V",
      garbageValue = "246674736"
   )
   static final void method2919(int var0, int var1, int var2, int var3, SpritePixels var4, class178 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapScale + Client.mapAngle & 2047;
         int var8 = class94.field1631[var7];
         int var9 = class94.field1621[var7];
         var8 = 256 * var8 / (256 + Client.mapScaleDelta);
         var9 = 256 * var9 / (Client.mapScaleDelta + 256);
         int var10 = var2 * var9 + var8 * var3 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class169.field2716.method1724(var0 + 94 + var14 + 4 - 10, 83 + var1 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         TextureProvider.method2172(var0, var1, var2, var3, var4, var5);
      }

   }
}
