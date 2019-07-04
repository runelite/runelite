import java.util.Arrays;
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

@ObfuscatedName("lz")
@Implements("WorldMap")
public class WorldMap {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   @Export("fontNameVerdana11")
   static final FontName fontNameVerdana11;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   @Export("fontNameVerdana13")
   static final FontName fontNameVerdana13;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   @Export("fontNameVerdana15")
   static final FontName fontNameVerdana15;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   AbstractIndexCache field989;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   AbstractIndexCache field990;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   AbstractIndexCache field991;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lkk;"
   )
   @Export("font")
   Font font;
   @ObfuscatedName("i")
   @Export("fonts")
   HashMap fonts;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   @Export("mapSceneSprites")
   IndexedSprite[] mapSceneSprites;
   @ObfuscatedName("z")
   @Export("mapAreas")
   HashMap mapAreas;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lag;"
   )
   @Export("mainMapArea")
   WorldMapArea mainMapArea;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lag;"
   )
   @Export("currentMapArea0")
   WorldMapArea currentMapArea0;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lag;"
   )
   WorldMapArea field992;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   @Export("worldMapManager")
   WorldMapManager worldMapManager;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lls;"
   )
   @Export("cacheLoader")
   WorldMapIndexCacheLoader cacheLoader;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1711576969
   )
   @Export("worldMapX")
   int worldMapX;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1318118645
   )
   @Export("worldMapY")
   int worldMapY;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -89657613
   )
   @Export("worldMapTargetX")
   int worldMapTargetX;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -56022357
   )
   @Export("worldMapTargetY")
   int worldMapTargetY;
   @ObfuscatedName("v")
   @Export("zoom")
   float zoom;
   @ObfuscatedName("ag")
   @Export("zoomTarget")
   float zoomTarget;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1469654441
   )
   @Export("worldMapDisplayWidth")
   int worldMapDisplayWidth;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1140942239
   )
   @Export("worldMapDisplayHeight")
   int worldMapDisplayHeight;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1301477687
   )
   @Export("worldMapDisplayX")
   int worldMapDisplayX;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -298919797
   )
   @Export("worldMapDisplayY")
   int worldMapDisplayY;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1653084915
   )
   int field993;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1664740569
   )
   int field994;
   @ObfuscatedName("ah")
   @Export("perpetualFlash0")
   boolean perpetualFlash0;
   @ObfuscatedName("ak")
   @Export("flashingElements")
   HashSet flashingElements;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1683910031
   )
   int field995;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 2064651113
   )
   int field996;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1979665983
   )
   int field997;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 547126547
   )
   int field998;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -815748997
   )
   int field999;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -988933407
   )
   int field1000;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      longValue = -4747643242047040283L
   )
   long field1001;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -969094439
   )
   int field1002;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -869889187
   )
   int field1003;
   @ObfuscatedName("an")
   boolean field1004;
   @ObfuscatedName("ao")
   @Export("enabledElements")
   HashSet enabledElements;
   @ObfuscatedName("aa")
   @Export("enabledCategories")
   HashSet enabledCategories;
   @ObfuscatedName("ax")
   HashSet field1005;
   @ObfuscatedName("af")
   HashSet field1006;
   @ObfuscatedName("ai")
   @Export("elementsDisabled")
   boolean elementsDisabled;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -237734529
   )
   int field1007;
   @ObfuscatedName("bs")
   final int[] field1008;
   @ObfuscatedName("bq")
   List field1009;
   @ObfuscatedName("bn")
   @Export("iconIterator")
   Iterator iconIterator;
   @ObfuscatedName("bk")
   HashSet field1010;
   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("mouseCoord")
   TileLocation mouseCoord;
   @ObfuscatedName("bc")
   @Export("showCoord")
   public boolean showCoord;
   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   @Export("sprite")
   Sprite sprite;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 2031417343
   )
   int field1011;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 754899959
   )
   int field1012;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 2064728623
   )
   int field1013;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1774424249
   )
   int field1014;

   public WorldMap() {
      this.worldMapTargetX = -1;
      this.worldMapTargetY = -1;
      this.worldMapDisplayWidth = -1;
      this.worldMapDisplayHeight = -1;
      this.worldMapDisplayX = -1;
      this.worldMapDisplayY = -1;
      this.field993 = 3;
      this.field994 = 50;
      this.perpetualFlash0 = false;
      this.flashingElements = null;
      this.field995 = -1;
      this.field996 = -1;
      this.field997 = -1;
      this.field998 = -1;
      this.field999 = -1;
      this.field1000 = -1;
      this.field1004 = true;
      this.enabledElements = new HashSet();
      this.enabledCategories = new HashSet();
      this.field1005 = new HashSet();
      this.field1006 = new HashSet();
      this.elementsDisabled = false;
      this.field1007 = 0;
      this.field1008 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field1010 = new HashSet();
      this.mouseCoord = null;
      this.showCoord = false;
      this.field1012 = -1;
      this.field1013 = -1;
      this.field1014 = -1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;Lir;Lkk;Ljava/util/HashMap;[Llq;I)V",
      garbageValue = "1887817097"
   )
   @Export("init")
   public void init(AbstractIndexCache var1, AbstractIndexCache var2, AbstractIndexCache var3, Font var4, HashMap var5, IndexedSprite[] var6) {
      this.mapSceneSprites = var6;
      this.field989 = var1;
      this.field990 = var2;
      this.field991 = var3;
      this.font = var4;
      this.fonts = new HashMap();
      this.fonts.put(WorldMapLabelSize.WorldMapLabelSize_small, var5.get(fontNameVerdana11));
      this.fonts.put(WorldMapLabelSize.WorldMapLabelSize_medium, var5.get(fontNameVerdana13));
      this.fonts.put(WorldMapLabelSize.WorldMapLabelSize_large, var5.get(fontNameVerdana15));
      this.cacheLoader = new WorldMapIndexCacheLoader(var1);
      int var7 = this.field989.getArchiveId(WorldMapCacheName.WorldMapCacheName_details.name);
      int[] var8 = this.field989.method3(var7);
      this.mapAreas = new HashMap(var8.length);

      for (int var9 = 0; var9 < var8.length; ++var9) {
         Buffer var10 = new Buffer(this.field989.takeRecord(var7, var8[var9]));
         WorldMapArea var11 = new WorldMapArea();
         var11.read(var10, var8[var9]);
         this.mapAreas.put(var11.archiveName(), var11);
         if (var11.isMain()) {
            this.mainMapArea = var11;
         }
      }

      this.setCurrentMapArea(this.mainMapArea);
      this.field992 = null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1144390092"
   )
   public void method360() {
      WorldMapRegion.field1051.demote(5);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIZIIIIB)V",
      garbageValue = "-35"
   )
   @Export("onCycle")
   public void onCycle(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if (this.cacheLoader.isLoaded()) {
         this.smoothZoom();
         this.method363();
         if (var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.zoom));
            int var9 = (int)Math.ceil((double)((float)var7 / this.zoom));
            List var10 = this.worldMapManager.method403(this.worldMapX - var8 / 2 - 1, this.worldMapY - var9 / 2 - 1, var8 / 2 + this.worldMapX + 1, var9 / 2 + this.worldMapY + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            AbstractWorldMapIcon var13;
            ScriptEvent var14;
            WorldMapEvent var15;
            for (var12 = var10.iterator(); var12.hasNext(); AbstractIndexCache.runScript(var14)) {
               var13 = (AbstractWorldMapIcon)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new WorldMapEvent(var13.vmethod395(), var13.coord1, var13.coord2);
               var14.setArgs(new Object[]{var15, var1, var2});
               if (this.field1010.contains(var13)) {
                  var14.setType(17);
               } else {
                  var14.setType(15);
               }
            }

            var12 = this.field1010.iterator();

            while (var12.hasNext()) {
               var13 = (AbstractWorldMapIcon)var12.next();
               if (!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new WorldMapEvent(var13.vmethod395(), var13.coord1, var13.coord2);
                  var14.setArgs(new Object[]{var15, var1, var2});
                  var14.setType(16);
                  AbstractIndexCache.runScript(var14);
               }
            }

            this.field1010 = var11;
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIZZS)V",
      garbageValue = "18431"
   )
   public void method361(int var1, int var2, boolean var3, boolean var4) {
      long var5 = class203.currentTimeMs();
      this.method362(var1, var2, var4, var5);
      if (this.method365() || !var4 && !var3) {
         this.method364();
      } else {
         if (var4) {
            this.field999 = var1;
            this.field1000 = var2;
            this.field997 = this.worldMapX;
            this.field998 = this.worldMapY;
         }

         if (this.field997 != -1) {
            int var7 = var1 - this.field999;
            int var8 = var2 - this.field1000;
            this.setWorldMapPosition(this.field997 - (int)((float)var7 / this.zoomTarget), (int)((float)var8 / this.zoomTarget) + this.field998, false);
         }
      }

      if (var4) {
         this.field1001 = var5;
         this.field1002 = var1;
         this.field1003 = var2;
      }

   }

   @ObfuscatedName("o")
   void method362(int var1, int var2, boolean var3, long var4) {
      if (this.currentMapArea0 != null) {
         int var6 = (int)((float)this.worldMapX + ((float)(var1 - this.worldMapDisplayX) - (float)this.method377() * this.zoom / 2.0F) / this.zoom);
         int var7 = (int)((float)this.worldMapY - ((float)(var2 - this.worldMapDisplayY) - (float)this.method378() * this.zoom / 2.0F) / this.zoom);
         this.mouseCoord = this.currentMapArea0.coord(var6 + this.currentMapArea0.minX() * 64, var7 + this.currentMapArea0.minY() * 64);
         if (this.mouseCoord != null && var3) {
            int var8;
            int var9;
            PacketBufferNode var11;
            if (FriendSystem.jmodCheck() && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81]) {
               int var12 = this.mouseCoord.x;
               var8 = this.mouseCoord.y;
               var9 = this.mouseCoord.plane;
               var11 = Interpreter.method1915(ClientPacket.field283, Client.packetWriter.isaacCipher);
               var11.packetBuffer.writeIntME(0);
               var11.packetBuffer.writeShortLE(var8);
               var11.packetBuffer.method56(var9);
               var11.packetBuffer.writeShort(var12);
               Client.packetWriter.method241(var11);
            } else {
               boolean var10 = true;
               if (this.field1004) {
                  var8 = var1 - this.field1002;
                  var9 = var2 - this.field1003;
                  if (var4 - this.field1001 > 500L || var8 < -25 || var8 > 25 || var9 < -25 || var9 > 25) {
                     var10 = false;
                  }
               }

               if (var10) {
                  var11 = Interpreter.method1915(ClientPacket.field267, Client.packetWriter.isaacCipher);
                  var11.packetBuffer.writeIntME(this.mouseCoord.packed());
                  Client.packetWriter.method241(var11);
                  this.field1001 = 0L;
               }
            }
         }
      } else {
         this.mouseCoord = null;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-328885193"
   )
   @Export("smoothZoom")
   void smoothZoom() {
      if (ClientParameter.field3645 != null) {
         this.zoom = this.zoomTarget;
      } else {
         if (this.zoom < this.zoomTarget) {
            this.zoom = Math.min(this.zoomTarget, this.zoom / 30.0F + this.zoom);
         }

         if (this.zoom > this.zoomTarget) {
            this.zoom = Math.max(this.zoomTarget, this.zoom - this.zoom / 30.0F);
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2075446341"
   )
   void method363() {
      if (this.method365()) {
         int var1 = this.worldMapTargetX - this.worldMapX;
         int var2 = this.worldMapTargetY - this.worldMapY;
         if (var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if (var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.setWorldMapPosition(var1 + this.worldMapX, var2 + this.worldMapY, true);
         if (this.worldMapTargetX == this.worldMapX && this.worldMapTargetY == this.worldMapY) {
            this.worldMapTargetX = -1;
            this.worldMapTargetY = -1;
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-943230538"
   )
   @Export("setWorldMapPosition")
   final void setWorldMapPosition(int var1, int var2, boolean var3) {
      this.worldMapX = var1;
      this.worldMapY = var2;
      class203.currentTimeMs();
      if (var3) {
         this.method364();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "35"
   )
   final void method364() {
      this.field1000 = -1;
      this.field999 = -1;
      this.field998 = -1;
      this.field997 = -1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1444745621"
   )
   boolean method365() {
      return this.worldMapTargetX != -1 && this.worldMapTargetY != -1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)Lag;",
      garbageValue = "1738506455"
   )
   @Export("mapAreaAtCoord")
   public WorldMapArea mapAreaAtCoord(int var1, int var2, int var3) {
      Iterator var4 = this.mapAreas.values().iterator();

      while (var4.hasNext()) {
         WorldMapArea var5 = (WorldMapArea)var4.next();
         if (var5.containsCoord(var1, var2, var3)) {
            return var5;
         }
      }

      return null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "469045892"
   )
   public void method366(int var1, int var2, int var3, boolean var4) {
      WorldMapArea var5 = this.mapAreaAtCoord(var1, var2, var3);
      if (var5 == null) {
         if (!var4) {
            return;
         }

         var5 = this.mainMapArea;
      }

      boolean var6 = false;
      if (var5 != this.field992 || var4) {
         this.field992 = var5;
         this.setCurrentMapArea(var5);
         var6 = true;
      }

      if (var6 || var4) {
         this.jump(var1, var2, var3);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1318491821"
   )
   @Export("setCurrentMapAreaId")
   public void setCurrentMapAreaId(int var1) {
      WorldMapArea var2 = this.getMapArea(var1);
      if (var2 != null) {
         this.setCurrentMapArea(var2);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-501094512"
   )
   @Export("currentMapAreaId")
   public int currentMapAreaId() {
      return this.currentMapArea0 == null ? -1 : this.currentMapArea0.id();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Lag;",
      garbageValue = "-810288511"
   )
   @Export("getCurrentMapArea")
   public WorldMapArea getCurrentMapArea() {
      return this.currentMapArea0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lag;B)V",
      garbageValue = "-44"
   )
   @Export("setCurrentMapArea")
   void setCurrentMapArea(WorldMapArea var1) {
      if (this.currentMapArea0 == null || var1 != this.currentMapArea0) {
         this.initializeWorldMap(var1);
         this.jump(-1, -1, -1);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lag;I)V",
      garbageValue = "-1072205896"
   )
   @Export("initializeWorldMap")
   void initializeWorldMap(WorldMapArea var1) {
      this.currentMapArea0 = var1;
      this.worldMapManager = new WorldMapManager(this.mapSceneSprites, this.fonts, this.field990, this.field991);
      this.cacheLoader.reset(this.currentMapArea0.archiveName());
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lag;Lhu;Lhu;ZI)V",
      garbageValue = "-1430939646"
   )
   public void method367(WorldMapArea var1, TileLocation var2, TileLocation var3, boolean var4) {
      if (var1 != null) {
         if (this.currentMapArea0 == null || var1 != this.currentMapArea0) {
            this.initializeWorldMap(var1);
         }

         if (!var4 && this.currentMapArea0.containsCoord(var2.plane, var2.x, var2.y)) {
            this.jump(var2.plane, var2.x, var2.y);
         } else {
            this.jump(var3.plane, var3.x, var3.y);
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1094346962"
   )
   @Export("jump")
   void jump(int var1, int var2, int var3) {
      if (this.currentMapArea0 != null) {
         int[] var4 = this.currentMapArea0.position(var1, var2, var3);
         if (var4 == null) {
            var4 = this.currentMapArea0.position(this.currentMapArea0.originPlane(), this.currentMapArea0.originX(), this.currentMapArea0.originY());
         }

         this.setWorldMapPosition(var4[0] - this.currentMapArea0.minX() * 64, var4[1] - this.currentMapArea0.minY() * 64, true);
         this.worldMapTargetX = -1;
         this.worldMapTargetY = -1;
         this.zoom = this.method370(this.currentMapArea0.zoom());
         this.zoomTarget = this.zoom;
         this.field1009 = null;
         this.iconIterator = null;
         this.worldMapManager.clearIcons();
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-288419793"
   )
   @Export("draw")
   public void draw(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.Rasterizer2D_getClipArray(var6);
      Rasterizer2D.Rasterizer2D_setClip(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      int var7 = this.cacheLoader.percentLoaded();
      if (var7 < 100) {
         this.drawLoading(var1, var2, var3, var4, var7);
      } else {
         if (!this.worldMapManager.isLoaded()) {
            this.worldMapManager.load(this.field989, this.currentMapArea0.archiveName(), Client.isMembersWorld);
            if (!this.worldMapManager.isLoaded()) {
               return;
            }
         }

         if (this.flashingElements != null) {
            ++this.field996;
            if (this.field996 % this.field994 == 0) {
               this.field996 = 0;
               ++this.field995;
            }

            if (this.field995 >= this.field993 && !this.perpetualFlash0) {
               this.flashingElements = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.zoom));
         int var9 = (int)Math.ceil((double)((float)var4 / this.zoom));
         this.worldMapManager.method401(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, var1, var2, var3 + var1, var2 + var4);
         if (!this.elementsDisabled) {
            boolean var10 = false;
            if (var5 - this.field1007 > 100) {
               this.field1007 = var5;
               var10 = true;
            }

            this.worldMapManager.method402(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, var1, var2, var3 + var1, var2 + var4, this.field1006, this.flashingElements, this.field996, this.field994, var10);
         }

         this.method369(var1, var2, var3, var4, var8, var9);
         if (FriendSystem.jmodCheck() && this.showCoord && this.mouseCoord != null) {
            this.font.draw("Coord: " + this.mouseCoord, Rasterizer2D.Rasterizer2D_xClipStart + 10, Rasterizer2D.Rasterizer2D_yClipStart + 20, 16776960, -1);
         }

         this.worldMapDisplayWidth = var8;
         this.worldMapDisplayHeight = var9;
         this.worldMapDisplayX = var1;
         this.worldMapDisplayY = var2;
         Rasterizer2D.Rasterizer2D_setClipArray(var6);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIII)Z",
      garbageValue = "-1561237851"
   )
   boolean method368(int var1, int var2, int var3, int var4, int var5, int var6) {
      return this.sprite == null ? true : (this.sprite.subWidth == var1 && this.sprite.subHeight == var2 ? (this.worldMapManager.field1050 != this.field1011 ? true : (this.field1014 != Client.field104 ? true : (var3 <= 0 && var4 <= 0 ? var3 + var1 < var5 || var2 + var4 < var6 : true))) : true);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-2090965249"
   )
   void method369(int var1, int var2, int var3, int var4, int var5, int var6) {
      if (ClientParameter.field3645 != null) {
         int var7 = 512 / (this.worldMapManager.field1050 * 2);
         int var8 = var3 + 512;
         int var9 = var4 + 512;
         float var10 = 1.0F;
         var8 = (int)((float)var8 / var10);
         var9 = (int)((float)var9 / var10);
         int var11 = this.method374() - var5 / 2 - var7;
         int var12 = this.method375() - var6 / 2 - var7;
         int var13 = var1 - (var7 + var11 - this.field1012) * this.worldMapManager.field1050;
         int var14 = var2 - this.worldMapManager.field1050 * (var7 - (var12 - this.field1013));
         if (this.method368(var8, var9, var13, var14, var3, var4)) {
            if (this.sprite != null && this.sprite.subWidth == var8 && this.sprite.subHeight == var9) {
               Arrays.fill(this.sprite.pixels, 0);
            } else {
               this.sprite = new Sprite(var8, var9);
            }

            this.field1012 = this.method374() - var5 / 2 - var7;
            this.field1013 = this.method375() - var6 / 2 - var7;
            this.field1011 = this.worldMapManager.field1050;
            ClientParameter.field3645.method4720(this.field1012, this.field1013, this.sprite, (float)this.field1011 / var10);
            this.field1014 = Client.field104;
            var13 = var1 - (var11 + var7 - this.field1012) * this.worldMapManager.field1050;
            var14 = var2 - this.worldMapManager.field1050 * (var7 - (var12 - this.field1013));
         }

         Rasterizer2D.Rasterizer2D_fillRectangleAlpha(var1, var2, var3, var4, 0, 128);
         if (1.0F == var10) {
            this.sprite.method312(var13, var14, 192);
         } else {
            this.sprite.method313(var13, var14, (int)(var10 * (float)var8), (int)((float)var9 * var10), 192);
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-84"
   )
   @Export("drawOverview")
   public void drawOverview(int var1, int var2, int var3, int var4) {
      if (this.cacheLoader.isLoaded()) {
         if (!this.worldMapManager.isLoaded()) {
            this.worldMapManager.load(this.field989, this.currentMapArea0.archiveName(), Client.isMembersWorld);
            if (!this.worldMapManager.isLoaded()) {
               return;
            }
         }

         this.worldMapManager.drawOverview(var1, var2, var3, var4, this.flashingElements, this.field996, this.field994);
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "328502073"
   )
   @Export("setZoomLevel")
   public void setZoomLevel(int var1) {
      this.zoomTarget = this.method370(var1);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "126"
   )
   @Export("drawLoading")
   void drawLoading(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      Rasterizer2D.Rasterizer2D_drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.Rasterizer2D_fillRectangle(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.font.drawCentered("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IB)F",
      garbageValue = "56"
   )
   float method370(int var1) {
      return var1 == 25 ? 1.0F : (var1 == 37 ? 1.5F : (var1 == 50 ? 2.0F : (var1 == 75 ? 3.0F : (var1 == 100 ? 4.0F : 8.0F))));
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-80"
   )
   @Export("getZoomLevel")
   public int getZoomLevel() {
      return (double)this.zoomTarget == 1.0D ? 25 : ((double)this.zoomTarget == 1.5D ? 37 : (2.0D == (double)this.zoomTarget ? 50 : (3.0D == (double)this.zoomTarget ? 75 : (4.0D == (double)this.zoomTarget ? 100 : 200))));
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-50"
   )
   @Export("loadCache")
   public void loadCache() {
      this.cacheLoader.load();
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "3411"
   )
   @Export("isCacheLoaded")
   public boolean isCacheLoaded() {
      return this.cacheLoader.isLoaded();
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)Lag;",
      garbageValue = "-1453627706"
   )
   @Export("getMapArea")
   public WorldMapArea getMapArea(int var1) {
      Iterator var2 = this.mapAreas.values().iterator();

      while (var2.hasNext()) {
         WorldMapArea var3 = (WorldMapArea)var2.next();
         if (var3.id() == var1) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1820000123"
   )
   @Export("setWorldMapPositionTarget")
   public void setWorldMapPositionTarget(int var1, int var2) {
      if (this.currentMapArea0 != null && this.currentMapArea0.containsPosition(var1, var2)) {
         this.worldMapTargetX = var1 - this.currentMapArea0.minX() * 64;
         this.worldMapTargetY = var2 - this.currentMapArea0.minY() * 64;
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2147142500"
   )
   public void method371(int var1, int var2) {
      if (this.currentMapArea0 != null) {
         this.setWorldMapPosition(var1 - this.currentMapArea0.minX() * 64, var2 - this.currentMapArea0.minY() * 64, true);
         this.worldMapTargetX = -1;
         this.worldMapTargetY = -1;
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-40"
   )
   public void method372(int var1, int var2, int var3) {
      if (this.currentMapArea0 != null) {
         int[] var4 = this.currentMapArea0.position(var1, var2, var3);
         if (var4 != null) {
            this.setWorldMapPositionTarget(var4[0], var4[1]);
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1808854561"
   )
   public void method373(int var1, int var2, int var3) {
      if (this.currentMapArea0 != null) {
         int[] var4 = this.currentMapArea0.position(var1, var2, var3);
         if (var4 != null) {
            this.method371(var4[0], var4[1]);
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-659556919"
   )
   public int method374() {
      return this.currentMapArea0 == null ? -1 : this.worldMapX + this.currentMapArea0.minX() * 64;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1893257871"
   )
   public int method375() {
      return this.currentMapArea0 == null ? -1 : this.worldMapY + this.currentMapArea0.minY() * 64;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)Lhu;",
      garbageValue = "-2005824064"
   )
   public TileLocation method376() {
      return this.currentMapArea0 == null ? null : this.currentMapArea0.coord(this.method374(), this.method375());
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "442119278"
   )
   public int method377() {
      return this.worldMapDisplayWidth;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2065910749"
   )
   public int method378() {
      return this.worldMapDisplayHeight;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2017050927"
   )
   public void method379(int var1) {
      if (var1 >= 1) {
         this.field993 = var1;
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1568631080"
   )
   public void method380() {
      this.field993 = 3;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "107295139"
   )
   public void method381(int var1) {
      if (var1 >= 1) {
         this.field994 = var1;
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2023118274"
   )
   public void method382() {
      this.field994 = 50;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1025207933"
   )
   @Export("perpetualFlash")
   public void perpetualFlash(boolean var1) {
      this.perpetualFlash0 = var1;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "509924675"
   )
   @Export("flashElement")
   public void flashElement(int var1) {
      this.flashingElements = new HashSet();
      this.flashingElements.add(var1);
      this.field995 = 0;
      this.field996 = 0;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-21"
   )
   @Export("flashCategory")
   public void flashCategory(int var1) {
      this.flashingElements = new HashSet();
      this.field995 = 0;
      this.field996 = 0;

      for (int var2 = 0; var2 < UserComparator4.WorldMapElement_count; ++var2) {
         if (ViewportMouse.getWorldMapElement(var2) != null && ViewportMouse.getWorldMapElement(var2).category == var1) {
            this.flashingElements.add(ViewportMouse.getWorldMapElement(var2).field1020);
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1011326291"
   )
   @Export("stopCurrentFlashes")
   public void stopCurrentFlashes() {
      this.flashingElements = null;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "179561693"
   )
   @Export("setElementsEnabled")
   public void setElementsEnabled(boolean var1) {
      this.elementsDisabled = !var1;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-853551606"
   )
   @Export("disableElement")
   public void disableElement(int var1, boolean var2) {
      if (!var2) {
         this.enabledElements.add(var1);
      } else {
         this.enabledElements.remove(var1);
      }

      this.method383();
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "128396492"
   )
   @Export("disableCategory")
   public void disableCategory(int var1, boolean var2) {
      if (!var2) {
         this.enabledCategories.add(var1);
      } else {
         this.enabledCategories.remove(var1);
      }

      for (int var3 = 0; var3 < UserComparator4.WorldMapElement_count; ++var3) {
         if (ViewportMouse.getWorldMapElement(var3) != null && ViewportMouse.getWorldMapElement(var3).category == var1) {
            int var4 = ViewportMouse.getWorldMapElement(var3).field1020;
            if (!var2) {
               this.field1005.add(var4);
            } else {
               this.field1005.remove(var4);
            }
         }
      }

      this.method383();
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "107"
   )
   @Export("getElementsEnabled")
   public boolean getElementsEnabled() {
      return !this.elementsDisabled;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   @Export("isElementDisabled")
   public boolean isElementDisabled(int var1) {
      return !this.enabledElements.contains(var1);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-758200752"
   )
   @Export("isCategoryDisabled")
   public boolean isCategoryDisabled(int var1) {
      return !this.enabledCategories.contains(var1);
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "758731634"
   )
   void method383() {
      this.field1006.clear();
      this.field1006.addAll(this.enabledElements);
      this.field1006.addAll(this.field1005);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-73"
   )
   public void method384(int var1, int var2, int var3, int var4, int var5, int var6) {
      if (this.cacheLoader.isLoaded()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.zoom));
         int var8 = (int)Math.ceil((double)((float)var4 / this.zoom));
         List var9 = this.worldMapManager.method403(this.worldMapX - var7 / 2 - 1, this.worldMapY - var8 / 2 - 1, var7 / 2 + this.worldMapX + 1, var8 / 2 + this.worldMapY + 1, var1, var2, var3, var4, var5, var6);
         if (!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var11;
            do {
               if (!var10.hasNext()) {
                  return;
               }

               AbstractWorldMapIcon var12 = (AbstractWorldMapIcon)var10.next();
               WorldMapElement var13 = ViewportMouse.getWorldMapElement(var12.vmethod395());
               var11 = false;

               for (int var14 = this.field1008.length - 1; var14 >= 0; --var14) {
                  if (var13.strings[var14] != null) {
                     Tiles.insertMenuItemNoShift(var13.strings[var14], var13.string1, this.field1008[var14], var12.vmethod395(), var12.coord1.packed(), var12.coord2.packed());
                     var11 = true;
                  }
               }
            } while(!var11);
         }
      }

   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(ILhu;I)Lhu;",
      garbageValue = "333454230"
   )
   public TileLocation method385(int var1, TileLocation var2) {
      if (!this.cacheLoader.isLoaded()) {
         return null;
      } else if (!this.worldMapManager.isLoaded()) {
         return null;
      } else if (!this.currentMapArea0.containsPosition(var2.x, var2.y)) {
         return null;
      } else {
         HashMap var3 = this.worldMapManager.buildIcons();
         List var4 = (List)var3.get(var1);
         if (var4 != null && !var4.isEmpty()) {
            AbstractWorldMapIcon var5 = null;
            int var6 = -1;
            Iterator var7 = var4.iterator();

            while (var7.hasNext()) {
               AbstractWorldMapIcon var8 = (AbstractWorldMapIcon)var7.next();
               int var10 = var8.coord2.x - var2.x;
               int var11 = var8.coord2.y - var2.y;
               int var9 = var11 * var11 + var10 * var10;
               if (var9 == 0) {
                  return var8.coord2;
               }

               if (var9 < var6 || var5 == null) {
                  var5 = var8;
                  var6 = var9;
               }
            }

            return var5.coord2;
         } else {
            return null;
         }
      }
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IILhu;Lhu;B)V",
      garbageValue = "94"
   )
   @Export("menuAction")
   public void menuAction(int var1, int var2, TileLocation var3, TileLocation var4) {
      ScriptEvent var5 = new ScriptEvent();
      WorldMapEvent var6 = new WorldMapEvent(var2, var3, var4);
      var5.setArgs(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.setType(10);
         break;
      case 1009:
         var5.setType(11);
         break;
      case 1010:
         var5.setType(12);
         break;
      case 1011:
         var5.setType(13);
         break;
      case 1012:
         var5.setType(14);
      }

      AbstractIndexCache.runScript(var5);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I)Lak;",
      garbageValue = "593642556"
   )
   @Export("iconStart")
   public AbstractWorldMapIcon iconStart() {
      if (!this.cacheLoader.isLoaded()) {
         return null;
      } else if (!this.worldMapManager.isLoaded()) {
         return null;
      } else {
         HashMap var1 = this.worldMapManager.buildIcons();
         this.field1009 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while (var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field1009.addAll(var3);
         }

         this.iconIterator = this.field1009.iterator();
         return this.iconNext();
      }
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(B)Lak;",
      garbageValue = "24"
   )
   @Export("iconNext")
   public AbstractWorldMapIcon iconNext() {
      if (this.iconIterator == null) {
         return null;
      } else {
         while (this.iconIterator.hasNext()) {
            AbstractWorldMapIcon var1 = (AbstractWorldMapIcon)this.iconIterator.next();
            if (var1.vmethod395() != -1) {
               return var1;
            }
         }

         return null;
      }
   }

   static {
      fontNameVerdana11 = FontName.FontName_verdana11;
      fontNameVerdana13 = FontName.FontName_verdana13;
      fontNameVerdana15 = FontName.FontName_verdana15;
   }
}
