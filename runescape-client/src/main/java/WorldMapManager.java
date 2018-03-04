import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("WorldMapManager")
public final class WorldMapManager {
   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   static BuildType field563;
   @ObfuscatedName("d")
   @Export("loaded")
   boolean loaded;
   @ObfuscatedName("z")
   @Export("loading")
   boolean loading;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lah;"
   )
   class45 field550;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   SpritePixels field552;
   @ObfuscatedName("e")
   HashMap field553;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "[[Laz;"
   )
   class35[][] field554;
   @ObfuscatedName("k")
   HashMap field551;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   IndexedSprite[] field564;
   @ObfuscatedName("p")
   @Export("mapFonts")
   final HashMap mapFonts;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -494506813
   )
   int field562;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -975078359
   )
   int field559;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -390783979
   )
   int field555;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 636469935
   )
   int field561;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -295362291
   )
   public int field558;

   @ObfuscatedSignature(
      signature = "([Llv;Ljava/util/HashMap;)V"
   )
   public WorldMapManager(IndexedSprite[] var1, HashMap var2) {
      this.loaded = false;
      this.loading = false;
      this.field551 = new HashMap();
      this.field558 = 0;
      this.field564 = var1;
      this.mapFonts = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljk;Ljava/lang/String;ZI)V",
      garbageValue = "-862276462"
   )
   @Export("load")
   public void load(IndexDataBase var1, String var2, boolean var3) {
      if(!this.loading) {
         this.loaded = false;
         this.loading = true;
         System.nanoTime();
         int var4 = var1.getFile(class41.field546.field542);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.takeRecordByNames(class41.field546.field542, var2));
         Buffer var7 = new Buffer(var1.takeRecordByNames(class41.field541.field542, var2));
         Buffer var8 = new Buffer(var1.takeRecordByNames(var2, class41.field544.field542));
         System.nanoTime();
         System.nanoTime();
         this.field550 = new class45();

         try {
            this.field550.method632(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var20) {
            return;
         }

         this.field550.method304();
         this.field550.method305();
         this.field550.method306();
         this.field562 = this.field550.method312() * 64;
         this.field559 = this.field550.method302() * 64;
         this.field555 = (this.field550.method300() - this.field550.method312() + 1) * 64;
         this.field561 = (this.field550.method348() - this.field550.method302() + 1) * 64;
         int var17 = this.field550.method300() - this.field550.method312() + 1;
         int var10 = this.field550.method348() - this.field550.method302() + 1;
         System.nanoTime();
         System.nanoTime();
         class35.field485.method4049();
         class35.field484.method4049();
         this.field554 = new class35[var17][var10];
         Iterator var11 = this.field550.field574.iterator();

         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field411;
            int var14 = var12.field420;
            int var15 = var13 - this.field550.method312();
            int var16 = var14 - this.field550.method302();
            this.field554[var15][var16] = new class35(var13, var14, this.field550.method298(), this.mapFonts);
            this.field554[var15][var16].method372(var12, this.field550.field576);
         }

         for(int var18 = 0; var18 < var17; ++var18) {
            for(int var19 = 0; var19 < var10; ++var19) {
               if(this.field554[var18][var19] == null) {
                  this.field554[var18][var19] = new class35(this.field550.method312() + var18, this.field550.method302() + var19, this.field550.method298(), this.mapFonts);
                  this.field554[var18][var19].method373(this.field550.field575, this.field550.field576);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4689(class41.field548.field542, var2)) {
            byte[] var21 = var1.takeRecordByNames(class41.field548.field542, var2);
            this.field552 = KeyFocusListener.method774(var21);
         }

         System.nanoTime();
         var1.method4683();
         var1.reset();
         this.loaded = true;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-803443741"
   )
   public final void method598() {
      this.field553 = null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "35"
   )
   @Export("drawMapRegion")
   public final void drawMapRegion(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      class29 var13 = this.method588(var1, var2, var3, var4);
      float var14 = this.method568(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      this.field558 = var15;
      if(!this.field551.containsKey(Integer.valueOf(var15))) {
         class47 var16 = new class47(var15);
         var16.method671();
         this.field551.put(Integer.valueOf(var15), var16);
      }

      class35[] var22 = new class35[8];

      int var17;
      int var18;
      for(var17 = var13.field429; var17 < var13.field429 + var13.field432; ++var17) {
         for(var18 = var13.field426; var18 < var13.field427 + var13.field426; ++var18) {
            this.method567(var17, var18, var22);
            this.field554[var17][var18].method463(var15, (class47)this.field551.get(Integer.valueOf(var15)), var22, this.field564);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(var14 * 64.0F);
      var18 = this.field562 + var1;
      int var19 = var2 + this.field559;

      for(int var20 = var13.field429; var20 < var13.field429 + var13.field432; ++var20) {
         for(int var21 = var13.field426; var21 < var13.field426 + var13.field427; ++var21) {
            this.field554[var20][var21].method371(var5 + var17 * (this.field554[var20][var21].field494 * 64 - var18) / 64, var8 - var17 * (this.field554[var20][var21].field488 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "-2085339928"
   )
   @Export("drawMapIcons")
   public final void drawMapIcons(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method588(var1, var2, var3, var4);
      float var15 = this.method568(var7 - var5, var3 - var1);
      int var16 = (int)(var15 * 64.0F);
      int var17 = this.field562 + var1;
      int var18 = var2 + this.field559;

      int var19;
      int var20;
      for(var19 = var14.field429; var19 < var14.field429 + var14.field432; ++var19) {
         for(var20 = var14.field426; var20 < var14.field426 + var14.field427; ++var20) {
            if(var13) {
               this.field554[var19][var20].method399();
            }

            this.field554[var19][var20].method377(var5 + var16 * (this.field554[var19][var20].field494 * 64 - var17) / 64, var8 - var16 * (this.field554[var19][var20].field488 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field429; var19 < var14.field432 + var14.field429; ++var19) {
            for(var20 = var14.field426; var20 < var14.field426 + var14.field427; ++var20) {
               this.field554[var19][var20].drawFlashingMapIcons(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II[Laz;I)V",
      garbageValue = "425304368"
   )
   void method567(int var1, int var2, class35[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field554.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field554[0].length - 1;
      if(var7) {
         var3[class254.field3324.rsOrdinal()] = null;
      } else {
         var3[class254.field3324.rsOrdinal()] = this.field554[var1][var2 + 1];
      }

      var3[class254.field3315.rsOrdinal()] = !var7 && !var5?this.field554[var1 + 1][var2 + 1]:null;
      var3[class254.field3321.rsOrdinal()] = !var7 && !var4?this.field554[var1 - 1][var2 + 1]:null;
      var3[class254.field3316.rsOrdinal()] = var5?null:this.field554[var1 + 1][var2];
      var3[class254.field3320.rsOrdinal()] = var4?null:this.field554[var1 - 1][var2];
      var3[class254.field3318.rsOrdinal()] = var6?null:this.field554[var1][var2 - 1];
      var3[class254.field3317.rsOrdinal()] = !var6 && !var5?this.field554[var1 + 1][var2 - 1]:null;
      var3[class254.field3319.rsOrdinal()] = !var6 && !var4?this.field554[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "1351597011"
   )
   public void method586(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field552 != null) {
         this.field552.method5989(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field553 == null) {
               this.method574();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field553.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  MapIcon var12 = (MapIcon)var11.next();
                  int var13 = var3 * (var12.field531.worldX - this.field562) / this.field555;
                  int var14 = var4 - (var12.field531.worldY - this.field559) * var4 / this.field561;
                  Rasterizer2D.method5803(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIII)Ljava/util/List;",
      garbageValue = "215864529"
   )
   public List method569(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.loaded) {
         return var11;
      } else {
         class29 var12 = this.method588(var1, var2, var3, var4);
         float var13 = this.method568(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = this.field562 + var1;
         int var16 = var2 + this.field559;

         for(int var17 = var12.field429; var17 < var12.field432 + var12.field429; ++var17) {
            for(int var18 = var12.field426; var18 < var12.field426 + var12.field427; ++var18) {
               List var19 = this.field554[var17][var18].method413(var5 + var14 * (this.field554[var17][var18].field494 * 64 - var15) / 64, var8 + var6 - var14 * (this.field554[var17][var18].field488 * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIB)Law;",
      garbageValue = "8"
   )
   class29 method588(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field562 + var1;
      int var7 = var2 + this.field559;
      int var8 = var3 + this.field562;
      int var9 = var4 + this.field559;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field432 = var12 - var10 + 1;
      var5.field427 = var13 - var11 + 1;
      var5.field429 = var10 - this.field550.method312();
      var5.field426 = var11 - this.field550.method302();
      if(var5.field429 < 0) {
         var5.field432 += var5.field429;
         var5.field429 = 0;
      }

      if(var5.field429 > this.field554.length - var5.field432) {
         var5.field432 = this.field554.length - var5.field429;
      }

      if(var5.field426 < 0) {
         var5.field427 += var5.field426;
         var5.field426 = 0;
      }

      if(var5.field426 > this.field554[0].length - var5.field427) {
         var5.field427 = this.field554[0].length - var5.field426;
      }

      var5.field432 = Math.min(var5.field432, this.field554.length);
      var5.field427 = Math.min(var5.field427, this.field554[0].length);
      return var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-78861031"
   )
   public boolean method571() {
      return this.loaded;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "830982687"
   )
   public HashMap method572() {
      this.method574();
      return this.field553;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-108"
   )
   void method574() {
      if(this.field553 == null) {
         this.field553 = new HashMap();
      }

      this.field553.clear();

      for(int var1 = 0; var1 < this.field554.length; ++var1) {
         for(int var2 = 0; var2 < this.field554[var1].length; ++var2) {
            List var3 = this.field554[var1][var2].method407();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               MapIcon var5 = (MapIcon)var4.next();
               if(!this.field553.containsKey(Integer.valueOf(var5.areaId))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field553.put(Integer.valueOf(var5.areaId), var6);
               } else {
                  List var7 = (List)this.field553.get(Integer.valueOf(var5.areaId));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "1256703910"
   )
   float method568(int var1, int var2) {
      float var3 = (float)var1 / (float)var2;
      if(var3 > 8.0F) {
         return 8.0F;
      } else if(var3 < 1.0F) {
         return 1.0F;
      } else {
         int var4 = Math.round(var3);
         return Math.abs((float)var4 - var3) < 0.05F?(float)var4:var3;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIIII[Lfb;I)V",
      garbageValue = "-405333973"
   )
   static final void method601(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
                  var5[var6].flags[var7 + var1][var8 + var2] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               class171.loadTerrain(var10, var7, var8 + var1, var9 + var2, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(Liw;I)Z",
      garbageValue = "-2051976893"
   )
   static final boolean method562(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = ItemContainer.method1078(var0, var1);
            int var3 = var0.field2939[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }
}
