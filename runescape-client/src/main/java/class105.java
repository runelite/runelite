import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public final class class105 implements KeyListener, FocusListener {
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -189679741
   )
   static int field1696 = 0;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -1699967611
   )
   static int field1701 = 0;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 1198626167
   )
   static int field1709 = 0;
   @ObfuscatedName("ci")
   static char[] field1714 = new char[128];
   @ObfuscatedName("cc")
   static int[] field1715 = new int[128];
   @ObfuscatedName("ck")
   static int[] field1716 = new int[128];
   @ObfuscatedName("o")
   @Export("keyboard")
   static class105 keyboard = new class105();
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = -976025369
   )
   protected static int field1720;
   @ObfuscatedName("cq")
   public static int[] field1721 = new int[128];
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1447470011
   )
   public static int field1722 = 0;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -1469005157
   )
   static int field1723 = 0;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 117925105
   )
   static int field1724 = 0;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -1306888715
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks = 0;
   @ObfuscatedName("cd")
   static int[] field1727 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("co")
   public static boolean[] field1728 = new boolean[112];

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != keyboard) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1727.length) {
            var2 = field1727[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field1709 >= 0 && var2 >= 0) {
            field1716[field1709] = var2;
            field1709 = field1709 + 1 & 127;
            if(field1709 == field1701) {
               field1709 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field1724 + 1 & 127;
            if(var3 != field1723) {
               field1715[field1724] = var2;
               field1714[field1724] = 0;
               field1724 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(null != keyboard) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1727.length) {
            var2 = field1727[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field1709 >= 0 && var2 >= 0) {
            field1716[field1709] = ~var2;
            field1709 = 1 + field1709 & 127;
            if(field1709 == field1701) {
               field1709 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff' && class40.method735(var2)) {
            int var3 = 1 + field1724 & 127;
            if(field1723 != var3) {
               field1715[field1724] = -1;
               field1714[field1724] = var2;
               field1724 = var3;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != keyboard) {
         field1709 = -1;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;Lclass139;I)Z",
      garbageValue = "1772993612"
   )
   public static boolean method1969(class182 var0, class182 var1, class182 var2, class139 var3) {
      class138.field1934 = var0;
      class138.field1928 = var1;
      class138.field1927 = var2;
      class138.field1926 = var3;
      return true;
   }
}
