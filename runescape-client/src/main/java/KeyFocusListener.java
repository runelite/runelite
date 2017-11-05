import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lan;"
   )
   @Export("keyboard")
   public static KeyFocusListener keyboard;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -301087595
   )
   public static int field645;
   @ObfuscatedName("cn")
   public static boolean[] field659;
   @ObfuscatedName("cw")
   public static int[] field660;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 345386375
   )
   public static int field653;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 1507021157
   )
   public static int field662;
   @ObfuscatedName("cd")
   static char[] field646;
   @ObfuscatedName("cc")
   static int[] field664;
   @ObfuscatedName("cq")
   public static int[] field671;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1601557415
   )
   public static int field666;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 107316193
   )
   public static int field667;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 868770429
   )
   public static int field661;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 591715025
   )
   public static int field639;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 1156889777
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks;
   @ObfuscatedName("cy")
   static int[] field669;

   static {
      keyboard = new KeyFocusListener();
      field659 = new boolean[112];
      field660 = new int[128];
      field653 = 0;
      field662 = 0;
      field646 = new char[128];
      field664 = new int[128];
      field671 = new int[128];
      field666 = 0;
      field667 = 0;
      field661 = 0;
      field639 = 0;
      keyboardIdleTicks = 0;
      field669 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field669.length) {
            var2 = field669[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field662 >= 0 && var2 >= 0) {
            field660[field662] = var2;
            field662 = field662 + 1 & 127;
            if(field653 == field662) {
               field662 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field661 + 1 & 127;
            if(var3 != field667) {
               field664[field661] = var2;
               field646[field661] = 0;
               field661 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field662 = -1;
      }

   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label58: {
                  if(var2 != 0) {
                     char[] var7 = class266.field3666;

                     for(int var5 = 0; var5 < var7.length; ++var5) {
                        char var6 = var7[var5];
                        if(var6 == var2) {
                           var3 = true;
                           break label58;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var4 = field661 + 1 & 127;
               if(var4 != field667) {
                  field664[field661] = -1;
                  field646[field661] = var2;
                  field661 = var4;
               }
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field669.length) {
            var2 = field669[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field662 >= 0 && var2 >= 0) {
            field660[field662] = ~var2;
            field662 = field662 + 1 & 127;
            if(field662 == field653) {
               field662 = -1;
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)[Lij;",
      garbageValue = "1"
   )
   static class239[] method755() {
      return new class239[]{class239.field3267, class239.field3270, class239.field3268};
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1426107077"
   )
   static final void method756() {
      if(class1.soundSystem1 != null) {
         class1.soundSystem1.method2059();
      }

      if(ItemLayer.soundSystem0 != null) {
         ItemLayer.soundSystem0.method2059();
      }

   }
}
