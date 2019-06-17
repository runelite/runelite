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
   @Export("__an_ra")
   static int __an_ra;
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
   @Export("__an_x")
   static IndexedSprite[] __an_x;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   @Export("__an_i")
   static IndexedSprite __an_i;
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
   @Export("__an_cq")
   static int[] __an_cq;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 1112094745
   )
   @Export("__an_ch")
   static int __an_ch;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -1208053825
   )
   @Export("__an_cw")
   static int __an_cw;
   @ObfuscatedName("cg")
   @Export("__an_cg")
   static char[] __an_cg;
   @ObfuscatedName("cf")
   @Export("__an_cf")
   static int[] __an_cf;
   @ObfuscatedName("cp")
   @Export("__an_cp")
   public static int[] __an_cp;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -674534717
   )
   @Export("__an_cl")
   public static int __an_cl;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -93280591
   )
   @Export("__an_ct")
   static int __an_ct;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 2066759739
   )
   @Export("__an_cz")
   static int __an_cz;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -1942898885
   )
   @Export("__an_cc")
   static int __an_cc;
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
      if(KeyHandler_instance != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
            var2 = KeyHandler_keyCodes[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(__an_cw >= 0 && var2 >= 0) {
            __an_cq[__an_cw] = var2;
            __an_cw = __an_cw + 1 & 127;
            if(__an_ch == __an_cw) {
               __an_cw = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = __an_cz + 1 & 127;
            if(var3 != __an_ct) {
               __an_cf[__an_cz] = var2;
               __an_cg[__an_cz] = 0;
               __an_cz = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
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
      if(KeyHandler_instance != null) {
         __an_cw = -1;
      }

   }

   @Export("keyReleased")
   @ObfuscatedName("keyReleased")
   public final synchronized void keyReleased(KeyEvent var1) {
      if(KeyHandler_instance != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
            var2 = KeyHandler_keyCodes[var2] & -129;
         } else {
            var2 = -1;
         }

         if(__an_cw >= 0 && var2 >= 0) {
            __an_cq[__an_cw] = ~var2;
            __an_cw = __an_cw + 1 & 127;
            if(__an_ch == __an_cw) {
               __an_cw = -1;
            }
         }
      }

      var1.consume();
   }

   @Export("keyTyped")
   @ObfuscatedName("keyTyped")
   public final void keyTyped(KeyEvent var1) {
      if(KeyHandler_instance != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label56: {
                  if(var2 != 0) {
                     char[] var4 = class304.cp1252AsciiExtension;

                     for(int var5 = 0; var5 < var4.length; ++var5) {
                        char var6 = var4[var5];
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
               int var7 = __an_cz + 1 & 127;
               if(var7 != __an_ct) {
                  __an_cf[__an_cz] = -1;
                  __an_cg[__an_cz] = var2;
                  __an_cz = var7;
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
      for(Iterator var2 = Messages.Messages_hashTable.iterator(); var2.hasNext(); var0 = var0 + var1.sender + ':' + var1.text + '\n') {
         var1 = (Message)var2.next();
      }

      return var0;
   }

   static {
      KeyHandler_instance = new KeyHandler();
      KeyHandler_pressedKeys = new boolean[112];
      __an_cq = new int[128];
      __an_ch = 0;
      __an_cw = 0;
      __an_cg = new char[128];
      __an_cf = new int[128];
      __an_cp = new int[128];
      __an_cl = 0;
      __an_ct = 0;
      __an_cz = 0;
      __an_cc = 0;
      KeyHandler_idleCycles = 0;
      KeyHandler_keyCodes = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }
}
