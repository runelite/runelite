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

@ObfuscatedName("li")
@Implements("RenderOverview")
public class RenderOverview {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lkv;"
   )
   @Export("fontNameVerdana11")
   static final FontName fontNameVerdana11;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lkv;"
   )
   @Export("fontNameVerdana13")
   static final FontName fontNameVerdana13;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lkv;"
   )
   @Export("fontNameVerdana15")
   static final FontName fontNameVerdana15;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   IndexDataBase field4012;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   Font field4055;
   @ObfuscatedName("o")
   @Export("mapFonts")
   HashMap mapFonts;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Llh;"
   )
   IndexedSprite[] field4025;
   @ObfuscatedName("r")
   @Export("worldMapDataByIdentifier")
   HashMap worldMapDataByIdentifier;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   WorldMapData field4020;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   @Export("worldMapData")
   WorldMapData worldMapData;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   WorldMapData field4022;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lah;"
   )
   @Export("worldMapManager")
   WorldMapManager worldMapManager;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   class333 field4024;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1524280783
   )
   @Export("worldMapX")
   int worldMapX;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1290490625
   )
   @Export("worldMapY")
   int worldMapY;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2143279969
   )
   @Export("worldMapTargetX")
   int worldMapTargetX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 32135313
   )
   @Export("worldMapTargetY")
   int worldMapTargetY;
   @ObfuscatedName("a")
   @Export("worldMapZoom")
   float worldMapZoom;
   @ObfuscatedName("x")
   @Export("worldMapZoomTarget")
   float worldMapZoomTarget;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -668818303
   )
   @Export("worldMapDisplayWidth")
   int worldMapDisplayWidth;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 770943119
   )
   @Export("worldMapDisplayHeight")
   int worldMapDisplayHeight;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 62508177
   )
   @Export("worldMapDisplayX")
   int worldMapDisplayX;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 54622359
   )
   @Export("worldMapDisplayY")
   int worldMapDisplayY;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 349666829
   )
   int field4035;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 421799631
   )
   int field4036;
   @ObfuscatedName("ay")
   boolean field4037;
   @ObfuscatedName("as")
   HashSet field4038;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 377643723
   )
   int field4039;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1436411621
   )
   int field4060;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 125002637
   )
   int field4041;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -269478135
   )
   int field4030;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 404031459
   )
   int field4034;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1634127807
   )
   int field4042;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      longValue = -5364072696261179111L
   )
   long field4019;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 559323289
   )
   int field4014;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 162527723
   )
   int field4047;
   @ObfuscatedName("ah")
   boolean field4048;
   @ObfuscatedName("at")
   HashSet field4049;
   @ObfuscatedName("am")
   HashSet field4050;
   @ObfuscatedName("an")
   HashSet field4051;
   @ObfuscatedName("ae")
   HashSet field4052;
   @ObfuscatedName("aw")
   boolean field4065;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 766483029
   )
   int field4054;
   @ObfuscatedName("bq")
   final int[] field4045;
   @ObfuscatedName("bi")
   List field4056;
   @ObfuscatedName("bo")
   Iterator field4057;
   @ObfuscatedName("bj")
   HashSet field4058;
   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   Coordinates field4059;
   @ObfuscatedName("bp")
   public boolean field4011;
   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   SpritePixels field4061;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -709917857
   )
   int field4046;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 1689064333
   )
   int field4063;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -181740721
   )
   int field4064;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 358686437
   )
   int field4044;

   static {
      fontNameVerdana11 = FontName.field3885;
      fontNameVerdana13 = FontName.field3886;
      fontNameVerdana15 = FontName.field3882;
   }

   public RenderOverview() {
      this.worldMapTargetX = -1;
      this.worldMapTargetY = -1;
      this.worldMapDisplayWidth = -1;
      this.worldMapDisplayHeight = -1;
      this.worldMapDisplayX = -1;
      this.worldMapDisplayY = -1;
      this.field4035 = 3;
      this.field4036 = 50;
      this.field4037 = false;
      this.field4038 = null;
      this.field4039 = -1;
      this.field4060 = -1;
      this.field4041 = -1;
      this.field4030 = -1;
      this.field4034 = -1;
      this.field4042 = -1;
      this.field4048 = true;
      this.field4049 = new HashSet();
      this.field4050 = new HashSet();
      this.field4051 = new HashSet();
      this.field4052 = new HashSet();
      this.field4065 = false;
      this.field4054 = 0;
      this.field4045 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field4058 = new HashSet();
      this.field4059 = null;
      this.field4011 = false;
      this.field4063 = -1;
      this.field4064 = -1;
      this.field4044 = -1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;Lkh;Ljava/util/HashMap;[Llh;I)V",
      garbageValue = "-302992314"
   )
   public void method6065(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field4025 = var4;
      this.field4012 = var1;
      this.field4055 = var2;
      this.mapFonts = new HashMap();
      this.mapFonts.put(Size.field365, var3.get(fontNameVerdana11));
      this.mapFonts.put(Size.field359, var3.get(fontNameVerdana13));
      this.mapFonts.put(Size.field360, var3.get(fontNameVerdana15));
      this.field4024 = new class333(var1);
      int var5 = this.field4012.getFile(MapCacheArchiveNames.DETAILS.name);
      int[] var6 = this.field4012.getChilds(var5);
      this.worldMapDataByIdentifier = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field4012.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.worldMapDataByIdentifier.put(var9.getIdentifier(), var9);
         if(var9.method358()) {
            this.field4020 = var9;
         }
      }

      this.method6081(this.field4020);
      this.field4022 = null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "968954721"
   )
   public int method6116() {
      return this.field4012.tryLoadRecordByNames(this.field4020.getIdentifier(), MapCacheArchiveNames.AREA.name)?100:this.field4012.archiveLoadPercentByName(this.field4020.getIdentifier());
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-75"
   )
   public void method6124() {
      class90.method1995();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIZIIIIB)V",
      garbageValue = "30"
   )
   public void method6068(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field4024.method6053()) {
         this.moveTowardZoomTarget();
         this.moveTowardLocationTarget();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.worldMapZoom));
            int var9 = (int)Math.ceil((double)((float)var7 / this.worldMapZoom));
            List var10 = this.worldMapManager.method601(this.worldMapX - var8 / 2 - 1, this.worldMapY - var9 / 2 - 1, var8 / 2 + this.worldMapX + 1, var9 / 2 + this.worldMapY + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            MapIcon var13;
            ScriptEvent var14;
            MapIconReference var15;
            for(var12 = var10.iterator(); var12.hasNext(); class71.method1203(var14)) {
               var13 = (MapIcon)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new MapIconReference(var13.areaId, var13.field528, var13.field522);
               var14.method1155(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field4058.contains(var13)) {
                  var14.method1154(class245.field2966);
               } else {
                  var14.method1154(class245.field2964);
               }
            }

            var12 = this.field4058.iterator();

            while(var12.hasNext()) {
               var13 = (MapIcon)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new MapIconReference(var13.areaId, var13.field528, var13.field522);
                  var14.method1155(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1154(class245.field2965);
                  class71.method1203(var14);
               }
            }

            this.field4058 = var11;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIZZI)V",
      garbageValue = "1575120628"
   )
   public void method6200(int var1, int var2, boolean var3, boolean var4) {
      long var5 = class289.method5267();
      this.method6070(var1, var2, var4, var5);
      if(!this.hasTargetPosition() && (var4 || var3)) {
         if(var4) {
            this.field4034 = var1;
            this.field4042 = var2;
            this.field4041 = this.worldMapX;
            this.field4030 = this.worldMapY;
         }

         if(this.field4041 != -1) {
            int var7 = var1 - this.field4034;
            int var8 = var2 - this.field4042;
            this.setWorldMapPosition(this.field4041 - (int)((float)var7 / this.worldMapZoomTarget), (int)((float)var8 / this.worldMapZoomTarget) + this.field4030, false);
         }
      } else {
         this.method6074();
      }

      if(var4) {
         this.field4019 = var5;
         this.field4014 = var1;
         this.field4047 = var2;
      }

   }

   @ObfuscatedName("l")
   void method6070(int var1, int var2, boolean var3, long var4) {
      if(this.worldMapData != null) {
         int var6 = (int)((float)this.worldMapX + ((float)(var1 - this.worldMapDisplayX) - (float)this.method6180() * this.worldMapZoom / 2.0F) / this.worldMapZoom);
         int var7 = (int)((float)this.worldMapY - ((float)(var2 - this.worldMapDisplayY) - (float)this.method6117() * this.worldMapZoom / 2.0F) / this.worldMapZoom);
         this.field4059 = this.worldMapData.method285(var6 + this.worldMapData.getMinX() * 64, var7 + this.worldMapData.getMinY() * 64);
         if(this.field4059 != null && var3) {
            boolean var8 = Client.rights >= 2;
            if(var8 && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81]) {
               MapIcon.method596(this.field4059.worldX, this.field4059.worldY, this.field4059.plane, false);
            } else {
               boolean var9 = true;
               if(this.field4048) {
                  int var10 = var1 - this.field4014;
                  int var11 = var2 - this.field4047;
                  if(var4 - this.field4019 > 500L || var10 < -25 || var10 > 25 || var11 < -25 || var11 > 25) {
                     var9 = false;
                  }
               }

               if(var9) {
                  PacketNode var12 = AbstractSoundSystem.method2350(ClientPacket.field2435, Client.field911.field1460);
                  var12.packetBuffer.putInt(this.field4059.bitpack());
                  Client.field911.method2135(var12);
                  this.field4019 = 0L;
               }
            }
         }
      } else {
         this.field4059 = null;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   @Export("moveTowardZoomTarget")
   void moveTowardZoomTarget() {
      if(class19.field326 != null) {
         this.worldMapZoom = this.worldMapZoomTarget;
      } else {
         if(this.worldMapZoom < this.worldMapZoomTarget) {
            this.worldMapZoom = Math.min(this.worldMapZoomTarget, this.worldMapZoom / 30.0F + this.worldMapZoom);
         }

         if(this.worldMapZoom > this.worldMapZoomTarget) {
            this.worldMapZoom = Math.max(this.worldMapZoomTarget, this.worldMapZoom - this.worldMapZoom / 30.0F);
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-76"
   )
   @Export("moveTowardLocationTarget")
   void moveTowardLocationTarget() {
      if(this.hasTargetPosition()) {
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-1363015109"
   )
   @Export("setWorldMapPosition")
   final void setWorldMapPosition(int worldMapX, int worldMapY, boolean changeSurface) {
      this.worldMapX = worldMapX;
      this.worldMapY = worldMapY;
      class289.method5267();
      if(changeSurface) {
         this.method6074();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1113993218"
   )
   final void method6074() {
      this.field4042 = -1;
      this.field4034 = -1;
      this.field4030 = -1;
      this.field4041 = -1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1580920681"
   )
   @Export("hasTargetPosition")
   boolean hasTargetPosition() {
      return this.worldMapTargetX != -1 && this.worldMapTargetY != -1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIB)Las;",
      garbageValue = "-55"
   )
   @Export("getWorldMapDataContainingCoord")
   public WorldMapData getWorldMapDataContainingCoord(int var1, int var2, int var3) {
      Iterator var4 = this.worldMapDataByIdentifier.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.containsCoord(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-340906321"
   )
   public void method6077(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.getWorldMapDataContainingCoord(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field4020;
      }

      boolean var6 = false;
      if(var5 != this.field4022 || var4) {
         this.field4022 = var5;
         this.method6081(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method6265(var1, var2, var3);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "977419984"
   )
   public void method6078(int var1) {
      WorldMapData var2 = this.getWorldMapDataByFileId(var1);
      if(var2 != null) {
         this.method6081(var2);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-55"
   )
   public int method6079() {
      return this.worldMapData == null?-1:this.worldMapData.getFileId();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Las;",
      garbageValue = "21"
   )
   public WorldMapData method6080() {
      return this.worldMapData;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Las;B)V",
      garbageValue = "-110"
   )
   void method6081(WorldMapData var1) {
      if(this.worldMapData == null || var1 != this.worldMapData) {
         this.initializeWorldMap(var1);
         this.method6265(-1, -1, -1);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "1233856408"
   )
   @Export("initializeWorldMap")
   void initializeWorldMap(WorldMapData var1) {
      this.worldMapData = var1;
      this.worldMapManager = new WorldMapManager(this.field4025, this.mapFonts);
      this.field4024.method6060(this.worldMapData.getIdentifier());
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Las;Lio;Lio;ZB)V",
      garbageValue = "-63"
   )
   public void method6103(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.worldMapData == null || var1 != this.worldMapData) {
            this.initializeWorldMap(var1);
         }

         if(!var4 && this.worldMapData.containsCoord(var2.plane, var2.worldX, var2.worldY)) {
            this.method6265(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method6265(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1615422630"
   )
   void method6265(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method354(var1, var2, var3);
         if(var4 == null) {
            var4 = this.worldMapData.method354(this.worldMapData.method298(), this.worldMapData.method297(), this.worldMapData.method299());
         }

         this.setWorldMapPosition(var4[0] - this.worldMapData.getMinX() * 64, var4[1] - this.worldMapData.getMinY() * 64, true);
         this.worldMapTargetX = -1;
         this.worldMapTargetY = -1;
         this.worldMapZoom = this.worldMapZoomPercentToFloat(this.worldMapData.getInitialMapSurfaceZoom());
         this.worldMapZoomTarget = this.worldMapZoom;
         this.field4056 = null;
         this.field4057 = null;
         this.worldMapManager.method603();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIIS)V",
      garbageValue = "4171"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int graphicsX, int graphicsY, int width, int height, int gameCycle) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(graphicsX, graphicsY, width + graphicsX, graphicsY + height);
      Rasterizer2D.Rasterizer2D_fillRectangle(graphicsX, graphicsY, width, height, -16777216);
      int var7 = this.field4024.method6051();
      if(var7 < 100) {
         this.method6090(graphicsX, graphicsY, width, height, var7);
      } else {
         if(!this.worldMapManager.getLoaded()) {
            this.worldMapManager.load(this.field4012, this.worldMapData.getIdentifier(), Client.isMembers);
            if(!this.worldMapManager.getLoaded()) {
               return;
            }
         }

         if(this.field4038 != null) {
            ++this.field4060;
            if(this.field4060 % this.field4036 == 0) {
               this.field4060 = 0;
               ++this.field4039;
            }

            if(this.field4039 >= this.field4035 && !this.field4037) {
               this.field4038 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)width / this.worldMapZoom));
         int var9 = (int)Math.ceil((double)((float)height / this.worldMapZoom));
         this.worldMapManager.drawMapRegion(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, graphicsX, graphicsY, width + graphicsX, graphicsY + height);
         boolean var10;
         if(!this.field4065) {
            var10 = false;
            if(gameCycle - this.field4054 > 100) {
               this.field4054 = gameCycle;
               var10 = true;
            }

            this.worldMapManager.drawMapIcons(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, graphicsX, graphicsY, width + graphicsX, graphicsY + height, this.field4052, this.field4038, this.field4060, this.field4036, var10);
         }

         this.method6087(graphicsX, graphicsY, width, height, var8, var9);
         var10 = Client.rights >= 2;
         if(var10 && this.field4011 && this.field4059 != null) {
            this.field4055.method5630("Coord: " + this.field4059, Rasterizer2D.draw_region_x + 10, Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
         }

         this.worldMapDisplayWidth = var8;
         this.worldMapDisplayHeight = var9;
         this.worldMapDisplayX = graphicsX;
         this.worldMapDisplayY = graphicsY;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)Z",
      garbageValue = "105"
   )
   boolean method6260(int var1, int var2, int var3, int var4, int var5, int var6) {
      return this.field4061 == null?true:(this.field4061.width == var1 && this.field4061.height == var2?(this.worldMapManager.field557 != this.field4046?true:(this.field4044 != Client.field1053?true:(var3 <= 0 && var4 <= 0?var3 + var1 < var5 || var2 + var4 < var6:true))):true);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1516132344"
   )
   void method6087(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class19.field326 != null) {
         int var7 = 512 / (this.worldMapManager.field557 * 2);
         int var8 = var3 + 512;
         int var9 = var4 + 512;
         float var10 = 1.0F;
         var8 = (int)((float)var8 / var10);
         var9 = (int)((float)var9 / var10);
         int var11 = this.method6099() - var5 / 2 - var7;
         int var12 = this.method6155() - var6 / 2 - var7;
         int var13 = var1 - (var7 + var11 - this.field4063) * this.worldMapManager.field557;
         int var14 = var2 - this.worldMapManager.field557 * (var7 - (var12 - this.field4064));
         if(this.method6260(var8, var9, var13, var14, var3, var4)) {
            if(this.field4061 != null && this.field4061.width == var8 && this.field4061.height == var9) {
               Arrays.fill(this.field4061.pixels, 0);
            } else {
               this.field4061 = new SpritePixels(var8, var9);
            }

            this.field4063 = this.method6099() - var5 / 2 - var7;
            this.field4064 = this.method6155() - var6 / 2 - var7;
            this.field4046 = this.worldMapManager.field557;
            class19.field326.method4822(this.field4063, this.field4064, this.field4061, (float)this.field4046 / var10);
            this.field4044 = Client.field1053;
            var13 = var1 - (var7 + var11 - this.field4063) * this.worldMapManager.field557;
            var14 = var2 - this.worldMapManager.field557 * (var7 - (var12 - this.field4064));
         }

         Rasterizer2D.fillRectangle(var1, var2, var3, var4, 0, 128);
         if(var10 == 1.0F) {
            this.field4061.method5925(var13, var14, 192);
         } else {
            this.field4061.method5928(var13, var14, (int)((float)var8 * var10), (int)(var10 * (float)var9), 192);
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "61"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field4024.method6053()) {
         if(!this.worldMapManager.getLoaded()) {
            this.worldMapManager.load(this.field4012, this.worldMapData.getIdentifier(), Client.isMembers);
            if(!this.worldMapManager.getLoaded()) {
               return;
            }
         }

         this.worldMapManager.method607(var1, var2, var3, var4, this.field4038, this.field4060, this.field4036);
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "692472671"
   )
   public void method6089(int var1) {
      this.worldMapZoomTarget = this.worldMapZoomPercentToFloat(var1);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1132253976"
   )
   void method6090(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.Rasterizer2D_fillRectangle(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field4055.drawTextCentered("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)F",
      garbageValue = "682468389"
   )
   @Export("worldMapZoomPercentToFloat")
   float worldMapZoomPercentToFloat(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "3"
   )
   public int method6181() {
      return 1.0D == (double)this.worldMapZoomTarget?25:(1.5D == (double)this.worldMapZoomTarget?37:(2.0D == (double)this.worldMapZoomTarget?50:(3.0D == (double)this.worldMapZoomTarget?75:((double)this.worldMapZoomTarget == 4.0D?100:200))));
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1157817593"
   )
   public void method6177() {
      this.field4024.method6056();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "16256"
   )
   public boolean method6239() {
      return this.field4024.method6053();
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(II)Las;",
      garbageValue = "-1520785091"
   )
   @Export("getWorldMapDataByFileId")
   public WorldMapData getWorldMapDataByFileId(int var1) {
      Iterator var2 = this.worldMapDataByIdentifier.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.getFileId() != var1);

      return var3;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1506928777"
   )
   @Export("setWorldMapPositionTarget")
   public void setWorldMapPositionTarget(int surfaceX, int surfaceY) {
      if(this.worldMapData != null && this.worldMapData.surfaceContainsPosition(surfaceX, surfaceY)) {
         this.worldMapTargetX = surfaceX - this.worldMapData.getMinX() * 64;
         this.worldMapTargetY = surfaceY - this.worldMapData.getMinY() * 64;
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "22"
   )
   public void method6096(int var1, int var2) {
      if(this.worldMapData != null) {
         this.setWorldMapPosition(var1 - this.worldMapData.getMinX() * 64, var2 - this.worldMapData.getMinY() * 64, true);
         this.worldMapTargetX = -1;
         this.worldMapTargetY = -1;
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-116"
   )
   public void method6240(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method354(var1, var2, var3);
         if(var4 != null) {
            this.setWorldMapPositionTarget(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2145961554"
   )
   public void method6098(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method354(var1, var2, var3);
         if(var4 != null) {
            this.method6096(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1929079217"
   )
   public int method6099() {
      return this.worldMapData == null?-1:this.worldMapX + this.worldMapData.getMinX() * 64;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "117"
   )
   public int method6155() {
      return this.worldMapData == null?-1:this.worldMapY + this.worldMapData.getMinY() * 64;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)Lio;",
      garbageValue = "-89713756"
   )
   public Coordinates method6101() {
      return this.worldMapData == null?null:this.worldMapData.method285(this.method6099(), this.method6155());
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1406147063"
   )
   public int method6180() {
      return this.worldMapDisplayWidth;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "16711935"
   )
   public int method6117() {
      return this.worldMapDisplayHeight;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-116"
   )
   public void method6104(int var1) {
      if(var1 >= 1) {
         this.field4035 = var1;
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1825578307"
   )
   public void method6206() {
      this.field4035 = 3;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "955208306"
   )
   public void method6106(int var1) {
      if(var1 >= 1) {
         this.field4036 = var1;
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "527847885"
   )
   public void method6107() {
      this.field4036 = 50;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "47"
   )
   public void method6108(boolean var1) {
      this.field4037 = var1;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-22"
   )
   public void method6088(int var1) {
      this.field4038 = new HashSet();
      this.field4038.add(Integer.valueOf(var1));
      this.field4039 = 0;
      this.field4060 = 0;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-1"
   )
   public void method6246(int var1) {
      this.field4038 = new HashSet();
      this.field4039 = 0;
      this.field4060 = 0;

      for(int var2 = 0; var2 < class190.mapAreaType.length; ++var2) {
         if(class190.mapAreaType[var2] != null && class190.mapAreaType[var2].field3463 == var1) {
            this.field4038.add(Integer.valueOf(class190.mapAreaType[var2].id));
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1526973526"
   )
   public void method6111() {
      this.field4038 = null;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "921203440"
   )
   public void method6112(boolean var1) {
      this.field4065 = !var1;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "2141955616"
   )
   public void method6153(int var1, boolean var2) {
      if(!var2) {
         this.field4049.add(Integer.valueOf(var1));
      } else {
         this.field4049.remove(Integer.valueOf(var1));
      }

      this.method6118();
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "-57"
   )
   public void method6114(int var1, boolean var2) {
      if(!var2) {
         this.field4050.add(Integer.valueOf(var1));
      } else {
         this.field4050.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < class190.mapAreaType.length; ++var3) {
         if(class190.mapAreaType[var3] != null && class190.mapAreaType[var3].field3463 == var1) {
            int var4 = class190.mapAreaType[var3].id;
            if(!var2) {
               this.field4051.add(Integer.valueOf(var4));
            } else {
               this.field4051.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method6118();
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1266653746"
   )
   public boolean method6115() {
      return !this.field4065;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-109"
   )
   public boolean method6067(int var1) {
      return !this.field4049.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1888772730"
   )
   public boolean method6172(int var1) {
      return !this.field4050.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1733453472"
   )
   void method6118() {
      this.field4052.clear();
      this.field4052.addAll(this.field4049);
      this.field4052.addAll(this.field4051);
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-57"
   )
   public void method6119(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field4024.method6053()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.worldMapZoom));
         int var8 = (int)Math.ceil((double)((float)var4 / this.worldMapZoom));
         List var9 = this.worldMapManager.method601(this.worldMapX - var7 / 2 - 1, this.worldMapY - var8 / 2 - 1, var7 / 2 + this.worldMapX + 1, var8 / 2 + this.worldMapY + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               MapIcon var11 = (MapIcon)var10.next();
               Area var12 = class190.mapAreaType[var11.areaId];
               var13 = false;

               for(int var14 = this.field4045.length - 1; var14 >= 0; --var14) {
                  if(var12.field3470[var14] != null) {
                     class150.addMenuEntry(var12.field3470[var14], var12.field3459, this.field4045[var14], var11.areaId, var11.field528.bitpack(), var11.field522.bitpack());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(ILio;B)Lio;",
      garbageValue = "-73"
   )
   public Coordinates method6120(int var1, Coordinates var2) {
      if(!this.field4024.method6053()) {
         return null;
      } else if(!this.worldMapManager.getLoaded()) {
         return null;
      } else if(!this.worldMapData.surfaceContainsPosition(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.worldMapManager.method630();
         List var4 = (List)var3.get(Integer.valueOf(var1));
         if(var4 != null && !var4.isEmpty()) {
            MapIcon var5 = null;
            int var6 = -1;
            Iterator var7 = var4.iterator();

            while(true) {
               MapIcon var8;
               int var11;
               do {
                  if(!var7.hasNext()) {
                     return var5.field522;
                  }

                  var8 = (MapIcon)var7.next();
                  int var9 = var8.field522.worldX - var2.worldX;
                  int var10 = var8.field522.worldY - var2.worldY;
                  var11 = var9 * var9 + var10 * var10;
                  if(var11 == 0) {
                     return var8.field522;
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

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(IILio;Lio;B)V",
      garbageValue = "3"
   )
   @Export("onMapClicked")
   public void onMapClicked(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      MapIconReference var6 = new MapIconReference(var2, var3, var4);
      var5.method1155(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1154(class245.field2960);
         break;
      case 1009:
         var5.method1154(class245.field2961);
         break;
      case 1010:
         var5.method1154(class245.field2962);
         break;
      case 1011:
         var5.method1154(class245.field2969);
         break;
      case 1012:
         var5.method1154(class245.field2963);
      }

      class71.method1203(var5);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(B)Lal;",
      garbageValue = "-81"
   )
   public MapIcon method6122() {
      if(!this.field4024.method6053()) {
         return null;
      } else if(!this.worldMapManager.getLoaded()) {
         return null;
      } else {
         HashMap var1 = this.worldMapManager.method630();
         this.field4056 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field4056.addAll(var3);
         }

         this.field4057 = this.field4056.iterator();
         return this.method6123();
      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(S)Lal;",
      garbageValue = "25435"
   )
   public MapIcon method6123() {
      return this.field4057 == null?null:(!this.field4057.hasNext()?null:(MapIcon)this.field4057.next());
   }
}
