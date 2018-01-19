import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class46 {
   @ObfuscatedName("i")
   static String[] field570;
   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("indexCache3")
   static IndexData indexCache3;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1178674609
   )
   int field569;
   @ObfuscatedName("v")
   byte[][][] field568;

   class46(int var1) {
      this.field569 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-831469135"
   )
   void method657(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field569 != 0 && this.field568 != null) {
         var8 = this.method658(var8, var7);
         var7 = this.method659(var7);
         Rasterizer2D.method5189(var1, var2, var5, var6, var3, var4, this.field568[var7 - 1][var8], this.field569);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "940612500"
   )
   int method658(int var1, int var2) {
      if(var2 == 9) {
         var1 = var1 + 1 & 3;
      }

      if(var2 == 10) {
         var1 = var1 + 3 & 3;
      }

      if(var2 == 11) {
         var1 = var1 + 3 & 3;
      }

      return var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "7"
   )
   int method659(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1992962005"
   )
   void method662() {
      if(this.field568 == null) {
         this.field568 = new byte[8][4][];
         this.method661();
         this.method675();
         this.method663();
         this.method664();
         this.method671();
         this.method666();
         this.method665();
         this.method668();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method661() {
      byte[] var1 = new byte[this.field569 * this.field569];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field569; ++var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[0][0] = var1;
      var1 = new byte[this.field569 * this.field569];
      var2 = 0;

      for(var3 = this.field569 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[0][1] = var1;
      var1 = new byte[this.field569 * this.field569];
      var2 = 0;

      for(var3 = 0; var3 < this.field569; ++var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[0][2] = var1;
      var1 = new byte[this.field569 * this.field569];
      var2 = 0;

      for(var3 = this.field569 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[0][3] = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1207027874"
   )
   void method675() {
      byte[] var1 = new byte[this.field569 * this.field569];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field569 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[1][0] = var1;
      var1 = new byte[this.field569 * this.field569];
      var2 = 0;

      for(var3 = 0; var3 < this.field569; ++var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var2 >= 0 && var2 < var1.length) {
               if(var4 >= var3 << 1) {
                  var1[var2] = -1;
               }

               ++var2;
            } else {
               ++var2;
            }
         }
      }

      this.field568[1][1] = var1;
      var1 = new byte[this.field569 * this.field569];
      var2 = 0;

      for(var3 = 0; var3 < this.field569; ++var3) {
         for(var4 = this.field569 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[1][2] = var1;
      var1 = new byte[this.field569 * this.field569];
      var2 = 0;

      for(var3 = this.field569 - 1; var3 >= 0; --var3) {
         for(var4 = this.field569 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[1][3] = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "702938504"
   )
   void method663() {
      byte[] var1 = new byte[this.field569 * this.field569];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field569 - 1; var3 >= 0; --var3) {
         for(var4 = this.field569 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[2][0] = var1;
      var1 = new byte[this.field569 * this.field569];
      var2 = 0;

      for(var3 = this.field569 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[2][1] = var1;
      var1 = new byte[this.field569 * this.field569];
      var2 = 0;

      for(var3 = 0; var3 < this.field569; ++var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[2][2] = var1;
      var1 = new byte[this.field569 * this.field569];
      var2 = 0;

      for(var3 = 0; var3 < this.field569; ++var3) {
         for(var4 = this.field569 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[2][3] = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-616606089"
   )
   void method664() {
      byte[] var1 = new byte[this.field569 * this.field569];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field569 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[3][0] = var1;
      var1 = new byte[this.field569 * this.field569];
      var2 = 0;

      for(var3 = 0; var3 < this.field569; ++var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[3][1] = var1;
      var1 = new byte[this.field569 * this.field569];
      var2 = 0;

      for(var3 = 0; var3 < this.field569; ++var3) {
         for(var4 = this.field569 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[3][2] = var1;
      var1 = new byte[this.field569 * this.field569];
      var2 = 0;

      for(var3 = this.field569 - 1; var3 >= 0; --var3) {
         for(var4 = this.field569 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[3][3] = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "11"
   )
   void method671() {
      byte[] var1 = new byte[this.field569 * this.field569];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field569 - 1; var3 >= 0; --var3) {
         for(var4 = this.field569 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[4][0] = var1;
      var1 = new byte[this.field569 * this.field569];
      var2 = 0;

      for(var3 = this.field569 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[4][1] = var1;
      var1 = new byte[this.field569 * this.field569];
      var2 = 0;

      for(var3 = 0; var3 < this.field569; ++var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[4][2] = var1;
      var1 = new byte[this.field569 * this.field569];
      var2 = 0;

      for(var3 = 0; var3 < this.field569; ++var3) {
         for(var4 = this.field569 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[4][3] = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   void method666() {
      byte[] var1 = new byte[this.field569 * this.field569];
      boolean var2 = false;
      var1 = new byte[this.field569 * this.field569];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field569; ++var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var4 <= this.field569 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[5][0] = var1;
      var1 = new byte[this.field569 * this.field569];
      var5 = 0;

      for(var3 = 0; var3 < this.field569; ++var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var3 <= this.field569 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[5][1] = var1;
      var1 = new byte[this.field569 * this.field569];
      var5 = 0;

      for(var3 = 0; var3 < this.field569; ++var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var4 >= this.field569 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[5][2] = var1;
      var1 = new byte[this.field569 * this.field569];
      var5 = 0;

      for(var3 = 0; var3 < this.field569; ++var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var3 >= this.field569 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[5][3] = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "569726619"
   )
   void method665() {
      byte[] var1 = new byte[this.field569 * this.field569];
      boolean var2 = false;
      var1 = new byte[this.field569 * this.field569];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field569; ++var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var4 <= var3 - this.field569 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[6][0] = var1;
      var1 = new byte[this.field569 * this.field569];
      var5 = 0;

      for(var3 = this.field569 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var4 <= var3 - this.field569 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[6][1] = var1;
      var1 = new byte[this.field569 * this.field569];
      var5 = 0;

      for(var3 = this.field569 - 1; var3 >= 0; --var3) {
         for(var4 = this.field569 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field569 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[6][2] = var1;
      var1 = new byte[this.field569 * this.field569];
      var5 = 0;

      for(var3 = 0; var3 < this.field569; ++var3) {
         for(var4 = this.field569 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field569 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[6][3] = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1975659428"
   )
   void method668() {
      byte[] var1 = new byte[this.field569 * this.field569];
      boolean var2 = false;
      var1 = new byte[this.field569 * this.field569];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field569; ++var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var4 >= var3 - this.field569 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[7][0] = var1;
      var1 = new byte[this.field569 * this.field569];
      var5 = 0;

      for(var3 = this.field569 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field569; ++var4) {
            if(var4 >= var3 - this.field569 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[7][1] = var1;
      var1 = new byte[this.field569 * this.field569];
      var5 = 0;

      for(var3 = this.field569 - 1; var3 >= 0; --var3) {
         for(var4 = this.field569 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field569 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[7][2] = var1;
      var1 = new byte[this.field569 * this.field569];
      var5 = 0;

      for(var3 = 0; var3 < this.field569; ++var3) {
         for(var4 = this.field569 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field569 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[7][3] = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lil;II)Lhm;",
      garbageValue = "-352308539"
   )
   static class218 method690(IndexDataBase var0, int var1) {
      byte[] var2 = var0.takeRecordFlat(var1);
      return var2 == null?null:new class218(var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-95"
   )
   public static void method691() {
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1184058701"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         class45.region = new Region(4, 104, 104, class61.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class234.minimapSprite = new SpritePixels(512, 512);
         class91.loadingText = "Starting game engine...";
         class91.loadingBarPercentage = 5;
         Client.loadingStage = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.loadingStage == 20) {
            int[] var34 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 15 + 128;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var34[var1] = var3 * var4 >> 16;
            }

            Region.method2781(var34, 500, 800, 512, 334);
            class91.loadingText = "Prepared visibility map";
            class91.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         } else if(Client.loadingStage == 30) {
            CombatInfoListHolder.indexInterfaces = class48.openCacheIndex(0, false, true, true);
            class139.indexSoundEffects = class48.openCacheIndex(1, false, true, true);
            class215.configsIndex = class48.openCacheIndex(2, true, false, true);
            indexCache3 = class48.openCacheIndex(3, false, true, true);
            class19.indexCache4 = class48.openCacheIndex(4, false, true, true);
            ScriptState.indexMaps = class48.openCacheIndex(5, true, true, true);
            Size.indexTrack1 = class48.openCacheIndex(6, true, true, false);
            MouseInput.indexModels = class48.openCacheIndex(7, false, true, true);
            Renderable.indexSprites = class48.openCacheIndex(8, false, true, true);
            class3.indexTextures = class48.openCacheIndex(9, false, true, true);
            MouseInput.indexCache10 = class48.openCacheIndex(10, false, true, true);
            RunException.indexTrack2 = class48.openCacheIndex(11, false, true, true);
            Timer.indexScripts = class48.openCacheIndex(12, false, true, true);
            class64.indexCache13 = class48.openCacheIndex(13, true, false, true);
            class44.vorbisIndex = class48.openCacheIndex(14, false, true, false);
            class31.indexCache15 = class48.openCacheIndex(15, false, true, true);
            GameCanvas.indexWorldMap = class48.openCacheIndex(16, false, true, false);
            class91.loadingText = "Connecting to update server";
            class91.loadingBarPercentage = 20;
            Client.loadingStage = 40;
         } else if(Client.loadingStage == 40) {
            byte var32 = 0;
            var0 = var32 + CombatInfoListHolder.indexInterfaces.percentage() * 4 / 100;
            var0 += class139.indexSoundEffects.percentage() * 4 / 100;
            var0 += class215.configsIndex.percentage() * 2 / 100;
            var0 += indexCache3.percentage() * 2 / 100;
            var0 += class19.indexCache4.percentage() * 6 / 100;
            var0 += ScriptState.indexMaps.percentage() * 4 / 100;
            var0 += Size.indexTrack1.percentage() * 2 / 100;
            var0 += MouseInput.indexModels.percentage() * 58 / 100;
            var0 += Renderable.indexSprites.percentage() * 2 / 100;
            var0 += class3.indexTextures.percentage() * 2 / 100;
            var0 += MouseInput.indexCache10.percentage() * 2 / 100;
            var0 += RunException.indexTrack2.percentage() * 2 / 100;
            var0 += Timer.indexScripts.percentage() * 2 / 100;
            var0 += class64.indexCache13.percentage() * 2 / 100;
            var0 += class44.vorbisIndex.percentage() * 2 / 100;
            var0 += class31.indexCache15.percentage() * 2 / 100;
            var0 += GameCanvas.indexWorldMap.percentage() * 2 / 100;
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
            IndexData var28;
            IndexData var29;
            IndexData var30;
            if(Client.loadingStage == 45) {
               boolean var31 = !Client.lowMemory;
               AbstractSoundSystem.sampleRate = 22050;
               class2.highMemory = var31;
               AbstractSoundSystem.priority = 2;
               class215 var36 = new class215();
               var36.method3906(9, 128);
               Renderable.soundSystem0 = DynamicObject.method1885(class179.taskManager, 0, 22050);
               Renderable.soundSystem0.method2063(var36);
               var28 = class31.indexCache15;
               var29 = class44.vorbisIndex;
               var30 = class19.indexCache4;
               class214.field2635 = var28;
               class214.field2633 = var29;
               class214.field2629 = var30;
               class214.field2630 = var36;
               UrlRequester.soundSystem1 = DynamicObject.method1885(class179.taskManager, 1, 2048);
               class89.field1328 = new class101();
               UrlRequester.soundSystem1.method2063(class89.field1328);
               class23.field343 = new class115(22050, AbstractSoundSystem.sampleRate);
               class91.loadingText = "Prepared sound engine";
               class91.loadingBarPercentage = 35;
               Client.loadingStage = 50;
               class48.fonts = new Fonts(Renderable.indexSprites, class64.indexCache13);
            } else if(Client.loadingStage == 50) {
               var0 = FontName.method4929().length;
               Client.fontsMap = class48.fonts.createMap(FontName.method4929());
               if(Client.fontsMap.size() < var0) {
                  class91.loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var0 + "%";
                  class91.loadingBarPercentage = 40;
               } else {
                  FileRequest.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
                  CombatInfo1.font_p12full = (Font)Client.fontsMap.get(FontName.FontName_plain12);
                  class36.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
                  GameSocket.platformInfo = new MachineInfo(true);
                  class91.loadingText = "Loaded fonts";
                  class91.loadingBarPercentage = 40;
                  Client.loadingStage = 60;
               }
            } else {
               IndexData var35;
               if(Client.loadingStage == 60) {
                  var35 = MouseInput.indexCache10;
                  var28 = Renderable.indexSprites;
                  var3 = 0;
                  if(var35.tryLoadRecordByNames("title.jpg", "")) {
                     ++var3;
                  }

                  if(var28.tryLoadRecordByNames("logo", "")) {
                     ++var3;
                  }

                  if(var28.tryLoadRecordByNames("logo_deadman_mode", "")) {
                     ++var3;
                  }

                  if(var28.tryLoadRecordByNames("titlebox", "")) {
                     ++var3;
                  }

                  if(var28.tryLoadRecordByNames("titlebutton", "")) {
                     ++var3;
                  }

                  if(var28.tryLoadRecordByNames("runes", "")) {
                     ++var3;
                  }

                  if(var28.tryLoadRecordByNames("title_mute", "")) {
                     ++var3;
                  }

                  if(var28.tryLoadRecordByNames("options_radio_buttons,0", "")) {
                     ++var3;
                  }

                  if(var28.tryLoadRecordByNames("options_radio_buttons,2", "")) {
                     ++var3;
                  }

                  if(var28.tryLoadRecordByNames("options_radio_buttons,4", "")) {
                     ++var3;
                  }

                  if(var28.tryLoadRecordByNames("options_radio_buttons,6", "")) {
                     ++var3;
                  }

                  var28.tryLoadRecordByNames("sl_back", "");
                  var28.tryLoadRecordByNames("sl_flags", "");
                  var28.tryLoadRecordByNames("sl_arrows", "");
                  var28.tryLoadRecordByNames("sl_stars", "");
                  var28.tryLoadRecordByNames("sl_button", "");
                  var4 = MouseRecorder.method1116();
                  if(var3 < var4) {
                     class91.loadingText = "Loading title screen - " + var3 * 100 / var4 + "%";
                     class91.loadingBarPercentage = 50;
                  } else {
                     class91.loadingText = "Loaded title screen";
                     class91.loadingBarPercentage = 50;
                     ClanMember.setGameState(5);
                     Client.loadingStage = 70;
                  }
               } else if(Client.loadingStage == 70) {
                  if(!class215.configsIndex.method4330()) {
                     class91.loadingText = "Loading config - " + class215.configsIndex.loadPercent() + "%";
                     class91.loadingBarPercentage = 60;
                  } else {
                     WorldMapType2.method525(class215.configsIndex);
                     IndexData var33 = class215.configsIndex;
                     FloorUnderlayDefinition.underlay_ref = var33;
                     var35 = class215.configsIndex;
                     var28 = MouseInput.indexModels;
                     KitDefinition.identKit_ref = var35;
                     KitDefinition.field3440 = var28;
                     KitDefinition.field3447 = KitDefinition.identKit_ref.fileCount(3);
                     MouseRecorder.method1119(class215.configsIndex, MouseInput.indexModels, Client.lowMemory);
                     DynamicObject.method1887(class215.configsIndex, MouseInput.indexModels);
                     var29 = class215.configsIndex;
                     class60.field723 = var29;
                     var30 = class215.configsIndex;
                     IndexData var5 = MouseInput.indexModels;
                     boolean var6 = Client.isMembers;
                     Font var7 = FileRequest.fontPlain11;
                     ItemComposition.item_ref = var30;
                     ItemComposition.ItemDefinition_modelIndexCache = var5;
                     ItemComposition.isMembersWorld = var6;
                     class89.field1329 = ItemComposition.item_ref.fileCount(10);
                     GrandExchangeOffer.field297 = var7;
                     IndexData var8 = class215.configsIndex;
                     IndexData var9 = CombatInfoListHolder.indexInterfaces;
                     IndexData var10 = class139.indexSoundEffects;
                     Sequence.seq_ref = var8;
                     Sequence.skel_ref = var9;
                     Sequence.skin_ref = var10;
                     BoundingBox2D.method38(class215.configsIndex, MouseInput.indexModels);
                     IndexData var11 = class215.configsIndex;
                     Varbit.varbit_ref = var11;
                     IndexData var12 = class215.configsIndex;
                     GameEngine.varplayer_ref = var12;
                     VarPlayerType.field3378 = GameEngine.varplayer_ref.fileCount(16);
                     IndexData var13 = indexCache3;
                     IndexData var14 = MouseInput.indexModels;
                     IndexData var15 = Renderable.indexSprites;
                     IndexData var16 = class64.indexCache13;
                     Widget.widgetIndex = var13;
                     VertexNormal.field1914 = var14;
                     Widget.field2789 = var15;
                     GroundObject.field1776 = var16;
                     Widget.widgets = new Widget[Widget.widgetIndex.size()][];
                     class254.validInterfaces = new boolean[Widget.widgetIndex.size()];
                     AttackOption.method1748(class215.configsIndex);
                     class167.method3235(class215.configsIndex);
                     IndexData var17 = class215.configsIndex;
                     class254.field3408 = var17;
                     IndexData var18 = class215.configsIndex;
                     class19.field317 = var18;
                     class39.method535(class215.configsIndex);
                     class159.chatMessages = new Varcs();
                     IndexData var19 = class215.configsIndex;
                     IndexData var20 = Renderable.indexSprites;
                     IndexData var21 = class64.indexCache13;
                     class265.field3515 = var19;
                     class60.field725 = var20;
                     class265.field3498 = var21;
                     class249.method4458(class215.configsIndex, Renderable.indexSprites);
                     IndexData var22 = class215.configsIndex;
                     IndexData var23 = Renderable.indexSprites;
                     Area.field3391 = var23;
                     if(var22.method4330()) {
                        Area.field3382 = var22.fileCount(35);
                        Area.mapAreaType = new Area[Area.field3382];

                        for(int var24 = 0; var24 < Area.field3382; ++var24) {
                           byte[] var25 = var22.getConfigData(35, var24);
                           if(var25 != null) {
                              Area.mapAreaType[var24] = new Area(var24);
                              Area.mapAreaType[var24].method4496(new Buffer(var25));
                              Area.mapAreaType[var24].method4492();
                           }
                        }
                     }

                     class91.loadingText = "Loaded config";
                     class91.loadingBarPercentage = 60;
                     Client.loadingStage = 80;
                  }
               } else if(Client.loadingStage == 80) {
                  var0 = 0;
                  SpritePixels var27;
                  if(VarPlayerType.compass == null) {
                     var28 = Renderable.indexSprites;
                     var3 = var28.getFile("compass");
                     var4 = var28.getChild(var3, "");
                     var27 = GameCanvas.method772(var28, var3, var4);
                     VarPlayerType.compass = var27;
                  } else {
                     ++var0;
                  }

                  if(class2.mapedge == null) {
                     var28 = Renderable.indexSprites;
                     var3 = var28.getFile("mapedge");
                     var4 = var28.getChild(var3, "");
                     var27 = GameCanvas.method772(var28, var3, var4);
                     class2.mapedge = var27;
                  } else {
                     ++var0;
                  }

                  if(class21.mapscene == null) {
                     class21.mapscene = BufferProvider.getIndexedSprites(Renderable.indexSprites, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(class44.headIconsPk == null) {
                     class44.headIconsPk = class5.getSprites(Renderable.indexSprites, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(class18.headIconsPrayer == null) {
                     class18.headIconsPrayer = class5.getSprites(Renderable.indexSprites, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(GameEngine.headIconsHint == null) {
                     GameEngine.headIconsHint = class5.getSprites(Renderable.indexSprites, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(BaseVarType.mapMarkers == null) {
                     BaseVarType.mapMarkers = class5.getSprites(Renderable.indexSprites, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(MessageNode.crossSprites == null) {
                     MessageNode.crossSprites = class5.getSprites(Renderable.indexSprites, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(GameObject.mapDots == null) {
                     GameObject.mapDots = class5.getSprites(Renderable.indexSprites, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(GameEngine.scrollbarSprites == null) {
                     GameEngine.scrollbarSprites = BufferProvider.getIndexedSprites(Renderable.indexSprites, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(class254.modIconSprites == null) {
                     class254.modIconSprites = BufferProvider.getIndexedSprites(Renderable.indexSprites, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 11) {
                     class91.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                     class91.loadingBarPercentage = 70;
                  } else {
                     FontTypeFace.modIcons = class254.modIconSprites;
                     class2.mapedge.method5317();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;
                     class21.mapscene[0].method5259(var4 + var1, var4 + var2, var3 + var4);
                     class91.loadingText = "Loaded sprites";
                     class91.loadingBarPercentage = 70;
                     Client.loadingStage = 90;
                  }
               } else if(Client.loadingStage == 90) {
                  if(!class3.indexTextures.method4330()) {
                     class91.loadingText = "Loading textures - " + "0%";
                     class91.loadingBarPercentage = 90;
                  } else {
                     ItemContainer.field752 = new TextureProvider(class3.indexTextures, Renderable.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
                     Graphics3D.method2667(ItemContainer.field752);
                     Graphics3D.setBrightness(0.8D);
                     Client.loadingStage = 100;
                  }
               } else if(Client.loadingStage == 100) {
                  var0 = ItemContainer.field752.method2469();
                  if(var0 < 100) {
                     class91.loadingText = "Loading textures - " + var0 + "%";
                     class91.loadingBarPercentage = 90;
                  } else {
                     class91.loadingText = "Loaded textures";
                     class91.loadingBarPercentage = 90;
                     Client.loadingStage = 110;
                  }
               } else if(Client.loadingStage == 110) {
                  UrlRequester.mouseRecorder = new MouseRecorder();
                  class179.taskManager.createRunnable(UrlRequester.mouseRecorder, 10);
                  class91.loadingText = "Loaded input handler";
                  class91.loadingBarPercentage = 92;
                  Client.loadingStage = 120;
               } else if(Client.loadingStage == 120) {
                  if(!MouseInput.indexCache10.tryLoadRecordByNames("huffman", "")) {
                     class91.loadingText = "Loading wordpack - " + 0 + "%";
                     class91.loadingBarPercentage = 94;
                  } else {
                     Huffman var26 = new Huffman(MouseInput.indexCache10.takeRecordByNames("huffman", ""));
                     class193.method3653(var26);
                     class91.loadingText = "Loaded wordpack";
                     class91.loadingBarPercentage = 94;
                     Client.loadingStage = 130;
                  }
               } else if(Client.loadingStage == 130) {
                  if(!indexCache3.method4330()) {
                     class91.loadingText = "Loading interfaces - " + indexCache3.loadPercent() * 4 / 5 + "%";
                     class91.loadingBarPercentage = 96;
                  } else if(!Timer.indexScripts.method4330()) {
                     class91.loadingText = "Loading interfaces - " + (80 + Timer.indexScripts.loadPercent() / 6) + "%";
                     class91.loadingBarPercentage = 96;
                  } else if(!class64.indexCache13.method4330()) {
                     class91.loadingText = "Loading interfaces - " + (96 + class64.indexCache13.loadPercent() / 50) + "%";
                     class91.loadingBarPercentage = 96;
                  } else {
                     class91.loadingText = "Loaded interfaces";
                     class91.loadingBarPercentage = 98;
                     Client.loadingStage = 140;
                  }
               } else if(Client.loadingStage == 140) {
                  class91.loadingBarPercentage = 100;
                  if(!GameCanvas.indexWorldMap.tryLoadArchiveByName(class40.field522.field517)) {
                     class91.loadingText = "Loading world map - " + GameCanvas.indexWorldMap.archiveLoadPercentByName(class40.field522.field517) / 10 + "%";
                  } else {
                     if(TextureProvider.renderOverview == null) {
                        TextureProvider.renderOverview = new RenderOverview();
                        TextureProvider.renderOverview.method5424(GameCanvas.indexWorldMap, class36.fontBold12, Client.fontsMap, class21.mapscene);
                     }

                     var0 = TextureProvider.renderOverview.method5425();
                     if(var0 < 100) {
                        class91.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                     } else {
                        class91.loadingText = "Loaded world map";
                        Client.loadingStage = 150;
                     }
                  }
               } else if(Client.loadingStage == 150) {
                  ClanMember.setGameState(10);
               }
            }
         }
      }
   }
}
