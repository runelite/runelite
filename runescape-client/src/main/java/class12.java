import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Comparator;
import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
final class class12 implements Comparator {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   public static class112 field260;
   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field262;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = -848494787
   )
   static int field258;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lt;Lt;I)I",
      garbageValue = "101760607"
   )
   int method57(class14 var1, class14 var2) {
      return var1.field278 < var2.field278?-1:(var2.field278 == var1.field278?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method57((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IB)I",
      garbageValue = "-128"
   )
   public static int method64(CharSequence var0, int var1) {
      return class162.parseInt(var0, var1, true);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lip;Lip;ZII)V",
      garbageValue = "1059271861"
   )
   static void method56(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class92.field1414) {
         if(var3 == 4) {
            class92.loginIndex = 4;
         }

      } else {
         class92.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.method4027("title.jpg", "");
         BufferedImage var6 = null;

         SpritePixels var5;
         label155: {
            try {
               var6 = ImageIO.read(new ByteArrayInputStream(var4));
               int var7 = var6.getWidth();
               int var8 = var6.getHeight();
               int[] var9 = new int[var7 * var8];
               PixelGrabber var10 = new PixelGrabber(var6, 0, 0, var7, var8, var9, 0, var7);
               var10.grabPixels();
               var5 = new SpritePixels(var9, var7, var8);
               break label155;
            } catch (IOException var13) {
               ;
            } catch (InterruptedException var14) {
               ;
            }

            var5 = new SpritePixels(0, 0);
         }

         class92.field1394 = var5;
         class92.field1399 = class92.field1394.method4947();
         if((Client.flags & 536870912) != 0) {
            class92.logoSprite = Occluder.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class92.logoSprite = Occluder.getSprite(var1, "logo", "");
         }

         class92.field1396 = Occluder.getSprite(var1, "titlebox", "");
         class92.field1397 = Occluder.getSprite(var1, "titlebutton", "");
         class36.field493 = class269.method4758(var1, "runes", "");
         AbstractByteBuffer.titlemuteSprite = class269.method4758(var1, "title_mute", "");
         class177.field2382 = Occluder.getSprite(var1, "options_radio_buttons,0", "");
         WorldMapType1.field413 = Occluder.getSprite(var1, "options_radio_buttons,2", "");
         class31.field431 = new int[256];

         int var11;
         for(var11 = 0; var11 < 64; ++var11) {
            class31.field431[var11] = var11 * 262144;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class31.field431[var11 + 64] = var11 * 1024 + 16711680;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class31.field431[var11 + 128] = 4 * var11 + 16776960;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class31.field431[var11 + 192] = 16777215;
         }

         class92.field1405 = new int[256];

         for(var11 = 0; var11 < 64; ++var11) {
            class92.field1405[var11] = var11 * 1024;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class92.field1405[var11 + 64] = var11 * 4 + '\uff00';
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class92.field1405[var11 + 128] = var11 * 262144 + '\uffff';
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class92.field1405[var11 + 192] = 16777215;
         }

         VertexNormal.field1970 = new int[256];

         for(var11 = 0; var11 < 64; ++var11) {
            VertexNormal.field1970[var11] = var11 * 4;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            VertexNormal.field1970[var11 + 64] = 262144 * var11 + 255;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            VertexNormal.field1970[var11 + 128] = var11 * 1024 + 16711935;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            VertexNormal.field1970[var11 + 192] = 16777215;
         }

         class67.field816 = new int[256];
         class92.field1406 = new int['耀'];
         class92.field1409 = new int['耀'];
         class20.method151((IndexedSprite)null);
         class24.field348 = new int['耀'];
         CombatInfo1.field1271 = new int['耀'];
         if(var2) {
            class92.username = "";
            class92.password = "";
         }

         Ignore.authCodeForLogin = 0;
         Occluder.authCode = "";
         class92.field1424 = true;
         class92.worldSelectShown = false;
         if(!class34.preferences.muted) {
            Permission.method3996(2, class8.indexTrack1, "scape main", "", 255, false);
         } else {
            class112.method2031(2);
         }

         CombatInfoListHolder.sendConInfo(false);
         class92.field1414 = true;
         class92.field1417 = (class45.canvasWidth - 765) / 2;
         class92.loginWindowX = class92.field1417 + 202;
         class92.field1394.method4956(class92.field1417, 0);
         class92.field1399.method4956(class92.field1417 + 382, 0);
         class92.logoSprite.method4941(class92.field1417 + 382 - class92.logoSprite.originalWidth / 2, 18);
      }
   }
}
