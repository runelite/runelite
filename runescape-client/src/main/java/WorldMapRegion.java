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

@ObfuscatedName("ao")
@Implements("WorldMapRegion")
public class WorldMapRegion {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   public static class213 field470;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   public static class213 field458;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static final Coordinates field468;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = 775228979
   )
   @Export("port1")
   static int port1;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = -523210033
   )
   static int field453;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 798137115
   )
   int field459;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1045172125
   )
   int field456;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   class22 field457;
   @ObfuscatedName("a")
   LinkedList field462;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1309850323
   )
   int field463;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1562000851
   )
   int field464;
   @ObfuscatedName("l")
   List field471;
   @ObfuscatedName("m")
   HashMap field466;
   @ObfuscatedName("b")
   @Export("mapFonts")
   final HashMap mapFonts;

   static {
      field470 = new class213(37748736, 256);
      field458 = new class213(256, 256);
      field468 = new Coordinates();
   }

   WorldMapRegion(int var1, int var2, int var3, HashMap var4) {
      this.field459 = var1;
      this.field456 = var2;
      this.field462 = new LinkedList();
      this.field471 = new LinkedList();
      this.field466 = new HashMap();
      this.field463 = var3 | -16777216;
      this.mapFonts = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-35002468"
   )
   void method390(int var1, int var2, int var3) {
      SpritePixels var4 = Size.method194(this.field459, this.field456, this.field464);
      if(var4 != null) {
         if(var3 == this.field464 * 64) {
            var4.method5868(var1, var2);
         } else {
            var4.method5890(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lq;Ljava/util/List;I)V",
      garbageValue = "-875631561"
   )
   void method508(class22 var1, List var2) {
      this.field466.clear();
      this.field457 = var1;
      this.method393(0, 0, 64, 64, this.field457);
      this.method394(var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
      garbageValue = "1320872508"
   )
   void method392(HashSet var1, List var2) {
      this.field466.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class46 var4 = (class46)var3.next();
         if(var4.method260() == this.field459 && var4.method247() == this.field456) {
            this.field462.add(var4);
            this.method393(var4.method687() * 8, var4.method679() * 8, 8, 8, var4);
         }
      }

      this.method394(var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIILal;I)V",
      garbageValue = "-2022359444"
   )
   void method393(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label56:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field391; ++var9) {
               WorldMapDecoration[] var10 = var5.decorations[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  WorldMapDecoration[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     WorldMapDecoration var13 = var11[var12];
                     Area var14 = this.method424(var13.objectDefinitionId);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field459 * 64 + var6, this.field456 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field457 != null) {
                           var16 = new Coordinates(this.field457.field392 + var9, var6 + this.field457.field390 * 64, var7 + this.field457.field387 * 64);
                        } else {
                           class46 var17 = (class46)var5;
                           var16 = new Coordinates(var9 + var17.field392, var6 + var17.field390 * 64 + var17.method676() * 8, var17.field387 * 64 + var7 + var17.method677() * 8);
                        }

                        MapIcon var18 = new MapIcon(var14.id, var16, var15, this.method509(var14));
                        this.field466.put(var8, var18);
                        continue label56;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;S)V",
      garbageValue = "-14065"
   )
   void method394(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field354.worldX >> 6 == this.field459 && var3.field354.worldY >> 6 == this.field456) {
            MapIcon var4 = new MapIcon(var3.field355, var3.field354, var3.field354, this.method451(var3.field355));
            this.field471.add(var4);
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILaz;[Lao;[Llq;B)V",
      garbageValue = "-51"
   )
   void method395(int var1, class47 var2, WorldMapRegion[] var3, IndexedSprite[] var4) {
      this.field464 = var1;
      if(this.field457 != null || !this.field462.isEmpty()) {
         if(Size.method194(this.field459, this.field456, var1) == null) {
            class33 var5 = this.method418(this.field459, this.field456, var3);
            SpritePixels var6 = new SpritePixels(this.field464 * 64, this.field464 * 64);
            var6.setRaster();
            if(this.field457 != null) {
               this.method398(var2, var3, var4, var5);
            } else {
               this.method399(var2, var4, var5);
            }

            AbstractByteBuffer.method3773(var6, this.field459, this.field456, this.field464);
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "962214860"
   )
   void method414(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.drawNonLinkMapIcons(var1, var2, var4, var3);
      this.drawMapLinks(var1, var2, var4, var3);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-1472148153"
   )
   @Export("drawFlashingMapIcons")
   void drawFlashingMapIcons(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field466.values().iterator();

      while(var4.hasNext()) {
         MapIcon var5 = (MapIcon)var4.next();
         if(var1.contains(Integer.valueOf(var5.areaId))) {
            Area var6 = Area.mapAreaType[var5.areaId];
            this.method413(var6, var5.screenX, var5.screenY, var2, var3);
         }
      }

      this.method412(var1, var2, var3);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Laz;[Lao;[Llq;Laa;B)V",
      garbageValue = "88"
   )
   void method398(class47 var1, WorldMapRegion[] var2, IndexedSprite[] var3, class33 var4) {
      int var5;
      int var6;
      for(var5 = 0; var5 < 64; ++var5) {
         for(var6 = 0; var6 < 64; ++var6) {
            this.method461(var5, var6, this.field457, var1, var4);
            this.method420(var5, var6, this.field457, var1);
         }
      }

      for(var5 = 0; var5 < 64; ++var5) {
         for(var6 = 0; var6 < 64; ++var6) {
            this.method502(var5, var6, this.field457, var1, var3);
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Laz;[Llq;Laa;B)V",
      garbageValue = "-90"
   )
   void method399(class47 var1, IndexedSprite[] var2, class33 var3) {
      Iterator var4 = this.field462.iterator();

      class46 var5;
      int var6;
      int var7;
      while(var4.hasNext()) {
         var5 = (class46)var4.next();

         for(var6 = var5.method687() * 8; var6 < var5.method687() * 8 + 8; ++var6) {
            for(var7 = var5.method679() * 8; var7 < var5.method679() * 8 + 8; ++var7) {
               this.method461(var6, var7, var5, var1, var3);
               this.method420(var6, var7, var5, var1);
            }
         }
      }

      var4 = this.field462.iterator();

      while(var4.hasNext()) {
         var5 = (class46)var4.next();

         for(var6 = var5.method687() * 8; var6 < var5.method687() * 8 + 8; ++var6) {
            for(var7 = var5.method679() * 8; var7 < var5.method679() * 8 + 8; ++var7) {
               this.method502(var6, var7, var5, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IILal;Laz;[Llq;I)V",
      garbageValue = "-1137960162"
   )
   void method502(int var1, int var2, class28 var3, class47 var4, IndexedSprite[] var5) {
      this.method410(var1, var2, var3);
      this.method409(var1, var2, var3, var5);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IILal;Laz;Laa;I)V",
      garbageValue = "1639893092"
   )
   void method461(int var1, int var2, class28 var3, class47 var4, class33 var5) {
      int var6 = var3.field388[0][var1][var2] - 1;
      int var7 = var3.field393[0][var1][var2] - 1;
      if(var6 == -1 && var7 == -1) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field464 * var1, this.field464 * (63 - var2), this.field464, this.field464, this.field463);
      }

      int var8 = 16711935;
      int var9;
      if(var7 != -1) {
         int var10 = this.field463;
         Overlay var11 = VarPlayerType.getOverlayDefinition(var7);
         if(var11 == null) {
            var9 = var10;
         } else if(var11.otherRgbColor >= 0) {
            var9 = var11.otherRgbColor | -16777216;
         } else {
            int var12;
            int var13;
            byte var14;
            int var16;
            if(var11.texture >= 0) {
               var13 = Graphics3D.textureLoader.getAverageTextureRGB(var11.texture);
               var14 = 96;
               if(var13 == -2) {
                  var12 = 12345678;
               } else if(var13 == -1) {
                  if(var14 < 0) {
                     var14 = 0;
                  } else if(var14 > 127) {
                     var14 = 127;
                  }

                  var16 = 127 - var14;
                  var12 = var16;
               } else {
                  var16 = var14 * (var13 & 127) / 128;
                  if(var16 < 2) {
                     var16 = 2;
                  } else if(var16 > 126) {
                     var16 = 126;
                  }

                  var12 = var16 + (var13 & 65408);
               }

               var9 = Graphics3D.colorPalette[var12] | -16777216;
            } else if(var11.color == 16711935) {
               var9 = var10;
            } else {
               var12 = Resampler.method2295(var11.hue, var11.saturation, var11.lightness);
               var14 = 96;
               if(var12 == -2) {
                  var13 = 12345678;
               } else if(var12 == -1) {
                  if(var14 < 0) {
                     var14 = 0;
                  } else if(var14 > 127) {
                     var14 = 127;
                  }

                  var16 = 127 - var14;
                  var13 = var16;
               } else {
                  var16 = var14 * (var12 & 127) / 128;
                  if(var16 < 2) {
                     var16 = 2;
                  } else if(var16 > 126) {
                     var16 = 126;
                  }

                  var13 = var16 + (var12 & 65408);
               }

               var9 = Graphics3D.colorPalette[var13] | -16777216;
            }
         }

         var8 = var9;
      }

      if(var7 > -1 && var3.field394[0][var1][var2] == 0) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field464 * var1, this.field464 * (63 - var2), this.field464, this.field464, var8);
      } else {
         var9 = this.method408(var1, var2, var3, var5);
         if(var7 == -1) {
            Rasterizer2D.Rasterizer2D_fillRectangle(this.field464 * var1, this.field464 * (63 - var2), this.field464, this.field464, var9);
         } else {
            var4.method699(this.field464 * var1, this.field464 * (63 - var2), var9, var8, this.field464, this.field464, var3.field394[0][var1][var2], var3.field395[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IILal;Laz;I)V",
      garbageValue = "-1739354945"
   )
   void method420(int var1, int var2, class28 var3, class47 var4) {
      for(int var5 = 1; var5 < var3.field391; ++var5) {
         int var6 = var3.field393[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var8 = this.field463;
            Overlay var9 = VarPlayerType.getOverlayDefinition(var6);
            int var7;
            if(var9 == null) {
               var7 = var8;
            } else if(var9.otherRgbColor >= 0) {
               var7 = var9.otherRgbColor | -16777216;
            } else {
               int var10;
               int var11;
               byte var12;
               int var15;
               if(var9.texture >= 0) {
                  var11 = Graphics3D.textureLoader.getAverageTextureRGB(var9.texture);
                  var12 = 96;
                  if(var11 == -2) {
                     var10 = 12345678;
                  } else if(var11 == -1) {
                     if(var12 < 0) {
                        var12 = 0;
                     } else if(var12 > 127) {
                        var12 = 127;
                     }

                     var15 = 127 - var12;
                     var10 = var15;
                  } else {
                     var15 = var12 * (var11 & 127) / 128;
                     if(var15 < 2) {
                        var15 = 2;
                     } else if(var15 > 126) {
                        var15 = 126;
                     }

                     var10 = var15 + (var11 & 65408);
                  }

                  var7 = Graphics3D.colorPalette[var10] | -16777216;
               } else if(var9.color == 16711935) {
                  var7 = var8;
               } else {
                  var10 = Resampler.method2295(var9.hue, var9.saturation, var9.lightness);
                  var12 = 96;
                  if(var10 == -2) {
                     var11 = 12345678;
                  } else if(var10 == -1) {
                     if(var12 < 0) {
                        var12 = 0;
                     } else if(var12 > 127) {
                        var12 = 127;
                     }

                     var15 = 127 - var12;
                     var11 = var15;
                  } else {
                     var15 = var12 * (var10 & 127) / 128;
                     if(var15 < 2) {
                        var15 = 2;
                     } else if(var15 > 126) {
                        var15 = 126;
                     }

                     var11 = var15 + (var10 & 65408);
                  }

                  var7 = Graphics3D.colorPalette[var11] | -16777216;
               }
            }

            if(var3.field394[var5][var1][var2] == 0) {
               Rasterizer2D.Rasterizer2D_fillRectangle(this.field464 * var1, this.field464 * (63 - var2), this.field464, this.field464, var7);
            } else {
               var4.method699(this.field464 * var1, this.field464 * (63 - var2), 0, var7, this.field464, this.field464, var3.field394[var5][var1][var2], var3.field395[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II[Lao;I)Laa;",
      garbageValue = "-430539823"
   )
   class33 method418(int var1, int var2, WorldMapRegion[] var3) {
      class213 var5 = field458;
      long var6 = (long)(0 | var1 << 8 | var2);
      class33 var4 = (class33)var5.method3945(var6);
      class33 var11 = var4;
      if(var4 == null) {
         var11 = this.method404(var3);
         class213 var10 = field458;
         long var8 = (long)(0 | var1 << 8 | var2);
         var10.method3953(var11, var8);
      }

      return var11;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([Lao;I)Laa;",
      garbageValue = "-768703734"
   )
   class33 method404(WorldMapRegion[] var1) {
      class44 var2 = new class44(64, 64);
      if(this.field457 != null) {
         this.method406(0, 0, 64, 64, this.field457, var2);
      } else {
         Iterator var3 = this.field462.iterator();

         while(var3.hasNext()) {
            class46 var4 = (class46)var3.next();
            this.method406(var4.method687() * 8, var4.method679() * 8, 8, 8, var4, var2);
         }
      }

      this.method405(var1, var2);
      class33 var5 = new class33();
      var5.method377(var2);
      return var5;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([Lao;Lad;B)V",
      garbageValue = "0"
   )
   void method405(WorldMapRegion[] var1, class44 var2) {
      class254[] var3 = new class254[]{class254.field3312, class254.field3314, class254.field3313, class254.field3316, class254.field3320, class254.field3311, class254.field3318, class254.field3315};
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
            switch(var7.field3319) {
            case 0:
               var12 = 59;
               var13 = 59;
               var10 = 5;
               var11 = 5;
               break;
            case 1:
               var9 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 2:
               var9 = 59;
               var11 = 5;
               var12 = 59;
               var10 = 5;
               break;
            case 3:
               var13 = 59;
               var11 = 5;
               break;
            case 4:
               var8 = 59;
               var10 = 5;
               break;
            case 5:
               var9 = 59;
               var11 = 5;
               break;
            case 6:
               var13 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 7:
               var12 = 59;
               var10 = 5;
            }

            this.method407(var12, var13, var8, var9, var10, var11, var1[var7.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIILal;Lad;I)V",
      garbageValue = "1993208575"
   )
   void method406(int var1, int var2, int var3, int var4, class28 var5, class44 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field388[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = WidgetNode.getUnderlayDefinition(var9);
               var6.method650(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IIIIIILao;Lad;B)V",
      garbageValue = "-51"
   )
   void method407(int var1, int var2, int var3, int var4, int var5, int var6, WorldMapRegion var7, class44 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method428(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = WidgetNode.getUnderlayDefinition(var11);
               var8.method650(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IILal;Laa;B)I",
      garbageValue = "0"
   )
   int method408(int var1, int var2, class28 var3, class33 var4) {
      return var3.field388[0][var1][var2] == 0?this.field463:var4.method376(var1, var2);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IILal;[Llq;B)V",
      garbageValue = "4"
   )
   void method409(int var1, int var2, class28 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field391; ++var5) {
         WorldMapDecoration[] var6 = var3.decorations[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            WorldMapDecoration[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               WorldMapDecoration var9 = var7[var8];
               if(!GrandExchangeEvents.method86(var9.decoration)) {
                  int var11 = var9.decoration;
                  boolean var10 = var11 == WorldMapDecorationType.field2993.rsOrdinal;
                  if(!var10) {
                     continue;
                  }
               }

               ObjectComposition var12 = FileRequest.getObjectDefinition(var9.objectDefinitionId);
               if(var12.mapSceneId != -1) {
                  if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                     var4[var12.mapSceneId].method5844(this.field464 * var1, this.field464 * (63 - var2), this.field464 * 2, this.field464 * 2);
                  } else {
                     var4[var12.mapSceneId].method5844(this.field464 * var1, this.field464 * (63 - var2), this.field464 * 2 + 1, this.field464 * 2 + 1);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IILal;I)V",
      garbageValue = "-624507285"
   )
   void method410(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field391; ++var4) {
         WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            WorldMapDecoration[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               WorldMapDecoration var8 = var6[var7];
               if(class110.method2262(var8.decoration)) {
                  ObjectComposition var9 = FileRequest.getObjectDefinition(var8.objectDefinitionId);
                  int var10 = var9.int1 != 0?-3407872:-3355444;
                  if(var8.decoration == WorldMapDecorationType.field2982.rsOrdinal) {
                     this.method427(var1, var2, var8.rotation, var10);
                  }

                  if(var8.decoration == WorldMapDecorationType.field2975.rsOrdinal) {
                     this.method427(var1, var2, var8.rotation, -3355444);
                     this.method427(var1, var2, var8.rotation + 1, var10);
                  }

                  if(var8.decoration == WorldMapDecorationType.field2976.rsOrdinal) {
                     if(var8.rotation == 0) {
                        Rasterizer2D.method5756(this.field464 * var1, this.field464 * (63 - var2), 1, var10);
                     }

                     if(var8.rotation == 1) {
                        Rasterizer2D.method5756(this.field464 + this.field464 * var1 - 1, this.field464 * (63 - var2), 1, var10);
                     }

                     if(var8.rotation == 2) {
                        Rasterizer2D.method5756(this.field464 * var1 + this.field464 - 1, this.field464 * (63 - var2) + this.field464 - 1, 1, var10);
                     }

                     if(var8.rotation == 3) {
                        Rasterizer2D.method5756(this.field464 * var1, this.field464 * (63 - var2) + this.field464 - 1, 1, var10);
                     }
                  }

                  if(var8.decoration == WorldMapDecorationType.field2977.rsOrdinal) {
                     int var11 = var8.rotation % 2;
                     int var12;
                     if(var11 == 0) {
                        for(var12 = 0; var12 < this.field464; ++var12) {
                           Rasterizer2D.method5756(var12 + this.field464 * var1, (64 - var2) * this.field464 - 1 - var12, 1, var10);
                        }
                     } else {
                        for(var12 = 0; var12 < this.field464; ++var12) {
                           Rasterizer2D.method5756(var12 + this.field464 * var1, var12 + this.field464 * (63 - var2), 1, var10);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;IS)V",
      garbageValue = "256"
   )
   @Export("drawNonLinkMapIcons")
   void drawNonLinkMapIcons(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field466.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var9.worldX * var5 + (float)var1 - var6);
         int var11 = (int)((float)(var2 + var4) - (float)var9.worldY * var5 - var6);
         MapIcon var12 = (MapIcon)var8.getValue();
         if(var12 != null) {
            var12.screenX = var10;
            var12.screenY = var11;
            Area var13 = Area.mapAreaType[var12.areaId];
            if(!var3.contains(Integer.valueOf(var13.method4755()))) {
               this.method518(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "1424049642"
   )
   void method412(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field471.iterator();

      while(var4.hasNext()) {
         MapIcon var5 = (MapIcon)var4.next();
         Area var6 = Area.mapAreaType[var5.areaId];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4755()))) {
            this.method413(var6, var5.screenX, var5.screenY, var2, var3);
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lja;IIIIB)V",
      garbageValue = "-26"
   )
   void method413(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.getMapIcon(false);
      if(var6 != null) {
         var6.drawAt(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method5739(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method5739(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Law;IIFB)V",
      garbageValue = "3"
   )
   void method518(MapIcon var1, int var2, int var3, float var4) {
      Area var5 = Area.mapAreaType[var1.areaId];
      this.method419(var5, var2, var3);
      this.method437(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lja;IIB)V",
      garbageValue = "-85"
   )
   void method419(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.getMapIcon(false);
      if(var4 != null) {
         int var5 = this.method514(var4, var1.horizontalAlignment);
         int var6 = this.method421(var4, var1.verticalAlignment);
         var4.drawAt(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Law;Lja;IIFB)V",
      garbageValue = "38"
   )
   void method437(MapIcon var1, Area var2, int var3, int var4, float var5) {
      if(var1.field509 != null) {
         if(var1.field509.fontSize.method192(var5)) {
            Font var6 = (Font)this.mapFonts.get(var1.field509.fontSize);
            var6.method5525(var1.field509.text, var3 - var1.field509.field446 / 2, var4, var1.field509.field446, var1.field509.field452, -16777216 | var2.field3459, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "129011931"
   )
   @Export("drawMapLinks")
   void drawMapLinks(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field471.iterator();

      while(var6.hasNext()) {
         MapIcon var7 = (MapIcon)var6.next();
         int var8 = var7.field512.worldX % 64;
         int var9 = var7.field512.worldY % 64;
         var7.screenX = (int)((float)var8 * var5 + (float)var1);
         var7.screenY = (int)((float)(63 - var9) * var5 + (float)var2);
         if(!var3.contains(Integer.valueOf(var7.areaId))) {
            this.method518(var7, var7.screenX, var7.screenY, var5);
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2021721969"
   )
   void method442() {
      if(this.field457 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method475(var1, var2, this.field457);
            }
         }
      } else {
         Iterator var5 = this.field462.iterator();

         while(var5.hasNext()) {
            class46 var6 = (class46)var5.next();

            for(int var3 = var6.method687() * 8; var3 < var6.method687() * 8 + 8; ++var3) {
               for(int var4 = var6.method679() * 8; var4 < var6.method679() * 8 + 8; ++var4) {
                  this.method475(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IILal;I)V",
      garbageValue = "-2071079517"
   )
   void method475(int var1, int var2, class28 var3) {
      field468.set(0, var1, var2);

      for(int var4 = 0; var4 < var3.field391; ++var4) {
         WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            WorldMapDecoration[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               WorldMapDecoration var8 = var6[var7];
               Area var9 = this.method424(var8.objectDefinitionId);
               if(var9 != null) {
                  MapIcon var10 = (MapIcon)this.field466.get(field468);
                  if(var10 != null) {
                     if(var10.areaId != var9.id) {
                        MapIcon var16 = new MapIcon(var9.id, var10.field506, var10.field512, this.method509(var9));
                        this.field466.put(new Coordinates(field468), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field506.plane - var10.field512.plane;
                     var10.field512.plane = var4;
                     var10.field506.plane = var4 + var15;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field459 * 64 + var1, this.field456 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field457 != null) {
                     var12 = new Coordinates(this.field457.field392 + var4, this.field457.field390 * 64 + var1, var2 + this.field457.field387 * 64);
                  } else {
                     Iterator var13 = this.field462.iterator();

                     while(var13.hasNext()) {
                        class46 var14 = (class46)var13.next();
                        if(var14.method674(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field392, var14.field390 * 64 + var1 + var14.method676() * 8, var14.field387 * 64 + var2 + var14.method677() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new MapIcon(var9.id, var12, var11, this.method509(var9));
                     this.field466.put(new Coordinates(field468), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field466.remove(field468);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lla;Ljl;I)I",
      garbageValue = "1546347288"
   )
   int method514(SpritePixels var1, HorizontalAlignment var2) {
      switch(var2.value) {
      case 1:
         return -var1.width / 2;
      case 2:
         return 0;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Lla;Ljd;I)I",
      garbageValue = "1035471215"
   )
   int method421(SpritePixels var1, VerticalAlignment var2) {
      switch(var2.value) {
      case 0:
         return -var1.height / 2;
      case 2:
         return 0;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)Lja;",
      garbageValue = "1086239022"
   )
   Area method424(int var1) {
      ObjectComposition var2 = FileRequest.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.mapAreaType[var2.mapIconId]:null;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)Lah;",
      garbageValue = "-1254733264"
   )
   MapLabel method451(int var1) {
      Area var2 = Area.mapAreaType[var1];
      return this.method509(var2);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lja;I)Lah;",
      garbageValue = "505952158"
   )
   MapLabel method509(Area var1) {
      if(var1.name != null && this.mapFonts != null && this.mapFonts.get(Size.field347) != null) {
         Size var2 = Size.method199(var1.field3449);
         if(var2 == null) {
            return null;
         } else {
            Font var3 = (Font)this.mapFonts.get(var2);
            if(var3 == null) {
               return null;
            } else {
               int var4 = var3.method5519(var1.name, 1000000);
               String[] var5 = new String[var4];
               var3.method5517(var1.name, (int[])null, var5);
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
      signature = "(IIIIII)Ljava/util/List;",
      garbageValue = "-1174225388"
   )
   List method425(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field466.values().iterator();

            MapIcon var8;
            while(var7.hasNext()) {
               var8 = (MapIcon)var7.next();
               if(var8.method563(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field471.iterator();

            while(var7.hasNext()) {
               var8 = (MapIcon)var7.next();
               if(var8.method563(var4, var5)) {
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

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/List;",
      garbageValue = "-2012315534"
   )
   List method426() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field471);
      var1.addAll(this.field466.values());
      return var1;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1976692379"
   )
   void method427(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method5752(this.field464 * var1, this.field464 * (63 - var2), this.field464, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5756(this.field464 * var1, this.field464 * (63 - var2), this.field464, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5752(this.field464 * var1 + this.field464 - 1, this.field464 * (63 - var2), this.field464, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5756(this.field464 * var1, this.field464 * (63 - var2) + this.field464 - 1, this.field464, var4);
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "999262223"
   )
   int method428(int var1, int var2) {
      if(this.field457 != null) {
         return this.field457.method264(var1, var2);
      } else {
         if(!this.field462.isEmpty()) {
            Iterator var3 = this.field462.iterator();

            while(var3.hasNext()) {
               class46 var4 = (class46)var3.next();
               if(var4.method674(var1, var2)) {
                  return var4.method264(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIIIS)V",
      garbageValue = "-21276"
   )
   public static final void method422(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = Math.min(var3, Math.min(var4, var5)) - var6;
      int var8 = Math.max(var3, Math.max(var4, var5)) + var6;
      int var9 = Math.min(var0, Math.min(var1, var2)) - var6;
      int var10 = Math.max(var0, Math.max(var1, var2)) + var6;
      class254.method4525(var7, var9, var8, var10, -49088);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-33"
   )
   public static final boolean method519() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field615 == KeyFocusListener.field617) {
            return false;
         } else {
            Tile.currentPressedKey = KeyFocusListener.field612[KeyFocusListener.field615];
            BuildType.currentTypedKey = KeyFocusListener.field594[KeyFocusListener.field615];
            KeyFocusListener.field615 = KeyFocusListener.field615 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZB)[B",
      garbageValue = "113"
   )
   @Export("toByteArray")
   public static byte[] toByteArray(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?DecorativeObject.method3097(var3):var3;
      } else if(var0 instanceof AbstractByteBuffer) {
         AbstractByteBuffer var2 = (AbstractByteBuffer)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("kr")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-20"
   )
   static void method516() {
      if(Client.field1132 != null) {
         Client.field972 = Client.gameCycle;
         Client.field1132.method4710();

         for(int var0 = 0; var0 < Client.cachedPlayers.length; ++var0) {
            if(Client.cachedPlayers[var0] != null) {
               Client.field1132.method4709((Client.cachedPlayers[var0].x >> 7) + PacketNode.baseX, (Client.cachedPlayers[var0].y >> 7) + BaseVarType.baseY);
            }
         }
      }

   }
}
