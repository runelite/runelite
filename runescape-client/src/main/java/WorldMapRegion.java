import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("WorldMapRegion")
public class WorldMapRegion {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   static class213 field457;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   static class213 field462;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   static final Coordinates field468;
   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -851917493
   )
   int field459;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 160241815
   )
   int field460;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lr;"
   )
   class22 field461;
   @ObfuscatedName("o")
   LinkedList field453;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1642704305
   )
   int field463;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1104238619
   )
   int field464;
   @ObfuscatedName("u")
   List field465;
   @ObfuscatedName("j")
   HashMap field466;
   @ObfuscatedName("k")
   @Export("mapFonts")
   final HashMap mapFonts;

   static {
      field457 = new class213(37748736, 256);
      field462 = new class213(256, 256);
      field468 = new Coordinates();
   }

   WorldMapRegion(int var1, int var2, int var3, HashMap var4) {
      this.field459 = var1;
      this.field460 = var2;
      this.field453 = new LinkedList();
      this.field465 = new LinkedList();
      this.field466 = new HashMap();
      this.field463 = var3 | -16777216;
      this.mapFonts = var4;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1823687407"
   )
   void method443(int var1, int var2, int var3) {
      SpritePixels var4 = Size.method190(this.field459, this.field460, this.field464);
      if(var4 != null) {
         if(var3 == this.field464 * 64) {
            var4.method5830(var1, var2);
         } else {
            var4.method5853(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lr;Ljava/util/List;I)V",
      garbageValue = "-267233013"
   )
   void method463(class22 var1, List var2) {
      this.field466.clear();
      this.field461 = var1;
      this.method390(0, 0, 64, 64, this.field461);
      this.method391(var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
      garbageValue = "823199088"
   )
   void method451(HashSet var1, List var2) {
      this.field466.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class46 var4 = (class46)var3.next();
         if(var4.method238() == this.field459 && var4.method239() == this.field460) {
            this.field453.add(var4);
            this.method390(var4.method697() * 8, var4.method698() * 8, 8, 8, var4);
         }
      }

      this.method391(var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIILav;B)V",
      garbageValue = "41"
   )
   void method390(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label54:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field382; ++var9) {
               WorldMapDecoration[] var10 = var5.decorations[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  WorldMapDecoration[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     WorldMapDecoration var13 = var11[var12];
                     Area var14 = this.method419(var13.objectDefinitionId);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field459 * 64 + var6, this.field460 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field461 != null) {
                           var16 = new Coordinates(this.field461.field381 + var9, var6 + this.field461.field379 * 64, var7 + this.field461.field378 * 64);
                        } else {
                           class46 var17 = (class46)var5;
                           var16 = new Coordinates(var9 + var17.field381, var17.field379 * 64 + var6 + var17.method705() * 8, var17.field378 * 64 + var7 + var17.method696() * 8);
                        }

                        MapIcon var18 = new MapIcon(var14.id, var16, var15, this.method421(var14));
                        this.field466.put(var8, var18);
                        continue label54;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;B)V",
      garbageValue = "26"
   )
   void method391(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field345.worldX >> 6 == this.field459 && var3.field345.worldY >> 6 == this.field460) {
            MapIcon var4 = new MapIcon(var3.field347, var3.field345, var3.field345, this.method420(var3.field347));
            this.field465.add(var4);
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILaf;[Lau;[Llk;I)V",
      garbageValue = "345530047"
   )
   void method388(int var1, class47 var2, WorldMapRegion[] var3, IndexedSprite[] var4) {
      this.field464 = var1;
      if(this.field461 != null || !this.field453.isEmpty()) {
         if(Size.method190(this.field459, this.field460, var1) == null) {
            class33 var5 = this.method400(this.field459, this.field460, var3);
            SpritePixels var6 = new SpritePixels(this.field464 * 64, this.field464 * 64);
            var6.method5833();
            if(this.field461 != null) {
               this.method395(var2, var3, var4, var5);
            } else {
               this.method500(var2, var4, var5);
            }

            class38.method550(var6, this.field459, this.field460, this.field464);
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;B)V",
      garbageValue = "7"
   )
   void method393(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.drawNonLinkMapIcons(var1, var2, var4, var3);
      this.drawMapLinks(var1, var2, var4, var3);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;IIB)V",
      garbageValue = "4"
   )
   @Export("drawFlashingMapIcons")
   void drawFlashingMapIcons(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field466.values().iterator();

      while(var4.hasNext()) {
         MapIcon var5 = (MapIcon)var4.next();
         if(var1.contains(Integer.valueOf(var5.areaId))) {
            Area var6 = Area.mapAreaType[var5.areaId];
            this.method426(var6, var5.screenX, var5.screenY, var2, var3);
         }
      }

      this.method409(var1, var2, var3);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Laf;[Lau;[Llk;Lap;I)V",
      garbageValue = "-755047049"
   )
   void method395(class47 var1, WorldMapRegion[] var2, IndexedSprite[] var3, class33 var4) {
      int var5;
      int var6;
      for(var5 = 0; var5 < 64; ++var5) {
         for(var6 = 0; var6 < 64; ++var6) {
            this.method398(var5, var6, this.field461, var1, var4);
            this.method402(var5, var6, this.field461, var1);
         }
      }

      for(var5 = 0; var5 < 64; ++var5) {
         for(var6 = 0; var6 < 64; ++var6) {
            this.method429(var5, var6, this.field461, var1, var3);
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Laf;[Llk;Lap;I)V",
      garbageValue = "850119981"
   )
   void method500(class47 var1, IndexedSprite[] var2, class33 var3) {
      Iterator var4 = this.field453.iterator();

      class46 var5;
      int var6;
      int var7;
      while(var4.hasNext()) {
         var5 = (class46)var4.next();

         for(var6 = var5.method697() * 8; var6 < var5.method697() * 8 + 8; ++var6) {
            for(var7 = var5.method698() * 8; var7 < var5.method698() * 8 + 8; ++var7) {
               this.method398(var6, var7, var5, var1, var3);
               this.method402(var6, var7, var5, var1);
            }
         }
      }

      var4 = this.field453.iterator();

      while(var4.hasNext()) {
         var5 = (class46)var4.next();

         for(var6 = var5.method697() * 8; var6 < var5.method697() * 8 + 8; ++var6) {
            for(var7 = var5.method698() * 8; var7 < var5.method698() * 8 + 8; ++var7) {
               this.method429(var6, var7, var5, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IILav;Laf;[Llk;I)V",
      garbageValue = "-13139557"
   )
   void method429(int var1, int var2, class28 var3, class47 var4, IndexedSprite[] var5) {
      this.method389(var1, var2, var3);
      this.method406(var1, var2, var3, var5);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IILav;Laf;Lap;I)V",
      garbageValue = "27250558"
   )
   void method398(int var1, int var2, class28 var3, class47 var4, class33 var5) {
      int var6 = var3.field383[0][var1][var2] - 1;
      int var7 = var3.field384[0][var1][var2] - 1;
      if(var6 == -1 && var7 == -1) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field464 * var1, this.field464 * (63 - var2), this.field464, this.field464, this.field463);
      }

      int var8 = 16711935;
      int var9;
      if(var7 != -1) {
         int var10 = this.field463;
         Overlay var11 = class183.getOverlayDefinition(var7);
         if(var11 == null) {
            var9 = var10;
         } else if(var11.otherRgbColor >= 0) {
            var9 = var11.otherRgbColor | -16777216;
         } else {
            int var12;
            if(var11.texture >= 0) {
               var12 = MapIconReference.method758(Graphics3D.textureLoader.getAverageTextureRGB(var11.texture), 96);
               var9 = Graphics3D.colorPalette[var12] | -16777216;
            } else if(var11.color == 16711935) {
               var9 = var10;
            } else {
               var12 = class21.method168(var11.hue, var11.saturation, var11.lightness);
               int var13 = MapIconReference.method758(var12, 96);
               var9 = Graphics3D.colorPalette[var13] | -16777216;
            }
         }

         var8 = var9;
      }

      if(var7 > -1 && var3.field389[0][var1][var2] == 0) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field464 * var1, this.field464 * (63 - var2), this.field464, this.field464, var8);
      } else {
         var9 = this.method405(var1, var2, var3, var5);
         if(var7 == -1) {
            Rasterizer2D.Rasterizer2D_fillRectangle(this.field464 * var1, this.field464 * (63 - var2), this.field464, this.field464, var9);
         } else {
            var4.method750(this.field464 * var1, this.field464 * (63 - var2), var9, var8, this.field464, this.field464, var3.field389[0][var1][var2], var3.field386[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IILav;Laf;I)V",
      garbageValue = "462243802"
   )
   void method402(int var1, int var2, class28 var3, class47 var4) {
      for(int var5 = 1; var5 < var3.field382; ++var5) {
         int var6 = var3.field384[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var8 = this.field463;
            Overlay var9 = class183.getOverlayDefinition(var6);
            int var7;
            if(var9 == null) {
               var7 = var8;
            } else if(var9.otherRgbColor >= 0) {
               var7 = var9.otherRgbColor | -16777216;
            } else {
               int var10;
               if(var9.texture >= 0) {
                  var10 = MapIconReference.method758(Graphics3D.textureLoader.getAverageTextureRGB(var9.texture), 96);
                  var7 = Graphics3D.colorPalette[var10] | -16777216;
               } else if(var9.color == 16711935) {
                  var7 = var8;
               } else {
                  var10 = class21.method168(var9.hue, var9.saturation, var9.lightness);
                  int var11 = MapIconReference.method758(var10, 96);
                  var7 = Graphics3D.colorPalette[var11] | -16777216;
               }
            }

            if(var3.field389[var5][var1][var2] == 0) {
               Rasterizer2D.Rasterizer2D_fillRectangle(this.field464 * var1, this.field464 * (63 - var2), this.field464, this.field464, var7);
            } else {
               var4.method750(this.field464 * var1, this.field464 * (63 - var2), 0, var7, this.field464, this.field464, var3.field389[var5][var1][var2], var3.field386[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II[Lau;B)Lap;",
      garbageValue = "26"
   )
   class33 method400(int var1, int var2, WorldMapRegion[] var3) {
      class33 var4 = VertexNormal.method2776(var1, var2);
      if(var4 == null) {
         var4 = this.method401(var3);
         class213 var5 = field462;
         long var7 = (long)(0 | var1 << 8 | var2);
         var5.method3967(var4, var7);
      }

      return var4;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([Lau;I)Lap;",
      garbageValue = "-680619990"
   )
   class33 method401(WorldMapRegion[] var1) {
      class44 var2 = new class44(64, 64);
      if(this.field461 != null) {
         this.method403(0, 0, 64, 64, this.field461, var2);
      } else {
         Iterator var3 = this.field453.iterator();

         while(var3.hasNext()) {
            class46 var4 = (class46)var3.next();
            this.method403(var4.method697() * 8, var4.method698() * 8, 8, 8, var4, var2);
         }
      }

      this.method410(var1, var2);
      class33 var5 = new class33();
      var5.method369(var2);
      return var5;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([Lau;Law;I)V",
      garbageValue = "-1039156466"
   )
   void method410(WorldMapRegion[] var1, class44 var2) {
      class254[] var3 = new class254[]{class254.field3322, class254.field3323, class254.field3325, class254.field3326, class254.field3320, class254.field3319, class254.field3327, class254.field3321};
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
            switch(var7.field3328) {
            case 0:
               var8 = 59;
               var10 = 5;
               break;
            case 1:
               var13 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 2:
               var12 = 59;
               var13 = 59;
               var10 = 5;
               var11 = 5;
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
               var12 = 59;
               var10 = 5;
               break;
            case 7:
               var9 = 59;
               var11 = 5;
            }

            this.method397(var12, var13, var8, var9, var10, var11, var1[var7.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIILav;Law;I)V",
      garbageValue = "2123195268"
   )
   void method403(int var1, int var2, int var3, int var4, class28 var5, class44 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field383[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = BuildType.getUnderlayDefinition(var9);
               var6.method672(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IIIIIILau;Law;B)V",
      garbageValue = "-77"
   )
   void method397(int var1, int var2, int var3, int var4, int var5, int var6, WorldMapRegion var7, class44 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method512(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = BuildType.getUnderlayDefinition(var11);
               var8.method672(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IILav;Lap;I)I",
      garbageValue = "-1914465942"
   )
   int method405(int var1, int var2, class28 var3, class33 var4) {
      return var3.field383[0][var1][var2] == 0?this.field463:var4.method368(var1, var2);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IILav;[Llk;B)V",
      garbageValue = "47"
   )
   void method406(int var1, int var2, class28 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field382; ++var5) {
         WorldMapDecoration[] var6 = var3.decorations[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            WorldMapDecoration[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               WorldMapDecoration var9 = var7[var8];
               if(!Projectile.method1969(var9.decoration)) {
                  int var11 = var9.decoration;
                  boolean var10 = var11 == WorldMapDecorationType.field3002.rsOrdinal;
                  if(!var10) {
                     continue;
                  }
               }

               ObjectComposition var12 = Spotanim.getObjectDefinition(var9.objectDefinitionId);
               if(var12.mapSceneId != -1) {
                  if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                     var4[var12.mapSceneId].method5823(this.field464 * var1, this.field464 * (63 - var2), this.field464 * 2, this.field464 * 2);
                  } else {
                     var4[var12.mapSceneId].method5823(this.field464 * var1, this.field464 * (63 - var2), this.field464 * 2 + 1, this.field464 * 2 + 1);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IILav;B)V",
      garbageValue = "-103"
   )
   void method389(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field382; ++var4) {
         WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            WorldMapDecoration[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               WorldMapDecoration var8 = var6[var7];
               int var10 = var8.decoration;
               boolean var9 = var10 >= WorldMapDecorationType.field2980.rsOrdinal && var10 <= WorldMapDecorationType.field2983.rsOrdinal || var10 == WorldMapDecorationType.field2984.rsOrdinal;
               if(var9) {
                  ObjectComposition var11 = Spotanim.getObjectDefinition(var8.objectDefinitionId);
                  int var12 = var11.int1 != 0?-3407872:-3355444;
                  if(var8.decoration == WorldMapDecorationType.field2980.rsOrdinal) {
                     this.method424(var1, var2, var8.rotation, var12);
                  }

                  if(var8.decoration == WorldMapDecorationType.field2982.rsOrdinal) {
                     this.method424(var1, var2, var8.rotation, -3355444);
                     this.method424(var1, var2, var8.rotation + 1, var12);
                  }

                  if(var8.decoration == WorldMapDecorationType.field2983.rsOrdinal) {
                     if(var8.rotation == 0) {
                        Rasterizer2D.method5718(this.field464 * var1, this.field464 * (63 - var2), 1, var12);
                     }

                     if(var8.rotation == 1) {
                        Rasterizer2D.method5718(this.field464 * var1 + this.field464 - 1, this.field464 * (63 - var2), 1, var12);
                     }

                     if(var8.rotation == 2) {
                        Rasterizer2D.method5718(this.field464 * var1 + this.field464 - 1, this.field464 * (63 - var2) + this.field464 - 1, 1, var12);
                     }

                     if(var8.rotation == 3) {
                        Rasterizer2D.method5718(this.field464 * var1, this.field464 * (63 - var2) + this.field464 - 1, 1, var12);
                     }
                  }

                  if(var8.decoration == WorldMapDecorationType.field2984.rsOrdinal) {
                     int var13 = var8.rotation % 2;
                     int var14;
                     if(var13 == 0) {
                        for(var14 = 0; var14 < this.field464; ++var14) {
                           Rasterizer2D.method5718(var14 + this.field464 * var1, (64 - var2) * this.field464 - 1 - var14, 1, var12);
                        }
                     } else {
                        for(var14 = 0; var14 < this.field464; ++var14) {
                           Rasterizer2D.method5718(var14 + this.field464 * var1, var14 + this.field464 * (63 - var2), 1, var12);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;IB)V",
      garbageValue = "-40"
   )
   @Export("drawNonLinkMapIcons")
   void drawNonLinkMapIcons(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field466.entrySet().iterator();

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
            if(!var3.contains(Integer.valueOf(var13.method4773()))) {
               this.method411(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-455319299"
   )
   void method409(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field465.iterator();

      while(var4.hasNext()) {
         MapIcon var5 = (MapIcon)var4.next();
         Area var6 = Area.mapAreaType[var5.areaId];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4773()))) {
            this.method426(var6, var5.screenX, var5.screenY, var2, var3);
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljj;IIIIB)V",
      garbageValue = "21"
   )
   void method426(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.getMapIcon(false);
      if(var6 != null) {
         var6.drawAt(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method5720(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method5720(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lal;IIFI)V",
      garbageValue = "2103223692"
   )
   void method411(MapIcon var1, int var2, int var3, float var4) {
      Area var5 = Area.mapAreaType[var1.areaId];
      this.method525(var5, var2, var3);
      this.method413(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Ljj;III)V",
      garbageValue = "-1817349594"
   )
   void method525(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.getMapIcon(false);
      if(var4 != null) {
         int var5 = this.method417(var4, var1.horizontalAlignment);
         int var6 = this.method418(var4, var1.verticalAlignment);
         var4.drawAt(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lal;Ljj;IIFI)V",
      garbageValue = "1838875191"
   )
   void method413(MapIcon var1, Area var2, int var3, int var4, float var5) {
      if(var1.field516 != null) {
         if(var1.field516.fontSize.method189(var5)) {
            Font var6 = (Font)this.mapFonts.get(var1.field516.fontSize);
            var6.method5504(var1.field516.text, var3 - var1.field516.field441 / 2, var4, var1.field516.field441, var1.field516.field442, -16777216 | var2.field3473, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "2040164864"
   )
   @Export("drawMapLinks")
   void drawMapLinks(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field465.iterator();

      while(var6.hasNext()) {
         MapIcon var7 = (MapIcon)var6.next();
         int var8 = var7.field510.worldX % 64;
         int var9 = var7.field510.worldY % 64;
         var7.screenX = (int)((float)var8 * var5 + (float)var1);
         var7.screenY = (int)(var5 * (float)(63 - var9) + (float)var2);
         if(!var3.contains(Integer.valueOf(var7.areaId))) {
            this.method411(var7, var7.screenX, var7.screenY, var5);
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2078182693"
   )
   void method439() {
      if(this.field461 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method416(var1, var2, this.field461);
            }
         }
      } else {
         Iterator var5 = this.field453.iterator();

         while(var5.hasNext()) {
            class46 var6 = (class46)var5.next();

            for(int var3 = var6.method697() * 8; var3 < var6.method697() * 8 + 8; ++var3) {
               for(int var4 = var6.method698() * 8; var4 < var6.method698() * 8 + 8; ++var4) {
                  this.method416(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IILav;I)V",
      garbageValue = "-832144509"
   )
   void method416(int var1, int var2, class28 var3) {
      field468.set(0, var1, var2);

      for(int var4 = 0; var4 < var3.field382; ++var4) {
         WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            WorldMapDecoration[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               WorldMapDecoration var8 = var6[var7];
               Area var9 = this.method419(var8.objectDefinitionId);
               if(var9 != null) {
                  MapIcon var10 = (MapIcon)this.field466.get(field468);
                  if(var10 != null) {
                     if(var10.areaId != var9.id) {
                        MapIcon var16 = new MapIcon(var9.id, var10.field511, var10.field510, this.method421(var9));
                        this.field466.put(new Coordinates(field468), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field511.plane - var10.field510.plane;
                     var10.field510.plane = var4;
                     var10.field511.plane = var4 + var15;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field459 * 64 + var1, this.field460 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field461 != null) {
                     var12 = new Coordinates(this.field461.field381 + var4, this.field461.field379 * 64 + var1, var2 + this.field461.field378 * 64);
                  } else {
                     Iterator var13 = this.field453.iterator();

                     while(var13.hasNext()) {
                        class46 var14 = (class46)var13.next();
                        if(var14.method703(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field381, var14.field379 * 64 + var1 + var14.method705() * 8, var14.field378 * 64 + var2 + var14.method696() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new MapIcon(var9.id, var12, var11, this.method421(var9));
                     this.field466.put(new Coordinates(field468), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field466.remove(field468);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lla;Ljm;B)I",
      garbageValue = "106"
   )
   int method417(SpritePixels var1, HorizontalAlignment var2) {
      switch(var2.value) {
      case 0:
         return -var1.width / 2;
      case 2:
         return 0;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lla;Lji;I)I",
      garbageValue = "1109668212"
   )
   int method418(SpritePixels var1, VerticalAlignment var2) {
      switch(var2.value) {
      case 0:
         return -var1.height / 2;
      case 1:
         return 0;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II)Ljj;",
      garbageValue = "1373077104"
   )
   Area method419(int var1) {
      ObjectComposition var2 = Spotanim.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.mapAreaType[var2.mapIconId]:null;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)Lah;",
      garbageValue = "2075329345"
   )
   MapLabel method420(int var1) {
      Area var2 = Area.mapAreaType[var1];
      return this.method421(var2);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Ljj;I)Lah;",
      garbageValue = "-173106583"
   )
   MapLabel method421(Area var1) {
      if(var1.name != null && this.mapFonts != null && this.mapFonts.get(Size.field343) != null) {
         int var3 = var1.field3462;
         Size[] var4 = new Size[]{Size.field335, Size.field343, Size.field334};
         Size[] var5 = var4;
         int var6 = 0;

         Size var2;
         while(true) {
            if(var6 >= var5.length) {
               var2 = null;
               break;
            }

            Size var7 = var5[var6];
            if(var3 == var7.field339) {
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
               var6 = var14.method5498(var1.name, 1000000);
               String[] var15 = new String[var6];
               var14.method5496(var1.name, (int[])null, var15);
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

               return new MapLabel(var1.name, var9, var8, var2);
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IIIIIB)Ljava/util/List;",
      garbageValue = "-54"
   )
   List method422(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field466.values().iterator();

            MapIcon var8;
            while(var7.hasNext()) {
               var8 = (MapIcon)var7.next();
               if(var8.method585(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field465.iterator();

            while(var7.hasNext()) {
               var8 = (MapIcon)var7.next();
               if(var8.method585(var4, var5)) {
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

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(B)Ljava/util/List;",
      garbageValue = "104"
   )
   List method427() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field465);
      var1.addAll(this.field466.values());
      return var1;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-25"
   )
   void method424(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method5707(this.field464 * var1, this.field464 * (63 - var2), this.field464, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5718(this.field464 * var1, this.field464 * (63 - var2), this.field464, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5707(this.field464 * var1 + this.field464 - 1, this.field464 * (63 - var2), this.field464, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5718(this.field464 * var1, this.field464 * (63 - var2) + this.field464 - 1, this.field464, var4);
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-417273353"
   )
   int method512(int var1, int var2) {
      if(this.field461 != null) {
         return this.field461.method237(var1, var2);
      } else {
         if(!this.field453.isEmpty()) {
            Iterator var3 = this.field453.iterator();

            while(var3.hasNext()) {
               class46 var4 = (class46)var3.next();
               if(var4.method703(var1, var2)) {
                  return var4.method237(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "2026477297"
   )
   public static synchronized long method465() {
      long var0 = System.currentTimeMillis();
      if(var0 < class196.field2570) {
         class196.field2565 += class196.field2570 - var0;
      }

      class196.field2570 = var0;
      return class196.field2565 + var0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Lfr;",
      garbageValue = "-1733296987"
   )
   public static Timer method529() {
      try {
         return new NanoTimer();
      } catch (Throwable var1) {
         return new MilliTimer();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "995177292"
   )
   static int method535(int var0, Script var1, boolean var2) {
      Widget var3 = GZipDecompressor.getWidget(class81.intStack[--class5.intStackSize]);
      if(var0 == 2800) {
         int[] var4 = class81.intStack;
         int var5 = ++class5.intStackSize - 1;
         int var7 = GrandExchangeEvent.getWidgetConfig(var3);
         int var6 = var7 >> 11 & 63;
         var4[var5] = var6;
         return 1;
      } else if(var0 != 2801) {
         if(var0 == 2802) {
            if(var3.name == null) {
               class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
            } else {
               class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var8 = class81.intStack[--class5.intStackSize];
         --var8;
         if(var3.actions != null && var8 < var3.actions.length && var3.actions[var8] != null) {
            class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var3.actions[var8];
         } else {
            class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(Lig;IIB)V",
      garbageValue = "5"
   )
   static final void method534(Widget var0, int var1, int var2) {
      if(Client.draggedWidget == null && !Client.isMenuOpen) {
         if(var0 != null && class110.method2298(var0) != null) {
            Client.draggedWidget = var0;
            Client.field1020 = class110.method2298(var0);
            Client.field1021 = var1;
            Client.field1015 = var2;
            MapLabel.field446 = 0;
            Client.draggingWidget = false;
            int var3 = Client.menuOptionCount - 1;
            if(var3 != -1) {
               WorldMapDecoration.topContextMenuRow = new ContextMenuRow();
               WorldMapDecoration.topContextMenuRow.param0 = Client.menuActionParams0[var3];
               WorldMapDecoration.topContextMenuRow.param1 = Client.menuActionParams1[var3];
               WorldMapDecoration.topContextMenuRow.type = Client.menuTypes[var3];
               WorldMapDecoration.topContextMenuRow.identifier = Client.menuIdentifiers[var3];
               WorldMapDecoration.topContextMenuRow.option = Client.menuOptions[var3];
            }

         }
      }
   }
}
