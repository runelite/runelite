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

@ObfuscatedName("kw")
@Implements("RenderOverview")
public class RenderOverview {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   static final class268 field3894;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   static final class268 field3878;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   static final class268 field3869;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   IndexDataBase field3896;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   Font field3874;
   @ObfuscatedName("o")
   HashMap field3871;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Lks;"
   )
   IndexedSprite[] field3872;
   @ObfuscatedName("q")
   HashMap field3873;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lam;"
   )
   WorldMapData field3881;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lam;"
   )
   WorldMapData field3863;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lam;"
   )
   WorldMapData field3876;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   class41 field3877;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   class296 field3891;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1665862293
   )
   int field3867;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -268928687
   )
   int field3880;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -352480285
   )
   int field3900;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1699286233
   )
   int field3882;
   @ObfuscatedName("e")
   float field3906;
   @ObfuscatedName("v")
   float field3884;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2125071141
   )
   int field3885;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1652476995
   )
   int field3886;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1616206279
   )
   int field3887;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1258522507
   )
   int field3897;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 153511829
   )
   int field3889;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -997319583
   )
   int field3870;
   @ObfuscatedName("an")
   boolean field3879;
   @ObfuscatedName("am")
   HashSet field3892;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1491368057
   )
   int field3898;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1258925969
   )
   int field3890;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 760146393
   )
   int field3895;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1265671251
   )
   int field3868;
   @ObfuscatedName("as")
   HashSet field3902;
   @ObfuscatedName("ah")
   HashSet field3862;
   @ObfuscatedName("aw")
   HashSet field3899;
   @ObfuscatedName("al")
   HashSet field3883;
   @ObfuscatedName("aj")
   boolean field3875;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -295560493
   )
   int field3866;
   @ObfuscatedName("af")
   final int[] field3903;
   @ObfuscatedName("ay")
   List field3904;
   @ObfuscatedName("ab")
   Iterator field3905;
   @ObfuscatedName("ax")
   HashSet field3888;
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   Coordinates field3907;

   static {
      field3894 = class268.field3671;
      field3878 = class268.field3669;
      field3869 = class268.field3673;
   }

   public RenderOverview() {
      this.field3900 = -1;
      this.field3882 = -1;
      this.field3885 = -1;
      this.field3886 = -1;
      this.field3887 = -1;
      this.field3897 = -1;
      this.field3889 = 3;
      this.field3870 = 50;
      this.field3879 = false;
      this.field3892 = null;
      this.field3898 = -1;
      this.field3890 = -1;
      this.field3895 = -1;
      this.field3868 = -1;
      this.field3902 = new HashSet();
      this.field3862 = new HashSet();
      this.field3899 = new HashSet();
      this.field3883 = new HashSet();
      this.field3875 = false;
      this.field3866 = 0;
      this.field3903 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3888 = new HashSet();
      this.field3907 = null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lij;Ljn;Ljava/util/HashMap;[Lks;I)V",
      garbageValue = "274742328"
   )
   public void method5238(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field3872 = var4;
      this.field3896 = var1;
      this.field3874 = var2;
      this.field3871 = new HashMap();
      this.field3871.put(class24.field335, var3.get(field3894));
      this.field3871.put(class24.field329, var3.get(field3878));
      this.field3871.put(class24.field330, var3.get(field3869));
      this.field3891 = new class296(var1);
      int var5 = this.field3896.getFile(class40.field507.field504);
      int[] var6 = this.field3896.getChilds(var5);
      this.field3873 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3896.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3873.put(var9.method258(), var9);
         if(var9.method257()) {
            this.field3881 = var9;
         }
      }

      this.method5250(this.field3881);
      this.field3876 = null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1859778759"
   )
   public int method5239() {
      return this.field3896.method4127(this.field3881.method258(), class40.field502.field504)?100:this.field3896.method4128(this.field3881.method258());
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIZIIIIB)V",
      garbageValue = "43"
   )
   public void method5240(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3891.method5226()) {
         this.method5387();
         this.method5243();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3906));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3906));
            List var10 = this.field3877.method526(this.field3867 - var8 / 2 - 1, this.field3880 - var9 / 2 - 1, var8 / 2 + this.field3867 + 1, var9 / 2 + this.field3880 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            ScriptEvent var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); BaseVarType.method11(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new class47(var13.field498, var13.field491, var13.field492);
               var14.method1032(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3888.contains(var13)) {
                  var14.method1033(class226.field2855);
               } else {
                  var14.method1033(class226.field2857);
               }
            }

            var12 = this.field3888.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new class47(var13.field498, var13.field491, var13.field492);
                  var14.method1032(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1033(class226.field2858);
                  BaseVarType.method11(var14);
               }
            }

            this.field3888 = var11;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIZZI)V",
      garbageValue = "199587606"
   )
   public void method5241(int var1, int var2, boolean var3, boolean var4) {
      this.method5242(var1, var2, var4);
      if(this.field3895 == -1) {
         this.field3895 = var1;
      }

      if(this.field3868 == -1) {
         this.field3868 = var2;
      }

      int var5 = var1 - this.field3895;
      int var6 = var2 - this.field3868;
      this.field3895 = var1;
      this.field3868 = var2;
      if(var3 && !this.method5244()) {
         this.field3867 -= (int)((float)var5 / this.field3884);
         this.field3880 += (int)((float)var6 / this.field3884);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "27"
   )
   void method5242(int var1, int var2, boolean var3) {
      boolean var4 = Client.rights >= 2;
      if(var4) {
         if(this.field3863 != null) {
            int var5 = (int)((float)this.field3867 + ((float)(var1 - this.field3887) - (float)this.method5270() * this.field3906 / 2.0F) / this.field3906);
            int var6 = (int)((float)this.field3880 - ((float)(var2 - this.field3897) - (float)this.method5330() * this.field3906 / 2.0F) / this.field3906);
            this.field3907 = this.field3863.method254(var5 + this.field3863.method255() * 64, var6 + this.field3863.method264() * 64);
            if(this.field3907 != null && var3 && KeyFocusListener.field578[82] && KeyFocusListener.field578[81] && var3) {
               class12.method72(this.field3907.worldX, this.field3907.worldY, this.field3907.plane);
            }
         } else {
            this.field3907 = null;
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-988871578"
   )
   void method5387() {
      if(this.field3906 < this.field3884) {
         this.field3906 = Math.min(this.field3884, this.field3906 / 30.0F + this.field3906);
      }

      if(this.field3906 > this.field3884) {
         this.field3906 = Math.max(this.field3884, this.field3906 - this.field3906 / 30.0F);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-15206"
   )
   void method5243() {
      if(this.method5244()) {
         int var1 = this.field3900 - this.field3867;
         int var2 = this.field3882 - this.field3880;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3867 += var1;
         this.field3880 += var2;
         if(this.field3867 == this.field3900 && this.field3882 == this.field3880) {
            this.field3900 = -1;
            this.field3882 = -1;
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "36"
   )
   boolean method5244() {
      return this.field3900 != -1 && this.field3882 != -1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)Lam;",
      garbageValue = "553232564"
   )
   public WorldMapData method5245(int var1, int var2, int var3) {
      Iterator var4 = this.field3873.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method274(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-2064742059"
   )
   public void method5246(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5245(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3881;
      }

      boolean var6 = false;
      if(var5 != this.field3876 || var4) {
         this.field3876 = var5;
         this.method5250(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5292(var1, var2, var3);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "127"
   )
   public void method5276(int var1) {
      WorldMapData var2 = this.method5262(var1);
      if(var2 != null) {
         this.method5250(var2);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-2"
   )
   public int method5248() {
      return this.field3863 == null?-1:this.field3863.method256();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Lam;",
      garbageValue = "610515041"
   )
   public WorldMapData method5249() {
      return this.field3863;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lam;B)V",
      garbageValue = "-67"
   )
   void method5250(WorldMapData var1) {
      if(this.field3863 == null || var1 != this.field3863) {
         this.method5247(var1);
         this.method5292(-1, -1, -1);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lam;I)V",
      garbageValue = "-142001075"
   )
   void method5247(WorldMapData var1) {
      this.field3863 = var1;
      this.field3877 = new class41(this.field3872, this.field3871);
      this.field3891.method5224(this.field3863.method258());
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lam;Lhk;Lhk;ZB)V",
      garbageValue = "122"
   )
   public void method5252(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.field3863 == null || var1 != this.field3863) {
            this.method5247(var1);
         }

         if(!var4 && this.field3863.method274(var2.plane, var2.worldX, var2.worldY)) {
            this.method5292(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5292(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1675265443"
   )
   void method5292(int var1, int var2, int var3) {
      if(this.field3863 != null) {
         int[] var4 = this.field3863.method253(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3863.method253(this.field3863.method267(), this.field3863.method277(), this.field3863.method268());
         }

         this.field3867 = var4[0] - this.field3863.method255() * 64;
         this.field3880 = var4[1] - this.field3863.method264() * 64;
         this.field3900 = -1;
         this.field3882 = -1;
         this.field3906 = this.method5350(this.field3863.method263());
         this.field3884 = this.field3906;
         this.field3904 = null;
         this.field3905 = null;
         this.field3877.method534();
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "-44"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.method4981(var1, var2, var3, var4, -16777216);
      int var7 = this.field3891.method5230();
      if(var7 < 100) {
         this.method5257(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3877.method528()) {
            this.field3877.method520(this.field3896, this.field3863.method258(), Client.isMembers);
            if(!this.field3877.method528()) {
               return;
            }
         }

         if(this.field3892 != null) {
            ++this.field3890;
            if(this.field3890 % this.field3870 == 0) {
               this.field3890 = 0;
               ++this.field3898;
            }

            if(this.field3898 >= this.field3889 && !this.field3879) {
               this.field3892 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3906));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3906));
         this.field3877.method543(this.field3867 - var8 / 2, this.field3880 - var9 / 2, var8 / 2 + this.field3867, var9 / 2 + this.field3880, var1, var2, var3 + var1, var2 + var4);
         boolean var10;
         if(!this.field3875) {
            var10 = false;
            if(var5 - this.field3866 > 100) {
               this.field3866 = var5;
               var10 = true;
            }

            this.field3877.method524(this.field3867 - var8 / 2, this.field3880 - var9 / 2, var8 / 2 + this.field3867, var9 / 2 + this.field3880, var1, var2, var3 + var1, var2 + var4, this.field3883, this.field3892, this.field3890, this.field3870, var10);
         }

         var10 = Client.rights >= 2;
         if(var10 && this.field3907 != null) {
            this.field3874.method4770("Coord: " + this.field3907, Rasterizer2D.draw_region_x + 10, Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
         }

         this.field3885 = var8;
         this.field3886 = var9;
         this.field3887 = var1;
         this.field3897 = var2;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-126"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3891.method5226()) {
         if(!this.field3877.method528()) {
            this.field3877.method520(this.field3896, this.field3863.method258(), Client.isMembers);
            if(!this.field3877.method528()) {
               return;
            }
         }

         this.field3877.method525(var1, var2, var3, var4, this.field3892, this.field3890, this.field3870);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1588350991"
   )
   public void method5256(int var1) {
      this.field3884 = this.method5350(var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1117828912"
   )
   void method5257(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.method4981(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.method4981(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3874.method4773("Loading...", var7, var6 + var8, -1, -1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)F",
      garbageValue = "-67"
   )
   float method5350(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-387880056"
   )
   public int method5280() {
      return 1.0D == (double)this.field3884?25:(1.5D == (double)this.field3884?37:((double)this.field3884 == 2.0D?50:((double)this.field3884 == 3.0D?75:((double)this.field3884 == 4.0D?100:200))));
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "1883"
   )
   public void method5260() {
      this.field3891.method5235();
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "6309"
   )
   public boolean method5419() {
      return this.field3891.method5226();
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)Lam;",
      garbageValue = "805686017"
   )
   public WorldMapData method5262(int var1) {
      Iterator var2 = this.field3873.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method256() != var1);

      return var3;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "16"
   )
   public void method5263(int var1, int var2) {
      if(this.field3863 != null && this.field3863.method252(var1, var2)) {
         this.field3900 = var1 - this.field3863.method255() * 64;
         this.field3882 = var2 - this.field3863.method264() * 64;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "12531"
   )
   public void method5264(int var1, int var2) {
      if(this.field3863 != null) {
         this.field3867 = var1 - this.field3863.method255() * 64;
         this.field3880 = var2 - this.field3863.method264() * 64;
         this.field3900 = -1;
         this.field3882 = -1;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-75"
   )
   public void method5395(int var1, int var2, int var3) {
      if(this.field3863 != null) {
         int[] var4 = this.field3863.method253(var1, var2, var3);
         if(var4 != null) {
            this.method5263(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-123"
   )
   public void method5266(int var1, int var2, int var3) {
      if(this.field3863 != null) {
         int[] var4 = this.field3863.method253(var1, var2, var3);
         if(var4 != null) {
            this.method5264(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1857213305"
   )
   public int method5415() {
      return this.field3863 == null?-1:this.field3867 + this.field3863.method255() * 64;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1457563797"
   )
   public int method5268() {
      return this.field3863 == null?-1:this.field3880 + this.field3863.method264() * 64;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)Lhk;",
      garbageValue = "-203637488"
   )
   public Coordinates method5269() {
      return this.field3863 == null?null:this.field3863.method254(this.method5415(), this.method5268());
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-759002382"
   )
   public int method5270() {
      return this.field3885;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "59"
   )
   public int method5330() {
      return this.field3886;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-516117867"
   )
   public void method5272(int var1) {
      if(var1 >= 1) {
         this.field3889 = var1;
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "68"
   )
   public void method5417() {
      this.field3889 = 3;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "43"
   )
   public void method5255(int var1) {
      if(var1 >= 1) {
         this.field3870 = var1;
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2065618598"
   )
   public void method5275() {
      this.field3870 = 50;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1894276181"
   )
   public void method5327(boolean var1) {
      this.field3879 = var1;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-21359"
   )
   public void method5317(int var1) {
      this.field3892 = new HashSet();
      this.field3892.add(Integer.valueOf(var1));
      this.field3898 = 0;
      this.field3890 = 0;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "968466606"
   )
   public void method5278(int var1) {
      this.field3892 = new HashSet();
      this.field3898 = 0;
      this.field3890 = 0;

      for(int var2 = 0; var2 < Area.field3345.length; ++var2) {
         if(Area.field3345[var2] != null && Area.field3345[var2].field3365 == var1) {
            this.field3892.add(Integer.valueOf(Area.field3345[var2].field3348));
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-853213511"
   )
   public void method5326() {
      this.field3892 = null;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1366330848"
   )
   public void method5237(boolean var1) {
      this.field3875 = !var1;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-220435151"
   )
   public void method5281(int var1, boolean var2) {
      if(!var2) {
         this.field3902.add(Integer.valueOf(var1));
      } else {
         this.field3902.remove(Integer.valueOf(var1));
      }

      this.method5286();
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "-76"
   )
   public void method5331(int var1, boolean var2) {
      if(!var2) {
         this.field3862.add(Integer.valueOf(var1));
      } else {
         this.field3862.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.field3345.length; ++var3) {
         if(Area.field3345[var3] != null && Area.field3345[var3].field3365 == var1) {
            int var4 = Area.field3345[var3].field3348;
            if(!var2) {
               this.field3899.add(Integer.valueOf(var4));
            } else {
               this.field3899.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5286();
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-96"
   )
   public boolean method5396() {
      return !this.field3875;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1229651991"
   )
   public boolean method5284(int var1) {
      return !this.field3902.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "204900279"
   )
   public boolean method5370(int var1) {
      return !this.field3862.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "10143"
   )
   void method5286() {
      this.field3883.clear();
      this.field3883.addAll(this.field3902);
      this.field3883.addAll(this.field3899);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1111078599"
   )
   public void method5287(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3891.method5226()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3906));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3906));
         List var9 = this.field3877.method526(this.field3867 - var7 / 2 - 1, this.field3880 - var8 / 2 - 1, var7 / 2 + this.field3867 + 1, var8 / 2 + this.field3880 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               Area var12 = Area.field3345[var11.field498];
               var13 = false;

               for(int var14 = this.field3903.length - 1; var14 >= 0; --var14) {
                  if(var12.field3349[var14] != null) {
                     WorldMapData.addMenuEntry(var12.field3349[var14], var12.field3353, this.field3903[var14], var11.field498, var11.field491.method3966(), var11.field492.method3966());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(ILhk;I)Lhk;",
      garbageValue = "1821789646"
   )
   public Coordinates method5373(int var1, Coordinates var2) {
      if(!this.field3891.method5226()) {
         return null;
      } else if(!this.field3877.method528()) {
         return null;
      } else if(!this.field3863.method252(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.field3877.method529();
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
                     return var5.field492;
                  }

                  var8 = (class39)var7.next();
                  int var9 = var8.field492.worldX - var2.worldX;
                  int var10 = var8.field492.worldY - var2.worldY;
                  var11 = var9 * var9 + var10 * var10;
                  if(var11 == 0) {
                     return var8.field492;
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
      signature = "(IILhk;Lhk;I)V",
      garbageValue = "1137340844"
   )
   public void method5289(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1032(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1033(class226.field2852);
         break;
      case 1009:
         var5.method1033(class226.field2853);
         break;
      case 1010:
         var5.method1033(class226.field2854);
         break;
      case 1011:
         var5.method1033(class226.field2859);
         break;
      case 1012:
         var5.method1033(class226.field2856);
      }

      BaseVarType.method11(var5);
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(B)Law;",
      garbageValue = "-125"
   )
   public class39 method5332() {
      if(!this.field3891.method5226()) {
         return null;
      } else if(!this.field3877.method528()) {
         return null;
      } else {
         HashMap var1 = this.field3877.method529();
         this.field3904 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3904.addAll(var3);
         }

         this.field3905 = this.field3904.iterator();
         return this.method5383();
      }
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)Law;",
      garbageValue = "1492850834"
   )
   public class39 method5383() {
      return this.field3905 == null?null:(!this.field3905.hasNext()?null:(class39)this.field3905.next());
   }
}
