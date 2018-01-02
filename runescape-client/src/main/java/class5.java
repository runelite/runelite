import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;

@ObfuscatedName("z")
final class class5 implements class0 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lib;Lib;ZII)V",
      garbageValue = "1650327181"
   )
   static void method14(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class91.field1347) {
         if(var3 == 4) {
            class91.loginIndex = 4;
         }

      } else {
         class91.loginIndex = var3;
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
               int[] var9 = new int[var7 * var8];
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

         class91.field1315 = var5;
         class91.field1319 = class91.field1315.method5277();
         if((Client.flags & 536870912) != 0) {
            class91.logoSprite = class279.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class91.logoSprite = class279.getSprite(var1, "logo", "");
         }

         class91.field1316 = class279.getSprite(var1, "titlebox", "");
         class91.field1317 = class279.getSprite(var1, "titlebutton", "");
         class234.runeSprites = Signlink.getIndexedSprites(var1, "runes", "");
         class278.titlemuteSprite = Signlink.getIndexedSprites(var1, "title_mute", "");
         CombatInfoListHolder.field1267 = class279.getSprite(var1, "options_radio_buttons,0", "");
         class234.field2945 = class279.getSprite(var1, "options_radio_buttons,4", "");
         class91.field1333 = class279.getSprite(var1, "options_radio_buttons,2", "");
         WorldMapType2.field492 = class279.getSprite(var1, "options_radio_buttons,6", "");
         MouseInput.field683 = CombatInfoListHolder.field1267.originalWidth;
         BoundingBox.field239 = CombatInfoListHolder.field1267.height;
         class218.field2696 = new int[256];

         int var12;
         for(var12 = 0; var12 < 64; ++var12) {
            class218.field2696[var12] = var12 * 262144;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class218.field2696[var12 + 64] = var12 * 1024 + 16711680;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class218.field2696[var12 + 128] = var12 * 4 + 16776960;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class218.field2696[var12 + 192] = 16777215;
         }

         class91.field1325 = new int[256];

         for(var12 = 0; var12 < 64; ++var12) {
            class91.field1325[var12] = var12 * 1024;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class91.field1325[var12 + 64] = var12 * 4 + 65280;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class91.field1325[var12 + 128] = var12 * 262144 + 65535;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class91.field1325[var12 + 192] = 16777215;
         }

         class2.field11 = new int[256];

         for(var12 = 0; var12 < 64; ++var12) {
            class2.field11[var12] = var12 * 4;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class2.field11[var12 + 64] = var12 * 262144 + 255;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class2.field11[var12 + 128] = var12 * 1024 + 16711935;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class2.field11[var12 + 192] = 16777215;
         }

         Item.field1386 = new int[256];
         class36.field478 = new int['耀'];
         class186.field2532 = new int['耀'];
         CombatInfoListHolder.method1623((IndexedSprite)null);
         class89.field1302 = new int['耀'];
         BoundingBox.field238 = new int['耀'];
         if(var2) {
            class91.username = "";
            class91.password = "";
         }

         BoundingBox.field240 = 0;
         class237.field3245 = "";
         class91.field1346 = true;
         class91.worldSelectShown = false;
         if(!class2.preferences.muted) {
            IndexData var15 = class29.indexTrack1;
            var7 = var15.getFile("scape main");
            var8 = var15.getChild(var7, "");
            CollisionData.method3152(2, var15, var7, var8, 255, false);
         } else {
            class214.field2620 = 1;
            class214.field2623 = null;
            class61.field692 = -1;
            class282.field3754 = -1;
            class214.field2625 = 0;
            IndexFile.field2181 = false;
            Timer.field2159 = 2;
         }

         class27.sendConInfo(false);
         class91.field1347 = true;
         class91.field1351 = (Huffman.canvasWidth - 765) / 2;
         class91.loginWindowX = class91.field1351 + 202;
         Preferences.field1217 = class91.loginWindowX + 180;
         class91.field1315.method5203(class91.field1351, 0);
         class91.field1319.method5203(class91.field1351 + 382, 0);
         class91.logoSprite.method5176(class91.field1351 + 382 - class91.logoSprite.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1860937356"
   )
   static String method15() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class96.messages.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "330163320"
   )
   static void method13() {
      class91.username = class91.username.trim();
      if(class91.username.length() == 0) {
         class64.method1033("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = WorldMapMappings.method620();
         int var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            var0 = FontName.method4872(var1, class91.username);
         }

         switch(var0) {
         case 2:
            class64.method1033("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class91.loginIndex = 6;
            break;
         case 3:
            class64.method1033("", "Error connecting to server.", "");
            break;
         case 4:
            class64.method1033("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class64.method1033("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class64.method1033("", "Error connecting to server.", "");
            break;
         case 7:
            class64.method1033("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("ew")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1957292188"
   )
   static final void method16() {
      Overlay.overlays.reset();
      AttackOption.method1669();
      class250.method4401();
      WorldMapType3.method209();
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      class139.method2870();
      class21.method155();
      Varbit.varbits.reset();
      VarPlayerType.varplayers.reset();
      class265.field3499.reset();
      class265.field3489.reset();
      class265.field3491.reset();
      CombatInfo2.field3443.reset();
      CombatInfo2.spriteCache.reset();
      class263.field3472.reset();
      class262.field3464.reset();
      Area.areaSpriteCache.reset();
      PacketBuffer.method3578();
      PacketBuffer.method3546();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1431.reset();
      BoundingBox.indexInterfaces.reset();
      FrameMap.indexSoundEffects.reset();
      MouseInput.indexCache3.reset();
      class86.indexCache4.reset();
      SceneComposition.indexMaps.reset();
      class29.indexTrack1.reset();
      class37.indexModels.reset();
      class43.indexSprites.reset();
      class3.indexTextures.reset();
      class36.indexCache10.reset();
      class20.indexTrack2.reset();
      SocketSession2.indexScripts.reset();
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-42201957"
   )
   @Export("npcUpdateViewport")
   static final void npcUpdateViewport() {
      PacketBuffer var0 = Client.field888.packetBuffer;
      var0.bitAccess();
      int var1 = var0.getBits(8);
      int var2;
      if(var1 < Client.npcIndexesCount) {
         for(var2 = var1; var2 < Client.npcIndexesCount; ++var2) {
            Client.npcIndiciesPendingRemoval[++Client.localNpcsCount - 1] = Client.npcIndices[var2];
         }
      }

      if(var1 > Client.npcIndexesCount) {
         throw new RuntimeException("");
      } else {
         Client.npcIndexesCount = 0;

         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = Client.npcIndices[var2];
            NPC var4 = Client.cachedNPCs[var3];
            int var5 = var0.getBits(1);
            if(var5 == 0) {
               Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
               var4.npcCycle = Client.gameCycle;
            } else {
               int var6 = var0.getBits(2);
               if(var6 == 0) {
                  Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
                  var4.npcCycle = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
               } else {
                  int var7;
                  int var8;
                  if(var6 == 1) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
                     var4.npcCycle = Client.gameCycle;
                     var7 = var0.getBits(3);
                     var4.method1640(var7, (byte)1);
                     var8 = var0.getBits(1);
                     if(var8 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
                     }
                  } else if(var6 == 2) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
                     var4.npcCycle = Client.gameCycle;
                     var7 = var0.getBits(3);
                     var4.method1640(var7, (byte)2);
                     var8 = var0.getBits(3);
                     var4.method1640(var8, (byte)2);
                     int var9 = var0.getBits(1);
                     if(var9 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
                     }
                  } else if(var6 == 3) {
                     Client.npcIndiciesPendingRemoval[++Client.localNpcsCount - 1] = var3;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1187732732"
   )
   static String method18(int var0) {
      return var0 < 0?"":(Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0]);
   }
}
