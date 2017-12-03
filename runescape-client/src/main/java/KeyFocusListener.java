import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lar;"
   )
   @Export("keyboard")
   public static KeyFocusListener keyboard;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static IndexDataBase field589;
   @ObfuscatedName("ce")
   public static boolean[] field593;
   @ObfuscatedName("cs")
   public static int[] field607;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -1512651883
   )
   public static int field596;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 127277717
   )
   public static int field597;
   @ObfuscatedName("co")
   static char[] field598;
   @ObfuscatedName("cg")
   static int[] field599;
   @ObfuscatedName("cy")
   public static int[] field600;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 40357429
   )
   public static int field601;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -269192015
   )
   public static int field602;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 809111005
   )
   public static int field590;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 1644143225
   )
   public static int field604;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -1997209807
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks;
   @ObfuscatedName("cx")
   @Export("KeyHandler_keyCodes")
   static int[] KeyHandler_keyCodes;

   static {
      keyboard = new KeyFocusListener();
      field593 = new boolean[112];
      field607 = new int[128];
      field596 = 0;
      field597 = 0;
      field598 = new char[128];
      field599 = new int[128];
      field600 = new int[128];
      field601 = 0;
      field602 = 0;
      field590 = 0;
      field604 = 0;
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

         if(field597 >= 0 && var2 >= 0) {
            field607[field597] = var2;
            field597 = field597 + 1 & 127;
            if(field596 == field597) {
               field597 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field590 + 1 & 127;
            if(var3 != field602) {
               field599[field590] = var2;
               field598[field590] = 0;
               field590 = var3;
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

         if(field597 >= 0 && var2 >= 0) {
            field607[field597] = ~var2;
            field597 = field597 + 1 & 127;
            if(field596 == field597) {
               field597 = -1;
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
                     char[] var7 = class277.cp1252AsciiExtension;

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
               int var4 = field590 + 1 & 127;
               if(var4 != field602) {
                  field599[field590] = -1;
                  field598[field590] = var2;
                  field590 = var4;
               }
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field597 = -1;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "1948992354"
   )
   static void method751(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method751(var0, var1, var2, var5 - 1);
         method751(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lib;Ljava/lang/String;Ljava/lang/String;I)[Lks;",
      garbageValue = "-2121269127"
   )
   @Export("getSprites")
   public static SpritePixels[] getSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return SceneTilePaint.method2685(var0, var3, var4);
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "10"
   )
   static void method750(int var0) {
      for(IntegerNode var1 = (IntegerNode)Client.widgetFlags.first(); var1 != null; var1 = (IntegerNode)Client.widgetFlags.next()) {
         if((long)var0 == (var1.hash >> 48 & 65535L)) {
            var1.unlink();
         }
      }

   }
}
