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
   @ObfuscatedName("pk")
   @ObfuscatedGetter(
      intValue = -2072813541
   )
   static int field467;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   static final Coordinates field464;
   @ObfuscatedName("aq")
   static int[] field466;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -967898601
   )
   static int field465;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -971486229
   )
   int field452;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 904335891
   )
   int field451;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ld;"
   )
   class22 field455;
   @ObfuscatedName("e")
   LinkedList field456;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -634981445
   )
   int field457;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 275358129
   )
   int field458;
   @ObfuscatedName("n")
   int[][] field459;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   SpritePixels field454;
   @ObfuscatedName("a")
   List field461;
   @ObfuscatedName("y")
   HashMap field462;
   @ObfuscatedName("w")
   final HashMap field463;

   static {
      field464 = new Coordinates();
   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field452 = var1;
      this.field451 = var2;
      this.field456 = new LinkedList();
      this.field461 = new LinkedList();
      this.field462 = new HashMap();
      this.field457 = var3 | -16777216;
      this.field463 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1382862972"
   )
   void method486(int var1, int var2, int var3) {
      if(this.field454 != null) {
         if(var3 == this.field458 * 64) {
            this.field454.method5276(var1, var2);
         } else {
            this.field454.method5293(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ld;Ljava/util/List;I)V",
      garbageValue = "-1443740959"
   )
   void method400(class22 var1, List var2) {
      this.field462.clear();
      this.field455 = var1;
      this.method402(0, 0, 64, 64, this.field455);
      this.method403(var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
      garbageValue = "-1252628295"
   )
   void method434(HashSet var1, List var2) {
      this.field462.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method265() == this.field452 && var4.method249() == this.field451) {
            this.field456.add(var4);
            this.method402(var4.method699() * 8, var4.method700() * 8, 8, 8, var4);
         }
      }

      this.method403(var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIILaq;I)V",
      garbageValue = "282444750"
   )
   void method402(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label57:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field391; ++var9) {
               class31[] var10 = var5.field401[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method447(var13.field429);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field452 * 64 + var6, this.field451 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field455 != null) {
                           var16 = new Coordinates(this.field455.field395 + var9, var6 + this.field455.field399 * 64, var7 + this.field455.field392 * 64);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var9 + var17.field395, var6 + var17.field399 * 64 + var17.method702() * 8, var7 + var17.field392 * 64 + var17.method698() * 8);
                        }

                        class39 var18 = new class39(var14.field3352, var16, var15, this.method419(var14));
                        this.field462.put(var8, var18);
                        continue label57;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;I)V",
      garbageValue = "37821"
   )
   void method403(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field359.worldX >> 6 == this.field452 && var3.field359.worldY >> 6 == this.field451) {
            class39 var4 = new class39(var3.field357, var3.field359, var3.field359, this.method433(var3.field357));
            this.field461.add(var4);
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILaf;[Lak;[Lko;I)Z",
      garbageValue = "268228049"
   )
   boolean method404(int var1, class46 var2, class34[] var3, IndexedSprite[] var4) {
      if(!this.method407(var1)) {
         return false;
      } else if(this.field455 == null && this.field456.isEmpty()) {
         return false;
      } else {
         this.method484(var3);
         this.field454.method5269();
         if(this.field455 != null) {
            this.method522(var2, var3, var4);
         } else {
            this.method409(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "1805060066"
   )
   void method405(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method421(var1, var2, var4, var3);
      this.method427(var1, var2, var4, var3);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;IIB)V",
      garbageValue = "-96"
   )
   void method432(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field462.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field508))) {
            Area var6 = Area.field3358[var5.field508];
            this.method423(var6, var5.field504, var5.field505, var2, var3);
         }
      }

      this.method422(var1, var2, var3);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "103"
   )
   boolean method407(int var1) {
      if(this.field454 != null && this.field458 == var1) {
         return false;
      } else {
         this.field458 = var1;
         this.field454 = new SpritePixels(this.field458 * 64, this.field458 * 64);
         return true;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Laf;[Lak;[Lko;I)V",
      garbageValue = "-730285290"
   )
   void method522(class46 var1, class34[] var2, IndexedSprite[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method411(var4, var5, this.field455, var1);
            this.method412(var4, var5, this.field455, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method410(var4, var5, this.field455, var1, var3);
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Laf;[Lko;I)V",
      garbageValue = "-133423352"
   )
   void method409(class46 var1, IndexedSprite[] var2) {
      Iterator var3 = this.field456.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method699() * 8; var5 < var4.method699() * 8 + 8; ++var5) {
            for(var6 = var4.method700() * 8; var6 < var4.method700() * 8 + 8; ++var6) {
               this.method411(var5, var6, var4, var1);
               this.method412(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field456.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method699() * 8; var5 < var4.method699() * 8 + 8; ++var5) {
            for(var6 = var4.method700() * 8; var6 < var4.method700() * 8 + 8; ++var6) {
               this.method410(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILaq;Laf;[Lko;I)V",
      garbageValue = "1610142638"
   )
   void method410(int var1, int var2, class28 var3, class46 var4, IndexedSprite[] var5) {
      this.method399(var1, var2, var3);
      this.method509(var1, var2, var3, var5);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IILaq;Laf;I)V",
      garbageValue = "-898629955"
   )
   void method411(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field396[0][var1][var2] - 1;
      int var6 = var3.field397[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.method5151(this.field458 * var1, this.field458 * (63 - var2), this.field458, this.field458, this.field457);
      }

      int var7 = 16711935;
      if(var6 != -1) {
         var7 = class72.method1179(var6, this.field457);
      }

      if(var6 > -1 && var3.field398[0][var1][var2] == 0) {
         Rasterizer2D.method5151(this.field458 * var1, this.field458 * (63 - var2), this.field458, this.field458, var7);
      } else {
         int var8 = this.method418(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.method5151(this.field458 * var1, this.field458 * (63 - var2), this.field458, this.field458, var8);
         } else {
            var4.method724(this.field458 * var1, this.field458 * (63 - var2), var8, var7, this.field458, this.field458, var3.field398[0][var1][var2], var3.field400[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IILaq;Laf;B)V",
      garbageValue = "25"
   )
   void method412(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field391; ++var5) {
         int var6 = var3.field397[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = class72.method1179(var6, this.field457);
            if(var3.field398[var5][var1][var2] == 0) {
               Rasterizer2D.method5151(this.field458 * var1, this.field458 * (63 - var2), this.field458, this.field458, var7);
            } else {
               var4.method724(this.field458 * var1, this.field458 * (63 - var2), 0, var7, this.field458, this.field458, var3.field398[var5][var1][var2], var3.field400[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([Lak;I)Z",
      garbageValue = "1581972063"
   )
   boolean method484(class34[] var1) {
      if(this.field459 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field455 != null) {
            this.method416(0, 0, 64, 64, this.field455, var2);
         } else {
            Iterator var3 = this.field456.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method416(var4.method699() * 8, var4.method700() * 8, 8, 8, var4, var2);
            }
         }

         this.method415(var1, var2);
         this.method414(var2);
         return true;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lac;I)V",
      garbageValue = "-1553499641"
   )
   void method414(class43 var1) {
      this.field459 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field459[var2][var3] = var1.method672(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([Lak;Lac;I)V",
      garbageValue = "1189934992"
   )
   void method415(class34[] var1, class43 var2) {
      class235[] var3 = Tile.method2610();
      class235[] var4 = var3;

      for(int var5 = 0; var5 < var4.length; ++var5) {
         class235 var6 = var4[var5];
         if(var1[var6.rsOrdinal()] != null) {
            byte var7 = 0;
            byte var8 = 0;
            byte var9 = 64;
            byte var10 = 64;
            byte var11 = 0;
            byte var12 = 0;
            switch(var6.field3226) {
            case 0:
               var8 = 59;
               var10 = 5;
               break;
            case 1:
               var11 = 59;
               var12 = 59;
               var9 = 5;
               var10 = 5;
               break;
            case 2:
               var8 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
               break;
            case 3:
               var12 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
               break;
            case 4:
               var12 = 59;
               var10 = 5;
               break;
            case 5:
               var7 = 59;
               var9 = 5;
               break;
            case 6:
               var11 = 59;
               var9 = 5;
               break;
            case 7:
               var8 = 59;
               var10 = 5;
               var11 = 59;
               var9 = 5;
            }

            this.method417(var11, var12, var7, var8, var9, var10, var1[var6.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIILaq;Lac;B)V",
      garbageValue = "-102"
   )
   void method416(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field396[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = class2.method4(var9);
               var6.method677(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIIILak;Lac;B)V",
      garbageValue = "-117"
   )
   void method417(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method438(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = class2.method4(var11);
               var8.method677(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILaq;I)I",
      garbageValue = "178759762"
   )
   int method418(int var1, int var2, class28 var3) {
      return var3.field396[0][var1][var2] == 0?this.field457:this.field459[var1][var2];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IILaq;[Lko;I)V",
      garbageValue = "891535130"
   )
   void method509(int var1, int var2, class28 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field391; ++var5) {
         class31[] var6 = var3.field401[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               int var11 = var9.field423;
               boolean var10 = var11 >= class228.field2900.field2887 && var11 <= class228.field2901.field2887;
               if(var10 || class148.method3010(var9.field423)) {
                  ObjectComposition var12 = class24.getObjectDefinition(var9.field429);
                  if(var12.mapSceneId != -1) {
                     if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                        var4[var12.mapSceneId].method5252(this.field458 * var1, this.field458 * (63 - var2), this.field458 * 2, this.field458 * 2);
                     } else {
                        var4[var12.mapSceneId].method5252(this.field458 * var1, this.field458 * (63 - var2), this.field458 * 2 + 1, this.field458 * 2 + 1);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IILaq;I)V",
      garbageValue = "-105296475"
   )
   void method399(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field391; ++var4) {
         class31[] var5 = var3.field401[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               if(SoundTask.method2168(var8.field423)) {
                  ObjectComposition var9 = class24.getObjectDefinition(var8.field429);
                  int var10 = var9.field3506 != 0?-3407872:-3355444;
                  if(var8.field423 == class228.field2888.field2887) {
                     this.method437(var1, var2, var8.field424, var10);
                  }

                  if(var8.field423 == class228.field2882.field2887) {
                     this.method437(var1, var2, var8.field424, -3355444);
                     this.method437(var1, var2, var8.field424 + 1, var10);
                  }

                  if(var8.field423 == class228.field2883.field2887) {
                     if(var8.field424 == 0) {
                        Rasterizer2D.method5230(this.field458 * var1, this.field458 * (63 - var2), 1, var10);
                     }

                     if(var8.field424 == 1) {
                        Rasterizer2D.method5230(this.field458 * var1 + this.field458 - 1, this.field458 * (63 - var2), 1, var10);
                     }

                     if(var8.field424 == 2) {
                        Rasterizer2D.method5230(this.field458 + this.field458 * var1 - 1, this.field458 * (63 - var2) + this.field458 - 1, 1, var10);
                     }

                     if(var8.field424 == 3) {
                        Rasterizer2D.method5230(this.field458 * var1, this.field458 * (63 - var2) + this.field458 - 1, 1, var10);
                     }
                  }

                  if(var8.field423 == class228.field2884.field2887) {
                     int var11 = var8.field424 % 2;
                     int var12;
                     if(var11 == 0) {
                        for(var12 = 0; var12 < this.field458; ++var12) {
                           Rasterizer2D.method5230(var12 + this.field458 * var1, (64 - var2) * this.field458 - 1 - var12, 1, var10);
                        }
                     } else {
                        for(var12 = 0; var12 < this.field458; ++var12) {
                           Rasterizer2D.method5230(var12 + this.field458 * var1, var12 + this.field458 * (63 - var2), 1, var10);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-1986100084"
   )
   void method421(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field462.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var1 + (float)var9.worldX * var5 - var6);
         int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.worldY - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field504 = var10;
            var12.field505 = var11;
            Area var13 = Area.field3358[var12.field508];
            if(!var3.contains(Integer.valueOf(var13.method4482()))) {
               this.method525(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-1248091645"
   )
   void method422(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field461.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         Area var6 = Area.field3358[var5.field508];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4482()))) {
            this.method423(var6, var5.field504, var5.field505, var2, var3);
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Lif;IIIII)V",
      garbageValue = "-260282010"
   )
   void method423(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.method4485(false);
      if(var6 != null) {
         var6.drawAt(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method5149(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method5149(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lay;IIFI)V",
      garbageValue = "1514195518"
   )
   void method525(class39 var1, int var2, int var3, float var4) {
      Area var5 = Area.field3358[var1.field508];
      this.method425(var5, var2, var3);
      this.method426(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lif;III)V",
      garbageValue = "-853597990"
   )
   void method425(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.method4485(false);
      if(var4 != null) {
         int var5 = this.method430(var4, var1.field3348);
         int var6 = this.method431(var4, var1.field3349);
         var4.drawAt(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lay;Lif;IIFI)V",
      garbageValue = "-1284383238"
   )
   void method426(class39 var1, Area var2, int var3, int var4, float var5) {
      if(var1.field503 != null) {
         if(var1.field503.field446.method193(var5)) {
            Font var6 = (Font)this.field463.get(var1.field503.field446);
            var6.method4935(var1.field503.field447, var3 - var1.field503.field448 / 2, var4, var1.field503.field448, var1.field503.field445, -16777216 | var2.field3366, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;IB)V",
      garbageValue = "1"
   )
   void method427(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field461.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field499.worldX % 64;
         int var9 = var7.field499.worldY % 64;
         var7.field504 = (int)(var5 * (float)var8 + (float)var1);
         var7.field505 = (int)((float)var2 + (float)(63 - var9) * var5);
         if(!var3.contains(Integer.valueOf(var7.field508))) {
            this.method525(var7, var7.field504, var7.field505, var5);
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1546430315"
   )
   void method532() {
      if(this.field455 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method408(var1, var2, this.field455);
            }
         }
      } else {
         Iterator var5 = this.field456.iterator();

         while(var5.hasNext()) {
            class45 var6 = (class45)var5.next();

            for(int var3 = var6.method699() * 8; var3 < var6.method699() * 8 + 8; ++var3) {
               for(int var4 = var6.method700() * 8; var4 < var6.method700() * 8 + 8; ++var4) {
                  this.method408(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IILaq;I)V",
      garbageValue = "-2049367388"
   )
   void method408(int var1, int var2, class28 var3) {
      field464.method4092(0, var1, var2);

      for(int var4 = 0; var4 < var3.field391; ++var4) {
         class31[] var5 = var3.field401[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method447(var8.field429);
               if(var9 != null) {
                  class39 var10 = (class39)this.field462.get(field464);
                  if(var10 != null) {
                     if(var9.field3352 != var10.field508) {
                        class39 var16 = new class39(var9.field3352, var10.field498, var10.field499, this.method419(var9));
                        this.field462.put(new Coordinates(field464), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field498.plane - var10.field499.plane;
                     var10.field499.plane = var4;
                     var10.field498.plane = var4 + var15;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field452 * 64 + var1, this.field451 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field455 != null) {
                     var12 = new Coordinates(this.field455.field395 + var4, this.field455.field399 * 64 + var1, var2 + this.field455.field392 * 64);
                  } else {
                     Iterator var13 = this.field456.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method695(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field395, var1 + var14.field399 * 64 + var14.method702() * 8, var2 + var14.field392 * 64 + var14.method698() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3352, var12, var11, this.method419(var9));
                     this.field462.put(new Coordinates(field464), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field462.remove(field464);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Lkd;Lju;B)I",
      garbageValue = "0"
   )
   int method430(SpritePixels var1, class264 var2) {
      switch(var2.field3598) {
      case 0:
         return 0;
      case 2:
         return -var1.width / 2;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lkd;Lic;B)I",
      garbageValue = "65"
   )
   int method431(SpritePixels var1, class246 var2) {
      switch(var2.field3338) {
      case 0:
         return 0;
      case 2:
         return -var1.height / 2;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IS)Lif;",
      garbageValue = "-6572"
   )
   Area method447(int var1) {
      ObjectComposition var2 = class24.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.field3358[var2.mapIconId]:null;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IB)Lav;",
      garbageValue = "-121"
   )
   class33 method433(int var1) {
      Area var2 = Area.field3358[var1];
      return this.method419(var2);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lif;I)Lav;",
      garbageValue = "-1880540434"
   )
   class33 method419(Area var1) {
      if(var1.name != null && this.field463 != null && this.field463.get(class24.field356) != null) {
         class24 var2 = class24.method195(var1.field3354);
         if(var2 == null) {
            return null;
         } else {
            Font var3 = (Font)this.field463.get(var2);
            if(var3 == null) {
               return null;
            } else {
               int var4 = var3.method4929(var1.name, 1000000);
               String[] var5 = new String[var4];
               var3.method4927(var1.name, (int[])null, var5);
               int var6 = var5.length * var3.verticalSpace / 2;
               int var7 = 0;
               String[] var8 = var5;

               for(int var9 = 0; var9 < var8.length; ++var9) {
                  String var10 = var8[var9];
                  int var11 = var3.method4926(var10);
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

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IIIIII)Ljava/util/List;",
      garbageValue = "1399965610"
   )
   List method435(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field462.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method583(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field461.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
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
      garbageValue = "2104625274"
   )
   List method466() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field461);
      var1.addAll(this.field462.values());
      return var1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1271589844"
   )
   void method437(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method5182(this.field458 * var1, this.field458 * (63 - var2), this.field458, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5230(this.field458 * var1, this.field458 * (63 - var2), this.field458, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5182(this.field458 + this.field458 * var1 - 1, this.field458 * (63 - var2), this.field458, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5230(this.field458 * var1, this.field458 * (63 - var2) + this.field458 - 1, this.field458, var4);
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1410525179"
   )
   int method438(int var1, int var2) {
      if(this.field455 != null) {
         return this.field455.method247(var1, var2);
      } else {
         if(!this.field456.isEmpty()) {
            Iterator var3 = this.field456.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method695(var1, var2)) {
                  return var4.method247(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Lie;",
      garbageValue = "-1438679490"
   )
   public static class250 method538(int var0) {
      class250 var1 = (class250)class250.field3371.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class222.field2712.getConfigData(19, var0);
         var1 = new class250();
         if(var2 != null) {
            var1.method4491(new Buffer(var2));
         }

         class250.field3371.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Z",
      garbageValue = "21"
   )
   static boolean method491(String var0, int var1) {
      return World.method1670(var0, var1, "openjs");
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-2077707427"
   )
   static synchronized void method536(byte[] var0) {
      if(var0.length == 100 && class181.field2502 < 1000) {
         class181.field2505[++class181.field2502 - 1] = var0;
      } else if(var0.length == 5000 && class181.field2503 < 250) {
         class181.field2506[++class181.field2503 - 1] = var0;
      } else if(var0.length == 30000 && class181.field2504 < 50) {
         class181.field2507[++class181.field2504 - 1] = var0;
      } else {
         if(AbstractByteBuffer.field2513 != null) {
            for(int var1 = 0; var1 < BuildType.field3245.length; ++var1) {
               if(var0.length == BuildType.field3245[var1] && FaceNormal.field2051[var1] < AbstractByteBuffer.field2513[var1].length) {
                  AbstractByteBuffer.field2513[var1][FaceNormal.field2051[var1]++] = var0;
                  return;
               }
            }
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Lko;",
      garbageValue = "-1577786521"
   )
   static IndexedSprite method511() {
      IndexedSprite var0 = new IndexedSprite();
      var0.width = class295.field3850;
      var0.originalHeight = class295.field3851;
      var0.offsetX = class295.field3853[0];
      var0.offsetY = class37.offsetsY[0];
      var0.originalWidth = ItemContainer.field745[0];
      var0.height = class31.field428[0];
      var0.palette = class295.field3852;
      var0.pixels = class295.spritePixels[0];
      class276.method5044();
      return var0;
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(Lbq;IIS)V",
      garbageValue = "-29341"
   )
   static void method503(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = ItemLayer.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1179 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1163 = 0;
         }

         if(var3 == 2) {
            var0.field1163 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || ItemLayer.getAnimation(var1).forcedPriority >= ItemLayer.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1179 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1163 = 0;
         var0.field1186 = var0.queueSize;
      }

   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-518029986"
   )
   static void method495() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "-34"
   )
   static final void method534(String var0, boolean var1) {
      if(var0 != null) {
         if((Client.ignoreCount < 100 || Client.field971 == 1) && Client.ignoreCount < 400) {
            String var2 = PacketBuffer.method3598(var0, class60.field718);
            if(var2 != null) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < Client.ignoreCount; ++var3) {
                  Ignore var4 = Client.ignores[var3];
                  var5 = PacketBuffer.method3598(var4.name, class60.field718);
                  if(var5 != null && var5.equals(var2)) {
                     class96.sendGameMessage(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(var4.previousName != null) {
                     var6 = PacketBuffer.method3598(var4.previousName, class60.field718);
                     if(var6 != null && var6.equals(var2)) {
                        class96.sendGameMessage(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < Client.friendCount; ++var3) {
                  Friend var8 = Client.friends[var3];
                  var5 = PacketBuffer.method3598(var8.name, class60.field718);
                  if(var5 != null && var5.equals(var2)) {
                     class96.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(var8.previousName != null) {
                     var6 = PacketBuffer.method3598(var8.previousName, class60.field718);
                     if(var6 != null && var6.equals(var2)) {
                        class96.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(PacketBuffer.method3598(class48.localPlayer.name, class60.field718).equals(var2)) {
                  class96.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  class170 var7 = Actor.method1628(class167.field2346, Client.field952.field1478);
                  var7.field2423.putByte(Projectile.getLength(var0));
                  var7.field2423.putString(var0);
                  Client.field952.method1951(var7);
               }
            }
         } else {
            class96.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }
}
