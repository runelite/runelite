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
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("fontNameVerdana11")
   static final FontName fontNameVerdana11;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("fontNameVerdana13")
   static final FontName fontNameVerdana13;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("fontNameVerdana15")
   static final FontName fontNameVerdana15;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   IndexDataBase field4022;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkw;"
   )
   Font field4010;
   @ObfuscatedName("a")
   @Export("mapFonts")
   HashMap mapFonts;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   IndexedSprite[] field4012;
   @ObfuscatedName("f")
   @Export("worldMapDataByIdentifier")
   HashMap worldMapDataByIdentifier;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   WorldMapData field4014;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   @Export("worldMapData")
   WorldMapData worldMapData;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   WorldMapData field4013;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lag;"
   )
   @Export("worldMapManager")
   WorldMapManager worldMapManager;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Llw;"
   )
   class333 field4018;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2084277079
   )
   @Export("worldMapX")
   int worldMapX;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 858942121
   )
   @Export("worldMapY")
   int worldMapY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1179703793
   )
   int field4058;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 440748131
   )
   int field4007;
   @ObfuscatedName("g")
   @Export("worldMapZoom")
   float worldMapZoom;
   @ObfuscatedName("y")
   @Export("worldMapZoomTarget")
   float worldMapZoomTarget;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2139838999
   )
   int field4025;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 306820131
   )
   int field4017;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -712254929
   )
   int field4027;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 198996327
   )
   int field4028;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1948009863
   )
   int field4035;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 345858551
   )
   int field4030;
   @ObfuscatedName("ak")
   boolean field4031;
   @ObfuscatedName("as")
   HashSet field4032;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1045928297
   )
   int field4033;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 120322211
   )
   int field4034;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -658172263
   )
   int field4016;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1231625575
   )
   int field4036;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 657957417
   )
   int field4037;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -644393531
   )
   int field4038;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      longValue = -1697827831108886865L
   )
   long field4006;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1576368777
   )
   int field4026;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 2037468587
   )
   int field4041;
   @ObfuscatedName("ag")
   boolean field4042;
   @ObfuscatedName("at")
   HashSet field4043;
   @ObfuscatedName("av")
   HashSet field4044;
   @ObfuscatedName("az")
   HashSet field4045;
   @ObfuscatedName("aj")
   HashSet field4029;
   @ObfuscatedName("ar")
   boolean field4047;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1204769595
   )
   int field4048;
   @ObfuscatedName("bv")
   final int[] field4049;
   @ObfuscatedName("bw")
   List field4050;
   @ObfuscatedName("bj")
   Iterator field4051;
   @ObfuscatedName("ba")
   HashSet field4052;
   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   Coordinates field4040;
   @ObfuscatedName("br")
   public boolean field4054;
   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   SpritePixels field4055;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 630729317
   )
   int field4056;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -454993663
   )
   int field4057;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 213212441
   )
   int field4039;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1786363401
   )
   int field4059;

   static {
      fontNameVerdana11 = FontName.field3872;
      fontNameVerdana13 = FontName.field3873;
      fontNameVerdana15 = FontName.field3880;
   }

   public RenderOverview() {
      this.field4058 = -1;
      this.field4007 = -1;
      this.field4025 = -1;
      this.field4017 = -1;
      this.field4027 = -1;
      this.field4028 = -1;
      this.field4035 = 3;
      this.field4030 = 50;
      this.field4031 = false;
      this.field4032 = null;
      this.field4033 = -1;
      this.field4034 = -1;
      this.field4016 = -1;
      this.field4036 = -1;
      this.field4037 = -1;
      this.field4038 = -1;
      this.field4042 = true;
      this.field4043 = new HashSet();
      this.field4044 = new HashSet();
      this.field4045 = new HashSet();
      this.field4029 = new HashSet();
      this.field4047 = false;
      this.field4048 = 0;
      this.field4049 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field4052 = new HashSet();
      this.field4040 = null;
      this.field4054 = false;
      this.field4057 = -1;
      this.field4039 = -1;
      this.field4059 = -1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljm;Lkw;Ljava/util/HashMap;[Llq;I)V",
      garbageValue = "16711935"
   )
   public void method6049(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field4012 = var4;
      this.field4022 = var1;
      this.field4010 = var2;
      this.mapFonts = new HashMap();
      this.mapFonts.put(Size.field347, var3.get(fontNameVerdana11));
      this.mapFonts.put(Size.field346, var3.get(fontNameVerdana13));
      this.mapFonts.put(Size.field344, var3.get(fontNameVerdana15));
      this.field4018 = new class333(var1);
      int var5 = this.field4022.getFile(MapCacheArchiveNames.DETAILS.name);
      int[] var6 = this.field4022.getChilds(var5);
      this.worldMapDataByIdentifier = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field4022.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.worldMapDataByIdentifier.put(var9.getIdentifier(), var9);
         if(var9.method374()) {
            this.field4014 = var9;
         }
      }

      this.method6039(this.field4014);
      this.field4013 = null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method6010() {
      return this.field4022.tryLoadRecordByNames(this.field4014.getIdentifier(), MapCacheArchiveNames.AREA.name)?100:this.field4022.archiveLoadPercentByName(this.field4014.getIdentifier());
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-115"
   )
   public void method6011() {
      WorldMapRegion.field470.method3944(5);
      WorldMapRegion.field458.method3944(5);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "1355157211"
   )
   public void method6166(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field4018.method5999()) {
         this.method6153();
         this.method6016();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.worldMapZoom));
            int var9 = (int)Math.ceil((double)((float)var7 / this.worldMapZoom));
            List var10 = this.worldMapManager.method586(this.worldMapX - var8 / 2 - 1, this.worldMapY - var9 / 2 - 1, var8 / 2 + this.worldMapX + 1, var9 / 2 + this.worldMapY + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            MapIcon var13;
            ScriptEvent var14;
            MapIconReference var15;
            for(var12 = var10.iterator(); var12.hasNext(); AbstractByteBuffer.method3757(var14)) {
               var13 = (MapIcon)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new MapIconReference(var13.areaId, var13.field506, var13.field512);
               var14.method1102(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field4052.contains(var13)) {
                  var14.method1099(class245.field2956);
               } else {
                  var14.method1099(class245.field2952);
               }
            }

            var12 = this.field4052.iterator();

            while(var12.hasNext()) {
               var13 = (MapIcon)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new MapIconReference(var13.areaId, var13.field506, var13.field512);
                  var14.method1102(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1099(class245.field2955);
                  AbstractByteBuffer.method3757(var14);
               }
            }

            this.field4052 = var11;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIZZI)V",
      garbageValue = "1640258053"
   )
   public void method6013(int var1, int var2, boolean var3, boolean var4) {
      long var5 = ScriptVarType.method28();
      this.method6014(var1, var2, var4, var5);
      if(!this.method6019() && (var4 || var3)) {
         if(var4) {
            this.field4037 = var1;
            this.field4038 = var2;
            this.field4016 = this.worldMapX;
            this.field4036 = this.worldMapY;
         }

         if(this.field4016 != -1) {
            int var7 = var1 - this.field4037;
            int var8 = var2 - this.field4038;
            this.method6017(this.field4016 - (int)((float)var7 / this.worldMapZoomTarget), (int)((float)var8 / this.worldMapZoomTarget) + this.field4036, false);
         }
      } else {
         this.method6018();
      }

      if(var4) {
         this.field4006 = var5;
         this.field4026 = var1;
         this.field4041 = var2;
      }

   }

   @ObfuscatedName("x")
   void method6014(int var1, int var2, boolean var3, long var4) {
      if(this.worldMapData != null) {
         int var6 = (int)((float)this.worldMapX + ((float)(var1 - this.field4027) - (float)this.method6173() * this.worldMapZoom / 2.0F) / this.worldMapZoom);
         int var7 = (int)((float)this.worldMapY - ((float)(var2 - this.field4028) - (float)this.method6084() * this.worldMapZoom / 2.0F) / this.worldMapZoom);
         this.field4040 = this.worldMapData.method354(var6 + this.worldMapData.getMinX() * 64, var7 + this.worldMapData.getMinY() * 64);
         if(this.field4040 != null && var3) {
            if(class237.method4377() && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81]) {
               GrandExchangeOffer.method125(this.field4040.worldX, this.field4040.worldY, this.field4040.plane, false);
            } else {
               boolean var8 = true;
               if(this.field4042) {
                  int var9 = var1 - this.field4026;
                  int var10 = var2 - this.field4041;
                  if(var4 - this.field4006 > 500L || var9 < -25 || var9 > 25 || var10 < -25 || var10 > 25) {
                     var8 = false;
                  }
               }

               if(var8) {
                  PacketNode var11 = FaceNormal.method3078(ClientPacket.field2457, Client.field902.field1475);
                  var11.packetBuffer.method3677(this.field4040.bitpack());
                  Client.field902.method2036(var11);
                  this.field4006 = 0L;
               }
            }
         }
      } else {
         this.field4040 = null;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-408085666"
   )
   void method6153() {
      if(Client.field1132 != null) {
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "102037237"
   )
   void method6016() {
      if(this.method6019()) {
         int var1 = this.field4058 - this.worldMapX;
         int var2 = this.field4007 - this.worldMapY;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.method6017(var1 + this.worldMapX, var2 + this.worldMapY, true);
         if(this.worldMapX == this.field4058 && this.worldMapY == this.field4007) {
            this.field4058 = -1;
            this.field4007 = -1;
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-86174702"
   )
   final void method6017(int var1, int var2, boolean var3) {
      this.worldMapX = var1;
      this.worldMapY = var2;
      ScriptVarType.method28();
      if(var3) {
         this.method6018();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "13"
   )
   final void method6018() {
      this.field4038 = -1;
      this.field4037 = -1;
      this.field4036 = -1;
      this.field4016 = -1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1847675345"
   )
   boolean method6019() {
      return this.field4058 != -1 && this.field4007 != -1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIB)Las;",
      garbageValue = "29"
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-1211581182"
   )
   public void method6021(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.getWorldMapDataContainingCoord(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field4014;
      }

      boolean var6 = false;
      if(var5 != this.field4013 || var4) {
         this.field4013 = var5;
         this.method6039(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method6144(var1, var2, var3);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2097660034"
   )
   public void method6026(int var1) {
      WorldMapData var2 = this.getWorldMapDataByFileId(var1);
      if(var2 != null) {
         this.method6039(var2);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "539586463"
   )
   public int method6131() {
      return this.worldMapData == null?-1:this.worldMapData.getFileId();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Las;",
      garbageValue = "-1864187490"
   )
   public WorldMapData method6024() {
      return this.worldMapData;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "960749060"
   )
   void method6039(WorldMapData var1) {
      if(this.worldMapData == null || var1 != this.worldMapData) {
         this.initializeWorldMap(var1);
         this.method6144(-1, -1, -1);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "-123985502"
   )
   @Export("initializeWorldMap")
   void initializeWorldMap(WorldMapData var1) {
      this.worldMapData = var1;
      this.worldMapManager = new WorldMapManager(this.field4012, this.mapFonts);
      this.field4018.method5994(this.worldMapData.getIdentifier());
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Las;Lim;Lim;ZB)V",
      garbageValue = "90"
   )
   public void method6202(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.worldMapData == null || var1 != this.worldMapData) {
            this.initializeWorldMap(var1);
         }

         if(!var4 && this.worldMapData.containsCoord(var2.plane, var2.worldX, var2.worldY)) {
            this.method6144(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method6144(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "12"
   )
   void method6144(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method309(var1, var2, var3);
         if(var4 == null) {
            var4 = this.worldMapData.method309(this.worldMapData.method323(), this.worldMapData.method322(), this.worldMapData.method324());
         }

         this.method6017(var4[0] - this.worldMapData.getMinX() * 64, var4[1] - this.worldMapData.getMinY() * 64, true);
         this.field4058 = -1;
         this.field4007 = -1;
         this.worldMapZoom = this.method6035(this.worldMapData.method352());
         this.worldMapZoomTarget = this.worldMapZoom;
         this.field4050 = null;
         this.field4051 = null;
         this.worldMapManager.method619();
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-160617335"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      int var7 = this.field4018.method5997();
      if(var7 < 100) {
         this.method6034(var1, var2, var3, var4, var7);
      } else {
         if(!this.worldMapManager.method588()) {
            this.worldMapManager.load(this.field4022, this.worldMapData.getIdentifier(), Client.isMembers);
            if(!this.worldMapManager.method588()) {
               return;
            }
         }

         if(this.field4032 != null) {
            ++this.field4034;
            if(this.field4034 % this.field4030 == 0) {
               this.field4034 = 0;
               ++this.field4033;
            }

            if(this.field4033 >= this.field4035 && !this.field4031) {
               this.field4032 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.worldMapZoom));
         int var9 = (int)Math.ceil((double)((float)var4 / this.worldMapZoom));
         this.worldMapManager.drawMapRegion(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, var1, var2, var3 + var1, var2 + var4);
         if(!this.field4047) {
            boolean var10 = false;
            if(var5 - this.field4048 > 100) {
               this.field4048 = var5;
               var10 = true;
            }

            this.worldMapManager.drawMapIcons(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, var1, var2, var3 + var1, var2 + var4, this.field4029, this.field4032, this.field4034, this.field4030, var10);
         }

         this.method6031(var1, var2, var3, var4, var8, var9);
         if(class237.method4377() && this.field4054 && this.field4040 != null) {
            this.field4010.method5521("Coord: " + this.field4040, Rasterizer2D.draw_region_x + 10, Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
         }

         this.field4025 = var8;
         this.field4017 = var9;
         this.field4027 = var1;
         this.field4028 = var2;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IIIIIII)Z",
      garbageValue = "-938179055"
   )
   boolean method6029(int var1, int var2, int var3, int var4, int var5, int var6) {
      return this.field4055 == null?true:(this.field4055.width == var1 && this.field4055.height == var2?(this.worldMapManager.field535 != this.field4056?true:(this.field4059 != Client.field972?true:(var3 <= 0 && var4 <= 0?var3 + var1 < var5 || var2 + var4 < var6:true))):true);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "48"
   )
   void method6031(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field1132 != null) {
         int var7 = 512 / (this.worldMapManager.field535 * 2);
         int var8 = var3 + 512;
         int var9 = var4 + 512;
         float var10 = 1.0F;
         var8 = (int)((float)var8 / var10);
         var9 = (int)((float)var9 / var10);
         int var11 = this.method6181() - var5 / 2 - var7;
         int var12 = this.method6081() - var6 / 2 - var7;
         int var13 = var1 - (var11 + var7 - this.field4057) * this.worldMapManager.field535;
         int var14 = var2 - this.worldMapManager.field535 * (var7 - (var12 - this.field4039));
         if(this.method6029(var8, var9, var13, var14, var3, var4)) {
            if(this.field4055 != null && this.field4055.width == var8 && this.field4055.height == var9) {
               Arrays.fill(this.field4055.pixels, 0);
            } else {
               this.field4055 = new SpritePixels(var8, var9);
            }

            this.field4057 = this.method6181() - var5 / 2 - var7;
            this.field4039 = this.method6081() - var6 / 2 - var7;
            this.field4056 = this.worldMapManager.field535;
            Client.field1132.method4711(this.field4057, this.field4039, this.field4055, (float)this.field4056 / var10);
            this.field4059 = Client.field972;
            var13 = var1 - (var7 + var11 - this.field4057) * this.worldMapManager.field535;
            var14 = var2 - this.worldMapManager.field535 * (var7 - (var12 - this.field4039));
         }

         Rasterizer2D.fillRectangle(var1, var2, var3, var4, 0, 128);
         if(1.0F == var10) {
            this.field4055.method5879(var13, var14, 192);
         } else {
            this.field4055.method5939(var13, var14, (int)(var10 * (float)var8), (int)(var10 * (float)var9), 192);
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "327416106"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field4018.method5999()) {
         if(!this.worldMapManager.method588()) {
            this.worldMapManager.load(this.field4022, this.worldMapData.getIdentifier(), Client.isMembers);
            if(!this.worldMapManager.method588()) {
               return;
            }
         }

         this.worldMapManager.method620(var1, var2, var3, var4, this.field4032, this.field4034, this.field4030);
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-19"
   )
   public void method6133(int var1) {
      this.worldMapZoomTarget = this.method6035(var1);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "718919850"
   )
   void method6034(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.Rasterizer2D_fillRectangle(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field4010.drawTextCentered("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II)F",
      garbageValue = "1023835628"
   )
   float method6035(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1560261993"
   )
   public int method6036() {
      return 1.0D == (double)this.worldMapZoomTarget?25:(1.5D == (double)this.worldMapZoomTarget?37:(2.0D == (double)this.worldMapZoomTarget?50:((double)this.worldMapZoomTarget == 3.0D?75:((double)this.worldMapZoomTarget == 4.0D?100:200))));
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "256"
   )
   public void method6108() {
      this.field4018.method5995();
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "10"
   )
   public boolean method6038() {
      return this.field4018.method5999();
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IB)Las;",
      garbageValue = "-29"
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

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "823215735"
   )
   public void method6097(int var1, int var2) {
      if(this.worldMapData != null && this.worldMapData.method308(var1, var2)) {
         this.field4058 = var1 - this.worldMapData.getMinX() * 64;
         this.field4007 = var2 - this.worldMapData.getMinY() * 64;
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-129635329"
   )
   public void method6143(int var1, int var2) {
      if(this.worldMapData != null) {
         this.method6017(var1 - this.worldMapData.getMinX() * 64, var2 - this.worldMapData.getMinY() * 64, true);
         this.field4058 = -1;
         this.field4007 = -1;
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1279331054"
   )
   public void method6042(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method309(var1, var2, var3);
         if(var4 != null) {
            this.method6097(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1285173091"
   )
   public void method6196(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method309(var1, var2, var3);
         if(var4 != null) {
            this.method6143(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2128919966"
   )
   public int method6181() {
      return this.worldMapData == null?-1:this.worldMapX + this.worldMapData.getMinX() * 64;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method6081() {
      return this.worldMapData == null?-1:this.worldMapY + this.worldMapData.getMinY() * 64;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)Lim;",
      garbageValue = "-1324206859"
   )
   public Coordinates method6053() {
      return this.worldMapData == null?null:this.worldMapData.method354(this.method6181(), this.method6081());
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1750330915"
   )
   public int method6173() {
      return this.field4025;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-500206409"
   )
   public int method6084() {
      return this.field4017;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-112301360"
   )
   public void method6030(int var1) {
      if(var1 >= 1) {
         this.field4035 = var1;
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   public void method6050() {
      this.field4035 = 3;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "518060547"
   )
   public void method6051(int var1) {
      if(var1 >= 1) {
         this.field4030 = var1;
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   public void method6052() {
      this.field4030 = 50;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2145323297"
   )
   public void method6066(boolean var1) {
      this.field4031 = var1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2065525415"
   )
   public void method6054(int var1) {
      this.field4032 = new HashSet();
      this.field4032.add(Integer.valueOf(var1));
      this.field4033 = 0;
      this.field4034 = 0;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1901239654"
   )
   public void method6075(int var1) {
      this.field4032 = new HashSet();
      this.field4033 = 0;
      this.field4034 = 0;

      for(int var2 = 0; var2 < Area.mapAreaType.length; ++var2) {
         if(Area.mapAreaType[var2] != null && Area.mapAreaType[var2].field3463 == var1) {
            this.field4032.add(Integer.valueOf(Area.mapAreaType[var2].id));
         }
      }

   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "17274531"
   )
   public void method6056() {
      this.field4032 = null;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1170625294"
   )
   public void method6057(boolean var1) {
      this.field4047 = !var1;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "63"
   )
   public void method6058(int var1, boolean var2) {
      if(!var2) {
         this.field4043.add(Integer.valueOf(var1));
      } else {
         this.field4043.remove(Integer.valueOf(var1));
      }

      this.method6063();
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "554929871"
   )
   public void method6059(int var1, boolean var2) {
      if(!var2) {
         this.field4044.add(Integer.valueOf(var1));
      } else {
         this.field4044.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.mapAreaType.length; ++var3) {
         if(Area.mapAreaType[var3] != null && Area.mapAreaType[var3].field3463 == var1) {
            int var4 = Area.mapAreaType[var3].id;
            if(!var2) {
               this.field4045.add(Integer.valueOf(var4));
            } else {
               this.field4045.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method6063();
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1596985739"
   )
   public boolean method6060() {
      return !this.field4047;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-185339468"
   )
   public boolean method6061(int var1) {
      return !this.field4043.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1565500085"
   )
   public boolean method6062(int var1) {
      return !this.field4044.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-127819397"
   )
   void method6063() {
      this.field4029.clear();
      this.field4029.addAll(this.field4043);
      this.field4029.addAll(this.field4045);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1946246363"
   )
   public void method6064(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field4018.method5999()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.worldMapZoom));
         int var8 = (int)Math.ceil((double)((float)var4 / this.worldMapZoom));
         List var9 = this.worldMapManager.method586(this.worldMapX - var7 / 2 - 1, this.worldMapY - var8 / 2 - 1, var7 / 2 + this.worldMapX + 1, var8 / 2 + this.worldMapY + 1, var1, var2, var3, var4, var5, var6);
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

               for(int var14 = this.field4049.length - 1; var14 >= 0; --var14) {
                  if(var12.field3461[var14] != null) {
                     RunException.addMenuEntry(var12.field3461[var14], var12.field3460, this.field4049[var14], var11.areaId, var11.field506.bitpack(), var11.field512.bitpack());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(ILim;I)Lim;",
      garbageValue = "-881888672"
   )
   public Coordinates method6065(int var1, Coordinates var2) {
      if(!this.field4018.method5999()) {
         return null;
      } else if(!this.worldMapManager.method588()) {
         return null;
      } else if(!this.worldMapData.method308(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.worldMapManager.method589();
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
                     return var5.field512;
                  }

                  var8 = (MapIcon)var7.next();
                  int var9 = var8.field512.worldX - var2.worldX;
                  int var10 = var8.field512.worldY - var2.worldY;
                  var11 = var9 * var9 + var10 * var10;
                  if(var11 == 0) {
                     return var8.field512;
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
      signature = "(IILim;Lim;S)V",
      garbageValue = "-4323"
   )
   @Export("onMapClicked")
   public void onMapClicked(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      MapIconReference var6 = new MapIconReference(var2, var3, var4);
      var5.method1102(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1099(class245.field2950);
         break;
      case 1009:
         var5.method1099(class245.field2951);
         break;
      case 1010:
         var5.method1099(class245.field2959);
         break;
      case 1011:
         var5.method1099(class245.field2949);
         break;
      case 1012:
         var5.method1099(class245.field2953);
      }

      AbstractByteBuffer.method3757(var5);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)Law;",
      garbageValue = "1311190374"
   )
   public MapIcon method6080() {
      if(!this.field4018.method5999()) {
         return null;
      } else if(!this.worldMapManager.method588()) {
         return null;
      } else {
         HashMap var1 = this.worldMapManager.method589();
         this.field4050 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field4050.addAll(var3);
         }

         this.field4051 = this.field4050.iterator();
         return this.method6068();
      }
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(I)Law;",
      garbageValue = "-1978457448"
   )
   public MapIcon method6068() {
      return this.field4051 == null?null:(!this.field4051.hasNext()?null:(MapIcon)this.field4051.next());
   }
}
