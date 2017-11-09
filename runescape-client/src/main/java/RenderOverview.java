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

@ObfuscatedName("kz")
@Implements("RenderOverview")
public class RenderOverview {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   static final class268 field3892;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   static final class268 field3876;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   static final class268 field3870;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   IndexDataBase field3873;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   Font field3872;
   @ObfuscatedName("a")
   HashMap field3895;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "[Lko;"
   )
   IndexedSprite[] field3871;
   @ObfuscatedName("w")
   HashMap field3875;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   WorldMapData field3908;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   WorldMapData field3877;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   WorldMapData field3878;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Law;"
   )
   class41 field3879;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   class296 field3880;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -950095321
   )
   int field3909;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1035096807
   )
   int field3882;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 694162097
   )
   int field3883;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1174789315
   )
   int field3884;
   @ObfuscatedName("s")
   float field3885;
   @ObfuscatedName("f")
   float field3886;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1214788167
   )
   int field3887;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 2079745981
   )
   int field3888;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1047470849
   )
   int field3889;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 933974723
   )
   int field3890;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -814603963
   )
   int field3891;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -2141932389
   )
   int field3901;
   @ObfuscatedName("ag")
   boolean field3893;
   @ObfuscatedName("ap")
   HashSet field3868;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1623897553
   )
   int field3869;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1690720815
   )
   int field3896;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -580932169
   )
   int field3897;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 2006900703
   )
   int field3898;
   @ObfuscatedName("ah")
   HashSet field3881;
   @ObfuscatedName("am")
   HashSet field3900;
   @ObfuscatedName("ay")
   HashSet field3894;
   @ObfuscatedName("az")
   HashSet field3902;
   @ObfuscatedName("aw")
   boolean field3903;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1061227
   )
   int field3904;
   @ObfuscatedName("ai")
   final int[] field3874;
   @ObfuscatedName("ax")
   List field3905;
   @ObfuscatedName("af")
   Iterator field3907;
   @ObfuscatedName("aa")
   HashSet field3906;
   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   Coordinates field3864;

   static {
      field3892 = class268.field3676;
      field3876 = class268.field3687;
      field3870 = class268.field3674;
   }

   public RenderOverview() {
      this.field3883 = -1;
      this.field3884 = -1;
      this.field3887 = -1;
      this.field3888 = -1;
      this.field3889 = -1;
      this.field3890 = -1;
      this.field3891 = 3;
      this.field3901 = 50;
      this.field3893 = false;
      this.field3868 = null;
      this.field3869 = -1;
      this.field3896 = -1;
      this.field3897 = -1;
      this.field3898 = -1;
      this.field3881 = new HashSet();
      this.field3900 = new HashSet();
      this.field3894 = new HashSet();
      this.field3902 = new HashSet();
      this.field3903 = false;
      this.field3904 = 0;
      this.field3874 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3906 = new HashSet();
      this.field3864 = null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lik;Ljt;Ljava/util/HashMap;[Lko;B)V",
      garbageValue = "-76"
   )
   public void method5413(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field3871 = var4;
      this.field3873 = var1;
      this.field3872 = var2;
      this.field3895 = new HashMap();
      this.field3895.put(class24.field356, var3.get(field3892));
      this.field3895.put(class24.field348, var3.get(field3876));
      this.field3895.put(class24.field349, var3.get(field3870));
      this.field3880 = new class296(var1);
      int var5 = this.field3873.getFile(class40.field514.field512);
      int[] var6 = this.field3873.getChilds(var5);
      this.field3875 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3873.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3875.put(var9.method319(), var9);
         if(var9.method316()) {
            this.field3908 = var9;
         }
      }

      this.method5571(this.field3908);
      this.field3878 = null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
   )
   public int method5474() {
      return this.field3873.method4295(this.field3908.method319(), class40.field515.field512)?100:this.field3873.method4323(this.field3908.method319());
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "-761271580"
   )
   public void method5415(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3880.method5400()) {
         this.method5418();
         this.method5419();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3885));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3885));
            List var10 = this.field3879.method601(this.field3909 - var8 / 2 - 1, this.field3882 - var9 / 2 - 1, var8 / 2 + this.field3909 + 1, var9 / 2 + this.field3882 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            ScriptEvent var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); class111.method2177(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new class47(var13.field508, var13.field498, var13.field499);
               var14.method1159(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3906.contains(var13)) {
                  var14.method1160(class226.field2868);
               } else {
                  var14.method1160(class226.field2866);
               }
            }

            var12 = this.field3906.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new class47(var13.field508, var13.field498, var13.field499);
                  var14.method1159(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1160(class226.field2863);
                  class111.method2177(var14);
               }
            }

            this.field3906 = var11;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIZZI)V",
      garbageValue = "2056577355"
   )
   public void method5554(int var1, int var2, boolean var3, boolean var4) {
      this.method5417(var1, var2, var4);
      if(this.field3897 == -1) {
         this.field3897 = var1;
      }

      if(this.field3898 == -1) {
         this.field3898 = var2;
      }

      int var5 = var1 - this.field3897;
      int var6 = var2 - this.field3898;
      this.field3897 = var1;
      this.field3898 = var2;
      if(var3 && !this.method5420()) {
         this.field3909 -= (int)((float)var5 / this.field3886);
         this.field3882 += (int)((float)var6 / this.field3886);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-593120199"
   )
   void method5417(int var1, int var2, boolean var3) {
      if(class44.method687()) {
         if(this.field3877 != null) {
            int var4 = (int)((float)this.field3909 + ((float)(var1 - this.field3889) - (float)this.method5446() * this.field3885 / 2.0F) / this.field3885);
            int var5 = (int)((float)this.field3882 - ((float)(var2 - this.field3890) - (float)this.method5449() * this.field3885 / 2.0F) / this.field3885);
            this.field3864 = this.field3877.method327(var4 + this.field3877.method323() * 64, var5 + this.field3877.method325() * 64);
            if(this.field3864 != null && var3 && KeyFocusListener.field618[82] && KeyFocusListener.field618[81] && var3) {
               int var6 = this.field3864.worldX;
               int var7 = this.field3864.worldY;
               int var8 = this.field3864.plane;
               PacketNode var9 = Actor.method1628(ClientPacket.field2386, Client.field952.field1478);
               var9.packetBuffer.putShort(var7);
               var9.packetBuffer.method3340(var6);
               var9.packetBuffer.putByte(var8);
               Client.field952.method1951(var9);
            }
         } else {
            this.field3864 = null;
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-16"
   )
   void method5418() {
      if(this.field3885 < this.field3886) {
         this.field3885 = Math.min(this.field3886, this.field3885 + this.field3885 / 30.0F);
      }

      if(this.field3885 > this.field3886) {
         this.field3885 = Math.max(this.field3886, this.field3885 - this.field3885 / 30.0F);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-393598143"
   )
   void method5419() {
      if(this.method5420()) {
         int var1 = this.field3883 - this.field3909;
         int var2 = this.field3884 - this.field3882;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3909 += var1;
         this.field3882 += var2;
         if(this.field3909 == this.field3883 && this.field3882 == this.field3884) {
            this.field3883 = -1;
            this.field3884 = -1;
         }

      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-158764232"
   )
   boolean method5420() {
      return this.field3883 != -1 && this.field3884 != -1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)Lap;",
      garbageValue = "307054098"
   )
   public WorldMapData method5421(int var1, int var2, int var3) {
      Iterator var4 = this.field3875.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method344(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-1770083577"
   )
   public void method5496(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5421(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3908;
      }

      boolean var6 = false;
      if(var5 != this.field3878 || var4) {
         this.field3878 = var5;
         this.method5571(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5439(var1, var2, var3);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1183899243"
   )
   public void method5423(int var1) {
      WorldMapData var2 = this.method5438(var1);
      if(var2 != null) {
         this.method5571(var2);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1971787805"
   )
   public int method5424() {
      return this.field3877 == null?-1:this.field3877.method392();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Lap;",
      garbageValue = "-1255509232"
   )
   public WorldMapData method5425() {
      return this.field3877;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lap;I)V",
      garbageValue = "878400821"
   )
   void method5571(WorldMapData var1) {
      if(this.field3877 == null || var1 != this.field3877) {
         this.method5427(var1);
         this.method5439(-1, -1, -1);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lap;I)V",
      garbageValue = "-15218812"
   )
   void method5427(WorldMapData var1) {
      this.field3877 = var1;
      this.field3879 = new class41(this.field3871, this.field3895);
      this.field3880.method5398(this.field3877.method319());
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lap;Lhq;Lhq;ZB)V",
      garbageValue = "36"
   )
   public void method5428(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.field3877 == null || var1 != this.field3877) {
            this.method5427(var1);
         }

         if(!var4 && this.field3877.method344(var2.plane, var2.worldX, var2.worldY)) {
            this.method5439(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5439(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-136152202"
   )
   void method5439(int var1, int var2, int var3) {
      if(this.field3877 != null) {
         int[] var4 = this.field3877.method314(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3877.method314(this.field3877.method317(), this.field3877.method328(), this.field3877.method329());
         }

         this.field3909 = var4[0] - this.field3877.method323() * 64;
         this.field3882 = var4[1] - this.field3877.method325() * 64;
         this.field3883 = -1;
         this.field3884 = -1;
         this.field3885 = this.method5434(this.field3877.method322());
         this.field3886 = this.field3885;
         this.field3905 = null;
         this.field3907 = null;
         this.field3879.method600();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "389433290"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.method5151(var1, var2, var3, var4, -16777216);
      int var7 = this.field3880.method5399();
      if(var7 < 100) {
         this.method5433(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3879.method607()) {
            this.field3879.method604(this.field3873, this.field3877.method319(), Client.isMembers);
            if(!this.field3879.method607()) {
               return;
            }
         }

         if(this.field3868 != null) {
            ++this.field3896;
            if(this.field3896 % this.field3901 == 0) {
               this.field3896 = 0;
               ++this.field3869;
            }

            if(this.field3869 >= this.field3891 && !this.field3893) {
               this.field3868 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3885));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3885));
         this.field3879.method602(this.field3909 - var8 / 2, this.field3882 - var9 / 2, var8 / 2 + this.field3909, var9 / 2 + this.field3882, var1, var2, var3 + var1, var2 + var4);
         if(!this.field3903) {
            boolean var10 = false;
            if(var5 - this.field3904 > 100) {
               this.field3904 = var5;
               var10 = true;
            }

            this.field3879.method598(this.field3909 - var8 / 2, this.field3882 - var9 / 2, var8 / 2 + this.field3909, var9 / 2 + this.field3882, var1, var2, var3 + var1, var2 + var4, this.field3902, this.field3868, this.field3896, this.field3901, var10);
         }

         if(class44.method687() && this.field3864 != null) {
            this.field3872.method4931("Coord: " + this.field3864, Rasterizer2D.draw_region_x + 10, Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
         }

         this.field3887 = var8;
         this.field3888 = var9;
         this.field3889 = var1;
         this.field3890 = var2;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "14"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3880.method5400()) {
         if(!this.field3879.method607()) {
            this.field3879.method604(this.field3873, this.field3877.method319(), Client.isMembers);
            if(!this.field3879.method607()) {
               return;
            }
         }

         this.field3879.method644(var1, var2, var3, var4, this.field3868, this.field3896, this.field3901);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1976235506"
   )
   public void method5432(int var1) {
      this.field3886 = this.method5434(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "0"
   )
   void method5433(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.method5151(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.method5151(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3872.method4934("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IB)F",
      garbageValue = "2"
   )
   float method5434(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2072388056"
   )
   public int method5447() {
      return 1.0D == (double)this.field3886?25:(1.5D == (double)this.field3886?37:(2.0D == (double)this.field3886?50:(3.0D == (double)this.field3886?75:((double)this.field3886 == 4.0D?100:200))));
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2130101751"
   )
   public void method5516() {
      this.field3880.method5409();
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-989662272"
   )
   public boolean method5437() {
      return this.field3880.method5400();
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II)Lap;",
      garbageValue = "185603095"
   )
   public WorldMapData method5438(int var1) {
      Iterator var2 = this.field3875.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method392() != var1);

      return var3;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "414861777"
   )
   public void method5526(int var1, int var2) {
      if(this.field3877 != null && this.field3877.method313(var1, var2)) {
         this.field3883 = var1 - this.field3877.method323() * 64;
         this.field3884 = var2 - this.field3877.method325() * 64;
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1569094532"
   )
   public void method5440(int var1, int var2) {
      if(this.field3877 != null) {
         this.field3909 = var1 - this.field3877.method323() * 64;
         this.field3882 = var2 - this.field3877.method325() * 64;
         this.field3883 = -1;
         this.field3884 = -1;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "861003069"
   )
   public void method5441(int var1, int var2, int var3) {
      if(this.field3877 != null) {
         int[] var4 = this.field3877.method314(var1, var2, var3);
         if(var4 != null) {
            this.method5526(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1711620925"
   )
   public void method5442(int var1, int var2, int var3) {
      if(this.field3877 != null) {
         int[] var4 = this.field3877.method314(var1, var2, var3);
         if(var4 != null) {
            this.method5440(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "33"
   )
   public int method5503() {
      return this.field3877 == null?-1:this.field3909 + this.field3877.method323() * 64;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1948584773"
   )
   public int method5444() {
      return this.field3877 == null?-1:this.field3882 + this.field3877.method325() * 64;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)Lhq;",
      garbageValue = "-1811592314"
   )
   public Coordinates method5558() {
      return this.field3877 == null?null:this.field3877.method327(this.method5503(), this.method5444());
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "82"
   )
   public int method5446() {
      return this.field3887;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1285871590"
   )
   public int method5449() {
      return this.field3888;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2092899837"
   )
   public void method5549(int var1) {
      if(var1 >= 1) {
         this.field3891 = var1;
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "181361906"
   )
   public void method5592() {
      this.field3891 = 3;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-124081187"
   )
   public void method5450(int var1) {
      if(var1 >= 1) {
         this.field3901 = var1;
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1484824426"
   )
   public void method5555() {
      this.field3901 = 50;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1225425209"
   )
   public void method5452(boolean var1) {
      this.field3893 = var1;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1205120704"
   )
   public void method5453(int var1) {
      this.field3868 = new HashSet();
      this.field3868.add(Integer.valueOf(var1));
      this.field3869 = 0;
      this.field3896 = 0;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2145742078"
   )
   public void method5471(int var1) {
      this.field3868 = new HashSet();
      this.field3869 = 0;
      this.field3896 = 0;

      for(int var2 = 0; var2 < Area.field3358.length; ++var2) {
         if(Area.field3358[var2] != null && Area.field3358[var2].field3369 == var1) {
            this.field3868.add(Integer.valueOf(Area.field3358[var2].field3352));
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "36641848"
   )
   public void method5455() {
      this.field3868 = null;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "255"
   )
   public void method5533(boolean var1) {
      this.field3903 = !var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "262025028"
   )
   public void method5504(int var1, boolean var2) {
      if(!var2) {
         this.field3881.add(Integer.valueOf(var1));
      } else {
         this.field3881.remove(Integer.valueOf(var1));
      }

      this.method5416();
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "4"
   )
   public void method5458(int var1, boolean var2) {
      if(!var2) {
         this.field3900.add(Integer.valueOf(var1));
      } else {
         this.field3900.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.field3358.length; ++var3) {
         if(Area.field3358[var3] != null && Area.field3358[var3].field3369 == var1) {
            int var4 = Area.field3358[var3].field3352;
            if(!var2) {
               this.field3894.add(Integer.valueOf(var4));
            } else {
               this.field3894.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5416();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1719971434"
   )
   public boolean method5459() {
      return !this.field3903;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-551109468"
   )
   public boolean method5460(int var1) {
      return !this.field3881.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "4"
   )
   public boolean method5461(int var1) {
      return !this.field3900.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-11"
   )
   void method5416() {
      this.field3902.clear();
      this.field3902.addAll(this.field3881);
      this.field3902.addAll(this.field3894);
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "127"
   )
   public void method5414(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3880.method5400()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3885));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3885));
         List var9 = this.field3879.method601(this.field3909 - var7 / 2 - 1, this.field3882 - var8 / 2 - 1, var7 / 2 + this.field3909 + 1, var8 / 2 + this.field3882 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               Area var12 = Area.field3358[var11.field508];
               var13 = false;

               for(int var14 = this.field3874.length - 1; var14 >= 0; --var14) {
                  if(var12.field3359[var14] != null) {
                     class60.addMenuEntry(var12.field3359[var14], var12.field3363, this.field3874[var14], var11.field508, var11.field498.method4093(), var11.field499.method4093());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(ILhq;I)Lhq;",
      garbageValue = "-1080387728"
   )
   public Coordinates method5517(int var1, Coordinates var2) {
      if(!this.field3880.method5400()) {
         return null;
      } else if(!this.field3879.method607()) {
         return null;
      } else if(!this.field3877.method313(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.field3879.method608();
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
                     return var5.field499;
                  }

                  var8 = (class39)var7.next();
                  int var9 = var8.field499.worldX - var2.worldX;
                  int var10 = var8.field499.worldY - var2.worldY;
                  var11 = var9 * var9 + var10 * var10;
                  if(var11 == 0) {
                     return var8.field499;
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
      signature = "(IILhq;Lhq;S)V",
      garbageValue = "27791"
   )
   public void method5464(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1159(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1160(class226.field2870);
         break;
      case 1009:
         var5.method1160(class226.field2862);
         break;
      case 1010:
         var5.method1160(class226.field2865);
         break;
      case 1011:
         var5.method1160(class226.field2861);
         break;
      case 1012:
         var5.method1160(class226.field2867);
      }

      class111.method2177(var5);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(I)Lay;",
      garbageValue = "350389744"
   )
   public class39 method5465() {
      if(!this.field3880.method5400()) {
         return null;
      } else if(!this.field3879.method607()) {
         return null;
      } else {
         HashMap var1 = this.field3879.method608();
         this.field3905 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3905.addAll(var3);
         }

         this.field3907 = this.field3905.iterator();
         return this.method5466();
      }
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(B)Lay;",
      garbageValue = "81"
   )
   public class39 method5466() {
      return this.field3907 == null?null:(!this.field3907.hasNext()?null:(class39)this.field3907.next());
   }
}
