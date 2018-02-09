import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public class class65 {
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexCache3")
   static IndexData indexCache3;
   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexCache10")
   static IndexData indexCache10;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "60"
   )
   public static int method1060(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-43"
   )
   static void method1058() {
      class62.field724 = null;
      class29.field403 = null;
      TotalQuantityComparator.field288 = null;
      class62.field725 = null;
      class21.field331 = null;
      class160.field2156 = null;
      class62.field726 = null;
      BoundingBox2D.field229 = null;
      TotalQuantityComparator.field292 = null;
      class62.field727 = null;
      class94.field1417 = null;
      BoundingBox3D.field247 = null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;ZIB)V",
      garbageValue = "67"
   )
   static void method1059(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class89.field1329) {
         if(var3 == 4) {
            class89.loginIndex = 4;
         }

      } else {
         class89.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.takeRecordByNames("title.jpg", "");
         UnitPriceComparator.field307 = SoundTask.method2330(var4);
         class37.field483 = UnitPriceComparator.field307.method5673();
         if((Client.flags & 536870912) != 0) {
            class137.logoSprite = class163.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class137.logoSprite = class163.getSprite(var1, "logo", "");
         }

         AbstractByteBuffer.field2531 = class163.getSprite(var1, "titlebox", "");
         class89.field1319 = class163.getSprite(var1, "titlebutton", "");
         class89.runeSprites = class233.getIndexedSprites(var1, "runes", "");
         class35.titlemuteSprite = class233.getIndexedSprites(var1, "title_mute", "");
         Size.field350 = class163.getSprite(var1, "options_radio_buttons,0", "");
         class85.field1292 = class163.getSprite(var1, "options_radio_buttons,4", "");
         class89.field1321 = class163.getSprite(var1, "options_radio_buttons,2", "");
         BaseVarType.field16 = class163.getSprite(var1, "options_radio_buttons,6", "");
         WorldMapType2.field499 = Size.field350.originalWidth;
         class192.field2551 = Size.field350.height;
         KeyFocusListener.field623 = new int[256];

         int var5;
         for(var5 = 0; var5 < 64; ++var5) {
            KeyFocusListener.field623[var5] = var5 * 262144;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            KeyFocusListener.field623[var5 + 64] = var5 * 1024 + 16711680;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            KeyFocusListener.field623[var5 + 128] = var5 * 4 + 16776960;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            KeyFocusListener.field623[var5 + 192] = 16777215;
         }

         class89.field1326 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class89.field1326[var5] = var5 * 1024;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class89.field1326[var5 + 64] = var5 * 4 + 65280;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class89.field1326[var5 + 128] = var5 * 262144 + 65535;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class89.field1326[var5 + 192] = 16777215;
         }

         class80.field1251 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class80.field1251[var5] = var5 * 4;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class80.field1251[var5 + 64] = var5 * 262144 + 255;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class80.field1251[var5 + 128] = var5 * 1024 + 16711935;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class80.field1251[var5 + 192] = 16777215;
         }

         class5.field29 = new int[256];
         class43.field547 = new int['耀'];
         OwnWorldComparator.field834 = new int['耀'];
         class18.method143((IndexedSprite)null);
         OwnWorldComparator.field838 = new int['耀'];
         class31.field424 = new int['耀'];
         if(var2) {
            class89.username = "";
            class89.password = "";
         }

         MouseInput.field687 = 0;
         class27.field376 = "";
         class89.field1346 = true;
         class89.worldSelectShown = false;
         if(!WorldComparator.preferences.muted) {
            IndexData var8 = class231.indexTrack1;
            int var6 = var8.getFile("scape main");
            int var7 = var8.getChild(var6, "");
            DState.method3488(2, var8, var6, var7, 255, false);
         } else {
            UnitPriceComparator.method132(2);
         }

         Timer.sendConInfo(false);
         class89.field1329 = true;
         class89.field1356 = (GameEngine.canvasWidth - 765) / 2;
         class89.loginWindowX = class89.field1356 + 202;
         class89.field1323 = class89.loginWindowX + 180;
         UnitPriceComparator.field307.method5682(class89.field1356, 0);
         class37.field483.method5682(class89.field1356 + 382, 0);
         class137.logoSprite.method5653(class89.field1356 + 382 - class137.logoSprite.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "73"
   )
   static final String method1061(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class70.getColTags(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class70.getColTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class70.getColTags(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "([Lhs;IIIZI)V",
      garbageValue = "1059352676"
   )
   static void method1057(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            PendingSpawn.method1593(var6, var2, var3, var4);
            class216.method4247(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class5.method14(var0, var6, var4);
            }
         }
      }

   }
}
