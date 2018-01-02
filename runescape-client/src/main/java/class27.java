import net.runelite.mapping.*;

import java.awt.*;
import java.io.IOException;

@ObfuscatedName("ad")
public enum class27 implements Enumerated {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lad;"
   )
   field366(3, (byte)0),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lad;"
   )
   field368(2, (byte)1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lad;"
   )
   field369(0, (byte)2),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lad;"
   )
   field367(1, (byte)3);

   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1781428861
   )
   final int field370;
   @ObfuscatedName("z")
   final byte field371;

   class27(int var3, byte var4) {
      this.field370 = var3;
      this.field371 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1035813094"
   )
   public int rsOrdinal() {
      return this.field371;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "44"
   )
   static void method213(Component var0) {
      var0.addMouseListener(MouseInput.mouse);
      var0.addMouseMotionListener(MouseInput.mouse);
      var0.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1804574040"
   )
   static void method218() {
      for(GameObjectTransformMetadata var0 = (GameObjectTransformMetadata) GameObjectTransformMetadata.field1235.getFront(); var0 != null; var0 = (GameObjectTransformMetadata) GameObjectTransformMetadata.field1235.getNext()) {
         if(var0.field1229 != null) {
            class214.field2628.method1882(var0.field1229);
            var0.field1229 = null;
         }

         if(var0.field1234 != null) {
            class214.field2628.method1882(var0.field1234);
            var0.field1234 = null;
         }
      }

      GameObjectTransformMetadata.field1235.clear();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "1"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class249.NetCache_socket != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class249.NetCache_socket.vmethod3082(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class249.NetCache_socket.vmethod3081();
            } catch (Exception var3) {
               ;
            }

            ++class249.field3360;
            class249.NetCache_socket = null;
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BZB)Ljava/lang/Object;",
      garbageValue = "76"
   )
   @Export("byteArrayToObject")
   public static Object byteArrayToObject(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.directBufferUnavailable) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.directBufferUnavailable = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1678114138"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         class48.region = new Region(4, 104, 104, class61.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         BoundingBox3D.field250 = new SpritePixels(512, 512);
         class91.loadingText = "Starting game engine...";
         class91.loadingBarPercentage = 5;
         Client.loadingStage = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.loadingStage == 20) {
            int[] var28 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 15 + 128;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var28[var1] = var3 * var4 >> 16;
            }

            Region.method2725(var28, 500, 800, 512, 334);
            class91.loadingText = "Prepared visibility map";
            class91.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         } else if(Client.loadingStage == 30) {
            BoundingBox.indexInterfaces = Player.openCacheIndex(0, false, true, true);
            FrameMap.indexSoundEffects = Player.openCacheIndex(1, false, true, true);
            Fonts.configsIndex = Player.openCacheIndex(2, true, false, true);
            MouseInput.indexCache3 = Player.openCacheIndex(3, false, true, true);
            class86.indexCache4 = Player.openCacheIndex(4, false, true, true);
            SceneComposition.indexMaps = Player.openCacheIndex(5, true, true, true);
            class29.indexTrack1 = Player.openCacheIndex(6, true, true, false);
            class37.indexModels = Player.openCacheIndex(7, false, true, true);
            class43.indexSprites = Player.openCacheIndex(8, false, true, true);
            class3.indexTextures = Player.openCacheIndex(9, false, true, true);
            class36.indexCache10 = Player.openCacheIndex(10, false, true, true);
            class20.indexTrack2 = Player.openCacheIndex(11, false, true, true);
            SocketSession2.indexScripts = Player.openCacheIndex(12, false, true, true);
            Preferences.indexCache13 = Player.openCacheIndex(13, true, false, true);
            class231.vorbisIndex = Player.openCacheIndex(14, false, true, false);
            FontName.indexCache15 = Player.openCacheIndex(15, false, true, true);
            FriendLoginUpdate.indexWorldMap = Player.openCacheIndex(16, false, true, false);
            class91.loadingText = "Connecting to update server";
            class91.loadingBarPercentage = 20;
            Client.loadingStage = 40;
         } else if(Client.loadingStage == 40) {
            byte var24 = 0;
            var0 = var24 + BoundingBox.indexInterfaces.percentage() * 4 / 100;
            var0 += FrameMap.indexSoundEffects.percentage() * 4 / 100;
            var0 += Fonts.configsIndex.percentage() * 2 / 100;
            var0 += MouseInput.indexCache3.percentage() * 2 / 100;
            var0 += class86.indexCache4.percentage() * 6 / 100;
            var0 += SceneComposition.indexMaps.percentage() * 4 / 100;
            var0 += class29.indexTrack1.percentage() * 2 / 100;
            var0 += class37.indexModels.percentage() * 58 / 100;
            var0 += class43.indexSprites.percentage() * 2 / 100;
            var0 += class3.indexTextures.percentage() * 2 / 100;
            var0 += class36.indexCache10.percentage() * 2 / 100;
            var0 += class20.indexTrack2.percentage() * 2 / 100;
            var0 += SocketSession2.indexScripts.percentage() * 2 / 100;
            var0 += Preferences.indexCache13.percentage() * 2 / 100;
            var0 += class231.vorbisIndex.percentage() * 2 / 100;
            var0 += FontName.indexCache15.percentage() * 2 / 100;
            var0 += FriendLoginUpdate.indexWorldMap.percentage() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class91.loadingText = "Checking for updates - " + var0 + "%";
               }

               class91.loadingBarPercentage = 30;
            } else {
               class91.loadingText = "Loaded update list";
               class91.loadingBarPercentage = 30;
               Client.loadingStage = 45;
            }
         } else {
            IndexData var20;
            IndexData var21;
            IndexData var22;
            if(Client.loadingStage == 45) {
               AbstractByteBuffer.method3518(22050, !Client.lowMemory, 2);
               RSAudioPlayer var27 = new RSAudioPlayer();
               var27.method3851(9, 128);
               class36.soundSystem0 = PacketBuffer.method3579(GameEngine.taskManager, 0, 22050);
               class36.soundSystem0.method2002(var27);
               var20 = FontName.indexCache15;
               var21 = class231.vorbisIndex;
               var22 = class86.indexCache4;
               class214.field2626 = var20;
               class214.field2621 = var21;
               class214.field2624 = var22;
               class282.field3753 = var27;
               VertexNormal.soundSystem1 = PacketBuffer.method3579(GameEngine.taskManager, 1, 2048);
               class214.field2628 = new AudioLinkedDeque();
               VertexNormal.soundSystem1.method2002(class214.field2628);
               class34.field457 = new class115(22050, ScriptState.sampleRate);
               class91.loadingText = "Prepared sound engine";
               class91.loadingBarPercentage = 35;
               Client.loadingStage = 50;
               FileSystem.fonts = new Fonts(class43.indexSprites, Preferences.indexCache13);
            } else if(Client.loadingStage == 50) {
               var0 = FontName.method4869().length;
               Client.fontsMap = FileSystem.fonts.createMap(FontName.method4869());
               if(Client.fontsMap.size() < var0) {
                  class91.loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var0 + "%";
                  class91.loadingBarPercentage = 40;
               } else {
                  class56.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
                  BaseVarType.font_p12full = (Font)Client.fontsMap.get(FontName.FontName_plain12);
                  Friend.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
                  class48.platformInfo = new MachineInfo(true);
                  class91.loadingText = "Loaded fonts";
                  class91.loadingBarPercentage = 40;
                  Client.loadingStage = 60;
               }
            } else if(Client.loadingStage == 60) {
               var20 = class36.indexCache10;
               var21 = class43.indexSprites;
               var3 = 0;
               if(var20.tryLoadRecordByNames("title.jpg", "")) {
                  ++var3;
               }

               if(var21.tryLoadRecordByNames("logo", "")) {
                  ++var3;
               }

               if(var21.tryLoadRecordByNames("logo_deadman_mode", "")) {
                  ++var3;
               }

               if(var21.tryLoadRecordByNames("titlebox", "")) {
                  ++var3;
               }

               if(var21.tryLoadRecordByNames("titlebutton", "")) {
                  ++var3;
               }

               if(var21.tryLoadRecordByNames("runes", "")) {
                  ++var3;
               }

               if(var21.tryLoadRecordByNames("title_mute", "")) {
                  ++var3;
               }

               if(var21.tryLoadRecordByNames("options_radio_buttons,0", "")) {
                  ++var3;
               }

               if(var21.tryLoadRecordByNames("options_radio_buttons,2", "")) {
                  ++var3;
               }

               if(var21.tryLoadRecordByNames("options_radio_buttons,4", "")) {
                  ++var3;
               }

               if(var21.tryLoadRecordByNames("options_radio_buttons,6", "")) {
                  ++var3;
               }

               var21.tryLoadRecordByNames("sl_back", "");
               var21.tryLoadRecordByNames("sl_flags", "");
               var21.tryLoadRecordByNames("sl_arrows", "");
               var21.tryLoadRecordByNames("sl_stars", "");
               var21.tryLoadRecordByNames("sl_button", "");
               var4 = class91.method1694();
               if(var3 < var4) {
                  class91.loadingText = "Loading title screen - " + var3 * 100 / var4 + "%";
                  class91.loadingBarPercentage = 50;
               } else {
                  class91.loadingText = "Loaded title screen";
                  class91.loadingBarPercentage = 50;
                  Friend.setGameState(5);
                  Client.loadingStage = 70;
               }
            } else if(Client.loadingStage == 70) {
               if(!Fonts.configsIndex.method4259()) {
                  class91.loadingText = "Loading config - " + Fonts.configsIndex.loadPercent() + "%";
                  class91.loadingBarPercentage = 60;
               } else {
                  IndexData var26 = Fonts.configsIndex;
                  Overlay.overlay_ref = var26;
                  var20 = Fonts.configsIndex;
                  FloorUnderlayDefinition.underlay_ref = var20;
                  var21 = Fonts.configsIndex;
                  var22 = class37.indexModels;
                  KitDefinition.identKit_ref = var21;
                  KitDefinition.field3432 = var22;
                  WorldComparator.field265 = KitDefinition.identKit_ref.fileCount(3);
                  IndexDataBase.method4346(Fonts.configsIndex, class37.indexModels, Client.lowMemory);
                  JagexGame.method4250(Fonts.configsIndex, class37.indexModels);
                  IndexData var23 = Fonts.configsIndex;
                  class263.field3471 = var23;
                  IndexData var5 = Fonts.configsIndex;
                  IndexData var6 = class37.indexModels;
                  boolean var7 = Client.isMembers;
                  Font var8 = class56.fontPlain11;
                  ItemComposition.item_ref = var5;
                  class238.ItemDefinition_modelIndexCache = var6;
                  ScriptState.isMembersWorld = var7;
                  class179.field2463 = ItemComposition.item_ref.fileCount(10);
                  class226.field2748 = var8;
                  IndexData var9 = Fonts.configsIndex;
                  IndexData var10 = BoundingBox.indexInterfaces;
                  IndexData var11 = FrameMap.indexSoundEffects;
                  class34.seq_ref = var9;
                  Sequence.skel_ref = var10;
                  Sequence.skin_ref = var11;
                  Actor.method1466(Fonts.configsIndex, class37.indexModels);
                  class239.method4226(Fonts.configsIndex);
                  class91.method1719(Fonts.configsIndex);
                  CombatInfoListHolder.method1629(MouseInput.indexCache3, class37.indexModels, class43.indexSprites, Preferences.indexCache13);
                  class33.method345(Fonts.configsIndex);
                  class86.method1650(Fonts.configsIndex);
                  class20.method146(Fonts.configsIndex);
                  ScriptVarType.method26(Fonts.configsIndex);
                  CombatInfoListHolder.method1633(Fonts.configsIndex);
                  NetWriter.chatMessages = new Varcs();
                  IndexData var12 = Fonts.configsIndex;
                  IndexData var13 = class43.indexSprites;
                  IndexData var14 = Preferences.indexCache13;
                  class265.field3497 = var12;
                  class265.field3487 = var13;
                  class265.field3488 = var14;
                  class180.method3232(Fonts.configsIndex, class43.indexSprites);
                  IndexData var15 = Fonts.configsIndex;
                  IndexData var16 = class43.indexSprites;
                  Area.field3392 = var16;
                  if(var15.method4259()) {
                     Area.field3379 = var15.fileCount(35);
                     Area.mapAreaType = new Area[Area.field3379];

                     for(int var17 = 0; var17 < Area.field3379; ++var17) {
                        byte[] var18 = var15.getConfigData(35, var17);
                        if(var18 != null) {
                           Area.mapAreaType[var17] = new Area(var17);
                           Area.mapAreaType[var17].method4438(new Buffer(var18));
                           Area.mapAreaType[var17].method4440();
                        }
                     }
                  }

                  class91.loadingText = "Loaded config";
                  class91.loadingBarPercentage = 60;
                  Client.loadingStage = 80;
               }
            } else if(Client.loadingStage == 80) {
               var0 = 0;
               if(GrandExchangeEvent.compass == null) {
                  GrandExchangeEvent.compass = class283.spriteForName(class43.indexSprites, "compass", "");
               } else {
                  ++var0;
               }

               if(MapAreaMetadata.mapedge == null) {
                  MapAreaMetadata.mapedge = class283.spriteForName(class43.indexSprites, "mapedge", "");
               } else {
                  ++var0;
               }

               if(AttackOption.mapscene == null) {
                  AttackOption.mapscene = Signlink.getIndexedSprites(class43.indexSprites, "mapscene", "");
               } else {
                  ++var0;
               }

               if(GEItemNameComparator.headIconsPk == null) {
                  GEItemNameComparator.headIconsPk = KeyFocusListener.getSprites(class43.indexSprites, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(UnitPriceComparator.headIconsPrayer == null) {
                  UnitPriceComparator.headIconsPrayer = KeyFocusListener.getSprites(class43.indexSprites, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(RenderOverview.headIconsHint == null) {
                  RenderOverview.headIconsHint = KeyFocusListener.getSprites(class43.indexSprites, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(class34.mapMarkers == null) {
                  class34.mapMarkers = KeyFocusListener.getSprites(class43.indexSprites, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(Size.crossSprites == null) {
                  Size.crossSprites = KeyFocusListener.getSprites(class43.indexSprites, "cross", "");
               } else {
                  ++var0;
               }

               if(Script.mapDots == null) {
                  Script.mapDots = KeyFocusListener.getSprites(class43.indexSprites, "mapdots", "");
               } else {
                  ++var0;
               }

               if(WallObject.scrollbarSprites == null) {
                  WallObject.scrollbarSprites = Signlink.getIndexedSprites(class43.indexSprites, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(Ignore.modIconSprites == null) {
                  Ignore.modIconSprites = Signlink.getIndexedSprites(class43.indexSprites, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 11) {
                  class91.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                  class91.loadingBarPercentage = 70;
               } else {
                  FontTypeFace.modIcons = Ignore.modIconSprites;
                  MapAreaMetadata.mapedge.method5253();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;
                  AttackOption.mapscene[0].method5175(var4 + var1, var2 + var4, var3 + var4);
                  class91.loadingText = "Loaded sprites";
                  class91.loadingBarPercentage = 70;
                  Client.loadingStage = 90;
               }
            } else if(Client.loadingStage == 90) {
               if(!class3.indexTextures.method4259()) {
                  class91.loadingText = "Loading textures - " + class3.indexTextures.loadPercent() + "%";
                  class91.loadingBarPercentage = 90;
               } else {
                  TextureProvider var25 = new TextureProvider(class3.indexTextures, class43.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
                  Graphics3D.setTextureLoader(var25);
                  Graphics3D.setBrightness(0.8D);
                  class91.loadingText = "Loaded textures";
                  class91.loadingBarPercentage = 90;
                  Client.loadingStage = 110;
               }
            } else if(Client.loadingStage == 110) {
               WorldMapMappings.mouseRecorder = new MouseRecorder();
               GameEngine.taskManager.createRunnable(WorldMapMappings.mouseRecorder, 10);
               class91.loadingText = "Loaded input handler";
               class91.loadingBarPercentage = 92;
               Client.loadingStage = 120;
            } else if(Client.loadingStage == 120) {
               if(!class36.indexCache10.tryLoadRecordByNames("huffman", "")) {
                  class91.loadingText = "Loading wordpack - " + 0 + "%";
                  class91.loadingBarPercentage = 94;
               } else {
                  Huffman var19 = new Huffman(class36.indexCache10.takeRecordByNames("huffman", ""));
                  class276.huffman = var19;
                  class91.loadingText = "Loaded wordpack";
                  class91.loadingBarPercentage = 94;
                  Client.loadingStage = 130;
               }
            } else if(Client.loadingStage == 130) {
               if(!MouseInput.indexCache3.method4259()) {
                  class91.loadingText = "Loading interfaces - " + MouseInput.indexCache3.loadPercent() * 4 / 5 + "%";
                  class91.loadingBarPercentage = 96;
               } else if(!SocketSession2.indexScripts.method4259()) {
                  class91.loadingText = "Loading interfaces - " + (80 + SocketSession2.indexScripts.loadPercent() / 6) + "%";
                  class91.loadingBarPercentage = 96;
               } else if(!Preferences.indexCache13.method4259()) {
                  class91.loadingText = "Loading interfaces - " + (96 + Preferences.indexCache13.loadPercent() / 50) + "%";
                  class91.loadingBarPercentage = 96;
               } else {
                  class91.loadingText = "Loaded interfaces";
                  class91.loadingBarPercentage = 98;
                  Client.loadingStage = 140;
               }
            } else if(Client.loadingStage == 140) {
               class91.loadingBarPercentage = 100;
               if(!FriendLoginUpdate.indexWorldMap.tryLoadArchiveByName(NamedRecord.field510.field514)) {
                  class91.loadingText = "Loading world map - " + FriendLoginUpdate.indexWorldMap.archiveLoadPercentByName(NamedRecord.field510.field514) / 10 + "%";
               } else {
                  if(class61.renderOverview == null) {
                     class61.renderOverview = new RenderOverview();
                     class61.renderOverview.method5340(FriendLoginUpdate.indexWorldMap, Friend.fontBold12, Client.fontsMap, AttackOption.mapscene);
                  }

                  var0 = class61.renderOverview.method5421();
                  if(var0 < 100) {
                     class91.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                  } else {
                     class91.loadingText = "Loaded world map";
                     Client.loadingStage = 150;
                  }
               }
            } else if(Client.loadingStage == 150) {
               Friend.setGameState(10);
            }
         }
      }
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "688722835"
   )
   @Export("npcUpdateMasks")
   static final void npcUpdateMasks(PacketBuffer var0) {
      for(int var1 = 0; var1 < Client.pendingNpcFlagsCount; ++var1) {
         int var2 = Client.pendingNpcFlagsIndices[var1];
         NPC var3 = Client.cachedNPCs[var2];
         int var4 = var0.readUnsignedByte();
         int var5;
         if((var4 & 4) != 0) {
            var3.graphic = var0.readUnsignedShort();
            var5 = var0.readInt();
            var3.field1163 = var5 >> 16;
            var3.graphicsDelay = (var5 & 65535) + Client.gameCycle;
            var3.field1160 = 0;
            var3.field1143 = 0;
            if(var3.graphicsDelay > Client.gameCycle) {
               var3.field1160 = -1;
            }

            if(var3.graphic == 65535) {
               var3.graphic = -1;
            }
         }

         if((var4 & 32) != 0) {
            var3.interacting = var0.method3297();
            if(var3.interacting == 65535) {
               var3.interacting = -1;
            }
         }

         if((var4 & 8) != 0) {
            var3.composition = Client.getNpcDefinition(var0.method3297());
            var3.field1126 = var3.composition.field3620;
            var3.field1175 = var3.composition.field3648;
            var3.field1139 = var3.composition.field3631;
            var3.field1131 = var3.composition.field3632;
            var3.field1132 = var3.composition.field3633;
            var3.field1123 = var3.composition.field3634;
            var3.idlePoseAnimation = var3.composition.field3628;
            var3.field1128 = var3.composition.field3644;
            var3.field1176 = var3.composition.field3630;
         }

         int var6;
         int var7;
         int var8;
         if((var4 & 2) != 0) {
            var5 = var0.readUnsignedByte();
            int var9;
            int var10;
            int var11;
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var8 = -1;
                  var9 = -1;
                  var10 = -1;
                  var7 = var0.getUSmart();
                  if(var7 == 32767) {
                     var7 = var0.getUSmart();
                     var9 = var0.getUSmart();
                     var8 = var0.getUSmart();
                     var10 = var0.getUSmart();
                  } else if(var7 != 32766) {
                     var9 = var0.getUSmart();
                  } else {
                     var7 = -1;
                  }

                  var11 = var0.getUSmart();
                  var3.method1463(var7, var9, var8, var10, Client.gameCycle, var11);
               }
            }

            var6 = var0.method3335();
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  if(var9 != 32767) {
                     var10 = var0.getUSmart();
                     var11 = var0.method3335();
                     int var12 = var9 > 0?var0.readUnsignedByte():var11;
                     var3.method1467(var8, Client.gameCycle, var9, var10, var11, var12);
                  } else {
                     var3.method1468(var8);
                  }
               }
            }
         }

         if((var4 & 1) != 0) {
            var5 = var0.method3299();
            var6 = var0.readUnsignedShortOb1();
            var7 = var3.x - (var5 - SceneChunkMetadata.baseX - SceneChunkMetadata.baseX) * 64;
            var8 = var3.y - (var6 - Client.baseY - Client.baseY) * 64;
            if(var7 != 0 || var8 != 0) {
               var3.field1150 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }

         if((var4 & 64) != 0) {
            var5 = var0.readUnsignedShort();
            if(var5 == 65535) {
               var5 = -1;
            }

            var6 = var0.readUnsignedByte();
            if(var5 == var3.animation && var5 != -1) {
               var7 = Permission.getAnimation(var5).replyMode;
               if(var7 == 1) {
                  var3.actionFrame = 0;
                  var3.field1156 = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field1124 = 0;
               }

               if(var7 == 2) {
                  var3.field1124 = 0;
               }
            } else if(var5 == -1 || var3.animation == -1 || Permission.getAnimation(var5).forcedPriority >= Permission.getAnimation(var3.animation).forcedPriority) {
               var3.animation = var5;
               var3.actionFrame = 0;
               var3.field1156 = 0;
               var3.actionAnimationDisable = var6;
               var3.field1124 = 0;
               var3.field1155 = var3.queueSize;
            }
         }

         if((var4 & 16) != 0) {
            var3.overhead = var0.readString();
            var3.overheadTextCyclesRemaining = 100;
         }
      }

   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "1877630926"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      PacketNode var8;
      if(var2 == 1) {
         Client.field1003 = var6;
         Client.field936 = var7;
         Client.cursorState = 2;
         Client.field1092 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = FileSystem.bufferForSize(ClientPacket.field2382, Client.field888.field1449);
         var8.packetBuffer.method3306(GEItemNameComparator.field304);
         var8.packetBuffer.putByte(KeyFocusListener.field593[82]?1:0);
         var8.packetBuffer.writeShortLE(var3 >> 14 & 32767);
         var8.packetBuffer.putShortLE(Client.baseY + var1);
         var8.packetBuffer.writeShortLE(class36.selectedItemIndex);
         var8.packetBuffer.writeIntLE16(var0 + SceneChunkMetadata.baseX);
         var8.packetBuffer.writeShortLE(SceneChunkMetadata.field557);
         Client.field888.method1862(var8);
      } else if(var2 == 2) {
         Client.field1003 = var6;
         Client.field936 = var7;
         Client.cursorState = 2;
         Client.field1092 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = FileSystem.bufferForSize(ClientPacket.field2374, Client.field888.field1449);
         var8.packetBuffer.writeIntLE(JagexGame.field3297);
         var8.packetBuffer.writeIntLE16(Client.baseY + var1);
         var8.packetBuffer.putShortLE(var3 >> 14 & 32767);
         var8.packetBuffer.writeIntLE16(var0 + SceneChunkMetadata.baseX);
         var8.packetBuffer.method3287(KeyFocusListener.field593[82]?1:0);
         var8.packetBuffer.writeIntLE16(Client.field984);
         Client.field888.method1862(var8);
      } else if(var2 == 3) {
         Client.field1003 = var6;
         Client.field936 = var7;
         Client.cursorState = 2;
         Client.field1092 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = FileSystem.bufferForSize(ClientPacket.field2338, Client.field888.field1449);
         var8.packetBuffer.writeShortLE(var0 + SceneChunkMetadata.baseX);
         var8.packetBuffer.writeShortLE(Client.baseY + var1);
         var8.packetBuffer.putShortLE(var3 >> 14 & 32767);
         var8.packetBuffer.method3286(KeyFocusListener.field593[82]?1:0);
         Client.field888.method1862(var8);
      } else if(var2 == 4) {
         Client.field1003 = var6;
         Client.field936 = var7;
         Client.cursorState = 2;
         Client.field1092 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = FileSystem.bufferForSize(ClientPacket.field2368, Client.field888.field1449);
         var8.packetBuffer.writeIntLE16(var3 >> 14 & 32767);
         var8.packetBuffer.method3287(KeyFocusListener.field593[82]?1:0);
         var8.packetBuffer.putShort(var0 + SceneChunkMetadata.baseX);
         var8.packetBuffer.writeIntLE16(Client.baseY + var1);
         Client.field888.method1862(var8);
      } else if(var2 == 5) {
         Client.field1003 = var6;
         Client.field936 = var7;
         Client.cursorState = 2;
         Client.field1092 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = FileSystem.bufferForSize(ClientPacket.field2399, Client.field888.field1449);
         var8.packetBuffer.writeIntLE16(var3 >> 14 & 32767);
         var8.packetBuffer.putShort(var0 + SceneChunkMetadata.baseX);
         var8.packetBuffer.method3287(KeyFocusListener.field593[82]?1:0);
         var8.packetBuffer.writeIntLE16(Client.baseY + var1);
         Client.field888.method1862(var8);
      } else if(var2 == 6) {
         Client.field1003 = var6;
         Client.field936 = var7;
         Client.cursorState = 2;
         Client.field1092 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = FileSystem.bufferForSize(ClientPacket.field2392, Client.field888.field1449);
         var8.packetBuffer.writeIntLE16(Client.baseY + var1);
         var8.packetBuffer.writeIntLE16(var3 >> 14 & 32767);
         var8.packetBuffer.method3287(KeyFocusListener.field593[82]?1:0);
         var8.packetBuffer.writeShortLE(var0 + SceneChunkMetadata.baseX);
         Client.field888.method1862(var8);
      } else {
         PacketNode var17;
         NPC var21;
         if(var2 == 7) {
            var21 = Client.cachedNPCs[var3];
            if(var21 != null) {
               Client.field1003 = var6;
               Client.field936 = var7;
               Client.cursorState = 2;
               Client.field1092 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var17 = FileSystem.bufferForSize(ClientPacket.field2348, Client.field888.field1449);
               var17.packetBuffer.putShortLE(SceneChunkMetadata.field557);
               var17.packetBuffer.writeIntLE16(var3);
               var17.packetBuffer.putByte(KeyFocusListener.field593[82]?1:0);
               var17.packetBuffer.putShortLE(class36.selectedItemIndex);
               var17.packetBuffer.putInt(GEItemNameComparator.field304);
               Client.field888.method1862(var17);
            }
         } else if(var2 == 8) {
            var21 = Client.cachedNPCs[var3];
            if(var21 != null) {
               Client.field1003 = var6;
               Client.field936 = var7;
               Client.cursorState = 2;
               Client.field1092 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var17 = FileSystem.bufferForSize(ClientPacket.field2347, Client.field888.field1449);
               var17.packetBuffer.putShortLE(Client.field984);
               var17.packetBuffer.putShort(var3);
               var17.packetBuffer.method3311(JagexGame.field3297);
               var17.packetBuffer.method3285(KeyFocusListener.field593[82]?1:0);
               Client.field888.method1862(var17);
            }
         } else if(var2 == 9) {
            var21 = Client.cachedNPCs[var3];
            if(var21 != null) {
               Client.field1003 = var6;
               Client.field936 = var7;
               Client.cursorState = 2;
               Client.field1092 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var17 = FileSystem.bufferForSize(ClientPacket.field2386, Client.field888.field1449);
               var17.packetBuffer.putShortLE(var3);
               var17.packetBuffer.method3287(KeyFocusListener.field593[82]?1:0);
               Client.field888.method1862(var17);
            }
         } else if(var2 == 10) {
            var21 = Client.cachedNPCs[var3];
            if(var21 != null) {
               Client.field1003 = var6;
               Client.field936 = var7;
               Client.cursorState = 2;
               Client.field1092 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var17 = FileSystem.bufferForSize(ClientPacket.field2344, Client.field888.field1449);
               var17.packetBuffer.putShortLE(var3);
               var17.packetBuffer.method3285(KeyFocusListener.field593[82]?1:0);
               Client.field888.method1862(var17);
            }
         } else if(var2 == 11) {
            var21 = Client.cachedNPCs[var3];
            if(var21 != null) {
               Client.field1003 = var6;
               Client.field936 = var7;
               Client.cursorState = 2;
               Client.field1092 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var17 = FileSystem.bufferForSize(ClientPacket.field2360, Client.field888.field1449);
               var17.packetBuffer.method3287(KeyFocusListener.field593[82]?1:0);
               var17.packetBuffer.writeIntLE16(var3);
               Client.field888.method1862(var17);
            }
         } else if(var2 == 12) {
            var21 = Client.cachedNPCs[var3];
            if(var21 != null) {
               Client.field1003 = var6;
               Client.field936 = var7;
               Client.cursorState = 2;
               Client.field1092 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var17 = FileSystem.bufferForSize(ClientPacket.field2395, Client.field888.field1449);
               var17.packetBuffer.writeIntLE16(var3);
               var17.packetBuffer.putByte(KeyFocusListener.field593[82]?1:0);
               Client.field888.method1862(var17);
            }
         } else if(var2 == 13) {
            var21 = Client.cachedNPCs[var3];
            if(var21 != null) {
               Client.field1003 = var6;
               Client.field936 = var7;
               Client.cursorState = 2;
               Client.field1092 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var17 = FileSystem.bufferForSize(ClientPacket.field2381, Client.field888.field1449);
               var17.packetBuffer.method3285(KeyFocusListener.field593[82]?1:0);
               var17.packetBuffer.writeIntLE16(var3);
               Client.field888.method1862(var17);
            }
         } else {
            Player var24;
            if(var2 == 14) {
               var24 = Client.cachedPlayers[var3];
               if(var24 != null) {
                  Client.field1003 = var6;
                  Client.field936 = var7;
                  Client.cursorState = 2;
                  Client.field1092 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var17 = FileSystem.bufferForSize(ClientPacket.field2323, Client.field888.field1449);
                  var17.packetBuffer.putInt(GEItemNameComparator.field304);
                  var17.packetBuffer.putByte(KeyFocusListener.field593[82]?1:0);
                  var17.packetBuffer.putShort(SceneChunkMetadata.field557);
                  var17.packetBuffer.putShort(var3);
                  var17.packetBuffer.putShort(class36.selectedItemIndex);
                  Client.field888.method1862(var17);
               }
            } else if(var2 == 15) {
               var24 = Client.cachedPlayers[var3];
               if(var24 != null) {
                  Client.field1003 = var6;
                  Client.field936 = var7;
                  Client.cursorState = 2;
                  Client.field1092 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var17 = FileSystem.bufferForSize(ClientPacket.field2311, Client.field888.field1449);
                  var17.packetBuffer.method3311(JagexGame.field3297);
                  var17.packetBuffer.writeShortLE(var3);
                  var17.packetBuffer.putShort(Client.field984);
                  var17.packetBuffer.putByte(KeyFocusListener.field593[82]?1:0);
                  Client.field888.method1862(var17);
               }
            } else if(var2 == 16) {
               Client.field1003 = var6;
               Client.field936 = var7;
               Client.cursorState = 2;
               Client.field1092 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = FileSystem.bufferForSize(ClientPacket.field2383, Client.field888.field1449);
               var8.packetBuffer.method3287(KeyFocusListener.field593[82]?1:0);
               var8.packetBuffer.method3306(GEItemNameComparator.field304);
               var8.packetBuffer.putShort(SceneChunkMetadata.field557);
               var8.packetBuffer.writeShortLE(var0 + SceneChunkMetadata.baseX);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.putShortLE(Client.baseY + var1);
               var8.packetBuffer.putShortLE(class36.selectedItemIndex);
               Client.field888.method1862(var8);
            } else if(var2 == 17) {
               Client.field1003 = var6;
               Client.field936 = var7;
               Client.cursorState = 2;
               Client.field1092 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = FileSystem.bufferForSize(ClientPacket.field2377, Client.field888.field1449);
               var8.packetBuffer.writeIntLE(JagexGame.field3297);
               var8.packetBuffer.writeIntLE16(var0 + SceneChunkMetadata.baseX);
               var8.packetBuffer.method3287(KeyFocusListener.field593[82]?1:0);
               var8.packetBuffer.writeIntLE16(Client.field984);
               var8.packetBuffer.writeIntLE16(var3);
               var8.packetBuffer.writeIntLE16(Client.baseY + var1);
               Client.field888.method1862(var8);
            } else if(var2 == 18) {
               Client.field1003 = var6;
               Client.field936 = var7;
               Client.cursorState = 2;
               Client.field1092 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = FileSystem.bufferForSize(ClientPacket.field2322, Client.field888.field1449);
               var8.packetBuffer.putShortLE(Client.baseY + var1);
               var8.packetBuffer.putShortLE(var0 + SceneChunkMetadata.baseX);
               var8.packetBuffer.putShortLE(var3);
               var8.packetBuffer.method3286(KeyFocusListener.field593[82]?1:0);
               Client.field888.method1862(var8);
            } else if(var2 == 19) {
               Client.field1003 = var6;
               Client.field936 = var7;
               Client.cursorState = 2;
               Client.field1092 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = FileSystem.bufferForSize(ClientPacket.field2370, Client.field888.field1449);
               var8.packetBuffer.putShort(var0 + SceneChunkMetadata.baseX);
               var8.packetBuffer.writeShortLE(Client.baseY + var1);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.method3287(KeyFocusListener.field593[82]?1:0);
               Client.field888.method1862(var8);
            } else if(var2 == 20) {
               Client.field1003 = var6;
               Client.field936 = var7;
               Client.cursorState = 2;
               Client.field1092 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = FileSystem.bufferForSize(ClientPacket.field2405, Client.field888.field1449);
               var8.packetBuffer.writeIntLE16(Client.baseY + var1);
               var8.packetBuffer.method3286(KeyFocusListener.field593[82]?1:0);
               var8.packetBuffer.writeShortLE(var0 + SceneChunkMetadata.baseX);
               var8.packetBuffer.writeIntLE16(var3);
               Client.field888.method1862(var8);
            } else if(var2 == 21) {
               Client.field1003 = var6;
               Client.field936 = var7;
               Client.cursorState = 2;
               Client.field1092 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = FileSystem.bufferForSize(ClientPacket.field2353, Client.field888.field1449);
               var8.packetBuffer.writeShortLE(Client.baseY + var1);
               var8.packetBuffer.writeIntLE16(var0 + SceneChunkMetadata.baseX);
               var8.packetBuffer.putByte(KeyFocusListener.field593[82]?1:0);
               var8.packetBuffer.putShortLE(var3);
               Client.field888.method1862(var8);
            } else if(var2 == 22) {
               Client.field1003 = var6;
               Client.field936 = var7;
               Client.cursorState = 2;
               Client.field1092 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = FileSystem.bufferForSize(ClientPacket.field2403, Client.field888.field1449);
               var8.packetBuffer.putShort(var0 + SceneChunkMetadata.baseX);
               var8.packetBuffer.method3287(KeyFocusListener.field593[82]?1:0);
               var8.packetBuffer.writeShortLE(var3);
               var8.packetBuffer.putShort(Client.baseY + var1);
               Client.field888.method1862(var8);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class48.region.method2728();
               } else {
                  class48.region.method2829(BoundingBox2D.plane, var0, var1, true);
               }
            } else {
               PacketNode var10;
               Widget var26;
               if(var2 == 24) {
                  var26 = VertexNormal.getWidget(var1);
                  boolean var9 = true;
                  if(var26.contentType > 0) {
                     var9 = class54.method765(var26);
                  }

                  if(var9) {
                     var10 = FileSystem.bufferForSize(ClientPacket.field2336, Client.field888.field1449);
                     var10.packetBuffer.putInt(var1);
                     Client.field888.method1862(var10);
                  }
               } else {
                  int var14;
                  if(var2 == 25) {
                     var26 = TextureProvider.getWidgetChild(var1, var0);
                     if(var26 != null) {
                        class25.method181();
                        int var25 = class36.getWidgetConfig(var26);
                        int var27 = var25 >> 11 & 63;
                        BoundingBox2D.method39(var1, var0, var27, var26.itemId);
                        Client.itemSelectionState = 0;
                        int var15 = class36.getWidgetConfig(var26);
                        var14 = var15 >> 11 & 63;
                        String var19;
                        if(var14 == 0) {
                           var19 = null;
                        } else if(var26.selectedAction != null && var26.selectedAction.trim().length() != 0) {
                           var19 = var26.selectedAction;
                        } else {
                           var19 = null;
                        }

                        Client.field986 = var19;
                        if(Client.field986 == null) {
                           Client.field986 = "Null";
                        }

                        if(var26.hasScript) {
                           Client.field910 = var26.name + Buffer.getColTags(16777215);
                        } else {
                           Client.field910 = Buffer.getColTags(65280) + var26.spellName + Buffer.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     Widget.method4187();
                  } else {
                     int var18;
                     Widget var28;
                     if(var2 == 28) {
                        var8 = FileSystem.bufferForSize(ClientPacket.field2336, Client.field888.field1449);
                        var8.packetBuffer.putInt(var1);
                        Client.field888.method1862(var8);
                        var28 = VertexNormal.getWidget(var1);
                        if(var28.dynamicValues != null && var28.dynamicValues[0][0] == 5) {
                           var18 = var28.dynamicValues[0][1];
                           VarpSettingsStore.widgetSettings[var18] = 1 - VarpSettingsStore.widgetSettings[var18];
                           class150.method2933(var18);
                        }
                     } else if(var2 == 29) {
                        var8 = FileSystem.bufferForSize(ClientPacket.field2336, Client.field888.field1449);
                        var8.packetBuffer.putInt(var1);
                        Client.field888.method1862(var8);
                        var28 = VertexNormal.getWidget(var1);
                        if(var28.dynamicValues != null && var28.dynamicValues[0][0] == 5) {
                           var18 = var28.dynamicValues[0][1];
                           if(VarpSettingsStore.widgetSettings[var18] != var28.field2837[0]) {
                              VarpSettingsStore.widgetSettings[var18] = var28.field2837[0];
                              class150.method2933(var18);
                           }
                        }
                     } else if(var2 == 30) {
                        if(Client.field958 == null) {
                           var8 = FileSystem.bufferForSize(ClientPacket.field2324, Client.field888.field1449);
                           var8.packetBuffer.writeIntLE(var1);
                           var8.packetBuffer.writeShortLE(var0);
                           Client.field888.method1862(var8);
                           Client.field958 = TextureProvider.getWidgetChild(var1, var0);
                           class33.method344(Client.field958);
                        }
                     } else if(var2 == 31) {
                        var8 = FileSystem.bufferForSize(ClientPacket.field2320, Client.field888.field1449);
                        var8.packetBuffer.putShortLE(var0);
                        var8.packetBuffer.writeShortLE(SceneChunkMetadata.field557);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.putInt(GEItemNameComparator.field304);
                        var8.packetBuffer.writeIntLE16(var3);
                        var8.packetBuffer.putShort(class36.selectedItemIndex);
                        Client.field888.method1862(var8);
                        Client.mouseCrosshair = 0;
                        Friend.field742 = VertexNormal.getWidget(var1);
                        Client.field940 = var0;
                     } else if(var2 == 32) {
                        var8 = FileSystem.bufferForSize(ClientPacket.field2314, Client.field888.field1449);
                        var8.packetBuffer.putShort(Client.field984);
                        var8.packetBuffer.method3306(var1);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.putShortLE(var0);
                        var8.packetBuffer.method3306(JagexGame.field3297);
                        Client.field888.method1862(var8);
                        Client.mouseCrosshair = 0;
                        Friend.field742 = VertexNormal.getWidget(var1);
                        Client.field940 = var0;
                     } else if(var2 == 33) {
                        var8 = FileSystem.bufferForSize(ClientPacket.field2313, Client.field888.field1449);
                        var8.packetBuffer.method3311(var1);
                        var8.packetBuffer.putShortLE(var3);
                        var8.packetBuffer.writeIntLE16(var0);
                        Client.field888.method1862(var8);
                        Client.mouseCrosshair = 0;
                        Friend.field742 = VertexNormal.getWidget(var1);
                        Client.field940 = var0;
                     } else if(var2 == 34) {
                        var8 = FileSystem.bufferForSize(ClientPacket.field2318, Client.field888.field1449);
                        var8.packetBuffer.writeShortLE(var3);
                        var8.packetBuffer.putShortLE(var0);
                        var8.packetBuffer.putInt(var1);
                        Client.field888.method1862(var8);
                        Client.mouseCrosshair = 0;
                        Friend.field742 = VertexNormal.getWidget(var1);
                        Client.field940 = var0;
                     } else if(var2 == 35) {
                        var8 = FileSystem.bufferForSize(ClientPacket.field2330, Client.field888.field1449);
                        var8.packetBuffer.putShortLE(var3);
                        var8.packetBuffer.method3311(var1);
                        var8.packetBuffer.putShort(var0);
                        Client.field888.method1862(var8);
                        Client.mouseCrosshair = 0;
                        Friend.field742 = VertexNormal.getWidget(var1);
                        Client.field940 = var0;
                     } else if(var2 == 36) {
                        var8 = FileSystem.bufferForSize(ClientPacket.field2389, Client.field888.field1449);
                        var8.packetBuffer.writeShortLE(var3);
                        var8.packetBuffer.method3306(var1);
                        var8.packetBuffer.putShortLE(var0);
                        Client.field888.method1862(var8);
                        Client.mouseCrosshair = 0;
                        Friend.field742 = VertexNormal.getWidget(var1);
                        Client.field940 = var0;
                     } else if(var2 == 37) {
                        var8 = FileSystem.bufferForSize(ClientPacket.field2340, Client.field888.field1449);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.method3311(var1);
                        var8.packetBuffer.putShort(var3);
                        Client.field888.method1862(var8);
                        Client.mouseCrosshair = 0;
                        Friend.field742 = VertexNormal.getWidget(var1);
                        Client.field940 = var0;
                     } else {
                        if(var2 == 38) {
                           class25.method181();
                           var26 = VertexNormal.getWidget(var1);
                           Client.itemSelectionState = 1;
                           class36.selectedItemIndex = var0;
                           GEItemNameComparator.field304 = var1;
                           SceneChunkMetadata.field557 = var3;
                           class33.method344(var26);
                           Client.lastSelectedItemName = Buffer.getColTags(16748608) + KitDefinition.getItemDefinition(var3).name + Buffer.getColTags(16777215);
                           if(Client.lastSelectedItemName == null) {
                              Client.lastSelectedItemName = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           var8 = FileSystem.bufferForSize(ClientPacket.field2350, Client.field888.field1449);
                           var8.packetBuffer.method3306(var1);
                           var8.packetBuffer.writeShortLE(var0);
                           var8.packetBuffer.putShortLE(var3);
                           Client.field888.method1862(var8);
                           Client.mouseCrosshair = 0;
                           Friend.field742 = VertexNormal.getWidget(var1);
                           Client.field940 = var0;
                        } else if(var2 == 40) {
                           var8 = FileSystem.bufferForSize(ClientPacket.field2362, Client.field888.field1449);
                           var8.packetBuffer.writeIntLE16(var0);
                           var8.packetBuffer.method3311(var1);
                           var8.packetBuffer.putShortLE(var3);
                           Client.field888.method1862(var8);
                           Client.mouseCrosshair = 0;
                           Friend.field742 = VertexNormal.getWidget(var1);
                           Client.field940 = var0;
                        } else if(var2 == 41) {
                           var8 = FileSystem.bufferForSize(ClientPacket.field2326, Client.field888.field1449);
                           var8.packetBuffer.writeIntLE16(var0);
                           var8.packetBuffer.putShort(var3);
                           var8.packetBuffer.method3311(var1);
                           Client.field888.method1862(var8);
                           Client.mouseCrosshair = 0;
                           Friend.field742 = VertexNormal.getWidget(var1);
                           Client.field940 = var0;
                        } else if(var2 == 42) {
                           var8 = FileSystem.bufferForSize(ClientPacket.field2384, Client.field888.field1449);
                           var8.packetBuffer.putShort(var3);
                           var8.packetBuffer.putInt(var1);
                           var8.packetBuffer.putShortLE(var0);
                           Client.field888.method1862(var8);
                           Client.mouseCrosshair = 0;
                           Friend.field742 = VertexNormal.getWidget(var1);
                           Client.field940 = var0;
                        } else if(var2 == 43) {
                           var8 = FileSystem.bufferForSize(ClientPacket.field2346, Client.field888.field1449);
                           var8.packetBuffer.putInt(var1);
                           var8.packetBuffer.writeShortLE(var3);
                           var8.packetBuffer.writeShortLE(var0);
                           Client.field888.method1862(var8);
                           Client.mouseCrosshair = 0;
                           Friend.field742 = VertexNormal.getWidget(var1);
                           Client.field940 = var0;
                        } else if(var2 == 44) {
                           var24 = Client.cachedPlayers[var3];
                           if(var24 != null) {
                              Client.field1003 = var6;
                              Client.field936 = var7;
                              Client.cursorState = 2;
                              Client.field1092 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var17 = FileSystem.bufferForSize(ClientPacket.field2315, Client.field888.field1449);
                              var17.packetBuffer.putByte(KeyFocusListener.field593[82]?1:0);
                              var17.packetBuffer.putShortLE(var3);
                              Client.field888.method1862(var17);
                           }
                        } else if(var2 == 45) {
                           var24 = Client.cachedPlayers[var3];
                           if(var24 != null) {
                              Client.field1003 = var6;
                              Client.field936 = var7;
                              Client.cursorState = 2;
                              Client.field1092 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var17 = FileSystem.bufferForSize(ClientPacket.field2329, Client.field888.field1449);
                              var17.packetBuffer.method3287(KeyFocusListener.field593[82]?1:0);
                              var17.packetBuffer.putShortLE(var3);
                              Client.field888.method1862(var17);
                           }
                        } else if(var2 == 46) {
                           var24 = Client.cachedPlayers[var3];
                           if(var24 != null) {
                              Client.field1003 = var6;
                              Client.field936 = var7;
                              Client.cursorState = 2;
                              Client.field1092 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var17 = FileSystem.bufferForSize(ClientPacket.field2335, Client.field888.field1449);
                              var17.packetBuffer.putShortLE(var3);
                              var17.packetBuffer.method3286(KeyFocusListener.field593[82]?1:0);
                              Client.field888.method1862(var17);
                           }
                        } else if(var2 == 47) {
                           var24 = Client.cachedPlayers[var3];
                           if(var24 != null) {
                              Client.field1003 = var6;
                              Client.field936 = var7;
                              Client.cursorState = 2;
                              Client.field1092 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var17 = FileSystem.bufferForSize(ClientPacket.field2359, Client.field888.field1449);
                              var17.packetBuffer.method3287(KeyFocusListener.field593[82]?1:0);
                              var17.packetBuffer.putShortLE(var3);
                              Client.field888.method1862(var17);
                           }
                        } else if(var2 == 48) {
                           var24 = Client.cachedPlayers[var3];
                           if(var24 != null) {
                              Client.field1003 = var6;
                              Client.field936 = var7;
                              Client.cursorState = 2;
                              Client.field1092 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var17 = FileSystem.bufferForSize(ClientPacket.field2337, Client.field888.field1449);
                              var17.packetBuffer.putShortLE(var3);
                              var17.packetBuffer.method3286(KeyFocusListener.field593[82]?1:0);
                              Client.field888.method1862(var17);
                           }
                        } else if(var2 == 49) {
                           var24 = Client.cachedPlayers[var3];
                           if(var24 != null) {
                              Client.field1003 = var6;
                              Client.field936 = var7;
                              Client.cursorState = 2;
                              Client.field1092 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var17 = FileSystem.bufferForSize(ClientPacket.field2361, Client.field888.field1449);
                              var17.packetBuffer.writeIntLE16(var3);
                              var17.packetBuffer.method3285(KeyFocusListener.field593[82]?1:0);
                              Client.field888.method1862(var17);
                           }
                        } else if(var2 == 50) {
                           var24 = Client.cachedPlayers[var3];
                           if(var24 != null) {
                              Client.field1003 = var6;
                              Client.field936 = var7;
                              Client.cursorState = 2;
                              Client.field1092 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var17 = FileSystem.bufferForSize(ClientPacket.field2391, Client.field888.field1449);
                              var17.packetBuffer.method3287(KeyFocusListener.field593[82]?1:0);
                              var17.packetBuffer.putShortLE(var3);
                              Client.field888.method1862(var17);
                           }
                        } else if(var2 == 51) {
                           var24 = Client.cachedPlayers[var3];
                           if(var24 != null) {
                              Client.field1003 = var6;
                              Client.field936 = var7;
                              Client.cursorState = 2;
                              Client.field1092 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var17 = FileSystem.bufferForSize(ClientPacket.field2393, Client.field888.field1449);
                              var17.packetBuffer.method3285(KeyFocusListener.field593[82]?1:0);
                              var17.packetBuffer.writeShortLE(var3);
                              Client.field888.method1862(var17);
                           }
                        } else {
                           label1046: {
                              if(var2 != 57) {
                                 if(var2 == 58) {
                                    var26 = TextureProvider.getWidgetChild(var1, var0);
                                    if(var26 != null) {
                                       var17 = FileSystem.bufferForSize(ClientPacket.field2388, Client.field888.field1449);
                                       var17.packetBuffer.putInt(var1);
                                       var17.packetBuffer.writeShortLE(Client.field985);
                                       var17.packetBuffer.putShortLE(var26.itemId);
                                       var17.packetBuffer.writeShortLE(Client.field984);
                                       var17.packetBuffer.method3311(JagexGame.field3297);
                                       var17.packetBuffer.writeIntLE16(var0);
                                       Client.field888.method1862(var17);
                                    }
                                    break label1046;
                                 }

                                 if(var2 == 1001) {
                                    Client.field1003 = var6;
                                    Client.field936 = var7;
                                    Client.cursorState = 2;
                                    Client.field1092 = 0;
                                    Client.destinationX = var0;
                                    Client.destinationY = var1;
                                    var8 = FileSystem.bufferForSize(ClientPacket.field2351, Client.field888.field1449);
                                    var8.packetBuffer.writeIntLE16(var3 >> 14 & 32767);
                                    var8.packetBuffer.writeIntLE16(var0 + SceneChunkMetadata.baseX);
                                    var8.packetBuffer.method3285(KeyFocusListener.field593[82]?1:0);
                                    var8.packetBuffer.putShort(Client.baseY + var1);
                                    Client.field888.method1862(var8);
                                    break label1046;
                                 }

                                 if(var2 == 1002) {
                                    Client.field1003 = var6;
                                    Client.field936 = var7;
                                    Client.cursorState = 2;
                                    Client.field1092 = 0;
                                    var8 = FileSystem.bufferForSize(ClientPacket.field2390, Client.field888.field1449);
                                    var8.packetBuffer.putShort(var3 >> 14 & 32767);
                                    Client.field888.method1862(var8);
                                    break label1046;
                                 }

                                 if(var2 == 1003) {
                                    Client.field1003 = var6;
                                    Client.field936 = var7;
                                    Client.cursorState = 2;
                                    Client.field1092 = 0;
                                    var21 = Client.cachedNPCs[var3];
                                    if(var21 != null) {
                                       NPCComposition var29 = var21.composition;
                                       if(var29.configs != null) {
                                          var29 = var29.transform();
                                       }

                                       if(var29 != null) {
                                          var10 = FileSystem.bufferForSize(ClientPacket.field2343, Client.field888.field1449);
                                          var10.packetBuffer.putShort(var29.id);
                                          Client.field888.method1862(var10);
                                       }
                                    }
                                    break label1046;
                                 }

                                 if(var2 == 1004) {
                                    Client.field1003 = var6;
                                    Client.field936 = var7;
                                    Client.cursorState = 2;
                                    Client.field1092 = 0;
                                    var8 = FileSystem.bufferForSize(ClientPacket.field2402, Client.field888.field1449);
                                    var8.packetBuffer.writeIntLE16(var3);
                                    Client.field888.method1862(var8);
                                    break label1046;
                                 }

                                 if(var2 == 1005) {
                                    var26 = VertexNormal.getWidget(var1);
                                    if(var26 != null && var26.itemQuantities[var0] >= 100000) {
                                       class25.sendGameMessage(27, "", var26.itemQuantities[var0] + " x " + KitDefinition.getItemDefinition(var3).name);
                                    } else {
                                       var17 = FileSystem.bufferForSize(ClientPacket.field2402, Client.field888.field1449);
                                       var17.packetBuffer.writeIntLE16(var3);
                                       Client.field888.method1862(var17);
                                    }

                                    Client.mouseCrosshair = 0;
                                    Friend.field742 = VertexNormal.getWidget(var1);
                                    Client.field940 = var0;
                                    break label1046;
                                 }

                                 if(var2 != 1007) {
                                    if(var2 == 1008 || var2 == 1009 || var2 == 1011 || var2 == 1010 || var2 == 1012) {
                                       class61.renderOverview.method5392(var2, var3, new Coordinates(var0), new Coordinates(var1));
                                    }
                                    break label1046;
                                 }
                              }

                              var26 = TextureProvider.getWidgetChild(var1, var0);
                              if(var26 != null) {
                                 int var22 = var26.itemId;
                                 Widget var23 = TextureProvider.getWidgetChild(var1, var0);
                                 if(var23 != null) {
                                    if(var23.field2859 != null) {
                                       ScriptEvent var11 = new ScriptEvent();
                                       var11.widget = var23;
                                       var11.field773 = var3;
                                       var11.string = var5;
                                       var11.objs = var23.field2859;
                                       CacheFile.method2350(var11);
                                    }

                                    boolean var16 = true;
                                    if(var23.contentType > 0) {
                                       var16 = class54.method765(var23);
                                    }

                                    if(var16) {
                                       int var13 = class36.getWidgetConfig(var23);
                                       var14 = var3 - 1;
                                       boolean var12 = (var13 >> var14 + 1 & 1) != 0;
                                       if(var12) {
                                          PacketNode var20;
                                          if(var3 == 1) {
                                             var20 = FileSystem.bufferForSize(ClientPacket.field2367, Client.field888.field1449);
                                             var20.packetBuffer.putInt(var1);
                                             var20.packetBuffer.putShort(var0);
                                             var20.packetBuffer.putShort(var22);
                                             Client.field888.method1862(var20);
                                          }

                                          if(var3 == 2) {
                                             var20 = FileSystem.bufferForSize(ClientPacket.field2325, Client.field888.field1449);
                                             var20.packetBuffer.putInt(var1);
                                             var20.packetBuffer.putShort(var0);
                                             var20.packetBuffer.putShort(var22);
                                             Client.field888.method1862(var20);
                                          }

                                          if(var3 == 3) {
                                             var20 = FileSystem.bufferForSize(ClientPacket.field2404, Client.field888.field1449);
                                             var20.packetBuffer.putInt(var1);
                                             var20.packetBuffer.putShort(var0);
                                             var20.packetBuffer.putShort(var22);
                                             Client.field888.method1862(var20);
                                          }

                                          if(var3 == 4) {
                                             var20 = FileSystem.bufferForSize(ClientPacket.field2406, Client.field888.field1449);
                                             var20.packetBuffer.putInt(var1);
                                             var20.packetBuffer.putShort(var0);
                                             var20.packetBuffer.putShort(var22);
                                             Client.field888.method1862(var20);
                                          }

                                          if(var3 == 5) {
                                             var20 = FileSystem.bufferForSize(ClientPacket.field2331, Client.field888.field1449);
                                             var20.packetBuffer.putInt(var1);
                                             var20.packetBuffer.putShort(var0);
                                             var20.packetBuffer.putShort(var22);
                                             Client.field888.method1862(var20);
                                          }

                                          if(var3 == 6) {
                                             var20 = FileSystem.bufferForSize(ClientPacket.field2400, Client.field888.field1449);
                                             var20.packetBuffer.putInt(var1);
                                             var20.packetBuffer.putShort(var0);
                                             var20.packetBuffer.putShort(var22);
                                             Client.field888.method1862(var20);
                                          }

                                          if(var3 == 7) {
                                             var20 = FileSystem.bufferForSize(ClientPacket.field2371, Client.field888.field1449);
                                             var20.packetBuffer.putInt(var1);
                                             var20.packetBuffer.putShort(var0);
                                             var20.packetBuffer.putShort(var22);
                                             Client.field888.method1862(var20);
                                          }

                                          if(var3 == 8) {
                                             var20 = FileSystem.bufferForSize(ClientPacket.field2379, Client.field888.field1449);
                                             var20.packetBuffer.putInt(var1);
                                             var20.packetBuffer.putShort(var0);
                                             var20.packetBuffer.putShort(var22);
                                             Client.field888.method1862(var20);
                                          }

                                          if(var3 == 9) {
                                             var20 = FileSystem.bufferForSize(ClientPacket.field2327, Client.field888.field1449);
                                             var20.packetBuffer.putInt(var1);
                                             var20.packetBuffer.putShort(var0);
                                             var20.packetBuffer.putShort(var22);
                                             Client.field888.method1862(var20);
                                          }

                                          if(var3 == 10) {
                                             var20 = FileSystem.bufferForSize(ClientPacket.field2319, Client.field888.field1449);
                                             var20.packetBuffer.putInt(var1);
                                             var20.packetBuffer.putShort(var0);
                                             var20.packetBuffer.putShort(var22);
                                             Client.field888.method1862(var20);
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if(Client.itemSelectionState != 0) {
         Client.itemSelectionState = 0;
         class33.method344(VertexNormal.getWidget(GEItemNameComparator.field304));
      }

      if(Client.spellSelected) {
         class25.method181();
      }

      if(Friend.field742 != null && Client.mouseCrosshair == 0) {
         class33.method344(Friend.field742);
      }

   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "15"
   )
   @Export("isIgnored")
   static boolean isIgnored(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = SpritePixels2.cleanUsername(var0, PendingSpawn.jagexLoginType);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(SpritePixels2.cleanUsername(var3.name, PendingSpawn.jagexLoginType))) {
               return true;
            }

            if(var1.equalsIgnoreCase(SpritePixels2.cleanUsername(var3.previousName, PendingSpawn.jagexLoginType))) {
               return true;
            }
         }

         return false;
      }
   }
}
