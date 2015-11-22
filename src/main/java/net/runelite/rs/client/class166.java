package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fa")
public abstract class class166 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1670589393
   )
   static int field2654 = 0;
   @ObfuscatedName("m")
   int[] field2655;
   @ObfuscatedName("f")
   int[] field2656;
   @ObfuscatedName("l")
   class191 field2657;
   @ObfuscatedName("u")
   int[] field2658;
   @ObfuscatedName("a")
   int[] field2659;
   @ObfuscatedName("h")
   int[] field2660;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 963878023
   )
   public int field2661;
   @ObfuscatedName("t")
   int[][] field2662;
   @ObfuscatedName("k")
   class191[] field2663;
   @ObfuscatedName("w")
   Object[][] field2664;
   @ObfuscatedName("e")
   static class115 field2665 = new class115();
   @ObfuscatedName("i")
   int[][] field2666;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 868125475
   )
   int field2667;
   @ObfuscatedName("p")
   boolean field2668;
   @ObfuscatedName("r")
   boolean field2669;
   @ObfuscatedName("s")
   Object[] field2670;

   @ObfuscatedName("u")
   public boolean method3314(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2664.length && this.field2664[var1] != null && var2 >= 0 && var2 < this.field2664[var1].length) {
         if(null != this.field2664[var1][var2]) {
            return true;
         } else if(this.field2670[var1] != null) {
            return true;
         } else {
            this.vmethod3403(var1);
            return null != this.field2670[var1];
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("a")
   public boolean method3315(int var1) {
      if(null != this.field2670[var1]) {
         return true;
      } else {
         this.vmethod3403(var1);
         return this.field2670[var1] != null;
      }
   }

   @ObfuscatedName("h")
   public boolean method3316() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2655.length; ++var2) {
         int var3 = this.field2655[var2];
         if(null == this.field2670[var3]) {
            this.vmethod3403(var3);
            if(this.field2670[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("t")
   public byte[] method3318(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2664.length && null != this.field2664[var1] && var2 >= 0 && var2 < this.field2664[var1].length) {
         if(this.field2664[var1][var2] == null) {
            boolean var3 = this.method3326(var1, (int[])null);
            if(!var3) {
               this.vmethod3403(var1);
               var3 = this.method3326(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class6.method119(this.field2664[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("k")
   public byte[] method3319(int var1) {
      if(1 == this.field2664.length) {
         return this.method3318(0, var1);
      } else if(this.field2664[var1].length == 1) {
         return this.method3318(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("s")
   void vmethod3403(int var1) {
   }

   @ObfuscatedName("w")
   public int[] method3321(int var1) {
      return this.field2666[var1];
   }

   @ObfuscatedName("e")
   public int method3322(int var1) {
      return this.field2664[var1].length;
   }

   @ObfuscatedName("y")
   public int method3323(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2663[var1].method3802(class43.method944(var2));
   }

   @ObfuscatedName("p")
   public void method3324(int var1) {
      for(int var2 = 0; var2 < this.field2664[var1].length; ++var2) {
         this.field2664[var1][var2] = null;
      }

   }

   @ObfuscatedName("r")
   public void method3325() {
      for(int var1 = 0; var1 < this.field2664.length; ++var1) {
         if(null != this.field2664[var1]) {
            for(int var2 = 0; var2 < this.field2664[var1].length; ++var2) {
               this.field2664[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("g")
   boolean method3326(int var1, int[] var2) {
      if(null == this.field2670[var1]) {
         return false;
      } else {
         int var3 = this.field2660[var1];
         int[] var4 = this.field2666[var1];
         Object[] var5 = this.field2664[var1];
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
            if(null == var2 || 0 == var2[0] && 0 == var2[1] && 0 == var2[2] && 0 == var2[3]) {
               var18 = class6.method119(this.field2670[var1], false);
            } else {
               var18 = class6.method119(this.field2670[var1], true);
               class118 var8 = new class118(var18);
               var8.method2554(var2, 5, var8.field1980.length);
            }

            byte[] var19 = class26.method678(var18);
            if(this.field2668) {
               this.field2670[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var19.length;
               --var9;
               int var10 = var19[var9] & 255;
               var9 -= var10 * var3 * 4;
               class118 var11 = new class118(var19);
               int[] var12 = new int[var3];
               var11.field1981 = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2541();
                     var12[var15] += var14;
                  }
               }

               byte[][] var20 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var20[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.field1981 = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2541();
                     System.arraycopy(var19, var14, var20[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2669) {
                     var5[var4[var15]] = class43.method958(var20[var15]);
                  } else {
                     var5[var4[var15]] = var20[var15];
                  }
               }
            } else if(!this.field2669) {
               var5[var4[0]] = class43.method958(var19);
            } else {
               var5[var4[0]] = var19;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("n")
   public int method3327(String var1) {
      var1 = var1.toLowerCase();
      return this.field2657.method3802(class43.method944(var1));
   }

   @ObfuscatedName("v")
   public byte[] method3329(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2657.method3802(class43.method944(var1));
      int var4 = this.field2663[var3].method3802(class43.method944(var2));
      return this.method3352(var3, var4);
   }

   @ObfuscatedName("q")
   public boolean method3330(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2657.method3802(class43.method944(var1));
      int var4 = this.field2663[var3].method3802(class43.method944(var2));
      return this.method3314(var3, var4);
   }

   @ObfuscatedName("x")
   public boolean method3331(String var1) {
      int var2 = this.method3327("");
      return -1 != var2?this.method3330("", var1):this.method3330(var1, "");
   }

   @ObfuscatedName("m")
   void vmethod3402(int var1) {
   }

   @ObfuscatedName("l")
   public byte[] method3337(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2664.length && null != this.field2664[var1] && var2 >= 0 && var2 < this.field2664[var1].length) {
         if(null == this.field2664[var1][var2]) {
            boolean var4 = this.method3326(var1, var3);
            if(!var4) {
               this.vmethod3403(var1);
               var4 = this.method3326(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class6.method119(this.field2664[var1][var2], false);
         if(this.field2669) {
            this.field2664[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("i")
   public byte[] method3338(int var1) {
      if(1 == this.field2664.length) {
         return this.method3352(0, var1);
      } else if(1 == this.field2664[var1].length) {
         return this.method3352(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("f")
   public byte[] method3352(int var1, int var2) {
      return this.method3337(var1, var2, (int[])null);
   }

   @ObfuscatedName("j")
   void method3360(byte[] var1) {
      int var3 = var1.length;
      int var2 = class8.method139(var1, 0, var3);
      this.field2661 = var2;
      class118 var4 = new class118(class26.method678(var1));
      int var5 = var4.method2536();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var4.method2541();
         }

         int var6 = var4.method2536();
         if(var5 >= 7) {
            this.field2667 = var4.method2593();
         } else {
            this.field2667 = var4.method2538();
         }

         int var7 = 0;
         int var8 = -1;
         this.field2655 = new int[this.field2667];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2667; ++var9) {
               this.field2655[var9] = var7 += var4.method2593();
               if(this.field2655[var9] > var8) {
                  var8 = this.field2655[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.field2667; ++var9) {
               this.field2655[var9] = var7 += var4.method2538();
               if(this.field2655[var9] > var8) {
                  var8 = this.field2655[var9];
               }
            }
         }

         this.field2658 = new int[var8 + 1];
         this.field2659 = new int[1 + var8];
         this.field2660 = new int[1 + var8];
         this.field2666 = new int[1 + var8][];
         this.field2670 = new Object[1 + var8];
         this.field2664 = new Object[1 + var8][];
         if(var6 != 0) {
            this.field2656 = new int[1 + var8];

            for(var9 = 0; var9 < this.field2667; ++var9) {
               this.field2656[this.field2655[var9]] = var4.method2541();
            }

            this.field2657 = new class191(this.field2656);
         }

         for(var9 = 0; var9 < this.field2667; ++var9) {
            this.field2658[this.field2655[var9]] = var4.method2541();
         }

         for(var9 = 0; var9 < this.field2667; ++var9) {
            this.field2659[this.field2655[var9]] = var4.method2541();
         }

         for(var9 = 0; var9 < this.field2667; ++var9) {
            this.field2660[this.field2655[var9]] = var4.method2538();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2667; ++var9) {
               var10 = this.field2655[var9];
               var11 = this.field2660[var10];
               var7 = 0;
               var12 = -1;
               this.field2666[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2666[var10][var13] = var7 += var4.method2593();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2664[var10] = new Object[1 + var12];
            }
         } else {
            for(var9 = 0; var9 < this.field2667; ++var9) {
               var10 = this.field2655[var9];
               var11 = this.field2660[var10];
               var7 = 0;
               var12 = -1;
               this.field2666[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2666[var10][var13] = var7 += var4.method2538();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2664[var10] = new Object[1 + var12];
            }
         }

         if(0 != var6) {
            this.field2662 = new int[var8 + 1][];
            this.field2663 = new class191[1 + var8];

            for(var9 = 0; var9 < this.field2667; ++var9) {
               var10 = this.field2655[var9];
               var11 = this.field2660[var10];
               this.field2662[var10] = new int[this.field2664[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.field2662[var10][this.field2666[var10][var12]] = var4.method2541();
               }

               this.field2663[var10] = new class191(this.field2662[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("z")
   public int method3361() {
      return this.field2664.length;
   }

   class166(boolean var1, boolean var2) {
      this.field2668 = var1;
      this.field2669 = var2;
   }

   @ObfuscatedName("d")
   public void method3394(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2657.method3802(class43.method944(var1));
      if(var2 >= 0) {
         this.vmethod3402(var2);
      }
   }
}
