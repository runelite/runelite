import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public abstract class class167 {
   @ObfuscatedName("b")
   class192 field2665;
   @ObfuscatedName("r")
   Object[] field2666;
   @ObfuscatedName("x")
   int[] field2667;
   @ObfuscatedName("g")
   int[][] field2668;
   @ObfuscatedName("l")
   int[] field2669;
   @ObfuscatedName("n")
   int[] field2670;
   @ObfuscatedName("d")
   int[] field2671;
   @ObfuscatedName("m")
   int[][] field2672;
   @ObfuscatedName("u")
   int[] field2673;
   @ObfuscatedName("s")
   class192[] field2674;
   @ObfuscatedName("ge")
   static class173 field2675;
   @ObfuscatedName("k")
   Object[][] field2676;
   @ObfuscatedName("o")
   static class116 field2677 = new class116();
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -592835927
   )
   public int field2678;
   @ObfuscatedName("p")
   boolean field2679;
   @ObfuscatedName("h")
   boolean field2680;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -995044159
   )
   static int field2681 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 499639535
   )
   int field2682;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1171043006"
   )
   void vmethod3363(int var1) {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "85927516"
   )
   public byte[] method3286(int var1, int var2) {
      return this.method3287(var1, var2, (int[])null);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II[IB)[B",
      garbageValue = "98"
   )
   public byte[] method3287(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2676.length && this.field2676[var1] != null && var2 >= 0 && var2 < this.field2676[var1].length) {
         if(null == this.field2676[var1][var2]) {
            boolean var4 = this.method3299(var1, var3);
            if(!var4) {
               this.vmethod3364(var1);
               var4 = this.method3299(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class35.method774(this.field2676[var1][var2], false);
         if(this.field2680) {
            this.field2676[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "1"
   )
   public boolean method3288(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2676.length && null != this.field2676[var1] && var2 >= 0 && var2 < this.field2676[var1].length) {
         if(null != this.field2676[var1][var2]) {
            return true;
         } else if(this.field2666[var1] != null) {
            return true;
         } else {
            this.vmethod3364(var1);
            return null != this.field2666[var1];
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "216393104"
   )
   public boolean method3289(int var1) {
      if(this.field2666[var1] != null) {
         return true;
      } else {
         this.vmethod3364(var1);
         return null != this.field2666[var1];
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1800194162"
   )
   public boolean method3290() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2673.length; ++var2) {
         int var3 = this.field2673[var2];
         if(null == this.field2666[var3]) {
            this.vmethod3364(var3);
            if(this.field2666[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "2019856775"
   )
   public byte[] method3291(int var1) {
      if(this.field2676.length == 1) {
         return this.method3286(0, var1);
      } else if(this.field2676[var1].length == 1) {
         return this.method3286(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1724205944"
   )
   public int method3292() {
      return this.field2676.length;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "0"
   )
   public byte[] method3295(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2676.length && null != this.field2676[var1] && var2 >= 0 && var2 < this.field2676[var1].length) {
         if(this.field2676[var1][var2] == null) {
            boolean var3 = this.method3299(var1, (int[])null);
            if(!var3) {
               this.vmethod3364(var1);
               var3 = this.method3299(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class35.method774(this.field2676[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   class167(boolean var1, boolean var2) {
      this.field2679 = var1;
      this.field2680 = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "730090871"
   )
   public void method3297(int var1) {
      for(int var2 = 0; var2 < this.field2676[var1].length; ++var2) {
         this.field2676[var1][var2] = null;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2028480641"
   )
   public void method3298() {
      for(int var1 = 0; var1 < this.field2676.length; ++var1) {
         if(this.field2676[var1] != null) {
            for(int var2 = 0; var2 < this.field2676[var1].length; ++var2) {
               this.field2676[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "1249866445"
   )
   boolean method3299(int var1, int[] var2) {
      if(this.field2666[var1] == null) {
         return false;
      } else {
         int var3 = this.field2670[var1];
         int[] var4 = this.field2672[var1];
         Object[] var5 = this.field2676[var1];
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
               var18 = class35.method774(this.field2666[var1], false);
            } else {
               var18 = class35.method774(this.field2666[var1], true);
               class119 var8 = new class119(var18);
               var8.method2573(var2, 5, var8.field2000.length);
            }

            byte[] var20 = class186.method3756(var18);
            if(this.field2679) {
               this.field2666[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= 4 * var10 * var3;
               class119 var11 = new class119(var20);
               int[] var12 = new int[var3];
               var11.field1998 = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2696();
                     var12[var15] += var14;
                  }
               }

               byte[][] var19 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var19[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.field1998 = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2696();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2680) {
                     var5[var4[var15]] = class46.method1022(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2680) {
               var5[var4[0]] = class46.method1022(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "698524162"
   )
   public int method3300(String var1) {
      var1 = var1.toLowerCase();
      return this.field2665.method3784(class165.method3271(var1));
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;S)I",
      garbageValue = "11304"
   )
   public int method3301(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2674[var1].method3784(class165.method3271(var2));
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "61"
   )
   public byte[] method3302(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2665.method3784(class165.method3271(var1));
      int var4 = this.field2674[var3].method3784(class165.method3271(var2));
      return this.method3286(var3, var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1607784323"
   )
   public void method3304(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2665.method3784(class165.method3271(var1));
      if(var2 >= 0) {
         this.vmethod3363(var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "6"
   )
   public int method3321(int var1) {
      return this.field2676[var1].length;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1329470439"
   )
   void vmethod3364(int var1) {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "-21"
   )
   public boolean method3324(String var1) {
      int var2 = this.method3300("");
      return var2 != -1?this.method3348("", var1):this.method3348(var1, "");
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "827535253"
   )
   public int[] method3342(int var1) {
      return this.field2672[var1];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1989130746"
   )
   public byte[] method3346(int var1) {
      if(this.field2676.length == 1) {
         return this.method3295(0, var1);
      } else if(this.field2676[var1].length == 1) {
         return this.method3295(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-327712755"
   )
   public boolean method3348(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2665.method3784(class165.method3271(var1));
      int var4 = this.field2674[var3].method3784(class165.method3271(var2));
      return this.method3288(var3, var4);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-126"
   )
   void method3351(byte[] var1) {
      int var3 = var1.length;
      int var5 = -1;

      int var6;
      for(var6 = 0; var6 < var3; ++var6) {
         var5 = var5 >>> 8 ^ class119.field1999[(var5 ^ var1[var6]) & 255];
      }

      var5 = ~var5;
      this.field2678 = var5;
      class119 var4 = new class119(class186.method3756(var1));
      var5 = var4.method2554();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var4.method2696();
         }

         var6 = var4.method2554();
         if(var5 >= 7) {
            this.field2682 = var4.method2728();
         } else {
            this.field2682 = var4.method2556();
         }

         int var7 = 0;
         int var8 = -1;
         this.field2673 = new int[this.field2682];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2682; ++var9) {
               this.field2673[var9] = var7 += var4.method2728();
               if(this.field2673[var9] > var8) {
                  var8 = this.field2673[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.field2682; ++var9) {
               this.field2673[var9] = var7 += var4.method2556();
               if(this.field2673[var9] > var8) {
                  var8 = this.field2673[var9];
               }
            }
         }

         this.field2669 = new int[var8 + 1];
         this.field2671 = new int[var8 + 1];
         this.field2670 = new int[var8 + 1];
         this.field2672 = new int[1 + var8][];
         this.field2666 = new Object[var8 + 1];
         this.field2676 = new Object[var8 + 1][];
         if(var6 != 0) {
            this.field2667 = new int[1 + var8];

            for(var9 = 0; var9 < this.field2682; ++var9) {
               this.field2667[this.field2673[var9]] = var4.method2696();
            }

            this.field2665 = new class192(this.field2667);
         }

         for(var9 = 0; var9 < this.field2682; ++var9) {
            this.field2669[this.field2673[var9]] = var4.method2696();
         }

         for(var9 = 0; var9 < this.field2682; ++var9) {
            this.field2671[this.field2673[var9]] = var4.method2696();
         }

         for(var9 = 0; var9 < this.field2682; ++var9) {
            this.field2670[this.field2673[var9]] = var4.method2556();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2682; ++var9) {
               var10 = this.field2673[var9];
               var11 = this.field2670[var10];
               var7 = 0;
               var12 = -1;
               this.field2672[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2672[var10][var13] = var7 += var4.method2728();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2676[var10] = new Object[1 + var12];
            }
         } else {
            for(var9 = 0; var9 < this.field2682; ++var9) {
               var10 = this.field2673[var9];
               var11 = this.field2670[var10];
               var7 = 0;
               var12 = -1;
               this.field2672[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2672[var10][var13] = var7 += var4.method2556();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2676[var10] = new Object[1 + var12];
            }
         }

         if(var6 != 0) {
            this.field2668 = new int[var8 + 1][];
            this.field2674 = new class192[var8 + 1];

            for(var9 = 0; var9 < this.field2682; ++var9) {
               var10 = this.field2673[var9];
               var11 = this.field2670[var10];
               this.field2668[var10] = new int[this.field2676[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.field2668[var10][this.field2672[var10][var12]] = var4.method2696();
               }

               this.field2674[var10] = new class192(this.field2668[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2081835178"
   )
   public static boolean method3361(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }
}
