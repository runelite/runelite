import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class168 extends class167 {
   @ObfuscatedName("z")
   volatile boolean[] field2684;
   @ObfuscatedName("y")
   class134 field2685;
   @ObfuscatedName("v")
   class134 field2686;
   @ObfuscatedName("i")
   volatile boolean field2687 = false;
   @ObfuscatedName("a")
   boolean field2688 = false;
   @ObfuscatedName("at")
   static class78[] field2689;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1456938879
   )
   int field2690;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 55631605
   )
   int field2691;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1446728605
   )
   int field2692;
   @ObfuscatedName("j")
   static CRC32 field2693 = new CRC32();
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1714748921
   )
   int field2694 = -1;

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2110906321"
   )
   public int method3362() {
      if(this.field2687) {
         return 100;
      } else if(null != super.field2666) {
         return 99;
      } else {
         int var1 = class6.method92(255, this.field2690);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1171043006"
   )
   void vmethod3363(int var1) {
      int var2 = this.field2690;
      long var3 = (long)(var1 + (var2 << 16));
      class172 var5 = (class172)class171.field2718.method3822(var3);
      if(null != var5) {
         class171.field2717.method3912(var5);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1329470439"
   )
   void vmethod3364(int var1) {
      if(this.field2686 != null && this.field2684 != null && this.field2684[var1]) {
         class84.method1966(var1, this.field2686, this);
      } else {
         class50.method1072(this, this.field2690, var1, super.field2669[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method3366() {
      this.field2684 = new boolean[super.field2666.length];

      int var1;
      for(var1 = 0; var1 < this.field2684.length; ++var1) {
         this.field2684[var1] = false;
      }

      if(null == this.field2686) {
         this.field2687 = true;
      } else {
         this.field2694 = -1;

         for(var1 = 0; var1 < this.field2684.length; ++var1) {
            if(super.field2670[var1] > 0) {
               class16.method197(var1, this.field2686, this);
               this.field2694 = var1;
            }
         }

         if(this.field2694 == -1) {
            this.field2687 = true;
         }

      }
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(Lclass134;I[BZS)V",
      garbageValue = "-25423"
   )
   void method3367(class134 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2685) {
         if(this.field2687) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class50.method1072(this, 255, this.field2690, this.field2691, (byte)0, true);
            return;
         }

         field2693.reset();
         field2693.update(var3, 0, var3.length);
         var5 = (int)field2693.getValue();
         class119 var6 = new class119(class186.method3756(var3));
         int var7 = var6.method2554();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2690 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.method2696();
         }

         if(var5 != this.field2691 || var8 != this.field2692) {
            class50.method1072(this, 255, this.field2690, this.field2691, (byte)0, true);
            return;
         }

         this.method3351(var3);
         this.method3366();
      } else {
         if(!var4 && this.field2694 == var2) {
            this.field2687 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field2684[var2] = false;
            if(this.field2688 || var4) {
               class50.method1072(this, this.field2690, var2, super.field2669[var2], (byte)2, var4);
            }

            return;
         }

         field2693.reset();
         field2693.update(var3, 0, var3.length - 2);
         var5 = (int)field2693.getValue();
         int var9 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(super.field2669[var2] != var5 || var9 != super.field2671[var2]) {
            this.field2684[var2] = false;
            if(this.field2688 || var4) {
               class50.method1072(this, this.field2690, var2, super.field2669[var2], (byte)2, var4);
            }

            return;
         }

         this.field2684[var2] = true;
         if(var4) {
            super.field2666[var2] = class46.method1022(var3, false);
         }
      }

   }

   public class168(class134 var1, class134 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2686 = var1;
      this.field2685 = var2;
      this.field2690 = var3;
      this.field2688 = var6;
      class111.method2481(this, this.field2690);
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "261178546"
   )
   int method3368(int var1) {
      return super.field2666[var1] != null?100:(this.field2684[var1]?100:class6.method92(this.field2690, var1));
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "16711935"
   )
   public void method3369(int var1, int var2) {
      this.field2691 = var1;
      this.field2692 = var2;
      if(this.field2685 != null) {
         class84.method1966(this.field2690, this.field2685, this);
      } else {
         class50.method1072(this, 255, this.field2690, this.field2691, (byte)0, true);
      }

   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1809919629"
   )
   public int method3370() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2666.length; ++var3) {
         if(super.field2670[var3] > 0) {
            var1 += 100;
            var2 += this.method3368(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "629242700"
   )
   public void method3391(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2687) {
            throw new RuntimeException();
         }

         if(this.field2685 != null) {
            class123.method2798(this.field2690, var2, this.field2685);
         }

         this.method3351(var2);
         this.method3366();
      } else {
         var2[var2.length - 2] = (byte)(super.field2671[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2671[var1];
         if(this.field2686 != null) {
            class134 var5 = this.field2686;
            class169 var6 = new class169();
            var6.field2697 = 0;
            var6.field3115 = (long)var1;
            var6.field2696 = var2;
            var6.field2698 = var5;
            class199 var7 = class170.field2707;
            synchronized(class170.field2707) {
               class170.field2707.method3877(var6);
            }

            Object var12 = class170.field2705;
            synchronized(class170.field2705) {
               if(class170.field2702 == 0) {
                  class7.field136.method2903(new class170(), 5);
               }

               class170.field2702 = 600;
            }

            this.field2684[var1] = true;
         }

         if(var4) {
            super.field2666[var1] = class46.method1022(var2, false);
         }
      }

   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "0"
   )
   static final void method3392(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class129.field2056.method2001(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class129.field2056.method2094(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class178.field2911.field1409;
         var11 = var1 * 4 + 24624 + (103 - var2) * 2048;
         var12 = var5 >> 14 & 32767;
         class40 var13 = class150.method3166(var12);
         if(var13.field965 != -1) {
            class80 var14 = class14.field211[var13.field965];
            if(var14 != null) {
               int var15 = (var13.field945 * 4 - var14.field1428) / 2;
               int var16 = (var13.field937 * 4 - var14.field1429) / 2;
               var14.method1916(4 * var1 + 48 + var15, (104 - var2 - var13.field937) * 4 + 48 + var16);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 3 + 512] = var9;
                  var10[1024 + 3 + var11] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[2 + var11 + 1536] = var9;
                  var10[1536 + var11 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[1024 + var11] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[2 + var11] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[3 + var11] = var9;
                  var10[var11 + 3 + 512] = var9;
                  var10[3 + var11 + 1024] = var9;
                  var10[3 + var11 + 1536] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[2 + var11 + 1536] = var9;
                  var10[1536 + var11 + 3] = var9;
               }
            }
         }
      }

      var5 = class129.field2056.method2111(var0, var1, var2);
      if(var5 != 0) {
         var6 = class129.field2056.method2094(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         class40 var23 = class150.method3166(var9);
         int var18;
         if(var23.field965 != -1) {
            class80 var17 = class14.field211[var23.field965];
            if(var17 != null) {
               var12 = (var23.field945 * 4 - var17.field1428) / 2;
               var18 = (var23.field937 * 4 - var17.field1429) / 2;
               var17.method1916(var1 * 4 + 48 + var12, 48 + (104 - var2 - var23.field937) * 4 + var18);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var19 = class178.field2911.field1409;
            var18 = 24624 + 4 * var1 + (103 - var2) * 2048;
            if(var7 != 0 && var7 != 2) {
               var19[var18] = var11;
               var19[1 + 512 + var18] = var11;
               var19[1024 + var18 + 2] = var11;
               var19[3 + var18 + 1536] = var11;
            } else {
               var19[var18 + 1536] = var11;
               var19[1024 + var18 + 1] = var11;
               var19[2 + var18 + 512] = var11;
               var19[3 + var18] = var11;
            }
         }
      }

      var5 = class129.field2056.method1979(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         class40 var21 = class150.method3166(var6);
         if(var21.field965 != -1) {
            class80 var20 = class14.field211[var21.field965];
            if(var20 != null) {
               var9 = (var21.field945 * 4 - var20.field1428) / 2;
               int var22 = (var21.field937 * 4 - var20.field1429) / 2;
               var20.method1916(var9 + 48 + 4 * var1, 48 + (104 - var2 - var21.field937) * 4 + var22);
            }
         }
      }

   }
}
