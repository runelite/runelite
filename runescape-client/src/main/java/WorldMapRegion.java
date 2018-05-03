import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("WorldMapRegion")
public class WorldMapRegion {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static class213 field472;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static class213 field473;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   static final Coordinates field483;
   @ObfuscatedName("x")
   @Export("tt")
   static int[] tt;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1150813059
   )
   int field481;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -747292749
   )
   int field488;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lm;"
   )
   class22 field476;
   @ObfuscatedName("o")
   LinkedList field477;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1268986153
   )
   int field478;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1066215841
   )
   @Export("pixelsPerTile")
   int pixelsPerTile;
   @ObfuscatedName("p")
   List field479;
   @ObfuscatedName("q")
   HashMap field474;
   @ObfuscatedName("f")
   @Export("mapFonts")
   final HashMap mapFonts;

   static {
      field472 = new class213(37748736, 256);
      field473 = new class213(256, 256);
      field483 = new Coordinates();
   }

   WorldMapRegion(int var1, int var2, int var3, HashMap var4) {
      this.field481 = var1;
      this.field488 = var2;
      this.field477 = new LinkedList();
      this.field479 = new LinkedList();
      this.field474 = new HashMap();
      this.field478 = var3 | -16777216;
      this.mapFonts = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "1412"
   )
   void method377(int var1, int var2, int var3) {
      SpritePixels var4 = Resampler.method2387(this.field481, this.field488, this.pixelsPerTile);
      if(var4 != null) {
         if(var3 == this.pixelsPerTile * 64) {
            var4.method5915(var1, var2);
         } else {
            var4.method5936(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lm;Ljava/util/List;I)V",
      garbageValue = "-269086829"
   )
   void method458(class22 var1, List var2) {
      this.field474.clear();
      this.field476 = var1;
      this.method437(0, 0, 64, 64, this.field476);
      this.method420(var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
      garbageValue = "-2092658217"
   )
   void method379(HashSet var1, List var2) {
      this.field474.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class46 var4 = (class46)var3.next();
         if(var4.method227() == this.field481 && var4.method228() == this.field488) {
            this.field477.add(var4);
            this.method437(var4.method704() * 8, var4.method689() * 8, 8, 8, var4);
         }
      }

      this.method420(var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIILaj;I)V",
      garbageValue = "-2107360457"
   )
   void method437(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label55:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field403; ++var9) {
               WorldMapDecoration[] var10 = var5.decorations[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  WorldMapDecoration[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     WorldMapDecoration var13 = var11[var12];
                     Area var14 = this.method512(var13.objectDefinitionId);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field481 * 64 + var6, this.field488 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field476 != null) {
                           var16 = new Coordinates(this.field476.field402 + var9, var6 + this.field476.field405 * 64, var7 + this.field476.field399 * 64);
                        } else {
                           class46 var17 = (class46)var5;
                           var16 = new Coordinates(var9 + var17.field402, var17.field405 * 64 + var6 + var17.method686() * 8, var7 + var17.field399 * 64 + var17.method687() * 8);
                        }

                        MapIcon var18 = new MapIcon(var14.id, var16, var15, this.createMapLabel(var14));
                        this.field474.put(var8, var18);
                        continue label55;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;I)V",
      garbageValue = "-1427388661"
   )
   void method420(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field371.worldX >> 6 == this.field481 && var3.field371.worldY >> 6 == this.field488) {
            MapIcon var4 = new MapIcon(var3.field373, var3.field371, var3.field371, this.method410(var3.field373));
            this.field479.add(var4);
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILan;[Lak;[Llh;I)V",
      garbageValue = "-2110816636"
   )
   void method382(int var1, class47 var2, WorldMapRegion[] var3, IndexedSprite[] var4) {
      this.pixelsPerTile = var1;
      if(this.field476 != null || !this.field477.isEmpty()) {
         if(Resampler.method2387(this.field481, this.field488, var1) == null) {
            class33 var5 = this.method390(this.field481, this.field488, var3);
            SpritePixels var6 = new SpritePixels(this.pixelsPerTile * 64, this.pixelsPerTile * 64);
            var6.setRaster();
            if(this.field476 != null) {
               this.method385(var2, var3, var4, var5);
            } else {
               this.method386(var2, var4, var5);
            }

            LoginPacket.method3506(var6, this.field481, this.field488, this.pixelsPerTile);
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "1923609767"
   )
   void method499(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.drawNonLinkMapIcons(var1, var2, var4, var3);
      this.drawMapLinks(var1, var2, var4, var3);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-1592911503"
   )
   @Export("drawFlashingMapIcons")
   void drawFlashingMapIcons(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field474.values().iterator();

      while(var4.hasNext()) {
         MapIcon var5 = (MapIcon)var4.next();
         if(var1.contains(Integer.valueOf(var5.areaId))) {
            Area var6 = class190.mapAreaType[var5.areaId];
            this.method400(var6, var5.screenX, var5.screenY, var2, var3);
         }
      }

      this.method399(var1, var2, var3);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lan;[Lak;[Llh;Lav;I)V",
      garbageValue = "-719054966"
   )
   void method385(class47 var1, WorldMapRegion[] var2, IndexedSprite[] var3, class33 var4) {
      int var5;
      int var6;
      for(var5 = 0; var5 < 64; ++var5) {
         for(var6 = 0; var6 < 64; ++var6) {
            this.method446(var5, var6, this.field476, var1, var4);
            this.method389(var5, var6, this.field476, var1);
         }
      }

      for(var5 = 0; var5 < 64; ++var5) {
         for(var6 = 0; var6 < 64; ++var6) {
            this.method387(var5, var6, this.field476, var1, var3);
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lan;[Llh;Lav;I)V",
      garbageValue = "-147588806"
   )
   void method386(class47 var1, IndexedSprite[] var2, class33 var3) {
      Iterator var4 = this.field477.iterator();

      class46 var5;
      int var6;
      int var7;
      while(var4.hasNext()) {
         var5 = (class46)var4.next();

         for(var6 = var5.method704() * 8; var6 < var5.method704() * 8 + 8; ++var6) {
            for(var7 = var5.method689() * 8; var7 < var5.method689() * 8 + 8; ++var7) {
               this.method446(var6, var7, var5, var1, var3);
               this.method389(var6, var7, var5, var1);
            }
         }
      }

      var4 = this.field477.iterator();

      while(var4.hasNext()) {
         var5 = (class46)var4.next();

         for(var6 = var5.method704() * 8; var6 < var5.method704() * 8 + 8; ++var6) {
            for(var7 = var5.method689() * 8; var7 < var5.method689() * 8 + 8; ++var7) {
               this.method387(var6, var7, var5, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IILaj;Lan;[Llh;I)V",
      garbageValue = "-1681872679"
   )
   void method387(int var1, int var2, class28 var3, class47 var4, IndexedSprite[] var5) {
      this.method383(var1, var2, var3);
      this.method396(var1, var2, var3, var5);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IILaj;Lan;Lav;I)V",
      garbageValue = "-1201824971"
   )
   void method446(int var1, int var2, class28 var3, class47 var4, class33 var5) {
      int var6 = var3.field404[0][var1][var2] - 1;
      int var7 = var3.field400[0][var1][var2] - 1;
      if(var6 == -1 && var7 == -1) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, this.field478);
      }

      int var8 = 16711935;
      if(var7 != -1) {
         var8 = class157.method3252(var7, this.field478);
      }

      if(var7 > -1 && var3.field406[0][var1][var2] == 0) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var8);
      } else {
         int var9 = this.method395(var1, var2, var3, var5);
         if(var7 == -1) {
            Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var9);
         } else {
            var4.method729(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), var9, var8, this.pixelsPerTile, this.pixelsPerTile, var3.field406[0][var1][var2], var3.field407[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IILaj;Lan;I)V",
      garbageValue = "356679318"
   )
   void method389(int var1, int var2, class28 var3, class47 var4) {
      for(int var5 = 1; var5 < var3.field403; ++var5) {
         int var6 = var3.field400[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = class157.method3252(var6, this.field478);
            if(var3.field406[var5][var1][var2] == 0) {
               Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var7);
            } else {
               var4.method729(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 0, var7, this.pixelsPerTile, this.pixelsPerTile, var3.field406[var5][var1][var2], var3.field407[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II[Lak;I)Lav;",
      garbageValue = "1165286327"
   )
   class33 method390(int var1, int var2, WorldMapRegion[] worldMapRegions) {
      class33 var4 = class157.method3253(var1, var2);
      if(var4 == null) {
         var4 = this.method502(worldMapRegions);
         class292.method5270(var4, var1, var2);
      }

      return var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([Lak;I)Lav;",
      garbageValue = "1395972876"
   )
   class33 method502(WorldMapRegion[] var1) {
      class44 var2 = new class44(64, 64);
      if(this.field476 != null) {
         this.method508(0, 0, 64, 64, this.field476, var2);
      } else {
         Iterator var3 = this.field477.iterator();

         while(var3.hasNext()) {
            class46 var4 = (class46)var3.next();
            this.method508(var4.method704() * 8, var4.method689() * 8, 8, 8, var4, var2);
         }
      }

      this.method392(var1, var2);
      class33 var5 = new class33();
      var5.method371(var2);
      return var5;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([Lak;Lap;B)V",
      garbageValue = "-5"
   )
   void method392(WorldMapRegion[] var1, class44 var2) {
      class254[] var3 = new class254[]{class254.field3320, class254.field3322, class254.field3318, class254.field3321, class254.field3316, class254.field3315, class254.field3317, class254.field3319};
      class254[] var5 = var3;

      for(int var6 = 0; var6 < var5.length; ++var6) {
         class254 var7 = var5[var6];
         if(var1[var7.rsOrdinal()] != null) {
            byte var8 = 0;
            byte var9 = 0;
            byte var10 = 64;
            byte var11 = 64;
            byte var12 = 0;
            byte var13 = 0;
            switch(var7.field3314) {
            case 0:
               var9 = 59;
               var11 = 5;
               var12 = 59;
               var10 = 5;
               break;
            case 1:
               var13 = 59;
               var11 = 5;
               break;
            case 2:
               var9 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 3:
               var8 = 59;
               var10 = 5;
               break;
            case 4:
               var13 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 5:
               var12 = 59;
               var10 = 5;
               break;
            case 6:
               var9 = 59;
               var11 = 5;
               break;
            case 7:
               var12 = 59;
               var13 = 59;
               var10 = 5;
               var11 = 5;
            }

            this.method394(var12, var13, var8, var9, var10, var11, var1[var7.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IIIILaj;Lap;I)V",
      garbageValue = "-1691589206"
   )
   void method508(int var1, int var2, int var3, int var4, class28 var5, class44 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field404[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = Frames.getUnderlayDefinition(var9);
               var6.method671(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IIIIIILak;Lap;I)V",
      garbageValue = "-585125877"
   )
   void method394(int var1, int var2, int var3, int var4, int var5, int var6, WorldMapRegion var7, class44 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method414(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = Frames.getUnderlayDefinition(var11);
               var8.method671(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IILaj;Lav;I)I",
      garbageValue = "344709742"
   )
   int method395(int var1, int var2, class28 var3, class33 var4) {
      return var3.field404[0][var1][var2] == 0?this.field478:var4.method367(var1, var2);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IILaj;[Llh;I)V",
      garbageValue = "-1848680229"
   )
   void method396(int var1, int var2, class28 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field403; ++var5) {
         WorldMapDecoration[] var6 = var3.decorations[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            WorldMapDecoration[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               WorldMapDecoration var9 = var7[var8];
               int var11 = var9.decoration;
               boolean var10 = var11 >= WorldMapDecorationType.field2977.rsOrdinal && var11 <= WorldMapDecorationType.field2997.rsOrdinal;
               if(var10 || TotalQuantityComparator.method104(var9.decoration)) {
                  ObjectComposition var12 = class80.getObjectDefinition(var9.objectDefinitionId);
                  if(var12.mapSceneId != -1) {
                     if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                        var4[var12.mapSceneId].method5891(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2, this.pixelsPerTile * 2);
                     } else {
                        var4[var12.mapSceneId].method5891(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2 + 1, this.pixelsPerTile * 2 + 1);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IILaj;I)V",
      garbageValue = "-1524999305"
   )
   void method383(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field403; ++var4) {
         WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            WorldMapDecoration[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               WorldMapDecoration var8 = var6[var7];
               if(ItemContainer.method1149(var8.decoration)) {
                  ObjectComposition var9 = class80.getObjectDefinition(var8.objectDefinitionId);
                  int var10 = var9.int1 != 0?-3407872:-3355444;
                  if(var8.decoration == WorldMapDecorationType.field2987.rsOrdinal) {
                     this.method460(var1, var2, var8.rotation, var10);
                  }

                  if(var8.decoration == WorldMapDecorationType.field2978.rsOrdinal) {
                     this.method460(var1, var2, var8.rotation, -3355444);
                     this.method460(var1, var2, var8.rotation + 1, var10);
                  }

                  if(var8.decoration == WorldMapDecorationType.field2976.rsOrdinal) {
                     if(var8.rotation == 0) {
                        Rasterizer2D.method5812(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 1, var10);
                     }

                     if(var8.rotation == 1) {
                        Rasterizer2D.method5812(this.pixelsPerTile + this.pixelsPerTile * var1 - 1, this.pixelsPerTile * (63 - var2), 1, var10);
                     }

                     if(var8.rotation == 2) {
                        Rasterizer2D.method5812(this.pixelsPerTile + this.pixelsPerTile * var1 - 1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, 1, var10);
                     }

                     if(var8.rotation == 3) {
                        Rasterizer2D.method5812(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, 1, var10);
                     }
                  }

                  if(var8.decoration == WorldMapDecorationType.field2980.rsOrdinal) {
                     int var11 = var8.rotation % 2;
                     int var12;
                     if(var11 == 0) {
                        for(var12 = 0; var12 < this.pixelsPerTile; ++var12) {
                           Rasterizer2D.method5812(var12 + this.pixelsPerTile * var1, (64 - var2) * this.pixelsPerTile - 1 - var12, 1, var10);
                        }
                     } else {
                        for(var12 = 0; var12 < this.pixelsPerTile; ++var12) {
                           Rasterizer2D.method5812(var12 + this.pixelsPerTile * var1, var12 + this.pixelsPerTile * (63 - var2), 1, var10);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;IB)V",
      garbageValue = "50"
   )
   @Export("drawNonLinkMapIcons")
   void drawNonLinkMapIcons(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field474.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var9.worldX * var5 + (float)var1 - var6);
         int var11 = (int)((float)(var2 + var4) - (float)var9.worldY * var5 - var6);
         MapIcon var12 = (MapIcon)var8.getValue();
         if(var12 != null) {
            var12.screenX = var10;
            var12.screenY = var11;
            Area var13 = class190.mapAreaType[var12.areaId];
            if(!var3.contains(Integer.valueOf(var13.method4865()))) {
               this.method381(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;IIB)V",
      garbageValue = "32"
   )
   void method399(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field479.iterator();

      while(var4.hasNext()) {
         MapIcon var5 = (MapIcon)var4.next();
         Area var6 = class190.mapAreaType[var5.areaId];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4865()))) {
            this.method400(var6, var5.screenX, var5.screenY, var2, var3);
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ljx;IIIIB)V",
      garbageValue = "-48"
   )
   void method400(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.getMapIcon(false);
      if(var6 != null) {
         var6.drawAt(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method5802(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method5802(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Lal;IIFI)V",
      garbageValue = "-2042579438"
   )
   void method381(MapIcon var1, int var2, int var3, float var4) {
      Area var5 = class190.mapAreaType[var1.areaId];
      this.method409(var5, var2, var3);
      this.method497(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Ljx;III)V",
      garbageValue = "-1152180226"
   )
   void method409(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.getMapIcon(false);
      if(var4 != null) {
         int var5 = this.method407(var4, var1.horizontalAlignment);
         int var6 = this.method408(var4, var1.verticalAlignment);
         var4.drawAt(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lal;Ljx;IIFB)V",
      garbageValue = "-89"
   )
   void method497(MapIcon mapIcon, Area var2, int var3, int var4, float var5) {
      if(mapIcon.field526 != null) {
         if(mapIcon.field526.fontSize.method184(var5)) {
            Font var6 = (Font)this.mapFonts.get(mapIcon.field526.fontSize);
            var6.method5574(mapIcon.field526.text, var3 - mapIcon.field526.field460 / 2, var4, mapIcon.field526.field460, mapIcon.field526.field462, -16777216 | var2.field3456, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;IB)V",
      garbageValue = "16"
   )
   @Export("drawMapLinks")
   void drawMapLinks(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field479.iterator();

      while(var6.hasNext()) {
         MapIcon var7 = (MapIcon)var6.next();
         int var8 = var7.field522.worldX % 64;
         int var9 = var7.field522.worldY % 64;
         var7.screenX = (int)((float)var1 + var5 * (float)var8);
         var7.screenY = (int)((float)var2 + var5 * (float)(63 - var9));
         if(!var3.contains(Integer.valueOf(var7.areaId))) {
            this.method381(var7, var7.screenX, var7.screenY, var5);
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-82"
   )
   void method405() {
      if(this.field476 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method401(var1, var2, this.field476);
            }
         }
      } else {
         Iterator var5 = this.field477.iterator();

         while(var5.hasNext()) {
            class46 var6 = (class46)var5.next();

            for(int var3 = var6.method704() * 8; var3 < var6.method704() * 8 + 8; ++var3) {
               for(int var4 = var6.method689() * 8; var4 < var6.method689() * 8 + 8; ++var4) {
                  this.method401(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IILaj;I)V",
      garbageValue = "-939134610"
   )
   void method401(int var1, int var2, class28 var3) {
      field483.set(0, var1, var2);

      for(int var4 = 0; var4 < var3.field403; ++var4) {
         WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            WorldMapDecoration[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               WorldMapDecoration var8 = var6[var7];
               Area var9 = this.method512(var8.objectDefinitionId);
               if(var9 != null) {
                  MapIcon var10 = (MapIcon)this.field474.get(field483);
                  if(var10 != null) {
                     if(var9.id != var10.areaId) {
                        MapIcon var16 = new MapIcon(var9.id, var10.field528, var10.field522, this.createMapLabel(var9));
                        this.field474.put(new Coordinates(field483), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field528.plane - var10.field522.plane;
                     var10.field522.plane = var4;
                     var10.field528.plane = var4 + var15;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field481 * 64 + var1, this.field488 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field476 != null) {
                     var12 = new Coordinates(this.field476.field402 + var4, this.field476.field405 * 64 + var1, var2 + this.field476.field399 * 64);
                  } else {
                     Iterator var13 = this.field477.iterator();

                     while(var13.hasNext()) {
                        class46 var14 = (class46)var13.next();
                        if(var14.method709(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field402, var1 + var14.field405 * 64 + var14.method686() * 8, var2 + var14.field399 * 64 + var14.method687() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new MapIcon(var9.id, var12, var11, this.createMapLabel(var9));
                     this.field474.put(new Coordinates(field483), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field474.remove(field483);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Llv;Ljt;I)I",
      garbageValue = "358818066"
   )
   int method407(SpritePixels var1, HorizontalAlignment var2) {
      switch(var2.value) {
      case 0:
         return 0;
      case 1:
         return -var1.width / 2;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Llv;Lja;I)I",
      garbageValue = "-1775293171"
   )
   int method408(SpritePixels var1, VerticalAlignment var2) {
      switch(var2.value) {
      case 1:
         return 0;
      case 2:
         return -var1.height / 2;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)Ljx;",
      garbageValue = "2035329881"
   )
   Area method512(int var1) {
      ObjectComposition var2 = class80.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?class190.mapAreaType[var2.mapIconId]:null;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IB)Lao;",
      garbageValue = "104"
   )
   MapLabel method410(int var1) {
      Area var2 = class190.mapAreaType[var1];
      return this.createMapLabel(var2);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ljx;I)Lao;",
      garbageValue = "81116203"
   )
   @Export("createMapLabel")
   MapLabel createMapLabel(Area area) {
      if(area.name != null && this.mapFonts != null && this.mapFonts.get(Size.field365) != null) {
         int var3 = area.field3457;
         Size[] var4 = new Size[]{Size.field359, Size.field365, Size.field360};
         Size[] var5 = var4;
         int var6 = 0;

         Size var2;
         while(true) {
            if(var6 >= var5.length) {
               var2 = null;
               break;
            }

            Size var7 = var5[var6];
            if(var3 == var7.field363) {
               var2 = var7;
               break;
            }

            ++var6;
         }

         if(var2 == null) {
            return null;
         } else {
            Font var14 = (Font)this.mapFonts.get(var2);
            if(var14 == null) {
               return null;
            } else {
               var6 = var14.method5564(area.name, 1000000);
               String[] var15 = new String[var6];
               var14.method5566(area.name, (int[])null, var15);
               int var8 = var15.length * var14.verticalSpace / 2;
               int var9 = 0;
               String[] var10 = var15;

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  String var12 = var10[var11];
                  int var13 = var14.getTextWidth(var12);
                  if(var13 > var9) {
                     var9 = var13;
                  }
               }

               return new MapLabel(area.name, var9, var8, var2);
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIIIB)Ljava/util/List;",
      garbageValue = "127"
   )
   List method449(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field474.values().iterator();

            MapIcon var8;
            while(var7.hasNext()) {
               var8 = (MapIcon)var7.next();
               if(var8.method583(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field479.iterator();

            while(var7.hasNext()) {
               var8 = (MapIcon)var7.next();
               if(var8.method583(var4, var5)) {
                  var6.add(var8);
               }
            }

            return var6;
         } else {
            return var6;
         }
      } else {
         return var6;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/List;",
      garbageValue = "-1595817575"
   )
   List method463() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field479);
      var1.addAll(this.field474.values());
      return var1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2026361078"
   )
   void method460(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method5814(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5812(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5814(this.pixelsPerTile * var1 + this.pixelsPerTile - 1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5812(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, this.pixelsPerTile, var4);
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-456929533"
   )
   int method414(int var1, int var2) {
      if(this.field476 != null) {
         return this.field476.method226(var1, var2);
      } else {
         if(!this.field477.isEmpty()) {
            Iterator var3 = this.field477.iterator();

            while(var3.hasNext()) {
               class46 var4 = (class46)var3.next();
               if(var4.method709(var1, var2)) {
                  return var4.method226(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-618667590"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class95.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class95.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
      class95.messages.put(var5, (long)var5.id);
      class95.field1429.add(var5);
      Client.chatCycle = Client.cycleCntr;
   }
}
