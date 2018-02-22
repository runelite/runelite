import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("GameCanvas")
public final class GameCanvas extends Canvas {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   public static IndexDataBase field601;
   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("indexCache3")
   static IndexData indexCache3;
   @ObfuscatedName("b")
   @Export("component")
   Component component;

   GameCanvas(Component var1) {
      this.component = var1;
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lie;Lie;ZII)V",
      garbageValue = "331963377"
   )
   static void method804(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class5.field30) {
         if(var3 == 4) {
            class89.loginIndex = 4;
         }

      } else {
         class89.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.takeRecordByNames("title.jpg", "");
         class234.field2759 = Signlink.method3249(var4);
         class305.field3806 = class234.field2759.method5800();
         if((Client.flags & 536870912) != 0) {
            class89.logoSprite = class137.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class89.logoSprite = class137.getSprite(var1, "logo", "");
         }

         class89.field1299 = class137.getSprite(var1, "titlebox", "");
         class84.field1264 = class137.getSprite(var1, "titlebutton", "");
         class89.runeSprites = DState.getIndexedSprites(var1, "runes", "");
         SoundTask.titlemuteSprite = DState.getIndexedSprites(var1, "title_mute", "");
         WorldComparator.field259 = class137.getSprite(var1, "options_radio_buttons,0", "");
         class40.field504 = class137.getSprite(var1, "options_radio_buttons,4", "");
         class89.field1302 = class137.getSprite(var1, "options_radio_buttons,2", "");
         Nameable.field3702 = class137.getSprite(var1, "options_radio_buttons,6", "");
         class194.field2550 = WorldComparator.field259.originalWidth;
         Item.field1365 = WorldComparator.field259.height;
         class28.field385 = new int[256];

         int var5;
         for(var5 = 0; var5 < 64; ++var5) {
            class28.field385[var5] = var5 * 262144;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class28.field385[var5 + 64] = var5 * 1024 + 16711680;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class28.field385[var5 + 128] = var5 * 4 + 16776960;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class28.field385[var5 + 192] = 16777215;
         }

         class153.field2093 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class153.field2093[var5] = var5 * 1024;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class153.field2093[var5 + 64] = var5 * 4 + 65280;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class153.field2093[var5 + 128] = var5 * 262144 + 65535;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class153.field2093[var5 + 192] = 16777215;
         }

         class27.field370 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class27.field370[var5] = var5 * 4;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class27.field370[var5 + 64] = var5 * 262144 + 255;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class27.field370[var5 + 128] = var5 * 1024 + 16711935;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class27.field370[var5 + 192] = 16777215;
         }

         ChatLineBuffer.field1429 = new int[256];
         class36.field471 = new int['耀'];
         class36.field467 = new int['耀'];
         class246.method4510((IndexedSprite)null);
         class89.field1307 = new int['耀'];
         DynamicObject.field1422 = new int['耀'];
         if(var2) {
            class89.username = "";
            class89.password = "";
         }

         BoundingBox3DDrawMode.field253 = 0;
         WidgetNode.field740 = "";
         class89.field1312 = true;
         class89.worldSelectShown = false;
         if(!Client.preferences.muted) {
            IndexData var8 = class155.indexTrack1;
            int var6 = var8.getFile("scape main");
            int var7 = var8.getChild(var6, "");
            class223.field2646 = 1;
            Huffman.field2471 = var8;
            class223.field2648 = var6;
            TextureProvider.field1658 = var7;
            class223.field2645 = 255;
            class223.field2647 = false;
            VertexNormal.field1888 = 2;
         } else {
            class249.method4517(2);
         }

         class230.sendConInfo(false);
         class5.field30 = true;
         class89.field1324 = (class1.canvasWidth - 765) / 2;
         class89.loginWindowX = class89.field1324 + 202;
         class222.field2641 = class89.loginWindowX + 180;
         class234.field2759.method5809(class89.field1324, 0);
         class305.field3806.method5809(class89.field1324 + 382, 0);
         class89.logoSprite.method5783(class89.field1324 + 382 - class89.logoSprite.originalWidth / 2, 18);
      }
   }
}
