import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public abstract class class167 {
   @ObfuscatedName("p")
   Object[] field2663;
   @ObfuscatedName("g")
   int[] field2664;
   @ObfuscatedName("d")
   class192 field2666;
   @ObfuscatedName("x")
   int[] field2667;
   @ObfuscatedName("y")
   int[] field2668;
   @ObfuscatedName("k")
   boolean field2669;
   @ObfuscatedName("c")
   int[][] field2670;
   @ObfuscatedName("l")
   int[][] field2671;
   @ObfuscatedName("u")
   class192[] field2672;
   @ObfuscatedName("r")
   int[] field2673;
   @ObfuscatedName("n")
   Object[][] field2674;
   @ObfuscatedName("w")
   static class116 field2675 = new class116();
   @ObfuscatedName("j")
   int[] field2676;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1337546125
   )
   public int field2677;
   @ObfuscatedName("o")
   boolean field2678;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 741237873
   )
   static int field2679 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2141814481
   )
   int field2680;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-148634981"
   )
   void vmethod3350(int var1) {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-2039319558"
   )
   public byte[] method3266(int var1, int var2) {
      return this.method3267(var1, var2, (int[])null);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II[IS)[B",
      garbageValue = "19414"
   )
   public byte[] method3267(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2674.length && this.field2674[var1] != null && var2 >= 0 && var2 < this.field2674[var1].length) {
         if(this.field2674[var1][var2] == null) {
            boolean var4 = this.method3280(var1, var3);
            if(!var4) {
               this.vmethod3346(var1);
               var4 = this.method3280(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class30.method663(this.field2674[var1][var2], false);
         if(this.field2678) {
            this.field2674[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2025230857"
   )
   public boolean method3268(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2674.length && null != this.field2674[var1] && var2 >= 0 && var2 < this.field2674[var1].length) {
         if(this.field2674[var1][var2] != null) {
            return true;
         } else if(this.field2663[var1] != null) {
            return true;
         } else {
            this.vmethod3346(var1);
            return null != this.field2663[var1];
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-184219211"
   )
   public boolean method3269(int var1) {
      if(this.field2663[var1] != null) {
         return true;
      } else {
         this.vmethod3346(var1);
         return null != this.field2663[var1];
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "62167496"
   )
   public boolean method3270() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2664.length; ++var2) {
         int var3 = this.field2664[var2];
         if(null == this.field2663[var3]) {
            this.vmethod3346(var3);
            if(null == this.field2663[var3]) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "118"
   )
   public byte[] method3271(int var1) {
      if(this.field2674.length == 1) {
         return this.method3266(0, var1);
      } else if(this.field2674[var1].length == 1) {
         return this.method3266(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-2108240806"
   )
   public byte[] method3273(int var1) {
      if(this.field2674.length == 1) {
         return this.method3298(0, var1);
      } else if(this.field2674[var1].length == 1) {
         return this.method3298(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1650420311"
   )
   public int method3276(int var1) {
      return this.field2674[var1].length;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-71"
   )
   public int method3277() {
      return this.field2674.length;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "95"
   )
   public void method3279() {
      for(int var1 = 0; var1 < this.field2674.length; ++var1) {
         if(null != this.field2674[var1]) {
            for(int var2 = 0; var2 < this.field2674[var1].length; ++var2) {
               this.field2674[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I[IS)Z",
      garbageValue = "1000"
   )
   boolean method3280(int var1, int[] var2) {
      if(this.field2663[var1] == null) {
         return false;
      } else {
         int var3 = this.field2673[var1];
         int[] var4 = this.field2670[var1];
         Object[] var5 = this.field2674[var1];
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
               var18 = class30.method663(this.field2663[var1], false);
            } else {
               var18 = class30.method663(this.field2663[var1], true);
               class119 var8 = new class119(var18);
               var8.method2533(var2, 5, var8.field1982.length);
            }

            byte[] var20 = class116.method2460(var18);
            if(this.field2669) {
               this.field2663[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= 4 * var10 * var3;
               class119 var11 = new class119(var20);
               int[] var12 = new int[var3];
               var11.field1976 = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2519();
                     var12[var15] += var14;
                  }
               }

               byte[][] var19 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var19[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.field1976 = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2519();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2678) {
                     var5[var4[var15]] = class109.method2426(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2678) {
               var5[var4[0]] = class109.method2426(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "0"
   )
   public int method3281(String var1) {
      var1 = var1.toLowerCase();
      return this.field2666.method3753(class109.method2431(var1));
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "106922959"
   )
   public int method3282(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2672[var1].method3753(class109.method2431(var2));
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1806686967"
   )
   void vmethod3346(int var1) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-848119985"
   )
   public boolean method3285(String var1) {
      int var2 = this.method3281("");
      return var2 != -1?this.method3341("", var1):this.method3341(var1, "");
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1754341615"
   )
   public void method3286(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2666.method3753(class109.method2431(var1));
      if(var2 >= 0) {
         this.vmethod3350(var2);
      }
   }

   class167(boolean var1, boolean var2) {
      this.field2669 = var1;
      this.field2678 = var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "-1154649761"
   )
   public byte[] method3294(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2666.method3753(class109.method2431(var1));
      int var4 = this.field2672[var3].method3753(class109.method2431(var2));
      return this.method3266(var3, var4);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "2091120911"
   )
   public byte[] method3298(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2674.length && this.field2674[var1] != null && var2 >= 0 && var2 < this.field2674[var1].length) {
         if(null == this.field2674[var1][var2]) {
            boolean var4 = this.method3280(var1, (int[])null);
            if(!var4) {
               this.vmethod3346(var1);
               var4 = this.method3280(var1, (int[])null);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var3 = class30.method663(this.field2674[var1][var2], false);
         return var3;
      } else {
         return null;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-330937234"
   )
   public int[] method3307(int var1) {
      return this.field2670[var1];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1677195323"
   )
   void method3324(byte[] var1) {
      int var3 = var1.length;
      int var2 = class8.method114(var1, 0, var3);
      this.field2677 = var2;
      class119 var4 = new class119(class116.method2460(var1));
      int var5 = var4.method2514();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var4.method2519();
         }

         int var6 = var4.method2514();
         if(var5 >= 7) {
            this.field2680 = var4.method2731();
         } else {
            this.field2680 = var4.method2516();
         }

         int var7 = 0;
         int var8 = -1;
         this.field2664 = new int[this.field2680];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2680; ++var9) {
               this.field2664[var9] = var7 += var4.method2731();
               if(this.field2664[var9] > var8) {
                  var8 = this.field2664[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.field2680; ++var9) {
               this.field2664[var9] = var7 += var4.method2516();
               if(this.field2664[var9] > var8) {
                  var8 = this.field2664[var9];
               }
            }
         }

         this.field2667 = new int[var8 + 1];
         this.field2668 = new int[1 + var8];
         this.field2673 = new int[1 + var8];
         this.field2670 = new int[1 + var8][];
         this.field2663 = new Object[1 + var8];
         this.field2674 = new Object[var8 + 1][];
         if(var6 != 0) {
            this.field2676 = new int[1 + var8];

            for(var9 = 0; var9 < this.field2680; ++var9) {
               this.field2676[this.field2664[var9]] = var4.method2519();
            }

            this.field2666 = new class192(this.field2676);
         }

         for(var9 = 0; var9 < this.field2680; ++var9) {
            this.field2667[this.field2664[var9]] = var4.method2519();
         }

         for(var9 = 0; var9 < this.field2680; ++var9) {
            this.field2668[this.field2664[var9]] = var4.method2519();
         }

         for(var9 = 0; var9 < this.field2680; ++var9) {
            this.field2673[this.field2664[var9]] = var4.method2516();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2680; ++var9) {
               var10 = this.field2664[var9];
               var11 = this.field2673[var10];
               var7 = 0;
               var12 = -1;
               this.field2670[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2670[var10][var13] = var7 += var4.method2731();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2674[var10] = new Object[var12 + 1];
            }
         } else {
            for(var9 = 0; var9 < this.field2680; ++var9) {
               var10 = this.field2664[var9];
               var11 = this.field2673[var10];
               var7 = 0;
               var12 = -1;
               this.field2670[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2670[var10][var13] = var7 += var4.method2516();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2674[var10] = new Object[var12 + 1];
            }
         }

         if(var6 != 0) {
            this.field2671 = new int[var8 + 1][];
            this.field2672 = new class192[1 + var8];

            for(var9 = 0; var9 < this.field2680; ++var9) {
               var10 = this.field2664[var9];
               var11 = this.field2673[var10];
               this.field2671[var10] = new int[this.field2674[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.field2671[var10][this.field2670[var10][var12]] = var4.method2519();
               }

               this.field2672[var10] = new class192(this.field2671[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass167;I)V",
      garbageValue = "-1956100655"
   )
   public static void method3333(class167 var0) {
      class50.field1070 = var0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "1605721143"
   )
   public boolean method3341(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2666.method3753(class109.method2431(var1));
      int var4 = this.field2672[var3].method3753(class109.method2431(var2));
      return this.method3268(var3, var4);
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIIIIII)V",
      garbageValue = "1979420609"
   )
   static final void method3344(class173 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(client.field370) {
         client.field533 = 32;
      } else {
         client.field533 = 0;
      }

      client.field370 = false;
      int var7;
      if(class140.field2133 == 1 || !class161.field2631 && class140.field2133 == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < 16 + var2) {
            var0.field2770 -= 4;
            class4.method37(var0);
         } else if(var5 >= var1 && var5 < 16 + var1 && var6 >= var2 + var3 - 16 && var6 < var2 + var3) {
            var0.field2770 += 4;
            class4.method37(var0);
         } else if(var5 >= var1 - client.field533 && var5 < client.field533 + var1 + 16 && var6 >= 16 + var2 && var6 < var3 + var2 - 16) {
            var7 = (var3 - 32) * var3 / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.field2770 = (var4 - var3) * var8 / var9;
            class4.method37(var0);
            client.field370 = true;
         }
      }

      if(client.field485 != 0) {
         var7 = var0.field2763;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < 16 + var1 && var6 <= var3 + var2) {
            var0.field2770 += client.field485 * 45;
            class4.method37(var0);
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "743714110"
   )
   public void method3345(int var1) {
      for(int var2 = 0; var2 < this.field2674[var1].length; ++var2) {
         this.field2674[var1][var2] = null;
      }

   }
}
