import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public final class class105 implements KeyListener, FocusListener {
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 810037511
   )
   public static int field1695 = 0;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -1029781029
   )
   public static int field1696 = 0;
   @ObfuscatedName("s")
   @Export("keyboard")
   public static class105 keyboard = new class105();
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -716490275
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("cn")
   public static boolean[] field1709 = new boolean[112];
   @ObfuscatedName("cm")
   public static int[] field1710 = new int[128];
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 147587177
   )
   public static int field1711 = 0;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -1609171185
   )
   public static int field1712 = 0;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -1421839129
   )
   public static int field1713 = 0;
   @ObfuscatedName("cj")
   static int[] field1714 = new int[128];
   @ObfuscatedName("cl")
   public static int[] field1715 = new int[128];
   @ObfuscatedName("cp")
   static char[] field1719 = new char[128];
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -1251357063
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks = 0;
   @ObfuscatedName("cx")
   public static int[] field1721 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -1820513759
   )
   public static int field1722 = 0;

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if((var2 <= 0 || var2 >= 128) && (var2 < 160 || var2 > 255)) {
               label62: {
                  if(var2 != 0) {
                     char[] var4 = class203.field3077;

                     for(int var5 = 0; var5 < var4.length; ++var5) {
                        char var6 = var4[var5];
                        if(var6 == var2) {
                           var3 = true;
                           break label62;
                        }
                     }
                  }

                  var3 = false;
               }
            } else {
               var3 = true;
            }

            if(var3) {
               int var7 = 1 + field1713 & 127;
               if(var7 != field1695) {
                  field1714[field1713] = -1;
                  field1719[field1713] = var2;
                  field1713 = var7;
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
         if(var2 >= 0 && var2 < field1721.length) {
            var2 = field1721[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field1712 >= 0 && var2 >= 0) {
            field1710[field1712] = ~var2;
            field1712 = field1712 + 1 & 127;
            if(field1711 == field1712) {
               field1712 = -1;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != keyboard) {
         field1712 = -1;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != keyboard) {
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

         if(field1712 >= 0 && var2 >= 0) {
            field1710[field1712] = var2;
            field1712 = 1 + field1712 & 127;
            if(field1712 == field1711) {
               field1712 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field1713 + 1 & 127;
            if(var3 != field1695) {
               field1714[field1713] = var2;
               field1719[field1713] = 0;
               field1713 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1115961267"
   )
   static final void method1961() {
      if(Client.field346 > 0) {
         CombatInfoListHolder.method692();
      } else {
         class103.setGameState(40);
         ItemComposition.field3003 = class30.field698;
         class30.field698 = null;
      }
   }
}
