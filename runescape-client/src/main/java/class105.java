import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public final class class105 implements KeyListener, FocusListener {
   @ObfuscatedName("cj")
   static int[] field1724 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 1304557351
   )
   public static int field1726 = 0;
   @ObfuscatedName("cr")
   public static boolean[] field1734 = new boolean[112];
   @ObfuscatedName("cp")
   public static int[] field1735 = new int[128];
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -260598339
   )
   public static int field1736 = 0;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -730213105
   )
   public static int field1737 = 0;
   @ObfuscatedName("cc")
   static char[] field1738 = new char[128];
   @ObfuscatedName("cq")
   static int[] field1739 = new int[128];
   @ObfuscatedName("cm")
   public static int[] field1740 = new int[128];
   @ObfuscatedName("f")
   @Export("keyboard")
   public static class105 keyboard = new class105();
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 1352228569
   )
   public static int field1742 = 0;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1044206861
   )
   public static int field1743 = 0;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 1372248781
   )
   public static int field1745 = 0;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 714405235
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks = 0;

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != keyboard) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1724.length) {
            var2 = field1724[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field1743 >= 0 && var2 >= 0) {
            field1735[field1743] = var2;
            field1743 = 1 + field1743 & 127;
            if(field1743 == field1736) {
               field1743 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = 1 + field1737 & 127;
            if(field1742 != var3) {
               field1739[field1737] = var2;
               field1738[field1737] = 0;
               field1737 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field1743 = -1;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final void keyTyped(KeyEvent var1) {
      if(null != keyboard) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff' && class36.method757(var2)) {
            int var3 = field1737 + 1 & 127;
            if(var3 != field1742) {
               field1739[field1737] = -1;
               field1738[field1737] = var2;
               field1737 = var3;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1724.length) {
            var2 = field1724[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field1743 >= 0 && var2 >= 0) {
            field1735[field1743] = ~var2;
            field1743 = field1743 + 1 & 127;
            if(field1743 == field1736) {
               field1743 = -1;
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1502043260"
   )
   static final void method2064() {
      int[] var0 = class45.field918;

      int var1;
      for(var1 = 0; var1 < class45.field923; ++var1) {
         Player var4 = Client.cachedPlayers[var0[var1]];
         if(var4 != null && var4.field656 > 0) {
            --var4.field656;
            if(var4.field656 == 0) {
               var4.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.field402; ++var1) {
         int var2 = Client.field342[var1];
         NPC var3 = Client.cachedNPCs[var2];
         if(var3 != null && var3.field656 > 0) {
            --var3.field656;
            if(var3.field656 == 0) {
               var3.overhead = null;
            }
         }
      }

   }
}
