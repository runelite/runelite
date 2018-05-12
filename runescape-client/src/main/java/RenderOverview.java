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
@Implements("RenderOverview")
public class RenderOverview {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   @Export("fontNameVerdana11")
   static final FontName fontNameVerdana11;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   @Export("fontNameVerdana13")
   static final FontName fontNameVerdana13;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   @Export("fontNameVerdana15")
   static final FontName fontNameVerdana15;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   IndexDataBase field3862;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   Font field3825;
   @ObfuscatedName("d")
   @Export("mapFonts")
   HashMap mapFonts;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Llh;"
   )
   IndexedSprite[] field3853;
   @ObfuscatedName("p")
   @Export("worldMapDataByIdentifier")
   HashMap worldMapDataByIdentifier;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Li;"
   )
   WorldMapData field3829;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Li;"
   )
   @Export("worldMapData")
   WorldMapData worldMapData;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Li;"
   )
   WorldMapData field3831;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lay;"
   )
   @Export("worldMapManager")
   WorldMapManager worldMapManager;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   class320 field3833;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 270498649
   )
   @Export("worldMapX")
   int worldMapX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -57982191
   )
   @Export("worldMapY")
   int worldMapY;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2107115173
   )
   @Export("worldMapTargetX")
   int worldMapTargetX;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 506343915
   )
   @Export("worldMapTargetY")
   int worldMapTargetY;
   @ObfuscatedName("r")
   @Export("worldMapZoom")
   float worldMapZoom;
   @ObfuscatedName("v")
   @Export("worldMapZoomTarget")
   float worldMapZoomTarget;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -902288793
   )
   @Export("worldMapDisplayWidth")
   int worldMapDisplayWidth;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 977658759
   )
   @Export("worldMapDisplayHeight")
   int worldMapDisplayHeight;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1024219427
   )
   @Export("worldMapDisplayX")
   int worldMapDisplayX;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1313041719
   )
   @Export("worldMapDisplayY")
   int worldMapDisplayY;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 732122803
   )
   int field3844;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -672161053
   )
   int field3845;
   @ObfuscatedName("an")
   boolean field3821;
   @ObfuscatedName("as")
   HashSet field3847;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 444200591
   )
   int field3848;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1971633153
   )
   int field3849;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -648199013
   )
   int field3850;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1630041807
   )
   int field3874;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -252206571
   )
   int field3852;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -2042783335
   )
   int field3857;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      longValue = 310548302039362533L
   )
   long field3855;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1744002699
   )
   int field3823;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1805176019
   )
   int field3856;
   @ObfuscatedName("aj")
   boolean field3858;
   @ObfuscatedName("av")
   HashSet field3863;
   @ObfuscatedName("ab")
   HashSet field3859;
   @ObfuscatedName("aa")
   HashSet field3860;
   @ObfuscatedName("ar")
   HashSet field3861;
   @ObfuscatedName("ax")
   boolean field3819;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -436963705
   )
   int field3865;
   @ObfuscatedName("bc")
   final int[] field3864;
   @ObfuscatedName("bo")
   List field3867;
   @ObfuscatedName("bx")
   Iterator field3822;
   @ObfuscatedName("be")
   HashSet field3869;
   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   Coordinates field3868;
   @ObfuscatedName("bk")
   public boolean field3846;
   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "Llc;"
   )
   SpritePixels field3870;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -262712901
   )
   int field3871;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -1932536847
   )
   int field3872;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 1610230661
   )
   int field3873;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -1716343699
   )
   int field3842;

   static {
      fontNameVerdana11 = FontName.field3682;
      fontNameVerdana13 = FontName.field3683;
      fontNameVerdana15 = FontName.field3684;
   }

   public RenderOverview() {
      this.worldMapTargetX = -1;
      this.worldMapTargetY = -1;
      this.worldMapDisplayWidth = -1;
      this.worldMapDisplayHeight = -1;
      this.worldMapDisplayX = -1;
      this.worldMapDisplayY = -1;
      this.field3844 = 3;
      this.field3845 = 50;
      this.field3821 = false;
      this.field3847 = null;
      this.field3848 = -1;
      this.field3849 = -1;
      this.field3850 = -1;
      this.field3874 = -1;
      this.field3852 = -1;
      this.field3857 = -1;
      this.field3858 = true;
      this.field3863 = new HashSet();
      this.field3859 = new HashSet();
      this.field3860 = new HashSet();
      this.field3861 = new HashSet();
      this.field3819 = false;
      this.field3865 = 0;
      this.field3864 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3869 = new HashSet();
      this.field3868 = null;
      this.field3846 = false;
      this.field3872 = -1;
      this.field3873 = -1;
      this.field3842 = -1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Liv;Lkr;Ljava/util/HashMap;[Llh;I)V",
      garbageValue = "-757010619"
   )
   public void method6047(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field3853 = var4;
      this.field3862 = var1;
      this.field3825 = var2;
      this.mapFonts = new HashMap();
      this.mapFonts.put(Size.field93, var3.get(fontNameVerdana11));
      this.mapFonts.put(Size.field87, var3.get(fontNameVerdana13));
      this.mapFonts.put(Size.field89, var3.get(fontNameVerdana15));
      this.field3833 = new class320(var1);
      int var5 = this.field3862.getFile(MapCacheArchiveNames.DETAILS.name);
      int[] var6 = this.field3862.getChilds(var5);
      this.worldMapDataByIdentifier = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3862.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.worldMapDataByIdentifier.put(var9.getIdentifier(), var9);
         if(var9.method265()) {
            this.field3829 = var9;
         }
      }

      this.method6062(this.field3829);
      this.field3831 = null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1699946316"
   )
   public int method6048() {
      return this.field3862.tryLoadRecordByNames(this.field3829.getIdentifier(), MapCacheArchiveNames.AREA.name)?100:this.field3862.archiveLoadPercentByName(this.field3829.getIdentifier());
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "2047"
   )
   public void method6049() {
      class68.method1742();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "2067315291"
   )
   public void method6162(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3833.method6035()) {
         this.moveTowardZoomTarget();
         this.moveTowardLocationTarget();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.worldMapZoom));
            int var9 = (int)Math.ceil((double)((float)var7 / this.worldMapZoom));
            List var10 = this.worldMapManager.method560(this.worldMapX - var8 / 2 - 1, this.worldMapY - var9 / 2 - 1, var8 / 2 + this.worldMapX + 1, var9 / 2 + this.worldMapY + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            MapIcon var13;
            ScriptEvent var14;
            MapIconReference var15;
            for(var12 = var10.iterator(); var12.hasNext(); FriendManager.method1728(var14)) {
               var13 = (MapIcon)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new MapIconReference(var13.areaId, var13.field253, var13.field247);
               var14.method1078(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3869.contains(var13)) {
                  var14.method1079(17);
               } else {
                  var14.method1079(15);
               }
            }

            var12 = this.field3869.iterator();

            while(var12.hasNext()) {
               var13 = (MapIcon)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new MapIconReference(var13.areaId, var13.field253, var13.field247);
                  var14.method1078(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1079(16);
                  FriendManager.method1728(var14);
               }
            }

            this.field3869 = var11;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIZZI)V",
      garbageValue = "1302070535"
   )
   public void method6051(int var1, int var2, boolean var3, boolean var4) {
      long var5 = class166.method3456();
      this.method6221(var1, var2, var4, var5);
      if(!this.hasTargetPosition() && (var4 || var3)) {
         if(var4) {
            this.field3852 = var1;
            this.field3857 = var2;
            this.field3850 = this.worldMapX;
            this.field3874 = this.worldMapY;
         }

         if(this.field3850 != -1) {
            int var7 = var1 - this.field3852;
            int var8 = var2 - this.field3857;
            this.setWorldMapPosition(this.field3850 - (int)((float)var7 / this.worldMapZoomTarget), (int)((float)var8 / this.worldMapZoomTarget) + this.field3874, false);
         }
      } else {
         this.method6197();
      }

      if(var4) {
         this.field3855 = var5;
         this.field3823 = var1;
         this.field3856 = var2;
      }

   }

   @ObfuscatedName("a")
   void method6221(int var1, int var2, boolean var3, long var4) {
      if(this.worldMapData != null) {
         int var6 = (int)((float)this.worldMapX + ((float)(var1 - this.worldMapDisplayX) - (float)this.method6084() * this.worldMapZoom / 2.0F) / this.worldMapZoom);
         int var7 = (int)((float)this.worldMapY - ((float)(var2 - this.worldMapDisplayY) - (float)this.method6085() * this.worldMapZoom / 2.0F) / this.worldMapZoom);
         this.field3868 = this.worldMapData.method229(var6 + this.worldMapData.getMinX() * 64, var7 + this.worldMapData.getMinY() * 64);
         if(this.field3868 != null && var3) {
            if(class139.method3161() && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81]) {
               class145.method3194(this.field3868.worldX, this.field3868.worldY, this.field3868.plane, false);
            } else {
               boolean var8 = true;
               if(this.field3858) {
                  int var9 = var1 - this.field3823;
                  int var10 = var2 - this.field3856;
                  if(var4 - this.field3855 > 500L || var9 < -25 || var9 > 25 || var10 < -25 || var10 > 25) {
                     var8 = false;
                  }
               }

               if(var8) {
                  PacketNode var11 = DecorativeObject.method3115(ClientPacket.field2167, Client.field739.field1250);
                  var11.packetBuffer.method3670(this.field3868.bitpack());
                  Client.field739.method2019(var11);
                  this.field3855 = 0L;
               }
            }
         }
      } else {
         this.field3868 = null;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1125890593"
   )
   @Export("moveTowardZoomTarget")
   void moveTowardZoomTarget() {
      if(class8.field53 != null) {
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1119078583"
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
         if(this.worldMapX == this.worldMapTargetX && this.worldMapTargetY == this.worldMapY) {
            this.worldMapTargetX = -1;
            this.worldMapTargetY = -1;
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "411012073"
   )
   @Export("setWorldMapPosition")
   final void setWorldMapPosition(int worldMapX, int worldMapY, boolean changeSurface) {
      this.worldMapX = worldMapX;
      this.worldMapY = worldMapY;
      class166.method3456();
      if(changeSurface) {
         this.method6197();
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "786815238"
   )
   final void method6197() {
      this.field3857 = -1;
      this.field3852 = -1;
      this.field3874 = -1;
      this.field3850 = -1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "715993111"
   )
   @Export("hasTargetPosition")
   boolean hasTargetPosition() {
      return this.worldMapTargetX != -1 && this.worldMapTargetY != -1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)Li;",
      garbageValue = "-793504190"
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-1464176187"
   )
   public void method6222(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.getWorldMapDataContainingCoord(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3829;
      }

      boolean var6 = false;
      if(var5 != this.field3831 || var4) {
         this.field3831 = var5;
         this.method6062(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method6065(var1, var2, var3);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "55"
   )
   public void method6244(int var1) {
      WorldMapData var2 = this.getWorldMapDataByFileId(var1);
      if(var2 != null) {
         this.method6062(var2);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method6060() {
      return this.worldMapData == null?-1:this.worldMapData.getFileId();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Li;",
      garbageValue = "881769675"
   )
   public WorldMapData method6061() {
      return this.worldMapData;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Li;B)V",
      garbageValue = "-77"
   )
   void method6062(WorldMapData var1) {
      if(this.worldMapData == null || var1 != this.worldMapData) {
         this.initializeWorldMap(var1);
         this.method6065(-1, -1, -1);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Li;I)V",
      garbageValue = "480853407"
   )
   @Export("initializeWorldMap")
   void initializeWorldMap(WorldMapData var1) {
      this.worldMapData = var1;
      this.worldMapManager = new WorldMapManager(this.field3853, this.mapFonts);
      this.field3833.method6042(this.worldMapData.getIdentifier());
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Li;Lhh;Lhh;ZI)V",
      garbageValue = "149377571"
   )
   public void method6112(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.worldMapData == null || var1 != this.worldMapData) {
            this.initializeWorldMap(var1);
         }

         if(!var4 && this.worldMapData.containsCoord(var2.plane, var2.worldX, var2.worldY)) {
            this.method6065(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method6065(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-650364801"
   )
   void method6065(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method281(var1, var2, var3);
         if(var4 == null) {
            var4 = this.worldMapData.method281(this.worldMapData.method242(), this.worldMapData.method241(), this.worldMapData.method243());
         }

         this.setWorldMapPosition(var4[0] - this.worldMapData.getMinX() * 64, var4[1] - this.worldMapData.getMinY() * 64, true);
         this.worldMapTargetX = -1;
         this.worldMapTargetY = -1;
         this.worldMapZoom = this.worldMapZoomPercentToFloat(this.worldMapData.getInitialMapSurfaceZoom());
         this.worldMapZoomTarget = this.worldMapZoom;
         this.field3867 = null;
         this.field3822 = null;
         this.worldMapManager.method561();
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "8"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int graphicsX, int graphicsY, int width, int height, int gameCycle) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(graphicsX, graphicsY, width + graphicsX, graphicsY + height);
      Rasterizer2D.Rasterizer2D_fillRectangle(graphicsX, graphicsY, width, height, -16777216);
      int var7 = this.field3833.method6036();
      if(var7 < 100) {
         this.method6071(graphicsX, graphicsY, width, height, var7);
      } else {
         if(!this.worldMapManager.getLoaded()) {
            this.worldMapManager.load(this.field3862, this.worldMapData.getIdentifier(), Client.isMembers);
            if(!this.worldMapManager.getLoaded()) {
               return;
            }
         }

         if(this.field3847 != null) {
            ++this.field3849;
            if(this.field3849 % this.field3845 == 0) {
               this.field3849 = 0;
               ++this.field3848;
            }

            if(this.field3848 >= this.field3844 && !this.field3821) {
               this.field3847 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)width / this.worldMapZoom));
         int var9 = (int)Math.ceil((double)((float)height / this.worldMapZoom));
         this.worldMapManager.drawMapRegion(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, graphicsX, graphicsY, width + graphicsX, graphicsY + height);
         if(!this.field3819) {
            boolean var10 = false;
            if(gameCycle - this.field3865 > 100) {
               this.field3865 = gameCycle;
               var10 = true;
            }

            this.worldMapManager.drawMapIcons(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, graphicsX, graphicsY, width + graphicsX, graphicsY + height, this.field3861, this.field3847, this.field3849, this.field3845, var10);
         }

         this.method6068(graphicsX, graphicsY, width, height, var8, var9);
         if(class139.method3161() && this.field3846 && this.field3868 != null) {
            this.field3825.method5541("Coord: " + this.field3868, Rasterizer2D.draw_region_x + 10, Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
         }

         this.worldMapDisplayWidth = var8;
         this.worldMapDisplayHeight = var9;
         this.worldMapDisplayX = graphicsX;
         this.worldMapDisplayY = graphicsY;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIIIII)Z",
      garbageValue = "93988318"
   )
   boolean method6079(int var1, int var2, int var3, int var4, int var5, int var6) {
      return this.field3870 == null?true:(this.field3870.width == var1 && this.field3870.height == var2?(this.worldMapManager.field269 != this.field3871?true:(this.field3842 != Client.field859?true:(var3 <= 0 && var4 <= 0?var3 + var1 < var5 || var2 + var4 < var6:true))):true);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IIIIIIS)V",
      garbageValue = "-13244"
   )
   void method6068(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class8.field53 != null) {
         int var7 = 512 / (this.worldMapManager.field269 * 2);
         int var8 = var3 + 512;
         int var9 = var4 + 512;
         float var10 = 1.0F;
         var8 = (int)((float)var8 / var10);
         var9 = (int)((float)var9 / var10);
         int var11 = this.method6081() - var5 / 2 - var7;
         int var12 = this.method6218() - var6 / 2 - var7;
         int var13 = var1 - (var11 + var7 - this.field3872) * this.worldMapManager.field269;
         int var14 = var2 - this.worldMapManager.field269 * (var7 - (var12 - this.field3873));
         if(this.method6079(var8, var9, var13, var14, var3, var4)) {
            if(this.field3870 != null && this.field3870.width == var8 && this.field3870.height == var9) {
               Arrays.fill(this.field3870.pixels, 0);
            } else {
               this.field3870 = new SpritePixels(var8, var9);
            }

            this.field3872 = this.method6081() - var5 / 2 - var7;
            this.field3873 = this.method6218() - var6 / 2 - var7;
            this.field3871 = this.worldMapManager.field269;
            class8.field53.method4789(this.field3872, this.field3873, this.field3870, (float)this.field3871 / var10);
            this.field3842 = Client.field859;
            var13 = var1 - (var7 + var11 - this.field3872) * this.worldMapManager.field269;
            var14 = var2 - this.worldMapManager.field269 * (var7 - (var12 - this.field3873));
         }

         Rasterizer2D.fillRectangle(var1, var2, var3, var4, 0, 128);
         if(var10 == 1.0F) {
            this.field3870.method5907(var13, var14, 192);
         } else {
            this.field3870.method5899(var13, var14, (int)((float)var8 * var10), (int)(var10 * (float)var9), 192);
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1856418436"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3833.method6035()) {
         if(!this.worldMapManager.getLoaded()) {
            this.worldMapManager.load(this.field3862, this.worldMapData.getIdentifier(), Client.isMembers);
            if(!this.worldMapManager.getLoaded()) {
               return;
            }
         }

         this.worldMapManager.method525(var1, var2, var3, var4, this.field3847, this.field3849, this.field3845);
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "65536"
   )
   public void method6191(int var1) {
      this.worldMapZoomTarget = this.worldMapZoomPercentToFloat(var1);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1394913070"
   )
   void method6071(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.Rasterizer2D_fillRectangle(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3825.drawTextCentered("Loading...", var7, var6 + var8, -1, -1);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II)F",
      garbageValue = "1791100097"
   )
   @Export("worldMapZoomPercentToFloat")
   float worldMapZoomPercentToFloat(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "47"
   )
   public int method6073() {
      return (double)this.worldMapZoomTarget == 1.0D?25:(1.5D == (double)this.worldMapZoomTarget?37:((double)this.worldMapZoomTarget == 2.0D?50:((double)this.worldMapZoomTarget == 3.0D?75:((double)this.worldMapZoomTarget == 4.0D?100:200))));
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "931458431"
   )
   public void method6074() {
      this.field3833.method6034();
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-92331913"
   )
   public boolean method6075() {
      return this.field3833.method6035();
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)Li;",
      garbageValue = "1018202974"
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

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1919861881"
   )
   @Export("setWorldMapPositionTarget")
   public void setWorldMapPositionTarget(int surfaceX, int surfaceY) {
      if(this.worldMapData != null && this.worldMapData.surfaceContainsPosition(surfaceX, surfaceY)) {
         this.worldMapTargetX = surfaceX - this.worldMapData.getMinX() * 64;
         this.worldMapTargetY = surfaceY - this.worldMapData.getMinY() * 64;
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-104006593"
   )
   public void method6070(int var1, int var2) {
      if(this.worldMapData != null) {
         this.setWorldMapPosition(var1 - this.worldMapData.getMinX() * 64, var2 - this.worldMapData.getMinY() * 64, true);
         this.worldMapTargetX = -1;
         this.worldMapTargetY = -1;
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-960074123"
   )
   public void method6224(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method281(var1, var2, var3);
         if(var4 != null) {
            this.setWorldMapPositionTarget(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1944009879"
   )
   public void method6080(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method281(var1, var2, var3);
         if(var4 != null) {
            this.method6070(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-864091244"
   )
   public int method6081() {
      return this.worldMapData == null?-1:this.worldMapX + this.worldMapData.getMinX() * 64;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1005686150"
   )
   public int method6218() {
      return this.worldMapData == null?-1:this.worldMapY + this.worldMapData.getMinY() * 64;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(B)Lhh;",
      garbageValue = "0"
   )
   public Coordinates method6083() {
      return this.worldMapData == null?null:this.worldMapData.method229(this.method6081(), this.method6218());
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-63"
   )
   public int method6084() {
      return this.worldMapDisplayWidth;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-233288034"
   )
   public int method6085() {
      return this.worldMapDisplayHeight;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "742759615"
   )
   public void method6086(int var1) {
      if(var1 >= 1) {
         this.field3844 = var1;
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "76"
   )
   public void method6087() {
      this.field3844 = 3;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "7"
   )
   public void method6088(int var1) {
      if(var1 >= 1) {
         this.field3845 = var1;
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "16711680"
   )
   public void method6203() {
      this.field3845 = 50;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "608660990"
   )
   public void method6058(boolean var1) {
      this.field3821 = var1;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "987050279"
   )
   public void method6091(int var1) {
      this.field3847 = new HashSet();
      this.field3847.add(Integer.valueOf(var1));
      this.field3848 = 0;
      this.field3849 = 0;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1369602526"
   )
   public void method6090(int var1) {
      this.field3847 = new HashSet();
      this.field3848 = 0;
      this.field3849 = 0;

      for(int var2 = 0; var2 < Area.mapAreaType.length; ++var2) {
         if(Area.mapAreaType[var2] != null && Area.mapAreaType[var2].field3277 == var1) {
            this.field3847.add(Integer.valueOf(Area.mapAreaType[var2].id));
         }
      }

   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-46"
   )
   public void method6093() {
      this.field3847 = null;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "772669540"
   )
   public void method6094(boolean var1) {
      this.field3819 = !var1;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1498858143"
   )
   public void method6095(int var1, boolean var2) {
      if(!var2) {
         this.field3863.add(Integer.valueOf(var1));
      } else {
         this.field3863.remove(Integer.valueOf(var1));
      }

      this.method6069();
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1775032823"
   )
   public void method6082(int var1, boolean var2) {
      if(!var2) {
         this.field3859.add(Integer.valueOf(var1));
      } else {
         this.field3859.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.mapAreaType.length; ++var3) {
         if(Area.mapAreaType[var3] != null && Area.mapAreaType[var3].field3277 == var1) {
            int var4 = Area.mapAreaType[var3].id;
            if(!var2) {
               this.field3860.add(Integer.valueOf(var4));
            } else {
               this.field3860.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method6069();
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1844320408"
   )
   public boolean method6097() {
      return !this.field3819;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1820684571"
   )
   public boolean method6098(int var1) {
      return !this.field3863.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-123"
   )
   public boolean method6059(int var1) {
      return !this.field3859.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1307289694"
   )
   void method6069() {
      this.field3861.clear();
      this.field3861.addAll(this.field3863);
      this.field3861.addAll(this.field3860);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1338821488"
   )
   public void method6216(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3833.method6035()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.worldMapZoom));
         int var8 = (int)Math.ceil((double)((float)var4 / this.worldMapZoom));
         List var9 = this.worldMapManager.method560(this.worldMapX - var7 / 2 - 1, this.worldMapY - var8 / 2 - 1, var7 / 2 + this.worldMapX + 1, var8 / 2 + this.worldMapY + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               MapIcon var11 = (MapIcon)var10.next();
               Area var12 = Area.mapAreaType[var11.areaId];
               var13 = false;

               for(int var14 = this.field3864.length - 1; var14 >= 0; --var14) {
                  if(var12.field3266[var14] != null) {
                     VertexNormal.addMenuEntry(var12.field3266[var14], var12.field3270, this.field3864[var14], var11.areaId, var11.field253.bitpack(), var11.field247.bitpack());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(ILhh;I)Lhh;",
      garbageValue = "163107076"
   )
   public Coordinates method6105(int var1, Coordinates var2) {
      if(!this.field3833.method6035()) {
         return null;
      } else if(!this.worldMapManager.getLoaded()) {
         return null;
      } else if(!this.worldMapData.surfaceContainsPosition(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.worldMapManager.method546();
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
                     return var5.field247;
                  }

                  var8 = (MapIcon)var7.next();
                  int var9 = var8.field247.worldX - var2.worldX;
                  int var10 = var8.field247.worldY - var2.worldY;
                  var11 = var10 * var10 + var9 * var9;
                  if(var11 == 0) {
                     return var8.field247;
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

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(IILhh;Lhh;I)V",
      garbageValue = "1870384164"
   )
   @Export("onMapClicked")
   public void onMapClicked(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      MapIconReference var6 = new MapIconReference(var2, var3, var4);
      var5.method1078(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1079(10);
         break;
      case 1009:
         var5.method1079(11);
         break;
      case 1010:
         var5.method1079(12);
         break;
      case 1011:
         var5.method1079(13);
         break;
      case 1012:
         var5.method1079(14);
      }

      FriendManager.method1728(var5);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(S)Lad;",
      garbageValue = "180"
   )
   public MapIcon method6067() {
      if(!this.field3833.method6035()) {
         return null;
      } else if(!this.worldMapManager.getLoaded()) {
         return null;
      } else {
         HashMap var1 = this.worldMapManager.method546();
         this.field3867 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3867.addAll(var3);
         }

         this.field3822 = this.field3867.iterator();
         return this.method6245();
      }
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)Lad;",
      garbageValue = "832581793"
   )
   public MapIcon method6245() {
      return this.field3822 == null?null:(!this.field3822.hasNext()?null:(MapIcon)this.field3822.next());
   }
}
