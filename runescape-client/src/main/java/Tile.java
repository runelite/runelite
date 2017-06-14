import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1219636581
   )
   int field1907;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -402673223
   )
   int field1908;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2138141773
   )
   @Export("y")
   int y;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 314136059
   )
   int field1910;
   @ObfuscatedName("f")
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("m")
   SceneTileModel field1912;
   @ObfuscatedName("c")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("mk")
   @Export("chatMessages")
   static ChatMessages chatMessages;
   @ObfuscatedName("r")
   boolean field1915;
   @ObfuscatedName("h")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1681321785
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("o")
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("x")
   int[] field1919;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1462768955
   )
   @Export("x")
   int x;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 379908259
   )
   int field1921;
   @ObfuscatedName("z")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("b")
   boolean field1923;
   @ObfuscatedName("s")
   boolean field1924;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1660859807
   )
   int field1925;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -14275209
   )
   int field1926;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 680504525
   )
   int field1927;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1167900407
   )
   int field1928;
   @ObfuscatedName("q")
   Tile field1929;
   @ObfuscatedName("g")
   @Export("itemLayer")
   ItemLayer itemLayer;

   Tile(int var1, int var2, int var3) {
      this.objects = new GameObject[5];
      this.field1919 = new int[5];
      this.field1908 = 0;
      this.field1907 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;ZIB)V",
      garbageValue = "-70"
   )
   static void method2507(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class92.field1430) {
         if(var3 == 4) {
            class92.loginIndex = 4;
         }

      } else {
         class92.loginIndex = var3;
         Rasterizer2D.method4964();
         byte[] var4 = var0.method4144("title.jpg", "");
         BufferedImage var6 = null;

         SpritePixels var5;
         label157: {
            try {
               var6 = ImageIO.read(new ByteArrayInputStream(var4));
               int var7 = var6.getWidth();
               int var8 = var6.getHeight();
               int[] var9 = new int[var8 * var7];
               PixelGrabber var10 = new PixelGrabber(var6, 0, 0, var7, var8, var9, 0, var7);
               var10.grabPixels();
               var5 = new SpritePixels(var9, var7, var8);
               break label157;
            } catch (IOException var13) {
               ;
            } catch (InterruptedException var14) {
               ;
            }

            var5 = new SpritePixels(0, 0);
         }

         class92.field1420 = var5;
         class92.field1421 = class92.field1420.method5124();
         if((Client.flags & 536870912) != 0) {
            class71.field845 = class151.method2928(var1, "logo_deadman_mode", "");
         } else {
            class71.field845 = class151.method2928(var1, "logo", "");
         }

         class92.field1418 = class151.method2928(var1, "titlebox", "");
         WidgetNode.field820 = class151.method2928(var1, "titlebutton", "");
         class92.field1419 = class41.method582(var1, "runes", "");
         class177.field2426 = class41.method582(var1, "title_mute", "");
         class33.field478 = class151.method2928(var1, "options_radio_buttons,0", "");
         class92.field1422 = class151.method2928(var1, "options_radio_buttons,2", "");
         class51.field641 = new int[256];

         int var12;
         for(var12 = 0; var12 < 64; ++var12) {
            class51.field641[var12] = var12 * 262144;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class51.field641[var12 + 64] = var12 * 1024 + 16711680;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class51.field641[var12 + 128] = var12 * 4 + 16776960;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class51.field641[var12 + 192] = 16777215;
         }

         class158.field2274 = new int[256];

         for(var12 = 0; var12 < 64; ++var12) {
            class158.field2274[var12] = var12 * 1024;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class158.field2274[var12 + 64] = var12 * 4 + '\uff00';
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class158.field2274[var12 + 128] = var12 * 262144 + '\uffff';
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class158.field2274[var12 + 192] = 16777215;
         }

         class41.field563 = new int[256];

         for(var12 = 0; var12 < 64; ++var12) {
            class41.field563[var12] = var12 * 4;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class41.field563[var12 + 64] = var12 * 262144 + 255;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class41.field563[var12 + 128] = var12 * 1024 + 16711935;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class41.field563[var12 + 192] = 16777215;
         }

         DecorativeObject.field2184 = new int[256];
         class1.field12 = new int['耀'];
         RSSocket.field2286 = new int['耀'];
         class47.method686((ModIcon)null);
         class36.field509 = new int['耀'];
         MessageNode.field860 = new int['耀'];
         if(var2) {
            class92.username = "";
            class92.password = "";
         }

         class175.authCodeForLogin = 0;
         XItemContainer.authCode = "";
         class92.field1442 = true;
         class92.worldSelectShown = false;
         if(!class66.field801.field1316) {
            class10.method71(2, class54.indexTrack1, "scape main", "", 255, false);
         } else {
            class203.field2515 = 1;
            class203.field2516 = null;
            class158.field2275 = -1;
            class275.field3730 = -1;
            FileOnDisk.field1774 = 0;
            class271.field3690 = false;
            class155.field2261 = 2;
         }

         class222.method4092(false);
         class92.field1430 = true;
         class92.field1417 = (class174.canvasWidth - 765) / 2;
         class92.loginWindowX = class92.field1417 + 202;
         class92.field1420.method5164(class92.field1417, 0);
         class92.field1421.method5164(class92.field1417 + 382, 0);
         class71.field845.method5066(class92.field1417 + 382 - class71.field845.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("p")
   static final void method2508(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }
}
