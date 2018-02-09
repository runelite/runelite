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
   @ObfuscatedName("le")
   @ObfuscatedSignature(
      signature = "Lcm;"
   )
   @Export("chatMessages")
   static Varcs chatMessages;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   static final Coordinates field465;
   @ObfuscatedName("el")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   static Task field454;
   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   @Export("scrollbarSprites")
   static IndexedSprite[] scrollbarSprites;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 983464247
   )
   int field462;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1598821899
   )
   int field468;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   class22 field451;
   @ObfuscatedName("t")
   LinkedList field457;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1655922811
   )
   int field458;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -202705491
   )
   int field459;
   @ObfuscatedName("k")
   int[][] field460;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   SpritePixels field461;
   @ObfuscatedName("o")
   List field455;
   @ObfuscatedName("l")
   HashMap field456;
   @ObfuscatedName("f")
   final HashMap field463;

   static {
      field465 = new Coordinates();
   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field462 = var1;
      this.field468 = var2;
      this.field457 = new LinkedList();
      this.field455 = new LinkedList();
      this.field456 = new HashMap();
      this.field458 = var3 | -16777216;
      this.field463 = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "26"
   )
   void method394(int var1, int var2, int var3) {
      if(this.field461 != null) {
         if(var3 == this.field459 * 64) {
            this.field461.method5682(var1, var2);
         } else {
            this.field461.method5699(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lj;Ljava/util/List;I)V",
      garbageValue = "1884838681"
   )
   void method344(class22 var1, List var2) {
      this.field456.clear();
      this.field451 = var1;
      this.method346(0, 0, 64, 64, this.field451);
      this.method371(var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
      garbageValue = "1128643630"
   )
   void method345(HashSet var1, List var2) {
      this.field456.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method218() == this.field462 && var4.method219() == this.field468) {
            this.field457.add(var4);
            this.method346(var4.method610() * 8, var4.method615() * 8, 8, 8, var4);
         }
      }

      this.method371(var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIILaq;I)V",
      garbageValue = "-2147131009"
   )
   void method346(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label57:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field393; ++var9) {
               class31[] var10 = var5.field392[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method375(var13.field419);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field462 * 64 + var6, this.field468 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field451 != null) {
                           var16 = new Coordinates(this.field451.field391 + var9, var6 + this.field451.field398 * 64, var7 + this.field451.field389 * 64);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var9 + var17.field391, var6 + var17.field398 * 64 + var17.method630() * 8, var7 + var17.field389 * 64 + var17.method633() * 8);
                        }

                        class39 var18 = new class39(var14.field3379, var16, var15, this.method377(var14));
                        this.field456.put(var8, var18);
                        continue label57;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;I)V",
      garbageValue = "1922445455"
   )
   void method371(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field353.worldX >> 6 == this.field462 && var3.field353.worldY >> 6 == this.field468) {
            class39 var4 = new class39(var3.field355, var3.field353, var3.field353, this.method376(var3.field355));
            this.field455.add(var4);
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILap;[Lak;[Lkh;I)Z",
      garbageValue = "-1449296919"
   )
   boolean method418(int var1, class46 var2, class34[] var3, IndexedSprite[] var4) {
      if(!this.method351(var1)) {
         return false;
      } else if(this.field451 == null && this.field457.isEmpty()) {
         return false;
      } else {
         this.method411(var3);
         this.field461.method5677();
         if(this.field451 != null) {
            this.method356(var2, var3, var4);
         } else {
            this.method353(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "-1806066434"
   )
   void method343(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method364(var1, var2, var4, var3);
      this.method370(var1, var2, var4, var3);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-1516923876"
   )
   void method437(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field456.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field514))) {
            Area var6 = Area.mapAreaType[var5.field514];
            this.method366(var6, var5.field506, var5.field507, var2, var3);
         }
      }

      this.method445(var1, var2, var3);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "52"
   )
   boolean method351(int var1) {
      if(this.field461 != null && this.field459 == var1) {
         return false;
      } else {
         this.field459 = var1;
         this.field461 = new SpritePixels(this.field459 * 64, this.field459 * 64);
         return true;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lap;[Lak;[Lkh;S)V",
      garbageValue = "25293"
   )
   void method356(class46 var1, class34[] var2, IndexedSprite[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method438(var4, var5, this.field451, var1);
            this.method372(var4, var5, this.field451, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method350(var4, var5, this.field451, var1, var3);
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lap;[Lkh;I)V",
      garbageValue = "-2124219784"
   )
   void method353(class46 var1, IndexedSprite[] var2) {
      Iterator var3 = this.field457.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method610() * 8; var5 < var4.method610() * 8 + 8; ++var5) {
            for(var6 = var4.method615() * 8; var6 < var4.method615() * 8 + 8; ++var6) {
               this.method438(var5, var6, var4, var1);
               this.method372(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field457.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method610() * 8; var5 < var4.method610() * 8 + 8; ++var5) {
            for(var6 = var4.method615() * 8; var6 < var4.method615() * 8 + 8; ++var6) {
               this.method350(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILaq;Lap;[Lkh;I)V",
      garbageValue = "724298817"
   )
   void method350(int var1, int var2, class28 var3, class46 var4, IndexedSprite[] var5) {
      this.method363(var1, var2, var3);
      this.method469(var1, var2, var3, var5);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IILaq;Lap;B)V",
      garbageValue = "77"
   )
   void method438(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field388[0][var1][var2] - 1;
      int var6 = var3.field395[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field459 * var1, this.field459 * (63 - var2), this.field459, this.field459, this.field458);
      }

      int var7 = 16711935;
      if(var6 != -1) {
         var7 = class2.method3(var6, this.field458);
      }

      if(var6 > -1 && var3.field396[0][var1][var2] == 0) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field459 * var1, this.field459 * (63 - var2), this.field459, this.field459, var7);
      } else {
         int var8 = this.method361(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.Rasterizer2D_fillRectangle(this.field459 * var1, this.field459 * (63 - var2), this.field459, this.field459, var8);
         } else {
            var4.method636(this.field459 * var1, this.field459 * (63 - var2), var8, var7, this.field459, this.field459, var3.field396[0][var1][var2], var3.field397[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IILaq;Lap;I)V",
      garbageValue = "2141449160"
   )
   void method372(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field393; ++var5) {
         int var6 = var3.field395[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = class2.method3(var6, this.field458);
            if(var3.field396[var5][var1][var2] == 0) {
               Rasterizer2D.Rasterizer2D_fillRectangle(this.field459 * var1, this.field459 * (63 - var2), this.field459, this.field459, var7);
            } else {
               var4.method636(this.field459 * var1, this.field459 * (63 - var2), 0, var7, this.field459, this.field459, var3.field396[var5][var1][var2], var3.field397[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([Lak;I)Z",
      garbageValue = "-1550837629"
   )
   boolean method411(class34[] var1) {
      if(this.field460 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field451 != null) {
            this.method373(0, 0, 64, 64, this.field451, var2);
         } else {
            Iterator var3 = this.field457.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method373(var4.method610() * 8, var4.method615() * 8, 8, 8, var4, var2);
            }
         }

         this.method358(var1, var2);
         this.method357(var2);
         return true;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lao;I)V",
      garbageValue = "-844544974"
   )
   void method357(class43 var1) {
      this.field460 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field460[var2][var3] = var1.method594(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([Lak;Lao;I)V",
      garbageValue = "559969913"
   )
   void method358(class34[] var1, class43 var2) {
      class239[] var3 = NetWriter.method2042();
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
            switch(var6.field3252) {
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
               var8 = 59;
               var10 = 5;
               break;
            case 3:
               var11 = 59;
               var9 = 5;
               break;
            case 4:
               var7 = 59;
               var9 = 5;
               break;
            case 5:
               var12 = 59;
               var10 = 5;
               break;
            case 6:
               var12 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
               break;
            case 7:
               var8 = 59;
               var10 = 5;
               var11 = 59;
               var9 = 5;
            }

            this.method347(var11, var12, var7, var8, var9, var10, var1[var6.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIILaq;Lao;I)V",
      garbageValue = "-871757547"
   )
   void method373(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field388[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = OwnWorldComparator.getUnderlayDefinition(var9);
               var6.method593(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIIILak;Lao;S)V",
      garbageValue = "15317"
   )
   void method347(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method381(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = OwnWorldComparator.getUnderlayDefinition(var11);
               var8.method593(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IILaq;I)I",
      garbageValue = "1978494762"
   )
   int method361(int var1, int var2, class28 var3) {
      return var3.field388[0][var1][var2] == 0?this.field458:this.field460[var1][var2];
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IILaq;[Lkh;I)V",
      garbageValue = "1063767705"
   )
   void method469(int var1, int var2, class28 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field393; ++var5) {
         class31[] var6 = var3.field392[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               if(!class70.method1116(var9.field423)) {
                  int var11 = var9.field423;
                  boolean var10 = var11 == class232.field2922.field2938;
                  if(!var10) {
                     continue;
                  }
               }

               ObjectComposition var12 = class219.getObjectDefinition(var9.field419);
               if(var12.mapSceneId != -1) {
                  if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                     var4[var12.mapSceneId].method5655(this.field459 * var1, this.field459 * (63 - var2), this.field459 * 2, this.field459 * 2);
                  } else {
                     var4[var12.mapSceneId].method5655(this.field459 * var1, this.field459 * (63 - var2), this.field459 * 2 + 1, this.field459 * 2 + 1);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IILaq;I)V",
      garbageValue = "-125935731"
   )
   void method363(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field393; ++var4) {
         class31[] var5 = var3.field392[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               if(class43.method598(var8.field423)) {
                  ObjectComposition var9 = class219.getObjectDefinition(var8.field419);
                  int var10 = var9.int1 != 0?-3407872:-3355444;
                  if(var8.field423 == class232.field2937.field2938) {
                     this.method380(var1, var2, var8.field421, var10);
                  }

                  if(var8.field423 == class232.field2930.field2938) {
                     this.method380(var1, var2, var8.field421, -3355444);
                     this.method380(var1, var2, var8.field421 + 1, var10);
                  }

                  if(var8.field423 == class232.field2918.field2938) {
                     if(var8.field421 == 0) {
                        Rasterizer2D.method5573(this.field459 * var1, this.field459 * (63 - var2), 1, var10);
                     }

                     if(var8.field421 == 1) {
                        Rasterizer2D.method5573(this.field459 + this.field459 * var1 - 1, this.field459 * (63 - var2), 1, var10);
                     }

                     if(var8.field421 == 2) {
                        Rasterizer2D.method5573(this.field459 * var1 + this.field459 - 1, this.field459 * (63 - var2) + this.field459 - 1, 1, var10);
                     }

                     if(var8.field421 == 3) {
                        Rasterizer2D.method5573(this.field459 * var1, this.field459 * (63 - var2) + this.field459 - 1, 1, var10);
                     }
                  }

                  if(var8.field423 == class232.field2919.field2938) {
                     int var11 = var8.field421 % 2;
                     int var12;
                     if(var11 == 0) {
                        for(var12 = 0; var12 < this.field459; ++var12) {
                           Rasterizer2D.method5573(var12 + this.field459 * var1, (64 - var2) * this.field459 - 1 - var12, 1, var10);
                        }
                     } else {
                        for(var12 = 0; var12 < this.field459; ++var12) {
                           Rasterizer2D.method5573(var12 + this.field459 * var1, var12 + this.field459 * (63 - var2), 1, var10);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "606404488"
   )
   void method364(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field456.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var1 + (float)var9.worldX * var5 - var6);
         int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.worldY - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field506 = var10;
            var12.field507 = var11;
            Area var13 = Area.mapAreaType[var12.field514];
            if(!var3.contains(Integer.valueOf(var13.method4685()))) {
               this.method367(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "237248809"
   )
   void method445(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field455.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         Area var6 = Area.mapAreaType[var5.field514];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4685()))) {
            this.method366(var6, var5.field506, var5.field507, var2, var3);
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lip;IIIII)V",
      garbageValue = "1726456370"
   )
   void method366(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.getMapIcon(false);
      if(var6 != null) {
         var6.drawAt(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method5562(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method5562(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lah;IIFI)V",
      garbageValue = "-870896008"
   )
   void method367(class39 var1, int var2, int var3, float var4) {
      Area var5 = Area.mapAreaType[var1.field514];
      this.method368(var5, var2, var3);
      this.method369(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lip;IIB)V",
      garbageValue = "48"
   )
   void method368(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.getMapIcon(false);
      if(var4 != null) {
         int var5 = this.method457(var4, var1.field3384);
         int var6 = this.method374(var4, var1.field3375);
         var4.drawAt(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lah;Lip;IIFI)V",
      garbageValue = "-1957103251"
   )
   void method369(class39 var1, Area var2, int var3, int var4, float var5) {
      if(var1.field511 != null) {
         if(var1.field511.field444.method176(var5)) {
            Font var6 = (Font)this.field463.get(var1.field511.field444);
            var6.method5376(var1.field511.field447, var3 - var1.field511.field442 / 2, var4, var1.field511.field442, var1.field511.field443, -16777216 | var2.field3383, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-122343516"
   )
   void method370(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field455.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field509.worldX % 64;
         int var9 = var7.field509.worldY % 64;
         var7.field506 = (int)((float)var1 + (float)var8 * var5);
         var7.field507 = (int)(var5 * (float)(63 - var9) + (float)var2);
         if(!var3.contains(Integer.valueOf(var7.field514))) {
            this.method367(var7, var7.field506, var7.field507, var5);
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2125841285"
   )
   void method365() {
      if(this.field451 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method423(var1, var2, this.field451);
            }
         }
      } else {
         Iterator var5 = this.field457.iterator();

         while(var5.hasNext()) {
            class45 var6 = (class45)var5.next();

            for(int var3 = var6.method610() * 8; var3 < var6.method610() * 8 + 8; ++var3) {
               for(int var4 = var6.method615() * 8; var4 < var6.method615() * 8 + 8; ++var4) {
                  this.method423(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IILaq;I)V",
      garbageValue = "2122090139"
   )
   void method423(int var1, int var2, class28 var3) {
      field465.set(0, var1, var2);

      for(int var4 = 0; var4 < var3.field393; ++var4) {
         class31[] var5 = var3.field392[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method375(var8.field419);
               if(var9 != null) {
                  class39 var10 = (class39)this.field456.get(field465);
                  if(var10 != null) {
                     if(var9.field3379 != var10.field514) {
                        class39 var16 = new class39(var9.field3379, var10.field504, var10.field509, this.method377(var9));
                        this.field456.put(new Coordinates(field465), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field504.plane - var10.field509.plane;
                     var10.field509.plane = var4;
                     var10.field504.plane = var4 + var15;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field462 * 64 + var1, this.field468 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field451 != null) {
                     var12 = new Coordinates(this.field451.field391 + var4, this.field451.field398 * 64 + var1, var2 + this.field451.field389 * 64);
                  } else {
                     Iterator var13 = this.field457.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method611(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field391, var14.field398 * 64 + var1 + var14.method630() * 8, var14.field389 * 64 + var2 + var14.method633() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3379, var12, var11, this.method377(var9));
                     this.field456.put(new Coordinates(field465), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field456.remove(field465);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lki;Ljo;I)I",
      garbageValue = "-1982564247"
   )
   int method457(SpritePixels var1, class268 var2) {
      switch(var2.field3621) {
      case 0:
         return -var1.width / 2;
      case 2:
         return 0;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lki;Lif;S)I",
      garbageValue = "13362"
   )
   int method374(SpritePixels var1, class250 var2) {
      switch(var2.field3362) {
      case 0:
         return -var1.height / 2;
      case 1:
         return 0;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)Lip;",
      garbageValue = "468089927"
   )
   Area method375(int var1) {
      ObjectComposition var2 = class219.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.mapAreaType[var2.mapIconId]:null;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)Lax;",
      garbageValue = "1506600920"
   )
   class33 method376(int var1) {
      Area var2 = Area.mapAreaType[var1];
      return this.method377(var2);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Lip;B)Lax;",
      garbageValue = "-40"
   )
   class33 method377(Area var1) {
      if(var1.name != null && this.field463 != null && this.field463.get(Size.field345) != null) {
         Size var2 = Size.method177(var1.field3378);
         if(var2 == null) {
            return null;
         } else {
            Font var3 = (Font)this.field463.get(var2);
            if(var3 == null) {
               return null;
            } else {
               int var4 = var3.method5370(var1.name, 1000000);
               String[] var5 = new String[var4];
               var3.method5368(var1.name, (int[])null, var5);
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

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IIIIII)Ljava/util/List;",
      garbageValue = "903728292"
   )
   List method378(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field456.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method519(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field455.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method519(var4, var5)) {
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

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)Ljava/util/List;",
      garbageValue = "17"
   )
   List method379() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field455);
      var1.addAll(this.field456.values());
      return var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1089445432"
   )
   void method380(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method5575(this.field459 * var1, this.field459 * (63 - var2), this.field459, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5573(this.field459 * var1, this.field459 * (63 - var2), this.field459, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5575(this.field459 + this.field459 * var1 - 1, this.field459 * (63 - var2), this.field459, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5573(this.field459 * var1, this.field459 * (63 - var2) + this.field459 - 1, this.field459, var4);
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "1"
   )
   int method381(int var1, int var2) {
      if(this.field451 != null) {
         return this.field451.method217(var1, var2);
      } else {
         if(!this.field457.isEmpty()) {
            Iterator var3 = this.field457.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method611(var1, var2)) {
                  return var4.method217(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "8"
   )
   static final void method483(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class62.tileHeights[var0][var3 + var1][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class62.tileHeights[var0][var1][var3 + var2] = class62.tileHeights[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class62.tileHeights[var0][var3 + var1][var2] = class62.tileHeights[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class62.tileHeights[var0][var1 - 1][var2] != 0) {
         class62.tileHeights[var0][var1][var2] = class62.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class62.tileHeights[var0][var1][var2 - 1] != 0) {
         class62.tileHeights[var0][var1][var2] = class62.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class62.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class62.tileHeights[var0][var1][var2] = class62.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILcf;ZI)I",
      garbageValue = "1328309278"
   )
   static int method482(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.intStack[++class80.intStackSize - 1] = Client.grandExchangeOffers[var3].type();
         return 1;
      } else if(var0 == 3904) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.intStack[++class80.intStackSize - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.intStack[++class80.intStackSize - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.intStack[++class80.intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.intStack[++class80.intStackSize - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.intStack[++class80.intStackSize - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = class80.intStack[--class80.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class80.intStack[++class80.intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class80.intStack[--class80.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class80.intStack[++class80.intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class80.intStack[--class80.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class80.intStack[++class80.intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class80.intStack[--class80.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class80.intStack[++class80.intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = class80.intStack[--class80.intStackSize] == 1;
               if(VertexNormal.grandExchangeEvents != null) {
                  VertexNormal.grandExchangeEvents.sort(GrandExchangeEvents.field272, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = class80.intStack[--class80.intStackSize] == 1;
               if(VertexNormal.grandExchangeEvents != null) {
                  VertexNormal.grandExchangeEvents.sort(GrandExchangeEvents.field271, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               class80.intStackSize -= 2;
               var13 = class80.intStack[class80.intStackSize] == 1;
               boolean var4 = class80.intStack[class80.intStackSize + 1] == 1;
               if(VertexNormal.grandExchangeEvents != null) {
                  Client.field1074.field835 = var4;
                  VertexNormal.grandExchangeEvents.sort(Client.field1074, var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = class80.intStack[--class80.intStackSize] == 1;
               if(VertexNormal.grandExchangeEvents != null) {
                  VertexNormal.grandExchangeEvents.sort(GrandExchangeEvents.field270, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = class80.intStack[--class80.intStackSize] == 1;
               if(VertexNormal.grandExchangeEvents != null) {
                  VertexNormal.grandExchangeEvents.sort(GrandExchangeEvents.field273, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               class80.intStack[++class80.intStackSize - 1] = VertexNormal.grandExchangeEvents == null?0:VertexNormal.grandExchangeEvents.events.size();
               return 1;
            } else {
               GrandExchangeEvent var11;
               if(var0 == 3920) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)VertexNormal.grandExchangeEvents.events.get(var3);
                  class80.intStack[++class80.intStackSize - 1] = var11.world;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)VertexNormal.grandExchangeEvents.events.get(var3);
                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var11.method79();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)VertexNormal.grandExchangeEvents.events.get(var3);
                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var11.method86();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)VertexNormal.grandExchangeEvents.events.get(var3);
                  long var5 = SceneTilePaint.currentTimeMs() - WidgetNode.field766 - var11.field277;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * 60000)) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)VertexNormal.grandExchangeEvents.events.get(var3);
                  class80.intStack[++class80.intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)VertexNormal.grandExchangeEvents.events.get(var3);
                  class80.intStack[++class80.intStackSize - 1] = var11.grandExchangeOffer.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)VertexNormal.grandExchangeEvents.events.get(var3);
                  class80.intStack[++class80.intStackSize - 1] = var11.grandExchangeOffer.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }
}
