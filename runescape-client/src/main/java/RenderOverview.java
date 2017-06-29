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
   @ObfuscatedName("c")
   WorldMapData field3811;
   @ObfuscatedName("al")
   HashSet field3812;
   @ObfuscatedName("v")
   IndexDataBase field3814;
   @ObfuscatedName("y")
   static final class261 field3815;
   @ObfuscatedName("j")
   static final class261 field3816;
   @ObfuscatedName("aa")
   final int[] field3817;
   @ObfuscatedName("e")
   Font field3818;
   @ObfuscatedName("o")
   HashMap field3819;
   @ObfuscatedName("z")
   ModIcon[] field3820;
   @ObfuscatedName("ak")
   HashSet field3821;
   @ObfuscatedName("g")
   float field3822;
   @ObfuscatedName("n")
   class287 field3823;
   @ObfuscatedName("l")
   HashMap field3824;
   @ObfuscatedName("f")
   class41 field3825;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -947154409
   )
   int field3826;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1107965647
   )
   int field3827;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -37352265
   )
   int field3828;
   @ObfuscatedName("b")
   WorldMapData field3829;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1360846803
   )
   int field3830;
   @ObfuscatedName("h")
   float field3831;
   @ObfuscatedName("an")
   HashSet field3832;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1318281977
   )
   int field3833;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1865968359
   )
   int field3834;
   @ObfuscatedName("ai")
   boolean field3835;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1350150903
   )
   int field3836;
   @ObfuscatedName("k")
   static final class261 field3837;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1783940055
   )
   int field3838;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1063810865
   )
   int field3839;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -323609939
   )
   int field3841;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1097606511
   )
   int field3842;
   @ObfuscatedName("as")
   HashSet field3843;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -2095637313
   )
   int field3844;
   @ObfuscatedName("aq")
   HashSet field3845;
   @ObfuscatedName("ax")
   HashSet field3846;
   @ObfuscatedName("ac")
   boolean field3847;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 819547259
   )
   int field3848;
   @ObfuscatedName("am")
   List field3850;
   @ObfuscatedName("az")
   Iterator field3851;
   @ObfuscatedName("m")
   WorldMapData field3852;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)LWorldMapData;",
      garbageValue = "1"
   )
   public WorldMapData method5179(int var1) {
      Iterator var2 = this.field3824.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method280() != var1);

      return var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1818316604"
   )
   public int method5180() {
      return this.field3814.method4134(this.field3811.method282(), class40.field561.field566)?100:this.field3814.method4118(this.field3811.method282());
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "3635"
   )
   public void method5181() {
      this.field3844 = 3;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-2103824157"
   )
   public void method5182(int var1, int var2, boolean var3) {
      if(this.field3841 == -1) {
         this.field3841 = var1;
      }

      if(this.field3842 == -1) {
         this.field3842 = var2;
      }

      int var4 = var1 - this.field3841;
      int var5 = var2 - this.field3842;
      this.field3841 = var1;
      this.field3842 = var2;
      if(var3 && !this.method5320()) {
         this.field3827 -= (int)((float)var4 / this.field3822);
         this.field3828 += (int)((float)var5 / this.field3822);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-1155665695"
   )
   public void method5187(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5214(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3811;
      }

      boolean var6 = false;
      if(this.field3829 != var5 || var4) {
         this.field3829 = var5;
         this.method5191(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5194(var1, var2, var3);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-108"
   )
   public void method5188(int var1) {
      WorldMapData var2 = this.method5179(var1);
      if(var2 != null) {
         this.method5191(var2);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1459279674"
   )
   public int method5189() {
      return this.field3852 == null?-1:this.field3852.method280();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;B)V",
      garbageValue = "5"
   )
   void method5191(WorldMapData var1) {
      if(this.field3852 == null || this.field3852 != var1) {
         this.method5192(var1);
         this.method5194(-1, -1, -1);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;I)V",
      garbageValue = "-886747868"
   )
   void method5192(WorldMapData var1) {
      this.field3852 = var1;
      this.field3825 = new class41(this.field3820, this.field3819);
      this.field3823.method5176(this.field3852.method282());
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;LCoordinates;LCoordinates;ZI)V",
      garbageValue = "1244119515"
   )
   public void method5193(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.field3852 == null || this.field3852 != var1) {
            this.method5192(var1);
         }

         if(!var4 && this.field3852.method275(var2.plane, var2.worldX, var2.worldY)) {
            this.method5194(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5194(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "0"
   )
   void method5194(int var1, int var2, int var3) {
      if(this.field3852 != null) {
         int[] var4 = this.field3852.method317(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3852.method317(this.field3852.method333(), this.field3852.method336(), this.field3852.method292());
         }

         this.field3827 = var4[0] - this.field3852.method305() * 64;
         this.field3828 = var4[1] - this.field3852.method288() * 64;
         this.field3836 = -1;
         this.field3830 = -1;
         this.field3831 = this.method5199(this.field3852.method285());
         this.field3822 = this.field3831;
         this.field3850 = null;
         this.field3851 = null;
         this.field3825.method567();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1507002387"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.method4924(var6);
      Rasterizer2D.method4999(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.method4983(var1, var2, var3, var4, -16777216);
      int var7 = this.field3823.method5164();
      if(var7 < 100) {
         this.method5203(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3825.method608()) {
            this.field3825.method566(this.field3814, this.field3852.method282(), Client.isMembers);
            if(!this.field3825.method608()) {
               return;
            }
         }

         if(this.field3832 != null) {
            ++this.field3838;
            if(this.field3838 % this.field3826 == 0) {
               this.field3838 = 0;
               ++this.field3839;
            }

            if(this.field3839 >= this.field3844 && !this.field3835) {
               this.field3832 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3831));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3831));
         this.field3825.method568(this.field3827 - var8 / 2, this.field3828 - var9 / 2, var8 / 2 + this.field3827, this.field3828 + var9 / 2, var1, var2, var3 + var1, var2 + var4);
         if(!this.field3847) {
            boolean var10 = false;
            if(var5 - this.field3848 > 100) {
               this.field3848 = var5;
               var10 = true;
            }

            this.field3825.method600(this.field3827 - var8 / 2, this.field3828 - var9 / 2, var8 / 2 + this.field3827, this.field3828 + var9 / 2, var1, var2, var3 + var1, var2 + var4, this.field3846, this.field3832, this.field3838, this.field3826, var10);
         }

         this.field3833 = var8;
         this.field3834 = var9;
         Rasterizer2D.method4921(var6);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1709565675"
   )
   void method5198() {
      if(this.field3831 < this.field3822) {
         this.field3831 = Math.min(this.field3822, this.field3831 / 30.0F + this.field3831);
      }

      if(this.field3831 > this.field3822) {
         this.field3831 = Math.max(this.field3822, this.field3831 - this.field3831 / 30.0F);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)F",
      garbageValue = "2112499553"
   )
   float method5199(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   public void method5201() {
      this.field3823.method5170();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1305170651"
   )
   public boolean method5202() {
      return this.field3823.method5163();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "672134051"
   )
   void method5203(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var1 + var3 / 2;
      int var8 = var2 + var4 / 2 - 18 - var6;
      Rasterizer2D.method4983(var1, var2, var3, var4, -16777216);
      Rasterizer2D.method4958(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.method4983(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3818.method4757("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1823449395"
   )
   public void method5204(int var1, int var2) {
      if(this.field3852 != null && this.field3852.method307(var1, var2)) {
         this.field3836 = var1 - this.field3852.method305() * 64;
         this.field3830 = var2 - this.field3852.method288() * 64;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2123284689"
   )
   public void method5205(int var1, int var2) {
      if(this.field3852 != null) {
         this.field3827 = var1 - this.field3852.method305() * 64;
         this.field3828 = var2 - this.field3852.method288() * 64;
         this.field3836 = -1;
         this.field3830 = -1;
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1478140254"
   )
   public void method5206(int var1, int var2, int var3) {
      if(this.field3852 != null) {
         int[] var4 = this.field3852.method317(var1, var2, var3);
         if(var4 != null) {
            this.method5204(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1782845335"
   )
   public int method5209() {
      return this.field3852 == null?-1:this.field3828 + this.field3852.method288() * 64;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)LCoordinates;",
      garbageValue = "-160668764"
   )
   public Coordinates method5210() {
      return this.field3852 == null?null:this.field3852.method278(this.method5299(), this.method5209());
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1950238230"
   )
   public void method5212(int var1, int var2, int var3) {
      if(this.field3852 != null) {
         int[] var4 = this.field3852.method317(var1, var2, var3);
         if(var4 != null) {
            this.method5205(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)LWorldMapData;",
      garbageValue = "-982690911"
   )
   public WorldMapData method5214(int var1, int var2, int var3) {
      Iterator var4 = this.field3824.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method275(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "300407288"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3823.method5163()) {
         if(!this.field3825.method608()) {
            this.field3825.method566(this.field3814, this.field3852.method282(), Client.isMembers);
            if(!this.field3825.method608()) {
               return;
            }
         }

         this.field3825.method571(var1, var2, var3, var4, this.field3832, this.field3838, this.field3826);
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "7329519"
   )
   public void method5217(boolean var1) {
      this.field3835 = var1;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-184115514"
   )
   public void method5219(int var1) {
      this.field3832 = new HashSet();
      this.field3839 = 0;
      this.field3838 = 0;

      for(int var2 = 0; var2 < Area.field3303.length; ++var2) {
         if(Area.field3303[var2] != null && Area.field3303[var2].field3307 == var1) {
            this.field3832.add(Integer.valueOf(Area.field3303[var2].field3297));
         }
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public void method5220() {
      this.field3832 = null;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1155841624"
   )
   void method5221() {
      this.field3846.clear();
      this.field3846.addAll(this.field3843);
      this.field3846.addAll(this.field3845);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "65280"
   )
   public void method5222(int var1, boolean var2) {
      if(!var2) {
         this.field3843.add(Integer.valueOf(var1));
      } else {
         this.field3843.remove(Integer.valueOf(var1));
      }

      this.method5221();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1962315629"
   )
   public void method5223(int var1, boolean var2) {
      if(!var2) {
         this.field3821.add(Integer.valueOf(var1));
      } else {
         this.field3821.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.field3303.length; ++var3) {
         if(Area.field3303[var3] != null && Area.field3303[var3].field3307 == var1) {
            int var4 = Area.field3303[var3].field3297;
            if(!var2) {
               this.field3845.add(Integer.valueOf(var4));
            } else {
               this.field3845.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5221();
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-855374767"
   )
   public boolean method5224() {
      return !this.field3847;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "2"
   )
   public boolean method5225(int var1) {
      return !this.field3843.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "621006344"
   )
   public boolean method5226(int var1) {
      return !this.field3821.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "976338749"
   )
   public void method5228(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3823.method5163()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3831));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3831));
         List var9 = this.field3825.method572(this.field3827 - var7 / 2 - 1, this.field3828 - var8 / 2 - 1, this.field3827 + var7 / 2 + 1, var8 / 2 + this.field3828 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               Area var12 = Area.field3303[var11.field548];
               var13 = false;

               for(int var14 = this.field3817.length - 1; var14 >= 0; --var14) {
                  if(var12.field3304[var14] != null) {
                     class175.addMenuEntry(var12.field3304[var14], var12.field3305, this.field3817[var14], var11.field548, var11.field547.method3913(), var11.field550.method3913());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(IILCoordinates;LCoordinates;B)V",
      garbageValue = "2"
   )
   public void method5230(int var1, int var2, Coordinates var3, Coordinates var4) {
      class69 var5 = new class69();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1133(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1128(class219.field2801);
         break;
      case 1009:
         var5.method1128(class219.field2795);
         break;
      case 1010:
         var5.method1128(class219.field2796);
         break;
      case 1011:
         var5.method1128(class219.field2797);
         break;
      case 1012:
         var5.method1128(class219.field2798);
      }

      class14.method76(var5);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)Lclass39;",
      garbageValue = "1283263724"
   )
   public class39 method5231() {
      if(!this.field3823.method5163()) {
         return null;
      } else if(!this.field3825.method608()) {
         return null;
      } else {
         HashMap var1 = this.field3825.method601();
         this.field3850 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3850.addAll(var3);
         }

         this.field3851 = this.field3850.iterator();
         return this.method5232();
      }
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I)Lclass39;",
      garbageValue = "-421110655"
   )
   public class39 method5232() {
      return this.field3851 == null?null:(!this.field3851.hasNext()?null:(class39)this.field3851.next());
   }

   static {
      field3815 = class261.field3635;
      field3816 = class261.field3628;
      field3837 = class261.field3629;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "1482781066"
   )
   public void method5240(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3823.method5163()) {
         this.method5198();
         this.method5336();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3831));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3831));
            List var10 = this.field3825.method572(this.field3827 - var8 / 2 - 1, this.field3828 - var9 / 2 - 1, var8 / 2 + this.field3827 + 1, this.field3828 + var9 / 2 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            class69 var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); class14.method76(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new class69();
               var15 = new class47(var13.field548, var13.field547, var13.field550);
               var14.method1133(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3812.contains(var13)) {
                  var14.method1128(class219.field2794);
               } else {
                  var14.method1128(class219.field2799);
               }
            }

            var12 = this.field3812.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new class69();
                  var15 = new class47(var13.field548, var13.field547, var13.field550);
                  var14.method1133(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1128(class219.field2800);
                  class14.method76(var14);
               }
            }

            this.field3812 = var11;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "335486787"
   )
   public void method5250(int var1) {
      this.field3822 = this.method5199(var1);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1531230296"
   )
   public void method5254(int var1) {
      if(var1 >= 1) {
         this.field3844 = var1;
      }

   }

   public RenderOverview() {
      this.field3836 = -1;
      this.field3830 = -1;
      this.field3833 = -1;
      this.field3834 = -1;
      this.field3844 = 3;
      this.field3826 = 50;
      this.field3835 = false;
      this.field3832 = null;
      this.field3839 = -1;
      this.field3838 = -1;
      this.field3841 = -1;
      this.field3842 = -1;
      this.field3843 = new HashSet();
      this.field3821 = new HashSet();
      this.field3845 = new HashSet();
      this.field3846 = new HashSet();
      this.field3847 = false;
      this.field3848 = 0;
      this.field3817 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3812 = new HashSet();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)LWorldMapData;",
      garbageValue = "402500747"
   )
   public WorldMapData method5260() {
      return this.field3852;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-107"
   )
   public void method5283() {
      this.field3826 = 50;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "955609950"
   )
   public int method5284() {
      return this.field3833;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LFont;Ljava/util/HashMap;[LModIcon;I)V",
      garbageValue = "-829554855"
   )
   public void method5298(IndexDataBase var1, Font var2, HashMap var3, ModIcon[] var4) {
      this.field3820 = var4;
      this.field3814 = var1;
      this.field3818 = var2;
      this.field3819 = new HashMap();
      this.field3819.put(class24.field364, var3.get(field3815));
      this.field3819.put(class24.field358, var3.get(field3816));
      this.field3819.put(class24.field359, var3.get(field3837));
      this.field3823 = new class287(var1);
      int var5 = this.field3814.method4146(class40.field564.field566);
      int[] var6 = this.field3814.method4121(var5);
      this.field3824 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3814.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3824.put(var9.method282(), var9);
         if(var9.method281()) {
            this.field3811 = var9;
         }
      }

      this.method5191(this.field3811);
      this.field3829 = null;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1705700341"
   )
   public int method5299() {
      return this.field3852 == null?-1:this.field3827 + this.field3852.method305() * 64;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1755009626"
   )
   public void method5319(int var1) {
      if(var1 >= 1) {
         this.field3826 = var1;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2061338808"
   )
   boolean method5320() {
      return this.field3836 != -1 && this.field3830 != -1;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(ILCoordinates;I)LCoordinates;",
      garbageValue = "1967360528"
   )
   public Coordinates method5321(int var1, Coordinates var2) {
      if(!this.field3823.method5163()) {
         return null;
      } else if(!this.field3825.method608()) {
         return null;
      } else if(!this.field3852.method307(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.field3825.method601();
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
                     return var5.field550;
                  }

                  var8 = (class39)var7.next();
                  int var9 = var8.field550.worldX - var2.worldX;
                  int var10 = var8.field550.worldY - var2.worldY;
                  var11 = var10 * var10 + var9 * var9;
                  if(var11 == 0) {
                     return var8.field550;
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1261315798"
   )
   public int method5325() {
      return 1.0D == (double)this.field3822?25:(1.5D == (double)this.field3822?37:(2.0D == (double)this.field3822?50:(3.0D == (double)this.field3822?75:(4.0D == (double)this.field3822?100:200))));
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-398072213"
   )
   public int method5333() {
      return this.field3834;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "32"
   )
   void method5336() {
      if(this.method5320()) {
         int var1 = this.field3836 - this.field3827;
         int var2 = this.field3830 - this.field3828;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3827 += var1;
         this.field3828 += var2;
         if(this.field3836 == this.field3827 && this.field3830 == this.field3828) {
            this.field3836 = -1;
            this.field3830 = -1;
         }

      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "501510299"
   )
   public void method5339(int var1) {
      this.field3832 = new HashSet();
      this.field3832.add(Integer.valueOf(var1));
      this.field3839 = 0;
      this.field3838 = 0;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1329442843"
   )
   public void method5365(boolean var1) {
      this.field3847 = !var1;
   }
}
