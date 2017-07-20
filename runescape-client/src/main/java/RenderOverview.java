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
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   static final class261 field3802;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   static final class261 field3827;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   static final class261 field3834;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   ModIcon[] field3807;
   @ObfuscatedName("ag")
   boolean field3829;
   @ObfuscatedName("an")
   HashSet field3831;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 826527963
   )
   int field3818;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1432292335
   )
   int field3821;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1241612101
   )
   int field3822;
   @ObfuscatedName("ar")
   HashSet field3805;
   @ObfuscatedName("ad")
   boolean field3803;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -24275123
   )
   int field3804;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1515713375
   )
   int field3828;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   IndexDataBase field3801;
   @ObfuscatedName("aw")
   HashSet field3833;
   @ObfuscatedName("av")
   HashSet field3806;
   @ObfuscatedName("h")
   HashMap field3808;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   class287 field3813;
   @ObfuscatedName("ai")
   Iterator field3838;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -284503309
   )
   int field3816;
   @ObfuscatedName("b")
   float field3819;
   @ObfuscatedName("z")
   float field3809;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lab;"
   )
   WorldMapData field3810;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lab;"
   )
   WorldMapData field3824;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 2124935521
   )
   int field3825;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -952602295
   )
   int field3817;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1248387747
   )
   int field3815;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1708308071
   )
   int field3814;
   @ObfuscatedName("w")
   HashMap field3811;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1716246285
   )
   int field3826;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lab;"
   )
   WorldMapData field3837;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   Font field3823;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   class41 field3812;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1379319479
   )
   int field3830;
   @ObfuscatedName("at")
   HashSet field3832;
   @ObfuscatedName("ax")
   List field3797;
   @ObfuscatedName("ah")
   final int[] field3820;
   @ObfuscatedName("aa")
   HashSet field3839;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1117560281
   )
   int field3835;

   static {
      field3802 = class261.field3602;
      field3827 = class261.field3603;
      field3834 = class261.field3604;
   }

   public RenderOverview() {
      this.field3816 = -1;
      this.field3817 = -1;
      this.field3818 = -1;
      this.field3821 = -1;
      this.field3822 = 3;
      this.field3804 = 50;
      this.field3829 = false;
      this.field3806 = null;
      this.field3826 = -1;
      this.field3830 = -1;
      this.field3828 = -1;
      this.field3825 = -1;
      this.field3805 = new HashSet();
      this.field3831 = new HashSet();
      this.field3832 = new HashSet();
      this.field3833 = new HashSet();
      this.field3803 = false;
      this.field3835 = 0;
      this.field3820 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3839 = new HashSet();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "603905589"
   )
   boolean method5145() {
      return this.field3816 != -1 && this.field3817 != -1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)Lab;",
      garbageValue = "1218033150"
   )
   public WorldMapData method5154(int var1, int var2, int var3) {
      Iterator var4 = this.field3808.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method304(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)F",
      garbageValue = "-35"
   )
   float method5108(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IB)Lab;",
      garbageValue = "8"
   )
   public WorldMapData method5112(int var1) {
      Iterator var2 = this.field3808.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method284() != var1);

      return var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lab;I)V",
      garbageValue = "-361886507"
   )
   void method5093(WorldMapData var1) {
      this.field3810 = var1;
      this.field3812 = new class41(this.field3807, this.field3811);
      this.field3813.method5069(this.field3810.method335());
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1329091301"
   )
   public int method5117() {
      return this.field3810 == null?-1:this.field3814 + this.field3810.method286() * 64;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lab;B)V",
      garbageValue = "70"
   )
   void method5256(WorldMapData var1) {
      if(this.field3810 == null || var1 != this.field3810) {
         this.method5093(var1);
         this.method5103(-1, -1, -1);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2006757139"
   )
   void method5171() {
      if(this.field3809 < this.field3819) {
         this.field3809 = Math.min(this.field3819, this.field3809 + this.field3809 / 30.0F);
      }

      if(this.field3809 > this.field3819) {
         this.field3809 = Math.max(this.field3819, this.field3809 - this.field3809 / 30.0F);
      }

   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1510309348"
   )
   void method5252() {
      this.field3833.clear();
      this.field3833.addAll(this.field3805);
      this.field3833.addAll(this.field3832);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-56"
   )
   void method5103(int var1, int var2, int var3) {
      if(this.field3810 != null) {
         int[] var4 = this.field3810.method277(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3810.method277(this.field3810.method291(), this.field3810.method290(), this.field3810.method273());
         }

         this.field3814 = var4[0] - this.field3810.method286() * 64;
         this.field3815 = var4[1] - this.field3810.method289() * 64;
         this.field3816 = -1;
         this.field3817 = -1;
         this.field3809 = this.method5108(this.field3810.method285());
         this.field3819 = this.field3809;
         this.field3797 = null;
         this.field3838 = null;
         this.field3812.method532();
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1346562147"
   )
   public int method5179() {
      return this.field3810 == null?-1:this.field3815 + this.field3810.method289() * 64;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-383642176"
   )
   void method5146() {
      if(this.method5145()) {
         int var1 = this.field3816 - this.field3814;
         int var2 = this.field3817 - this.field3815;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3814 += var1;
         this.field3815 += var2;
         if(this.field3816 == this.field3814 && this.field3817 == this.field3815) {
            this.field3816 = -1;
            this.field3817 = -1;
         }

      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1864690397"
   )
   public void method5113(int var1, int var2) {
      if(this.field3810 != null && this.field3810.method276(var1, var2)) {
         this.field3816 = var1 - this.field3810.method286() * 64;
         this.field3817 = var2 - this.field3810.method289() * 64;
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "28"
   )
   public void method5208(int var1, int var2) {
      if(this.field3810 != null) {
         this.field3814 = var1 - this.field3810.method286() * 64;
         this.field3815 = var2 - this.field3810.method289() * 64;
         this.field3816 = -1;
         this.field3817 = -1;
      }
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)Lad;",
      garbageValue = "-1143316059"
   )
   public class39 method5141() {
      return this.field3838 == null?null:(!this.field3838.hasNext()?null:(class39)this.field3838.next());
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-2069010625"
   )
   void method5134(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var1 + var3 / 2;
      int var8 = var2 + var4 / 2 - 18 - var6;
      Rasterizer2D.method4828(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.method4828(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3823.method4643("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1800085888"
   )
   public int method5089() {
      return this.field3801.method4028(this.field3824.method335(), class40.field545.field549)?100:this.field3801.method4031(this.field3824.method335());
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lip;Ljt;Ljava/util/HashMap;[Ljx;I)V",
      garbageValue = "-1209745074"
   )
   public void method5088(IndexDataBase var1, Font var2, HashMap var3, ModIcon[] var4) {
      this.field3807 = var4;
      this.field3801 = var1;
      this.field3823 = var2;
      this.field3811 = new HashMap();
      this.field3811.put(class24.field351, var3.get(field3802));
      this.field3811.put(class24.field342, var3.get(field3827));
      this.field3811.put(class24.field343, var3.get(field3834));
      this.field3813 = new class287(var1);
      int var5 = this.field3801.getFile(class40.field540.field549);
      int[] var6 = this.field3801.getChilds(var5);
      this.field3808 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3801.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3808.put(var9.method335(), var9);
         if(var9.method281()) {
            this.field3824 = var9;
         }
      }

      this.method5256(this.field3824);
      this.field3837 = null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1509398226"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.method4828(var1, var2, var3, var4, -16777216);
      int var7 = this.field3813.method5072();
      if(var7 < 100) {
         this.method5134(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3812.method539()) {
            this.field3812.method531(this.field3801, this.field3810.method335(), Client.isMembers);
            if(!this.field3812.method539()) {
               return;
            }
         }

         if(this.field3806 != null) {
            ++this.field3830;
            if(this.field3830 % this.field3804 == 0) {
               this.field3830 = 0;
               ++this.field3826;
            }

            if(this.field3826 >= this.field3822 && !this.field3829) {
               this.field3806 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3809));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3809));
         this.field3812.method533(this.field3814 - var8 / 2, this.field3815 - var9 / 2, this.field3814 + var8 / 2, this.field3815 + var9 / 2, var1, var2, var3 + var1, var2 + var4);
         if(!this.field3803) {
            boolean var10 = false;
            if(var5 - this.field3835 > 100) {
               this.field3835 = var5;
               var10 = true;
            }

            this.field3812.method554(this.field3814 - var8 / 2, this.field3815 - var9 / 2, this.field3814 + var8 / 2, this.field3815 + var9 / 2, var1, var2, var3 + var1, var2 + var4, this.field3833, this.field3806, this.field3830, this.field3804, var10);
         }

         this.field3818 = var8;
         this.field3821 = var9;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-11"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3813.method5077()) {
         if(!this.field3812.method539()) {
            this.field3812.method531(this.field3801, this.field3810.method335(), Client.isMembers);
            if(!this.field3812.method539()) {
               return;
            }
         }

         this.field3812.method557(var1, var2, var3, var4, this.field3806, this.field3830, this.field3804);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-717029805"
   )
   public void method5240(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5154(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3824;
      }

      boolean var6 = false;
      if(var5 != this.field3837 || var4) {
         this.field3837 = var5;
         this.method5256(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5103(var1, var2, var3);
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-897129920"
   )
   public void method5136() {
      this.field3813.method5070();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "-2007174725"
   )
   public void method5090(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3813.method5077()) {
         this.method5171();
         this.method5146();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3809));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3809));
            List var10 = this.field3812.method537(this.field3814 - var8 / 2 - 1, this.field3815 - var9 / 2 - 1, this.field3814 + var8 / 2 + 1, this.field3815 + var9 / 2 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            ScriptEvent var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); Ignore.method1054(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new class47(var13.field531, var13.field532, var13.field537);
               var14.method1047(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3839.contains(var13)) {
                  var14.method1048(class219.field2773);
               } else {
                  var14.method1048(class219.field2770);
               }
            }

            var12 = this.field3839.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new class47(var13.field531, var13.field532, var13.field537);
                  var14.method1047(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1048(class219.field2765);
                  Ignore.method1054(var14);
               }
            }

            this.field3839 = var11;
         }
      }
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-15"
   )
   public void method5137(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3813.method5077()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3809));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3809));
         List var9 = this.field3812.method537(this.field3814 - var7 / 2 - 1, this.field3815 - var8 / 2 - 1, var7 / 2 + this.field3814 + 1, this.field3815 + var8 / 2 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               Area var12 = Area.field3265[var11.field531];
               var13 = false;

               for(int var14 = this.field3820.length - 1; var14 >= 0; --var14) {
                  if(var12.field3270[var14] != null) {
                     class261.addMenuEntry(var12.field3270[var14], var12.field3271, this.field3820[var14], var11.field531, var11.field532.method3866(), var11.field537.method3866());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "938086888"
   )
   public void method5097(int var1) {
      WorldMapData var2 = this.method5112(var1);
      if(var2 != null) {
         this.method5256(var2);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "60"
   )
   public void method5106(int var1) {
      this.field3819 = this.method5108(var1);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-98"
   )
   public int method5109() {
      return (double)this.field3819 == 1.0D?25:(1.5D == (double)this.field3819?37:((double)this.field3819 == 2.0D?50:(3.0D == (double)this.field3819?75:((double)this.field3819 == 4.0D?100:200))));
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "102992109"
   )
   public void method5177(int var1, int var2, boolean var3) {
      if(this.field3828 == -1) {
         this.field3828 = var1;
      }

      if(this.field3825 == -1) {
         this.field3825 = var2;
      }

      int var4 = var1 - this.field3828;
      int var5 = var2 - this.field3825;
      this.field3828 = var1;
      this.field3825 = var2;
      if(var3 && !this.method5145()) {
         this.field3814 -= (int)((float)var4 / this.field3819);
         this.field3815 += (int)((float)var5 / this.field3819);
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1982265855"
   )
   public boolean method5107() {
      return this.field3813.method5077();
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)Lhs;",
      garbageValue = "-357257454"
   )
   public Coordinates method5110() {
      return this.field3810 == null?null:this.field3810.method278(this.method5117(), this.method5179());
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1971657240"
   )
   public void method5115(int var1, int var2, int var3) {
      if(this.field3810 != null) {
         int[] var4 = this.field3810.method277(var1, var2, var3);
         if(var4 != null) {
            this.method5113(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "3224609"
   )
   public void method5116(int var1, int var2, int var3) {
      if(this.field3810 != null) {
         int[] var4 = this.field3810.method277(var1, var2, var3);
         if(var4 != null) {
            this.method5208(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-18"
   )
   public int method5098() {
      return this.field3810 == null?-1:this.field3810.method284();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Lab;",
      garbageValue = "-2027283739"
   )
   public WorldMapData method5099() {
      return this.field3810;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-581886111"
   )
   public void method5221() {
      this.field3822 = 3;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-23"
   )
   public void method5125() {
      this.field3804 = 50;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-195514828"
   )
   public int method5120() {
      return this.field3818;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1410703674"
   )
   public void method5114(int var1) {
      if(var1 >= 1) {
         this.field3822 = var1;
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "39934048"
   )
   public void method5124(int var1) {
      if(var1 >= 1) {
         this.field3804 = var1;
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1475113267"
   )
   public void method5142() {
      this.field3806 = null;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "795007185"
   )
   public void method5184(int var1) {
      this.field3806 = new HashSet();
      this.field3806.add(Integer.valueOf(var1));
      this.field3826 = 0;
      this.field3830 = 0;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1862993084"
   )
   public void method5126(boolean var1) {
      this.field3829 = var1;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "8"
   )
   public void method5128(int var1) {
      this.field3806 = new HashSet();
      this.field3826 = 0;
      this.field3830 = 0;

      for(int var2 = 0; var2 < Area.field3265.length; ++var2) {
         if(Area.field3265[var2] != null && Area.field3265[var2].field3281 == var1) {
            this.field3806.add(Integer.valueOf(Area.field3265[var2].field3275));
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-991866821"
   )
   public void method5130(boolean var1) {
      this.field3803 = !var1;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-96"
   )
   public int method5121() {
      return this.field3821;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I)Lad;",
      garbageValue = "2072007971"
   )
   public class39 method5140() {
      if(!this.field3813.method5077()) {
         return null;
      } else if(!this.field3812.method539()) {
         return null;
      } else {
         HashMap var1 = this.field3812.method540();
         this.field3797 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3797.addAll(var3);
         }

         this.field3838 = this.field3797.iterator();
         return this.method5141();
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1952869906"
   )
   public boolean method5095() {
      return !this.field3803;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "217895844"
   )
   public void method5131(int var1, boolean var2) {
      if(!var2) {
         this.field3805.add(Integer.valueOf(var1));
      } else {
         this.field3805.remove(Integer.valueOf(var1));
      }

      this.method5252();
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "-124"
   )
   public void method5132(int var1, boolean var2) {
      if(!var2) {
         this.field3831.add(Integer.valueOf(var1));
      } else {
         this.field3831.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.field3265.length; ++var3) {
         if(Area.field3265[var3] != null && Area.field3265[var3].field3281 == var1) {
            int var4 = Area.field3265[var3].field3275;
            if(!var2) {
               this.field3832.add(Integer.valueOf(var4));
            } else {
               this.field3832.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5252();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lab;Lhs;Lhs;ZB)V",
      garbageValue = "2"
   )
   public void method5102(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.field3810 == null || var1 != this.field3810) {
            this.method5093(var1);
         }

         if(!var4 && this.field3810.method304(var2.plane, var2.worldX, var2.worldY)) {
            this.method5103(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5103(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "330635737"
   )
   public boolean method5149(int var1) {
      return !this.field3805.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "18"
   )
   public boolean method5135(int var1) {
      return !this.field3831.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(ILhs;B)Lhs;",
      garbageValue = "2"
   )
   public Coordinates method5233(int var1, Coordinates var2) {
      if(!this.field3813.method5077()) {
         return null;
      } else if(!this.field3812.method539()) {
         return null;
      } else if(!this.field3810.method276(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.field3812.method540();
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
                     return var5.field537;
                  }

                  var8 = (class39)var7.next();
                  int var9 = var8.field537.worldX - var2.worldX;
                  int var10 = var8.field537.worldY - var2.worldY;
                  var11 = var10 * var10 + var9 * var9;
                  if(var11 == 0) {
                     return var8.field537;
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

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(IILhs;Lhs;I)V",
      garbageValue = "1555793519"
   )
   public void method5139(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1047(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1048(class219.field2762);
         break;
      case 1009:
         var5.method1048(class219.field2760);
         break;
      case 1010:
         var5.method1048(class219.field2761);
         break;
      case 1011:
         var5.method1048(class219.field2766);
         break;
      case 1012:
         var5.method1048(class219.field2763);
      }

      Ignore.method1054(var5);
   }
}
