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
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   static final class261 field3797;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   static final class261 field3795;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   static final class261 field3799;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Ljw;"
   )
   IndexedSprite[] field3802;
   @ObfuscatedName("ah")
   HashSet field3808;
   @ObfuscatedName("at")
   boolean field3826;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -224252313
   )
   int field3807;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1702862277
   )
   int field3816;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1332794031
   )
   int field3817;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -45881071
   )
   int field3823;
   @ObfuscatedName("ad")
   HashSet field3825;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -332057367
   )
   int field3800;
   @ObfuscatedName("az")
   boolean field3829;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   IndexDataBase field3815;
   @ObfuscatedName("av")
   HashSet field3828;
   @ObfuscatedName("ag")
   HashSet field3798;
   @ObfuscatedName("p")
   HashMap field3803;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   class287 field3792;
   @ObfuscatedName("aa")
   Iterator field3833;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 433154723
   )
   int field3811;
   @ObfuscatedName("z")
   float field3814;
   @ObfuscatedName("h")
   float field3796;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   WorldMapData field3805;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   WorldMapData field3804;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -538821503
   )
   int field3824;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 892657373
   )
   int field3818;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -337052381
   )
   int field3810;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1791045805
   )
   int field3791;
   @ObfuscatedName("s")
   HashMap field3801;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 345176945
   )
   int field3832;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   WorldMapData field3806;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   Font field3830;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lay;"
   )
   class41 field3822;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1278687009
   )
   int field3820;
   @ObfuscatedName("ao")
   HashSet field3827;
   @ObfuscatedName("af")
   List field3809;
   @ObfuscatedName("an")
   final int[] field3831;
   @ObfuscatedName("ak")
   HashSet field3834;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 2055400077
   )
   int field3812;

   static {
      field3797 = class261.field3602;
      field3795 = class261.field3609;
      field3799 = class261.field3604;
   }

   public RenderOverview() {
      this.field3811 = -1;
      this.field3818 = -1;
      this.field3807 = -1;
      this.field3816 = -1;
      this.field3817 = 3;
      this.field3800 = 50;
      this.field3826 = false;
      this.field3798 = null;
      this.field3832 = -1;
      this.field3820 = -1;
      this.field3823 = -1;
      this.field3824 = -1;
      this.field3825 = new HashSet();
      this.field3808 = new HashSet();
      this.field3827 = new HashSet();
      this.field3828 = new HashSet();
      this.field3829 = false;
      this.field3812 = 0;
      this.field3831 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3834 = new HashSet();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-159589647"
   )
   boolean method5256() {
      return this.field3811 != -1 && this.field3818 != -1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)Lae;",
      garbageValue = "-280619051"
   )
   public WorldMapData method5264(int var1, int var2, int var3) {
      Iterator var4 = this.field3803.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method278(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)F",
      garbageValue = "102"
   )
   float method5214(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IB)Lae;",
      garbageValue = "103"
   )
   public WorldMapData method5218(int var1) {
      Iterator var2 = this.field3803.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method275() != var1);

      return var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lae;I)V",
      garbageValue = "-1898044279"
   )
   void method5285(WorldMapData var1) {
      this.field3805 = var1;
      this.field3822 = new class41(this.field3802, this.field3801);
      this.field3792.method5184(this.field3805.method285());
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "30"
   )
   public int method5223() {
      return this.field3805 == null?-1:this.field3791 + this.field3805.method289() * 64;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lae;I)V",
      garbageValue = "1939815533"
   )
   void method5206(WorldMapData var1) {
      if(this.field3805 == null || var1 != this.field3805) {
         this.method5285(var1);
         this.method5209(-1, -1, -1);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   void method5257() {
      if(this.field3796 < this.field3814) {
         this.field3796 = Math.min(this.field3814, this.field3796 + this.field3796 / 30.0F);
      }

      if(this.field3796 > this.field3814) {
         this.field3796 = Math.max(this.field3814, this.field3796 - this.field3796 / 30.0F);
      }

   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-66"
   )
   void method5279() {
      this.field3828.clear();
      this.field3828.addAll(this.field3825);
      this.field3828.addAll(this.field3827);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "7506"
   )
   void method5209(int var1, int var2, int var3) {
      if(this.field3805 != null) {
         int[] var4 = this.field3805.method280(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3805.method280(this.field3805.method296(), this.field3805.method292(), this.field3805.method294());
         }

         this.field3791 = var4[0] - this.field3805.method289() * 64;
         this.field3810 = var4[1] - this.field3805.method319() * 64;
         this.field3811 = -1;
         this.field3818 = -1;
         this.field3796 = this.method5214(this.field3805.method288());
         this.field3814 = this.field3796;
         this.field3809 = null;
         this.field3833 = null;
         this.field3822.method561();
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-23"
   )
   public int method5347() {
      return this.field3805 == null?-1:this.field3810 + this.field3805.method319() * 64;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "559755129"
   )
   void method5199() {
      if(this.method5256()) {
         int var1 = this.field3811 - this.field3791;
         int var2 = this.field3818 - this.field3810;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3791 += var1;
         this.field3810 += var2;
         if(this.field3811 == this.field3791 && this.field3818 == this.field3810) {
            this.field3811 = -1;
            this.field3818 = -1;
         }

      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1859335221"
   )
   public void method5219(int var1, int var2) {
      if(this.field3805 != null && this.field3805.method279(var1, var2)) {
         this.field3811 = var1 - this.field3805.method289() * 64;
         this.field3818 = var2 - this.field3805.method319() * 64;
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "-16916"
   )
   public void method5220(int var1, int var2) {
      if(this.field3805 != null) {
         this.field3791 = var1 - this.field3805.method289() * 64;
         this.field3810 = var2 - this.field3805.method319() * 64;
         this.field3811 = -1;
         this.field3818 = -1;
      }
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I)Laz;",
      garbageValue = "236876418"
   )
   public class39 method5247() {
      return this.field3833 == null?null:(!this.field3833.hasNext()?null:(class39)this.field3833.next());
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "1"
   )
   void method5213(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var1 + var3 / 2;
      int var8 = var2 + var4 / 2 - 18 - var6;
      Rasterizer2D.method4937(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.method4937(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3830.method4742("Loading...", var7, var6 + var8, -1, -1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1590896118"
   )
   public int method5242() {
      return this.field3815.method4135(this.field3804.method285(), class40.field512.field510)?100:this.field3815.method4136(this.field3804.method285());
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lim;Ljt;Ljava/util/HashMap;[Ljw;I)V",
      garbageValue = "-1703519640"
   )
   public void method5194(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field3802 = var4;
      this.field3815 = var1;
      this.field3830 = var2;
      this.field3801 = new HashMap();
      this.field3801.put(class24.field338, var3.get(field3797));
      this.field3801.put(class24.field336, var3.get(field3795));
      this.field3801.put(class24.field337, var3.get(field3799));
      this.field3792 = new class287(var1);
      int var5 = this.field3815.getFile(class40.field515.field510);
      int[] var6 = this.field3815.getChilds(var5);
      this.field3803 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3815.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3803.put(var9.method285(), var9);
         if(var9.method353()) {
            this.field3804 = var9;
         }
      }

      this.method5206(this.field3804);
      this.field3806 = null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1384179787"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.method4937(var1, var2, var3, var4, -16777216);
      int var7 = this.field3792.method5190();
      if(var7 < 100) {
         this.method5213(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3822.method568()) {
            this.field3822.method575(this.field3815, this.field3805.method285(), Client.isMembers);
            if(!this.field3822.method568()) {
               return;
            }
         }

         if(this.field3798 != null) {
            ++this.field3820;
            if(this.field3820 % this.field3800 == 0) {
               this.field3820 = 0;
               ++this.field3832;
            }

            if(this.field3832 >= this.field3817 && !this.field3826) {
               this.field3798 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3796));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3796));
         this.field3822.method565(this.field3791 - var8 / 2, this.field3810 - var9 / 2, this.field3791 + var8 / 2, this.field3810 + var9 / 2, var1, var2, var3 + var1, var2 + var4);
         if(!this.field3829) {
            boolean var10 = false;
            if(var5 - this.field3812 > 100) {
               this.field3812 = var5;
               var10 = true;
            }

            this.field3822.method563(this.field3791 - var8 / 2, this.field3810 - var9 / 2, this.field3791 + var8 / 2, this.field3810 + var9 / 2, var1, var2, var3 + var1, var2 + var4, this.field3828, this.field3798, this.field3820, this.field3800, var10);
         }

         this.field3807 = var8;
         this.field3816 = var9;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1042175593"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3792.method5183()) {
         if(!this.field3822.method568()) {
            this.field3822.method575(this.field3815, this.field3805.method285(), Client.isMembers);
            if(!this.field3822.method568()) {
               return;
            }
         }

         this.field3822.method579(var1, var2, var3, var4, this.field3798, this.field3820, this.field3800);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "1795014041"
   )
   public void method5202(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5264(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3804;
      }

      boolean var6 = false;
      if(var5 != this.field3806 || var4) {
         this.field3806 = var5;
         this.method5206(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5209(var1, var2, var3);
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1959142458"
   )
   public void method5216() {
      this.field3792.method5182();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "-461481403"
   )
   public void method5196(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3792.method5183()) {
         this.method5257();
         this.method5199();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3796));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3796));
            List var10 = this.field3822.method566(this.field3791 - var8 / 2 - 1, this.field3810 - var9 / 2 - 1, this.field3791 + var8 / 2 + 1, this.field3810 + var9 / 2 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            ScriptEvent var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); Ignore.method1126(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new class47(var13.field505, var13.field500, var13.field504);
               var14.method1115(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3834.contains(var13)) {
                  var14.method1116(class219.field2773);
               } else {
                  var14.method1116(class219.field2771);
               }
            }

            var12 = this.field3834.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new class47(var13.field505, var13.field500, var13.field504);
                  var14.method1115(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1116(class219.field2778);
                  Ignore.method1126(var14);
               }
            }

            this.field3834 = var11;
         }
      }
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-2099572068"
   )
   public void method5259(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3792.method5183()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3796));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3796));
         List var9 = this.field3822.method566(this.field3791 - var7 / 2 - 1, this.field3810 - var8 / 2 - 1, this.field3791 + var7 / 2 + 1, this.field3810 + var8 / 2 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               Area var12 = Area.field3286[var11.field505];
               var13 = false;

               for(int var14 = this.field3831.length - 1; var14 >= 0; --var14) {
                  if(var12.field3284[var14] != null) {
                     class164.addMenuEntry(var12.field3284[var14], var12.field3285, this.field3831[var14], var11.field505, var11.field500.method3941(), var11.field504.method3941());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2010595004"
   )
   public void method5203(int var1) {
      WorldMapData var2 = this.method5218(var1);
      if(var2 != null) {
         this.method5206(var2);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1096071804"
   )
   public void method5212(int var1) {
      this.field3814 = this.method5214(var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1498901951"
   )
   public int method5215() {
      return (double)this.field3814 == 1.0D?25:(1.5D == (double)this.field3814?37:(2.0D == (double)this.field3814?50:(3.0D == (double)this.field3814?75:((double)this.field3814 == 4.0D?100:200))));
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-12462734"
   )
   public void method5197(int var1, int var2, boolean var3) {
      if(this.field3823 == -1) {
         this.field3823 = var1;
      }

      if(this.field3824 == -1) {
         this.field3824 = var2;
      }

      int var4 = var1 - this.field3823;
      int var5 = var2 - this.field3824;
      this.field3823 = var1;
      this.field3824 = var2;
      if(var3 && !this.method5256()) {
         this.field3791 -= (int)((float)var4 / this.field3814);
         this.field3810 += (int)((float)var5 / this.field3814);
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-159920295"
   )
   public boolean method5193() {
      return this.field3792.method5183();
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)Lhy;",
      garbageValue = "-122197303"
   )
   public Coordinates method5282() {
      return this.field3805 == null?null:this.field3805.method281(this.method5223(), this.method5347());
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1742117577"
   )
   public void method5221(int var1, int var2, int var3) {
      if(this.field3805 != null) {
         int[] var4 = this.field3805.method280(var1, var2, var3);
         if(var4 != null) {
            this.method5219(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1755510184"
   )
   public void method5222(int var1, int var2, int var3) {
      if(this.field3805 != null) {
         int[] var4 = this.field3805.method280(var1, var2, var3);
         if(var4 != null) {
            this.method5220(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method5204() {
      return this.field3805 == null?-1:this.field3805.method275();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Lae;",
      garbageValue = "1298922680"
   )
   public WorldMapData method5342() {
      return this.field3805;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1740392456"
   )
   public void method5335() {
      this.field3817 = 3;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1815334705"
   )
   public void method5280() {
      this.field3800 = 50;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1769072032"
   )
   public int method5226() {
      return this.field3807;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "2"
   )
   public void method5228(int var1) {
      if(var1 >= 1) {
         this.field3817 = var1;
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "246059693"
   )
   public void method5198(int var1) {
      if(var1 >= 1) {
         this.field3800 = var1;
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1433148911"
   )
   public void method5235() {
      this.field3798 = null;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1921582293"
   )
   public void method5370(int var1) {
      this.field3798 = new HashSet();
      this.field3798.add(Integer.valueOf(var1));
      this.field3832 = 0;
      this.field3820 = 0;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "660962656"
   )
   public void method5232(boolean var1) {
      this.field3826 = var1;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "29070"
   )
   public void method5234(int var1) {
      this.field3798 = new HashSet();
      this.field3832 = 0;
      this.field3820 = 0;

      for(int var2 = 0; var2 < Area.field3286.length; ++var2) {
         if(Area.field3286[var2] != null && Area.field3286[var2].field3295 == var1) {
            this.field3798.add(Integer.valueOf(Area.field3286[var2].field3278));
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-72"
   )
   public void method5241(boolean var1) {
      this.field3829 = !var1;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)Laz;",
      garbageValue = "-1244385022"
   )
   public class39 method5205() {
      if(!this.field3792.method5183()) {
         return null;
      } else if(!this.field3822.method568()) {
         return null;
      } else {
         HashMap var1 = this.field3822.method569();
         this.field3809 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3809.addAll(var3);
         }

         this.field3833 = this.field3809.iterator();
         return this.method5247();
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-748559916"
   )
   public int method5227() {
      return this.field3816;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "118"
   )
   public boolean method5239() {
      return !this.field3829;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1578636100"
   )
   public void method5237(int var1, boolean var2) {
      if(!var2) {
         this.field3825.add(Integer.valueOf(var1));
      } else {
         this.field3825.remove(Integer.valueOf(var1));
      }

      this.method5279();
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "31"
   )
   public void method5238(int var1, boolean var2) {
      if(!var2) {
         this.field3808.add(Integer.valueOf(var1));
      } else {
         this.field3808.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.field3286.length; ++var3) {
         if(Area.field3286[var3] != null && Area.field3286[var3].field3295 == var1) {
            int var4 = Area.field3286[var3].field3278;
            if(!var2) {
               this.field3827.add(Integer.valueOf(var4));
            } else {
               this.field3827.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5279();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lae;Lhy;Lhy;ZI)V",
      garbageValue = "1386404546"
   )
   public void method5253(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.field3805 == null || var1 != this.field3805) {
            this.method5285(var1);
         }

         if(!var4 && this.field3805.method278(var2.plane, var2.worldX, var2.worldY)) {
            this.method5209(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5209(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "82"
   )
   public boolean method5327(int var1) {
      return !this.field3825.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "665809222"
   )
   public boolean method5208(int var1) {
      return !this.field3808.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(ILhy;I)Lhy;",
      garbageValue = "-1995711763"
   )
   public Coordinates method5244(int var1, Coordinates var2) {
      if(!this.field3792.method5183()) {
         return null;
      } else if(!this.field3822.method568()) {
         return null;
      } else if(!this.field3805.method279(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.field3822.method569();
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
                     return var5.field504;
                  }

                  var8 = (class39)var7.next();
                  int var9 = var8.field504.worldX - var2.worldX;
                  int var10 = var8.field504.worldY - var2.worldY;
                  var11 = var9 * var9 + var10 * var10;
                  if(var11 == 0) {
                     return var8.field504;
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

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IILhy;Lhy;I)V",
      garbageValue = "-1104892284"
   )
   public void method5201(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1115(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1116(class219.field2770);
         break;
      case 1009:
         var5.method1116(class219.field2774);
         break;
      case 1010:
         var5.method1116(class219.field2775);
         break;
      case 1011:
         var5.method1116(class219.field2769);
         break;
      case 1012:
         var5.method1116(class219.field2768);
      }

      Ignore.method1126(var5);
   }
}
