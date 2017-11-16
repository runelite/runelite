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

@ObfuscatedName("h")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -873262441
   )
   static int field288;
   @ObfuscatedName("b")
   @Export("progress")
   byte progress;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1693679247
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1703938485
   )
   @Export("price")
   public int price;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1557997979
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1314806785
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 186417057
   )
   @Export("spent")
   public int spent;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lfs;Z)V",
      garbageValue = "0"
   )
   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-694956443"
   )
   public int method100() {
      return this.progress & 7;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1875113448"
   )
   public int method101() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1441522214"
   )
   void method98(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1234986220"
   )
   void method99(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lij;Lij;ZIB)V",
      garbageValue = "67"
   )
   static void method114(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class12.field256) {
         if(var3 == 4) {
            class91.loginIndex = 4;
         }

      } else {
         class91.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.method4141("title.jpg", "");
         BufferedImage var6 = null;

         SpritePixels var5;
         int var7;
         int var8;
         label153: {
            try {
               var6 = ImageIO.read(new ByteArrayInputStream(var4));
               var7 = var6.getWidth();
               var8 = var6.getHeight();
               int[] var9 = new int[var8 * var7];
               PixelGrabber var10 = new PixelGrabber(var6, 0, 0, var7, var8, var9, 0, var7);
               var10.grabPixels();
               var5 = new SpritePixels(var9, var7, var8);
               break label153;
            } catch (IOException var13) {
               ;
            } catch (InterruptedException var14) {
               ;
            }

            var5 = new SpritePixels(0, 0);
         }

         class243.field3292 = var5;
         class230.field2910 = class243.field3292.method5103();
         if((Client.flags & 536870912) != 0) {
            class66.logoSprite = class72.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class66.logoSprite = class72.getSprite(var1, "logo", "");
         }

         class91.field1331 = class72.getSprite(var1, "titlebox", "");
         class273.field3711 = class72.getSprite(var1, "titlebutton", "");
         class91.field1332 = class36.method477(var1, "runes", "");
         class268.titlemuteSprite = class36.method477(var1, "title_mute", "");
         class91.field1351 = class72.getSprite(var1, "options_radio_buttons,0", "");
         Permission.field3241 = class72.getSprite(var1, "options_radio_buttons,4", "");
         RSCanvas.field617 = class72.getSprite(var1, "options_radio_buttons,2", "");
         ChatLineBuffer.field1453 = class72.getSprite(var1, "options_radio_buttons,6", "");
         field288 = class91.field1351.originalWidth;
         class163.field2207 = class91.field1351.height;
         class82.field1265 = new int[256];

         int var11;
         for(var11 = 0; var11 < 64; ++var11) {
            class82.field1265[var11] = var11 * 262144;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class82.field1265[var11 + 64] = var11 * 1024 + 16711680;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class82.field1265[var11 + 128] = var11 * 4 + 16776960;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class82.field1265[var11 + 192] = 16777215;
         }

         class91.field1330 = new int[256];

         for(var11 = 0; var11 < 64; ++var11) {
            class91.field1330[var11] = var11 * 1024;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class91.field1330[var11 + 64] = var11 * 4 + 65280;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class91.field1330[var11 + 128] = var11 * 262144 + 65535;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class91.field1330[var11 + 192] = 16777215;
         }

         class44.field540 = new int[256];

         for(var11 = 0; var11 < 64; ++var11) {
            class44.field540[var11] = var11 * 4;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class44.field540[var11 + 64] = var11 * 262144 + 255;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class44.field540[var11 + 128] = var11 * 1024 + 16711935;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class44.field540[var11 + 192] = 16777215;
         }

         Friend.field758 = new int[256];
         class164.field2208 = new int['耀'];
         class91.field1364 = new int['耀'];
         class259.method4460((IndexedSprite)null);
         class21.field312 = new int['耀'];
         class86.field1295 = new int['耀'];
         if(var2) {
            class91.username = "";
            class91.password = "";
         }

         class51.field609 = 0;
         class44.field538 = "";
         class91.field1355 = true;
         class91.worldSelectShown = false;
         if(!class70.preferences.muted) {
            IndexData var15 = class45.indexTrack1;
            var7 = var15.getFile("scape main");
            var8 = var15.getChild(var7, "");
            RSCanvas.method744(2, var15, var7, var8, 255, false);
         } else {
            class210.field2585 = 1;
            class70.field802 = null;
            class210.field2586 = -1;
            class31.field414 = -1;
            class230.field2909 = 0;
            class230.field2905 = false;
            FrameMap.field1952 = 2;
         }

         class3.sendConInfo(false);
         class12.field256 = true;
         class91.field1361 = (class66.canvasWidth - 765) / 2;
         class91.loginWindowX = class91.field1361 + 202;
         class256.field3426 = class91.loginWindowX + 180;
         class243.field3292.method5138(class91.field1361, 0);
         class230.field2910.method5138(class91.field1361 + 382, 0);
         class66.logoSprite.method5097(class91.field1361 + 382 - class66.logoSprite.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "179075774"
   )
   static final int method113(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & 65280) * var2 + (var0 & 65280) * var3 & 16711680) + (var3 * (var0 & 16711935) + (var1 & 16711935) * var2 & -16711936) >> 8;
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(IIIIIIS)V",
      garbageValue = "1326"
   )
   static final void method112(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = Graphics3D.SINE[var6];
         var12 = Graphics3D.COSINE[var6];
         var13 = var9 * var12 - var11 * var5 >> 16;
         var10 = var5 * var12 + var9 * var11 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = Graphics3D.SINE[var7];
         var12 = Graphics3D.COSINE[var7];
         var13 = var12 * var8 + var10 * var11 >> 16;
         var10 = var12 * var10 - var8 * var11 >> 16;
         var8 = var13;
      }

      class45.cameraX = var0 - var8;
      class279.cameraZ = var1 - var9;
      Client.cameraY = var2 - var10;
      class45.cameraPitch = var3;
      class230.cameraYaw = var4;
   }
}
