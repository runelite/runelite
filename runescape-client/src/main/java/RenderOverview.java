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

@ObfuscatedName("kl")
@Implements("RenderOverview")
public class RenderOverview {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("fontNameVerdana11")
   static final FontName fontNameVerdana11;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("fontNameVerdana13")
   static final FontName fontNameVerdana13;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("fontNameVerdana15")
   static final FontName fontNameVerdana15;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   IndexDataBase field3925;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   Font field3888;
   @ObfuscatedName("u")
   HashMap field3889;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Lkm;"
   )
   IndexedSprite[] field3890;
   @ObfuscatedName("w")
   HashMap field3918;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   WorldMapData field3892;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   WorldMapData field3893;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   WorldMapData field3894;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   class41 field3895;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   class300 field3907;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1348949345
   )
   int field3897;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2044624325
   )
   int field3916;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -298687497
   )
   int field3884;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 923496081
   )
   int field3913;
   @ObfuscatedName("c")
   float field3891;
   @ObfuscatedName("k")
   float field3902;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 555542541
   )
   int field3903;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1933292409
   )
   int field3886;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1830302445
   )
   int field3905;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 748729021
   )
   int field3906;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -2117014219
   )
   int field3900;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 48346025
   )
   int field3882;
   @ObfuscatedName("af")
   boolean field3909;
   @ObfuscatedName("az")
   HashSet field3910;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1070224289
   )
   int field3911;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 703992323
   )
   int field3912;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1220642567
   )
   int field3924;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 753591557
   )
   int field3914;
   @ObfuscatedName("ah")
   HashSet field3915;
   @ObfuscatedName("ab")
   HashSet field3899;
   @ObfuscatedName("aj")
   HashSet field3908;
   @ObfuscatedName("aa")
   HashSet field3896;
   @ObfuscatedName("ao")
   boolean field3919;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1683106557
   )
   int field3920;
   @ObfuscatedName("aq")
   final int[] field3921;
   @ObfuscatedName("ak")
   List field3922;
   @ObfuscatedName("as")
   Iterator field3923;
   @ObfuscatedName("au")
   HashSet field3901;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   Coordinates field3917;

   static {
      fontNameVerdana11 = FontName.field3704;
      fontNameVerdana13 = FontName.field3706;
      fontNameVerdana15 = FontName.field3707;
   }

   public RenderOverview() {
      this.field3884 = -1;
      this.field3913 = -1;
      this.field3903 = -1;
      this.field3886 = -1;
      this.field3905 = -1;
      this.field3906 = -1;
      this.field3900 = 3;
      this.field3882 = 50;
      this.field3909 = false;
      this.field3910 = null;
      this.field3911 = -1;
      this.field3912 = -1;
      this.field3924 = -1;
      this.field3914 = -1;
      this.field3915 = new HashSet();
      this.field3899 = new HashSet();
      this.field3908 = new HashSet();
      this.field3896 = new HashSet();
      this.field3919 = false;
      this.field3920 = 0;
      this.field3921 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3901 = new HashSet();
      this.field3917 = null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lil;Ljz;Ljava/util/HashMap;[Lkm;I)V",
      garbageValue = "-1750364617"
   )
   public void method5424(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field3890 = var4;
      this.field3925 = var1;
      this.field3888 = var2;
      this.field3889 = new HashMap();
      this.field3889.put(Size.field351, var3.get(fontNameVerdana11));
      this.field3889.put(Size.field348, var3.get(fontNameVerdana13));
      this.field3889.put(Size.field349, var3.get(fontNameVerdana15));
      this.field3907 = new class300(var1);
      int var5 = this.field3925.getFile(class40.field522.field517);
      int[] var6 = this.field3925.getChilds(var5);
      this.field3918 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3925.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3918.put(var9.method278(), var9);
         if(var9.method333()) {
            this.field3892 = var9;
         }
      }

      this.method5445(this.field3892);
      this.field3894 = null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1888373425"
   )
   public int method5425() {
      return this.field3925.tryLoadRecordByNames(this.field3892.method278(), class40.field521.field517)?100:this.field3925.archiveLoadPercentByName(this.field3892.method278());
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "-1090439266"
   )
   public void method5426(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3907.method5414()) {
         this.method5429();
         this.method5430();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3891));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3891));
            List var10 = this.field3895.method571(this.field3897 - var8 / 2 - 1, this.field3916 - var9 / 2 - 1, var8 / 2 + this.field3897 + 1, var9 / 2 + this.field3916 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            ScriptEvent var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); Preferences.method1633(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new class47(var13.field512, var13.field509, var13.field514);
               var14.method1107(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3901.contains(var13)) {
                  var14.method1106(class230.field2906);
               } else {
                  var14.method1106(class230.field2899);
               }
            }

            var12 = this.field3901.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new class47(var13.field512, var13.field509, var13.field514);
                  var14.method1107(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1106(class230.field2905);
                  Preferences.method1633(var14);
               }
            }

            this.field3901 = var11;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIZZB)V",
      garbageValue = "4"
   )
   public void method5575(int var1, int var2, boolean var3, boolean var4) {
      this.method5428(var1, var2, var4);
      if(this.field3924 == -1) {
         this.field3924 = var1;
      }

      if(this.field3914 == -1) {
         this.field3914 = var2;
      }

      int var5 = var1 - this.field3924;
      int var6 = var2 - this.field3914;
      this.field3924 = var1;
      this.field3914 = var2;
      if(var3 && !this.method5524()) {
         this.field3897 -= (int)((float)var5 / this.field3902);
         this.field3916 += (int)((float)var6 / this.field3902);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "8"
   )
   void method5428(int var1, int var2, boolean var3) {
      boolean var4 = Client.rights >= 2;
      if(var4) {
         if(this.field3893 != null) {
            int var5 = (int)((float)this.field3897 + ((float)(var1 - this.field3905) - (float)this.method5457() * this.field3891 / 2.0F) / this.field3891);
            int var6 = (int)((float)this.field3916 - ((float)(var2 - this.field3906) - (float)this.method5458() * this.field3891 / 2.0F) / this.field3891);
            this.field3917 = this.field3893.method279(var5 + this.field3893.method297() * 64, var6 + this.field3893.method289() * 64);
            if(this.field3917 != null && var3 && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81] && var3) {
               class5.method12(this.field3917.worldX, this.field3917.worldY, this.field3917.plane);
            }
         } else {
            this.field3917 = null;
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1585649409"
   )
   void method5429() {
      if(this.field3891 < this.field3902) {
         this.field3891 = Math.min(this.field3902, this.field3891 + this.field3891 / 30.0F);
      }

      if(this.field3891 > this.field3902) {
         this.field3891 = Math.max(this.field3902, this.field3891 - this.field3891 / 30.0F);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-116"
   )
   void method5430() {
      if(this.method5524()) {
         int var1 = this.field3884 - this.field3897;
         int var2 = this.field3913 - this.field3916;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3897 += var1;
         this.field3916 += var2;
         if(this.field3897 == this.field3884 && this.field3913 == this.field3916) {
            this.field3884 = -1;
            this.field3913 = -1;
         }

      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "99"
   )
   boolean method5524() {
      return this.field3884 != -1 && this.field3913 != -1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)Laz;",
      garbageValue = "-1234160309"
   )
   public WorldMapData method5432(int var1, int var2, int var3) {
      Iterator var4 = this.field3918.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method276(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIZS)V",
      garbageValue = "9049"
   )
   public void method5597(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5432(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3892;
      }

      boolean var6 = false;
      if(var5 != this.field3894 || var4) {
         this.field3894 = var5;
         this.method5445(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5440(var1, var2, var3);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2125842609"
   )
   public void method5434(int var1) {
      WorldMapData var2 = this.method5449(var1);
      if(var2 != null) {
         this.method5445(var2);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1142847061"
   )
   public int method5554() {
      return this.field3893 == null?-1:this.field3893.method281();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Laz;",
      garbageValue = "2"
   )
   public WorldMapData method5436() {
      return this.field3893;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Laz;B)V",
      garbageValue = "-10"
   )
   void method5445(WorldMapData var1) {
      if(this.field3893 == null || var1 != this.field3893) {
         this.method5438(var1);
         this.method5440(-1, -1, -1);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Laz;I)V",
      garbageValue = "-665741145"
   )
   void method5438(WorldMapData var1) {
      this.field3893 = var1;
      this.field3895 = new class41(this.field3890, this.field3889);
      this.field3907.method5412(this.field3893.method278());
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Laz;Lht;Lht;ZI)V",
      garbageValue = "1875643387"
   )
   public void method5439(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.field3893 == null || var1 != this.field3893) {
            this.method5438(var1);
         }

         if(!var4 && this.field3893.method276(var2.plane, var2.worldX, var2.worldY)) {
            this.method5440(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5440(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1360842154"
   )
   void method5440(int var1, int var2, int var3) {
      if(this.field3893 != null) {
         int[] var4 = this.field3893.method322(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3893.method322(this.field3893.method292(), this.field3893.method274(), this.field3893.method293());
         }

         this.field3897 = var4[0] - this.field3893.method297() * 64;
         this.field3916 = var4[1] - this.field3893.method289() * 64;
         this.field3884 = -1;
         this.field3913 = -1;
         this.field3891 = this.method5431(this.field3893.method288());
         this.field3902 = this.field3891;
         this.field3922 = null;
         this.field3923 = null;
         this.field3895.method578();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "-98"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      int var7 = this.field3907.method5415();
      if(var7 < 100) {
         this.method5444(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3895.method550()) {
            this.field3895.method569(this.field3925, this.field3893.method278(), Client.isMembers);
            if(!this.field3895.method550()) {
               return;
            }
         }

         if(this.field3910 != null) {
            ++this.field3912;
            if(this.field3912 % this.field3882 == 0) {
               this.field3912 = 0;
               ++this.field3911;
            }

            if(this.field3911 >= this.field3900 && !this.field3909) {
               this.field3910 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3891));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3891));
         this.field3895.method544(this.field3897 - var8 / 2, this.field3916 - var9 / 2, var8 / 2 + this.field3897, var9 / 2 + this.field3916, var1, var2, var3 + var1, var2 + var4);
         boolean var10;
         if(!this.field3919) {
            var10 = false;
            if(var5 - this.field3920 > 100) {
               this.field3920 = var5;
               var10 = true;
            }

            this.field3895.method542(this.field3897 - var8 / 2, this.field3916 - var9 / 2, var8 / 2 + this.field3897, var9 / 2 + this.field3916, var1, var2, var3 + var1, var2 + var4, this.field3896, this.field3910, this.field3912, this.field3882, var10);
         }

         var10 = Client.rights >= 2;
         if(var10 && this.field3917 != null) {
            this.field3888.method4950("Coord: " + this.field3917, Rasterizer2D.draw_region_x + 10, Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
         }

         this.field3903 = var8;
         this.field3886 = var9;
         this.field3905 = var1;
         this.field3906 = var2;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "127"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3907.method5414()) {
         if(!this.field3895.method550()) {
            this.field3895.method569(this.field3925, this.field3893.method278(), Client.isMembers);
            if(!this.field3895.method550()) {
               return;
            }
         }

         this.field3895.method547(var1, var2, var3, var4, this.field3910, this.field3912, this.field3882);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "3056"
   )
   public void method5459(int var1) {
      this.field3902 = this.method5431(var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1442370584"
   )
   void method5444(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.Rasterizer2D_fillRectangle(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3888.drawTextCentered("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)F",
      garbageValue = "1722867053"
   )
   float method5431(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "69"
   )
   public int method5446() {
      return (double)this.field3902 == 1.0D?25:((double)this.field3902 == 1.5D?37:((double)this.field3902 == 2.0D?50:((double)this.field3902 == 3.0D?75:(4.0D == (double)this.field3902?100:200))));
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2056919475"
   )
   public void method5447() {
      this.field3907.method5413();
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "706162689"
   )
   public boolean method5448() {
      return this.field3907.method5414();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)Laz;",
      garbageValue = "1360300541"
   )
   public WorldMapData method5449(int var1) {
      Iterator var2 = this.field3918.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method281() != var1);

      return var3;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-513591334"
   )
   public void method5450(int var1, int var2) {
      if(this.field3893 != null && this.field3893.method296(var1, var2)) {
         this.field3884 = var1 - this.field3893.method297() * 64;
         this.field3913 = var2 - this.field3893.method289() * 64;
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "36"
   )
   public void method5477(int var1, int var2) {
      if(this.field3893 != null) {
         this.field3897 = var1 - this.field3893.method297() * 64;
         this.field3916 = var2 - this.field3893.method289() * 64;
         this.field3884 = -1;
         this.field3913 = -1;
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-541448036"
   )
   public void method5441(int var1, int var2, int var3) {
      if(this.field3893 != null) {
         int[] var4 = this.field3893.method322(var1, var2, var3);
         if(var4 != null) {
            this.method5450(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-466266958"
   )
   public void method5581(int var1, int var2, int var3) {
      if(this.field3893 != null) {
         int[] var4 = this.field3893.method322(var1, var2, var3);
         if(var4 != null) {
            this.method5477(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "577142486"
   )
   public int method5454() {
      return this.field3893 == null?-1:this.field3897 + this.field3893.method297() * 64;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1640255315"
   )
   public int method5455() {
      return this.field3893 == null?-1:this.field3916 + this.field3893.method289() * 64;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)Lht;",
      garbageValue = "-1560268290"
   )
   public Coordinates method5437() {
      return this.field3893 == null?null:this.field3893.method279(this.method5454(), this.method5455());
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1012401273"
   )
   public int method5457() {
      return this.field3903;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1136102974"
   )
   public int method5458() {
      return this.field3886;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1749181064"
   )
   public void method5443(int var1) {
      if(var1 >= 1) {
         this.field3900 = var1;
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-62"
   )
   public void method5460() {
      this.field3900 = 3;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "7"
   )
   public void method5601(int var1) {
      if(var1 >= 1) {
         this.field3882 = var1;
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1420529758"
   )
   public void method5462() {
      this.field3882 = 50;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1298853147"
   )
   public void method5463(boolean var1) {
      this.field3909 = var1;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1465578647"
   )
   public void method5453(int var1) {
      this.field3910 = new HashSet();
      this.field3910.add(Integer.valueOf(var1));
      this.field3911 = 0;
      this.field3912 = 0;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-121"
   )
   public void method5465(int var1) {
      this.field3910 = new HashSet();
      this.field3911 = 0;
      this.field3912 = 0;

      for(int var2 = 0; var2 < Area.mapAreaType.length; ++var2) {
         if(Area.mapAreaType[var2] != null && Area.mapAreaType[var2].field3401 == var1) {
            this.field3910.add(Integer.valueOf(Area.mapAreaType[var2].field3384));
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1052783577"
   )
   public void method5466() {
      this.field3910 = null;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "20"
   )
   public void method5467(boolean var1) {
      this.field3919 = !var1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1932281917"
   )
   public void method5578(int var1, boolean var2) {
      if(!var2) {
         this.field3915.add(Integer.valueOf(var1));
      } else {
         this.field3915.remove(Integer.valueOf(var1));
      }

      this.method5473();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-245899759"
   )
   public void method5557(int var1, boolean var2) {
      if(!var2) {
         this.field3899.add(Integer.valueOf(var1));
      } else {
         this.field3899.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.mapAreaType.length; ++var3) {
         if(Area.mapAreaType[var3] != null && Area.mapAreaType[var3].field3401 == var1) {
            int var4 = Area.mapAreaType[var3].field3384;
            if(!var2) {
               this.field3908.add(Integer.valueOf(var4));
            } else {
               this.field3908.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5473();
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "995527087"
   )
   public boolean method5470() {
      return !this.field3919;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1295234738"
   )
   public boolean method5471(int var1) {
      return !this.field3915.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   public boolean method5433(int var1) {
      return !this.field3899.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-747632746"
   )
   void method5473() {
      this.field3896.clear();
      this.field3896.addAll(this.field3915);
      this.field3896.addAll(this.field3908);
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "114"
   )
   public void method5506(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3907.method5414()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3891));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3891));
         List var9 = this.field3895.method571(this.field3897 - var7 / 2 - 1, this.field3916 - var8 / 2 - 1, var7 / 2 + this.field3897 + 1, var8 / 2 + this.field3916 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               Area var12 = Area.mapAreaType[var11.field512];
               var13 = false;

               for(int var14 = this.field3921.length - 1; var14 >= 0; --var14) {
                  if(var12.field3398[var14] != null) {
                     DecorativeObject.addMenuEntry(var12.field3398[var14], var12.field3393, this.field3921[var14], var11.field512, var11.field509.method4160(), var11.field514.method4160());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(ILht;I)Lht;",
      garbageValue = "1268161711"
   )
   public Coordinates method5475(int var1, Coordinates var2) {
      if(!this.field3907.method5414()) {
         return null;
      } else if(!this.field3895.method550()) {
         return null;
      } else if(!this.field3893.method296(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.field3895.method551();
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
                     return var5.field514;
                  }

                  var8 = (class39)var7.next();
                  int var9 = var8.field514.worldX - var2.worldX;
                  int var10 = var8.field514.worldY - var2.worldY;
                  var11 = var9 * var9 + var10 * var10;
                  if(var11 == 0) {
                     return var8.field514;
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

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IILht;Lht;I)V",
      garbageValue = "-1890694685"
   )
   public void method5476(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1107(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1106(class230.field2904);
         break;
      case 1009:
         var5.method1106(class230.field2900);
         break;
      case 1010:
         var5.method1106(class230.field2901);
         break;
      case 1011:
         var5.method1106(class230.field2909);
         break;
      case 1012:
         var5.method1106(class230.field2903);
      }

      Preferences.method1633(var5);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I)Laj;",
      garbageValue = "102268217"
   )
   public class39 method5478() {
      if(!this.field3907.method5414()) {
         return null;
      } else if(!this.field3895.method550()) {
         return null;
      } else {
         HashMap var1 = this.field3895.method551();
         this.field3922 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3922.addAll(var3);
         }

         this.field3923 = this.field3922.iterator();
         return this.method5596();
      }
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I)Laj;",
      garbageValue = "2082935946"
   )
   public class39 method5596() {
      return this.field3923 == null?null:(!this.field3923.hasNext()?null:(class39)this.field3923.next());
   }
}
