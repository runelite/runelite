import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -760934405
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1706988923
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("i")
   @Export("progress")
   byte progress;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1855258375
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("at")
   static FontMetrics field300;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1060137675
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1282512613
   )
   @Export("price")
   public int price;
   @ObfuscatedName("ry")
   static Preferences field303;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -575779005
   )
   static int field304;

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1880358595"
   )
   public int method86() {
      return this.progress & 7;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;ZII)V",
      garbageValue = "223793313"
   )
   static void method87(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class21.field334) {
         if(var3 == 4) {
            class92.loginIndex = 4;
         }

      } else {
         class92.loginIndex = var3;
         Rasterizer2D.method4919();
         byte[] var4 = var0.method4170("title.jpg", "");
         class33.field474 = class34.method441(var4);
         class211.field2609 = class33.field474.method5036();
         if((Client.flags & 536870912) != 0) {
            class92.field1457 = class84.method1666(var1, "logo_deadman_mode", "");
         } else {
            class92.field1457 = class84.method1666(var1, "logo", "");
         }

         class92.field1442 = class84.method1666(var1, "titlebox", "");
         FileOnDisk.field1782 = class84.method1666(var1, "titlebutton", "");
         class92.field1470 = class164.method3071(var1, "runes", "");
         class56.field692 = class164.method3071(var1, "title_mute", "");
         class3.field28 = class84.method1666(var1, "options_radio_buttons,0", "");
         class77.field1237 = class84.method1666(var1, "options_radio_buttons,2", "");
         class270.field3683 = new int[256];

         int var5;
         for(var5 = 0; var5 < 64; ++var5) {
            class270.field3683[var5] = var5 * 262144;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class270.field3683[var5 + 64] = var5 * 1024 + 16711680;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class270.field3683[var5 + 128] = var5 * 4 + 16776960;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class270.field3683[var5 + 192] = 16777215;
         }

         FileOnDisk.field1783 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            FileOnDisk.field1783[var5] = var5 * 1024;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            FileOnDisk.field1783[var5 + 64] = var5 * 4 + '\uff00';
         }

         for(var5 = 0; var5 < 64; ++var5) {
            FileOnDisk.field1783[var5 + 128] = var5 * 262144 + '\uffff';
         }

         for(var5 = 0; var5 < 64; ++var5) {
            FileOnDisk.field1783[var5 + 192] = 16777215;
         }

         class89.field1424 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class89.field1424[var5] = var5 * 4;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class89.field1424[var5 + 64] = var5 * 262144 + 255;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class89.field1424[var5 + 128] = var5 * 1024 + 16711935;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class89.field1424[var5 + 192] = 16777215;
         }

         class100.field1558 = new int[256];
         class10.field258 = new int['耀'];
         class25.field362 = new int['耀'];
         Actor.method1533((ModIcon)null);
         class23.field344 = new int['耀'];
         class21.field327 = new int['耀'];
         if(var2) {
            class92.username = "";
            class92.password = "";
         }

         class134.authCodeForLogin = 0;
         class231.authCode = "";
         class92.field1464 = true;
         class92.worldSelectShown = false;
         if(!field303.field1332) {
            class7.method26(2, class22.indexTrack1, "scape main", "", 255, false);
         } else {
            class84.method1668(2);
         }

         Preferences.method1595(false);
         class21.field334 = true;
         class92.field1459 = (VertexNormal.field2020 - 765) / 2;
         class92.loginWindowX = class92.field1459 + 202;
         class33.field474.method5045(class92.field1459, 0);
         class211.field2609.method5045(class92.field1459 + 382, 0);
         class92.field1457.method5017(class92.field1459 + 382 - class92.field1457.originalWidth / 2, 18);
      }
   }

   public XGrandExchangeOffer() {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-999899956"
   )
   void method88(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-5"
   )
   public int method93() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-30685"
   )
   void method95(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-6"
   )
   public static synchronized long method96() {
      long var0 = System.currentTimeMillis();
      if(var0 < class175.field2424) {
         class268.field3669 += class175.field2424 - var0;
      }

      class175.field2424 = var0;
      return class268.field3669 + var0;
   }
}
