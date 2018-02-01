import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      intValue = -1165136445
   )
   static int field598;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   @Export("keyboard")
   public static KeyFocusListener keyboard;
   @ObfuscatedName("cl")
   @Export("keyPressed")
   public static boolean[] keyPressed;
   @ObfuscatedName("co")
   public static int[] field586;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 1095649741
   )
   public static int field587;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -1836513709
   )
   public static int field588;
   @ObfuscatedName("cn")
   static char[] field582;
   @ObfuscatedName("cb")
   static int[] field576;
   @ObfuscatedName("cq")
   public static int[] field591;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 963445957
   )
   public static int field592;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 355909849
   )
   public static int field593;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -810682453
   )
   public static int field590;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -1787856307
   )
   public static int field595;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -1043470355
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks;
   @ObfuscatedName("ce")
   @Export("KeyHandler_keyCodes")
   static int[] KeyHandler_keyCodes;

   static {
      keyboard = new KeyFocusListener();
      keyPressed = new boolean[112];
      field586 = new int[128];
      field587 = 0;
      field588 = 0;
      field582 = new char[128];
      field576 = new int[128];
      field591 = new int[128];
      field592 = 0;
      field593 = 0;
      field590 = 0;
      field595 = 0;
      keyboardIdleTicks = 0;
      KeyHandler_keyCodes = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff' && Actor.method1597(var2)) {
            int var3 = field590 + 1 & 127;
            if(var3 != field593) {
               field576[field590] = -1;
               field582[field590] = var2;
               field590 = var3;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field588 = -1;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
            var2 = KeyHandler_keyCodes[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field588 >= 0 && var2 >= 0) {
            field586[field588] = ~var2;
            field588 = field588 + 1 & 127;
            if(field587 == field588) {
               field588 = -1;
            }
         }
      }

      var1.consume();
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

         if(field588 >= 0 && var2 >= 0) {
            field586[field588] = var2;
            field588 = field588 + 1 & 127;
            if(field587 == field588) {
               field588 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field590 + 1 & 127;
            if(var3 != field593) {
               field576[field590] = var2;
               field582[field590] = 0;
               field590 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lhe;III)Lcd;",
      garbageValue = "-109814653"
   )
   static Script method735(class230 var0, int var1, int var2) {
      int var3 = class192.method3700(var1, var0);
      Script var4 = ScriptVarType.getScriptByFile(var3, var0);
      if(var4 != null) {
         return var4;
      } else {
         int var5 = var0.field2877 + (var2 + 40000 << 8);
         var4 = ScriptVarType.getScriptByFile(var5, var0);
         return var4 != null?var4:null;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1593843414"
   )
   public static void method759() {
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(Lba;B)V",
      garbageValue = "-21"
   )
   static final void method760(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = class48.region.method2895(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = class48.region.method2873(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = class48.region.method2839(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = class48.region.method2840(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = class48.region.getObjectFlags(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1086 = var2;
      var0.field1087 = var3;
      var0.field1084 = var4;
   }
}
