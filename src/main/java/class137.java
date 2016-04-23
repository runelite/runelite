import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public final class class137 implements KeyListener, FocusListener {
   @ObfuscatedName("cl")
   public static char field2081;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -1119666969
   )
   public static int field2088 = 0;
   @ObfuscatedName("j")
   public static class137 field2089 = new class137();
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -1704018337
   )
   static int field2092 = 0;
   @ObfuscatedName("cj")
   public static boolean[] field2095 = new boolean[112];
   @ObfuscatedName("cp")
   static int[] field2097 = new int[128];
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 2092272875
   )
   static int field2098 = 0;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -895406211
   )
   public static int field2099 = 0;
   @ObfuscatedName("cm")
   static char[] field2100 = new char[128];
   @ObfuscatedName("cy")
   static int[] field2101 = new int[128];
   @ObfuscatedName("cc")
   public static int[] field2102 = new int[128];
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -440719135
   )
   static volatile int field2104 = 0;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1444843977
   )
   static int field2105 = 0;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -336878173
   )
   static int field2106 = 0;
   @ObfuscatedName("cd")
   static int[] field2108 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

   public final synchronized void focusLost(FocusEvent var1) {
      if(field2089 != null) {
         field2099 = -1;
      }

   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != field2089) {
         field2104 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2108.length) {
            var2 = field2108[var2];
            if(0 != (var2 & 128)) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2099 >= 0 && var2 >= 0) {
            field2097[field2099] = var2;
            field2099 = 1 + field2099 & 127;
            if(field2099 == field2098) {
               field2099 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field2105 + 1 & 127;
            if(var3 != field2092) {
               field2101[field2105] = var2;
               field2100[field2105] = 0;
               field2105 = var3;
            }
         }

         var3 = var1.getModifiers();
         if(0 != (var3 & 10) || 85 == var2 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final void keyTyped(KeyEvent var1) {
      if(field2089 != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && '\uffff' != var2) {
            boolean var3;
            if((var2 <= 0 || var2 >= 128) && (var2 < 160 || var2 > 255)) {
               label63: {
                  if(var2 != 0) {
                     char[] var4 = class165.field2655;

                     for(int var5 = 0; var5 < var4.length; ++var5) {
                        char var6 = var4[var5];
                        if(var2 == var6) {
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
               int var7 = field2105 + 1 & 127;
               if(field2092 != var7) {
                  field2101[field2105] = -1;
                  field2100[field2105] = var2;
                  field2105 = var7;
               }
            }
         }
      }

      var1.consume();
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(null != field2089) {
         field2104 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2108.length) {
            var2 = field2108[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2099 >= 0 && var2 >= 0) {
            field2097[field2099] = ~var2;
            field2099 = field2099 + 1 & 127;
            if(field2098 == field2099) {
               field2099 = -1;
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-99"
   )
   public static void method2897() {
      class46.field1031.method3707();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "42"
   )
   static String method2898(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }
}
