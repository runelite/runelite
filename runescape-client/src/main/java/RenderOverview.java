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
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1741787041
   )
   int field3802;
   @ObfuscatedName("k")
   WorldMapData field3804;
   @ObfuscatedName("x")
   static final class261 field3805;
   @ObfuscatedName("f")
   static final class261 field3806;
   @ObfuscatedName("n")
   static final class261 field3807;
   @ObfuscatedName("a")
   Font field3808;
   @ObfuscatedName("ae")
   HashSet field3809;
   @ObfuscatedName("m")
   class41 field3810;
   @ObfuscatedName("q")
   HashMap field3811;
   @ObfuscatedName("j")
   WorldMapData field3812;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1128061169
   )
   int field3813;
   @ObfuscatedName("r")
   WorldMapData field3814;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 867653601
   )
   int field3815;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -850126561
   )
   int field3816;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1622626289
   )
   int field3817;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -114941971
   )
   int field3818;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -614499405
   )
   int field3820;
   @ObfuscatedName("l")
   float field3821;
   @ObfuscatedName("u")
   float field3822;
   @ObfuscatedName("au")
   HashSet field3823;
   @ObfuscatedName("ab")
   HashSet field3824;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 2129852865
   )
   int field3825;
   @ObfuscatedName("d")
   class287 field3826;
   @ObfuscatedName("af")
   boolean field3827;
   @ObfuscatedName("at")
   HashSet field3828;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 586647373
   )
   int field3829;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1515969781
   )
   int field3830;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -437607607
   )
   int field3831;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1673555261
   )
   int field3832;
   @ObfuscatedName("o")
   HashMap field3833;
   @ObfuscatedName("aa")
   HashSet field3834;
   @ObfuscatedName("h")
   IndexDataBase field3835;
   @ObfuscatedName("ap")
   HashSet field3836;
   @ObfuscatedName("as")
   boolean field3837;
   @ObfuscatedName("z")
   ModIcon[] field3838;
   @ObfuscatedName("az")
   final int[] field3839;
   @ObfuscatedName("ac")
   List field3840;
   @ObfuscatedName("ax")
   Iterator field3841;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -867779559
   )
   int field3842;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "99"
   )
   public int method5173() {
      return this.field3835.method4128(this.field3812.method274(), class40.field544.field542)?100:this.field3835.method4133(this.field3812.method274());
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "-2021936277"
   )
   public void method5174(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3826.method5156()) {
         this.method5176();
         this.method5177();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3821));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3821));
            List var10 = this.field3810.method543(this.field3817 - var8 / 2 - 1, this.field3818 - var9 / 2 - 1, var8 / 2 + this.field3817 + 1, this.field3818 + var9 / 2 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            class69 var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); Friend.method1075(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new class69();
               var15 = new class47(var13.field536, var13.field526, var13.field525);
               var14.method1087(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3823.contains(var13)) {
                  var14.method1090(class219.field2794);
               } else {
                  var14.method1090(class219.field2792);
               }
            }

            var12 = this.field3823.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new class69();
                  var15 = new class47(var13.field536, var13.field526, var13.field525);
                  var14.method1087(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1090(class219.field2796);
                  Friend.method1075(var14);
               }
            }

            this.field3823 = var11;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "658666395"
   )
   void method5176() {
      if(this.field3821 < this.field3822) {
         this.field3821 = Math.min(this.field3822, this.field3821 + this.field3821 / 30.0F);
      }

      if(this.field3821 > this.field3822) {
         this.field3821 = Math.max(this.field3822, this.field3821 - this.field3821 / 30.0F);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1822195638"
   )
   void method5177() {
      if(this.method5178()) {
         int var1 = this.field3831 - this.field3817;
         int var2 = this.field3820 - this.field3818;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3817 += var1;
         this.field3818 += var2;
         if(this.field3831 == this.field3817 && this.field3820 == this.field3818) {
            this.field3831 = -1;
            this.field3820 = -1;
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2013288347"
   )
   boolean method5178() {
      return this.field3831 != -1 && this.field3820 != -1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIB)LWorldMapData;",
      garbageValue = "4"
   )
   public WorldMapData method5179(int var1, int var2, int var3) {
      Iterator var4 = this.field3811.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method267(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-5"
   )
   public void method5181(int var1) {
      WorldMapData var2 = this.method5196(var1);
      if(var2 != null) {
         this.method5184(var2);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)LWorldMapData;",
      garbageValue = "1484731130"
   )
   public WorldMapData method5183() {
      return this.field3804;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;I)V",
      garbageValue = "-1531334326"
   )
   void method5184(WorldMapData var1) {
      if(this.field3804 == null || var1 != this.field3804) {
         this.method5204(var1);
         this.method5187(-1, -1, -1);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;LCoordinates;LCoordinates;ZI)V",
      garbageValue = "-1348287108"
   )
   public void method5186(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.field3804 == null || var1 != this.field3804) {
            this.method5204(var1);
         }

         if(!var4 && this.field3804.method267(var2.plane, var2.worldX, var2.worldY)) {
            this.method5187(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5187(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "966263965"
   )
   void method5187(int var1, int var2, int var3) {
      if(this.field3804 != null) {
         int[] var4 = this.field3804.method269(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3804.method269(this.field3804.method278(), this.field3804.method282(), this.field3804.method284());
         }

         this.field3817 = var4[0] - this.field3804.method303() * 64;
         this.field3818 = var4[1] - this.field3804.method280() * 64;
         this.field3831 = -1;
         this.field3820 = -1;
         this.field3821 = this.method5192(this.field3804.method333());
         this.field3822 = this.field3821;
         this.field3840 = null;
         this.field3841 = null;
         this.field3810.method544();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LFont;Ljava/util/HashMap;[LModIcon;B)V",
      garbageValue = "-88"
   )
   public void method5189(IndexDataBase var1, Font var2, HashMap var3, ModIcon[] var4) {
      this.field3838 = var4;
      this.field3835 = var1;
      this.field3808 = var2;
      this.field3833 = new HashMap();
      this.field3833.put(class24.field357, var3.get(field3805));
      this.field3833.put(class24.field350, var3.get(field3806));
      this.field3833.put(class24.field352, var3.get(field3807));
      this.field3826 = new class287(var1);
      int var5 = this.field3835.method4125(class40.field540.field542);
      int[] var6 = this.field3835.method4161(var5);
      this.field3811 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3835.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3811.put(var9.method274(), var9);
         if(var9.method273()) {
            this.field3812 = var9;
         }
      }

      this.method5184(this.field3812);
      this.field3814 = null;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "1"
   )
   void method5191(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var2 + var4 / 2 - 18 - var6;
      Rasterizer2D.method4923(var1, var2, var3, var4, -16777216);
      Rasterizer2D.method4945(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.method4923(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3808.method4736("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IB)F",
      garbageValue = "59"
   )
   float method5192(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "22"
   )
   public int method5193() {
      return 1.0D == (double)this.field3822?25:(1.5D == (double)this.field3822?37:((double)this.field3822 == 2.0D?50:(3.0D == (double)this.field3822?75:(4.0D == (double)this.field3822?100:200))));
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1968270721"
   )
   public void method5194() {
      this.field3826.method5158();
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-289739656"
   )
   public boolean method5195() {
      return this.field3826.method5156();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)LWorldMapData;",
      garbageValue = "-71932288"
   )
   public WorldMapData method5196(int var1) {
      Iterator var2 = this.field3811.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method277() != var1);

      return var3;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2143546290"
   )
   public void method5197(int var1, int var2) {
      if(this.field3804 != null && this.field3804.method287(var1, var2)) {
         this.field3831 = var1 - this.field3804.method303() * 64;
         this.field3820 = var2 - this.field3804.method280() * 64;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1255295394"
   )
   public void method5199(int var1, int var2, int var3) {
      if(this.field3804 != null) {
         int[] var4 = this.field3804.method269(var1, var2, var3);
         if(var4 != null) {
            this.method5197(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-298450754"
   )
   public void method5200(int var1, int var2, int var3) {
      if(this.field3804 != null) {
         int[] var4 = this.field3804.method269(var1, var2, var3);
         if(var4 != null) {
            this.method5288(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1853133290"
   )
   public int method5202() {
      return this.field3804 == null?-1:this.field3818 + this.field3804.method280() * 64;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;I)V",
      garbageValue = "-1891974113"
   )
   void method5204(WorldMapData var1) {
      this.field3804 = var1;
      this.field3810 = new class41(this.field3838, this.field3833);
      this.field3826.method5157(this.field3804.method274());
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "5275277"
   )
   public int method5205() {
      return this.field3842;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-59"
   )
   public void method5207() {
      this.field3825 = 3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "490715543"
   )
   public int method5208() {
      return this.field3804 == null?-1:this.field3804.method277();
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "100"
   )
   public void method5210(boolean var1) {
      this.field3827 = var1;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-123"
   )
   public void method5211(int var1) {
      this.field3828 = new HashSet();
      this.field3828.add(Integer.valueOf(var1));
      this.field3815 = 0;
      this.field3830 = 0;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-796464620"
   )
   public void method5212(int var1) {
      this.field3828 = new HashSet();
      this.field3815 = 0;
      this.field3830 = 0;

      for(int var2 = 0; var2 < class223.field2839.length; ++var2) {
         if(class223.field2839[var2] != null && class223.field2839[var2].field3297 == var1) {
            this.field3828.add(Integer.valueOf(class223.field2839[var2].field3289));
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)LCoordinates;",
      garbageValue = "2026700825"
   )
   public Coordinates method5213() {
      return this.field3804 == null?null:this.field3804.method270(this.method5258(), this.method5202());
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-57"
   )
   public void method5214(boolean var1) {
      this.field3837 = !var1;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1571743477"
   )
   public boolean method5217() {
      return !this.field3837;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1978984161"
   )
   public boolean method5219(int var1) {
      return !this.field3834.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1737768019"
   )
   void method5220() {
      this.field3809.clear();
      this.field3809.addAll(this.field3824);
      this.field3809.addAll(this.field3836);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1062103167"
   )
   public void method5221(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3826.method5156()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3821));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3821));
         List var9 = this.field3810.method543(this.field3817 - var7 / 2 - 1, this.field3818 - var8 / 2 - 1, var7 / 2 + this.field3817 + 1, this.field3818 + var8 / 2 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               Area var12 = class223.field2839[var11.field536];
               var13 = false;

               for(int var14 = this.field3839.length - 1; var14 >= 0; --var14) {
                  if(var12.field3298[var14] != null) {
                     class3.addMenuEntry(var12.field3298[var14], var12.field3308, this.field3839[var14], var11.field536, var11.field526.method3918(), var11.field525.method3918());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1829993925"
   )
   public boolean method5222(int var1) {
      return !this.field3824.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(IILCoordinates;LCoordinates;I)V",
      garbageValue = "523634212"
   )
   public void method5223(int var1, int var2, Coordinates var3, Coordinates var4) {
      class69 var5 = new class69();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1087(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1090(class219.field2798);
         break;
      case 1009:
         var5.method1090(class219.field2790);
         break;
      case 1010:
         var5.method1090(class219.field2789);
         break;
      case 1011:
         var5.method1090(class219.field2799);
         break;
      case 1012:
         var5.method1090(class219.field2791);
      }

      Friend.method1075(var5);
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(I)Lclass39;",
      garbageValue = "-1495822984"
   )
   public class39 method5225() {
      return this.field3841 == null?null:(!this.field3841.hasNext()?null:(class39)this.field3841.next());
   }

   static {
      field3805 = class261.field3620;
      field3806 = class261.field3621;
      field3807 = class261.field3618;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I)Lclass39;",
      garbageValue = "-1732006379"
   )
   public class39 method5232() {
      if(!this.field3826.method5156()) {
         return null;
      } else if(!this.field3810.method548()) {
         return null;
      } else {
         HashMap var1 = this.field3810.method547();
         this.field3840 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3840.addAll(var3);
         }

         this.field3841 = this.field3840.iterator();
         return this.method5225();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "1047073313"
   )
   public void method5234(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5179(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3812;
      }

      boolean var6 = false;
      if(this.field3814 != var5 || var4) {
         this.field3814 = var5;
         this.method5184(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5187(var1, var2, var3);
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1421034248"
   )
   public void method5240(int var1) {
      this.field3822 = this.method5192(var1);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-29"
   )
   public int method5258() {
      return this.field3804 == null?-1:this.field3817 + this.field3804.method303() * 64;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1216201565"
   )
   public void method5259() {
      this.field3802 = 50;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(ILCoordinates;I)LCoordinates;",
      garbageValue = "-1792292634"
   )
   public Coordinates method5266(int var1, Coordinates var2) {
      if(!this.field3826.method5156()) {
         return null;
      } else if(!this.field3810.method548()) {
         return null;
      } else if(!this.field3804.method287(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.field3810.method547();
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
                     return var5.field525;
                  }

                  var8 = (class39)var7.next();
                  int var9 = var8.field525.worldX - var2.worldX;
                  int var10 = var8.field525.worldY - var2.worldY;
                  var11 = var9 * var9 + var10 * var10;
                  if(var11 == 0) {
                     return var8.field525;
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1886431234"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3826.method5156()) {
         if(!this.field3810.method548()) {
            System.out.println("renderOverview extractData");
            this.field3810.method537(this.field3835, this.field3804.method274(), Client.isMembers);
            System.out.println("done");
            if(!this.field3810.method548()) {
               return;
            }
         }

         this.field3810.method542(var1, var2, var3, var4, this.field3828, this.field3830, this.field3802);
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2039962099"
   )
   public void method5273(int var1) {
      if(var1 >= 1) {
         this.field3802 = var1;
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1498820372"
   )
   public void method5278(int var1) {
      if(var1 >= 1) {
         this.field3825 = var1;
      }

   }

   public RenderOverview() {
      this.field3831 = -1;
      this.field3820 = -1;
      this.field3829 = -1;
      this.field3842 = -1;
      this.field3825 = 3;
      this.field3802 = 50;
      this.field3827 = false;
      this.field3828 = null;
      this.field3815 = -1;
      this.field3830 = -1;
      this.field3813 = -1;
      this.field3832 = -1;
      this.field3824 = new HashSet();
      this.field3834 = new HashSet();
      this.field3836 = new HashSet();
      this.field3809 = new HashSet();
      this.field3837 = false;
      this.field3816 = 0;
      this.field3839 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3823 = new HashSet();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1227501106"
   )
   public void method5288(int var1, int var2) {
      if(this.field3804 != null) {
         this.field3817 = var1 - this.field3804.method303() * 64;
         this.field3818 = var2 - this.field3804.method280() * 64;
         this.field3831 = -1;
         this.field3820 = -1;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1901745465"
   )
   public int method5294() {
      return this.field3829;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "2076976510"
   )
   public void method5299(int var1, boolean var2) {
      if(!var2) {
         this.field3824.add(Integer.valueOf(var1));
      } else {
         this.field3824.remove(Integer.valueOf(var1));
      }

      this.method5220();
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1261898322"
   )
   public void method5304(int var1, boolean var2) {
      if(!var2) {
         this.field3834.add(Integer.valueOf(var1));
      } else {
         this.field3834.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < class223.field2839.length; ++var3) {
         if(class223.field2839[var3] != null && var1 == class223.field2839[var3].field3297) {
            int var4 = class223.field2839[var3].field3289;
            if(!var2) {
               this.field3836.add(Integer.valueOf(var4));
            } else {
               this.field3836.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5220();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1298020137"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.method4957(var6);
      Rasterizer2D.method4940(var1, var2, var1 + var3, var2 + var4);
      Rasterizer2D.method4923(var1, var2, var3, var4, -16777216);
      int var7 = this.field3826.method5160();
      if(var7 < 100) {
         this.method5191(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3810.method548()) {
            System.out.println("renderOverview extractWorldmap");
            this.field3810.method537(this.field3835, this.field3804.method274(), Client.isMembers);
            System.out.println("done");
            if(!this.field3810.method548()) {
               return;
            }
         }

         if(this.field3828 != null) {
            ++this.field3830;
            if(this.field3830 % this.field3802 == 0) {
               this.field3830 = 0;
               ++this.field3815;
            }

            if(this.field3815 >= this.field3825 && !this.field3827) {
               this.field3828 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3821));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3821));
         this.field3810.method539(this.field3817 - var8 / 2, this.field3818 - var9 / 2, var8 / 2 + this.field3817, this.field3818 + var9 / 2, var1, var2, var1 + var3, var4 + var2);
         if(!this.field3837) {
            boolean var10 = false;
            if(var5 - this.field3816 > 100) {
               this.field3816 = var5;
               var10 = true;
            }

            this.field3810.method554(this.field3817 - var8 / 2, this.field3818 - var9 / 2, var8 / 2 + this.field3817, this.field3818 + var9 / 2, var1, var2, var1 + var3, var2 + var4, this.field3809, this.field3828, this.field3830, this.field3802, var10);
         }

         this.field3829 = var8;
         this.field3842 = var9;
         Rasterizer2D.method4928(var6);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "100"
   )
   public void method5327(int var1, int var2, boolean var3) {
      if(this.field3813 == -1) {
         this.field3813 = var1;
      }

      if(this.field3832 == -1) {
         this.field3832 = var2;
      }

      int var4 = var1 - this.field3813;
      int var5 = var2 - this.field3832;
      this.field3813 = var1;
      this.field3832 = var2;
      if(var3 && !this.method5178()) {
         this.field3817 -= (int)((float)var4 / this.field3822);
         this.field3818 += (int)((float)var5 / this.field3822);
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "111703334"
   )
   public void method5329() {
      this.field3828 = null;
   }
}
