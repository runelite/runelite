import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public abstract class class166 {
   @ObfuscatedName("l")
   int[] field2679;
   @ObfuscatedName("a")
   int[] field2680;
   @ObfuscatedName("i")
   class191 field2681;
   @ObfuscatedName("f")
   int[] field2682;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1434754549
   )
   int field2683;
   @ObfuscatedName("o")
   int[] field2684;
   @ObfuscatedName("h")
   int[][] field2685;
   @ObfuscatedName("n")
   int[][] field2686;
   @ObfuscatedName("k")
   class191[] field2687;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1215427255
   )
   public int field2688;
   @ObfuscatedName("b")
   Object[][] field2689;
   @ObfuscatedName("g")
   boolean field2690;
   @ObfuscatedName("q")
   static class115 field2692 = new class115();
   @ObfuscatedName("y")
   boolean field2693;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 353435587
   )
   static int field2694 = 0;
   @ObfuscatedName("r")
   Object[] field2695;
   @ObfuscatedName("m")
   int[] field2697;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1258670449"
   )
   void method3212(byte[] var1) {
      this.field2688 = class4.method38(var1, var1.length);
      class118 var2 = new class118(class24.method594(var1));
      int var3 = var2.method2453();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.method2458();
         }

         int var4 = var2.method2453();
         if(var3 >= 7) {
            this.field2683 = var2.method2467();
         } else {
            this.field2683 = var2.method2455();
         }

         int var5 = 0;
         int var6 = -1;
         this.field2679 = new int[this.field2683];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2683; ++var7) {
               this.field2679[var7] = var5 += var2.method2467();
               if(this.field2679[var7] > var6) {
                  var6 = this.field2679[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.field2683; ++var7) {
               this.field2679[var7] = var5 += var2.method2455();
               if(this.field2679[var7] > var6) {
                  var6 = this.field2679[var7];
               }
            }
         }

         this.field2682 = new int[1 + var6];
         this.field2697 = new int[var6 + 1];
         this.field2684 = new int[1 + var6];
         this.field2685 = new int[1 + var6][];
         this.field2695 = new Object[var6 + 1];
         this.field2689 = new Object[var6 + 1][];
         if(var4 != 0) {
            this.field2680 = new int[var6 + 1];

            for(var7 = 0; var7 < this.field2683; ++var7) {
               this.field2680[this.field2679[var7]] = var2.method2458();
            }

            this.field2681 = new class191(this.field2680);
         }

         for(var7 = 0; var7 < this.field2683; ++var7) {
            this.field2682[this.field2679[var7]] = var2.method2458();
         }

         for(var7 = 0; var7 < this.field2683; ++var7) {
            this.field2697[this.field2679[var7]] = var2.method2458();
         }

         for(var7 = 0; var7 < this.field2683; ++var7) {
            this.field2684[this.field2679[var7]] = var2.method2455();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2683; ++var7) {
               var8 = this.field2679[var7];
               var9 = this.field2684[var8];
               var5 = 0;
               var10 = -1;
               this.field2685[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2685[var8][var11] = var5 += var2.method2467();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2689[var8] = new Object[var10 + 1];
            }
         } else {
            for(var7 = 0; var7 < this.field2683; ++var7) {
               var8 = this.field2679[var7];
               var9 = this.field2684[var8];
               var5 = 0;
               var10 = -1;
               this.field2685[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2685[var8][var11] = var5 += var2.method2455();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2689[var8] = new Object[1 + var10];
            }
         }

         if(var4 != 0) {
            this.field2686 = new int[var6 + 1][];
            this.field2687 = new class191[1 + var6];

            for(var7 = 0; var7 < this.field2683; ++var7) {
               var8 = this.field2679[var7];
               var9 = this.field2684[var8];
               this.field2686[var8] = new int[this.field2689[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.field2686[var8][this.field2685[var8][var10]] = var2.method2458();
               }

               this.field2687[var8] = new class191(this.field2686[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("l")
   void vmethod3288(int var1) {
   }

   @ObfuscatedName("a")
   public byte[] method3214(int var1, int var2) {
      return this.method3215(var1, var2, (int[])null);
   }

   @ObfuscatedName("i")
   public byte[] method3215(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2689.length && null != this.field2689[var1] && var2 >= 0 && var2 < this.field2689[var1].length) {
         if(null == this.field2689[var1][var2]) {
            boolean var4 = this.method3228(var1, var3);
            if(!var4) {
               this.vmethod3289(var1);
               var4 = this.method3228(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class17.method188(this.field2689[var1][var2], false);
         if(this.field2693) {
            this.field2689[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("f")
   public boolean method3216(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2689.length && null != this.field2689[var1] && var2 >= 0 && var2 < this.field2689[var1].length) {
         if(null != this.field2689[var1][var2]) {
            return true;
         } else if(this.field2695[var1] != null) {
            return true;
         } else {
            this.vmethod3289(var1);
            return null != this.field2695[var1];
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("h")
   public byte[] method3219(int var1) {
      if(this.field2689.length == 1) {
         return this.method3214(0, var1);
      } else if(1 == this.field2689[var1].length) {
         return this.method3214(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("n")
   public byte[] method3220(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2689.length && this.field2689[var1] != null && var2 >= 0 && var2 < this.field2689[var1].length) {
         if(null == this.field2689[var1][var2]) {
            boolean var3 = this.method3228(var1, (int[])null);
            if(!var3) {
               this.vmethod3289(var1);
               var3 = this.method3228(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class17.method188(this.field2689[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("k")
   public byte[] method3221(int var1) {
      if(1 == this.field2689.length) {
         return this.method3220(0, var1);
      } else if(this.field2689[var1].length == 1) {
         return this.method3220(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("r")
   void vmethod3289(int var1) {
   }

   @ObfuscatedName("b")
   public int[] method3223(int var1) {
      return this.field2685[var1];
   }

   @ObfuscatedName("q")
   public int method3224(int var1) {
      return this.field2689[var1].length;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "99"
   )
   public void method3227() {
      for(int var1 = 0; var1 < this.field2689.length; ++var1) {
         if(this.field2689[var1] != null) {
            for(int var2 = 0; var2 < this.field2689[var1].length; ++var2) {
               this.field2689[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("s")
   boolean method3228(int var1, int[] var2) {
      if(null == this.field2695[var1]) {
         return false;
      } else {
         int var3 = this.field2684[var1];
         int[] var4 = this.field2685[var1];
         Object[] var5 = this.field2689[var1];
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
            if(null == var2 || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
               var18 = class17.method188(this.field2695[var1], false);
            } else {
               var18 = class17.method188(this.field2695[var1], true);
               class118 var8 = new class118(var18);
               var8.method2472(var2, 5, var8.field1995.length);
            }

            byte[] var19 = class24.method594(var18);
            if(this.field2690) {
               this.field2695[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var19.length;
               --var9;
               int var10 = var19[var9] & 255;
               var9 -= var10 * var3 * 4;
               class118 var11 = new class118(var19);
               int[] var12 = new int[var3];
               var11.field1998 = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2458();
                     var12[var15] += var14;
                  }
               }

               byte[][] var20 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var20[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.field1998 = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2458();
                     System.arraycopy(var19, var14, var20[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2693) {
                     var5[var4[var15]] = class97.method2168(var20[var15]);
                  } else {
                     var5[var4[var15]] = var20[var15];
                  }
               }
            } else if(!this.field2693) {
               var5[var4[0]] = class97.method2168(var19);
            } else {
               var5[var4[0]] = var19;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("t")
   public boolean method3233(String var1) {
      int var2 = this.method3248("");
      return var2 != -1?this.method3274("", var1):this.method3274(var1, "");
   }

   @ObfuscatedName("c")
   public void method3234(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2681.method3707(class20.method560(var1));
      if(var2 >= 0) {
         this.vmethod3288(var2);
      }
   }

   @ObfuscatedName("z")
   public int method3238(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2687[var1].method3707(class20.method560(var2));
   }

   @ObfuscatedName("u")
   public int method3246() {
      return this.field2689.length;
   }

   @ObfuscatedName("d")
   public int method3248(String var1) {
      var1 = var1.toLowerCase();
      return this.field2681.method3707(class20.method560(var1));
   }

   class166(boolean var1, boolean var2) {
      this.field2690 = var1;
      this.field2693 = var2;
   }

   @ObfuscatedName("p")
   public byte[] method3261(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2681.method3707(class20.method560(var1));
      int var4 = this.field2687[var3].method3707(class20.method560(var2));
      return this.method3214(var3, var4);
   }

   @ObfuscatedName("g")
   public void method3269(int var1) {
      for(int var2 = 0; var2 < this.field2689[var1].length; ++var2) {
         this.field2689[var1][var2] = null;
      }

   }

   @ObfuscatedName("w")
   public boolean method3274(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2681.method3707(class20.method560(var1));
      int var4 = this.field2687[var3].method3707(class20.method560(var2));
      return this.method3216(var3, var4);
   }

   @ObfuscatedName("o")
   public boolean method3278() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2679.length; ++var2) {
         int var3 = this.field2679[var2];
         if(this.field2695[var3] == null) {
            this.vmethod3289(var3);
            if(null == this.field2695[var3]) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("m")
   public boolean method3280(int var1) {
      if(this.field2695[var1] != null) {
         return true;
      } else {
         this.vmethod3289(var1);
         return this.field2695[var1] != null;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILclass133;Lclass167;I)V",
      garbageValue = "247120227"
   )
   static void method3286(int var0, class133 var1, class167 var2) {
      byte[] var3 = null;
      class198 var4 = class169.field2717;
      synchronized(class169.field2717) {
         for(class168 var5 = (class168)class169.field2717.method3773(); var5 != null; var5 = (class168)class169.field2717.method3772()) {
            if(var5.field3112 == (long)var0 && var5.field2711 == var1 && 0 == var5.field2709) {
               var3 = var5.field2710;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method3320(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2793(var0);
         var2.method3320(var1, var0, var8, true);
      }
   }
}
