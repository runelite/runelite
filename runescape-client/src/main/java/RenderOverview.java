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

@ObfuscatedName("ko")
@Implements("RenderOverview")
public class RenderOverview {
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1331476067
   )
   int field3806;
   @ObfuscatedName("r")
   class287 field3807;
   @ObfuscatedName("g")
   WorldMapData field3808;
   @ObfuscatedName("j")
   IndexDataBase field3809;
   @ObfuscatedName("i")
   static final class261 field3810;
   @ObfuscatedName("f")
   static final class261 field3811;
   @ObfuscatedName("c")
   static final class261 field3812;
   @ObfuscatedName("q")
   HashMap field3813;
   @ObfuscatedName("n")
   ModIcon[] field3815;
   @ObfuscatedName("a")
   HashMap field3816;
   @ObfuscatedName("az")
   HashSet field3817;
   @ObfuscatedName("v")
   WorldMapData field3818;
   @ObfuscatedName("s")
   WorldMapData field3819;
   @ObfuscatedName("k")
   class41 field3820;
   @ObfuscatedName("y")
   float field3821;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 106364477
   )
   int field3822;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 671015489
   )
   int field3823;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 268778931
   )
   int field3825;
   @ObfuscatedName("b")
   float field3826;
   @ObfuscatedName("ac")
   HashSet field3827;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1209964407
   )
   int field3828;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 684786863
   )
   int field3829;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1998616825
   )
   int field3830;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1188099129
   )
   int field3831;
   @ObfuscatedName("ae")
   boolean field3832;
   @ObfuscatedName("ap")
   HashSet field3833;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 2064026383
   )
   int field3834;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1463415737
   )
   int field3835;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1295969917
   )
   int field3837;
   @ObfuscatedName("ar")
   HashSet field3838;
   @ObfuscatedName("ao")
   HashSet field3839;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1647547927
   )
   int field3840;
   @ObfuscatedName("aa")
   HashSet field3841;
   @ObfuscatedName("ay")
   boolean field3842;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1075383775
   )
   int field3843;
   @ObfuscatedName("aq")
   final int[] field3844;
   @ObfuscatedName("as")
   List field3845;
   @ObfuscatedName("an")
   Iterator field3846;
   @ObfuscatedName("o")
   Font field3847;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "1595693946"
   )
   public void method5046(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3807.method5034()) {
         this.method5048();
         this.method5049();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3826));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3826));
            List var10 = this.field3820.method561(this.field3822 - var8 / 2 - 1, this.field3840 - var9 / 2 - 1, this.field3822 + var8 / 2 + 1, this.field3840 + var9 / 2 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            class69 var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); class77.method1440(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new class69();
               var15 = new class47(var13.field541, var13.field545, var13.field538);
               var14.method1041(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3817.contains(var13)) {
                  var14.method1036(class219.field2806);
               } else {
                  var14.method1036(class219.field2803);
               }
            }

            var12 = this.field3817.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new class69();
                  var15 = new class47(var13.field541, var13.field545, var13.field538);
                  var14.method1041(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1036(class219.field2802);
                  class77.method1440(var14);
               }
            }

            this.field3817 = var11;
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-1329382974"
   )
   public void method5047(int var1, int var2, boolean var3) {
      if(this.field3823 == -1) {
         this.field3823 = var1;
      }

      if(this.field3806 == -1) {
         this.field3806 = var2;
      }

      int var4 = var1 - this.field3823;
      int var5 = var2 - this.field3806;
      this.field3823 = var1;
      this.field3806 = var2;
      if(var3 && !this.method5132()) {
         this.field3822 -= (int)((float)var4 / this.field3821);
         this.field3840 += (int)((float)var5 / this.field3821);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-89"
   )
   void method5048() {
      if(this.field3826 < this.field3821) {
         this.field3826 = Math.min(this.field3821, this.field3826 / 30.0F + this.field3826);
      }

      if(this.field3826 > this.field3821) {
         this.field3826 = Math.max(this.field3821, this.field3826 - this.field3826 / 30.0F);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method5049() {
      if(this.method5132()) {
         int var1 = this.field3837 - this.field3822;
         int var2 = this.field3825 - this.field3840;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3822 += var1;
         this.field3840 += var2;
         if(this.field3837 == this.field3822 && this.field3840 == this.field3825) {
            this.field3837 = -1;
            this.field3825 = -1;
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)LWorldMapData;",
      garbageValue = "843144926"
   )
   public WorldMapData method5051(int var1, int var2, int var3) {
      Iterator var4 = this.field3816.values().iterator();

      while(var4.hasNext()) {
         WorldMapData var5 = (WorldMapData)var4.next();
         if(var5.method282(var1, var2, var3)) {
            return var5;
         }
      }

      return null;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(I)Lclass39;",
      garbageValue = "2106361501"
   )
   public class39 method5052() {
      return this.field3846 == null?null:(!this.field3846.hasNext()?null:(class39)this.field3846.next());
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1206269430"
   )
   public void method5053(int var1) {
      WorldMapData var2 = this.method5151(var1);
      if(var2 != null) {
         this.method5199(var2);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)LWorldMapData;",
      garbageValue = "52"
   )
   public WorldMapData method5055() {
      return this.field3818;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;B)V",
      garbageValue = "0"
   )
   void method5057(WorldMapData var1) {
      this.field3818 = var1;
      this.field3820 = new class41(this.field3815, this.field3813);
      this.field3807.method5032(this.field3818.method315());
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "92"
   )
   void method5059(int var1, int var2, int var3) {
      if(this.field3818 != null) {
         int[] var4 = this.field3818.method346(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3818.method346(this.field3818.method298(), this.field3818.method297(), this.field3818.method286());
         }

         this.field3822 = var4[0] - this.field3818.method293() * 64;
         this.field3840 = var4[1] - this.field3818.method305() * 64;
         this.field3837 = -1;
         this.field3825 = -1;
         this.field3826 = this.method5064(this.field3818.method314());
         this.field3821 = this.field3826;
         this.field3845 = null;
         this.field3846 = null;
         this.field3820.method527();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-495889689"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.method4884(var6);
      Rasterizer2D.method4833(var1, var2, var1 + var3, var2 + var4);
      Rasterizer2D.method4826(var1, var2, var3, var4, -16777216);
      int var7 = this.field3807.method5035();
      if(var7 < 100) {
         this.method5063(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3820.method552()) {
            this.field3820.method526(this.field3809, this.field3818.method315(), Client.isMembers);
            if(!this.field3820.method552()) {
               return;
            }
         }

         if(this.field3833 != null) {
            ++this.field3835;
            if(this.field3835 % this.field3831 == 0) {
               this.field3835 = 0;
               ++this.field3834;
            }

            if(this.field3834 >= this.field3830 && !this.field3832) {
               this.field3833 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3826));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3826));
         this.field3820.method528(this.field3822 - var8 / 2, this.field3840 - var9 / 2, var8 / 2 + this.field3822, var9 / 2 + this.field3840, var1, var2, var1 + var3, var4 + var2);
         if(!this.field3842) {
            boolean var10 = false;
            if(var5 - this.field3843 > 100) {
               this.field3843 = var5;
               var10 = true;
            }

            this.field3820.method529(this.field3822 - var8 / 2, this.field3840 - var9 / 2, var8 / 2 + this.field3822, this.field3840 + var9 / 2, var1, var2, var3 + var1, var2 + var4, this.field3841, this.field3833, this.field3835, this.field3831, var10);
         }

         this.field3828 = var8;
         this.field3829 = var9;
         Rasterizer2D.method4821(var6);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "33"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3807.method5034()) {
         if(!this.field3820.method552()) {
            this.field3820.method526(this.field3809, this.field3818.method315(), Client.isMembers);
            if(!this.field3820.method552()) {
               return;
            }
         }

         this.field3820.method531(var1, var2, var3, var4, this.field3833, this.field3835, this.field3831);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-106"
   )
   public void method5062(int var1) {
      this.field3821 = this.method5064(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-2088005419"
   )
   void method5063(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.method4826(var1, var2, var3, var4, -16777216);
      Rasterizer2D.method4888(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.method4826(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3847.method4635("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)F",
      garbageValue = "2018781034"
   )
   float method5064(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1498091569"
   )
   public int method5065() {
      return 1.0D == (double)this.field3821?25:(1.5D == (double)this.field3821?37:((double)this.field3821 == 2.0D?50:((double)this.field3821 == 3.0D?75:(4.0D == (double)this.field3821?100:200))));
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1124503806"
   )
   public void method5066() {
      this.field3807.method5033();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "7"
   )
   public boolean method5067() {
      return this.field3807.method5034();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LFont;Ljava/util/HashMap;[LModIcon;B)V",
      garbageValue = "83"
   )
   public void method5068(IndexDataBase var1, Font var2, HashMap var3, ModIcon[] var4) {
      this.field3815 = var4;
      this.field3809 = var1;
      this.field3847 = var2;
      this.field3813 = new HashMap();
      this.field3813.put(class24.field381, var3.get(field3810));
      this.field3813.put(class24.field373, var3.get(field3811));
      this.field3813.put(class24.field374, var3.get(field3812));
      this.field3807 = new class287(var1);
      int var5 = this.field3809.method4055(class40.field556.field548);
      int[] var6 = this.field3809.method4005(var5);
      this.field3816 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3809.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3816.put(var9.method315(), var9);
         if(var9.method288()) {
            this.field3808 = var9;
         }
      }

      this.method5199(this.field3808);
      this.field3819 = null;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "28"
   )
   public void method5069(int var1, int var2) {
      if(this.field3818 != null && this.field3818.method283(var1, var2)) {
         this.field3837 = var1 - this.field3818.method293() * 64;
         this.field3825 = var2 - this.field3818.method305() * 64;
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "270489799"
   )
   public void method5072(int var1, int var2, int var3) {
      if(this.field3818 != null) {
         int[] var4 = this.field3818.method346(var1, var2, var3);
         if(var4 != null) {
            this.method5213(var4[0], var4[1]);
         }
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1275687232"
   )
   public int method5073() {
      return this.field3818 == null?-1:this.field3822 + this.field3818.method293() * 64;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "250120873"
   )
   public int method5074() {
      return this.field3818 == null?-1:this.field3840 + this.field3818.method305() * 64;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)LCoordinates;",
      garbageValue = "-1896630379"
   )
   public Coordinates method5075() {
      return this.field3818 == null?null:this.field3818.method317(this.method5073(), this.method5074());
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1246581557"
   )
   public int method5076() {
      return this.field3818 == null?-1:this.field3818.method287();
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2131398642"
   )
   public void method5078(int var1) {
      if(var1 >= 1) {
         this.field3830 = var1;
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-921154331"
   )
   public void method5080() {
      this.field3830 = 3;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1674627433"
   )
   public void method5081() {
      this.field3831 = 50;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1401115620"
   )
   public void method5082(boolean var1) {
      this.field3832 = var1;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1907103557"
   )
   public void method5083(int var1) {
      this.field3833 = new HashSet();
      this.field3833.add(Integer.valueOf(var1));
      this.field3834 = 0;
      this.field3835 = 0;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1338810898"
   )
   public void method5084(int var1) {
      this.field3833 = new HashSet();
      this.field3834 = 0;
      this.field3835 = 0;

      for(int var2 = 0; var2 < Area.field3304.length; ++var2) {
         if(Area.field3304[var2] != null && var1 == Area.field3304[var2].field3306) {
            this.field3833.add(Integer.valueOf(Area.field3304[var2].field3301));
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "58"
   )
   public void method5085() {
      this.field3833 = null;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-51"
   )
   public void method5086(boolean var1) {
      this.field3842 = !var1;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1177155756"
   )
   public void method5087(int var1, boolean var2) {
      if(!var2) {
         this.field3838.add(Integer.valueOf(var1));
      } else {
         this.field3838.remove(Integer.valueOf(var1));
      }

      this.method5092();
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-190237049"
   )
   public void method5088(int var1, boolean var2) {
      if(!var2) {
         this.field3839.add(Integer.valueOf(var1));
      } else {
         this.field3839.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.field3304.length; ++var3) {
         if(Area.field3304[var3] != null && Area.field3304[var3].field3306 == var1) {
            int var4 = Area.field3304[var3].field3301;
            if(!var2) {
               this.field3827.add(Integer.valueOf(var4));
            } else {
               this.field3827.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5092();
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "53"
   )
   public boolean method5089() {
      return !this.field3842;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "7735"
   )
   public boolean method5091(int var1) {
      return !this.field3839.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1185056889"
   )
   void method5092() {
      this.field3841.clear();
      this.field3841.addAll(this.field3838);
      this.field3841.addAll(this.field3827);
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-113"
   )
   public void method5093(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3807.method5034()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3826));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3826));
         List var9 = this.field3820.method561(this.field3822 - var7 / 2 - 1, this.field3840 - var8 / 2 - 1, this.field3822 + var7 / 2 + 1, var8 / 2 + this.field3840 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var11;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var12 = (class39)var10.next();
               Area var13 = Area.field3304[var12.field541];
               var11 = false;

               for(int var14 = this.field3844.length - 1; var14 >= 0; --var14) {
                  if(var13.field3307[var14] != null) {
                     class44.addMenuEntry(var13.field3307[var14], var13.field3308, this.field3844[var14], var12.field541, var12.field545.method3825(), var12.field538.method3825());
                     var11 = true;
                  }
               }
            } while(!var11);
         }
      }

   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(ILCoordinates;I)LCoordinates;",
      garbageValue = "2059319611"
   )
   public Coordinates method5094(int var1, Coordinates var2) {
      if(!this.field3807.method5034()) {
         return null;
      } else if(!this.field3820.method552()) {
         return null;
      } else if(!this.field3818.method283(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.field3820.method535();
         List var4 = (List)var3.get(Integer.valueOf(var1));
         if(var4 != null && !var4.isEmpty()) {
            class39 var5 = null;
            int var6 = -1;
            Iterator var7 = var4.iterator();

            while(var7.hasNext()) {
               class39 var8 = (class39)var7.next();
               int var10 = var8.field538.worldX - var2.worldX;
               int var11 = var8.field538.worldY - var2.worldY;
               int var9 = var10 * var10 + var11 * var11;
               if(var9 == 0) {
                  return var8.field538;
               }

               if(var9 < var6 || var5 == null) {
                  var5 = var8;
                  var6 = var9;
               }
            }

            return var5.field538;
         } else {
            return null;
         }
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-39"
   )
   public int method5107() {
      return this.field3828;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1577068640"
   )
   public boolean method5113(int var1) {
      return !this.field3838.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I)Lclass39;",
      garbageValue = "1171292790"
   )
   public class39 method5114() {
      if(!this.field3807.method5034()) {
         return null;
      } else if(!this.field3820.method552()) {
         return null;
      } else {
         HashMap var1 = this.field3820.method535();
         this.field3845 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3845.addAll(var3);
         }

         this.field3846 = this.field3845.iterator();
         return this.method5052();
      }
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IILCoordinates;LCoordinates;I)V",
      garbageValue = "-512007214"
   )
   public void method5130(int var1, int var2, Coordinates var3, Coordinates var4) {
      class69 var5 = new class69();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1041(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1036(class219.field2796);
         break;
      case 1009:
         var5.method1036(class219.field2797);
         break;
      case 1010:
         var5.method1036(class219.field2798);
         break;
      case 1011:
         var5.method1036(class219.field2799);
         break;
      case 1012:
         var5.method1036(class219.field2800);
      }

      class77.method1440(var5);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1708808554"
   )
   boolean method5132() {
      return this.field3837 != -1 && this.field3825 != -1;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1205677966"
   )
   public int method5144() {
      return this.field3829;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1699120622"
   )
   public void method5147(int var1) {
      if(var1 >= 1) {
         this.field3831 = var1;
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IB)LWorldMapData;",
      garbageValue = "9"
   )
   public WorldMapData method5151(int var1) {
      Iterator var2 = this.field3816.values().iterator();

      while(var2.hasNext()) {
         WorldMapData var3 = (WorldMapData)var2.next();
         if(var3.method287() == var1) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "557866503"
   )
   public void method5168(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5051(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3808;
      }

      boolean var6 = false;
      if(this.field3819 != var5 || var4) {
         this.field3819 = var5;
         this.method5199(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5059(var1, var2, var3);
      }

   }

   public RenderOverview() {
      this.field3837 = -1;
      this.field3825 = -1;
      this.field3828 = -1;
      this.field3829 = -1;
      this.field3830 = 3;
      this.field3831 = 50;
      this.field3832 = false;
      this.field3833 = null;
      this.field3834 = -1;
      this.field3835 = -1;
      this.field3823 = -1;
      this.field3806 = -1;
      this.field3838 = new HashSet();
      this.field3839 = new HashSet();
      this.field3827 = new HashSet();
      this.field3841 = new HashSet();
      this.field3842 = false;
      this.field3843 = 0;
      this.field3844 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3817 = new HashSet();
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1952490383"
   )
   public void method5182(int var1, int var2, int var3) {
      if(this.field3818 != null) {
         int[] var4 = this.field3818.method346(var1, var2, var3);
         if(var4 != null) {
            this.method5069(var4[0], var4[1]);
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;I)V",
      garbageValue = "-1682548477"
   )
   void method5199(WorldMapData var1) {
      if(this.field3818 == null || this.field3818 != var1) {
         this.method5057(var1);
         this.method5059(-1, -1, -1);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;LCoordinates;LCoordinates;ZI)V",
      garbageValue = "-1284019072"
   )
   public void method5207(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.field3818 == null || this.field3818 != var1) {
            this.method5057(var1);
         }

         if(!var4 && this.field3818.method282(var2.plane, var2.worldX, var2.worldY)) {
            this.method5059(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5059(var3.plane, var3.worldX, var3.worldY);
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "88"
   )
   public void method5213(int var1, int var2) {
      if(this.field3818 != null) {
         this.field3822 = var1 - this.field3818.method293() * 64;
         this.field3840 = var2 - this.field3818.method305() * 64;
         this.field3837 = -1;
         this.field3825 = -1;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-1911"
   )
   public int method5217() {
      return this.field3809.method4026(this.field3808.method315(), class40.field551.field548)?100:this.field3809.method4018(this.field3808.method315());
   }

   static {
      field3810 = class261.field3625;
      field3811 = class261.field3623;
      field3812 = class261.field3622;
   }
}
