import java.awt.Canvas;
import java.awt.Container;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public final class class137 implements KeyListener, FocusListener {
   @ObfuscatedName("b")
   @Export("keyboard")
   public static class137 field2081 = new class137();
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -22667549
   )
   static int field2082 = 0;
   @ObfuscatedName("ce")
   static char[] field2088 = new char[128];
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = -1003379023
   )
   @Export("keyboardIdleTicks")
   public static volatile int field2094 = 0;
   @ObfuscatedName("cb")
   public static boolean[] field2095 = new boolean[112];
   @ObfuscatedName("cy")
   static int[] field2096 = new int[128];
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 452118107
   )
   public static int field2098 = 0;
   @ObfuscatedName("z")
   public static class172 field2099;
   @ObfuscatedName("cn")
   static int[] field2100 = new int[128];
   @ObfuscatedName("ct")
   public static int[] field2101 = new int[128];
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -599200685
   )
   public static int field2102 = 0;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 2015589877
   )
   static int field2103 = 0;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 608032543
   )
   static int field2105 = 0;
   @ObfuscatedName("ch")
   public static int[] field2107 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1169179317
   )
   static int field2108 = 0;

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != field2081) {
         field2094 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2107.length) {
            var2 = field2107[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2098 >= 0 && var2 >= 0) {
            field2096[field2098] = var2;
            field2098 = 1 + field2098 & 127;
            if(field2103 == field2098) {
               field2098 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field2108 + 1 & 127;
            if(field2082 != var3) {
               field2100[field2108] = var2;
               field2088[field2108] = 0;
               field2108 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(null != field2081) {
         field2094 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2107.length) {
            var2 = field2107[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2098 >= 0 && var2 >= 0) {
            field2096[field2098] = ~var2;
            field2098 = field2098 + 1 & 127;
            if(field2103 == field2098) {
               field2098 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void keyTyped(KeyEvent var1) {
      if(null != field2081) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if((var2 <= 0 || var2 >= 128) && (var2 < 160 || var2 > 255)) {
               label60: {
                  if(var2 != 0) {
                     char[] var4 = class165.field2657;

                     for(int var5 = 0; var5 < var4.length; ++var5) {
                        char var6 = var4[var5];
                        if(var6 == var2) {
                           var3 = true;
                           break label60;
                        }
                     }
                  }

                  var3 = false;
               }
            } else {
               var3 = true;
            }

            if(var3) {
               int var7 = field2108 + 1 & 127;
               if(field2082 != var7) {
                  field2100[field2108] = -1;
                  field2088[field2108] = var2;
                  field2108 = var7;
               }
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != field2081) {
         field2098 = -1;
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1815016532"
   )
   static void method2961() {
      client var0 = client.field284;
      synchronized(client.field284) {
         Container var1 = client.field284.method3057();
         if(var1 != null) {
            class110.field1934 = Math.max(var1.getSize().width, class104.field1782);
            class89.field1532 = Math.max(var1.getSize().height, class9.field150);
            if(class75.field1346 == var1) {
               Insets var2 = class75.field1346.getInsets();
               class110.field1934 -= var2.right + var2.left;
               class89.field1532 -= var2.bottom + var2.top;
            }

            if(class110.field1934 <= 0) {
               class110.field1934 = 1;
            }

            if(class89.field1532 <= 0) {
               class89.field1532 = 1;
            }

            int var12 = client.field501?2:1;
            if(var12 == 1) {
               class45.field1026 = client.field502;
               class143.field2169 = client.field353 * 503;
            } else {
               class45.field1026 = Math.min(class110.field1934, 7680);
               class143.field2169 = Math.min(class89.field1532, 2160);
            }

            class144.field2184 = (class110.field1934 - class45.field1026) / 2;
            class144.field2182 = 0;
            class46.field1040.setSize(class45.field1026, class143.field2169);
            int var4 = class45.field1026;
            int var5 = class143.field2169;
            Canvas var6 = class46.field1040;

            Object var3;
            try {
               class81 var7 = new class81();
               var7.vmethod1878(var4, var5, var6);
               var3 = var7;
            } catch (Throwable var16) {
               class75 var8 = new class75();
               var8.vmethod1878(var4, var5, var6);
               var3 = var8;
            }

            class48.field1049 = (class77)var3;
            if(class75.field1346 == var1) {
               Insets var18 = class75.field1346.getInsets();
               class46.field1040.setLocation(class144.field2184 + var18.left, class144.field2182 + var18.top);
            } else {
               class46.field1040.setLocation(class144.field2184, class144.field2182);
            }

            int var13 = class45.field1026;
            int var14 = class143.field2169;
            if(class110.field1934 < var13) {
               var13 = class110.field1934;
            }

            if(class89.field1532 < var14) {
               var14 = class89.field1532;
            }

            if(class162.field2637 != null) {
               try {
                  client var9 = client.field284;
                  int var10 = client.field501?2:1;
                  class132.method2880(var9, "resize", new Object[]{Integer.valueOf(var10)});
               } catch (Throwable var15) {
                  ;
               }
            }

            if(client.field456 != -1) {
               class85.method1921(client.field456, class45.field1026, class143.field2169, true);
            }

            class35.method737();
         }
      }
   }
}
