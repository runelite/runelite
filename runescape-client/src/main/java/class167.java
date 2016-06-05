import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public abstract class class167 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -693221559
   )
   static int field2700 = 0;
   @ObfuscatedName("i")
   int[] field2701;
   @ObfuscatedName("f")
   int[] field2702;
   @ObfuscatedName("h")
   class192 field2703;
   @ObfuscatedName("y")
   Object[] field2704;
   @ObfuscatedName("g")
   int[] field2705;
   @ObfuscatedName("k")
   static class116 field2706 = new class116();
   @ObfuscatedName("z")
   int[] field2707;
   @ObfuscatedName("d")
   int[][] field2708;
   @ObfuscatedName("l")
   class192[] field2709;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -91641013
   )
   int field2710;
   @ObfuscatedName("p")
   Object[][] field2711;
   @ObfuscatedName("s")
   int[][] field2712;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1267427377
   )
   public int field2713;
   @ObfuscatedName("b")
   boolean field2714;
   @ObfuscatedName("j")
   boolean field2715;
   @ObfuscatedName("r")
   int[] field2716;
   @ObfuscatedName("af")
   static class78[] field2717;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "63"
   )
   void vmethod3306(int var1) {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-1111515330"
   )
   public byte[] method3221(int var1, int var2) {
      return this.method3222(var1, var2, (int[])null);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II[IB)[B",
      garbageValue = "8"
   )
   public byte[] method3222(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2711.length && this.field2711[var1] != null && var2 >= 0 && var2 < this.field2711[var1].length) {
         if(this.field2711[var1][var2] == null) {
            boolean var4 = this.method3235(var1, var3);
            if(!var4) {
               this.vmethod3307(var1);
               var4 = this.method3235(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class155.method3135(this.field2711[var1][var2], false);
         if(this.field2715) {
            this.field2711[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "3"
   )
   public boolean method3224(int var1) {
      if(this.field2704[var1] != null) {
         return true;
      } else {
         this.vmethod3307(var1);
         return null != this.field2704[var1];
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1442703093"
   )
   public boolean method3225() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2701.length; ++var2) {
         int var3 = this.field2701[var2];
         if(this.field2704[var3] == null) {
            this.vmethod3307(var3);
            if(null == this.field2704[var3]) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "1801857740"
   )
   public boolean method3227(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2703.method3710(class119.method2667(var1));
      int var4 = this.field2709[var3].method3710(class119.method2667(var2));
      return this.method3259(var3, var4);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2127739612"
   )
   void vmethod3307(int var1) {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "2115829463"
   )
   public int[] method3230(int var1) {
      return this.field2712[var1];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-989643636"
   )
   public int method3231(int var1) {
      return this.field2711[var1].length;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "858349601"
   )
   public int method3232() {
      return this.field2711.length;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1216401918"
   )
   public void method3233(int var1) {
      for(int var2 = 0; var2 < this.field2711[var1].length; ++var2) {
         this.field2711[var1][var2] = null;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I[IB)Z",
      garbageValue = "86"
   )
   boolean method3235(int var1, int[] var2) {
      if(this.field2704[var1] == null) {
         return false;
      } else {
         int var3 = this.field2702[var1];
         int[] var4 = this.field2712[var1];
         Object[] var5 = this.field2711[var1];
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
            if(null == var2 || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
               var18 = class155.method3135(this.field2704[var1], false);
            } else {
               var18 = class155.method3135(this.field2704[var1], true);
               class119 var8 = new class119(var18);
               var8.method2487(var2, 5, var8.field2001.length);
            }

            byte[] var20 = class137.method2904(var18);
            if(this.field2714) {
               this.field2704[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= var3 * var10 * 4;
               class119 var11 = new class119(var20);
               int[] var12 = new int[var3];
               var11.field2000 = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2505();
                     var12[var15] += var14;
                  }
               }

               byte[][] var19 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var19[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.field2000 = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2505();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2715) {
                     var5[var4[var15]] = class111.method2388(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2715) {
               var5[var4[0]] = class111.method2388(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "-8"
   )
   public int method3236(String var1) {
      var1 = var1.toLowerCase();
      return this.field2703.method3710(class119.method2667(var1));
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "-635260943"
   )
   public int method3237(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2709[var1].method3710(class119.method2667(var2));
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-46117486"
   )
   public void method3238() {
      for(int var1 = 0; var1 < this.field2711.length; ++var1) {
         if(this.field2711[var1] != null) {
            for(int var2 = 0; var2 < this.field2711[var1].length; ++var2) {
               this.field2711[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "-52"
   )
   public byte[] method3240(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2711.length && this.field2711[var1] != null && var2 >= 0 && var2 < this.field2711[var1].length) {
         if(null == this.field2711[var1][var2]) {
            boolean var3 = this.method3235(var1, (int[])null);
            if(!var3) {
               this.vmethod3307(var1);
               var3 = this.method3235(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class155.method3135(this.field2711[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1777220749"
   )
   public void method3241(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2703.method3710(class119.method2667(var1));
      if(var2 >= 0) {
         this.vmethod3306(var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-979494635"
   )
   public boolean method3259(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2711.length && null != this.field2711[var1] && var2 >= 0 && var2 < this.field2711[var1].length) {
         if(this.field2711[var1][var2] != null) {
            return true;
         } else if(null != this.field2704[var1]) {
            return true;
         } else {
            this.vmethod3307(var1);
            return this.field2704[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1003187981"
   )
   public byte[] method3275(int var1) {
      if(this.field2711.length == 1) {
         return this.method3221(0, var1);
      } else if(this.field2711[var1].length == 1) {
         return this.method3221(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "106"
   )
   public byte[] method3279(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2703.method3710(class119.method2667(var1));
      int var4 = this.field2709[var3].method3710(class119.method2667(var2));
      return this.method3221(var3, var4);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "72"
   )
   public boolean method3281(String var1) {
      int var2 = this.method3236("");
      return var2 != -1?this.method3227("", var1):this.method3227(var1, "");
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1330754614"
   )
   public byte[] method3291(int var1) {
      if(this.field2711.length == 1) {
         return this.method3240(0, var1);
      } else if(this.field2711[var1].length == 1) {
         return this.method3240(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   class167(boolean var1, boolean var2) {
      this.field2714 = var1;
      this.field2715 = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-185144799"
   )
   void method3297(byte[] var1) {
      int var3 = var1.length;
      int var2 = class155.method3131(var1, 0, var3);
      this.field2713 = var2;
      class119 var4 = new class119(class137.method2904(var1));
      int var5 = var4.method2494();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var4.method2505();
         }

         int var6 = var4.method2494();
         if(var5 >= 7) {
            this.field2710 = var4.method2482();
         } else {
            this.field2710 = var4.method2470();
         }

         int var7 = 0;
         int var8 = -1;
         this.field2701 = new int[this.field2710];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2710; ++var9) {
               this.field2701[var9] = var7 += var4.method2482();
               if(this.field2701[var9] > var8) {
                  var8 = this.field2701[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.field2710; ++var9) {
               this.field2701[var9] = var7 += var4.method2470();
               if(this.field2701[var9] > var8) {
                  var8 = this.field2701[var9];
               }
            }
         }

         this.field2707 = new int[var8 + 1];
         this.field2716 = new int[var8 + 1];
         this.field2702 = new int[1 + var8];
         this.field2712 = new int[1 + var8][];
         this.field2704 = new Object[1 + var8];
         this.field2711 = new Object[var8 + 1][];
         if(var6 != 0) {
            this.field2705 = new int[var8 + 1];

            for(var9 = 0; var9 < this.field2710; ++var9) {
               this.field2705[this.field2701[var9]] = var4.method2505();
            }

            this.field2703 = new class192(this.field2705);
         }

         for(var9 = 0; var9 < this.field2710; ++var9) {
            this.field2707[this.field2701[var9]] = var4.method2505();
         }

         for(var9 = 0; var9 < this.field2710; ++var9) {
            this.field2716[this.field2701[var9]] = var4.method2505();
         }

         for(var9 = 0; var9 < this.field2710; ++var9) {
            this.field2702[this.field2701[var9]] = var4.method2470();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2710; ++var9) {
               var10 = this.field2701[var9];
               var11 = this.field2702[var10];
               var7 = 0;
               var12 = -1;
               this.field2712[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2712[var10][var13] = var7 += var4.method2482();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2711[var10] = new Object[1 + var12];
            }
         } else {
            for(var9 = 0; var9 < this.field2710; ++var9) {
               var10 = this.field2701[var9];
               var11 = this.field2702[var10];
               var7 = 0;
               var12 = -1;
               this.field2712[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2712[var10][var13] = var7 += var4.method2470();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2711[var10] = new Object[1 + var12];
            }
         }

         if(var6 != 0) {
            this.field2708 = new int[var8 + 1][];
            this.field2709 = new class192[var8 + 1];

            for(var9 = 0; var9 < this.field2710; ++var9) {
               var10 = this.field2701[var9];
               var11 = this.field2702[var10];
               this.field2708[var10] = new int[this.field2711[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.field2708[var10][this.field2712[var10][var12]] = var4.method2505();
               }

               this.field2709[var10] = new class192(this.field2708[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }
}
