import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Laq;"
   )
   @Export("keyboard")
   public static KeyFocusListener keyboard;
   @ObfuscatedName("ck")
   @Export("keyPressed")
   public static boolean[] keyPressed;
   @ObfuscatedName("cn")
   static int[] field612;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 192381307
   )
   static int field621;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -1261446189
   )
   static int field614;
   @ObfuscatedName("cd")
   static char[] field623;
   @ObfuscatedName("co")
   static int[] field624;
   @ObfuscatedName("cb")
   public static int[] field625;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 1144120925
   )
   public static int field626;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -356896107
   )
   static int field627;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 41605993
   )
   static int field628;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 373220073
   )
   static int field610;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 613223241
   )
   @Export("keyboardIdleTicks")
   static volatile int keyboardIdleTicks;
   @ObfuscatedName("ct")
   @Export("KeyHandler_keyCodes")
   static int[] KeyHandler_keyCodes;
   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("indexCache15")
   static IndexData indexCache15;
   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   static Widget field635;

   static {
      keyboard = new KeyFocusListener();
      keyPressed = new boolean[112];
      field612 = new int[128];
      field621 = 0;
      field614 = 0;
      field623 = new char[128];
      field624 = new int[128];
      field625 = new int[128];
      field626 = 0;
      field627 = 0;
      field628 = 0;
      field610 = 0;
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

         if(field614 >= 0 && var2 >= 0) {
            field612[field614] = var2;
            field614 = field614 + 1 & 127;
            if(field621 == field614) {
               field614 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field628 + 1 & 127;
            if(var3 != field627) {
               field624[field628] = var2;
               field623[field628] = 0;
               field628 = var3;
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

         if(field614 >= 0 && var2 >= 0) {
            field612[field614] = ~var2;
            field614 = field614 + 1 & 127;
            if(field621 == field614) {
               field614 = -1;
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
               label59: {
                  if(var2 != 0) {
                     char[] var7 = class314.cp1252AsciiExtension;

                     for(int var5 = 0; var5 < var7.length; ++var5) {
                        char var6 = var7[var5];
                        if(var6 == var2) {
                           var3 = true;
                           break label59;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var4 = field628 + 1 & 127;
               if(var4 != field627) {
                  field624[field628] = -1;
                  field623[field628] = var2;
                  field628 = var4;
               }
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   @Export("focusLost")
   @Hook("focusLost")
   @ObfuscatedName("focusLost")
   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field614 = -1;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)Lbn;",
      garbageValue = "639693877"
   )
   static MessageNode method822(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class95.chatLineMap.get(Integer.valueOf(var0));
      return var2.getMessage(var1);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1160784232"
   )
   static void method823() {
      Iterator var0 = class95.messages.iterator();

      while(var0.hasNext()) {
         MessageNode var1 = (MessageNode)var0.next();
         var1.method1172();
      }

   }
}
