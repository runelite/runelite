import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public final class class105 implements KeyListener, FocusListener {
   @ObfuscatedName("cp")
   public static int[] field1687 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -1320832857
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks = 0;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 640920471
   )
   public static int field1692 = 0;
   @ObfuscatedName("cy")
   public static boolean[] field1693 = new boolean[112];
   @ObfuscatedName("ct")
   static int[] field1694 = new int[128];
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -1041790595
   )
   static int field1695 = 0;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -2038881465
   )
   static int field1696 = 0;
   @ObfuscatedName("cx")
   static char[] field1697 = new char[128];
   @ObfuscatedName("cs")
   static int[] field1698 = new int[128];
   @ObfuscatedName("cf")
   public static int[] field1699 = new int[128];
   @ObfuscatedName("i")
   @Export("keyboard")
   public static class105 keyboard = new class105();
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -269826967
   )
   static int field1701 = 0;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1504247619
   )
   static int field1702 = 0;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -914202759
   )
   static int field1703 = 0;
   @ObfuscatedName("bm")
   static class184 field1706;

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != keyboard) {
         field1703 = -1;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1687.length) {
            var2 = field1687[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field1703 >= 0 && var2 >= 0) {
            field1694[field1703] = ~var2;
            field1703 = field1703 + 1 & 127;
            if(field1695 == field1703) {
               field1703 = -1;
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
               label70: {
                  if(var2 != 0) {
                     char[] var7 = class203.field3073;

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
               int var4 = field1702 + 1 & 127;
               if(var4 != field1701) {
                  field1698[field1702] = -1;
                  field1697[field1702] = var2;
                  field1702 = var4;
               }
            }
         }
      }

      var1.consume();
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != keyboard) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1687.length) {
            var2 = field1687[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field1703 >= 0 && var2 >= 0) {
            field1694[field1703] = var2;
            field1703 = field1703 + 1 & 127;
            if(field1695 == field1703) {
               field1703 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = 1 + field1702 & 127;
            if(var3 != field1701) {
               field1698[field1702] = var2;
               field1697[field1702] = 0;
               field1702 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public static void method1994() {
      KitDefinition.field2828.reset();
   }
}
