import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("KeyHandler")
public final class KeyHandler implements KeyListener, FocusListener {
   @ObfuscatedName("ra")
   @ObfuscatedGetter(
      intValue = -817957995
   )
   static int field445;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lan;"
   )
   @Export("KeyHandler_instance")
   public static KeyHandler KeyHandler_instance;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   @Export("title_muteSprite")
   static IndexedSprite[] title_muteSprite;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   @Export("options_buttons_6Sprite")
   static IndexedSprite options_buttons_6Sprite;
   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   @Export("loginType")
   static LoginType loginType;
   @ObfuscatedName("cb")
   @Export("KeyHandler_pressedKeys")
   public static boolean[] KeyHandler_pressedKeys;
   @ObfuscatedName("cq")
   static int[] field446;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 1112094745
   )
   static int field447;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -1208053825
   )
   static int field448;
   @ObfuscatedName("cg")
   static char[] field449;
   @ObfuscatedName("cf")
   static int[] field450;
   @ObfuscatedName("cp")
   public static int[] field451;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -674534717
   )
   public static int field452;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -93280591
   )
   static int field453;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 2066759739
   )
   static int field454;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -1942898885
   )
   static int field455;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -474146073
   )
   @Export("KeyHandler_idleCycles")
   public static volatile int KeyHandler_idleCycles;
   @ObfuscatedName("cd")
   @Export("KeyHandler_keyCodes")
   static int[] KeyHandler_keyCodes;
   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "[Lln;"
   )
   @Export("crossSprites")
   static Sprite[] crossSprites;

   @Export("keyPressed")
   @ObfuscatedName("keyPressed")
   public final synchronized void keyPressed(KeyEvent var1) {
      if (KeyHandler_instance != null) {
         int var2 = var1.getKeyCode();
         if (var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
            var2 = KeyHandler_keyCodes[var2];
            if ((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if (field448 >= 0 && var2 >= 0) {
            field446[field448] = var2;
            field448 = field448 + 1 & 127;
            if (field447 == field448) {
               field448 = -1;
            }
         }

         int var3;
         if (var2 >= 0) {
            var3 = field454 + 1 & 127;
            if (var3 != field453) {
               field450[field454] = var2;
               field449[field454] = 0;
               field454 = var3;
            }
         }

         var3 = var1.getModifiers();
         if ((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   @Export("focusGained")
   @ObfuscatedName("focusGained")
   public final void focusGained(FocusEvent var1) {
   }

   @Export("focusLost")
   @ObfuscatedName("focusLost")
   public final synchronized void focusLost(FocusEvent var1) {
      if (KeyHandler_instance != null) {
         field448 = -1;
      }

   }

   @Export("keyReleased")
   @ObfuscatedName("keyReleased")
   public final synchronized void keyReleased(KeyEvent var1) {
      if (KeyHandler_instance != null) {
         int var2 = var1.getKeyCode();
         if (var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
            var2 = KeyHandler_keyCodes[var2] & -129;
         } else {
            var2 = -1;
         }

         if (field448 >= 0 && var2 >= 0) {
            field446[field448] = ~var2;
            field448 = field448 + 1 & 127;
            if (field447 == field448) {
               field448 = -1;
            }
         }
      }

      var1.consume();
   }

   @Export("keyTyped")
   @ObfuscatedName("keyTyped")
   public final void keyTyped(KeyEvent var1) {
      if (KeyHandler_instance != null) {
         char var2 = var1.getKeyChar();
         if (var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if (var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label56: {
                  if (var2 != 0) {
                     char[] var4 = class304.cp1252AsciiExtension;

                     for (int var5 = 0; var5 < var4.length; ++var5) {
                        char var6 = var4[var5];
                        if (var2 == var6) {
                           var3 = true;
                           break label56;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if (var3) {
               int var7 = field454 + 1 & 127;
               if (var7 != field453) {
                  field450[field454] = -1;
                  field449[field454] = var2;
                  field454 = var7;
               }
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-345222494"
   )
   static String method839() {
      String var0 = "";

      Message var1;
      for (Iterator var2 = Messages.Messages_hashTable.iterator(); var2.hasNext(); var0 = var0 + var1.sender + ':' + var1.text + '\n') {
         var1 = (Message)var2.next();
      }

      return var0;
   }

   static {
      KeyHandler_instance = new KeyHandler();
      KeyHandler_pressedKeys = new boolean[112];
      field446 = new int[128];
      field447 = 0;
      field448 = 0;
      field449 = new char[128];
      field450 = new int[128];
      field451 = new int[128];
      field452 = 0;
      field453 = 0;
      field454 = 0;
      field455 = 0;
      KeyHandler_idleCycles = 0;
      KeyHandler_keyCodes = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }
}
