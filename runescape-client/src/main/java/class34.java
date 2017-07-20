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

@ObfuscatedName("ak")
public class class34 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   static final Coordinates field475;
   @ObfuscatedName("qt")
   @ObfuscatedSignature(
      signature = "Lcc;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("w")
   List field463;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   SpritePixels field471;
   @ObfuscatedName("k")
   int[][] field470;
   @ObfuscatedName("s")
   LinkedList field467;
   @ObfuscatedName("v")
   HashMap field473;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   class22 field466;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1283685261
   )
   int field464;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1882901427
   )
   int field474;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1291783763
   )
   int field472;
   @ObfuscatedName("h")
   final HashMap field461;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1049186919
   )
   int field465;

   static {
      field475 = new Coordinates();
   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field464 = var1;
      this.field465 = var2;
      this.field467 = new LinkedList();
      this.field463 = new LinkedList();
      this.field473 = new HashMap();
      this.field472 = var3 | -16777216;
      this.field461 = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1474492961"
   )
   boolean method357(int var1) {
      if(this.field471 != null && this.field474 == var1) {
         return false;
      } else {
         this.field474 = var1;
         this.field471 = new SpritePixels(this.field474 * 64, this.field474 * 64);
         return true;
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IILam;I)V",
      garbageValue = "448522790"
   )
   void method405(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field405; ++var4) {
         class31[] var5 = var3.field397[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               if(SceneTilePaint.method2613(var8.field432)) {
                  ObjectComposition var9 = class169.getObjectDefinition(var8.field433);
                  int var10 = var9.field3429 != 0?-3407872:-3355444;
                  if(var8.field432 == class221.field2789.field2803) {
                     this.method387(var1, var2, var8.field426, var10);
                  }

                  if(var8.field432 == class221.field2788.field2803) {
                     this.method387(var1, var2, var8.field426, -3355444);
                     this.method387(var1, var2, var8.field426 + 1, var10);
                  }

                  if(var8.field432 == class221.field2790.field2803) {
                     if(var8.field426 == 0) {
                        Rasterizer2D.method4837(this.field474 * var1, this.field474 * (63 - var2), 1, var10);
                     }

                     if(var8.field426 == 1) {
                        Rasterizer2D.method4837(this.field474 + this.field474 * var1 - 1, this.field474 * (63 - var2), 1, var10);
                     }

                     if(var8.field426 == 2) {
                        Rasterizer2D.method4837(this.field474 + this.field474 * var1 - 1, this.field474 * (63 - var2) + this.field474 - 1, 1, var10);
                     }

                     if(var8.field426 == 3) {
                        Rasterizer2D.method4837(this.field474 * var1, this.field474 * (63 - var2) + this.field474 - 1, 1, var10);
                     }
                  }

                  if(var8.field432 == class221.field2798.field2803) {
                     int var11 = var8.field426 % 2;
                     int var12;
                     if(var11 == 0) {
                        for(var12 = 0; var12 < this.field474; ++var12) {
                           Rasterizer2D.method4837(var12 + this.field474 * var1, (64 - var2) * this.field474 - 1 - var12, 1, var10);
                        }
                     } else {
                        for(var12 = 0; var12 < this.field474; ++var12) {
                           Rasterizer2D.method4837(var12 + this.field474 * var1, var12 + this.field474 * (63 - var2), 1, var10);
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
      garbageValue = "-2041894596"
   )
   void method388(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field473.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var9.worldX * var5 + (float)var1 - var6);
         int var11 = (int)((float)(var2 + var4) - (float)var9.worldY * var5 - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field526 = var10;
            var12.field535 = var11;
            Area var13 = Area.field3265[var12.field531];
            if(!var3.contains(Integer.valueOf(var13.method4187()))) {
               this.method422(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lis;B)Laf;",
      garbageValue = "-60"
   )
   class33 method406(Area var1) {
      if(var1.name != null && this.field461 != null && this.field461.get(class24.field351) != null) {
         int var3 = var1.field3269;
         class24[] var4 = class24.method171();
         int var5 = 0;

         class24 var2;
         while(true) {
            if(var5 >= var4.length) {
               var2 = null;
               break;
            }

            class24 var6 = var4[var5];
            if(var3 == var6.field345) {
               var2 = var6;
               break;
            }

            ++var5;
         }

         if(var2 == null) {
            return null;
         } else {
            Font var14 = (Font)this.field461.get(var2);
            if(var14 == null) {
               return null;
            } else {
               int var15 = var14.method4638(var1.name, 1000000);
               String[] var7 = new String[var15];
               var14.method4636(var1.name, (int[])null, var7);
               int var8 = var7.length * var14.verticalSpace / 2;
               int var9 = 0;
               String[] var10 = var7;

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  String var12 = var10[var11];
                  int var13 = var14.method4635(var12);
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

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lis;IIB)V",
      garbageValue = "-60"
   )
   void method375(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.method4181(false);
      if(var4 != null) {
         int var5 = this.method380(var4, var1.field3280);
         int var6 = this.method381(var4, var1.field3276);
         var4.method4958(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IILam;[Ljx;I)V",
      garbageValue = "-1238454493"
   )
   void method392(int var1, int var2, class28 var3, ModIcon[] var4) {
      for(int var5 = 0; var5 < var3.field405; ++var5) {
         class31[] var6 = var3.field397[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               if(!MouseInput.method972(var9.field432)) {
                  int var11 = var9.field432;
                  boolean var10 = var11 == class221.field2809.field2803;
                  if(!var10) {
                     continue;
                  }
               }

               ObjectComposition var12 = class169.getObjectDefinition(var9.field433);
               if(var12.mapSceneId != -1) {
                  if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                     var4[var12.mapSceneId].method4927(this.field474 * var1, this.field474 * (63 - var2), this.field474 * 2, this.field474 * 2);
                  } else {
                     var4[var12.mapSceneId].method4927(this.field474 * var1, this.field474 * (63 - var2), this.field474 * 2 + 1, this.field474 * 2 + 1);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "2125952086"
   )
   void method377(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field463.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field537.worldX % 64;
         int var9 = var7.field537.worldY % 64;
         var7.field526 = (int)((float)var8 * var5 + (float)var1);
         var7.field535 = (int)((float)var2 + (float)(63 - var9) * var5);
         if(!var3.contains(Integer.valueOf(var7.field531))) {
            this.method422(var7, var7.field526, var7.field535, var5);
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IILam;Laq;B)V",
      garbageValue = "3"
   )
   void method361(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field398[0][var1][var2] - 1;
      int var6 = var3.field399[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.method4828(this.field474 * var1, this.field474 * (63 - var2), this.field474, this.field474, this.field472);
      }

      int var7 = 16711935;
      if(var6 != -1) {
         var7 = VertexNormal.method2522(var6, this.field472);
      }

      if(var6 > -1 && var3.field400[0][var1][var2] == 0) {
         Rasterizer2D.method4828(this.field474 * var1, this.field474 * (63 - var2), this.field474, this.field474, var7);
      } else {
         int var8 = this.method368(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.method4828(this.field474 * var1, this.field474 * (63 - var2), this.field474, this.field474, var8);
         } else {
            var4.method628(this.field474 * var1, this.field474 * (63 - var2), var8, var7, this.field474, this.field474, var3.field400[0][var1][var2], var3.field401[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Ljj;Lil;B)I",
      garbageValue = "113"
   )
   int method380(SpritePixels var1, class257 var2) {
      switch(var2.field3524) {
      case 1:
         return 0;
      case 2:
         return -var1.width / 2;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1526235096"
   )
   int method370(int var1, int var2) {
      if(this.field466 != null) {
         return this.field466.method220(var1, var2);
      } else {
         if(!this.field467.isEmpty()) {
            Iterator var3 = this.field467.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method608(var1, var2)) {
                  return var4.method220(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Lad;Lis;IIFB)V",
      garbageValue = "7"
   )
   void method385(class39 var1, Area var2, int var3, int var4, float var5) {
      if(var1.field533 != null) {
         if(var1.field533.field454.method172(var5)) {
            Font var6 = (Font)this.field461.get(var1.field533.field454);
            var6.method4644(var1.field533.field457, var3 - var1.field533.field452 / 2, var4, var1.field533.field452, var1.field533.field453, -16777216 | var2.field3268, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IILam;Laq;[Ljx;I)V",
      garbageValue = "-1203149734"
   )
   void method360(int var1, int var2, class28 var3, class46 var4, ModIcon[] var5) {
      this.method405(var1, var2, var3);
      this.method392(var1, var2, var3, var5);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "1907729666"
   )
   void method372(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field463.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         Area var6 = Area.field3265[var5.field531];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4187()))) {
            this.method478(var6, var5.field526, var5.field535, var2, var3);
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([Lak;I)Z",
      garbageValue = "106329336"
   )
   boolean method349(class34[] var1) {
      if(this.field470 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field466 != null) {
            this.method366(0, 0, 64, 64, this.field466, var2);
         } else {
            Iterator var3 = this.field467.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method366(var4.method611() * 8, var4.method609() * 8, 8, 8, var4, var2);
            }
         }

         this.method365(var1, var2);
         this.method364(var2);
         return true;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;I)V",
      garbageValue = "-2108682560"
   )
   void method353(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field352.worldX >> 6 == this.field464 && var3.field352.worldY >> 6 == this.field465) {
            class39 var4 = new class39(var3.field356, var3.field352, var3.field352, this.method373(var3.field356));
            this.field463.add(var4);
         }
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IILam;I)V",
      garbageValue = "-2005617011"
   )
   void method379(int var1, int var2, class28 var3) {
      field475.method3874(0, var1, var2);

      for(int var4 = 0; var4 < var3.field405; ++var4) {
         class31[] var5 = var3.field397[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method382(var8.field433);
               if(var9 != null) {
                  class39 var10 = (class39)this.field473.get(field475);
                  if(var10 != null) {
                     if(var10.field531 != var9.field3275) {
                        class39 var16 = new class39(var9.field3275, var10.field532, var10.field537, this.method406(var9));
                        this.field473.put(new Coordinates(field475), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field532.plane - var10.field537.plane;
                     var10.field537.plane = var4;
                     var10.field532.plane = var4 + var15;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field464 * 64 + var1, this.field465 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field466 != null) {
                     var12 = new Coordinates(this.field466.field396 + var4, this.field466.field403 * 64 + var1, this.field466.field393 * 64 + var2);
                  } else {
                     Iterator var13 = this.field467.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method608(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field396, var14.field403 * 64 + var1 + var14.method625() * 8, var14.field393 * 64 + var2 + var14.method606() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3275, var12, var11, this.method406(var9));
                     this.field473.put(new Coordinates(field475), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field473.remove(field475);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIILam;B)V",
      garbageValue = "0"
   )
   void method434(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label56:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field405; ++var9) {
               class31[] var10 = var5.field397[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method382(var13.field433);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, var6 + this.field464 * 64, var7 + this.field465 * 64);
                        Coordinates var16 = null;
                        if(this.field466 != null) {
                           var16 = new Coordinates(this.field466.field396 + var9, var6 + this.field466.field403 * 64, var7 + this.field466.field393 * 64);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var9 + var17.field396, var6 + var17.field403 * 64 + var17.method625() * 8, var7 + var17.field393 * 64 + var17.method606() * 8);
                        }

                        class39 var18 = new class39(var14.field3275, var16, var15, this.method406(var14));
                        this.field473.put(var8, var18);
                        continue label56;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IILam;Laq;I)V",
      garbageValue = "1802381038"
   )
   void method415(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field405; ++var5) {
         int var6 = var3.field399[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = VertexNormal.method2522(var6, this.field472);
            if(var3.field400[var5][var1][var2] == 0) {
               Rasterizer2D.method4828(this.field474 * var1, this.field474 * (63 - var2), this.field474, this.field474, var7);
            } else {
               var4.method628(this.field474 * var1, this.field474 * (63 - var2), 0, var7, this.field474, this.field474, var3.field400[var5][var1][var2], var3.field401[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Ljj;Lir;B)I",
      garbageValue = "-40"
   )
   int method381(SpritePixels var1, class239 var2) {
      switch(var2.field3247) {
      case 0:
         return 0;
      case 2:
         return -var1.height / 2;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIILam;Lax;I)V",
      garbageValue = "-828555211"
   )
   void method366(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field398[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = class163.method3000(var9);
               var6.method592(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IILam;I)I",
      garbageValue = "-915102365"
   )
   int method368(int var1, int var2, class28 var3) {
      return var3.field398[0][var1][var2] == 0?this.field472:this.field470[var1][var2];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([Lak;Lax;B)V",
      garbageValue = "-45"
   )
   void method365(class34[] var1, class43 var2) {
      class228[] var3 = new class228[]{class228.field3131, class228.field3121, class228.field3128, class228.field3122, class228.field3124, class228.field3120, class228.field3125, class228.field3126};
      class228[] var5 = var3;

      for(int var6 = 0; var6 < var5.length; ++var6) {
         class228 var7 = var5[var6];
         if(var1[var7.rsOrdinal()] != null) {
            byte var8 = 0;
            byte var9 = 0;
            byte var10 = 64;
            byte var11 = 64;
            byte var12 = 0;
            byte var13 = 0;
            switch(var7.field3127) {
            case 0:
               var12 = 59;
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
               break;
            case 3:
               var8 = 59;
               var10 = 5;
               break;
            case 4:
               var12 = 59;
               var13 = 59;
               var10 = 5;
               var11 = 5;
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
               var9 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
            }

            this.method367(var12, var13, var8, var9, var10, var11, var1[var7.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)Lis;",
      garbageValue = "297640335"
   )
   Area method382(int var1) {
      ObjectComposition var2 = class169.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.field3265[var2.mapIconId]:null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lax;B)V",
      garbageValue = "125"
   )
   void method364(class43 var1) {
      this.field470 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field470[var2][var3] = var1.method587(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Laq;[Ljx;I)V",
      garbageValue = "2040435981"
   )
   void method363(class46 var1, ModIcon[] var2) {
      Iterator var3 = this.field467.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method611() * 8; var5 < var4.method611() * 8 + 8; ++var5) {
            for(var6 = var4.method609() * 8; var6 < var4.method609() * 8 + 8; ++var6) {
               this.method361(var5, var6, var4, var1);
               this.method415(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field467.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method611() * 8; var5 < var4.method611() * 8 + 8; ++var5) {
            for(var6 = var4.method609() * 8; var6 < var4.method609() * 8 + 8; ++var6) {
               this.method360(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Laq;[Lak;[Ljx;B)V",
      garbageValue = "-111"
   )
   void method431(class46 var1, class34[] var2, ModIcon[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method361(var4, var5, this.field466, var1);
            this.method415(var4, var5, this.field466, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method360(var4, var5, this.field466, var1, var3);
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/List;",
      garbageValue = "88865827"
   )
   List method386() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field463);
      var1.addAll(this.field473.values());
      return var1;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lis;IIIII)V",
      garbageValue = "-147027285"
   )
   void method478(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.method4181(false);
      if(var6 != null) {
         var6.method4958(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method4826(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method4826(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)Laf;",
      garbageValue = "-505074265"
   )
   class33 method373(int var1) {
      Area var2 = Area.field3265[var1];
      return this.method406(var2);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "13"
   )
   void method378() {
      if(this.field466 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method379(var1, var2, this.field466);
            }
         }
      } else {
         Iterator var5 = this.field467.iterator();

         while(var5.hasNext()) {
            class45 var6 = (class45)var5.next();

            for(int var3 = var6.method611() * 8; var3 < var6.method611() * 8 + 8; ++var3) {
               for(int var4 = var6.method609() * 8; var4 < var6.method609() * 8 + 8; ++var4) {
                  this.method379(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lad;IIFI)V",
      garbageValue = "-27019539"
   )
   void method422(class39 var1, int var2, int var3, float var4) {
      Area var5 = Area.field3265[var1.field531];
      this.method375(var5, var2, var3);
      this.method385(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-1284554914"
   )
   void method403(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field473.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field531))) {
            Area var6 = Area.field3265[var5.field531];
            this.method478(var6, var5.field526, var5.field535, var2, var3);
         }
      }

      this.method372(var1, var2, var3);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "694680586"
   )
   void method387(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method4864(this.field474 * var1, this.field474 * (63 - var2), this.field474, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method4837(this.field474 * var1, this.field474 * (63 - var2), this.field474, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method4864(this.field474 * var1 + this.field474 - 1, this.field474 * (63 - var2), this.field474, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method4837(this.field474 * var1, this.field474 * (63 - var2) + this.field474 - 1, this.field474, var4);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "734856613"
   )
   void method355(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method388(var1, var2, var4, var3);
      this.method377(var1, var2, var4, var3);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIIIIB)Ljava/util/List;",
      garbageValue = "102"
   )
   List method437(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field473.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method521(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field463.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method521(var4, var5)) {
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILaq;[Lak;[Ljx;B)Z",
      garbageValue = "6"
   )
   boolean method354(int var1, class46 var2, class34[] var3, ModIcon[] var4) {
      if(!this.method357(var1)) {
         return false;
      } else if(this.field466 == null && this.field467.isEmpty()) {
         return false;
      } else {
         this.method349(var3);
         this.field471.method4949();
         if(this.field466 != null) {
            this.method431(var2, var3, var4);
         } else {
            this.method363(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIIILak;Lax;B)V",
      garbageValue = "11"
   )
   void method367(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method370(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = class163.method3000(var11);
               var8.method592(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1277499287"
   )
   void method417(int var1, int var2, int var3) {
      if(this.field471 != null) {
         if(var3 == this.field474 * 64) {
            this.field471.method4956(var1, var2);
         } else {
            this.field471.method4973(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ln;Ljava/util/List;I)V",
      garbageValue = "-1128487061"
   )
   void method350(class22 var1, List var2) {
      this.field473.clear();
      this.field466 = var1;
      this.method434(0, 0, 64, 64, this.field466);
      this.method353(var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;B)V",
      garbageValue = "1"
   )
   void method376(HashSet var1, List var2) {
      this.field473.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method236() == this.field464 && var4.method222() == this.field465) {
            this.field467.add(var4);
            this.method434(var4.method611() * 8, var4.method609() * 8, 8, 8, var4);
         }
      }

      this.method353(var2);
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(Lho;Lic;IIZB)V",
      garbageValue = "-19"
   )
   static final void method460(Widget var0, ItemComposition var1, int var2, int var3, boolean var4) {
      String[] var5 = var1.inventoryActions;
      byte var6 = -1;
      String var7 = null;
      if(var5 != null && var5[var3] != null) {
         if(var3 == 0) {
            var6 = 33;
         } else if(var3 == 1) {
            var6 = 34;
         } else if(var3 == 2) {
            var6 = 35;
         } else if(var3 == 3) {
            var6 = 36;
         } else {
            var6 = 37;
         }

         var7 = var5[var3];
      } else if(var3 == 4) {
         var6 = 37;
         var7 = "Drop";
      }

      if(var6 != -1 && var7 != null) {
         String var9 = class8.getColTags(16748608) + var1.name;
         int var11 = var1.id;
         int var13 = var0.id;
         if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var7;
            Client.menuTargets[Client.menuOptionCount] = var9;
            Client.menuTypes[Client.menuOptionCount] = var6;
            Client.menuIdentifiers[Client.menuOptionCount] = var11;
            Client.menuActionParams0[Client.menuOptionCount] = var2;
            Client.menuActionParams1[Client.menuOptionCount] = var13;
            Client.field984[Client.menuOptionCount] = var4;
            ++Client.menuOptionCount;
         }
      }

   }
}
