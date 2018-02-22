import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class34 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   static final Coordinates field451;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1142539685
   )
   int field447;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1955588221
   )
   int field437;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   class22 field452;
   @ObfuscatedName("l")
   LinkedList field443;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 529891713
   )
   int field444;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 324572807
   )
   int field445;
   @ObfuscatedName("c")
   int[][] field446;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Llm;"
   )
   SpritePixels field448;
   @ObfuscatedName("r")
   List field440;
   @ObfuscatedName("d")
   HashMap field449;
   @ObfuscatedName("v")
   final HashMap field450;

   static {
      field451 = new Coordinates();
   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field447 = var1;
      this.field437 = var2;
      this.field443 = new LinkedList();
      this.field440 = new LinkedList();
      this.field449 = new HashMap();
      this.field444 = var3 | -16777216;
      this.field450 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1927684471"
   )
   void method378(int var1, int var2, int var3) {
      if(this.field448 != null) {
         if(var3 == this.field445 * 64) {
            this.field448.method5809(var1, var2);
         } else {
            this.field448.method5860(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Le;Ljava/util/List;B)V",
      garbageValue = "5"
   )
   void method379(class22 var1, List var2) {
      this.field449.clear();
      this.field452 = var1;
      this.method443(0, 0, 64, 64, this.field452);
      this.method382(var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
      garbageValue = "1634744644"
   )
   void method494(HashSet var1, List var2) {
      this.field449.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method245() == this.field447 && var4.method255() == this.field437) {
            this.field443.add(var4);
            this.method443(var4.method671() * 8, var4.method664() * 8, 8, 8, var4);
         }
      }

      this.method382(var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIILam;I)V",
      garbageValue = "1644534674"
   )
   void method443(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label57:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field377; ++var9) {
               class31[] var10 = var5.field382[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method435(var13.field412);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field447 * 64 + var6, this.field437 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field452 != null) {
                           var16 = new Coordinates(this.field452.field384 + var9, var6 + this.field452.field383 * 64, var7 + this.field452.field373 * 64);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var9 + var17.field384, var17.field383 * 64 + var6 + var17.method661() * 8, var7 + var17.field373 * 64 + var17.method662() * 8);
                        }

                        class39 var18 = new class39(var14.field3406, var16, var15, this.method448(var14));
                        this.field449.put(var8, var18);
                        continue label57;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;I)V",
      garbageValue = "235106040"
   )
   void method382(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field342.worldX >> 6 == this.field447 && var3.field342.worldY >> 6 == this.field437) {
            class39 var4 = new class39(var3.field347, var3.field342, var3.field342, this.method412(var3.field347));
            this.field440.add(var4);
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILaa;[Lak;[Llv;S)Z",
      garbageValue = "1405"
   )
   boolean method383(int var1, class46 var2, class34[] var3, IndexedSprite[] var4) {
      if(!this.method386(var1)) {
         return false;
      } else if(this.field452 == null && this.field443.isEmpty()) {
         return false;
      } else {
         this.method392(var3);
         this.field448.method5802();
         if(this.field452 != null) {
            this.method420(var2, var3, var4);
         } else {
            this.method388(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "-2025753674"
   )
   void method384(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method402(var1, var2, var4, var3);
      this.method406(var1, var2, var4, var3);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "926231148"
   )
   void method385(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field449.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field488))) {
            Area var6 = class330.mapAreaType[var5.field488];
            this.method425(var6, var5.field494, var5.field495, var2, var3);
         }
      }

      this.method401(var1, var2, var3);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1927160921"
   )
   boolean method386(int var1) {
      if(this.field448 != null && this.field445 == var1) {
         return false;
      } else {
         this.field445 = var1;
         this.field448 = new SpritePixels(this.field445 * 64, this.field445 * 64);
         return true;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Laa;[Lak;[Llv;B)V",
      garbageValue = "0"
   )
   void method420(class46 var1, class34[] var2, IndexedSprite[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method390(var4, var5, this.field452, var1);
            this.method391(var4, var5, this.field452, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method389(var4, var5, this.field452, var1, var3);
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Laa;[Llv;B)V",
      garbageValue = "-5"
   )
   void method388(class46 var1, IndexedSprite[] var2) {
      Iterator var3 = this.field443.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method671() * 8; var5 < var4.method671() * 8 + 8; ++var5) {
            for(var6 = var4.method664() * 8; var6 < var4.method664() * 8 + 8; ++var6) {
               this.method390(var5, var6, var4, var1);
               this.method391(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field443.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method671() * 8; var5 < var4.method671() * 8 + 8; ++var5) {
            for(var6 = var4.method664() * 8; var6 < var4.method664() * 8 + 8; ++var6) {
               this.method389(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IILam;Laa;[Llv;B)V",
      garbageValue = "12"
   )
   void method389(int var1, int var2, class28 var3, class46 var4, IndexedSprite[] var5) {
      this.method399(var1, var2, var3);
      this.method483(var1, var2, var3, var5);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IILam;Laa;B)V",
      garbageValue = "83"
   )
   void method390(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field378[0][var1][var2] - 1;
      int var6 = var3.field379[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field445 * var1, this.field445 * (63 - var2), this.field445, this.field445, this.field444);
      }

      int var7 = 16711935;
      int var8;
      if(var6 != -1) {
         int var9 = this.field444;
         Overlay var10 = class21.getOverlayDefinition(var6);
         if(var10 == null) {
            var8 = var9;
         } else if(var10.otherRgbColor >= 0) {
            var8 = var10.otherRgbColor | -16777216;
         } else {
            int var11;
            if(var10.texture >= 0) {
               var11 = class23.method188(Graphics3D.textureLoader.getAverageTextureRGB(var10.texture), 96);
               var8 = Graphics3D.colorPalette[var11] | -16777216;
            } else if(var10.color == 16711935) {
               var8 = var9;
            } else {
               var11 = BoundingBox3DDrawMode.method54(var10.hue, var10.saturation, var10.lightness);
               int var12 = class23.method188(var11, 96);
               var8 = Graphics3D.colorPalette[var12] | -16777216;
            }
         }

         var7 = var8;
      }

      if(var6 > -1 && var3.field386[0][var1][var2] == 0) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field445 * var1, this.field445 * (63 - var2), this.field445, this.field445, var7);
      } else {
         var8 = this.method397(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.Rasterizer2D_fillRectangle(this.field445 * var1, this.field445 * (63 - var2), this.field445, this.field445, var8);
         } else {
            var4.method684(this.field445 * var1, this.field445 * (63 - var2), var8, var7, this.field445, this.field445, var3.field386[0][var1][var2], var3.field380[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IILam;Laa;I)V",
      garbageValue = "-1486848137"
   )
   void method391(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field377; ++var5) {
         int var6 = var3.field379[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var8 = this.field444;
            Overlay var9 = class21.getOverlayDefinition(var6);
            int var7;
            if(var9 == null) {
               var7 = var8;
            } else if(var9.otherRgbColor >= 0) {
               var7 = var9.otherRgbColor | -16777216;
            } else {
               int var10;
               if(var9.texture >= 0) {
                  var10 = class23.method188(Graphics3D.textureLoader.getAverageTextureRGB(var9.texture), 96);
                  var7 = Graphics3D.colorPalette[var10] | -16777216;
               } else if(var9.color == 16711935) {
                  var7 = var8;
               } else {
                  var10 = BoundingBox3DDrawMode.method54(var9.hue, var9.saturation, var9.lightness);
                  int var11 = class23.method188(var10, 96);
                  var7 = Graphics3D.colorPalette[var11] | -16777216;
               }
            }

            if(var3.field386[var5][var1][var2] == 0) {
               Rasterizer2D.Rasterizer2D_fillRectangle(this.field445 * var1, this.field445 * (63 - var2), this.field445, this.field445, var7);
            } else {
               var4.method684(this.field445 * var1, this.field445 * (63 - var2), 0, var7, this.field445, this.field445, var3.field386[var5][var1][var2], var3.field380[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([Lak;I)Z",
      garbageValue = "747732843"
   )
   boolean method392(class34[] var1) {
      if(this.field446 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field452 != null) {
            this.method413(0, 0, 64, 64, this.field452, var2);
         } else {
            Iterator var3 = this.field443.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method413(var4.method671() * 8, var4.method664() * 8, 8, 8, var4, var2);
            }
         }

         this.method428(var1, var2);
         this.method418(var2);
         return true;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lac;B)V",
      garbageValue = "1"
   )
   void method418(class43 var1) {
      this.field446 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field446[var2][var3] = var1.method635(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([Lak;Lac;I)V",
      garbageValue = "-1453366211"
   )
   void method428(class34[] var1, class43 var2) {
      class248[] var3 = new class248[]{class248.field3271, class248.field3269, class248.field3273, class248.field3275, class248.field3272, class248.field3270, class248.field3266, class248.field3268};
      class248[] var5 = var3;

      for(int var6 = 0; var6 < var5.length; ++var6) {
         class248 var7 = var5[var6];
         if(var1[var7.rsOrdinal()] != null) {
            byte var8 = 0;
            byte var9 = 0;
            byte var10 = 64;
            byte var11 = 64;
            byte var12 = 0;
            byte var13 = 0;
            switch(var7.field3274) {
            case 0:
               var9 = 59;
               var11 = 5;
               break;
            case 1:
               var8 = 59;
               var10 = 5;
               break;
            case 2:
               var9 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 3:
               var9 = 59;
               var11 = 5;
               var12 = 59;
               var10 = 5;
               break;
            case 4:
               var12 = 59;
               var10 = 5;
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
               var13 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
            }

            this.method396(var12, var13, var8, var9, var10, var11, var1[var7.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIILam;Lac;I)V",
      garbageValue = "591038275"
   )
   void method413(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field378[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = Item.getUnderlayDefinition(var9);
               var6.method636(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIILak;Lac;I)V",
      garbageValue = "-2049927052"
   )
   void method396(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method417(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = Item.getUnderlayDefinition(var11);
               var8.method636(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IILam;I)I",
      garbageValue = "1675365728"
   )
   int method397(int var1, int var2, class28 var3) {
      return var3.field378[0][var1][var2] == 0?this.field444:this.field446[var1][var2];
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IILam;[Llv;I)V",
      garbageValue = "-1561978302"
   )
   void method483(int var1, int var2, class28 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field377; ++var5) {
         class31[] var6 = var3.field382[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               if(class201.method3891(var9.field409) || class237.method4473(var9.field409)) {
                  ObjectComposition var10 = Preferences.getObjectDefinition(var9.field412);
                  if(var10.mapSceneId != -1) {
                     if(var10.mapSceneId != 46 && var10.mapSceneId != 52) {
                        var4[var10.mapSceneId].method5781(this.field445 * var1, this.field445 * (63 - var2), this.field445 * 2, this.field445 * 2);
                     } else {
                        var4[var10.mapSceneId].method5781(this.field445 * var1, this.field445 * (63 - var2), this.field445 * 2 + 1, this.field445 * 2 + 1);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IILam;B)V",
      garbageValue = "-112"
   )
   void method399(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field377; ++var4) {
         class31[] var5 = var3.field382[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               int var10 = var8.field409;
               boolean var9 = var10 >= class241.field2937.field2958 && var10 <= class241.field2936.field2958 || var10 == class241.field2933.field2958;
               if(var9) {
                  ObjectComposition var11 = Preferences.getObjectDefinition(var8.field412);
                  int var12 = var11.int1 != 0?-3407872:-3355444;
                  if(var8.field409 == class241.field2937.field2958) {
                     this.method416(var1, var2, var8.field408, var12);
                  }

                  if(var8.field409 == class241.field2935.field2958) {
                     this.method416(var1, var2, var8.field408, -3355444);
                     this.method416(var1, var2, var8.field408 + 1, var12);
                  }

                  if(var8.field409 == class241.field2936.field2958) {
                     if(var8.field408 == 0) {
                        Rasterizer2D.method5683(this.field445 * var1, this.field445 * (63 - var2), 1, var12);
                     }

                     if(var8.field408 == 1) {
                        Rasterizer2D.method5683(this.field445 + this.field445 * var1 - 1, this.field445 * (63 - var2), 1, var12);
                     }

                     if(var8.field408 == 2) {
                        Rasterizer2D.method5683(this.field445 * var1 + this.field445 - 1, this.field445 * (63 - var2) + this.field445 - 1, 1, var12);
                     }

                     if(var8.field408 == 3) {
                        Rasterizer2D.method5683(this.field445 * var1, this.field445 * (63 - var2) + this.field445 - 1, 1, var12);
                     }
                  }

                  if(var8.field409 == class241.field2933.field2958) {
                     int var13 = var8.field408 % 2;
                     int var14;
                     if(var13 == 0) {
                        for(var14 = 0; var14 < this.field445; ++var14) {
                           Rasterizer2D.method5683(var14 + this.field445 * var1, (64 - var2) * this.field445 - 1 - var14, 1, var12);
                        }
                     } else {
                        for(var14 = 0; var14 < this.field445; ++var14) {
                           Rasterizer2D.method5683(var14 + this.field445 * var1, var14 + this.field445 * (63 - var2), 1, var12);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-1044872651"
   )
   void method402(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field449.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var1 + var5 * (float)var9.worldX - var6);
         int var11 = (int)((float)(var2 + var4) - (float)var9.worldY * var5 - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field494 = var10;
            var12.field495 = var11;
            Area var13 = class330.mapAreaType[var12.field488];
            if(!var3.contains(Integer.valueOf(var13.method4741()))) {
               this.method403(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-64842753"
   )
   void method401(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field440.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         Area var6 = class330.mapAreaType[var5.field488];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4741()))) {
            this.method425(var6, var5.field494, var5.field495, var2, var3);
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Ljz;IIIII)V",
      garbageValue = "1113932488"
   )
   void method425(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.getMapIcon(false);
      if(var6 != null) {
         var6.drawAt(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method5672(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method5672(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lad;IIFI)V",
      garbageValue = "2130030632"
   )
   void method403(class39 var1, int var2, int var3, float var4) {
      Area var5 = class330.mapAreaType[var1.field488];
      this.method404(var5, var2, var3);
      this.method405(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Ljz;III)V",
      garbageValue = "-689289719"
   )
   void method404(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.getMapIcon(false);
      if(var4 != null) {
         int var5 = this.method423(var4, var1.field3390);
         int var6 = this.method410(var4, var1.field3407);
         var4.drawAt(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lad;Ljz;IIFI)V",
      garbageValue = "868818062"
   )
   void method405(class39 var1, Area var2, int var3, int var4, float var5) {
      if(var1.field493 != null) {
         if(var1.field493.field433.method192(var5)) {
            Font var6 = (Font)this.field450.get(var1.field493.field433);
            var6.method5455(var1.field493.field431, var3 - var1.field493.field436 / 2, var4, var1.field493.field436, var1.field493.field432, -16777216 | var2.field3396, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-1967729716"
   )
   void method406(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field440.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field490.worldX % 64;
         int var9 = var7.field490.worldY % 64;
         var7.field494 = (int)((float)var1 + var5 * (float)var8);
         var7.field495 = (int)(var5 * (float)(63 - var9) + (float)var2);
         if(!var3.contains(Integer.valueOf(var7.field488))) {
            this.method403(var7, var7.field494, var7.field495, var5);
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2130388369"
   )
   void method407() {
      if(this.field452 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method408(var1, var2, this.field452);
            }
         }
      } else {
         Iterator var5 = this.field443.iterator();

         while(var5.hasNext()) {
            class45 var6 = (class45)var5.next();

            for(int var3 = var6.method671() * 8; var3 < var6.method671() * 8 + 8; ++var3) {
               for(int var4 = var6.method664() * 8; var4 < var6.method664() * 8 + 8; ++var4) {
                  this.method408(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IILam;I)V",
      garbageValue = "1782966364"
   )
   void method408(int var1, int var2, class28 var3) {
      field451.set(0, var1, var2);

      for(int var4 = 0; var4 < var3.field377; ++var4) {
         class31[] var5 = var3.field382[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method435(var8.field412);
               if(var9 != null) {
                  class39 var10 = (class39)this.field449.get(field451);
                  if(var10 != null) {
                     if(var9.field3406 != var10.field488) {
                        class39 var16 = new class39(var9.field3406, var10.field491, var10.field490, this.method448(var9));
                        this.field449.put(new Coordinates(field451), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field491.plane - var10.field490.plane;
                     var10.field490.plane = var4;
                     var10.field491.plane = var4 + var15;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field447 * 64 + var1, this.field437 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field452 != null) {
                     var12 = new Coordinates(this.field452.field384 + var4, this.field452.field383 * 64 + var1, var2 + this.field452.field373 * 64);
                  } else {
                     Iterator var13 = this.field443.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method672(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field384, var1 + var14.field383 * 64 + var14.method661() * 8, var2 + var14.field373 * 64 + var14.method662() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3406, var12, var11, this.method448(var9));
                     this.field449.put(new Coordinates(field451), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field449.remove(field451);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Llm;Ljj;I)I",
      garbageValue = "-1625591871"
   )
   int method423(SpritePixels var1, class277 var2) {
      switch(var2.field3623) {
      case 0:
         return 0;
      case 1:
         return -var1.width / 2;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Llm;Lif;B)I",
      garbageValue = "-80"
   )
   int method410(SpritePixels var1, class259 var2) {
      switch(var2.field3378) {
      case 0:
         return 0;
      case 2:
         return -var1.height / 2;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)Ljz;",
      garbageValue = "232225155"
   )
   Area method435(int var1) {
      ObjectComposition var2 = Preferences.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?class330.mapAreaType[var2.mapIconId]:null;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)Laq;",
      garbageValue = "133726924"
   )
   class33 method412(int var1) {
      Area var2 = class330.mapAreaType[var1];
      return this.method448(var2);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Ljz;B)Laq;",
      garbageValue = "1"
   )
   class33 method448(Area var1) {
      if(var1.name != null && this.field450 != null && this.field450.get(Size.field336) != null) {
         Size var2 = Size.method193(var1.field3399);
         if(var2 == null) {
            return null;
         } else {
            Font var3 = (Font)this.field450.get(var2);
            if(var3 == null) {
               return null;
            } else {
               int var4 = var3.method5449(var1.name, 1000000);
               String[] var5 = new String[var4];
               var3.method5447(var1.name, (int[])null, var5);
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

               return new class33(var1.name, var7, var6, var2);
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IIIIII)Ljava/util/List;",
      garbageValue = "-2079182801"
   )
   List method414(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field449.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method558(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field440.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method558(var4, var5)) {
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

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)Ljava/util/List;",
      garbageValue = "-111"
   )
   List method415() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field440);
      var1.addAll(this.field449.values());
      return var1;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "319359797"
   )
   void method416(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method5685(this.field445 * var1, this.field445 * (63 - var2), this.field445, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5683(this.field445 * var1, this.field445 * (63 - var2), this.field445, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5685(this.field445 * var1 + this.field445 - 1, this.field445 * (63 - var2), this.field445, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5683(this.field445 * var1, this.field445 * (63 - var2) + this.field445 - 1, this.field445, var4);
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-612131890"
   )
   int method417(int var1, int var2) {
      if(this.field452 != null) {
         return this.field452.method251(var1, var2);
      } else {
         if(!this.field443.isEmpty()) {
            Iterator var3 = this.field443.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method672(var1, var2)) {
                  return var4.method251(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "700967297"
   )
   public static char method509(char var0) {
      return (char)(var0 == 198?69:(var0 == 230?101:(var0 == 223?115:(var0 == 338?69:(var0 == 339?'e':'\u0000')))));
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)[Liz;",
      garbageValue = "2052091963"
   )
   public static Permission[] method395() {
      return new Permission[]{Permission.field3290, Permission.field3287, Permission.field3296, Permission.field3291, Permission.field3288, Permission.field3289};
   }
}
