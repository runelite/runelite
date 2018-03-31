import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public abstract class class178 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -882661685
   )
   public int field2283;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1237071661
   )
   public int field2282;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 887492989
   )
   public int field2280;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -443205561
   )
   public int field2281;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIILfk;B)Z",
      garbageValue = "78"
   )
   protected abstract boolean vmethod3410(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljm;Ljm;ZII)V",
      garbageValue = "1394721650"
   )
   static void method3415(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class90.field1345) {
         if(var3 == 4) {
            class90.loginIndex = 4;
         }

      } else {
         class90.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.takeRecordByNames("title.jpg", "");
         BufferedImage var6 = null;

         SpritePixels var5;
         label159: {
            try {
               var6 = ImageIO.read(new ByteArrayInputStream(var4));
               int var7 = var6.getWidth();
               int var8 = var6.getHeight();
               int[] var9 = new int[var8 * var7];
               PixelGrabber var10 = new PixelGrabber(var6, 0, 0, var7, var8, var9, 0, var7);
               var10.grabPixels();
               var5 = new SpritePixels(var9, var7, var8);
               break label159;
            } catch (IOException var13) {
               ;
            } catch (InterruptedException var14) {
               ;
            }

            var5 = new SpritePixels(0, 0);
         }

         class317.field3926 = var5;
         class61.field715 = class317.field3926.method5924();
         if((Client.flags & 536870912) != 0) {
            class90.logoSprite = class44.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class90.logoSprite = class44.getSprite(var1, "logo", "");
         }

         class90.field1339 = class44.getSprite(var1, "titlebox", "");
         class203.field2605 = class44.getSprite(var1, "titlebutton", "");
         class90.runeSprites = class199.getIndexedSprites(var1, "runes", "");
         class38.titlemuteSprite = class199.getIndexedSprites(var1, "title_mute", "");
         TextureProvider.field1691 = class44.getSprite(var1, "options_radio_buttons,0", "");
         class90.field1342 = class44.getSprite(var1, "options_radio_buttons,4", "");
         class151.field2127 = class44.getSprite(var1, "options_radio_buttons,2", "");
         class304.field3848 = class44.getSprite(var1, "options_radio_buttons,6", "");
         class90.field1363 = TextureProvider.field1691.width;
         WorldMapType1.field415 = TextureProvider.field1691.height;
         class38.field489 = new int[256];

         int var12;
         for(var12 = 0; var12 < 64; ++var12) {
            class38.field489[var12] = var12 * 262144;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class38.field489[var12 + 64] = var12 * 1024 + 16711680;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class38.field489[var12 + 128] = var12 * 4 + 16776960;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class38.field489[var12 + 192] = 16777215;
         }

         class7.field231 = new int[256];

         for(var12 = 0; var12 < 64; ++var12) {
            class7.field231[var12] = var12 * 1024;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class7.field231[var12 + 64] = var12 * 4 + 65280;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class7.field231[var12 + 128] = var12 * 262144 + 65535;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class7.field231[var12 + 192] = 16777215;
         }

         class36.field480 = new int[256];

         for(var12 = 0; var12 < 64; ++var12) {
            class36.field480[var12] = var12 * 4;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class36.field480[var12 + 64] = var12 * 262144 + 255;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class36.field480[var12 + 128] = var12 * 1024 + 16711935;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class36.field480[var12 + 192] = 16777215;
         }

         Item.field1408 = new int[256];
         BaseVarType.field30 = new int['耀'];
         class5.field34 = new int['耀'];
         class20.method169((IndexedSprite)null);
         class90.field1362 = new int['耀'];
         RunException.field2181 = new int['耀'];
         if(var2) {
            class90.username = "";
            class90.password = "";
         }

         PendingSpawn.field1145 = 0;
         MapCacheArchiveNames.field520 = "";
         class90.field1344 = true;
         class90.worldSelectShown = false;
         if(!class46.preferences.muted) {
            class158.method3185(2, class1.indexTrack1, "scape main", "", 255, false);
         } else {
            IndexStoreActionHandler.method4660(2);
         }

         class189.sendConInfo(false);
         class90.field1345 = true;
         class90.field1338 = (Sequence.canvasWidth - 765) / 2;
         class90.loginWindowX = class90.field1338 + 202;
         GameCanvas.field630 = class90.loginWindowX + 180;
         class317.field3926.method5868(class90.field1338, 0);
         class61.field715.method5868(class90.field1338 + 382, 0);
         class90.logoSprite.method5842(class90.field1338 + 382 - class90.logoSprite.width / 2, 18);
      }
   }
}
