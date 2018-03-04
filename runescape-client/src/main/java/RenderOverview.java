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
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   @Export("fontNameVerdana11")
   static final FontName fontNameVerdana11;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   @Export("fontNameVerdana13")
   static final FontName fontNameVerdana13;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   @Export("fontNameVerdana15")
   static final FontName fontNameVerdana15;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   IndexDataBase field4058;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lkw;"
   )
   Font field4011;
   @ObfuscatedName("h")
   @Export("mapFonts")
   HashMap mapFonts;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   IndexedSprite[] field4013;
   @ObfuscatedName("i")
   HashMap field4014;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   WorldMapData field4020;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   @Export("worldMapData")
   WorldMapData worldMapData;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   WorldMapData field4017;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lag;"
   )
   @Export("worldMapManager")
   WorldMapManager worldMapManager;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lls;"
   )
   class333 field4019;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1514711959
   )
   @Export("worldMapX")
   int worldMapX;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 970454361
   )
   @Export("worldMapY")
   int worldMapY;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -34578857
   )
   int field4022;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -389371339
   )
   int field4023;
   @ObfuscatedName("w")
   @Export("worldMapZoom")
   float worldMapZoom;
   @ObfuscatedName("o")
   @Export("worldMapZoomTarget")
   float worldMapZoomTarget;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1814815485
   )
   int field4026;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1554577159
   )
   int field4027;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1385783337
   )
   int field4028;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -848336073
   )
   int field4004;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 2084129549
   )
   int field4015;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1973469379
   )
   int field4043;
   @ObfuscatedName("au")
   boolean field4030;
   @ObfuscatedName("al")
   HashSet field4033;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1592984697
   )
   int field4041;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -689628191
   )
   int field4035;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1890459881
   )
   int field4059;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1600363729
   )
   int field4037;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1721520701
   )
   int field4038;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1886573813
   )
   int field4039;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      longValue = 6163742386716194805L
   )
   long field4040;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -105299707
   )
   int field4051;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1188797073
   )
   int field4042;
   @ObfuscatedName("ag")
   boolean field4055;
   @ObfuscatedName("ah")
   HashSet field4061;
   @ObfuscatedName("ab")
   HashSet field4046;
   @ObfuscatedName("am")
   HashSet field4047;
   @ObfuscatedName("ay")
   HashSet field4007;
   @ObfuscatedName("aj")
   boolean field4049;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 2051372703
   )
   int field4050;
   @ObfuscatedName("bc")
   final int[] field4031;
   @ObfuscatedName("br")
   List field4052;
   @ObfuscatedName("by")
   Iterator field4054;
   @ObfuscatedName("bl")
   HashSet field4036;
   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   Coordinates field4032;
   @ObfuscatedName("bu")
   public boolean field4056;
   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   SpritePixels field4060;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -513028097
   )
   int field4048;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1161058697
   )
   int field4029;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 911083017
   )
   int field4053;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -538956131
   )
   int field4005;

   static {
      fontNameVerdana11 = FontName.field3868;
      fontNameVerdana13 = FontName.field3870;
      fontNameVerdana15 = FontName.field3867;
   }

   public RenderOverview() {
      this.field4022 = -1;
      this.field4023 = -1;
      this.field4026 = -1;
      this.field4027 = -1;
      this.field4028 = -1;
      this.field4004 = -1;
      this.field4015 = 3;
      this.field4043 = 50;
      this.field4030 = false;
      this.field4033 = null;
      this.field4041 = -1;
      this.field4035 = -1;
      this.field4059 = -1;
      this.field4037 = -1;
      this.field4038 = -1;
      this.field4039 = -1;
      this.field4055 = true;
      this.field4061 = new HashSet();
      this.field4046 = new HashSet();
      this.field4047 = new HashSet();
      this.field4007 = new HashSet();
      this.field4049 = false;
      this.field4050 = 0;
      this.field4031 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field4036 = new HashSet();
      this.field4032 = null;
      this.field4056 = false;
      this.field4029 = -1;
      this.field4053 = -1;
      this.field4005 = -1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljk;Lkw;Ljava/util/HashMap;[Llv;I)V",
      garbageValue = "-1914646838"
   )
   public void method6156(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field4013 = var4;
      this.field4058 = var1;
      this.field4011 = var2;
      this.mapFonts = new HashMap();
      this.mapFonts.put(Size.field362, var3.get(fontNameVerdana11));
      this.mapFonts.put(Size.field368, var3.get(fontNameVerdana13));
      this.mapFonts.put(Size.field364, var3.get(fontNameVerdana15));
      this.field4019 = new class333(var1);
      int var5 = this.field4058.getFile(class41.field546.field542);
      int[] var6 = this.field4058.getChilds(var5);
      this.field4014 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field4058.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field4014.put(var9.method296(), var9);
         if(var9.method313()) {
            this.field4020 = var9;
         }
      }

      this.method6082(this.field4020);
      this.field4017 = null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-596708677"
   )
   public int method6086() {
      return this.field4058.tryLoadRecordByNames(this.field4020.method296(), class41.field544.field542)?100:this.field4058.archiveLoadPercentByName(this.field4020.method296());
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-161963664"
   )
   public void method6068() {
      class243.method4618();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "-1116618753"
   )
   public void method6093(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field4019.method6055()) {
         this.method6211();
         this.method6106();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.worldMapZoom));
            int var9 = (int)Math.ceil((double)((float)var7 / this.worldMapZoom));
            List var10 = this.worldMapManager.method569(this.worldMapX - var8 / 2 - 1, this.worldMapY - var9 / 2 - 1, var8 / 2 + this.worldMapX + 1, var9 / 2 + this.worldMapY + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            MapIcon var13;
            ScriptEvent var14;
            MapIconReference var15;
            for(var12 = var10.iterator(); var12.hasNext(); GameCanvas.method800(var14)) {
               var13 = (MapIcon)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new MapIconReference(var13.areaId, var13.field532, var13.field531);
               var14.method1084(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field4036.contains(var13)) {
                  var14.method1085(class245.field2969);
               } else {
                  var14.method1085(class245.field2967);
               }
            }

            var12 = this.field4036.iterator();

            while(var12.hasNext()) {
               var13 = (MapIcon)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new MapIconReference(var13.areaId, var13.field532, var13.field531);
                  var14.method1084(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1085(class245.field2965);
                  GameCanvas.method800(var14);
               }
            }

            this.field4036 = var11;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIZZI)V",
      garbageValue = "-2063108569"
   )
   public void method6108(int var1, int var2, boolean var3, boolean var4) {
      long var5 = PendingSpawn.currentTimeMs();
      this.method6071(var1, var2, var4, var5);
      if(!this.method6076() && (var4 || var3)) {
         if(var4) {
            this.field4038 = var1;
            this.field4039 = var2;
            this.field4059 = this.worldMapX;
            this.field4037 = this.worldMapY;
         }

         if(this.field4059 != -1) {
            int var7 = var1 - this.field4038;
            int var8 = var2 - this.field4039;
            this.method6136(this.field4059 - (int)((float)var7 / this.worldMapZoomTarget), (int)((float)var8 / this.worldMapZoomTarget) + this.field4037, false);
         }
      } else {
         this.method6117();
      }

      if(var4) {
         this.field4040 = var5;
         this.field4051 = var1;
         this.field4042 = var2;
      }

   }

   @ObfuscatedName("y")
   void method6071(int var1, int var2, boolean var3, long var4) {
      if(this.worldMapData != null) {
         int var6 = (int)((float)this.worldMapX + ((float)(var1 - this.field4028) - (float)this.method6103() * this.worldMapZoom / 2.0F) / this.worldMapZoom);
         int var7 = (int)((float)this.worldMapY - ((float)(var2 - this.field4004) - (float)this.method6104() * this.worldMapZoom / 2.0F) / this.worldMapZoom);
         this.field4032 = this.worldMapData.method292(var6 + this.worldMapData.method312() * 64, var7 + this.worldMapData.method302() * 64);
         if(this.field4032 != null && var3) {
            boolean var8 = Client.rights >= 2;
            if(var8 && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81]) {
               class3.method8(this.field4032.worldX, this.field4032.worldY, this.field4032.plane, false);
            } else {
               boolean var9 = true;
               if(this.field4055) {
                  int var10 = var1 - this.field4051;
                  int var11 = var2 - this.field4042;
                  if(var4 - this.field4040 > 500L || var10 < -25 || var10 > 25 || var11 < -25 || var11 > 25) {
                     var9 = false;
                  }
               }

               if(var9) {
                  PacketNode var12 = class31.method285(ClientPacket.field2386, Client.field899.field1470);
                  var12.packetBuffer.putInt(this.field4032.bitpack());
                  Client.field899.method2082(var12);
                  this.field4040 = 0L;
               }
            }
         }
      } else {
         this.field4032 = null;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method6211() {
      if(OwnWorldComparator.field852 != null) {
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "93"
   )
   void method6106() {
      if(this.method6076()) {
         int var1 = this.field4022 - this.worldMapX;
         int var2 = this.field4023 - this.worldMapY;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.method6136(var1 + this.worldMapX, var2 + this.worldMapY, true);
         if(this.worldMapX == this.field4022 && this.field4023 == this.worldMapY) {
            this.field4022 = -1;
            this.field4023 = -1;
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "504925955"
   )
   final void method6136(int var1, int var2, boolean var3) {
      this.worldMapX = var1;
      this.worldMapY = var2;
      PendingSpawn.currentTimeMs();
      if(var3) {
         this.method6117();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1265479274"
   )
   final void method6117() {
      this.field4039 = -1;
      this.field4038 = -1;
      this.field4037 = -1;
      this.field4059 = -1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2134187354"
   )
   boolean method6076() {
      return this.field4022 != -1 && this.field4023 != -1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)Lal;",
      garbageValue = "1652573332"
   )
   public WorldMapData method6077(int var1, int var2, int var3) {
      Iterator var4 = this.field4014.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method290(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIZB)V",
      garbageValue = "6"
   )
   public void method6170(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method6077(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field4020;
      }

      boolean var6 = false;
      if(var5 != this.field4017 || var4) {
         this.field4017 = var5;
         this.method6082(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method6085(var1, var2, var3);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "21305"
   )
   public void method6079(int var1) {
      WorldMapData var2 = this.method6175(var1);
      if(var2 != null) {
         this.method6082(var2);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "232989975"
   )
   public int method6080() {
      return this.worldMapData == null?-1:this.worldMapData.method294();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Lal;",
      garbageValue = "-1687455713"
   )
   public WorldMapData method6081() {
      return this.worldMapData;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lal;I)V",
      garbageValue = "-615405224"
   )
   void method6082(WorldMapData var1) {
      if(this.worldMapData == null || var1 != this.worldMapData) {
         this.initializeWorldMap(var1);
         this.method6085(-1, -1, -1);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lal;B)V",
      garbageValue = "22"
   )
   @Export("initializeWorldMap")
   void initializeWorldMap(WorldMapData var1) {
      this.worldMapData = var1;
      this.worldMapManager = new WorldMapManager(this.field4013, this.mapFonts);
      this.field4019.method6053(this.worldMapData.method296());
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lal;Lic;Lic;ZB)V",
      garbageValue = "41"
   )
   public void method6084(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.worldMapData == null || var1 != this.worldMapData) {
            this.initializeWorldMap(var1);
         }

         if(!var4 && this.worldMapData.method290(var2.plane, var2.worldX, var2.worldY)) {
            this.method6085(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method6085(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-16"
   )
   void method6085(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method291(var1, var2, var3);
         if(var4 == null) {
            var4 = this.worldMapData.method291(this.worldMapData.method305(), this.worldMapData.method304(), this.worldMapData.method306());
         }

         this.method6136(var4[0] - this.worldMapData.method312() * 64, var4[1] - this.worldMapData.method302() * 64, true);
         this.field4022 = -1;
         this.field4023 = -1;
         this.worldMapZoom = this.method6091(this.worldMapData.method329());
         this.worldMapZoomTarget = this.worldMapZoom;
         this.field4052 = null;
         this.field4054 = null;
         this.worldMapManager.method598();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1656559864"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      int var7 = this.field4019.method6056();
      if(var7 < 100) {
         this.method6090(var1, var2, var3, var4, var7);
      } else {
         if(!this.worldMapManager.method571()) {
            this.worldMapManager.load(this.field4058, this.worldMapData.method296(), Client.isMembers);
            if(!this.worldMapManager.method571()) {
               return;
            }
         }

         if(this.field4033 != null) {
            ++this.field4035;
            if(this.field4035 % this.field4043 == 0) {
               this.field4035 = 0;
               ++this.field4041;
            }

            if(this.field4041 >= this.field4015 && !this.field4030) {
               this.field4033 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.worldMapZoom));
         int var9 = (int)Math.ceil((double)((float)var4 / this.worldMapZoom));
         this.worldMapManager.drawMapRegion(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, var1, var2, var3 + var1, var2 + var4);
         boolean var10;
         if(!this.field4049) {
            var10 = false;
            if(var5 - this.field4050 > 100) {
               this.field4050 = var5;
               var10 = true;
            }

            this.worldMapManager.drawMapIcons(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, var1, var2, var3 + var1, var2 + var4, this.field4007, this.field4033, this.field4035, this.field4043, var10);
         }

         this.method6087(var1, var2, var3, var4, var8, var9);
         var10 = Client.rights >= 2;
         if(var10 && this.field4056 && this.field4032 != null) {
            this.field4011.method5689("Coord: " + this.field4032, Rasterizer2D.draw_region_x + 10, Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
         }

         this.field4026 = var8;
         this.field4027 = var9;
         this.field4028 = var1;
         this.field4004 = var2;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IIIIIII)Z",
      garbageValue = "-369684336"
   )
   boolean method6203(int var1, int var2, int var3, int var4, int var5, int var6) {
      return this.field4060 == null?true:(this.field4060.width == var1 && this.field4060.height == var2?(this.worldMapManager.field558 != this.field4048?true:(this.field4005 != Client.field1116?true:(var3 <= 0 && var4 <= 0?var3 + var1 < var5 || var2 + var4 < var6:true))):true);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "805712621"
   )
   void method6087(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(OwnWorldComparator.field852 != null) {
         int var7 = 512 / (this.worldMapManager.field558 * 2);
         int var8 = var3 + 512;
         int var9 = var4 + 512;
         float var10 = 1.0F;
         var8 = (int)((float)var8 / var10);
         var9 = (int)((float)var9 / var10);
         int var11 = this.method6190() - var5 / 2 - var7;
         int var12 = this.method6101() - var6 / 2 - var7;
         int var13 = var1 - (var7 + var11 - this.field4029) * this.worldMapManager.field558;
         int var14 = var2 - this.worldMapManager.field558 * (var7 - (var12 - this.field4053));
         if(this.method6203(var8, var9, var13, var14, var3, var4)) {
            if(this.field4060 != null && this.field4060.width == var8 && this.field4060.height == var9) {
               Arrays.fill(this.field4060.pixels, 0);
            } else {
               this.field4060 = new SpritePixels(var8, var9);
            }

            this.field4029 = this.method6190() - var5 / 2 - var7;
            this.field4053 = this.method6101() - var6 / 2 - var7;
            this.field4048 = this.worldMapManager.field558;
            OwnWorldComparator.field852.method4842(this.field4029, this.field4053, this.field4060, (float)this.field4048 / var10);
            this.field4005 = Client.field1116;
            var13 = var1 - (var11 + var7 - this.field4029) * this.worldMapManager.field558;
            var14 = var2 - this.worldMapManager.field558 * (var7 - (var12 - this.field4053));
         }

         Rasterizer2D.fillRectangle(var1, var2, var3, var4, 0, 128);
         if(var10 == 1.0F) {
            this.field4060.method5931(var13, var14, 192);
         } else {
            this.field4060.method5958(var13, var14, (int)((float)var8 * var10), (int)(var10 * (float)var9), 192);
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2131230642"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field4019.method6055()) {
         if(!this.worldMapManager.method571()) {
            this.worldMapManager.load(this.field4058, this.worldMapData.method296(), Client.isMembers);
            if(!this.worldMapManager.method571()) {
               return;
            }
         }

         this.worldMapManager.method586(var1, var2, var3, var4, this.field4033, this.field4035, this.field4043);
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-834470662"
   )
   public void method6089(int var1) {
      this.worldMapZoomTarget = this.method6091(var1);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1831390593"
   )
   void method6090(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.Rasterizer2D_fillRectangle(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field4011.drawTextCentered("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II)F",
      garbageValue = "961260810"
   )
   float method6091(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "113"
   )
   public int method6092() {
      return 1.0D == (double)this.worldMapZoomTarget?25:((double)this.worldMapZoomTarget == 1.5D?37:(2.0D == (double)this.worldMapZoomTarget?50:((double)this.worldMapZoomTarget == 3.0D?75:(4.0D == (double)this.worldMapZoomTarget?100:200))));
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1750956885"
   )
   public void method6095() {
      this.field4019.method6054();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   public boolean method6114() {
      return this.field4019.method6055();
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)Lal;",
      garbageValue = "2038581939"
   )
   public WorldMapData method6175(int var1) {
      Iterator var2 = this.field4014.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method294() != var1);

      return var3;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   public void method6096(int var1, int var2) {
      if(this.worldMapData != null && this.worldMapData.method338(var1, var2)) {
         this.field4022 = var1 - this.worldMapData.method312() * 64;
         this.field4023 = var2 - this.worldMapData.method302() * 64;
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-298021635"
   )
   public void method6073(int var1, int var2) {
      if(this.worldMapData != null) {
         this.method6136(var1 - this.worldMapData.method312() * 64, var2 - this.worldMapData.method302() * 64, true);
         this.field4022 = -1;
         this.field4023 = -1;
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-766987676"
   )
   public void method6161(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method291(var1, var2, var3);
         if(var4 != null) {
            this.method6096(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-651057972"
   )
   public void method6099(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method291(var1, var2, var3);
         if(var4 != null) {
            this.method6073(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-909290804"
   )
   public int method6190() {
      return this.worldMapData == null?-1:this.worldMapX + this.worldMapData.method312() * 64;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1480146818"
   )
   public int method6101() {
      return this.worldMapData == null?-1:this.worldMapY + this.worldMapData.method302() * 64;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)Lic;",
      garbageValue = "-1889624187"
   )
   public Coordinates method6102() {
      return this.worldMapData == null?null:this.worldMapData.method292(this.method6190(), this.method6101());
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1331455398"
   )
   public int method6103() {
      return this.field4026;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "57"
   )
   public int method6104() {
      return this.field4027;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1062540823"
   )
   public void method6105(int var1) {
      if(var1 >= 1) {
         this.field4015 = var1;
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "830982687"
   )
   public void method6197() {
      this.field4015 = 3;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   public void method6149(int var1) {
      if(var1 >= 1) {
         this.field4043 = var1;
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "51"
   )
   public void method6231() {
      this.field4043 = 50;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "41"
   )
   public void method6127(boolean var1) {
      this.field4030 = var1;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2001489392"
   )
   public void method6224(int var1) {
      this.field4033 = new HashSet();
      this.field4033.add(Integer.valueOf(var1));
      this.field4041 = 0;
      this.field4035 = 0;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "76780456"
   )
   public void method6074(int var1) {
      this.field4033 = new HashSet();
      this.field4041 = 0;
      this.field4035 = 0;

      for(int var2 = 0; var2 < Area.mapAreaType.length; ++var2) {
         if(Area.mapAreaType[var2] != null && Area.mapAreaType[var2].field3451 == var1) {
            this.field4033.add(Integer.valueOf(Area.mapAreaType[var2].id));
         }
      }

   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-406182945"
   )
   public void method6112() {
      this.field4033 = null;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "921637277"
   )
   public void method6113(boolean var1) {
      this.field4049 = !var1;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-622547956"
   )
   public void method6107(int var1, boolean var2) {
      if(!var2) {
         this.field4061.add(Integer.valueOf(var1));
      } else {
         this.field4061.remove(Integer.valueOf(var1));
      }

      this.method6119();
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "66"
   )
   public void method6115(int var1, boolean var2) {
      if(!var2) {
         this.field4046.add(Integer.valueOf(var1));
      } else {
         this.field4046.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.mapAreaType.length; ++var3) {
         if(Area.mapAreaType[var3] != null && Area.mapAreaType[var3].field3451 == var1) {
            int var4 = Area.mapAreaType[var3].id;
            if(!var2) {
               this.field4047.add(Integer.valueOf(var4));
            } else {
               this.field4047.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method6119();
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1916366674"
   )
   public boolean method6166() {
      return !this.field4049;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "79"
   )
   public boolean method6083(int var1) {
      return !this.field4061.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-28"
   )
   public boolean method6118(int var1) {
      return !this.field4046.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1026029487"
   )
   void method6119() {
      this.field4007.clear();
      this.field4007.addAll(this.field4061);
      this.field4007.addAll(this.field4047);
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-25"
   )
   public void method6120(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field4019.method6055()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.worldMapZoom));
         int var8 = (int)Math.ceil((double)((float)var4 / this.worldMapZoom));
         List var9 = this.worldMapManager.method569(this.worldMapX - var7 / 2 - 1, this.worldMapY - var8 / 2 - 1, var7 / 2 + this.worldMapX + 1, var8 / 2 + this.worldMapY + 1, var1, var2, var3, var4, var5, var6);
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

               for(int var14 = this.field4031.length - 1; var14 >= 0; --var14) {
                  if(var12.field3467[var14] != null) {
                     TextureProvider.addMenuEntry(var12.field3467[var14], var12.field3462, this.field4031[var14], var11.areaId, var11.field532.bitpack(), var11.field531.bitpack());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(ILic;I)Lic;",
      garbageValue = "-1553820891"
   )
   public Coordinates method6121(int var1, Coordinates var2) {
      if(!this.field4019.method6055()) {
         return null;
      } else if(!this.worldMapManager.method571()) {
         return null;
      } else if(!this.worldMapData.method338(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.worldMapManager.method572();
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
                     return var5.field531;
                  }

                  var8 = (MapIcon)var7.next();
                  int var9 = var8.field531.worldX - var2.worldX;
                  int var10 = var8.field531.worldY - var2.worldY;
                  var11 = var9 * var9 + var10 * var10;
                  if(var11 == 0) {
                     return var8.field531;
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

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IILic;Lic;I)V",
      garbageValue = "-669880805"
   )
   public void method6122(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      MapIconReference var6 = new MapIconReference(var2, var3, var4);
      var5.method1084(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1085(class245.field2968);
         break;
      case 1009:
         var5.method1085(class245.field2963);
         break;
      case 1010:
         var5.method1085(class245.field2962);
         break;
      case 1011:
         var5.method1085(class245.field2972);
         break;
      case 1012:
         var5.method1085(class245.field2964);
      }

      GameCanvas.method800(var5);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(B)Lao;",
      garbageValue = "-17"
   )
   public MapIcon method6109() {
      if(!this.field4019.method6055()) {
         return null;
      } else if(!this.worldMapManager.method571()) {
         return null;
      } else {
         HashMap var1 = this.worldMapManager.method572();
         this.field4052 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field4052.addAll(var3);
         }

         this.field4054 = this.field4052.iterator();
         return this.method6124();
      }
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(I)Lao;",
      garbageValue = "2115004861"
   )
   public MapIcon method6124() {
      return this.field4054 == null?null:(!this.field4054.hasNext()?null:(MapIcon)this.field4054.next());
   }
}
