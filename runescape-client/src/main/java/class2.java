import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
final class class2 implements class0 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("identKit_ref")
   public static IndexDataBase identKit_ref;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -2072174983
   )
   static int field14;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljk;Ljk;ZII)V",
      garbageValue = "1780534319"
   )
   static void method7(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class90.field1343) {
         if(var3 == 4) {
            class90.loginIndex = 4;
         }

      } else {
         class90.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.takeRecordByNames("title.jpg", "");
         BufferedImage var6 = null;

         SpritePixels var5;
         int var7;
         int var8;
         label159: {
            try {
               var6 = ImageIO.read(new ByteArrayInputStream(var4));
               var7 = var6.getWidth();
               var8 = var6.getHeight();
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

         class90.field1338 = var5;
         class90.field1340 = class90.field1338.method5910();
         if((Client.flags & 536870912) != 0) {
            class90.logoSprite = class81.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class90.logoSprite = class81.getSprite(var1, "logo", "");
         }

         class90.field1356 = class81.getSprite(var1, "titlebox", "");
         class19.field328 = class81.getSprite(var1, "titlebutton", "");
         class90.runeSprites = class254.getIndexedSprites(var1, "runes", "");
         ChatLineBuffer.titlemuteSprite = class254.getIndexedSprites(var1, "title_mute", "");
         class7.field235 = class81.getSprite(var1, "options_radio_buttons,0", "");
         CombatInfo1.field1199 = class81.getSprite(var1, "options_radio_buttons,4", "");
         class90.field1342 = class81.getSprite(var1, "options_radio_buttons,2", "");
         FileSystem.field3358 = class81.getSprite(var1, "options_radio_buttons,6", "");
         class149.field2111 = class7.field235.originalWidth;
         class37.field512 = class7.field235.height;
         ScriptState.field755 = new int[256];

         int var12;
         for(var12 = 0; var12 < 64; ++var12) {
            ScriptState.field755[var12] = var12 * 262144;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            ScriptState.field755[var12 + 64] = var12 * 1024 + 16711680;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            ScriptState.field755[var12 + 128] = var12 * 4 + 16776960;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            ScriptState.field755[var12 + 192] = 16777215;
         }

         class297.field3826 = new int[256];

         for(var12 = 0; var12 < 64; ++var12) {
            class297.field3826[var12] = var12 * 1024;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class297.field3826[var12 + 64] = var12 * 4 + 65280;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class297.field3826[var12 + 128] = var12 * 262144 + 65535;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class297.field3826[var12 + 192] = 16777215;
         }

         BoundingBox3DDrawMode.field271 = new int[256];

         for(var12 = 0; var12 < 64; ++var12) {
            BoundingBox3DDrawMode.field271[var12] = var12 * 4;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            BoundingBox3DDrawMode.field271[var12 + 64] = var12 * 262144 + 255;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            BoundingBox3DDrawMode.field271[var12 + 128] = var12 * 1024 + 16711935;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            BoundingBox3DDrawMode.field271[var12 + 192] = 16777215;
         }

         class289.field3775 = new int[256];
         TotalQuantityComparator.field299 = new int['耀'];
         class177.field2277 = new int['耀'];
         class138.method3120((IndexedSprite)null);
         class1.field11 = new int['耀'];
         class308.field3866 = new int['耀'];
         if(var2) {
            class90.username = "";
            class90.password = "";
         }

         field14 = 0;
         Sequence.field3752 = "";
         class90.field1363 = true;
         class90.worldSelectShown = false;
         if(!class55.preferences.muted) {
            IndexData var15 = class154.indexTrack1;
            var7 = var15.getFile("scape main");
            var8 = var15.getChild(var7, "");
            class229.field2694 = 1;
            class229.field2687 = var15;
            class229.field2691 = var7;
            AttackOption.field1331 = var8;
            class229.field2692 = 255;
            class37.field506 = false;
            class284.field3699 = 2;
         } else {
            class229.field2694 = 1;
            class229.field2687 = null;
            class229.field2691 = -1;
            AttackOption.field1331 = -1;
            class229.field2692 = 0;
            class37.field506 = false;
            class284.field3699 = 2;
         }

         class36.sendConInfo(false);
         class90.field1343 = true;
         class90.field1336 = (GameEngine.canvasWidth - 765) / 2;
         class90.loginWindowX = class90.field1336 + 202;
         NPC.field1290 = class90.loginWindowX + 180;
         class90.field1338.method6003(class90.field1336, 0);
         class90.field1340.method6003(class90.field1336 + 382, 0);
         class90.logoSprite.method5899(class90.field1336 + 382 - class90.logoSprite.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2116609128"
   )
   static void method6() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.first(); var0 != null; var0 = (WidgetNode)Client.componentTable.next()) {
         int var1 = var0.id;
         if(class18.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class5.getWidget(var4);
               if(var5 != null) {
                  class171.method3363(var5);
               }
            }
         }
      }

   }
}
