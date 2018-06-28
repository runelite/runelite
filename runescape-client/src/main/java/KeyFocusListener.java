import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Laf;"
   )
   @Export("keyboard")
   public static KeyFocusListener keyboard;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   static IndexDataBase field354;
   @ObfuscatedName("co")
   @Export("keyPressed")
   public static boolean[] keyPressed;
   @ObfuscatedName("ck")
   public static int[] field341;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = 1378128227
   )
   public static int field343;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1055169947
   )
   public static int field349;
   @ObfuscatedName("cb")
   static char[] field344;
   @ObfuscatedName("cg")
   static int[] field339;
   @ObfuscatedName("cl")
   public static int[] field346;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1183185103
   )
   public static int field347;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 1947619039
   )
   public static int field342;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 1763637537
   )
   public static int field355;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 1737283633
   )
   public static int field348;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -2116695327
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks;
   @ObfuscatedName("cr")
   @Export("KeyHandler_keyCodes")
   static int[] KeyHandler_keyCodes;
   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "[Llc;"
   )
   @Export("headIconsPrayer")
   static SpritePixels[] headIconsPrayer;

   static {
      keyboard = new KeyFocusListener();
      keyPressed = new boolean[112];
      field341 = new int[128];
      field343 = 0;
      field349 = 0;
      field344 = new char[128];
      field339 = new int[128];
      field346 = new int[128];
      field347 = 0;
      field342 = 0;
      field355 = 0;
      field348 = 0;
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

         if(field349 >= 0 && var2 >= 0) {
            field341[field349] = var2;
            field349 = field349 + 1 & 127;
            if(field349 == field343) {
               field349 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field355 + 1 & 127;
            if(var3 != field342) {
               field339[field355] = var2;
               field344[field355] = 0;
               field355 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   @Export("focusLost")
   @Hook("focusLost")
   @ObfuscatedName("focusLost")
   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field349 = -1;
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
               label60: {
                  if(var2 != 0) {
                     char[] var7 = class301.cp1252AsciiExtension;

                     for(int var5 = 0; var5 < var7.length; ++var5) {
                        char var6 = var7[var5];
                        if(var6 == var2) {
                           var3 = true;
                           break label60;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var4 = field355 + 1 & 127;
               if(var4 != field342) {
                  field339[field355] = -1;
                  field344[field355] = var2;
                  field355 = var4;
               }
            }
         }
      }

      var1.consume();
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
            var2 = KeyHandler_keyCodes[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field349 >= 0 && var2 >= 0) {
            field341[field349] = ~var2;
            field349 = field349 + 1 & 127;
            if(field343 == field349) {
               field349 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "217026398"
   )
   public static int method759(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-18"
   )
   @Export("adjustHSLListness0")
   static final int adjustHSLListness0(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1212853060"
   )
   static final void method761(boolean var0) {
      if(var0) {
         Client.field716 = class78.field1132?class146.field1927:class146.field1933;
      } else {
         Client.field716 = ScriptState.preferences.preferences.containsKey(Integer.valueOf(Client.method1577(class78.username)))?class146.field1930:class146.field1929;
      }

   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-2"
   )
   @Export("worldToScreen")
   static final void worldToScreen(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class264.getTileHeight(var0, var1, class192.plane) - var2;
         var0 -= WorldMapType3.cameraX;
         var3 -= Size.cameraZ;
         var1 -= class13.cameraY;
         int var4 = Graphics3D.SINE[class146.cameraPitch];
         int var5 = Graphics3D.COSINE[class146.cameraPitch];
         int var6 = Graphics3D.SINE[WidgetNode.cameraYaw];
         int var7 = Graphics3D.COSINE[WidgetNode.cameraYaw];
         int var8 = var0 * var7 + var6 * var1 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var4 * var1 >> 16;
         var1 = var3 * var4 + var5 * var1 >> 16;
         if(var1 >= 50) {
            Client.screenX = var0 * Client.scale / var1 + Client.viewportWidth / 2;
            Client.screenY = var8 * Client.scale / var1 + Client.viewportHeight / 2;
         } else {
            Client.screenX = -1;
            Client.screenY = -1;
         }

      } else {
         Client.screenX = -1;
         Client.screenY = -1;
      }
   }
}
