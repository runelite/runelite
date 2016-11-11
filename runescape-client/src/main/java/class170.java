import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public abstract class class170 {
   @ObfuscatedName("c")
   boolean field2714;
   @ObfuscatedName("l")
   int[][] field2715;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1050017327
   )
   static int field2716 = 0;
   @ObfuscatedName("g")
   class195 field2717;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1953032357
   )
   int field2718;
   @ObfuscatedName("p")
   static class119 field2719 = new class119();
   @ObfuscatedName("d")
   int[] field2720;
   @ObfuscatedName("m")
   int[][] field2721;
   @ObfuscatedName("s")
   Object[][] field2722;
   @ObfuscatedName("j")
   class195[] field2723;
   @ObfuscatedName("y")
   Object[] field2724;
   @ObfuscatedName("u")
   int[] field2725;
   @ObfuscatedName("h")
   int[] field2726;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 339531795
   )
   public int field2727;
   @ObfuscatedName("r")
   boolean field2728;
   @ObfuscatedName("e")
   int[] field2729;
   @ObfuscatedName("n")
   int[] field2730;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "-701166268"
   )
   public byte[] method3290(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2722.length && this.field2722[var1] != null && var2 >= 0 && var2 < this.field2722[var1].length) {
         if(this.field2722[var1][var2] == null) {
            boolean var4 = this.method3303(var1, var3);
            if(!var4) {
               this.vmethod3380(var1);
               var4 = this.method3303(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = WidgetNode.method51(this.field2722[var1][var2], false);
         if(this.field2714) {
            this.field2722[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1853902575"
   )
   public boolean method3291(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2722.length && this.field2722[var1] != null && var2 >= 0 && var2 < this.field2722[var1].length) {
         if(this.field2722[var1][var2] != null) {
            return true;
         } else if(this.field2724[var1] != null) {
            return true;
         } else {
            this.vmethod3380(var1);
            return this.field2724[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-1969922727"
   )
   public byte[] method3292(int var1, int var2) {
      return this.method3290(var1, var2, (int[])null);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-2133262624"
   )
   public byte[] method3295(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2722.length && this.field2722[var1] != null && var2 >= 0 && var2 < this.field2722[var1].length) {
         if(null == this.field2722[var1][var2]) {
            boolean var4 = this.method3303(var1, (int[])null);
            if(!var4) {
               this.vmethod3380(var1);
               var4 = this.method3303(var1, (int[])null);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var3 = WidgetNode.method51(this.field2722[var1][var2], false);
         return var3;
      } else {
         return null;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-78"
   )
   void vmethod3380(int var1) {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-2092824205"
   )
   public int[] method3298(int var1) {
      return this.field2715[var1];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-485718841"
   )
   public int method3299(int var1) {
      return this.field2722[var1].length;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1900158654"
   )
   public int method3300() {
      return this.field2722.length;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   public void method3301(int var1) {
      for(int var2 = 0; var2 < this.field2722[var1].length; ++var2) {
         this.field2722[var1][var2] = null;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-527287438"
   )
   public void method3302() {
      for(int var1 = 0; var1 < this.field2722.length; ++var1) {
         if(null != this.field2722[var1]) {
            for(int var2 = 0; var2 < this.field2722[var1].length; ++var2) {
               this.field2722[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I[IB)Z",
      garbageValue = "109"
   )
   boolean method3303(int var1, int[] var2) {
      if(null == this.field2724[var1]) {
         return false;
      } else {
         int var3 = this.field2720[var1];
         int[] var4 = this.field2715[var1];
         Object[] var5 = this.field2722[var1];
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
               var18 = WidgetNode.method51(this.field2724[var1], false);
            } else {
               var18 = WidgetNode.method51(this.field2724[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method2564(var2, 5, var8.payload.length);
            }

            byte[] var20 = class134.method2883(var18);
            if(this.field2728) {
               this.field2724[var1] = null;
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
                     var14 += var11.method2549();
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
                     var16 += var11.method2549();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2714) {
                     var5[var4[var15]] = Ignore.method103(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2714) {
               var5[var4[0]] = Ignore.method103(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "86"
   )
   public int method3304(String var1) {
      var1 = var1.toLowerCase();
      return this.field2717.method3775(XItemContainer.method188(var1));
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "-1503651747"
   )
   public int method3305(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2723[var1].method3775(XItemContainer.method188(var2));
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "-915027442"
   )
   public byte[] method3306(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2717.method3775(XItemContainer.method188(var1));
      int var4 = this.field2723[var3].method3775(XItemContainer.method188(var2));
      return this.method3292(var3, var4);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-48174881"
   )
   public boolean method3308(String var1) {
      int var2 = this.method3304("");
      return var2 != -1?this.method3360("", var1):this.method3360(var1, "");
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1928713797"
   )
   public void method3309(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2717.method3775(XItemContainer.method188(var1));
      if(var2 >= 0) {
         this.vmethod3369(var2);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-71355894"
   )
   public byte[] method3311(int var1) {
      if(this.field2722.length == 1) {
         return this.method3292(0, var1);
      } else if(this.field2722[var1].length == 1) {
         return this.method3292(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "514094195"
   )
   public boolean method3315() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2726.length; ++var2) {
         int var3 = this.field2726[var2];
         if(null == this.field2724[var3]) {
            this.vmethod3380(var3);
            if(this.field2724[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "0"
   )
   public byte[] method3319(int var1) {
      if(this.field2722.length == 1) {
         return this.method3295(0, var1);
      } else if(this.field2722[var1].length == 1) {
         return this.method3295(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-25734"
   )
   void vmethod3369(int var1) {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-2124586680"
   )
   void method3346(byte[] var1) {
      int var3 = var1.length;
      int var2 = class75.method1613(var1, 0, var3);
      this.field2727 = var2;
      Buffer var4 = new Buffer(class134.method2883(var1));
      int var5 = var4.method2544();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var4.method2549();
         }

         int var6 = var4.method2544();
         if(var5 >= 7) {
            this.field2718 = var4.method2558();
         } else {
            this.field2718 = var4.method2546();
         }

         int var7 = 0;
         int var8 = -1;
         this.field2726 = new int[this.field2718];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2718; ++var9) {
               this.field2726[var9] = var7 += var4.method2558();
               if(this.field2726[var9] > var8) {
                  var8 = this.field2726[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.field2718; ++var9) {
               this.field2726[var9] = var7 += var4.method2546();
               if(this.field2726[var9] > var8) {
                  var8 = this.field2726[var9];
               }
            }
         }

         this.field2730 = new int[var8 + 1];
         this.field2725 = new int[1 + var8];
         this.field2720 = new int[var8 + 1];
         this.field2715 = new int[var8 + 1][];
         this.field2724 = new Object[var8 + 1];
         this.field2722 = new Object[var8 + 1][];
         if(var6 != 0) {
            this.field2729 = new int[var8 + 1];

            for(var9 = 0; var9 < this.field2718; ++var9) {
               this.field2729[this.field2726[var9]] = var4.method2549();
            }

            this.field2717 = new class195(this.field2729);
         }

         for(var9 = 0; var9 < this.field2718; ++var9) {
            this.field2730[this.field2726[var9]] = var4.method2549();
         }

         for(var9 = 0; var9 < this.field2718; ++var9) {
            this.field2725[this.field2726[var9]] = var4.method2549();
         }

         for(var9 = 0; var9 < this.field2718; ++var9) {
            this.field2720[this.field2726[var9]] = var4.method2546();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2718; ++var9) {
               var10 = this.field2726[var9];
               var11 = this.field2720[var10];
               var7 = 0;
               var12 = -1;
               this.field2715[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2715[var10][var13] = var7 += var4.method2558();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2722[var10] = new Object[var12 + 1];
            }
         } else {
            for(var9 = 0; var9 < this.field2718; ++var9) {
               var10 = this.field2726[var9];
               var11 = this.field2720[var10];
               var7 = 0;
               var12 = -1;
               this.field2715[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2715[var10][var13] = var7 += var4.method2546();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2722[var10] = new Object[1 + var12];
            }
         }

         if(var6 != 0) {
            this.field2721 = new int[1 + var8][];
            this.field2723 = new class195[1 + var8];

            for(var9 = 0; var9 < this.field2718; ++var9) {
               var10 = this.field2726[var9];
               var11 = this.field2720[var10];
               this.field2721[var10] = new int[this.field2722[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.field2721[var10][this.field2715[var10][var12]] = var4.method2549();
               }

               this.field2723[var10] = new class195(this.field2721[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   class170(boolean var1, boolean var2) {
      this.field2728 = var1;
      this.field2714 = var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-197544398"
   )
   public boolean method3354(int var1) {
      if(this.field2724[var1] != null) {
         return true;
      } else {
         this.vmethod3380(var1);
         return this.field2724[var1] != null;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "970196408"
   )
   public boolean method3360(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2717.method3775(XItemContainer.method188(var1));
      int var4 = this.field2723[var3].method3775(XItemContainer.method188(var2));
      return this.method3291(var3, var4);
   }
}
