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

@ObfuscatedName("aj")
public class class34 {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   static final Coordinates field466;
   @ObfuscatedName("i")
   static int[] field459;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = -1310412347
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1122806645
   )
   int field471;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -567955897
   )
   int field452;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   class22 field457;
   @ObfuscatedName("b")
   LinkedList field458;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 27750919
   )
   int field453;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1439279793
   )
   int field460;
   @ObfuscatedName("r")
   int[][] field461;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   SpritePixels field462;
   @ObfuscatedName("u")
   List field455;
   @ObfuscatedName("n")
   HashMap field469;
   @ObfuscatedName("c")
   final HashMap field465;

   static {
      field466 = new Coordinates();
   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field471 = var1;
      this.field452 = var2;
      this.field458 = new LinkedList();
      this.field455 = new LinkedList();
      this.field469 = new HashMap();
      this.field453 = var3 | -16777216;
      this.field465 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-80"
   )
   void method368(int var1, int var2, int var3) {
      if(this.field462 != null) {
         if(var3 == this.field460 * 64) {
            this.field462.method5266(var1, var2);
         } else {
            this.field462.method5283(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lo;Ljava/util/List;I)V",
      garbageValue = "1725093442"
   )
   void method363(class22 var1, List var2) {
      this.field469.clear();
      this.field457 = var1;
      this.method436(0, 0, 64, 64, this.field457);
      this.method366(var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
      garbageValue = "2097925232"
   )
   void method437(HashSet var1, List var2) {
      this.field469.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method224() == this.field471 && var4.method225() == this.field452) {
            this.field458.add(var4);
            this.method436(var4.method644() * 8, var4.method641() * 8, 8, 8, var4);
         }
      }

      this.method366(var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIILaa;B)V",
      garbageValue = "-21"
   )
   void method436(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label54:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field383; ++var9) {
               class31[] var10 = var5.field388[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method423(var13.field420);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field471 * 64 + var6, this.field452 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field457 != null) {
                           var16 = new Coordinates(this.field457.field389 + var9, var6 + this.field457.field391 * 64, var7 + this.field457.field379 * 64);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var9 + var17.field389, var17.field391 * 64 + var6 + var17.method642() * 8, var7 + var17.field379 * 64 + var17.method643() * 8);
                        }

                        class39 var18 = new class39(var14.field3366, var16, var15, this.method396(var14));
                        this.field469.put(var8, var18);
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
      garbageValue = "886456359"
   )
   void method366(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field349.worldX >> 6 == this.field471 && var3.field349.worldY >> 6 == this.field452) {
            class39 var4 = new class39(var3.field351, var3.field349, var3.field349, this.method395(var3.field351));
            this.field455.add(var4);
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILaf;[Laj;[Lkl;B)Z",
      garbageValue = "51"
   )
   boolean method367(int var1, class46 var2, class34[] var3, IndexedSprite[] var4) {
      if(!this.method370(var1)) {
         return false;
      } else if(this.field457 == null && this.field458.isEmpty()) {
         return false;
      } else {
         this.method376(var3);
         this.field462.method5285();
         if(this.field457 != null) {
            this.method448(var2, var3, var4);
         } else {
            this.method372(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "777857009"
   )
   void method472(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method384(var1, var2, var4, var3);
      this.method389(var1, var2, var4, var3);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "280776421"
   )
   void method369(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field469.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field513))) {
            Area var6 = Area.mapAreaType[var5.field513];
            this.method449(var6, var5.field509, var5.field512, var2, var3);
         }
      }

      this.method385(var1, var2, var3);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1165366744"
   )
   boolean method370(int var1) {
      if(this.field462 != null && this.field460 == var1) {
         return false;
      } else {
         this.field460 = var1;
         this.field462 = new SpritePixels(this.field460 * 64, this.field460 * 64);
         return true;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Laf;[Laj;[Lkl;I)V",
      garbageValue = "-1495482801"
   )
   void method448(class46 var1, class34[] var2, IndexedSprite[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method374(var4, var5, this.field457, var1);
            this.method375(var4, var5, this.field457, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method373(var4, var5, this.field457, var1, var3);
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Laf;[Lkl;I)V",
      garbageValue = "786893567"
   )
   void method372(class46 var1, IndexedSprite[] var2) {
      Iterator var3 = this.field458.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method644() * 8; var5 < var4.method644() * 8 + 8; ++var5) {
            for(var6 = var4.method641() * 8; var6 < var4.method641() * 8 + 8; ++var6) {
               this.method374(var5, var6, var4, var1);
               this.method375(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field458.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method644() * 8; var5 < var4.method644() * 8 + 8; ++var5) {
            for(var6 = var4.method641() * 8; var6 < var4.method641() * 8 + 8; ++var6) {
               this.method373(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IILaa;Laf;[Lkl;I)V",
      garbageValue = "16777215"
   )
   void method373(int var1, int var2, class28 var3, class46 var4, IndexedSprite[] var5) {
      this.method364(var1, var2, var3);
      this.method382(var1, var2, var3, var5);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IILaa;Laf;I)V",
      garbageValue = "657353480"
   )
   void method374(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field384[0][var1][var2] - 1;
      int var6 = var3.field386[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field460 * var1, this.field460 * (63 - var2), this.field460, this.field460, this.field453);
      }

      int var7 = 16711935;
      if(var6 != -1) {
         var7 = Size.method182(var6, this.field453);
      }

      if(var6 > -1 && var3.field378[0][var1][var2] == 0) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field460 * var1, this.field460 * (63 - var2), this.field460, this.field460, var7);
      } else {
         int var8 = this.method381(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.Rasterizer2D_fillRectangle(this.field460 * var1, this.field460 * (63 - var2), this.field460, this.field460, var8);
         } else {
            var4.method667(this.field460 * var1, this.field460 * (63 - var2), var8, var7, this.field460, this.field460, var3.field378[0][var1][var2], var3.field387[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IILaa;Laf;I)V",
      garbageValue = "-1957819824"
   )
   void method375(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field383; ++var5) {
         int var6 = var3.field386[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = Size.method182(var6, this.field453);
            if(var3.field378[var5][var1][var2] == 0) {
               Rasterizer2D.Rasterizer2D_fillRectangle(this.field460 * var1, this.field460 * (63 - var2), this.field460, this.field460, var7);
            } else {
               var4.method667(this.field460 * var1, this.field460 * (63 - var2), 0, var7, this.field460, this.field460, var3.field378[var5][var1][var2], var3.field387[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([Laj;I)Z",
      garbageValue = "-1984989090"
   )
   boolean method376(class34[] var1) {
      if(this.field461 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field457 != null) {
            this.method379(0, 0, 64, 64, this.field457, var2);
         } else {
            Iterator var3 = this.field458.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method379(var4.method644() * 8, var4.method641() * 8, 8, 8, var4, var2);
            }
         }

         this.method452(var1, var2);
         this.method496(var2);
         return true;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lay;I)V",
      garbageValue = "271572994"
   )
   void method496(class43 var1) {
      this.field461 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field461[var2][var3] = var1.method623(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([Laj;Lay;B)V",
      garbageValue = "70"
   )
   void method452(class34[] var1, class43 var2) {
      class235[] var3 = Player.method1175();
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
            switch(var6.field3237) {
            case 0:
               var8 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
               break;
            case 1:
               var12 = 59;
               var10 = 5;
               break;
            case 2:
               var7 = 59;
               var9 = 5;
               break;
            case 3:
               var8 = 59;
               var10 = 5;
               break;
            case 4:
               var8 = 59;
               var10 = 5;
               var11 = 59;
               var9 = 5;
               break;
            case 5:
               var11 = 59;
               var9 = 5;
               break;
            case 6:
               var12 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
               break;
            case 7:
               var11 = 59;
               var12 = 59;
               var9 = 5;
               var10 = 5;
            }

            this.method380(var11, var12, var7, var8, var9, var10, var1[var6.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIILaa;Lay;I)V",
      garbageValue = "1361613267"
   )
   void method379(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field384[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = ScriptState.getUnderlayDefinition(var9);
               var6.method622(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIIILaj;Lay;I)V",
      garbageValue = "919030443"
   )
   void method380(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method400(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = ScriptState.getUnderlayDefinition(var11);
               var8.method622(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IILaa;B)I",
      garbageValue = "-45"
   )
   int method381(int var1, int var2, class28 var3) {
      return var3.field384[0][var1][var2] == 0?this.field453:this.field461[var1][var2];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILaa;[Lkl;B)V",
      garbageValue = "91"
   )
   void method382(int var1, int var2, class28 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field383; ++var5) {
         class31[] var6 = var3.field388[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               if(!SoundTask.method2178(var9.field426)) {
                  int var11 = var9.field426;
                  boolean var10 = var11 == class228.field2907.field2908;
                  if(!var10) {
                     continue;
                  }
               }

               ObjectComposition var12 = class3.getObjectDefinition(var9.field420);
               if(var12.mapSceneId != -1) {
                  if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                     var4[var12.mapSceneId].method5241(this.field460 * var1, this.field460 * (63 - var2), this.field460 * 2, this.field460 * 2);
                  } else {
                     var4[var12.mapSceneId].method5241(this.field460 * var1, this.field460 * (63 - var2), this.field460 * 2 + 1, this.field460 * 2 + 1);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IILaa;B)V",
      garbageValue = "-55"
   )
   void method364(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field383; ++var4) {
         class31[] var5 = var3.field388[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               if(class111.method2196(var8.field426)) {
                  ObjectComposition var9 = class3.getObjectDefinition(var8.field420);
                  int var10 = var9.int1 != 0?-3407872:-3355444;
                  if(var8.field426 == class228.field2892.field2908) {
                     this.method430(var1, var2, var8.field418, var10);
                  }

                  if(var8.field426 == class228.field2887.field2908) {
                     this.method430(var1, var2, var8.field418, -3355444);
                     this.method430(var1, var2, var8.field418 + 1, var10);
                  }

                  if(var8.field426 == class228.field2888.field2908) {
                     if(var8.field418 == 0) {
                        Rasterizer2D.method5148(this.field460 * var1, this.field460 * (63 - var2), 1, var10);
                     }

                     if(var8.field418 == 1) {
                        Rasterizer2D.method5148(this.field460 + this.field460 * var1 - 1, this.field460 * (63 - var2), 1, var10);
                     }

                     if(var8.field418 == 2) {
                        Rasterizer2D.method5148(this.field460 + this.field460 * var1 - 1, this.field460 * (63 - var2) + this.field460 - 1, 1, var10);
                     }

                     if(var8.field418 == 3) {
                        Rasterizer2D.method5148(this.field460 * var1, this.field460 * (63 - var2) + this.field460 - 1, 1, var10);
                     }
                  }

                  if(var8.field426 == class228.field2889.field2908) {
                     int var11 = var8.field418 % 2;
                     int var12;
                     if(var11 == 0) {
                        for(var12 = 0; var12 < this.field460; ++var12) {
                           Rasterizer2D.method5148(var12 + this.field460 * var1, (64 - var2) * this.field460 - 1 - var12, 1, var10);
                        }
                     } else {
                        for(var12 = 0; var12 < this.field460; ++var12) {
                           Rasterizer2D.method5148(var12 + this.field460 * var1, var12 + this.field460 * (63 - var2), 1, var10);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-1939698017"
   )
   void method384(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field469.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var1 + var5 * (float)var9.worldX - var6);
         int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.worldY - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field509 = var10;
            var12.field512 = var11;
            Area var13 = Area.mapAreaType[var12.field513];
            if(!var3.contains(Integer.valueOf(var13.method4448()))) {
               this.method386(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "1857614222"
   )
   void method385(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field455.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         Area var6 = Area.mapAreaType[var5.field513];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4448()))) {
            this.method449(var6, var5.field509, var5.field512, var2, var3);
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Liz;IIIII)V",
      garbageValue = "-222680606"
   )
   void method449(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.getMapIcon(false);
      if(var6 != null) {
         var6.drawAt(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method5136(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method5136(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lap;IIFB)V",
      garbageValue = "71"
   )
   void method386(class39 var1, int var2, int var3, float var4) {
      Area var5 = Area.mapAreaType[var1.field513];
      this.method387(var5, var2, var3);
      this.method388(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Liz;IIB)V",
      garbageValue = "49"
   )
   void method387(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.getMapIcon(false);
      if(var4 != null) {
         int var5 = this.method392(var4, var1.field3380);
         int var6 = this.method444(var4, var1.field3379);
         var4.drawAt(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lap;Liz;IIFI)V",
      garbageValue = "-779255321"
   )
   void method388(class39 var1, Area var2, int var3, int var4, float var5) {
      if(var1.field510 != null) {
         if(var1.field510.field443.method184(var5)) {
            Font var6 = (Font)this.field465.get(var1.field510.field443);
            var6.method4935(var1.field510.field442, var3 - var1.field510.field441 / 2, var4, var1.field510.field441, var1.field510.field445, -16777216 | var2.field3370, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-1106522968"
   )
   void method389(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field455.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field506.worldX % 64;
         int var9 = var7.field506.worldY % 64;
         var7.field509 = (int)(var5 * (float)var8 + (float)var1);
         var7.field512 = (int)((float)var2 + (float)(63 - var9) * var5);
         if(!var3.contains(Integer.valueOf(var7.field513))) {
            this.method386(var7, var7.field509, var7.field512, var5);
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1869257995"
   )
   void method390() {
      if(this.field457 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method501(var1, var2, this.field457);
            }
         }
      } else {
         Iterator var5 = this.field458.iterator();

         while(var5.hasNext()) {
            class45 var6 = (class45)var5.next();

            for(int var3 = var6.method644() * 8; var3 < var6.method644() * 8 + 8; ++var3) {
               for(int var4 = var6.method641() * 8; var4 < var6.method641() * 8 + 8; ++var4) {
                  this.method501(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IILaa;B)V",
      garbageValue = "97"
   )
   void method501(int var1, int var2, class28 var3) {
      field466.set(0, var1, var2);

      for(int var4 = 0; var4 < var3.field383; ++var4) {
         class31[] var5 = var3.field388[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method423(var8.field420);
               if(var9 != null) {
                  class39 var10 = (class39)this.field469.get(field466);
                  if(var10 != null) {
                     if(var9.field3366 != var10.field513) {
                        class39 var16 = new class39(var9.field3366, var10.field507, var10.field506, this.method396(var9));
                        this.field469.put(new Coordinates(field466), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field507.plane - var10.field506.plane;
                     var10.field506.plane = var4;
                     var10.field507.plane = var15 + var4;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field471 * 64 + var1, this.field452 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field457 != null) {
                     var12 = new Coordinates(this.field457.field389 + var4, this.field457.field391 * 64 + var1, var2 + this.field457.field379 * 64);
                  } else {
                     Iterator var13 = this.field458.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method639(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field389, var1 + var14.field391 * 64 + var14.method642() * 8, var14.field379 * 64 + var2 + var14.method643() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3366, var12, var11, this.method396(var9));
                     this.field469.put(new Coordinates(field466), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field469.remove(field466);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lky;Ljn;I)I",
      garbageValue = "1451750027"
   )
   int method392(SpritePixels var1, class264 var2) {
      switch(var2.field3609) {
      case 0:
         return -var1.width / 2;
      case 1:
         return 0;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lky;Lih;I)I",
      garbageValue = "-2107292503"
   )
   int method444(SpritePixels var1, class246 var2) {
      switch(var2.field3345) {
      case 0:
         return 0;
      case 1:
         return -var1.height / 2;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)Liz;",
      garbageValue = "-2051132736"
   )
   Area method423(int var1) {
      ObjectComposition var2 = class3.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.mapAreaType[var2.mapIconId]:null;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IB)Lae;",
      garbageValue = "16"
   )
   class33 method395(int var1) {
      Area var2 = Area.mapAreaType[var1];
      return this.method396(var2);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Liz;I)Lae;",
      garbageValue = "248424233"
   )
   class33 method396(Area var1) {
      if(var1.name != null && this.field465 != null && this.field465.get(Size.field343) != null) {
         int var3 = var1.field3371;
         Size[] var4 = new Size[]{Size.field343, Size.field342, Size.field341};
         Size[] var5 = var4;
         int var6 = 0;

         Size var2;
         while(true) {
            if(var6 >= var5.length) {
               var2 = null;
               break;
            }

            Size var7 = var5[var6];
            if(var3 == var7.field345) {
               var2 = var7;
               break;
            }

            ++var6;
         }

         if(var2 == null) {
            return null;
         } else {
            Font var14 = (Font)this.field465.get(var2);
            if(var14 == null) {
               return null;
            } else {
               var6 = var14.method4929(var1.name, 1000000);
               String[] var15 = new String[var6];
               var14.method4997(var1.name, (int[])null, var15);
               int var8 = var15.length * var14.verticalSpace / 2;
               int var9 = 0;
               String[] var10 = var15;

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  String var12 = var10[var11];
                  int var13 = var14.method4925(var12);
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

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IIIIIB)Ljava/util/List;",
      garbageValue = "43"
   )
   List method397(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field469.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method553(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field455.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method553(var4, var5)) {
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

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/List;",
      garbageValue = "1801803684"
   )
   List method398() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field455);
      var1.addAll(this.field469.values());
      return var1;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1981412976"
   )
   void method430(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method5146(this.field460 * var1, this.field460 * (63 - var2), this.field460, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5148(this.field460 * var1, this.field460 * (63 - var2), this.field460, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5146(this.field460 * var1 + this.field460 - 1, this.field460 * (63 - var2), this.field460, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5148(this.field460 * var1, this.field460 * (63 - var2) + this.field460 - 1, this.field460, var4);
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2066258611"
   )
   int method400(int var1, int var2) {
      if(this.field457 != null) {
         return this.field457.method234(var1, var2);
      } else {
         if(!this.field458.isEmpty()) {
            Iterator var3 = this.field458.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method639(var1, var2)) {
                  return var4.method234(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2118164745"
   )
   static void method500() {
      class61.field735 = 99;
      class61.field724 = new byte[4][104][104];
      class61.field736 = new byte[4][104][104];
      class36.field481 = new byte[4][104][104];
      class61.field726 = new byte[4][104][104];
      BoundingBox3D.field242 = new int[4][105][105];
      ScriptState.field745 = new byte[4][105][105];
      class61.field727 = new int[105][105];
      TotalQuantityComparator.field287 = new int[104];
      class43.field545 = new int[104];
      GrandExchangeOffer.field300 = new int[104];
      Permission.field3260 = new int[104];
      Frames.field2044 = new int[104];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lgv;IB)Z",
      garbageValue = "-23"
   )
   @Export("decodeRegionHash")
   static boolean decodeRegionHash(PacketBuffer var0, int var1) {
      int var2 = var0.getBits(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.getBits(1) != 0) {
            decodeRegionHash(var0, var1);
         }

         var3 = var0.getBits(13);
         var4 = var0.getBits(13);
         boolean var12 = var0.getBits(1) == 1;
         if(var12) {
            class94.field1420[++class94.field1419 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field857 = var1;
            if(class94.field1407[var1] != null) {
               var6.decodeApperance(class94.field1407[var1]);
            }

            var6.orientation = class94.Players_orientations[var1];
            var6.interacting = class94.Players_targetIndices[var1];
            var7 = class94.Players_regions[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.pathTraversed[0] = class94.field1410[var1];
            var6.field853 = (byte)var8;
            var6.method1156((var9 << 13) + var3 - IndexDataBase.baseX, (var10 << 13) + var4 - Occluder.baseY);
            var6.field836 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class94.Players_regions[var1];
         class94.Players_regions[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class94.Players_regions[var1];
            var7 = (var11 >> 28) + var4 & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class94.Players_regions[var1] = (var8 << 14) + var9 + (var7 << 28);
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class94.Players_regions[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var11 + var7 & 255;
            class94.Players_regions[var1] = (var9 << 14) + var10 + (var8 << 28);
            return false;
         }
      }
   }
}
