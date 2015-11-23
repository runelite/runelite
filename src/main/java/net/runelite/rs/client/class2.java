package net.runelite.rs.client;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("f")
@Implements("Player")
public final class class2 extends class37 {
   @ObfuscatedName("m")
   @Export("composition")
   class178 field31;
   @ObfuscatedName("a")
   String[] field32 = new String[3];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1713111685
   )
   int field33 = -1;
   @ObfuscatedName("j")
   @Export("name")
   String field34;
   @ObfuscatedName("x")
   boolean field35;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -539000905
   )
   int field37;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1000600475
   )
   int field38;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1312493237
   )
   @Export("totalLevel")
   int field39;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -52221355
   )
   int field40;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1212572511
   )
   int field41;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1214603931
   )
   int field42;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -228649331
   )
   int field43;
   @ObfuscatedName("p")
   @Export("model")
   class104 field44;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1569066985
   )
   int field45;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1545413731
   )
   int field46 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1776610935
   )
   int field47;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 978161407
   )
   int field48;
   @ObfuscatedName("v")
   boolean field49;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -252226933
   )
   @Export("team")
   int field50;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1455461317
   )
   int field51;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1863061207
   )
   int field52;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -249902191
   )
   @Export("combatLevel")
   int field53;
   @ObfuscatedName("c")
   boolean field54;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1513270911
   )
   int field55;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1046303529
   )
   int field56;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -688378285
   )
   int field58;

   @ObfuscatedName("j")
   final void method14(class118 var1) {
      var1.field1981 = 0;
      int var2 = var1.method2536();
      this.field46 = var1.method2537();
      this.field33 = var1.method2537();
      int var3 = -1;
      this.field50 = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.method2536();
         if(0 == var6) {
            var4[var5] = 0;
         } else {
            var7 = var1.method2536();
            var4[var5] = var7 + (var6 << 8);
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.method2538();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = class10.method158(var4[var5] - 512).field1124;
               if(0 != var8) {
                  this.field50 = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2536();
         if(var7 < 0 || var7 >= class118.field1979[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.field803 = var1.method2538();
      if(super.field803 == '\uffff') {
         super.field803 = -1;
      }

      super.field804 = var1.method2538();
      if(super.field804 == '\uffff') {
         super.field804 = -1;
      }

      super.field849 = super.field804 * -1;
      super.field806 = var1.method2538();
      if('\uffff' == super.field806) {
         super.field806 = -1;
      }

      super.field807 = var1.method2538();
      if('\uffff' == super.field807) {
         super.field807 = -1;
      }

      super.field822 = var1.method2538();
      if('\uffff' == super.field822) {
         super.field822 = -1;
      }

      super.field818 = var1.method2538();
      if(super.field818 == '\uffff') {
         super.field818 = -1;
      }

      super.field810 = var1.method2538();
      if(super.field810 == '\uffff') {
         super.field810 = -1;
      }

      this.field34 = var1.method2544();
      if(class0.field12 == this) {
         class217.field3147 = this.field34;
      }

      this.field53 = var1.method2536();
      this.field37 = var1.method2538();
      this.field35 = var1.method2536() == 1;
      if(0 == client.field279 && client.field441 >= 2) {
         this.field35 = false;
      }

      if(this.field31 == null) {
         this.field31 = new class178();
      }

      this.field31.method3537(var4, var9, 1 == var2, var3);
   }

   @ObfuscatedName("m")
   int method15() {
      return this.field31 != null && this.field31.field2898 != -1?class22.method618(this.field31.field2898).field871:1;
   }

   @ObfuscatedName("f")
   protected final class104 vmethod1921() {
      if(null == this.field31) {
         return null;
      } else {
         class42 var1 = super.field829 != -1 && 0 == super.field832?client.method584(super.field829):null;
         class42 var2 = super.field826 != -1 && !this.field49 && (super.field826 != super.field803 || var1 == null)?client.method584(super.field826):null;
         class104 var3 = this.field31.method3543(var1, super.field830, var2, super.field827);
         if(null == var3) {
            return null;
         } else {
            var3.method2334();
            super.field811 = var3.field1441;
            class104 var4;
            class104[] var5;
            if(!this.field49 && -1 != super.field805 && super.field835 != -1) {
               var4 = class10.method156(super.field805).method948(super.field835);
               if(var4 != null) {
                  var4.method2344(0, -super.field838, 0);
                  var5 = new class104[]{var3, var4};
                  var3 = new class104(var5, 2);
               }
            }

            if(!this.field49 && this.field44 != null) {
               if(client.field286 >= this.field40) {
                  this.field44 = null;
               }

               if(client.field286 >= this.field39 && client.field286 < this.field40) {
                  var4 = this.field44;
                  var4.method2344(this.field41 - super.field846, this.field42 - this.field38, this.field43 - super.field834);
                  if(super.field848 == 512) {
                     var4.method2340();
                     var4.method2340();
                     var4.method2340();
                  } else if(super.field848 == 1024) {
                     var4.method2340();
                     var4.method2340();
                  } else if(super.field848 == 1536) {
                     var4.method2340();
                  }

                  var5 = new class104[]{var3, var4};
                  var3 = new class104(var5, 2);
                  if(512 == super.field848) {
                     var4.method2340();
                  } else if(1024 == super.field848) {
                     var4.method2340();
                     var4.method2340();
                  } else if(super.field848 == 1536) {
                     var4.method2340();
                     var4.method2340();
                     var4.method2340();
                  }

                  var4.method2344(super.field846 - this.field41, this.field38 - this.field42, super.field834 - this.field43);
               }
            }

            var3.field1821 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("a")
   final void method18(int var1, int var2, byte var3) {
      if(super.field851 < 9) {
         ++super.field851;
      }

      for(int var4 = super.field851; var4 > 0; --var4) {
         super.field809[var4] = super.field809[var4 - 1];
         super.field816[var4] = super.field816[var4 - 1];
         super.field855[var4] = super.field855[var4 - 1];
      }

      super.field809[0] = var1;
      super.field816[0] = var2;
      super.field855[0] = var3;
   }

   @ObfuscatedName("h")
   final boolean vmethod791() {
      return this.field31 != null;
   }

   @ObfuscatedName("u")
   void method26(int var1, int var2) {
      super.field851 = 0;
      super.field856 = 0;
      super.field831 = 0;
      super.field809[0] = var1;
      super.field816[0] = var2;
      int var3 = this.method15();
      super.field846 = var3 * 64 + 128 * super.field809[0];
      super.field834 = super.field816[0] * 128 + var3 * 64;
   }

   @ObfuscatedName("l")
   final void method32(int var1, int var2, byte var3) {
      if(super.field829 != -1 && client.method584(super.field829).field985 == 1) {
         super.field829 = -1;
      }

      super.field825 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.field809[0] >= 0 && super.field809[0] < 104 && super.field816[0] >= 0 && super.field816[0] < 104) {
            if(2 == var3) {
               class152.method3194(this, var1, var2, (byte)2);
            }

            this.method18(var1, var2, var3);
         } else {
            this.method26(var1, var2);
         }
      } else {
         this.method26(var1, var2);
      }

   }

   class2() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.field32[var1] = "";
      }

      this.field53 = 0;
      this.field37 = 0;
      this.field39 = 0;
      this.field40 = 0;
      this.field49 = false;
      this.field50 = 0;
      this.field35 = false;
      this.field54 = false;
   }

   @ObfuscatedName("u")
   public static void method42() {
      if(class170.field2715 != null) {
         class170.field2715.method3022();
      }

   }
}
