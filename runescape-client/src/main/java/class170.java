import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public abstract class class170 {
   @ObfuscatedName("m")
   int[] field2716;
   @ObfuscatedName("f")
   int[] field2717;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2021387503
   )
   public int field2718;
   @ObfuscatedName("c")
   class195 field2719;
   @ObfuscatedName("v")
   int[] field2720;
   @ObfuscatedName("q")
   int[] field2721;
   @ObfuscatedName("j")
   int[] field2722;
   @ObfuscatedName("y")
   int[][] field2723;
   @ObfuscatedName("u")
   int[][] field2724;
   @ObfuscatedName("h")
   class195[] field2725;
   @ObfuscatedName("l")
   Object[] field2726;
   @ObfuscatedName("p")
   boolean field2727;
   @ObfuscatedName("g")
   static class119 field2728 = new class119();
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -259900877
   )
   int field2729;
   @ObfuscatedName("b")
   Object[][] field2730;
   @ObfuscatedName("s")
   boolean field2731;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -229936387
   )
   static int field2732 = 0;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -1312942017
   )
   @Export("cameraY")
   static int cameraY;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BS)V",
      garbageValue = "-18167"
   )
   void method3278(byte[] var1) {
      int var3 = var1.length;
      int var2 = class125.method2833(var1, 0, var3);
      this.field2718 = var2;
      Buffer var4 = new Buffer(DecorativeObject.method2239(var1));
      int var5 = var4.method2571();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var4.method2576();
         }

         int var6 = var4.method2571();
         if(var5 >= 7) {
            this.field2729 = var4.method2585();
         } else {
            this.field2729 = var4.method2691();
         }

         int var7 = 0;
         int var8 = -1;
         this.field2721 = new int[this.field2729];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2729; ++var9) {
               this.field2721[var9] = var7 += var4.method2585();
               if(this.field2721[var9] > var8) {
                  var8 = this.field2721[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.field2729; ++var9) {
               this.field2721[var9] = var7 += var4.method2691();
               if(this.field2721[var9] > var8) {
                  var8 = this.field2721[var9];
               }
            }
         }

         this.field2720 = new int[var8 + 1];
         this.field2722 = new int[1 + var8];
         this.field2716 = new int[1 + var8];
         this.field2723 = new int[1 + var8][];
         this.field2726 = new Object[var8 + 1];
         this.field2730 = new Object[var8 + 1][];
         if(var6 != 0) {
            this.field2717 = new int[var8 + 1];

            for(var9 = 0; var9 < this.field2729; ++var9) {
               this.field2717[this.field2721[var9]] = var4.method2576();
            }

            this.field2719 = new class195(this.field2717);
         }

         for(var9 = 0; var9 < this.field2729; ++var9) {
            this.field2720[this.field2721[var9]] = var4.method2576();
         }

         for(var9 = 0; var9 < this.field2729; ++var9) {
            this.field2722[this.field2721[var9]] = var4.method2576();
         }

         for(var9 = 0; var9 < this.field2729; ++var9) {
            this.field2716[this.field2721[var9]] = var4.method2691();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2729; ++var9) {
               var10 = this.field2721[var9];
               var11 = this.field2716[var10];
               var7 = 0;
               var12 = -1;
               this.field2723[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2723[var10][var13] = var7 += var4.method2585();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2730[var10] = new Object[1 + var12];
            }
         } else {
            for(var9 = 0; var9 < this.field2729; ++var9) {
               var10 = this.field2721[var9];
               var11 = this.field2716[var10];
               var7 = 0;
               var12 = -1;
               this.field2723[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2723[var10][var13] = var7 += var4.method2691();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2730[var10] = new Object[var12 + 1];
            }
         }

         if(var6 != 0) {
            this.field2724 = new int[var8 + 1][];
            this.field2725 = new class195[1 + var8];

            for(var9 = 0; var9 < this.field2729; ++var9) {
               var10 = this.field2721[var9];
               var11 = this.field2716[var10];
               this.field2724[var10] = new int[this.field2730[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.field2724[var10][this.field2723[var10][var12]] = var4.method2576();
               }

               this.field2725[var10] = new class195(this.field2724[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "974604139"
   )
   void vmethod3366(int var1) {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "2120313073"
   )
   public byte[] method3281(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2730.length && this.field2730[var1] != null && var2 >= 0 && var2 < this.field2730[var1].length) {
         if(this.field2730[var1][var2] == null) {
            boolean var4 = this.method3294(var1, var3);
            if(!var4) {
               this.vmethod3383(var1);
               var4 = this.method3294(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class59.method1268(this.field2730[var1][var2], false);
         if(this.field2731) {
            this.field2730[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-830676605"
   )
   public boolean method3282(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2730.length && this.field2730[var1] != null && var2 >= 0 && var2 < this.field2730[var1].length) {
         if(null != this.field2730[var1][var2]) {
            return true;
         } else if(null != this.field2726[var1]) {
            return true;
         } else {
            this.vmethod3383(var1);
            return this.field2726[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2125128131"
   )
   public boolean method3284() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2721.length; ++var2) {
         int var3 = this.field2721[var2];
         if(this.field2726[var3] == null) {
            this.vmethod3383(var3);
            if(null == this.field2726[var3]) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "50"
   )
   public byte[] method3286(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2730.length && this.field2730[var1] != null && var2 >= 0 && var2 < this.field2730[var1].length) {
         if(this.field2730[var1][var2] == null) {
            boolean var3 = this.method3294(var1, (int[])null);
            if(!var3) {
               this.vmethod3383(var1);
               var3 = this.method3294(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class59.method1268(this.field2730[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-6"
   )
   public byte[] method3287(int var1) {
      if(this.field2730.length == 1) {
         return this.method3286(0, var1);
      } else if(this.field2730[var1].length == 1) {
         return this.method3286(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IS)[I",
      garbageValue = "7208"
   )
   public int[] method3289(int var1) {
      return this.field2723[var1];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "467657921"
   )
   public int method3290(int var1) {
      return this.field2730[var1].length;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "11"
   )
   public int method3291() {
      return this.field2730.length;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "287131734"
   )
   public void method3292(int var1) {
      for(int var2 = 0; var2 < this.field2730[var1].length; ++var2) {
         this.field2730[var1][var2] = null;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I[IB)Z",
      garbageValue = "58"
   )
   boolean method3294(int var1, int[] var2) {
      if(this.field2726[var1] == null) {
         return false;
      } else {
         int var3 = this.field2716[var1];
         int[] var4 = this.field2723[var1];
         Object[] var5 = this.field2730[var1];
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
               var18 = class59.method1268(this.field2726[var1], false);
            } else {
               var18 = class59.method1268(this.field2726[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method2591(var2, 5, var8.payload.length);
            }

            byte[] var20 = DecorativeObject.method2239(var18);
            if(this.field2727) {
               this.field2726[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= 4 * var3 * var10;
               Buffer var11 = new Buffer(var20);
               int[] var12 = new int[var3];
               var11.offset = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2576();
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
                     var16 += var11.method2576();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2731) {
                     var5[var4[var15]] = class48.method1001(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2731) {
               var5[var4[0]] = class48.method1001(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "48"
   )
   public boolean method3296(int var1) {
      if(null != this.field2726[var1]) {
         return true;
      } else {
         this.vmethod3383(var1);
         return null != this.field2726[var1];
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "-969050063"
   )
   public byte[] method3297(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2719.method3780(Item.method673(var1));
      int var4 = this.field2725[var3].method3780(Item.method673(var2));
      return this.method3305(var3, var4);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "-85"
   )
   public boolean method3299(String var1) {
      int var2 = this.method3327("");
      return var2 != -1?this.method3351("", var1):this.method3351(var1, "");
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-592909450"
   )
   public void method3300(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2719.method3780(Item.method673(var1));
      if(var2 >= 0) {
         this.vmethod3366(var2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "45"
   )
   public byte[] method3305(int var1, int var2) {
      return this.method3281(var1, var2, (int[])null);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-82"
   )
   public byte[] method3310(int var1) {
      if(this.field2730.length == 1) {
         return this.method3305(0, var1);
      } else if(this.field2730[var1].length == 1) {
         return this.method3305(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   class170(boolean var1, boolean var2) {
      this.field2727 = var1;
      this.field2731 = var2;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "25857785"
   )
   public int method3325(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2725[var1].method3780(Item.method673(var2));
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-553430289"
   )
   public int method3327(String var1) {
      var1 = var1.toLowerCase();
      return this.field2719.method3780(Item.method673(var1));
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-725084683"
   )
   public void method3337() {
      for(int var1 = 0; var1 < this.field2730.length; ++var1) {
         if(this.field2730[var1] != null) {
            for(int var2 = 0; var2 < this.field2730[var1].length; ++var2) {
               this.field2730[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-721910564"
   )
   public boolean method3351(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2719.method3780(Item.method673(var1));
      int var4 = this.field2725[var3].method3780(Item.method673(var2));
      return this.method3282(var3, var4);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1885427498"
   )
   void vmethod3383(int var1) {
   }
}
