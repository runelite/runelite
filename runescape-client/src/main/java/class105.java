import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public final class class105 implements KeyListener, FocusListener {
   @ObfuscatedName("pv")
   static class1 field1703;
   @ObfuscatedName("cm")
   static int[] field1706 = new int[128];
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 1770471263
   )
   static int field1710 = 0;
   @ObfuscatedName("cj")
   public static boolean[] field1713 = new boolean[112];
   @ObfuscatedName("cg")
   static int[] field1714 = new int[128];
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 1346191273
   )
   static int field1715 = 0;
   @ObfuscatedName("q")
   @Export("keyboard")
   public static class105 keyboard = new class105();
   @ObfuscatedName("cl")
   static int[] field1718 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("ci")
   public static int[] field1719 = new int[128];
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -308142255
   )
   public static int field1720 = 0;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -202365829
   )
   static int field1722 = 0;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -1723265307
   )
   static int field1723 = 0;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 95868481
   )
   @Export("keyboardIdleTicks")
   static volatile int keyboardIdleTicks = 0;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -733919291
   )
   public static int field1726 = 0;
   @ObfuscatedName("cu")
   static char[] field1727 = new char[128];
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -652327489
   )
   static int field1728;

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1718.length) {
            var2 = field1718[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field1726 >= 0 && var2 >= 0) {
            field1714[field1726] = var2;
            field1726 = field1726 + 1 & 127;
            if(field1726 == field1715) {
               field1726 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = 1 + field1722 & 127;
            if(field1710 != var3) {
               field1706[field1722] = var2;
               field1727[field1722] = 0;
               field1722 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(Lclass25;I)V",
      garbageValue = "-1915197209"
   )
   static final void method2057(class25 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field593 == 0) {
         var1 = Script.region.method1773(var0.field594, var0.field598, var0.field595);
      }

      if(var0.field593 == 1) {
         var1 = Script.region.method1811(var0.field594, var0.field598, var0.field595);
      }

      if(var0.field593 == 2) {
         var1 = Script.region.method1878(var0.field594, var0.field598, var0.field595);
      }

      if(var0.field593 == 3) {
         var1 = Script.region.method1776(var0.field594, var0.field598, var0.field595);
      }

      if(var1 != 0) {
         int var5 = Script.region.method1777(var0.field594, var0.field598, var0.field595, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field596 = var2;
      var0.field601 = var3;
      var0.field597 = var4;
   }

   public final void keyTyped(KeyEvent var1) {
      if(null != keyboard) {
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
               int var7 = field1722 + 1 & 127;
               if(field1710 != var7) {
                  field1706[field1722] = -1;
                  field1727[field1722] = var2;
                  field1722 = var7;
               }
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != keyboard) {
         field1726 = -1;
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1718.length) {
            var2 = field1718[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field1726 >= 0 && var2 >= 0) {
            field1714[field1726] = ~var2;
            field1726 = 1 + field1726 & 127;
            if(field1726 == field1715) {
               field1726 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "-1215281042"
   )
   public static boolean method2082(CharSequence var0) {
      boolean var2 = false;
      boolean var3 = false;
      int var4 = 0;
      int var5 = var0.length();
      int var6 = 0;

      boolean var1;
      while(true) {
         if(var6 >= var5) {
            var1 = var3;
            break;
         }

         label95: {
            char var7 = var0.charAt(var6);
            if(var6 == 0) {
               if(var7 == 45) {
                  var2 = true;
                  break label95;
               }

               if(var7 == 43) {
                  break label95;
               }
            }

            int var9;
            if(var7 >= 48 && var7 <= 57) {
               var9 = var7 - 48;
            } else if(var7 >= 65 && var7 <= 90) {
               var9 = var7 - 55;
            } else {
               if(var7 < 97 || var7 > 122) {
                  var1 = false;
                  break;
               }

               var9 = var7 - 87;
            }

            if(var9 >= 10) {
               var1 = false;
               break;
            }

            if(var2) {
               var9 = -var9;
            }

            int var8 = var4 * 10 + var9;
            if(var8 / 10 != var4) {
               var1 = false;
               break;
            }

            var4 = var8;
            var3 = true;
         }

         ++var6;
      }

      return var1;
   }
}
