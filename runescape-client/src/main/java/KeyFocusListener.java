import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("ot")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   @Export("clanMemberManager")
   static ClanMemberManager clanMemberManager;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lad;"
   )
   @Export("keyboard")
   static KeyFocusListener keyboard;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "Llf;"
   )
   @Export("rasterProvider")
   public static BufferProvider rasterProvider;
   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "Llu;"
   )
   @Export("loginType")
   static JagexLoginType loginType;
   @ObfuscatedName("co")
   @Export("keyPressed")
   public static boolean[] keyPressed;
   @ObfuscatedName("cq")
   static int[] releasedKeys;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -642864633
   )
   static int field602;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1725353421
   )
   static int field603;
   @ObfuscatedName("ce")
   static char[] typedKeys;
   @ObfuscatedName("cx")
   static int[] pressedKeys;
   @ObfuscatedName("cy")
   public static int[] field606;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -1774127637
   )
   public static int field600;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 1092602855
   )
   static int currentEventIndex;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -1147949605
   )
   static int keyEventIndex;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 1886525411
   )
   static int field610;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 1669368153
   )
   @Export("keyboardIdleTicks")
   static volatile int keyboardIdleTicks;
   @ObfuscatedName("ca")
   @Export("KeyHandler_keyCodes")
   static int[] KeyHandler_keyCodes;

   static {
      keyboard = new KeyFocusListener();
      keyPressed = new boolean[112];
      releasedKeys = new int[128];
      field602 = 0;
      field603 = 0;
      typedKeys = new char[128];
      pressedKeys = new int[128];
      field606 = new int[128];
      field600 = 0;
      currentEventIndex = 0;
      keyEventIndex = 0;
      field610 = 0;
      keyboardIdleTicks = 0;
      KeyHandler_keyCodes = new int[]{
              -1,
              -1,
              -1,
              -1,
              -1,
              -1,
              -1,
              -1,
              85, // backspace
              80, // tab
              84, // enter
              -1,
              91, // clear
              -1,
              -1,
              -1,
              81, // shift
              82, // ctrl
              86, // alt
              -1,
              -1,
              -1,
              -1,
              -1,
              -1,
              -1,
              -1,
              13, // esc
              -1,
              -1,
              -1,
              -1,
              83,  // space
              104, // pg up
              105, // pg down
              103, // end
              102, // home
              96,  // left
              98,  // up
              97,  // right
              99,  // down
              -1,
              -1,
              -1,
              -1,
              -1,
              -1,
              -1,
              25, // 0
              16, // 1
              17, // 2
              18, // 3
              19, // 4
              20, // 5
              21, // 6
              22, // 7
              23, // 8
              24, // 9
              -1,
              -1,
              -1,
              -1,
              -1,
              -1,
              -1,
              48, // a
              68, // b
              66, // c
              50, // d
              34, // e
              51, // f
              52, // g
              53, // h
              39, // i
              54, // j
              55, // k
              56, // l
              70, // m
              69, // n
              40, // o
              41, // p
              32, // q
              35, // r
              49, // s
              36, // t
              38, // u
              67, // v
              33, // w
              65, // x
              37, // y
              64, // z
              -1,
              -1,
              -1,
              -1,
              -1,
              228, // numpad 0
              231, // numpad 1
              227, // numpad 2
              233, // numpad 3
              224, // numpad 4
              219, // numpad 5
              225, // numpad 6
              230, // numpad 7
              226, // numpad 8
              232, // numpad 9
              89,  // multiply
              87,  // add
              -1,
              88,  // subtract
              229, // decimal
              90,  // divide
              1,   // f1
              2,   // f2
              3,   // f3
              4,   // f4
              5,   // f5
              6,   // f6
              7,   // f7
              8,   // f8
              9,   // f9
              10,  // f10
              11,  // f11
              12,  // f12
              -1,
              -1,
              -1,
              101, // 0x7F delete
              -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1,
              100, // 0x9B insert
              -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1
      };
   }

   @Export("focusLost")
   @Hook("focusLost")
   @ObfuscatedName("focusLost")
   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field603 = -1;
      }

   }

   @Export("keyTyped")
   @ObfuscatedName("keyTyped")
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
               int var4 = keyEventIndex + 1 & 127;
               if(var4 != currentEventIndex) {
                  pressedKeys[keyEventIndex] = -1;
                  typedKeys[keyEventIndex] = var2;
                  keyEventIndex = var4;
               }
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   @Export("keyReleased")
   @ObfuscatedName("keyReleased")
   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
            var2 = KeyHandler_keyCodes[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field603 >= 0 && var2 >= 0) {
            releasedKeys[field603] = ~var2;
            field603 = field603 + 1 & 127;
            if(field603 == field602) {
               field603 = -1;
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

         if(field603 >= 0 && var2 >= 0) {
            releasedKeys[field603] = var2;
            field603 = field603 + 1 & 127;
            if(field602 == field603) {
               field603 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = keyEventIndex + 1 & 127;
            if(var3 != currentEventIndex) {
               pressedKeys[keyEventIndex] = var2;
               typedKeys[keyEventIndex] = 0;
               keyEventIndex = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-795924043"
   )
   static void method828(Component var0) {
      var0.addMouseListener(MouseInput.mouse);
      var0.addMouseMotionListener(MouseInput.mouse);
      var0.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZB)Z",
      garbageValue = "-2"
   )
   public static boolean method829(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIIS)I",
      garbageValue = "19118"
   )
   public static int method830(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }
}
