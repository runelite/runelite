import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public final class class137 implements KeyListener, FocusListener {
   @ObfuscatedName("ct")
   public static int[] field2103 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -554262825
   )
   public static int field2113 = 0;
   @ObfuscatedName("co")
   public static boolean[] field2114 = new boolean[112];
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1973677161
   )
   public static int field2116 = 0;
   @ObfuscatedName("cs")
   public static int[] field2117 = new int[128];
   @ObfuscatedName("f")
   @Export("keyboard")
   public static class137 field2118 = new class137();
   @ObfuscatedName("cf")
   static char[] field2119 = new char[128];
   @ObfuscatedName("cb")
   static int[] field2120 = new int[128];
   @ObfuscatedName("ck")
   public static int[] field2122 = new int[128];
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 1388160341
   )
   public static int field2123 = 0;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 418664769
   )
   public static int field2124 = 0;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -1850909495
   )
   public static int field2125 = 0;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -2141274801
   )
   @Export("keyboardIdleTicks")
   public static volatile int field2126 = 0;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -362453861
   )
   public static int field2127 = 0;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = -832556591
   )
   static int field2128;
   @ObfuscatedName("g")
   static class154 field2130;

   public final void keyTyped(KeyEvent var1) {
      if(null != field2118) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff' && class111.method2479(var2)) {
            int var3 = 1 + field2124 & 127;
            if(var3 != field2116) {
               field2120[field2124] = -1;
               field2119[field2124] = var2;
               field2124 = var3;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(field2118 != null) {
         field2113 = -1;
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(field2118 != null) {
         field2126 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2103.length) {
            var2 = field2103[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2113 >= 0 && var2 >= 0) {
            field2122[field2113] = ~var2;
            field2113 = field2113 + 1 & 127;
            if(field2125 == field2113) {
               field2113 = -1;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != field2118) {
         field2126 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2103.length) {
            var2 = field2103[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2113 >= 0 && var2 >= 0) {
            field2122[field2113] = var2;
            field2113 = field2113 + 1 & 127;
            if(field2125 == field2113) {
               field2113 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field2124 + 1 & 127;
            if(field2116 != var3) {
               field2120[field2124] = var2;
               field2119[field2124] = 0;
               field2124 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Lclass78;",
      garbageValue = "-2013336249"
   )
   @Export("createSprite")
   public static final class78 method2954(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var4 << 40) + (long)var0 + ((long)var1 << 16) + ((long)var2 << 38) + ((long)var3 << 42);
      class78 var8;
      if(!var5) {
         var8 = (class78)class51.field1118.method3797(var6);
         if(null != var8) {
            return var8;
         }
      }

      class51 var9 = class141.method3001(var0);
      if(var1 > 1 && null != var9.field1150) {
         int var21 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field1138[var11] && var9.field1138[var11] != 0) {
               var21 = var9.field1150[var11];
            }
         }

         if(var21 != -1) {
            var9 = class141.method3001(var21);
         }
      }

      class105 var10 = var9.method1112(1);
      if(var10 == null) {
         return null;
      } else {
         class78 var22 = null;
         if(var9.field1153 != -1) {
            var22 = method2954(var9.field1152, 10, 1, 0, 0, true);
            if(null == var22) {
               return null;
            }
         } else if(var9.field1162 != -1) {
            var22 = method2954(var9.field1161, var1, var2, var3, 0, false);
            if(var22 == null) {
               return null;
            }
         } else if(var9.field1164 != -1) {
            var22 = method2954(var9.field1163, var1, 0, 0, 0, false);
            if(var22 == null) {
               return null;
            }
         }

         int[] var12 = class79.field1421;
         int var13 = class79.field1419;
         int var14 = class79.field1425;
         int[] var15 = new int[4];
         class79.method1850(var15);
         var8 = new class78(36, 32);
         class79.method1846(var8.field1409, 36, 32);
         class79.method1852();
         class91.method2151();
         class91.method2145(16, 16);
         class91.field1587 = false;
         if(var9.field1164 != -1) {
            var22.method1763(0, 0);
         }

         int var16 = var9.field1127;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = class91.field1597[var9.field1117] * var16 >> 16;
         int var18 = class91.field1577[var9.field1117] * var16 >> 16;
         var10.method2357();
         var10.method2367(0, var9.field1129, var9.field1131, var9.field1117, var9.field1133, var9.field1132 + var17 + var10.field1468 / 2, var9.field1132 + var18);
         if(var9.field1162 != -1) {
            var22.method1763(0, 0);
         }

         if(var2 >= 1) {
            var8.method1769(1);
         }

         if(var2 >= 2) {
            var8.method1769(16777215);
         }

         if(var3 != 0) {
            var8.method1759(var3);
         }

         class79.method1846(var8.field1409, 36, 32);
         if(var9.field1153 != -1) {
            var22.method1763(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.field1151 == 1) {
            class224 var19 = class51.field1123;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4066(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            class51.field1118.method3788(var8, var6);
         }

         class79.method1846(var12, var13, var14);
         class79.method1855(var15);
         class91.method2151();
         class91.field1587 = true;
         return var8;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass143;ZB)V",
      garbageValue = "93"
   )
   public static void method2961(class143 var0, boolean var1) {
      if(null != class171.field2722) {
         try {
            class171.field2722.method3013();
         } catch (Exception var6) {
            ;
         }

         class171.field2722 = null;
      }

      class171.field2722 = var0;
      class163.method3250(var1);
      class171.field2723.field1998 = 0;
      class142.field2173 = null;
      class171.field2712 = null;
      class171.field2711 = 0;

      while(true) {
         class172 var2 = (class172)class171.field2715.method3825();
         if(null == var2) {
            while(true) {
               var2 = (class172)class171.field2720.method3825();
               if(var2 == null) {
                  if(class171.field2729 != 0) {
                     try {
                        class119 var7 = new class119(4);
                        var7.method2654(4);
                        var7.method2654(class171.field2729);
                        var7.method2540(0);
                        class171.field2722.method3018(var7.field2000, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class171.field2722.method3013();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class171.field2716;
                        class171.field2722 = null;
                     }
                  }

                  class171.field2724 = 0;
                  class125.field2046 = class130.method2846();
                  return;
               }

               class171.field2717.method3912(var2);
               class171.field2718.method3826(var2, var2.field3115);
               ++class171.field2719;
               --class171.field2721;
            }
         }

         class171.field2713.method3826(var2, var2.field3115);
         ++class171.field2730;
         --class171.field2714;
      }
   }
}
