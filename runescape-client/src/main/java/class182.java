import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
public abstract class class182 {
   @ObfuscatedName("v")
   int[] field2715;
   @ObfuscatedName("m")
   int[] field2716;
   @ObfuscatedName("b")
   int[] field2717;
   @ObfuscatedName("z")
   Object[] field2718;
   @ObfuscatedName("h")
   int[] field2719;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -183674127
   )
   static int field2720 = 0;
   @ObfuscatedName("l")
   int[] field2721;
   @ObfuscatedName("i")
   boolean field2722;
   @ObfuscatedName("u")
   int[][] field2723;
   @ObfuscatedName("k")
   class122[] field2724;
   @ObfuscatedName("p")
   boolean field2725;
   @ObfuscatedName("y")
   Object[][] field2726;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1349813269
   )
   int field2727;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1231315463
   )
   public int field2728;
   @ObfuscatedName("c")
   int[][] field2729;
   @ObfuscatedName("j")
   static class146 field2730 = new class146();
   @ObfuscatedName("g")
   class122 field2731;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2136437876"
   )
   void vmethod3295(int var1) {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "437797695"
   )
   void method3201(byte[] var1) {
      int var3 = var1.length;
      int var2 = class85.method1663(var1, 0, var3);
      this.field2728 = var2;
      Buffer var4 = new Buffer(class7.method88(var1));
      int var5 = var4.readUnsignedByte();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var4.method2731();
         }

         int var6 = var4.readUnsignedByte();
         if(var5 >= 7) {
            this.field2727 = var4.method2721();
         } else {
            this.field2727 = var4.readUnsignedShort();
         }

         int var7 = 0;
         int var8 = -1;
         this.field2716 = new int[this.field2727];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2727; ++var9) {
               this.field2716[var9] = var7 += var4.method2721();
               if(this.field2716[var9] > var8) {
                  var8 = this.field2716[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.field2727; ++var9) {
               this.field2716[var9] = var7 += var4.readUnsignedShort();
               if(this.field2716[var9] > var8) {
                  var8 = this.field2716[var9];
               }
            }
         }

         this.field2719 = new int[var8 + 1];
         this.field2715 = new int[1 + var8];
         this.field2721 = new int[var8 + 1];
         this.field2729 = new int[var8 + 1][];
         this.field2718 = new Object[var8 + 1];
         this.field2726 = new Object[1 + var8][];
         if(var6 != 0) {
            this.field2717 = new int[1 + var8];

            for(var9 = 0; var9 < this.field2727; ++var9) {
               this.field2717[this.field2716[var9]] = var4.method2731();
            }

            this.field2731 = new class122(this.field2717);
         }

         for(var9 = 0; var9 < this.field2727; ++var9) {
            this.field2719[this.field2716[var9]] = var4.method2731();
         }

         for(var9 = 0; var9 < this.field2727; ++var9) {
            this.field2715[this.field2716[var9]] = var4.method2731();
         }

         for(var9 = 0; var9 < this.field2727; ++var9) {
            this.field2721[this.field2716[var9]] = var4.readUnsignedShort();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2727; ++var9) {
               var10 = this.field2716[var9];
               var11 = this.field2721[var10];
               var7 = 0;
               var12 = -1;
               this.field2729[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2729[var10][var13] = var7 += var4.method2721();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2726[var10] = new Object[var12 + 1];
            }
         } else {
            for(var9 = 0; var9 < this.field2727; ++var9) {
               var10 = this.field2716[var9];
               var11 = this.field2721[var10];
               var7 = 0;
               var12 = -1;
               this.field2729[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2729[var10][var13] = var7 += var4.readUnsignedShort();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2726[var10] = new Object[1 + var12];
            }
         }

         if(var6 != 0) {
            this.field2723 = new int[var8 + 1][];
            this.field2724 = new class122[1 + var8];

            for(var9 = 0; var9 < this.field2727; ++var9) {
               var10 = this.field2716[var9];
               var11 = this.field2721[var10];
               this.field2723[var10] = new int[this.field2726[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.field2723[var10][this.field2729[var10][var12]] = var4.method2731();
               }

               this.field2724[var10] = new class122(this.field2723[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "-101"
   )
   public byte[] method3203(int var1, int var2) {
      return this.method3279(var1, var2, (int[])null);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1697180035"
   )
   public boolean method3205(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2726.length && null != this.field2726[var1] && var2 >= 0 && var2 < this.field2726[var1].length) {
         if(null != this.field2726[var1][var2]) {
            return true;
         } else if(null != this.field2718[var1]) {
            return true;
         } else {
            this.vmethod3313(var1);
            return this.field2718[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-906579640"
   )
   public boolean method3206(int var1) {
      if(this.field2718[var1] != null) {
         return true;
      } else {
         this.vmethod3313(var1);
         return null != this.field2718[var1];
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2060131030"
   )
   public boolean method3207() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2716.length; ++var2) {
         int var3 = this.field2716[var2];
         if(this.field2718[var3] == null) {
            this.vmethod3313(var3);
            if(this.field2718[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "883062146"
   )
   public byte[] method3208(int var1) {
      if(this.field2726.length == 1) {
         return this.method3203(0, var1);
      } else if(this.field2726[var1].length == 1) {
         return this.method3203(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIS)[B",
      garbageValue = "18579"
   )
   public byte[] method3209(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2726.length && this.field2726[var1] != null && var2 >= 0 && var2 < this.field2726[var1].length) {
         if(null == this.field2726[var1][var2]) {
            boolean var3 = this.method3217(var1, (int[])null);
            if(!var3) {
               this.vmethod3313(var1);
               var3 = this.method3217(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class7.method73(this.field2726[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "52"
   )
   public int[] method3212(int var1) {
      return this.field2729[var1];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-116"
   )
   public void method3215(int var1) {
      for(int var2 = 0; var2 < this.field2726[var1].length; ++var2) {
         this.field2726[var1][var2] = null;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I[IS)Z",
      garbageValue = "10438"
   )
   boolean method3217(int var1, int[] var2) {
      if(this.field2718[var1] == null) {
         return false;
      } else {
         int var3 = this.field2721[var1];
         int[] var4 = this.field2729[var1];
         Object[] var5 = this.field2726[var1];
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
               var18 = class7.method73(this.field2718[var1], false);
            } else {
               var18 = class7.method73(this.field2718[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method2746(var2, 5, var8.payload.length);
            }

            byte[] var20 = class7.method88(var18);
            if(this.field2725) {
               this.field2718[var1] = null;
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
                     var14 += var11.method2731();
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
                     var16 += var11.method2731();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2722) {
                     var5[var4[var15]] = class177.method3189(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2722) {
               var5[var4[0]] = class177.method3189(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1942360395"
   )
   public int method3218(String var1) {
      var1 = var1.toLowerCase();
      return this.field2731.method2269(class142.method2616(var1));
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)I",
      garbageValue = "8"
   )
   public int method3219(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2724[var1].method2269(class142.method2616(var2));
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "37"
   )
   public byte[] method3220(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2731.method2269(class142.method2616(var1));
      int var4 = this.field2724[var3].method2269(class142.method2616(var2));
      return this.method3203(var3, var4);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-66062527"
   )
   public boolean method3221(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2731.method2269(class142.method2616(var1));
      int var4 = this.field2724[var3].method2269(class142.method2616(var2));
      return this.method3205(var3, var4);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1887577574"
   )
   public boolean method3222(String var1) {
      int var2 = this.method3218("");
      return var2 != -1?this.method3221("", var1):this.method3221(var1, "");
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "787543879"
   )
   public void method3223(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2731.method2269(class142.method2616(var1));
      if(var2 >= 0) {
         this.vmethod3295(var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-122"
   )
   public int method3245(int var1) {
      return this.field2726[var1].length;
   }

   class182(boolean var1, boolean var2) {
      this.field2725 = var1;
      this.field2722 = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1083536474"
   )
   public void method3252() {
      for(int var1 = 0; var1 < this.field2726.length; ++var1) {
         if(null != this.field2726[var1]) {
            for(int var2 = 0; var2 < this.field2726[var1].length; ++var2) {
               this.field2726[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;I)V",
      garbageValue = "382411757"
   )
   public static void method3253(class182 var0, class182 var1, class182 var2) {
      class196.field2866 = var0;
      class196.field2881 = var1;
      class196.field2889 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "125"
   )
   public int method3254() {
      return this.field2726.length;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-903346480"
   )
   void vmethod3313(int var1) {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "1438781887"
   )
   public byte[] method3279(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2726.length && null != this.field2726[var1] && var2 >= 0 && var2 < this.field2726[var1].length) {
         if(null == this.field2726[var1][var2]) {
            boolean var4 = this.method3217(var1, var3);
            if(!var4) {
               this.vmethod3313(var1);
               var4 = this.method3217(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class7.method73(this.field2726[var1][var2], false);
         if(this.field2722) {
            this.field2726[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1565045841"
   )
   public byte[] method3281(int var1) {
      if(this.field2726.length == 1) {
         return this.method3209(0, var1);
      } else if(this.field2726[var1].length == 1) {
         return this.method3209(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }
}
