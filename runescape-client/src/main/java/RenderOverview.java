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

@ObfuscatedName("kv")
@Implements("RenderOverview")
public class RenderOverview {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   static final class262 field3808;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   static final class262 field3818;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   static final class262 field3812;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Ljp;"
   )
   IndexedSprite[] field3802;
   @ObfuscatedName("ah")
   boolean field3819;
   @ObfuscatedName("av")
   HashSet field3826;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 551751171
   )
   int field3815;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1072482347
   )
   int field3817;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1686550899
   )
   int field3829;
   @ObfuscatedName("aw")
   HashSet field3800;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1343995297
   )
   int field3823;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -680891783
   )
   int field3805;
   @ObfuscatedName("ad")
   boolean field3811;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   IndexDataBase field3801;
   @ObfuscatedName("ak")
   HashSet field3828;
   @ObfuscatedName("h")
   HashMap field3803;
   @ObfuscatedName("ao")
   HashSet field3820;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   class288 field3796;
   @ObfuscatedName("as")
   Iterator field3833;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -599890407
   )
   int field3834;
   @ObfuscatedName("j")
   float field3814;
   @ObfuscatedName("i")
   float field3813;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   WorldMapData field3827;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   WorldMapData field3804;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -2136516317
   )
   int field3825;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -504705301
   )
   int field3816;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1585024287
   )
   int field3824;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -659075605
   )
   int field3830;
   @ObfuscatedName("o")
   HashMap field3810;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 2083339721
   )
   int field3821;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   WorldMapData field3806;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   Font field3791;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Laf;"
   )
   class41 field3807;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -554572933
   )
   int field3822;
   @ObfuscatedName("ac")
   HashSet field3799;
   @ObfuscatedName("aq")
   List field3832;
   @ObfuscatedName("am")
   final int[] field3831;
   @ObfuscatedName("ab")
   HashSet field3795;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -2072248427
   )
   int field3798;

   static {
      field3808 = class262.field3615;
      field3818 = class262.field3621;
      field3812 = class262.field3616;
   }

   public RenderOverview() {
      this.field3834 = -1;
      this.field3816 = -1;
      this.field3815 = -1;
      this.field3829 = -1;
      this.field3817 = 3;
      this.field3805 = 50;
      this.field3819 = false;
      this.field3820 = null;
      this.field3821 = -1;
      this.field3822 = -1;
      this.field3823 = -1;
      this.field3825 = -1;
      this.field3800 = new HashSet();
      this.field3826 = new HashSet();
      this.field3799 = new HashSet();
      this.field3828 = new HashSet();
      this.field3811 = false;
      this.field3798 = 0;
      this.field3831 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field3795 = new HashSet();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-348891696"
   )
   boolean method5310() {
      return this.field3834 != -1 && this.field3816 != -1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)Lae;",
      garbageValue = "341817308"
   )
   public WorldMapData method5232(int var1, int var2, int var3) {
      Iterator var4 = this.field3803.values().iterator();

      WorldMapData var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapData)var4.next();
      } while(!var5.method286(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)Lae;",
      garbageValue = "-673163666"
   )
   public WorldMapData method5249(int var1) {
      Iterator var2 = this.field3803.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapData)var2.next();
      } while(var3.method348() != var1);

      return var3;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)F",
      garbageValue = "1833309772"
   )
   float method5413(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lae;I)V",
      garbageValue = "-249807994"
   )
   void method5238(WorldMapData var1) {
      this.field3827 = var1;
      this.field3807 = new class41(this.field3802, this.field3810);
      this.field3796.method5210(this.field3827.method350());
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-52"
   )
   public int method5348() {
      return this.field3827 == null?-1:this.field3830 + this.field3827.method297() * 64;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lae;B)V",
      garbageValue = "-128"
   )
   void method5393(WorldMapData var1) {
      if(this.field3827 == null || var1 != this.field3827) {
         this.method5238(var1);
         this.method5308(-1, -1, -1);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1264587575"
   )
   void method5229() {
      if(this.field3813 < this.field3814) {
         this.field3813 = Math.min(this.field3814, this.field3813 / 30.0F + this.field3813);
      }

      if(this.field3813 > this.field3814) {
         this.field3813 = Math.max(this.field3814, this.field3813 - this.field3813 / 30.0F);
      }

   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1673506311"
   )
   void method5307() {
      this.field3828.clear();
      this.field3828.addAll(this.field3800);
      this.field3828.addAll(this.field3799);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2105465274"
   )
   void method5308(int var1, int var2, int var3) {
      if(this.field3827 != null) {
         int[] var4 = this.field3827.method288(var1, var2, var3);
         if(var4 == null) {
            var4 = this.field3827.method288(this.field3827.method302(), this.field3827.method301(), this.field3827.method346());
         }

         this.field3830 = var4[0] - this.field3827.method297() * 64;
         this.field3824 = var4[1] - this.field3827.method299() * 64;
         this.field3834 = -1;
         this.field3816 = -1;
         this.field3813 = this.method5413(this.field3827.method296());
         this.field3814 = this.field3813;
         this.field3832 = null;
         this.field3833 = null;
         this.field3807.method562();
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "50"
   )
   public int method5297() {
      return this.field3827 == null?-1:this.field3824 + this.field3827.method299() * 64;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1794662627"
   )
   void method5399() {
      if(this.method5310()) {
         int var1 = this.field3834 - this.field3830;
         int var2 = this.field3816 - this.field3824;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.field3830 += var1;
         this.field3824 += var2;
         if(this.field3830 == this.field3834 && this.field3816 == this.field3824) {
            this.field3834 = -1;
            this.field3816 = -1;
         }

      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1679195634"
   )
   public void method5251(int var1, int var2) {
      if(this.field3827 != null) {
         this.field3830 = var1 - this.field3827.method297() * 64;
         this.field3824 = var2 - this.field3827.method299() * 64;
         this.field3834 = -1;
         this.field3816 = -1;
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1984649496"
   )
   public void method5256(int var1, int var2) {
      if(this.field3827 != null && this.field3827.method283(var1, var2)) {
         this.field3834 = var1 - this.field3827.method297() * 64;
         this.field3816 = var2 - this.field3827.method299() * 64;
      }
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(B)Lad;",
      garbageValue = "0"
   )
   public class39 method5270() {
      return this.field3833 == null?null:(!this.field3833.hasNext()?null:(class39)this.field3833.next());
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-39870835"
   )
   void method5244(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.method4973(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.method4973(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.field3791.method4779("Loading...", var7, var6 + var8, -1, -1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "534034941"
   )
   public int method5226() {
      return this.field3801.method4134(this.field3804.method350(), class40.field538.field540)?100:this.field3801.method4137(this.field3804.method350());
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lit;Ljk;Ljava/util/HashMap;[Ljp;I)V",
      garbageValue = "1283738935"
   )
   public void method5225(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
      this.field3802 = var4;
      this.field3801 = var1;
      this.field3791 = var2;
      this.field3810 = new HashMap();
      this.field3810.put(class24.field358, var3.get(field3808));
      this.field3810.put(class24.field361, var3.get(field3818));
      this.field3810.put(class24.field359, var3.get(field3812));
      this.field3796 = new class288(var1);
      int var5 = this.field3801.getFile(class40.field542.field540);
      int[] var6 = this.field3801.getChilds(var5);
      this.field3803 = new HashMap(var6.length);

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Buffer var8 = new Buffer(this.field3801.getConfigData(var5, var6[var7]));
         WorldMapData var9 = new WorldMapData();
         var9.loadMapData(var8, var6[var7]);
         this.field3803.put(var9.method350(), var9);
         if(var9.method292()) {
            this.field3804 = var9;
         }
      }

      this.method5393(this.field3804);
      this.field3806 = null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIS)V",
      garbageValue = "1023"
   )
   @Export("extractWorldmap")
   public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.method4973(var1, var2, var3, var4, -16777216);
      int var7 = this.field3796.method5213();
      if(var7 < 100) {
         this.method5244(var1, var2, var3, var4, var7);
      } else {
         if(!this.field3807.method550()) {
            this.field3807.method556(this.field3801, this.field3827.method350(), Client.isMembers);
            if(!this.field3807.method550()) {
               return;
            }
         }

         if(this.field3820 != null) {
            ++this.field3822;
            if(this.field3822 % this.field3805 == 0) {
               this.field3822 = 0;
               ++this.field3821;
            }

            if(this.field3821 >= this.field3817 && !this.field3819) {
               this.field3820 = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.field3813));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3813));
         this.field3807.method572(this.field3830 - var8 / 2, this.field3824 - var9 / 2, var8 / 2 + this.field3830, var9 / 2 + this.field3824, var1, var2, var3 + var1, var2 + var4);
         if(!this.field3811) {
            boolean var10 = false;
            if(var5 - this.field3798 > 100) {
               this.field3798 = var5;
               var10 = true;
            }

            this.field3807.method545(this.field3830 - var8 / 2, this.field3824 - var9 / 2, var8 / 2 + this.field3830, var9 / 2 + this.field3824, var1, var2, var3 + var1, var2 + var4, this.field3828, this.field3820, this.field3822, this.field3805, var10);
         }

         this.field3815 = var8;
         this.field3829 = var9;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-41"
   )
   @Export("extractData")
   public void extractData(int var1, int var2, int var3, int var4) {
      if(this.field3796.method5212()) {
         if(!this.field3807.method550()) {
            this.field3807.method556(this.field3801, this.field3827.method350(), Client.isMembers);
            if(!this.field3807.method550()) {
               return;
            }
         }

         this.field3807.method547(var1, var2, var3, var4, this.field3820, this.field3822, this.field3805);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-579095083"
   )
   public void method5288(int var1, int var2, int var3, boolean var4) {
      WorldMapData var5 = this.method5232(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field3804;
      }

      boolean var6 = false;
      if(var5 != this.field3806 || var4) {
         this.field3806 = var5;
         this.method5393(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method5308(var1, var2, var3);
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1890496067"
   )
   public void method5247() {
      this.field3796.method5222();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "1818398041"
   )
   public void method5227(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.field3796.method5212()) {
         this.method5229();
         this.method5399();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.field3813));
            int var9 = (int)Math.ceil((double)((float)var7 / this.field3813));
            List var10 = this.field3807.method548(this.field3830 - var8 / 2 - 1, this.field3824 - var9 / 2 - 1, var8 / 2 + this.field3830 + 1, var9 / 2 + this.field3824 + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            class39 var13;
            ScriptEvent var14;
            class47 var15;
            for(var12 = var10.iterator(); var12.hasNext(); PendingSpawn.method1525(var14)) {
               var13 = (class39)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new class47(var13.field534, var13.field528, var13.field530);
               var14.method1113(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field3795.contains(var13)) {
                  var14.method1107(class220.field2768);
               } else {
                  var14.method1107(class220.field2762);
               }
            }

            var12 = this.field3795.iterator();

            while(var12.hasNext()) {
               var13 = (class39)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new class47(var13.field534, var13.field528, var13.field530);
                  var14.method1113(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1107(class220.field2767);
                  PendingSpawn.method1525(var14);
               }
            }

            this.field3795 = var11;
         }
      }
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1578333007"
   )
   public void method5230(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.field3796.method5212()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.field3813));
         int var8 = (int)Math.ceil((double)((float)var4 / this.field3813));
         List var9 = this.field3807.method548(this.field3830 - var7 / 2 - 1, this.field3824 - var8 / 2 - 1, var7 / 2 + this.field3830 + 1, var8 / 2 + this.field3824 + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               class39 var11 = (class39)var10.next();
               Area var12 = Area.field3276[var11.field534];
               var13 = false;

               for(int var14 = this.field3831.length - 1; var14 >= 0; --var14) {
                  if(var12.field3285[var14] != null) {
                     class165.addMenuEntry(var12.field3285[var14], var12.field3275, this.field3831[var14], var11.field534, var11.field528.method3935(), var11.field530.method3935());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-169460737"
   )
   public void method5234(int var1) {
      WorldMapData var2 = this.method5249(var1);
      if(var2 != null) {
         this.method5393(var2);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "1253831416"
   )
   public void method5228(int var1, int var2, boolean var3) {
      if(this.field3823 == -1) {
         this.field3823 = var1;
      }

      if(this.field3825 == -1) {
         this.field3825 = var2;
      }

      int var4 = var1 - this.field3823;
      int var5 = var2 - this.field3825;
      this.field3823 = var1;
      this.field3825 = var2;
      if(var3 && !this.method5310()) {
         this.field3830 -= (int)((float)var4 / this.field3814);
         this.field3824 += (int)((float)var5 / this.field3814);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1244711536"
   )
   public void method5243(int var1) {
      this.field3814 = this.method5413(var1);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-747825181"
   )
   public int method5397() {
      return 1.0D == (double)this.field3814?25:((double)this.field3814 == 1.5D?37:(2.0D == (double)this.field3814?50:(3.0D == (double)this.field3814?75:((double)this.field3814 == 4.0D?100:200))));
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-2232"
   )
   public boolean method5286() {
      return this.field3796.method5212();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)Lhq;",
      garbageValue = "-1729455864"
   )
   public Coordinates method5254() {
      return this.field3827 == null?null:this.field3827.method289(this.method5348(), this.method5297());
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "143651966"
   )
   public void method5274(int var1, int var2, int var3) {
      if(this.field3827 != null) {
         int[] var4 = this.field3827.method288(var1, var2, var3);
         if(var4 != null) {
            this.method5256(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1803800924"
   )
   public void method5253(int var1, int var2, int var3) {
      if(this.field3827 != null) {
         int[] var4 = this.field3827.method288(var1, var2, var3);
         if(var4 != null) {
            this.method5251(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "636009288"
   )
   public int method5233() {
      return this.field3827 == null?-1:this.field3827.method348();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Lae;",
      garbageValue = "-38775664"
   )
   public WorldMapData method5236() {
      return this.field3827;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1965594023"
   )
   public void method5260() {
      this.field3817 = 3;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "49"
   )
   public void method5262() {
      this.field3805 = 50;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1335563302"
   )
   public int method5257() {
      return this.field3815;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1526163175"
   )
   public void method5259(int var1) {
      if(var1 >= 1) {
         this.field3817 = var1;
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1743007761"
   )
   public void method5261(int var1) {
      if(var1 >= 1) {
         this.field3805 = var1;
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-4576"
   )
   public void method5266() {
      this.field3820 = null;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1453899749"
   )
   public void method5264(int var1) {
      this.field3820 = new HashSet();
      this.field3820.add(Integer.valueOf(var1));
      this.field3821 = 0;
      this.field3822 = 0;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "1"
   )
   public void method5263(boolean var1) {
      this.field3819 = var1;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2011410418"
   )
   public void method5265(int var1) {
      this.field3820 = new HashSet();
      this.field3821 = 0;
      this.field3822 = 0;

      for(int var2 = 0; var2 < Area.field3276.length; ++var2) {
         if(Area.field3276[var2] != null && Area.field3276[var2].field3296 == var1) {
            this.field3820.add(Integer.valueOf(Area.field3276[var2].field3297));
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1307573560"
   )
   public void method5267(boolean var1) {
      this.field3811 = !var1;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "52"
   )
   public int method5258() {
      return this.field3829;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I)Lad;",
      garbageValue = "1752872805"
   )
   public class39 method5371() {
      if(!this.field3796.method5212()) {
         return null;
      } else if(!this.field3807.method550()) {
         return null;
      } else {
         HashMap var1 = this.field3807.method551();
         this.field3832 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field3832.addAll(var3);
         }

         this.field3833 = this.field3832.iterator();
         return this.method5270();
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-424070324"
   )
   public boolean method5378() {
      return !this.field3811;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-2066455314"
   )
   public void method5224(int var1, boolean var2) {
      if(!var2) {
         this.field3800.add(Integer.valueOf(var1));
      } else {
         this.field3800.remove(Integer.valueOf(var1));
      }

      this.method5307();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1052117962"
   )
   public void method5269(int var1, boolean var2) {
      if(!var2) {
         this.field3826.add(Integer.valueOf(var1));
      } else {
         this.field3826.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < Area.field3276.length; ++var3) {
         if(Area.field3276[var3] != null && Area.field3276[var3].field3296 == var1) {
            int var4 = Area.field3276[var3].field3297;
            if(!var2) {
               this.field3799.add(Integer.valueOf(var4));
            } else {
               this.field3799.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method5307();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lae;Lhq;Lhq;ZI)V",
      garbageValue = "1696307317"
   )
   public void method5239(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
      if(var1 != null) {
         if(this.field3827 == null || var1 != this.field3827) {
            this.method5238(var1);
         }

         if(!var4 && this.field3827.method286(var2.plane, var2.worldX, var2.worldY)) {
            this.method5308(var2.plane, var2.worldX, var2.worldY);
         } else {
            this.method5308(var3.plane, var3.worldX, var3.worldY);
         }

      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "518959847"
   )
   public boolean method5271(int var1) {
      return !this.field3800.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "119"
   )
   public boolean method5376(int var1) {
      return !this.field3826.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(ILhq;B)Lhq;",
      garbageValue = "47"
   )
   public Coordinates method5283(int var1, Coordinates var2) {
      if(!this.field3796.method5212()) {
         return null;
      } else if(!this.field3807.method550()) {
         return null;
      } else if(!this.field3827.method283(var2.worldX, var2.worldY)) {
         return null;
      } else {
         HashMap var3 = this.field3807.method551();
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
                     return var5.field530;
                  }

                  var8 = (class39)var7.next();
                  int var9 = var8.field530.worldX - var2.worldX;
                  int var10 = var8.field530.worldY - var2.worldY;
                  var11 = var10 * var10 + var9 * var9;
                  if(var11 == 0) {
                     return var8.field530;
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
      signature = "(IILhq;Lhq;B)V",
      garbageValue = "9"
   )
   public void method5276(int var1, int var2, Coordinates var3, Coordinates var4) {
      ScriptEvent var5 = new ScriptEvent();
      class47 var6 = new class47(var2, var3, var4);
      var5.method1113(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1107(class220.field2772);
         break;
      case 1009:
         var5.method1107(class220.field2763);
         break;
      case 1010:
         var5.method1107(class220.field2764);
         break;
      case 1011:
         var5.method1107(class220.field2765);
         break;
      case 1012:
         var5.method1107(class220.field2766);
      }

      PendingSpawn.method1525(var5);
   }
}
