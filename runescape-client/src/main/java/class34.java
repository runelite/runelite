import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class34 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   static final Coordinates field497;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 2031710313
   )
   static int field498;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -562851309
   )
   static int field499;
   @ObfuscatedName("b")
   int[][] field492;
   @ObfuscatedName("m")
   List field487;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   SpritePixels field493;
   @ObfuscatedName("c")
   LinkedList field491;
   @ObfuscatedName("i")
   HashMap field495;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   class22 field488;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 684837801
   )
   int field500;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -48451645
   )
   int field484;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -942439881
   )
   int field490;
   @ObfuscatedName("s")
   final HashMap field496;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 237281153
   )
   int field486;

   static {
      field497 = new Coordinates();
   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field500 = var1;
      this.field486 = var2;
      this.field491 = new LinkedList();
      this.field487 = new LinkedList();
      this.field495 = new HashMap();
      this.field490 = var3 | -16777216;
      this.field496 = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "51"
   )
   boolean method385(int var1) {
      if(this.field493 != null && this.field484 == var1) {
         return false;
      } else {
         this.field484 = var1;
         this.field493 = new SpritePixels(this.field484 * 64, this.field484 * 64);
         return true;
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IILan;B)V",
      garbageValue = "-56"
   )
   void method398(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field415; ++var4) {
         class31[] var5 = var3.field420[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               if(class208.method3882(var8.field451)) {
                  ObjectComposition var9 = class37.getObjectDefinition(var8.field454);
                  int var10 = var9.field3445 != 0?-3407872:-3355444;
                  if(var8.field451 == class222.field2808.field2810) {
                     this.method476(var1, var2, var8.field452, var10);
                  }

                  if(var8.field451 == class222.field2814.field2810) {
                     this.method476(var1, var2, var8.field452, -3355444);
                     this.method476(var1, var2, var8.field452 + 1, var10);
                  }

                  if(var8.field451 == class222.field2822.field2810) {
                     if(var8.field452 == 0) {
                        Rasterizer2D.method4985(this.field484 * var1, this.field484 * (63 - var2), 1, var10);
                     }

                     if(var8.field452 == 1) {
                        Rasterizer2D.method4985(this.field484 + this.field484 * var1 - 1, this.field484 * (63 - var2), 1, var10);
                     }

                     if(var8.field452 == 2) {
                        Rasterizer2D.method4985(this.field484 * var1 + this.field484 - 1, this.field484 * (63 - var2) + this.field484 - 1, 1, var10);
                     }

                     if(var8.field452 == 3) {
                        Rasterizer2D.method4985(this.field484 * var1, this.field484 * (63 - var2) + this.field484 - 1, 1, var10);
                     }
                  }

                  if(var8.field451 == class222.field2812.field2810) {
                     int var11 = var8.field452 % 2;
                     int var12;
                     if(var11 == 0) {
                        for(var12 = 0; var12 < this.field484; ++var12) {
                           Rasterizer2D.method4985(var12 + this.field484 * var1, (64 - var2) * this.field484 - 1 - var12, 1, var10);
                        }
                     } else {
                        for(var12 = 0; var12 < this.field484; ++var12) {
                           Rasterizer2D.method4985(var12 + this.field484 * var1, var12 + this.field484 * (63 - var2), 1, var10);
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
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "1049553283"
   )
   void method399(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field495.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var9.worldX * var5 + (float)var1 - var6);
         int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.worldY - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field536 = var10;
            var12.field543 = var11;
            Area var13 = Area.field3284[var12.field544];
            if(!var3.contains(Integer.valueOf(var13.method4330()))) {
               this.method402(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lie;I)Laj;",
      garbageValue = "-829603552"
   )
   class33 method425(Area var1) {
      if(var1.name != null && this.field496 != null && this.field496.get(class24.field369) != null) {
         class24 var2 = class24.method190(var1.field3281);
         if(var2 == null) {
            return null;
         } else {
            Font var3 = (Font)this.field496.get(var2);
            if(var3 == null) {
               return null;
            } else {
               int var4 = var3.method4778(var1.name, 1000000);
               String[] var5 = new String[var4];
               var3.method4776(var1.name, (int[])null, var5);
               int var6 = var5.length * var3.verticalSpace / 2;
               int var7 = 0;
               String[] var8 = var5;

               for(int var9 = 0; var9 < var8.length; ++var9) {
                  String var10 = var8[var9];
                  int var11 = var3.method4775(var10);
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

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IILan;[Ljr;I)V",
      garbageValue = "1376426955"
   )
   void method397(int var1, int var2, class28 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field415; ++var5) {
         class31[] var6 = var3.field420[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               if(!class31.method293(var9.field451)) {
                  int var11 = var9.field451;
                  boolean var10 = var11 == class222.field2830.field2810;
                  if(!var10) {
                     continue;
                  }
               }

               ObjectComposition var12 = class37.getObjectDefinition(var9.field454);
               if(var12.mapSceneId != -1) {
                  if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                     var4[var12.mapSceneId].method5060(this.field484 * var1, this.field484 * (63 - var2), this.field484 * 2, this.field484 * 2);
                  } else {
                     var4[var12.mapSceneId].method5060(this.field484 * var1, this.field484 * (63 - var2), this.field484 * 2 + 1, this.field484 * 2 + 1);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Lie;III)V",
      garbageValue = "-179879132"
   )
   void method403(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.method4308(false);
      if(var4 != null) {
         int var5 = this.method408(var4, var1.field3293);
         int var6 = this.method409(var4, var1.field3291);
         var4.method5172(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IILan;Law;S)V",
      garbageValue = "-2586"
   )
   void method389(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field419[0][var1][var2] - 1;
      int var6 = var3.field417[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.method4968(this.field484 * var1, this.field484 * (63 - var2), this.field484, this.field484, this.field490);
      }

      int var7 = 16711935;
      int var8;
      if(var6 != -1) {
         int var9 = this.field490;
         Overlay var10 = NPCComposition.method4664(var6);
         if(var10 == null) {
            var8 = var9;
         } else if(var10.otherRgbColor >= 0) {
            var8 = var10.otherRgbColor | -16777216;
         } else if(var10.texture >= 0) {
            int var11 = Friend.method1139(Graphics3D.textureLoader.getAverageTextureRGB(var10.texture), 96);
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
            int var16 = Friend.method1139(var15, 96);
            var8 = Graphics3D.colorPalette[var16] | -16777216;
         }

         var7 = var8;
      }

      if(var6 > -1 && var3.field412[0][var1][var2] == 0) {
         Rasterizer2D.method4968(this.field484 * var1, this.field484 * (63 - var2), this.field484, this.field484, var7);
      } else {
         var8 = this.method455(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.method4968(this.field484 * var1, this.field484 * (63 - var2), this.field484, this.field484, var8);
         } else {
            var4.method692(this.field484 * var1, this.field484 * (63 - var2), var8, var7, this.field484, this.field484, var3.field412[0][var1][var2], var3.field423[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;IB)V",
      garbageValue = "-1"
   )
   void method405(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field487.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field542.worldX % 64;
         int var9 = var7.field542.worldY % 64;
         var7.field536 = (int)(var5 * (float)var8 + (float)var1);
         var7.field543 = (int)((float)var2 + (float)(63 - var9) * var5);
         if(!var3.contains(Integer.valueOf(var7.field544))) {
            this.method402(var7, var7.field536, var7.field543, var5);
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lkp;Liq;B)I",
      garbageValue = "4"
   )
   int method408(SpritePixels var1, class258 var2) {
      switch(var2.field3532) {
      case 1:
         return 0;
      case 2:
         return -var1.width / 2;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Laz;Lie;IIFI)V",
      garbageValue = "1848899583"
   )
   void method421(class39 var1, Area var2, int var3, int var4, float var5) {
      if(var1.field541 != null) {
         if(var1.field541.field480.method186(var5)) {
            Font var6 = (Font)this.field496.get(var1.field541.field480);
            var6.method4784(var1.field541.field483, var3 - var1.field541.field477 / 2, var4, var1.field541.field477, var1.field541.field479, -16777216 | var2.field3283, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IILan;Law;[Ljr;I)V",
      garbageValue = "-1966768923"
   )
   void method471(int var1, int var2, class28 var3, class46 var4, IndexedSprite[] var5) {
      this.method398(var1, var2, var3);
      this.method397(var1, var2, var3, var5);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1736828970"
   )
   int method503(int var1, int var2) {
      if(this.field488 != null) {
         return this.field488.method239(var1, var2);
      } else {
         if(!this.field491.isEmpty()) {
            Iterator var3 = this.field491.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method666(var1, var2)) {
                  return var4.method239(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-2100556575"
   )
   void method400(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field487.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         Area var6 = Area.field3284[var5.field544];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4330()))) {
            this.method383(var6, var5.field536, var5.field543, var2, var3);
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIILan;I)V",
      garbageValue = "156277686"
   )
   void method380(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label57:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field415; ++var9) {
               class31[] var10 = var5.field420[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method498(var13.field454);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, var6 + this.field500 * 64, var7 + this.field486 * 64);
                        Coordinates var16 = null;
                        if(this.field488 != null) {
                           var16 = new Coordinates(this.field488.field414 + var9, var6 + this.field488.field416 * 64, var7 + this.field488.field411 * 64);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var9 + var17.field414, var6 + var17.field416 * 64 + var17.method667() * 8, var17.field411 * 64 + var7 + var17.method668() * 8);
                        }

                        class39 var18 = new class39(var14.field3287, var16, var15, this.method425(var14));
                        this.field495.put(var8, var18);
                        continue label57;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;B)V",
      garbageValue = "1"
   )
   void method393(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field384.worldX >> 6 == this.field500 && var3.field384.worldY >> 6 == this.field486) {
            class39 var4 = new class39(var3.field382, var3.field384, var3.field384, this.method411(var3.field382));
            this.field487.add(var4);
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([Lae;B)Z",
      garbageValue = "-33"
   )
   boolean method448(class34[] var1) {
      if(this.field492 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field488 != null) {
            this.method390(0, 0, 64, 64, this.field488, var2);
         } else {
            Iterator var3 = this.field491.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method390(var4.method676() * 8, var4.method664() * 8, 8, 8, var4, var2);
            }
         }

         this.method439(var1, var2);
         this.method392(var2);
         return true;
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IILan;I)V",
      garbageValue = "1066615762"
   )
   void method444(int var1, int var2, class28 var3) {
      field497.method3940(0, var1, var2);

      for(int var4 = 0; var4 < var3.field415; ++var4) {
         class31[] var5 = var3.field420[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method498(var8.field454);
               if(var9 != null) {
                  class39 var10 = (class39)this.field495.get(field497);
                  if(var10 != null) {
                     if(var10.field544 != var9.field3287) {
                        class39 var16 = new class39(var9.field3287, var10.field537, var10.field542, this.method425(var9));
                        this.field495.put(new Coordinates(field497), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field537.plane - var10.field542.plane;
                     var10.field542.plane = var4;
                     var10.field537.plane = var4 + var15;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field500 * 64 + var1, this.field486 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field488 != null) {
                     var12 = new Coordinates(this.field488.field414 + var4, var1 + this.field488.field416 * 64, var2 + this.field488.field411 * 64);
                  } else {
                     Iterator var13 = this.field491.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method666(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field414, var14.field416 * 64 + var1 + var14.method667() * 8, var2 + var14.field411 * 64 + var14.method668() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3287, var12, var11, this.method425(var9));
                     this.field495.put(new Coordinates(field497), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field495.remove(field497);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILan;Law;B)V",
      garbageValue = "1"
   )
   void method454(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field415; ++var5) {
         int var6 = var3.field417[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = class66.method1143(var6, this.field490);
            if(var3.field412[var5][var1][var2] == 0) {
               Rasterizer2D.method4968(this.field484 * var1, this.field484 * (63 - var2), this.field484, this.field484, var7);
            } else {
               var4.method692(this.field484 * var1, this.field484 * (63 - var2), 0, var7, this.field484, this.field484, var3.field412[var5][var1][var2], var3.field423[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lkp;Lis;I)I",
      garbageValue = "1728254073"
   )
   int method409(SpritePixels var1, class240 var2) {
      switch(var2.field3260) {
      case 0:
         return -var1.height / 2;
      case 1:
         return 0;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIILan;Lap;I)V",
      garbageValue = "672486086"
   )
   void method390(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field419[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = class60.method1071(var9);
               var6.method646(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IILan;I)I",
      garbageValue = "1047151795"
   )
   int method455(int var1, int var2, class28 var3) {
      return var3.field419[0][var1][var2] == 0?this.field490:this.field492[var1][var2];
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([Lae;Lap;I)V",
      garbageValue = "-1947458694"
   )
   void method439(class34[] var1, class43 var2) {
      class229[] var3 = new class229[]{class229.field3153, class229.field3145, class229.field3143, class229.field3147, class229.field3148, class229.field3150, class229.field3146, class229.field3144};
      class229[] var5 = var3;

      for(int var6 = 0; var6 < var5.length; ++var6) {
         class229 var7 = var5[var6];
         if(var1[var7.rsOrdinal()] != null) {
            byte var8 = 0;
            byte var9 = 0;
            byte var10 = 64;
            byte var11 = 64;
            byte var12 = 0;
            byte var13 = 0;
            switch(var7.field3149) {
            case 0:
               var8 = 59;
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
               var9 = 59;
               var11 = 5;
               break;
            case 4:
               var9 = 59;
               var11 = 5;
               var12 = 59;
               var10 = 5;
               break;
            case 5:
               var12 = 59;
               var10 = 5;
               break;
            case 6:
               var13 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 7:
               var12 = 59;
               var13 = 59;
               var10 = 5;
               var11 = 5;
            }

            this.method395(var12, var13, var8, var9, var10, var11, var1[var7.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)Lie;",
      garbageValue = "356432458"
   )
   Area method498(int var1) {
      ObjectComposition var2 = class37.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.field3284[var2.mapIconId]:null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lap;I)V",
      garbageValue = "561918403"
   )
   void method392(class43 var1) {
      this.field492 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field492[var2][var3] = var1.method643(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Law;[Lae;[Ljr;B)V",
      garbageValue = "0"
   )
   void method386(class46 var1, class34[] var2, IndexedSprite[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method389(var4, var5, this.field488, var1);
            this.method454(var4, var5, this.field488, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method471(var4, var5, this.field488, var1, var3);
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Law;[Ljr;B)V",
      garbageValue = "-30"
   )
   void method440(class46 var1, IndexedSprite[] var2) {
      Iterator var3 = this.field491.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method676() * 8; var5 < var4.method676() * 8 + 8; ++var5) {
            for(var6 = var4.method664() * 8; var6 < var4.method664() * 8 + 8; ++var6) {
               this.method389(var5, var6, var4, var1);
               this.method454(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field491.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method676() * 8; var5 < var4.method676() * 8 + 8; ++var5) {
            for(var6 = var4.method664() * 8; var6 < var4.method664() * 8 + 8; ++var6) {
               this.method471(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/List;",
      garbageValue = "406589813"
   )
   List method414() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field487);
      var1.addAll(this.field495.values());
      return var1;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lie;IIIII)V",
      garbageValue = "-194502441"
   )
   void method383(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.method4308(false);
      if(var6 != null) {
         var6.method5172(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method4966(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method4966(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IB)Laj;",
      garbageValue = "115"
   )
   class33 method411(int var1) {
      Area var2 = Area.field3284[var1];
      return this.method425(var2);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "220"
   )
   void method406() {
      if(this.field488 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method444(var1, var2, this.field488);
            }
         }
      } else {
         Iterator var5 = this.field491.iterator();

         while(var5.hasNext()) {
            class45 var6 = (class45)var5.next();

            for(int var3 = var6.method676() * 8; var3 < var6.method676() * 8 + 8; ++var3) {
               for(int var4 = var6.method664() * 8; var4 < var6.method664() * 8 + 8; ++var4) {
                  this.method444(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Laz;IIFI)V",
      garbageValue = "1874679586"
   )
   void method402(class39 var1, int var2, int var3, float var4) {
      Area var5 = Area.field3284[var1.field544];
      this.method403(var5, var2, var3);
      this.method421(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;IIB)V",
      garbageValue = "12"
   )
   void method384(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field495.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field544))) {
            Area var6 = Area.field3284[var5.field544];
            this.method383(var6, var5.field536, var5.field543, var2, var3);
         }
      }

      this.method400(var1, var2, var3);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1348731536"
   )
   void method476(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method4979(this.field484 * var1, this.field484 * (63 - var2), this.field484, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method4985(this.field484 * var1, this.field484 * (63 - var2), this.field484, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method4979(this.field484 + this.field484 * var1 - 1, this.field484 * (63 - var2), this.field484, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method4985(this.field484 * var1, this.field484 * (63 - var2) + this.field484 - 1, this.field484, var4);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;B)V",
      garbageValue = "-17"
   )
   void method464(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method399(var1, var2, var4, var3);
      this.method405(var1, var2, var4, var3);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IIIIIB)Ljava/util/List;",
      garbageValue = "-21"
   )
   List method413(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field495.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method566(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field487.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method566(var4, var5)) {
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILaw;[Lae;[Ljr;S)Z",
      garbageValue = "20716"
   )
   boolean method382(int var1, class46 var2, class34[] var3, IndexedSprite[] var4) {
      if(!this.method385(var1)) {
         return false;
      } else if(this.field488 == null && this.field491.isEmpty()) {
         return false;
      } else {
         this.method448(var3);
         this.field493.method5092();
         if(this.field488 != null) {
            this.method386(var2, var3, var4);
         } else {
            this.method440(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIIILae;Lap;I)V",
      garbageValue = "1391528200"
   )
   void method395(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method503(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = class60.method1071(var11);
               var8.method646(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1246038034"
   )
   void method377(int var1, int var2, int var3) {
      if(this.field493 != null) {
         if(var3 == this.field484 * 64) {
            this.field493.method5107(var1, var2);
         } else {
            this.field493.method5090(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lk;Ljava/util/List;I)V",
      garbageValue = "-1878190138"
   )
   void method378(class22 var1, List var2) {
      this.field495.clear();
      this.field488 = var1;
      this.method380(0, 0, 64, 64, this.field488);
      this.method393(var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
      garbageValue = "1602475547"
   )
   void method379(HashSet var1, List var2) {
      this.field495.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method236() == this.field500 && var4.method240() == this.field486) {
            this.field491.add(var4);
            this.method380(var4.method676() * 8, var4.method664() * 8, 8, 8, var4);
         }
      }

      this.method393(var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lia;B)V",
      garbageValue = "56"
   )
   public static void method505(IndexDataBase var0) {
      FloorUnderlayDefinition.underlay_ref = var0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-772252411"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class99.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class99.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
      class99.field1530.put(var5, (long)var5.id);
      class99.field1531.method3665(var5);
      Client.chatCycle = Client.cycleCntr;
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "758013495"
   )
   static final String method465(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?Tile.getColTags(16711680):(var2 < -6?Tile.getColTags(16723968):(var2 < -3?Tile.getColTags(16740352):(var2 < 0?Tile.getColTags(16756736):(var2 > 9?Tile.getColTags('\uff00'):(var2 > 6?Tile.getColTags(4259584):(var2 > 3?Tile.getColTags(8453888):(var2 > 0?Tile.getColTags(12648192):Tile.getColTags(16776960))))))));
   }
}
