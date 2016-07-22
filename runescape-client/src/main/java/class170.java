import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public abstract class class170 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 237564953
   )
   int field2723;
   @ObfuscatedName("w")
   int[] field2724;
   @ObfuscatedName("e")
   int[] field2725;
   @ObfuscatedName("j")
   int[] field2726;
   @ObfuscatedName("s")
   boolean field2728;
   @ObfuscatedName("o")
   class195 field2729;
   @ObfuscatedName("r")
   int[][] field2730;
   @ObfuscatedName("x")
   int[][] field2731;
   @ObfuscatedName("k")
   class195[] field2732;
   @ObfuscatedName("v")
   Object[] field2733;
   @ObfuscatedName("h")
   Object[][] field2734;
   @ObfuscatedName("u")
   static class119 field2735 = new class119();
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -174543635
   )
   public int field2736;
   @ObfuscatedName("p")
   boolean field2737;
   @ObfuscatedName("g")
   int[] field2738;
   @ObfuscatedName("l")
   int[] field2739;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -948800263
   )
   static int field2740 = 0;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1741555609"
   )
   public void method3301(int var1) {
      for(int var2 = 0; var2 < this.field2734[var1].length; ++var2) {
         this.field2734[var1][var2] = null;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "81"
   )
   void vmethod3403(int var1) {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "748010224"
   )
   public byte[] method3304(int var1, int var2) {
      return this.method3305(var1, var2, (int[])null);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II[IB)[B",
      garbageValue = "1"
   )
   public byte[] method3305(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2734.length && null != this.field2734[var1] && var2 >= 0 && var2 < this.field2734[var1].length) {
         if(null == this.field2734[var1][var2]) {
            boolean var5 = this.method3318(var1, var3);
            if(!var5) {
               this.vmethod3385(var1);
               var5 = this.method3318(var1, var3);
               if(!var5) {
                  return null;
               }
            }
         }

         byte[] var4 = class125.method2820(this.field2734[var1][var2], false);
         if(this.field2728) {
            this.field2734[var1][var2] = null;
         }

         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1814420804"
   )
   public int method3306() {
      return this.field2734.length;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1341194127"
   )
   public boolean method3307(int var1) {
      if(null != this.field2733[var1]) {
         return true;
      } else {
         this.vmethod3385(var1);
         return null != this.field2733[var1];
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-32"
   )
   public boolean method3308() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2724.length; ++var2) {
         int var3 = this.field2724[var2];
         if(null == this.field2733[var3]) {
            this.vmethod3385(var3);
            if(null == this.field2733[var3]) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "12"
   )
   public byte[] method3309(int var1) {
      if(this.field2734.length == 1) {
         return this.method3304(0, var1);
      } else if(this.field2734[var1].length == 1) {
         return this.method3304(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-2045831638"
   )
   public byte[] method3310(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2734.length && this.field2734[var1] != null && var2 >= 0 && var2 < this.field2734[var1].length) {
         if(null == this.field2734[var1][var2]) {
            boolean var4 = this.method3318(var1, (int[])null);
            if(!var4) {
               this.vmethod3385(var1);
               var4 = this.method3318(var1, (int[])null);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var3 = class125.method2820(this.field2734[var1][var2], false);
         return var3;
      } else {
         return null;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-60"
   )
   void vmethod3385(int var1) {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "736926216"
   )
   public int method3317(int var1) {
      return this.field2734[var1].length;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "-508455749"
   )
   boolean method3318(int var1, int[] var2) {
      if(this.field2733[var1] == null) {
         return false;
      } else {
         int var3 = this.field2726[var1];
         int[] var4 = this.field2730[var1];
         Object[] var5 = this.field2734[var1];
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
               var18 = class125.method2820(this.field2733[var1], false);
            } else {
               var18 = class125.method2820(this.field2733[var1], true);
               class122 var8 = new class122(var18);
               var8.method2591(var2, 5, var8.field2047.length);
            }

            byte[] var20 = class156.method3200(var18);
            if(this.field2737) {
               this.field2733[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= var10 * var3 * 4;
               class122 var11 = new class122(var20);
               int[] var12 = new int[var3];
               var11.field2045 = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2577();
                     var12[var15] += var14;
                  }
               }

               byte[][] var19 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var19[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.field2045 = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2577();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2728) {
                     var5[var4[var15]] = class132.method2879(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2728) {
               var5[var4[0]] = class132.method2879(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "409861283"
   )
   public int method3319(String var1) {
      var1 = var1.toLowerCase();
      return this.field2729.method3806(class111.method2480(var1));
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1878941185"
   )
   public void method3320() {
      for(int var1 = 0; var1 < this.field2734.length; ++var1) {
         if(null != this.field2734[var1]) {
            for(int var2 = 0; var2 < this.field2734[var1].length; ++var2) {
               this.field2734[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "-73"
   )
   public boolean method3322(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2729.method3806(class111.method2480(var1));
      int var4 = this.field2732[var3].method3806(class111.method2480(var2));
      return this.method3359(var3, var4);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1945812024"
   )
   public void method3324(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2729.method3806(class111.method2480(var1));
      if(var2 >= 0) {
         this.vmethod3403(var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1037441965"
   )
   static void method3326(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      class175 var4 = (class175)class174.field2773.method3856(var2);
      if(null != var4) {
         class174.field2764.method3942(var4);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;S)[B",
      garbageValue = "-2889"
   )
   public byte[] method3334(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2729.method3806(class111.method2480(var1));
      int var4 = this.field2732[var3].method3806(class111.method2480(var2));
      return this.method3304(var3, var4);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "860472273"
   )
   public boolean method3345(String var1) {
      int var2 = this.method3319("");
      return var2 != -1?this.method3322("", var1):this.method3322(var1, "");
   }

   class170(boolean var1, boolean var2) {
      this.field2737 = var1;
      this.field2728 = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "638235416"
   )
   public int[] method3353(int var1) {
      return this.field2730[var1];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1482059963"
   )
   public boolean method3359(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2734.length && null != this.field2734[var1] && var2 >= 0 && var2 < this.field2734[var1].length) {
         if(this.field2734[var1][var2] != null) {
            return true;
         } else if(null != this.field2733[var1]) {
            return true;
         } else {
            this.vmethod3385(var1);
            return null != this.field2733[var1];
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1753082391"
   )
   public byte[] method3363(int var1) {
      if(this.field2734.length == 1) {
         return this.method3310(0, var1);
      } else if(this.field2734[var1].length == 1) {
         return this.method3310(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-330008531"
   )
   void method3366(byte[] var1) {
      this.field2736 = class79.method1763(var1, var1.length);
      class122 var2 = new class122(class156.method3200(var1));
      int var3 = var2.method2556();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.method2577();
         }

         int var4 = var2.method2556();
         if(var3 >= 7) {
            this.field2723 = var2.method2737();
         } else {
            this.field2723 = var2.method2706();
         }

         int var5 = 0;
         int var6 = -1;
         this.field2724 = new int[this.field2723];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2723; ++var7) {
               this.field2724[var7] = var5 += var2.method2737();
               if(this.field2724[var7] > var6) {
                  var6 = this.field2724[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.field2723; ++var7) {
               this.field2724[var7] = var5 += var2.method2706();
               if(this.field2724[var7] > var6) {
                  var6 = this.field2724[var7];
               }
            }
         }

         this.field2738 = new int[1 + var6];
         this.field2739 = new int[var6 + 1];
         this.field2726 = new int[var6 + 1];
         this.field2730 = new int[var6 + 1][];
         this.field2733 = new Object[1 + var6];
         this.field2734 = new Object[1 + var6][];
         if(var4 != 0) {
            this.field2725 = new int[var6 + 1];

            for(var7 = 0; var7 < this.field2723; ++var7) {
               this.field2725[this.field2724[var7]] = var2.method2577();
            }

            this.field2729 = new class195(this.field2725);
         }

         for(var7 = 0; var7 < this.field2723; ++var7) {
            this.field2738[this.field2724[var7]] = var2.method2577();
         }

         for(var7 = 0; var7 < this.field2723; ++var7) {
            this.field2739[this.field2724[var7]] = var2.method2577();
         }

         for(var7 = 0; var7 < this.field2723; ++var7) {
            this.field2726[this.field2724[var7]] = var2.method2706();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2723; ++var7) {
               var8 = this.field2724[var7];
               var9 = this.field2726[var8];
               var5 = 0;
               var10 = -1;
               this.field2730[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2730[var8][var11] = var5 += var2.method2737();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2734[var8] = new Object[1 + var10];
            }
         } else {
            for(var7 = 0; var7 < this.field2723; ++var7) {
               var8 = this.field2724[var7];
               var9 = this.field2726[var8];
               var5 = 0;
               var10 = -1;
               this.field2730[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2730[var8][var11] = var5 += var2.method2706();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2734[var8] = new Object[1 + var10];
            }
         }

         if(var4 != 0) {
            this.field2731 = new int[1 + var6][];
            this.field2732 = new class195[1 + var6];

            for(var7 = 0; var7 < this.field2723; ++var7) {
               var8 = this.field2724[var7];
               var9 = this.field2726[var8];
               this.field2731[var8] = new int[this.field2734[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.field2731[var8][this.field2730[var8][var10]] = var2.method2577();
               }

               this.field2732[var8] = new class195(this.field2731[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "-104098039"
   )
   public int method3368(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2732[var1].method3806(class111.method2480(var2));
   }

   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      signature = "(Lclass176;I)Ljava/lang/String;",
      garbageValue = "1643473951"
   )
   static String method3381(class176 var0) {
      return class25.method599(class12.method151(var0)) == 0?null:(var0.field2874 != null && var0.field2874.trim().length() != 0?var0.field2874:null);
   }
}
