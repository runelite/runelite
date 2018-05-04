import java.awt.Component;
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

@ObfuscatedName("ah")
@Implements("WorldMapManager")
public final class WorldMapManager {
   @ObfuscatedName("ag")
   static int[] field559;
   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   @Export("compass")
   static SpritePixels compass;
   @ObfuscatedName("g")
   @Export("loaded")
   boolean loaded;
   @ObfuscatedName("e")
   @Export("loading")
   boolean loading;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   class45 field546;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   SpritePixels field558;
   @ObfuscatedName("n")
   HashMap field548;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[[Lak;"
   )
   @Export("mapRegions")
   WorldMapRegion[][] mapRegions;
   @ObfuscatedName("s")
   HashMap field550;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "[Llh;"
   )
   IndexedSprite[] field545;
   @ObfuscatedName("c")
   @Export("mapFonts")
   final HashMap mapFonts;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 623990259
   )
   @Export("mapSurfaceBaseOffsetX")
   int mapSurfaceBaseOffsetX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1324620167
   )
   @Export("mapSurfaceBaseOffsetY")
   int mapSurfaceBaseOffsetY;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2023618093
   )
   int field556;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1286908039
   )
   int field553;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1002952257
   )
   public int field557;

   @ObfuscatedSignature(
      signature = "([Llh;Ljava/util/HashMap;)V"
   )
   public WorldMapManager(IndexedSprite[] var1, HashMap var2) {
      this.loaded = false;
      this.loading = false;
      this.field550 = new HashMap();
      this.field557 = 0;
      this.field545 = var1;
      this.mapFonts = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljava/lang/String;ZI)V",
      garbageValue = "-1876480128"
   )
   @Export("load")
   public void load(IndexDataBase var1, String var2, boolean var3) {
      if(!this.loading) {
         this.loaded = false;
         this.loading = true;
         System.nanoTime();
         int var4 = var1.getFile(MapCacheArchiveNames.DETAILS.name);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.takeRecordByNames(MapCacheArchiveNames.DETAILS.name, var2));
         Buffer var7 = new Buffer(var1.takeRecordByNames(MapCacheArchiveNames.COMPOSITE_MAP.name, var2));
         Buffer var8 = new Buffer(var1.takeRecordByNames(var2, MapCacheArchiveNames.AREA.name));
         System.nanoTime();
         System.nanoTime();
         this.field546 = new class45();

         try {
            this.field546.method677(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var20) {
            return;
         }

         this.field546.method297();
         this.field546.method298();
         this.field546.method299();
         this.mapSurfaceBaseOffsetX = this.field546.getMinX() * 64;
         this.mapSurfaceBaseOffsetY = this.field546.getMinY() * 64;
         this.field556 = (this.field546.method294() - this.field546.getMinX() + 1) * 64;
         this.field553 = (this.field546.method296() - this.field546.getMinY() + 1) * 64;
         int var17 = this.field546.method294() - this.field546.getMinX() + 1;
         int var10 = this.field546.method296() - this.field546.getMinY() + 1;
         System.nanoTime();
         System.nanoTime();
         WorldMapRegion.field472.method4030();
         WorldMapRegion.field473.method4030();
         this.mapRegions = new WorldMapRegion[var17][var10];
         Iterator var11 = this.field546.field571.iterator();

         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field405;
            int var14 = var12.field399;
            int var15 = var13 - this.field546.getMinX();
            int var16 = var14 - this.field546.getMinY();
            this.mapRegions[var15][var16] = new WorldMapRegion(var13, var14, this.field546.method316(), this.mapFonts);
            this.mapRegions[var15][var16].method458(var12, this.field546.field569);
         }

         for(int var18 = 0; var18 < var17; ++var18) {
            for(int var19 = 0; var19 < var10; ++var19) {
               if(this.mapRegions[var18][var19] == null) {
                  this.mapRegions[var18][var19] = new WorldMapRegion(this.field546.getMinX() + var18, this.field546.getMinY() + var19, this.field546.method316(), this.mapFonts);
                  this.mapRegions[var18][var19].method379(this.field546.field570, this.field546.field569);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4663(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, var2)) {
            byte[] var21 = var1.takeRecordByNames(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, var2);
            this.field558 = class265.method4809(var21);
         }

         System.nanoTime();
         var1.method4657();
         var1.reset();
         this.loaded = true;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1908032782"
   )
   public final void method603() {
      this.field548 = null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-486046884"
   )
   @Export("drawMapRegion")
   public final void drawMapRegion(int var1, int var2, int var3, int var4, int x1, int y1, int x2, int y2) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      WorldMapRectangle var13 = this.getRegionRectForViewport(var1, var2, var3, var4);
      float var14 = this.method602(x2 - x1, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      this.field557 = var15;
      if(!this.field550.containsKey(Integer.valueOf(var15))) {
         class47 var16 = new class47(var15);
         var16.method718();
         this.field550.put(Integer.valueOf(var15), var16);
      }

      WorldMapRegion[] var22 = new WorldMapRegion[8];

      int var17;
      int var18;
      for(var17 = var13.worldMapRegionX; var17 < var13.worldMapRegionWidth + var13.worldMapRegionX; ++var17) {
         for(var18 = var13.worldMapRegionY; var18 < var13.worldMapRegionHeight + var13.worldMapRegionY; ++var18) {
            this.method625(var17, var18, var22);
            this.mapRegions[var17][var18].method382(var15, (class47)this.field550.get(Integer.valueOf(var15)), var22, this.field545);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(64.0F * var14);
      var18 = this.mapSurfaceBaseOffsetX + var1;
      int var19 = this.mapSurfaceBaseOffsetY + var2;

      for(int var20 = var13.worldMapRegionX; var20 < var13.worldMapRegionWidth + var13.worldMapRegionX; ++var20) {
         for(int var21 = var13.worldMapRegionY; var21 < var13.worldMapRegionY + var13.worldMapRegionHeight; ++var21) {
            this.mapRegions[var20][var21].method377(x1 + var17 * (this.mapRegions[var20][var21].field481 * 64 - var18) / 64, y2 - var17 * (this.mapRegions[var20][var21].field488 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "-1997582972"
   )
   @Export("drawMapIcons")
   public final void drawMapIcons(int x1, int y1, int x2, int y2, int graphicsX1, int var6, int graphicsX2, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      WorldMapRectangle worldMapRectangle = this.getRegionRectForViewport(x1, y1, x2, y2);
      float var15 = this.method602(graphicsX2 - graphicsX1, x2 - x1);
      int var16 = (int)(64.0F * var15);
      int xCoordinate = x1 + this.mapSurfaceBaseOffsetX;
      int yCoordinate = y1 + this.mapSurfaceBaseOffsetY;

      int var19;
      int var20;
      for(var19 = worldMapRectangle.worldMapRegionX; var19 < worldMapRectangle.worldMapRegionWidth + worldMapRectangle.worldMapRegionX; ++var19) {
         for(var20 = worldMapRectangle.worldMapRegionY; var20 < worldMapRectangle.worldMapRegionHeight + worldMapRectangle.worldMapRegionY; ++var20) {
            if(var13) {
               this.mapRegions[var19][var20].method405();
            }

            this.mapRegions[var19][var20].method499(graphicsX1 + var16 * (this.mapRegions[var19][var20].field481 * 64 - xCoordinate) / 64, var8 - var16 * (this.mapRegions[var19][var20].field488 * 64 - yCoordinate + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = worldMapRectangle.worldMapRegionX; var19 < worldMapRectangle.worldMapRegionWidth + worldMapRectangle.worldMapRegionX; ++var19) {
            for(var20 = worldMapRectangle.worldMapRegionY; var20 < worldMapRectangle.worldMapRegionHeight + worldMapRectangle.worldMapRegionY; ++var20) {
               this.mapRegions[var19][var20].drawFlashingMapIcons(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II[Lak;I)V",
      garbageValue = "-673510366"
   )
   void method625(int var1, int var2, WorldMapRegion[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.mapRegions.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.mapRegions[0].length - 1;
      if(var7) {
         var3[class254.field3321.rsOrdinal()] = null;
      } else {
         var3[class254.field3321.rsOrdinal()] = this.mapRegions[var1][var2 + 1];
      }

      var3[class254.field3315.rsOrdinal()] = !var7 && !var5?this.mapRegions[var1 + 1][var2 + 1]:null;
      var3[class254.field3318.rsOrdinal()] = !var7 && !var4?this.mapRegions[var1 - 1][var2 + 1]:null;
      var3[class254.field3317.rsOrdinal()] = var5?null:this.mapRegions[var1 + 1][var2];
      var3[class254.field3316.rsOrdinal()] = var4?null:this.mapRegions[var1 - 1][var2];
      var3[class254.field3320.rsOrdinal()] = var6?null:this.mapRegions[var1][var2 - 1];
      var3[class254.field3322.rsOrdinal()] = !var6 && !var5?this.mapRegions[var1 + 1][var2 - 1]:null;
      var3[class254.field3319.rsOrdinal()] = !var6 && !var4?this.mapRegions[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;IIB)V",
      garbageValue = "-7"
   )
   public void method607(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field558 != null) {
         this.field558.method5987(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field548 == null) {
               this.method606();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field548.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  MapIcon var12 = (MapIcon)var11.next();
                  int var13 = var3 * (var12.field522.worldX - this.mapSurfaceBaseOffsetX) / this.field556;
                  int var14 = var4 - (var12.field522.worldY - this.mapSurfaceBaseOffsetY) * var4 / this.field553;
                  Rasterizer2D.method5802(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIIB)Ljava/util/List;",
      garbageValue = "-79"
   )
   public List method601(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.loaded) {
         return var11;
      } else {
         WorldMapRectangle var12 = this.getRegionRectForViewport(var1, var2, var3, var4);
         float var13 = this.method602(var7, var3 - var1);
         int var14 = (int)(64.0F * var13);
         int var15 = this.mapSurfaceBaseOffsetX + var1;
         int var16 = var2 + this.mapSurfaceBaseOffsetY;

         for(int var17 = var12.worldMapRegionX; var17 < var12.worldMapRegionWidth + var12.worldMapRegionX; ++var17) {
            for(int var18 = var12.worldMapRegionY; var18 < var12.worldMapRegionY + var12.worldMapRegionHeight; ++var18) {
               List var19 = this.mapRegions[var17][var18].method449(var5 + var14 * (this.mapRegions[var17][var18].field481 * 64 - var15) / 64, var8 + var6 - var14 * (this.mapRegions[var17][var18].field488 * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIB)Lac;",
      garbageValue = "30"
   )
   @Export("getRegionRectForViewport")
   WorldMapRectangle getRegionRectForViewport(int x1, int y1, int x2, int y2) {
      WorldMapRectangle var5 = new WorldMapRectangle(this);
      int var6 = x1 + this.mapSurfaceBaseOffsetX;
      int var7 = y1 + this.mapSurfaceBaseOffsetY;
      int var8 = x2 + this.mapSurfaceBaseOffsetX;
      int var9 = y2 + this.mapSurfaceBaseOffsetY;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.worldMapRegionWidth = var12 - var10 + 1;
      var5.worldMapRegionHeight = var13 - var11 + 1;
      var5.worldMapRegionX = var10 - this.field546.getMinX();
      var5.worldMapRegionY = var11 - this.field546.getMinY();
      if(var5.worldMapRegionX < 0) {
         var5.worldMapRegionWidth += var5.worldMapRegionX;
         var5.worldMapRegionX = 0;
      }

      if(var5.worldMapRegionX > this.mapRegions.length - var5.worldMapRegionWidth) {
         var5.worldMapRegionWidth = this.mapRegions.length - var5.worldMapRegionX;
      }

      if(var5.worldMapRegionY < 0) {
         var5.worldMapRegionHeight += var5.worldMapRegionY;
         var5.worldMapRegionY = 0;
      }

      if(var5.worldMapRegionY > this.mapRegions[0].length - var5.worldMapRegionHeight) {
         var5.worldMapRegionHeight = this.mapRegions[0].length - var5.worldMapRegionY;
      }

      var5.worldMapRegionWidth = Math.min(var5.worldMapRegionWidth, this.mapRegions.length);
      var5.worldMapRegionHeight = Math.min(var5.worldMapRegionHeight, this.mapRegions[0].length);
      return var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-191452998"
   )
   @Export("getLoaded")
   public boolean getLoaded() {
      return this.loaded;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "1250844219"
   )
   public HashMap method630() {
      this.method606();
      return this.field548;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1047577366"
   )
   void method606() {
      if(this.field548 == null) {
         this.field548 = new HashMap();
      }

      this.field548.clear();

      for(int var1 = 0; var1 < this.mapRegions.length; ++var1) {
         for(int var2 = 0; var2 < this.mapRegions[var1].length; ++var2) {
            List var3 = this.mapRegions[var1][var2].method463();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               MapIcon var5 = (MapIcon)var4.next();
               if(!this.field548.containsKey(Integer.valueOf(var5.areaId))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field548.put(Integer.valueOf(var5.areaId), var6);
               } else {
                  List var7 = (List)this.field548.get(Integer.valueOf(var5.areaId));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "-782152666"
   )
   float method602(int graphicsDiff, int worldDiff) {
      float var3 = (float)graphicsDiff / (float)worldDiff;
      if(var3 > 8.0F) {
         return 8.0F;
      } else if(var3 < 1.0F) {
         return 1.0F;
      } else {
         int var4 = Math.round(var3);
         return Math.abs((float)var4 - var3) < 0.05F?(float)var4:var3;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1614039052"
   )
   static void method608(Component var0) {
      var0.removeMouseListener(MouseInput.mouse);
      var0.removeMouseMotionListener(MouseInput.mouse);
      var0.removeFocusListener(MouseInput.mouse);
      MouseInput.MouseHandler_currentButton = 0;
   }
}
