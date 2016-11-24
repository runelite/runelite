import java.applet.Applet;
import java.awt.Component;
import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public class class101 extends RuntimeException {
   @ObfuscatedName("n")
   static Applet field1643;
   @ObfuscatedName("d")
   public static String field1644;
   @ObfuscatedName("h")
   String field1646;
   @ObfuscatedName("w")
   Throwable field1647;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = -238847295
   )
   static int field1648;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1105981307
   )
   public static int field1649;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1062617677
   )
   static int field1650;
   @ObfuscatedName("pd")
   static GarbageCollectorMXBean field1651;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([Lclass165;IB)Lclass165;",
      garbageValue = "63"
   )
   public static class165 method1985(class165[] var0, int var1) {
      class165[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class165 var4 = var2[var3];
         if(var1 == var4.vmethod4132()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass182;Lclass182;ZII)V",
      garbageValue = "-174747007"
   )
   static void method1987(Component var0, class182 var1, class182 var2, boolean var3, int var4) {
      if(class41.field831) {
         if(var4 == 4) {
            class41.loginIndex = 4;
         }

      } else {
         class41.loginIndex = var4;
         class219.method4061();
         byte[] var5 = var1.method3346("title.jpg", "");
         class41.field821 = new SpritePixels(var5, var0);
         class41.field822 = class41.field821.method4205();
         if((Client.flags & 536870912) != 0) {
            class41.field823 = class189.method3506(var2, "logo_deadman_mode", "");
         } else {
            class41.field823 = class189.method3506(var2, "logo", "");
         }

         class41.field818 = class189.method3506(var2, "titlebox", "");
         class41.field819 = class189.method3506(var2, "titlebutton", "");
         class41.field820 = class183.method3419(var2, "runes", "");
         class181.field2706 = class183.method3419(var2, "title_mute", "");
         class8.field69 = class189.method3506(var2, "options_radio_buttons,0", "");
         class6.field56 = class189.method3506(var2, "options_radio_buttons,2", "");
         class137.field1909 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class137.field1909[var6] = var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class137.field1909[64 + var6] = 16711680 + var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class137.field1909[128 + var6] = 16776960 + 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class137.field1909[var6 + 192] = 16777215;
         }

         class38.field800 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class38.field800[var6] = 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class38.field800[var6 + 64] = var6 * 4 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class38.field800[var6 + 128] = '\uffff' + var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class38.field800[192 + var6] = 16777215;
         }

         class18.field200 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class18.field200[var6] = 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class18.field200[64 + var6] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class18.field200[128 + var6] = 16711935 + 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class18.field200[var6 + 192] = 16777215;
         }

         class107.field1730 = new int[256];
         class188.field2780 = new int['耀'];
         GroundObject.field1290 = new int['耀'];
         class34.method728((ModIcon)null);
         class8.field72 = new int['耀'];
         class119.field1848 = new int['耀'];
         if(var3) {
            class41.username = "";
            class41.field834 = "";
         }

         class60.field1075 = 0;
         class22.authCode = "";
         class41.field843 = true;
         class41.worldSelectShown = false;
         if(!Tile.field1343.field688) {
            class39.method773(2, class34.field746, "scape main", "", 255, false);
         } else {
            class138.field1917 = 1;
            class1.field12 = null;
            class138.field1918 = -1;
            Frames.field1566 = -1;
            field1649 = 0;
            class34.field742 = false;
            class114.field1792 = 2;
         }

         class7.method102(false);
         class41.field831 = true;
         class41.field848 = (class16.field169 - Client.field500) / 2;
         class41.loginWindowX = 202 + class41.field848;
         class41.field821.method4190(class41.field848, 0);
         class41.field822.method4190(class41.field848 + 382, 0);
         class41.field823.method4146(class41.field848 + 382 - class41.field823.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIBI)V",
      garbageValue = "-1449759915"
   )
   static final void method1988(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.method240();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var7 = class194.method3591(var4, var5, var0.method240(), class9.method114(var1, var2), Client.collisionMaps[var0.field267], true, Client.field549, Client.field300);
            if(var7 >= 1) {
               for(int var8 = 0; var8 < var7 - 1; ++var8) {
                  var0.method235(Client.field549[var8], Client.field300[var8], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "511236658"
   )
   static final void method1990(int var0, int var1, int var2, boolean var3) {
      if(class60.method1127(var0)) {
         Frames.method1930(Widget.widgets[var0], -1, var1, var2, var3);
      }
   }
}
