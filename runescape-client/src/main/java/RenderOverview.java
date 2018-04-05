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

@ObfuscatedName("lp")
@Implements("RenderOverview")
public class RenderOverview {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   @Export("fontNameVerdana11")
   static final FontName fontNameVerdana11;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   @Export("fontNameVerdana13")
   static final FontName fontNameVerdana13;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   @Export("fontNameVerdana15")
   static final FontName fontNameVerdana15;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   IndexDataBase field4055;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   Font field4008;
   @ObfuscatedName("a")
   @Export("mapFonts")
   HashMap mapFonts;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lll;"
   )
   IndexedSprite[] field4063;
   @ObfuscatedName("n")
   @Export("worldMapDataByIdentifier")
   HashMap worldMapDataByIdentifier;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lah;"
   )
   WorldMapData field4018;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lah;"
   )
   @Export("worldMapData")
   WorldMapData worldMapData;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lah;"
   )
   WorldMapData field4032;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lad;"
   )
   @Export("worldMapManager")
   WorldMapManager worldMapManager;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Llw;"
   )
   class333 field4043;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1575300903
   )
   @Export("worldMapX")
   int worldMapX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1338430201
   )
   @Export("worldMapY")
   int worldMapY;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 807705593
   )
   int field4025;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1175411227
   )
   int field4026;
   @ObfuscatedName("p")
   @Export("worldMapZoom")
   float worldMapZoom;
   @ObfuscatedName("e")
   @Export("worldMapZoomTarget")
   float worldMapZoomTarget;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1455345827
   )
   int field4013;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1625408669
   )
   int field4030;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -642823815
   )
   int field4031;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1338917191
   )
   int field4058;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1677903703
   )
   int field4033;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1953684657
   )
   int field4034;
   @ObfuscatedName("al")
   boolean field4035;
   @ObfuscatedName("ah")
   HashSet field4036;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1520261245
   )
   int field4037;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 2129780447
   )
   int field4038;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 422897531
   )
   int field4010;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -406147601
   )
   int field4022;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1253502247
   )
   int field4041;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1870735773
   )
   int field4042;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      longValue = 8297852581767525577L
   )
   long field4019;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 293178707
   )
   int field4044;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1738005435
   )
   int field4045;
   @ObfuscatedName("ad")
   boolean field4052;
   @ObfuscatedName("an")
   HashSet field4007;
   @ObfuscatedName("ae")
   HashSet field4048;
   @ObfuscatedName("aw")
   HashSet field4049;
   @ObfuscatedName("ak")
   HashSet field4050;
   @ObfuscatedName("as")
   boolean field4051;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -513463829
   )
   int field4062;
   @ObfuscatedName("bm")
   final int[] field4061;
   @ObfuscatedName("bx")
   List field4054;
   @ObfuscatedName("bl")
   Iterator field4006;
   @ObfuscatedName("bf")
   HashSet field4056;
   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   Coordinates field4057;
   @ObfuscatedName("bs")
   public boolean field4016;
   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   SpritePixels field4047;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1839688437
   )
   int field4060;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1090167411
   )
   int field4039;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -1370150953
   )
   int field4014;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1853441527
   )
   int field4029;

   static {
      fontNameVerdana11 = FontName.field3881;
      fontNameVerdana13 = FontName.field3882;
      fontNameVerdana15 = FontName.field3886;
   }

   public RenderOverview() {
      this.field4025 = -1;
      this.field4026 = -1;
      this.field4013 = -1;
      this.field4030 = -1;
      this.field4031 = -1;
      this.field4058 = -1;
      this.field4033 = 3;
      this.field4034 = 50;
      this.field4035 = false;
      this.field4036 = null;
      this.field4037 = -1;
      this.field4038 = -1;
      this.field4010 = -1;
      this.field4022 = -1;
      this.field4041 = -1;
      this.field4042 = -1;
      this.field4052 = true;
      this.field4007 = new HashSet();
      this.field4048 = new HashSet();
      this.field4049 = new HashSet();
      this.field4050 = new HashSet();
      this.field4051 = false;
      this.field4062 = 0;
      this.field4061 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field4056 = new HashSet();
      this.field4057 = null;
      this.field4016 = false;
      this.field4039 = -1;
      this.field4014 = -1;
      this.field4029 = -1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljf;Lki;Ljava/util/HashMap;[Lll;I)V",
      garbageValue = "389228687"
   )
   public void method6006(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field4063 = var4;
      this.field4055 = var1;
      this.field4008 = var2;
      this.mapFonts = new HashMap();
      this.mapFonts.put(Size.field371, var3.get(fontNameVerdana11));
      this.mapFonts.put(Size.field363, var3.get(fontNameVerdana13));
      this.mapFonts.put(Size.field368, var3.get(fontNameVerdana15));
      this.field4043 = new class333(var1);
      int var5 = this.field4055.getFile(MapCacheArchiveNames.DETAILS.name);
      int[] var6 = this.field4055.getChilds(var5);
      this.worldMapDataByIdentifier = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field4055.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.worldMapDataByIdentifier.put(var9.getIdentifier(), var9);
         if(var9.method325()) {
            this.field4018 = var9;
         }
      }

      this.method6022(this.field4018);
      this.field4032 = null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-282485643"
   )
   public int method6057() {
      return this.field4055.tryLoadRecordByNames(this.field4018.getIdentifier(), MapCacheArchiveNames.AREA.name)?100:this.field4055.archiveLoadPercentByName(this.field4018.getIdentifier());
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   public void method6008() {
      WorldMapRegion.field479.method3937(5);
      WorldMapRegion.field480.method3937(5);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIZIIIIB)V",
      garbageValue = "0"
   )
   public void method6009(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field4043.method5997()) {
         this.method6012();
         this.method6013();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.worldMapZoom));
            int var9 = (int)Math.ceil((double)((float)var7 / this.worldMapZoom));
            List var10 = this.worldMapManager.method596(this.worldMapX - var8 / 2 - 1, this.worldMapY - var9 / 2 - 1, var8 / 2 + this.worldMapX + 1, var9 / 2 + this.worldMapY + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            MapIcon var13;
            ScriptEvent var14;
            MapIconReference var15;
            for(var12 = var10.iterator(); var12.hasNext(); AbstractSoundSystem.method2256(var14)) {
               var13 = (MapIcon)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new MapIconReference(var13.areaId, var13.field524, var13.field532);
               var14.method1137(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field4056.contains(var13)) {
                  var14.method1138(class245.field2966);
               } else {
                  var14.method1138(class245.field2968);
               }
            }

            var12 = this.field4056.iterator();

            while(var12.hasNext()) {
               var13 = (MapIcon)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new MapIconReference(var13.areaId, var13.field524, var13.field532);
                  var14.method1137(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1138(class245.field2971);
                  AbstractSoundSystem.method2256(var14);
               }
            }

            this.field4056 = var11;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIZZI)V",
      garbageValue = "-446014827"
   )
   public void method6010(int var1, int var2, boolean var3, boolean var4) {
      long var5 = class64.method1118();
      this.method6011(var1, var2, var4, var5);
      if(!this.method6017() && (var4 || var3)) {
         if(var4) {
            this.field4041 = var1;
            this.field4042 = var2;
            this.field4010 = this.worldMapX;
            this.field4022 = this.worldMapY;
         }

         if(this.field4010 != -1) {
            int var7 = var1 - this.field4041;
            int var8 = var2 - this.field4042;
            this.method6014(this.field4010 - (int)((float)var7 / this.worldMapZoomTarget), (int)((float)var8 / this.worldMapZoomTarget) + this.field4022, false);
         }
      } else {
         this.method6070();
      }

      if(var4) {
         this.field4019 = var5;
         this.field4044 = var1;
         this.field4045 = var2;
      }

   }

   @ObfuscatedName("m")
   void method6011(int var1, int var2, boolean var3, long var4) {
      if(this.worldMapData != null) {
         int var6 = (int)((float)this.worldMapX + ((float)(var1 - this.field4031) - (float)this.method6044() * this.worldMapZoom / 2.0F) / this.worldMapZoom);
         int var7 = (int)((float)this.worldMapY - ((float)(var2 - this.field4058) - (float)this.method6045() * this.worldMapZoom / 2.0F) / this.worldMapZoom);
         this.field4057 = this.worldMapData.method322(var6 + this.worldMapData.getMinX() * 64, var7 + this.worldMapData.getMinY() * 64);
         if(this.field4057 != null && var3) {
            boolean var8 = Client.rights >= 2;
            if(var8 && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81]) {
               class19.method166(this.field4057.worldX, this.field4057.worldY, this.field4057.plane, false);
            } else {
               boolean var9 = true;
               if(this.field4052) {
                  int var10 = var1 - this.field4044;
                  int var11 = var2 - this.field4045;
                  if(var4 - this.field4019 > 500L || var10 < -25 || var10 > 25 || var11 < -25 || var11 > 25) {
                     var9 = false;
                  }
               }

               if(var9) {
                  PacketNode var12 = WorldMapRectangle.method280(ClientPacket.field2409, Client.field957.field1484);
                  var12.packetBuffer.method3559(this.field4057.bitpack());
                  Client.field957.method2052(var12);
                  this.field4019 = 0L;
               }
            }
         }
      } else {
         this.field4057 = null;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "87"
   )
   void method6012() {
      if(BaseVarType.field25 != null) {
         this.worldMapZoom = this.worldMapZoomTarget;
      } else {
         if(this.worldMapZoom < this.worldMapZoomTarget) {
            this.worldMapZoom = Math.min(this.worldMapZoomTarget, this.worldMapZoom + this.worldMapZoom / 30.0F);
         }

         if(this.worldMapZoom > this.worldMapZoomTarget) {
            this.worldMapZoom = Math.max(this.worldMapZoomTarget, this.worldMapZoom - this.worldMapZoom / 30.0F);
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1282906726"
   )
   void method6013() {
      if(this.method6017()) {
         int var1 = this.field4025 - this.worldMapX;
         int var2 = this.field4026 - this.worldMapY;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.method6014(var1 + this.worldMapX, var2 + this.worldMapY, true);
         if(this.worldMapX == this.field4025 && this.field4026 == this.worldMapY) {
            this.field4025 = -1;
            this.field4026 = -1;
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "96493842"
   )
   final void method6014(int var1, int var2, boolean var3) {
      this.worldMapX = var1;
      this.worldMapY = var2;
      class64.method1118();
      if(var3) {
         this.method6070();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "1000"
   )
   final void method6070() {
      this.field4042 = -1;
      this.field4041 = -1;
      this.field4022 = -1;
      this.field4010 = -1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1382521577"
   )
   boolean method6017() {
      return this.field4025 != -1 && this.field4026 != -1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)Lah;",
      garbageValue = "-1081902819"
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "1173678182"
   )
   public void method6018(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.getWorldMapDataContainingCoord(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field4018;
      }

      boolean var6 = false;
      if(var5 != this.field4032 || var4) {
         this.field4032 = var5;
         this.method6022(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method6173(var1, var2, var3);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-120"
   )
   public void method6019(int var1) {
      WorldMapData var2 = this.getWorldMapDataByFileId(var1);
      if(var2 != null) {
         this.method6022(var2);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1099945094"
   )
   public int method6020() {
      return this.worldMapData == null?-1:this.worldMapData.getFileId();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Lah;",
      garbageValue = "-1264075628"
   )
   public WorldMapData method6021() {
      return this.worldMapData;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lah;B)V",
      garbageValue = "-104"
   )
   void method6022(WorldMapData var1) {
      if(this.worldMapData == null || var1 != this.worldMapData) {
         this.initializeWorldMap(var1);
         this.method6173(-1, -1, -1);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lah;I)V",
      garbageValue = "-1559561436"
   )
   @Export("initializeWorldMap")
   void initializeWorldMap(WorldMapData var1) {
      this.worldMapData = var1;
      this.worldMapManager = new WorldMapManager(this.field4063, this.mapFonts);
      this.field4043.method5995(this.worldMapData.getIdentifier());
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lah;Lix;Lix;ZI)V",
      garbageValue = "252850026"
   )
   public void method6024(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.worldMapData == null || var1 != this.worldMapData) {
            this.initializeWorldMap(var1);
         }

         if(!var4 && this.worldMapData.containsCoord(var2.plane, var2.worldX, var2.worldY)) {
            this.method6173(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method6173(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "-16257"
   )
   void method6173(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method321(var1, var2, var3);
         if(var4 == null) {
            var4 = this.worldMapData.method321(this.worldMapData.method386(), this.worldMapData.method334(), this.worldMapData.method336());
         }

         this.method6014(var4[0] - this.worldMapData.getMinX() * 64, var4[1] - this.worldMapData.getMinY() * 64, true);
         this.field4025 = -1;
         this.field4026 = -1;
         this.worldMapZoom = this.method6005(this.worldMapData.method338());
         this.worldMapZoomTarget = this.worldMapZoom;
         this.field4054 = null;
         this.field4006 = null;
         this.worldMapManager.method591();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "145957979"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      int var7 = this.field4043.method5998();
      if(var7 < 100) {
         this.method6097(var1, var2, var3, var4, var7);
      } else {
         if(!this.worldMapManager.method598()) {
            this.worldMapManager.load(this.field4055, this.worldMapData.getIdentifier(), Client.isMembers);
            if(!this.worldMapManager.method598()) {
               return;
            }
         }

         if(this.field4036 != null) {
            ++this.field4038;
            if(this.field4038 % this.field4034 == 0) {
               this.field4038 = 0;
               ++this.field4037;
            }

            if(this.field4037 >= this.field4033 && !this.field4035) {
               this.field4036 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.worldMapZoom));
         int var9 = (int)Math.ceil((double)((float)var4 / this.worldMapZoom));
         this.worldMapManager.drawMapRegion(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, var1, var2, var3 + var1, var2 + var4);
         boolean var10;
         if(!this.field4051) {
            var10 = false;
            if(var5 - this.field4062 > 100) {
               this.field4062 = var5;
               var10 = true;
            }

            this.worldMapManager.drawMapIcons(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, var1, var2, var3 + var1, var2 + var4, this.field4050, this.field4036, this.field4038, this.field4034, var10);
         }

         this.method6028(var1, var2, var3, var4, var8, var9);
         var10 = Client.rights >= 2;
         if(var10 && this.field4016 && this.field4057 != null) {
            this.field4008.method5510("Coord: " + this.field4057, Rasterizer2D.draw_region_x + 10, Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
         }

         this.field4013 = var8;
         this.field4030 = var9;
         this.field4031 = var1;
         this.field4058 = var2;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)Z",
      garbageValue = "68"
   )
   boolean method6027(int var1, int var2, int var3, int var4, int var5, int var6) {
      return this.field4047 == null?true:(this.field4047.width == var1 && this.field4047.height == var2?(this.worldMapManager.field548 != this.field4060?true:(this.field4029 != Client.field1135?true:(var3 <= 0 && var4 <= 0?var3 + var1 < var5 || var2 + var4 < var6:true))):true);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-92"
   )
   void method6028(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(BaseVarType.field25 != null) {
         int var7 = 512 / (this.worldMapManager.field548 * 2);
         int var8 = var3 + 512;
         int var9 = var4 + 512;
         float var10 = 1.0F;
         var8 = (int)((float)var8 / var10);
         var9 = (int)((float)var9 / var10);
         int var11 = this.method6047() - var5 / 2 - var7;
         int var12 = this.method6042() - var6 / 2 - var7;
         int var13 = var1 - (var7 + var11 - this.field4039) * this.worldMapManager.field548;
         int var14 = var2 - this.worldMapManager.field548 * (var7 - (var12 - this.field4014));
         if(this.method6027(var8, var9, var13, var14, var3, var4)) {
            if(this.field4047 != null && this.field4047.width == var8 && this.field4047.height == var9) {
               Arrays.fill(this.field4047.pixels, 0);
            } else {
               this.field4047 = new SpritePixels(var8, var9);
            }

            this.field4039 = this.method6047() - var5 / 2 - var7;
            this.field4014 = this.method6042() - var6 / 2 - var7;
            this.field4060 = this.worldMapManager.field548;
            BaseVarType.field25.method4689(this.field4039, this.field4014, this.field4047, (float)this.field4060 / var10);
            this.field4029 = Client.field1135;
            var13 = var1 - (var11 + var7 - this.field4039) * this.worldMapManager.field548;
            var14 = var2 - this.worldMapManager.field548 * (var7 - (var12 - this.field4014));
         }

         Rasterizer2D.fillRectangle(var1, var2, var3, var4, 0, 128);
         if(var10 == 1.0F) {
            this.field4047.method5868(var13, var14, 192);
         } else {
            this.field4047.method5934(var13, var14, (int)(var10 * (float)var8), (int)(var10 * (float)var9), 192);
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "-23317"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field4043.method5997()) {
         if(!this.worldMapManager.method598()) {
            this.worldMapManager.load(this.field4055, this.worldMapData.getIdentifier(), Client.isMembers);
            if(!this.worldMapManager.method598()) {
               return;
            }
         }

         this.worldMapManager.method595(var1, var2, var3, var4, this.field4036, this.field4038, this.field4034);
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "205975194"
   )
   public void method6030(int var1) {
      this.worldMapZoomTarget = this.method6005(var1);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1827160685"
   )
   void method6097(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.Rasterizer2D_fillRectangle(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field4008.drawTextCentered("Loading...", var7, var6 + var8, -1, -1);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)F",
      garbageValue = "-2090584138"
   )
   float method6005(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "508720306"
   )
   public int method6033() {
      return 1.0D == (double)this.worldMapZoomTarget?25:(1.5D == (double)this.worldMapZoomTarget?37:((double)this.worldMapZoomTarget == 2.0D?50:(3.0D == (double)this.worldMapZoomTarget?75:((double)this.worldMapZoomTarget == 4.0D?100:200))));
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "107"
   )
   public void method6034() {
      this.field4043.method5996();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "34"
   )
   public boolean method6035() {
      return this.field4043.method5997();
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)Lah;",
      garbageValue = "-1430836076"
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

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2023135036"
   )
   public void method6037(int var1, int var2) {
      if(this.worldMapData != null && this.worldMapData.method335(var1, var2)) {
         this.field4025 = var1 - this.worldMapData.getMinX() * 64;
         this.field4026 = var2 - this.worldMapData.getMinY() * 64;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2012861981"
   )
   public void method6038(int var1, int var2) {
      if(this.worldMapData != null) {
         this.method6014(var1 - this.worldMapData.getMinX() * 64, var2 - this.worldMapData.getMinY() * 64, true);
         this.field4025 = -1;
         this.field4026 = -1;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-17"
   )
   public void method6029(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method321(var1, var2, var3);
         if(var4 != null) {
            this.method6037(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-404666643"
   )
   public void method6040(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method321(var1, var2, var3);
         if(var4 != null) {
            this.method6038(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "107"
   )
   public int method6047() {
      return this.worldMapData == null?-1:this.worldMapX + this.worldMapData.getMinX() * 64;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-61"
   )
   public int method6042() {
      return this.worldMapData == null?-1:this.worldMapY + this.worldMapData.getMinY() * 64;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)Lix;",
      garbageValue = "2068566551"
   )
   public Coordinates method6043() {
      return this.worldMapData == null?null:this.worldMapData.method322(this.method6047(), this.method6042());
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "206825206"
   )
   public int method6044() {
      return this.field4013;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1531551039"
   )
   public int method6045() {
      return this.field4030;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1080837780"
   )
   public void method6118(int var1) {
      if(var1 >= 1) {
         this.field4033 = var1;
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1723003306"
   )
   public void method6157() {
      this.field4033 = 3;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-31"
   )
   public void method6048(int var1) {
      if(var1 >= 1) {
         this.field4034 = var1;
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-80"
   )
   public void method6141() {
      this.field4034 = 50;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-445145795"
   )
   public void method6106(boolean var1) {
      this.field4035 = var1;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-40"
   )
   public void method6051(int var1) {
      this.field4036 = new HashSet();
      this.field4036.add(Integer.valueOf(var1));
      this.field4037 = 0;
      this.field4038 = 0;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1479071714"
   )
   public void method6134(int var1) {
      this.field4036 = new HashSet();
      this.field4037 = 0;
      this.field4038 = 0;

      for(int var2 = 0; var2 < Area.mapAreaType.length; ++var2) {
         if(Area.mapAreaType[var2] != null && Area.mapAreaType[var2].field3473 == var1) {
            this.field4036.add(Integer.valueOf(Area.mapAreaType[var2].id));
         }
      }

   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1662262407"
   )
   public void method6160() {
      this.field4036 = null;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1502975543"
   )
   public void method6054(boolean var1) {
      this.field4051 = !var1;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "-121"
   )
   public void method6055(int var1, boolean var2) {
      if(!var2) {
         this.field4007.add(Integer.valueOf(var1));
      } else {
         this.field4007.remove(Integer.valueOf(var1));
      }

      this.method6060();
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "3"
   )
   public void method6056(int var1, boolean var2) {
      if(!var2) {
         this.field4048.add(Integer.valueOf(var1));
      } else {
         this.field4048.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.mapAreaType.length; ++var3) {
         if(Area.mapAreaType[var3] != null && Area.mapAreaType[var3].field3473 == var1) {
            int var4 = Area.mapAreaType[var3].id;
            if(!var2) {
               this.field4049.add(Integer.valueOf(var4));
            } else {
               this.field4049.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method6060();
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "14"
   )
   public boolean method6074() {
      return !this.field4051;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1861947169"
   )
   public boolean method6058(int var1) {
      return !this.field4007.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "80"
   )
   public boolean method6059(int var1) {
      return !this.field4048.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-813701098"
   )
   void method6060() {
      this.field4050.clear();
      this.field4050.addAll(this.field4007);
      this.field4050.addAll(this.field4049);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1428076007"
   )
   public void method6077(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field4043.method5997()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.worldMapZoom));
         int var8 = (int)Math.ceil((double)((float)var4 / this.worldMapZoom));
         List var9 = this.worldMapManager.method596(this.worldMapX - var7 / 2 - 1, this.worldMapY - var8 / 2 - 1, var7 / 2 + this.worldMapX + 1, var8 / 2 + this.worldMapY + 1, var1, var2, var3, var4, var5, var6);
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

               for(int var14 = this.field4061.length - 1; var14 >= 0; --var14) {
                  if(var12.field3462[var14] != null) {
                     TextureProvider.addMenuEntry(var12.field3462[var14], var12.field3470, this.field4061[var14], var11.areaId, var11.field524.bitpack(), var11.field532.bitpack());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(ILix;I)Lix;",
      garbageValue = "1035619549"
   )
   public Coordinates method6062(int var1, Coordinates var2) {
      if(!this.field4043.method5997()) {
         return null;
      } else if(!this.worldMapManager.method598()) {
         return null;
      } else if(!this.worldMapData.method335(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.worldMapManager.method612();
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
                     return var5.field532;
                  }

                  var8 = (MapIcon)var7.next();
                  int var9 = var8.field532.worldX - var2.worldX;
                  int var10 = var8.field532.worldY - var2.worldY;
                  var11 = var10 * var10 + var9 * var9;
                  if(var11 == 0) {
                     return var8.field532;
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
      signature = "(IILix;Lix;I)V",
      garbageValue = "2143736537"
   )
   @Export("onMapClicked")
   public void onMapClicked(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      MapIconReference var6 = new MapIconReference(var2, var3, var4);
      var5.method1137(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1138(class245.field2976);
         break;
      case 1009:
         var5.method1138(class245.field2969);
         break;
      case 1010:
         var5.method1138(class245.field2965);
         break;
      case 1011:
         var5.method1138(class245.field2970);
         break;
      case 1012:
         var5.method1138(class245.field2967);
      }

      AbstractSoundSystem.method2256(var5);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(I)Lao;",
      garbageValue = "-1678805927"
   )
   public MapIcon method6064() {
      if(!this.field4043.method5997()) {
         return null;
      } else if(!this.worldMapManager.method598()) {
         return null;
      } else {
         HashMap var1 = this.worldMapManager.method612();
         this.field4054 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field4054.addAll(var3);
         }

         this.field4006 = this.field4054.iterator();
         return this.method6065();
      }
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)Lao;",
      garbageValue = "559330705"
   )
   public MapIcon method6065() {
      return this.field4006 == null?null:(!this.field4006.hasNext()?null:(MapIcon)this.field4006.next());
   }
}
