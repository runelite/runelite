import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public abstract class class167 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -640100531
   )
   int field2668;
   @ObfuscatedName("w")
   int[] field2669;
   @ObfuscatedName("f")
   int[] field2670;
   @ObfuscatedName("y")
   static class116 field2671 = new class116();
   @ObfuscatedName("p")
   int[] field2672;
   @ObfuscatedName("h")
   int[] field2673;
   @ObfuscatedName("g")
   int[] field2674;
   @ObfuscatedName("a")
   int[][] field2675;
   @ObfuscatedName("r")
   int[][] field2676;
   @ObfuscatedName("k")
   class192[] field2677;
   @ObfuscatedName("m")
   Object[] field2678;
   @ObfuscatedName("j")
   boolean field2680;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1752399333
   )
   public int field2681;
   @ObfuscatedName("l")
   boolean field2683;
   @ObfuscatedName("n")
   Object[][] field2684;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -195031745
   )
   static int field2685 = 0;
   @ObfuscatedName("s")
   class192 field2686;

   class167(boolean var1, boolean var2) {
      this.field2680 = var1;
      this.field2683 = var2;
   }

   @ObfuscatedName("w")
   void vmethod3324(int var1) {
   }

   @ObfuscatedName("c")
   public int method3255(String var1) {
      var1 = var1.toLowerCase();
      return this.field2686.method3749(class27.method648(var1));
   }

   @ObfuscatedName("i")
   public int method3257() {
      return this.field2684.length;
   }

   @ObfuscatedName("h")
   public boolean method3258(int var1) {
      if(null != this.field2678[var1]) {
         return true;
      } else {
         this.vmethod3325(var1);
         return this.field2678[var1] != null;
      }
   }

   @ObfuscatedName("g")
   public boolean method3259() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2669.length; ++var2) {
         int var3 = this.field2669[var2];
         if(null == this.field2678[var3]) {
            this.vmethod3325(var3);
            if(null == this.field2678[var3]) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("a")
   public byte[] method3260(int var1) {
      if(1 == this.field2684.length) {
         return this.method3280(0, var1);
      } else if(1 == this.field2684[var1].length) {
         return this.method3280(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("r")
   public byte[] method3261(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2684.length && this.field2684[var1] != null && var2 >= 0 && var2 < this.field2684[var1].length) {
         if(null == this.field2684[var1][var2]) {
            boolean var3 = this.method3269(var1, (int[])null);
            if(!var3) {
               this.vmethod3325(var1);
               var3 = this.method3269(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class99.method2212(this.field2684[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("k")
   public byte[] method3262(int var1) {
      if(1 == this.field2684.length) {
         return this.method3261(0, var1);
      } else if(this.field2684[var1].length == 1) {
         return this.method3261(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("m")
   void vmethod3325(int var1) {
   }

   @ObfuscatedName("p")
   public boolean method3264(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2684.length && this.field2684[var1] != null && var2 >= 0 && var2 < this.field2684[var1].length) {
         if(this.field2684[var1][var2] != null) {
            return true;
         } else if(null != this.field2678[var1]) {
            return true;
         } else {
            this.vmethod3325(var1);
            return this.field2678[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("n")
   public int[] method3265(int var1) {
      return this.field2675[var1];
   }

   @ObfuscatedName("j")
   public void method3267(int var1) {
      for(int var2 = 0; var2 < this.field2684[var1].length; ++var2) {
         this.field2684[var1][var2] = null;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-56728448"
   )
   public void method3268() {
      for(int var1 = 0; var1 < this.field2684.length; ++var1) {
         if(null != this.field2684[var1]) {
            for(int var2 = 0; var2 < this.field2684[var1].length; ++var2) {
               this.field2684[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("o")
   boolean method3269(int var1, int[] var2) {
      if(null == this.field2678[var1]) {
         return false;
      } else {
         int var3 = this.field2674[var1];
         int[] var4 = this.field2675[var1];
         Object[] var5 = this.field2684[var1];
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
            if(var2 == null || var2[0] == 0 && 0 == var2[1] && var2[2] == 0 && var2[3] == 0) {
               var18 = class99.method2212(this.field2678[var1], false);
            } else {
               var18 = class99.method2212(this.field2678[var1], true);
               class119 var8 = new class119(var18);
               var8.method2542(var2, 5, var8.field1980.length);
            }

            byte[] var19 = class111.method2447(var18);
            if(this.field2680) {
               this.field2678[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var19.length;
               --var9;
               int var10 = var19[var9] & 255;
               var9 -= 4 * var10 * var3;
               class119 var11 = new class119(var19);
               int[] var12 = new int[var3];
               var11.field1976 = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2528();
                     var12[var15] += var14;
                  }
               }

               byte[][] var20 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var20[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.field1976 = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2528();
                     System.arraycopy(var19, var14, var20[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2683) {
                     var5[var4[var15]] = class36.method734(var20[var15]);
                  } else {
                     var5[var4[var15]] = var20[var15];
                  }
               }
            } else if(!this.field2683) {
               var5[var4[0]] = class36.method734(var19);
            } else {
               var5[var4[0]] = var19;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("s")
   public byte[] method3270(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2684.length && this.field2684[var1] != null && var2 >= 0 && var2 < this.field2684[var1].length) {
         if(this.field2684[var1][var2] == null) {
            boolean var4 = this.method3269(var1, var3);
            if(!var4) {
               this.vmethod3325(var1);
               var4 = this.method3269(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class99.method2212(this.field2684[var1][var2], false);
         if(this.field2683) {
            this.field2684[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("x")
   public int method3271(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2677[var1].method3749(class27.method648(var2));
   }

   @ObfuscatedName("q")
   public boolean method3273(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2686.method3749(class27.method648(var1));
      int var4 = this.field2677[var3].method3749(class27.method648(var2));
      return this.method3264(var3, var4);
   }

   @ObfuscatedName("t")
   public void method3275(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2686.method3749(class27.method648(var1));
      if(var2 >= 0) {
         this.vmethod3324(var2);
      }
   }

   @ObfuscatedName("f")
   public byte[] method3280(int var1, int var2) {
      return this.method3270(var1, var2, (int[])null);
   }

   @ObfuscatedName("u")
   public boolean method3299(String var1) {
      int var2 = this.method3255("");
      return var2 != -1?this.method3273("", var1):this.method3273(var1, "");
   }

   @ObfuscatedName("b")
   public byte[] method3305(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2686.method3749(class27.method648(var1));
      int var4 = this.field2677[var3].method3749(class27.method648(var2));
      return this.method3280(var3, var4);
   }

   @ObfuscatedName("y")
   public int method3307(int var1) {
      return this.field2684[var1].length;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1353404822"
   )
   void method3319(byte[] var1) {
      this.field2681 = class141.method2978(var1, var1.length);
      class119 var2 = new class119(class111.method2447(var1));
      int var3 = var2.method2523();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.method2528();
         }

         int var4 = var2.method2523();
         if(var3 >= 7) {
            this.field2668 = var2.method2537();
         } else {
            this.field2668 = var2.method2700();
         }

         int var5 = 0;
         int var6 = -1;
         this.field2669 = new int[this.field2668];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2668; ++var7) {
               this.field2669[var7] = var5 += var2.method2537();
               if(this.field2669[var7] > var6) {
                  var6 = this.field2669[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.field2668; ++var7) {
               this.field2669[var7] = var5 += var2.method2700();
               if(this.field2669[var7] > var6) {
                  var6 = this.field2669[var7];
               }
            }
         }

         this.field2672 = new int[1 + var6];
         this.field2673 = new int[1 + var6];
         this.field2674 = new int[var6 + 1];
         this.field2675 = new int[var6 + 1][];
         this.field2678 = new Object[var6 + 1];
         this.field2684 = new Object[1 + var6][];
         if(0 != var4) {
            this.field2670 = new int[1 + var6];

            for(var7 = 0; var7 < this.field2668; ++var7) {
               this.field2670[this.field2669[var7]] = var2.method2528();
            }

            this.field2686 = new class192(this.field2670);
         }

         for(var7 = 0; var7 < this.field2668; ++var7) {
            this.field2672[this.field2669[var7]] = var2.method2528();
         }

         for(var7 = 0; var7 < this.field2668; ++var7) {
            this.field2673[this.field2669[var7]] = var2.method2528();
         }

         for(var7 = 0; var7 < this.field2668; ++var7) {
            this.field2674[this.field2669[var7]] = var2.method2700();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2668; ++var7) {
               var8 = this.field2669[var7];
               var9 = this.field2674[var8];
               var5 = 0;
               var10 = -1;
               this.field2675[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2675[var8][var11] = var5 += var2.method2537();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2684[var8] = new Object[1 + var10];
            }
         } else {
            for(var7 = 0; var7 < this.field2668; ++var7) {
               var8 = this.field2669[var7];
               var9 = this.field2674[var8];
               var5 = 0;
               var10 = -1;
               this.field2675[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2675[var8][var11] = var5 += var2.method2700();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2684[var8] = new Object[1 + var10];
            }
         }

         if(var4 != 0) {
            this.field2676 = new int[1 + var6][];
            this.field2677 = new class192[1 + var6];

            for(var7 = 0; var7 < this.field2668; ++var7) {
               var8 = this.field2669[var7];
               var9 = this.field2674[var8];
               this.field2676[var8] = new int[this.field2684[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.field2676[var8][this.field2675[var8][var10]] = var2.method2528();
               }

               this.field2677[var8] = new class192(this.field2676[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("a")
   public static void method3320() {
      class44.field1003.method3760();
   }

   @ObfuscatedName("f")
   public static void method3321(int var0, class167 var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.method3255(var2);
      int var7 = var1.method3271(var6, var3);
      class183.field2958 = 1;
      class14.field209 = var1;
      class148.field2219 = var6;
      class164.field2656 = var7;
      class96.field1611 = var4;
      class125.field2030 = var5;
      class209.field3118 = var0;
   }
}
