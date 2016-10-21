import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public abstract class class170 {
   @ObfuscatedName("e")
   int[] field2703;
   @ObfuscatedName("x")
   boolean field2704;
   @ObfuscatedName("h")
   Object[][] field2705;
   @ObfuscatedName("t")
   class195 field2706;
   @ObfuscatedName("w")
   class195[] field2707;
   @ObfuscatedName("b")
   int[] field2708;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 752937321
   )
   int field2709;
   @ObfuscatedName("k")
   int[][] field2710;
   @ObfuscatedName("c")
   int[][] field2711;
   @ObfuscatedName("m")
   int[] field2712;
   @ObfuscatedName("l")
   Object[] field2713;
   @ObfuscatedName("v")
   int[] field2714;
   @ObfuscatedName("i")
   static class119 field2715 = new class119();
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1412612921
   )
   public int field2716;
   @ObfuscatedName("n")
   int[] field2717;
   @ObfuscatedName("d")
   boolean field2718;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1955244449
   )
   static int field2719 = 0;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2105936523"
   )
   void vmethod3391(int var1) {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1782793428"
   )
   void method3284(byte[] var1) {
      int var3 = var1.length;
      int var5 = -1;

      int var6;
      for(var6 = 0; var6 < var3; ++var6) {
         var5 = var5 >>> 8 ^ Buffer.field2055[(var5 ^ var1[var6]) & 255];
      }

      var5 = ~var5;
      this.field2716 = var5;
      Buffer var4 = new Buffer(class160.method3192(var1));
      var5 = var4.method2656();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var4.method2538();
         }

         var6 = var4.method2656();
         if(var5 >= 7) {
            this.field2709 = var4.method2547();
         } else {
            this.field2709 = var4.method2535();
         }

         int var7 = 0;
         int var8 = -1;
         this.field2703 = new int[this.field2709];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2709; ++var9) {
               this.field2703[var9] = var7 += var4.method2547();
               if(this.field2703[var9] > var8) {
                  var8 = this.field2703[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.field2709; ++var9) {
               this.field2703[var9] = var7 += var4.method2535();
               if(this.field2703[var9] > var8) {
                  var8 = this.field2703[var9];
               }
            }
         }

         this.field2714 = new int[var8 + 1];
         this.field2708 = new int[1 + var8];
         this.field2712 = new int[var8 + 1];
         this.field2710 = new int[var8 + 1][];
         this.field2713 = new Object[1 + var8];
         this.field2705 = new Object[1 + var8][];
         if(var6 != 0) {
            this.field2717 = new int[1 + var8];

            for(var9 = 0; var9 < this.field2709; ++var9) {
               this.field2717[this.field2703[var9]] = var4.method2538();
            }

            this.field2706 = new class195(this.field2717);
         }

         for(var9 = 0; var9 < this.field2709; ++var9) {
            this.field2714[this.field2703[var9]] = var4.method2538();
         }

         for(var9 = 0; var9 < this.field2709; ++var9) {
            this.field2708[this.field2703[var9]] = var4.method2538();
         }

         for(var9 = 0; var9 < this.field2709; ++var9) {
            this.field2712[this.field2703[var9]] = var4.method2535();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2709; ++var9) {
               var10 = this.field2703[var9];
               var11 = this.field2712[var10];
               var7 = 0;
               var12 = -1;
               this.field2710[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2710[var10][var13] = var7 += var4.method2547();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2705[var10] = new Object[1 + var12];
            }
         } else {
            for(var9 = 0; var9 < this.field2709; ++var9) {
               var10 = this.field2703[var9];
               var11 = this.field2712[var10];
               var7 = 0;
               var12 = -1;
               this.field2710[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2710[var10][var13] = var7 += var4.method2535();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2705[var10] = new Object[1 + var12];
            }
         }

         if(var6 != 0) {
            this.field2711 = new int[1 + var8][];
            this.field2707 = new class195[var8 + 1];

            for(var9 = 0; var9 < this.field2709; ++var9) {
               var10 = this.field2703[var9];
               var11 = this.field2712[var10];
               this.field2711[var10] = new int[this.field2705[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.field2711[var10][this.field2710[var10][var12]] = var4.method2538();
               }

               this.field2707[var10] = new class195(this.field2711[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "-86"
   )
   public byte[] method3285(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2706.method3809(class31.method684(var1));
      int var4 = this.field2707[var3].method3809(class31.method684(var2));
      return this.method3304(var3, var4);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1606733625"
   )
   public void method3287(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2706.method3809(class31.method684(var1));
      if(var2 >= 0) {
         this.vmethod3391(var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "77"
   )
   public boolean method3288() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2703.length; ++var2) {
         int var3 = this.field2703[var2];
         if(this.field2713[var3] == null) {
            this.vmethod3382(var3);
            if(null == this.field2713[var3]) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-80"
   )
   public byte[] method3289(int var1) {
      if(this.field2705.length == 1) {
         return this.method3304(0, var1);
      } else if(this.field2705[var1].length == 1) {
         return this.method3304(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIS)[B",
      garbageValue = "-3627"
   )
   public byte[] method3292(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2705.length && this.field2705[var1] != null && var2 >= 0 && var2 < this.field2705[var1].length) {
         if(this.field2705[var1][var2] == null) {
            boolean var3 = this.method3298(var1, (int[])null);
            if(!var3) {
               this.vmethod3382(var1);
               var3 = this.method3298(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = Player.method43(this.field2705[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-748301859"
   )
   public int method3295() {
      return this.field2705.length;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1277812390"
   )
   public void method3296(int var1) {
      for(int var2 = 0; var2 < this.field2705[var1].length; ++var2) {
         this.field2705[var1][var2] = null;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-421652713"
   )
   public void method3297() {
      for(int var1 = 0; var1 < this.field2705.length; ++var1) {
         if(this.field2705[var1] != null) {
            for(int var2 = 0; var2 < this.field2705[var1].length; ++var2) {
               this.field2705[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "1549605051"
   )
   boolean method3298(int var1, int[] var2) {
      if(this.field2713[var1] == null) {
         return false;
      } else {
         int var3 = this.field2712[var1];
         int[] var4 = this.field2710[var1];
         Object[] var5 = this.field2705[var1];
         boolean var6 = true;

         for(int var7 = 0; var7 < var3; ++var7) {
            if(null == var5[var4[var7]]) {
               var6 = false;
               break;
            }
         }

         if(var6) {
            return true;
         } else {
            byte[] var18;
            if(var2 == null || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
               var18 = Player.method43(this.field2713[var1], false);
            } else {
               var18 = Player.method43(this.field2713[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method2553(var2, 5, var8.payload.length);
            }

            byte[] var20 = class160.method3192(var18);
            if(this.field2704) {
               this.field2713[var1] = null;
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
                     var14 += var11.method2538();
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
                     var16 += var11.method2538();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2718) {
                     var5[var4[var15]] = ItemLayer.method2235(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2718) {
               var5[var4[0]] = ItemLayer.method2235(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "29"
   )
   public int method3299(String var1) {
      var1 = var1.toLowerCase();
      return this.field2706.method3809(class31.method684(var1));
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "5"
   )
   void vmethod3382(int var1) {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-836782096"
   )
   public boolean method3302(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2706.method3809(class31.method684(var1));
      int var4 = this.field2707[var3].method3809(class31.method684(var2));
      return this.method3353(var3, var4);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "-37"
   )
   public boolean method3303(String var1) {
      int var2 = this.method3299("");
      return var2 != -1?this.method3302("", var1):this.method3302(var1, "");
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "7335221"
   )
   public byte[] method3304(int var1, int var2) {
      return this.method3318(var1, var2, (int[])null);
   }

   class170(boolean var1, boolean var2) {
      this.field2704 = var1;
      this.field2718 = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1368829595"
   )
   public int[] method3311(int var1) {
      return this.field2710[var1];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "51"
   )
   public byte[] method3317(int var1) {
      if(this.field2705.length == 1) {
         return this.method3292(0, var1);
      } else if(this.field2705[var1].length == 1) {
         return this.method3292(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II[IB)[B",
      garbageValue = "-86"
   )
   public byte[] method3318(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2705.length && null != this.field2705[var1] && var2 >= 0 && var2 < this.field2705[var1].length) {
         if(this.field2705[var1][var2] == null) {
            boolean var4 = this.method3298(var1, var3);
            if(!var4) {
               this.vmethod3382(var1);
               var4 = this.method3298(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = Player.method43(this.field2705[var1][var2], false);
         if(this.field2718) {
            this.field2705[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1191724084"
   )
   public int method3321(int var1) {
      return this.field2705[var1].length;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "3"
   )
   public boolean method3330(int var1) {
      if(this.field2713[var1] != null) {
         return true;
      } else {
         this.vmethod3382(var1);
         return this.field2713[var1] != null;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1664355312"
   )
   public boolean method3353(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2705.length && this.field2705[var1] != null && var2 >= 0 && var2 < this.field2705[var1].length) {
         if(null != this.field2705[var1][var2]) {
            return true;
         } else if(null != this.field2713[var1]) {
            return true;
         } else {
            this.vmethod3382(var1);
            return null != this.field2713[var1];
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "-2023790558"
   )
   public int method3361(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2707[var1].method3809(class31.method684(var2));
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1812396200"
   )
   static final int method3378(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
