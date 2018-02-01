import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class34 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static final Coordinates field456;
   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   @Export("loginType")
   static JagexLoginType loginType;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1364360519
   )
   int field445;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1923616111
   )
   int field446;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   class22 field447;
   @ObfuscatedName("t")
   LinkedList field448;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1803955283
   )
   int field450;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1853397877
   )
   int field457;
   @ObfuscatedName("h")
   int[][] field454;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   SpritePixels field452;
   @ObfuscatedName("x")
   List field453;
   @ObfuscatedName("q")
   HashMap field443;
   @ObfuscatedName("v")
   final HashMap field455;

   static {
      field456 = new Coordinates();
   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field445 = var1;
      this.field446 = var2;
      this.field448 = new LinkedList();
      this.field453 = new LinkedList();
      this.field443 = new HashMap();
      this.field450 = var3 | -16777216;
      this.field455 = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1017548420"
   )
   void method366(int var1, int var2, int var3) {
      if(this.field452 != null) {
         if(var3 == this.field457 * 64) {
            this.field452.method5534(var1, var2);
         } else {
            this.field452.method5551(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lg;Ljava/util/List;S)V",
      garbageValue = "16619"
   )
   void method367(class22 var1, List var2) {
      this.field443.clear();
      this.field447 = var1;
      this.method369(0, 0, 64, 64, this.field447);
      this.method370(var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
      garbageValue = "1939571953"
   )
   void method368(HashSet var1, List var2) {
      this.field443.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method237() == this.field445 && var4.method233() == this.field446) {
            this.field448.add(var4);
            this.method369(var4.method647() * 8, var4.method654() * 8, 8, 8, var4);
         }
      }

      this.method370(var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIILao;I)V",
      garbageValue = "966304425"
   )
   void method369(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label57:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field381; ++var9) {
               class31[] var10 = var5.field385[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method461(var13.field412);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field445 * 64 + var6, this.field446 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field447 != null) {
                           var16 = new Coordinates(this.field447.field379 + var9, var6 + this.field447.field384 * 64, var7 + this.field447.field376 * 64);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var9 + var17.field379, var17.field384 * 64 + var6 + var17.method629() * 8, var7 + var17.field376 * 64 + var17.method633() * 8);
                        }

                        class39 var18 = new class39(var14.field3360, var16, var15, this.method400(var14));
                        this.field443.put(var8, var18);
                        continue label57;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;I)V",
      garbageValue = "1169190440"
   )
   void method370(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field346.worldX >> 6 == this.field445 && var3.field346.worldY >> 6 == this.field446) {
            class39 var4 = new class39(var3.field347, var3.field346, var3.field346, this.method490(var3.field347));
            this.field453.add(var4);
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILak;[Lai;[Lkh;I)Z",
      garbageValue = "526710898"
   )
   boolean method371(int var1, class46 var2, class34[] var3, IndexedSprite[] var4) {
      if(!this.method464(var1)) {
         return false;
      } else if(this.field447 == null && this.field448.isEmpty()) {
         return false;
      } else {
         this.method380(var3);
         this.field452.method5527();
         if(this.field447 != null) {
            this.method375(var2, var3, var4);
         } else {
            this.method436(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "-2081088042"
   )
   void method372(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method388(var1, var2, var4, var3);
      this.method394(var1, var2, var4, var3);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;IIB)V",
      garbageValue = "-22"
   )
   void method373(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field443.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field495))) {
            Area var6 = Area.mapAreaType[var5.field495];
            this.method454(var6, var5.field499, var5.field494, var2, var3);
         }
      }

      this.method389(var1, var2, var3);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1017392381"
   )
   boolean method464(int var1) {
      if(this.field452 != null && this.field457 == var1) {
         return false;
      } else {
         this.field457 = var1;
         this.field452 = new SpritePixels(this.field457 * 64, this.field457 * 64);
         return true;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lak;[Lai;[Lkh;I)V",
      garbageValue = "-2131441272"
   )
   void method375(class46 var1, class34[] var2, IndexedSprite[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method378(var4, var5, this.field447, var1);
            this.method379(var4, var5, this.field447, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method395(var4, var5, this.field447, var1, var3);
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lak;[Lkh;I)V",
      garbageValue = "-1569659442"
   )
   void method436(class46 var1, IndexedSprite[] var2) {
      Iterator var3 = this.field448.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method647() * 8; var5 < var4.method647() * 8 + 8; ++var5) {
            for(var6 = var4.method654() * 8; var6 < var4.method654() * 8 + 8; ++var6) {
               this.method378(var5, var6, var4, var1);
               this.method379(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field448.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method647() * 8; var5 < var4.method647() * 8 + 8; ++var5) {
            for(var6 = var4.method654() * 8; var6 < var4.method654() * 8 + 8; ++var6) {
               this.method395(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILao;Lak;[Lkh;B)V",
      garbageValue = "52"
   )
   void method395(int var1, int var2, class28 var3, class46 var4, IndexedSprite[] var5) {
      this.method387(var1, var2, var3);
      this.method386(var1, var2, var3, var5);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IILao;Lak;B)V",
      garbageValue = "1"
   )
   void method378(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field380[0][var1][var2] - 1;
      int var6 = var3.field382[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field457 * var1, this.field457 * (63 - var2), this.field457, this.field457, this.field450);
      }

      int var7 = 16711935;
      int var8;
      if(var6 != -1) {
         int var9 = this.field450;
         Overlay var10 = KitDefinition.getOverlayDefinition(var6);
         if(var10 == null) {
            var8 = var9;
         } else if(var10.otherRgbColor >= 0) {
            var8 = var10.otherRgbColor | -16777216;
         } else if(var10.texture >= 0) {
            int var11 = Nameable.method5019(Graphics3D.textureLoader.getAverageTextureRGB(var10.texture), 96);
            var8 = Graphics3D.colorPalette[var11] | -16777216;
         } else if(var10.color == 16711935) {
            var8 = var9;
         } else {
            int var12 = var10.hue;
            int var13 = var10.saturation;
            int var14 = var10.lightness;
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
            int var16 = Nameable.method5019(var15, 96);
            var8 = Graphics3D.colorPalette[var16] | -16777216;
         }

         var7 = var8;
      }

      if(var6 > -1 && var3.field386[0][var1][var2] == 0) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field457 * var1, this.field457 * (63 - var2), this.field457, this.field457, var7);
      } else {
         var8 = this.method385(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.Rasterizer2D_fillRectangle(this.field457 * var1, this.field457 * (63 - var2), this.field457, this.field457, var8);
         } else {
            var4.method658(this.field457 * var1, this.field457 * (63 - var2), var8, var7, this.field457, this.field457, var3.field386[0][var1][var2], var3.field383[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IILao;Lak;I)V",
      garbageValue = "-246787642"
   )
   void method379(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field381; ++var5) {
         int var6 = var3.field382[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var8 = this.field450;
            Overlay var9 = KitDefinition.getOverlayDefinition(var6);
            int var7;
            if(var9 == null) {
               var7 = var8;
            } else if(var9.otherRgbColor >= 0) {
               var7 = var9.otherRgbColor | -16777216;
            } else if(var9.texture >= 0) {
               int var10 = Nameable.method5019(Graphics3D.textureLoader.getAverageTextureRGB(var9.texture), 96);
               var7 = Graphics3D.colorPalette[var10] | -16777216;
            } else if(var9.color == 16711935) {
               var7 = var8;
            } else {
               int var11 = var9.hue;
               int var12 = var9.saturation;
               int var13 = var9.lightness;
               if(var13 > 179) {
                  var12 /= 2;
               }

               if(var13 > 192) {
                  var12 /= 2;
               }

               if(var13 > 217) {
                  var12 /= 2;
               }

               if(var13 > 243) {
                  var12 /= 2;
               }

               int var14 = (var12 / 32 << 7) + var13 / 2 + (var11 / 4 << 10);
               int var15 = Nameable.method5019(var14, 96);
               var7 = Graphics3D.colorPalette[var15] | -16777216;
            }

            if(var3.field386[var5][var1][var2] == 0) {
               Rasterizer2D.Rasterizer2D_fillRectangle(this.field457 * var1, this.field457 * (63 - var2), this.field457, this.field457, var7);
            } else {
               var4.method658(this.field457 * var1, this.field457 * (63 - var2), 0, var7, this.field457, this.field457, var3.field386[var5][var1][var2], var3.field383[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([Lai;I)Z",
      garbageValue = "-1946507949"
   )
   boolean method380(class34[] var1) {
      if(this.field454 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field447 != null) {
            this.method383(0, 0, 64, 64, this.field447, var2);
         } else {
            Iterator var3 = this.field448.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method383(var4.method647() * 8, var4.method654() * 8, 8, 8, var4, var2);
            }
         }

         this.method382(var1, var2);
         this.method381(var2);
         return true;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lab;B)V",
      garbageValue = "-107"
   )
   void method381(class43 var1) {
      this.field454 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field454[var2][var3] = var1.method613(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([Lai;Lab;I)V",
      garbageValue = "2076557529"
   )
   void method382(class34[] var1, class43 var2) {
      class239[] var3 = World.method1637();
      class239[] var4 = var3;

      for(int var5 = 0; var5 < var4.length; ++var5) {
         class239 var6 = var4[var5];
         if(var1[var6.rsOrdinal()] != null) {
            byte var7 = 0;
            byte var8 = 0;
            byte var9 = 64;
            byte var10 = 64;
            byte var11 = 0;
            byte var12 = 0;
            switch(var6.field3230) {
            case 0:
               var8 = 59;
               var10 = 5;
               break;
            case 1:
               var12 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
               break;
            case 2:
               var7 = 59;
               var9 = 5;
               break;
            case 3:
               var8 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
               break;
            case 4:
               var11 = 59;
               var12 = 59;
               var9 = 5;
               var10 = 5;
               break;
            case 5:
               var8 = 59;
               var10 = 5;
               var11 = 59;
               var9 = 5;
               break;
            case 6:
               var11 = 59;
               var9 = 5;
               break;
            case 7:
               var12 = 59;
               var10 = 5;
            }

            this.method377(var11, var12, var7, var8, var9, var10, var1[var6.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIILao;Lab;I)V",
      garbageValue = "1703519881"
   )
   void method383(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field380[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = class5.getUnderlayDefinition(var9);
               var6.method616(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIIILai;Lab;I)V",
      garbageValue = "894454749"
   )
   void method377(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method404(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = class5.getUnderlayDefinition(var11);
               var8.method616(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IILao;I)I",
      garbageValue = "-1524566999"
   )
   int method385(int var1, int var2, class28 var3) {
      return var3.field380[0][var1][var2] == 0?this.field450:this.field454[var1][var2];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IILao;[Lkh;S)V",
      garbageValue = "6965"
   )
   void method386(int var1, int var2, class28 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field381; ++var5) {
         class31[] var6 = var3.field385[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               if(!GZipDecompressor.method3340(var9.field414)) {
                  int var11 = var9.field414;
                  boolean var10 = var11 == class232.field2914.field2903;
                  if(!var10) {
                     continue;
                  }
               }

               ObjectComposition var12 = TextureProvider.getObjectDefinition(var9.field412);
               if(var12.mapSceneId != -1) {
                  if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                     var4[var12.mapSceneId].method5508(this.field457 * var1, this.field457 * (63 - var2), this.field457 * 2, this.field457 * 2);
                  } else {
                     var4[var12.mapSceneId].method5508(this.field457 * var1, this.field457 * (63 - var2), this.field457 * 2 + 1, this.field457 * 2 + 1);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IILao;I)V",
      garbageValue = "1150779001"
   )
   void method387(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field381; ++var4) {
         class31[] var5 = var3.field385[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               int var10 = var8.field414;
               boolean var9 = var10 >= class232.field2909.field2903 && var10 <= class232.field2895.field2903 || var10 == class232.field2896.field2903;
               if(var9) {
                  ObjectComposition var11 = TextureProvider.getObjectDefinition(var8.field412);
                  int var12 = var11.int1 != 0?-3407872:-3355444;
                  if(var8.field414 == class232.field2909.field2903) {
                     this.method403(var1, var2, var8.field411, var12);
                  }

                  if(var8.field414 == class232.field2892.field2903) {
                     this.method403(var1, var2, var8.field411, -3355444);
                     this.method403(var1, var2, var8.field411 + 1, var12);
                  }

                  if(var8.field414 == class232.field2895.field2903) {
                     if(var8.field411 == 0) {
                        Rasterizer2D.method5410(this.field457 * var1, this.field457 * (63 - var2), 1, var12);
                     }

                     if(var8.field411 == 1) {
                        Rasterizer2D.method5410(this.field457 * var1 + this.field457 - 1, this.field457 * (63 - var2), 1, var12);
                     }

                     if(var8.field411 == 2) {
                        Rasterizer2D.method5410(this.field457 * var1 + this.field457 - 1, this.field457 * (63 - var2) + this.field457 - 1, 1, var12);
                     }

                     if(var8.field411 == 3) {
                        Rasterizer2D.method5410(this.field457 * var1, this.field457 * (63 - var2) + this.field457 - 1, 1, var12);
                     }
                  }

                  if(var8.field414 == class232.field2896.field2903) {
                     int var13 = var8.field411 % 2;
                     int var14;
                     if(var13 == 0) {
                        for(var14 = 0; var14 < this.field457; ++var14) {
                           Rasterizer2D.method5410(var14 + this.field457 * var1, (64 - var2) * this.field457 - 1 - var14, 1, var12);
                        }
                     } else {
                        for(var14 = 0; var14 < this.field457; ++var14) {
                           Rasterizer2D.method5410(var14 + this.field457 * var1, var14 + this.field457 * (63 - var2), 1, var12);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-1235279075"
   )
   void method388(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field443.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var9.worldX * var5 + (float)var1 - var6);
         int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.worldY - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field499 = var10;
            var12.field494 = var11;
            Area var13 = Area.mapAreaType[var12.field495];
            if(!var3.contains(Integer.valueOf(var13.method4552()))) {
               this.method390(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;IIB)V",
      garbageValue = "-67"
   )
   void method389(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field453.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         Area var6 = Area.mapAreaType[var5.field495];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4552()))) {
            this.method454(var6, var5.field499, var5.field494, var2, var3);
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Liw;IIIII)V",
      garbageValue = "1739126359"
   )
   void method454(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.getMapIcon(false);
      if(var6 != null) {
         var6.drawAt(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method5399(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method5399(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lag;IIFI)V",
      garbageValue = "1460846882"
   )
   void method390(class39 var1, int var2, int var3, float var4) {
      Area var5 = Area.mapAreaType[var1.field495];
      this.method392(var5, var2, var3);
      this.method393(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Liw;III)V",
      garbageValue = "-364365344"
   )
   void method392(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.getMapIcon(false);
      if(var4 != null) {
         int var5 = this.method487(var4, var1.field3356);
         int var6 = this.method491(var4, var1.field3370);
         var4.drawAt(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lag;Liw;IIFI)V",
      garbageValue = "1467732800"
   )
   void method393(class39 var1, Area var2, int var3, int var4, float var5) {
      if(var1.field498 != null) {
         if(var1.field498.field438.method182(var5)) {
            Font var6 = (Font)this.field455.get(var1.field498.field438);
            var6.method5217(var1.field498.field439, var3 - var1.field498.field435 / 2, var4, var1.field498.field435, var1.field498.field437, -16777216 | var2.field3361, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "408178579"
   )
   void method394(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field453.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field496.worldX % 64;
         int var9 = var7.field496.worldY % 64;
         var7.field499 = (int)((float)var1 + (float)var8 * var5);
         var7.field494 = (int)((float)(63 - var9) * var5 + (float)var2);
         if(!var3.contains(Integer.valueOf(var7.field495))) {
            this.method390(var7, var7.field499, var7.field494, var5);
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1118765865"
   )
   void method418() {
      if(this.field447 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method471(var1, var2, this.field447);
            }
         }
      } else {
         Iterator var5 = this.field448.iterator();

         while(var5.hasNext()) {
            class45 var6 = (class45)var5.next();

            for(int var3 = var6.method647() * 8; var3 < var6.method647() * 8 + 8; ++var3) {
               for(int var4 = var6.method654() * 8; var4 < var6.method654() * 8 + 8; ++var4) {
                  this.method471(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IILao;B)V",
      garbageValue = "103"
   )
   void method471(int var1, int var2, class28 var3) {
      field456.set(0, var1, var2);

      for(int var4 = 0; var4 < var3.field381; ++var4) {
         class31[] var5 = var3.field385[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method461(var8.field412);
               if(var9 != null) {
                  class39 var10 = (class39)this.field443.get(field456);
                  if(var10 != null) {
                     if(var9.field3360 != var10.field495) {
                        class39 var16 = new class39(var9.field3360, var10.field500, var10.field496, this.method400(var9));
                        this.field443.put(new Coordinates(field456), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field500.plane - var10.field496.plane;
                     var10.field496.plane = var4;
                     var10.field500.plane = var4 + var15;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field445 * 64 + var1, this.field446 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field447 != null) {
                     var12 = new Coordinates(this.field447.field379 + var4, this.field447.field384 * 64 + var1, var2 + this.field447.field376 * 64);
                  } else {
                     Iterator var13 = this.field448.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method631(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field379, var1 + var14.field384 * 64 + var14.method629() * 8, var14.field376 * 64 + var2 + var14.method633() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3360, var12, var11, this.method400(var9));
                     this.field443.put(new Coordinates(field456), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field443.remove(field456);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lko;Ljl;I)I",
      garbageValue = "870885034"
   )
   int method487(SpritePixels var1, class268 var2) {
      switch(var2.field3601) {
      case 0:
         return 0;
      case 1:
         return -var1.width / 2;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lko;Lih;I)I",
      garbageValue = "508513226"
   )
   int method491(SpritePixels var1, class250 var2) {
      switch(var2.field3341) {
      case 0:
         return 0;
      case 1:
         return -var1.height / 2;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)Liw;",
      garbageValue = "-1825207909"
   )
   Area method461(int var1) {
      ObjectComposition var2 = TextureProvider.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.mapAreaType[var2.mapIconId]:null;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)Lah;",
      garbageValue = "1406152709"
   )
   class33 method490(int var1) {
      Area var2 = Area.mapAreaType[var1];
      return this.method400(var2);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Liw;B)Lah;",
      garbageValue = "122"
   )
   class33 method400(Area var1) {
      if(var1.name != null && this.field455 != null && this.field455.get(Size.field343) != null) {
         int var3 = var1.field3352;
         Size[] var4 = Size.method183();
         int var5 = 0;

         Size var2;
         while(true) {
            if(var5 >= var4.length) {
               var2 = null;
               break;
            }

            Size var6 = var4[var5];
            if(var3 == var6.field342) {
               var2 = var6;
               break;
            }

            ++var5;
         }

         if(var2 == null) {
            return null;
         } else {
            Font var14 = (Font)this.field455.get(var2);
            if(var14 == null) {
               return null;
            } else {
               int var15 = var14.method5208(var1.name, 1000000);
               String[] var7 = new String[var15];
               var14.method5209(var1.name, (int[])null, var7);
               int var8 = var7.length * var14.verticalSpace / 2;
               int var9 = 0;
               String[] var10 = var7;

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  String var12 = var10[var11];
                  int var13 = var14.getTextWidth(var12);
                  if(var13 > var9) {
                     var9 = var13;
                  }
               }

               return new class33(var1.name, var9, var8, var2);
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IIIIIB)Ljava/util/List;",
      garbageValue = "7"
   )
   List method401(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field443.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method536(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field453.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method536(var4, var5)) {
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

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/List;",
      garbageValue = "-1907634499"
   )
   List method484() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field453);
      var1.addAll(this.field443.values());
      return var1;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "1"
   )
   void method403(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method5464(this.field457 * var1, this.field457 * (63 - var2), this.field457, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5410(this.field457 * var1, this.field457 * (63 - var2), this.field457, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5464(this.field457 * var1 + this.field457 - 1, this.field457 * (63 - var2), this.field457, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5410(this.field457 * var1, this.field457 * (63 - var2) + this.field457 - 1, this.field457, var4);
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1434278520"
   )
   int method404(int var1, int var2) {
      if(this.field447 != null) {
         return this.field447.method236(var1, var2);
      } else {
         if(!this.field448.isEmpty()) {
            Iterator var3 = this.field448.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method631(var1, var2)) {
                  return var4.method236(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "-1423682520"
   )
   static int method498(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class35.getWidget(class80.intStack[--class80.intStackSize]);
      } else {
         var3 = var2?class23.field331:GrandExchangeOffer.field297;
      }

      class60.method1015(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class80.intStack[--class80.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = class36.localPlayer.composition.method4216();
            return 1;
         } else {
            return 2;
         }
      } else {
         class80.intStackSize -= 2;
         int var4 = class80.intStack[class80.intStackSize];
         int var5 = class80.intStack[class80.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = CombatInfo1.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2787 = var6.offsetX2d;
         var3.field2782 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2739 = 0;
         } else if(var0 == 1212 | 1 == var6.isStackable) {
            var3.field2739 = 1;
         } else {
            var3.field2739 = 2;
         }

         if(var3.field2724 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2724;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
   )
   static final int method365() {
      return Client.menuOptionCount - 1;
   }
}
