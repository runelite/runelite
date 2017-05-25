import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kf")
public class class288 {
   @ObfuscatedName("av")
   HashSet field3795;
   @ObfuscatedName("ap")
   List field3800;
   @ObfuscatedName("t")
   IndexDataBase field3801;
   @ObfuscatedName("p")
   static final class261 field3802;
   @ObfuscatedName("l")
   static final class261 field3803;
   @ObfuscatedName("a")
   static final class261 field3804;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 602806889
   )
   int field3805;
   @ObfuscatedName("ag")
   HashSet field3806;
   @ObfuscatedName("b")
   ModIcon[] field3807;
   @ObfuscatedName("x")
   HashMap field3808;
   @ObfuscatedName("o")
   class32 field3809;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1029164747
   )
   int field3810;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 2024358293
   )
   int field3811;
   @ObfuscatedName("d")
   class41 field3812;
   @ObfuscatedName("e")
   class287 field3813;
   @ObfuscatedName("m")
   class32 field3814;
   @ObfuscatedName("k")
   Font field3815;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1350197865
   )
   int field3816;
   @ObfuscatedName("aw")
   HashSet field3817;
   @ObfuscatedName("f")
   float field3818;
   @ObfuscatedName("c")
   float field3819;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1549176835
   )
   int field3820;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -35357649
   )
   int field3821;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -436404745
   )
   int field3823;
   @ObfuscatedName("ac")
   boolean field3824;
   @ObfuscatedName("aq")
   HashSet field3825;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1681766761
   )
   int field3826;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -2082885625
   )
   int field3827;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1749992983
   )
   int field3828;
   @ObfuscatedName("j")
   class32 field3829;
   @ObfuscatedName("ae")
   HashSet field3831;
   @ObfuscatedName("ar")
   HashSet field3832;
   @ObfuscatedName("r")
   HashMap field3833;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 200787137
   )
   int field3834;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -2053239821
   )
   int field3835;
   @ObfuscatedName("am")
   final int[] field3836;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1301791303
   )
   int field3837;
   @ObfuscatedName("as")
   Iterator field3838;
   @ObfuscatedName("at")
   boolean field3839;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LFont;Ljava/util/HashMap;[LModIcon;I)V",
      garbageValue = "810933484"
   )
   public void method5253(IndexDataBase var1, Font var2, HashMap var3, ModIcon[] var4) {
      this.field3807 = var4;
      this.field3801 = var1;
      this.field3815 = var2;
      this.field3833 = new HashMap();
      this.field3833.put(class24.field367, var3.get(field3802));
      this.field3833.put(class24.field357, var3.get(field3803));
      this.field3833.put(class24.field358, var3.get(field3804));
      this.field3813 = new class287(var1);
      int var5 = this.field3801.method4189(class40.field538.field540);
      int[] var6 = this.field3801.method4183(var5);
      this.field3808 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3801.getConfigData(var5, var6[var7]));
         class32 var9 = new class32();
         var9.method271(var8, var6[var7]);
         this.field3808.put(var9.method295(), var9);
         if(var9.method330()) {
            this.field3809 = var9;
         }
      }

      this.method5266(this.field3809);
      this.field3814 = null;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2050436963"
   )
   public int method5254() {
      return this.field3829 == null?-1:this.field3837 + this.field3829.method286() * 64;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1807977885"
   )
   public int method5255() {
      return this.field3801.method4193(this.field3809.method295(), class40.field534.field540)?100:this.field3801.method4196(this.field3809.method295());
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "-903815555"
   )
   public void method5256(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3813.method5243()) {
         this.method5274();
         this.method5425();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3818));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3818));
            List var10 = this.field3812.method563(this.field3834 - var8 / 2 - 1, this.field3837 - var9 / 2 - 1, this.field3834 + var8 / 2 + 1, var9 / 2 + this.field3837 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            class69 var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); GroundObject.method2522(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new class69();
               var15 = new class47(var13.field526, var13.field523, var13.field527);
               var14.method1110(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3817.contains(var13)) {
                  var14.method1109(class219.field2789);
               } else {
                  var14.method1109(class219.field2787);
               }
            }

            var12 = this.field3817.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new class69();
                  var15 = new class47(var13.field526, var13.field523, var13.field527);
                  var14.method1110(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1109(class219.field2788);
                  GroundObject.method2522(var14);
               }
            }

            this.field3817 = var11;
         }
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "43"
   )
   public void method5257() {
      this.field3805 = 3;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2131910438"
   )
   boolean method5260() {
      return this.field3816 != -1 && this.field3810 != -1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-2091651263"
   )
   public void method5262(int var1, int var2, int var3, boolean var4) {
      class32 var5 = this.method5307(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3809;
      }

      boolean var6 = false;
      if(this.field3814 != var5 || var4) {
         this.field3814 = var5;
         this.method5266(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5326(var1, var2, var3);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Lclass32;",
      garbageValue = "-825274503"
   )
   public class32 method5265() {
      return this.field3829;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass32;I)V",
      garbageValue = "-939890925"
   )
   void method5266(class32 var1) {
      if(this.field3829 == null || this.field3829 != var1) {
         this.method5267(var1);
         this.method5326(-1, -1, -1);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass32;I)V",
      garbageValue = "638898869"
   )
   void method5267(class32 var1) {
      this.field3829 = var1;
      this.field3812 = new class41(this.field3807, this.field3833);
      this.field3813.method5241(this.field3829.method295());
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass32;Lclass212;Lclass212;ZB)V",
      garbageValue = "33"
   )
   public void method5268(class32 var1, class212 var2, class212 var3, boolean var4) {
      if(var1 != null) {
         if(this.field3829 == null || var1 != this.field3829) {
            this.method5267(var1);
         }

         if(!var4 && this.field3829.method270(var2.field2603, var2.field2600, var2.field2601)) {
            this.method5326(var2.field2603, var2.field2600, var2.field2601);
         } else {
            this.method5326(var3.field2603, var3.field2600, var3.field2601);
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "0"
   )
   public void method5270(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.method5000(var6);
      Rasterizer2D.method4998(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.method5042(var1, var2, var3, var4, -16777216);
      int var7 = this.field3813.method5244();
      if(var7 < 100) {
         this.method5408(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3812.method586()) {
            System.out.println("renderOverview extractWorldmap");
            this.field3812.method561(this.field3801, this.field3829.method295(), Client.isMembers);
            System.out.println("done");
            if(!this.field3812.method586()) {
               return;
            }
         }

         if(this.field3825 != null) {
            ++this.field3827;
            if(this.field3827 % this.field3811 == 0) {
               this.field3827 = 0;
               ++this.field3826;
            }

            if(this.field3826 >= this.field3805 && !this.field3824) {
               this.field3825 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3818));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3818));
         this.field3812.method572(this.field3834 - var8 / 2, this.field3837 - var9 / 2, this.field3834 + var8 / 2, var9 / 2 + this.field3837, var1, var2, var1 + var3, var2 + var4);
         if(!this.field3839) {
            boolean var10 = false;
            if(var5 - this.field3835 > 100) {
               this.field3835 = var5;
               var10 = true;
            }

            this.field3812.method560(this.field3834 - var8 / 2, this.field3837 - var9 / 2, this.field3834 + var8 / 2, var9 / 2 + this.field3837, var1, var2, var1 + var3, var2 + var4, this.field3806, this.field3825, this.field3827, this.field3811, var10);
         }

         this.field3820 = var8;
         this.field3821 = var9;
         Rasterizer2D.method5001(var6);
      }
   }

   public class288() {
      this.field3816 = -1;
      this.field3810 = -1;
      this.field3820 = -1;
      this.field3821 = -1;
      this.field3805 = 3;
      this.field3811 = 50;
      this.field3824 = false;
      this.field3825 = null;
      this.field3826 = -1;
      this.field3827 = -1;
      this.field3823 = -1;
      this.field3828 = -1;
      this.field3795 = new HashSet();
      this.field3831 = new HashSet();
      this.field3832 = new HashSet();
      this.field3806 = new HashSet();
      this.field3839 = false;
      this.field3835 = 0;
      this.field3836 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3817 = new HashSet();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2144189947"
   )
   public void method5271(int var1) {
      this.field3819 = this.method5370(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method5274() {
      if(this.field3818 < this.field3819) {
         this.field3818 = Math.min(this.field3819, this.field3818 / 30.0F + this.field3818);
      }

      if(this.field3818 > this.field3819) {
         this.field3818 = Math.max(this.field3819, this.field3818 - this.field3818 / 30.0F);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-167479905"
   )
   public void method5275() {
      this.field3813.method5252();
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-34"
   )
   public boolean method5276() {
      return this.field3813.method5243();
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1466253516"
   )
   public void method5278(int var1, int var2) {
      if(this.field3829 != null && this.field3829.method275(var1, var2)) {
         this.field3816 = var1 - this.field3829.method337() * 64;
         this.field3810 = var2 - this.field3829.method286() * 64;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2097860151"
   )
   public void method5279(int var1, int var2) {
      if(this.field3829 != null) {
         this.field3834 = var1 - this.field3829.method337() * 64;
         this.field3837 = var2 - this.field3829.method286() * 64;
         this.field3816 = -1;
         this.field3810 = -1;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-709205915"
   )
   public void method5280(int var1, int var2, int var3) {
      if(this.field3829 != null) {
         int[] var4 = this.field3829.method280(var1, var2, var3);
         if(var4 != null) {
            this.method5278(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-225190182"
   )
   public void method5281(int var1, int var2, int var3) {
      if(this.field3829 != null) {
         int[] var4 = this.field3829.method280(var1, var2, var3);
         if(var4 != null) {
            this.method5279(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1114568956"
   )
   public void method5282(int var1) {
      this.field3825 = new HashSet();
      this.field3826 = 0;
      this.field3827 = 0;

      for(int var2 = 0; var2 < class242.field3276.length; ++var2) {
         if(class242.field3276[var2] != null && var1 == class242.field3276[var2].field3296) {
            this.field3825.add(Integer.valueOf(class242.field3276[var2].field3279));
         }
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)Lclass212;",
      garbageValue = "-1365789298"
   )
   public class212 method5284() {
      return this.field3829 == null?null:this.field3829.method341(this.method5363(), this.method5254());
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "615642178"
   )
   public int method5285() {
      return this.field3820;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method5286() {
      return this.field3821;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1983634449"
   )
   public void method5289(int var1) {
      if(var1 >= 1) {
         this.field3811 = var1;
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1522580377"
   )
   public void method5291(boolean var1) {
      this.field3824 = var1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IB)Lclass32;",
      garbageValue = "-1"
   )
   public class32 method5292(int var1) {
      Iterator var2 = this.field3808.values().iterator();

      class32 var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (class32)var2.next();
      } while(var3.method318() != var1);

      return var3;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2136085772"
   )
   public void method5293(int var1) {
      if(var1 >= 1) {
         this.field3805 = var1;
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2096452020"
   )
   public void method5294() {
      this.field3825 = null;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2115389772"
   )
   public void method5295(boolean var1) {
      this.field3839 = !var1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-810846201"
   )
   public void method5296(int var1, boolean var2) {
      if(!var2) {
         this.field3795.add(Integer.valueOf(var1));
      } else {
         this.field3795.remove(Integer.valueOf(var1));
      }

      this.method5301();
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1251485453"
   )
   public boolean method5298() {
      return !this.field3839;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1862945203"
   )
   public boolean method5299(int var1) {
      return !this.field3795.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1383038974"
   )
   public boolean method5300(int var1) {
      return !this.field3831.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2112133076"
   )
   void method5301() {
      this.field3806.clear();
      this.field3806.addAll(this.field3795);
      this.field3806.addAll(this.field3832);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IILclass212;Lclass212;I)V",
      garbageValue = "-1643003467"
   )
   public void method5304(int var1, int var2, class212 var3, class212 var4) {
      class69 var5 = new class69();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1110(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1109(class219.field2791);
         break;
      case 1009:
         var5.method1109(class219.field2783);
         break;
      case 1010:
         var5.method1109(class219.field2782);
         break;
      case 1011:
         var5.method1109(class219.field2785);
         break;
      case 1012:
         var5.method1109(class219.field2786);
      }

      GroundObject.method2522(var5);
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(B)Lclass39;",
      garbageValue = "1"
   )
   public class39 method5305() {
      if(!this.field3813.method5243()) {
         return null;
      } else if(!this.field3812.method586()) {
         return null;
      } else {
         HashMap var1 = this.field3812.method566();
         this.field3800 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3800.addAll(var3);
         }

         this.field3838 = this.field3800.iterator();
         return this.method5306();
      }
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)Lclass39;",
      garbageValue = "1048538459"
   )
   public class39 method5306() {
      return this.field3838 == null?null:(!this.field3838.hasNext()?null:(class39)this.field3838.next());
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIB)Lclass32;",
      garbageValue = "-46"
   )
   public class32 method5307(int var1, int var2, int var3) {
      Iterator var4 = this.field3808.values().iterator();

      class32 var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (class32)var4.next();
      } while(!var5.method270(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "630664604"
   )
   void method5326(int var1, int var2, int var3) {
      if(this.field3829 != null) {
         int[] var4 = this.field3829.method280(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3829.method280(this.field3829.method289(), this.field3829.method293(), this.field3829.method273());
         }

         this.field3834 = var4[0] - this.field3829.method337() * 64;
         this.field3837 = var4[1] - this.field3829.method286() * 64;
         this.field3816 = -1;
         this.field3810 = -1;
         this.field3818 = this.method5370(this.field3829.method283());
         this.field3819 = this.field3818;
         this.field3800 = null;
         this.field3838 = null;
         this.field3812.method558();
      }
   }

   static {
      field3802 = class261.field3619;
      field3803 = class261.field3618;
      field3804 = class261.field3622;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "28"
   )
   public void method5342(int var1) {
      this.field3825 = new HashSet();
      this.field3825.add(Integer.valueOf(var1));
      this.field3826 = 0;
      this.field3827 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "109"
   )
   public void method5359(int var1, int var2, boolean var3) {
      if(this.field3823 == -1) {
         this.field3823 = var1;
      }

      if(this.field3828 == -1) {
         this.field3828 = var2;
      }

      int var4 = var1 - this.field3823;
      int var5 = var2 - this.field3828;
      this.field3823 = var1;
      this.field3828 = var2;
      if(var3 && !this.method5260()) {
         this.field3834 -= (int)((float)var4 / this.field3819);
         this.field3837 += (int)((float)var5 / this.field3819);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   public void method5361(int var1) {
      class32 var2 = this.method5292(var1);
      if(var2 != null) {
         this.method5266(var2);
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1818775806"
   )
   public int method5363() {
      return this.field3829 == null?-1:this.field3834 + this.field3829.method337() * 64;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)F",
      garbageValue = "67"
   )
   float method5370(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method5376() {
      return (double)this.field3819 == 1.0D?25:((double)this.field3819 == 1.5D?37:((double)this.field3819 == 2.0D?50:(3.0D == (double)this.field3819?75:(4.0D == (double)this.field3819?100:200))));
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "10740746"
   )
   public void method5381(int var1, boolean var2) {
      if(!var2) {
         this.field3831.add(Integer.valueOf(var1));
      } else {
         this.field3831.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < class242.field3276.length; ++var3) {
         if(class242.field3276[var3] != null && class242.field3276[var3].field3296 == var1) {
            int var4 = class242.field3276[var3].field3279;
            if(!var2) {
               this.field3832.add(Integer.valueOf(var4));
            } else {
               this.field3832.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5301();
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1058416153"
   )
   public void method5397(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3813.method5243()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3818));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3818));
         List var9 = this.field3812.method563(this.field3834 - var7 / 2 - 1, this.field3837 - var8 / 2 - 1, var7 / 2 + this.field3834 + 1, this.field3837 + var8 / 2 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               class242 var12 = class242.field3276[var11.field526];
               var13 = false;

               for(int var14 = this.field3836.length - 1; var14 >= 0; --var14) {
                  if(var12.field3285[var14] != null) {
                     class176.addMenuEntry(var12.field3285[var14], var12.field3286, this.field3836[var14], var11.field526, var11.field523.method3991(), var11.field527.method3991());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "-18"
   )
   void method5408(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var1 + var3 / 2;
      int var8 = var2 + var4 / 2 - 18 - var6;
      Rasterizer2D.method5042(var1, var2, var3, var4, -16777216);
      Rasterizer2D.method5012(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.method5042(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3815.method4817("Loading...", var7, var6 + var8, -1, -1);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(ILclass212;S)Lclass212;",
      garbageValue = "14287"
   )
   public class212 method5416(int var1, class212 var2) {
      if(!this.field3813.method5243()) {
         return null;
      } else if(!this.field3812.method586()) {
         return null;
      } else if(!this.field3829.method275(var2.field2600, var2.field2601)) {
         return null;
      } else {
         HashMap var3 = this.field3812.method566();
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
                     return var5.field527;
                  }

                  var8 = (class39)var7.next();
                  int var9 = var8.field527.field2600 - var2.field2600;
                  int var10 = var8.field527.field2601 - var2.field2601;
                  var11 = var9 * var9 + var10 * var10;
                  if(var11 == 0) {
                     return var8.field527;
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-17675"
   )
   void method5425() {
      if(this.method5260()) {
         int var1 = this.field3816 - this.field3834;
         int var2 = this.field3810 - this.field3837;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3834 += var1;
         this.field3837 += var2;
         if(this.field3816 == this.field3834 && this.field3837 == this.field3810) {
            this.field3816 = -1;
            this.field3810 = -1;
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-755406857"
   )
   public int method5427() {
      return this.field3829 == null?-1:this.field3829.method318();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1288932687"
   )
   public void method5429() {
      this.field3811 = 50;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-4"
   )
   public void method5436(int var1, int var2, int var3, int var4) {
      if(this.field3813.method5243()) {
         if(!this.field3812.method586()) {
            System.out.println("renderOverview extractData");
            this.field3812.method561(this.field3801, this.field3829.method295(), Client.isMembers);
            System.out.println("done");
            if(!this.field3812.method586()) {
               return;
            }
         }

         this.field3812.method562(var1, var2, var3, var4, this.field3825, this.field3827, this.field3811);
      }
   }
}
