import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public abstract class class166 {
   @ObfuscatedName("y")
   int[] field2656;
   @ObfuscatedName("r")
   int[] field2657;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -418382747
   )
   int field2658;
   @ObfuscatedName("s")
   class191 field2659;
   @ObfuscatedName("n")
   class191[] field2660;
   @ObfuscatedName("e")
   int[] field2661;
   @ObfuscatedName("g")
   int[] field2662;
   @ObfuscatedName("m")
   int[][] field2663;
   @ObfuscatedName("j")
   int[][] field2664;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1274752393
   )
   public int field2665;
   @ObfuscatedName("l")
   Object[] field2666;
   @ObfuscatedName("h")
   Object[][] field2667;
   @ObfuscatedName("i")
   static class115 field2668 = new class115();
   @ObfuscatedName("z")
   boolean field2669;
   @ObfuscatedName("f")
   int[] field2670;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -264993959
   )
   static int field2672 = 0;
   @ObfuscatedName("u")
   boolean field2673;

   class166(boolean var1, boolean var2) {
      this.field2669 = var1;
      this.field2673 = var2;
   }

   @ObfuscatedName("r")
   void vmethod3357(int var1) {
   }

   @ObfuscatedName("f")
   public byte[] method3263(int var1, int var2) {
      return this.method3311(var1, var2, (int[])null);
   }

   @ObfuscatedName("y")
   public boolean method3265(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2667.length && null != this.field2667[var1] && var2 >= 0 && var2 < this.field2667[var1].length) {
         if(this.field2667[var1][var2] != null) {
            return true;
         } else if(this.field2666[var1] != null) {
            return true;
         } else {
            this.vmethod3369(var1);
            return null != this.field2666[var1];
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("g")
   public boolean method3267() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2657.length; ++var2) {
         int var3 = this.field2657[var2];
         if(null == this.field2666[var3]) {
            this.vmethod3369(var3);
            if(this.field2666[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("m")
   public byte[] method3268(int var1) {
      if(1 == this.field2667.length) {
         return this.method3263(0, var1);
      } else if(1 == this.field2667[var1].length) {
         return this.method3263(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("n")
   public byte[] method3270(int var1) {
      if(this.field2667.length == 1) {
         return this.method3299(0, var1);
      } else if(this.field2667[var1].length == 1) {
         return this.method3299(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("l")
   void vmethod3369(int var1) {
   }

   @ObfuscatedName("h")
   public int[] method3272(int var1) {
      return this.field2663[var1];
   }

   @ObfuscatedName("i")
   public int method3273(int var1) {
      return this.field2667[var1].length;
   }

   @ObfuscatedName("p")
   public boolean method3275(String var1) {
      int var2 = this.method3278("");
      return var2 != -1?this.method3281("", var1):this.method3281(var1, "");
   }

   @ObfuscatedName("u")
   public void method3276() {
      for(int var1 = 0; var1 < this.field2667.length; ++var1) {
         if(null != this.field2667[var1]) {
            for(int var2 = 0; var2 < this.field2667[var1].length; ++var2) {
               this.field2667[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("t")
   boolean method3277(int var1, int[] var2) {
      if(this.field2666[var1] == null) {
         return false;
      } else {
         int var3 = this.field2662[var1];
         int[] var4 = this.field2663[var1];
         Object[] var5 = this.field2667[var1];
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
            if(var2 == null || var2[0] == 0 && 0 == var2[1] && var2[2] == 0 && 0 == var2[3]) {
               var18 = class76.method1677(this.field2666[var1], false);
            } else {
               var18 = class76.method1677(this.field2666[var1], true);
               class118 var8 = new class118(var18);
               var8.method2531(var2, 5, var8.field1980.length);
            }

            byte[] var19 = class143.method3110(var18);
            if(this.field2669) {
               this.field2666[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var19.length;
               --var9;
               int var10 = var19[var9] & 255;
               var9 -= var10 * var3 * 4;
               class118 var11 = new class118(var19);
               int[] var12 = new int[var3];
               var11.field1979 = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2517();
                     var12[var15] += var14;
                  }
               }

               byte[][] var20 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var20[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.field1979 = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2517();
                     System.arraycopy(var19, var14, var20[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2673) {
                     var5[var4[var15]] = class3.method51(var20[var15]);
                  } else {
                     var5[var4[var15]] = var20[var15];
                  }
               }
            } else if(!this.field2673) {
               var5[var4[0]] = class3.method51(var19);
            } else {
               var5[var4[0]] = var19;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("b")
   public int method3278(String var1) {
      var1 = var1.toLowerCase();
      return this.field2659.method3790(class122.method2784(var1));
   }

   @ObfuscatedName("x")
   public byte[] method3280(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2659.method3790(class122.method2784(var1));
      int var4 = this.field2660[var3].method3790(class122.method2784(var2));
      return this.method3263(var3, var4);
   }

   @ObfuscatedName("d")
   public boolean method3281(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2659.method3790(class122.method2784(var1));
      int var4 = this.field2660[var3].method3790(class122.method2784(var2));
      return this.method3265(var3, var4);
   }

   @ObfuscatedName("q")
   public void method3283(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2659.method3790(class122.method2784(var1));
      if(var2 >= 0) {
         this.vmethod3357(var2);
      }
   }

   @ObfuscatedName("v")
   public int method3287() {
      return this.field2667.length;
   }

   @ObfuscatedName("e")
   public boolean method3295(int var1) {
      if(null != this.field2666[var1]) {
         return true;
      } else {
         this.vmethod3369(var1);
         return null != this.field2666[var1];
      }
   }

   @ObfuscatedName("j")
   public byte[] method3299(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2667.length && this.field2667[var1] != null && var2 >= 0 && var2 < this.field2667[var1].length) {
         if(this.field2667[var1][var2] == null) {
            boolean var3 = this.method3277(var1, (int[])null);
            if(!var3) {
               this.vmethod3369(var1);
               var3 = this.method3277(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class76.method1677(this.field2667[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("s")
   public byte[] method3311(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2667.length && null != this.field2667[var1] && var2 >= 0 && var2 < this.field2667[var1].length) {
         if(null == this.field2667[var1][var2]) {
            boolean var4 = this.method3277(var1, var3);
            if(!var4) {
               this.vmethod3369(var1);
               var4 = this.method3277(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class76.method1677(this.field2667[var1][var2], false);
         if(this.field2673) {
            this.field2667[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("c")
   public int method3328(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2660[var1].method3790(class122.method2784(var2));
   }

   @ObfuscatedName("z")
   public void method3331(int var1) {
      for(int var2 = 0; var2 < this.field2667[var1].length; ++var2) {
         this.field2667[var1][var2] = null;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "16"
   )
   void method3343(byte[] var1) {
      this.field2665 = class34.method732(var1, var1.length);
      class118 var2 = new class118(class143.method3110(var1));
      int var3 = var2.method2579();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.method2517();
         }

         int var4 = var2.method2579();
         if(var3 >= 7) {
            this.field2658 = var2.method2526();
         } else {
            this.field2658 = var2.method2514();
         }

         int var5 = 0;
         int var6 = -1;
         this.field2657 = new int[this.field2658];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2658; ++var7) {
               this.field2657[var7] = var5 += var2.method2526();
               if(this.field2657[var7] > var6) {
                  var6 = this.field2657[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.field2658; ++var7) {
               this.field2657[var7] = var5 += var2.method2514();
               if(this.field2657[var7] > var6) {
                  var6 = this.field2657[var7];
               }
            }
         }

         this.field2656 = new int[1 + var6];
         this.field2661 = new int[var6 + 1];
         this.field2662 = new int[var6 + 1];
         this.field2663 = new int[var6 + 1][];
         this.field2666 = new Object[var6 + 1];
         this.field2667 = new Object[1 + var6][];
         if(var4 != 0) {
            this.field2670 = new int[var6 + 1];

            for(var7 = 0; var7 < this.field2658; ++var7) {
               this.field2670[this.field2657[var7]] = var2.method2517();
            }

            this.field2659 = new class191(this.field2670);
         }

         for(var7 = 0; var7 < this.field2658; ++var7) {
            this.field2656[this.field2657[var7]] = var2.method2517();
         }

         for(var7 = 0; var7 < this.field2658; ++var7) {
            this.field2661[this.field2657[var7]] = var2.method2517();
         }

         for(var7 = 0; var7 < this.field2658; ++var7) {
            this.field2662[this.field2657[var7]] = var2.method2514();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2658; ++var7) {
               var8 = this.field2657[var7];
               var9 = this.field2662[var8];
               var5 = 0;
               var10 = -1;
               this.field2663[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2663[var8][var11] = var5 += var2.method2526();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2667[var8] = new Object[1 + var10];
            }
         } else {
            for(var7 = 0; var7 < this.field2658; ++var7) {
               var8 = this.field2657[var7];
               var9 = this.field2662[var8];
               var5 = 0;
               var10 = -1;
               this.field2663[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2663[var8][var11] = var5 += var2.method2514();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2667[var8] = new Object[var10 + 1];
            }
         }

         if(var4 != 0) {
            this.field2664 = new int[1 + var6][];
            this.field2660 = new class191[var6 + 1];

            for(var7 = 0; var7 < this.field2658; ++var7) {
               var8 = this.field2657[var7];
               var9 = this.field2662[var8];
               this.field2664[var8] = new int[this.field2667[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.field2664[var8][this.field2663[var8][var10]] = var2.method2517();
               }

               this.field2660[var8] = new class191(this.field2664[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "6"
   )
   static final void method3355(int var0, int var1) {
      class198 var2 = client.field419[class48.field1078][var0][var1];
      if(null == var2) {
         class77.field1396.method1943(class48.field1078, var0, var1);
      } else {
         long var3 = -99999999L;
         class28 var5 = null;

         class28 var6;
         for(var6 = (class28)var2.method3860(); var6 != null; var6 = (class28)var2.method3861()) {
            class51 var7 = class75.method1648(var6.field681);
            long var8 = (long)var7.field1143;
            if(1 == var7.field1126) {
               var8 *= (long)(1 + var6.field677);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(null == var5) {
            class77.field1396.method1943(class48.field1078, var0, var1);
         } else {
            var2.method3856(var5);
            class28 var10 = null;
            class28 var11 = null;

            for(var6 = (class28)var2.method3860(); var6 != null; var6 = (class28)var2.method3861()) {
               if(var5.field681 != var6.field681) {
                  if(var10 == null) {
                     var10 = var6;
                  }

                  if(var10.field681 != var6.field681 && null == var11) {
                     var11 = var6;
                  }
               }
            }

            int var9 = 1610612736 + (var1 << 7) + var0;
            class77.field1396.method2086(class48.field1078, var0, var1, class4.method52(128 * var0 + 64, var1 * 128 + 64, class48.field1078), var5, var9, var10, var11);
         }
      }
   }
}
