import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   @Export("keyboard")
   static KeyFocusListener keyboard;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 1408398383
   )
   static int field654;
   @ObfuscatedName("cv")
   static int[] field640;
   @ObfuscatedName("ct")
   public static boolean[] field651;
   @ObfuscatedName("cx")
   static int[] field642;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1042228079
   )
   static int field653;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 2123971043
   )
   static int field658;
   @ObfuscatedName("cg")
   static char[] field655;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -1093319003
   )
   static int field657;
   @ObfuscatedName("cr")
   static int[] field656;
   @ObfuscatedName("ci")
   public static int[] field646;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 2118767627
   )
   public static int field652;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 637066631
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -1912663157
   )
   static int field661;
   @ObfuscatedName("rr")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   @Export("renderOverview")
   static RenderOverview renderOverview;

   static {
      keyboard = new KeyFocusListener();
      field651 = new boolean[112];
      field642 = new int[128];
      field653 = 0;
      field654 = 0;
      field655 = new char[128];
      field656 = new int[128];
      field646 = new int[128];
      field652 = 0;
      field657 = 0;
      field658 = 0;
      field661 = 0;
      keyboardIdleTicks = 0;
      field640 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field640.length) {
            var2 = field640[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field654 >= 0 && var2 >= 0) {
            field642[field654] = var2;
            field654 = field654 + 1 & 127;
            if(field653 == field654) {
               field654 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field658 + 1 & 127;
            if(var3 != field657) {
               field656[field658] = var2;
               field655[field658] = 0;
               field658 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
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
                     char[] var7 = class267.field3660;

                     for(int var5 = 0; var5 < var7.length; ++var5) {
                        char var6 = var7[var5];
                        if(var2 == var6) {
                           var3 = true;
                           break label58;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var4 = field658 + 1 & 127;
               if(var4 != field657) {
                  field656[field658] = -1;
                  field655[field658] = var2;
                  field658 = var4;
               }
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field654 = -1;
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field640.length) {
            var2 = field640[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field654 >= 0 && var2 >= 0) {
            field642[field654] = ~var2;
            field654 = field654 + 1 & 127;
            if(field653 == field654) {
               field654 = -1;
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(Lhx;IIIIIII)V",
      garbageValue = "-141953554"
   )
   static final void method813(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field1012) {
         Client.field1013 = 32;
      } else {
         Client.field1013 = 0;
      }

      Client.field1012 = false;
      int var7;
      if(MouseInput.field745 == 1 || !Client.field951 && MouseInput.field745 == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
            var0.scrollY -= 4;
            class7.method34(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.scrollY += 4;
            class7.method34(var0);
         } else if(var5 >= var1 - Client.field1013 && var5 < Client.field1013 + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = var8 * (var4 - var3) / var9;
            class7.method34(var0);
            Client.field1012 = true;
         }
      }

      if(Client.field1129 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.scrollY += Client.field1129 * 45;
            class7.method34(var0);
         }
      }

   }
}
