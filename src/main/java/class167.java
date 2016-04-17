import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public abstract class class167 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 104880609
   )
   static int field2659 = 0;
   @ObfuscatedName("w")
   int[] field2660;
   @ObfuscatedName("d")
   int[] field2661;
   @ObfuscatedName("c")
   class192 field2662;
   @ObfuscatedName("y")
   int[] field2663;
   @ObfuscatedName("k")
   int[] field2664;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = -606515903
   )
   static int field2665;
   @ObfuscatedName("e")
   Object[] field2666;
   @ObfuscatedName("r")
   int[] field2667;
   @ObfuscatedName("m")
   class192[] field2668;
   @ObfuscatedName("x")
   Object[][] field2670;
   @ObfuscatedName("z")
   static class116 field2671 = new class116();
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 517909341
   )
   public int field2672;
   @ObfuscatedName("t")
   boolean field2673;
   @ObfuscatedName("q")
   int[][] field2674;
   @ObfuscatedName("n")
   boolean field2675;
   @ObfuscatedName("p")
   int[][] field2679;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2057652661
   )
   int field2681;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BS)V",
      garbageValue = "22419"
   )
   void method3360(byte[] var1) {
      this.field2672 = class41.method946(var1, var1.length);
      class119 var2 = new class119(class111.method2531(var1));
      int var3 = var2.method2613();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.method2618();
         }

         int var4 = var2.method2613();
         if(var3 >= 7) {
            this.field2681 = var2.method2734();
         } else {
            this.field2681 = var2.method2615();
         }

         int var5 = 0;
         int var6 = -1;
         this.field2660 = new int[this.field2681];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2681; ++var7) {
               this.field2660[var7] = var5 += var2.method2734();
               if(this.field2660[var7] > var6) {
                  var6 = this.field2660[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.field2681; ++var7) {
               this.field2660[var7] = var5 += var2.method2615();
               if(this.field2660[var7] > var6) {
                  var6 = this.field2660[var7];
               }
            }
         }

         this.field2663 = new int[var6 + 1];
         this.field2664 = new int[1 + var6];
         this.field2667 = new int[var6 + 1];
         this.field2679 = new int[var6 + 1][];
         this.field2666 = new Object[1 + var6];
         this.field2670 = new Object[var6 + 1][];
         if(0 != var4) {
            this.field2661 = new int[var6 + 1];

            for(var7 = 0; var7 < this.field2681; ++var7) {
               this.field2661[this.field2660[var7]] = var2.method2618();
            }

            this.field2662 = new class192(this.field2661);
         }

         for(var7 = 0; var7 < this.field2681; ++var7) {
            this.field2663[this.field2660[var7]] = var2.method2618();
         }

         for(var7 = 0; var7 < this.field2681; ++var7) {
            this.field2664[this.field2660[var7]] = var2.method2618();
         }

         for(var7 = 0; var7 < this.field2681; ++var7) {
            this.field2667[this.field2660[var7]] = var2.method2615();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2681; ++var7) {
               var8 = this.field2660[var7];
               var9 = this.field2667[var8];
               var5 = 0;
               var10 = -1;
               this.field2679[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2679[var8][var11] = var5 += var2.method2734();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2670[var8] = new Object[var10 + 1];
            }
         } else {
            for(var7 = 0; var7 < this.field2681; ++var7) {
               var8 = this.field2660[var7];
               var9 = this.field2667[var8];
               var5 = 0;
               var10 = -1;
               this.field2679[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2679[var8][var11] = var5 += var2.method2615();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2670[var8] = new Object[var10 + 1];
            }
         }

         if(0 != var4) {
            this.field2674 = new int[var6 + 1][];
            this.field2668 = new class192[1 + var6];

            for(var7 = 0; var7 < this.field2681; ++var7) {
               var8 = this.field2660[var7];
               var9 = this.field2667[var8];
               this.field2674[var8] = new int[this.field2670[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.field2674[var8][this.field2679[var8][var10]] = var2.method2618();
               }

               this.field2668[var8] = new class192(this.field2674[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2110155430"
   )
   void vmethod3459(int var1) {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II[IB)[B",
      garbageValue = "0"
   )
   public byte[] method3363(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2670.length && null != this.field2670[var1] && var2 >= 0 && var2 < this.field2670[var1].length) {
         if(null == this.field2670[var1][var2]) {
            boolean var4 = this.method3376(var1, var3);
            if(!var4) {
               this.vmethod3441(var1);
               var4 = this.method3376(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class41.method945(this.field2670[var1][var2], false);
         if(this.field2675) {
            this.field2670[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-593941303"
   )
   public boolean method3366() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2660.length; ++var2) {
         int var3 = this.field2660[var2];
         if(this.field2666[var3] == null) {
            this.vmethod3441(var3);
            if(this.field2666[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1898090196"
   )
   public int[] method3368(int var1) {
      return this.field2679[var1];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "0"
   )
   public byte[] method3369(int var1) {
      if(1 == this.field2670.length) {
         return this.method3432(0, var1);
      } else if(this.field2670[var1].length == 1) {
         return this.method3432(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1936242067"
   )
   public int method3372(int var1) {
      return this.field2670[var1].length;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "985286324"
   )
   public boolean method3373(int var1) {
      if(this.field2666[var1] != null) {
         return true;
      } else {
         this.vmethod3441(var1);
         return null != this.field2666[var1];
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "-850154999"
   )
   boolean method3376(int var1, int[] var2) {
      if(this.field2666[var1] == null) {
         return false;
      } else {
         int var3 = this.field2667[var1];
         int[] var4 = this.field2679[var1];
         Object[] var5 = this.field2670[var1];
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
            if(var2 == null || var2[0] == 0 && var2[1] == 0 && 0 == var2[2] && 0 == var2[3]) {
               var18 = class41.method945(this.field2666[var1], false);
            } else {
               var18 = class41.method945(this.field2666[var1], true);
               class119 var8 = new class119(var18);
               var8.method2644(var2, 5, var8.field1993.length);
            }

            byte[] var19 = class111.method2531(var18);
            if(this.field2673) {
               this.field2666[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var19.length;
               --var9;
               int var10 = var19[var9] & 255;
               var9 -= var3 * var10 * 4;
               class119 var11 = new class119(var19);
               int[] var12 = new int[var3];
               var11.field1992 = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2618();
                     var12[var15] += var14;
                  }
               }

               byte[][] var20 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var20[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.field1992 = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2618();
                     System.arraycopy(var19, var14, var20[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2675) {
                     var5[var4[var15]] = class94.method2253(var20[var15], false);
                  } else {
                     var5[var4[var15]] = var20[var15];
                  }
               }
            } else if(!this.field2675) {
               var5[var4[0]] = class94.method2253(var19, false);
            } else {
               var5[var4[0]] = var19;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-71532500"
   )
   public int method3377(String var1) {
      var1 = var1.toLowerCase();
      return this.field2662.method3835(class29.method746(var1));
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)I",
      garbageValue = "1"
   )
   public int method3378(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2668[var1].method3835(class29.method746(var2));
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-1012362147"
   )
   public boolean method3380(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2662.method3835(class29.method746(var1));
      int var4 = this.field2668[var3].method3835(class29.method746(var2));
      return this.method3429(var3, var4);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)Z",
      garbageValue = "1299"
   )
   public boolean method3381(String var1) {
      int var2 = this.method3377("");
      return var2 != -1?this.method3380("", var1):this.method3380(var1, "");
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-118"
   )
   public void method3384(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2662.method3835(class29.method746(var1));
      if(var2 >= 0) {
         this.vmethod3459(var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "1828046896"
   )
   public byte[] method3391(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2662.method3835(class29.method746(var1));
      int var4 = this.field2668[var3].method3835(class29.method746(var2));
      return this.method3403(var3, var4);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-297177099"
   )
   void vmethod3441(int var1) {
   }

   class167(boolean var1, boolean var2) {
      this.field2673 = var1;
      this.field2675 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "1152946000"
   )
   public byte[] method3403(int var1, int var2) {
      return this.method3363(var1, var2, (int[])null);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public void method3408() {
      for(int var1 = 0; var1 < this.field2670.length; ++var1) {
         if(this.field2670[var1] != null) {
            for(int var2 = 0; var2 < this.field2670[var1].length; ++var2) {
               this.field2670[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1888489728"
   )
   public int method3411() {
      return this.field2670.length;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-22"
   )
   public byte[] method3414(int var1) {
      if(this.field2670.length == 1) {
         return this.method3403(0, var1);
      } else if(this.field2670[var1].length == 1) {
         return this.method3403(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-112"
   )
   public void method3416(int var1) {
      for(int var2 = 0; var2 < this.field2670[var1].length; ++var2) {
         this.field2670[var1][var2] = null;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-28"
   )
   public boolean method3429(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2670.length && this.field2670[var1] != null && var2 >= 0 && var2 < this.field2670[var1].length) {
         if(null != this.field2670[var1][var2]) {
            return true;
         } else if(null != this.field2666[var1]) {
            return true;
         } else {
            this.vmethod3441(var1);
            return null != this.field2666[var1];
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "38"
   )
   public byte[] method3432(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2670.length && null != this.field2670[var1] && var2 >= 0 && var2 < this.field2670[var1].length) {
         if(this.field2670[var1][var2] == null) {
            boolean var3 = this.method3376(var1, (int[])null);
            if(!var3) {
               this.vmethod3441(var1);
               var3 = this.method3376(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class41.method945(this.field2670[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "1"
   )
   static final void method3436(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         class134.field2078.field147 = !class134.field2078.field147;
         class213.method4031();
         if(class134.field2078.field147) {
            class129.method2943(99, "", "Roofs are now all hidden");
         } else {
            class129.method2943(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         client.field312 = !client.field312;
      }

      if(client.field345 >= 2) {
         if(var0.equalsIgnoreCase("fpson")) {
            client.field312 = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            client.field312 = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            class191.method3834();
         }

         if(var0.equalsIgnoreCase("errortest") && client.field352 == 2) {
            throw new RuntimeException();
         }
      }

      client.field338.method2873(252);
      client.field338.method2603(var0.length() + 1);
      client.field338.method2694(var0);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "340354133"
   )
   public static int method3437() {
      return class137.field2127;
   }
}
