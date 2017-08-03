import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class40 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Laq;"
   )
   public static final class40 field515;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Laq;"
   )
   public static final class40 field516;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Laq;"
   )
   public static final class40 field512;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Laq;"
   )
   public static final class40 field511;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Laq;"
   )
   public static final class40 field513;
   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "[Ljw;"
   )
   static IndexedSprite[] field517;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -251428877
   )
   static int field509;
   @ObfuscatedName("f")
   public final String field510;

   static {
      field515 = new class40("details");
      field516 = new class40("compositemap");
      field511 = new class40("compositetexture");
      field512 = new class40("area");
      field513 = new class40("labels");
   }

   class40(String var1) {
      this.field510 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Ljj;",
      garbageValue = "668444429"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lim;Lim;ZII)V",
      garbageValue = "946497932"
   )
   static void method553(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class92.field1420) {
         if(var3 == 4) {
            class92.loginIndex = 4;
         }

      } else {
         class92.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.method4132("title.jpg", "");
         class92.field1411 = class64.method1103(var4);
         class92.field1399 = class92.field1411.method5058();
         if((Client.flags & 536870912) != 0) {
            class11.logoSprite = class162.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class11.logoSprite = class162.getSprite(var1, "logo", "");
         }

         class92.field1396 = class162.getSprite(var1, "titlebox", "");
         class92.field1397 = class162.getSprite(var1, "titlebutton", "");
         class164.field2293 = class211.method3938(var1, "runes", "");
         class36.titlemuteSprite = class211.method3938(var1, "title_mute", "");
         class90.field1378 = class162.getSprite(var1, "options_radio_buttons,0", "");
         class149.field2178 = class162.getSprite(var1, "options_radio_buttons,2", "");
         ISAACCipher.field2404 = new int[256];

         int var5;
         for(var5 = 0; var5 < 64; ++var5) {
            ISAACCipher.field2404[var5] = var5 * 262144;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            ISAACCipher.field2404[var5 + 64] = 16711680 + var5 * 1024;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            ISAACCipher.field2404[var5 + 128] = var5 * 4 + 16776960;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            ISAACCipher.field2404[var5 + 192] = 16777215;
         }

         WorldMapData.field433 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            WorldMapData.field433[var5] = var5 * 1024;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            WorldMapData.field433[var5 + 64] = var5 * 4 + '\uff00';
         }

         for(var5 = 0; var5 < 64; ++var5) {
            WorldMapData.field433[var5 + 128] = '\uffff' + var5 * 262144;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            WorldMapData.field433[var5 + 192] = 16777215;
         }

         class47.field566 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class47.field566[var5] = var5 * 4;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class47.field566[var5 + 64] = var5 * 262144 + 255;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class47.field566[var5 + 128] = var5 * 1024 + 16711935;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class47.field566[var5 + 192] = 16777215;
         }

         class60.field719 = new int[256];
         class174.field2373 = new int['耀'];
         class268.field3657 = new int['耀'];
         class28.method234((IndexedSprite)null);
         XClanMember.field889 = new int['耀'];
         class21.field324 = new int['耀'];
         if(var2) {
            class92.username = "";
            class92.password = "";
         }

         class41.authCodeForLogin = 0;
         class17.authCode = "";
         class92.field1419 = true;
         class92.worldSelectShown = false;
         if(!class170.preferences.muted) {
            class220.method4074(2, class2.indexTrack1, "scape main", "", 255, false);
         } else {
            class27.method210(2);
         }

         GroundObject.sendConInfo(false);
         class92.field1420 = true;
         class92.field1416 = (class31.canvasWidth - 765) / 2;
         class92.loginWindowX = class92.field1416 + 202;
         class92.field1411.method5067(class92.field1416, 0);
         class92.field1399.method5067(class92.field1416 + 382, 0);
         class11.logoSprite.method5034(class92.field1416 + 382 - class11.logoSprite.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-492906407"
   )
   public static void method555() {
      PlayerComposition.field2604.reset();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILim;IIIZB)V",
      garbageValue = "-52"
   )
   public static void method556(int var0, IndexDataBase var1, int var2, int var3, int var4, boolean var5) {
      class203.field2475 = 1;
      class262.field3614 = var1;
      class11.field253 = var2;
      class203.field2482 = var3;
      class203.field2474 = var4;
      class182.field2413 = var5;
      RSCanvas.field633 = var0;
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(Lfw;II)V",
      garbageValue = "-195536653"
   )
   static void method558(Buffer var0, int var1) {
      class43.method633(var0.payload, var1);
      if(class155.field2223 != null) {
         try {
            class155.field2223.seek(0L);
            class155.field2223.write(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1611183884"
   )
   static void method554() {
      class96.field1470 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class96.field1469[var0] = null;
         class96.field1467[var0] = 1;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILcd;ZS)I",
      garbageValue = "-9626"
   )
   static int method552(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class83.intStack[--class83.intStackSize];
         var3 = WallObject.method2901(var4);
      } else {
         var3 = var2?class214.field2615:class73.field851;
      }

      if(var0 == 1100) {
         class83.intStackSize -= 2;
         var3.scrollX = class83.intStack[class83.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class83.intStack[class83.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class48.method732(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class83.intStack[--class83.intStackSize];
         class48.method732(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.field2658 = class83.intStack[--class83.intStackSize] == 1;
         class48.method732(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class83.intStack[--class83.intStackSize];
         class48.method732(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.field2662 = class83.intStack[--class83.intStackSize];
         class48.method732(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class83.intStack[--class83.intStackSize];
         class48.method732(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class83.intStack[--class83.intStackSize];
         class48.method732(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.field2733 = class83.intStack[--class83.intStackSize] == 1;
         class48.method732(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class83.intStack[--class83.intStackSize];
         class48.method732(var3);
         return 1;
      } else if(var0 == 1109) {
         class83.intStackSize -= 6;
         var3.field2678 = class83.intStack[class83.intStackSize];
         var3.field2693 = class83.intStack[class83.intStackSize + 1];
         var3.rotationX = class83.intStack[class83.intStackSize + 2];
         var3.rotationZ = class83.intStack[class83.intStackSize + 3];
         var3.rotationY = class83.intStack[class83.intStackSize + 4];
         var3.modelZoom = class83.intStack[class83.intStackSize + 5];
         class48.method732(var3);
         return 1;
      } else {
         int var10;
         if(var0 == 1110) {
            var10 = class83.intStack[--class83.intStackSize];
            if(var10 != var3.field2676) {
               var3.field2676 = var10;
               var3.field2751 = 0;
               var3.field2699 = 0;
               class48.method732(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2686 = class83.intStack[--class83.intStackSize] == 1;
            class48.method732(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class83.scriptStringStack[--Timer.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               class48.method732(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class83.intStack[--class83.intStackSize];
            class48.method732(var3);
            return 1;
         } else if(var0 == 1114) {
            class83.intStackSize -= 3;
            var3.field2692 = class83.intStack[class83.intStackSize];
            var3.field2687 = class83.intStack[class83.intStackSize + 1];
            var3.field2691 = class83.intStack[class83.intStackSize + 2];
            class48.method732(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class83.intStack[--class83.intStackSize] == 1;
            class48.method732(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class83.intStack[--class83.intStackSize];
            class48.method732(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class83.intStack[--class83.intStackSize];
            class48.method732(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class83.intStack[--class83.intStackSize] == 1;
            class48.method732(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class83.intStack[--class83.intStackSize] == 1;
            class48.method732(var3);
            return 1;
         } else if(var0 == 1120) {
            class83.intStackSize -= 2;
            var3.scrollWidth = class83.intStack[class83.intStackSize];
            var3.scrollHeight = class83.intStack[class83.intStackSize + 1];
            class48.method732(var3);
            if(var4 != -1 && var3.type == 0) {
               WorldListFetcher.method1530(class170.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            var10 = var3.id;
            int var6 = var3.index;
            Client.secretPacketBuffer1.putOpcode(161);
            Client.secretPacketBuffer1.putLEInt(var6);
            Client.secretPacketBuffer1.putLEShortA(var10);
            Client.field895 = var3;
            class48.method732(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2665 = class83.intStack[--class83.intStackSize];
            class48.method732(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2655 = class83.intStack[--class83.intStackSize];
            class48.method732(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2661 = class83.intStack[--class83.intStackSize];
            class48.method732(var3);
            return 1;
         } else if(var0 == 1125) {
            var10 = class83.intStack[--class83.intStackSize];
            class283[] var9 = new class283[]{class283.field3751, class283.field3749, class283.field3755, class283.field3754, class283.field3750};
            class283 var7 = (class283)CollisionData.forOrdinal(var9, var10);
            if(var7 != null) {
               var3.field2703 = var7;
               class48.method732(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class83.intStack[--class83.intStackSize] == 1;
            var3.field2663 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }
}
