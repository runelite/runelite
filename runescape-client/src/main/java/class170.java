import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public abstract class class170 {
   @ObfuscatedName("m")
   int[][] field2729;
   @ObfuscatedName("p")
   int[][] field2730;
   @ObfuscatedName("v")
   Object[][] field2731;
   @ObfuscatedName("z")
   class195 field2732;
   @ObfuscatedName("i")
   int[] field2733;
   @ObfuscatedName("db")
   static int[] field2734;
   @ObfuscatedName("l")
   int[] field2735;
   @ObfuscatedName("r")
   int[] field2736;
   @ObfuscatedName("d")
   Object[] field2737;
   @ObfuscatedName("f")
   class195[] field2738;
   @ObfuscatedName("g")
   boolean field2739;
   @ObfuscatedName("b")
   int[] field2740;
   @ObfuscatedName("q")
   static class119 field2741 = new class119();
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1171574663
   )
   public int field2742;
   @ObfuscatedName("s")
   boolean field2743;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -271877437
   )
   int field2744;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1479245843
   )
   static int field2745 = 0;
   @ObfuscatedName("j")
   int[] field2748;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-122"
   )
   void vmethod3364(int var1) {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "-1"
   )
   public int[] method3289(int var1) {
      return this.field2729[var1];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-1393868659"
   )
   public byte[] method3290(int var1, int var2) {
      return this.method3291(var1, var2, (int[])null);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "-274978567"
   )
   public byte[] method3291(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2731.length && this.field2731[var1] != null && var2 >= 0 && var2 < this.field2731[var1].length) {
         if(this.field2731[var1][var2] == null) {
            boolean var4 = this.method3303(var1, var3);
            if(!var4) {
               this.vmethod3365(var1);
               var4 = this.method3303(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class23.method566(this.field2731[var1][var2], false);
         if(this.field2743) {
            this.field2731[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "961367048"
   )
   public boolean method3292(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2731.length && null != this.field2731[var1] && var2 >= 0 && var2 < this.field2731[var1].length) {
         if(null != this.field2731[var1][var2]) {
            return true;
         } else if(this.field2737[var1] != null) {
            return true;
         } else {
            this.vmethod3365(var1);
            return this.field2737[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-1853609781"
   )
   public boolean method3294(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2732.method3778(class77.method1636(var1));
      int var4 = this.field2738[var3].method3778(class77.method1636(var2));
      return this.method3292(var3, var4);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "65"
   )
   public byte[] method3295(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2731.length && null != this.field2731[var1] && var2 >= 0 && var2 < this.field2731[var1].length) {
         if(null == this.field2731[var1][var2]) {
            boolean var3 = this.method3303(var1, (int[])null);
            if(!var3) {
               this.vmethod3365(var1);
               var3 = this.method3303(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class23.method566(this.field2731[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "16"
   )
   public byte[] method3296(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2732.method3778(class77.method1636(var1));
      int var4 = this.field2738[var3].method3778(class77.method1636(var2));
      return this.method3290(var3, var4);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-476485243"
   )
   void vmethod3365(int var1) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "782345301"
   )
   public int method3299(int var1) {
      return this.field2731[var1].length;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "103"
   )
   public int method3300() {
      return this.field2731.length;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "125"
   )
   public void method3301(int var1) {
      for(int var2 = 0; var2 < this.field2731[var1].length; ++var2) {
         this.field2731[var1][var2] = null;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "324257588"
   )
   public void method3302() {
      for(int var1 = 0; var1 < this.field2731.length; ++var1) {
         if(this.field2731[var1] != null) {
            for(int var2 = 0; var2 < this.field2731[var1].length; ++var2) {
               this.field2731[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "1534200142"
   )
   boolean method3303(int var1, int[] var2) {
      if(this.field2737[var1] == null) {
         return false;
      } else {
         int var3 = this.field2735[var1];
         int[] var4 = this.field2729[var1];
         Object[] var5 = this.field2731[var1];
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
               var18 = class23.method566(this.field2737[var1], false);
            } else {
               var18 = class23.method566(this.field2737[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method2576(var2, 5, var8.payload.length);
            }

            byte[] var20 = class54.method1096(var18);
            if(this.field2739) {
               this.field2737[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= var10 * var3 * 4;
               Buffer var11 = new Buffer(var20);
               int[] var12 = new int[var3];
               var11.offset = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2561();
                     var12[var15] += var14;
                  }
               }

               byte[][] var19 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var19[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.offset = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2561();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2743) {
                     var5[var4[var15]] = class45.method919(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2743) {
               var5[var4[0]] = class45.method919(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-410845486"
   )
   void method3304(byte[] var1) {
      this.field2742 = class4.method46(var1, var1.length);
      Buffer var2 = new Buffer(class54.method1096(var1));
      int var3 = var2.method2556();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.method2561();
         }

         int var4 = var2.method2556();
         if(var3 >= 7) {
            this.field2744 = var2.method2564();
         } else {
            this.field2744 = var2.method2551();
         }

         int var5 = 0;
         int var6 = -1;
         this.field2736 = new int[this.field2744];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2744; ++var7) {
               this.field2736[var7] = var5 += var2.method2564();
               if(this.field2736[var7] > var6) {
                  var6 = this.field2736[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.field2744; ++var7) {
               this.field2736[var7] = var5 += var2.method2551();
               if(this.field2736[var7] > var6) {
                  var6 = this.field2736[var7];
               }
            }
         }

         this.field2733 = new int[1 + var6];
         this.field2740 = new int[1 + var6];
         this.field2735 = new int[1 + var6];
         this.field2729 = new int[var6 + 1][];
         this.field2737 = new Object[var6 + 1];
         this.field2731 = new Object[1 + var6][];
         if(var4 != 0) {
            this.field2748 = new int[var6 + 1];

            for(var7 = 0; var7 < this.field2744; ++var7) {
               this.field2748[this.field2736[var7]] = var2.method2561();
            }

            this.field2732 = new class195(this.field2748);
         }

         for(var7 = 0; var7 < this.field2744; ++var7) {
            this.field2733[this.field2736[var7]] = var2.method2561();
         }

         for(var7 = 0; var7 < this.field2744; ++var7) {
            this.field2740[this.field2736[var7]] = var2.method2561();
         }

         for(var7 = 0; var7 < this.field2744; ++var7) {
            this.field2735[this.field2736[var7]] = var2.method2551();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2744; ++var7) {
               var8 = this.field2736[var7];
               var9 = this.field2735[var8];
               var5 = 0;
               var10 = -1;
               this.field2729[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2729[var8][var11] = var5 += var2.method2564();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2731[var8] = new Object[var10 + 1];
            }
         } else {
            for(var7 = 0; var7 < this.field2744; ++var7) {
               var8 = this.field2736[var7];
               var9 = this.field2735[var8];
               var5 = 0;
               var10 = -1;
               this.field2729[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2729[var8][var11] = var5 += var2.method2551();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2731[var8] = new Object[1 + var10];
            }
         }

         if(var4 != 0) {
            this.field2730 = new int[var6 + 1][];
            this.field2738 = new class195[1 + var6];

            for(var7 = 0; var7 < this.field2744; ++var7) {
               var8 = this.field2736[var7];
               var9 = this.field2735[var8];
               this.field2730[var8] = new int[this.field2731[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.field2730[var8][this.field2729[var8][var10]] = var2.method2561();
               }

               this.field2738[var8] = new class195(this.field2730[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "1655449837"
   )
   public int method3305(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2738[var1].method3778(class77.method1636(var2));
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "670414949"
   )
   public boolean method3307(String var1) {
      int var2 = this.method3359("");
      return var2 != -1?this.method3294("", var1):this.method3294(var1, "");
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1461614537"
   )
   public boolean method3308() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2736.length; ++var2) {
         int var3 = this.field2736[var2];
         if(null == this.field2737[var3]) {
            this.vmethod3365(var3);
            if(this.field2737[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1740888436"
   )
   public void method3309(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2732.method3778(class77.method1636(var1));
      if(var2 >= 0) {
         this.vmethod3364(var2);
      }
   }

   class170(boolean var1, boolean var2) {
      this.field2739 = var1;
      this.field2743 = var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1309399472"
   )
   public byte[] method3327(int var1) {
      if(this.field2731.length == 1) {
         return this.method3295(0, var1);
      } else if(this.field2731[var1].length == 1) {
         return this.method3295(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1671960429"
   )
   public boolean method3342(int var1) {
      if(null != this.field2737[var1]) {
         return true;
      } else {
         this.vmethod3365(var1);
         return null != this.field2737[var1];
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "6"
   )
   public byte[] method3352(int var1) {
      if(this.field2731.length == 1) {
         return this.method3290(0, var1);
      } else if(this.field2731[var1].length == 1) {
         return this.method3290(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "581753565"
   )
   public int method3359(String var1) {
      var1 = var1.toLowerCase();
      return this.field2732.method3778(class77.method1636(var1));
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1797887393"
   )
   static final void method3361(int var0, int var1, int var2, int var3, int var4) {
      class152.field2292[0].method1896(var0, var1);
      class152.field2292[1].method1896(var0, var3 + var1 - 16);
      class82.method1831(var0, var1 + 16, 16, var3 - 32, Client.field359);
      int var5 = var3 * (var3 - 32) / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = var2 * (var3 - 32 - var5) / (var4 - var3);
      class82.method1831(var0, var1 + 16 + var6, 16, var5, Client.field360);
      class82.method1841(var0, 16 + var1 + var6, var5, Client.field555);
      class82.method1841(1 + var0, var6 + 16 + var1, var5, Client.field555);
      class82.method1834(var0, 16 + var1 + var6, 16, Client.field555);
      class82.method1834(var0, var6 + 17 + var1, 16, Client.field555);
      class82.method1841(var0 + 15, var6 + var1 + 16, var5, Client.field361);
      class82.method1841(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field361);
      class82.method1834(var0, 15 + var1 + var6 + var5, 16, Client.field361);
      class82.method1834(1 + var0, var1 + 14 + var6 + var5, 15, Client.field361);
   }
}
