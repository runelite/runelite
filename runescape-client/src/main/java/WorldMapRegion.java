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

@ObfuscatedName("av")
@Implements("WorldMapRegion")
public class WorldMapRegion {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("__av_o")
   public static DemotingHashTable __av_o;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1061363609
   )
   @Export("x")
   int x;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2099407363
   )
   @Export("y")
   int y;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lz;"
   )
   class15 field239;
   @ObfuscatedName("e")
   @Export("__e")
   LinkedList __e;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -120515153
   )
   @Export("__x")
   int __x;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 415972873
   )
   @Export("__d")
   int __d;
   @ObfuscatedName("k")
   @Export("iconsList")
   List iconsList;
   @ObfuscatedName("n")
   @Export("iconsMap")
   HashMap iconsMap;
   @ObfuscatedName("i")
   @Export("fonts")
   final HashMap fonts;

   static {
      __av_o = new DemotingHashTable(37748736, 256);
   }

   WorldMapRegion(int var1, int var2, int var3, HashMap var4) {
      this.x = var1;
      this.y = var2;
      this.__e = new LinkedList();
      this.iconsList = new LinkedList();
      this.iconsMap = new HashMap();
      this.__x = var3 | -16777216;
      this.fonts = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-87"
   )
   @Export("__w_40")
   void __w_40(int var1, int var2, int var3) {
      Sprite var4 = class13.method164(this.x, this.y, this.__d);
      if(var4 != null) {
         if(var3 == this.__d * 64) {
            var4.drawAt(var1, var2);
         } else {
            var4.__al_517(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lz;Ljava/util/List;I)V",
      garbageValue = "1704588050"
   )
   void method447(class15 var1, List var2) {
      this.iconsMap.clear();
      this.field239 = var1;
      this.__x_43(var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;B)V",
      garbageValue = "-47"
   )
   @Export("__u_41")
   void __u_41(HashSet var1, List var2) {
      this.iconsMap.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class39 var4 = (class39)var3.next();
         if(var4.method256() == this.x && var4.method264() == this.y) {
            this.__e.add(var4);
         }
      }

      this.__x_43(var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIILb;B)V",
      garbageValue = "115"
   )
   void method449(int var1, int var2, int var3, int var4, class21 var5) {
      this.iconsMap.clear();

      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label75:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            for(int var8 = 0; var8 < var5.field156; ++var8) {
               class25[] var9 = var5.field144[var8][var6][var7];
               if(var9 != null && var9.length != 0) {
                  class25[] var10 = var9;

                  for(int var11 = 0; var11 < var10.length; ++var11) {
                     ObjectDefinition var13;
                     boolean var14;
                     label66: {
                        class25 var12 = var10[var11];
                        var13 = class50.getObjectDefinition(var12.field199);
                        if(var13.transforms != null) {
                           int[] var15 = var13.transforms;

                           for(int var16 = 0; var16 < var15.length; ++var16) {
                              int var17 = var15[var16];
                              ObjectDefinition var18 = class50.getObjectDefinition(var17);
                              if(var18.mapIconId != -1) {
                                 var14 = true;
                                 break label66;
                              }
                           }
                        } else if(var13.mapIconId != -1) {
                           var14 = true;
                           break label66;
                        }

                        var14 = false;
                     }

                     if(var14) {
                        this.method479(var13, var8, var6, var7, var5);
                        continue label75;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljr;IIILb;I)V",
      garbageValue = "-896662600"
   )
   void method479(ObjectDefinition var1, int var2, int var3, int var4, class21 var5) {
      TileLocation var6 = new TileLocation(var2, var3 + this.x * 64, this.y * 64 + var4);
      TileLocation var7 = null;
      if(this.field239 != null) {
         var7 = new TileLocation(this.field239.field148 + var2, var3 + this.field239.field149 * 64, var4 + this.field239.field146 * 64);
      } else {
         class39 var8 = (class39)var5;
         var7 = new TileLocation(var2 + var8.field148, var3 + var8.field149 * 64 + var8.method717() * 8, var4 + var8.field146 * 64 + var8.method718() * 8);
      }

      Object var10;
      if(var1.transforms != null) {
         var10 = new WorldMapIcon2(var7, var6, var1.id, this);
      } else {
         WorldMapElement var9 = ViewportMouse.getWorldMapElement(var1.mapIconId);
         var10 = new WorldMapIcon1(var7, var6, var9.__o, this.__ab_56(var9));
      }

      this.iconsMap.put(new TileLocation(0, var3, var4), var10);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   @Export("__e_42")
   void __e_42() {
      Iterator var1 = this.iconsMap.values().iterator();

      while(var1.hasNext()) {
         AbstractWorldMapIcon var2 = (AbstractWorldMapIcon)var1.next();
         if(var2 instanceof WorldMapIcon2) {
            ((WorldMapIcon2)var2).__z_27();
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;I)V",
      garbageValue = "128876606"
   )
   @Export("__x_43")
   void __x_43(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         WorldMapIcon1 var3 = (WorldMapIcon1)var2.next();
         if(var3.coord2.x >> 6 == this.x && var3.coord2.y >> 6 == this.y) {
            WorldMapIcon1 var4 = new WorldMapIcon1(var3.coord2, var3.coord2, var3.__m, this.__al_55(var3.__m));
            this.iconsList.add(var4);
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1543354181"
   )
   @Export("__d_44")
   void __d_44() {
      if(this.field239 != null) {
         this.field239.method282();
      } else {
         Iterator var1 = this.__e.iterator();

         while(var1.hasNext()) {
            class39 var2 = (class39)var1.next();
            var2.method282();
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lir;B)Z",
      garbageValue = "2"
   )
   @Export("__a_45")
   boolean __a_45(AbstractIndexCache var1) {
      if(this.field239 != null) {
         this.field239.method263(var1);
         if(this.field239.method271()) {
            this.method449(0, 0, 64, 64, this.field239);
            return true;
         } else {
            return false;
         }
      } else {
         boolean var2 = true;

         Iterator var3;
         class39 var4;
         for(var3 = this.__e.iterator(); var3.hasNext(); var2 &= var4.method271()) {
            var4 = (class39)var3.next();
            var4.method263(var1);
         }

         if(var2) {
            var3 = this.__e.iterator();

            while(var3.hasNext()) {
               var4 = (class39)var3.next();
               this.method449(var4.method719() * 8, var4.method720() * 8, 8, 8, var4);
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILad;[Llq;Lir;Lir;I)V",
      garbageValue = "518389076"
   )
   void method455(int var1, class40 var2, IndexedSprite[] var3, AbstractIndexCache var4, AbstractIndexCache var5) {
      this.__d = var1;
      if(this.field239 != null || !this.__e.isEmpty()) {
         if(class13.method164(this.x, this.y, var1) == null) {
            boolean var6 = true;
            var6 &= this.__a_45(var4);
            int var8;
            if(this.field239 != null) {
               var8 = this.field239.field150;
            } else {
               var8 = ((class21)this.__e.getFirst()).field150;
            }

            var6 &= var5.tryLoadArchive(var8);
            if(var6) {
               byte[] var7 = var5.takeRecordFlat(var8);
               class27 var9 = SecureRandomCallable.method1145(var7);
               Sprite var10 = new Sprite(this.__d * 64, this.__d * 64);
               var10.setRaster();
               if(this.field239 != null) {
                  this.method546(var2, var3, var9);
               } else {
                  this.method459(var2, var3, var9);
               }

               int var11 = this.x;
               int var12 = this.y;
               int var13 = this.__d;
               __av_o.put(var10, MouseHandler.method1083(var11, var12, var13), var10.pixels.length * 4);
               this.__d_44();
            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "893970699"
   )
   @Export("__j_46")
   void __j_46(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.__aq_48(var1, var2, var4, var3);
      this.__ah_54(var1, var2, var4, var3);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;IIB)V",
      garbageValue = "-70"
   )
   @Export("__s_47")
   void __s_47(HashSet var1, int var2, int var3) {
      Iterator var4 = this.iconsMap.values().iterator();

      while(var4.hasNext()) {
         AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
         if(var5.__h_67()) {
            int var6 = var5.__m_15();
            if(var1.contains(Integer.valueOf(var6))) {
               WorldMapElement var7 = ViewportMouse.getWorldMapElement(var6);
               this.__av_50(var7, var5.__e, var5.__x, var2, var3);
            }
         }
      }

      this.__aj_49(var1, var2, var3);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lad;[Llq;Laq;B)V",
      garbageValue = "-1"
   )
   void method546(class40 var1, IndexedSprite[] var2, class27 var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method461(var4, var5, this.field239, var1, var3);
            this.method462(var4, var5, this.field239, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method460(var4, var5, this.field239, var1, var2);
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lad;[Llq;Laq;I)V",
      garbageValue = "752069098"
   )
   void method459(class40 var1, IndexedSprite[] var2, class27 var3) {
      Iterator var4 = this.__e.iterator();

      class39 var5;
      int var6;
      int var7;
      while(var4.hasNext()) {
         var5 = (class39)var4.next();

         for(var6 = var5.method719() * 8; var6 < var5.method719() * 8 + 8; ++var6) {
            for(var7 = var5.method720() * 8; var7 < var5.method720() * 8 + 8; ++var7) {
               this.method461(var6, var7, var5, var1, var3);
               this.method462(var6, var7, var5, var1);
            }
         }
      }

      var4 = this.__e.iterator();

      while(var4.hasNext()) {
         var5 = (class39)var4.next();

         for(var6 = var5.method719() * 8; var6 < var5.method719() * 8 + 8; ++var6) {
            for(var7 = var5.method720() * 8; var7 < var5.method720() * 8 + 8; ++var7) {
               this.method460(var6, var7, var5, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IILb;Lad;[Llq;I)V",
      garbageValue = "1304772019"
   )
   void method460(int var1, int var2, class21 var3, class40 var4, IndexedSprite[] var5) {
      this.method465(var1, var2, var3);
      this.method464(var1, var2, var3, var5);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IILb;Lad;Laq;I)V",
      garbageValue = "1006396037"
   )
   void method461(int var1, int var2, class21 var3, class40 var4, class27 var5) {
      int var6 = var3.field151[0][var1][var2] - 1;
      int var7 = var3.field145[0][var1][var2] - 1;
      if(var6 == -1 && var7 == -1) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.__d * var1, this.__d * (63 - var2), this.__d, this.__d, this.__x);
      }

      int var8 = 16711935;
      int var9;
      if(var7 != -1) {
         int var10 = this.__x;
         OverlayDefinition var12 = (OverlayDefinition)OverlayDefinition.__jf_f.get((long)var7);
         OverlayDefinition var11;
         if(var12 != null) {
            var11 = var12;
         } else {
            byte[] var13 = OverlayDefinition.__jf_m.takeRecord(4, var7);
            var12 = new OverlayDefinition();
            if(var13 != null) {
               var12.read(new Buffer(var13), var7);
            }

            var12.init();
            OverlayDefinition.__jf_f.put(var12, (long)var7);
            var11 = var12;
         }

         if(var11 == null) {
            var9 = var10;
         } else if(var11.rgb2 >= 0) {
            var9 = var11.rgb2 | -16777216;
         } else if(var11.texture >= 0) {
            int var21 = WorldMapArea.method427(Rasterizer3D.Rasterizer3D_textureLoader.__w_213(var11.texture), 96);
            var9 = Rasterizer3D.Rasterizer3D_colorPalette[var21] | -16777216;
         } else if(var11.rgb == 16711935) {
            var9 = var10;
         } else {
            int var14 = var11.hue;
            int var15 = var11.saturation;
            int var16 = var11.lightness;
            if(var16 > 179) {
               var15 /= 2;
            }

            if(var16 > 192) {
               var15 /= 2;
            }

            if(var16 > 217) {
               var15 /= 2;
            }

            if(var16 > 243) {
               var15 /= 2;
            }

            int var17 = (var15 / 32 << 7) + var16 / 2 + (var14 / 4 << 10);
            byte var19 = 96;
            int var18;
            if(var17 == -2) {
               var18 = 12345678;
            } else {
               int var22;
               if(var17 == -1) {
                  if(var19 < 0) {
                     var19 = 0;
                  } else if(var19 > 127) {
                     var19 = 127;
                  }

                  var22 = 127 - var19;
                  var18 = var22;
               } else {
                  var22 = var19 * (var17 & 127) / 128;
                  if(var22 < 2) {
                     var22 = 2;
                  } else if(var22 > 126) {
                     var22 = 126;
                  }

                  var18 = var22 + (var17 & 65408);
               }
            }

            var9 = Rasterizer3D.Rasterizer3D_colorPalette[var18] | -16777216;
         }

         var8 = var9;
      }

      if(var7 > -1 && var3.field154[0][var1][var2] == 0) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.__d * var1, this.__d * (63 - var2), this.__d, this.__d, var8);
      } else {
         var9 = this.method541(var1, var2, var3, var5);
         if(var7 == -1) {
            Rasterizer2D.Rasterizer2D_fillRectangle(this.__d * var1, this.__d * (63 - var2), this.__d, this.__d, var9);
         } else {
            var4.method743(this.__d * var1, this.__d * (63 - var2), var9, var8, this.__d, this.__d, var3.field154[0][var1][var2], var3.field155[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IILb;Lad;B)V",
      garbageValue = "9"
   )
   void method462(int var1, int var2, class21 var3, class40 var4) {
      for(int var5 = 1; var5 < var3.field156; ++var5) {
         int var6 = var3.field145[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var8 = this.__x;
            OverlayDefinition var10 = (OverlayDefinition)OverlayDefinition.__jf_f.get((long)var6);
            OverlayDefinition var9;
            if(var10 != null) {
               var9 = var10;
            } else {
               byte[] var11 = OverlayDefinition.__jf_m.takeRecord(4, var6);
               var10 = new OverlayDefinition();
               if(var11 != null) {
                  var10.read(new Buffer(var11), var6);
               }

               var10.init();
               OverlayDefinition.__jf_f.put(var10, (long)var6);
               var9 = var10;
            }

            int var7;
            if(var9 == null) {
               var7 = var8;
            } else if(var9.rgb2 >= 0) {
               var7 = var9.rgb2 | -16777216;
            } else if(var9.texture >= 0) {
               int var20 = WorldMapArea.method427(Rasterizer3D.Rasterizer3D_textureLoader.__w_213(var9.texture), 96);
               var7 = Rasterizer3D.Rasterizer3D_colorPalette[var20] | -16777216;
            } else if(var9.rgb == 16711935) {
               var7 = var8;
            } else {
               int var12 = var9.hue;
               int var13 = var9.saturation;
               int var14 = var9.lightness;
               if(var14 > 179) {
                  var13 /= 2;
               }

               if(var14 > 192) {
                  var13 /= 2;
               }

               if(var14 > 217) {
                  var13 /= 2;
               }

               if(var14 > 243) {
                  var13 /= 2;
               }

               int var15 = (var13 / 32 << 7) + var14 / 2 + (var12 / 4 << 10);
               byte var17 = 96;
               int var16;
               if(var15 == -2) {
                  var16 = 12345678;
               } else {
                  int var21;
                  if(var15 == -1) {
                     if(var17 < 0) {
                        var17 = 0;
                     } else if(var17 > 127) {
                        var17 = 127;
                     }

                     var21 = 127 - var17;
                     var16 = var21;
                  } else {
                     var21 = var17 * (var15 & 127) / 128;
                     if(var21 < 2) {
                        var21 = 2;
                     } else if(var21 > 126) {
                        var21 = 126;
                     }

                     var16 = var21 + (var15 & 65408);
                  }
               }

               var7 = Rasterizer3D.Rasterizer3D_colorPalette[var16] | -16777216;
            }

            if(var3.field154[var5][var1][var2] == 0) {
               Rasterizer2D.Rasterizer2D_fillRectangle(this.__d * var1, this.__d * (63 - var2), this.__d, this.__d, var7);
            } else {
               var4.method743(this.__d * var1, this.__d * (63 - var2), 0, var7, this.__d, this.__d, var3.field154[var5][var1][var2], var3.field155[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IILb;Laq;I)I",
      garbageValue = "1908333009"
   )
   int method541(int var1, int var2, class21 var3, class27 var4) {
      return var3.field151[0][var1][var2] == 0?this.__x:var4.method430(var1, var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IILb;[Llq;S)V",
      garbageValue = "-26219"
   )
   void method464(int var1, int var2, class21 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field156; ++var5) {
         class25[] var6 = var3.field144[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class25[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class25 var9 = var7[var8];
               if(WorldMapAreaData.method711(var9.field198) || class1.method19(var9.field198)) {
                  ObjectDefinition var10 = class50.getObjectDefinition(var9.field199);
                  if(var10.mapSceneId != -1) {
                     if(var10.mapSceneId != 46 && var10.mapSceneId != 52) {
                        var4[var10.mapSceneId].__o_497(this.__d * var1, this.__d * (63 - var2), this.__d * 2, this.__d * 2);
                     } else {
                        var4[var10.mapSceneId].__o_497(this.__d * var1, this.__d * (63 - var2), this.__d * 2 + 1, this.__d * 2 + 1);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IILb;B)V",
      garbageValue = "-31"
   )
   void method465(int var1, int var2, class21 var3) {
      for(int var4 = 0; var4 < var3.field156; ++var4) {
         class25[] var5 = var3.field144[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class25[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class25 var8 = var6[var7];
               int var10 = var8.field198;
               boolean var9 = var10 >= class231.field2805.field2820 && var10 <= class231.field2804.field2820 || var10 == class231.field2806.field2820;
               if(var9) {
                  ObjectDefinition var11 = class50.getObjectDefinition(var8.field199);
                  int var12 = var11.int1 != 0?-3407872:-3355444;
                  if(var8.field198 == class231.field2805.field2820) {
                     this.__ad_58(var1, var2, var8.field202, var12);
                  }

                  if(var8.field198 == class231.field2813.field2820) {
                     this.__ad_58(var1, var2, var8.field202, -3355444);
                     this.__ad_58(var1, var2, var8.field202 + 1, var12);
                  }

                  if(var8.field198 == class231.field2804.field2820) {
                     if(var8.field202 == 0) {
                        Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.__d * var1, this.__d * (63 - var2), 1, var12);
                     }

                     if(var8.field202 == 1) {
                        Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.__d * var1 + this.__d - 1, this.__d * (63 - var2), 1, var12);
                     }

                     if(var8.field202 == 2) {
                        Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.__d * var1 + this.__d - 1, this.__d * (63 - var2) + this.__d - 1, 1, var12);
                     }

                     if(var8.field202 == 3) {
                        Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.__d * var1, this.__d * (63 - var2) + this.__d - 1, 1, var12);
                     }
                  }

                  if(var8.field198 == class231.field2806.field2820) {
                     int var13 = var8.field202 % 2;
                     int var14;
                     if(var13 == 0) {
                        for(var14 = 0; var14 < this.__d; ++var14) {
                           Rasterizer2D.Rasterizer2D_drawHorizontalLine(var14 + this.__d * var1, (64 - var2) * this.__d - 1 - var14, 1, var12);
                        }
                     } else {
                        for(var14 = 0; var14 < this.__d; ++var14) {
                           Rasterizer2D.Rasterizer2D_drawHorizontalLine(var14 + this.__d * var1, var14 + this.__d * (63 - var2), 1, var12);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;IB)V",
      garbageValue = "0"
   )
   @Export("__aq_48")
   void __aq_48(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.iconsMap.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         TileLocation var9 = (TileLocation)var8.getKey();
         int var10 = (int)((float)var1 + var5 * (float)var9.x - var6);
         int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.y - var6);
         AbstractWorldMapIcon var12 = (AbstractWorldMapIcon)var8.getValue();
         if(var12 != null && var12.__h_67()) {
            var12.__e = var10;
            var12.__x = var11;
            WorldMapElement var13 = ViewportMouse.getWorldMapElement(var12.__m_15());
            if(!var3.contains(Integer.valueOf(var13.__g_410()))) {
               this.__ar_51(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "781854370"
   )
   @Export("__aj_49")
   void __aj_49(HashSet var1, int var2, int var3) {
      Iterator var4 = this.iconsList.iterator();

      while(var4.hasNext()) {
         AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
         if(var5.__h_67()) {
            WorldMapElement var6 = ViewportMouse.getWorldMapElement(var5.__m_15());
            if(var6 != null && var1.contains(Integer.valueOf(var6.__g_410()))) {
               this.__av_50(var6, var5.__e, var5.__x, var2, var3);
            }
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lic;IIIIB)V",
      garbageValue = "92"
   )
   @Export("__av_50")
   void __av_50(WorldMapElement var1, int var2, int var3, int var4, int var5) {
      Sprite var6 = var1.getSprite(false);
      if(var6 != null) {
         var6.drawAt2(var2 - var6.subWidth / 2, var3 - var6.subHeight / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.Rasterizer2D_drawCircleAlpha(var2, var3, 15, 16776960, 128);
            Rasterizer2D.Rasterizer2D_drawCircleAlpha(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lak;IIFI)V",
      garbageValue = "-1283733783"
   )
   @Export("__ar_51")
   void __ar_51(AbstractWorldMapIcon var1, int var2, int var3, float var4) {
      WorldMapElement var5 = ViewportMouse.getWorldMapElement(var1.__m_15());
      this.__ac_52(var5, var2, var3);
      this.__ay_53(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lic;III)V",
      garbageValue = "423173487"
   )
   @Export("__ac_52")
   void __ac_52(WorldMapElement var1, int var2, int var3) {
      Sprite var4 = var1.getSprite(false);
      if(var4 != null) {
         int var5 = this.method473(var4, var1.field3287);
         int var6 = this.method474(var4, var1.field3301);
         var4.drawAt2(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lak;Lic;IIFI)V",
      garbageValue = "-1237576843"
   )
   @Export("__ay_53")
   void __ay_53(AbstractWorldMapIcon var1, WorldMapElement var2, int var3, int var4, float var5) {
      WorldMapLabel var6 = var1.__f_16();
      if(var6 != null) {
         if(var6.size.__f_14(var5)) {
            Font var7 = (Font)this.fonts.get(var6.size);
            var7.drawLines(var6.text, var3 - var6.width / 2, var4, var6.width, var6.height, -16777216 | var2.__e, 0, 1, 0, var7.ascent / 2);
         }
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;IB)V",
      garbageValue = "-17"
   )
   @Export("__ah_54")
   void __ah_54(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.iconsList.iterator();

      while(var6.hasNext()) {
         AbstractWorldMapIcon var7 = (AbstractWorldMapIcon)var6.next();
         if(var7.__h_67()) {
            int var8 = var7.coord2.x % 64;
            int var9 = var7.coord2.y % 64;
            var7.__e = (int)((float)var8 * var5 + (float)var1);
            var7.__x = (int)(var5 * (float)(63 - var9) + (float)var2);
            if(!var3.contains(Integer.valueOf(var7.__m_15()))) {
               this.__ar_51(var7, var7.__e, var7.__x, var5);
            }
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lln;Lju;I)I",
      garbageValue = "1945325707"
   )
   int method473(Sprite var1, class266 var2) {
      switch(var2.field3528) {
      case 0:
         return -var1.subWidth / 2;
      case 2:
         return 0;
      default:
         return -var1.subWidth;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Lln;Lip;I)I",
      garbageValue = "1788772278"
   )
   int method474(Sprite var1, class249 var2) {
      switch(var2.field3275) {
      case 0:
         return 0;
      case 1:
         return -var1.subHeight / 2;
      default:
         return -var1.subHeight;
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(II)Laj;",
      garbageValue = "598030754"
   )
   @Export("__al_55")
   WorldMapLabel __al_55(int var1) {
      WorldMapElement var2 = ViewportMouse.getWorldMapElement(var1);
      return this.__ab_56(var2);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Lic;B)Laj;",
      garbageValue = "59"
   )
   @Export("__ab_56")
   WorldMapLabel __ab_56(WorldMapElement var1) {
      if(var1.__l != null && this.fonts != null && this.fonts.get(WorldMapLabelSize.WorldMapLabelSize_small) != null) {
         WorldMapLabelSize var2 = WorldMapLabelSize.method195(var1.textSize);
         if(var2 == null) {
            return null;
         } else {
            Font var3 = (Font)this.fonts.get(var2);
            if(var3 == null) {
               return null;
            } else {
               int var4 = var3.lineCount(var1.__l, 1000000);
               String[] var5 = new String[var4];
               var3.breakLines(var1.__l, (int[])null, var5);
               int var6 = var5.length * var3.ascent / 2;
               int var7 = 0;
               String[] var8 = var5;

               for(int var9 = 0; var9 < var8.length; ++var9) {
                  String var10 = var8[var9];
                  int var11 = var3.stringWidth(var10);
                  if(var11 > var7) {
                     var7 = var11;
                  }
               }

               return new WorldMapLabel(var1.__l, var7, var6, var2);
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIIIII)Ljava/util/List;",
      garbageValue = "-1237576843"
   )
   @Export("__ae_57")
   List __ae_57(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.iconsMap.values().iterator();

            AbstractWorldMapIcon var8;
            while(var7.hasNext()) {
               var8 = (AbstractWorldMapIcon)var7.next();
               if(var8.__h_67() && var8.__y_66(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.iconsList.iterator();

            while(var7.hasNext()) {
               var8 = (AbstractWorldMapIcon)var7.next();
               if(var8.__h_67() && var8.__y_66(var4, var5)) {
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
      garbageValue = "722163590"
   )
   @Export("icons")
   List icons() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.iconsList);
      var1.addAll(this.iconsMap.values());
      return var1;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1516512827"
   )
   @Export("__ad_58")
   void __ad_58(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.Rasterizer2D_drawVerticalLine(this.__d * var1, this.__d * (63 - var2), this.__d, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.__d * var1, this.__d * (63 - var2), this.__d, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.Rasterizer2D_drawVerticalLine(this.__d * var1 + this.__d - 1, this.__d * (63 - var2), this.__d, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.__d * var1, this.__d * (63 - var2) + this.__d - 1, this.__d, var4);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1836178572"
   )
   public static int method568(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1877870965"
   )
   public static int method550(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(Lho;IIS)V",
      garbageValue = "597"
   )
   static final void method567(Widget var0, int var1, int var2) {
      if(Client.minimapState == 0 || Client.minimapState == 3) {
         if(!Client.isMenuOpen && (MouseHandler.MouseHandler_lastButton == 1 || !AbstractRasterProvider.__lp_ca && MouseHandler.MouseHandler_lastButton == 4)) {
            SpriteMask var3 = var0.getSpriteMask(true);
            if(var3 == null) {
               return;
            }

            int var4 = MouseHandler.MouseHandler_lastPressedX - var1;
            int var5 = MouseHandler.MouseHandler_lastPressedY - var2;
            if(var3.contains(var4, var5)) {
               var4 -= var3.width / 2;
               var5 -= var3.height / 2;
               int var6 = Client.minimapOrientation & 2047;
               int var7 = Rasterizer3D.Rasterizer3D_sine[var6];
               int var8 = Rasterizer3D.Rasterizer3D_cosine[var6];
               int var9 = var4 * var8 + var7 * var5 >> 11;
               int var10 = var5 * var8 - var4 * var7 >> 11;
               int var11 = var9 + Canvas.localPlayer.x >> 7;
               int var12 = Canvas.localPlayer.y - var10 >> 7;
               PacketBufferNode var13 = Interpreter.method1915(ClientPacket.__gs_ba, Client.packetWriter.isaacCipher);
               var13.packetBuffer.writeByte(18);
               var13.packetBuffer.__bo_322(var12 + GraphicsObject.baseY);
               var13.packetBuffer.__bo_322(var11 + class50.baseX);
               var13.packetBuffer.__af_314(KeyHandler.KeyHandler_pressedKeys[82]?(KeyHandler.KeyHandler_pressedKeys[81]?2:1):0);
               var13.packetBuffer.writeByte(var4);
               var13.packetBuffer.writeByte(var5);
               var13.packetBuffer.writeShort(Client.minimapOrientation);
               var13.packetBuffer.writeByte(57);
               var13.packetBuffer.writeByte(0);
               var13.packetBuffer.writeByte(0);
               var13.packetBuffer.writeByte(89);
               var13.packetBuffer.writeShort(Canvas.localPlayer.x);
               var13.packetBuffer.writeShort(Canvas.localPlayer.y);
               var13.packetBuffer.writeByte(63);
               Client.packetWriter.__q_167(var13);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "([Lho;IIIZS)V",
      garbageValue = "3640"
   )
   @Export("notRevalidateWidgetScroll")
   static void notRevalidateWidgetScroll(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            WorldMapSection3.alignWidgetSize(var6, var2, var3, var4);
            OverlayDefinition.alignWidgetPosition(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class39.revalidateWidgetScroll(var0, var6, var4);
            }
         }
      }

   }
}
