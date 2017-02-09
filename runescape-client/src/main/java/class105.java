import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public final class class105 implements KeyListener, FocusListener {
   @ObfuscatedName("k")
   @Export("keyboard")
   public static class105 keyboard = new class105();
   @ObfuscatedName("cp")
   static char[] field1701 = new char[128];
   @ObfuscatedName("cg")
   static int[] field1710 = new int[128];
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -759543131
   )
   static int field1711 = 0;
   @ObfuscatedName("co")
   public static boolean[] field1712 = new boolean[112];
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 1656638473
   )
   static int field1713 = 0;
   @ObfuscatedName("cx")
   static int[] field1714 = new int[128];
   @ObfuscatedName("cl")
   public static int[] field1715 = new int[128];
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -2027794155
   )
   public static int field1716 = 0;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -581152427
   )
   static int field1717 = 0;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -1235111397
   )
   static int field1718 = 0;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -198807893
   )
   public static int field1719 = 0;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 1484209573
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks = 0;
   @ObfuscatedName("cq")
   public static int[] field1721 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1138561219
   )
   public static int field1722;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = -1410414363
   )
   static int field1723;
   @ObfuscatedName("r")
   public static class182 field1724;

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

         if(field1719 >= 0 && var2 >= 0) {
            field1710[field1719] = var2;
            field1719 = 1 + field1719 & 127;
            if(field1711 == field1719) {
               field1719 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = 1 + field1713 & 127;
            if(var3 != field1718) {
               field1714[field1713] = var2;
               field1701[field1713] = 0;
               field1713 = var3;
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
         if(var2 >= 0 && var2 < field1721.length) {
            var2 = field1721[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field1719 >= 0 && var2 >= 0) {
            field1710[field1719] = ~var2;
            field1719 = 1 + field1719 & 127;
            if(field1719 == field1711) {
               field1719 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label71: {
                  if(var2 != 0) {
                     char[] var4 = class203.field3063;

                     for(int var5 = 0; var5 < var4.length; ++var5) {
                        char var6 = var4[var5];
                        if(var2 == var6) {
                           var3 = true;
                           break label71;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var7 = field1713 + 1 & 127;
               if(var7 != field1718) {
                  field1714[field1713] = -1;
                  field1701[field1713] = var2;
                  field1713 = var7;
               }
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != keyboard) {
         field1719 = -1;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "856430443"
   )
   public static int method1999(String var0) {
      return var0.length() + 1;
   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-489755004"
   )
   static final void method2013(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class15.method193(var0)) {
         class60.field1078 = null;
         class36.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(null != class60.field1078) {
            class36.gameDraw(class60.field1078, -1412584499, var1, var2, var3, var4, class5.field51, class32.field721, var7);
            class60.field1078 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field482[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field482[var8] = true;
            }
         }

      }
   }
}
