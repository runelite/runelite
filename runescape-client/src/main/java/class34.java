import java.io.IOException;
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

@ObfuscatedName("aq")
public class class34 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   static final Coordinates field495;
   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "[Lky;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   SpritePixels field494;
   @ObfuscatedName("n")
   List field500;
   @ObfuscatedName("x")
   int[][] field493;
   @ObfuscatedName("p")
   LinkedList field490;
   @ObfuscatedName("u")
   HashMap field503;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lr;"
   )
   class22 field504;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1702156401
   )
   int field487;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 172543097
   )
   int field484;
   @ObfuscatedName("t")
   final HashMap field492;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 176515067
   )
   int field488;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -491575563
   )
   int field491;

   static {
      field495 = new Coordinates();
   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field487 = var1;
      this.field488 = var2;
      this.field490 = new LinkedList();
      this.field500 = new LinkedList();
      this.field503 = new HashMap();
      this.field491 = var3 | -16777216;
      this.field492 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "71"
   )
   boolean method359(int var1) {
      if(this.field494 != null && this.field484 == var1) {
         return false;
      } else {
         this.field484 = var1;
         this.field494 = new SpritePixels(this.field484 * 64, this.field484 * 64);
         return true;
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IILaa;I)V",
      garbageValue = "-1396933543"
   )
   void method372(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field415; ++var4) {
         class31[] var5 = var3.field425[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               int var10 = var8.field460;
               boolean var9 = var10 >= class221.field2815.field2825 && var10 <= class221.field2812.field2825 || var10 == class221.field2806.field2825;
               if(var9) {
                  ObjectComposition var11 = CollisionData.getObjectDefinition(var8.field459);
                  int var12 = var11.field3454 != 0?-3407872:-3355444;
                  if(var8.field460 == class221.field2815.field2825) {
                     this.method364(var1, var2, var8.field456, var12);
                  }

                  if(var8.field460 == class221.field2804.field2825) {
                     this.method364(var1, var2, var8.field456, -3355444);
                     this.method364(var1, var2, var8.field456 + 1, var12);
                  }

                  if(var8.field460 == class221.field2812.field2825) {
                     if(var8.field456 == 0) {
                        Rasterizer2D.method5053(this.field484 * var1, this.field484 * (63 - var2), 1, var12);
                     }

                     if(var8.field456 == 1) {
                        Rasterizer2D.method5053(this.field484 + this.field484 * var1 - 1, this.field484 * (63 - var2), 1, var12);
                     }

                     if(var8.field456 == 2) {
                        Rasterizer2D.method5053(this.field484 + this.field484 * var1 - 1, this.field484 * (63 - var2) + this.field484 - 1, 1, var12);
                     }

                     if(var8.field456 == 3) {
                        Rasterizer2D.method5053(this.field484 * var1, this.field484 * (63 - var2) + this.field484 - 1, 1, var12);
                     }
                  }

                  if(var8.field460 == class221.field2806.field2825) {
                     int var13 = var8.field456 % 2;
                     int var14;
                     if(var13 == 0) {
                        for(var14 = 0; var14 < this.field484; ++var14) {
                           Rasterizer2D.method5053(var14 + this.field484 * var1, (64 - var2) * this.field484 - 1 - var14, 1, var12);
                        }
                     } else {
                        for(var14 = 0; var14 < this.field484; ++var14) {
                           Rasterizer2D.method5053(var14 + this.field484 * var1, var14 + this.field484 * (63 - var2), 1, var12);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "1195560969"
   )
   void method373(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field503.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var9.worldX * var5 + (float)var1 - var6);
         int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.worldY - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field552 = var10;
            var12.field549 = var11;
            Area var13 = Area.field3285[var12.field556];
            if(!var3.contains(Integer.valueOf(var13.method4381()))) {
               this.method376(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IILaa;[Ljo;B)V",
      garbageValue = "78"
   )
   void method371(int var1, int var2, class28 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field415; ++var5) {
         class31[] var6 = var3.field425[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               if(class27.method222(var9.field460) || class54.method779(var9.field460)) {
                  ObjectComposition var10 = CollisionData.getObjectDefinition(var9.field459);
                  if(var10.mapSceneId != -1) {
                     if(var10.mapSceneId != 46 && var10.mapSceneId != 52) {
                        var4[var10.mapSceneId].method5161(this.field484 * var1, this.field484 * (63 - var2), this.field484 * 2, this.field484 * 2);
                     } else {
                        var4[var10.mapSceneId].method5161(this.field484 * var1, this.field484 * (63 - var2), this.field484 * 2 + 1, this.field484 * 2 + 1);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lid;B)Lao;",
      garbageValue = "-68"
   )
   class33 method407(Area var1) {
      if(var1.name != null && this.field492 != null && this.field492.get(class24.field378) != null) {
         int var3 = var1.field3284;
         class24[] var4 = class24.method179();
         int var5 = 0;

         class24 var2;
         while(true) {
            if(var5 >= var4.length) {
               var2 = null;
               break;
            }

            class24 var6 = var4[var5];
            if(var3 == var6.field373) {
               var2 = var6;
               break;
            }

            ++var5;
         }

         if(var2 == null) {
            return null;
         } else {
            Font var14 = (Font)this.field492.get(var2);
            if(var14 == null) {
               return null;
            } else {
               int var15 = var14.method4840(var1.name, 1000000);
               String[] var7 = new String[var15];
               var14.method4838(var1.name, (int[])null, var7);
               int var8 = var7.length * var14.verticalSpace / 2;
               int var9 = 0;
               String[] var10 = var7;

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  String var12 = var10[var11];
                  int var13 = var14.method4848(var12);
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IILaa;Lar;I)V",
      garbageValue = "615215173"
   )
   void method375(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field421[0][var1][var2] - 1;
      int var6 = var3.field417[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.method5045(this.field484 * var1, this.field484 * (63 - var2), this.field484, this.field484, this.field491);
      }

      int var7 = 16711935;
      if(var6 != -1) {
         var7 = class11.method60(var6, this.field491);
      }

      if(var6 > -1 && var3.field422[0][var1][var2] == 0) {
         Rasterizer2D.method5045(this.field484 * var1, this.field484 * (63 - var2), this.field484, this.field484, var7);
      } else {
         int var8 = this.method445(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.method5045(this.field484 * var1, this.field484 * (63 - var2), this.field484, this.field484, var8);
         } else {
            var4.method655(this.field484 * var1, this.field484 * (63 - var2), var8, var7, this.field484, this.field484, var3.field422[0][var1][var2], var3.field424[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lid;III)V",
      garbageValue = "680810065"
   )
   void method377(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.method4368(false);
      if(var4 != null) {
         int var5 = this.method382(var4, var1.field3294);
         int var6 = this.method383(var4, var1.field3301);
         var4.drawAt(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "2005300625"
   )
   void method458(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field500.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field548.worldX % 64;
         int var9 = var7.field548.worldY % 64;
         var7.field552 = (int)((float)var1 + var5 * (float)var8);
         var7.field549 = (int)(var5 * (float)(63 - var9) + (float)var2);
         if(!var3.contains(Integer.valueOf(var7.field556))) {
            this.method376(var7, var7.field552, var7.field549, var5);
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lky;Lim;I)I",
      garbageValue = "1353275461"
   )
   int method382(SpritePixels var1, class257 var2) {
      switch(var2.field3547) {
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
      signature = "(IIB)I",
      garbageValue = "-26"
   )
   int method390(int var1, int var2) {
      if(this.field504 != null) {
         return this.field504.method227(var1, var2);
      } else {
         if(!this.field490.isEmpty()) {
            Iterator var3 = this.field490.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method633(var1, var2)) {
                  return var4.method227(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IILaa;Lar;[Ljo;I)V",
      garbageValue = "1862894887"
   )
   void method362(int var1, int var2, class28 var3, class46 var4, IndexedSprite[] var5) {
      this.method372(var1, var2, var3);
      this.method371(var1, var2, var3, var5);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;IIB)V",
      garbageValue = "-23"
   )
   void method374(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field500.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         Area var6 = Area.field3285[var5.field556];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4381()))) {
            this.method350(var6, var5.field552, var5.field549, var2, var3);
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIILaa;I)V",
      garbageValue = "-1867682721"
   )
   void method354(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label56:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field415; ++var9) {
               class31[] var10 = var5.field425[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method384(var13.field459);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field487 * 64 + var6, this.field488 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field504 != null) {
                           var16 = new Coordinates(this.field504.field419 + var9, var6 + this.field504.field423 * 64, var7 + this.field504.field416 * 64);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var9 + var17.field419, var17.field423 * 64 + var6 + var17.method628() * 8, var7 + var17.field416 * 64 + var17.method624() * 8);
                        }

                        class39 var18 = new class39(var14.field3287, var16, var15, this.method407(var14));
                        this.field503.put(var8, var18);
                        continue label56;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([Laq;I)Z",
      garbageValue = "932879117"
   )
   boolean method365(class34[] var1) {
      if(this.field493 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field504 != null) {
            this.method425(0, 0, 64, 64, this.field504, var2);
         } else {
            Iterator var3 = this.field490.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method425(var4.method649() * 8, var4.method631() * 8, 8, 8, var4, var2);
            }
         }

         this.method367(var1, var2);
         this.method366(var2);
         return true;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;B)V",
      garbageValue = "31"
   )
   void method385(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field383.worldX >> 6 == this.field487 && var3.field383.worldY >> 6 == this.field488) {
            class39 var4 = new class39(var3.field380, var3.field383, var3.field383, this.method446(var3.field380));
            this.field500.add(var4);
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lab;Lid;IIFB)V",
      garbageValue = "-73"
   )
   void method431(class39 var1, Area var2, int var3, int var4, float var5) {
      if(var1.field551 != null) {
         if(var1.field551.field477.method185(var5)) {
            Font var6 = (Font)this.field492.get(var1.field551.field477);
            var6.method4915(var1.field551.field482, var3 - var1.field551.field479 / 2, var4, var1.field551.field479, var1.field551.field478, -16777216 | var2.field3292, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IILaa;B)V",
      garbageValue = "-92"
   )
   void method381(int var1, int var2, class28 var3) {
      field495.method4013(0, var1, var2);

      for(int var4 = 0; var4 < var3.field415; ++var4) {
         class31[] var5 = var3.field425[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method384(var8.field459);
               if(var9 != null) {
                  class39 var10 = (class39)this.field503.get(field495);
                  if(var10 != null) {
                     if(var10.field556 != var9.field3287) {
                        class39 var16 = new class39(var9.field3287, var10.field559, var10.field548, this.method407(var9));
                        this.field503.put(new Coordinates(field495), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field559.plane - var10.field548.plane;
                     var10.field548.plane = var4;
                     var10.field559.plane = var15 + var4;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field487 * 64 + var1, this.field488 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field504 != null) {
                     var12 = new Coordinates(this.field504.field419 + var4, this.field504.field423 * 64 + var1, var2 + this.field504.field416 * 64);
                  } else {
                     Iterator var13 = this.field490.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method633(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field419, var14.field423 * 64 + var1 + var14.method628() * 8, var2 + var14.field416 * 64 + var14.method624() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3287, var12, var11, this.method407(var9));
                     this.field503.put(new Coordinates(field495), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field503.remove(field495);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IILaa;Lar;I)V",
      garbageValue = "-552066400"
   )
   void method423(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field415; ++var5) {
         int var6 = var3.field417[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = class11.method60(var6, this.field491);
            if(var3.field422[var5][var1][var2] == 0) {
               Rasterizer2D.method5045(this.field484 * var1, this.field484 * (63 - var2), this.field484, this.field484, var7);
            } else {
               var4.method655(this.field484 * var1, this.field484 * (63 - var2), 0, var7, this.field484, this.field484, var3.field422[var5][var1][var2], var3.field424[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lky;Lij;I)I",
      garbageValue = "1396758309"
   )
   int method383(SpritePixels var1, class239 var2) {
      switch(var2.field3266) {
      case 0:
         return 0;
      case 2:
         return -var1.height / 2;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIILaa;Lam;B)V",
      garbageValue = "-113"
   )
   void method425(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field421[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = class229.method4165(var9);
               var6.method613(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([Laq;Lam;I)V",
      garbageValue = "291472133"
   )
   void method367(class34[] var1, class43 var2) {
      class228[] var3 = new class228[]{class228.field3155, class228.field3163, class228.field3150, class228.field3151, class228.field3157, class228.field3154, class228.field3152, class228.field3153};
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
            switch(var7.field3156) {
            case 0:
               var13 = 59;
               var11 = 5;
               break;
            case 1:
               var9 = 59;
               var11 = 5;
               var12 = 59;
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
               break;
            case 4:
               var8 = 59;
               var10 = 5;
               break;
            case 5:
               var12 = 59;
               var13 = 59;
               var10 = 5;
               var11 = 5;
               break;
            case 6:
               var12 = 59;
               var10 = 5;
               break;
            case 7:
               var13 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
            }

            this.method369(var12, var13, var8, var9, var10, var11, var1[var7.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lam;I)V",
      garbageValue = "-2055090941"
   )
   void method366(class43 var1) {
      this.field493 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field493[var2][var3] = var1.method608(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lar;[Laq;[Ljo;B)V",
      garbageValue = "-69"
   )
   void method360(class46 var1, class34[] var2, IndexedSprite[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method375(var4, var5, this.field504, var1);
            this.method423(var4, var5, this.field504, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method362(var4, var5, this.field504, var1, var3);
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lar;[Ljo;I)V",
      garbageValue = "2017817240"
   )
   void method412(class46 var1, IndexedSprite[] var2) {
      Iterator var3 = this.field490.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method649() * 8; var5 < var4.method649() * 8 + 8; ++var5) {
            for(var6 = var4.method631() * 8; var6 < var4.method631() * 8 + 8; ++var6) {
               this.method375(var5, var6, var4, var1);
               this.method423(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field490.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method649() * 8; var5 < var4.method649() * 8 + 8; ++var5) {
            for(var6 = var4.method631() * 8; var6 < var4.method631() * 8 + 8; ++var6) {
               this.method362(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IILaa;S)I",
      garbageValue = "-24355"
   )
   int method445(int var1, int var2, class28 var3) {
      return var3.field421[0][var1][var2] == 0?this.field491:this.field493[var1][var2];
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IS)Lid;",
      garbageValue = "383"
   )
   Area method384(int var1) {
      ObjectComposition var2 = CollisionData.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.field3285[var2.mapIconId]:null;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lid;IIIIB)V",
      garbageValue = "64"
   )
   void method350(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.method4368(false);
      if(var6 != null) {
         var6.drawAt(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method5039(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method5039(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/List;",
      garbageValue = "-472568392"
   )
   List method415() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field500);
      var1.addAll(this.field503.values());
      return var1;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IB)Lao;",
      garbageValue = "-68"
   )
   class33 method446(int var1) {
      Area var2 = Area.field3285[var1];
      return this.method407(var2);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Lab;IIFI)V",
      garbageValue = "1091799419"
   )
   void method376(class39 var1, int var2, int var3, float var4) {
      Area var5 = Area.field3285[var1.field556];
      this.method377(var5, var2, var3);
      this.method431(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1854920824"
   )
   void method380() {
      if(this.field504 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method381(var1, var2, this.field504);
            }
         }
      } else {
         Iterator var5 = this.field490.iterator();

         while(var5.hasNext()) {
            class45 var6 = (class45)var5.next();

            for(int var3 = var6.method649() * 8; var3 < var6.method649() * 8 + 8; ++var3) {
               for(int var4 = var6.method631() * 8; var4 < var6.method631() * 8 + 8; ++var4) {
                  this.method381(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;IIB)V",
      garbageValue = "-3"
   )
   void method358(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field503.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field556))) {
            Area var6 = Area.field3285[var5.field556];
            this.method350(var6, var5.field552, var5.field549, var2, var3);
         }
      }

      this.method374(var1, var2, var3);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1829206522"
   )
   void method364(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method5055(this.field484 * var1, this.field484 * (63 - var2), this.field484, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5053(this.field484 * var1, this.field484 * (63 - var2), this.field484, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5055(this.field484 * var1 + this.field484 - 1, this.field484 * (63 - var2), this.field484, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5053(this.field484 * var1, this.field484 * (63 - var2) + this.field484 - 1, this.field484, var4);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;B)V",
      garbageValue = "88"
   )
   void method357(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method373(var1, var2, var4, var3);
      this.method458(var1, var2, var4, var3);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IIIIII)Ljava/util/List;",
      garbageValue = "-106798179"
   )
   List method387(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field503.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method523(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field500.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method523(var4, var5)) {
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILar;[Laq;[Ljo;I)Z",
      garbageValue = "647296069"
   )
   boolean method469(int var1, class46 var2, class34[] var3, IndexedSprite[] var4) {
      if(!this.method359(var1)) {
         return false;
      } else if(this.field504 == null && this.field490.isEmpty()) {
         return false;
      } else {
         this.method365(var3);
         this.field494.method5165();
         if(this.field504 != null) {
            this.method360(var2, var3, var4);
         } else {
            this.method412(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIILaq;Lam;I)V",
      garbageValue = "-1975692682"
   )
   void method369(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method390(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = class229.method4165(var11);
               var8.method613(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1447281530"
   )
   void method351(int var1, int var2, int var3) {
      if(this.field494 != null) {
         if(var3 == this.field484 * 64) {
            this.field494.method5172(var1, var2);
         } else {
            this.field494.method5188(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lr;Ljava/util/List;I)V",
      garbageValue = "-1638786668"
   )
   void method352(class22 var1, List var2) {
      this.field503.clear();
      this.field504 = var1;
      this.method354(0, 0, 64, 64, this.field504);
      this.method385(var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;B)V",
      garbageValue = "74"
   )
   void method353(HashSet var1, List var2) {
      this.field503.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method226() == this.field487 && var4.method229() == this.field488) {
            this.field490.add(var4);
            this.method354(var4.method649() * 8, var4.method631() * 8, 8, 8, var4);
         }
      }

      this.method385(var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "6"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class238.field3255 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class238.field3255.queueForWrite(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class238.field3255.close();
            } catch (Exception var3) {
               ;
            }

            ++class238.field3264;
            class238.field3255 = null;
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1666984904"
   )
   static final int method475(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & 16711935) * var2 + var3 * (var0 & 16711935) & -16711936) + ((var0 & 65280) * var3 + (var1 & 65280) * var2 & 16711680) >> 8;
   }
}
