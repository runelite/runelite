import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public abstract class class170 {
   @ObfuscatedName("h")
   class195 field2707;
   @ObfuscatedName("l")
   int[] field2708;
   @ObfuscatedName("c")
   int[] field2709;
   @ObfuscatedName("r")
   int[] field2710;
   @ObfuscatedName("o")
   int[][] field2711;
   @ObfuscatedName("a")
   int[] field2712;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -159552511
   )
   static int field2713 = 0;
   @ObfuscatedName("u")
   int[][] field2714;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -823142423
   )
   int field2715;
   @ObfuscatedName("p")
   class195[] field2716;
   @ObfuscatedName("i")
   Object[] field2717;
   @ObfuscatedName("q")
   Object[][] field2718;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1338644715
   )
   public int field2720;
   @ObfuscatedName("w")
   boolean field2721;
   @ObfuscatedName("b")
   int[] field2722;
   @ObfuscatedName("x")
   boolean field2723;
   @ObfuscatedName("g")
   static class119 field2725 = new class119();
   @ObfuscatedName("io")
   static class176 field2726;
   @ObfuscatedName("ea")
   static class81 field2729;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "24"
   )
   public byte[] method3340(int var1, int var2) {
      return this.method3409(var1, var2, (int[])null);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "-67"
   )
   public boolean method3341(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2707.method3830(class90.method2177(var1));
      int var4 = this.field2716[var3].method3830(class90.method2177(var2));
      return this.method3344(var3, var4);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "407568603"
   )
   public int method3342(String var1) {
      var1 = var1.toLowerCase();
      return this.field2707.method3830(class90.method2177(var1));
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-314564958"
   )
   public boolean method3344(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2718.length && null != this.field2718[var1] && var2 >= 0 && var2 < this.field2718[var1].length) {
         if(null != this.field2718[var1][var2]) {
            return true;
         } else if(this.field2717[var1] != null) {
            return true;
         } else {
            this.vmethod3442(var1);
            return this.field2717[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-47"
   )
   public boolean method3345(int var1) {
      if(this.field2717[var1] != null) {
         return true;
      } else {
         this.vmethod3442(var1);
         return this.field2717[var1] != null;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1639425795"
   )
   public int[] method3346(int var1) {
      return this.field2714[var1];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1545358741"
   )
   void method3347(byte[] var1) {
      int var3 = var1.length;
      int var2 = class21.method554(var1, 0, var3);
      this.field2720 = var2;
      class122 var4 = new class122(class59.method1325(var1));
      int var5 = var4.method2610();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var4.method2614();
         }

         int var6 = var4.method2610();
         if(var5 >= 7) {
            this.field2715 = var4.method2623();
         } else {
            this.field2715 = var4.method2612();
         }

         int var7 = 0;
         int var8 = -1;
         this.field2708 = new int[this.field2715];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2715; ++var9) {
               this.field2708[var9] = var7 += var4.method2623();
               if(this.field2708[var9] > var8) {
                  var8 = this.field2708[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.field2715; ++var9) {
               this.field2708[var9] = var7 += var4.method2612();
               if(this.field2708[var9] > var8) {
                  var8 = this.field2708[var9];
               }
            }
         }

         this.field2710 = new int[var8 + 1];
         this.field2712 = new int[1 + var8];
         this.field2722 = new int[1 + var8];
         this.field2714 = new int[var8 + 1][];
         this.field2717 = new Object[var8 + 1];
         this.field2718 = new Object[1 + var8][];
         if(var6 != 0) {
            this.field2709 = new int[var8 + 1];

            for(var9 = 0; var9 < this.field2715; ++var9) {
               this.field2709[this.field2708[var9]] = var4.method2614();
            }

            this.field2707 = new class195(this.field2709);
         }

         for(var9 = 0; var9 < this.field2715; ++var9) {
            this.field2710[this.field2708[var9]] = var4.method2614();
         }

         for(var9 = 0; var9 < this.field2715; ++var9) {
            this.field2712[this.field2708[var9]] = var4.method2614();
         }

         for(var9 = 0; var9 < this.field2715; ++var9) {
            this.field2722[this.field2708[var9]] = var4.method2612();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2715; ++var9) {
               var10 = this.field2708[var9];
               var11 = this.field2722[var10];
               var7 = 0;
               var12 = -1;
               this.field2714[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2714[var10][var13] = var7 += var4.method2623();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2718[var10] = new Object[var12 + 1];
            }
         } else {
            for(var9 = 0; var9 < this.field2715; ++var9) {
               var10 = this.field2708[var9];
               var11 = this.field2722[var10];
               var7 = 0;
               var12 = -1;
               this.field2714[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2714[var10][var13] = var7 += var4.method2612();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2718[var10] = new Object[1 + var12];
            }
         }

         if(var6 != 0) {
            this.field2711 = new int[var8 + 1][];
            this.field2716 = new class195[var8 + 1];

            for(var9 = 0; var9 < this.field2715; ++var9) {
               var10 = this.field2708[var9];
               var11 = this.field2722[var10];
               this.field2711[var10] = new int[this.field2718[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.field2711[var10][this.field2714[var10][var12]] = var4.method2614();
               }

               this.field2716[var10] = new class195(this.field2711[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "100"
   )
   public byte[] method3349(int var1) {
      if(this.field2718.length == 1) {
         return this.method3398(0, var1);
      } else if(this.field2718[var1].length == 1) {
         return this.method3398(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1362594641"
   )
   void vmethod3442(int var1) {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1922621358"
   )
   public int method3352(int var1) {
      return this.field2718[var1].length;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1007264792"
   )
   public void method3355() {
      for(int var1 = 0; var1 < this.field2718.length; ++var1) {
         if(null != this.field2718[var1]) {
            for(int var2 = 0; var2 < this.field2718[var1].length; ++var2) {
               this.field2718[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "-149524221"
   )
   boolean method3356(int var1, int[] var2) {
      if(null == this.field2717[var1]) {
         return false;
      } else {
         int var3 = this.field2722[var1];
         int[] var4 = this.field2714[var1];
         Object[] var5 = this.field2718[var1];
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
               var18 = class18.method169(this.field2717[var1], false);
            } else {
               var18 = class18.method169(this.field2717[var1], true);
               class122 var8 = new class122(var18);
               var8.method2629(var2, 5, var8.field2054.length);
            }

            byte[] var20 = class59.method1325(var18);
            if(this.field2721) {
               this.field2717[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= var10 * var3 * 4;
               class122 var11 = new class122(var20);
               int[] var12 = new int[var3];
               var11.field2061 = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2614();
                     var12[var15] += var14;
                  }
               }

               byte[][] var19 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var19[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.field2061 = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2614();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2723) {
                     var5[var4[var15]] = class42.method888(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2723) {
               var5[var4[0]] = class42.method888(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   class170(boolean var1, boolean var2) {
      this.field2721 = var1;
      this.field2723 = var2;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "616861528"
   )
   public int method3357(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2716[var1].method3830(class90.method2177(var2));
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "0"
   )
   public byte[] method3358(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2707.method3830(class90.method2177(var1));
      int var4 = this.field2716[var3].method3830(class90.method2177(var2));
      return this.method3340(var3, var4);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1065466219"
   )
   public void method3359(int var1) {
      for(int var2 = 0; var2 < this.field2718[var1].length; ++var2) {
         this.field2718[var1][var2] = null;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "681714954"
   )
   public boolean method3360(String var1) {
      int var2 = this.method3342("");
      return var2 != -1?this.method3341("", var1):this.method3341(var1, "");
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-8"
   )
   public void method3361(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2707.method3830(class90.method2177(var1));
      if(var2 >= 0) {
         this.vmethod3457(var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "347814796"
   )
   public boolean method3369() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2708.length; ++var2) {
         int var3 = this.field2708[var2];
         if(null == this.field2717[var3]) {
            this.vmethod3442(var3);
            if(this.field2717[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-673460376"
   )
   void vmethod3457(int var1) {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "1438007393"
   )
   public byte[] method3398(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2718.length && null != this.field2718[var1] && var2 >= 0 && var2 < this.field2718[var1].length) {
         if(null == this.field2718[var1][var2]) {
            boolean var4 = this.method3356(var1, (int[])null);
            if(!var4) {
               this.vmethod3442(var1);
               var4 = this.method3356(var1, (int[])null);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var3 = class18.method169(this.field2718[var1][var2], false);
         return var3;
      } else {
         return null;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "898032995"
   )
   public byte[] method3409(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2718.length && null != this.field2718[var1] && var2 >= 0 && var2 < this.field2718[var1].length) {
         if(this.field2718[var1][var2] == null) {
            boolean var4 = this.method3356(var1, var3);
            if(!var4) {
               this.vmethod3442(var1);
               var4 = this.method3356(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class18.method169(this.field2718[var1][var2], false);
         if(this.field2723) {
            this.field2718[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IS)[B",
      garbageValue = "-29498"
   )
   public byte[] method3415(int var1) {
      if(this.field2718.length == 1) {
         return this.method3340(0, var1);
      } else if(this.field2718[var1].length == 1) {
         return this.method3340(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1829944683"
   )
   public int method3416() {
      return this.field2718.length;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Z",
      garbageValue = "-1383574702"
   )
   static boolean method3424(String var0, int var1) {
      return class111.method2482(var0, var1, "openjs");
   }
}
