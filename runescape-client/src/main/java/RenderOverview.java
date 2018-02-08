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

@ObfuscatedName("lr")
@Implements("RenderOverview")
public class RenderOverview {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   @Export("fontNameVerdana11")
   static final FontName fontNameVerdana11;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   @Export("fontNameVerdana13")
   static final FontName fontNameVerdana13;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   @Export("fontNameVerdana15")
   static final FontName fontNameVerdana15;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   IndexDataBase field3924;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   Font field3931;
   @ObfuscatedName("o")
   HashMap field3929;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   IndexedSprite[] field3930;
   @ObfuscatedName("f")
   HashMap field3933;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   WorldMapData field3932;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   WorldMapData field3950;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   WorldMapData field3958;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   class41 field3935;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   class311 field3936;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -908005135
   )
   int field3963;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -914420777
   )
   int field3945;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -70759061
   )
   int field3939;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1142073223
   )
   int field3940;
   @ObfuscatedName("e")
   float field3934;
   @ObfuscatedName("v")
   float field3942;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -514666021
   )
   int field3943;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1416133609
   )
   int field3944;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -326484335
   )
   int field3951;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 819851087
   )
   int field3946;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -781275085
   )
   int field3947;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1890510553
   )
   int field3948;
   @ObfuscatedName("af")
   boolean field3920;
   @ObfuscatedName("as")
   HashSet field3938;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -369975051
   )
   int field3959;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 2018343203
   )
   int field3952;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -627409603
   )
   int field3941;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -720699161
   )
   int field3954;
   @ObfuscatedName("ab")
   HashSet field3955;
   @ObfuscatedName("am")
   HashSet field3960;
   @ObfuscatedName("ah")
   HashSet field3957;
   @ObfuscatedName("ag")
   HashSet field3949;
   @ObfuscatedName("az")
   boolean field3962;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1983397393
   )
   int field3922;
   @ObfuscatedName("av")
   final int[] field3961;
   @ObfuscatedName("aj")
   List field3937;
   @ObfuscatedName("ap")
   Iterator field3928;
   @ObfuscatedName("au")
   HashSet field3964;
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   Coordinates field3965;

   static {
      fontNameVerdana11 = FontName.field3750;
      fontNameVerdana13 = FontName.field3754;
      fontNameVerdana15 = FontName.field3752;
   }

   public RenderOverview() {
      this.field3939 = -1;
      this.field3940 = -1;
      this.field3943 = -1;
      this.field3944 = -1;
      this.field3951 = -1;
      this.field3946 = -1;
      this.field3947 = 3;
      this.field3948 = 50;
      this.field3920 = false;
      this.field3938 = null;
      this.field3959 = -1;
      this.field3952 = -1;
      this.field3941 = -1;
      this.field3954 = -1;
      this.field3955 = new HashSet();
      this.field3960 = new HashSet();
      this.field3957 = new HashSet();
      this.field3949 = new HashSet();
      this.field3962 = false;
      this.field3922 = 0;
      this.field3961 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3964 = new HashSet();
      this.field3965 = null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lir;Lkp;Ljava/util/HashMap;[Lkh;B)V",
      garbageValue = "93"
   )
   public void method5811(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field3930 = var4;
      this.field3924 = var1;
      this.field3931 = var2;
      this.field3929 = new HashMap();
      this.field3929.put(Size.field345, var3.get(fontNameVerdana11));
      this.field3929.put(Size.field344, var3.get(fontNameVerdana13));
      this.field3929.put(Size.field343, var3.get(fontNameVerdana15));
      this.field3936 = new class311(var1);
      int var5 = this.field3924.getFile(class40.field521.field515);
      int[] var6 = this.field3924.getChilds(var5);
      this.field3933 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3924.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3933.put(var9.method275(), var9);
         if(var9.method280()) {
            this.field3932 = var9;
         }
      }

      this.method5823(this.field3932);
      this.field3958 = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-780934865"
   )
   public int method5812() {
      return this.field3924.tryLoadRecordByNames(this.field3932.method275(), class40.field518.field515)?100:this.field3924.archiveLoadPercentByName(this.field3932.method275());
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "1246588062"
   )
   public void method5922(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3936.method5797()) {
         this.method5960();
         this.method5897();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3934));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3934));
            List var10 = this.field3935.method537(this.field3963 - var8 / 2 - 1, this.field3945 - var9 / 2 - 1, var8 / 2 + this.field3963 + 1, var9 / 2 + this.field3945 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            ScriptEvent var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); class84.method1868(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new class47(var13.field514, var13.field504, var13.field509);
               var14.method1065(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3964.contains(var13)) {
                  var14.method1066(class230.field2902);
               } else {
                  var14.method1066(class230.field2897);
               }
            }

            var12 = this.field3964.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new class47(var13.field514, var13.field504, var13.field509);
                  var14.method1065(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1066(class230.field2898);
                  class84.method1868(var14);
               }
            }

            this.field3964 = var11;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIZZI)V",
      garbageValue = "386109316"
   )
   public void method5814(int var1, int var2, boolean var3, boolean var4) {
      this.method5815(var1, var2, var4);
      if(this.field3941 == -1) {
         this.field3941 = var1;
      }

      if(this.field3954 == -1) {
         this.field3954 = var2;
      }

      int var5 = var1 - this.field3941;
      int var6 = var2 - this.field3954;
      this.field3941 = var1;
      this.field3954 = var2;
      if(var3 && !this.method5818()) {
         this.field3963 -= (int)((float)var5 / this.field3942);
         this.field3945 += (int)((float)var6 / this.field3942);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "6"
   )
   void method5815(int var1, int var2, boolean var3) {
      if(BoundingBox.method46()) {
         if(this.field3950 != null) {
            int var4 = (int)((float)this.field3963 + ((float)(var1 - this.field3951) - (float)this.method5843() * this.field3934 / 2.0F) / this.field3934);
            int var5 = (int)((float)this.field3945 - ((float)(var2 - this.field3946) - (float)this.method5933() * this.field3934 / 2.0F) / this.field3934);
            this.field3965 = this.field3950.method286(var4 + this.field3950.method284() * 64, var5 + this.field3950.method305() * 64);
            if(this.field3965 != null && var3 && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81] && var3) {
               int var6 = this.field3965.worldX;
               int var7 = this.field3965.worldY;
               int var8 = this.field3965.plane;
               PacketNode var9 = Script.method2025(ClientPacket.field2383, Client.field937.field1454);
               var9.packetBuffer.writeShortLE(var7);
               var9.packetBuffer.putShortLE(var8);
               var9.packetBuffer.writeIntLE16(var6);
               Client.field937.method2044(var9);
            }
         } else {
            this.field3965 = null;
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "254208056"
   )
   void method5960() {
      if(this.field3934 < this.field3942) {
         this.field3934 = Math.min(this.field3942, this.field3934 / 30.0F + this.field3934);
      }

      if(this.field3934 > this.field3942) {
         this.field3934 = Math.max(this.field3942, this.field3934 - this.field3934 / 30.0F);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1219322485"
   )
   void method5897() {
      if(this.method5818()) {
         int var1 = this.field3939 - this.field3963;
         int var2 = this.field3940 - this.field3945;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3963 += var1;
         this.field3945 += var2;
         if(this.field3939 == this.field3963 && this.field3945 == this.field3940) {
            this.field3939 = -1;
            this.field3940 = -1;
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "153412574"
   )
   boolean method5818() {
      return this.field3939 != -1 && this.field3940 != -1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)Las;",
      garbageValue = "1162381707"
   )
   public WorldMapData method5819(int var1, int var2, int var3) {
      Iterator var4 = this.field3933.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method334(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIZB)V",
      garbageValue = "72"
   )
   public void method5817(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5819(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3932;
      }

      boolean var6 = false;
      if(var5 != this.field3958 || var4) {
         this.field3958 = var5;
         this.method5823(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5826(var1, var2, var3);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "122"
   )
   public void method5847(int var1) {
      WorldMapData var2 = this.method5835(var1);
      if(var2 != null) {
         this.method5823(var2);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "20965"
   )
   public int method5821() {
      return this.field3950 == null?-1:this.field3950.method279();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Las;",
      garbageValue = "1757765069"
   )
   public WorldMapData method5822() {
      return this.field3950;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "1917001247"
   )
   void method5823(WorldMapData var1) {
      if(this.field3950 == null || var1 != this.field3950) {
         this.method5810(var1);
         this.method5826(-1, -1, -1);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "-1817707070"
   )
   void method5810(WorldMapData var1) {
      this.field3950 = var1;
      this.field3935 = new class41(this.field3930, this.field3929);
      this.field3936.method5795(this.field3950.method275());
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Las;Lhv;Lhv;ZI)V",
      garbageValue = "-1925501212"
   )
   public void method5984(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.field3950 == null || var1 != this.field3950) {
            this.method5810(var1);
         }

         if(!var4 && this.field3950.method334(var2.plane, var2.worldX, var2.worldY)) {
            this.method5826(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5826(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-56"
   )
   void method5826(int var1, int var2, int var3) {
      if(this.field3950 != null) {
         int[] var4 = this.field3950.method331(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3950.method331(this.field3950.method276(), this.field3950.method308(), this.field3950.method315());
         }

         this.field3963 = var4[0] - this.field3950.method284() * 64;
         this.field3945 = var4[1] - this.field3950.method305() * 64;
         this.field3939 = -1;
         this.field3940 = -1;
         this.field3934 = this.method5831(this.field3950.method311());
         this.field3942 = this.field3934;
         this.field3937 = null;
         this.field3928 = null;
         this.field3935.method532();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "484527577"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      int var7 = this.field3936.method5805();
      if(var7 < 100) {
         this.method5830(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3935.method539()) {
            this.field3935.method531(this.field3924, this.field3950.method275(), Client.isMembers);
            if(!this.field3935.method539()) {
               return;
            }
         }

         if(this.field3938 != null) {
            ++this.field3952;
            if(this.field3952 % this.field3948 == 0) {
               this.field3952 = 0;
               ++this.field3959;
            }

            if(this.field3959 >= this.field3947 && !this.field3920) {
               this.field3938 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3934));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3934));
         this.field3935.method533(this.field3963 - var8 / 2, this.field3945 - var9 / 2, var8 / 2 + this.field3963, var9 / 2 + this.field3945, var1, var2, var3 + var1, var2 + var4);
         if(!this.field3962) {
            boolean var10 = false;
            if(var5 - this.field3922 > 100) {
               this.field3922 = var5;
               var10 = true;
            }

            this.field3935.method534(this.field3963 - var8 / 2, this.field3945 - var9 / 2, var8 / 2 + this.field3963, var9 / 2 + this.field3945, var1, var2, var3 + var1, var2 + var4, this.field3949, this.field3938, this.field3952, this.field3948, var10);
         }

         if(BoundingBox.method46() && this.field3965 != null) {
            this.field3931.method5384("Coord: " + this.field3965, Rasterizer2D.draw_region_x + 10, Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
         }

         this.field3943 = var8;
         this.field3944 = var9;
         this.field3951 = var1;
         this.field3946 = var2;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "289294244"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3936.method5797()) {
         if(!this.field3935.method539()) {
            this.field3935.method531(this.field3924, this.field3950.method275(), Client.isMembers);
            if(!this.field3935.method539()) {
               return;
            }
         }

         this.field3935.method536(var1, var2, var3, var4, this.field3938, this.field3952, this.field3948);
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-5404"
   )
   public void method5829(int var1) {
      this.field3942 = this.method5831(var1);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1060128590"
   )
   void method5830(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.Rasterizer2D_fillRectangle(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3931.drawTextCentered("Loading...", var7, var6 + var8, -1, -1);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)F",
      garbageValue = "108657477"
   )
   float method5831(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1367296986"
   )
   public int method5832() {
      return (double)this.field3942 == 1.0D?25:(1.5D == (double)this.field3942?37:(2.0D == (double)this.field3942?50:((double)this.field3942 == 3.0D?75:((double)this.field3942 == 4.0D?100:200))));
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1449218319"
   )
   public void method5833() {
      this.field3936.method5796();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1174940558"
   )
   public boolean method5834() {
      return this.field3936.method5797();
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II)Las;",
      garbageValue = "-1757466014"
   )
   public WorldMapData method5835(int var1) {
      Iterator var2 = this.field3933.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method279() != var1);

      return var3;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "148038262"
   )
   public void method5930(int var1, int var2) {
      if(this.field3950 != null && this.field3950.method335(var1, var2)) {
         this.field3939 = var1 - this.field3950.method284() * 64;
         this.field3940 = var2 - this.field3950.method305() * 64;
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "61"
   )
   public void method5887(int var1, int var2) {
      if(this.field3950 != null) {
         this.field3963 = var1 - this.field3950.method284() * 64;
         this.field3945 = var2 - this.field3950.method305() * 64;
         this.field3939 = -1;
         this.field3940 = -1;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-985658970"
   )
   public void method5838(int var1, int var2, int var3) {
      if(this.field3950 != null) {
         int[] var4 = this.field3950.method331(var1, var2, var3);
         if(var4 != null) {
            this.method5930(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "69"
   )
   public void method5839(int var1, int var2, int var3) {
      if(this.field3950 != null) {
         int[] var4 = this.field3950.method331(var1, var2, var3);
         if(var4 != null) {
            this.method5887(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-11428"
   )
   public int method5840() {
      return this.field3950 == null?-1:this.field3963 + this.field3950.method284() * 64;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-39"
   )
   public int method5870() {
      return this.field3950 == null?-1:this.field3945 + this.field3950.method305() * 64;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)Lhv;",
      garbageValue = "-189348987"
   )
   public Coordinates method5813() {
      return this.field3950 == null?null:this.field3950.method286(this.method5840(), this.method5870());
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "774346746"
   )
   public int method5843() {
      return this.field3943;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-47"
   )
   public int method5933() {
      return this.field3944;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "79"
   )
   public void method5845(int var1) {
      if(var1 >= 1) {
         this.field3947 = var1;
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1942043549"
   )
   public void method5846() {
      this.field3947 = 3;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "6"
   )
   public void method5875(int var1) {
      if(var1 >= 1) {
         this.field3948 = var1;
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "48"
   )
   public void method5848() {
      this.field3948 = 50;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "57"
   )
   public void method5849(boolean var1) {
      this.field3920 = var1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-191593376"
   )
   public void method5850(int var1) {
      this.field3938 = new HashSet();
      this.field3938.add(Integer.valueOf(var1));
      this.field3959 = 0;
      this.field3952 = 0;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-5"
   )
   public void method5962(int var1) {
      this.field3938 = new HashSet();
      this.field3959 = 0;
      this.field3952 = 0;

      for(int var2 = 0; var2 < Area.mapAreaType.length; ++var2) {
         if(Area.mapAreaType[var2] != null && Area.mapAreaType[var2].field3396 == var1) {
            this.field3938.add(Integer.valueOf(Area.mapAreaType[var2].field3379));
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1522322997"
   )
   public void method5852() {
      this.field3938 = null;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-416385200"
   )
   public void method5865(boolean var1) {
      this.field3962 = !var1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-655125763"
   )
   public void method5854(int var1, boolean var2) {
      if(!var2) {
         this.field3955.add(Integer.valueOf(var1));
      } else {
         this.field3955.remove(Integer.valueOf(var1));
      }

      this.method5859();
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "592789797"
   )
   public void method5948(int var1, boolean var2) {
      if(!var2) {
         this.field3960.add(Integer.valueOf(var1));
      } else {
         this.field3960.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.mapAreaType.length; ++var3) {
         if(Area.mapAreaType[var3] != null && Area.mapAreaType[var3].field3396 == var1) {
            int var4 = Area.mapAreaType[var3].field3379;
            if(!var2) {
               this.field3957.add(Integer.valueOf(var4));
            } else {
               this.field3957.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5859();
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-219130625"
   )
   public boolean method5856() {
      return !this.field3962;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1191057407"
   )
   public boolean method5907(int var1) {
      return !this.field3955.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-357144739"
   )
   public boolean method5858(int var1) {
      return !this.field3960.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2082586165"
   )
   void method5859() {
      this.field3949.clear();
      this.field3949.addAll(this.field3955);
      this.field3949.addAll(this.field3957);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "596659962"
   )
   public void method5860(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3936.method5797()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3934));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3934));
         List var9 = this.field3935.method537(this.field3963 - var7 / 2 - 1, this.field3945 - var8 / 2 - 1, var7 / 2 + this.field3963 + 1, var8 / 2 + this.field3945 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               Area var12 = Area.mapAreaType[var11.field514];
               var13 = false;

               for(int var14 = this.field3961.length - 1; var14 >= 0; --var14) {
                  if(var12.field3397[var14] != null) {
                     NPCComposition.addMenuEntry(var12.field3397[var14], var12.field3387, this.field3961[var14], var11.field514, var11.field504.method4357(), var11.field509.method4357());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(ILhv;I)Lhv;",
      garbageValue = "-725807177"
   )
   public Coordinates method5861(int var1, Coordinates var2) {
      if(!this.field3936.method5797()) {
         return null;
      } else if(!this.field3935.method539()) {
         return null;
      } else if(!this.field3950.method335(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.field3935.method540();
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
                     return var5.field509;
                  }

                  var8 = (class39)var7.next();
                  int var9 = var8.field509.worldX - var2.worldX;
                  int var10 = var8.field509.worldY - var2.worldY;
                  var11 = var9 * var9 + var10 * var10;
                  if(var11 == 0) {
                     return var8.field509;
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

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IILhv;Lhv;B)V",
      garbageValue = "-40"
   )
   public void method5977(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1065(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1066(class230.field2892);
         break;
      case 1009:
         var5.method1066(class230.field2893);
         break;
      case 1010:
         var5.method1066(class230.field2894);
         break;
      case 1011:
         var5.method1066(class230.field2895);
         break;
      case 1012:
         var5.method1066(class230.field2896);
      }

      class84.method1868(var5);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(B)Lah;",
      garbageValue = "79"
   )
   public class39 method5953() {
      if(!this.field3936.method5797()) {
         return null;
      } else if(!this.field3935.method539()) {
         return null;
      } else {
         HashMap var1 = this.field3935.method540();
         this.field3937 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3937.addAll(var3);
         }

         this.field3928 = this.field3937.iterator();
         return this.method5929();
      }
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(I)Lah;",
      garbageValue = "1512884464"
   )
   public class39 method5929() {
      return this.field3928 == null?null:(!this.field3928.hasNext()?null:(class39)this.field3928.next());
   }
}
