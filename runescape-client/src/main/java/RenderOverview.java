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

@ObfuscatedName("kr")
@Implements("RenderOverview")
public class RenderOverview {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   static final class262 field3834;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   static final class262 field3815;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   static final class262 field3816;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   IndexedSprite[] field3819;
   @ObfuscatedName("ag")
   boolean field3836;
   @ObfuscatedName("ac")
   HashSet field3840;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -895176275
   )
   int field3822;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1690119847
   )
   int field3832;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -427691741
   )
   int field3837;
   @ObfuscatedName("az")
   HashSet field3842;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -389207983
   )
   int field3844;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -633935555
   )
   int field3835;
   @ObfuscatedName("ay")
   boolean field3846;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   IndexDataBase field3813;
   @ObfuscatedName("y")
   HashMap field3820;
   @ObfuscatedName("aj")
   HashSet field3845;
   @ObfuscatedName("ad")
   HashSet field3843;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   class288 field3825;
   @ObfuscatedName("an")
   Iterator field3827;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -422098895
   )
   int field3828;
   @ObfuscatedName("g")
   float field3849;
   @ObfuscatedName("f")
   float field3829;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lam;"
   )
   WorldMapData field3818;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lam;"
   )
   WorldMapData field3821;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1027416961
   )
   int field3833;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2083511185
   )
   int field3810;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1444937065
   )
   int field3811;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -629330763
   )
   int field3826;
   @ObfuscatedName("l")
   HashMap field3831;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -152654661
   )
   int field3838;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lam;"
   )
   WorldMapData field3823;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   Font field3817;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   class41 field3824;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1793042403
   )
   int field3839;
   @ObfuscatedName("aa")
   HashSet field3830;
   @ObfuscatedName("ah")
   List field3850;
   @ObfuscatedName("aw")
   final int[] field3848;
   @ObfuscatedName("af")
   HashSet field3851;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1157210837
   )
   int field3847;

   static {
      field3834 = class262.field3619;
      field3815 = class262.field3620;
      field3816 = class262.field3621;
   }

   public RenderOverview() {
      this.field3828 = -1;
      this.field3810 = -1;
      this.field3832 = -1;
      this.field3822 = -1;
      this.field3837 = 3;
      this.field3835 = 50;
      this.field3836 = false;
      this.field3843 = null;
      this.field3838 = -1;
      this.field3839 = -1;
      this.field3844 = -1;
      this.field3833 = -1;
      this.field3842 = new HashSet();
      this.field3840 = new HashSet();
      this.field3830 = new HashSet();
      this.field3845 = new HashSet();
      this.field3846 = false;
      this.field3847 = 0;
      this.field3848 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3851 = new HashSet();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIS)Lam;",
      garbageValue = "1103"
   )
   public WorldMapData method5162(int var1, int var2, int var3) {
      Iterator var4 = this.field3820.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method308(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1944996628"
   )
   boolean method5211() {
      return this.field3828 != -1 && this.field3810 != -1;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)F",
      garbageValue = "-2007956993"
   )
   float method5177(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IB)Lam;",
      garbageValue = "16"
   )
   public WorldMapData method5184(int var1) {
      Iterator var2 = this.field3820.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method313() != var1);

      return var3;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lam;I)V",
      garbageValue = "1697003313"
   )
   void method5170(WorldMapData var1) {
      this.field3818 = var1;
      this.field3824 = new class41(this.field3819, this.field3831);
      this.field3825.method5143(this.field3818.method340());
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-233842285"
   )
   public int method5243() {
      return this.field3818 == null?-1:this.field3826 + this.field3818.method360() * 64;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lam;I)V",
      garbageValue = "1794937127"
   )
   void method5169(WorldMapData var1) {
      if(this.field3818 == null || var1 != this.field3818) {
         this.method5170(var1);
         this.method5236(-1, -1, -1);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-552388022"
   )
   void method5161() {
      if(this.field3829 < this.field3849) {
         this.field3829 = Math.min(this.field3849, this.field3829 / 30.0F + this.field3829);
      }

      if(this.field3829 > this.field3849) {
         this.field3829 = Math.max(this.field3849, this.field3829 - this.field3829 / 30.0F);
      }

   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1051796411"
   )
   void method5338() {
      this.field3845.clear();
      this.field3845.addAll(this.field3842);
      this.field3845.addAll(this.field3830);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1037724226"
   )
   void method5236(int var1, int var2, int var3) {
      if(this.field3818 != null) {
         int[] var4 = this.field3818.method310(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3818.method310(this.field3818.method324(), this.field3818.method374(), this.field3818.method325());
         }

         this.field3826 = var4[0] - this.field3818.method360() * 64;
         this.field3811 = var4[1] - this.field3818.method373() * 64;
         this.field3828 = -1;
         this.field3810 = -1;
         this.field3829 = this.method5177(this.field3818.method318());
         this.field3849 = this.field3829;
         this.field3850 = null;
         this.field3827 = null;
         this.field3824.method579();
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-527770085"
   )
   public int method5212() {
      return this.field3818 == null?-1:this.field3811 + this.field3818.method373() * 64;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-59"
   )
   void method5269() {
      if(this.method5211()) {
         int var1 = this.field3828 - this.field3826;
         int var2 = this.field3810 - this.field3811;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3826 += var1;
         this.field3811 += var2;
         if(this.field3826 == this.field3828 && this.field3811 == this.field3810) {
            this.field3828 = -1;
            this.field3810 = -1;
         }

      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1806267566"
   )
   public void method5182(int var1, int var2) {
      if(this.field3818 != null && this.field3818.method309(var1, var2)) {
         this.field3828 = var1 - this.field3818.method360() * 64;
         this.field3810 = var2 - this.field3818.method373() * 64;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "101986739"
   )
   public void method5183(int var1, int var2) {
      if(this.field3818 != null) {
         this.field3826 = var1 - this.field3818.method360() * 64;
         this.field3811 = var2 - this.field3818.method373() * 64;
         this.field3828 = -1;
         this.field3810 = -1;
      }
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(B)Lay;",
      garbageValue = "7"
   )
   public class39 method5257() {
      return this.field3827 == null?null:(!this.field3827.hasNext()?null:(class39)this.field3827.next());
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "432351765"
   )
   void method5176(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.method4890(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.method4890(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3817.method4755("Loading...", var7, var6 + var8, -1, -1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1832673221"
   )
   public int method5158() {
      return this.field3813.method4155(this.field3821.method340(), class40.field558.field556)?100:this.field3813.method4158(this.field3821.method340());
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-739126080"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.method4890(var1, var2, var3, var4, -16777216);
      int var7 = this.field3825.method5147();
      if(var7 < 100) {
         this.method5176(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3824.method604()) {
            this.field3824.method578(this.field3813, this.field3818.method340(), Client.isMembers);
            if(!this.field3824.method604()) {
               return;
            }
         }

         if(this.field3843 != null) {
            ++this.field3839;
            if(this.field3839 % this.field3835 == 0) {
               this.field3839 = 0;
               ++this.field3838;
            }

            if(this.field3838 >= this.field3837 && !this.field3836) {
               this.field3843 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3829));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3829));
         this.field3824.method606(this.field3826 - var8 / 2, this.field3811 - var9 / 2, var8 / 2 + this.field3826, var9 / 2 + this.field3811, var1, var2, var3 + var1, var2 + var4);
         if(!this.field3846) {
            boolean var10 = false;
            if(var5 - this.field3847 > 100) {
               this.field3847 = var5;
               var10 = true;
            }

            this.field3824.method580(this.field3826 - var8 / 2, this.field3811 - var9 / 2, var8 / 2 + this.field3826, var9 / 2 + this.field3811, var1, var2, var3 + var1, var2 + var4, this.field3845, this.field3843, this.field3839, this.field3835, var10);
         }

         this.field3832 = var8;
         this.field3822 = var9;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lii;Ljm;Ljava/util/HashMap;[Ljx;I)V",
      garbageValue = "-1197836580"
   )
   public void method5157(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field3819 = var4;
      this.field3813 = var1;
      this.field3817 = var2;
      this.field3831 = new HashMap();
      this.field3831.put(class24.field370, var3.get(field3834));
      this.field3831.put(class24.field369, var3.get(field3815));
      this.field3831.put(class24.field373, var3.get(field3816));
      this.field3825 = new class288(var1);
      int var5 = this.field3813.getFile(class40.field560.field556);
      int[] var6 = this.field3813.getChilds(var5);
      this.field3820 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3813.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3820.put(var9.method340(), var9);
         if(var9.method314()) {
            this.field3821 = var9;
         }
      }

      this.method5169(this.field3821);
      this.field3823 = null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2034877606"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3825.method5146()) {
         if(!this.field3824.method604()) {
            this.field3824.method578(this.field3813, this.field3818.method340(), Client.isMembers);
            if(!this.field3824.method604()) {
               return;
            }
         }

         this.field3824.method582(var1, var2, var3, var4, this.field3843, this.field3839, this.field3835);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-1913092483"
   )
   public void method5175(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5162(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3821;
      }

      boolean var6 = false;
      if(var5 != this.field3823 || var4) {
         this.field3823 = var5;
         this.method5169(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5236(var1, var2, var3);
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "50"
   )
   public void method5174() {
      this.field3825.method5145();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIZIIIIB)V",
      garbageValue = "1"
   )
   public void method5159(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3825.method5146()) {
         this.method5161();
         this.method5269();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3829));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3829));
            List var10 = this.field3824.method583(this.field3826 - var8 / 2 - 1, this.field3811 - var9 / 2 - 1, var8 / 2 + this.field3826 + 1, var9 / 2 + this.field3811 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            ScriptEvent var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); class153.method3002(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new class47(var13.field543, var13.field542, var13.field552);
               var14.method1123(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3851.contains(var13)) {
                  var14.method1132(class220.field2797);
               } else {
                  var14.method1132(class220.field2801);
               }
            }

            var12 = this.field3851.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new class47(var13.field543, var13.field542, var13.field552);
                  var14.method1123(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1132(class220.field2803);
                  class153.method3002(var14);
               }
            }

            this.field3851 = var11;
         }
      }
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1964975635"
   )
   public void method5216(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3825.method5146()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3829));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3829));
         List var9 = this.field3824.method583(this.field3826 - var7 / 2 - 1, this.field3811 - var8 / 2 - 1, var7 / 2 + this.field3826 + 1, var8 / 2 + this.field3811 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               Area var12 = Area.field3294[var11.field543];
               var13 = false;

               for(int var14 = this.field3848.length - 1; var14 >= 0; --var14) {
                  if(var12.field3302[var14] != null) {
                     class36.addMenuEntry(var12.field3302[var14], var12.field3303, this.field3848[var14], var11.field543, var11.field542.method3970(), var11.field552.method3970());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-551556973"
   )
   public void method5166(int var1) {
      WorldMapData var2 = this.method5184(var1);
      if(var2 != null) {
         this.method5169(var2);
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1480026670"
   )
   public int method5178() {
      return (double)this.field3849 == 1.0D?25:((double)this.field3849 == 1.5D?37:((double)this.field3849 == 2.0D?50:(3.0D == (double)this.field3849?75:((double)this.field3849 == 4.0D?100:200))));
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "743718620"
   )
   public void method5192(int var1) {
      this.field3849 = this.method5177(var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-561763493"
   )
   public void method5160(int var1, int var2, boolean var3) {
      if(this.field3844 == -1) {
         this.field3844 = var1;
      }

      if(this.field3833 == -1) {
         this.field3833 = var2;
      }

      int var4 = var1 - this.field3844;
      int var5 = var2 - this.field3833;
      this.field3844 = var1;
      this.field3833 = var2;
      if(var3 && !this.method5211()) {
         this.field3826 -= (int)((float)var4 / this.field3849);
         this.field3811 += (int)((float)var5 / this.field3849);
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2051082234"
   )
   public boolean method5291() {
      return this.field3825.method5146();
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)Lhs;",
      garbageValue = "799487573"
   )
   public Coordinates method5164() {
      return this.field3818 == null?null:this.field3818.method311(this.method5243(), this.method5212());
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-29"
   )
   public void method5179(int var1, int var2, int var3) {
      if(this.field3818 != null) {
         int[] var4 = this.field3818.method310(var1, var2, var3);
         if(var4 != null) {
            this.method5182(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1890348413"
   )
   public void method5307(int var1, int var2, int var3) {
      if(this.field3818 != null) {
         int[] var4 = this.field3818.method310(var1, var2, var3);
         if(var4 != null) {
            this.method5183(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-308256858"
   )
   public int method5281() {
      return this.field3818 == null?-1:this.field3818.method313();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Lam;",
      garbageValue = "99"
   )
   public WorldMapData method5168() {
      return this.field3818;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1352441762"
   )
   public void method5297() {
      this.field3837 = 3;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "495264556"
   )
   public void method5194() {
      this.field3835 = 50;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-582773372"
   )
   public int method5189() {
      return this.field3832;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1320227914"
   )
   public void method5191(int var1) {
      if(var1 >= 1) {
         this.field3837 = var1;
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "15"
   )
   public void method5193(int var1) {
      if(var1 >= 1) {
         this.field3835 = var1;
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "46"
   )
   public void method5198() {
      this.field3843 = null;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1299039208"
   )
   public void method5250(int var1) {
      this.field3843 = new HashSet();
      this.field3843.add(Integer.valueOf(var1));
      this.field3838 = 0;
      this.field3839 = 0;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "27"
   )
   public void method5195(boolean var1) {
      this.field3836 = var1;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-91"
   )
   public void method5303(int var1) {
      this.field3843 = new HashSet();
      this.field3838 = 0;
      this.field3839 = 0;

      for(int var2 = 0; var2 < Area.field3294.length; ++var2) {
         if(Area.field3294[var2] != null && Area.field3294[var2].field3313 == var1) {
            this.field3843.add(Integer.valueOf(Area.field3294[var2].field3296));
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-470996439"
   )
   public void method5199(boolean var1) {
      this.field3846 = !var1;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1530112394"
   )
   public int method5190() {
      return this.field3822;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I)Lay;",
      garbageValue = "-1354351044"
   )
   public class39 method5209() {
      if(!this.field3825.method5146()) {
         return null;
      } else if(!this.field3824.method604()) {
         return null;
      } else {
         HashMap var1 = this.field3824.method586();
         this.field3850 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3850.addAll(var3);
         }

         this.field3827 = this.field3850.iterator();
         return this.method5257();
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-460"
   )
   public boolean method5202() {
      return !this.field3846;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "0"
   )
   public void method5322(int var1, boolean var2) {
      if(!var2) {
         this.field3842.add(Integer.valueOf(var1));
      } else {
         this.field3842.remove(Integer.valueOf(var1));
      }

      this.method5338();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-989280092"
   )
   public void method5201(int var1, boolean var2) {
      if(!var2) {
         this.field3840.add(Integer.valueOf(var1));
      } else {
         this.field3840.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.field3294.length; ++var3) {
         if(Area.field3294[var3] != null && Area.field3294[var3].field3313 == var1) {
            int var4 = Area.field3294[var3].field3296;
            if(!var2) {
               this.field3830.add(Integer.valueOf(var4));
            } else {
               this.field3830.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5338();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lam;Lhs;Lhs;ZB)V",
      garbageValue = "-39"
   )
   public void method5187(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.field3818 == null || var1 != this.field3818) {
            this.method5170(var1);
         }

         if(!var4 && this.field3818.method308(var2.plane, var2.worldX, var2.worldY)) {
            this.method5236(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5236(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "4891"
   )
   public boolean method5203(int var1) {
      return !this.field3842.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1127323453"
   )
   public boolean method5204(int var1) {
      return !this.field3840.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(ILhs;I)Lhs;",
      garbageValue = "869232975"
   )
   public Coordinates method5207(int var1, Coordinates var2) {
      if(!this.field3825.method5146()) {
         return null;
      } else if(!this.field3824.method604()) {
         return null;
      } else if(!this.field3818.method309(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.field3824.method586();
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
                     return var5.field552;
                  }

                  var8 = (class39)var7.next();
                  int var9 = var8.field552.worldX - var2.worldX;
                  int var10 = var8.field552.worldY - var2.worldY;
                  var11 = var9 * var9 + var10 * var10;
                  if(var11 == 0) {
                     return var8.field552;
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

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(IILhs;Lhs;I)V",
      garbageValue = "943155436"
   )
   public void method5180(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1123(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1132(class220.field2796);
         break;
      case 1009:
         var5.method1132(class220.field2799);
         break;
      case 1010:
         var5.method1132(class220.field2798);
         break;
      case 1011:
         var5.method1132(class220.field2809);
         break;
      case 1012:
         var5.method1132(class220.field2800);
      }

      class153.method3002(var5);
   }
}
