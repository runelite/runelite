import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("WorldMapManager")
public final class WorldMapManager {
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 289323021
   )
   static int field533;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      intValue = -68949011
   )
   static int field537;
   @ObfuscatedName("c")
   @Export("loaded")
   boolean loaded;
   @ObfuscatedName("i")
   @Export("loading")
   boolean loading;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   class45 field524;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   SpritePixels field534;
   @ObfuscatedName("k")
   HashMap field526;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[[Lao;"
   )
   @Export("mapRegions")
   WorldMapRegion[][] mapRegions;
   @ObfuscatedName("z")
   HashMap field528;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   IndexedSprite[] field529;
   @ObfuscatedName("w")
   @Export("mapFonts")
   final HashMap mapFonts;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1912797293
   )
   int field531;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 191548661
   )
   int field525;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -495703013
   )
   int field536;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1581878801
   )
   int field538;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -605053679
   )
   public int field535;

   @ObfuscatedSignature(
      signature = "([Llq;Ljava/util/HashMap;)V"
   )
   public WorldMapManager(IndexedSprite[] var1, HashMap var2) {
      this.loaded = false;
      this.loading = false;
      this.field528 = new HashMap();
      this.field535 = 0;
      this.field529 = var1;
      this.mapFonts = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljm;Ljava/lang/String;ZI)V",
      garbageValue = "-263697855"
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
         this.field524 = new class45();

         try {
            this.field524.method663(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var24) {
            return;
         }

         this.field524.method322();
         this.field524.method323();
         this.field524.method324();
         this.field531 = this.field524.getMinX() * 64;
         this.field525 = this.field524.getMinY() * 64;
         this.field536 = (this.field524.method319() - this.field524.getMinX() + 1) * 64;
         this.field538 = (this.field524.method313() - this.field524.getMinY() + 1) * 64;
         int var18 = this.field524.method319() - this.field524.getMinX() + 1;
         int var10 = this.field524.method313() - this.field524.getMinY() + 1;
         System.nanoTime();
         System.nanoTime();
         BoundingBox.method57();
         this.mapRegions = new WorldMapRegion[var18][var10];
         Iterator var11 = this.field524.field557.iterator();

         int var14;
         int var15;
         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field390;
            var14 = var12.field387;
            var15 = var13 - this.field524.getMinX();
            int var16 = var14 - this.field524.getMinY();
            this.mapRegions[var15][var16] = new WorldMapRegion(var13, var14, this.field524.method316(), this.mapFonts);
            this.mapRegions[var15][var16].method508(var12, this.field524.field555);
         }

         for(int var19 = 0; var19 < var18; ++var19) {
            for(int var20 = 0; var20 < var10; ++var20) {
               if(this.mapRegions[var19][var20] == null) {
                  this.mapRegions[var19][var20] = new WorldMapRegion(this.field524.getMinX() + var19, this.field524.getMinY() + var20, this.field524.method316(), this.mapFonts);
                  this.mapRegions[var19][var20].method392(this.field524.field554, this.field524.field555);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4571(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, var2)) {
            byte[] var27 = var1.takeRecordByNames(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, var2);
            BufferedImage var21 = null;

            SpritePixels var28;
            label46: {
               try {
                  var21 = ImageIO.read(new ByteArrayInputStream(var27));
                  var14 = var21.getWidth();
                  var15 = var21.getHeight();
                  int[] var22 = new int[var15 * var14];
                  PixelGrabber var17 = new PixelGrabber(var21, 0, 0, var14, var15, var22, 0, var14);
                  var17.grabPixels();
                  var28 = new SpritePixels(var22, var14, var15);
                  break label46;
               } catch (IOException var25) {
                  ;
               } catch (InterruptedException var26) {
                  ;
               }

               var28 = new SpritePixels(0, 0);
            }

            this.field534 = var28;
         }

         System.nanoTime();
         var1.method4556();
         var1.reset();
         this.loaded = true;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "300248511"
   )
   public final void method619() {
      this.field526 = null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "121"
   )
   @Export("drawMapRegion")
   public final void drawMapRegion(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      WorldMapRectangle var13 = this.getRegionRectForViewport(var1, var2, var3, var4);
      float var14 = this.method591(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      this.field535 = var15;
      if(!this.field528.containsKey(Integer.valueOf(var15))) {
         class47 var16 = new class47(var15);
         var16.method740();
         this.field528.put(Integer.valueOf(var15), var16);
      }

      WorldMapRegion[] var22 = new WorldMapRegion[8];

      int var17;
      int var18;
      for(var17 = var13.worldMapRegionX; var17 < var13.worldMapRegionX + var13.worldMapRegionWidth; ++var17) {
         for(var18 = var13.worldMapRegionY; var18 < var13.worldMapRegionY + var13.worldMapRegionHeight; ++var18) {
            this.method584(var17, var18, var22);
            this.mapRegions[var17][var18].method395(var15, (class47)this.field528.get(Integer.valueOf(var15)), var22, this.field529);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(64.0F * var14);
      var18 = this.field531 + var1;
      int var19 = var2 + this.field525;

      for(int var20 = var13.worldMapRegionX; var20 < var13.worldMapRegionX + var13.worldMapRegionWidth; ++var20) {
         for(int var21 = var13.worldMapRegionY; var21 < var13.worldMapRegionY + var13.worldMapRegionHeight; ++var21) {
            this.mapRegions[var20][var21].method390(var5 + var17 * (this.mapRegions[var20][var21].field459 * 64 - var18) / 64, var8 - var17 * (this.mapRegions[var20][var21].field456 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "1816619576"
   )
   @Export("drawMapIcons")
   public final void drawMapIcons(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      WorldMapRectangle var14 = this.getRegionRectForViewport(var1, var2, var3, var4);
      float var15 = this.method591(var7 - var5, var3 - var1);
      int var16 = (int)(var15 * 64.0F);
      int var17 = this.field531 + var1;
      int var18 = var2 + this.field525;

      int var19;
      int var20;
      for(var19 = var14.worldMapRegionX; var19 < var14.worldMapRegionX + var14.worldMapRegionWidth; ++var19) {
         for(var20 = var14.worldMapRegionY; var20 < var14.worldMapRegionY + var14.worldMapRegionHeight; ++var20) {
            if(var13) {
               this.mapRegions[var19][var20].method442();
            }

            this.mapRegions[var19][var20].method414(var5 + var16 * (this.mapRegions[var19][var20].field459 * 64 - var17) / 64, var8 - var16 * (this.mapRegions[var19][var20].field456 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.worldMapRegionX; var19 < var14.worldMapRegionWidth + var14.worldMapRegionX; ++var19) {
            for(var20 = var14.worldMapRegionY; var20 < var14.worldMapRegionHeight + var14.worldMapRegionY; ++var20) {
               this.mapRegions[var19][var20].drawFlashingMapIcons(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II[Lao;I)V",
      garbageValue = "218581327"
   )
   void method584(int var1, int var2, WorldMapRegion[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.mapRegions.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.mapRegions[0].length - 1;
      if(var7) {
         var3[class254.field3316.rsOrdinal()] = null;
      } else {
         var3[class254.field3316.rsOrdinal()] = this.mapRegions[var1][var2 + 1];
      }

      var3[class254.field3312.rsOrdinal()] = !var7 && !var5?this.mapRegions[var1 + 1][var2 + 1]:null;
      var3[class254.field3318.rsOrdinal()] = !var7 && !var4?this.mapRegions[var1 - 1][var2 + 1]:null;
      var3[class254.field3313.rsOrdinal()] = var5?null:this.mapRegions[var1 + 1][var2];
      var3[class254.field3320.rsOrdinal()] = var4?null:this.mapRegions[var1 - 1][var2];
      var3[class254.field3315.rsOrdinal()] = var6?null:this.mapRegions[var1][var2 - 1];
      var3[class254.field3314.rsOrdinal()] = !var6 && !var5?this.mapRegions[var1 + 1][var2 - 1]:null;
      var3[class254.field3311.rsOrdinal()] = !var6 && !var4?this.mapRegions[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "1679589986"
   )
   public void method620(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field534 != null) {
         this.field534.method5871(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field526 == null) {
               this.method590();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field526.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  MapIcon var12 = (MapIcon)var11.next();
                  int var13 = var3 * (var12.field512.worldX - this.field531) / this.field536;
                  int var14 = var4 - (var12.field512.worldY - this.field525) * var4 / this.field538;
                  Rasterizer2D.method5739(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIIB)Ljava/util/List;",
      garbageValue = "0"
   )
   public List method586(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.loaded) {
         return var11;
      } else {
         WorldMapRectangle var12 = this.getRegionRectForViewport(var1, var2, var3, var4);
         float var13 = this.method591(var7, var3 - var1);
         int var14 = (int)(64.0F * var13);
         int var15 = this.field531 + var1;
         int var16 = var2 + this.field525;

         for(int var17 = var12.worldMapRegionX; var17 < var12.worldMapRegionX + var12.worldMapRegionWidth; ++var17) {
            for(int var18 = var12.worldMapRegionY; var18 < var12.worldMapRegionHeight + var12.worldMapRegionY; ++var18) {
               List var19 = this.mapRegions[var17][var18].method425(var5 + var14 * (this.mapRegions[var17][var18].field459 * 64 - var15) / 64, var8 + var6 - var14 * (this.mapRegions[var17][var18].field456 * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIB)Lai;",
      garbageValue = "52"
   )
   @Export("getRegionRectForViewport")
   WorldMapRectangle getRegionRectForViewport(int var1, int var2, int var3, int var4) {
      WorldMapRectangle var5 = new WorldMapRectangle(this);
      int var6 = this.field531 + var1;
      int var7 = var2 + this.field525;
      int var8 = var3 + this.field531;
      int var9 = var4 + this.field525;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.worldMapRegionWidth = var12 - var10 + 1;
      var5.worldMapRegionHeight = var13 - var11 + 1;
      var5.worldMapRegionX = var10 - this.field524.getMinX();
      var5.worldMapRegionY = var11 - this.field524.getMinY();
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1131758784"
   )
   public boolean method588() {
      return this.loaded;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "-1521817553"
   )
   public HashMap method589() {
      this.method590();
      return this.field526;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1446693813"
   )
   void method590() {
      if(this.field526 == null) {
         this.field526 = new HashMap();
      }

      this.field526.clear();

      for(int var1 = 0; var1 < this.mapRegions.length; ++var1) {
         for(int var2 = 0; var2 < this.mapRegions[var1].length; ++var2) {
            List var3 = this.mapRegions[var1][var2].method426();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               MapIcon var5 = (MapIcon)var4.next();
               if(!this.field526.containsKey(Integer.valueOf(var5.areaId))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field526.put(Integer.valueOf(var5.areaId), var6);
               } else {
                  List var7 = (List)this.field526.get(Integer.valueOf(var5.areaId));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "1403116933"
   )
   float method591(int var1, int var2) {
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "634757620"
   )
   static final int method617() {
      return class132.Viewport_mouseY;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "-1715330642"
   )
   static int method624(int var0, Script var1, boolean var2) {
      Widget var3 = class3.getWidget(class81.intStack[--SceneTilePaint.intStackSize]);
      if(var0 == 2600) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 2601) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 2602) {
         class81.scriptStringStack[++World.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 2603) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 2604) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 2605) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 2606) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 2607) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 2608) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 2609) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 2610) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.field2846;
         return 1;
      } else if(var0 == 2611) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 2612) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.field2920;
         return 1;
      } else if(var0 == 2613) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.field2896.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(III)Lfn;",
      garbageValue = "-373695699"
   )
   static class178 method605(int var0, int var1) {
      Client.field1127.field2283 = var0;
      Client.field1127.field2282 = var1;
      Client.field1127.field2280 = 1;
      Client.field1127.field2281 = 1;
      return Client.field1127;
   }
}
