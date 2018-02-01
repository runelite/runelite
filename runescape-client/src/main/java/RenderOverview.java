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
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   @Export("fontNameVerdana11")
   static final FontName fontNameVerdana11;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   @Export("fontNameVerdana13")
   static final FontName fontNameVerdana13;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   @Export("fontNameVerdana15")
   static final FontName fontNameVerdana15;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   IndexDataBase field3911;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   Font field3917;
   @ObfuscatedName("x")
   HashMap field3938;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   IndexedSprite[] field3919;
   @ObfuscatedName("v")
   HashMap field3920;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   WorldMapData field3910;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   WorldMapData field3937;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   WorldMapData field3923;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Law;"
   )
   class41 field3924;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   class311 field3925;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1235789667
   )
   int field3926;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 379604783
   )
   int field3939;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1991070423
   )
   int field3934;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1111980395
   )
   int field3929;
   @ObfuscatedName("z")
   float field3930;
   @ObfuscatedName("b")
   float field3931;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1002881157
   )
   int field3932;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 2058176503
   )
   int field3933;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1220297453
   )
   int field3927;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1750958467
   )
   int field3935;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1526591891
   )
   int field3936;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1919860677
   )
   int field3921;
   @ObfuscatedName("ax")
   boolean field3913;
   @ObfuscatedName("ae")
   HashSet field3952;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1676823481
   )
   int field3940;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1048040225
   )
   int field3941;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1663134149
   )
   int field3942;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1389278383
   )
   int field3943;
   @ObfuscatedName("af")
   HashSet field3944;
   @ObfuscatedName("an")
   HashSet field3945;
   @ObfuscatedName("ag")
   HashSet field3909;
   @ObfuscatedName("av")
   HashSet field3947;
   @ObfuscatedName("aw")
   boolean field3948;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -508855993
   )
   int field3949;
   @ObfuscatedName("aq")
   final int[] field3950;
   @ObfuscatedName("ac")
   List field3951;
   @ObfuscatedName("ak")
   Iterator field3953;
   @ObfuscatedName("az")
   HashSet field3922;
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   Coordinates field3954;

   static {
      fontNameVerdana11 = FontName.field3723;
      fontNameVerdana13 = FontName.field3733;
      fontNameVerdana15 = FontName.field3734;
   }

   public RenderOverview() {
      this.field3934 = -1;
      this.field3929 = -1;
      this.field3932 = -1;
      this.field3933 = -1;
      this.field3927 = -1;
      this.field3935 = -1;
      this.field3936 = 3;
      this.field3921 = 50;
      this.field3913 = false;
      this.field3952 = null;
      this.field3940 = -1;
      this.field3941 = -1;
      this.field3942 = -1;
      this.field3943 = -1;
      this.field3944 = new HashSet();
      this.field3945 = new HashSet();
      this.field3909 = new HashSet();
      this.field3947 = new HashSet();
      this.field3948 = false;
      this.field3949 = 0;
      this.field3950 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3922 = new HashSet();
      this.field3954 = null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;Lkz;Ljava/util/HashMap;[Lkh;B)V",
      garbageValue = "12"
   )
   public void method5825(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field3919 = var4;
      this.field3911 = var1;
      this.field3917 = var2;
      this.field3938 = new HashMap();
      this.field3938.put(Size.field343, var3.get(fontNameVerdana11));
      this.field3938.put(Size.field336, var3.get(fontNameVerdana13));
      this.field3938.put(Size.field340, var3.get(fontNameVerdana15));
      this.field3925 = new class311(var1);
      int var5 = this.field3911.getFile(class40.field508.field509);
      int[] var6 = this.field3911.getChilds(var5);
      this.field3920 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3911.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3920.put(var9.method299(), var9);
         if(var9.method324()) {
            this.field3910 = var9;
         }
      }

      this.method5811(this.field3910);
      this.field3923 = null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-100"
   )
   public int method5662() {
      return this.field3911.tryLoadRecordByNames(this.field3910.method299(), class40.field512.field509)?100:this.field3911.archiveLoadPercentByName(this.field3910.method299());
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "1230632223"
   )
   public void method5663(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3925.method5647()) {
         this.method5716();
         this.method5667();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3930));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3930));
            List var10 = this.field3924.method557(this.field3926 - var8 / 2 - 1, this.field3939 - var9 / 2 - 1, var8 / 2 + this.field3926 + 1, var9 / 2 + this.field3939 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            ScriptEvent var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); class87.method1851(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new class47(var13.field495, var13.field500, var13.field496);
               var14.method1076(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3922.contains(var13)) {
                  var14.method1077(class230.field2883);
               } else {
                  var14.method1077(class230.field2881);
               }
            }

            var12 = this.field3922.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new class47(var13.field495, var13.field500, var13.field496);
                  var14.method1076(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1077(class230.field2882);
                  class87.method1851(var14);
               }
            }

            this.field3922 = var11;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIZZI)V",
      garbageValue = "193049714"
   )
   public void method5664(int var1, int var2, boolean var3, boolean var4) {
      this.method5699(var1, var2, var4);
      if(this.field3942 == -1) {
         this.field3942 = var1;
      }

      if(this.field3943 == -1) {
         this.field3943 = var2;
      }

      int var5 = var1 - this.field3942;
      int var6 = var2 - this.field3943;
      this.field3942 = var1;
      this.field3943 = var2;
      if(var3 && !this.method5668()) {
         this.field3926 -= (int)((float)var5 / this.field3931);
         this.field3939 += (int)((float)var6 / this.field3931);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "2015102595"
   )
   void method5699(int var1, int var2, boolean var3) {
      if(Signlink.method3107()) {
         if(this.field3937 != null) {
            int var4 = (int)((float)this.field3926 + ((float)(var1 - this.field3927) - (float)this.method5694() * this.field3930 / 2.0F) / this.field3930);
            int var5 = (int)((float)this.field3939 - ((float)(var2 - this.field3935) - (float)this.method5687() * this.field3930 / 2.0F) / this.field3930);
            this.field3954 = this.field3937.method295(var4 + this.field3937.method358() * 64, var5 + this.field3937.method305() * 64);
            if(this.field3954 != null && var3 && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81] && var3) {
               int var6 = this.field3954.worldX;
               int var7 = this.field3954.worldY;
               int var8 = this.field3954.plane;
               PacketNode var9 = class35.method501(ClientPacket.field2375, Client.field867.field1439);
               var9.packetBuffer.putByte(var8);
               var9.packetBuffer.putShortLE(var6);
               var9.packetBuffer.putShort(var7);
               Client.field867.method2021(var9);
            }
         } else {
            this.field3954 = null;
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-86"
   )
   void method5716() {
      if(this.field3930 < this.field3931) {
         this.field3930 = Math.min(this.field3931, this.field3930 / 30.0F + this.field3930);
      }

      if(this.field3930 > this.field3931) {
         this.field3930 = Math.max(this.field3931, this.field3930 - this.field3930 / 30.0F);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1662439604"
   )
   void method5667() {
      if(this.method5668()) {
         int var1 = this.field3934 - this.field3926;
         int var2 = this.field3929 - this.field3939;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3926 += var1;
         this.field3939 += var2;
         if(this.field3934 == this.field3926 && this.field3929 == this.field3939) {
            this.field3934 = -1;
            this.field3929 = -1;
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "160608345"
   )
   boolean method5668() {
      return this.field3934 != -1 && this.field3929 != -1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIB)Lae;",
      garbageValue = "0"
   )
   public WorldMapData method5836(int var1, int var2, int var3) {
      Iterator var4 = this.field3920.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method292(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIZB)V",
      garbageValue = "23"
   )
   public void method5670(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5836(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3910;
      }

      boolean var6 = false;
      if(var5 != this.field3923 || var4) {
         this.field3923 = var5;
         this.method5811(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5677(var1, var2, var3);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "37"
   )
   public void method5671(int var1) {
      WorldMapData var2 = this.method5686(var1);
      if(var2 != null) {
         this.method5811(var2);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1256469415"
   )
   public int method5672() {
      return this.field3937 == null?-1:this.field3937.method297();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Lae;",
      garbageValue = "2018808740"
   )
   public WorldMapData method5673() {
      return this.field3937;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lae;I)V",
      garbageValue = "-1144325150"
   )
   void method5811(WorldMapData var1) {
      if(this.field3937 == null || var1 != this.field3937) {
         this.method5791(var1);
         this.method5677(-1, -1, -1);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lae;I)V",
      garbageValue = "-1010307565"
   )
   void method5791(WorldMapData var1) {
      this.field3937 = var1;
      this.field3924 = new class41(this.field3919, this.field3938);
      this.field3925.method5645(this.field3937.method299());
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lae;Lhn;Lhn;ZI)V",
      garbageValue = "430529424"
   )
   public void method5660(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.field3937 == null || var1 != this.field3937) {
            this.method5791(var1);
         }

         if(!var4 && this.field3937.method292(var2.plane, var2.worldX, var2.worldY)) {
            this.method5677(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5677(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1007118946"
   )
   void method5677(int var1, int var2, int var3) {
      if(this.field3937 != null) {
         int[] var4 = this.field3937.method294(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3937.method294(this.field3937.method349(), this.field3937.method355(), this.field3937.method308());
         }

         this.field3926 = var4[0] - this.field3937.method358() * 64;
         this.field3939 = var4[1] - this.field3937.method305() * 64;
         this.field3934 = -1;
         this.field3929 = -1;
         this.field3930 = this.method5682(this.field3937.method302());
         this.field3931 = this.field3930;
         this.field3951 = null;
         this.field3953 = null;
         this.field3924.method586();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1874079470"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      int var7 = this.field3925.method5648();
      if(var7 < 100) {
         this.method5681(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3924.method559()) {
            this.field3924.method584(this.field3911, this.field3937.method299(), Client.isMembers);
            if(!this.field3924.method559()) {
               return;
            }
         }

         if(this.field3952 != null) {
            ++this.field3941;
            if(this.field3941 % this.field3921 == 0) {
               this.field3941 = 0;
               ++this.field3940;
            }

            if(this.field3940 >= this.field3936 && !this.field3913) {
               this.field3952 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3930));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3930));
         this.field3924.method553(this.field3926 - var8 / 2, this.field3939 - var9 / 2, var8 / 2 + this.field3926, var9 / 2 + this.field3939, var1, var2, var3 + var1, var2 + var4);
         if(!this.field3948) {
            boolean var10 = false;
            if(var5 - this.field3949 > 100) {
               this.field3949 = var5;
               var10 = true;
            }

            this.field3924.method554(this.field3926 - var8 / 2, this.field3939 - var9 / 2, var8 / 2 + this.field3926, var9 / 2 + this.field3939, var1, var2, var3 + var1, var2 + var4, this.field3947, this.field3952, this.field3941, this.field3921, var10);
         }

         if(Signlink.method3107() && this.field3954 != null) {
            this.field3917.method5225("Coord: " + this.field3954, Rasterizer2D.draw_region_x + 10, Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
         }

         this.field3932 = var8;
         this.field3933 = var9;
         this.field3927 = var1;
         this.field3935 = var2;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-600804804"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3925.method5647()) {
         if(!this.field3924.method559()) {
            this.field3924.method584(this.field3911, this.field3937.method299(), Client.isMembers);
            if(!this.field3924.method559()) {
               return;
            }
         }

         this.field3924.method556(var1, var2, var3, var4, this.field3952, this.field3941, this.field3921);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-22"
   )
   public void method5680(int var1) {
      this.field3931 = this.method5682(var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "-6"
   )
   void method5681(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.Rasterizer2D_fillRectangle(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3917.drawTextCentered("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)F",
      garbageValue = "-66"
   )
   float method5682(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1067029615"
   )
   public int method5683() {
      return (double)this.field3931 == 1.0D?25:(1.5D == (double)this.field3931?37:(2.0D == (double)this.field3931?50:(3.0D == (double)this.field3931?75:((double)this.field3931 == 4.0D?100:200))));
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-47"
   )
   public void method5684() {
      this.field3925.method5644();
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2077252539"
   )
   public boolean method5837() {
      return this.field3925.method5647();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)Lae;",
      garbageValue = "-199166531"
   )
   public WorldMapData method5686(int var1) {
      Iterator var2 = this.field3920.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method297() != var1);

      return var3;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-515578176"
   )
   public void method5785(int var1, int var2) {
      if(this.field3937 != null && this.field3937.method293(var1, var2)) {
         this.field3934 = var1 - this.field3937.method358() * 64;
         this.field3929 = var2 - this.field3937.method305() * 64;
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1419264734"
   )
   public void method5820(int var1, int var2) {
      if(this.field3937 != null) {
         this.field3926 = var1 - this.field3937.method358() * 64;
         this.field3939 = var2 - this.field3937.method305() * 64;
         this.field3934 = -1;
         this.field3929 = -1;
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1240183039"
   )
   public void method5689(int var1, int var2, int var3) {
      if(this.field3937 != null) {
         int[] var4 = this.field3937.method294(var1, var2, var3);
         if(var4 != null) {
            this.method5785(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1800865292"
   )
   public void method5661(int var1, int var2, int var3) {
      if(this.field3937 != null) {
         int[] var4 = this.field3937.method294(var1, var2, var3);
         if(var4 != null) {
            this.method5820(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "115"
   )
   public int method5840() {
      return this.field3937 == null?-1:this.field3926 + this.field3937.method358() * 64;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-67"
   )
   public int method5784() {
      return this.field3937 == null?-1:this.field3939 + this.field3937.method305() * 64;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)Lhn;",
      garbageValue = "-64"
   )
   public Coordinates method5693() {
      return this.field3937 == null?null:this.field3937.method295(this.method5840(), this.method5784());
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-588566327"
   )
   public int method5694() {
      return this.field3932;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method5687() {
      return this.field3933;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1607273865"
   )
   public void method5696(int var1) {
      if(var1 >= 1) {
         this.field3936 = var1;
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-215436821"
   )
   public void method5697() {
      this.field3936 = 3;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1251261819"
   )
   public void method5806(int var1) {
      if(var1 >= 1) {
         this.field3921 = var1;
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-314212416"
   )
   public void method5705() {
      this.field3921 = 50;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "817942677"
   )
   public void method5700(boolean var1) {
      this.field3913 = var1;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-6"
   )
   public void method5701(int var1) {
      this.field3952 = new HashSet();
      this.field3952.add(Integer.valueOf(var1));
      this.field3940 = 0;
      this.field3941 = 0;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "100"
   )
   public void method5702(int var1) {
      this.field3952 = new HashSet();
      this.field3940 = 0;
      this.field3941 = 0;

      for(int var2 = 0; var2 < Area.mapAreaType.length; ++var2) {
         if(Area.mapAreaType[var2] != null && Area.mapAreaType[var2].field3373 == var1) {
            this.field3952.add(Integer.valueOf(Area.mapAreaType[var2].field3360));
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-189840185"
   )
   public void method5703() {
      this.field3952 = null;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-660162081"
   )
   public void method5779(boolean var1) {
      this.field3948 = !var1;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-973773125"
   )
   public void method5707(int var1, boolean var2) {
      if(!var2) {
         this.field3944.add(Integer.valueOf(var1));
      } else {
         this.field3944.remove(Integer.valueOf(var1));
      }

      this.method5826();
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "126"
   )
   public void method5794(int var1, boolean var2) {
      if(!var2) {
         this.field3945.add(Integer.valueOf(var1));
      } else {
         this.field3945.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.mapAreaType.length; ++var3) {
         if(Area.mapAreaType[var3] != null && Area.mapAreaType[var3].field3373 == var1) {
            int var4 = Area.mapAreaType[var3].field3360;
            if(!var2) {
               this.field3909.add(Integer.valueOf(var4));
            } else {
               this.field3909.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5826();
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-129636072"
   )
   public boolean method5731() {
      return !this.field3948;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-305271517"
   )
   public boolean method5708(int var1) {
      return !this.field3944.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "462592701"
   )
   public boolean method5709(int var1) {
      return !this.field3945.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "128"
   )
   void method5826() {
      this.field3947.clear();
      this.field3947.addAll(this.field3944);
      this.field3947.addAll(this.field3909);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-256564279"
   )
   public void method5691(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3925.method5647()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3930));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3930));
         List var9 = this.field3924.method557(this.field3926 - var7 / 2 - 1, this.field3939 - var8 / 2 - 1, var7 / 2 + this.field3926 + 1, var8 / 2 + this.field3939 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               Area var12 = Area.mapAreaType[var11.field495];
               var13 = false;

               for(int var14 = this.field3950.length - 1; var14 >= 0; --var14) {
                  if(var12.field3362[var14] != null) {
                     class3.addMenuEntry(var12.field3362[var14], var12.field3366, this.field3950[var14], var11.field495, var11.field500.method4196(), var11.field496.method4196());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(ILhn;I)Lhn;",
      garbageValue = "1859443837"
   )
   public Coordinates method5728(int var1, Coordinates var2) {
      if(!this.field3925.method5647()) {
         return null;
      } else if(!this.field3924.method559()) {
         return null;
      } else if(!this.field3937.method293(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.field3924.method560();
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
                     return var5.field496;
                  }

                  var8 = (class39)var7.next();
                  int var9 = var8.field496.worldX - var2.worldX;
                  int var10 = var8.field496.worldY - var2.worldY;
                  var11 = var10 * var10 + var9 * var9;
                  if(var11 == 0) {
                     return var8.field496;
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

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(IILhn;Lhn;I)V",
      garbageValue = "-1447863894"
   )
   public void method5816(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1076(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1077(class230.field2886);
         break;
      case 1009:
         var5.method1077(class230.field2880);
         break;
      case 1010:
         var5.method1077(class230.field2878);
         break;
      case 1011:
         var5.method1077(class230.field2884);
         break;
      case 1012:
         var5.method1077(class230.field2879);
      }

      class87.method1851(var5);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(B)Lag;",
      garbageValue = "14"
   )
   public class39 method5714() {
      if(!this.field3925.method5647()) {
         return null;
      } else if(!this.field3924.method559()) {
         return null;
      } else {
         HashMap var1 = this.field3924.method560();
         this.field3951 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3951.addAll(var3);
         }

         this.field3953 = this.field3951.iterator();
         return this.method5715();
      }
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(I)Lag;",
      garbageValue = "-1470814756"
   )
   public class39 method5715() {
      return this.field3953 == null?null:(!this.field3953.hasNext()?null:(class39)this.field3953.next());
   }
}
