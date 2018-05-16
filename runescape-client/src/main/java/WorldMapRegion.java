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

@ObfuscatedName("r")
@Implements("WorldMapRegion")
public class WorldMapRegion {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   static class201 field203;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   static class201 field204;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   static final Coordinates field200;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -404288525
   )
   int field205;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -805234063
   )
   int field206;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ll;"
   )
   class10 field215;
   @ObfuscatedName("d")
   LinkedList field208;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -930941141
   )
   int field209;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 859680997
   )
   @Export("pixelsPerTile")
   int pixelsPerTile;
   @ObfuscatedName("g")
   List field211;
   @ObfuscatedName("y")
   HashMap field207;
   @ObfuscatedName("c")
   @Export("mapFonts")
   final HashMap mapFonts;

   static {
      field203 = new class201(37748736, 256);
      field204 = new class201(256, 256);
      field200 = new Coordinates();
   }

   WorldMapRegion(int var1, int var2, int var3, HashMap var4) {
      this.field205 = var1;
      this.field206 = var2;
      this.field208 = new LinkedList();
      this.field211 = new LinkedList();
      this.field207 = new HashMap();
      this.field209 = var3 | -16777216;
      this.mapFonts = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-381035337"
   )
   void method418(int var1, int var2, int var3) {
      SpritePixels var4 = class35.method684(this.field205, this.field206, this.pixelsPerTile);
      if(var4 != null) {
         if(var3 == this.pixelsPerTile * 64) {
            var4.method5893(var1, var2);
         } else {
            var4.method5884(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ll;Ljava/util/List;B)V",
      garbageValue = "102"
   )
   void method310(class10 var1, List var2) {
      this.field207.clear();
      this.field215 = var1;
      this.method312(0, 0, 64, 64, this.field215);
      this.method313(var2);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
      garbageValue = "1806641542"
   )
   void method378(HashSet var1, List var2) {
      this.field207.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class34 var4 = (class34)var3.next();
         if(var4.method182() == this.field205 && var4.method170() == this.field206) {
            this.field208.add(var4);
            this.method312(var4.method614() * 8, var4.method615() * 8, 8, 8, var4);
         }
      }

      this.method313(var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIILc;I)V",
      garbageValue = "-95484334"
   )
   void method312(int var1, int var2, int var3, int var4, class16 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label56:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field134; ++var9) {
               WorldMapDecoration[] var10 = var5.decorations[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  WorldMapDecoration[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     WorldMapDecoration var13 = var11[var12];
                     Area var14 = this.method351(var13.objectDefinitionId);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field205 * 64 + var6, this.field206 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field215 != null) {
                           var16 = new Coordinates(this.field215.field133 + var9, var6 + this.field215.field131 * 64, var7 + this.field215.field135 * 64);
                        } else {
                           class34 var17 = (class34)var5;
                           var16 = new Coordinates(var9 + var17.field133, var6 + var17.field131 * 64 + var17.method609() * 8, var17.field135 * 64 + var7 + var17.method617() * 8);
                        }

                        MapIcon var18 = new MapIcon(var14.id, var16, var15, this.createMapLabel(var14));
                        this.field207.put(var8, var18);
                        continue label56;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;I)V",
      garbageValue = "-1986485445"
   )
   void method313(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class13 var3 = (class13)var2.next();
         if(var3.field100.worldX >> 6 == this.field205 && var3.field100.worldY >> 6 == this.field206) {
            MapIcon var4 = new MapIcon(var3.field103, var3.field100, var3.field100, this.method453(var3.field103));
            this.field211.add(var4);
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILah;[Lr;[Llh;B)V",
      garbageValue = "6"
   )
   void method314(int var1, class35 var2, WorldMapRegion[] var3, IndexedSprite[] var4) {
      this.pixelsPerTile = var1;
      if(this.field215 != null || !this.field208.isEmpty()) {
         int var6 = this.field205;
         int var7 = this.field206;
         SpritePixels var5 = (SpritePixels)field203.method4033(class120.method2812(var6, var7, var1));
         if(var5 == null) {
            class21 var8 = this.method324(this.field205, this.field206, var3);
            SpritePixels var9 = new SpritePixels(this.pixelsPerTile * 64, this.pixelsPerTile * 64);
            var9.setRaster();
            if(this.field215 != null) {
               this.method308(var2, var3, var4, var8);
            } else {
               this.method447(var2, var4, var8);
            }

            int var10 = this.field205;
            int var11 = this.field206;
            int var12 = this.pixelsPerTile;
            field203.method4034(var9, class120.method2812(var10, var11, var12), var9.pixels.length * 4);
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;B)V",
      garbageValue = "91"
   )
   void method315(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.drawNonLinkMapIcons(var1, var2, var4, var3);
      this.drawMapLinks(var1, var2, var4, var3);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-502947431"
   )
   @Export("drawFlashingMapIcons")
   void drawFlashingMapIcons(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field207.values().iterator();

      while(var4.hasNext()) {
         MapIcon var5 = (MapIcon)var4.next();
         if(var1.contains(Integer.valueOf(var5.areaId))) {
            Area var6 = Area.mapAreaType[var5.areaId];
            this.method332(var6, var5.screenX, var5.screenY, var2, var3);
         }
      }

      this.method331(var1, var2, var3);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lah;[Lr;[Llh;Lz;I)V",
      garbageValue = "-2047175384"
   )
   void method308(class35 var1, WorldMapRegion[] var2, IndexedSprite[] var3, class21 var4) {
      int var5;
      int var6;
      for(var5 = 0; var5 < 64; ++var5) {
         for(var6 = 0; var6 < 64; ++var6) {
            this.method320(var5, var6, this.field215, var1, var4);
            this.method321(var5, var6, this.field215, var1);
         }
      }

      for(var5 = 0; var5 < 64; ++var5) {
         for(var6 = 0; var6 < 64; ++var6) {
            this.method311(var5, var6, this.field215, var1, var3);
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lah;[Llh;Lz;I)V",
      garbageValue = "1626073718"
   )
   void method447(class35 var1, IndexedSprite[] var2, class21 var3) {
      Iterator var4 = this.field208.iterator();

      class34 var5;
      int var6;
      int var7;
      while(var4.hasNext()) {
         var5 = (class34)var4.next();

         for(var6 = var5.method614() * 8; var6 < var5.method614() * 8 + 8; ++var6) {
            for(var7 = var5.method615() * 8; var7 < var5.method615() * 8 + 8; ++var7) {
               this.method320(var6, var7, var5, var1, var3);
               this.method321(var6, var7, var5, var1);
            }
         }
      }

      var4 = this.field208.iterator();

      while(var4.hasNext()) {
         var5 = (class34)var4.next();

         for(var6 = var5.method614() * 8; var6 < var5.method614() * 8 + 8; ++var6) {
            for(var7 = var5.method615() * 8; var7 < var5.method615() * 8 + 8; ++var7) {
               this.method311(var6, var7, var5, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IILc;Lah;[Llh;I)V",
      garbageValue = "-647064845"
   )
   void method311(int var1, int var2, class16 var3, class35 var4, IndexedSprite[] var5) {
      this.method329(var1, var2, var3);
      this.method328(var1, var2, var3, var5);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IILc;Lah;Lz;I)V",
      garbageValue = "-896122621"
   )
   void method320(int var1, int var2, class16 var3, class35 var4, class21 var5) {
      int var6 = var3.field129[0][var1][var2] - 1;
      int var7 = var3.field130[0][var1][var2] - 1;
      if(var6 == -1 && var7 == -1) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, this.field209);
      }

      int var8 = 16711935;
      if(var7 != -1) {
         var8 = Size.method122(var7, this.field209);
      }

      if(var7 > -1 && var3.field137[0][var1][var2] == 0) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var8);
      } else {
         int var9 = this.method327(var1, var2, var3, var5);
         if(var7 == -1) {
            Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var9);
         } else {
            var4.method637(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), var9, var8, this.pixelsPerTile, this.pixelsPerTile, var3.field137[0][var1][var2], var3.field138[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IILc;Lah;S)V",
      garbageValue = "8919"
   )
   void method321(int var1, int var2, class16 var3, class35 var4) {
      for(int var5 = 1; var5 < var3.field134; ++var5) {
         int var6 = var3.field130[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = Size.method122(var6, this.field209);
            if(var3.field137[var5][var1][var2] == 0) {
               Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var7);
            } else {
               var4.method637(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 0, var7, this.pixelsPerTile, this.pixelsPerTile, var3.field137[var5][var1][var2], var3.field138[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II[Lr;I)Lz;",
      garbageValue = "-1316524303"
   )
   class21 method324(int var1, int var2, WorldMapRegion[] worldMapRegions) {
      class21 var4 = (class21)field204.method4033(class120.method2812(var1, var2, 0));
      class21 var5 = var4;
      if(var4 == null) {
         var5 = this.method454(worldMapRegions);
         class35.method665(var5, var1, var2);
      }

      return var5;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([Lr;I)Lz;",
      garbageValue = "1643924475"
   )
   class21 method454(WorldMapRegion[] var1) {
      class32 var2 = new class32(64, 64);
      if(this.field215 != null) {
         this.method435(0, 0, 64, 64, this.field215, var2);
      } else {
         Iterator var3 = this.field208.iterator();

         while(var3.hasNext()) {
            class34 var4 = (class34)var3.next();
            this.method435(var4.method614() * 8, var4.method615() * 8, 8, 8, var4, var2);
         }
      }

      this.method322(var1, var2);
      class21 var5 = new class21();
      var5.method296(var2);
      return var5;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([Lr;Las;I)V",
      garbageValue = "298183410"
   )
   void method322(WorldMapRegion[] var1, class32 var2) {
      class240[] var3 = new class240[]{class240.field3123, class240.field3127, class240.field3128, class240.field3121, class240.field3122, class240.field3120, class240.field3125, class240.field3124};
      class240[] var5 = var3;

      for(int var6 = 0; var6 < var5.length; ++var6) {
         class240 var7 = var5[var6];
         if(var1[var7.rsOrdinal()] != null) {
            byte var8 = 0;
            byte var9 = 0;
            byte var10 = 64;
            byte var11 = 64;
            byte var12 = 0;
            byte var13 = 0;
            switch(var7.field3126) {
            case 0:
               var9 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 1:
               var9 = 59;
               var11 = 5;
               var12 = 59;
               var10 = 5;
               break;
            case 2:
               var13 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 3:
               var8 = 59;
               var10 = 5;
               break;
            case 4:
               var9 = 59;
               var11 = 5;
               break;
            case 5:
               var12 = 59;
               var13 = 59;
               var10 = 5;
               var11 = 5;
               break;
            case 6:
               var13 = 59;
               var11 = 5;
               break;
            case 7:
               var12 = 59;
               var10 = 5;
            }

            this.method326(var12, var13, var8, var9, var10, var11, var1[var7.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IIIILc;Las;S)V",
      garbageValue = "-2865"
   )
   void method435(int var1, int var2, int var3, int var4, class16 var5, class32 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field129[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = UrlRequester.getUnderlayDefinition(var9);
               var6.method587(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIIIILr;Las;B)V",
      garbageValue = "-74"
   )
   void method326(int var1, int var2, int var3, int var4, int var5, int var6, WorldMapRegion var7, class32 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method333(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = UrlRequester.getUnderlayDefinition(var11);
               var8.method587(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IILc;Lz;B)I",
      garbageValue = "21"
   )
   int method327(int var1, int var2, class16 var3, class21 var4) {
      return var3.field129[0][var1][var2] == 0?this.field209:var4.method305(var1, var2);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IILc;[Llh;I)V",
      garbageValue = "-773093225"
   )
   void method328(int var1, int var2, class16 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field134; ++var5) {
         WorldMapDecoration[] var6 = var3.decorations[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            WorldMapDecoration[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               WorldMapDecoration var9 = var7[var8];
               if(class222.method4445(var9.decoration) || class139.method3167(var9.decoration)) {
                  ObjectComposition var10 = SoundTaskDataProvider.getObjectDefinition(var9.objectDefinitionId);
                  if(var10.mapSceneId != -1) {
                     if(var10.mapSceneId != 46 && var10.mapSceneId != 52) {
                        var4[var10.mapSceneId].method5867(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2, this.pixelsPerTile * 2);
                     } else {
                        var4[var10.mapSceneId].method5867(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2 + 1, this.pixelsPerTile * 2 + 1);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IILc;I)V",
      garbageValue = "-651126195"
   )
   void method329(int var1, int var2, class16 var3) {
      for(int var4 = 0; var4 < var3.field134; ++var4) {
         WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            WorldMapDecoration[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               WorldMapDecoration var8 = var6[var7];
               int var10 = var8.decoration;
               boolean var9 = var10 >= WorldMapDecorationType.field2791.rsOrdinal && var10 <= WorldMapDecorationType.field2775.rsOrdinal || var10 == WorldMapDecorationType.field2776.rsOrdinal;
               if(var9) {
                  ObjectComposition var11 = SoundTaskDataProvider.getObjectDefinition(var8.objectDefinitionId);
                  int var12 = var11.int1 != 0?-3407872:-3355444;
                  if(var8.decoration == WorldMapDecorationType.field2791.rsOrdinal) {
                     this.method346(var1, var2, var8.rotation, var12);
                  }

                  if(var8.decoration == WorldMapDecorationType.field2774.rsOrdinal) {
                     this.method346(var1, var2, var8.rotation, -3355444);
                     this.method346(var1, var2, var8.rotation + 1, var12);
                  }

                  if(var8.decoration == WorldMapDecorationType.field2775.rsOrdinal) {
                     if(var8.rotation == 0) {
                        Rasterizer2D.method5780(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 1, var12);
                     }

                     if(var8.rotation == 1) {
                        Rasterizer2D.method5780(this.pixelsPerTile + this.pixelsPerTile * var1 - 1, this.pixelsPerTile * (63 - var2), 1, var12);
                     }

                     if(var8.rotation == 2) {
                        Rasterizer2D.method5780(this.pixelsPerTile * var1 + this.pixelsPerTile - 1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, 1, var12);
                     }

                     if(var8.rotation == 3) {
                        Rasterizer2D.method5780(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, 1, var12);
                     }
                  }

                  if(var8.decoration == WorldMapDecorationType.field2776.rsOrdinal) {
                     int var13 = var8.rotation % 2;
                     int var14;
                     if(var13 == 0) {
                        for(var14 = 0; var14 < this.pixelsPerTile; ++var14) {
                           Rasterizer2D.method5780(var14 + this.pixelsPerTile * var1, (64 - var2) * this.pixelsPerTile - 1 - var14, 1, var12);
                        }
                     } else {
                        for(var14 = 0; var14 < this.pixelsPerTile; ++var14) {
                           Rasterizer2D.method5780(var14 + this.pixelsPerTile * var1, var14 + this.pixelsPerTile * (63 - var2), 1, var12);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;IB)V",
      garbageValue = "57"
   )
   @Export("drawNonLinkMapIcons")
   void drawNonLinkMapIcons(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field207.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)(var5 * (float)var9.worldX + (float)var1 - var6);
         int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.worldY - var6);
         MapIcon var12 = (MapIcon)var8.getValue();
         if(var12 != null) {
            var12.screenX = var10;
            var12.screenY = var11;
            Area var13 = Area.mapAreaType[var12.areaId];
            if(!var3.contains(Integer.valueOf(var13.method4831()))) {
               this.method361(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-1766895347"
   )
   void method331(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field211.iterator();

      while(var4.hasNext()) {
         MapIcon var5 = (MapIcon)var4.next();
         Area var6 = Area.mapAreaType[var5.areaId];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4831()))) {
            this.method332(var6, var5.screenX, var5.screenY, var2, var3);
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Lin;IIIII)V",
      garbageValue = "-2011725975"
   )
   void method332(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.getMapIcon(false);
      if(var6 != null) {
         var6.drawAt(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method5818(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method5818(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lad;IIFI)V",
      garbageValue = "319451758"
   )
   void method361(MapIcon var1, int var2, int var3, float var4) {
      Area var5 = Area.mapAreaType[var1.areaId];
      this.method334(var5, var2, var3);
      this.method335(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lin;IIB)V",
      garbageValue = "1"
   )
   void method334(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.getMapIcon(false);
      if(var4 != null) {
         int var5 = this.method370(var4, var1.horizontalAlignment);
         int var6 = this.method405(var4, var1.verticalAlignment);
         var4.drawAt(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lad;Lin;IIFI)V",
      garbageValue = "2050284039"
   )
   void method335(MapIcon mapIcon, Area var2, int var3, int var4, float var5) {
      if(mapIcon.field255 != null) {
         if(mapIcon.field255.fontSize.method121(var5)) {
            Font var6 = (Font)this.mapFonts.get(mapIcon.field255.fontSize);
            var6.method5595(mapIcon.field255.text, var3 - mapIcon.field255.field192 / 2, var4, mapIcon.field255.field192, mapIcon.field255.field193, -16777216 | var2.field3263, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;IB)V",
      garbageValue = "-13"
   )
   @Export("drawMapLinks")
   void drawMapLinks(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field211.iterator();

      while(var6.hasNext()) {
         MapIcon var7 = (MapIcon)var6.next();
         int var8 = var7.field247.worldX % 64;
         int var9 = var7.field247.worldY % 64;
         var7.screenX = (int)((float)var8 * var5 + (float)var1);
         var7.screenY = (int)((float)(63 - var9) * var5 + (float)var2);
         if(!var3.contains(Integer.valueOf(var7.areaId))) {
            this.method361(var7, var7.screenX, var7.screenY, var5);
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1192063999"
   )
   void method337() {
      if(this.field215 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method338(var1, var2, this.field215);
            }
         }
      } else {
         Iterator var5 = this.field208.iterator();

         while(var5.hasNext()) {
            class34 var6 = (class34)var5.next();

            for(int var3 = var6.method614() * 8; var3 < var6.method614() * 8 + 8; ++var3) {
               for(int var4 = var6.method615() * 8; var4 < var6.method615() * 8 + 8; ++var4) {
                  this.method338(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IILc;I)V",
      garbageValue = "2014623481"
   )
   void method338(int var1, int var2, class16 var3) {
      field200.set(0, var1, var2);

      for(int var4 = 0; var4 < var3.field134; ++var4) {
         WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            WorldMapDecoration[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               WorldMapDecoration var8 = var6[var7];
               Area var9 = this.method351(var8.objectDefinitionId);
               if(var9 != null) {
                  MapIcon var10 = (MapIcon)this.field207.get(field200);
                  if(var10 != null) {
                     if(var10.areaId != var9.id) {
                        MapIcon var16 = new MapIcon(var9.id, var10.field253, var10.field247, this.createMapLabel(var9));
                        this.field207.put(new Coordinates(field200), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field253.plane - var10.field247.plane;
                     var10.field247.plane = var4;
                     var10.field253.plane = var4 + var15;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field205 * 64 + var1, this.field206 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field215 != null) {
                     var12 = new Coordinates(this.field215.field133 + var4, this.field215.field131 * 64 + var1, var2 + this.field215.field135 * 64);
                  } else {
                     Iterator var13 = this.field208.iterator();

                     while(var13.hasNext()) {
                        class34 var14 = (class34)var13.next();
                        if(var14.method610(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field133, var1 + var14.field131 * 64 + var14.method609() * 8, var14.field135 * 64 + var2 + var14.method617() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new MapIcon(var9.id, var12, var11, this.createMapLabel(var9));
                     this.field207.put(new Coordinates(field200), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field207.remove(field200);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Llc;Lja;I)I",
      garbageValue = "-354996341"
   )
   int method370(SpritePixels var1, HorizontalAlignment var2) {
      switch(var2.value) {
      case 0:
         return -var1.width / 2;
      case 2:
         return 0;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Llc;Lis;I)I",
      garbageValue = "1469360749"
   )
   int method405(SpritePixels var1, VerticalAlignment var2) {
      switch(var2.value) {
      case 1:
         return -var1.height / 2;
      case 2:
         return 0;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IS)Lin;",
      garbageValue = "16384"
   )
   Area method351(int var1) {
      ObjectComposition var2 = SoundTaskDataProvider.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.mapAreaType[var2.mapIconId]:null;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IB)Lk;",
      garbageValue = "31"
   )
   MapLabel method453(int var1) {
      Area var2 = Area.mapAreaType[var1];
      return this.createMapLabel(var2);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lin;I)Lk;",
      garbageValue = "1961022215"
   )
   @Export("createMapLabel")
   MapLabel createMapLabel(Area area) {
      if(area.name != null && this.mapFonts != null && this.mapFonts.get(Size.field93) != null) {
         Size var2 = Size.method117(area.field3276);
         if(var2 == null) {
            return null;
         } else {
            Font var3 = (Font)this.mapFonts.get(var2);
            if(var3 == null) {
               return null;
            } else {
               int var4 = var3.method5539(area.name, 1000000);
               String[] var5 = new String[var4];
               var3.method5537(area.name, (int[])null, var5);
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

               return new MapLabel(area.name, var7, var6, var2);
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IIIIII)Ljava/util/List;",
      garbageValue = "-1540513372"
   )
   List method344(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field207.values().iterator();

            MapIcon var8;
            while(var7.hasNext()) {
               var8 = (MapIcon)var7.next();
               if(var8.method504(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field211.iterator();

            while(var7.hasNext()) {
               var8 = (MapIcon)var7.next();
               if(var8.method504(var4, var5)) {
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

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(B)Ljava/util/List;",
      garbageValue = "9"
   )
   List method449() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field211);
      var1.addAll(this.field207.values());
      return var1;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1898100415"
   )
   void method346(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method5842(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5780(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5842(this.pixelsPerTile * var1 + this.pixelsPerTile - 1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5780(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, this.pixelsPerTile, var4);
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "848619032"
   )
   int method333(int var1, int var2) {
      if(this.field215 != null) {
         return this.field215.method168(var1, var2);
      } else {
         if(!this.field208.isEmpty()) {
            Iterator var3 = this.field208.iterator();

            while(var3.hasNext()) {
               class34 var4 = (class34)var3.next();
               if(var4.method610(var1, var2)) {
                  return var4.method168(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(Lbd;III)V",
      garbageValue = "65535"
   )
   static final void method455(ContextMenuRow var0, int var1, int var2) {
      FileOnDisk.menuAction(var0.param0, var0.param1, var0.type, var0.identifier, var0.option, var0.option, var1, var2);
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "72"
   )
   static void method456() {
      if(Client.spellSelected) {
         Widget var0 = class21.getWidgetChild(class142.field1911, Client.field748);
         if(var0 != null && var0.onTargetLeaveListener != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.source = var0;
            var1.params = var0.onTargetLeaveListener;
            FriendManager.method1728(var1);
         }

         Client.spellSelected = false;
         DState.method3548(var0);
      }
   }
}
