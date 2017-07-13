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

@ObfuscatedName("ke")
@Implements("RenderOverview")
public class RenderOverview {
   @ObfuscatedName("s")
   static final class261 field3811;
   @ObfuscatedName("w")
   static final class261 field3812;
   @ObfuscatedName("p")
   static final class261 field3813;
   @ObfuscatedName("g")
   ModIcon[] field3816;
   @ObfuscatedName("ak")
   boolean field3835;
   @ObfuscatedName("ag")
   HashSet field3836;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1448245529
   )
   int field3823;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1213540575
   )
   int field3829;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -392960173
   )
   int field3831;
   @ObfuscatedName("aa")
   HashSet field3839;
   @ObfuscatedName("ad")
   boolean field3822;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1404167761
   )
   int field3832;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1914252793
   )
   int field3837;
   @ObfuscatedName("l")
   IndexDataBase field3810;
   @ObfuscatedName("k")
   HashMap field3817;
   @ObfuscatedName("ax")
   HashSet field3842;
   @ObfuscatedName("ap")
   HashSet field3834;
   @ObfuscatedName("f")
   class287 field3806;
   @ObfuscatedName("at")
   Iterator field3840;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1552931231
   )
   int field3825;
   @ObfuscatedName("q")
   float field3830;
   @ObfuscatedName("b")
   float field3827;
   @ObfuscatedName("c")
   WorldMapData field3819;
   @ObfuscatedName("t")
   WorldMapData field3818;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1513184685
   )
   int field3848;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1872065317
   )
   int field3826;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 737540005
   )
   int field3814;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1933123975
   )
   int field3824;
   @ObfuscatedName("u")
   HashMap field3815;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 612915763
   )
   int field3847;
   @ObfuscatedName("o")
   WorldMapData field3820;
   @ObfuscatedName("m")
   Font field3807;
   @ObfuscatedName("x")
   class41 field3838;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 381590571
   )
   int field3833;
   @ObfuscatedName("aj")
   HashSet field3821;
   @ObfuscatedName("ab")
   List field3846;
   @ObfuscatedName("av")
   final int[] field3845;
   @ObfuscatedName("al")
   HashSet field3841;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1699796109
   )
   int field3844;

   static {
      field3811 = class261.field3624;
      field3812 = class261.field3625;
      field3813 = class261.field3626;
   }

   public RenderOverview() {
      this.field3825 = -1;
      this.field3826 = -1;
      this.field3829 = -1;
      this.field3823 = -1;
      this.field3831 = 3;
      this.field3832 = 50;
      this.field3835 = false;
      this.field3834 = null;
      this.field3847 = -1;
      this.field3833 = -1;
      this.field3837 = -1;
      this.field3848 = -1;
      this.field3839 = new HashSet();
      this.field3836 = new HashSet();
      this.field3821 = new HashSet();
      this.field3842 = new HashSet();
      this.field3822 = false;
      this.field3844 = 0;
      this.field3845 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3841 = new HashSet();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1743258289"
   )
   boolean method5113() {
      return this.field3825 != -1 && this.field3826 != -1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIB)LWorldMapData;",
      garbageValue = "-7"
   )
   public WorldMapData method5114(int var1, int var2, int var3) {
      Iterator var4 = this.field3817.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method280(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)F",
      garbageValue = "3"
   )
   float method5112(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)LWorldMapData;",
      garbageValue = "1552841712"
   )
   public WorldMapData method5107(int var1) {
      Iterator var2 = this.field3817.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method296() != var1);

      return var3;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;I)V",
      garbageValue = "70324129"
   )
   void method5120(WorldMapData var1) {
      this.field3819 = var1;
      this.field3838 = new class41(this.field3816, this.field3815);
      this.field3806.method5101(this.field3819.method287());
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "3"
   )
   public int method5136() {
      return this.field3819 == null?-1:this.field3814 + this.field3819.method291() * 64;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;I)V",
      garbageValue = "869179672"
   )
   void method5119(WorldMapData var1) {
      if(this.field3819 == null || var1 != this.field3819) {
         this.method5120(var1);
         this.method5122(-1, -1, -1);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "46"
   )
   void method5239() {
      if(this.field3827 < this.field3830) {
         this.field3827 = Math.min(this.field3830, this.field3827 / 30.0F + this.field3827);
      }

      if(this.field3827 > this.field3830) {
         this.field3827 = Math.max(this.field3830, this.field3827 - this.field3827 / 30.0F);
      }

   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1335426674"
   )
   void method5154() {
      this.field3842.clear();
      this.field3842.addAll(this.field3839);
      this.field3842.addAll(this.field3821);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "35"
   )
   void method5122(int var1, int var2, int var3) {
      if(this.field3819 != null) {
         int[] var4 = this.field3819.method331(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3819.method331(this.field3819.method342(), this.field3819.method295(), this.field3819.method297());
         }

         this.field3814 = var4[0] - this.field3819.method291() * 64;
         this.field3824 = var4[1] - this.field3819.method292() * 64;
         this.field3825 = -1;
         this.field3826 = -1;
         this.field3827 = this.method5112(this.field3819.method282());
         this.field3830 = this.field3827;
         this.field3846 = null;
         this.field3840 = null;
         this.field3838.method570();
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "342478775"
   )
   public int method5137() {
      return this.field3819 == null?-1:this.field3824 + this.field3819.method292() * 64;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1357577448"
   )
   void method5247() {
      if(this.method5113()) {
         int var1 = this.field3825 - this.field3814;
         int var2 = this.field3826 - this.field3824;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3814 += var1;
         this.field3824 += var2;
         if(this.field3814 == this.field3825 && this.field3826 == this.field3824) {
            this.field3825 = -1;
            this.field3826 = -1;
         }

      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "750552066"
   )
   public void method5182(int var1, int var2) {
      if(this.field3819 != null && this.field3819.method281(var1, var2)) {
         this.field3825 = var1 - this.field3819.method291() * 64;
         this.field3826 = var2 - this.field3819.method292() * 64;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "517065154"
   )
   public void method5224(int var1, int var2) {
      if(this.field3819 != null) {
         this.field3814 = var1 - this.field3819.method291() * 64;
         this.field3824 = var2 - this.field3819.method292() * 64;
         this.field3825 = -1;
         this.field3826 = -1;
      }
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)Lclass39;",
      garbageValue = "-2100739728"
   )
   public class39 method5270() {
      return this.field3840 == null?null:(!this.field3840.hasNext()?null:(class39)this.field3840.next());
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-692555411"
   )
   void method5126(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var1 + var3 / 2;
      int var8 = var2 + var4 / 2 - 18 - var6;
      Rasterizer2D.method4921(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.method4921(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3807.method4734("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1859870223"
   )
   public int method5108() {
      return this.field3810.method4101(this.field3818.method287(), class40.field533.field532)?100:this.field3810.method4112(this.field3818.method287());
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LFont;Ljava/util/HashMap;[LModIcon;B)V",
      garbageValue = "59"
   )
   public void method5160(IndexDataBase var1, Font var2, HashMap var3, ModIcon[] var4) {
      this.field3816 = var4;
      this.field3810 = var1;
      this.field3807 = var2;
      this.field3815 = new HashMap();
      this.field3815.put(class24.field355, var3.get(field3811));
      this.field3815.put(class24.field358, var3.get(field3812));
      this.field3815.put(class24.field354, var3.get(field3813));
      this.field3806 = new class287(var1);
      int var5 = this.field3810.getFile(class40.field535.field532);
      int[] var6 = this.field3810.getChilds(var5);
      this.field3817 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3810.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3817.put(var9.method287(), var9);
         if(var9.method286()) {
            this.field3818 = var9;
         }
      }

      this.method5119(this.field3818);
      this.field3820 = null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1110276369"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.method4921(var1, var2, var3, var4, -16777216);
      int var7 = this.field3806.method5097();
      if(var7 < 100) {
         this.method5126(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3838.method562()) {
            this.field3838.method565(this.field3810, this.field3819.method287(), Client.isMembers);
            if(!this.field3838.method562()) {
               return;
            }
         }

         if(this.field3834 != null) {
            ++this.field3833;
            if(this.field3833 % this.field3832 == 0) {
               this.field3833 = 0;
               ++this.field3847;
            }

            if(this.field3847 >= this.field3831 && !this.field3835) {
               this.field3834 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3827));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3827));
         this.field3838.method556(this.field3814 - var8 / 2, this.field3824 - var9 / 2, this.field3814 + var8 / 2, this.field3824 + var9 / 2, var1, var2, var3 + var1, var2 + var4);
         if(!this.field3822) {
            boolean var10 = false;
            if(var5 - this.field3844 > 100) {
               this.field3844 = var5;
               var10 = true;
            }

            this.field3838.method581(this.field3814 - var8 / 2, this.field3824 - var9 / 2, this.field3814 + var8 / 2, this.field3824 + var9 / 2, var1, var2, var3 + var1, var2 + var4, this.field3842, this.field3834, this.field3833, this.field3832, var10);
         }

         this.field3829 = var8;
         this.field3823 = var9;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-110"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3806.method5103()) {
         if(!this.field3838.method562()) {
            this.field3838.method565(this.field3810, this.field3819.method287(), Client.isMembers);
            if(!this.field3838.method562()) {
               return;
            }
         }

         this.field3838.method591(var1, var2, var3, var4, this.field3834, this.field3833, this.field3832);
      }
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(IILCoordinates;LCoordinates;I)V",
      garbageValue = "1222087812"
   )
   public void method5257(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1092(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1098(class219.field2798);
         break;
      case 1009:
         var5.method1098(class219.field2802);
         break;
      case 1010:
         var5.method1098(class219.field2793);
         break;
      case 1011:
         var5.method1098(class219.field2794);
         break;
      case 1012:
         var5.method1098(class219.field2795);
      }

      class89.method1689(var5);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIZB)V",
      garbageValue = "74"
   )
   public void method5115(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5114(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3818;
      }

      boolean var6 = false;
      if(var5 != this.field3820 || var4) {
         this.field3820 = var5;
         this.method5119(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5122(var1, var2, var3);
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-85"
   )
   public void method5166() {
      this.field3806.method5096();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIZIIIIB)V",
      garbageValue = "-71"
   )
   public void method5184(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3806.method5103()) {
         this.method5239();
         this.method5247();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3827));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3827));
            List var10 = this.field3838.method563(this.field3814 - var8 / 2 - 1, this.field3824 - var9 / 2 - 1, this.field3814 + var8 / 2 + 1, this.field3824 + var9 / 2 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            ScriptEvent var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); class89.method1689(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new class47(var13.field523, var13.field522, var13.field516);
               var14.method1092(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3841.contains(var13)) {
                  var14.method1098(class219.field2805);
               } else {
                  var14.method1098(class219.field2796);
               }
            }

            var12 = this.field3841.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new class47(var13.field523, var13.field522, var13.field516);
                  var14.method1092(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1098(class219.field2797);
                  class89.method1689(var14);
               }
            }

            this.field3841 = var11;
         }
      }
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1927927369"
   )
   public void method5248(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3806.method5103()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3827));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3827));
         List var9 = this.field3838.method563(this.field3814 - var7 / 2 - 1, this.field3824 - var8 / 2 - 1, this.field3814 + var7 / 2 + 1, this.field3824 + var8 / 2 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               Area var12 = class54.field662[var11.field523];
               var13 = false;

               for(int var14 = this.field3845.length - 1; var14 >= 0; --var14) {
                  if(var12.field3296[var14] != null) {
                     class37.addMenuEntry(var12.field3296[var14], var12.field3295, this.field3845[var14], var11.field523, var11.field522.method3915(), var11.field516.method3915());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "17"
   )
   public void method5116(int var1) {
      WorldMapData var2 = this.method5107(var1);
      if(var2 != null) {
         this.method5119(var2);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-90"
   )
   public void method5125(int var1) {
      this.field3830 = this.method5112(var1);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-64"
   )
   public int method5128() {
      return 1.0D == (double)this.field3830?25:((double)this.field3830 == 1.5D?37:((double)this.field3830 == 2.0D?50:((double)this.field3830 == 3.0D?75:(4.0D == (double)this.field3830?100:200))));
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2127180444"
   )
   public boolean method5155() {
      return this.field3806.method5103();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)LCoordinates;",
      garbageValue = "1023427320"
   )
   public Coordinates method5138() {
      return this.field3819 == null?null:this.field3819.method283(this.method5136(), this.method5137());
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-76"
   )
   public void method5134(int var1, int var2, int var3) {
      if(this.field3819 != null) {
         int[] var4 = this.field3819.method331(var1, var2, var3);
         if(var4 != null) {
            this.method5182(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "1401769121"
   )
   public void method5271(int var1, int var2, boolean var3) {
      if(this.field3837 == -1) {
         this.field3837 = var1;
      }

      if(this.field3848 == -1) {
         this.field3848 = var2;
      }

      int var4 = var1 - this.field3837;
      int var5 = var2 - this.field3848;
      this.field3837 = var1;
      this.field3848 = var2;
      if(var3 && !this.method5113()) {
         this.field3814 -= (int)((float)var4 / this.field3830);
         this.field3824 += (int)((float)var5 / this.field3830);
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1730303419"
   )
   public void method5135(int var1, int var2, int var3) {
      if(this.field3819 != null) {
         int[] var4 = this.field3819.method331(var1, var2, var3);
         if(var4 != null) {
            this.method5224(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-11"
   )
   public int method5117() {
      return this.field3819 == null?-1:this.field3819.method296();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)LWorldMapData;",
      garbageValue = "641538834"
   )
   public WorldMapData method5250() {
      return this.field3819;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-54"
   )
   public void method5177() {
      this.field3831 = 3;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   public void method5243() {
      this.field3832 = 50;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "615242740"
   )
   public int method5181() {
      return this.field3829;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2082233739"
   )
   public void method5141(int var1) {
      if(var1 >= 1) {
         this.field3831 = var1;
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "220826325"
   )
   public void method5106(int var1) {
      if(var1 >= 1) {
         this.field3832 = var1;
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2082975886"
   )
   public void method5148() {
      this.field3834 = null;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-20"
   )
   public void method5206(int var1) {
      this.field3834 = new HashSet();
      this.field3834.add(Integer.valueOf(var1));
      this.field3847 = 0;
      this.field3833 = 0;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1475070234"
   )
   public void method5145(boolean var1) {
      this.field3835 = var1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "101"
   )
   public void method5256(int var1) {
      this.field3834 = new HashSet();
      this.field3847 = 0;
      this.field3833 = 0;

      for(int var2 = 0; var2 < class54.field662.length; ++var2) {
         if(class54.field662[var2] != null && class54.field662[var2].field3307 == var1) {
            this.field3834.add(Integer.valueOf(class54.field662[var2].field3290));
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-119"
   )
   public void method5143(boolean var1) {
      this.field3822 = !var1;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1584809995"
   )
   public int method5140() {
      return this.field3823;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(B)Lclass39;",
      garbageValue = "100"
   )
   public class39 method5201() {
      if(!this.field3806.method5103()) {
         return null;
      } else if(!this.field3838.method562()) {
         return null;
      } else {
         HashMap var1 = this.field3838.method579();
         this.field3846 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3846.addAll(var3);
         }

         this.field3840 = this.field3846.iterator();
         return this.method5270();
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1355449249"
   )
   public boolean method5151() {
      return !this.field3822;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-53713290"
   )
   public void method5149(int var1, boolean var2) {
      if(!var2) {
         this.field3839.add(Integer.valueOf(var1));
      } else {
         this.field3839.remove(Integer.valueOf(var1));
      }

      this.method5154();
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "172425288"
   )
   public void method5150(int var1, boolean var2) {
      if(!var2) {
         this.field3836.add(Integer.valueOf(var1));
      } else {
         this.field3836.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < class54.field662.length; ++var3) {
         if(class54.field662[var3] != null && class54.field662[var3].field3307 == var1) {
            int var4 = class54.field662[var3].field3290;
            if(!var2) {
               this.field3821.add(Integer.valueOf(var4));
            } else {
               this.field3821.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5154();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "112"
   )
   public boolean method5208(int var1) {
      return !this.field3839.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "742038487"
   )
   public boolean method5153(int var1) {
      return !this.field3836.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(ILCoordinates;B)LCoordinates;",
      garbageValue = "0"
   )
   public Coordinates method5156(int var1, Coordinates var2) {
      if(!this.field3806.method5103()) {
         return null;
      } else if(!this.field3838.method562()) {
         return null;
      } else if(!this.field3819.method281(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.field3838.method579();
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
                     return var5.field516;
                  }

                  var8 = (class39)var7.next();
                  int var9 = var8.field516.worldX - var2.worldX;
                  int var10 = var8.field516.worldY - var2.worldY;
                  var11 = var9 * var9 + var10 * var10;
                  if(var11 == 0) {
                     return var8.field516;
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;LCoordinates;LCoordinates;ZI)V",
      garbageValue = "1616663843"
   )
   public void method5227(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.field3819 == null || var1 != this.field3819) {
            this.method5120(var1);
         }

         if(!var4 && this.field3819.method280(var2.plane, var2.worldX, var2.worldY)) {
            this.method5122(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5122(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }
}
