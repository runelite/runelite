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

@ObfuscatedName("lo")
@Implements("RenderOverview")
public class RenderOverview {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   @Export("fontNameVerdana11")
   static final FontName fontNameVerdana11;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   @Export("fontNameVerdana13")
   static final FontName fontNameVerdana13;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   @Export("fontNameVerdana15")
   static final FontName fontNameVerdana15;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   IndexDataBase field4011;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lkm;"
   )
   Font field4030;
   @ObfuscatedName("o")
   @Export("mapFonts")
   HashMap mapFonts;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "[Llk;"
   )
   IndexedSprite[] field4054;
   @ObfuscatedName("v")
   @Export("worldMapDataByIdentifier")
   HashMap worldMapDataByIdentifier;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   WorldMapData field4019;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   @Export("worldMapData")
   WorldMapData worldMapData;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   WorldMapData field4021;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lag;"
   )
   @Export("worldMapManager")
   WorldMapManager worldMapManager;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Llg;"
   )
   class333 field4023;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1593917541
   )
   @Export("worldMapX")
   int worldMapX;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1927995219
   )
   @Export("worldMapY")
   int worldMapY;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 617911765
   )
   int field4058;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1440402777
   )
   int field4038;
   @ObfuscatedName("y")
   @Export("worldMapZoom")
   float worldMapZoom;
   @ObfuscatedName("h")
   @Export("worldMapZoomTarget")
   float worldMapZoomTarget;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1270826085
   )
   int field4034;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 457580737
   )
   int field4031;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -870503361
   )
   int field4063;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1552771477
   )
   int field4033;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1516252767
   )
   int field4065;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1313477223
   )
   int field4035;
   @ObfuscatedName("am")
   boolean field4036;
   @ObfuscatedName("az")
   HashSet field4026;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1166474223
   )
   int field4041;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -173049769
   )
   int field4007;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 742831325
   )
   int field4018;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -939033645
   )
   int field4032;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -584040041
   )
   int field4042;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1546706885
   )
   int field4017;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      longValue = 5881410833357243083L
   )
   long field4040;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1700616233
   )
   int field4039;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 402883761
   )
   int field4046;
   @ObfuscatedName("ag")
   boolean field4027;
   @ObfuscatedName("aq")
   HashSet field4047;
   @ObfuscatedName("aa")
   HashSet field4051;
   @ObfuscatedName("af")
   HashSet field4052;
   @ObfuscatedName("ak")
   HashSet field4053;
   @ObfuscatedName("ab")
   boolean field4015;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 38466795
   )
   int field4050;
   @ObfuscatedName("bg")
   final int[] field4056;
   @ObfuscatedName("br")
   List field4055;
   @ObfuscatedName("ba")
   Iterator field4043;
   @ObfuscatedName("bk")
   HashSet field4029;
   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   Coordinates field4060;
   @ObfuscatedName("bc")
   public boolean field4061;
   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   SpritePixels field4062;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 974118911
   )
   int field4037;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -1512729589
   )
   int field4064;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 1953204963
   )
   int field4044;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 1802480405
   )
   int field4066;

   static {
      fontNameVerdana11 = FontName.field3878;
      fontNameVerdana13 = FontName.field3877;
      fontNameVerdana15 = FontName.field3880;
   }

   public RenderOverview() {
      this.field4058 = -1;
      this.field4038 = -1;
      this.field4034 = -1;
      this.field4031 = -1;
      this.field4063 = -1;
      this.field4033 = -1;
      this.field4065 = 3;
      this.field4035 = 50;
      this.field4036 = false;
      this.field4026 = null;
      this.field4041 = -1;
      this.field4007 = -1;
      this.field4018 = -1;
      this.field4032 = -1;
      this.field4042 = -1;
      this.field4017 = -1;
      this.field4027 = true;
      this.field4047 = new HashSet();
      this.field4051 = new HashSet();
      this.field4052 = new HashSet();
      this.field4053 = new HashSet();
      this.field4015 = false;
      this.field4050 = 0;
      this.field4056 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field4029 = new HashSet();
      this.field4060 = null;
      this.field4061 = false;
      this.field4064 = -1;
      this.field4044 = -1;
      this.field4066 = -1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljc;Lkm;Ljava/util/HashMap;[Llk;I)V",
      garbageValue = "-1229331830"
   )
   public void method5988(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field4054 = var4;
      this.field4011 = var1;
      this.field4030 = var2;
      this.mapFonts = new HashMap();
      this.mapFonts.put(Size.field343, var3.get(fontNameVerdana11));
      this.mapFonts.put(Size.field335, var3.get(fontNameVerdana13));
      this.mapFonts.put(Size.field334, var3.get(fontNameVerdana15));
      this.field4023 = new class333(var1);
      int var5 = this.field4011.getFile(MapCacheArchiveNames.DETAILS.name);
      int[] var6 = this.field4011.getChilds(var5);
      this.worldMapDataByIdentifier = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field4011.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.worldMapDataByIdentifier.put(var9.getIdentifier(), var9);
         if(var9.method351()) {
            this.field4019 = var9;
         }
      }

      this.method6004(this.field4019);
      this.field4021 = null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "335802232"
   )
   public int method6011() {
      return this.field4011.tryLoadRecordByNames(this.field4019.getIdentifier(), MapCacheArchiveNames.AREA.name)?100:this.field4011.archiveLoadPercentByName(this.field4019.getIdentifier());
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1193735117"
   )
   public void method5990() {
      class151.method3120();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIZIIIIB)V",
      garbageValue = "8"
   )
   public void method5991(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field4023.method5973()) {
         this.method6015();
         this.method5995();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.worldMapZoom));
            int var9 = (int)Math.ceil((double)((float)var7 / this.worldMapZoom));
            List var10 = this.worldMapManager.method615(this.worldMapX - var8 / 2 - 1, this.worldMapY - var9 / 2 - 1, var8 / 2 + this.worldMapX + 1, var9 / 2 + this.worldMapY + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            MapIcon var13;
            ScriptEvent var14;
            MapIconReference var15;
            for(var12 = var10.iterator(); var12.hasNext(); class25.runScript(var14, 500000)) {
               var13 = (MapIcon)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new MapIconReference(var13.areaId, var13.field511, var13.field510);
               var14.method1153(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field4029.contains(var13)) {
                  var14.method1152(class245.field2962);
               } else {
                  var14.method1152(class245.field2960);
               }
            }

            var12 = this.field4029.iterator();

            while(var12.hasNext()) {
               var13 = (MapIcon)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new MapIconReference(var13.areaId, var13.field511, var13.field510);
                  var14.method1153(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1152(class245.field2956);
                  class25.runScript(var14, 500000);
               }
            }

            this.field4029 = var11;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIZZI)V",
      garbageValue = "1884777800"
   )
   public void method6122(int var1, int var2, boolean var3, boolean var4) {
      long var5 = WorldMapRegion.method465();
      this.method5993(var1, var2, var4, var5);
      if(!this.method5998() && (var4 || var3)) {
         if(var4) {
            this.field4042 = var1;
            this.field4017 = var2;
            this.field4018 = this.worldMapX;
            this.field4032 = this.worldMapY;
         }

         if(this.field4018 != -1) {
            int var7 = var1 - this.field4042;
            int var8 = var2 - this.field4017;
            this.method5996(this.field4018 - (int)((float)var7 / this.worldMapZoomTarget), (int)((float)var8 / this.worldMapZoomTarget) + this.field4032, false);
         }
      } else {
         this.method5997();
      }

      if(var4) {
         this.field4040 = var5;
         this.field4039 = var1;
         this.field4046 = var2;
      }

   }

   @ObfuscatedName("b")
   void method5993(int var1, int var2, boolean var3, long var4) {
      if(this.worldMapData != null) {
         int var6 = (int)((float)this.worldMapX + ((float)(var1 - this.field4063) - (float)this.method6025() * this.worldMapZoom / 2.0F) / this.worldMapZoom);
         int var7 = (int)((float)this.worldMapY - ((float)(var2 - this.field4033) - (float)this.method6026() * this.worldMapZoom / 2.0F) / this.worldMapZoom);
         this.field4060 = this.worldMapData.method296(var6 + this.worldMapData.getMinX() * 64, var7 + this.worldMapData.getMinY() * 64);
         if(this.field4060 != null && var3) {
            boolean var8 = Client.rights >= 2;
            if(var8 && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81]) {
               FileOnDisk.method2542(this.field4060.worldX, this.field4060.worldY, this.field4060.plane, false);
            } else {
               boolean var9 = true;
               if(this.field4027) {
                  int var10 = var1 - this.field4039;
                  int var11 = var2 - this.field4046;
                  if(var4 - this.field4040 > 500L || var10 < -25 || var10 > 25 || var11 < -25 || var11 > 25) {
                     var9 = false;
                  }
               }

               if(var9) {
                  PacketNode var12 = class33.method382(ClientPacket.field2418, Client.field1072.field1456);
                  var12.packetBuffer.method3713(this.field4060.bitpack());
                  Client.field1072.method2073(var12);
                  this.field4040 = 0L;
               }
            }
         }
      } else {
         this.field4060 = null;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1756285052"
   )
   void method6015() {
      if(NetWriter.field1467 != null) {
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1225798340"
   )
   void method5995() {
      if(this.method5998()) {
         int var1 = this.field4058 - this.worldMapX;
         int var2 = this.field4038 - this.worldMapY;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.method5996(var1 + this.worldMapX, var2 + this.worldMapY, true);
         if(this.worldMapX == this.field4058 && this.worldMapY == this.field4038) {
            this.field4058 = -1;
            this.field4038 = -1;
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "1943207091"
   )
   final void method5996(int var1, int var2, boolean var3) {
      this.worldMapX = var1;
      this.worldMapY = var2;
      WorldMapRegion.method465();
      if(var3) {
         this.method5997();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "116"
   )
   final void method5997() {
      this.field4017 = -1;
      this.field4042 = -1;
      this.field4032 = -1;
      this.field4018 = -1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1284870096"
   )
   boolean method5998() {
      return this.field4058 != -1 && this.field4038 != -1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIB)Laz;",
      garbageValue = "-41"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIZB)V",
      garbageValue = "0"
   )
   public void method6072(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.getWorldMapDataContainingCoord(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field4019;
      }

      boolean var6 = false;
      if(var5 != this.field4021 || var4) {
         this.field4021 = var5;
         this.method6004(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method6142(var1, var2, var3);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-261388468"
   )
   public void method6160(int var1) {
      WorldMapData var2 = this.getWorldMapDataByFileId(var1);
      if(var2 != null) {
         this.method6004(var2);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method6002() {
      return this.worldMapData == null?-1:this.worldMapData.getFileId();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Laz;",
      garbageValue = "32"
   )
   public WorldMapData method6107() {
      return this.worldMapData;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Laz;B)V",
      garbageValue = "-76"
   )
   void method6004(WorldMapData var1) {
      if(this.worldMapData == null || var1 != this.worldMapData) {
         this.initializeWorldMap(var1);
         this.method6142(-1, -1, -1);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Laz;I)V",
      garbageValue = "1635946476"
   )
   @Export("initializeWorldMap")
   void initializeWorldMap(WorldMapData var1) {
      this.worldMapData = var1;
      this.worldMapManager = new WorldMapManager(this.field4054, this.mapFonts);
      this.field4023.method5974(this.worldMapData.getIdentifier());
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Laz;Lik;Lik;ZI)V",
      garbageValue = "2012190903"
   )
   public void method6006(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.worldMapData == null || var1 != this.worldMapData) {
            this.initializeWorldMap(var1);
         }

         if(!var4 && this.worldMapData.containsCoord(var2.plane, var2.worldX, var2.worldY)) {
            this.method6142(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method6142(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1939332546"
   )
   void method6142(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method299(var1, var2, var3);
         if(var4 == null) {
            var4 = this.worldMapData.method299(this.worldMapData.method308(), this.worldMapData.method307(), this.worldMapData.method309());
         }

         this.method5996(var4[0] - this.worldMapData.getMinX() * 64, var4[1] - this.worldMapData.getMinY() * 64, true);
         this.field4058 = -1;
         this.field4038 = -1;
         this.worldMapZoom = this.method6014(this.worldMapData.method367());
         this.worldMapZoomTarget = this.worldMapZoom;
         this.field4055 = null;
         this.field4043 = null;
         this.worldMapManager.method630();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "763902009"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      int var7 = this.field4023.method5977();
      if(var7 < 100) {
         this.method6127(var1, var2, var3, var4, var7);
      } else {
         if(!this.worldMapManager.method604()) {
            this.worldMapManager.load(this.field4011, this.worldMapData.getIdentifier(), Client.isMembers);
            if(!this.worldMapManager.method604()) {
               return;
            }
         }

         if(this.field4026 != null) {
            ++this.field4007;
            if(this.field4007 % this.field4035 == 0) {
               this.field4007 = 0;
               ++this.field4041;
            }

            if(this.field4041 >= this.field4065 && !this.field4036) {
               this.field4026 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.worldMapZoom));
         int var9 = (int)Math.ceil((double)((float)var4 / this.worldMapZoom));
         this.worldMapManager.drawMapRegion(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, var1, var2, var3 + var1, var2 + var4);
         boolean var10;
         if(!this.field4015) {
            var10 = false;
            if(var5 - this.field4050 > 100) {
               this.field4050 = var5;
               var10 = true;
            }

            this.worldMapManager.drawMapIcons(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, var1, var2, var3 + var1, var2 + var4, this.field4053, this.field4026, this.field4007, this.field4035, var10);
         }

         this.method6010(var1, var2, var3, var4, var8, var9);
         var10 = Client.rights >= 2;
         if(var10 && this.field4061 && this.field4060 != null) {
            this.field4030.method5500("Coord: " + this.field4060, Rasterizer2D.draw_region_x + 10, Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
         }

         this.field4034 = var8;
         this.field4031 = var9;
         this.field4063 = var1;
         this.field4033 = var2;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IIIIIII)Z",
      garbageValue = "1417981676"
   )
   boolean method6164(int var1, int var2, int var3, int var4, int var5, int var6) {
      return this.field4062 == null?true:(this.field4062.width == var1 && this.field4062.height == var2?(this.worldMapManager.field531 != this.field4037?true:(this.field4066 != Client.field1114?true:(var3 <= 0 && var4 <= 0?var3 + var1 < var5 || var2 + var4 < var6:true))):true);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "0"
   )
   void method6010(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(NetWriter.field1467 != null) {
         int var7 = 512 / (this.worldMapManager.field531 * 2);
         int var8 = var3 + 512;
         int var9 = var4 + 512;
         float var10 = 1.0F;
         var8 = (int)((float)var8 / var10);
         var9 = (int)((float)var9 / var10);
         int var11 = this.method6132() - var5 / 2 - var7;
         int var12 = this.method6023() - var6 / 2 - var7;
         int var13 = var1 - (var11 + var7 - this.field4064) * this.worldMapManager.field531;
         int var14 = var2 - this.worldMapManager.field531 * (var7 - (var12 - this.field4044));
         if(this.method6164(var8, var9, var13, var14, var3, var4)) {
            if(this.field4062 != null && this.field4062.width == var8 && this.field4062.height == var9) {
               Arrays.fill(this.field4062.pixels, 0);
            } else {
               this.field4062 = new SpritePixels(var8, var9);
            }

            this.field4064 = this.method6132() - var5 / 2 - var7;
            this.field4044 = this.method6023() - var6 / 2 - var7;
            this.field4037 = this.worldMapManager.field531;
            NetWriter.field1467.method4727(this.field4064, this.field4044, this.field4062, (float)this.field4037 / var10);
            this.field4066 = Client.field1114;
            var13 = var1 - (var11 + var7 - this.field4064) * this.worldMapManager.field531;
            var14 = var2 - this.worldMapManager.field531 * (var7 - (var12 - this.field4044));
         }

         Rasterizer2D.fillRectangle(var1, var2, var3, var4, 0, 128);
         if(var10 == 1.0F) {
            this.field4062.method5852(var13, var14, 192);
         } else {
            this.field4062.method5837(var13, var14, (int)((float)var8 * var10), (int)((float)var9 * var10), 192);
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-348110385"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field4023.method5973()) {
         if(!this.worldMapManager.method604()) {
            this.worldMapManager.load(this.field4011, this.worldMapData.getIdentifier(), Client.isMembers);
            if(!this.worldMapManager.method604()) {
               return;
            }
         }

         this.worldMapManager.method617(var1, var2, var3, var4, this.field4026, this.field4007, this.field4035);
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1666695028"
   )
   public void method6012(int var1) {
      this.worldMapZoomTarget = this.method6014(var1);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "227602042"
   )
   void method6127(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.Rasterizer2D_fillRectangle(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field4030.drawTextCentered("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IB)F",
      garbageValue = "97"
   )
   float method6014(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1599027539"
   )
   public int method6005() {
      return 1.0D == (double)this.worldMapZoomTarget?25:((double)this.worldMapZoomTarget == 1.5D?37:((double)this.worldMapZoomTarget == 2.0D?50:((double)this.worldMapZoomTarget == 3.0D?75:(4.0D == (double)this.worldMapZoomTarget?100:200))));
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1076054930"
   )
   public void method6032() {
      this.field4023.method5981();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2135107447"
   )
   public boolean method6050() {
      return this.field4023.method5973();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)Laz;",
      garbageValue = "-1816675674"
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

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1025236852"
   )
   public void method6047(int var1, int var2) {
      if(this.worldMapData != null && this.worldMapData.method294(var1, var2)) {
         this.field4058 = var1 - this.worldMapData.getMinX() * 64;
         this.field4038 = var2 - this.worldMapData.getMinY() * 64;
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "613983880"
   )
   public void method6019(int var1, int var2) {
      if(this.worldMapData != null) {
         this.method5996(var1 - this.worldMapData.getMinX() * 64, var2 - this.worldMapData.getMinY() * 64, true);
         this.field4058 = -1;
         this.field4038 = -1;
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1729605121"
   )
   public void method6020(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method299(var1, var2, var3);
         if(var4 != null) {
            this.method6047(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-27"
   )
   public void method6021(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method299(var1, var2, var3);
         if(var4 != null) {
            this.method6019(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-303068251"
   )
   public int method6132() {
      return this.worldMapData == null?-1:this.worldMapX + this.worldMapData.getMinX() * 64;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-118"
   )
   public int method6023() {
      return this.worldMapData == null?-1:this.worldMapY + this.worldMapData.getMinY() * 64;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)Lik;",
      garbageValue = "1213654071"
   )
   public Coordinates method6024() {
      return this.worldMapData == null?null:this.worldMapData.method296(this.method6132(), this.method6023());
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "54120977"
   )
   public int method6025() {
      return this.field4034;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1957327514"
   )
   public int method6026() {
      return this.field4031;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-393353698"
   )
   public void method6027(int var1) {
      if(var1 >= 1) {
         this.field4065 = var1;
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-11"
   )
   public void method6028() {
      this.field4065 = 3;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1254707774"
   )
   public void method6030(int var1) {
      if(var1 >= 1) {
         this.field4035 = var1;
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public void method6123() {
      this.field4035 = 50;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-51"
   )
   public void method6031(boolean var1) {
      this.field4036 = var1;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1202943116"
   )
   public void method6071(int var1) {
      this.field4026 = new HashSet();
      this.field4026.add(Integer.valueOf(var1));
      this.field4041 = 0;
      this.field4007 = 0;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "54"
   )
   public void method6120(int var1) {
      this.field4026 = new HashSet();
      this.field4041 = 0;
      this.field4007 = 0;

      for(int var2 = 0; var2 < Area.mapAreaType.length; ++var2) {
         if(Area.mapAreaType[var2] != null && Area.mapAreaType[var2].field3474 == var1) {
            this.field4026.add(Integer.valueOf(Area.mapAreaType[var2].id));
         }
      }

   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1810433274"
   )
   public void method6034() {
      this.field4026 = null;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1656360880"
   )
   public void method6149(boolean var1) {
      this.field4015 = !var1;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1268050434"
   )
   public void method6036(int var1, boolean var2) {
      if(!var2) {
         this.field4047.add(Integer.valueOf(var1));
      } else {
         this.field4047.remove(Integer.valueOf(var1));
      }

      this.method6051();
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "5632822"
   )
   public void method6037(int var1, boolean var2) {
      if(!var2) {
         this.field4051.add(Integer.valueOf(var1));
      } else {
         this.field4051.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.mapAreaType.length; ++var3) {
         if(Area.mapAreaType[var3] != null && Area.mapAreaType[var3].field3474 == var1) {
            int var4 = Area.mapAreaType[var3].id;
            if(!var2) {
               this.field4052.add(Integer.valueOf(var4));
            } else {
               this.field4052.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method6051();
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-1"
   )
   public boolean method6038() {
      return !this.field4015;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "16"
   )
   public boolean method6093(int var1) {
      return !this.field4047.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "12"
   )
   public boolean method6073(int var1) {
      return !this.field4051.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "13"
   )
   void method6051() {
      this.field4053.clear();
      this.field4053.addAll(this.field4047);
      this.field4053.addAll(this.field4052);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-322581905"
   )
   public void method6080(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field4023.method5973()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.worldMapZoom));
         int var8 = (int)Math.ceil((double)((float)var4 / this.worldMapZoom));
         List var9 = this.worldMapManager.method615(this.worldMapX - var7 / 2 - 1, this.worldMapY - var8 / 2 - 1, var7 / 2 + this.worldMapX + 1, var8 / 2 + this.worldMapY + 1, var1, var2, var3, var4, var5, var6);
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

               for(int var14 = this.field4056.length - 1; var14 >= 0; --var14) {
                  if(var12.field3465[var14] != null) {
                     class169.addMenuEntry(var12.field3465[var14], var12.field3476, this.field4056[var14], var11.areaId, var11.field511.bitpack(), var11.field510.bitpack());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(ILik;B)Lik;",
      garbageValue = "38"
   )
   public Coordinates method6043(int var1, Coordinates var2) {
      if(!this.field4023.method5973()) {
         return null;
      } else if(!this.worldMapManager.method604()) {
         return null;
      } else if(!this.worldMapData.method294(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.worldMapManager.method597();
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
                     return var5.field510;
                  }

                  var8 = (MapIcon)var7.next();
                  int var9 = var8.field510.worldX - var2.worldX;
                  int var10 = var8.field510.worldY - var2.worldY;
                  var11 = var10 * var10 + var9 * var9;
                  if(var11 == 0) {
                     return var8.field510;
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

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IILik;Lik;I)V",
      garbageValue = "1054425186"
   )
   @Export("onMapClicked")
   public void onMapClicked(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      MapIconReference var6 = new MapIconReference(var2, var3, var4);
      var5.method1153(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1152(class245.field2965);
         break;
      case 1009:
         var5.method1152(class245.field2964);
         break;
      case 1010:
         var5.method1152(class245.field2957);
         break;
      case 1011:
         var5.method1152(class245.field2958);
         break;
      case 1012:
         var5.method1152(class245.field2955);
      }

      class25.runScript(var5, 500000);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)Lal;",
      garbageValue = "1043008294"
   )
   public MapIcon method6007() {
      if(!this.field4023.method5973()) {
         return null;
      } else if(!this.worldMapManager.method604()) {
         return null;
      } else {
         HashMap var1 = this.worldMapManager.method597();
         this.field4055 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field4055.addAll(var3);
         }

         this.field4043 = this.field4055.iterator();
         return this.method6046();
      }
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)Lal;",
      garbageValue = "-617761992"
   )
   public MapIcon method6046() {
      return this.field4043 == null?null:(!this.field4043.hasNext()?null:(MapIcon)this.field4043.next());
   }
}
