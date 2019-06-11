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
   @Export("__g")
   AbstractIndexCache __g;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__l")
   AbstractIndexCache __l;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__e")
   AbstractIndexCache __e;
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
   @Export("__t")
   WorldMapArea __t;
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
   @Export("__aq")
   int __aq;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1140942239
   )
   @Export("__aj")
   int __aj;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1301477687
   )
   @Export("__av")
   int __av;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -298919797
   )
   @Export("__ar")
   int __ar;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1653084915
   )
   @Export("__ac")
   int __ac;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1664740569
   )
   @Export("__ay")
   int __ay;
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
   @Export("__aw")
   int __aw;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 2064651113
   )
   @Export("__al")
   int __al;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1979665983
   )
   @Export("__ab")
   int __ab;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 547126547
   )
   @Export("__ae")
   int __ae;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -815748997
   )
   @Export("__at")
   int __at;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -988933407
   )
   @Export("__ad")
   int __ad;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      longValue = -4747643242047040283L
   )
   @Export("__ap")
   long __ap;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -969094439
   )
   @Export("__as")
   int __as;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -869889187
   )
   @Export("__am")
   int __am;
   @ObfuscatedName("an")
   @Export("__an")
   boolean __an;
   @ObfuscatedName("ao")
   @Export("enabledElements")
   HashSet enabledElements;
   @ObfuscatedName("aa")
   @Export("enabledCategories")
   HashSet enabledCategories;
   @ObfuscatedName("ax")
   @Export("__ax")
   HashSet __ax;
   @ObfuscatedName("af")
   @Export("__af")
   HashSet __af;
   @ObfuscatedName("ai")
   @Export("elementsDisabled")
   boolean elementsDisabled;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -237734529
   )
   @Export("__ba")
   int __ba;
   @ObfuscatedName("bs")
   @Export("__bs")
   final int[] __bs;
   @ObfuscatedName("bq")
   @Export("__bq")
   List __bq;
   @ObfuscatedName("bn")
   @Export("iconIterator")
   Iterator iconIterator;
   @ObfuscatedName("bk")
   @Export("__bk")
   HashSet __bk;
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
   @Export("__bx")
   int __bx;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 754899959
   )
   @Export("__by")
   int __by;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 2064728623
   )
   @Export("__bu")
   int __bu;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1774424249
   )
   @Export("__bm")
   int __bm;

   static {
      fontNameVerdana11 = FontName.FontName_verdana11;
      fontNameVerdana13 = FontName.FontName_verdana13;
      fontNameVerdana15 = FontName.FontName_verdana15;
   }

   public WorldMap() {
      this.worldMapTargetX = -1;
      this.worldMapTargetY = -1;
      this.__aq = -1;
      this.__aj = -1;
      this.__av = -1;
      this.__ar = -1;
      this.__ac = 3;
      this.__ay = 50;
      this.perpetualFlash0 = false;
      this.flashingElements = null;
      this.__aw = -1;
      this.__al = -1;
      this.__ab = -1;
      this.__ae = -1;
      this.__at = -1;
      this.__ad = -1;
      this.__an = true;
      this.enabledElements = new HashSet();
      this.enabledCategories = new HashSet();
      this.__ax = new HashSet();
      this.__af = new HashSet();
      this.elementsDisabled = false;
      this.__ba = 0;
      this.__bs = new int[]{1008, 1009, 1010, 1011, 1012};
      this.__bk = new HashSet();
      this.mouseCoord = null;
      this.showCoord = false;
      this.__by = -1;
      this.__bu = -1;
      this.__bm = -1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;Lir;Lkk;Ljava/util/HashMap;[Llq;I)V",
      garbageValue = "1887817097"
   )
   @Export("init")
   public void init(AbstractIndexCache var1, AbstractIndexCache var2, AbstractIndexCache var3, Font var4, HashMap var5, IndexedSprite[] var6) {
      this.mapSceneSprites = var6;
      this.__g = var1;
      this.__l = var2;
      this.__e = var3;
      this.font = var4;
      this.fonts = new HashMap();
      this.fonts.put(WorldMapLabelSize.WorldMapLabelSize_small, var5.get(fontNameVerdana11));
      this.fonts.put(WorldMapLabelSize.WorldMapLabelSize_medium, var5.get(fontNameVerdana13));
      this.fonts.put(WorldMapLabelSize.WorldMapLabelSize_large, var5.get(fontNameVerdana15));
      this.cacheLoader = new WorldMapIndexCacheLoader(var1);
      int var7 = this.__g.getArchiveId(WorldMapCacheName.WorldMapCacheName_details.name);
      int[] var8 = this.__g.__j_395(var7);
      this.mapAreas = new HashMap(var8.length);

      for(int var9 = 0; var9 < var8.length; ++var9) {
         Buffer var10 = new Buffer(this.__g.takeRecord(var7, var8[var9]));
         WorldMapArea var11 = new WorldMapArea();
         var11.read(var10, var8[var9]);
         this.mapAreas.put(var11.archiveName(), var11);
         if(var11.isMain()) {
            this.mainMapArea = var11;
         }
      }

      this.setCurrentMapArea(this.mainMapArea);
      this.__t = null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1144390092"
   )
   @Export("__f_518")
   public void __f_518() {
      WorldMapRegion.__av_o.demote(5);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIZIIIIB)V",
      garbageValue = "-35"
   )
   @Export("onCycle")
   public void onCycle(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.cacheLoader.isLoaded()) {
         this.smoothZoom();
         this.__g_521();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.zoom));
            int var9 = (int)Math.ceil((double)((float)var7 / this.zoom));
            List var10 = this.worldMapManager.__u_74(this.worldMapX - var8 / 2 - 1, this.worldMapY - var9 / 2 - 1, var8 / 2 + this.worldMapX + 1, var9 / 2 + this.worldMapY + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            AbstractWorldMapIcon var13;
            ScriptEvent var14;
            WorldMapEvent var15;
            for(var12 = var10.iterator(); var12.hasNext(); AbstractIndexCache.runScript(var14)) {
               var13 = (AbstractWorldMapIcon)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new WorldMapEvent(var13.__m_15(), var13.coord1, var13.coord2);
               var14.setArgs(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.__bk.contains(var13)) {
                  var14.setType(17);
               } else {
                  var14.setType(15);
               }
            }

            var12 = this.__bk.iterator();

            while(var12.hasNext()) {
               var13 = (AbstractWorldMapIcon)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new WorldMapEvent(var13.__m_15(), var13.coord1, var13.coord2);
                  var14.setArgs(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.setType(16);
                  AbstractIndexCache.runScript(var14);
               }
            }

            this.__bk = var11;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIZZS)V",
      garbageValue = "18431"
   )
   @Export("__w_519")
   public void __w_519(int var1, int var2, boolean var3, boolean var4) {
      long var5 = class203.currentTimeMs();
      this.__o_520(var1, var2, var4, var5);
      if(!this.__x_524() && (var4 || var3)) {
         if(var4) {
            this.__at = var1;
            this.__ad = var2;
            this.__ab = this.worldMapX;
            this.__ae = this.worldMapY;
         }

         if(this.__ab != -1) {
            int var7 = var1 - this.__at;
            int var8 = var2 - this.__ad;
            this.setWorldMapPosition(this.__ab - (int)((float)var7 / this.zoomTarget), (int)((float)var8 / this.zoomTarget) + this.__ae, false);
         }
      } else {
         this.__e_523();
      }

      if(var4) {
         this.__ap = var5;
         this.__as = var1;
         this.__am = var2;
      }

   }

   @ObfuscatedName("o")
   @Export("__o_520")
   void __o_520(int var1, int var2, boolean var3, long var4) {
      if(this.currentMapArea0 != null) {
         int var6 = (int)((float)this.worldMapX + ((float)(var1 - this.__av) - (float)this.__ap_537() * this.zoom / 2.0F) / this.zoom);
         int var7 = (int)((float)this.worldMapY - ((float)(var2 - this.__ar) - (float)this.__as_538() * this.zoom / 2.0F) / this.zoom);
         this.mouseCoord = this.currentMapArea0.coord(var6 + this.currentMapArea0.minX() * 64, var7 + this.currentMapArea0.minY() * 64);
         if(this.mouseCoord != null && var3) {
            int var9;
            int var10;
            if(FriendSystem.jmodCheck() && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81]) {
               int var13 = this.mouseCoord.x;
               var9 = this.mouseCoord.y;
               var10 = this.mouseCoord.plane;
               PacketBufferNode var11 = Interpreter.method1915(ClientPacket.__gs_bx, Client.packetWriter.isaacCipher);
               var11.packetBuffer.writeIntME(0);
               var11.packetBuffer.writeShortLE(var9);
               var11.packetBuffer.__ai_315(var10);
               var11.packetBuffer.writeShort(var13);
               Client.packetWriter.__q_167(var11);
            } else {
               boolean var8 = true;
               if(this.__an) {
                  var9 = var1 - this.__as;
                  var10 = var2 - this.__am;
                  if(var4 - this.__ap > 500L || var9 < -25 || var9 > 25 || var10 < -25 || var10 > 25) {
                     var8 = false;
                  }
               }

               if(var8) {
                  PacketBufferNode var12 = Interpreter.method1915(ClientPacket.__gs_az, Client.packetWriter.isaacCipher);
                  var12.packetBuffer.writeIntME(this.mouseCoord.packed());
                  Client.packetWriter.__q_167(var12);
                  this.__ap = 0L;
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
      if(ClientParameter.field3645 != null) {
         this.zoom = this.zoomTarget;
      } else {
         if(this.zoom < this.zoomTarget) {
            this.zoom = Math.min(this.zoomTarget, this.zoom / 30.0F + this.zoom);
         }

         if(this.zoom > this.zoomTarget) {
            this.zoom = Math.max(this.zoomTarget, this.zoom - this.zoom / 30.0F);
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2075446341"
   )
   @Export("__g_521")
   void __g_521() {
      if(this.__x_524()) {
         int var1 = this.worldMapTargetX - this.worldMapX;
         int var2 = this.worldMapTargetY - this.worldMapY;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.setWorldMapPosition(var1 + this.worldMapX, var2 + this.worldMapY, true);
         if(this.worldMapTargetX == this.worldMapX && this.worldMapTargetY == this.worldMapY) {
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
      if(var3) {
         this.__e_523();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "35"
   )
   @Export("__e_523")
   final void __e_523() {
      this.__ad = -1;
      this.__at = -1;
      this.__ae = -1;
      this.__ab = -1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1444745621"
   )
   @Export("__x_524")
   boolean __x_524() {
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

      WorldMapArea var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapArea)var4.next();
      } while(!var5.containsCoord(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "469045892"
   )
   @Export("__a_525")
   public void __a_525(int var1, int var2, int var3, boolean var4) {
      WorldMapArea var5 = this.mapAreaAtCoord(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.mainMapArea;
      }

      boolean var6 = false;
      if(var5 != this.__t || var4) {
         this.__t = var5;
         this.setCurrentMapArea(var5);
         var6 = true;
      }

      if(var6 || var4) {
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
      if(var2 != null) {
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
      return this.currentMapArea0 == null?-1:this.currentMapArea0.id();
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
      if(this.currentMapArea0 == null || var1 != this.currentMapArea0) {
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
      this.worldMapManager = new WorldMapManager(this.mapSceneSprites, this.fonts, this.__l, this.__e);
      this.cacheLoader.reset(this.currentMapArea0.archiveName());
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lag;Lhu;Lhu;ZI)V",
      garbageValue = "-1430939646"
   )
   @Export("__h_526")
   public void __h_526(WorldMapArea var1, TileLocation var2, TileLocation var3, boolean var4) {
      if(var1 != null) {
         if(this.currentMapArea0 == null || var1 != this.currentMapArea0) {
            this.initializeWorldMap(var1);
         }

         if(!var4 && this.currentMapArea0.containsCoord(var2.plane, var2.x, var2.y)) {
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
      if(this.currentMapArea0 != null) {
         int[] var4 = this.currentMapArea0.position(var1, var2, var3);
         if(var4 == null) {
            var4 = this.currentMapArea0.position(this.currentMapArea0.originPlane(), this.currentMapArea0.originX(), this.currentMapArea0.originY());
         }

         this.setWorldMapPosition(var4[0] - this.currentMapArea0.minX() * 64, var4[1] - this.currentMapArea0.minY() * 64, true);
         this.worldMapTargetX = -1;
         this.worldMapTargetY = -1;
         this.zoom = this.__av_529(this.currentMapArea0.zoom());
         this.zoomTarget = this.zoom;
         this.__bq = null;
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
      if(var7 < 100) {
         this.drawLoading(var1, var2, var3, var4, var7);
      } else {
         if(!this.worldMapManager.isLoaded()) {
            this.worldMapManager.load(this.__g, this.currentMapArea0.archiveName(), Client.isMembersWorld);
            if(!this.worldMapManager.isLoaded()) {
               return;
            }
         }

         if(this.flashingElements != null) {
            ++this.__al;
            if(this.__al % this.__ay == 0) {
               this.__al = 0;
               ++this.__aw;
            }

            if(this.__aw >= this.__ac && !this.perpetualFlash0) {
               this.flashingElements = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.zoom));
         int var9 = (int)Math.ceil((double)((float)var4 / this.zoom));
         this.worldMapManager.__q_72(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, var1, var2, var3 + var1, var2 + var4);
         if(!this.elementsDisabled) {
            boolean var10 = false;
            if(var5 - this.__ba > 100) {
               this.__ba = var5;
               var10 = true;
            }

            this.worldMapManager.__w_73(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, var1, var2, var3 + var1, var2 + var4, this.__af, this.flashingElements, this.__al, this.__ay, var10);
         }

         this.__v_528(var1, var2, var3, var4, var8, var9);
         if(FriendSystem.jmodCheck() && this.showCoord && this.mouseCoord != null) {
            this.font.draw("Coord: " + this.mouseCoord, Rasterizer2D.Rasterizer2D_xClipStart + 10, Rasterizer2D.Rasterizer2D_yClipStart + 20, 16776960, -1);
         }

         this.__aq = var8;
         this.__aj = var9;
         this.__av = var1;
         this.__ar = var2;
         Rasterizer2D.Rasterizer2D_setClipArray(var6);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIII)Z",
      garbageValue = "-1561237851"
   )
   @Export("__p_527")
   boolean __p_527(int var1, int var2, int var3, int var4, int var5, int var6) {
      return this.sprite == null?true:(this.sprite.subWidth == var1 && this.sprite.subHeight == var2?(this.worldMapManager.__z != this.__bx?true:(this.__bm != Client.__client_ss?true:(var3 <= 0 && var4 <= 0?var3 + var1 < var5 || var2 + var4 < var6:true))):true);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-2090965249"
   )
   @Export("__v_528")
   void __v_528(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(ClientParameter.field3645 != null) {
         int var7 = 512 / (this.worldMapManager.__z * 2);
         int var8 = var3 + 512;
         int var9 = var4 + 512;
         float var10 = 1.0F;
         var8 = (int)((float)var8 / var10);
         var9 = (int)((float)var9 / var10);
         int var11 = this.__ae_534() - var5 / 2 - var7;
         int var12 = this.__at_535() - var6 / 2 - var7;
         int var13 = var1 - (var7 + var11 - this.__by) * this.worldMapManager.__z;
         int var14 = var2 - this.worldMapManager.__z * (var7 - (var12 - this.__bu));
         if(this.__p_527(var8, var9, var13, var14, var3, var4)) {
            if(this.sprite != null && this.sprite.subWidth == var8 && this.sprite.subHeight == var9) {
               Arrays.fill(this.sprite.pixels, 0);
            } else {
               this.sprite = new Sprite(var8, var9);
            }

            this.__by = this.__ae_534() - var5 / 2 - var7;
            this.__bu = this.__at_535() - var6 / 2 - var7;
            this.__bx = this.worldMapManager.__z;
            ClientParameter.field3645.method4720(this.__by, this.__bu, this.sprite, (float)this.__bx / var10);
            this.__bm = Client.__client_ss;
            var13 = var1 - (var11 + var7 - this.__by) * this.worldMapManager.__z;
            var14 = var2 - this.worldMapManager.__z * (var7 - (var12 - this.__bu));
         }

         Rasterizer2D.Rasterizer2D_moreAlpha(var1, var2, var3, var4, 0, 128);
         if(1.0F == var10) {
            this.sprite.__v_510(var13, var14, 192);
         } else {
            this.sprite.__aj_511(var13, var14, (int)(var10 * (float)var8), (int)((float)var9 * var10), 192);
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
      if(this.cacheLoader.isLoaded()) {
         if(!this.worldMapManager.isLoaded()) {
            this.worldMapManager.load(this.__g, this.currentMapArea0.archiveName(), Client.isMembersWorld);
            if(!this.worldMapManager.isLoaded()) {
               return;
            }
         }

         this.worldMapManager.drawOverview(var1, var2, var3, var4, this.flashingElements, this.__al, this.__ay);
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "328502073"
   )
   @Export("setZoomLevel")
   public void setZoomLevel(int var1) {
      this.zoomTarget = this.__av_529(var1);
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
   @Export("__av_529")
   float __av_529(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-80"
   )
   @Export("getZoomLevel")
   public int getZoomLevel() {
      return (double)this.zoomTarget == 1.0D?25:((double)this.zoomTarget == 1.5D?37:(2.0D == (double)this.zoomTarget?50:(3.0D == (double)this.zoomTarget?75:(4.0D == (double)this.zoomTarget?100:200))));
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

      WorldMapArea var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapArea)var2.next();
      } while(var3.id() != var1);

      return var3;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1820000123"
   )
   @Export("setWorldMapPositionTarget")
   public void setWorldMapPositionTarget(int var1, int var2) {
      if(this.currentMapArea0 != null && this.currentMapArea0.containsPosition(var1, var2)) {
         this.worldMapTargetX = var1 - this.currentMapArea0.minX() * 64;
         this.worldMapTargetY = var2 - this.currentMapArea0.minY() * 64;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2147142500"
   )
   @Export("__aw_531")
   public void __aw_531(int var1, int var2) {
      if(this.currentMapArea0 != null) {
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
   @Export("__al_532")
   public void __al_532(int var1, int var2, int var3) {
      if(this.currentMapArea0 != null) {
         int[] var4 = this.currentMapArea0.position(var1, var2, var3);
         if(var4 != null) {
            this.setWorldMapPositionTarget(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1808854561"
   )
   @Export("__ab_533")
   public void __ab_533(int var1, int var2, int var3) {
      if(this.currentMapArea0 != null) {
         int[] var4 = this.currentMapArea0.position(var1, var2, var3);
         if(var4 != null) {
            this.__aw_531(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-659556919"
   )
   @Export("__ae_534")
   public int __ae_534() {
      return this.currentMapArea0 == null?-1:this.worldMapX + this.currentMapArea0.minX() * 64;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1893257871"
   )
   @Export("__at_535")
   public int __at_535() {
      return this.currentMapArea0 == null?-1:this.worldMapY + this.currentMapArea0.minY() * 64;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)Lhu;",
      garbageValue = "-2005824064"
   )
   @Export("__ad_536")
   public TileLocation __ad_536() {
      return this.currentMapArea0 == null?null:this.currentMapArea0.coord(this.__ae_534(), this.__at_535());
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "442119278"
   )
   @Export("__ap_537")
   public int __ap_537() {
      return this.__aq;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2065910749"
   )
   @Export("__as_538")
   public int __as_538() {
      return this.__aj;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2017050927"
   )
   @Export("__am_539")
   public void __am_539(int var1) {
      if(var1 >= 1) {
         this.__ac = var1;
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1568631080"
   )
   @Export("__an_540")
   public void __an_540() {
      this.__ac = 3;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "107295139"
   )
   @Export("__az_541")
   public void __az_541(int var1) {
      if(var1 >= 1) {
         this.__ay = var1;
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2023118274"
   )
   @Export("__au_542")
   public void __au_542() {
      this.__ay = 50;
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
      this.flashingElements.add(Integer.valueOf(var1));
      this.__aw = 0;
      this.__al = 0;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-21"
   )
   @Export("flashCategory")
   public void flashCategory(int var1) {
      this.flashingElements = new HashSet();
      this.__aw = 0;
      this.__al = 0;

      for(int var2 = 0; var2 < UserComparator4.WorldMapElement_count; ++var2) {
         if(ViewportMouse.getWorldMapElement(var2) != null && ViewportMouse.getWorldMapElement(var2).category == var1) {
            this.flashingElements.add(Integer.valueOf(ViewportMouse.getWorldMapElement(var2).__o));
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
      if(!var2) {
         this.enabledElements.add(Integer.valueOf(var1));
      } else {
         this.enabledElements.remove(Integer.valueOf(var1));
      }

      this.__bk_543();
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "128396492"
   )
   @Export("disableCategory")
   public void disableCategory(int var1, boolean var2) {
      if(!var2) {
         this.enabledCategories.add(Integer.valueOf(var1));
      } else {
         this.enabledCategories.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < UserComparator4.WorldMapElement_count; ++var3) {
         if(ViewportMouse.getWorldMapElement(var3) != null && ViewportMouse.getWorldMapElement(var3).category == var1) {
            int var4 = ViewportMouse.getWorldMapElement(var3).__o;
            if(!var2) {
               this.__ax.add(Integer.valueOf(var4));
            } else {
               this.__ax.remove(Integer.valueOf(var4));
            }
         }
      }

      this.__bk_543();
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
      return !this.enabledElements.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-758200752"
   )
   @Export("isCategoryDisabled")
   public boolean isCategoryDisabled(int var1) {
      return !this.enabledCategories.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "758731634"
   )
   @Export("__bk_543")
   void __bk_543() {
      this.__af.clear();
      this.__af.addAll(this.enabledElements);
      this.__af.addAll(this.__ax);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-73"
   )
   @Export("__bd_544")
   public void __bd_544(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.cacheLoader.isLoaded()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.zoom));
         int var8 = (int)Math.ceil((double)((float)var4 / this.zoom));
         List var9 = this.worldMapManager.__u_74(this.worldMapX - var7 / 2 - 1, this.worldMapY - var8 / 2 - 1, var7 / 2 + this.worldMapX + 1, var8 / 2 + this.worldMapY + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               AbstractWorldMapIcon var11 = (AbstractWorldMapIcon)var10.next();
               WorldMapElement var12 = ViewportMouse.getWorldMapElement(var11.__m_15());
               var13 = false;

               for(int var14 = this.__bs.length - 1; var14 >= 0; --var14) {
                  if(var12.strings[var14] != null) {
                     Tiles.method1106(var12.strings[var14], var12.string1, this.__bs[var14], var11.__m_15(), var11.coord1.packed(), var11.coord2.packed());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(ILhu;I)Lhu;",
      garbageValue = "333454230"
   )
   @Export("__bc_545")
   public TileLocation __bc_545(int var1, TileLocation var2) {
      if(!this.cacheLoader.isLoaded()) {
         return null;
      } else if(!this.worldMapManager.isLoaded()) {
         return null;
      } else if(!this.currentMapArea0.containsPosition(var2.x, var2.y)) {
         return null;
      } else {
         HashMap var3 = this.worldMapManager.buildIcons();
         List var4 = (List)var3.get(Integer.valueOf(var1));
         if(var4 != null && !var4.isEmpty()) {
            AbstractWorldMapIcon var5 = null;
            int var6 = -1;
            Iterator var7 = var4.iterator();

            while(true) {
               AbstractWorldMapIcon var8;
               int var11;
               do {
                  if(!var7.hasNext()) {
                     return var5.coord2;
                  }

                  var8 = (AbstractWorldMapIcon)var7.next();
                  int var9 = var8.coord2.x - var2.x;
                  int var10 = var8.coord2.y - var2.y;
                  var11 = var10 * var10 + var9 * var9;
                  if(var11 == 0) {
                     return var8.coord2;
                  }
               } while(var11 >= var6 && var5 != null);

               var5 = var8;
               var6 = var11;
            }
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
      if(!this.cacheLoader.isLoaded()) {
         return null;
      } else if(!this.worldMapManager.isLoaded()) {
         return null;
      } else {
         HashMap var1 = this.worldMapManager.buildIcons();
         this.__bq = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.__bq.addAll(var3);
         }

         this.iconIterator = this.__bq.iterator();
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
      if(this.iconIterator == null) {
         return null;
      } else {
         AbstractWorldMapIcon var1;
         do {
            if(!this.iconIterator.hasNext()) {
               return null;
            }

            var1 = (AbstractWorldMapIcon)this.iconIterator.next();
         } while(var1.__m_15() == -1);

         return var1;
      }
   }
}
