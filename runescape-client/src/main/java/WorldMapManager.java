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

@ObfuscatedName("al")
@Implements("WorldMapManager")
public final class WorldMapManager {
   @ObfuscatedName("m")
   @Export("isLoaded0")
   boolean isLoaded0;
   @ObfuscatedName("f")
   @Export("loadStarted")
   boolean loadStarted;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   @Export("mapAreaData")
   WorldMapAreaData mapAreaData;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   @Export("overviewSprite")
   Sprite overviewSprite;
   @ObfuscatedName("o")
   @Export("icons")
   HashMap icons;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[[Lav;"
   )
   @Export("regions")
   WorldMapRegion[][] regions;
   @ObfuscatedName("g")
   @Export("__g")
   HashMap __g;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   @Export("mapSceneSprites")
   IndexedSprite[] mapSceneSprites;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__e")
   final AbstractIndexCache __e;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__x")
   final AbstractIndexCache __x;
   @ObfuscatedName("d")
   @Export("fonts")
   final HashMap fonts;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1459928419
   )
   @Export("surfaceOffsetX")
   int surfaceOffsetX;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1364441271
   )
   @Export("surfaceOffsetY")
   int surfaceOffsetY;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1729323633
   )
   @Export("__i")
   int __i;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -395718741
   )
   @Export("__a")
   int __a;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1085359673
   )
   @Export("__z")
   public int __z;

   @ObfuscatedSignature(
      signature = "([Llq;Ljava/util/HashMap;Lir;Lir;)V"
   )
   public WorldMapManager(IndexedSprite[] var1, HashMap var2, AbstractIndexCache var3, AbstractIndexCache var4) {
      this.isLoaded0 = false;
      this.loadStarted = false;
      this.__g = new HashMap();
      this.__z = 0;
      this.mapSceneSprites = var1;
      this.fonts = var2;
      this.__e = var3;
      this.__x = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;Ljava/lang/String;ZB)V",
      garbageValue = "32"
   )
   @Export("load")
   public void load(AbstractIndexCache var1, String var2, boolean var3) {
      if(!this.loadStarted) {
         this.isLoaded0 = false;
         this.loadStarted = true;
         System.nanoTime();
         int var4 = var1.getArchiveId(WorldMapCacheName.WorldMapCacheName_details.name);
         int var5 = var1.getRecordId(var4, var2);
         Buffer var6 = new Buffer(var1.takeRecordByNames(WorldMapCacheName.WorldMapCacheName_details.name, var2));
         Buffer var7 = new Buffer(var1.takeRecordByNames(WorldMapCacheName.WorldMapCacheName_compositeMap.name, var2));
         System.nanoTime();
         System.nanoTime();
         this.mapAreaData = new WorldMapAreaData();

         try {
            this.mapAreaData.__ce_76(var6, var7, var5, var3);
         } catch (IllegalStateException var16) {
            return;
         }

         this.mapAreaData.originX();
         this.mapAreaData.originPlane();
         this.mapAreaData.originY();
         this.surfaceOffsetX = this.mapAreaData.minX() * 64;
         this.surfaceOffsetY = this.mapAreaData.minY() * 64;
         this.__i = (this.mapAreaData.maxX() - this.mapAreaData.minX() + 1) * 64;
         this.__a = (this.mapAreaData.maxY() - this.mapAreaData.minY() + 1) * 64;
         int var8 = this.mapAreaData.maxX() - this.mapAreaData.minX() + 1;
         int var9 = this.mapAreaData.maxY() - this.mapAreaData.minY() + 1;
         System.nanoTime();
         System.nanoTime();
         SoundSystem.method2456();
         this.regions = new WorldMapRegion[var8][var9];
         Iterator var10 = this.mapAreaData.surfaceOffsetY.iterator();

         int var12;
         while(var10.hasNext()) {
            class15 var11 = (class15)var10.next();
            var12 = var11.field149;
            int var13 = var11.field146;
            int var14 = var12 - this.mapAreaData.minX();
            int var15 = var13 - this.mapAreaData.minY();
            this.regions[var14][var15] = new WorldMapRegion(var12, var13, this.mapAreaData.__a_39(), this.fonts);
            this.regions[var14][var15].method447(var11, this.mapAreaData.__a);
         }

         for(int var17 = 0; var17 < var8; ++var17) {
            for(var12 = 0; var12 < var9; ++var12) {
               if(this.regions[var17][var12] == null) {
                  this.regions[var17][var12] = new WorldMapRegion(this.mapAreaData.minX() + var17, this.mapAreaData.minY() + var12, this.mapAreaData.__a_39(), this.fonts);
                  this.regions[var17][var12].__u_41(this.mapAreaData.__i, this.mapAreaData.__a);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.__ag_401(WorldMapCacheName.WorldMapCacheName_compositeTexture.name, var2)) {
            byte[] var18 = var1.takeRecordByNames(WorldMapCacheName.WorldMapCacheName_compositeTexture.name, var2);
            this.overviewSprite = class27.method438(var18);
         }

         System.nanoTime();
         var1.__y_398();
         var1.__b_400();
         this.isLoaded0 = true;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "20"
   )
   @Export("clearIcons")
   public final void clearIcons() {
      this.icons = null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1619301748"
   )
   @Export("__q_72")
   public final void __q_72(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.Rasterizer2D_pixels;
      int var10 = Rasterizer2D.Rasterizer2D_width;
      int var11 = Rasterizer2D.Rasterizer2D_height;
      int[] var12 = new int[4];
      Rasterizer2D.Rasterizer2D_getClipArray(var12);
      class22 var13 = this.method643(var1, var2, var3, var4);
      float var14 = this.getPixelsPerTile(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      this.__z = var15;
      if(!this.__g.containsKey(Integer.valueOf(var15))) {
         class40 var16 = new class40(var15);
         var16.method763();
         this.__g.put(Integer.valueOf(var15), var16);
      }

      int var23 = var13.field166 + var13.field169 - 1;
      int var17 = var13.field167 + var13.field164 - 1;

      int var18;
      int var19;
      for(var18 = var13.field166; var18 <= var23; ++var18) {
         for(var19 = var13.field167; var19 <= var17; ++var19) {
            this.regions[var18][var19].method455(var15, (class40)this.__g.get(Integer.valueOf(var15)), this.mapSceneSprites, this.__e, this.__x);
         }
      }

      Rasterizer2D.Rasterizer2D_replace(var9, var10, var11);
      Rasterizer2D.Rasterizer2D_setClipArray(var12);
      var18 = (int)(64.0F * var14);
      var19 = this.surfaceOffsetX + var1;
      int var20 = var2 + this.surfaceOffsetY;

      for(int var21 = var13.field166; var21 < var13.field166 + var13.field169; ++var21) {
         for(int var22 = var13.field167; var22 < var13.field167 + var13.field164; ++var22) {
            this.regions[var21][var22].__w_40(var5 + var18 * (this.regions[var21][var22].x * 64 - var19) / 64, var8 - var18 * (this.regions[var21][var22].y * 64 - var20 + 64) / 64, var18);
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZB)V",
      garbageValue = "-71"
   )
   @Export("__w_73")
   public final void __w_73(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class22 var14 = this.method643(var1, var2, var3, var4);
      float var15 = this.getPixelsPerTile(var7 - var5, var3 - var1);
      int var16 = (int)(var15 * 64.0F);
      int var17 = this.surfaceOffsetX + var1;
      int var18 = var2 + this.surfaceOffsetY;

      int var19;
      int var20;
      for(var19 = var14.field166; var19 < var14.field169 + var14.field166; ++var19) {
         for(var20 = var14.field167; var20 < var14.field164 + var14.field167; ++var20) {
            if(var13) {
               this.regions[var19][var20].__e_42();
            }

            this.regions[var19][var20].__j_46(var5 + var16 * (this.regions[var19][var20].x * 64 - var17) / 64, var8 - var16 * (this.regions[var19][var20].y * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field166; var19 < var14.field169 + var14.field166; ++var19) {
            for(var20 = var14.field167; var20 < var14.field167 + var14.field164; ++var20) {
               this.regions[var19][var20].__s_47(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "-2144548575"
   )
   @Export("drawOverview")
   public void drawOverview(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.overviewSprite != null) {
         this.overviewSprite.__j_506(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.icons == null) {
               this.buildIcons0();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var9;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var10 = ((Integer)var8.next()).intValue();
                  var9 = (List)this.icons.get(Integer.valueOf(var10));
               } while(var9 == null);

               Iterator var14 = var9.iterator();

               while(var14.hasNext()) {
                  AbstractWorldMapIcon var11 = (AbstractWorldMapIcon)var14.next();
                  int var12 = var3 * (var11.coord2.x - this.surfaceOffsetX) / this.__i;
                  int var13 = var4 - (var11.coord2.y - this.surfaceOffsetY) * var4 / this.__a;
                  Rasterizer2D.Rasterizer2D_drawCircleAlpha(var12 + var1, var13 + var2, 2, 16776960, 256);
               }
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIII)Ljava/util/List;",
      garbageValue = "1185703832"
   )
   @Export("__u_74")
   public List __u_74(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.isLoaded0) {
         return var11;
      } else {
         class22 var12 = this.method643(var1, var2, var3, var4);
         float var13 = this.getPixelsPerTile(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = this.surfaceOffsetX + var1;
         int var16 = var2 + this.surfaceOffsetY;

         for(int var17 = var12.field166; var17 < var12.field166 + var12.field169; ++var17) {
            for(int var18 = var12.field167; var18 < var12.field164 + var12.field167; ++var18) {
               List var19 = this.regions[var17][var18].__ae_57(var5 + var14 * (this.regions[var17][var18].x * 64 - var15) / 64, var8 + var6 - var14 * (this.regions[var17][var18].y * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIII)Lc;",
      garbageValue = "-1455088394"
   )
   class22 method643(int var1, int var2, int var3, int var4) {
      class22 var5 = new class22(this);
      int var6 = this.surfaceOffsetX + var1;
      int var7 = var2 + this.surfaceOffsetY;
      int var8 = var3 + this.surfaceOffsetX;
      int var9 = var4 + this.surfaceOffsetY;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field169 = var12 - var10 + 1;
      var5.field164 = var13 - var11 + 1;
      var5.field166 = var10 - this.mapAreaData.minX();
      var5.field167 = var11 - this.mapAreaData.minY();
      if(var5.field166 < 0) {
         var5.field169 += var5.field166;
         var5.field166 = 0;
      }

      if(var5.field166 > this.regions.length - var5.field169) {
         var5.field169 = this.regions.length - var5.field166;
      }

      if(var5.field167 < 0) {
         var5.field164 += var5.field167;
         var5.field167 = 0;
      }

      if(var5.field167 > this.regions[0].length - var5.field164) {
         var5.field164 = this.regions[0].length - var5.field167;
      }

      var5.field169 = Math.min(var5.field169, this.regions.length);
      var5.field164 = Math.min(var5.field164, this.regions[0].length);
      return var5;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "483037662"
   )
   @Export("isLoaded")
   public boolean isLoaded() {
      return this.isLoaded0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "464090770"
   )
   @Export("buildIcons")
   public HashMap buildIcons() {
      this.buildIcons0();
      return this.icons;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   @Export("buildIcons0")
   void buildIcons0() {
      if(this.icons == null) {
         this.icons = new HashMap();
      }

      this.icons.clear();

      for(int var1 = 0; var1 < this.regions.length; ++var1) {
         for(int var2 = 0; var2 < this.regions[var1].length; ++var2) {
            List var3 = this.regions[var1][var2].icons();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
               if(var5.__h_67()) {
                  int var6 = var5.__m_15();
                  if(!this.icons.containsKey(Integer.valueOf(var6))) {
                     LinkedList var7 = new LinkedList();
                     var7.add(var5);
                     this.icons.put(Integer.valueOf(var6), var7);
                  } else {
                     List var8 = (List)this.icons.get(Integer.valueOf(var6));
                     var8.add(var5);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "1249403507"
   )
   @Export("getPixelsPerTile")
   float getPixelsPerTile(int var1, int var2) {
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "514181856"
   )
   @Export("itemContainerSetItem")
   static void itemContainerSetItem(int var0, int var1, int var2, int var3) {
      ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new ItemContainer();
         ItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.ids.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.ids.length; ++var7) {
            var5[var7] = var4.ids[var7];
            var6[var7] = var4.quantities[var7];
         }

         for(var7 = var4.ids.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.ids = var5;
         var4.quantities = var6;
      }

      var4.ids[var1] = var2;
      var4.quantities[var1] = var3;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1743251873"
   )
   public static void method673() {
      ObjectDefinition.ObjectDefinition_cached.clear();
      ObjectDefinition.__jr_o.clear();
      ObjectDefinition.__jr_u.clear();
      ObjectDefinition.ObjectDefinition_cachedModels.clear();
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1344882321"
   )
   static boolean method672(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   @ObfuscatedName("ks")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1341489301"
   )
   static final void method668() {
      Client.__client_na = Client.cycleCntr;
   }
}
