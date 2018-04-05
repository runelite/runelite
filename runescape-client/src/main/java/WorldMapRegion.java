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

@ObfuscatedName("ai")
@Implements("WorldMapRegion")
public class WorldMapRegion {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   public static class213 field479;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   public static class213 field480;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   static final Coordinates field490;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2143517309
   )
   int field484;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -139529475
   )
   int field482;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lf;"
   )
   class22 field483;
   @ObfuscatedName("a")
   LinkedList field475;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -794821421
   )
   int field485;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1051009891
   )
   int field474;
   @ObfuscatedName("l")
   List field487;
   @ObfuscatedName("s")
   HashMap field476;
   @ObfuscatedName("v")
   @Export("mapFonts")
   final HashMap mapFonts;

   static {
      field479 = new class213(37748736, 256);
      field480 = new class213(256, 256);
      field490 = new Coordinates();
   }

   WorldMapRegion(int var1, int var2, int var3, HashMap var4) {
      this.field484 = var1;
      this.field482 = var2;
      this.field475 = new LinkedList();
      this.field487 = new LinkedList();
      this.field476 = new HashMap();
      this.field485 = var3 | -16777216;
      this.mapFonts = var4;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1981111026"
   )
   void method413(int var1, int var2, int var3) {
      int var5 = this.field484;
      int var6 = this.field482;
      int var7 = this.field474;
      class213 var8 = field479;
      long var9 = (long)(var7 << 16 | var5 << 8 | var6);
      SpritePixels var4 = (SpritePixels)var8.method3932(var9);
      if(var4 != null) {
         if(var3 == this.field474 * 64) {
            var4.method5856(var1, var2);
         } else {
            var4.method5879(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lf;Ljava/util/List;I)V",
      garbageValue = "1696479959"
   )
   void method414(class22 var1, List var2) {
      this.field476.clear();
      this.field483 = var1;
      this.method416(0, 0, 64, 64, this.field483);
      this.method417(var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
      garbageValue = "797631939"
   )
   void method415(HashSet var1, List var2) {
      this.field476.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class46 var4 = (class46)var3.next();
         if(var4.method255() == this.field484 && var4.method256() == this.field482) {
            this.field475.add(var4);
            this.method416(var4.method681() * 8, var4.method682() * 8, 8, 8, var4);
         }
      }

      this.method417(var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIILag;I)V",
      garbageValue = "-464175153"
   )
   void method416(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label55:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field411; ++var9) {
               WorldMapDecoration[] var10 = var5.decorations[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  WorldMapDecoration[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     WorldMapDecoration var13 = var11[var12];
                     Area var14 = this.method445(var13.objectDefinitionId);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field484 * 64 + var6, this.field482 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field483 != null) {
                           var16 = new Coordinates(this.field483.field410 + var9, var6 + this.field483.field406 * 64, var7 + this.field483.field407 * 64);
                        } else {
                           class46 var17 = (class46)var5;
                           var16 = new Coordinates(var9 + var17.field410, var6 + var17.field406 * 64 + var17.method679() * 8, var7 + var17.field407 * 64 + var17.method680() * 8);
                        }

                        MapIcon var18 = new MapIcon(var14.id, var16, var15, this.method447(var14));
                        this.field476.put(var8, var18);
                        continue label55;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;I)V",
      garbageValue = "-2088329344"
   )
   void method417(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field374.worldX >> 6 == this.field484 && var3.field374.worldY >> 6 == this.field482) {
            MapIcon var4 = new MapIcon(var3.field375, var3.field374, var3.field374, this.method446(var3.field375));
            this.field487.add(var4);
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILaw;[Lai;[Lll;B)V",
      garbageValue = "104"
   )
   void method444(int var1, class47 var2, WorldMapRegion[] var3, IndexedSprite[] var4) {
      this.field474 = var1;
      if(this.field483 != null || !this.field475.isEmpty()) {
         int var6 = this.field484;
         int var7 = this.field482;
         class213 var8 = field479;
         long var9 = (long)(var1 << 16 | var6 << 8 | var7);
         SpritePixels var5 = (SpritePixels)var8.method3932(var9);
         if(var5 == null) {
            class33 var18 = this.method426(this.field484, this.field482, var3);
            SpritePixels var17 = new SpritePixels(this.field474 * 64, this.field474 * 64);
            var17.setRaster();
            if(this.field483 != null) {
               this.method421(var2, var3, var4, var18);
            } else {
               this.method499(var2, var4, var18);
            }

            int var10 = this.field484;
            int var11 = this.field482;
            int var12 = this.field474;
            class213 var13 = field479;
            long var15 = (long)(var12 << 16 | var10 << 8 | var11);
            var13.method3936(var17, var15, var17.pixels.length * 4);
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;B)V",
      garbageValue = "31"
   )
   void method419(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.drawNonLinkMapIcons(var1, var2, var4, var3);
      this.drawMapLinks(var1, var2, var4, var3);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-657314952"
   )
   @Export("drawFlashingMapIcons")
   void drawFlashingMapIcons(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field476.values().iterator();

      while(var4.hasNext()) {
         MapIcon var5 = (MapIcon)var4.next();
         if(var1.contains(Integer.valueOf(var5.areaId))) {
            Area var6 = Area.mapAreaType[var5.areaId];
            this.method436(var6, var5.screenX, var5.screenY, var2, var3);
         }
      }

      this.method430(var1, var2, var3);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Law;[Lai;[Lll;Laf;I)V",
      garbageValue = "1079227649"
   )
   void method421(class47 var1, WorldMapRegion[] var2, IndexedSprite[] var3, class33 var4) {
      int var5;
      int var6;
      for(var5 = 0; var5 < 64; ++var5) {
         for(var6 = 0; var6 < 64; ++var6) {
            this.method424(var5, var6, this.field483, var1, var4);
            this.method425(var5, var6, this.field483, var1);
         }
      }

      for(var5 = 0; var5 < 64; ++var5) {
         for(var6 = 0; var6 < 64; ++var6) {
            this.method412(var5, var6, this.field483, var1, var3);
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Law;[Lll;Laf;I)V",
      garbageValue = "-334353730"
   )
   void method499(class47 var1, IndexedSprite[] var2, class33 var3) {
      Iterator var4 = this.field475.iterator();

      class46 var5;
      int var6;
      int var7;
      while(var4.hasNext()) {
         var5 = (class46)var4.next();

         for(var6 = var5.method681() * 8; var6 < var5.method681() * 8 + 8; ++var6) {
            for(var7 = var5.method682() * 8; var7 < var5.method682() * 8 + 8; ++var7) {
               this.method424(var6, var7, var5, var1, var3);
               this.method425(var6, var7, var5, var1);
            }
         }
      }

      var4 = this.field475.iterator();

      while(var4.hasNext()) {
         var5 = (class46)var4.next();

         for(var6 = var5.method681() * 8; var6 < var5.method681() * 8 + 8; ++var6) {
            for(var7 = var5.method682() * 8; var7 < var5.method682() * 8 + 8; ++var7) {
               this.method412(var6, var7, var5, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILag;Law;[Lll;I)V",
      garbageValue = "-1093455432"
   )
   void method412(int var1, int var2, class28 var3, class47 var4, IndexedSprite[] var5) {
      this.method433(var1, var2, var3);
      this.method432(var1, var2, var3, var5);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IILag;Law;Laf;I)V",
      garbageValue = "760540555"
   )
   void method424(int var1, int var2, class28 var3, class47 var4, class33 var5) {
      int var6 = var3.field414[0][var1][var2] - 1;
      int var7 = var3.field413[0][var1][var2] - 1;
      if(var6 == -1 && var7 == -1) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field474 * var1, this.field474 * (63 - var2), this.field474, this.field474, this.field485);
      }

      int var8 = 16711935;
      if(var7 != -1) {
         var8 = class169.method3291(var7, this.field485);
      }

      if(var7 > -1 && var3.field408[0][var1][var2] == 0) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field474 * var1, this.field474 * (63 - var2), this.field474, this.field474, var8);
      } else {
         int var9 = this.method431(var1, var2, var3, var5);
         if(var7 == -1) {
            Rasterizer2D.Rasterizer2D_fillRectangle(this.field474 * var1, this.field474 * (63 - var2), this.field474, this.field474, var9);
         } else {
            var4.method707(this.field474 * var1, this.field474 * (63 - var2), var9, var8, this.field474, this.field474, var3.field408[0][var1][var2], var3.field415[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IILag;Law;I)V",
      garbageValue = "-1471112519"
   )
   void method425(int var1, int var2, class28 var3, class47 var4) {
      for(int var5 = 1; var5 < var3.field411; ++var5) {
         int var6 = var3.field413[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = class169.method3291(var6, this.field485);
            if(var3.field408[var5][var1][var2] == 0) {
               Rasterizer2D.Rasterizer2D_fillRectangle(this.field474 * var1, this.field474 * (63 - var2), this.field474, this.field474, var7);
            } else {
               var4.method707(this.field474 * var1, this.field474 * (63 - var2), 0, var7, this.field474, this.field474, var3.field408[var5][var1][var2], var3.field415[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II[Lai;I)Laf;",
      garbageValue = "-1914049046"
   )
   class33 method426(int var1, int var2, WorldMapRegion[] var3) {
      class213 var5 = field480;
      long var6 = (long)(0 | var1 << 8 | var2);
      class33 var4 = (class33)var5.method3932(var6);
      class33 var8 = var4;
      if(var4 == null) {
         var8 = this.method534(var3);
         BoundingBox3DDrawMode.method55(var8, var1, var2);
      }

      return var8;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([Lai;B)Laf;",
      garbageValue = "-75"
   )
   class33 method534(WorldMapRegion[] var1) {
      class44 var2 = new class44(64, 64);
      if(this.field483 != null) {
         this.method491(0, 0, 64, 64, this.field483, var2);
      } else {
         Iterator var3 = this.field475.iterator();

         while(var3.hasNext()) {
            class46 var4 = (class46)var3.next();
            this.method491(var4.method681() * 8, var4.method682() * 8, 8, 8, var4, var2);
         }
      }

      this.method500(var1, var2);
      class33 var5 = new class33();
      var5.method407(var2);
      return var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([Lai;Lar;I)V",
      garbageValue = "1058265443"
   )
   void method500(WorldMapRegion[] var1, class44 var2) {
      class254[] var3 = new class254[]{class254.field3321, class254.field3322, class254.field3326, class254.field3328, class254.field3327, class254.field3324, class254.field3325, class254.field3323};
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
            switch(var7.field3329) {
            case 0:
               var13 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 1:
               var12 = 59;
               var13 = 59;
               var10 = 5;
               var11 = 5;
               break;
            case 2:
               var8 = 59;
               var10 = 5;
               break;
            case 3:
               var13 = 59;
               var11 = 5;
               break;
            case 4:
               var12 = 59;
               var10 = 5;
               break;
            case 5:
               var9 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 6:
               var9 = 59;
               var11 = 5;
               break;
            case 7:
               var9 = 59;
               var11 = 5;
               var12 = 59;
               var10 = 5;
            }

            this.method526(var12, var13, var8, var9, var10, var11, var1[var7.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIILag;Lar;I)V",
      garbageValue = "-1055720985"
   )
   void method491(int var1, int var2, int var3, int var4, class28 var5, class44 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field414[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = Tile.getUnderlayDefinition(var9);
               var6.method656(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIIILai;Lar;I)V",
      garbageValue = "-82032246"
   )
   void method526(int var1, int var2, int var3, int var4, int var5, int var6, WorldMapRegion var7, class44 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method451(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = Tile.getUnderlayDefinition(var11);
               var8.method656(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IILag;Laf;B)I",
      garbageValue = "1"
   )
   int method431(int var1, int var2, class28 var3, class33 var4) {
      return var3.field414[0][var1][var2] == 0?this.field485:var4.method402(var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IILag;[Lll;B)V",
      garbageValue = "-81"
   )
   void method432(int var1, int var2, class28 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field411; ++var5) {
         WorldMapDecoration[] var6 = var3.decorations[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            WorldMapDecoration[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               WorldMapDecoration var9 = var7[var8];
               if(!class64.method1112(var9.decoration)) {
                  int var11 = var9.decoration;
                  boolean var10 = var11 == WorldMapDecorationType.field3008.rsOrdinal;
                  if(!var10) {
                     continue;
                  }
               }

               ObjectComposition var12 = GameCanvas.getObjectDefinition(var9.objectDefinitionId);
               if(var12.mapSceneId != -1) {
                  if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                     var4[var12.mapSceneId].method5827(this.field474 * var1, this.field474 * (63 - var2), this.field474 * 2, this.field474 * 2);
                  } else {
                     var4[var12.mapSceneId].method5827(this.field474 * var1, this.field474 * (63 - var2), this.field474 * 2 + 1, this.field474 * 2 + 1);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IILag;S)V",
      garbageValue = "256"
   )
   void method433(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field411; ++var4) {
         WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            WorldMapDecoration[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               WorldMapDecoration var8 = var6[var7];
               int var10 = var8.decoration;
               boolean var9 = var10 >= WorldMapDecorationType.field2992.rsOrdinal && var10 <= WorldMapDecorationType.field2989.rsOrdinal || var10 == WorldMapDecorationType.field2990.rsOrdinal;
               if(var9) {
                  ObjectComposition var11 = GameCanvas.getObjectDefinition(var8.objectDefinitionId);
                  int var12 = var11.int1 != 0?-3407872:-3355444;
                  if(var8.decoration == WorldMapDecorationType.field2992.rsOrdinal) {
                     this.method466(var1, var2, var8.rotation, var12);
                  }

                  if(var8.decoration == WorldMapDecorationType.field2986.rsOrdinal) {
                     this.method466(var1, var2, var8.rotation, -3355444);
                     this.method466(var1, var2, var8.rotation + 1, var12);
                  }

                  if(var8.decoration == WorldMapDecorationType.field2989.rsOrdinal) {
                     if(var8.rotation == 0) {
                        Rasterizer2D.method5731(this.field474 * var1, this.field474 * (63 - var2), 1, var12);
                     }

                     if(var8.rotation == 1) {
                        Rasterizer2D.method5731(this.field474 + this.field474 * var1 - 1, this.field474 * (63 - var2), 1, var12);
                     }

                     if(var8.rotation == 2) {
                        Rasterizer2D.method5731(this.field474 * var1 + this.field474 - 1, this.field474 * (63 - var2) + this.field474 - 1, 1, var12);
                     }

                     if(var8.rotation == 3) {
                        Rasterizer2D.method5731(this.field474 * var1, this.field474 * (63 - var2) + this.field474 - 1, 1, var12);
                     }
                  }

                  if(var8.decoration == WorldMapDecorationType.field2990.rsOrdinal) {
                     int var13 = var8.rotation % 2;
                     int var14;
                     if(var13 == 0) {
                        for(var14 = 0; var14 < this.field474; ++var14) {
                           Rasterizer2D.method5731(var14 + this.field474 * var1, (64 - var2) * this.field474 - 1 - var14, 1, var12);
                        }
                     } else {
                        for(var14 = 0; var14 < this.field474; ++var14) {
                           Rasterizer2D.method5731(var14 + this.field474 * var1, var14 + this.field474 * (63 - var2), 1, var12);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;IB)V",
      garbageValue = "0"
   )
   @Export("drawNonLinkMapIcons")
   void drawNonLinkMapIcons(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field476.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var1 + var5 * (float)var9.worldX - var6);
         int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.worldY - var6);
         MapIcon var12 = (MapIcon)var8.getValue();
         if(var12 != null) {
            var12.screenX = var10;
            var12.screenY = var11;
            Area var13 = Area.mapAreaType[var12.areaId];
            if(!var3.contains(Integer.valueOf(var13.method4746()))) {
               this.method468(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "1242878155"
   )
   void method430(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field487.iterator();

      while(var4.hasNext()) {
         MapIcon var5 = (MapIcon)var4.next();
         Area var6 = Area.mapAreaType[var5.areaId];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4746()))) {
            this.method436(var6, var5.screenX, var5.screenY, var2, var3);
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Ljw;IIIII)V",
      garbageValue = "706232157"
   )
   void method436(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.getMapIcon(false);
      if(var6 != null) {
         var6.drawAt(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method5720(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method5720(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lao;IIFB)V",
      garbageValue = "-13"
   )
   void method468(MapIcon var1, int var2, int var3, float var4) {
      Area var5 = Area.mapAreaType[var1.areaId];
      this.method449(var5, var2, var3);
      this.method439(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljw;III)V",
      garbageValue = "-771442016"
   )
   void method449(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.getMapIcon(false);
      if(var4 != null) {
         int var5 = this.method437(var4, var1.horizontalAlignment);
         int var6 = this.method471(var4, var1.verticalAlignment);
         var4.drawAt(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lao;Ljw;IIFB)V",
      garbageValue = "-87"
   )
   void method439(MapIcon var1, Area var2, int var3, int var4, float var5) {
      if(var1.field527 != null) {
         if(var1.field527.fontSize.method192(var5)) {
            Font var6 = (Font)this.mapFonts.get(var1.field527.fontSize);
            var6.method5514(var1.field527.text, var3 - var1.field527.field470 / 2, var4, var1.field527.field470, var1.field527.field469, -16777216 | var2.field3460, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "605500216"
   )
   @Export("drawMapLinks")
   void drawMapLinks(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field487.iterator();

      while(var6.hasNext()) {
         MapIcon var7 = (MapIcon)var6.next();
         int var8 = var7.field532.worldX % 64;
         int var9 = var7.field532.worldY % 64;
         var7.screenX = (int)(var5 * (float)var8 + (float)var1);
         var7.screenY = (int)((float)var2 + var5 * (float)(63 - var9));
         if(!var3.contains(Integer.valueOf(var7.areaId))) {
            this.method468(var7, var7.screenX, var7.screenY, var5);
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "4095"
   )
   void method441() {
      if(this.field483 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method442(var1, var2, this.field483);
            }
         }
      } else {
         Iterator var5 = this.field475.iterator();

         while(var5.hasNext()) {
            class46 var6 = (class46)var5.next();

            for(int var3 = var6.method681() * 8; var3 < var6.method681() * 8 + 8; ++var3) {
               for(int var4 = var6.method682() * 8; var4 < var6.method682() * 8 + 8; ++var4) {
                  this.method442(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IILag;I)V",
      garbageValue = "1923191773"
   )
   void method442(int var1, int var2, class28 var3) {
      field490.set(0, var1, var2);

      for(int var4 = 0; var4 < var3.field411; ++var4) {
         WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            WorldMapDecoration[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               WorldMapDecoration var8 = var6[var7];
               Area var9 = this.method445(var8.objectDefinitionId);
               if(var9 != null) {
                  MapIcon var10 = (MapIcon)this.field476.get(field490);
                  if(var10 != null) {
                     if(var9.id != var10.areaId) {
                        MapIcon var16 = new MapIcon(var9.id, var10.field524, var10.field532, this.method447(var9));
                        this.field476.put(new Coordinates(field490), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field524.plane - var10.field532.plane;
                     var10.field532.plane = var4;
                     var10.field524.plane = var15 + var4;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field484 * 64 + var1, this.field482 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field483 != null) {
                     var12 = new Coordinates(this.field483.field410 + var4, this.field483.field406 * 64 + var1, var2 + this.field483.field407 * 64);
                  } else {
                     Iterator var13 = this.field475.iterator();

                     while(var13.hasNext()) {
                        class46 var14 = (class46)var13.next();
                        if(var14.method678(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field410, var14.field406 * 64 + var1 + var14.method679() * 8, var14.field407 * 64 + var2 + var14.method680() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new MapIcon(var9.id, var12, var11, this.method447(var9));
                     this.field476.put(new Coordinates(field490), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field476.remove(field490);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lld;Lji;B)I",
      garbageValue = "-17"
   )
   int method437(SpritePixels var1, HorizontalAlignment var2) {
      switch(var2.value) {
      case 0:
         return -var1.width / 2;
      case 2:
         return 0;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lld;Ljx;I)I",
      garbageValue = "428411858"
   )
   int method471(SpritePixels var1, VerticalAlignment var2) {
      switch(var2.value) {
      case 0:
         return 0;
      case 1:
         return -var1.height / 2;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)Ljw;",
      garbageValue = "162387825"
   )
   Area method445(int var1) {
      ObjectComposition var2 = GameCanvas.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.mapAreaType[var2.mapIconId]:null;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(II)Laq;",
      garbageValue = "-603443895"
   )
   MapLabel method446(int var1) {
      Area var2 = Area.mapAreaType[var1];
      return this.method447(var2);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Ljw;I)Laq;",
      garbageValue = "877118470"
   )
   MapLabel method447(Area var1) {
      if(var1.name != null && this.mapFonts != null && this.mapFonts.get(Size.field371) != null) {
         Size var2 = Size.method195(var1.field3458);
         if(var2 == null) {
            return null;
         } else {
            Font var3 = (Font)this.mapFonts.get(var2);
            if(var3 == null) {
               return null;
            } else {
               int var4 = var3.method5508(var1.name, 1000000);
               String[] var5 = new String[var4];
               var3.method5580(var1.name, (int[])null, var5);
               int var6 = var5.length * var3.verticalSpace / 2;
               int var7 = 0;
               String[] var8 = var5;

               for(int var9 = 0; var9 < var8.length; ++var9) {
                  String var10 = var8[var9];
                  int var11 = var3.getTextWidth(var10);
                  if(var11 > var7) {
                     var7 = var11;
                  }
               }

               return new MapLabel(var1.name, var7, var6, var2);
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IIIIIB)Ljava/util/List;",
      garbageValue = "-41"
   )
   List method469(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field476.values().iterator();

            MapIcon var8;
            while(var7.hasNext()) {
               var8 = (MapIcon)var7.next();
               if(var8.method583(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field487.iterator();

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

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/List;",
      garbageValue = "-607735882"
   )
   List method511() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field487);
      var1.addAll(this.field476.values());
      return var1;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1540734489"
   )
   void method466(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method5797(this.field474 * var1, this.field474 * (63 - var2), this.field474, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5731(this.field474 * var1, this.field474 * (63 - var2), this.field474, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5797(this.field474 * var1 + this.field474 - 1, this.field474 * (63 - var2), this.field474, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5731(this.field474 * var1, this.field474 * (63 - var2) + this.field474 - 1, this.field474, var4);
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1260888046"
   )
   int method451(int var1, int var2) {
      if(this.field483 != null) {
         return this.field483.method269(var1, var2);
      } else {
         if(!this.field475.isEmpty()) {
            Iterator var3 = this.field475.iterator();

            while(var3.hasNext()) {
               class46 var4 = (class46)var3.next();
               if(var4.method678(var1, var2)) {
                  return var4.method269(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljf;II)Lhx;",
      garbageValue = "-716151021"
   )
   static class233 method536(IndexDataBase var0, int var1) {
      byte[] var2 = var0.takeRecordFlat(var1);
      return var2 == null?null:new class233(var2);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1905297197"
   )
   @Export("getLength")
   public static int getLength(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-429516646"
   )
   static final void method535(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field1118 - Client.field1120) * var5 / 100 + Client.field1120;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1123) {
         var15 = Client.field1123;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field1122) {
            var6 = Client.field1122;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field911) {
         var15 = Client.field911;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1121) {
            var6 = Client.field1121;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1104 - Client.field1018) * var5 / 100 + Client.field1018;
      Client.scale = var3 * var6 * var8 / 85504 << 1;
      if(var2 != Client.viewportWidth || var3 != Client.viewportHeight) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.buildVisibilityMaps(var14, 500, 800, var2, var3);
      }

      Client.Viewport_xOffset = var0;
      Client.Viewport_yOffset = var1;
      Client.viewportWidth = var2;
      Client.viewportHeight = var3;
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(ZLgs;B)V",
      garbageValue = "-80"
   )
   @Hook("onNpcUpdate")
   @Export("updateNpcs")
   static final void updateNpcs(boolean var0, PacketBuffer var1) {
      Client.field990 = 0;
      Client.pendingNpcFlagsCount = 0;
      PacketBuffer var2 = Client.field957.packetBuffer;
      var2.bitAccess();
      int var3 = var2.getBits(8);
      int var4;
      if(var3 < Client.npcIndexesCount) {
         for(var4 = var3; var4 < Client.npcIndexesCount; ++var4) {
            Client.field1027[++Client.field990 - 1] = Client.npcIndices[var4];
         }
      }

      if(var3 > Client.npcIndexesCount) {
         throw new RuntimeException("");
      } else {
         Client.npcIndexesCount = 0;

         for(var4 = 0; var4 < var3; ++var4) {
            int var5 = Client.npcIndices[var4];
            NPC var6 = Client.cachedNPCs[var5];
            int var7 = var2.getBits(1);
            if(var7 == 0) {
               Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
               var6.npcCycle = Client.gameCycle;
            } else {
               int var8 = var2.getBits(2);
               if(var8 == 0) {
                  Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                  var6.npcCycle = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
               } else {
                  int var9;
                  int var10;
                  if(var8 == 1) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                     var6.npcCycle = Client.gameCycle;
                     var9 = var2.getBits(3);
                     var6.method1873(var9, (byte)1);
                     var10 = var2.getBits(1);
                     if(var10 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
                     }
                  } else if(var8 == 2) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                     var6.npcCycle = Client.gameCycle;
                     var9 = var2.getBits(3);
                     var6.method1873(var9, (byte)2);
                     var10 = var2.getBits(3);
                     var6.method1873(var10, (byte)2);
                     int var11 = var2.getBits(1);
                     if(var11 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
                     }
                  } else if(var8 == 3) {
                     Client.field1027[++Client.field990 - 1] = var5;
                  }
               }
            }
         }

         class28.method274(var0, var1);
         UrlRequester.method3091(var1);

         int var12;
         for(var12 = 0; var12 < Client.field990; ++var12) {
            var3 = Client.field1027[var12];
            if(Client.cachedNPCs[var3].npcCycle != Client.gameCycle) {
               Client.cachedNPCs[var3].composition = null;
               Client.cachedNPCs[var3] = null;
            }
         }

         if(var1.offset != Client.field957.packetLength) {
            throw new RuntimeException(var1.offset + "," + Client.field957.packetLength);
         } else {
            for(var12 = 0; var12 < Client.npcIndexesCount; ++var12) {
               if(Client.cachedNPCs[Client.npcIndices[var12]] == null) {
                  throw new RuntimeException(var12 + "," + Client.npcIndexesCount);
               }
            }

         }
      }
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(Lin;I)Lin;",
      garbageValue = "-861700018"
   )
   static Widget method533(Widget var0) {
      Widget var1 = class265.method4692(var0);
      if(var1 == null) {
         var1 = var0.dragParent;
      }

      return var1;
   }
}
