import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
@Implements("Signlink")
public class Signlink implements Runnable {
   @ObfuscatedName("c")
   @Export("javaVendor")
   public static String javaVendor;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "[Lds;"
   )
   public static CacheFile[] field2199;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -1033912135
   )
   static int field2193;
   @ObfuscatedName("m")
   @Export("closed")
   boolean closed;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("currentTask")
   Task currentTask;
   @ObfuscatedName("g")
   @Export("sysEventQueue")
   Thread sysEventQueue;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("cachedTask")
   Task cachedTask;

   public Signlink() {
      this.currentTask = null;
      this.cachedTask = null;
      this.closed = false;
      javaVendor = "Unknown";
      Frames.javaVersion = "1.6";

      try {
         javaVendor = System.getProperty("java.vendor");
         Frames.javaVersion = System.getProperty("java.version");
      } catch (Exception var2) {
         ;
      }

      this.closed = false;
      this.sysEventQueue = new Thread(this);
      this.sysEventQueue.setPriority(10);
      this.sysEventQueue.setDaemon(true);
      this.sysEventQueue.start();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Ler;",
      garbageValue = "-1442670692"
   )
   final Task method2861(int var1, int var2, int var3, Object var4) {
      Task var5 = new Task();
      var5.type = var1;
      var5.field2190 = var2;
      var5.field2184 = var4;
      synchronized(this) {
         if(this.cachedTask != null) {
            this.cachedTask.task = var5;
            this.cachedTask = var5;
         } else {
            this.cachedTask = this.currentTask = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Ler;",
      garbageValue = "-886534263"
   )
   @Export("createURL")
   public final Task createURL(URL var1) {
      return this.method2861(4, 0, 0, var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Ler;",
      garbageValue = "334634604"
   )
   @Export("createRunnable")
   public final Task createRunnable(Runnable var1, int var2) {
      return this.method2861(2, var2, 0, var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-81"
   )
   @Export("join")
   public final void join() {
      synchronized(this) {
         this.closed = true;
         this.notifyAll();
      }

      try {
         this.sysEventQueue.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Ler;",
      garbageValue = "-122"
   )
   @Export("createSocket")
   public final Task createSocket(String var1, int var2) {
      return this.method2861(1, var2, 0, var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Ler;",
      garbageValue = "1"
   )
   @Export("createHost")
   public final Task createHost(int var1) {
      return this.method2861(3, var1, 0, (Object)null);
   }

   public final void run() {
      while(true) {
         Task var1;
         synchronized(this) {
            while(true) {
               if(this.closed) {
                  return;
               }

               if(this.currentTask != null) {
                  var1 = this.currentTask;
                  this.currentTask = this.currentTask.task;
                  if(this.currentTask == null) {
                     this.cachedTask = null;
                  }
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var8) {
                  ;
               }
            }
         }

         try {
            int var5 = var1.type;
            if(var5 == 1) {
               var1.value = new Socket(InetAddress.getByName((String)var1.field2184), var1.field2190);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2184);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2190);
               var1.value = var3;
            } else if(var5 == 4) {
               var1.value = new DataInputStream(((URL)var1.field2184).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2190 >> 24 & 255) + "." + (var1.field2190 >> 16 & 255) + "." + (var1.field2190 >> 8 & 255) + "." + (var1.field2190 & 255);
               var1.value = InetAddress.getByName(var10).getHostName();
            }

            var1.status = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.status = 2;
         }
      }
   }

   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-224575308"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         class19.region = new Region(4, 104, 104, class61.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class43.field576 = new SpritePixels(512, 512);
         class92.loadingText = "Starting game engine...";
         class92.loadingBarPercentage = 5;
         Client.loadingStage = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.loadingStage != 20) {
            if(Client.loadingStage == 30) {
               class37.indexInterfaces = ScriptState.openCacheIndex(0, false, true, true);
               class112.indexSoundEffects = ScriptState.openCacheIndex(1, false, true, true);
               Client.configsIndex = ScriptState.openCacheIndex(2, true, false, true);
               Overlay.field3568 = ScriptState.openCacheIndex(3, false, true, true);
               class25.field353 = ScriptState.openCacheIndex(4, false, true, true);
               ISAACCipher.indexMaps = ScriptState.openCacheIndex(5, true, true, true);
               class8.indexTrack1 = ScriptState.openCacheIndex(6, true, true, false);
               class1.indexModels = ScriptState.openCacheIndex(7, false, true, true);
               class271.indexSprites = ScriptState.openCacheIndex(8, false, true, true);
               WorldMapType3.indexTextures = ScriptState.openCacheIndex(9, false, true, true);
               class27.field387 = ScriptState.openCacheIndex(10, false, true, true);
               class222.indexTrack2 = ScriptState.openCacheIndex(11, false, true, true);
               class13.indexScripts = ScriptState.openCacheIndex(12, false, true, true);
               class60.field744 = ScriptState.openCacheIndex(13, true, false, true);
               ChatLineBuffer.vorbisIndex = ScriptState.openCacheIndex(14, false, true, false);
               class92.field1431 = ScriptState.openCacheIndex(15, false, true, true);
               Item.indexWorldMap = ScriptState.openCacheIndex(16, false, true, false);
               class92.loadingText = "Connecting to update server";
               class92.loadingBarPercentage = 20;
               Client.loadingStage = 40;
            } else if(Client.loadingStage == 40) {
               byte var26 = 0;
               var0 = var26 + class37.indexInterfaces.percentage() * 4 / 100;
               var0 += class112.indexSoundEffects.percentage() * 4 / 100;
               var0 += Client.configsIndex.percentage() * 2 / 100;
               var0 += Overlay.field3568.percentage() * 2 / 100;
               var0 += class25.field353.percentage() * 6 / 100;
               var0 += ISAACCipher.indexMaps.percentage() * 4 / 100;
               var0 += class8.indexTrack1.percentage() * 2 / 100;
               var0 += class1.indexModels.percentage() * 58 / 100;
               var0 += class271.indexSprites.percentage() * 2 / 100;
               var0 += WorldMapType3.indexTextures.percentage() * 2 / 100;
               var0 += class27.field387.percentage() * 2 / 100;
               var0 += class222.indexTrack2.percentage() * 2 / 100;
               var0 += class13.indexScripts.percentage() * 2 / 100;
               var0 += class60.field744.percentage() * 2 / 100;
               var0 += ChatLineBuffer.vorbisIndex.percentage() * 2 / 100;
               var0 += class92.field1431.percentage() * 2 / 100;
               var0 += Item.indexWorldMap.percentage() * 2 / 100;
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
            } else if(Client.loadingStage == 45) {
               boolean var25 = !Client.lowMemory;
               CombatInfo1.sampleRate = 22050;
               class8.highMemory = var25;
               class261.priority = 2;
               class204 var31 = new class204();
               var31.method3650(9, 128);
               VertexNormal.soundSystem0 = Projectile.method1704(GameEngine.taskManager, 0, 22050);
               VertexNormal.soundSystem0.method1940(var31);
               class168.method3056(class92.field1431, ChatLineBuffer.vorbisIndex, class25.field353, var31);
               MessageNode.soundSystem1 = Projectile.method1704(GameEngine.taskManager, 1, 2048);
               class1.field4 = new class102();
               MessageNode.soundSystem1.method1940(class1.field4);
               class9.field237 = new class116(22050, CombatInfo1.sampleRate);
               class92.loadingText = "Prepared sound engine";
               class92.loadingBarPercentage = 35;
               Client.loadingStage = 50;
               class47.field602 = new class262(class271.indexSprites, class60.field744);
            } else if(Client.loadingStage == 50) {
               var0 = class261.method4616().length;
               Client.field1002 = class47.field602.method4620(class261.method4616());
               if(Client.field1002.size() < var0) {
                  class92.loadingText = "Loading fonts - " + Client.field1002.size() * 100 / var0 + "%";
                  class92.loadingBarPercentage = 40;
               } else {
                  class15.field293 = (Font)Client.field1002.get(class261.field3608);
                  class112.font_p12full = (Font)Client.field1002.get(class261.field3600);
                  Area.field3285 = (Font)Client.field1002.get(class261.field3601);
                  class214.field2600 = new MachineInfo(true);
                  class92.loadingText = "Loaded fonts";
                  class92.loadingBarPercentage = 40;
                  Client.loadingStage = 60;
               }
            } else if(Client.loadingStage == 60) {
               var0 = CombatInfo1.method1503(class27.field387, class271.indexSprites);
               var1 = Buffer.method3304();
               if(var0 < var1) {
                  class92.loadingText = "Loading title screen - " + var0 * 100 / var1 + "%";
                  class92.loadingBarPercentage = 50;
               } else {
                  class92.loadingText = "Loaded title screen";
                  class92.loadingBarPercentage = 50;
                  class152.setGameState(5);
                  Client.loadingStage = 70;
               }
            } else {
               IndexData var22;
               if(Client.loadingStage == 70) {
                  if(!Client.configsIndex.method4012()) {
                     class92.loadingText = "Loading config - " + Client.configsIndex.method4126() + "%";
                     class92.loadingBarPercentage = 60;
                  } else {
                     IndexData var29 = Client.configsIndex;
                     Overlay.overlay_ref = var29;
                     IndexData var30 = Client.configsIndex;
                     FloorUnderlayDefinition.underlay_ref = var30;
                     var22 = Client.configsIndex;
                     IndexData var23 = class1.indexModels;
                     KitDefinition.identKit_ref = var22;
                     KitDefinition.field3328 = var23;
                     KitDefinition.field3323 = KitDefinition.identKit_ref.fileCount(3);
                     IndexData var24 = Client.configsIndex;
                     IndexData var5 = class1.indexModels;
                     boolean var6 = Client.lowMemory;
                     ObjectComposition.objects_ref = var24;
                     class37.field511 = var5;
                     ObjectComposition.field3428 = var6;
                     KeyFocusListener.method738(Client.configsIndex, class1.indexModels);
                     IndexData var7 = Client.configsIndex;
                     class252.field3370 = var7;
                     IndexData var8 = Client.configsIndex;
                     IndexData var9 = class1.indexModels;
                     boolean var10 = Client.isMembers;
                     Font var11 = class15.field293;
                     InvType.item_ref = var8;
                     ItemComposition.field3466 = var9;
                     IndexFile.isMembersWorld = var10;
                     ItemComposition.field3467 = InvType.item_ref.fileCount(10);
                     WorldMapType2.field523 = var11;
                     WorldListFetcher.method1471(Client.configsIndex, class37.indexInterfaces, class112.indexSoundEffects);
                     IndexData var12 = Client.configsIndex;
                     IndexData var13 = class1.indexModels;
                     Spotanim.field3297 = var12;
                     Spotanim.field3298 = var13;
                     class202.method3623(Client.configsIndex);
                     IndexData var14 = Client.configsIndex;
                     VarPlayerType.varplayer_ref = var14;
                     class215.field2605 = VarPlayerType.varplayer_ref.fileCount(16);
                     class56.method778(Overlay.field3568, class1.indexModels, class271.indexSprites, class60.field744);
                     IndexData var15 = Client.configsIndex;
                     class5.field30 = var15;
                     class205.method3760(Client.configsIndex);
                     IndexData var16 = Client.configsIndex;
                     class243.field3286 = var16;
                     IndexData var17 = Client.configsIndex;
                     class244.field3293 = var17;
                     Renderable.method2801(Client.configsIndex);
                     Varcs.chatMessages = new Varcs();
                     class21.method152(Client.configsIndex, class271.indexSprites, class60.field744);
                     IndexData var18 = Client.configsIndex;
                     IndexData var19 = class271.indexSprites;
                     CombatInfo2.field3336 = var18;
                     CombatInfo2.field3342 = var19;
                     class175.method3313(Client.configsIndex, class271.indexSprites);
                     class92.loadingText = "Loaded config";
                     class92.loadingBarPercentage = 60;
                     Client.loadingStage = 80;
                  }
               } else if(Client.loadingStage == 80) {
                  var0 = 0;
                  SpritePixels var21;
                  if(Player.compass == null) {
                     var22 = class271.indexSprites;
                     var3 = var22.getFile("compass");
                     var4 = var22.getChild(var3, "");
                     var21 = NPCComposition.method4549(var22, var3, var4);
                     Player.compass = var21;
                  } else {
                     ++var0;
                  }

                  if(class9.mapedge == null) {
                     var22 = class271.indexSprites;
                     var3 = var22.getFile("mapedge");
                     var4 = var22.getChild(var3, "");
                     var21 = NPCComposition.method4549(var22, var3, var4);
                     class9.mapedge = var21;
                  } else {
                     ++var0;
                  }

                  if(DynamicObject.field1519 == null) {
                     DynamicObject.field1519 = class269.method4758(class271.indexSprites, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(GZipDecompressor.mapfunctions == null) {
                     GZipDecompressor.mapfunctions = class269.method4759(class271.indexSprites, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(class181.hitmarks == null) {
                     class181.hitmarks = class269.method4759(class271.indexSprites, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(class92.pkIcons == null) {
                     class92.pkIcons = class269.method4759(class271.indexSprites, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(class27.field388 == null) {
                     class27.field388 = class269.method4759(class271.indexSprites, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(class82.field1319 == null) {
                     class82.field1319 = class269.method4759(class271.indexSprites, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(WorldMapType3.mapDots == null) {
                     WorldMapType3.mapDots = class269.method4759(class271.indexSprites, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(FileRequest.field3179 == null) {
                     FileRequest.field3179 = class269.method4758(class271.indexSprites, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(class220.field2776 == null) {
                     class220.field2776 = class269.method4758(class271.indexSprites, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 11) {
                     class92.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                     class92.loadingBarPercentage = 70;
                  } else {
                     FontTypeFace.modIcons = class220.field2776;
                     class9.mapedge.method4961();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;
                     DynamicObject.field1519[0].method4924(var4 + var1, var2 + var4, var4 + var3);
                     class92.loadingText = "Loaded sprites";
                     class92.loadingBarPercentage = 70;
                     Client.loadingStage = 90;
                  }
               } else if(Client.loadingStage == 90) {
                  if(!WorldMapType3.indexTextures.method4012()) {
                     class92.loadingText = "Loading textures - " + WorldMapType3.indexTextures.method4126() + "%";
                     class92.loadingBarPercentage = 90;
                  } else {
                     TextureProvider var28 = new TextureProvider(WorldMapType3.indexTextures, class271.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
                     Graphics3D.setTextureLoader(var28);
                     Graphics3D.setBrightness(0.8D);
                     class92.loadingText = "Loaded textures";
                     class92.loadingBarPercentage = 90;
                     Client.loadingStage = 110;
                  }
               } else if(Client.loadingStage == 110) {
                  Client.field1038 = new class71();
                  GameEngine.taskManager.createRunnable(Client.field1038, 10);
                  class92.loadingText = "Loaded input handler";
                  class92.loadingBarPercentage = 94;
                  Client.loadingStage = 120;
               } else if(Client.loadingStage == 120) {
                  if(!class27.field387.method4028("huffman", "")) {
                     class92.loadingText = "Loading wordpack - " + 0 + "%";
                     class92.loadingBarPercentage = 96;
                  } else {
                     Huffman var27 = new Huffman(class27.field387.method4027("huffman", ""));
                     class265.field3642 = var27;
                     class92.loadingText = "Loaded wordpack";
                     class92.loadingBarPercentage = 96;
                     Client.loadingStage = 130;
                  }
               } else if(Client.loadingStage == 130) {
                  if(!Overlay.field3568.method4012()) {
                     class92.loadingText = "Loading interfaces - " + Overlay.field3568.method4126() * 4 / 5 + "%";
                     class92.loadingBarPercentage = 100;
                  } else if(!class13.indexScripts.method4012()) {
                     class92.loadingText = "Loading interfaces - " + (80 + class13.indexScripts.method4126() / 6) + "%";
                     class92.loadingBarPercentage = 100;
                  } else if(!class60.field744.method4012()) {
                     class92.loadingText = "Loading interfaces - " + (96 + class60.field744.method4126() / 50) + "%";
                     class92.loadingBarPercentage = 100;
                  } else {
                     class92.loadingText = "Loaded interfaces";
                     class92.loadingBarPercentage = 98;
                     Client.loadingStage = 140;
                  }
               } else if(Client.loadingStage == 140) {
                  if(!Item.indexWorldMap.method4029(class40.field540.field549)) {
                     class92.loadingText = "Loading world map - " + Item.indexWorldMap.method4031(class40.field540.field549) / 10 + "%";
                  } else {
                     if(Client.renderOverview == null) {
                        Client.renderOverview = new RenderOverview();
                        Client.renderOverview.method5088(Item.indexWorldMap, Area.field3285, Client.field1002, DynamicObject.field1519);
                     }

                     var0 = Client.renderOverview.method5089();
                     if(var0 < 100) {
                        class92.loadingText = "Loading world map - " + (9 * var0 / 10 + 10) + "%";
                     } else {
                        class92.loadingText = "Loaded world map";
                        class92.loadingBarPercentage = 100;
                        Client.loadingStage = 150;
                     }
                  }
               } else if(Client.loadingStage == 150) {
                  class152.setGameState(10);
               }
            }
         } else {
            int[] var20 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 128 + 15;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var20[var1] = var3 * var4 >> 16;
            }

            Region.method2633(var20, 500, 800, 512, 334);
            class92.loadingText = "Prepared visibility map";
            class92.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lbo;I)V",
      garbageValue = "1781173260"
   )
   static void method2887(GameEngine var0) {
      int var1;
      int var10;
      int var11;
      int var13;
      if(class92.worldSelectShown) {
         if(MouseInput.field729 == 1 || !GameEngine.field699 && MouseInput.field729 == 4) {
            var1 = class92.field1417 + 280;
            if(MouseInput.field737 >= var1 && MouseInput.field737 <= var1 + 14 && MouseInput.field723 >= 4 && MouseInput.field723 <= 18) {
               MouseInput.method968(0, 0);
            } else if(MouseInput.field737 >= var1 + 15 && MouseInput.field737 <= var1 + 80 && MouseInput.field723 >= 4 && MouseInput.field723 <= 18) {
               MouseInput.method968(0, 1);
            } else {
               var10 = class92.field1417 + 390;
               if(MouseInput.field737 >= var10 && MouseInput.field737 <= var10 + 14 && MouseInput.field723 >= 4 && MouseInput.field723 <= 18) {
                  MouseInput.method968(1, 0);
               } else if(MouseInput.field737 >= var10 + 15 && MouseInput.field737 <= var10 + 80 && MouseInput.field723 >= 4 && MouseInput.field723 <= 18) {
                  MouseInput.method968(1, 1);
               } else {
                  var11 = class92.field1417 + 500;
                  if(MouseInput.field737 >= var11 && MouseInput.field737 <= var11 + 14 && MouseInput.field723 >= 4 && MouseInput.field723 <= 18) {
                     MouseInput.method968(2, 0);
                  } else if(MouseInput.field737 >= var11 + 15 && MouseInput.field737 <= var11 + 80 && MouseInput.field723 >= 4 && MouseInput.field723 <= 18) {
                     MouseInput.method968(2, 1);
                  } else {
                     var13 = class92.field1417 + 610;
                     if(MouseInput.field737 >= var13 && MouseInput.field737 <= var13 + 14 && MouseInput.field723 >= 4 && MouseInput.field723 <= 18) {
                        MouseInput.method968(3, 0);
                     } else if(MouseInput.field737 >= var13 + 15 && MouseInput.field737 <= var13 + 80 && MouseInput.field723 >= 4 && MouseInput.field723 <= 18) {
                        MouseInput.method968(3, 1);
                     } else if(MouseInput.field737 >= class92.field1417 + 708 && MouseInput.field723 >= 4 && MouseInput.field737 <= class92.field1417 + 708 + 50 && MouseInput.field723 <= 20) {
                        class92.worldSelectShown = false;
                        class92.field1394.method4956(class92.field1417, 0);
                        class92.field1399.method4956(class92.field1417 + 382, 0);
                        class92.logoSprite.method4941(class92.field1417 + 382 - class92.logoSprite.originalWidth / 2, 18);
                     } else if(class92.field1426 != -1) {
                        World var5 = class64.worldList[class92.field1426];
                        IndexDataBase.method4052(var5);
                        class92.worldSelectShown = false;
                        class92.field1394.method4956(class92.field1417, 0);
                        class92.field1399.method4956(class92.field1417 + 382, 0);
                        class92.logoSprite.method4941(class92.field1417 + 382 - class92.logoSprite.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((MouseInput.field729 == 1 || !GameEngine.field699 && MouseInput.field729 == 4) && MouseInput.field737 >= class92.field1417 + 765 - 50 && MouseInput.field723 >= 453) {
            class34.preferences.muted = !class34.preferences.muted;
            class10.method51();
            if(!class34.preferences.muted) {
               GraphicsObject.method1617(class8.indexTrack1, "scape main", "", 255, false);
            } else {
               Client.method1459();
            }
         }

         if(Client.gameState != 5) {
            ++class92.field1412;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.languageId == 0) {
                  if(MouseInput.field729 == 1 || !GameEngine.field699 && MouseInput.field729 == 4) {
                     var1 = class92.field1417 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(MouseInput.field737 >= var1 && MouseInput.field737 <= var3 + var1 && MouseInput.field723 >= var2 && MouseInput.field723 <= var4 + var2) {
                        FileRequest.method4004();
                        return;
                     }
                  }

                  if(class265.listFetcher != null) {
                     FileRequest.method4004();
                  }
               }

               var1 = MouseInput.field729;
               var10 = MouseInput.field737;
               var11 = MouseInput.field723;
               if(!GameEngine.field699 && var1 == 4) {
                  var1 = 1;
               }

               short var6;
               int var9;
               if(class92.loginIndex == 0) {
                  boolean var12 = false;

                  while(class36.method486()) {
                     if(class219.field2771 == 84) {
                        var12 = true;
                     }
                  }

                  var9 = class92.loginWindowX + 180 - 80;
                  var6 = 291;
                  if(var1 == 1 && var10 >= var9 - 75 && var10 <= var9 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                     class37.method488(WorldMapData.method347("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var9 = class92.loginWindowX + 180 + 80;
                  if(var1 == 1 && var10 >= var9 - 75 && var10 <= var9 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20 || var12) {
                     if((Client.flags & 33554432) != 0) {
                        class92.field1419 = "";
                        class92.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class92.loginMessage2 = "Your normal account will not be affected.";
                        class92.loginMessage3 = "";
                        class92.loginIndex = 1;
                        class92.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class92.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class92.loginMessage2 = "Players can attack each other almost everywhere";
                           class92.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class92.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class92.loginMessage2 = "Players can attack each other";
                           class92.loginMessage3 = "almost everywhere.";
                        }

                        class92.field1419 = "Warning!";
                        class92.loginIndex = 1;
                        class92.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class92.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class92.loginMessage2 = "The Protect Item prayer will";
                        class92.loginMessage3 = "not work on this world.";
                        class92.field1419 = "Warning!";
                        class92.loginIndex = 1;
                        class92.loginIndex2 = 0;
                     } else {
                        class92.loginMessage1 = "";
                        class92.loginMessage2 = "Enter your username/email & password.";
                        class92.loginMessage3 = "";
                        class92.loginIndex = 2;
                        class92.loginIndex2 = 0;
                     }
                  }
               } else {
                  short var17;
                  if(class92.loginIndex != 1) {
                     short var14;
                     if(class92.loginIndex == 2) {
                        var14 = 231;
                        var13 = var14 + 30;
                        if(var1 == 1 && var11 >= var13 - 15 && var11 < var13) {
                           class92.loginIndex2 = 0;
                        }

                        var13 += 15;
                        if(var1 == 1 && var11 >= var13 - 15 && var11 < var13) {
                           class92.loginIndex2 = 1;
                        }

                        var13 += 15;
                        var14 = 361;
                        if(var1 == 1 && var11 >= var14 - 15 && var11 < var14) {
                           class22.method165("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class92.loginIndex = 5;
                           return;
                        }

                        var9 = class92.loginWindowX + 180 - 80;
                        var6 = 321;
                        if(var1 == 1 && var10 >= var9 - 75 && var10 <= var9 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                           class92.username = class92.username.trim();
                           if(class92.username.length() == 0) {
                              class22.method165("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class92.password.length() == 0) {
                              class22.method165("", "Please enter your password.", "");
                              return;
                           }

                           class22.method165("", "Connecting to server...", "");
                           class92.field1422 = class34.preferences.preferences.containsKey(Integer.valueOf(class244.method4222(class92.username)))?class149.field2157:class149.field2161;
                           class152.setGameState(20);
                           return;
                        }

                        var9 = 180 + class92.loginWindowX + 80;
                        if(var1 == 1 && var10 >= var9 - 75 && var10 <= var9 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                           class92.loginIndex = 0;
                           class92.username = "";
                           class92.password = "";
                           Ignore.authCodeForLogin = 0;
                           Occluder.authCode = "";
                           class92.field1424 = true;
                        }

                        while(true) {
                           while(class36.method486()) {
                              boolean var7 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(class227.field3118 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var7 = true;
                                    break;
                                 }
                              }

                              if(class219.field2771 == 13) {
                                 class92.loginIndex = 0;
                                 class92.username = "";
                                 class92.password = "";
                                 Ignore.authCodeForLogin = 0;
                                 Occluder.authCode = "";
                                 class92.field1424 = true;
                              } else if(class92.loginIndex2 == 0) {
                                 if(class219.field2771 == 85 && class92.username.length() > 0) {
                                    class92.username = class92.username.substring(0, class92.username.length() - 1);
                                 }

                                 if(class219.field2771 == 84 || class219.field2771 == 80) {
                                    class92.loginIndex2 = 1;
                                 }

                                 if(var7 && class92.username.length() < 320) {
                                    class92.username = class92.username + class227.field3118;
                                 }
                              } else if(class92.loginIndex2 == 1) {
                                 if(class219.field2771 == 85 && class92.password.length() > 0) {
                                    class92.password = class92.password.substring(0, class92.password.length() - 1);
                                 }

                                 if(class219.field2771 == 84 || class219.field2771 == 80) {
                                    class92.loginIndex2 = 0;
                                 }

                                 if(class219.field2771 == 84) {
                                    class92.username = class92.username.trim();
                                    if(class92.username.length() == 0) {
                                       class22.method165("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class92.password.length() == 0) {
                                       class22.method165("", "Please enter your password.", "");
                                       return;
                                    }

                                    class22.method165("", "Connecting to server...", "");
                                    class92.field1422 = class34.preferences.preferences.containsKey(Integer.valueOf(class244.method4222(class92.username)))?class149.field2157:class149.field2161;
                                    class152.setGameState(20);
                                    return;
                                 }

                                 if(var7 && class92.password.length() < 20) {
                                    class92.password = class92.password + class227.field3118;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class92.loginIndex == 3) {
                        var13 = class92.loginWindowX + 180;
                        var17 = 276;
                        if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                           class92.loginMessage1 = "";
                           class92.loginMessage2 = "Enter your username/email & password.";
                           class92.loginMessage3 = "";
                           class92.loginIndex = 2;
                           class92.loginIndex2 = 0;
                        }

                        var13 = class92.loginWindowX + 180;
                        var17 = 326;
                        if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                           class22.method165("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class92.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var15;
                        int var16;
                        if(class92.loginIndex == 4) {
                           var13 = class92.loginWindowX + 180 - 80;
                           var17 = 321;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                              Occluder.authCode.trim();
                              if(Occluder.authCode.length() != 6) {
                                 class22.method165("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              Ignore.authCodeForLogin = Integer.parseInt(Occluder.authCode);
                              Occluder.authCode = "";
                              class92.field1422 = class92.field1424?class149.field2158:class149.field2160;
                              class22.method165("", "Connecting to server...", "");
                              class152.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var10 >= class92.loginWindowX + 180 - 9 && var10 <= class92.loginWindowX + 180 + 130 && var11 >= 263 && var11 <= 296) {
                              class92.field1424 = !class92.field1424;
                           }

                           if(var1 == 1 && var10 >= class92.loginWindowX + 180 - 34 && var10 <= 180 + class92.loginWindowX + 34 && var11 >= 351 && var11 <= 363) {
                              class37.method488(WorldMapData.method347("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var13 = 180 + class92.loginWindowX + 80;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                              class92.loginIndex = 0;
                              class92.username = "";
                              class92.password = "";
                              Ignore.authCodeForLogin = 0;
                              Occluder.authCode = "";
                           }

                           while(class36.method486()) {
                              var15 = false;

                              for(var16 = 0; var16 < "1234567890".length(); ++var16) {
                                 if(class227.field3118 == "1234567890".charAt(var16)) {
                                    var15 = true;
                                    break;
                                 }
                              }

                              if(class219.field2771 == 13) {
                                 class92.loginIndex = 0;
                                 class92.username = "";
                                 class92.password = "";
                                 Ignore.authCodeForLogin = 0;
                                 Occluder.authCode = "";
                              } else {
                                 if(class219.field2771 == 85 && Occluder.authCode.length() > 0) {
                                    Occluder.authCode = Occluder.authCode.substring(0, Occluder.authCode.length() - 1);
                                 }

                                 if(class219.field2771 == 84) {
                                    Occluder.authCode.trim();
                                    if(Occluder.authCode.length() != 6) {
                                       class22.method165("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    Ignore.authCodeForLogin = Integer.parseInt(Occluder.authCode);
                                    Occluder.authCode = "";
                                    class92.field1422 = class92.field1424?class149.field2158:class149.field2160;
                                    class22.method165("", "Connecting to server...", "");
                                    class152.setGameState(20);
                                    return;
                                 }

                                 if(var15 && Occluder.authCode.length() < 6) {
                                    Occluder.authCode = Occluder.authCode + class227.field3118;
                                 }
                              }
                           }
                        } else if(class92.loginIndex == 5) {
                           var13 = class92.loginWindowX + 180 - 80;
                           var17 = 321;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                              ISAACCipher.method3380();
                              return;
                           }

                           var13 = class92.loginWindowX + 180 + 80;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                              class92.loginMessage1 = "";
                              class92.loginMessage2 = "Enter your username/email & password.";
                              class92.loginMessage3 = "";
                              class92.loginIndex = 2;
                              class92.loginIndex2 = 0;
                              class92.password = "";
                           }

                           while(class36.method486()) {
                              var15 = false;

                              for(var16 = 0; var16 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var16) {
                                 if(class227.field3118 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var16)) {
                                    var15 = true;
                                    break;
                                 }
                              }

                              if(class219.field2771 == 13) {
                                 class92.loginMessage1 = "";
                                 class92.loginMessage2 = "Enter your username/email & password.";
                                 class92.loginMessage3 = "";
                                 class92.loginIndex = 2;
                                 class92.loginIndex2 = 0;
                                 class92.password = "";
                              } else {
                                 if(class219.field2771 == 85 && class92.username.length() > 0) {
                                    class92.username = class92.username.substring(0, class92.username.length() - 1);
                                 }

                                 if(class219.field2771 == 84) {
                                    ISAACCipher.method3380();
                                    return;
                                 }

                                 if(var15 && class92.username.length() < 320) {
                                    class92.username = class92.username + class227.field3118;
                                 }
                              }
                           }
                        } else if(class92.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class36.method486()) {
                                    var14 = 321;
                                    if(var1 == 1 && var11 >= var14 - 20 && var11 <= var14 + 20) {
                                       class92.loginMessage1 = "";
                                       class92.loginMessage2 = "Enter your username/email & password.";
                                       class92.loginMessage3 = "";
                                       class92.loginIndex = 2;
                                       class92.loginIndex2 = 0;
                                       class92.password = "";
                                    }

                                    return;
                                 }
                              } while(class219.field2771 != 84 && class219.field2771 != 13);

                              class92.loginMessage1 = "";
                              class92.loginMessage2 = "Enter your username/email & password.";
                              class92.loginMessage3 = "";
                              class92.loginIndex = 2;
                              class92.loginIndex2 = 0;
                              class92.password = "";
                           }
                        }
                     }
                  } else {
                     while(class36.method486()) {
                        if(class219.field2771 == 84) {
                           class92.loginMessage1 = "";
                           class92.loginMessage2 = "Enter your username/email & password.";
                           class92.loginMessage3 = "";
                           class92.loginIndex = 2;
                           class92.loginIndex2 = 0;
                        } else if(class219.field2771 == 13) {
                           class92.loginIndex = 0;
                        }
                     }

                     var13 = class92.loginWindowX + 180 - 80;
                     var17 = 321;
                     if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                        class92.loginMessage1 = "";
                        class92.loginMessage2 = "Enter your username/email & password.";
                        class92.loginMessage3 = "";
                        class92.loginIndex = 2;
                        class92.loginIndex2 = 0;
                     }

                     var13 = class92.loginWindowX + 180 + 80;
                     if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                        class92.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "834729559"
   )
   static final void method2882() {
      short var0 = 256;
      int var1;
      if(class92.field1395 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class92.field1395 > 768) {
               class67.field816[var1] = class61.method1020(class31.field431[var1], class92.field1405[var1], 1024 - class92.field1395);
            } else if(class92.field1395 > 256) {
               class67.field816[var1] = class92.field1405[var1];
            } else {
               class67.field816[var1] = class61.method1020(class92.field1405[var1], class31.field431[var1], 256 - class92.field1395);
            }
         }
      } else if(class92.field1407 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class92.field1407 > 768) {
               class67.field816[var1] = class61.method1020(class31.field431[var1], VertexNormal.field1970[var1], 1024 - class92.field1407);
            } else if(class92.field1407 > 256) {
               class67.field816[var1] = VertexNormal.field1970[var1];
            } else {
               class67.field816[var1] = class61.method1020(VertexNormal.field1970[var1], class31.field431[var1], 256 - class92.field1407);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class67.field816[var1] = class31.field431[var1];
         }
      }

      Rasterizer2D.setDrawRegion(class92.field1417, 9, class92.field1417 + 128, var0 + 7);
      class92.field1394.method4956(class92.field1417, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      int var2 = WorldMapType1.field417.width * 9 + class92.field1417;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class92.field1423[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class24.field348[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class67.field816[var7];
               var10 = WorldMapType1.field417.pixels[var2];
               WorldMapType1.field417.pixels[var2++] = (var9 * (var10 & '\uff00') + var8 * (var7 & '\uff00') & 16711680) + ((var10 & 16711935) * var9 + var8 * (var7 & 16711935) & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + WorldMapType1.field417.width - 128;
      }

      Rasterizer2D.setDrawRegion(class92.field1417 + 765 - 128, 9, class92.field1417 + 765, var0 + 7);
      class92.field1399.method4956(class92.field1417 + 382, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      var2 = 24 + WorldMapType1.field417.width * 9 + 637 + class92.field1417;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class92.field1423[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class24.field348[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class67.field816[var7];
               var10 = WorldMapType1.field417.pixels[var2];
               WorldMapType1.field417.pixels[var2++] = (var9 * (var10 & 16711935) + var8 * (var7 & 16711935) & -16711936) + (var9 * (var10 & '\uff00') + var8 * (var7 & '\uff00') & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += WorldMapType1.field417.width - var5 - var4;
      }

   }
}
