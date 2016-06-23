import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("Player")
public final class class2 extends class37 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1840261741
   )
   int field35;
   @ObfuscatedName("u")
   @Export("composition")
   class179 field36;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1109945475
   )
   int field37;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -168197621
   )
   int field38 = -1;
   @ObfuscatedName("d")
   @Export("actions")
   String[] field39 = new String[3];
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 880308307
   )
   @Export("combatLevel")
   int field40;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1595179191
   )
   int field41;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 935740733
   )
   int field42;
   @ObfuscatedName("p")
   @Export("model")
   class105 field43;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1543379599
   )
   int field44;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -750312373
   )
   int field45;
   @ObfuscatedName("c")
   boolean field46;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -399686087
   )
   int field47;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1030428491
   )
   int field48;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2129792861
   )
   int field49;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2026665751
   )
   int field50;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1988308349
   )
   int field51;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1205471011
   )
   int field52;
   @ObfuscatedName("v")
   boolean field53;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 577486861
   )
   @Export("totalLevel")
   int field54;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 245083945
   )
   int field55;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2104357919
   )
   int field56 = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -951340395
   )
   @Export("team")
   int field57;
   @ObfuscatedName("z")
   boolean field58;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1440226485
   )
   int field59;
   @ObfuscatedName("f")
   @Export("name")
   String field60;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-2094135592"
   )
   final void method15(class119 var1) {
      var1.field1998 = 0;
      int var2 = var1.method2554();
      this.field56 = var1.method2538();
      this.field38 = var1.method2538();
      int var3 = -1;
      this.field57 = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var9 = 0; var9 < 12; ++var9) {
         var6 = var1.method2554();
         if(var6 == 0) {
            var4[var9] = 0;
         } else {
            var7 = var1.method2554();
            var4[var9] = (var6 << 8) + var7;
            if(var9 == 0 && var4[0] == '\uffff') {
               var3 = var1.method2556();
               break;
            }

            if(var4[var9] >= 512) {
               int var8 = class141.method3001(var4[var9] - 512).field1159;
               if(var8 != 0) {
                  this.field57 = var8;
               }
            }
         }
      }

      int[] var5 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2554();
         if(var7 < 0 || var7 >= class169.field2701[var6].length) {
            var7 = 0;
         }

         var5[var6] = var7;
      }

      super.field826 = var1.method2556();
      if(super.field826 == '\uffff') {
         super.field826 = -1;
      }

      super.field827 = var1.method2556();
      if(super.field827 == '\uffff') {
         super.field827 = -1;
      }

      super.field845 = super.field827;
      super.field829 = var1.method2556();
      if(super.field829 == '\uffff') {
         super.field829 = -1;
      }

      super.field830 = var1.method2556();
      if(super.field830 == '\uffff') {
         super.field830 = -1;
      }

      super.field831 = var1.method2556();
      if(super.field831 == '\uffff') {
         super.field831 = -1;
      }

      super.field832 = var1.method2556();
      if(super.field832 == '\uffff') {
         super.field832 = -1;
      }

      super.field833 = var1.method2556();
      if(super.field833 == '\uffff') {
         super.field833 = -1;
      }

      this.field60 = var1.method2668();
      if(this == class15.field225) {
         class148.field2221 = this.field60;
      }

      this.field40 = var1.method2554();
      this.field41 = var1.method2556();
      this.field46 = var1.method2554() == 1;
      if(client.field293 == 0 && client.field454 >= 2) {
         this.field46 = false;
      }

      if(null == this.field36) {
         this.field36 = new class179();
      }

      this.field36.method3508(var4, var5, var2 == 1, var3);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "116"
   )
   int method16() {
      return null != this.field36 && this.field36.field2916 != -1?class172.method3424(this.field36.field2916).field907:1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-887473608"
   )
   final void method18(int var1, int var2, byte var3) {
      if(super.field822 != -1 && class34.method768(super.field822).field997 == 1) {
         super.field822 = -1;
      }

      super.field848 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.field875[0] >= 0 && super.field875[0] < 104 && super.field876[0] >= 0 && super.field876[0] < 104) {
            if(var3 == 2) {
               class33.method748(this, var1, var2, (byte)2);
            }

            this.method30(var1, var2, var3);
         } else {
            this.method33(var1, var2);
         }
      } else {
         this.method33(var1, var2);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass144;B)V",
      garbageValue = "64"
   )
   static void method19(class144 var0) {
      if(class140.field2156 == 1 || !class148.field2224 && class140.field2156 == 4) {
         int var1 = 280 + class31.field725;
         if(class140.field2161 >= var1 && class140.field2161 <= 14 + var1 && class140.field2158 >= 4 && class140.field2158 <= 18) {
            class104.method2350(0, 0);
            return;
         }

         if(class140.field2161 >= var1 + 15 && class140.field2161 <= 80 + var1 && class140.field2158 >= 4 && class140.field2158 <= 18) {
            class104.method2350(0, 1);
            return;
         }

         int var2 = 390 + class31.field725;
         if(class140.field2161 >= var2 && class140.field2161 <= 14 + var2 && class140.field2158 >= 4 && class140.field2158 <= 18) {
            class104.method2350(1, 0);
            return;
         }

         if(class140.field2161 >= 15 + var2 && class140.field2161 <= 80 + var2 && class140.field2158 >= 4 && class140.field2158 <= 18) {
            class104.method2350(1, 1);
            return;
         }

         int var3 = 500 + class31.field725;
         if(class140.field2161 >= var3 && class140.field2161 <= 14 + var3 && class140.field2158 >= 4 && class140.field2158 <= 18) {
            class104.method2350(2, 0);
            return;
         }

         if(class140.field2161 >= 15 + var3 && class140.field2161 <= 80 + var3 && class140.field2158 >= 4 && class140.field2158 <= 18) {
            class104.method2350(2, 1);
            return;
         }

         int var4 = 610 + class31.field725;
         if(class140.field2161 >= var4 && class140.field2161 <= 14 + var4 && class140.field2158 >= 4 && class140.field2158 <= 18) {
            class104.method2350(3, 0);
            return;
         }

         if(class140.field2161 >= var4 + 15 && class140.field2161 <= 80 + var4 && class140.field2158 >= 4 && class140.field2158 <= 18) {
            class104.method2350(3, 1);
            return;
         }

         if(class140.field2161 >= class31.field725 + 708 && class140.field2158 >= 4 && class140.field2161 <= class31.field725 + 708 + 50 && class140.field2158 <= 20) {
            class31.field722 = false;
            class31.field717.method1761(class31.field725, 0);
            class172.field2738.method1761(382 + class31.field725, 0);
            class159.field2605.method1916(class31.field725 + 382 - class159.field2605.field1428 / 2, 18);
            return;
         }

         if(class31.field743 != -1) {
            class25 var5 = class25.field635[class31.field743];
            class107.method2431(var5);
            class31.field722 = false;
            class31.field717.method1761(class31.field725, 0);
            class172.field2738.method1761(382 + class31.field725, 0);
            class159.field2605.method1916(382 + class31.field725 - class159.field2605.field1428 / 2, 18);
            return;
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1658145806"
   )
   final boolean vmethod790() {
      return null != this.field36;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)Lclass105;",
      garbageValue = "1006"
   )
   protected final class105 vmethod1968() {
      if(this.field36 == null) {
         return null;
      } else {
         class42 var1 = super.field822 != -1 && super.field855 == 0?class34.method768(super.field822):null;
         class42 var2 = super.field849 == -1 || this.field53 || super.field826 == super.field849 && var1 != null?null:class34.method768(super.field849);
         class105 var3 = this.field36.method3514(var1, super.field853, var2, super.field868);
         if(null == var3) {
            return null;
         } else {
            var3.method2357();
            super.field870 = var3.field1468;
            class105 var4;
            class105[] var5;
            if(!this.field53 && super.field857 != -1 && super.field821 != -1) {
               var4 = class1.method12(super.field857).method952(super.field821);
               if(null != var4) {
                  var4.method2365(0, -super.field842, 0);
                  var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
               }
            }

            if(!this.field53 && this.field43 != null) {
               if(client.field301 >= this.field48) {
                  this.field43 = null;
               }

               if(client.field301 >= this.field54 && client.field301 < this.field48) {
                  var4 = this.field43;
                  var4.method2365(this.field45 - super.field837, this.field44 - this.field42, this.field47 - super.field880);
                  if(super.field871 == 512) {
                     var4.method2383();
                     var4.method2383();
                     var4.method2383();
                  } else if(super.field871 == 1024) {
                     var4.method2383();
                     var4.method2383();
                  } else if(super.field871 == 1536) {
                     var4.method2383();
                  }

                  var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
                  if(super.field871 == 512) {
                     var4.method2383();
                  } else if(super.field871 == 1024) {
                     var4.method2383();
                     var4.method2383();
                  } else if(super.field871 == 1536) {
                     var4.method2383();
                     var4.method2383();
                     var4.method2383();
                  }

                  var4.method2365(super.field837 - this.field45, this.field42 - this.field44, super.field880 - this.field47);
               }
            }

            var3.field1829 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "651536460"
   )
   final void method30(int var1, int var2, byte var3) {
      if(super.field874 < 9) {
         ++super.field874;
      }

      for(int var4 = super.field874; var4 > 0; --var4) {
         super.field875[var4] = super.field875[var4 - 1];
         super.field876[var4] = super.field876[var4 - 1];
         super.field828[var4] = super.field828[var4 - 1];
      }

      super.field875[0] = var1;
      super.field876[0] = var2;
      super.field828[0] = var3;
   }

   class2() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.field39[var1] = "";
      }

      this.field40 = 0;
      this.field41 = 0;
      this.field54 = 0;
      this.field48 = 0;
      this.field53 = false;
      this.field57 = 0;
      this.field46 = false;
      this.field58 = false;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "240"
   )
   void method33(int var1, int var2) {
      super.field874 = 0;
      super.field879 = 0;
      super.field865 = 0;
      super.field875[0] = var1;
      super.field876[0] = var2;
      int var3 = this.method16();
      super.field837 = 128 * super.field875[0] + 64 * var3;
      super.field880 = super.field876[0] * 128 + var3 * 64;
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIZI)V",
      garbageValue = "-1339034448"
   )
   static void method42(class173 var0, int var1, int var2, boolean var3) {
      int var4 = var0.field2769;
      int var5 = var0.field2888;
      if(var0.field2761 == 0) {
         var0.field2769 = var0.field2825;
      } else if(var0.field2761 == 1) {
         var0.field2769 = var1 - var0.field2825;
      } else if(var0.field2761 == 2) {
         var0.field2769 = var1 * var0.field2825 >> 14;
      }

      if(var0.field2762 == 0) {
         var0.field2888 = var0.field2863;
      } else if(var0.field2762 == 1) {
         var0.field2888 = var2 - var0.field2863;
      } else if(var0.field2762 == 2) {
         var0.field2888 = var2 * var0.field2863 >> 14;
      }

      if(var0.field2761 == 4) {
         var0.field2769 = var0.field2888 * var0.field2775 / var0.field2771;
      }

      if(var0.field2762 == 4) {
         var0.field2888 = var0.field2769 * var0.field2771 / var0.field2775;
      }

      if(client.field534 && var0.field2798 == 0) {
         if(var0.field2888 < 5 && var0.field2769 < 5) {
            var0.field2888 = 5;
            var0.field2769 = 5;
         } else {
            if(var0.field2888 <= 0) {
               var0.field2888 = 5;
            }

            if(var0.field2769 <= 0) {
               var0.field2769 = 5;
            }
         }
      }

      if(var0.field2758 == 1337) {
         client.field462 = var0;
      }

      if(var3 && null != var0.field2856 && (var0.field2769 != var4 || var0.field2888 != var5)) {
         class0 var6 = new class0();
         var6.field1 = var0;
         var6.field0 = var0.field2856;
         client.field486.method3877(var6);
      }

   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "103"
   )
   static boolean method43(String var0) {
      if(null == var0) {
         return false;
      } else {
         String var1 = class138.method2969(var0, client.field294);

         for(int var2 = 0; var2 < client.field559; ++var2) {
            class7 var3 = client.field560[var2];
            if(var1.equalsIgnoreCase(class138.method2969(var3.field134, client.field294))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class138.method2969(var3.field137, client.field294))) {
               return true;
            }
         }

         return false;
      }
   }
}
