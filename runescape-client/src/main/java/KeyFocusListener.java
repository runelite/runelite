import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("og")
   @ObfuscatedSignature(
      signature = "Lcz;"
   )
   static class99 field583;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   @Export("keyboard")
   static KeyFocusListener keyboard;
   @ObfuscatedName("cl")
   @Export("keyPressed")
   public static boolean[] keyPressed;
   @ObfuscatedName("cy")
   static int[] field580;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -1826053867
   )
   static int field581;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 188162605
   )
   static int field584;
   @ObfuscatedName("ct")
   static char[] field590;
   @ObfuscatedName("cj")
   static int[] field577;
   @ObfuscatedName("ce")
   public static int[] field585;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -2066314643
   )
   public static int field593;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -751896907
   )
   static int field569;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -775182571
   )
   static int field588;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 495446913
   )
   static int field582;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 956774301
   )
   @Export("keyboardIdleTicks")
   static volatile int keyboardIdleTicks;
   @ObfuscatedName("ck")
   @Export("KeyHandler_keyCodes")
   static int[] KeyHandler_keyCodes;
   @ObfuscatedName("fj")
   static byte[][] field589;

   static {
      keyboard = new KeyFocusListener();
      keyPressed = new boolean[112];
      field580 = new int[128];
      field581 = 0;
      field584 = 0;
      field590 = new char[128];
      field577 = new int[128];
      field585 = new int[128];
      field593 = 0;
      field569 = 0;
      field588 = 0;
      field582 = 0;
      keyboardIdleTicks = 0;
      KeyHandler_keyCodes = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   @Export("keyPressed")
   @ObfuscatedName("keyPressed")
   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
            var2 = KeyHandler_keyCodes[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field584 >= 0 && var2 >= 0) {
            field580[field584] = var2;
            field584 = field584 + 1 & 127;
            if(field581 == field584) {
               field584 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field588 + 1 & 127;
            if(var3 != field569) {
               field577[field588] = var2;
               field590[field588] = 0;
               field588 = var3;
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
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
            var2 = KeyHandler_keyCodes[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field584 >= 0 && var2 >= 0) {
            field580[field584] = ~var2;
            field584 = field584 + 1 & 127;
            if(field584 == field581) {
               field584 = -1;
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
               label56: {
                  if(var2 != 0) {
                     char[] var7 = class300.cp1252AsciiExtension;

                     for(int var5 = 0; var5 < var7.length; ++var5) {
                        char var6 = var7[var5];
                        if(var2 == var6) {
                           var3 = true;
                           break label56;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var4 = field588 + 1 & 127;
               if(var4 != field569) {
                  field577[field588] = -1;
                  field590[field588] = var2;
                  field588 = var4;
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
         field584 = -1;
      }

   }
}
