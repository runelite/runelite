import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public abstract class class170 {
   @ObfuscatedName("p")
   static class119 field2724 = new class119();
   @ObfuscatedName("n")
   int[][] field2725;
   @ObfuscatedName("r")
   int[] field2726;
   @ObfuscatedName("d")
   boolean field2727;
   @ObfuscatedName("s")
   int[] field2729;
   @ObfuscatedName("g")
   int[] field2730;
   @ObfuscatedName("u")
   int[][] field2731;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -760113577
   )
   int field2732;
   @ObfuscatedName("b")
   class195[] field2733;
   @ObfuscatedName("m")
   Object[] field2734;
   @ObfuscatedName("q")
   Object[][] field2735;
   @ObfuscatedName("h")
   int[] field2736;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -434440997
   )
   public int field2737;
   @ObfuscatedName("o")
   boolean field2738;
   @ObfuscatedName("e")
   class195 field2739;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -16655877
   )
   static int field2740 = 0;
   @ObfuscatedName("k")
   int[] field2742;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-866855828"
   )
   void method3393(byte[] var1) {
      this.field2737 = ObjectComposition.method885(var1, var1.length);
      Buffer var2 = new Buffer(class124.method2893(var1));
      int var3 = var2.method2633();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.method2620();
         }

         int var4 = var2.method2633();
         if(var3 >= 7) {
            this.field2732 = var2.method2780();
         } else {
            this.field2732 = var2.method2635();
         }

         int var5 = 0;
         int var6 = -1;
         this.field2730 = new int[this.field2732];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2732; ++var7) {
               this.field2730[var7] = var5 += var2.method2780();
               if(this.field2730[var7] > var6) {
                  var6 = this.field2730[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.field2732; ++var7) {
               this.field2730[var7] = var5 += var2.method2635();
               if(this.field2730[var7] > var6) {
                  var6 = this.field2730[var7];
               }
            }
         }

         this.field2736 = new int[1 + var6];
         this.field2729 = new int[1 + var6];
         this.field2742 = new int[var6 + 1];
         this.field2731 = new int[1 + var6][];
         this.field2734 = new Object[1 + var6];
         this.field2735 = new Object[var6 + 1][];
         if(var4 != 0) {
            this.field2726 = new int[1 + var6];

            for(var7 = 0; var7 < this.field2732; ++var7) {
               this.field2726[this.field2730[var7]] = var2.method2620();
            }

            this.field2739 = new class195(this.field2726);
         }

         for(var7 = 0; var7 < this.field2732; ++var7) {
            this.field2736[this.field2730[var7]] = var2.method2620();
         }

         for(var7 = 0; var7 < this.field2732; ++var7) {
            this.field2729[this.field2730[var7]] = var2.method2620();
         }

         for(var7 = 0; var7 < this.field2732; ++var7) {
            this.field2742[this.field2730[var7]] = var2.method2635();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2732; ++var7) {
               var8 = this.field2730[var7];
               var9 = this.field2742[var8];
               var5 = 0;
               var10 = -1;
               this.field2731[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2731[var8][var11] = var5 += var2.method2780();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2735[var8] = new Object[var10 + 1];
            }
         } else {
            for(var7 = 0; var7 < this.field2732; ++var7) {
               var8 = this.field2730[var7];
               var9 = this.field2742[var8];
               var5 = 0;
               var10 = -1;
               this.field2731[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2731[var8][var11] = var5 += var2.method2635();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2735[var8] = new Object[var10 + 1];
            }
         }

         if(var4 != 0) {
            this.field2725 = new int[1 + var6][];
            this.field2733 = new class195[1 + var6];

            for(var7 = 0; var7 < this.field2732; ++var7) {
               var8 = this.field2730[var7];
               var9 = this.field2742[var8];
               this.field2725[var8] = new int[this.field2735[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.field2725[var8][this.field2731[var8][var10]] = var2.method2620();
               }

               this.field2733[var8] = new class195(this.field2725[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-366929248"
   )
   void vmethod3485(int var1) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "2041452531"
   )
   public int[] method3395(int var1) {
      return this.field2731[var1];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II[IB)[B",
      garbageValue = "12"
   )
   public byte[] method3396(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2735.length && null != this.field2735[var1] && var2 >= 0 && var2 < this.field2735[var1].length) {
         if(null == this.field2735[var1][var2]) {
            boolean var4 = this.method3409(var1, var3);
            if(!var4) {
               this.vmethod3508(var1);
               var4 = this.method3409(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class47.method1004(this.field2735[var1][var2], false);
         if(this.field2727) {
            this.field2735[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-366557879"
   )
   public byte[] method3401(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2735.length && null != this.field2735[var1] && var2 >= 0 && var2 < this.field2735[var1].length) {
         if(null == this.field2735[var1][var2]) {
            boolean var3 = this.method3409(var1, (int[])null);
            if(!var3) {
               this.vmethod3508(var1);
               var3 = this.method3409(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class47.method1004(this.field2735[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1040151244"
   )
   public byte[] method3402(int var1) {
      if(this.field2735.length == 1) {
         return this.method3411(0, var1);
      } else if(this.field2735[var1].length == 1) {
         return this.method3411(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "585180784"
   )
   void vmethod3508(int var1) {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1823117590"
   )
   public int method3405(int var1) {
      return this.field2735[var1].length;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-102"
   )
   public int method3406() {
      return this.field2735.length;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1356940082"
   )
   public void method3407(int var1) {
      for(int var2 = 0; var2 < this.field2735[var1].length; ++var2) {
         this.field2735[var1][var2] = null;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1866161659"
   )
   public void method3408() {
      for(int var1 = 0; var1 < this.field2735.length; ++var1) {
         if(this.field2735[var1] != null) {
            for(int var2 = 0; var2 < this.field2735[var1].length; ++var2) {
               this.field2735[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "-1188602727"
   )
   boolean method3409(int var1, int[] var2) {
      if(this.field2734[var1] == null) {
         return false;
      } else {
         int var3 = this.field2742[var1];
         int[] var4 = this.field2731[var1];
         Object[] var5 = this.field2735[var1];
         boolean var6 = true;

         for(int var7 = 0; var7 < var3; ++var7) {
            if(var5[var4[var7]] == null) {
               var6 = false;
               break;
            }
         }

         if(var6) {
            return true;
         } else {
            byte[] var18;
            if(var2 == null || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
               var18 = class47.method1004(this.field2734[var1], false);
            } else {
               var18 = class47.method1004(this.field2734[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method2653(var2, 5, var8.payload.length);
            }

            byte[] var19 = class124.method2893(var18);
            if(this.field2738) {
               this.field2734[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var19.length;
               --var9;
               int var10 = var19[var9] & 255;
               var9 -= var3 * var10 * 4;
               Buffer var11 = new Buffer(var19);
               int[] var12 = new int[var3];
               var11.offset = var9;

               int var13;
               int var14;
               for(int var15 = 0; var15 < var10; ++var15) {
                  var13 = 0;

                  for(var14 = 0; var14 < var3; ++var14) {
                     var13 += var11.method2620();
                     var12[var14] += var13;
                  }
               }

               byte[][] var20 = new byte[var3][];

               for(var13 = 0; var13 < var3; ++var13) {
                  var20[var13] = new byte[var12[var13]];
                  var12[var13] = 0;
               }

               var11.offset = var9;
               var13 = 0;

               for(var14 = 0; var14 < var10; ++var14) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2620();
                     System.arraycopy(var19, var13, var20[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var13 += var16;
                  }
               }

               for(var14 = 0; var14 < var3; ++var14) {
                  if(!this.field2727) {
                     var5[var4[var14]] = class52.method1131(var20[var14], false);
                  } else {
                     var5[var4[var14]] = var20[var14];
                  }
               }
            } else if(!this.field2727) {
               var5[var4[0]] = class52.method1131(var19, false);
            } else {
               var5[var4[0]] = var19;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "99"
   )
   public int method3410(String var1) {
      var1 = var1.toLowerCase();
      return this.field2739.method3899(class151.method3272(var1));
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "99"
   )
   public byte[] method3411(int var1, int var2) {
      return this.method3396(var1, var2, (int[])null);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "119"
   )
   public byte[] method3412(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2739.method3899(class151.method3272(var1));
      int var4 = this.field2733[var3].method3899(class151.method3272(var2));
      return this.method3411(var3, var4);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "35"
   )
   public boolean method3413(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2739.method3899(class151.method3272(var1));
      int var4 = this.field2733[var3].method3899(class151.method3272(var2));
      return this.method3453(var3, var4);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "-4"
   )
   public boolean method3414(String var1) {
      int var2 = this.method3410("");
      return var2 != -1?this.method3413("", var1):this.method3413(var1, "");
   }

   class170(boolean var1, boolean var2) {
      this.field2738 = var1;
      this.field2727 = var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1273885944"
   )
   public boolean method3421(int var1) {
      if(null != this.field2734[var1]) {
         return true;
      } else {
         this.vmethod3508(var1);
         return this.field2734[var1] != null;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-169322697"
   )
   public boolean method3430() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2730.length; ++var2) {
         int var3 = this.field2730[var2];
         if(null == this.field2734[var3]) {
            this.vmethod3508(var3);
            if(this.field2734[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1882385671"
   )
   public void method3446(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2739.method3899(class151.method3272(var1));
      if(var2 >= 0) {
         this.vmethod3485(var2);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1940575240"
   )
   public boolean method3453(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2735.length && null != this.field2735[var1] && var2 >= 0 && var2 < this.field2735[var1].length) {
         if(null != this.field2735[var1][var2]) {
            return true;
         } else if(this.field2734[var1] != null) {
            return true;
         } else {
            this.vmethod3508(var1);
            return this.field2734[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IS)[B",
      garbageValue = "1948"
   )
   public byte[] method3455(int var1) {
      if(this.field2735.length == 1) {
         return this.method3401(0, var1);
      } else if(this.field2735[var1].length == 1) {
         return this.method3401(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "1437946522"
   )
   public int method3459(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2733[var1].method3899(class151.method3272(var2));
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "394714680"
   )
   static final int method3482(int var0, int var1) {
      int var2 = class33.method732(var0 - 1, var1 - 1) + class33.method732(var0 + 1, var1 - 1) + class33.method732(var0 - 1, var1 + 1) + class33.method732(1 + var0, 1 + var1);
      int var3 = class33.method732(var0 - 1, var1) + class33.method732(var0 + 1, var1) + class33.method732(var0, var1 - 1) + class33.method732(var0, 1 + var1);
      int var4 = class33.method732(var0, var1);
      return var3 / 8 + var2 / 16 + var4 / 4;
   }
}
