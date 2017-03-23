import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public final class class105 implements KeyListener, FocusListener {
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 1604550707
   )
   public static int field1716 = 0;
   @ObfuscatedName("x")
   @Export("keyboard")
   public static class105 keyboard = new class105();
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 231864247
   )
   static int field1720 = 0;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 1961420355
   )
   static int field1721 = 0;
   @ObfuscatedName("cy")
   static char[] field1722 = new char[128];
   @ObfuscatedName("cz")
   static int[] field1723 = new int[128];
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -1242791609
   )
   static int field1724 = 0;
   @ObfuscatedName("ck")
   public static boolean[] field1725 = new boolean[112];
   @ObfuscatedName("cx")
   static int[] field1726 = new int[128];
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 765113149
   )
   static int field1727 = 0;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -1062328915
   )
   static int field1728 = 0;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 235919241
   )
   @Export("keyboardIdleTicks")
   static volatile int keyboardIdleTicks = 0;
   @ObfuscatedName("cr")
   static int[] field1730 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = 1562169393
   )
   protected static int field1731;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = 1256942875
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("ak")
   static class102 field1733;
   @ObfuscatedName("cm")
   public static int[] field1735 = new int[128];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1165497485
   )
   public static int field1737;

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1730.length) {
            var2 = field1730[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field1721 >= 0 && var2 >= 0) {
            field1726[field1721] = ~var2;
            field1721 = 1 + field1721 & 127;
            if(field1721 == field1720) {
               field1721 = -1;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != keyboard) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1730.length) {
            var2 = field1730[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field1721 >= 0 && var2 >= 0) {
            field1726[field1721] = var2;
            field1721 = 1 + field1721 & 127;
            if(field1721 == field1720) {
               field1721 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field1727 + 1 & 127;
            if(field1724 != var3) {
               field1723[field1727] = var2;
               field1722[field1727] = 0;
               field1727 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "54998299"
   )
   static void method2058() {
      if(class108.loadWorlds()) {
         class41.worldSelectShown = true;
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != keyboard) {
         field1721 = -1;
      }

   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff' && class157.method3068(var2)) {
            int var3 = field1727 + 1 & 127;
            if(var3 != field1724) {
               field1723[field1727] = -1;
               field1722[field1727] = var2;
               field1727 = var3;
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass182;Lclass182;ZII)V",
      garbageValue = "-1985139671"
   )
   static void method2066(Component var0, class182 var1, class182 var2, boolean var3, int var4) {
      if(class41.field868) {
         if(var4 == 4) {
            class41.loginIndex = 4;
         }

      } else {
         class41.loginIndex = var4;
         Rasterizer2D.method4030();
         byte[] var5 = var1.method3323("title.jpg", "");
         class41.field880 = new SpritePixels(var5, var0);
         class41.field850 = class41.field880.method4203();
         if((Client.flags & 536870912) != 0) {
            class186.field2763 = class26.method600(var2, "logo_deadman_mode", "");
         } else {
            class186.field2763 = class26.method600(var2, "logo", "");
         }

         class41.field882 = class26.method600(var2, "titlebox", "");
         class41.field847 = class26.method600(var2, "titlebutton", "");
         class205.field3095 = class0.method15(var2, "runes", "");
         GroundObject.field1310 = class0.method15(var2, "title_mute", "");
         class41.field851 = class26.method600(var2, "options_radio_buttons,0", "");
         class41.field852 = class26.method600(var2, "options_radio_buttons,2", "");
         class8.field83 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class8.field83[var6] = var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class8.field83[64 + var6] = 1024 * var6 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class8.field83[128 + var6] = 16776960 + 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class8.field83[192 + var6] = 16777215;
         }

         class176.field2648 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class176.field2648[var6] = 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class176.field2648[64 + var6] = var6 * 4 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class176.field2648[128 + var6] = '\uffff' + 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class176.field2648[192 + var6] = 16777215;
         }

         class41.field857 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field857[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field857[64 + var6] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field857[128 + var6] = 16711935 + var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field857[192 + var6] = 16777215;
         }

         class7.field71 = new int[256];
         class36.field807 = new int['耀'];
         class41.field860 = new int['耀'];
         class30.method688((ModIcon)null);
         XGrandExchangeOffer.field48 = new int['耀'];
         class161.field2130 = new int['耀'];
         if(var3) {
            class41.username = "";
            class41.password = "";
         }

         CombatInfoListHolder.field781 = 0;
         class146.authCode = "";
         class41.field875 = true;
         class41.worldSelectShown = false;
         if(!class8.field84.field712) {
            class184 var9 = class3.field39;
            int var7 = var9.method3321("scape main");
            int var8 = var9.method3322(var7, "");
            class138.field1920 = 1;
            class138.field1916 = var9;
            class138.field1922 = var7;
            class8.field86 = var8;
            Ignore.field245 = 255;
            class138.field1923 = false;
            XClanMember.field302 = 2;
         } else {
            GroundObject.method1595(2);
         }

         class44.method884(false);
         class41.field868 = true;
         class41.field846 = (class108.field1748 - Client.field528) / 2;
         class41.loginWindowX = 202 + class41.field846;
         class41.field880.method4147(class41.field846, 0);
         class41.field850.method4147(class41.field846 + 382, 0);
         class186.field2763.method4090(class41.field846 + 382 - class186.field2763.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "639959636"
   )
   public static int method2080(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;B)V",
      garbageValue = "103"
   )
   static final void method2087(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      if(var4 != null) {
         int var6 = Client.mapScale + Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class84.field1441[var6];
            int var9 = class84.field1462[var6];
            var8 = 256 * var8 / (Client.mapScaleDelta + 256);
            var9 = 256 * var9 / (Client.mapScaleDelta + 256);
            int var10 = var8 * var3 + var2 * var9 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method4159(var10 + var5.field2146 / 2 - var4.maxWidth / 2, var5.field2150 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2146, var5.field2150, var5.field2141, var5.field2142);
            } else {
               var4.method4149(var10 + var0 + var5.field2146 / 2 - var4.maxWidth / 2, var5.field2150 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}
