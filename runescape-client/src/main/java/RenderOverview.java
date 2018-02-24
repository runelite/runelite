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

@ObfuscatedName("ll")
@Implements("RenderOverview")
public class RenderOverview {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   @Export("fontNameVerdana11")
   static final FontName fontNameVerdana11;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   @Export("fontNameVerdana13")
   static final FontName fontNameVerdana13;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   @Export("fontNameVerdana15")
   static final FontName fontNameVerdana15;
   @ObfuscatedName("ae")
   @Export("clientInstance")
   @ObfuscatedSignature(
      signature = "Lclient;"
   )
   static Client clientInstance;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   IndexDataBase field3930;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   Font field3959;
   @ObfuscatedName("r")
   HashMap field3935;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   IndexedSprite[] field3936;
   @ObfuscatedName("v")
   HashMap field3938;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   WorldMapData field3941;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   @Export("worldMapData")
   WorldMapData worldMapData;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   WorldMapData field3943;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lag;"
   )
   @Export("worldMapManager")
   WorldMapManager worldMapManager;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Llg;"
   )
   class324 field3942;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 842223287
   )
   int field3927;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1635518129
   )
   int field3944;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2136082273
   )
   int field3960;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1823797665
   )
   int field3946;
   @ObfuscatedName("k")
   float field3947;
   @ObfuscatedName("n")
   float field3948;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -80031077
   )
   int field3949;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1693775603
   )
   int field3950;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1503005031
   )
   int field3967;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -404424607
   )
   int field3952;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1626536773
   )
   int field3970;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -721249757
   )
   int field3954;
   @ObfuscatedName("af")
   boolean field3955;
   @ObfuscatedName("ai")
   HashSet field3934;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -532121041
   )
   int field3957;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 832462963
   )
   int field3958;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 826727191
   )
   int field3956;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -313674919
   )
   int field3932;
   @ObfuscatedName("az")
   HashSet field3964;
   @ObfuscatedName("ax")
   HashSet field3962;
   @ObfuscatedName("ad")
   HashSet field3940;
   @ObfuscatedName("ar")
   HashSet field3928;
   @ObfuscatedName("ag")
   boolean field3965;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 37103355
   )
   int field3966;
   @ObfuscatedName("ay")
   final int[] field3937;
   @ObfuscatedName("at")
   List field3968;
   @ObfuscatedName("aa")
   Iterator field3969;
   @ObfuscatedName("aw")
   HashSet field3945;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   Coordinates field3971;

   static {
      fontNameVerdana11 = FontName.field3753;
      fontNameVerdana13 = FontName.field3757;
      fontNameVerdana15 = FontName.field3755;
   }

   public RenderOverview() {
      this.field3960 = -1;
      this.field3946 = -1;
      this.field3949 = -1;
      this.field3950 = -1;
      this.field3967 = -1;
      this.field3952 = -1;
      this.field3970 = 3;
      this.field3954 = 50;
      this.field3955 = false;
      this.field3934 = null;
      this.field3957 = -1;
      this.field3958 = -1;
      this.field3956 = -1;
      this.field3932 = -1;
      this.field3964 = new HashSet();
      this.field3962 = new HashSet();
      this.field3940 = new HashSet();
      this.field3928 = new HashSet();
      this.field3965 = false;
      this.field3966 = 0;
      this.field3937 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3945 = new HashSet();
      this.field3971 = null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lie;Lkt;Ljava/util/HashMap;[Llv;I)V",
      garbageValue = "1145722921"
   )
   public void method5963(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field3936 = var4;
      this.field3930 = var1;
      this.field3959 = var2;
      this.field3935 = new HashMap();
      this.field3935.put(Size.field336, var3.get(fontNameVerdana11));
      this.field3935.put(Size.field325, var3.get(fontNameVerdana13));
      this.field3935.put(Size.field326, var3.get(fontNameVerdana15));
      this.field3942 = new class324(var1);
      int var5 = this.field3930.getFile(class40.field497.field502);
      int[] var6 = this.field3930.getChilds(var5);
      this.field3938 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3930.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3938.put(var9.method314(), var9);
         if(var9.method335()) {
            this.field3941 = var9;
         }
      }

      this.method5976(this.field3941);
      this.field3943 = null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-24753"
   )
   public int method5964() {
      return this.field3930.tryLoadRecordByNames(this.field3941.method314(), class40.field500.field502)?100:this.field3930.archiveLoadPercentByName(this.field3941.method314());
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIZIIIIB)V",
      garbageValue = "-71"
   )
   public void method5965(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3942.method5958()) {
         this.method5968();
         this.method5969();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3947));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3947));
            List var10 = this.worldMapManager.method583(this.field3927 - var8 / 2 - 1, this.field3944 - var9 / 2 - 1, var8 / 2 + this.field3927 + 1, var9 / 2 + this.field3944 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            ScriptEvent var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); class194.method3791(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new class47(var13.field488, var13.field491, var13.field490);
               var14.method1134(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3945.contains(var13)) {
                  var14.method1130(class239.field2922);
               } else {
                  var14.method1130(class239.field2920);
               }
            }

            var12 = this.field3945.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new class47(var13.field488, var13.field491, var13.field490);
                  var14.method1134(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1130(class239.field2921);
                  class194.method3791(var14);
               }
            }

            this.field3945 = var11;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIZZI)V",
      garbageValue = "830996549"
   )
   public void method6141(int var1, int var2, boolean var3, boolean var4) {
      this.method6094(var1, var2, var4);
      if(this.field3956 == -1) {
         this.field3956 = var1;
      }

      if(this.field3932 == -1) {
         this.field3932 = var2;
      }

      int var5 = var1 - this.field3956;
      int var6 = var2 - this.field3932;
      this.field3956 = var1;
      this.field3932 = var2;
      if(var3 && !this.method6053()) {
         this.field3927 -= (int)((float)var5 / this.field3948);
         this.field3944 += (int)((float)var6 / this.field3948);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "-58"
   )
   void method6094(int var1, int var2, boolean var3) {
      boolean var4 = Client.rights >= 2;
      if(var4) {
         if(this.worldMapData != null) {
            int var5 = (int)((float)this.field3927 + ((float)(var1 - this.field3967) - (float)this.method5996() * this.field3947 / 2.0F) / this.field3947);
            int var6 = (int)((float)this.field3944 - ((float)(var2 - this.field3952) - (float)this.method5981() * this.field3947 / 2.0F) / this.field3947);
            this.field3971 = this.worldMapData.method310(var5 + this.worldMapData.method318() * 64, var6 + this.worldMapData.method355() * 64);
            if(this.field3971 != null && var3 && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81] && var3) {
               int var7 = this.field3971.worldX;
               int var8 = this.field3971.worldY;
               int var9 = this.field3971.plane;
               PacketNode var10 = class61.method1076(ClientPacket.field2379, Client.field863.field1434);
               var10.packetBuffer.writeShortLE(var7);
               var10.packetBuffer.putByte(var9);
               var10.packetBuffer.method3641(var8);
               Client.field863.method2039(var10);
            }
         } else {
            this.field3971 = null;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-62"
   )
   void method5968() {
      if(this.field3947 < this.field3948) {
         this.field3947 = Math.min(this.field3948, this.field3947 / 30.0F + this.field3947);
      }

      if(this.field3947 > this.field3948) {
         this.field3947 = Math.max(this.field3948, this.field3947 - this.field3947 / 30.0F);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   void method5969() {
      if(this.method6053()) {
         int var1 = this.field3960 - this.field3927;
         int var2 = this.field3946 - this.field3944;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3927 += var1;
         this.field3944 += var2;
         if(this.field3960 == this.field3927 && this.field3946 == this.field3944) {
            this.field3960 = -1;
            this.field3946 = -1;
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-1"
   )
   boolean method6053() {
      return this.field3960 != -1 && this.field3946 != -1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIB)Lai;",
      garbageValue = "55"
   )
   public WorldMapData method5971(int var1, int var2, int var3) {
      Iterator var4 = this.field3938.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method332(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIZB)V",
      garbageValue = "2"
   )
   public void method5972(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5971(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3941;
      }

      boolean var6 = false;
      if(var5 != this.field3943 || var4) {
         this.field3943 = var5;
         this.method5976(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5979(var1, var2, var3);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-25"
   )
   public void method5977(int var1) {
      WorldMapData var2 = this.method5994(var1);
      if(var2 != null) {
         this.method5976(var2);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "114"
   )
   public int method5974() {
      return this.worldMapData == null?-1:this.worldMapData.method312();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Lai;",
      garbageValue = "-284786961"
   )
   public WorldMapData method6033() {
      return this.worldMapData;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lai;I)V",
      garbageValue = "1100825688"
   )
   void method5976(WorldMapData var1) {
      if(this.worldMapData == null || var1 != this.worldMapData) {
         this.initializeWorldMap(var1);
         this.method5979(-1, -1, -1);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lai;I)V",
      garbageValue = "-125220503"
   )
   @Export("initializeWorldMap")
   void initializeWorldMap(WorldMapData var1) {
      this.worldMapData = var1;
      this.worldMapManager = new WorldMapManager(this.field3936, this.field3935);
      this.field3942.method5949(this.worldMapData.method314());
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lai;Lhp;Lhp;ZI)V",
      garbageValue = "1410060610"
   )
   public void method5978(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.worldMapData == null || var1 != this.worldMapData) {
            this.initializeWorldMap(var1);
         }

         if(!var4 && this.worldMapData.method332(var2.plane, var2.worldX, var2.worldY)) {
            this.method5979(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5979(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-25"
   )
   void method5979(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method329(var1, var2, var3);
         if(var4 == null) {
            var4 = this.worldMapData.method329(this.worldMapData.method323(), this.worldMapData.method322(), this.worldMapData.method368());
         }

         this.field3927 = var4[0] - this.worldMapData.method318() * 64;
         this.field3944 = var4[1] - this.worldMapData.method355() * 64;
         this.field3960 = -1;
         this.field3946 = -1;
         this.field3947 = this.method5984(this.worldMapData.method317());
         this.field3948 = this.field3947;
         this.field3968 = null;
         this.field3969 = null;
         this.worldMapManager.method566();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-2089963487"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      int var7 = this.field3942.method5952();
      if(var7 < 100) {
         this.method6089(var1, var2, var3, var4, var7);
      } else {
         if(!this.worldMapManager.method572()) {
            this.worldMapManager.load(this.field3930, this.worldMapData.method314(), Client.isMembers);
            if(!this.worldMapManager.method572()) {
               return;
            }
         }

         if(this.field3934 != null) {
            ++this.field3958;
            if(this.field3958 % this.field3954 == 0) {
               this.field3958 = 0;
               ++this.field3957;
            }

            if(this.field3957 >= this.field3970 && !this.field3955) {
               this.field3934 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3947));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3947));
         this.worldMapManager.method564(this.field3927 - var8 / 2, this.field3944 - var9 / 2, var8 / 2 + this.field3927, var9 / 2 + this.field3944, var1, var2, var3 + var1, var2 + var4);
         boolean var10;
         if(!this.field3965) {
            var10 = false;
            if(var5 - this.field3966 > 100) {
               this.field3966 = var5;
               var10 = true;
            }

            this.worldMapManager.method565(this.field3927 - var8 / 2, this.field3944 - var9 / 2, var8 / 2 + this.field3927, var9 / 2 + this.field3944, var1, var2, var3 + var1, var2 + var4, this.field3928, this.field3934, this.field3958, this.field3954, var10);
         }

         var10 = Client.rights >= 2;
         if(var10 && this.field3971 != null) {
            this.field3959.method5451("Coord: " + this.field3971, Rasterizer2D.draw_region_x + 10, Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
         }

         this.field3949 = var8;
         this.field3950 = var9;
         this.field3967 = var1;
         this.field3952 = var2;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "110"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3942.method5958()) {
         if(!this.worldMapManager.method572()) {
            this.worldMapManager.load(this.field3930, this.worldMapData.method314(), Client.isMembers);
            if(!this.worldMapManager.method572()) {
               return;
            }
         }

         this.worldMapManager.method588(var1, var2, var3, var4, this.field3934, this.field3958, this.field3954);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "1205"
   )
   public void method5982(int var1) {
      this.field3948 = this.method5984(var1);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IIIIIS)V",
      garbageValue = "3112"
   )
   void method6089(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.Rasterizer2D_fillRectangle(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3959.drawTextCentered("Loading...", var7, var6 + var8, -1, -1);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)F",
      garbageValue = "55131557"
   )
   float method5984(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "41291512"
   )
   public int method5985() {
      return 1.0D == (double)this.field3948?25:((double)this.field3948 == 1.5D?37:((double)this.field3948 == 2.0D?50:(3.0D == (double)this.field3948?75:((double)this.field3948 == 4.0D?100:200))));
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public void method5986() {
      this.field3942.method5950();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1382176665"
   )
   public boolean method5987() {
      return this.field3942.method5958();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)Lai;",
      garbageValue = "-731693019"
   )
   public WorldMapData method5994(int var1) {
      Iterator var2 = this.field3938.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method312() != var1);

      return var3;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "61"
   )
   public void method5989(int var1, int var2) {
      if(this.worldMapData != null && this.worldMapData.method328(var1, var2)) {
         this.field3960 = var1 - this.worldMapData.method318() * 64;
         this.field3946 = var2 - this.worldMapData.method355() * 64;
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2000254546"
   )
   public void method6023(int var1, int var2) {
      if(this.worldMapData != null) {
         this.field3927 = var1 - this.worldMapData.method318() * 64;
         this.field3944 = var2 - this.worldMapData.method355() * 64;
         this.field3960 = -1;
         this.field3946 = -1;
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1922255263"
   )
   public void method5991(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method329(var1, var2, var3);
         if(var4 != null) {
            this.method5989(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1643918849"
   )
   public void method5992(int var1, int var2, int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method329(var1, var2, var3);
         if(var4 != null) {
            this.method6023(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2092606107"
   )
   public int method5993() {
      return this.worldMapData == null?-1:this.field3927 + this.worldMapData.method318() * 64;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1029972457"
   )
   public int method6124() {
      return this.worldMapData == null?-1:this.field3944 + this.worldMapData.method355() * 64;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(B)Lhp;",
      garbageValue = "56"
   )
   public Coordinates method5995() {
      return this.worldMapData == null?null:this.worldMapData.method310(this.method5993(), this.method6124());
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method5996() {
      return this.field3949;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1454332493"
   )
   public int method5981() {
      return this.field3950;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "93"
   )
   public void method5998(int var1) {
      if(var1 >= 1) {
         this.field3970 = var1;
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-119"
   )
   public void method6074() {
      this.field3970 = 3;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-477209447"
   )
   public void method6146(int var1) {
      if(var1 >= 1) {
         this.field3954 = var1;
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1914495698"
   )
   public void method6001() {
      this.field3954 = 50;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "55"
   )
   public void method6081(boolean var1) {
      this.field3955 = var1;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1647642874"
   )
   public void method6003(int var1) {
      this.field3934 = new HashSet();
      this.field3934.add(Integer.valueOf(var1));
      this.field3957 = 0;
      this.field3958 = 0;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   public void method6004(int var1) {
      this.field3934 = new HashSet();
      this.field3957 = 0;
      this.field3958 = 0;

      for(int var2 = 0; var2 < class330.mapAreaType.length; ++var2) {
         if(class330.mapAreaType[var2] != null && class330.mapAreaType[var2].field3397 == var1) {
            this.field3934.add(Integer.valueOf(class330.mapAreaType[var2].field3406));
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2045876250"
   )
   public void method6005() {
      this.field3934 = null;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "454280892"
   )
   public void method6006(boolean var1) {
      this.field3965 = !var1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "528243512"
   )
   public void method6007(int var1, boolean var2) {
      if(!var2) {
         this.field3964.add(Integer.valueOf(var1));
      } else {
         this.field3964.remove(Integer.valueOf(var1));
      }

      this.method6051();
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-736929074"
   )
   public void method6008(int var1, boolean var2) {
      if(!var2) {
         this.field3962.add(Integer.valueOf(var1));
      } else {
         this.field3962.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < class330.mapAreaType.length; ++var3) {
         if(class330.mapAreaType[var3] != null && class330.mapAreaType[var3].field3397 == var1) {
            int var4 = class330.mapAreaType[var3].field3406;
            if(!var2) {
               this.field3940.add(Integer.valueOf(var4));
            } else {
               this.field3940.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method6051();
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-495112677"
   )
   public boolean method6022() {
      return !this.field3965;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-926093223"
   )
   public boolean method6010(int var1) {
      return !this.field3964.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-16030221"
   )
   public boolean method6011(int var1) {
      return !this.field3962.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-21830"
   )
   void method6051() {
      this.field3928.clear();
      this.field3928.addAll(this.field3964);
      this.field3928.addAll(this.field3940);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "204278500"
   )
   public void method6013(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3942.method5958()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3947));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3947));
         List var9 = this.worldMapManager.method583(this.field3927 - var7 / 2 - 1, this.field3944 - var8 / 2 - 1, var7 / 2 + this.field3927 + 1, var8 / 2 + this.field3944 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               Area var12 = class330.mapAreaType[var11.field488];
               var13 = false;

               for(int var14 = this.field3937.length - 1; var14 >= 0; --var14) {
                  if(var12.field3389[var14] != null) {
                     class21.addMenuEntry(var12.field3389[var14], var12.field3400, this.field3937[var14], var11.field488, var11.field491.method4375(), var11.field490.method4375());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(ILhp;I)Lhp;",
      garbageValue = "-1734093705"
   )
   public Coordinates method5983(int var1, Coordinates var2) {
      if(!this.field3942.method5958()) {
         return null;
      } else if(!this.worldMapManager.method572()) {
         return null;
      } else if(!this.worldMapData.method328(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.worldMapManager.method579();
         List var4 = (List)var3.get(Integer.valueOf(var1));
         if(var4 != null && !var4.isEmpty()) {
            class39 var5 = null;
            int var6 = -1;
            Iterator var7 = var4.iterator();

            while(true) {
               class39 var8;
               int var11;
               do {
                  if(!var7.hasNext()) {
                     return var5.field490;
                  }

                  var8 = (class39)var7.next();
                  int var9 = var8.field490.worldX - var2.worldX;
                  int var10 = var8.field490.worldY - var2.worldY;
                  var11 = var9 * var9 + var10 * var10;
                  if(var11 == 0) {
                     return var8.field490;
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

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(IILhp;Lhp;B)V",
      garbageValue = "-97"
   )
   public void method6015(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1134(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1130(class239.field2915);
         break;
      case 1009:
         var5.method1130(class239.field2916);
         break;
      case 1010:
         var5.method1130(class239.field2918);
         break;
      case 1011:
         var5.method1130(class239.field2924);
         break;
      case 1012:
         var5.method1130(class239.field2919);
      }

      class194.method3791(var5);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(I)Lad;",
      garbageValue = "781761940"
   )
   public class39 method6016() {
      if(!this.field3942.method5958()) {
         return null;
      } else if(!this.worldMapManager.method572()) {
         return null;
      } else {
         HashMap var1 = this.worldMapManager.method579();
         this.field3968 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3968.addAll(var3);
         }

         this.field3969 = this.field3968.iterator();
         return this.method6027();
      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I)Lad;",
      garbageValue = "-1967218353"
   )
   public class39 method6027() {
      return this.field3969 == null?null:(!this.field3969.hasNext()?null:(class39)this.field3969.next());
   }
}
