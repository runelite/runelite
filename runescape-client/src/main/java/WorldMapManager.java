import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
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

@ObfuscatedName("ad")
@Implements("WorldMapManager")
public final class WorldMapManager {
   @ObfuscatedName("o")
   @Export("loaded")
   boolean loaded;
   @ObfuscatedName("k")
   @Export("loading")
   boolean loading;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lan;"
   )
   class45 field549;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   SpritePixels field560;
   @ObfuscatedName("h")
   HashMap field550;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[[Lai;"
   )
   @Export("mapRegions")
   WorldMapRegion[][] mapRegions;
   @ObfuscatedName("z")
   HashMap field546;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Lll;"
   )
   IndexedSprite[] field553;
   @ObfuscatedName("u")
   @Export("mapFonts")
   final HashMap mapFonts;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 136673257
   )
   int field557;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1128542591
   )
   int field556;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1429969103
   )
   int field554;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 911884203
   )
   int field558;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1783357293
   )
   public int field548;

   @ObfuscatedSignature(
      signature = "([Lll;Ljava/util/HashMap;)V"
   )
   public WorldMapManager(IndexedSprite[] var1, HashMap var2) {
      this.loaded = false;
      this.loading = false;
      this.field546 = new HashMap();
      this.field548 = 0;
      this.field553 = var1;
      this.mapFonts = var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljf;Ljava/lang/String;ZB)V",
      garbageValue = "-128"
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
         this.field549 = new class45();

         try {
            this.field549.method669(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var20) {
            return;
         }

         this.field549.method334();
         this.field549.method386();
         this.field549.method336();
         this.field557 = this.field549.getMinX() * 64;
         this.field556 = this.field549.getMinY() * 64;
         this.field554 = (this.field549.method360() - this.field549.getMinX() + 1) * 64;
         this.field558 = (this.field549.method331() - this.field549.getMinY() + 1) * 64;
         int var17 = this.field549.method360() - this.field549.getMinX() + 1;
         int var10 = this.field549.method331() - this.field549.getMinY() + 1;
         System.nanoTime();
         System.nanoTime();
         WorldMapRegion.field479.method3938();
         WorldMapRegion.field480.method3938();
         this.mapRegions = new WorldMapRegion[var17][var10];
         Iterator var11 = this.field549.field572.iterator();

         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field406;
            int var14 = var12.field407;
            int var15 = var13 - this.field549.getMinX();
            int var16 = var14 - this.field549.getMinY();
            this.mapRegions[var15][var16] = new WorldMapRegion(var13, var14, this.field549.method352(), this.mapFonts);
            this.mapRegions[var15][var16].method414(var12, this.field549.field571);
         }

         for(int var18 = 0; var18 < var17; ++var18) {
            for(int var19 = 0; var19 < var10; ++var19) {
               if(this.mapRegions[var18][var19] == null) {
                  this.mapRegions[var18][var19] = new WorldMapRegion(this.field549.getMinX() + var18, this.field549.getMinY() + var19, this.field549.method352(), this.mapFonts);
                  this.mapRegions[var18][var19].method415(this.field549.field570, this.field549.field571);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4599(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, var2)) {
            byte[] var21 = var1.takeRecordByNames(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, var2);
            this.field560 = class185.method3448(var21);
         }

         System.nanoTime();
         var1.method4566();
         var1.reset();
         this.loaded = true;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   public final void method591() {
      this.field550 = null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-590495595"
   )
   @Export("drawMapRegion")
   public final void drawMapRegion(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      WorldMapRectangle var13 = this.getRegionRectForViewport(var1, var2, var3, var4);
      float var14 = this.method601(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      this.field548 = var15;
      if(!this.field546.containsKey(Integer.valueOf(var15))) {
         class47 var16 = new class47(var15);
         var16.method734();
         this.field546.put(Integer.valueOf(var15), var16);
      }

      WorldMapRegion[] var22 = new WorldMapRegion[8];

      int var17;
      int var18;
      for(var17 = var13.worldMapRegionX; var17 < var13.worldMapRegionWidth + var13.worldMapRegionX; ++var17) {
         for(var18 = var13.worldMapRegionY; var18 < var13.worldMapRegionY + var13.worldMapRegionHeight; ++var18) {
            this.method594(var17, var18, var22);
            this.mapRegions[var17][var18].method444(var15, (class47)this.field546.get(Integer.valueOf(var15)), var22, this.field553);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(var14 * 64.0F);
      var18 = this.field557 + var1;
      int var19 = var2 + this.field556;

      for(int var20 = var13.worldMapRegionX; var20 < var13.worldMapRegionWidth + var13.worldMapRegionX; ++var20) {
         for(int var21 = var13.worldMapRegionY; var21 < var13.worldMapRegionHeight + var13.worldMapRegionY; ++var21) {
            this.mapRegions[var20][var21].method413(var5 + var17 * (this.mapRegions[var20][var21].field484 * 64 - var18) / 64, var8 - var17 * (this.mapRegions[var20][var21].field482 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "-1953063707"
   )
   @Export("drawMapIcons")
   public final void drawMapIcons(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      WorldMapRectangle var14 = this.getRegionRectForViewport(var1, var2, var3, var4);
      float var15 = this.method601(var7 - var5, var3 - var1);
      int var16 = (int)(64.0F * var15);
      int var17 = this.field557 + var1;
      int var18 = var2 + this.field556;

      int var19;
      int var20;
      for(var19 = var14.worldMapRegionX; var19 < var14.worldMapRegionWidth + var14.worldMapRegionX; ++var19) {
         for(var20 = var14.worldMapRegionY; var20 < var14.worldMapRegionY + var14.worldMapRegionHeight; ++var20) {
            if(var13) {
               this.mapRegions[var19][var20].method441();
            }

            this.mapRegions[var19][var20].method419(var5 + var16 * (this.mapRegions[var19][var20].field484 * 64 - var17) / 64, var8 - var16 * (this.mapRegions[var19][var20].field482 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.worldMapRegionX; var19 < var14.worldMapRegionWidth + var14.worldMapRegionX; ++var19) {
            for(var20 = var14.worldMapRegionY; var20 < var14.worldMapRegionY + var14.worldMapRegionHeight; ++var20) {
               this.mapRegions[var19][var20].drawFlashingMapIcons(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II[Lai;I)V",
      garbageValue = "-1627237797"
   )
   void method594(int var1, int var2, WorldMapRegion[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.mapRegions.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.mapRegions[0].length - 1;
      if(var7) {
         var3[class254.field3324.rsOrdinal()] = null;
      } else {
         var3[class254.field3324.rsOrdinal()] = this.mapRegions[var1][var2 + 1];
      }

      var3[class254.field3322.rsOrdinal()] = !var7 && !var5?this.mapRegions[var1 + 1][var2 + 1]:null;
      var3[class254.field3328.rsOrdinal()] = !var7 && !var4?this.mapRegions[var1 - 1][var2 + 1]:null;
      var3[class254.field3323.rsOrdinal()] = var5?null:this.mapRegions[var1 + 1][var2];
      var3[class254.field3321.rsOrdinal()] = var4?null:this.mapRegions[var1 - 1][var2];
      var3[class254.field3325.rsOrdinal()] = var6?null:this.mapRegions[var1][var2 - 1];
      var3[class254.field3327.rsOrdinal()] = !var6 && !var5?this.mapRegions[var1 + 1][var2 - 1]:null;
      var3[class254.field3326.rsOrdinal()] = !var6 && !var4?this.mapRegions[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "-1315647766"
   )
   public void method595(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field560 != null) {
         this.field560.method5860(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field550 == null) {
               this.method600();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field550.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  MapIcon var12 = (MapIcon)var11.next();
                  int var13 = var3 * (var12.field532.worldX - this.field557) / this.field554;
                  int var14 = var4 - (var12.field532.worldY - this.field556) * var4 / this.field558;
                  Rasterizer2D.method5720(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIII)Ljava/util/List;",
      garbageValue = "1797511523"
   )
   public List method596(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.loaded) {
         return var11;
      } else {
         WorldMapRectangle var12 = this.getRegionRectForViewport(var1, var2, var3, var4);
         float var13 = this.method601(var7, var3 - var1);
         int var14 = (int)(64.0F * var13);
         int var15 = this.field557 + var1;
         int var16 = var2 + this.field556;

         for(int var17 = var12.worldMapRegionX; var17 < var12.worldMapRegionX + var12.worldMapRegionWidth; ++var17) {
            for(int var18 = var12.worldMapRegionY; var18 < var12.worldMapRegionHeight + var12.worldMapRegionY; ++var18) {
               List var19 = this.mapRegions[var17][var18].method469(var5 + var14 * (this.mapRegions[var17][var18].field484 * 64 - var15) / 64, var8 + var6 - var14 * (this.mapRegions[var17][var18].field482 * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIB)Lat;",
      garbageValue = "82"
   )
   @Export("getRegionRectForViewport")
   WorldMapRectangle getRegionRectForViewport(int var1, int var2, int var3, int var4) {
      WorldMapRectangle var5 = new WorldMapRectangle(this);
      int var6 = this.field557 + var1;
      int var7 = var2 + this.field556;
      int var8 = var3 + this.field557;
      int var9 = var4 + this.field556;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.worldMapRegionWidth = var12 - var10 + 1;
      var5.worldMapRegionHeight = var13 - var11 + 1;
      var5.worldMapRegionX = var10 - this.field549.getMinX();
      var5.worldMapRegionY = var11 - this.field549.getMinY();
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1242355759"
   )
   public boolean method598() {
      return this.loaded;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Ljava/util/HashMap;",
      garbageValue = "-14"
   )
   public HashMap method612() {
      this.method600();
      return this.field550;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1782970232"
   )
   void method600() {
      if(this.field550 == null) {
         this.field550 = new HashMap();
      }

      this.field550.clear();

      for(int var1 = 0; var1 < this.mapRegions.length; ++var1) {
         for(int var2 = 0; var2 < this.mapRegions[var1].length; ++var2) {
            List var3 = this.mapRegions[var1][var2].method511();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               MapIcon var5 = (MapIcon)var4.next();
               if(!this.field550.containsKey(Integer.valueOf(var5.areaId))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field550.put(Integer.valueOf(var5.areaId), var6);
               } else {
                  List var7 = (List)this.field550.get(Integer.valueOf(var5.areaId));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "-1441360137"
   )
   float method601(int var1, int var2) {
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljf;Ljava/lang/String;Ljava/lang/String;I)[Lll;",
      garbageValue = "-1612142140"
   )
   @Export("getIndexedSprites")
   public static IndexedSprite[] getIndexedSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite[] var5;
      if(!RunException.method3215(var0, var3, var4)) {
         var5 = null;
      } else {
         IndexedSprite[] var7 = new IndexedSprite[class332.indexedSpriteCount];

         for(int var8 = 0; var8 < class332.indexedSpriteCount; ++var8) {
            IndexedSprite var9 = var7[var8] = new IndexedSprite();
            var9.originalWidth = class332.indexedSpriteWidth;
            var9.originalHeight = class332.indexedSpriteHeight;
            var9.offsetX = class332.indexedSpriteOffsetXs[var8];
            var9.offsetY = FileSystem.indexedSpriteOffsetYs[var8];
            var9.width = WorldMapDecoration.indexSpriteWidths[var8];
            var9.height = class332.indexedSpriteHeights[var8];
            var9.palette = class332.indexedSpritePalette;
            var9.pixels = class332.spritePixels[var8];
         }

         class36.method541();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "-782138484"
   )
   static int method610(int var0, Script var1, boolean var2) {
      String var11;
      if(var0 == 3100) {
         var11 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
         class57.sendGameMessage(0, "", var11);
         return 1;
      } else if(var0 == 3101) {
         WorldComparator.intStackSize -= 2;
         GameObject.method3083(SoundTaskDataProvider.localPlayer, class81.intStack[WorldComparator.intStackSize], class81.intStack[WorldComparator.intStackSize + 1]);
         return 1;
      } else if(var0 == 3103) {
         PacketNode var13 = WorldMapRectangle.method280(ClientPacket.field2428, Client.field957.field1484);
         Client.field957.method2052(var13);

         for(WidgetNode var15 = (WidgetNode)Client.componentTable.first(); var15 != null; var15 = (WidgetNode)Client.componentTable.next()) {
            if(var15.owner == 0 || var15.owner == 3) {
               class57.closeWidget(var15, true);
            }
         }

         if(Client.field1033 != null) {
            FontName.method5490(Client.field1033);
            Client.field1033 = null;
         }

         return 1;
      } else {
         int var7;
         int var14;
         if(var0 == 3104) {
            var11 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
            var7 = 0;
            if(class7.method27(var11)) {
               var14 = class150.parseInt(var11, 10, true);
               var7 = var14;
            }

            PacketNode var19 = WorldMapRectangle.method280(ClientPacket.field2410, Client.field957.field1484);
            var19.packetBuffer.putInt(var7);
            Client.field957.method2052(var19);
            return 1;
         } else {
            PacketNode var12;
            if(var0 == 3105) {
               var11 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
               var12 = WorldMapRectangle.method280(ClientPacket.field2480, Client.field957.field1484);
               var12.packetBuffer.putByte(var11.length() + 1);
               var12.packetBuffer.putString(var11);
               Client.field957.method2052(var12);
               return 1;
            } else if(var0 == 3106) {
               var11 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
               var12 = WorldMapRectangle.method280(ClientPacket.field2397, Client.field957.field1484);
               var12.packetBuffer.putByte(var11.length() + 1);
               var12.packetBuffer.putString(var11);
               Client.field957.method2052(var12);
               return 1;
            } else {
               String var4;
               int var9;
               if(var0 == 3107) {
                  var9 = class81.intStack[--WorldComparator.intStackSize];
                  var4 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                  WorldMapRectangle.method279(var9, var4);
                  return 1;
               } else if(var0 == 3108) {
                  WorldComparator.intStackSize -= 3;
                  var9 = class81.intStack[WorldComparator.intStackSize];
                  var7 = class81.intStack[WorldComparator.intStackSize + 1];
                  var14 = class81.intStack[WorldComparator.intStackSize + 2];
                  Widget var16 = class44.getWidget(var14);
                  class27.method239(var16, var9, var7);
                  return 1;
               } else if(var0 == 3109) {
                  WorldComparator.intStackSize -= 2;
                  var9 = class81.intStack[WorldComparator.intStackSize];
                  var7 = class81.intStack[WorldComparator.intStackSize + 1];
                  Widget var18 = var2?class81.field1285:Signlink.field2218;
                  class27.method239(var18, var9, var7);
                  return 1;
               } else if(var0 == 3110) {
                  MapIconReference.middleMouseMovesCamera = class81.intStack[--WorldComparator.intStackSize] == 1;
                  return 1;
               } else if(var0 == 3111) {
                  class81.intStack[++WorldComparator.intStackSize - 1] = Client.preferences.hideRoofs?1:0;
                  return 1;
               } else if(var0 == 3112) {
                  Client.preferences.hideRoofs = class81.intStack[--WorldComparator.intStackSize] == 1;
                  MouseInput.method1062();
                  return 1;
               } else if(var0 == 3113) {
                  var11 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                  boolean var17 = class81.intStack[--WorldComparator.intStackSize] == 1;
                  if(var17) {
                     if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                        try {
                           Desktop.getDesktop().browse(new URI(var11));
                           return 1;
                        } catch (Exception var10) {
                           ;
                        }
                     }

                     if(class57.field667.startsWith("win")) {
                        Buffer.method3727(var11, 0);
                     } else if(class57.field667.startsWith("mac")) {
                        CombatInfoListHolder.method1865(var11, 1, "openjs");
                     } else {
                        Buffer.method3727(var11, 2);
                     }
                  } else {
                     Buffer.method3727(var11, 3);
                  }

                  return 1;
               } else if(var0 == 3115) {
                  var9 = class81.intStack[--WorldComparator.intStackSize];
                  var12 = WorldMapRectangle.method280(ClientPacket.field2389, Client.field957.field1484);
                  var12.packetBuffer.putShort(var9);
                  Client.field957.method2052(var12);
                  return 1;
               } else if(var0 == 3116) {
                  var9 = class81.intStack[--WorldComparator.intStackSize];
                  KeyFocusListener.scriptStringStackSize -= 2;
                  var4 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                  String var8 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                  if(var4.length() > 500) {
                     return 1;
                  } else if(var8.length() > 500) {
                     return 1;
                  } else {
                     PacketNode var6 = WorldMapRectangle.method280(ClientPacket.field2385, Client.field957.field1484);
                     var6.packetBuffer.putShort(1 + WorldMapRegion.getLength(var4) + WorldMapRegion.getLength(var8));
                     var6.packetBuffer.putString(var8);
                     var6.packetBuffer.method3542(var9);
                     var6.packetBuffer.putString(var4);
                     Client.field957.method2052(var6);
                     return 1;
                  }
               } else if(var0 == 3117) {
                  Client.field981 = class81.intStack[--WorldComparator.intStackSize] == 1;
                  return 1;
               } else if(var0 == 3118) {
                  Client.field1017 = class81.intStack[--WorldComparator.intStackSize] == 1;
                  return 1;
               } else if(var0 == 3119) {
                  Client.field988 = class81.intStack[--WorldComparator.intStackSize] == 1;
                  return 1;
               } else if(var0 == 3120) {
                  if(class81.intStack[--WorldComparator.intStackSize] == 1) {
                     Client.playerNameMask |= 1;
                  } else {
                     Client.playerNameMask &= -2;
                  }

                  return 1;
               } else if(var0 == 3121) {
                  if(class81.intStack[--WorldComparator.intStackSize] == 1) {
                     Client.playerNameMask |= 2;
                  } else {
                     Client.playerNameMask &= -3;
                  }

                  return 1;
               } else if(var0 == 3122) {
                  if(class81.intStack[--WorldComparator.intStackSize] == 1) {
                     Client.playerNameMask |= 4;
                  } else {
                     Client.playerNameMask &= -5;
                  }

                  return 1;
               } else if(var0 == 3123) {
                  if(class81.intStack[--WorldComparator.intStackSize] == 1) {
                     Client.playerNameMask |= 8;
                  } else {
                     Client.playerNameMask &= -9;
                  }

                  return 1;
               } else if(var0 == 3124) {
                  Client.playerNameMask = 0;
                  return 1;
               } else if(var0 == 3125) {
                  Client.field974 = class81.intStack[--WorldComparator.intStackSize] == 1;
                  return 1;
               } else if(var0 == 3126) {
                  Client.field1097 = class81.intStack[--WorldComparator.intStackSize] == 1;
                  return 1;
               } else if(var0 == 3127) {
                  class23.method190(class81.intStack[--WorldComparator.intStackSize] == 1);
                  return 1;
               } else if(var0 == 3128) {
                  int[] var3 = class81.intStack;
                  var7 = ++WorldComparator.intStackSize - 1;
                  boolean var5 = Client.field1016;
                  var3[var7] = var5?1:0;
                  return 1;
               } else if(var0 == 3129) {
                  WorldComparator.intStackSize -= 2;
                  Client.field1059 = class81.intStack[WorldComparator.intStackSize];
                  Client.field950 = class81.intStack[WorldComparator.intStackSize + 1];
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(Lbz;ZB)V",
      garbageValue = "-38"
   )
   static void method627(Player var0, boolean var1) {
      if(var0 != null && var0.hasConfig() && !var0.hidden) {
         int var2 = var0.field836 << 14;
         var0.isLowDetail = false;
         if((Client.lowMemory && class93.playerIndexesCount > 50 || class93.playerIndexesCount > 200) && var1 && var0.idlePoseAnimation == var0.poseAnimation) {
            var0.isLowDetail = true;
         }

         int var3 = var0.x >> 7;
         int var4 = var0.y >> 7;
         if(var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
            if(var0.model != null && Client.gameCycle >= var0.animationCycleStart && Client.gameCycle < var0.animationCycleEnd) {
               var0.isLowDetail = false;
               var0.field842 = class265.getTileHeight(var0.x, var0.y, BoundingBox3DDrawMode.plane);
               var0.field1161 = Client.gameCycle;
               class255.region.method2871(BoundingBox3DDrawMode.plane, var0.x, var0.y, var0.field842, 60, var0, var0.angle, var2, var0.field849, var0.field850, var0.field851, var0.field852);
            } else {
               if((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if(Client.field966[var3][var4] == Client.field1137) {
                     return;
                  }

                  Client.field966[var3][var4] = Client.field1137;
               }

               var0.field842 = class265.getTileHeight(var0.x, var0.y, BoundingBox3DDrawMode.plane);
               var0.field1161 = Client.gameCycle;
               class255.region.method2863(BoundingBox3DDrawMode.plane, var0.x, var0.y, var0.field842, 60, var0, var0.angle, var2, var0.field1159);
            }
         }
      }

   }
}
