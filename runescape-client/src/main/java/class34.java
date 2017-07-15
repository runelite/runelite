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

@ObfuscatedName("aq")
public class class34 {
   @ObfuscatedName("t")
   static final Coordinates field476;
   @ObfuscatedName("p")
   int[][] field463;
   @ObfuscatedName("m")
   SpritePixels field472;
   @ObfuscatedName("u")
   List field473;
   @ObfuscatedName("l")
   LinkedList field468;
   @ObfuscatedName("g")
   HashMap field465;
   @ObfuscatedName("e")
   class22 field467;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1206861865
   )
   int field470;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1560773943
   )
   int field471;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 721125063
   )
   int field469;
   @ObfuscatedName("k")
   final HashMap field474;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1992323633
   )
   int field466;

   static {
      field476 = new Coordinates();
   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field470 = var1;
      this.field466 = var2;
      this.field468 = new LinkedList();
      this.field473 = new LinkedList();
      this.field465 = new HashMap();
      this.field469 = var3 | -16777216;
      this.field474 = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-399311448"
   )
   boolean method391(int var1) {
      if(this.field472 != null && this.field471 == var1) {
         return false;
      } else {
         this.field471 = var1;
         this.field472 = new SpritePixels(this.field471 * 64, this.field471 * 64);
         return true;
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IILclass28;B)V",
      garbageValue = "-63"
   )
   void method376(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field404; ++var4) {
         class31[] var5 = var3.field409[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               if(XClanMember.method1140(var8.field433)) {
                  ObjectComposition var9 = PlayerComposition.getObjectDefinition(var8.field436);
                  int var10 = var9.field3453 != 0?-3407872:-3355444;
                  if(var8.field433 == class221.field2824.field2816) {
                     this.method393(var1, var2, var8.field434, var10);
                  }

                  if(var8.field433 == class221.field2812.field2816) {
                     this.method393(var1, var2, var8.field434, -3355444);
                     this.method393(var1, var2, var8.field434 + 1, var10);
                  }

                  if(var8.field433 == class221.field2815.field2816) {
                     if(var8.field434 == 0) {
                        Rasterizer2D.method4927(this.field471 * var1, this.field471 * (63 - var2), 1, var10);
                     }

                     if(var8.field434 == 1) {
                        Rasterizer2D.method4927(this.field471 * var1 + this.field471 - 1, this.field471 * (63 - var2), 1, var10);
                     }

                     if(var8.field434 == 2) {
                        Rasterizer2D.method4927(this.field471 + this.field471 * var1 - 1, this.field471 * (63 - var2) + this.field471 - 1, 1, var10);
                     }

                     if(var8.field434 == 3) {
                        Rasterizer2D.method4927(this.field471 * var1, (63 - var2) * this.field471 + this.field471 - 1, 1, var10);
                     }
                  }

                  if(var8.field433 == class221.field2830.field2816) {
                     int var11 = var8.field434 % 2;
                     int var12;
                     if(var11 == 0) {
                        for(var12 = 0; var12 < this.field471; ++var12) {
                           Rasterizer2D.method4927(var12 + this.field471 * var1, (64 - var2) * this.field471 - 1 - var12, 1, var10);
                        }
                     } else {
                        for(var12 = 0; var12 < this.field471; ++var12) {
                           Rasterizer2D.method4927(var12 + this.field471 * var1, var12 + this.field471 * (63 - var2), 1, var10);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-1504460433"
   )
   void method377(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field465.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var1 + var5 * (float)var9.worldX - var6);
         int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.worldY - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field521 = var10;
            var12.field515 = var11;
            Area var13 = class54.field662[var12.field523];
            if(!var3.contains(Integer.valueOf(var13.method4253()))) {
               this.method380(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(LArea;I)Lclass33;",
      garbageValue = "-993041197"
   )
   class33 method390(Area var1) {
      if(var1.name != null && this.field474 != null && this.field474.get(class24.field355) != null) {
         int var3 = var1.field3300;
         class24[] var4 = new class24[]{class24.field355, class24.field358, class24.field354};
         class24[] var5 = var4;
         int var6 = 0;

         class24 var2;
         while(true) {
            if(var6 >= var5.length) {
               var2 = null;
               break;
            }

            class24 var7 = var5[var6];
            if(var3 == var7.field360) {
               var2 = var7;
               break;
            }

            ++var6;
         }

         if(var2 == null) {
            return null;
         } else {
            Font var14 = (Font)this.field474.get(var2);
            if(var14 == null) {
               return null;
            } else {
               var6 = var14.method4675(var1.name, 1000000);
               String[] var15 = new String[var6];
               var14.method4673(var1.name, (int[])null, var15);
               int var8 = var15.length * var14.verticalSpace / 2;
               int var9 = 0;
               String[] var10 = var15;

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  String var12 = var10[var11];
                  int var13 = var14.method4721(var12);
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IILclass28;[LModIcon;B)V",
      garbageValue = "37"
   )
   void method371(int var1, int var2, class28 var3, ModIcon[] var4) {
      for(int var5 = 0; var5 < var3.field404; ++var5) {
         class31[] var6 = var3.field409[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               int var11 = var9.field433;
               boolean var10 = var11 >= class221.field2831.field2816 && var11 <= class221.field2826.field2816;
               if(var10 || Tile.method2492(var9.field433)) {
                  ObjectComposition var12 = PlayerComposition.getObjectDefinition(var9.field436);
                  if(var12.mapSceneId != -1) {
                     if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                        var4[var12.mapSceneId].method4947(this.field471 * var1, this.field471 * (63 - var2), this.field471 * 2, this.field471 * 2);
                     } else {
                        var4[var12.mapSceneId].method4947(this.field471 * var1, this.field471 * (63 - var2), this.field471 * 2 + 1, this.field471 * 2 + 1);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(LArea;IIB)V",
      garbageValue = "0"
   )
   void method424(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.method4249(false);
      if(var4 != null) {
         int var5 = this.method386(var4, var1.field3303);
         int var6 = this.method439(var4, var1.field3304);
         var4.method5032(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IILclass28;Lclass46;I)V",
      garbageValue = "1890691279"
   )
   void method368(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field405[0][var1][var2] - 1;
      int var6 = var3.field410[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.method4921(this.field471 * var1, this.field471 * (63 - var2), this.field471, this.field471, this.field469);
      }

      int var7 = 16711935;
      if(var6 != -1) {
         var7 = WorldMapData.method347(var6, this.field469);
      }

      if(var6 > -1 && var3.field406[0][var1][var2] == 0) {
         Rasterizer2D.method4921(this.field471 * var1, this.field471 * (63 - var2), this.field471, this.field471, var7);
      } else {
         int var8 = this.method374(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.method4921(this.field471 * var1, this.field471 * (63 - var2), this.field471, this.field471, var8);
         } else {
            var4.method670(this.field471 * var1, this.field471 * (63 - var2), var8, var7, this.field471, this.field471, var3.field406[0][var1][var2], var3.field408[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-701431061"
   )
   void method383(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field473.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field516.worldX % 64;
         int var9 = var7.field516.worldY % 64;
         var7.field521 = (int)((float)var8 * var5 + (float)var1);
         var7.field515 = (int)((float)var2 + (float)(63 - var9) * var5);
         if(!var3.contains(Integer.valueOf(var7.field523))) {
            this.method380(var7, var7.field521, var7.field515, var5);
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(LSpritePixels;Lclass257;I)I",
      garbageValue = "1271001057"
   )
   int method386(SpritePixels var1, class257 var2) {
      switch(var2.field3551) {
      case 0:
         return 0;
      case 1:
         return -var1.width / 2;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1690945561"
   )
   int method394(int var1, int var2) {
      if(this.field467 != null) {
         return this.field467.method222(var1, var2);
      } else {
         if(!this.field468.isEmpty()) {
            Iterator var3 = this.field468.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method644(var1, var2)) {
                  return var4.method222(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IILclass28;Lclass46;[LModIcon;B)V",
      garbageValue = "109"
   )
   void method367(int var1, int var2, class28 var3, class46 var4, ModIcon[] var5) {
      this.method376(var1, var2, var3);
      this.method371(var1, var2, var3, var5);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lclass39;LArea;IIFI)V",
      garbageValue = "-1110888446"
   )
   void method382(class39 var1, Area var2, int var3, int var4, float var5) {
      if(var1.field520 != null) {
         if(var1.field520.field457.method170(var5)) {
            Font var6 = (Font)this.field474.get(var1.field520.field457);
            var6.method4681(var1.field520.field462, var3 - var1.field520.field455 / 2, var4, var1.field520.field455, var1.field520.field456, -16777216 | var2.field3305, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;IIB)V",
      garbageValue = "12"
   )
   void method395(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field473.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         Area var6 = class54.field662[var5.field523];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4253()))) {
            this.method379(var6, var5.field521, var5.field515, var2, var3);
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([Lclass34;B)Z",
      garbageValue = "-4"
   )
   boolean method370(class34[] var1) {
      if(this.field463 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field467 != null) {
            this.method372(0, 0, 64, 64, this.field467, var2);
         } else {
            Iterator var3 = this.field468.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method372(var4.method647() * 8, var4.method664() * 8, 8, 8, var4, var2);
            }
         }

         this.method471(var1, var2);
         this.method456(var2);
         return true;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIILclass28;I)V",
      garbageValue = "-117293994"
   )
   void method402(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label54:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field404; ++var9) {
               class31[] var10 = var5.field409[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method388(var13.field436);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, var6 + this.field470 * 64, var7 + this.field466 * 64);
                        Coordinates var16 = null;
                        if(this.field467 != null) {
                           var16 = new Coordinates(this.field467.field407 + var9, var6 + this.field467.field403 * 64, var7 + this.field467.field400 * 64);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var9 + var17.field407, var6 + var17.field403 * 64 + var17.method645() * 8, var7 + var17.field400 * 64 + var17.method648() * 8);
                        }

                        class39 var18 = new class39(var14.field3290, var16, var15, this.method390(var14));
                        this.field465.put(var8, var18);
                        continue label54;
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
      garbageValue = "-1049806257"
   )
   void method470(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field366.worldX >> 6 == this.field470 && var3.field366.worldY >> 6 == this.field466) {
            class39 var4 = new class39(var3.field372, var3.field366, var3.field366, this.method389(var3.field372));
            this.field473.add(var4);
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IILclass28;S)V",
      garbageValue = "-24901"
   )
   void method464(int var1, int var2, class28 var3) {
      field476.method3928(0, var1, var2);

      for(int var4 = 0; var4 < var3.field404; ++var4) {
         class31[] var5 = var3.field409[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method388(var8.field436);
               if(var9 != null) {
                  class39 var10 = (class39)this.field465.get(field476);
                  if(var10 != null) {
                     if(var9.field3290 != var10.field523) {
                        class39 var16 = new class39(var9.field3290, var10.field522, var10.field516, this.method390(var9));
                        this.field465.put(new Coordinates(field476), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field522.plane - var10.field516.plane;
                     var10.field516.plane = var4;
                     var10.field522.plane = var15 + var4;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field470 * 64 + var1, this.field466 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field467 != null) {
                     var12 = new Coordinates(this.field467.field407 + var4, this.field467.field403 * 64 + var1, this.field467.field400 * 64 + var2);
                  } else {
                     Iterator var13 = this.field468.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method644(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field407, var14.field403 * 64 + var1 + var14.method645() * 8, var14.field400 * 64 + var2 + var14.method648() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3290, var12, var11, this.method390(var9));
                     this.field465.put(new Coordinates(field476), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field465.remove(field476);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IILclass28;Lclass46;I)V",
      garbageValue = "-280210877"
   )
   void method369(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field404; ++var5) {
         int var6 = var3.field410[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = WorldMapData.method347(var6, this.field469);
            if(var3.field406[var5][var1][var2] == 0) {
               Rasterizer2D.method4921(this.field471 * var1, this.field471 * (63 - var2), this.field471, this.field471, var7);
            } else {
               var4.method670(this.field471 * var1, this.field471 * (63 - var2), 0, var7, this.field471, this.field471, var3.field406[var5][var1][var2], var3.field408[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(LSpritePixels;Lclass239;I)I",
      garbageValue = "-701317261"
   )
   int method439(SpritePixels var1, class239 var2) {
      switch(var2.field3276) {
      case 1:
         return -var1.height / 2;
      case 2:
         return 0;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIILclass28;Lclass43;I)V",
      garbageValue = "1694574091"
   )
   void method372(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field405[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = class116.method2104(var9);
               var6.method623(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IILclass28;I)I",
      garbageValue = "1650574864"
   )
   int method374(int var1, int var2, class28 var3) {
      return var3.field405[0][var1][var2] == 0?this.field469:this.field463[var1][var2];
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([Lclass34;Lclass43;I)V",
      garbageValue = "-1742647183"
   )
   void method471(class34[] var1, class43 var2) {
      class228[] var3 = new class228[]{class228.field3161, class228.field3157, class228.field3156, class228.field3155, class228.field3153, class228.field3159, class228.field3154, class228.field3158};
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
            switch(var7.field3152) {
            case 0:
               var9 = 59;
               var11 = 5;
               var12 = 59;
               var10 = 5;
               break;
            case 1:
               var13 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 2:
               var8 = 59;
               var10 = 5;
               break;
            case 3:
               var12 = 59;
               var13 = 59;
               var10 = 5;
               var11 = 5;
               break;
            case 4:
               var13 = 59;
               var11 = 5;
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
               break;
            case 7:
               var12 = 59;
               var10 = 5;
            }

            this.method373(var12, var13, var8, var9, var10, var11, var1[var7.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)LArea;",
      garbageValue = "371596270"
   )
   Area method388(int var1) {
      ObjectComposition var2 = PlayerComposition.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?class54.field662[var2.mapIconId]:null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass43;B)V",
      garbageValue = "33"
   )
   void method456(class43 var1) {
      this.field463 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field463[var2][var3] = var1.method629(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass46;[Lclass34;[LModIcon;B)V",
      garbageValue = "14"
   )
   void method365(class46 var1, class34[] var2, ModIcon[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method368(var4, var5, this.field467, var1);
            this.method369(var4, var5, this.field467, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method367(var4, var5, this.field467, var1, var3);
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass46;[LModIcon;I)V",
      garbageValue = "730437136"
   )
   void method366(class46 var1, ModIcon[] var2) {
      Iterator var3 = this.field468.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method647() * 8; var5 < var4.method647() * 8 + 8; ++var5) {
            for(var6 = var4.method664() * 8; var6 < var4.method664() * 8 + 8; ++var6) {
               this.method368(var5, var6, var4, var1);
               this.method369(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field468.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method647() * 8; var5 < var4.method647() * 8 + 8; ++var5) {
            for(var6 = var4.method664() * 8; var6 < var4.method664() * 8 + 8; ++var6) {
               this.method367(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)Ljava/util/List;",
      garbageValue = "50"
   )
   List method396() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field473);
      var1.addAll(this.field465.values());
      return var1;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(LArea;IIIIB)V",
      garbageValue = "2"
   )
   void method379(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.method4249(false);
      if(var6 != null) {
         var6.method5032(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method4852(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method4852(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IB)Lclass33;",
      garbageValue = "-20"
   )
   class33 method389(int var1) {
      Area var2 = class54.field662[var1];
      return this.method390(var2);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1843780137"
   )
   void method384() {
      if(this.field467 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method464(var1, var2, this.field467);
            }
         }
      } else {
         Iterator var5 = this.field468.iterator();

         while(var5.hasNext()) {
            class45 var6 = (class45)var5.next();

            for(int var3 = var6.method647() * 8; var3 < var6.method647() * 8 + 8; ++var3) {
               for(int var4 = var6.method664() * 8; var4 < var6.method664() * 8 + 8; ++var4) {
                  this.method464(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lclass39;IIFI)V",
      garbageValue = "-1584344202"
   )
   void method380(class39 var1, int var2, int var3, float var4) {
      Area var5 = class54.field662[var1.field523];
      this.method424(var5, var2, var3);
      this.method382(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;IIB)V",
      garbageValue = "1"
   )
   void method363(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field465.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field523))) {
            Area var6 = class54.field662[var5.field523];
            this.method379(var6, var5.field521, var5.field515, var2, var3);
         }
      }

      this.method395(var1, var2, var3);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "808399803"
   )
   void method393(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method4865(this.field471 * var1, this.field471 * (63 - var2), this.field471, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method4927(this.field471 * var1, this.field471 * (63 - var2), this.field471, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method4865(this.field471 + this.field471 * var1 - 1, this.field471 * (63 - var2), this.field471, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method4927(this.field471 * var1, this.field471 * (63 - var2) + this.field471 - 1, this.field471, var4);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;B)V",
      garbageValue = "58"
   )
   void method362(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method377(var1, var2, var4, var3);
      this.method383(var1, var2, var4, var3);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IIIIII)Ljava/util/List;",
      garbageValue = "-649227014"
   )
   List method457(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field465.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method546(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field473.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method546(var4, var5)) {
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILclass46;[Lclass34;[LModIcon;B)Z",
      garbageValue = "-61"
   )
   boolean method361(int var1, class46 var2, class34[] var3, ModIcon[] var4) {
      if(!this.method391(var1)) {
         return false;
      } else if(this.field467 == null && this.field468.isEmpty()) {
         return false;
      } else {
         this.method370(var3);
         this.field472.method4974();
         if(this.field467 != null) {
            this.method365(var2, var3, var4);
         } else {
            this.method366(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIIILclass34;Lclass43;I)V",
      garbageValue = "-2138587628"
   )
   void method373(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method394(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = class116.method2104(var11);
               var8.method623(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-309651174"
   )
   void method458(int var1, int var2, int var3) {
      if(this.field472 != null) {
         if(var3 == this.field471 * 64) {
            this.field472.method4981(var1, var2);
         } else {
            this.field472.method4997(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass22;Ljava/util/List;I)V",
      garbageValue = "2049626438"
   )
   void method357(class22 var1, List var2) {
      this.field465.clear();
      this.field467 = var1;
      this.method402(0, 0, 64, 64, this.field467);
      this.method470(var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;B)V",
      garbageValue = "72"
   )
   void method431(HashSet var1, List var2) {
      this.field465.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method223() == this.field470 && var4.method234() == this.field466) {
            this.field468.add(var4);
            this.method402(var4.method647() * 8, var4.method664() * 8, 8, 8, var4);
         }
      }

      this.method470(var2);
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-2035458933"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      Widget var8;
      if(var2 == 1005) {
         var8 = class61.method1038(var1);
         if(var8 != null && var8.itemQuantities[var0] >= 100000) {
            WidgetNode.sendGameMessage(27, "", var8.itemQuantities[var0] + " x " + class83.getItemDefinition(var3).name);
         } else {
            Client.secretPacketBuffer1.putOpcode(101);
            Client.secretPacketBuffer1.putShort(var3);
         }

         Client.field1017 = 0;
         class35.field482 = class61.method1038(var1);
         Client.field1048 = var0;
      }

      Player var18;
      if(var2 == 45) {
         var18 = Client.cachedPlayers[var3];
         if(var18 != null) {
            Client.field1013 = var6;
            Client.field1071 = var7;
            Client.cursorState = 2;
            Client.field1015 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(231);
            Client.secretPacketBuffer1.putByte(KeyFocusListener.field626[82]?1:0);
            Client.secretPacketBuffer1.putShortOb2(var3);
         }
      }

      if(var2 == 1) {
         Client.field1013 = var6;
         Client.field1071 = var7;
         Client.cursorState = 2;
         Client.field1015 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(63);
         Client.secretPacketBuffer1.method3181(class3.field17);
         Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field626[82]?1:0);
         Client.secretPacketBuffer1.putShortOb2(class11.selectedItemIndex);
         Client.secretPacketBuffer1.putLEShortA(class95.field1484);
         Client.secretPacketBuffer1.method3171(var0 + class163.baseX);
         Client.secretPacketBuffer1.putShort(class10.baseY + var1);
         Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
      }

      if(var2 == 39) {
         Client.secretPacketBuffer1.putOpcode(33);
         Client.secretPacketBuffer1.method3291(var1);
         Client.secretPacketBuffer1.putLEShortA(var3);
         Client.secretPacketBuffer1.putShortOb2(var0);
         Client.field1017 = 0;
         class35.field482 = class61.method1038(var1);
         Client.field1048 = var0;
      }

      NPC var19;
      if(var2 == 13) {
         var19 = Client.cachedNPCs[var3];
         if(var19 != null) {
            Client.field1013 = var6;
            Client.field1071 = var7;
            Client.cursorState = 2;
            Client.field1015 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(129);
            Client.secretPacketBuffer1.putByte(KeyFocusListener.field626[82]?1:0);
            Client.secretPacketBuffer1.method3171(var3);
         }
      }

      if(var2 == 26) {
         Client.secretPacketBuffer1.putOpcode(89);

         for(WidgetNode var20 = (WidgetNode)Client.componentTable.method3538(); var20 != null; var20 = (WidgetNode)Client.componentTable.method3539()) {
            if(var20.owner == 0 || var20.owner == 3) {
               MilliTimer.method2909(var20, true);
            }
         }

         if(Client.field1070 != null) {
            class48.method749(Client.field1070);
            Client.field1070 = null;
         }
      }

      if(var2 == 1003) {
         Client.field1013 = var6;
         Client.field1071 = var7;
         Client.cursorState = 2;
         Client.field1015 = 0;
         var19 = Client.cachedNPCs[var3];
         if(var19 != null) {
            NPCComposition var9 = var19.composition;
            if(var9.configs != null) {
               var9 = var9.transform();
            }

            if(var9 != null) {
               Client.secretPacketBuffer1.putOpcode(54);
               Client.secretPacketBuffer1.putLEShortA(var9.id);
            }
         }
      }

      if(var2 == 1008 || var2 == 1009 || var2 == 1010 || var2 == 1011 || var2 == 1012) {
         class11.renderOverview.method5257(var2, var3, new Coordinates(var0), new Coordinates(var1));
      }

      if(var2 == 7) {
         var19 = Client.cachedNPCs[var3];
         if(var19 != null) {
            Client.field1013 = var6;
            Client.field1071 = var7;
            Client.cursorState = 2;
            Client.field1015 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(209);
            Client.secretPacketBuffer1.method3127(KeyFocusListener.field626[82]?1:0);
            Client.secretPacketBuffer1.putLEShortA(class11.selectedItemIndex);
            Client.secretPacketBuffer1.method3171(var3);
            Client.secretPacketBuffer1.method3181(class3.field17);
            Client.secretPacketBuffer1.putShort(class95.field1484);
         }
      }

      if(var2 == 40) {
         Client.secretPacketBuffer1.putOpcode(97);
         Client.secretPacketBuffer1.putShortOb2(var3);
         Client.secretPacketBuffer1.method3171(var0);
         Client.secretPacketBuffer1.putLEInt(var1);
         Client.field1017 = 0;
         class35.field482 = class61.method1038(var1);
         Client.field1048 = var0;
      }

      if(var2 == 38) {
         class66.method1085();
         var8 = class61.method1038(var1);
         Client.itemSelectionState = 1;
         class11.selectedItemIndex = var0;
         class3.field17 = var1;
         class95.field1484 = var3;
         class48.method749(var8);
         Client.selectedItemName = class46.getColTags(16748608) + class83.getItemDefinition(var3).name + class46.getColTags(16777215);
         if(Client.selectedItemName == null) {
            Client.selectedItemName = "null";
         }

      } else {
         if(var2 == 15) {
            var18 = Client.cachedPlayers[var3];
            if(var18 != null) {
               Client.field1013 = var6;
               Client.field1071 = var7;
               Client.cursorState = 2;
               Client.field1015 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(221);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field626[82]?1:0);
               Client.secretPacketBuffer1.putShortOb2(Client.field1062);
               Client.secretPacketBuffer1.putLEShortA(var3);
               Client.secretPacketBuffer1.putLEInt(class41.field550);
            }
         }

         if(var2 == 6) {
            Client.field1013 = var6;
            Client.field1071 = var7;
            Client.cursorState = 2;
            Client.field1015 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(197);
            Client.secretPacketBuffer1.method3171(var0 + class163.baseX);
            Client.secretPacketBuffer1.putShortOb2(class10.baseY + var1);
            Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3127(KeyFocusListener.field626[82]?1:0);
         }

         if(var2 == 43) {
            Client.secretPacketBuffer1.putOpcode(103);
            Client.secretPacketBuffer1.putShort(var0);
            Client.secretPacketBuffer1.putLEInt(var1);
            Client.secretPacketBuffer1.putLEShortA(var3);
            Client.field1017 = 0;
            class35.field482 = class61.method1038(var1);
            Client.field1048 = var0;
         }

         if(var2 == 16) {
            Client.field1013 = var6;
            Client.field1071 = var7;
            Client.cursorState = 2;
            Client.field1015 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(180);
            Client.secretPacketBuffer1.putLEShortA(class11.selectedItemIndex);
            Client.secretPacketBuffer1.putShort(var0 + class163.baseX);
            Client.secretPacketBuffer1.method3171(class95.field1484);
            Client.secretPacketBuffer1.method3171(var3);
            Client.secretPacketBuffer1.putLEInt(class3.field17);
            Client.secretPacketBuffer1.method3164(KeyFocusListener.field626[82]?1:0);
            Client.secretPacketBuffer1.putLEShortA(class10.baseY + var1);
         }

         if(var2 == 2) {
            Client.field1013 = var6;
            Client.field1071 = var7;
            Client.cursorState = 2;
            Client.field1015 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(119);
            Client.secretPacketBuffer1.putLEShortA(var0 + class163.baseX);
            Client.secretPacketBuffer1.putShortOb2(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field626[82]?1:0);
            Client.secretPacketBuffer1.putShortOb2(Client.field1062);
            Client.secretPacketBuffer1.method3181(class41.field550);
            Client.secretPacketBuffer1.putShortOb2(class10.baseY + var1);
         }

         if(var2 == 1004) {
            Client.field1013 = var6;
            Client.field1071 = var7;
            Client.cursorState = 2;
            Client.field1015 = 0;
            Client.secretPacketBuffer1.putOpcode(101);
            Client.secretPacketBuffer1.putShort(var3);
         }

         if(var2 == 42) {
            Client.secretPacketBuffer1.putOpcode(178);
            Client.secretPacketBuffer1.putShort(var0);
            Client.secretPacketBuffer1.method3181(var1);
            Client.secretPacketBuffer1.method3171(var3);
            Client.field1017 = 0;
            class35.field482 = class61.method1038(var1);
            Client.field1048 = var0;
         }

         if(var2 == 30 && Client.field1070 == null) {
            Client.secretPacketBuffer1.putOpcode(213);
            Client.secretPacketBuffer1.putLEInt(var1);
            Client.secretPacketBuffer1.putLEShortA(var0);
            Client.field1070 = class12.method70(var1, var0);
            class48.method749(Client.field1070);
         }

         if(var2 == 35) {
            Client.secretPacketBuffer1.putOpcode(251);
            Client.secretPacketBuffer1.putLEInt(var1);
            Client.secretPacketBuffer1.putLEShortA(var0);
            Client.secretPacketBuffer1.putLEShortA(var3);
            Client.field1017 = 0;
            class35.field482 = class61.method1038(var1);
            Client.field1048 = var0;
         }

         if(var2 == 33) {
            Client.secretPacketBuffer1.putOpcode(39);
            Client.secretPacketBuffer1.method3171(var3);
            Client.secretPacketBuffer1.putLEShortA(var0);
            Client.secretPacketBuffer1.putLEInt(var1);
            Client.field1017 = 0;
            class35.field482 = class61.method1038(var1);
            Client.field1048 = var0;
         }

         if(var2 == 51) {
            var18 = Client.cachedPlayers[var3];
            if(var18 != null) {
               Client.field1013 = var6;
               Client.field1071 = var7;
               Client.cursorState = 2;
               Client.field1015 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(205);
               Client.secretPacketBuffer1.putShortOb2(var3);
               Client.secretPacketBuffer1.method3164(KeyFocusListener.field626[82]?1:0);
            }
         }

         int var15;
         if(var2 == 28) {
            Client.secretPacketBuffer1.putOpcode(9);
            Client.secretPacketBuffer1.putInt(var1);
            var8 = class61.method1038(var1);
            if(var8.dynamicValues != null && var8.dynamicValues[0][0] == 5) {
               var15 = var8.dynamicValues[0][1];
               class211.widgetSettings[var15] = 1 - class211.widgetSettings[var15];
               class3.method8(var15);
            }
         }

         if(var2 == 31) {
            Client.secretPacketBuffer1.putOpcode(219);
            Client.secretPacketBuffer1.method3171(class95.field1484);
            Client.secretPacketBuffer1.method3291(class3.field17);
            Client.secretPacketBuffer1.putLEShortA(var0);
            Client.secretPacketBuffer1.putLEShortA(class11.selectedItemIndex);
            Client.secretPacketBuffer1.putInt(var1);
            Client.secretPacketBuffer1.putShortOb2(var3);
            Client.field1017 = 0;
            class35.field482 = class61.method1038(var1);
            Client.field1048 = var0;
         }

         if(var2 == 25) {
            var8 = class12.method70(var1, var0);
            if(var8 != null) {
               class66.method1085();
               int var10 = class46.getWidgetConfig(var8);
               var15 = var10 >> 11 & 63;
               int var12 = var8.itemId;
               Widget var13 = class12.method70(var1, var0);
               if(var13 != null && var13.field2744 != null) {
                  ScriptEvent var14 = new ScriptEvent();
                  var14.widget = var13;
                  var14.field839 = var13.field2744;
                  class89.method1689(var14);
               }

               Client.field1063 = var12;
               Client.spellSelected = true;
               class41.field550 = var1;
               Client.field1062 = var0;
               class116.field1676 = var15;
               class48.method749(var13);
               Client.itemSelectionState = 0;
               Client.field1064 = MouseInput.method1029(var8);
               if(Client.field1064 == null) {
                  Client.field1064 = "Null";
               }

               if(var8.hasScript) {
                  Client.field1019 = var8.name + class46.getColTags(16777215);
               } else {
                  Client.field1019 = class46.getColTags('\uff00') + var8.field2769 + class46.getColTags(16777215);
               }
            }

         } else {
            if(var2 == 36) {
               Client.secretPacketBuffer1.putOpcode(56);
               Client.secretPacketBuffer1.putShortOb2(var3);
               Client.secretPacketBuffer1.putShort(var0);
               Client.secretPacketBuffer1.putLEInt(var1);
               Client.field1017 = 0;
               class35.field482 = class61.method1038(var1);
               Client.field1048 = var0;
            }

            if(var2 == 5) {
               Client.field1013 = var6;
               Client.field1071 = var7;
               Client.cursorState = 2;
               Client.field1015 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(156);
               Client.secretPacketBuffer1.putShort(class10.baseY + var1);
               Client.secretPacketBuffer1.putLEShortA(var3 >> 14 & 32767);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field626[82]?1:0);
               Client.secretPacketBuffer1.putLEShortA(var0 + class163.baseX);
            }

            if(var2 == 1002) {
               Client.field1013 = var6;
               Client.field1071 = var7;
               Client.cursorState = 2;
               Client.field1015 = 0;
               Client.secretPacketBuffer1.putOpcode(152);
               Client.secretPacketBuffer1.putLEShortA(var3 >> 14 & 32767);
            }

            if(var2 == 12) {
               var19 = Client.cachedNPCs[var3];
               if(var19 != null) {
                  Client.field1013 = var6;
                  Client.field1071 = var7;
                  Client.cursorState = 2;
                  Client.field1015 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(242);
                  Client.secretPacketBuffer1.putShortOb2(var3);
                  Client.secretPacketBuffer1.method3164(KeyFocusListener.field626[82]?1:0);
               }
            }

            if(var2 == 9) {
               var19 = Client.cachedNPCs[var3];
               if(var19 != null) {
                  Client.field1013 = var6;
                  Client.field1071 = var7;
                  Client.cursorState = 2;
                  Client.field1015 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(250);
                  Client.secretPacketBuffer1.putShort(var3);
                  Client.secretPacketBuffer1.method3164(KeyFocusListener.field626[82]?1:0);
               }
            }

            if(var2 == 34) {
               Client.secretPacketBuffer1.putOpcode(172);
               Client.secretPacketBuffer1.putShortOb2(var0);
               Client.secretPacketBuffer1.method3291(var1);
               Client.secretPacketBuffer1.putLEShortA(var3);
               Client.field1017 = 0;
               class35.field482 = class61.method1038(var1);
               Client.field1048 = var0;
            }

            if(var2 == 58) {
               var8 = class12.method70(var1, var0);
               if(var8 != null) {
                  Client.secretPacketBuffer1.putOpcode(248);
                  Client.secretPacketBuffer1.method3171(var0);
                  Client.secretPacketBuffer1.putLEInt(class41.field550);
                  Client.secretPacketBuffer1.method3291(var1);
                  Client.secretPacketBuffer1.method3171(Client.field1063);
                  Client.secretPacketBuffer1.putShort(var8.itemId);
                  Client.secretPacketBuffer1.putShortOb2(Client.field1062);
               }
            }

            if(var2 == 48) {
               var18 = Client.cachedPlayers[var3];
               if(var18 != null) {
                  Client.field1013 = var6;
                  Client.field1071 = var7;
                  Client.cursorState = 2;
                  Client.field1015 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(69);
                  Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field626[82]?1:0);
                  Client.secretPacketBuffer1.putShortOb2(var3);
               }
            }

            if(var2 == 11) {
               var19 = Client.cachedNPCs[var3];
               if(var19 != null) {
                  Client.field1013 = var6;
                  Client.field1071 = var7;
                  Client.cursorState = 2;
                  Client.field1015 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(217);
                  Client.secretPacketBuffer1.putLEShortA(var3);
                  Client.secretPacketBuffer1.method3127(KeyFocusListener.field626[82]?1:0);
               }
            }

            if(var2 == 19) {
               Client.field1013 = var6;
               Client.field1071 = var7;
               Client.cursorState = 2;
               Client.field1015 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(1);
               Client.secretPacketBuffer1.method3127(KeyFocusListener.field626[82]?1:0);
               Client.secretPacketBuffer1.method3171(var3);
               Client.secretPacketBuffer1.method3171(class10.baseY + var1);
               Client.secretPacketBuffer1.method3171(var0 + class163.baseX);
            }

            if(var2 == 24) {
               var8 = class61.method1038(var1);
               boolean var21 = true;
               if(var8.contentType > 0) {
                  var21 = SoundTask.method2059(var8);
               }

               if(var21) {
                  Client.secretPacketBuffer1.putOpcode(9);
                  Client.secretPacketBuffer1.putInt(var1);
               }
            }

            if(var2 == 8) {
               var19 = Client.cachedNPCs[var3];
               if(var19 != null) {
                  Client.field1013 = var6;
                  Client.field1071 = var7;
                  Client.cursorState = 2;
                  Client.field1015 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(175);
                  Client.secretPacketBuffer1.putShortOb2(var3);
                  Client.secretPacketBuffer1.method3171(Client.field1062);
                  Client.secretPacketBuffer1.putLEInt(class41.field550);
                  Client.secretPacketBuffer1.method3127(KeyFocusListener.field626[82]?1:0);
               }
            }

            if(var2 == 41) {
               Client.secretPacketBuffer1.putOpcode(66);
               Client.secretPacketBuffer1.putLEShortA(var3);
               Client.secretPacketBuffer1.method3181(var1);
               Client.secretPacketBuffer1.putShortOb2(var0);
               Client.field1017 = 0;
               class35.field482 = class61.method1038(var1);
               Client.field1048 = var0;
            }

            if(var2 == 20) {
               Client.field1013 = var6;
               Client.field1071 = var7;
               Client.cursorState = 2;
               Client.field1015 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(59);
               Client.secretPacketBuffer1.method3171(var3);
               Client.secretPacketBuffer1.method3171(var0 + class163.baseX);
               Client.secretPacketBuffer1.putShortOb2(class10.baseY + var1);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field626[82]?1:0);
            }

            if(var2 == 37) {
               Client.secretPacketBuffer1.putOpcode(58);
               Client.secretPacketBuffer1.method3171(var0);
               Client.secretPacketBuffer1.method3291(var1);
               Client.secretPacketBuffer1.putShort(var3);
               Client.field1017 = 0;
               class35.field482 = class61.method1038(var1);
               Client.field1048 = var0;
            }

            if(var2 == 29) {
               Client.secretPacketBuffer1.putOpcode(9);
               Client.secretPacketBuffer1.putInt(var1);
               var8 = class61.method1038(var1);
               if(var8.dynamicValues != null && var8.dynamicValues[0][0] == 5) {
                  var15 = var8.dynamicValues[0][1];
                  if(class211.widgetSettings[var15] != var8.field2654[0]) {
                     class211.widgetSettings[var15] = var8.field2654[0];
                     class3.method8(var15);
                  }
               }
            }

            if(var2 == 22) {
               Client.field1013 = var6;
               Client.field1071 = var7;
               Client.cursorState = 2;
               Client.field1015 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(105);
               Client.secretPacketBuffer1.putLEShortA(var0 + class163.baseX);
               Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field626[82]?1:0);
               Client.secretPacketBuffer1.putShort(class10.baseY + var1);
               Client.secretPacketBuffer1.method3171(var3);
            }

            if(var2 == 4) {
               Client.field1013 = var6;
               Client.field1071 = var7;
               Client.cursorState = 2;
               Client.field1015 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(25);
               Client.secretPacketBuffer1.putLEShortA(class10.baseY + var1);
               Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
               Client.secretPacketBuffer1.method3164(KeyFocusListener.field626[82]?1:0);
               Client.secretPacketBuffer1.method3171(var0 + class163.baseX);
            }

            if(var2 == 18) {
               Client.field1013 = var6;
               Client.field1071 = var7;
               Client.cursorState = 2;
               Client.field1015 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(144);
               Client.secretPacketBuffer1.method3171(var0 + class163.baseX);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.putShort(class10.baseY + var1);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field626[82]?1:0);
            }

            if(var2 == 32) {
               Client.secretPacketBuffer1.putOpcode(88);
               Client.secretPacketBuffer1.putLEInt(class41.field550);
               Client.secretPacketBuffer1.putShortOb2(var3);
               Client.secretPacketBuffer1.putLEShortA(Client.field1062);
               Client.secretPacketBuffer1.putLEInt(var1);
               Client.secretPacketBuffer1.method3171(var0);
               Client.field1017 = 0;
               class35.field482 = class61.method1038(var1);
               Client.field1048 = var0;
            }

            if(var2 == 57 || var2 == 1007) {
               var8 = class12.method70(var1, var0);
               if(var8 != null) {
                  var15 = var8.itemId;
                  Widget var16 = class12.method70(var1, var0);
                  if(var16 != null) {
                     if(var16.field2753 != null) {
                        ScriptEvent var17 = new ScriptEvent();
                        var17.widget = var16;
                        var17.field832 = var3;
                        var17.field837 = var5;
                        var17.field839 = var16.field2753;
                        class89.method1689(var17);
                     }

                     boolean var11 = true;
                     if(var16.contentType > 0) {
                        var11 = SoundTask.method2059(var16);
                     }

                     if(var11 && class90.method1692(class46.getWidgetConfig(var16), var3 - 1)) {
                        if(var3 == 1) {
                           Client.secretPacketBuffer1.putOpcode(215);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var15);
                        }

                        if(var3 == 2) {
                           Client.secretPacketBuffer1.putOpcode(85);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var15);
                        }

                        if(var3 == 3) {
                           Client.secretPacketBuffer1.putOpcode(61);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var15);
                        }

                        if(var3 == 4) {
                           Client.secretPacketBuffer1.putOpcode(149);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var15);
                        }

                        if(var3 == 5) {
                           Client.secretPacketBuffer1.putOpcode(200);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var15);
                        }

                        if(var3 == 6) {
                           Client.secretPacketBuffer1.putOpcode(191);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var15);
                        }

                        if(var3 == 7) {
                           Client.secretPacketBuffer1.putOpcode(98);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var15);
                        }

                        if(var3 == 8) {
                           Client.secretPacketBuffer1.putOpcode(31);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var15);
                        }

                        if(var3 == 9) {
                           Client.secretPacketBuffer1.putOpcode(76);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var15);
                        }

                        if(var3 == 10) {
                           Client.secretPacketBuffer1.putOpcode(108);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putShort(var15);
                        }
                     }
                  }
               }
            }

            if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class29.region.method2738();
               } else {
                  class29.region.method2703(class45.plane, var0, var1, true);
               }
            }

            if(var2 == 14) {
               var18 = Client.cachedPlayers[var3];
               if(var18 != null) {
                  Client.field1013 = var6;
                  Client.field1071 = var7;
                  Client.cursorState = 2;
                  Client.field1015 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(170);
                  Client.secretPacketBuffer1.method3171(class95.field1484);
                  Client.secretPacketBuffer1.putShort(var3);
                  Client.secretPacketBuffer1.putInt(class3.field17);
                  Client.secretPacketBuffer1.putByte(KeyFocusListener.field626[82]?1:0);
                  Client.secretPacketBuffer1.method3171(class11.selectedItemIndex);
               }
            }

            if(var2 == 44) {
               var18 = Client.cachedPlayers[var3];
               if(var18 != null) {
                  Client.field1013 = var6;
                  Client.field1071 = var7;
                  Client.cursorState = 2;
                  Client.field1015 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(143);
                  Client.secretPacketBuffer1.putByte(KeyFocusListener.field626[82]?1:0);
                  Client.secretPacketBuffer1.putShortOb2(var3);
               }
            }

            if(var2 == 50) {
               var18 = Client.cachedPlayers[var3];
               if(var18 != null) {
                  Client.field1013 = var6;
                  Client.field1071 = var7;
                  Client.cursorState = 2;
                  Client.field1015 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(93);
                  Client.secretPacketBuffer1.method3164(KeyFocusListener.field626[82]?1:0);
                  Client.secretPacketBuffer1.putLEShortA(var3);
               }
            }

            if(var2 == 46) {
               var18 = Client.cachedPlayers[var3];
               if(var18 != null) {
                  Client.field1013 = var6;
                  Client.field1071 = var7;
                  Client.cursorState = 2;
                  Client.field1015 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(157);
                  Client.secretPacketBuffer1.putByte(KeyFocusListener.field626[82]?1:0);
                  Client.secretPacketBuffer1.putLEShortA(var3);
               }
            }

            if(var2 == 49) {
               var18 = Client.cachedPlayers[var3];
               if(var18 != null) {
                  Client.field1013 = var6;
                  Client.field1071 = var7;
                  Client.cursorState = 2;
                  Client.field1015 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(20);
                  Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field626[82]?1:0);
                  Client.secretPacketBuffer1.putShort(var3);
               }
            }

            if(var2 == 3) {
               Client.field1013 = var6;
               Client.field1071 = var7;
               Client.cursorState = 2;
               Client.field1015 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(113);
               Client.secretPacketBuffer1.method3127(KeyFocusListener.field626[82]?1:0);
               Client.secretPacketBuffer1.putShort(var0 + class163.baseX);
               Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
               Client.secretPacketBuffer1.putLEShortA(class10.baseY + var1);
            }

            if(var2 == 47) {
               var18 = Client.cachedPlayers[var3];
               if(var18 != null) {
                  Client.field1013 = var6;
                  Client.field1071 = var7;
                  Client.cursorState = 2;
                  Client.field1015 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(49);
                  Client.secretPacketBuffer1.putShort(var3);
                  Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field626[82]?1:0);
               }
            }

            if(var2 == 1001) {
               Client.field1013 = var6;
               Client.field1071 = var7;
               Client.cursorState = 2;
               Client.field1015 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(5);
               Client.secretPacketBuffer1.putShort(var0 + class163.baseX);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field626[82]?1:0);
               Client.secretPacketBuffer1.method3171(class10.baseY + var1);
               Client.secretPacketBuffer1.putLEShortA(var3 >> 14 & 32767);
            }

            if(var2 == 21) {
               Client.field1013 = var6;
               Client.field1071 = var7;
               Client.cursorState = 2;
               Client.field1015 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(107);
               Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field626[82]?1:0);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.method3171(var0 + class163.baseX);
               Client.secretPacketBuffer1.putShortOb2(class10.baseY + var1);
            }

            if(var2 == 17) {
               Client.field1013 = var6;
               Client.field1071 = var7;
               Client.cursorState = 2;
               Client.field1015 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(177);
               Client.secretPacketBuffer1.putShortOb2(Client.field1062);
               Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field626[82]?1:0);
               Client.secretPacketBuffer1.putShortOb2(var3);
               Client.secretPacketBuffer1.putShort(class10.baseY + var1);
               Client.secretPacketBuffer1.putLEShortA(var0 + class163.baseX);
               Client.secretPacketBuffer1.method3291(class41.field550);
            }

            if(var2 == 10) {
               var19 = Client.cachedNPCs[var3];
               if(var19 != null) {
                  Client.field1013 = var6;
                  Client.field1071 = var7;
                  Client.cursorState = 2;
                  Client.field1015 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(74);
                  Client.secretPacketBuffer1.method3127(KeyFocusListener.field626[82]?1:0);
                  Client.secretPacketBuffer1.method3171(var3);
               }
            }

            if(Client.itemSelectionState != 0) {
               Client.itemSelectionState = 0;
               class48.method749(class61.method1038(class3.field17));
            }

            if(Client.spellSelected) {
               class66.method1085();
            }

            if(class35.field482 != null && Client.field1017 == 0) {
               class48.method749(class35.field482);
            }

         }
      }
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "638055344"
   )
   static void method480() {
      Client.secretPacketBuffer1.putOpcode(220);
      PacketBuffer var0 = Client.secretPacketBuffer1;
      int var1 = Client.isResized?2:1;
      var0.putByte(var1);
      Client.secretPacketBuffer1.putShort(class77.canvasWidth);
      Client.secretPacketBuffer1.putShort(FloorUnderlayDefinition.canvasHeight);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1791157756"
   )
   public static int method482(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "1351695451"
   )
   static final String[] method481(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
