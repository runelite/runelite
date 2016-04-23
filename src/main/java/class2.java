import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("Player")
public final class class2 extends class37 {
   @ObfuscatedName("w")
   boolean field35;
   @ObfuscatedName("h")
   @Export("composition")
   class179 field36;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1708535135
   )
   int field37 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -323547261
   )
   int field38;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1577175653
   )
   int field39;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2020990467
   )
   int field40 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1591891547
   )
   @Export("combatLevel")
   int field41;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1243059053
   )
   int field43;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1579666651
   )
   @Export("totalLevel")
   int field44;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1733480655
   )
   int field45;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -249147045
   )
   int field46;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2060060309
   )
   int field47;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1034426771
   )
   int field48;
   @ObfuscatedName("p")
   @Export("model")
   class105 field49;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1788955145
   )
   int field50;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 381058917
   )
   int field51;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 126369665
   )
   int field52;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -441392383
   )
   int field53;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1950525641
   )
   int field54;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -5436303
   )
   @Export("team")
   int field55;
   @ObfuscatedName("s")
   boolean field56;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1765762019
   )
   int field57;
   @ObfuscatedName("j")
   @Export("name")
   String field58;
   @ObfuscatedName("v")
   boolean field59;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -678904851
   )
   int field60;
   @ObfuscatedName("e")
   String[] field61 = new String[3];
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = -1056960677
   )
   static int field62;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "-35"
   )
   final void method8(class119 var1) {
      var1.field1971 = 0;
      int var2 = var1.method2500();
      this.field37 = var1.method2670();
      this.field40 = var1.method2670();
      int var3 = -1;
      this.field55 = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.method2500();
         if(var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.method2500();
            var4[var5] = (var6 << 8) + var7;
            if(0 == var5 && var4[0] == '\uffff') {
               var3 = var1.method2502();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = class89.method2081(var4[var5] - 512).field1130;
               if(0 != var8) {
                  this.field55 = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2500();
         if(var7 < 0 || var7 >= class89.field1535[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.field799 = var1.method2502();
      if(super.field799 == '\uffff') {
         super.field799 = -1;
      }

      super.field800 = var1.method2502();
      if('\uffff' == super.field800) {
         super.field800 = -1;
      }

      super.field804 = super.field800;
      super.field802 = var1.method2502();
      if(super.field802 == '\uffff') {
         super.field802 = -1;
      }

      super.field803 = var1.method2502();
      if(super.field803 == '\uffff') {
         super.field803 = -1;
      }

      super.field851 = var1.method2502();
      if('\uffff' == super.field851) {
         super.field851 = -1;
      }

      super.field847 = var1.method2502();
      if(super.field847 == '\uffff') {
         super.field847 = -1;
      }

      super.field806 = var1.method2502();
      if('\uffff' == super.field806) {
         super.field806 = -1;
      }

      this.field58 = var1.method2508();
      if(class47.field1053 == this) {
         class148.field2201 = this.field58;
      }

      this.field41 = var1.method2500();
      this.field39 = var1.method2502();
      this.field56 = var1.method2500() == 1;
      if(0 == client.field431 && client.field440 >= 2) {
         this.field56 = false;
      }

      if(this.field36 == null) {
         this.field36 = new class179();
      }

      this.field36.method3438(var4, var9, 1 == var2, var3);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1904135544"
   )
   int method10() {
      return null != this.field36 && this.field36.field2921 != -1?class156.method3130(this.field36.field2921).field868:1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "-1145523992"
   )
   protected final class105 vmethod1900() {
      if(this.field36 == null) {
         return null;
      } else {
         class42 var1 = -1 != super.field825 && super.field849 == 0?class161.method3153(super.field825):null;
         class42 var2 = -1 == super.field854 || this.field35 || super.field799 == super.field854 && var1 != null?null:class161.method3153(super.field854);
         class105 var3 = this.field36.method3444(var1, super.field826, var2, super.field798);
         if(var3 == null) {
            return null;
         } else {
            var3.method2335();
            super.field794 = var3.field1443;
            class105 var4;
            class105[] var5;
            if(!this.field35 && -1 != super.field856 && -1 != super.field831) {
               var4 = class19.method239(super.field856).method888(super.field831);
               if(var4 != null) {
                  var4.method2297(0, -super.field834, 0);
                  var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
               }
            }

            if(!this.field35 && null != this.field49) {
               if(client.field285 >= this.field45) {
                  this.field49 = null;
               }

               if(client.field285 >= this.field44 && client.field285 < this.field45) {
                  var4 = this.field49;
                  var4.method2297(this.field46 - super.field816, this.field54 - this.field43, this.field48 - super.field840);
                  if(super.field844 == 512) {
                     var4.method2293();
                     var4.method2293();
                     var4.method2293();
                  } else if(1024 == super.field844) {
                     var4.method2293();
                     var4.method2293();
                  } else if(super.field844 == 1536) {
                     var4.method2293();
                  }

                  var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
                  if(512 == super.field844) {
                     var4.method2293();
                  } else if(1024 == super.field844) {
                     var4.method2293();
                     var4.method2293();
                  } else if(1536 == super.field844) {
                     var4.method2293();
                     var4.method2293();
                     var4.method2293();
                  }

                  var4.method2297(super.field816 - this.field46, this.field43 - this.field54, super.field840 - this.field48);
               }
            }

            var3.field1809 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "96"
   )
   void method13(int var1, int var2) {
      super.field820 = 0;
      super.field852 = 0;
      super.field823 = 0;
      super.field848[0] = var1;
      super.field822[0] = var2;
      int var3 = this.method10();
      super.field816 = var3 * 64 + super.field848[0] * 128;
      super.field840 = var3 * 64 + 128 * super.field822[0];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "20"
   )
   final void method14(int var1, int var2, byte var3) {
      if(super.field820 < 9) {
         ++super.field820;
      }

      for(int var4 = super.field820; var4 > 0; --var4) {
         super.field848[var4] = super.field848[var4 - 1];
         super.field822[var4] = super.field822[var4 - 1];
         super.field850[var4] = super.field850[var4 - 1];
      }

      super.field848[0] = var1;
      super.field822[0] = var2;
      super.field850[0] = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-216843888"
   )
   final boolean vmethod742() {
      return null != this.field36;
   }

   class2() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.field61[var1] = "";
      }

      this.field41 = 0;
      this.field39 = 0;
      this.field44 = 0;
      this.field45 = 0;
      this.field35 = false;
      this.field55 = 0;
      this.field56 = false;
      this.field59 = false;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "126"
   )
   final void method26(int var1, int var2, byte var3) {
      if(-1 != super.field825 && class161.method3153(super.field825).field976 == 1) {
         super.field825 = -1;
      }

      super.field821 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.field848[0] >= 0 && super.field848[0] < 104 && super.field822[0] >= 0 && super.field822[0] < 104) {
            if(var3 == 2) {
               class2 var4 = this;
               int var5 = super.field848[0];
               int var6 = super.field822[0];
               int var7 = this.method10();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var10 = this.method10();
                  client.field552.field1861 = var1;
                  client.field552.field1859 = var2;
                  client.field552.field1858 = 1;
                  client.field552.field1863 = 1;
                  class10 var11 = client.field552;
                  int var12 = client.method312(var5, var6, var10, var11, client.field482[this.field57], true, client.field553, client.field554);
                  if(var12 >= 1) {
                     for(int var13 = 0; var13 < var12 - 1; ++var13) {
                        var4.method14(client.field553[var13], client.field554[var13], (byte)2);
                     }
                  }
               }
            }

            this.method14(var1, var2, var3);
         } else {
            this.method13(var1, var2);
         }
      } else {
         this.method13(var1, var2);
      }

   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)V",
      garbageValue = "-1743868050"
   )
   static void method28(class173 var0) {
      if(client.field477 == var0.field2876) {
         client.field478[var0.field2734] = true;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "868450064"
   )
   public static final boolean method29() {
      class137 var0 = class137.field2089;
      synchronized(class137.field2089) {
         if(class137.field2106 == class137.field2092) {
            return false;
         } else {
            class188.field3056 = class137.field2101[class137.field2092];
            class137.field2081 = class137.field2100[class137.field2092];
            class137.field2092 = class137.field2092 + 1 & 127;
            return true;
         }
      }
   }
}
