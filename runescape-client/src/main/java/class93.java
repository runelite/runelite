import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public class class93 {
   @ObfuscatedName("o")
   static byte[] field1411;
   @ObfuscatedName("j")
   static byte[] field1409;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Lgp;"
   )
   static Buffer[] field1413;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1143734549
   )
   @Export("playerIndexesCount")
   static int playerIndexesCount;
   @ObfuscatedName("z")
   @Export("playerIndices")
   static int[] playerIndices;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -736890587
   )
   static int field1416;
   @ObfuscatedName("w")
   static int[] field1418;
   @ObfuscatedName("r")
   @Export("Players_regions")
   static int[] Players_regions;
   @ObfuscatedName("d")
   @Export("Players_orientations")
   static int[] Players_orientations;
   @ObfuscatedName("a")
   @Export("Players_targetIndices")
   static int[] Players_targetIndices;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -68246881
   )
   static int field1421;
   @ObfuscatedName("f")
   static int[] field1422;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   static Buffer field1423;

   static {
      field1411 = new byte[2048];
      field1409 = new byte[2048];
      field1413 = new Buffer[2048];
      playerIndexesCount = 0;
      playerIndices = new int[2048];
      field1416 = 0;
      field1418 = new int[2048];
      Players_regions = new int[2048];
      Players_orientations = new int[2048];
      Players_targetIndices = new int[2048];
      field1421 = 0;
      field1422 = new int[2048];
      field1423 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IS)I",
      garbageValue = "21718"
   )
   public static int method1928(CharSequence var0, int var1) {
      return FrameMap.parseInt(var0, var1, true);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljm;II)Z",
      garbageValue = "1816915677"
   )
   public static boolean method1941(IndexDataBase var0, int var1) {
      byte[] var2 = var0.takeRecordFlat(var1);
      if(var2 == null) {
         return false;
      } else {
         Varbit.decodeSprite(var2);
         return true;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Lla;",
      garbageValue = "1568359095"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var4 << 40) + ((long)var1 << 16) + (long)var0 + ((long)var2 << 38) + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = GameObject.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = GameObject.getItemDefinition(var10);
         }
      }

      Model var21 = var9.getModel(1);
      if(var21 == null) {
         return null;
      } else {
         SpritePixels var22 = null;
         if(var9.notedTemplate != -1) {
            var22 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var22 == null) {
               return null;
            }
         } else if(var9.notedId != -1) {
            var22 = createSprite(var9.unnotedId, var1, var2, var3, 0, false);
            if(var22 == null) {
               return null;
            }
         } else if(var9.int3 != -1) {
            var22 = createSprite(var9.int2, var1, 0, 0, 0, false);
            if(var22 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.copyDrawRegion(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
         Rasterizer2D.reset();
         Graphics3D.Rasterizer3D_method1();
         Graphics3D.method2795(16, 16);
         Graphics3D.rasterGouraudLowRes = false;
         if(var9.int3 != -1) {
            var22.drawAt(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * Graphics3D.SINE[var9.xan2d] >> 16;
         int var18 = var16 * Graphics3D.COSINE[var9.xan2d] >> 16;
         var21.calculateBoundsCylinder();
         var21.method2700(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var21.modelHeight / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.notedId != -1) {
            var22.drawAt(0, 0);
         }

         if(var2 >= 1) {
            var8.method5866(1);
         }

         if(var2 >= 2) {
            var8.method5866(16777215);
         }

         if(var3 != 0) {
            var8.method5863(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
         if(var9.notedTemplate != -1) {
            var22.drawAt(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            Font var19 = class236.field2767;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method5521(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.setDrawRegion(var15);
         Graphics3D.Rasterizer3D_method1();
         Graphics3D.rasterGouraudLowRes = true;
         return var8;
      }
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2042069459"
   )
   static final void method1950(int var0) {
      WorldMapType1.method298();
      class153.method3155();
      int var1 = FileRequest.method4547(var0).configType;
      if(var1 != 0) {
         int var2 = class237.clientVarps[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               Graphics3D.setBrightness(0.9D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.9D);
            }

            if(var2 == 2) {
               Graphics3D.setBrightness(0.8D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.8D);
            }

            if(var2 == 3) {
               Graphics3D.setBrightness(0.7D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.7D);
            }

            if(var2 == 4) {
               Graphics3D.setBrightness(0.6D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.6D);
            }

            class152.method3141();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != Client.field1044) {
               if(Client.field1044 == 0 && Client.field1089 != -1) {
                  class95.method2007(class1.indexTrack1, Client.field1089, 0, var3, false);
                  Client.field1090 = false;
               } else if(var3 == 0) {
                  class229.field2679.method4150();
                  class229.field2680 = 1;
                  class61.field714 = null;
                  Client.field1090 = false;
               } else {
                  class95.method2008(var3);
               }

               Client.field1044 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field1091 = 127;
            }

            if(var2 == 1) {
               Client.field1091 = 96;
            }

            if(var2 == 2) {
               Client.field1091 = 64;
            }

            if(var2 == 3) {
               Client.field1091 = 32;
            }

            if(var2 == 4) {
               Client.field1091 = 0;
            }
         }

         if(var1 == 5) {
            Client.field884 = var2;
         }

         if(var1 == 6) {
            Client.field1018 = var2;
         }

         if(var1 == 9) {
            Client.field1019 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field1034 = 127;
            }

            if(var2 == 1) {
               Client.field1034 = 96;
            }

            if(var2 == 2) {
               Client.field1034 = 64;
            }

            if(var2 == 3) {
               Client.field1034 = 32;
            }

            if(var2 == 4) {
               Client.field1034 = 0;
            }
         }

         if(var1 == 17) {
            Client.field1055 = var2 & 65535;
         }

         if(var1 == 18) {
            Client.playerAttackOption = (AttackOption)class44.forOrdinal(GameSocket.method3365(), var2);
            if(Client.playerAttackOption == null) {
               Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field982 = -1;
            } else {
               Client.field982 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            Client.npcAttackOption = (AttackOption)class44.forOrdinal(GameSocket.method3365(), var2);
            if(Client.npcAttackOption == null) {
               Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

      }
   }
}
