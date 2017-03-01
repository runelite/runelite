import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public final class class10 {
   @ObfuscatedName("r")
   static final int[] field79 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("n")
   @Export("tileSettings")
   static byte[][][] tileSettings = new byte[4][104][104];
   @ObfuscatedName("u")
   static final int[] field81 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1427544245
   )
   static int field82 = 99;
   @ObfuscatedName("m")
   static byte[][][] field83;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = -1564213757
   )
   static int field84;
   @ObfuscatedName("l")
   static final int[] field85 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("x")
   @Export("tileHeights")
   static int[][][] tileHeights = new int[4][105][105];
   @ObfuscatedName("y")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("e")
   static final int[] field88 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("i")
   static int[] field89;
   @ObfuscatedName("d")
   static final int[] field90 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1664289953
   )
   static int field91 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -559474857
   )
   static int field92 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("h")
   static final int[] field93 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = 236090523
   )
   @Export("cameraPitch")
   static int cameraPitch;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass182;Lclass182;ZII)V",
      garbageValue = "-1172548136"
   )
   static void method130(Component var0, class182 var1, class182 var2, boolean var3, int var4) {
      if(class41.field858) {
         if(var4 == 4) {
            class41.loginIndex = 4;
         }

      } else {
         class41.loginIndex = var4;
         Rasterizer2D.method4017();
         byte[] var5 = var1.method3371("title.jpg", "");
         class41.field824 = new SpritePixels(var5, var0);
         class41.field825 = class41.field824.method4214();
         if((Client.flags & 536870912) != 0) {
            class168.field2191 = class162.method3186(var2, "logo_deadman_mode", "");
         } else {
            class168.field2191 = class162.method3186(var2, "logo", "");
         }

         class41.field821 = class162.method3186(var2, "titlebox", "");
         class41.field826 = class162.method3186(var2, "titlebutton", "");
         ScriptState.field95 = XItemContainer.method169(var2, "runes", "");
         class189.field2789 = XItemContainer.method169(var2, "title_mute", "");
         FaceNormal.field1568 = class162.method3186(var2, "options_radio_buttons,0", "");
         class41.field835 = class162.method3186(var2, "options_radio_buttons,2", "");
         class41.field830 = new int[256];

         int var9;
         for(var9 = 0; var9 < 64; ++var9) {
            class41.field830[var9] = var9 * 262144;
         }

         for(var9 = 0; var9 < 64; ++var9) {
            class41.field830[64 + var9] = 16711680 + 1024 * var9;
         }

         for(var9 = 0; var9 < 64; ++var9) {
            class41.field830[var9 + 128] = 16776960 + var9 * 4;
         }

         for(var9 = 0; var9 < 64; ++var9) {
            class41.field830[var9 + 192] = 16777215;
         }

         NPC.field765 = new int[256];

         for(var9 = 0; var9 < 64; ++var9) {
            NPC.field765[var9] = var9 * 1024;
         }

         for(var9 = 0; var9 < 64; ++var9) {
            NPC.field765[var9 + 64] = var9 * 4 + '\uff00';
         }

         for(var9 = 0; var9 < 64; ++var9) {
            NPC.field765[128 + var9] = '\uffff' + 262144 * var9;
         }

         for(var9 = 0; var9 < 64; ++var9) {
            NPC.field765[192 + var9] = 16777215;
         }

         PlayerComposition.field2178 = new int[256];

         for(var9 = 0; var9 < 64; ++var9) {
            PlayerComposition.field2178[var9] = var9 * 4;
         }

         for(var9 = 0; var9 < 64; ++var9) {
            PlayerComposition.field2178[64 + var9] = 262144 * var9 + 255;
         }

         for(var9 = 0; var9 < 64; ++var9) {
            PlayerComposition.field2178[var9 + 128] = 1024 * var9 + 16711935;
         }

         for(var9 = 0; var9 < 64; ++var9) {
            PlayerComposition.field2178[var9 + 192] = 16777215;
         }

         class211.field3132 = new int[256];
         class185.field2768 = new int['耀'];
         XGrandExchangeOffer.field34 = new int['耀'];
         FrameMap.method1787((ModIcon)null);
         class47.field946 = new int['耀'];
         class30.field688 = new int['耀'];
         if(var3) {
            class41.username = "";
            class41.field845 = "";
         }

         class6.field54 = 0;
         XItemContainer.authCode = "";
         class41.field847 = true;
         class41.worldSelectShown = false;
         if(!ObjectComposition.field2944.field691) {
            class184 var6 = Client.field306;
            int var7 = var6.method3426("scape main");
            int var8 = var6.method3370(var7, "");
            Renderable.method1971(2, var6, var7, var8, 255, false);
         } else {
            WallObject.method1982(2);
         }

         class172.method3331(false);
         class41.field858 = true;
         class41.field822 = (RSCanvas.field1756 - Client.field504) / 2;
         class41.loginWindowX = 202 + class41.field822;
         class41.field824.method4172(class41.field822, 0);
         class41.field825.method4172(class41.field822 + 382, 0);
         class168.field2191.method4115(class41.field822 + 382 - class168.field2191.originalWidth / 2, 18);
      }
   }

   class10() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass184;",
      garbageValue = "-1024151429"
   )
   static class184 method148(int var0, boolean var1, boolean var2, boolean var3) {
      class116 var4 = null;
      if(null != class104.field1699) {
         var4 = new class116(var0, class104.field1699, WidgetNode.field182[var0], 1000000);
      }

      return new class184(var4, class18.field200, var0, var1, var2, var3);
   }
}
