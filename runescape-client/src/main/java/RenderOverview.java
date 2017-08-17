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

@ObfuscatedName("kg")
@Implements("RenderOverview")
public class RenderOverview {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   static final class262 field3798;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   static final class262 field3794;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   static final class262 field3800;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Ljr;"
   )
   IndexedSprite[] field3803;
   @ObfuscatedName("ar")
   boolean field3832;
   @ObfuscatedName("as")
   HashSet field3827;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 2006627827
   )
   int field3797;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1047219569
   )
   int field3816;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -626748383
   )
   int field3817;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1976832167
   )
   int field3824;
   @ObfuscatedName("at")
   HashSet field3826;
   @ObfuscatedName("az")
   boolean field3799;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1797236321
   )
   int field3802;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   IndexDataBase field3811;
   @ObfuscatedName("au")
   HashSet field3820;
   @ObfuscatedName("s")
   HashMap field3804;
   @ObfuscatedName("ag")
   HashSet field3821;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   class288 field3829;
   @ObfuscatedName("ad")
   Iterator field3834;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -817693445
   )
   int field3812;
   @ObfuscatedName("n")
   float field3815;
   @ObfuscatedName("q")
   float field3818;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lab;"
   )
   WorldMapData field3806;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lab;"
   )
   WorldMapData field3805;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1941373897
   )
   int field3814;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1909690303
   )
   int field3813;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1528658991
   )
   int field3835;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1248677889
   )
   int field3810;
   @ObfuscatedName("m")
   HashMap field3809;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -621728079
   )
   int field3825;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lab;"
   )
   WorldMapData field3795;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   Font field3807;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lam;"
   )
   class41 field3808;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 771476677
   )
   int field3823;
   @ObfuscatedName("af")
   HashSet field3828;
   @ObfuscatedName("ap")
   List field3833;
   @ObfuscatedName("ah")
   final int[] field3822;
   @ObfuscatedName("aa")
   HashSet field3830;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 233296089
   )
   int field3831;

   static {
      field3798 = class262.field3611;
      field3794 = class262.field3614;
      field3800 = class262.field3613;
   }

   public RenderOverview() {
      this.field3812 = -1;
      this.field3813 = -1;
      this.field3816 = -1;
      this.field3817 = -1;
      this.field3797 = 3;
      this.field3802 = 50;
      this.field3832 = false;
      this.field3821 = null;
      this.field3825 = -1;
      this.field3823 = -1;
      this.field3824 = -1;
      this.field3814 = -1;
      this.field3826 = new HashSet();
      this.field3827 = new HashSet();
      this.field3828 = new HashSet();
      this.field3820 = new HashSet();
      this.field3799 = false;
      this.field3831 = 0;
      this.field3822 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3830 = new HashSet();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1080370111"
   )
   boolean method5233() {
      return this.field3812 != -1 && this.field3813 != -1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIII)Lab;",
      garbageValue = "842426102"
   )
   public WorldMapData method5271(int var1, int var2, int var3) {
      Iterator var4 = this.field3804.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method299(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IB)F",
      garbageValue = "-91"
   )
   float method5247(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)Lab;",
      garbageValue = "-1121774778"
   )
   public WorldMapData method5251(int var1) {
      Iterator var2 = this.field3804.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method311() != var1);

      return var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lab;I)V",
      garbageValue = "1241150806"
   )
   void method5281(WorldMapData var1) {
      this.field3806 = var1;
      this.field3808 = new class41(this.field3803, this.field3809);
      this.field3829.method5214(this.field3806.method306());
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "598230940"
   )
   public int method5256() {
      return this.field3806 == null?-1:this.field3810 + this.field3806.method310() * 64;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lab;I)V",
      garbageValue = "2127312204"
   )
   void method5239(WorldMapData var1) {
      if(this.field3806 == null || var1 != this.field3806) {
         this.method5281(var1);
         this.method5263(-1, -1, -1);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2145140766"
   )
   void method5329() {
      if(this.field3818 < this.field3815) {
         this.field3818 = Math.min(this.field3815, this.field3818 + this.field3818 / 30.0F);
      }

      if(this.field3818 > this.field3815) {
         this.field3818 = Math.max(this.field3815, this.field3818 - this.field3818 / 30.0F);
      }

   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-91"
   )
   void method5274() {
      this.field3820.clear();
      this.field3820.addAll(this.field3826);
      this.field3820.addAll(this.field3828);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1535010275"
   )
   void method5263(int var1, int var2, int var3) {
      if(this.field3806 != null) {
         int[] var4 = this.field3806.method368(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3806.method368(this.field3806.method315(), this.field3806.method325(), this.field3806.method316());
         }

         this.field3810 = var4[0] - this.field3806.method310() * 64;
         this.field3835 = var4[1] - this.field3806.method327() * 64;
         this.field3812 = -1;
         this.field3813 = -1;
         this.field3818 = this.method5247(this.field3806.method309());
         this.field3815 = this.field3818;
         this.field3833 = null;
         this.field3834 = null;
         this.field3808.method603();
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   public int method5312() {
      return this.field3806 == null?-1:this.field3835 + this.field3806.method327() * 64;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "8218"
   )
   void method5232() {
      if(this.method5233()) {
         int var1 = this.field3812 - this.field3810;
         int var2 = this.field3813 - this.field3835;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3810 += var1;
         this.field3835 += var2;
         if(this.field3812 == this.field3810 && this.field3835 == this.field3813) {
            this.field3812 = -1;
            this.field3813 = -1;
         }

      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1747263309"
   )
   public void method5252(int var1, int var2) {
      if(this.field3806 != null && this.field3806.method300(var1, var2)) {
         this.field3812 = var1 - this.field3806.method310() * 64;
         this.field3813 = var2 - this.field3806.method327() * 64;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2124290351"
   )
   public void method5253(int var1, int var2) {
      if(this.field3806 != null) {
         this.field3810 = var1 - this.field3806.method310() * 64;
         this.field3835 = var2 - this.field3806.method327() * 64;
         this.field3812 = -1;
         this.field3813 = -1;
      }
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(B)Laz;",
      garbageValue = "95"
   )
   public class39 method5279() {
      return this.field3834 == null?null:(!this.field3834.hasNext()?null:(class39)this.field3834.next());
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIS)V",
      garbageValue = "221"
   )
   void method5315(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.method4968(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.method4968(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3807.method4843("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-131731373"
   )
   public int method5228() {
      return this.field3811.method4133(this.field3805.method306(), class40.field552.field551)?100:this.field3811.method4136(this.field3805.method306());
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lia;Ljh;Ljava/util/HashMap;[Ljr;S)V",
      garbageValue = "1111"
   )
   public void method5280(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field3803 = var4;
      this.field3811 = var1;
      this.field3807 = var2;
      this.field3809 = new HashMap();
      this.field3809.put(class24.field369, var3.get(field3798));
      this.field3809.put(class24.field366, var3.get(field3794));
      this.field3809.put(class24.field367, var3.get(field3800));
      this.field3829 = new class288(var1);
      int var5 = this.field3811.getFile(class40.field559.field551);
      int[] var6 = this.field3811.getChilds(var5);
      this.field3804 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3811.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3804.put(var9.method306(), var9);
         if(var9.method305()) {
            this.field3805 = var9;
         }
      }

      this.method5239(this.field3805);
      this.field3795 = null;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1761195545"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.method4968(var1, var2, var3, var4, -16777216);
      int var7 = this.field3829.method5215();
      if(var7 < 100) {
         this.method5315(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3808.method577()) {
            this.field3808.method579(this.field3811, this.field3806.method306(), Client.isMembers);
            if(!this.field3808.method577()) {
               return;
            }
         }

         if(this.field3821 != null) {
            ++this.field3823;
            if(this.field3823 % this.field3802 == 0) {
               this.field3823 = 0;
               ++this.field3825;
            }

            if(this.field3825 >= this.field3797 && !this.field3832) {
               this.field3821 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3818));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3818));
         this.field3808.method591(this.field3810 - var8 / 2, this.field3835 - var9 / 2, var8 / 2 + this.field3810, var9 / 2 + this.field3835, var1, var2, var3 + var1, var2 + var4);
         if(!this.field3799) {
            boolean var10 = false;
            if(var5 - this.field3831 > 100) {
               this.field3831 = var5;
               var10 = true;
            }

            this.field3808.method572(this.field3810 - var8 / 2, this.field3835 - var9 / 2, var8 / 2 + this.field3810, var9 / 2 + this.field3835, var1, var2, var3 + var1, var2 + var4, this.field3820, this.field3821, this.field3823, this.field3802, var10);
         }

         this.field3816 = var8;
         this.field3817 = var9;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-488896265"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3829.method5223()) {
         if(!this.field3808.method577()) {
            this.field3808.method579(this.field3811, this.field3806.method306(), Client.isMembers);
            if(!this.field3808.method577()) {
               return;
            }
         }

         this.field3808.method574(var1, var2, var3, var4, this.field3821, this.field3823, this.field3802);
      }
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(IILhh;Lhh;I)V",
      garbageValue = "-1407912751"
   )
   public void method5277(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1161(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1162(class220.field2798);
         break;
      case 1009:
         var5.method1162(class220.field2792);
         break;
      case 1010:
         var5.method1162(class220.field2790);
         break;
      case 1011:
         var5.method1162(class220.field2791);
         break;
      case 1012:
         var5.method1162(class220.field2789);
      }

      Coordinates.method3942(var5);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-335127428"
   )
   public void method5229(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5271(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3805;
      }

      boolean var6 = false;
      if(var5 != this.field3795 || var4) {
         this.field3795 = var5;
         this.method5239(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5263(var1, var2, var3);
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "31246221"
   )
   public void method5249() {
      this.field3829.method5213();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "1407775985"
   )
   public void method5285(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3829.method5223()) {
         this.method5329();
         this.method5232();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3818));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3818));
            List var10 = this.field3808.method575(this.field3810 - var8 / 2 - 1, this.field3835 - var9 / 2 - 1, var8 / 2 + this.field3810 + 1, var9 / 2 + this.field3835 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            ScriptEvent var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); Coordinates.method3942(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new class47(var13.field544, var13.field537, var13.field542);
               var14.method1161(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3830.contains(var13)) {
                  var14.method1162(class220.field2795);
               } else {
                  var14.method1162(class220.field2793);
               }
            }

            var12 = this.field3830.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new class47(var13.field544, var13.field537, var13.field542);
                  var14.method1161(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1162(class220.field2794);
                  Coordinates.method3942(var14);
               }
            }

            this.field3830 = var11;
         }
      }
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-892264540"
   )
   public void method5275(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3829.method5223()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3818));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3818));
         List var9 = this.field3808.method575(this.field3810 - var7 / 2 - 1, this.field3835 - var8 / 2 - 1, var7 / 2 + this.field3810 + 1, var8 / 2 + this.field3835 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               Area var12 = Area.field3284[var11.field544];
               var13 = false;

               for(int var14 = this.field3822.length - 1; var14 >= 0; --var14) {
                  if(var12.field3285[var14] != null) {
                     DynamicObject.addMenuEntry(var12.field3285[var14], var12.field3286, this.field3822[var14], var11.field544, var11.field537.method3941(), var11.field542.method3941());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1913065583"
   )
   public void method5236(int var1) {
      WorldMapData var2 = this.method5251(var1);
      if(var2 != null) {
         this.method5239(var2);
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1554231229"
   )
   public int method5384() {
      return 1.0D == (double)this.field3815?25:(1.5D == (double)this.field3815?37:(2.0D == (double)this.field3815?50:((double)this.field3815 == 3.0D?75:(4.0D == (double)this.field3815?100:200))));
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1747227927"
   )
   public void method5410(int var1) {
      this.field3815 = this.method5247(var1);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1530043902"
   )
   public boolean method5250() {
      return this.field3829.method5223();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)Lhh;",
      garbageValue = "1993918649"
   )
   public Coordinates method5258() {
      return this.field3806 == null?null:this.field3806.method302(this.method5256(), this.method5312());
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "261918310"
   )
   public void method5254(int var1, int var2, int var3) {
      if(this.field3806 != null) {
         int[] var4 = this.field3806.method368(var1, var2, var3);
         if(var4 != null) {
            this.method5252(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-711746946"
   )
   public void method5255(int var1, int var2, int var3) {
      if(this.field3806 != null) {
         int[] var4 = this.field3806.method368(var1, var2, var3);
         if(var4 != null) {
            this.method5253(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-1393172882"
   )
   public void method5230(int var1, int var2, boolean var3) {
      if(this.field3824 == -1) {
         this.field3824 = var1;
      }

      if(this.field3814 == -1) {
         this.field3814 = var2;
      }

      int var4 = var1 - this.field3824;
      int var5 = var2 - this.field3814;
      this.field3824 = var1;
      this.field3814 = var2;
      if(var3 && !this.method5233()) {
         this.field3810 -= (int)((float)var4 / this.field3815);
         this.field3835 += (int)((float)var5 / this.field3815);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "281173576"
   )
   public int method5237() {
      return this.field3806 == null?-1:this.field3806.method311();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lab;",
      garbageValue = "-391378524"
   )
   public WorldMapData method5342() {
      return this.field3806;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-14"
   )
   public void method5351() {
      this.field3797 = 3;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-705612159"
   )
   public void method5264() {
      this.field3802 = 50;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "101"
   )
   public int method5341() {
      return this.field3816;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-698766400"
   )
   public void method5261(int var1) {
      if(var1 >= 1) {
         this.field3797 = var1;
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public void method5346() {
      this.field3821 = null;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-44"
   )
   public void method5382(int var1) {
      if(var1 >= 1) {
         this.field3802 = var1;
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2088970202"
   )
   public void method5305(int var1) {
      this.field3821 = new HashSet();
      this.field3821.add(Integer.valueOf(var1));
      this.field3825 = 0;
      this.field3823 = 0;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1633012660"
   )
   public void method5265(boolean var1) {
      this.field3832 = var1;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "131469714"
   )
   public void method5267(int var1) {
      this.field3821 = new HashSet();
      this.field3825 = 0;
      this.field3823 = 0;

      for(int var2 = 0; var2 < Area.field3284.length; ++var2) {
         if(Area.field3284[var2] != null && Area.field3284[var2].field3296 == var1) {
            this.field3821.add(Integer.valueOf(Area.field3284[var2].field3287));
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "13"
   )
   public void method5269(boolean var1) {
      this.field3799 = !var1;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-69"
   )
   public int method5238() {
      return this.field3817;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)Laz;",
      garbageValue = "36345171"
   )
   public class39 method5278() {
      if(!this.field3829.method5223()) {
         return null;
      } else if(!this.field3808.method577()) {
         return null;
      } else {
         HashMap var1 = this.field3808.method578();
         this.field3833 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3833.addAll(var3);
         }

         this.field3834 = this.field3833.iterator();
         return this.method5279();
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1705996823"
   )
   public boolean method5337() {
      return !this.field3799;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1038783221"
   )
   public void method5299(int var1, boolean var2) {
      if(!var2) {
         this.field3826.add(Integer.valueOf(var1));
      } else {
         this.field3826.remove(Integer.valueOf(var1));
      }

      this.method5274();
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "2145913652"
   )
   public void method5266(int var1, boolean var2) {
      if(!var2) {
         this.field3827.add(Integer.valueOf(var1));
      } else {
         this.field3827.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.field3284.length; ++var3) {
         if(Area.field3284[var3] != null && Area.field3284[var3].field3296 == var1) {
            int var4 = Area.field3284[var3].field3287;
            if(!var2) {
               this.field3828.add(Integer.valueOf(var4));
            } else {
               this.field3828.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5274();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lab;Lhh;Lhh;ZI)V",
      garbageValue = "761546315"
   )
   public void method5231(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.field3806 == null || var1 != this.field3806) {
            this.method5281(var1);
         }

         if(!var4 && this.field3806.method299(var2.plane, var2.worldX, var2.worldY)) {
            this.method5263(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5263(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1946742321"
   )
   public boolean method5372(int var1) {
      return !this.field3826.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1479827160"
   )
   public boolean method5259(int var1) {
      return !this.field3827.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(ILhh;B)Lhh;",
      garbageValue = "76"
   )
   public Coordinates method5399(int var1, Coordinates var2) {
      if(!this.field3829.method5223()) {
         return null;
      } else if(!this.field3808.method577()) {
         return null;
      } else if(!this.field3806.method300(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.field3808.method578();
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
                     return var5.field542;
                  }

                  var8 = (class39)var7.next();
                  int var9 = var8.field542.worldX - var2.worldX;
                  int var10 = var8.field542.worldY - var2.worldY;
                  var11 = var9 * var9 + var10 * var10;
                  if(var11 == 0) {
                     return var8.field542;
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
}
