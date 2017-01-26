import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public abstract class class182 {
   @ObfuscatedName("s")
   int[][] field2700;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1317704495
   )
   static int field2701 = 0;
   @ObfuscatedName("x")
   int[] field2702;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -604075751
   )
   public int field2703;
   @ObfuscatedName("d")
   int[] field2704;
   @ObfuscatedName("k")
   int[] field2705;
   @ObfuscatedName("j")
   int[] field2706;
   @ObfuscatedName("g")
   int[] field2707;
   @ObfuscatedName("o")
   int[][] field2708;
   @ObfuscatedName("a")
   class122[] field2709;
   @ObfuscatedName("c")
   Object[] field2710;
   @ObfuscatedName("h")
   static class146 field2711 = new class146();
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2029169533
   )
   int field2712;
   @ObfuscatedName("m")
   Object[][] field2713;
   @ObfuscatedName("u")
   boolean field2714;
   @ObfuscatedName("i")
   boolean field2715;
   @ObfuscatedName("q")
   class122 field2716;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-85868887"
   )
   void method3269(byte[] var1) {
      int var3 = var1.length;
      int var2 = class119.method2296(var1, 0, var3);
      this.field2703 = var2;
      Buffer var4 = new Buffer(Friend.method181(var1));
      int var5 = var4.readUnsignedByte();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var4.method2819();
         }

         int var6 = var4.readUnsignedByte();
         if(var5 >= 7) {
            this.field2712 = var4.method2957();
         } else {
            this.field2712 = var4.readUnsignedShort();
         }

         int var7 = 0;
         int var8 = -1;
         this.field2707 = new int[this.field2712];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2712; ++var9) {
               this.field2707[var9] = var7 += var4.method2957();
               if(this.field2707[var9] > var8) {
                  var8 = this.field2707[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.field2712; ++var9) {
               this.field2707[var9] = var7 += var4.readUnsignedShort();
               if(this.field2707[var9] > var8) {
                  var8 = this.field2707[var9];
               }
            }
         }

         this.field2704 = new int[1 + var8];
         this.field2705 = new int[var8 + 1];
         this.field2706 = new int[1 + var8];
         this.field2700 = new int[1 + var8][];
         this.field2710 = new Object[var8 + 1];
         this.field2713 = new Object[var8 + 1][];
         if(var6 != 0) {
            this.field2702 = new int[var8 + 1];

            for(var9 = 0; var9 < this.field2712; ++var9) {
               this.field2702[this.field2707[var9]] = var4.method2819();
            }

            this.field2716 = new class122(this.field2702);
         }

         for(var9 = 0; var9 < this.field2712; ++var9) {
            this.field2704[this.field2707[var9]] = var4.method2819();
         }

         for(var9 = 0; var9 < this.field2712; ++var9) {
            this.field2705[this.field2707[var9]] = var4.method2819();
         }

         for(var9 = 0; var9 < this.field2712; ++var9) {
            this.field2706[this.field2707[var9]] = var4.readUnsignedShort();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2712; ++var9) {
               var10 = this.field2707[var9];
               var11 = this.field2706[var10];
               var7 = 0;
               var12 = -1;
               this.field2700[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2700[var10][var13] = var7 += var4.method2957();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2713[var10] = new Object[1 + var12];
            }
         } else {
            for(var9 = 0; var9 < this.field2712; ++var9) {
               var10 = this.field2707[var9];
               var11 = this.field2706[var10];
               var7 = 0;
               var12 = -1;
               this.field2700[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2700[var10][var13] = var7 += var4.readUnsignedShort();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2713[var10] = new Object[var12 + 1];
            }
         }

         if(var6 != 0) {
            this.field2708 = new int[var8 + 1][];
            this.field2709 = new class122[var8 + 1];

            for(var9 = 0; var9 < this.field2712; ++var9) {
               var10 = this.field2707[var9];
               var11 = this.field2706[var10];
               this.field2708[var10] = new int[this.field2713[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.field2708[var10][this.field2700[var10][var12]] = var4.method2819();
               }

               this.field2709[var10] = new class122(this.field2708[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-920994339"
   )
   void vmethod3362(int var1) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "-1994689244"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2713.length && null != this.field2713[var1] && var2 >= 0 && var2 < this.field2713[var1].length) {
         if(this.field2713[var1][var2] == null) {
            boolean var4 = this.method3324(var1, var3);
            if(!var4) {
               this.vmethod3363(var1);
               var4 = this.method3324(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class2.method32(this.field2713[var1][var2], false);
         if(this.field2715) {
            this.field2713[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "60"
   )
   public boolean method3274(int var1) {
      if(this.field2710[var1] != null) {
         return true;
      } else {
         this.vmethod3363(var1);
         return this.field2710[var1] != null;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-83"
   )
   public boolean method3275() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2707.length; ++var2) {
         int var3 = this.field2707[var2];
         if(this.field2710[var3] == null) {
            this.vmethod3363(var3);
            if(this.field2710[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1769482986"
   )
   public int method3276(String var1) {
      var1 = var1.toLowerCase();
      return this.field2716.method2330(class112.method2100(var1));
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1697601934"
   )
   void vmethod3363(int var1) {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-928379253"
   )
   public int[] method3280(int var1) {
      return this.field2700[var1];
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1339942109"
   )
   public int method3282() {
      return this.field2713.length;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "386880346"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "-1448228565"
   )
   public int method3287(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2709[var1].method2330(class112.method2100(var2));
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "2005337369"
   )
   public byte[] method3288(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2716.method2330(class112.method2100(var1));
      int var4 = this.field2709[var3].method2330(class112.method2100(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "354642066"
   )
   public boolean method3289(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2716.method2330(class112.method2100(var1));
      int var4 = this.field2709[var3].method2330(class112.method2100(var2));
      return this.method3326(var3, var4);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-1272727896"
   )
   public boolean method3290(String var1) {
      int var2 = this.method3276("");
      return var2 != -1?this.method3289("", var1):this.method3289(var1, "");
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-28"
   )
   public void method3291(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2716.method2330(class112.method2100(var1));
      if(var2 >= 0) {
         this.vmethod3362(var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "50"
   )
   public byte[] method3292(int var1) {
      if(this.field2713.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.field2713[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "825251635"
   )
   public int method3309(int var1) {
      return this.field2713[var1].length;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-609519785"
   )
   public void method3311() {
      for(int var1 = 0; var1 < this.field2713.length; ++var1) {
         if(this.field2713[var1] != null) {
            for(int var2 = 0; var2 < this.field2713[var1].length; ++var2) {
               this.field2713[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "-713639895"
   )
   boolean method3324(int var1, int[] var2) {
      if(null == this.field2710[var1]) {
         return false;
      } else {
         int var3 = this.field2706[var1];
         int[] var4 = this.field2700[var1];
         Object[] var5 = this.field2713[var1];
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
               var18 = class2.method32(this.field2710[var1], false);
            } else {
               var18 = class2.method32(this.field2710[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method2833(var2, 5, var8.payload.length);
            }

            byte[] var20 = Friend.method181(var18);
            if(this.field2714) {
               this.field2710[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= 4 * var10 * var3;
               Buffer var11 = new Buffer(var20);
               int[] var12 = new int[var3];
               var11.offset = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2819();
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
                     var16 += var11.method2819();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2715) {
                     var5[var4[var15]] = World.method653(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2715) {
               var5[var4[0]] = World.method653(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-756435188"
   )
   public boolean method3326(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2713.length && this.field2713[var1] != null && var2 >= 0 && var2 < this.field2713[var1].length) {
         if(this.field2713[var1][var2] != null) {
            return true;
         } else if(null != this.field2710[var1]) {
            return true;
         } else {
            this.vmethod3363(var1);
            return this.field2710[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "2067817189"
   )
   public byte[] method3337(int var1) {
      if(this.field2713.length == 1) {
         return this.method3344(0, var1);
      } else if(this.field2713[var1].length == 1) {
         return this.method3344(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1545517108"
   )
   public void method3338(int var1) {
      for(int var2 = 0; var2 < this.field2713[var1].length; ++var2) {
         this.field2713[var1][var2] = null;
      }

   }

   class182(boolean var1, boolean var2) {
      this.field2714 = var1;
      this.field2715 = var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-1995054124"
   )
   public byte[] method3344(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2713.length && null != this.field2713[var1] && var2 >= 0 && var2 < this.field2713[var1].length) {
         if(this.field2713[var1][var2] == null) {
            boolean var4 = this.method3324(var1, (int[])null);
            if(!var4) {
               this.vmethod3363(var1);
               var4 = this.method3324(var1, (int[])null);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var3 = class2.method32(this.field2713[var1][var2], false);
         return var3;
      } else {
         return null;
      }
   }
}
