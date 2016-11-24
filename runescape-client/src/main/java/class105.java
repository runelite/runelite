import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
public final class class105 implements KeyListener, FocusListener {
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 1453005627
   )
   static int field1696 = 0;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 490246637
   )
   static int field1699 = 0;
   @ObfuscatedName("cp")
   public static boolean[] field1709 = new boolean[112];
   @ObfuscatedName("cz")
   static int[] field1710 = new int[128];
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 854962397
   )
   static int field1711 = 0;
   @ObfuscatedName("cq")
   static int[] field1712 = new int[128];
   @ObfuscatedName("cj")
   static char[] field1713 = new char[128];
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -779917401
   )
   static int field1714 = 0;
   @ObfuscatedName("cr")
   public static int[] field1715 = new int[128];
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -1739744569
   )
   public static int field1716 = 0;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -340983541
   )
   public static int field1718 = 0;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -1405658897
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks = 0;
   @ObfuscatedName("cf")
   public static int[] field1721 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("n")
   @Export("keyboard")
   public static class105 keyboard = new class105();
   @ObfuscatedName("iu")
   static Widget field1723;

   public final synchronized void keyReleased(KeyEvent var1) {
      if(null != keyboard) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1721.length) {
            var2 = field1721[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field1718 >= 0 && var2 >= 0) {
            field1710[field1718] = ~var2;
            field1718 = field1718 + 1 & 127;
            if(field1711 == field1718) {
               field1718 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != keyboard) {
         field1718 = -1;
      }

   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1721.length) {
            var2 = field1721[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field1718 >= 0 && var2 >= 0) {
            field1710[field1718] = var2;
            field1718 = field1718 + 1 & 127;
            if(field1711 == field1718) {
               field1718 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = 1 + field1714 & 127;
            if(field1699 != var3) {
               field1712[field1714] = var2;
               field1713[field1714] = 0;
               field1714 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-5474"
   )
   static int method2061() {
      return Client.isResized?2:1;
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
                     char[] var7 = class203.field3067;

                     for(int var5 = 0; var5 < var7.length; ++var5) {
                        char var6 = var7[var5];
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
               int var4 = 1 + field1714 & 127;
               if(field1699 != var4) {
                  field1712[field1714] = -1;
                  field1713[field1714] = var2;
                  field1714 = var4;
               }
            }
         }
      }

      var1.consume();
   }
}
