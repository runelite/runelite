import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public final class class137 implements KeyListener, FocusListener {
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = -195423151
   )
   public static int field2093 = 0;
   @ObfuscatedName("cw")
   public static int[] field2099 = new int[128];
   @ObfuscatedName("cs")
   public static int[] field2102 = new int[128];
   @ObfuscatedName("cr")
   public static boolean[] field2103 = new boolean[112];
   @ObfuscatedName("e")
   public static class137 field2104 = new class137();
   @ObfuscatedName("cc")
   static char[] field2107 = new char[128];
   @ObfuscatedName("cu")
   static int[] field2108 = new int[128];
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 1524101775
   )
   public static int field2109 = 0;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 966152059
   )
   public static int field2111 = 0;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 172351709
   )
   public static int field2112 = 0;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -1444848373
   )
   public static volatile int field2114 = 0;
   @ObfuscatedName("cp")
   public static int[] field2115 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -1235975787
   )
   public static int field2116 = 0;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 1365849923
   )
   public static int field2119 = 0;

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != field2104) {
         field2114 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2115.length) {
            var2 = field2115[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2111 >= 0 && var2 >= 0) {
            field2099[field2111] = var2;
            field2111 = 1 + field2111 & 127;
            if(field2116 == field2111) {
               field2111 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = 1 + field2112 & 127;
            if(field2093 != var3) {
               field2108[field2112] = var2;
               field2107[field2112] = 0;
               field2112 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || 85 == var2 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final void keyTyped(KeyEvent var1) {
      if(field2104 != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && '\uffff' != var2) {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label74: {
                  if(var2 != 0) {
                     char[] var4 = class165.field2659;

                     for(int var5 = 0; var5 < var4.length; ++var5) {
                        char var6 = var4[var5];
                        if(var6 == var2) {
                           var3 = true;
                           break label74;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var7 = field2112 + 1 & 127;
               if(field2093 != var7) {
                  field2108[field2112] = -1;
                  field2107[field2112] = var2;
                  field2112 = var7;
               }
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != field2104) {
         field2111 = -1;
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(field2104 != null) {
         field2114 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2115.length) {
            var2 = field2115[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2111 >= 0 && var2 >= 0) {
            field2099[field2111] = ~var2;
            field2111 = 1 + field2111 & 127;
            if(field2116 == field2111) {
               field2111 = -1;
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass144;S)V",
      garbageValue = "-9575"
   )
   static void method2909() {
      if(class140.field2146 == 1 || !class3.field66 && 4 == class140.field2146) {
         int var0 = class31.field696 + 280;
         if(class140.field2135 >= var0 && class140.field2135 <= 14 + var0 && class140.field2148 >= 4 && class140.field2148 <= 18) {
            class38.method755(0, 0);
            return;
         }

         if(class140.field2135 >= var0 + 15 && class140.field2135 <= var0 + 80 && class140.field2148 >= 4 && class140.field2148 <= 18) {
            class38.method755(0, 1);
            return;
         }

         int var1 = class31.field696 + 390;
         if(class140.field2135 >= var1 && class140.field2135 <= var1 + 14 && class140.field2148 >= 4 && class140.field2148 <= 18) {
            class38.method755(1, 0);
            return;
         }

         if(class140.field2135 >= var1 + 15 && class140.field2135 <= var1 + 80 && class140.field2148 >= 4 && class140.field2148 <= 18) {
            class38.method755(1, 1);
            return;
         }

         int var2 = class31.field696 + 500;
         if(class140.field2135 >= var2 && class140.field2135 <= var2 + 14 && class140.field2148 >= 4 && class140.field2148 <= 18) {
            class38.method755(2, 0);
            return;
         }

         if(class140.field2135 >= 15 + var2 && class140.field2135 <= 80 + var2 && class140.field2148 >= 4 && class140.field2148 <= 18) {
            class38.method755(2, 1);
            return;
         }

         int var3 = 610 + class31.field696;
         if(class140.field2135 >= var3 && class140.field2135 <= 14 + var3 && class140.field2148 >= 4 && class140.field2148 <= 18) {
            class38.method755(3, 0);
            return;
         }

         if(class140.field2135 >= var3 + 15 && class140.field2135 <= var3 + 80 && class140.field2148 >= 4 && class140.field2148 <= 18) {
            class38.method755(3, 1);
            return;
         }

         if(class140.field2135 >= class31.field696 + 708 && class140.field2148 >= 4 && class140.field2135 <= 708 + class31.field696 + 50 && class140.field2148 <= 20) {
            class31.field721 = false;
            class31.field720.method1741(class31.field696, 0);
            class13.field199.method1741(382 + class31.field696, 0);
            class31.field704.method1880(class31.field696 + 382 - class31.field704.field1390 / 2, 18);
            return;
         }

         if(-1 != class31.field700) {
            class25 var4 = class25.field615[class31.field700];
            class130.method2820(var4);
            class31.field721 = false;
            class31.field720.method1741(class31.field696, 0);
            class13.field199.method1741(382 + class31.field696, 0);
            class31.field704.method1880(382 + class31.field696 - class31.field704.field1390 / 2, 18);
            return;
         }
      }

   }
}
