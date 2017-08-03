import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class182 {
   @ObfuscatedName("d")
   public static final String[][] field2414;
   @ObfuscatedName("g")
   public static boolean field2413;
   @ObfuscatedName("q")
   public static final String[] field2409;
   @ObfuscatedName("x")
   public static Calendar field2410;

   static {
      field2414 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2409 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2410 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-602397291"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         class51.region = new Region(4, 104, 104, class62.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         KeyFocusListener.field619 = new SpritePixels(512, 512);
         class92.loadingText = "Starting game engine...";
         class92.loadingBarPercentage = 5;
         Client.loadingStage = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.loadingStage == 20) {
            int[] var31 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 128 + var1 * 32 + 15;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var31[var1] = var4 * var3 >> 16;
            }

            Region.method2735(var31, 500, 800, 512, 334);
            class92.loadingText = "Prepared visibility map";
            class92.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         } else if(Client.loadingStage == 30) {
            class67.indexInterfaces = class12.openCacheIndex(0, false, true, true);
            class64.indexSoundEffects = class12.openCacheIndex(1, false, true, true);
            Occluder.configsIndex = class12.openCacheIndex(2, true, false, true);
            class44.field551 = class12.openCacheIndex(3, false, true, true);
            class207.field2555 = class12.openCacheIndex(4, false, true, true);
            Client.indexMaps = class12.openCacheIndex(5, true, true, true);
            class2.indexTrack1 = class12.openCacheIndex(6, true, true, false);
            class54.indexModels = class12.openCacheIndex(7, false, true, true);
            CombatInfo1.indexSprites = class12.openCacheIndex(8, false, true, true);
            SoundTask.indexTextures = class12.openCacheIndex(9, false, true, true);
            class221.field2806 = class12.openCacheIndex(10, false, true, true);
            class3.indexTrack2 = class12.openCacheIndex(11, false, true, true);
            Client.indexScripts = class12.openCacheIndex(12, false, true, true);
            IndexFile.field2256 = class12.openCacheIndex(13, true, false, true);
            class91.vorbisIndex = class12.openCacheIndex(14, false, true, false);
            class21.field323 = class12.openCacheIndex(15, false, true, true);
            Script.indexWorldMap = class12.openCacheIndex(16, false, true, false);
            class92.loadingText = "Connecting to update server";
            class92.loadingBarPercentage = 20;
            Client.loadingStage = 40;
         } else if(Client.loadingStage == 40) {
            byte var28 = 0;
            var0 = var28 + class67.indexInterfaces.percentage() * 4 / 100;
            var0 += class64.indexSoundEffects.percentage() * 4 / 100;
            var0 += Occluder.configsIndex.percentage() * 2 / 100;
            var0 += class44.field551.percentage() * 2 / 100;
            var0 += class207.field2555.percentage() * 6 / 100;
            var0 += Client.indexMaps.percentage() * 4 / 100;
            var0 += class2.indexTrack1.percentage() * 2 / 100;
            var0 += class54.indexModels.percentage() * 58 / 100;
            var0 += CombatInfo1.indexSprites.percentage() * 2 / 100;
            var0 += SoundTask.indexTextures.percentage() * 2 / 100;
            var0 += class221.field2806.percentage() * 2 / 100;
            var0 += class3.indexTrack2.percentage() * 2 / 100;
            var0 += Client.indexScripts.percentage() * 2 / 100;
            var0 += IndexFile.field2256.percentage() * 2 / 100;
            var0 += class91.vorbisIndex.percentage() * 2 / 100;
            var0 += class21.field323.percentage() * 2 / 100;
            var0 += Script.indexWorldMap.percentage() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class92.loadingText = "Checking for updates - " + var0 + "%";
               }

               class92.loadingBarPercentage = 30;
            } else {
               class92.loadingText = "Loaded update list";
               class92.loadingBarPercentage = 30;
               Client.loadingStage = 45;
            }
         } else {
            IndexData var24;
            IndexData var25;
            IndexData var26;
            if(Client.loadingStage == 45) {
               boolean var27 = !Client.lowMemory;
               AbstractSoundSystem.sampleRate = 22050;
               XClanMember.highMemory = var27;
               class174.priority = 2;
               class204 var33 = new class204();
               var33.method3810(9, 128);
               class13.soundSystem0 = class67.method1110(GameEngine.taskManager, 0, 22050);
               class13.soundSystem0.method2114(var33);
               var24 = class21.field323;
               var25 = class91.vorbisIndex;
               var26 = class207.field2555;
               class21.field325 = var24;
               class203.field2472 = var25;
               class203.field2476 = var26;
               class203.field2473 = var33;
               Renderable.soundSystem1 = class67.method1110(GameEngine.taskManager, 1, 2048);
               class2.field18 = new class104();
               Renderable.soundSystem1.method2114(class2.field18);
               CacheFile.field1539 = new class118(22050, AbstractSoundSystem.sampleRate);
               class92.loadingText = "Prepared sound engine";
               class92.loadingBarPercentage = 35;
               Client.loadingStage = 50;
               IndexDataBase.field3208 = new class262(CombatInfo1.indexSprites, IndexFile.field2256);
            } else if(Client.loadingStage == 50) {
               var0 = class261.method4716().length;
               Client.field948 = IndexDataBase.field3208.method4718(class261.method4716());
               if(Client.field948.size() < var0) {
                  class92.loadingText = "Loading fonts - " + Client.field948.size() * 100 / var0 + "%";
                  class92.loadingBarPercentage = 40;
               } else {
                  NPC.field1340 = (Font)Client.field948.get(class261.field3603);
                  class18.font_p12full = (Font)Client.field948.get(class261.field3605);
                  class43.field544 = (Font)Client.field948.get(class261.field3600);
                  class34.field467 = new MachineInfo(true);
                  class92.loadingText = "Loaded fonts";
                  class92.loadingBarPercentage = 40;
                  Client.loadingStage = 60;
               }
            } else {
               IndexData var32;
               if(Client.loadingStage == 60) {
                  var32 = class221.field2806;
                  var24 = CombatInfo1.indexSprites;
                  var3 = 0;
                  if(var32.method4135("title.jpg", "")) {
                     ++var3;
                  }

                  if(var24.method4135("logo", "")) {
                     ++var3;
                  }

                  if(var24.method4135("logo_deadman_mode", "")) {
                     ++var3;
                  }

                  if(var24.method4135("titlebox", "")) {
                     ++var3;
                  }

                  if(var24.method4135("titlebutton", "")) {
                     ++var3;
                  }

                  if(var24.method4135("runes", "")) {
                     ++var3;
                  }

                  if(var24.method4135("title_mute", "")) {
                     ++var3;
                  }

                  if(var24.method4135("options_radio_buttons,0", "")) {
                     ++var3;
                  }

                  if(var24.method4135("options_radio_buttons,2", "")) {
                     ++var3;
                  }

                  var24.method4135("sl_back", "");
                  var24.method4135("sl_flags", "");
                  var24.method4135("sl_arrows", "");
                  var24.method4135("sl_stars", "");
                  var24.method4135("sl_button", "");
                  var4 = class11.method57();
                  if(var3 < var4) {
                     class92.loadingText = "Loading title screen - " + var3 * 100 / var4 + "%";
                     class92.loadingBarPercentage = 50;
                  } else {
                     class92.loadingText = "Loaded title screen";
                     class92.loadingBarPercentage = 50;
                     class2.setGameState(5);
                     Client.loadingStage = 70;
                  }
               } else if(Client.loadingStage == 70) {
                  if(!Occluder.configsIndex.method4133()) {
                     class92.loadingText = "Loading config - " + Occluder.configsIndex.method4209() + "%";
                     class92.loadingBarPercentage = 60;
                  } else {
                     XGrandExchangeOffer.method114(Occluder.configsIndex);
                     IndexData var30 = Occluder.configsIndex;
                     FloorUnderlayDefinition.underlay_ref = var30;
                     class35.method498(Occluder.configsIndex, class54.indexModels);
                     SceneTilePaint.method2696(Occluder.configsIndex, class54.indexModels, Client.lowMemory);
                     class10.method54(Occluder.configsIndex, class54.indexModels);
                     class244.method4307(Occluder.configsIndex);
                     AbstractByteBuffer.method3399(Occluder.configsIndex, class54.indexModels, Client.isMembers, NPC.field1340);
                     var32 = Occluder.configsIndex;
                     var24 = class67.indexInterfaces;
                     var25 = class64.indexSoundEffects;
                     Sequence.seq_ref = var32;
                     Sequence.skel_ref = var24;
                     Sequence.skin_ref = var25;
                     var26 = Occluder.configsIndex;
                     IndexData var5 = class54.indexModels;
                     Spotanim.field3310 = var26;
                     Spotanim.field3318 = var5;
                     IndexData var6 = Occluder.configsIndex;
                     Varbit.varbit_ref = var6;
                     IndexData var7 = Occluder.configsIndex;
                     VarPlayerType.varplayer_ref = var7;
                     class3.field22 = VarPlayerType.varplayer_ref.fileCount(16);
                     IndexData var8 = class44.field551;
                     IndexData var9 = class54.indexModels;
                     IndexData var10 = CombatInfo1.indexSprites;
                     IndexData var11 = IndexFile.field2256;
                     class67.widgetIndex = var8;
                     NPC.field1337 = var9;
                     Widget.field2622 = var10;
                     FileOnDisk.field1544 = var11;
                     class170.widgets = new Widget[class67.widgetIndex.size()][];
                     XItemContainer.validInterfaces = new boolean[class67.widgetIndex.size()];
                     IndexData var12 = Occluder.configsIndex;
                     class181.field2407 = var12;
                     IndexData var13 = Occluder.configsIndex;
                     Enum.field3375 = var13;
                     IndexData var14 = Occluder.configsIndex;
                     class243.field3298 = var14;
                     IndexData var15 = Occluder.configsIndex;
                     class270.field3668 = var15;
                     class71.method1134(Occluder.configsIndex);
                     class51.chatMessages = new Varcs();
                     class98.method1848(Occluder.configsIndex, CombatInfo1.indexSprites, IndexFile.field2256);
                     IndexData var16 = Occluder.configsIndex;
                     IndexData var17 = CombatInfo1.indexSprites;
                     CombatInfo2.field3356 = var16;
                     CombatInfo2.field3344 = var17;
                     IndexData var18 = Occluder.configsIndex;
                     IndexData var19 = CombatInfo1.indexSprites;
                     Area.field3289 = var19;
                     if(var18.method4133()) {
                        Area.field3276 = var18.fileCount(35);
                        Area.field3286 = new Area[Area.field3276];

                        for(int var20 = 0; var20 < Area.field3276; ++var20) {
                           byte[] var21 = var18.getConfigData(35, var20);
                           if(var21 != null) {
                              Area.field3286[var20] = new Area(var20);
                              Area.field3286[var20].method4269(new Buffer(var21));
                              Area.field3286[var20].method4270();
                           }
                        }
                     }

                     class92.loadingText = "Loaded config";
                     class92.loadingBarPercentage = 60;
                     Client.loadingStage = 80;
                  }
               } else if(Client.loadingStage == 80) {
                  var0 = 0;
                  SpritePixels var23;
                  if(FrameMap.compass == null) {
                     var24 = CombatInfo1.indexSprites;
                     var3 = var24.getFile("compass");
                     var4 = var24.getChild(var3, "");
                     var23 = class13.method72(var24, var3, var4);
                     FrameMap.compass = var23;
                  } else {
                     ++var0;
                  }

                  if(class134.mapedge == null) {
                     var24 = CombatInfo1.indexSprites;
                     var3 = var24.getFile("mapedge");
                     var4 = var24.getChild(var3, "");
                     var23 = class13.method72(var24, var3, var4);
                     class134.mapedge = var23;
                  } else {
                     ++var0;
                  }

                  if(class18.field306 == null) {
                     class18.field306 = class211.method3938(CombatInfo1.indexSprites, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(class51.mapfunctions == null) {
                     class51.mapfunctions = class267.method4867(CombatInfo1.indexSprites, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(class254.hitmarks == null) {
                     class254.hitmarks = class267.method4867(CombatInfo1.indexSprites, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(class37.pkIcons == null) {
                     class37.pkIcons = class267.method4867(CombatInfo1.indexSprites, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(class51.field627 == null) {
                     class51.field627 = class267.method4867(CombatInfo1.indexSprites, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(ScriptState.field724 == null) {
                     ScriptState.field724 = class267.method4867(CombatInfo1.indexSprites, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(TextureProvider.mapDots == null) {
                     TextureProvider.mapDots = class267.method4867(CombatInfo1.indexSprites, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(FloorUnderlayDefinition.field3327 == null) {
                     FloorUnderlayDefinition.field3327 = class211.method3938(CombatInfo1.indexSprites, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(class203.field2478 == null) {
                     class203.field2478 = class211.method3938(CombatInfo1.indexSprites, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 11) {
                     class92.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                     class92.loadingBarPercentage = 70;
                  } else {
                     FontTypeFace.modIcons = class203.field2478;
                     class134.mapedge.method5096();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;
                     class18.field306[0].method5035(var4 + var1, var4 + var2, var3 + var4);
                     class92.loadingText = "Loaded sprites";
                     class92.loadingBarPercentage = 70;
                     Client.loadingStage = 90;
                  }
               } else if(Client.loadingStage == 90) {
                  if(!SoundTask.indexTextures.method4133()) {
                     class92.loadingText = "Loading textures - " + SoundTask.indexTextures.method4209() + "%";
                     class92.loadingBarPercentage = 90;
                  } else {
                     TextureProvider var29 = new TextureProvider(SoundTask.indexTextures, CombatInfo1.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
                     Graphics3D.setTextureLoader(var29);
                     Graphics3D.setBrightness(0.8D);
                     class92.loadingText = "Loaded textures";
                     class92.loadingBarPercentage = 90;
                     Client.loadingStage = 110;
                  }
               } else if(Client.loadingStage == 110) {
                  class88.field1364 = new class71();
                  GameEngine.taskManager.createRunnable(class88.field1364, 10);
                  class92.loadingText = "Loaded input handler";
                  class92.loadingBarPercentage = 94;
                  Client.loadingStage = 120;
               } else if(Client.loadingStage == 120) {
                  if(!class221.field2806.method4135("huffman", "")) {
                     class92.loadingText = "Loading wordpack - " + 0 + "%";
                     class92.loadingBarPercentage = 96;
                  } else {
                     Huffman var22 = new Huffman(class221.field2806.method4132("huffman", ""));
                     class265.field3639 = var22;
                     class92.loadingText = "Loaded wordpack";
                     class92.loadingBarPercentage = 96;
                     Client.loadingStage = 130;
                  }
               } else if(Client.loadingStage == 130) {
                  if(!class44.field551.method4133()) {
                     class92.loadingText = "Loading interfaces - " + class44.field551.method4209() * 4 / 5 + "%";
                     class92.loadingBarPercentage = 100;
                  } else if(!Client.indexScripts.method4133()) {
                     class92.loadingText = "Loading interfaces - " + (80 + Client.indexScripts.method4209() / 6) + "%";
                     class92.loadingBarPercentage = 100;
                  } else if(!IndexFile.field2256.method4133()) {
                     class92.loadingText = "Loading interfaces - " + (96 + IndexFile.field2256.method4209() / 50) + "%";
                     class92.loadingBarPercentage = 100;
                  } else {
                     class92.loadingText = "Loaded interfaces";
                     class92.loadingBarPercentage = 98;
                     Client.loadingStage = 140;
                  }
               } else if(Client.loadingStage == 140) {
                  if(!Script.indexWorldMap.method4147(class40.field515.field510)) {
                     class92.loadingText = "Loading world map - " + Script.indexWorldMap.method4136(class40.field515.field510) / 10 + "%";
                  } else {
                     if(class7.renderOverview == null) {
                        class7.renderOverview = new RenderOverview();
                        class7.renderOverview.method5194(Script.indexWorldMap, class43.field544, Client.field948, class18.field306);
                     }

                     var0 = class7.renderOverview.method5242();
                     if(var0 < 100) {
                        class92.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                     } else {
                        class92.loadingText = "Loaded world map";
                        class92.loadingBarPercentage = 100;
                        Client.loadingStage = 150;
                     }
                  }
               } else if(Client.loadingStage == 150) {
                  class2.setGameState(10);
               }
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1325975480"
   )
   static final int method3479(int var0, int var1) {
      int var2 = class37.getSmoothNoise(var0 + '넵', var1 + 91923, 4) - 128 + (class37.getSmoothNoise(var0 + 10294, var1 + '鎽', 2) - 128 >> 1) + (class37.getSmoothNoise(var0, var1, 1) - 128 >> 2);
      var2 = (int)((double)var2 * 0.3D) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }
}
