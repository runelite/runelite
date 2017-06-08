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

@ObfuscatedName("kt")
@Implements("RenderOverview")
public class RenderOverview {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -770954253
   )
   int field3803;
   @ObfuscatedName("am")
   boolean field3804;
   @ObfuscatedName("c")
   IndexDataBase field3808;
   @ObfuscatedName("d")
   float field3809;
   @ObfuscatedName("h")
   static final class261 field3810;
   @ObfuscatedName("g")
   static final class261 field3811;
   @ObfuscatedName("e")
   Font field3812;
   @ObfuscatedName("ak")
   HashSet field3813;
   @ObfuscatedName("x")
   ModIcon[] field3814;
   @ObfuscatedName("a")
   HashMap field3815;
   @ObfuscatedName("y")
   WorldMapData field3816;
   @ObfuscatedName("r")
   WorldMapData field3817;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 564241045
   )
   int field3818;
   @ObfuscatedName("s")
   class41 field3819;
   @ObfuscatedName("v")
   class287 field3820;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1324022523
   )
   int field3821;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1986405843
   )
   int field3822;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1990824253
   )
   int field3823;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1568459543
   )
   int field3824;
   @ObfuscatedName("k")
   float field3825;
   @ObfuscatedName("aw")
   HashSet field3826;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 65832655
   )
   int field3827;
   @ObfuscatedName("z")
   static final class261 field3828;
   @ObfuscatedName("af")
   Iterator field3829;
   @ObfuscatedName("b")
   WorldMapData field3831;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -62192321
   )
   int field3832;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -2025921691
   )
   int field3833;
   @ObfuscatedName("aa")
   boolean field3834;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -468957185
   )
   int field3835;
   @ObfuscatedName("o")
   HashMap field3837;
   @ObfuscatedName("as")
   HashSet field3838;
   @ObfuscatedName("ah")
   HashSet field3839;
   @ObfuscatedName("ab")
   HashSet field3840;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1713229605
   )
   int field3841;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -458033347
   )
   int field3842;
   @ObfuscatedName("av")
   final int[] field3843;
   @ObfuscatedName("aq")
   List field3844;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1385228069
   )
   int field3845;
   @ObfuscatedName("ag")
   HashSet field3846;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LFont;Ljava/util/HashMap;[LModIcon;I)V",
      garbageValue = "40540765"
   )
   public void method5218(IndexDataBase var1, Font var2, HashMap var3, ModIcon[] var4) {
      this.field3814 = var4;
      this.field3808 = var1;
      this.field3812 = var2;
      this.field3837 = new HashMap();
      this.field3837.put(class24.field366, var3.get(field3828));
      this.field3837.put(class24.field365, var3.get(field3810));
      this.field3837.put(class24.field372, var3.get(field3811));
      this.field3820 = new class287(var1);
      int var5 = this.field3808.method4141(class40.field540.field543);
      int[] var6 = this.field3808.method4156(var5);
      this.field3815 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3808.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3815.put(var9.method297(), var9);
         if(var9.method356()) {
            this.field3816 = var9;
         }
      }

      this.method5230(this.field3816);
      this.field3831 = null;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1071561576"
   )
   public void method5219(int var1) {
      if(var1 >= 1) {
         this.field3821 = var1;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "152651304"
   )
   public void method5221(int var1) {
      this.field3809 = this.method5238(var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)LWorldMapData;",
      garbageValue = "-60"
   )
   public WorldMapData method5223() {
      return this.field3817;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)LWorldMapData;",
      garbageValue = "-1009070895"
   )
   public WorldMapData method5225(int var1, int var2, int var3) {
      Iterator var4 = this.field3815.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method291(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "1660048958"
   )
   public void method5226(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5225(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3816;
      }

      boolean var6 = false;
      if(var5 != this.field3831 || var4) {
         this.field3831 = var5;
         this.method5230(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5304(var1, var2, var3);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1270859222"
   )
   public void method5227(int var1) {
      WorldMapData var2 = this.method5272(var1);
      if(var2 != null) {
         this.method5230(var2);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1076318138"
   )
   public int method5228() {
      return this.field3817 == null?-1:this.field3817.method296();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;B)V",
      garbageValue = "33"
   )
   void method5230(WorldMapData var1) {
      if(this.field3817 == null || this.field3817 != var1) {
         this.method5231(var1);
         this.method5304(-1, -1, -1);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;B)V",
      garbageValue = "-85"
   )
   void method5231(WorldMapData var1) {
      this.field3817 = var1;
      this.field3819 = new class41(this.field3814, this.field3837);
      this.field3820.method5207(this.field3817.method297());
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;LCoordinates;LCoordinates;ZI)V",
      garbageValue = "388169576"
   )
   public void method5232(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.field3817 == null || var1 != this.field3817) {
            this.method5231(var1);
         }

         if(!var4 && this.field3817.method291(var2.plane, var2.worldX, var2.worldY)) {
            this.method5304(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5304(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)F",
      garbageValue = "-1290922235"
   )
   float method5238(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-590896175"
   )
   public int method5239() {
      return (double)this.field3809 == 1.0D?25:((double)this.field3809 == 1.5D?37:((double)this.field3809 == 2.0D?50:(3.0D == (double)this.field3809?75:(4.0D == (double)this.field3809?100:200))));
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-105"
   )
   public void method5240() {
      this.field3820.method5206();
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-824505925"
   )
   public boolean method5241() {
      return this.field3820.method5211();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-109"
   )
   public void method5243(int var1, int var2) {
      if(this.field3817 != null && this.field3817.method292(var1, var2)) {
         this.field3823 = var1 - this.field3817.method302() * 64;
         this.field3824 = var2 - this.field3817.method330() * 64;
      }
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IILCoordinates;LCoordinates;I)V",
      garbageValue = "149650111"
   )
   public void method5244(int var1, int var2, Coordinates var3, Coordinates var4) {
      class69 var5 = new class69();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1070(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1071(class219.field2789);
         break;
      case 1009:
         var5.method1071(class219.field2790);
         break;
      case 1010:
         var5.method1071(class219.field2797);
         break;
      case 1011:
         var5.method1071(class219.field2791);
         break;
      case 1012:
         var5.method1071(class219.field2792);
      }

      class227.method4101(var5);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "512197153"
   )
   public void method5245(int var1, int var2, int var3) {
      if(this.field3817 != null) {
         int[] var4 = this.field3817.method336(var1, var2, var3);
         if(var4 != null) {
            this.method5243(var4[0], var4[1]);
         }

      }
   }

   static {
      field3828 = class261.field3631;
      field3810 = class261.field3630;
      field3811 = class261.field3634;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1638350540"
   )
   public int method5246() {
      return this.field3817 == null?-1:this.field3803 + this.field3817.method302() * 64;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1496032017"
   )
   public int method5247() {
      return this.field3817 == null?-1:this.field3822 + this.field3817.method330() * 64;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)LCoordinates;",
      garbageValue = "212591558"
   )
   public Coordinates method5248() {
      return this.field3817 == null?null:this.field3817.method294(this.method5246(), this.method5247());
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-8"
   )
   public int method5249() {
      return this.field3827;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2147262160"
   )
   public int method5250() {
      return this.field3845;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1960600829"
   )
   public void method5251(int var1) {
      if(var1 >= 1) {
         this.field3832 = var1;
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2024234022"
   )
   public void method5252() {
      this.field3832 = 3;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1127341138"
   )
   public void method5254() {
      this.field3821 = 50;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1519078929"
   )
   public void method5255(boolean var1) {
      this.field3834 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "753717123"
   )
   public void method5256(int var1, int var2, boolean var3) {
      if(this.field3835 == -1) {
         this.field3835 = var1;
      }

      if(this.field3841 == -1) {
         this.field3841 = var2;
      }

      int var4 = var1 - this.field3835;
      int var5 = var2 - this.field3841;
      this.field3835 = var1;
      this.field3841 = var2;
      if(var3 && !this.method5319()) {
         this.field3803 -= (int)((float)var4 / this.field3809);
         this.field3822 += (int)((float)var5 / this.field3809);
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "8"
   )
   public void method5257(int var1) {
      this.field3826 = new HashSet();
      this.field3833 = 0;
      this.field3818 = 0;

      for(int var2 = 0; var2 < World.field1300.length; ++var2) {
         if(World.field1300[var2] != null && var1 == World.field1300[var2].field3313) {
            this.field3826.add(Integer.valueOf(World.field1300[var2].field3307));
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-5671"
   )
   public void method5258() {
      this.field3826 = null;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-41807436"
   )
   public void method5259(boolean var1) {
      this.field3804 = !var1;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1634691711"
   )
   public void method5260(int var1, boolean var2) {
      if(!var2) {
         this.field3813.add(Integer.valueOf(var1));
      } else {
         this.field3813.remove(Integer.valueOf(var1));
      }

      this.method5282();
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-193486136"
   )
   public void method5261(int var1, boolean var2) {
      if(!var2) {
         this.field3838.add(Integer.valueOf(var1));
      } else {
         this.field3838.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < World.field1300.length; ++var3) {
         if(World.field1300[var3] != null && World.field1300[var3].field3313 == var1) {
            int var4 = World.field1300[var3].field3307;
            if(!var2) {
               this.field3839.add(Integer.valueOf(var4));
            } else {
               this.field3839.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5282();
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1477286309"
   )
   public boolean method5262() {
      return !this.field3804;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1809756838"
   )
   public boolean method5263(int var1) {
      return !this.field3813.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1619520554"
   )
   public boolean method5264(int var1) {
      return !this.field3838.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(ILCoordinates;I)LCoordinates;",
      garbageValue = "651349028"
   )
   public Coordinates method5267(int var1, Coordinates var2) {
      if(!this.field3820.method5211()) {
         return null;
      } else if(!this.field3819.method547()) {
         return null;
      } else if(!this.field3817.method292(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.field3819.method555();
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
                  int var9 = var8.field527.worldX - var2.worldX;
                  int var10 = var8.field527.worldY - var2.worldY;
                  var11 = var10 * var10 + var9 * var9;
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

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)Lclass39;",
      garbageValue = "257814260"
   )
   public class39 method5269() {
      if(!this.field3820.method5211()) {
         return null;
      } else if(!this.field3819.method547()) {
         return null;
      } else {
         HashMap var1 = this.field3819.method555();
         this.field3844 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3844.addAll(var3);
         }

         this.field3829 = this.field3844.iterator();
         return this.method5270();
      }
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I)Lclass39;",
      garbageValue = "26530734"
   )
   public class39 method5270() {
      return this.field3829 == null?null:(!this.field3829.hasNext()?null:(class39)this.field3829.next());
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)LWorldMapData;",
      garbageValue = "-2035852461"
   )
   public WorldMapData method5272(int var1) {
      Iterator var2 = this.field3815.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method296() != var1);

      return var3;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "86"
   )
   void method5282() {
      this.field3840.clear();
      this.field3840.addAll(this.field3813);
      this.field3840.addAll(this.field3839);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   void method5284() {
      if(this.field3825 < this.field3809) {
         this.field3825 = Math.min(this.field3809, this.field3825 / 30.0F + this.field3825);
      }

      if(this.field3825 > this.field3809) {
         this.field3825 = Math.max(this.field3809, this.field3825 - this.field3825 / 30.0F);
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1755271079"
   )
   public void method5293(int var1, int var2, int var3) {
      if(this.field3817 != null) {
         int[] var4 = this.field3817.method336(var1, var2, var3);
         if(var4 != null) {
            this.method5299(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1681420591"
   )
   void method5297(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.method5040(var1, var2, var3, var4, -16777216);
      Rasterizer2D.method4976(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.method5040(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3812.method4825("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "85"
   )
   public void method5298(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3820.method5211()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3825));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3825));
         List var9 = this.field3819.method553(this.field3803 - var7 / 2 - 1, this.field3822 - var8 / 2 - 1, var7 / 2 + this.field3803 + 1, var8 / 2 + this.field3822 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               Area var12 = World.field1300[var11.field538];
               var13 = false;

               for(int var14 = this.field3843.length - 1; var14 >= 0; --var14) {
                  if(var12.field3302[var14] != null) {
                     Enum.addMenuEntry(var12.field3302[var14], var12.field3303, this.field3843[var14], var11.field538, var11.field529.method3955(), var11.field527.method3955());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1670304802"
   )
   public void method5299(int var1, int var2) {
      if(this.field3817 != null) {
         this.field3803 = var1 - this.field3817.method302() * 64;
         this.field3822 = var2 - this.field3817.method330() * 64;
         this.field3823 = -1;
         this.field3824 = -1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-72604677"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3820.method5211()) {
         if(!this.field3819.method547()) {
            System.out.println("renderOverview extractData");
            this.field3819.method548(this.field3808, this.field3817.method297(), Client.isMembers);
            System.out.println("done");
            if(!this.field3819.method547()) {
               return;
            }
         }

         this.field3819.method563(var1, var2, var3, var4, this.field3826, this.field3818, this.field3821);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-197503070"
   )
   void method5304(int var1, int var2, int var3) {
      if(this.field3817 != null) {
         int[] var4 = this.field3817.method336(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3817.method336(this.field3817.method307(), this.field3817.method321(), this.field3817.method308());
         }

         this.field3803 = var4[0] - this.field3817.method302() * 64;
         this.field3822 = var4[1] - this.field3817.method330() * 64;
         this.field3823 = -1;
         this.field3824 = -1;
         this.field3825 = this.method5238(this.field3817.method301());
         this.field3809 = this.field3825;
         this.field3844 = null;
         this.field3829 = null;
         this.field3819.method565();
      }
   }

   public RenderOverview() {
      this.field3823 = -1;
      this.field3824 = -1;
      this.field3827 = -1;
      this.field3845 = -1;
      this.field3832 = 3;
      this.field3821 = 50;
      this.field3834 = false;
      this.field3826 = null;
      this.field3833 = -1;
      this.field3818 = -1;
      this.field3835 = -1;
      this.field3841 = -1;
      this.field3813 = new HashSet();
      this.field3838 = new HashSet();
      this.field3839 = new HashSet();
      this.field3840 = new HashSet();
      this.field3804 = false;
      this.field3842 = 0;
      this.field3843 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3846 = new HashSet();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-260314865"
   )
   public void method5313(int var1) {
      this.field3826 = new HashSet();
      this.field3826.add(Integer.valueOf(var1));
      this.field3833 = 0;
      this.field3818 = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-42"
   )
   boolean method5319() {
      return this.field3823 != -1 && this.field3824 != -1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1717850565"
   )
   void method5333() {
      if(this.method5319()) {
         int var1 = this.field3823 - this.field3803;
         int var2 = this.field3824 - this.field3822;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3803 += var1;
         this.field3822 += var2;
         if(this.field3823 == this.field3803 && this.field3824 == this.field3822) {
            this.field3823 = -1;
            this.field3824 = -1;
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-988795969"
   )
   public int method5346() {
      return this.field3808.method4145(this.field3816.method297(), class40.field542.field543)?100:this.field3808.method4172(this.field3816.method297());
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "1050765979"
   )
   public void method5372(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3820.method5211()) {
         this.method5284();
         this.method5333();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3825));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3825));
            List var10 = this.field3819.method553(this.field3803 - var8 / 2 - 1, this.field3822 - var9 / 2 - 1, var8 / 2 + this.field3803 + 1, this.field3822 + var9 / 2 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            class69 var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); class227.method4101(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new class69();
               var15 = new class47(var13.field538, var13.field529, var13.field527);
               var14.method1070(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3846.contains(var13)) {
                  var14.method1071(class219.field2795);
               } else {
                  var14.method1071(class219.field2793);
               }
            }

            var12 = this.field3846.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new class69();
                  var15 = new class47(var13.field538, var13.field529, var13.field527);
                  var14.method1070(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1071(class219.field2794);
                  class227.method4101(var14);
               }
            }

            this.field3846 = var11;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-57920961"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.method4963(var6);
      Rasterizer2D.method4961(var1, var2, var1 + var3, var4 + var2);
      Rasterizer2D.method5040(var1, var2, var3, var4, -16777216);
      int var7 = this.field3820.method5208();
      if(var7 < 100) {
         this.method5297(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3819.method547()) {
            System.out.println("renderOverview extractWorldmap");
            this.field3819.method548(this.field3808, this.field3817.method297(), Client.isMembers);
            System.out.println("done");
            if(!this.field3819.method547()) {
               return;
            }
         }

         if(this.field3826 != null) {
            ++this.field3818;
            if(this.field3818 % this.field3821 == 0) {
               this.field3818 = 0;
               ++this.field3833;
            }

            if(this.field3833 >= this.field3832 && !this.field3834) {
               this.field3826 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3825));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3825));
         this.field3819.method550(this.field3803 - var8 / 2, this.field3822 - var9 / 2, this.field3803 + var8 / 2, this.field3822 + var9 / 2, var1, var2, var3 + var1, var4 + var2);
         if(!this.field3804) {
            boolean var10 = false;
            if(var5 - this.field3842 > 100) {
               this.field3842 = var5;
               var10 = true;
            }

            this.field3819.method551(this.field3803 - var8 / 2, this.field3822 - var9 / 2, var8 / 2 + this.field3803, this.field3822 + var9 / 2, var1, var2, var1 + var3, var2 + var4, this.field3840, this.field3826, this.field3818, this.field3821, var10);
         }

         this.field3827 = var8;
         this.field3845 = var9;
         Rasterizer2D.method5048(var6);
      }
   }
}
