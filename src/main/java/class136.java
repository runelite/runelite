import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eh")
public final class class136 implements KeyListener, FocusListener {
   @ObfuscatedName("cl")
   public static boolean[] field2087 = new boolean[112];
   @ObfuscatedName("ck")
   static char[] field2093 = new char[128];
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -537606549
   )
   static int field2101 = 0;
   @ObfuscatedName("cp")
   static int[] field2103 = new int[128];
   @ObfuscatedName("cm")
   static int[] field2107 = new int[128];
   @ObfuscatedName("a")
   public static class136 field2108 = new class136();
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = -1760746293
   )
   static int field2109 = 0;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 283046807
   )
   public static int field2110 = 0;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -1710349687
   )
   static int field2111 = 0;
   @ObfuscatedName("cb")
   public static int[] field2112 = new int[128];
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -386299427
   )
   static int field2113 = 0;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 1276853551
   )
   static int field2116 = 0;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 1565648987
   )
   static volatile int field2117 = 0;
   @ObfuscatedName("cd")
   public static int[] field2118 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("ip")
   static class30 field2120;
   @ObfuscatedName("i")
   public static class59 field2121;

   public final synchronized void keyPressed(KeyEvent var1) {
      if(field2108 != null) {
         field2117 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2118.length) {
            var2 = field2118[var2];
            if(0 != (var2 & 128)) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2109 >= 0 && var2 >= 0) {
            field2107[field2109] = var2;
            field2109 = field2109 + 1 & 127;
            if(field2113 == field2109) {
               field2109 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = 1 + field2111 & 127;
            if(var3 != field2101) {
               field2103[field2111] = var2;
               field2093[field2111] = 0;
               field2111 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || 85 == var2 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final void keyTyped(KeyEvent var1) {
      if(null != field2108) {
         char var2 = var1.getKeyChar();
         if(0 != var2 && '\uffff' != var2) {
            boolean var3;
            if((var2 <= 0 || var2 >= 128) && (var2 < 160 || var2 > 255)) {
               label63: {
                  if(var2 != 0) {
                     char[] var4 = class164.field2650;

                     for(int var5 = 0; var5 < var4.length; ++var5) {
                        char var6 = var4[var5];
                        if(var6 == var2) {
                           var3 = true;
                           break label63;
                        }
                     }
                  }

                  var3 = false;
               }
            } else {
               var3 = true;
            }

            if(var3) {
               int var7 = field2111 + 1 & 127;
               if(var7 != field2101) {
                  field2103[field2111] = -1;
                  field2093[field2111] = var2;
                  field2111 = var7;
               }
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != field2108) {
         field2109 = -1;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("e")
   static final void method2926(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, class85 var8, class107[] var9) {
      class118 var10 = new class118(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method2659();
         if(0 == var12) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.method2659();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.method2579();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var17 == var4 && var16 >= var5 && var16 < 8 + var5 && var15 >= var6 && var15 < var6 + 8) {
               class40 var21 = class156.method3176(var11);
               int var24 = var16 & 7;
               int var25 = var15 & 7;
               int var27 = var21.field938;
               int var28 = var21.field939;
               int var29;
               if(1 == (var20 & 1)) {
                  var29 = var27;
                  var27 = var28;
                  var28 = var29;
               }

               int var26 = var7 & 3;
               int var23;
               if(0 == var26) {
                  var23 = var24;
               } else if(var26 == 1) {
                  var23 = var25;
               } else if(var26 == 2) {
                  var23 = 7 - var24 - (var27 - 1);
               } else {
                  var23 = 7 - var25 - (var28 - 1);
               }

               var29 = var23 + var2;
               int var30 = var3 + class157.method3178(var16 & 7, var15 & 7, var7, var21.field938, var21.field939, var20);
               if(var29 > 0 && var30 > 0 && var29 < 103 && var30 < 103) {
                  int var31 = var1;
                  if((class5.field90[1][var29][var30] & 2) == 2) {
                     var31 = var1 - 1;
                  }

                  class107 var32 = null;
                  if(var31 >= 0) {
                     var32 = var9[var31];
                  }

                  class32.method712(var1, var29, var30, var11, var20 + var7 & 3, var19, var8, var32);
               }
            }
         }
      }
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(null != field2108) {
         field2117 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2118.length) {
            var2 = field2118[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2109 >= 0 && var2 >= 0) {
            field2107[field2109] = ~var2;
            field2109 = field2109 + 1 & 127;
            if(field2109 == field2113) {
               field2109 = -1;
            }
         }
      }

      var1.consume();
   }
}
