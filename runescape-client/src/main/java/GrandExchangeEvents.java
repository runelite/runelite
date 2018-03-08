import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("GrandExchangeEvents")
public class GrandExchangeEvents {
   @ObfuscatedName("q")
   public static Comparator field266;
   @ObfuscatedName("i")
   public static Comparator field272;
   @ObfuscatedName("a")
   public static Comparator field268;
   @ObfuscatedName("l")
   public static Comparator field264;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lak;"
   )
   @Export("scriptMapIconReference")
   static MapIconReference scriptMapIconReference;
   @ObfuscatedName("t")
   @Export("events")
   public final List events;

   static {
      field266 = new class19();
      new WorldComparator();
      field272 = new UnitPriceComparator();
      field268 = new class18();
      field264 = new TotalQuantityComparator();
   }

   @ObfuscatedSignature(
      signature = "(Lgb;Z)V",
      garbageValue = "1"
   )
   public GrandExchangeEvents(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.events = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.events.add(new GrandExchangeEvent(var1, var5, var3));
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "1319080101"
   )
   @Export("sort")
   public void sort(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.events, var1);
      } else {
         Collections.sort(this.events, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljc;Ljc;ZIB)V",
      garbageValue = "-42"
   )
   static void method80(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class90.field1340) {
         if(var3 == 4) {
            class90.loginIndex = 4;
         }

      } else {
         class90.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.takeRecordByNames("title.jpg", "");
         BufferedImage var6 = null;

         SpritePixels var5;
         label161: {
            try {
               var6 = ImageIO.read(new ByteArrayInputStream(var4));
               int var7 = var6.getWidth();
               int var8 = var6.getHeight();
               int[] var9 = new int[var7 * var8];
               PixelGrabber var10 = new PixelGrabber(var6, 0, 0, var7, var8, var9, 0, var7);
               var10.grabPixels();
               var5 = new SpritePixels(var9, var7, var8);
               break label161;
            } catch (IOException var13) {
               ;
            } catch (InterruptedException var14) {
               ;
            }

            var5 = new SpritePixels(0, 0);
         }

         Item.field1387 = var5;
         class237.field2773 = Item.field1387.method5831();
         if((Client.flags & 536870912) != 0) {
            class252.logoSprite = Renderable.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class252.logoSprite = Renderable.getSprite(var1, "logo", "");
         }

         class90.field1324 = Renderable.getSprite(var1, "titlebox", "");
         class250.field3014 = Renderable.getSprite(var1, "titlebutton", "");
         class241.runeSprites = WorldMapData.getIndexedSprites(var1, "runes", "");
         class90.titlemuteSprite = WorldMapData.getIndexedSprites(var1, "title_mute", "");
         FaceNormal.field2035 = Renderable.getSprite(var1, "options_radio_buttons,0", "");
         class160.field2132 = Renderable.getSprite(var1, "options_radio_buttons,4", "");
         class90.field1326 = Renderable.getSprite(var1, "options_radio_buttons,2", "");
         class90.field1331 = Renderable.getSprite(var1, "options_radio_buttons,6", "");
         class7.field221 = FaceNormal.field2035.originalWidth;
         class279.field3554 = FaceNormal.field2035.height;
         MapLabel.field448 = new int[256];

         int var12;
         for(var12 = 0; var12 < 64; ++var12) {
            MapLabel.field448[var12] = var12 * 262144;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            MapLabel.field448[var12 + 64] = var12 * 1024 + 16711680;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            MapLabel.field448[var12 + 128] = var12 * 4 + 16776960;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            MapLabel.field448[var12 + 192] = 16777215;
         }

         class233.field2754 = new int[256];

         for(var12 = 0; var12 < 64; ++var12) {
            class233.field2754[var12] = var12 * 1024;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class233.field2754[var12 + 64] = var12 * 4 + 65280;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class233.field2754[var12 + 128] = var12 * 262144 + 65535;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class233.field2754[var12 + 192] = 16777215;
         }

         MilliTimer.field2140 = new int[256];

         for(var12 = 0; var12 < 64; ++var12) {
            MilliTimer.field2140[var12] = var12 * 4;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            MilliTimer.field2140[var12 + 64] = var12 * 262144 + 255;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            MilliTimer.field2140[var12 + 128] = var12 * 1024 + 16711935;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            MilliTimer.field2140[var12 + 192] = 16777215;
         }

         ItemContainer.field750 = new int[256];
         class27.field365 = new int['耀'];
         SceneTilePaint.field1943 = new int['耀'];
         FloorUnderlayDefinition.method4830((IndexedSprite)null);
         class228.field2670 = new int['耀'];
         class55.field626 = new int['耀'];
         if(var2) {
            class90.username = "";
            class90.password = "";
         }

         class80.field1251 = 0;
         Coordinates.field2779 = "";
         class90.field1350 = true;
         class90.worldSelectShown = false;
         if(!MapIcon.preferences.muted) {
            class64.method1133(2, Varbit.indexTrack1, "scape main", "", 255, false);
         } else {
            class229.field2674 = 1;
            class229.field2672 = null;
            class171.field2199 = -1;
            class229.field2676 = -1;
            class229.field2677 = 0;
            class85.field1294 = false;
            class2.field13 = 2;
         }

         JagexGame.sendConInfo(false);
         class90.field1340 = true;
         class90.field1323 = (WallObject.canvasWidth - 765) / 2;
         class90.loginWindowX = class90.field1323 + 202;
         Coordinates.field2778 = class90.loginWindowX + 180;
         Item.field1387.method5830(class90.field1323, 0);
         class237.field2773.method5830(class90.field1323 + 382, 0);
         class252.logoSprite.method5806(class90.field1323 + 382 - class252.logoSprite.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1372691033"
   )
   public static final void method77(int var0, int var1, int var2, int var3, int var4) {
      class7.boundingBoxes.addFirst(new BoundingBox2D(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1055027677"
   )
   static void method79() {
      UnitPriceComparator.method130();
      Client.menuOptions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuTypes[0] = 1006;
      Client.menuBooleanArray[0] = false;
      Client.menuOptionCount = 1;
   }
}
