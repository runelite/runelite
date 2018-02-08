import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   @Export("keyboard")
   public static KeyFocusListener keyboard;
   @ObfuscatedName("j")
   static int[] field623;
   @ObfuscatedName("cj")
   @Export("keyPressed")
   public static boolean[] keyPressed;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -465748821
   )
   public static int field608;
   @ObfuscatedName("cg")
   public static int[] field609;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 1227126731
   )
   public static int field610;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -1104179147
   )
   public static int field614;
   @ObfuscatedName("cb")
   static char[] field612;
   @ObfuscatedName("cm")
   static int[] field603;
   @ObfuscatedName("cu")
   public static int[] field615;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -1599392479
   )
   public static int field607;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 462042515
   )
   public static int field622;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -1692419179
   )
   public static int field591;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1992491837
   )
   public static int field618;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -1971699435
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks;
   @ObfuscatedName("cs")
   @Export("KeyHandler_keyCodes")
   static int[] KeyHandler_keyCodes;
   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   static Widget field624;

   static {
      keyboard = new KeyFocusListener();
      keyPressed = new boolean[112];
      field609 = new int[128];
      field610 = 0;
      field614 = 0;
      field612 = new char[128];
      field603 = new int[128];
      field615 = new int[128];
      field607 = 0;
      field622 = 0;
      field591 = 0;
      field618 = 0;
      keyboardIdleTicks = 0;
      KeyHandler_keyCodes = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
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
            field609[field614] = ~var2;
            field614 = field614 + 1 & 127;
            if(field614 == field610) {
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
               label63: {
                  if(var2 != 0) {
                     char[] var7 = class289.cp1252AsciiExtension;

                     for(int var5 = 0; var5 < var7.length; ++var5) {
                        char var6 = var7[var5];
                        if(var2 == var6) {
                           var3 = true;
                           break label63;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var4 = field591 + 1 & 127;
               if(var4 != field622) {
                  field603[field591] = -1;
                  field612[field591] = var2;
                  field591 = var4;
               }
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field614 = -1;
      }

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
            field609[field614] = var2;
            field614 = field614 + 1 & 127;
            if(field614 == field610) {
               field614 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field591 + 1 & 127;
            if(var3 != field622) {
               field603[field591] = var2;
               field612[field591] = 0;
               field591 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "90"
   )
   public static boolean method733(int var0) {
      return (var0 >> 21 & 1) != 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lbg;",
      garbageValue = "1647184274"
   )
   static Preferences method731() {
      FileOnDisk var0 = null;
      Preferences var1 = new Preferences();

      try {
         var0 = VertexNormal.getPreferencesFile("", AbstractSoundSystem.field1553.name, false);
         byte[] var2 = new byte[(int)var0.length()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.read(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new Preferences(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.close();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-109"
   )
   static final void method732() {
      int var0 = class56.menuX;
      int var1 = class225.menuY;
      int var2 = WorldComparator.field265;
      int var3 = ScriptEvent.field772;
      int var4 = 6116423;
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, var4);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0 + 1, var1 + 1, var2 - 2, 16, 0);
      Rasterizer2D.drawRectangle(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      IndexDataBase.fontBold12.method5384("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = MouseInput.mouseLastX;
      int var6 = MouseInput.mouseLastY;

      int var7;
      int var8;
      int var9;
      for(var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         var8 = var1 + (Client.menuOptionCount - 1 - var7) * 15 + 31;
         var9 = 16777215;
         if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         Font var10 = IndexDataBase.fontBold12;
         String var11;
         if(var7 < 0) {
            var11 = "";
         } else if(Client.menuTargets[var7].length() > 0) {
            var11 = Client.menuOptions[var7] + " " + Client.menuTargets[var7];
         } else {
            var11 = Client.menuOptions[var7];
         }

         var10.method5384(var11, var0 + 3, var8, var9, 0);
      }

      var7 = class56.menuX;
      var8 = class225.menuY;
      var9 = WorldComparator.field265;
      int var12 = ScriptEvent.field772;

      for(int var13 = 0; var13 < Client.widgetCount; ++var13) {
         if(Client.widgetPositionX[var13] + Client.widgetBoundsWidth[var13] > var7 && Client.widgetPositionX[var13] < var9 + var7 && Client.widgetBoundsHeight[var13] + Client.widgetPositionY[var13] > var8 && Client.widgetPositionY[var13] < var8 + var12) {
            Client.field906[var13] = true;
         }
      }

   }
}
