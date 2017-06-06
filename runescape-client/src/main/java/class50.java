import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public final class class50 implements KeyListener, FocusListener {
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -1374006075
   )
   static int field635;
   @ObfuscatedName("ci")
   static char[] field637;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 1073041979
   )
   @Export("keyboardIdleTicks")
   static volatile int keyboardIdleTicks;
   @ObfuscatedName("cn")
   public static char field642;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1101145061
   )
   static int field644;
   @ObfuscatedName("co")
   public static boolean[] field645;
   @ObfuscatedName("i")
   @Export("keyboard")
   public static class50 keyboard;
   @ObfuscatedName("cl")
   static int[] field647;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -1573421999
   )
   static int field648;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -1782291671
   )
   static int field649;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -1932895125
   )
   static int field650;
   @ObfuscatedName("cu")
   static int[] field651;
   @ObfuscatedName("cx")
   public static int[] field652;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1762330479
   )
   public static int field653;
   @ObfuscatedName("ct")
   static int[] field658;
   @ObfuscatedName("du")
   @Export("indexWorldMap")
   static IndexData indexWorldMap;

   static {
      keyboard = new class50();
      field645 = new boolean[112];
      field647 = new int[128];
      field648 = 0;
      field650 = 0;
      field637 = new char[128];
      field651 = new int[128];
      field652 = new int[128];
      field653 = 0;
      field635 = 0;
      field649 = 0;
      field644 = 0;
      keyboardIdleTicks = 0;
      field658 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label70: {
                  if(var2 != 0) {
                     char[] var4 = class266.field3661;

                     for(int var5 = 0; var5 < var4.length; ++var5) {
                        char var6 = var4[var5];
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
               int var7 = field649 + 1 & 127;
               if(field635 != var7) {
                  field651[field649] = -1;
                  field637[field649] = var2;
                  field649 = var7;
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
         field650 = -1;
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field658.length) {
            var2 = field658[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field650 >= 0 && var2 >= 0) {
            field647[field650] = ~var2;
            field650 = field650 + 1 & 127;
            if(field650 == field648) {
               field650 = -1;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field658.length) {
            var2 = field658[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field650 >= 0 && var2 >= 0) {
            field647[field650] = var2;
            field650 = field650 + 1 & 127;
            if(field648 == field650) {
               field650 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field649 + 1 & 127;
            if(var3 != field635) {
               field651[field649] = var2;
               field637[field649] = 0;
               field649 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BS)Ljava/lang/String;",
      garbageValue = "4307"
   )
   public static String method751(byte[] var0) {
      return class220.method4057(var0, 0, var0.length);
   }
}
