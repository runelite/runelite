import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("Player")
public final class class2 extends class37 {
   @ObfuscatedName("w")
   @Export("composition")
   class179 field33;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1694274039
   )
   int field34;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -129867515
   )
   @Export("totalLevel")
   int field35;
   @ObfuscatedName("h")
   boolean field37;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -49462509
   )
   @Export("combatLevel")
   int field38;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2075778663
   )
   int field39;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2008080577
   )
   int field40;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1805043191
   )
   int field41 = -1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1864821837
   )
   int field42;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1310926663
   )
   int field44;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1939582435
   )
   int field45;
   @ObfuscatedName("t")
   @Export("model")
   class105 field46;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 803981703
   )
   int field47;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -494114155
   )
   int field48;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1388059727
   )
   int field49;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 875930163
   )
   int field50 = -1;
   @ObfuscatedName("f")
   boolean field51;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1960588267
   )
   int field52;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1814619965
   )
   int field53;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1112982245
   )
   int field54;
   @ObfuscatedName("k")
   String[] field55 = new String[3];
   @ObfuscatedName("o")
   boolean field56;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 324433119
   )
   int field57;
   @ObfuscatedName("a")
   @Export("name")
   String field58;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = -72693421
   )
   static int field59;
   @ObfuscatedName("kp")
   static class131 field60;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = 289185601
   )
   static int field61;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -231598219
   )
   int field62;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 265207159
   )
   @Export("team")
   int field63;

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "-30"
   )
   static void method15(int var0, String var1) {
      int var2 = class32.field771;
      int[] var3 = class32.field762;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         class2 var6 = client.field550[var3[var5]];
         if(null != var6 && var6 != class5.field93 && var6.field58 != null && var6.field58.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               client.field338.method2873(72);
               client.field338.method2745(var3[var5]);
               client.field338.method2743(0);
            } else if(4 == var0) {
               client.field338.method2873(174);
               client.field338.method2638(0);
               client.field338.method2599(var3[var5]);
            } else if(var0 == 6) {
               client.field338.method2873(31);
               client.field338.method2634(var3[var5]);
               client.field338.method2603(0);
            } else if(7 == var0) {
               client.field338.method2873(0);
               client.field338.method2638(0);
               client.field338.method2745(var3[var5]);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class129.method2943(4, "", "Unable to find " + var1);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "70"
   )
   final void method16(class119 var1) {
      var1.field1992 = 0;
      int var2 = var1.method2613();
      this.field41 = var1.method2699();
      this.field50 = var1.method2699();
      int var3 = -1;
      this.field63 = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.method2613();
         if(0 == var6) {
            var4[var5] = 0;
         } else {
            var7 = var1.method2613();
            var4[var5] = (var6 << 8) + var7;
            if(var5 == 0 && '\uffff' == var4[0]) {
               var3 = var1.method2615();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = class11.method178(var4[var5] - 512).field1133;
               if(var8 != 0) {
                  this.field63 = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2613();
         if(var7 < 0 || var7 >= class179.field2925[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.field822 = var1.method2615();
      if('\uffff' == super.field822) {
         super.field822 = -1;
      }

      super.field878 = var1.method2615();
      if(super.field878 == '\uffff') {
         super.field878 = -1;
      }

      super.field824 = super.field878;
      super.field825 = var1.method2615();
      if(super.field825 == '\uffff') {
         super.field825 = -1;
      }

      super.field839 = var1.method2615();
      if('\uffff' == super.field839) {
         super.field839 = -1;
      }

      super.field836 = var1.method2615();
      if('\uffff' == super.field836) {
         super.field836 = -1;
      }

      super.field828 = var1.method2615();
      if(super.field828 == '\uffff') {
         super.field828 = -1;
      }

      super.field829 = var1.method2615();
      if(super.field829 == '\uffff') {
         super.field829 = -1;
      }

      this.field58 = var1.method2621();
      if(class5.field93 == this) {
         class148.field2216 = this.field58;
      }

      this.field38 = var1.method2613();
      this.field39 = var1.method2615();
      this.field51 = var1.method2613() == 1;
      if(0 == client.field352 && client.field345 >= 2) {
         this.field51 = false;
      }

      if(null == this.field33) {
         this.field33 = new class179();
      }

      this.field33.method3564(var4, var9, 1 == var2, var3);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "48"
   )
   int method17() {
      return this.field33 != null && -1 != this.field33.field2929?class28.method734(this.field33.field2929).field887:1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "67"
   )
   final void method19(int var1, int var2, byte var3) {
      if(-1 != super.field848 && class96.method2279(super.field848).field1004 == 1) {
         super.field848 = -1;
      }

      super.field827 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.field871[0] >= 0 && super.field871[0] < 104 && super.field835[0] >= 0 && super.field835[0] < 104) {
            if(var3 == 2) {
               class2 var4 = this;
               int var5 = super.field871[0];
               int var6 = super.field835[0];
               int var7 = this.method17();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var10 = this.method17();
                  client.field573.field1873 = var1;
                  client.field573.field1868 = var2;
                  client.field573.field1869 = 1;
                  client.field573.field1878 = 1;
                  class10 var11 = client.field573;
                  int var12 = class24.method676(var5, var6, var10, var11, client.field361[this.field54], true, client.field574, client.field575);
                  if(var12 >= 1) {
                     for(int var13 = 0; var13 < var12 - 1; ++var13) {
                        var4.method22(client.field574[var13], client.field575[var13], (byte)2);
                     }
                  }
               }
            }

            this.method22(var1, var2, var3);
         } else {
            this.method20(var1, var2);
         }
      } else {
         this.method20(var1, var2);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1549032349"
   )
   void method20(int var1, int var2) {
      super.field821 = 0;
      super.field875 = 0;
      super.field874 = 0;
      super.field871[0] = var1;
      super.field835[0] = var2;
      int var3 = this.method17();
      super.field844 = 64 * var3 + super.field871[0] * 128;
      super.field819 = var3 * 64 + 128 * super.field835[0];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1698608845"
   )
   final void method22(int var1, int var2, byte var3) {
      if(super.field821 < 9) {
         ++super.field821;
      }

      for(int var4 = super.field821; var4 > 0; --var4) {
         super.field871[var4] = super.field871[var4 - 1];
         super.field835[var4] = super.field835[var4 - 1];
         super.field826[var4] = super.field826[var4 - 1];
      }

      super.field871[0] = var1;
      super.field835[0] = var2;
      super.field826[0] = var3;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1478814369"
   )
   final boolean vmethod836() {
      return this.field33 != null;
   }

   class2() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.field55[var1] = "";
      }

      this.field38 = 0;
      this.field39 = 0;
      this.field35 = 0;
      this.field42 = 0;
      this.field37 = false;
      this.field63 = 0;
      this.field51 = false;
      this.field56 = false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "-1720106348"
   )
   protected final class105 vmethod1999() {
      if(this.field33 == null) {
         return null;
      } else {
         class42 var1 = super.field848 != -1 && 0 == super.field851?class96.method2279(super.field848):null;
         class42 var2 = -1 != super.field845 && !this.field37 && (super.field822 != super.field845 || var1 == null)?class96.method2279(super.field845):null;
         class105 var3 = this.field33.method3565(var1, super.field849, var2, super.field846);
         if(var3 == null) {
            return null;
         } else {
            var3.method2418();
            super.field867 = var3.field1465;
            class105 var4;
            class105[] var5;
            if(!this.field37 && super.field865 != -1 && super.field854 != -1) {
               var4 = class25.method693(super.field865).method994(super.field854);
               if(var4 != null) {
                  var4.method2402(0, -super.field857, 0);
                  var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
               }
            }

            if(!this.field37 && this.field46 != null) {
               if(client.field306 >= this.field42) {
                  this.field46 = null;
               }

               if(client.field306 >= this.field35 && client.field306 < this.field42) {
                  var4 = this.field46;
                  var4.method2402(this.field62 - super.field844, this.field44 - this.field40, this.field45 - super.field819);
                  if(super.field853 == 512) {
                     var4.method2398();
                     var4.method2398();
                     var4.method2398();
                  } else if(1024 == super.field853) {
                     var4.method2398();
                     var4.method2398();
                  } else if(super.field853 == 1536) {
                     var4.method2398();
                  }

                  var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
                  if(512 == super.field853) {
                     var4.method2398();
                  } else if(1024 == super.field853) {
                     var4.method2398();
                     var4.method2398();
                  } else if(super.field853 == 1536) {
                     var4.method2398();
                     var4.method2398();
                     var4.method2398();
                  }

                  var4.method2402(super.field844 - this.field62, this.field40 - this.field44, super.field819 - this.field45);
               }
            }

            var3.field1819 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "123"
   )
   static final void method44(class122 var0) {
      for(int var1 = 0; var1 < class32.field769; ++var1) {
         int var2 = class32.field770[var1];
         class2 var3 = client.field550[var2];
         int var4 = var0.method2613();
         if(0 != (var4 & 4)) {
            var4 += var0.method2613() << 8;
         }

         class109.method2526(var0, var2, var3, var4);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass42;IIII)V",
      garbageValue = "254163788"
   )
   static void method46(class42 var0, int var1, int var2, int var3) {
      if(client.field536 < 50 && 0 != client.field514) {
         if(null != var0.field992 && var1 < var0.field992.length) {
            int var4 = var0.field992[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               client.field537[client.field536] = var5;
               client.field334[client.field536] = var6;
               client.field539[client.field536] = 0;
               client.field541[client.field536] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               client.field540[client.field536] = (var8 << 16) + (var9 << 8) + var7;
               ++client.field536;
            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-803159062"
   )
   public static int method47(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if(0 != (var1 & 1)) {
            var2 *= var0;
         }

         var0 *= var0;
      }

      if(1 == var1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }
}
