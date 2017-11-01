import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 690544057869974923L
   )
   @Export("position")
   long position;
   @ObfuscatedName("w")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -8685304355222831927L
   )
   @Export("length")
   long length;

   public FileOnDisk(File var1, String var2, long var3) throws IOException {
      if(var3 == -1L) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.file = new RandomAccessFile(var1, var2);
      this.length = var3;
      this.position = 0L;
      int var5 = this.file.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.file.seek(0L);
         this.file.write(var5);
      }

      this.file.seek(0L);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1384110788"
   )
   public final void method2406(boolean var1) throws IOException {
      if(this.file != null) {
         if(var1) {
            try {
               this.file.getFD().sync();
            } catch (SyncFailedException var3) {
               ;
            }
         }

         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "623553100"
   )
   @Export("length")
   public final long length() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "127"
   )
   @Export("close")
   public final void close() throws IOException {
      this.method2406(false);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "1399538335"
   )
   @Export("read")
   public final int read(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("w")
   @Export("seek")
   final void seek(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "25"
   )
   @Export("write")
   public final void write(byte[] var1, int var2, int var3) throws IOException {
      if(this.position + (long)var3 > this.length) {
         this.file.seek(1L + this.length);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.close();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lfz;Lgk;I)Lgk;",
      garbageValue = "1664462415"
   )
   static final IterableHashTable method2427(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = class48.method707(var2);
         var1 = new IterableHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new ObjectNode(var0.readString());
         } else {
            var6 = new IntegerNode(var0.readInt());
         }

         var1.put((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-95"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         class3.region = new Region(4, 104, 104, class61.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         ScriptVarType.field85 = new SpritePixels(512, 512);
         class90.loadingText = "Starting game engine...";
         class90.loadingBarPercentage = 5;
         Client.loadingStage = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.loadingStage == 20) {
            int[] var24 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 15 + 128;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var24[var1] = var4 * var3 >> 16;
            }

            Region.method2752(var24, 500, 800, 512, 334);
            class90.loadingText = "Prepared visibility map";
            class90.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         } else if(Client.loadingStage == 30) {
            class174.indexInterfaces = class13.openCacheIndex(0, false, true, true);
            WorldMapData.indexSoundEffects = class13.openCacheIndex(1, false, true, true);
            class8.configsIndex = class13.openCacheIndex(2, true, false, true);
            DecorativeObject.field2162 = class13.openCacheIndex(3, false, true, true);
            class15.field310 = class13.openCacheIndex(4, false, true, true);
            class18.indexMaps = class13.openCacheIndex(5, true, true, true);
            class37.indexTrack1 = class13.openCacheIndex(6, true, true, false);
            class14.indexModels = class13.openCacheIndex(7, false, true, true);
            class3.indexSprites = class13.openCacheIndex(8, false, true, true);
            Client.indexTextures = class13.openCacheIndex(9, false, true, true);
            class89.field1409 = class13.openCacheIndex(10, false, true, true);
            ScriptEvent.indexTrack2 = class13.openCacheIndex(11, false, true, true);
            WorldMapType1.indexScripts = class13.openCacheIndex(12, false, true, true);
            BaseVarType.field41 = class13.openCacheIndex(13, true, false, true);
            ItemContainer.vorbisIndex = class13.openCacheIndex(14, false, true, false);
            World.field1295 = class13.openCacheIndex(15, false, true, true);
            class232.indexWorldMap = class13.openCacheIndex(16, false, true, false);
            class90.loadingText = "Connecting to update server";
            class90.loadingBarPercentage = 20;
            Client.loadingStage = 40;
         } else if(Client.loadingStage == 40) {
            byte var20 = 0;
            var0 = var20 + class174.indexInterfaces.percentage() * 4 / 100;
            var0 += WorldMapData.indexSoundEffects.percentage() * 4 / 100;
            var0 += class8.configsIndex.percentage() * 2 / 100;
            var0 += DecorativeObject.field2162.percentage() * 2 / 100;
            var0 += class15.field310.percentage() * 6 / 100;
            var0 += class18.indexMaps.percentage() * 4 / 100;
            var0 += class37.indexTrack1.percentage() * 2 / 100;
            var0 += class14.indexModels.percentage() * 58 / 100;
            var0 += class3.indexSprites.percentage() * 2 / 100;
            var0 += Client.indexTextures.percentage() * 2 / 100;
            var0 += class89.field1409.percentage() * 2 / 100;
            var0 += ScriptEvent.indexTrack2.percentage() * 2 / 100;
            var0 += WorldMapType1.indexScripts.percentage() * 2 / 100;
            var0 += BaseVarType.field41.percentage() * 2 / 100;
            var0 += ItemContainer.vorbisIndex.percentage() * 2 / 100;
            var0 += World.field1295.percentage() * 2 / 100;
            var0 += class232.indexWorldMap.percentage() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class90.loadingText = "Checking for updates - " + var0 + "%";
               }

               class90.loadingBarPercentage = 30;
            } else {
               class90.loadingText = "Loaded update list";
               class90.loadingBarPercentage = 30;
               Client.loadingStage = 45;
            }
         } else {
            IndexData var16;
            IndexData var17;
            IndexData var18;
            if(Client.loadingStage == 45) {
               boolean var19 = !Client.lowMemory;
               AbstractSoundSystem.sampleRate = 22050;
               AbstractSoundSystem.highMemory = var19;
               FaceNormal.priority = 2;
               class204 var25 = new class204();
               var25.method3860(9, 128);
               ItemLayer.soundSystem0 = class80.method1603(GameEngine.taskManager, 0, 22050);
               ItemLayer.soundSystem0.method2068(var25);
               var16 = World.field1295;
               var17 = ItemContainer.vorbisIndex;
               var18 = class15.field310;
               class203.field2501 = var16;
               class203.field2498 = var17;
               class203.field2503 = var18;
               class203.field2499 = var25;
               class1.soundSystem1 = class80.method1603(GameEngine.taskManager, 1, 2048);
               class11.field278 = new class100();
               class1.soundSystem1.method2068(class11.field278);
               class251.field3390 = new class114(22050, AbstractSoundSystem.sampleRate);
               class90.loadingText = "Prepared sound engine";
               class90.loadingBarPercentage = 35;
               Client.loadingStage = 50;
               class7.field246 = new class262(class3.indexSprites, BaseVarType.field41);
            } else if(Client.loadingStage == 50) {
               class261[] var23 = new class261[]{class261.field3628, class261.field3622, class261.field3624, class261.field3623, class261.field3627, class261.field3634};
               var1 = var23.length;
               Client.field980 = class7.field246.method4823(class261.method4816());
               if(Client.field980.size() < var1) {
                  class90.loadingText = "Loading fonts - " + Client.field980.size() * 100 / var1 + "%";
                  class90.loadingBarPercentage = 40;
               } else {
                  Projectile.field1477 = (Font)Client.field980.get(class261.field3634);
                  class9.font_p12full = (Font)Client.field980.get(class261.field3623);
                  class155.field2238 = (Font)Client.field980.get(class261.field3624);
                  class226.field3137 = new MachineInfo(true);
                  class90.loadingText = "Loaded fonts";
                  class90.loadingBarPercentage = 40;
                  Client.loadingStage = 60;
               }
            } else {
               IndexData var15;
               if(Client.loadingStage == 60) {
                  var15 = class89.field1409;
                  var16 = class3.indexSprites;
                  var3 = 0;
                  if(var15.method4210("title.jpg", "")) {
                     ++var3;
                  }

                  if(var16.method4210("logo", "")) {
                     ++var3;
                  }

                  if(var16.method4210("logo_deadman_mode", "")) {
                     ++var3;
                  }

                  if(var16.method4210("titlebox", "")) {
                     ++var3;
                  }

                  if(var16.method4210("titlebutton", "")) {
                     ++var3;
                  }

                  if(var16.method4210("runes", "")) {
                     ++var3;
                  }

                  if(var16.method4210("title_mute", "")) {
                     ++var3;
                  }

                  if(var16.method4210("options_radio_buttons,0", "")) {
                     ++var3;
                  }

                  if(var16.method4210("options_radio_buttons,2", "")) {
                     ++var3;
                  }

                  if(var16.method4210("options_radio_buttons,4", "")) {
                     ++var3;
                  }

                  if(var16.method4210("options_radio_buttons,6", "")) {
                     ++var3;
                  }

                  var16.method4210("sl_back", "");
                  var16.method4210("sl_flags", "");
                  var16.method4210("sl_arrows", "");
                  var16.method4210("sl_stars", "");
                  var16.method4210("sl_button", "");
                  var4 = WorldMapType3.method212();
                  if(var3 < var4) {
                     class90.loadingText = "Loading title screen - " + var3 * 100 / var4 + "%";
                     class90.loadingBarPercentage = 50;
                  } else {
                     class90.loadingText = "Loaded title screen";
                     class90.loadingBarPercentage = 50;
                     class72.setGameState(5);
                     Client.loadingStage = 70;
                  }
               } else if(Client.loadingStage == 70) {
                  if(!class8.configsIndex.method4225()) {
                     class90.loadingText = "Loading config - " + class8.configsIndex.method4301() + "%";
                     class90.loadingBarPercentage = 60;
                  } else {
                     IndexData var22 = class8.configsIndex;
                     Overlay.overlay_ref = var22;
                     class80.method1606(class8.configsIndex);
                     class37.method492(class8.configsIndex, class14.indexModels);
                     GraphicsObject.method1670(class8.configsIndex, class14.indexModels, Client.lowMemory);
                     WorldMapData.method338(class8.configsIndex, class14.indexModels);
                     class33.method348(class8.configsIndex);
                     AbstractSoundSystem.method2115(class8.configsIndex, class14.indexModels, Client.isMembers, Projectile.field1477);
                     class177.method3489(class8.configsIndex, class174.indexInterfaces, WorldMapData.indexSoundEffects);
                     var15 = class8.configsIndex;
                     var16 = class14.indexModels;
                     class2.field21 = var15;
                     Spotanim.field3333 = var16;
                     class5.method17(class8.configsIndex);
                     var17 = class8.configsIndex;
                     VarPlayerType.varplayer_ref = var17;
                     VarPlayerType.field3280 = VarPlayerType.varplayer_ref.fileCount(16);
                     class207.method3964(DecorativeObject.field2162, class14.indexModels, class3.indexSprites, BaseVarType.field41);
                     class61.method1066(class8.configsIndex);
                     var18 = class8.configsIndex;
                     Enum.field3398 = var18;
                     IndexData var5 = class8.configsIndex;
                     class243.field3310 = var5;
                     IndexData var6 = class8.configsIndex;
                     class244.field3316 = var6;
                     class2.method4(class8.configsIndex);
                     class24.chatMessages = new Varcs();
                     IndexData var7 = class8.configsIndex;
                     IndexData var8 = class3.indexSprites;
                     IndexData var9 = BaseVarType.field41;
                     class254.field3430 = var7;
                     class254.field3432 = var8;
                     class254.field3433 = var9;
                     class227.method4158(class8.configsIndex, class3.indexSprites);
                     IndexData var10 = class8.configsIndex;
                     IndexData var11 = class3.indexSprites;
                     Area.field3300 = var11;
                     if(var10.method4225()) {
                        KeyFocusListener.field645 = var10.fileCount(35);
                        Area.field3285 = new Area[KeyFocusListener.field645];

                        for(int var12 = 0; var12 < KeyFocusListener.field645; ++var12) {
                           byte[] var13 = var10.getConfigData(35, var12);
                           if(var13 != null) {
                              Area.field3285[var12] = new Area(var12);
                              Area.field3285[var12].method4365(new Buffer(var13));
                              Area.field3285[var12].method4367();
                           }
                        }
                     }

                     class90.loadingText = "Loaded config";
                     class90.loadingBarPercentage = 60;
                     Client.loadingStage = 80;
                  }
               } else if(Client.loadingStage == 80) {
                  var0 = 0;
                  if(class202.compass == null) {
                     class202.compass = class224.method4153(class3.indexSprites, "compass", "");
                  } else {
                     ++var0;
                  }

                  if(class46.mapedge == null) {
                     class46.mapedge = class224.method4153(class3.indexSprites, "mapedge", "");
                  } else {
                     ++var0;
                  }

                  if(class220.mapscene == null) {
                     class220.mapscene = class219.method4135(class3.indexSprites, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(GZipDecompressor.headIconsPk == null) {
                     GZipDecompressor.headIconsPk = SceneTilePaint.method2714(class3.indexSprites, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(WorldMapType1.headIconsPrayer == null) {
                     WorldMapType1.headIconsPrayer = SceneTilePaint.method2714(class3.indexSprites, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(class14.headIconsHint == null) {
                     class14.headIconsHint = SceneTilePaint.method2714(class3.indexSprites, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(class202.mapMarkers == null) {
                     class202.mapMarkers = SceneTilePaint.method2714(class3.indexSprites, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(GroundObject.field1854 == null) {
                     GroundObject.field1854 = SceneTilePaint.method2714(class3.indexSprites, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(class34.mapDots == null) {
                     class34.mapDots = SceneTilePaint.method2714(class3.indexSprites, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(class88.field1401 == null) {
                     class88.field1401 = class219.method4135(class3.indexSprites, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(CombatInfoListHolder.field1360 == null) {
                     CombatInfoListHolder.field1360 = class219.method4135(class3.indexSprites, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 11) {
                     class90.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                     class90.loadingBarPercentage = 70;
                  } else {
                     FontTypeFace.modIcons = CombatInfoListHolder.field1360;
                     class46.mapedge.method5166();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;
                     class220.mapscene[0].method5136(var4 + var1, var2 + var4, var3 + var4);
                     class90.loadingText = "Loaded sprites";
                     class90.loadingBarPercentage = 70;
                     Client.loadingStage = 90;
                  }
               } else if(Client.loadingStage == 90) {
                  if(!Client.indexTextures.method4225()) {
                     class90.loadingText = "Loading textures - " + Client.indexTextures.method4301() + "%";
                     class90.loadingBarPercentage = 90;
                  } else {
                     TextureProvider var21 = new TextureProvider(Client.indexTextures, class3.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
                     Graphics3D.setTextureLoader(var21);
                     Graphics3D.setBrightness(0.8D);
                     class90.loadingText = "Loaded textures";
                     class90.loadingBarPercentage = 90;
                     Client.loadingStage = 110;
                  }
               } else if(Client.loadingStage == 110) {
                  class56.field695 = new class70();
                  GameEngine.taskManager.createRunnable(class56.field695, 10);
                  class90.loadingText = "Loaded input handler";
                  class90.loadingBarPercentage = 92;
                  Client.loadingStage = 120;
               } else if(Client.loadingStage == 120) {
                  if(!class89.field1409.method4210("huffman", "")) {
                     class90.loadingText = "Loading wordpack - " + 0 + "%";
                     class90.loadingBarPercentage = 94;
                  } else {
                     Huffman var14 = new Huffman(class89.field1409.method4265("huffman", ""));
                     class265.field3661 = var14;
                     class90.loadingText = "Loaded wordpack";
                     class90.loadingBarPercentage = 94;
                     Client.loadingStage = 130;
                  }
               } else if(Client.loadingStage == 130) {
                  if(!DecorativeObject.field2162.method4225()) {
                     class90.loadingText = "Loading interfaces - " + DecorativeObject.field2162.method4301() * 4 / 5 + "%";
                     class90.loadingBarPercentage = 96;
                  } else if(!WorldMapType1.indexScripts.method4225()) {
                     class90.loadingText = "Loading interfaces - " + (80 + WorldMapType1.indexScripts.method4301() / 6) + "%";
                     class90.loadingBarPercentage = 96;
                  } else if(!BaseVarType.field41.method4225()) {
                     class90.loadingText = "Loading interfaces - " + (96 + BaseVarType.field41.method4301() / 50) + "%";
                     class90.loadingBarPercentage = 96;
                  } else {
                     class90.loadingText = "Loaded interfaces";
                     class90.loadingBarPercentage = 98;
                     Client.loadingStage = 140;
                  }
               } else if(Client.loadingStage == 140) {
                  class90.loadingBarPercentage = 100;
                  if(!class232.indexWorldMap.method4211(class40.field567.field563)) {
                     class90.loadingText = "Loading world map - " + class232.indexWorldMap.method4213(class40.field567.field563) / 10 + "%";
                  } else {
                     if(Client.renderOverview == null) {
                        Client.renderOverview = new RenderOverview();
                        Client.renderOverview.method5294(class232.indexWorldMap, class155.field2238, Client.field980, class220.mapscene);
                     }

                     var0 = Client.renderOverview.method5295();
                     if(var0 < 100) {
                        class90.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                     } else {
                        class90.loadingText = "Loaded world map";
                        Client.loadingStage = 150;
                     }
                  }
               } else if(Client.loadingStage == 150) {
                  class72.setGameState(10);
               }
            }
         }
      }
   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(Lhj;I)V",
      garbageValue = "-1972454804"
   )
   static final void method2403(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field956 == -1) {
            Client.field956 = var0.spriteId;
            Client.field1187 = var0.field2678;
         }

         if(Client.field1185.isFemale) {
            var0.spriteId = Client.field956;
         } else {
            var0.spriteId = Client.field1187;
         }

      } else if(var1 == 325) {
         if(Client.field956 == -1) {
            Client.field956 = var0.spriteId;
            Client.field1187 = var0.field2678;
         }

         if(Client.field1185.isFemale) {
            var0.spriteId = Client.field1187;
         } else {
            var0.spriteId = Client.field956;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "([Lhj;II)V",
      garbageValue = "-231671021"
   )
   static final void method2424(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method2424(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  PendingSpawn.method1523(var4.id, var1);
               }
            }

            ScriptEvent var5;
            if(var1 == 0 && var3.field2749 != null) {
               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.field849 = var3.field2749;
               class56.method817(var5);
            }

            if(var1 == 1 && var3.field2740 != null) {
               if(var3.index >= 0) {
                  Widget var6 = ItemLayer.method2454(var3.id);
                  if(var6 == null || var6.children == null || var3.index >= var6.children.length || var3 != var6.children[var3.index]) {
                     continue;
                  }
               }

               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.field849 = var3.field2740;
               class56.method817(var5);
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lin;",
      garbageValue = "156445311"
   )
   public static Enum method2428(int var0) {
      Enum var1 = (Enum)Enum.field3408.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Enum.field3398.getConfigData(8, var0);
         var1 = new Enum();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Enum.field3408.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lco;Lco;IZB)I",
      garbageValue = "7"
   )
   static int method2410(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1545()?(var1.method1545()?0:1):(var1.method1545()?-1:0)):(var2 == 5?(var0.method1547()?(var1.method1547()?0:1):(var1.method1547()?-1:0)):(var2 == 6?(var0.method1548()?(var1.method1548()?0:1):(var1.method1548()?-1:0)):(var2 == 7?(var0.method1546()?(var1.method1546()?0:1):(var1.method1546()?-1:0)):var0.id - var1.id)))));
      }
   }
}
