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

@ObfuscatedName("az")
public class class35 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   static class213 field485;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   static class213 field484;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   static final Coordinates field496;
   @ObfuscatedName("kl")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   static Widget field497;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1759197995
   )
   int field494;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 115713563
   )
   int field488;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   class22 field498;
   @ObfuscatedName("h")
   LinkedList field490;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 86798001
   )
   int field491;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 217151411
   )
   int field486;
   @ObfuscatedName("u")
   List field493;
   @ObfuscatedName("q")
   HashMap field489;
   @ObfuscatedName("v")
   @Export("mapFonts")
   final HashMap mapFonts;

   static {
      field485 = new class213(37748736, 256);
      field484 = new class213(256, 256);
      field496 = new Coordinates();
   }

   class35(int var1, int var2, int var3, HashMap var4) {
      this.field494 = var1;
      this.field488 = var2;
      this.field490 = new LinkedList();
      this.field493 = new LinkedList();
      this.field489 = new HashMap();
      this.field491 = var3 | -16777216;
      this.mapFonts = var4;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-77"
   )
   void method371(int var1, int var2, int var3) {
      SpritePixels var4 = class57.method826(this.field494, this.field488, this.field486);
      if(var4 != null) {
         if(var3 == this.field486 * 64) {
            var4.method6003(var1, var2);
         } else {
            var4.method5942(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lg;Ljava/util/List;I)V",
      garbageValue = "1448596412"
   )
   void method372(class22 var1, List var2) {
      this.field489.clear();
      this.field498 = var1;
      this.method374(0, 0, 64, 64, this.field498);
      this.method453(var2);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;S)V",
      garbageValue = "-24275"
   )
   void method373(HashSet var1, List var2) {
      this.field489.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class46 var4 = (class46)var3.next();
         if(var4.method230() == this.field494 && var4.method231() == this.field488) {
            this.field490.add(var4);
            this.method374(var4.method650() * 8, var4.method647() * 8, 8, 8, var4);
         }
      }

      this.method453(var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIILac;I)V",
      garbageValue = "1025023312"
   )
   void method374(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label55:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field410; ++var9) {
               class31[] var10 = var5.field417[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method464(var13.field450);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field494 * 64 + var6, this.field488 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field498 != null) {
                           var16 = new Coordinates(this.field498.field414 + var9, var6 + this.field498.field411 * 64, var7 + this.field498.field420 * 64);
                        } else {
                           class46 var17 = (class46)var5;
                           var16 = new Coordinates(var9 + var17.field414, var6 + var17.field411 * 64 + var17.method644() * 8, var7 + var17.field420 * 64 + var17.method645() * 8);
                        }

                        MapIcon var18 = new MapIcon(var14.id, var16, var15, this.method419(var14));
                        this.field489.put(var8, var18);
                        continue label55;
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
      garbageValue = "-1605172206"
   )
   void method453(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field374.worldX >> 6 == this.field494 && var3.field374.worldY >> 6 == this.field488) {
            MapIcon var4 = new MapIcon(var3.field378, var3.field374, var3.field374, this.method430(var3.field378));
            this.field493.add(var4);
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILam;[Laz;[Llv;I)V",
      garbageValue = "-927762151"
   )
   void method463(int var1, class47 var2, class35[] var3, IndexedSprite[] var4) {
      this.field486 = var1;
      if(this.field498 != null || !this.field490.isEmpty()) {
         if(class57.method826(this.field494, this.field488, var1) == null) {
            class33 var5 = this.method446(this.field494, this.field488, var3);
            SpritePixels var6 = new SpritePixels(this.field486 * 64, this.field486 * 64);
            var6.method5912();
            if(this.field498 != null) {
               this.method461(var2, var3, var4, var5);
            } else {
               this.method380(var2, var4, var5);
            }

            int var7 = this.field494;
            int var8 = this.field488;
            int var9 = this.field486;
            class213 var10 = field485;
            long var12 = (long)(var9 << 16 | var7 << 8 | var8);
            var10.method4047(var6, var12, var6.pixels.length * 4);
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "522542096"
   )
   void method377(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.drawNonLinkMapIcons(var1, var2, var4, var3);
      this.drawMapLinks(var1, var2, var4, var3);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;IIB)V",
      garbageValue = "-31"
   )
   @Export("drawFlashingMapIcons")
   void drawFlashingMapIcons(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field489.values().iterator();

      while(var4.hasNext()) {
         MapIcon var5 = (MapIcon)var4.next();
         if(var1.contains(Integer.valueOf(var5.areaId))) {
            Area var6 = Area.mapAreaType[var5.areaId];
            this.method394(var6, var5.field538, var5.field537, var2, var3);
         }
      }

      this.method393(var1, var2, var3);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lam;[Laz;[Llv;Laf;I)V",
      garbageValue = "-272710680"
   )
   void method461(class47 var1, class35[] var2, IndexedSprite[] var3, class33 var4) {
      int var5;
      int var6;
      for(var5 = 0; var5 < 64; ++var5) {
         for(var6 = 0; var6 < 64; ++var6) {
            this.method402(var5, var6, this.field498, var1, var4);
            this.method383(var5, var6, this.field498, var1);
         }
      }

      for(var5 = 0; var5 < 64; ++var5) {
         for(var6 = 0; var6 < 64; ++var6) {
            this.method381(var5, var6, this.field498, var1, var3);
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lam;[Llv;Laf;I)V",
      garbageValue = "-1054025485"
   )
   void method380(class47 var1, IndexedSprite[] var2, class33 var3) {
      Iterator var4 = this.field490.iterator();

      class46 var5;
      int var6;
      int var7;
      while(var4.hasNext()) {
         var5 = (class46)var4.next();

         for(var6 = var5.method650() * 8; var6 < var5.method650() * 8 + 8; ++var6) {
            for(var7 = var5.method647() * 8; var7 < var5.method647() * 8 + 8; ++var7) {
               this.method402(var6, var7, var5, var1, var3);
               this.method383(var6, var7, var5, var1);
            }
         }
      }

      var4 = this.field490.iterator();

      while(var4.hasNext()) {
         var5 = (class46)var4.next();

         for(var6 = var5.method650() * 8; var6 < var5.method650() * 8 + 8; ++var6) {
            for(var7 = var5.method647() * 8; var7 < var5.method647() * 8 + 8; ++var7) {
               this.method381(var6, var7, var5, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IILac;Lam;[Llv;B)V",
      garbageValue = "0"
   )
   void method381(int var1, int var2, class28 var3, class47 var4, IndexedSprite[] var5) {
      this.method391(var1, var2, var3);
      this.method390(var1, var2, var3, var5);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IILac;Lam;Laf;B)V",
      garbageValue = "1"
   )
   void method402(int var1, int var2, class28 var3, class47 var4, class33 var5) {
      int var6 = var3.field423[0][var1][var2] - 1;
      int var7 = var3.field416[0][var1][var2] - 1;
      if(var6 == -1 && var7 == -1) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field486 * var1, this.field486 * (63 - var2), this.field486, this.field486, this.field491);
      }

      int var8 = 16711935;
      if(var7 != -1) {
         var8 = UrlRequester.method3167(var7, this.field491);
      }

      if(var7 > -1 && var3.field418[0][var1][var2] == 0) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field486 * var1, this.field486 * (63 - var2), this.field486, this.field486, var8);
      } else {
         int var9 = this.method404(var1, var2, var3, var5);
         if(var7 == -1) {
            Rasterizer2D.Rasterizer2D_fillRectangle(this.field486 * var1, this.field486 * (63 - var2), this.field486, this.field486, var9);
         } else {
            var4.method667(this.field486 * var1, this.field486 * (63 - var2), var9, var8, this.field486, this.field486, var3.field418[0][var1][var2], var3.field419[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IILac;Lam;I)V",
      garbageValue = "-2139218891"
   )
   void method383(int var1, int var2, class28 var3, class47 var4) {
      for(int var5 = 1; var5 < var3.field410; ++var5) {
         int var6 = var3.field416[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = UrlRequester.method3167(var6, this.field491);
            if(var3.field418[var5][var1][var2] == 0) {
               Rasterizer2D.Rasterizer2D_fillRectangle(this.field486 * var1, this.field486 * (63 - var2), this.field486, this.field486, var7);
            } else {
               var4.method667(this.field486 * var1, this.field486 * (63 - var2), 0, var7, this.field486, this.field486, var3.field418[var5][var1][var2], var3.field419[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II[Laz;B)Laf;",
      garbageValue = "-33"
   )
   class33 method446(int var1, int var2, class35[] var3) {
      class33 var4 = MouseRecorder.method1100(var1, var2);
      if(var4 == null) {
         var4 = this.method480(var3);
         class213 var5 = field484;
         long var7 = (long)(0 | var1 << 8 | var2);
         var5.method4046(var4, var7);
      }

      return var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([Laz;I)Laf;",
      garbageValue = "1928777713"
   )
   class33 method480(class35[] var1) {
      class44 var2 = new class44(64, 64);
      if(this.field498 != null) {
         this.method387(0, 0, 64, 64, this.field498, var2);
      } else {
         Iterator var3 = this.field490.iterator();

         while(var3.hasNext()) {
            class46 var4 = (class46)var3.next();
            this.method387(var4.method650() * 8, var4.method647() * 8, 8, 8, var4, var2);
         }
      }

      this.method370(var1, var2);
      class33 var5 = new class33();
      var5.method357(var2);
      return var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([Laz;Lax;I)V",
      garbageValue = "-191244303"
   )
   void method370(class35[] var1, class44 var2) {
      class254[] var3 = class151.method3207();
      class254[] var4 = var3;

      for(int var5 = 0; var5 < var4.length; ++var5) {
         class254 var6 = var4[var5];
         if(var1[var6.rsOrdinal()] != null) {
            byte var7 = 0;
            byte var8 = 0;
            byte var9 = 64;
            byte var10 = 64;
            byte var11 = 0;
            byte var12 = 0;
            switch(var6.field3322) {
            case 0:
               var8 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
               break;
            case 1:
               var11 = 59;
               var12 = 59;
               var9 = 5;
               var10 = 5;
               break;
            case 2:
               var12 = 59;
               var10 = 5;
               break;
            case 3:
               var7 = 59;
               var9 = 5;
               break;
            case 4:
               var11 = 59;
               var9 = 5;
               break;
            case 5:
               var12 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
               break;
            case 6:
               var8 = 59;
               var10 = 5;
               var11 = 59;
               var9 = 5;
               break;
            case 7:
               var8 = 59;
               var10 = 5;
            }

            this.method388(var11, var12, var7, var8, var9, var10, var1[var6.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIILac;Lax;I)V",
      garbageValue = "1802789370"
   )
   void method387(int var1, int var2, int var3, int var4, class28 var5, class44 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field423[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = InvType.getUnderlayDefinition(var9);
               var6.method626(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIIILaz;Lax;I)V",
      garbageValue = "-1716106004"
   )
   void method388(int var1, int var2, int var3, int var4, int var5, int var6, class35 var7, class44 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method409(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = InvType.getUnderlayDefinition(var11);
               var8.method626(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IILac;Laf;I)I",
      garbageValue = "492944004"
   )
   int method404(int var1, int var2, class28 var3, class33 var4) {
      return var3.field423[0][var1][var2] == 0?this.field491:var4.method360(var1, var2);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IILac;[Llv;I)V",
      garbageValue = "783677662"
   )
   void method390(int var1, int var2, class28 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field410; ++var5) {
         class31[] var6 = var3.field417[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               int var11 = var9.field446;
               boolean var10 = var11 >= class247.field3004.field3005 && var11 <= class247.field3003.field3005;
               if(var10 || class22.method161(var9.field446)) {
                  ObjectComposition var12 = class169.getObjectDefinition(var9.field450);
                  if(var12.mapSceneId != -1) {
                     if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                        var4[var12.mapSceneId].method5894(this.field486 * var1, this.field486 * (63 - var2), this.field486 * 2, this.field486 * 2);
                     } else {
                        var4[var12.mapSceneId].method5894(this.field486 * var1, this.field486 * (63 - var2), this.field486 * 2 + 1, this.field486 * 2 + 1);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IILac;I)V",
      garbageValue = "1226902137"
   )
   void method391(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field410; ++var4) {
         class31[] var5 = var3.field417[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               int var10 = var8.field446;
               boolean var9 = var10 >= class247.field2986.field3005 && var10 <= class247.field2982.field3005 || var10 == class247.field3006.field3005;
               if(var9) {
                  ObjectComposition var11 = class169.getObjectDefinition(var8.field450);
                  int var12 = var11.int1 != 0?-3407872:-3355444;
                  if(var8.field446 == class247.field2986.field3005) {
                     this.method408(var1, var2, var8.field452, var12);
                  }

                  if(var8.field446 == class247.field2985.field3005) {
                     this.method408(var1, var2, var8.field452, -3355444);
                     this.method408(var1, var2, var8.field452 + 1, var12);
                  }

                  if(var8.field446 == class247.field2982.field3005) {
                     if(var8.field452 == 0) {
                        Rasterizer2D.method5814(this.field486 * var1, this.field486 * (63 - var2), 1, var12);
                     }

                     if(var8.field452 == 1) {
                        Rasterizer2D.method5814(this.field486 + this.field486 * var1 - 1, this.field486 * (63 - var2), 1, var12);
                     }

                     if(var8.field452 == 2) {
                        Rasterizer2D.method5814(this.field486 + this.field486 * var1 - 1, this.field486 * (63 - var2) + this.field486 - 1, 1, var12);
                     }

                     if(var8.field452 == 3) {
                        Rasterizer2D.method5814(this.field486 * var1, this.field486 * (63 - var2) + this.field486 - 1, 1, var12);
                     }
                  }

                  if(var8.field446 == class247.field3006.field3005) {
                     int var13 = var8.field452 % 2;
                     int var14;
                     if(var13 == 0) {
                        for(var14 = 0; var14 < this.field486; ++var14) {
                           Rasterizer2D.method5814(var14 + this.field486 * var1, (64 - var2) * this.field486 - 1 - var14, 1, var12);
                        }
                     } else {
                        for(var14 = 0; var14 < this.field486; ++var14) {
                           Rasterizer2D.method5814(var14 + this.field486 * var1, var14 + this.field486 * (63 - var2), 1, var12);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-1423448249"
   )
   @Export("drawNonLinkMapIcons")
   void drawNonLinkMapIcons(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field489.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var9.worldX * var5 + (float)var1 - var6);
         int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.worldY - var6);
         MapIcon var12 = (MapIcon)var8.getValue();
         if(var12 != null) {
            var12.field538 = var10;
            var12.field537 = var11;
            Area var13 = Area.mapAreaType[var12.areaId];
            if(!var3.contains(Integer.valueOf(var13.method4883()))) {
               this.method395(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-1888903915"
   )
   void method393(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field493.iterator();

      while(var4.hasNext()) {
         MapIcon var5 = (MapIcon)var4.next();
         Area var6 = Area.mapAreaType[var5.areaId];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4883()))) {
            this.method394(var6, var5.field538, var5.field537, var2, var3);
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Ljw;IIIII)V",
      garbageValue = "820766126"
   )
   void method394(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.getMapIcon(false);
      if(var6 != null) {
         var6.drawAt(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method5803(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method5803(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lao;IIFB)V",
      garbageValue = "46"
   )
   void method395(MapIcon var1, int var2, int var3, float var4) {
      Area var5 = Area.mapAreaType[var1.areaId];
      this.method389(var5, var2, var3);
      this.method397(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Ljw;III)V",
      garbageValue = "2016208758"
   )
   void method389(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.getMapIcon(false);
      if(var4 != null) {
         int var5 = this.method401(var4, var1.field3464);
         int var6 = this.method471(var4, var1.field3463);
         var4.drawAt(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lao;Ljw;IIFI)V",
      garbageValue = "-1369182837"
   )
   void method397(MapIcon var1, Area var2, int var3, int var4, float var5) {
      if(var1.field536 != null) {
         if(var1.field536.fontSize.method176(var5)) {
            Font var6 = (Font)this.mapFonts.get(var1.field536.fontSize);
            var6.method5627(var1.field536.text, var3 - var1.field536.field472 / 2, var4, var1.field536.field472, var1.field536.field473, -16777216 | var2.field3448, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;IB)V",
      garbageValue = "68"
   )
   @Export("drawMapLinks")
   void drawMapLinks(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field493.iterator();

      while(var6.hasNext()) {
         MapIcon var7 = (MapIcon)var6.next();
         int var8 = var7.field531.worldX % 64;
         int var9 = var7.field531.worldY % 64;
         var7.field538 = (int)((float)var1 + var5 * (float)var8);
         var7.field537 = (int)((float)var2 + var5 * (float)(63 - var9));
         if(!var3.contains(Integer.valueOf(var7.areaId))) {
            this.method395(var7, var7.field538, var7.field537, var5);
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-38"
   )
   void method399() {
      if(this.field498 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method400(var1, var2, this.field498);
            }
         }
      } else {
         Iterator var5 = this.field490.iterator();

         while(var5.hasNext()) {
            class46 var6 = (class46)var5.next();

            for(int var3 = var6.method650() * 8; var3 < var6.method650() * 8 + 8; ++var3) {
               for(int var4 = var6.method647() * 8; var4 < var6.method647() * 8 + 8; ++var4) {
                  this.method400(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IILac;I)V",
      garbageValue = "-2113299433"
   )
   void method400(int var1, int var2, class28 var3) {
      field496.set(0, var1, var2);

      for(int var4 = 0; var4 < var3.field410; ++var4) {
         class31[] var5 = var3.field417[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method464(var8.field450);
               if(var9 != null) {
                  MapIcon var10 = (MapIcon)this.field489.get(field496);
                  if(var10 != null) {
                     if(var10.areaId != var9.id) {
                        MapIcon var16 = new MapIcon(var9.id, var10.field532, var10.field531, this.method419(var9));
                        this.field489.put(new Coordinates(field496), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field532.plane - var10.field531.plane;
                     var10.field531.plane = var4;
                     var10.field532.plane = var15 + var4;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field494 * 64 + var1, this.field488 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field498 != null) {
                     var12 = new Coordinates(this.field498.field414 + var4, this.field498.field411 * 64 + var1, var2 + this.field498.field420 * 64);
                  } else {
                     Iterator var13 = this.field490.iterator();

                     while(var13.hasNext()) {
                        class46 var14 = (class46)var13.next();
                        if(var14.method642(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field414, var14.field411 * 64 + var1 + var14.method644() * 8, var14.field420 * 64 + var2 + var14.method645() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new MapIcon(var9.id, var12, var11, this.method419(var9));
                     this.field489.put(new Coordinates(field496), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field489.remove(field496);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lly;Ljz;B)I",
      garbageValue = "92"
   )
   int method401(SpritePixels var1, class284 var2) {
      switch(var2.field3698) {
      case 1:
         return -var1.width / 2;
      case 2:
         return 0;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lly;Ljh;B)I",
      garbageValue = "64"
   )
   int method471(SpritePixels var1, class266 var2) {
      switch(var2.field3436) {
      case 1:
         return -var1.height / 2;
      case 2:
         return 0;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(II)Ljw;",
      garbageValue = "-1934696739"
   )
   Area method464(int var1) {
      ObjectComposition var2 = class169.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.mapAreaType[var2.mapIconId]:null;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)Lai;",
      garbageValue = "-1835918510"
   )
   MapLabel method430(int var1) {
      Area var2 = Area.mapAreaType[var1];
      return this.method419(var2);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Ljw;I)Lai;",
      garbageValue = "2002032189"
   )
   MapLabel method419(Area var1) {
      if(var1.name != null && this.mapFonts != null && this.mapFonts.get(Size.field362) != null) {
         Size var2 = Size.method177(var1.field3456);
         if(var2 == null) {
            return null;
         } else {
            Font var3 = (Font)this.mapFonts.get(var2);
            if(var3 == null) {
               return null;
            } else {
               int var4 = var3.method5613(var1.name, 1000000);
               String[] var5 = new String[var4];
               var3.method5639(var1.name, (int[])null, var5);
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

               return new MapLabel(var1.name, var7, var6, var2);
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IIIIII)Ljava/util/List;",
      garbageValue = "725355394"
   )
   List method413(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field489.values().iterator();

            MapIcon var8;
            while(var7.hasNext()) {
               var8 = (MapIcon)var7.next();
               if(var8.method548(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field493.iterator();

            while(var7.hasNext()) {
               var8 = (MapIcon)var7.next();
               if(var8.method548(var4, var5)) {
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

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)Ljava/util/List;",
      garbageValue = "63"
   )
   List method407() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field493);
      var1.addAll(this.field489.values());
      return var1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "907225135"
   )
   void method408(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method5816(this.field486 * var1, this.field486 * (63 - var2), this.field486, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5814(this.field486 * var1, this.field486 * (63 - var2), this.field486, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5816(this.field486 + this.field486 * var1 - 1, this.field486 * (63 - var2), this.field486, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5814(this.field486 * var1, this.field486 * (63 - var2) + this.field486 - 1, this.field486, var4);
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1454886725"
   )
   int method409(int var1, int var2) {
      if(this.field498 != null) {
         return this.field498.method229(var1, var2);
      } else {
         if(!this.field490.isEmpty()) {
            Iterator var3 = this.field490.iterator();

            while(var3.hasNext()) {
               class46 var4 = (class46)var3.next();
               if(var4.method642(var1, var2)) {
                  return var4.method229(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1557212982"
   )
   @Export("getTileHeight")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class62.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class62.tileHeights[var5][var3][var4] + class62.tileHeights[var5][var3 + 1][var4] * var6 >> 7;
         int var9 = var6 * class62.tileHeights[var5][var3 + 1][var4 + 1] + class62.tileHeights[var5][var3][var4 + 1] * (128 - var6) >> 7;
         return var7 * var9 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }
}
