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

@ObfuscatedName("ao")
public class class34 {
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = 452731593
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   static final Coordinates field453;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 728147721
   )
   int field442;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -188465401
   )
   int field443;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lz;"
   )
   class22 field444;
   @ObfuscatedName("u")
   LinkedList field440;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1614373739
   )
   int field446;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1866802489
   )
   int field441;
   @ObfuscatedName("n")
   int[][] field448;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   SpritePixels field449;
   @ObfuscatedName("o")
   List field447;
   @ObfuscatedName("a")
   HashMap field445;
   @ObfuscatedName("q")
   final HashMap field452;

   static {
      field453 = new Coordinates();
   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field442 = var1;
      this.field443 = var2;
      this.field440 = new LinkedList();
      this.field447 = new LinkedList();
      this.field445 = new HashMap();
      this.field446 = var3 | -16777216;
      this.field452 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "7089"
   )
   void method441(int var1, int var2, int var3) {
      if(this.field449 != null) {
         if(var3 == this.field441 * 64) {
            this.field449.method5138(var1, var2);
         } else {
            this.field449.method5128(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lz;Ljava/util/List;I)V",
      garbageValue = "-405396503"
   )
   void method327(class22 var1, List var2) {
      this.field445.clear();
      this.field444 = var1;
      this.method381(0, 0, 64, 64, this.field444);
      this.method363(var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
      garbageValue = "-363964486"
   )
   void method336(HashSet var1, List var2) {
      this.field445.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method212() == this.field442 && var4.method214() == this.field443) {
            this.field440.add(var4);
            this.method381(var4.method607() * 8, var4.method608() * 8, 8, 8, var4);
         }
      }

      this.method363(var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIILae;I)V",
      garbageValue = "1220373699"
   )
   void method381(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label55:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field380; ++var9) {
               class31[] var10 = var5.field384[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method359(var13.field409);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field442 * 64 + var6, this.field443 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field444 != null) {
                           var16 = new Coordinates(this.field444.field388 + var9, var6 + this.field444.field386 * 64, var7 + this.field444.field376 * 64);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var9 + var17.field388, var6 + var17.field386 * 64 + var17.method601() * 8, var7 + var17.field376 * 64 + var17.method606() * 8);
                        }

                        class39 var18 = new class39(var14.field3348, var16, var15, this.method380(var14));
                        this.field445.put(var8, var18);
                        continue label55;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;I)V",
      garbageValue = "-79119979"
   )
   void method363(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field337.worldX >> 6 == this.field442 && var3.field337.worldY >> 6 == this.field443) {
            class39 var4 = new class39(var3.field338, var3.field337, var3.field337, this.method394(var3.field338));
            this.field447.add(var4);
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILab;[Lao;[Lks;I)Z",
      garbageValue = "-875943267"
   )
   boolean method331(int var1, class46 var2, class34[] var3, IndexedSprite[] var4) {
      if(!this.method334(var1)) {
         return false;
      } else if(this.field444 == null && this.field440.isEmpty()) {
         return false;
      } else {
         this.method340(var3);
         this.field449.method5168();
         if(this.field444 != null) {
            this.method335(var2, var3, var4);
         } else {
            this.method434(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "1745496909"
   )
   void method332(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method348(var1, var2, var4, var3);
      this.method354(var1, var2, var4, var3);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-1999392138"
   )
   void method333(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field445.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field498))) {
            Area var6 = Area.field3345[var5.field498];
            this.method431(var6, var5.field495, var5.field490, var2, var3);
         }
      }

      this.method349(var1, var2, var3);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "443036177"
   )
   boolean method334(int var1) {
      if(this.field449 != null && this.field441 == var1) {
         return false;
      } else {
         this.field441 = var1;
         this.field449 = new SpritePixels(this.field441 * 64, this.field441 * 64);
         return true;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lab;[Lao;[Lks;I)V",
      garbageValue = "-71431745"
   )
   void method335(class46 var1, class34[] var2, IndexedSprite[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method338(var4, var5, this.field444, var1);
            this.method339(var4, var5, this.field444, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method467(var4, var5, this.field444, var1, var3);
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lab;[Lks;I)V",
      garbageValue = "-1453389093"
   )
   void method434(class46 var1, IndexedSprite[] var2) {
      Iterator var3 = this.field440.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method607() * 8; var5 < var4.method607() * 8 + 8; ++var5) {
            for(var6 = var4.method608() * 8; var6 < var4.method608() * 8 + 8; ++var6) {
               this.method338(var5, var6, var4, var1);
               this.method339(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field440.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method607() * 8; var5 < var4.method607() * 8 + 8; ++var5) {
            for(var6 = var4.method608() * 8; var6 < var4.method608() * 8 + 8; ++var6) {
               this.method467(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILae;Lab;[Lks;I)V",
      garbageValue = "2020561235"
   )
   void method467(int var1, int var2, class28 var3, class46 var4, IndexedSprite[] var5) {
      this.method347(var1, var2, var3);
      this.method346(var1, var2, var3, var5);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILae;Lab;I)V",
      garbageValue = "1629243839"
   )
   void method338(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field377[0][var1][var2] - 1;
      int var6 = var3.field382[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.method4981(this.field441 * var1, this.field441 * (63 - var2), this.field441, this.field441, this.field446);
      }

      int var7 = 16711935;
      if(var6 != -1) {
         var7 = class51.method719(var6, this.field446);
      }

      if(var6 > -1 && var3.field383[0][var1][var2] == 0) {
         Rasterizer2D.method4981(this.field441 * var1, this.field441 * (63 - var2), this.field441, this.field441, var7);
      } else {
         int var8 = this.method345(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.method4981(this.field441 * var1, this.field441 * (63 - var2), this.field441, this.field441, var8);
         } else {
            var4.method625(this.field441 * var1, this.field441 * (63 - var2), var8, var7, this.field441, this.field441, var3.field383[0][var1][var2], var3.field379[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IILae;Lab;B)V",
      garbageValue = "-89"
   )
   void method339(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field380; ++var5) {
         int var6 = var3.field382[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = class51.method719(var6, this.field446);
            if(var3.field383[var5][var1][var2] == 0) {
               Rasterizer2D.method4981(this.field441 * var1, this.field441 * (63 - var2), this.field441, this.field441, var7);
            } else {
               var4.method625(this.field441 * var1, this.field441 * (63 - var2), 0, var7, this.field441, this.field441, var3.field383[var5][var1][var2], var3.field379[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([Lao;I)Z",
      garbageValue = "-1517979164"
   )
   boolean method340(class34[] var1) {
      if(this.field448 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field444 != null) {
            this.method343(0, 0, 64, 64, this.field444, var2);
         } else {
            Iterator var3 = this.field440.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method343(var4.method607() * 8, var4.method608() * 8, 8, 8, var4, var2);
            }
         }

         this.method360(var1, var2);
         this.method341(var2);
         return true;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lag;I)V",
      garbageValue = "-1263044388"
   )
   void method341(class43 var1) {
      this.field448 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field448[var2][var3] = var1.method581(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Lao;Lag;S)V",
      garbageValue = "-6930"
   )
   void method360(class34[] var1, class43 var2) {
      class235[] var3 = class19.method142();
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
            switch(var6.field3220) {
            case 0:
               var8 = 59;
               var10 = 5;
               var11 = 59;
               var9 = 5;
               break;
            case 1:
               var7 = 59;
               var9 = 5;
               break;
            case 2:
               var11 = 59;
               var12 = 59;
               var9 = 5;
               var10 = 5;
               break;
            case 3:
               var12 = 59;
               var10 = 5;
               break;
            case 4:
               var11 = 59;
               var9 = 5;
               break;
            case 5:
               var8 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
               break;
            case 6:
               var8 = 59;
               var10 = 5;
               break;
            case 7:
               var12 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
            }

            this.method388(var11, var12, var7, var8, var9, var10, var1[var6.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIILae;Lag;I)V",
      garbageValue = "945475204"
   )
   void method343(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field377[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = class217.method3957(var9);
               var6.method580(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIIILao;Lag;B)V",
      garbageValue = "32"
   )
   void method388(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method413(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = class217.method3957(var11);
               var8.method580(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IILae;I)I",
      garbageValue = "-1431060390"
   )
   int method345(int var1, int var2, class28 var3) {
      return var3.field377[0][var1][var2] == 0?this.field446:this.field448[var1][var2];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IILae;[Lks;I)V",
      garbageValue = "1972089320"
   )
   void method346(int var1, int var2, class28 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field380; ++var5) {
         class31[] var6 = var3.field384[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               if(!WorldMapType2.method507(var9.field412)) {
                  int var11 = var9.field412;
                  boolean var10 = var11 == class228.field2894.field2888;
                  if(!var10) {
                     continue;
                  }
               }

               ObjectComposition var12 = ClientPacket.getObjectDefinition(var9.field409);
               if(var12.mapSceneId != -1) {
                  if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                     var4[var12.mapSceneId].method5085(this.field441 * var1, this.field441 * (63 - var2), this.field441 * 2, this.field441 * 2);
                  } else {
                     var4[var12.mapSceneId].method5085(this.field441 * var1, this.field441 * (63 - var2), this.field441 * 2 + 1, this.field441 * 2 + 1);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IILae;I)V",
      garbageValue = "-1826873048"
   )
   void method347(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field380; ++var4) {
         class31[] var5 = var3.field384[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               int var10 = var8.field412;
               boolean var9 = var10 >= class228.field2877.field2888 && var10 <= class228.field2875.field2888 || var10 == class228.field2872.field2888;
               if(var9) {
                  ObjectComposition var11 = ClientPacket.getObjectDefinition(var8.field409);
                  int var12 = var11.field3486 != 0?-3407872:-3355444;
                  if(var8.field412 == class228.field2877.field2888) {
                     this.method433(var1, var2, var8.field410, var12);
                  }

                  if(var8.field412 == class228.field2874.field2888) {
                     this.method433(var1, var2, var8.field410, -3355444);
                     this.method433(var1, var2, var8.field410 + 1, var12);
                  }

                  if(var8.field412 == class228.field2875.field2888) {
                     if(var8.field410 == 0) {
                        Rasterizer2D.method4990(this.field441 * var1, this.field441 * (63 - var2), 1, var12);
                     }

                     if(var8.field410 == 1) {
                        Rasterizer2D.method4990(this.field441 + this.field441 * var1 - 1, this.field441 * (63 - var2), 1, var12);
                     }

                     if(var8.field410 == 2) {
                        Rasterizer2D.method4990(this.field441 * var1 + this.field441 - 1, this.field441 * (63 - var2) + this.field441 - 1, 1, var12);
                     }

                     if(var8.field410 == 3) {
                        Rasterizer2D.method4990(this.field441 * var1, this.field441 * (63 - var2) + this.field441 - 1, 1, var12);
                     }
                  }

                  if(var8.field412 == class228.field2872.field2888) {
                     int var13 = var8.field410 % 2;
                     int var14;
                     if(var13 == 0) {
                        for(var14 = 0; var14 < this.field441; ++var14) {
                           Rasterizer2D.method4990(var14 + this.field441 * var1, (64 - var2) * this.field441 - 1 - var14, 1, var12);
                        }
                     } else {
                        for(var14 = 0; var14 < this.field441; ++var14) {
                           Rasterizer2D.method4990(var14 + this.field441 * var1, var14 + this.field441 * (63 - var2), 1, var12);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "493929951"
   )
   void method348(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field445.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var9.worldX * var5 + (float)var1 - var6);
         int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.worldY - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field495 = var10;
            var12.field490 = var11;
            Area var13 = Area.field3345[var12.field498];
            if(!var3.contains(Integer.valueOf(var13.method4273()))) {
               this.method418(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;IIS)V",
      garbageValue = "27064"
   )
   void method349(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field447.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         Area var6 = Area.field3345[var5.field498];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4273()))) {
            this.method431(var6, var5.field495, var5.field490, var2, var3);
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Lib;IIIII)V",
      garbageValue = "-1405466455"
   )
   void method431(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.method4275(false);
      if(var6 != null) {
         var6.drawAt(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method4979(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method4979(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Law;IIFI)V",
      garbageValue = "828512744"
   )
   void method418(class39 var1, int var2, int var3, float var4) {
      Area var5 = Area.field3345[var1.field498];
      this.method352(var5, var2, var3);
      this.method353(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Lib;IIB)V",
      garbageValue = "1"
   )
   void method352(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.method4275(false);
      if(var4 != null) {
         int var5 = this.method357(var4, var1.field3361);
         int var6 = this.method358(var4, var1.field3344);
         var4.drawAt(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Law;Lib;IIFI)V",
      garbageValue = "220579896"
   )
   void method353(class39 var1, Area var2, int var3, int var4, float var5) {
      if(var1.field494 != null) {
         if(var1.field494.field435.method171(var5)) {
            Font var6 = (Font)this.field452.get(var1.field494.field435);
            var6.method4774(var1.field494.field438, var3 - var1.field494.field432 / 2, var4, var1.field494.field432, var1.field494.field437, -16777216 | var2.field3352, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;IS)V",
      garbageValue = "-26392"
   )
   void method354(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field447.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field492.worldX % 64;
         int var9 = var7.field492.worldY % 64;
         var7.field495 = (int)((float)var8 * var5 + (float)var1);
         var7.field490 = (int)((float)var2 + (float)(63 - var9) * var5);
         if(!var3.contains(Integer.valueOf(var7.field498))) {
            this.method418(var7, var7.field495, var7.field490, var5);
         }
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1289165808"
   )
   void method355() {
      if(this.field444 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method356(var1, var2, this.field444);
            }
         }
      } else {
         Iterator var5 = this.field440.iterator();

         while(var5.hasNext()) {
            class45 var6 = (class45)var5.next();

            for(int var3 = var6.method607() * 8; var3 < var6.method607() * 8 + 8; ++var3) {
               for(int var4 = var6.method608() * 8; var4 < var6.method608() * 8 + 8; ++var4) {
                  this.method356(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IILae;I)V",
      garbageValue = "1807238138"
   )
   void method356(int var1, int var2, class28 var3) {
      field453.method3975(0, var1, var2);

      for(int var4 = 0; var4 < var3.field380; ++var4) {
         class31[] var5 = var3.field384[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method359(var8.field409);
               if(var9 != null) {
                  class39 var10 = (class39)this.field445.get(field453);
                  if(var10 != null) {
                     if(var9.field3348 != var10.field498) {
                        class39 var16 = new class39(var9.field3348, var10.field491, var10.field492, this.method380(var9));
                        this.field445.put(new Coordinates(field453), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field491.plane - var10.field492.plane;
                     var10.field492.plane = var4;
                     var10.field491.plane = var15 + var4;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field442 * 64 + var1, this.field443 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field444 != null) {
                     var12 = new Coordinates(this.field444.field388 + var4, this.field444.field386 * 64 + var1, var2 + this.field444.field376 * 64);
                  } else {
                     Iterator var13 = this.field440.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method603(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field388, var14.field386 * 64 + var1 + var14.method601() * 8, var2 + var14.field376 * 64 + var14.method606() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3348, var12, var11, this.method380(var9));
                     this.field445.put(new Coordinates(field453), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field445.remove(field453);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lkb;Ljp;I)I",
      garbageValue = "1404702225"
   )
   int method357(SpritePixels var1, class264 var2) {
      switch(var2.field3597) {
      case 0:
         return 0;
      case 1:
         return -var1.width / 2;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lkb;Lit;B)I",
      garbageValue = "-3"
   )
   int method358(SpritePixels var1, class246 var2) {
      switch(var2.field3327) {
      case 0:
         return -var1.height / 2;
      case 2:
         return 0;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II)Lib;",
      garbageValue = "-2126618690"
   )
   Area method359(int var1) {
      ObjectComposition var2 = ClientPacket.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.field3345[var2.mapIconId]:null;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)Lar;",
      garbageValue = "1325498690"
   )
   class33 method394(int var1) {
      Area var2 = Area.field3345[var1];
      return this.method380(var2);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Lib;I)Lar;",
      garbageValue = "-1872854250"
   )
   class33 method380(Area var1) {
      if(var1.name != null && this.field452 != null && this.field452.get(class24.field335) != null) {
         int var3 = var1.field3359;
         class24[] var4 = new class24[]{class24.field330, class24.field329, class24.field335};
         class24[] var5 = var4;
         int var6 = 0;

         class24 var2;
         while(true) {
            if(var6 >= var5.length) {
               var2 = null;
               break;
            }

            class24 var7 = var5[var6];
            if(var3 == var7.field334) {
               var2 = var7;
               break;
            }

            ++var6;
         }

         if(var2 == null) {
            return null;
         } else {
            Font var14 = (Font)this.field452.get(var2);
            if(var14 == null) {
               return null;
            } else {
               var6 = var14.method4768(var1.name, 1000000);
               String[] var15 = new String[var6];
               var14.method4797(var1.name, (int[])null, var15);
               int var8 = var15.length * var14.verticalSpace / 2;
               int var9 = 0;
               String[] var10 = var15;

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  String var12 = var10[var11];
                  int var13 = var14.method4790(var12);
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
      signature = "(IIIIII)Ljava/util/List;",
      garbageValue = "1518333161"
   )
   List method344(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field445.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method510(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field447.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method510(var4, var5)) {
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

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/List;",
      garbageValue = "-810594364"
   )
   List method470() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field447);
      var1.addAll(this.field445.values());
      return var1;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1446465529"
   )
   void method433(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method5019(this.field441 * var1, this.field441 * (63 - var2), this.field441, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method4990(this.field441 * var1, this.field441 * (63 - var2), this.field441, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5019(this.field441 * var1 + this.field441 - 1, this.field441 * (63 - var2), this.field441, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method4990(this.field441 * var1, this.field441 * (63 - var2) + this.field441 - 1, this.field441, var4);
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-426064123"
   )
   int method413(int var1, int var2) {
      if(this.field444 != null) {
         return this.field444.method211(var1, var2);
      } else {
         if(!this.field440.isEmpty()) {
            Iterator var3 = this.field440.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method603(var1, var2)) {
                  return var4.method211(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILfw;Liu;I)V",
      garbageValue = "-1461672078"
   )
   static void method469(int var0, IndexFile var1, IndexData var2) {
      FileSystem var3 = new FileSystem();
      var3.field3260 = 1;
      var3.hash = (long)var0;
      var3.index = var1;
      var3.data = var2;
      Deque var4 = class243.field3291;
      synchronized(class243.field3291) {
         class243.field3291.addFront(var3);
      }

      class29.method220();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-466549306"
   )
   static String method422() {
      String var0;
      if(class70.preferences.field1235) {
         String var2 = class91.username;
         int var4 = var2.length();
         char[] var5 = new char[var4];

         for(int var6 = 0; var6 < var4; ++var6) {
            var5[var6] = '*';
         }

         String var3 = new String(var5);
         var0 = var3;
      } else {
         var0 = class91.username;
      }

      return var0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lcg;Lcg;IZB)I",
      garbageValue = "0"
   )
   static int method351(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1549()?(var1.method1549()?0:1):(var1.method1549()?-1:0)):(var2 == 5?(var0.method1517()?(var1.method1517()?0:1):(var1.method1517()?-1:0)):(var2 == 6?(var0.method1519()?(var1.method1519()?0:1):(var1.method1519()?-1:0)):(var2 == 7?(var0.method1516()?(var1.method1516()?0:1):(var1.method1516()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1780938055"
   )
   public static void method472() {
      if(class19.field299 != null) {
         class19.field299.close();
      }

   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(Lbd;ZI)V",
      garbageValue = "-1262893804"
   )
   static void method458(Player var0, boolean var1) {
      if(var0 != null && var0.hasConfig() && !var0.hidden) {
         int var2 = var0.field834 << 14;
         var0.field832 = false;
         if((Client.lowMemory && class94.playerIndexesCount > 50 || class94.playerIndexesCount > 200) && var1 && var0.poseAnimation == var0.idlePoseAnimation) {
            var0.field832 = true;
         }

         int var3 = var0.x >> 7;
         int var4 = var0.y >> 7;
         if(var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
            if(var0.model != null && Client.gameCycle >= var0.field839 && Client.gameCycle < var0.field837) {
               var0.field832 = false;
               var0.field821 = class18.getTileHeight(var0.x, var0.y, class28.plane);
               Client.region.method2692(class28.plane, var0.x, var0.y, var0.field821, 60, var0, var0.angle, var2, var0.field828, var0.field829, var0.field830, var0.field831);
            } else {
               if((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if(Client.field920[var3][var4] == Client.field951) {
                     return;
                  }

                  Client.field920[var3][var4] = Client.field951;
               }

               var0.field821 = class18.getTileHeight(var0.x, var0.y, class28.plane);
               Client.region.method2699(class28.plane, var0.x, var0.y, var0.field821, 60, var0, var0.angle, var2, var0.field1147);
            }
         }
      }

   }
}
