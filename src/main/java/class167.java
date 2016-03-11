import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class167 extends class166 {
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 914826863
   )
   int field2698 = -1;
   @ObfuscatedName("w")
   class133 field2699;
   @ObfuscatedName("p")
   class133 field2700;
   @ObfuscatedName("c")
   volatile boolean field2701 = false;
   @ObfuscatedName("x")
   boolean field2702 = false;
   @ObfuscatedName("v")
   static CRC32 field2704 = new CRC32();
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1056900073
   )
   int field2705;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -236334207
   )
   int field2706;
   @ObfuscatedName("e")
   volatile boolean[] field2707;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 920377567
   )
   int field2708;

   @ObfuscatedName("bo")
   public int method3287() {
      if(this.field2701) {
         return 100;
      } else if(null != super.field2695) {
         return 99;
      } else {
         int var1 = class1.method7(255, this.field2708);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("l")
   void vmethod3288(int var1) {
      class9.method123(this.field2708, var1);
   }

   @ObfuscatedName("r")
   void vmethod3289(int var1) {
      if(this.field2700 != null && this.field2707 != null && this.field2707[var1]) {
         class166.method3286(var1, this.field2700, this);
      } else {
         class108.method2378(this, this.field2708, var1, super.field2682[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "-154981689"
   )
   void method3291(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2701) {
            throw new RuntimeException();
         }

         if(this.field2699 != null) {
            int var5 = this.field2708;
            class133 var6 = this.field2699;
            class168 var7 = new class168();
            var7.field2709 = 0;
            var7.field3112 = (long)var5;
            var7.field2710 = var2;
            var7.field2711 = var6;
            class198 var8 = class169.field2717;
            synchronized(class169.field2717) {
               class169.field2717.method3768(var7);
            }

            Object var21 = class169.field2716;
            synchronized(class169.field2716) {
               if(0 == class169.field2718) {
                  class26.field648.method2833(new class169(), 5);
               }

               class169.field2718 = 600;
            }
         }

         this.method3212(var2);
         this.method3293();
      } else {
         var2[var2.length - 2] = (byte)(super.field2697[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2697[var1];
         if(this.field2700 != null) {
            class133 var17 = this.field2700;
            class168 var18 = new class168();
            var18.field2709 = 0;
            var18.field3112 = (long)var1;
            var18.field2710 = var2;
            var18.field2711 = var17;
            class198 var19 = class169.field2717;
            synchronized(class169.field2717) {
               class169.field2717.method3768(var18);
            }

            Object var20 = class169.field2716;
            synchronized(class169.field2716) {
               if(0 == class169.field2718) {
                  class26.field648.method2833(new class169(), 5);
               }

               class169.field2718 = 600;
            }

            this.field2707[var1] = true;
         }

         if(var4) {
            super.field2695[var1] = class97.method2168(var2);
         }
      }

   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1318687794"
   )
   void method3293() {
      this.field2707 = new boolean[super.field2695.length];

      int var1;
      for(var1 = 0; var1 < this.field2707.length; ++var1) {
         this.field2707[var1] = false;
      }

      if(this.field2700 == null) {
         this.field2701 = true;
      } else {
         this.field2698 = -1;

         for(var1 = 0; var1 < this.field2707.length; ++var1) {
            if(super.field2684[var1] > 0) {
               class133 var2 = this.field2700;
               class168 var4 = new class168();
               var4.field2709 = 1;
               var4.field3112 = (long)var1;
               var4.field2711 = var2;
               var4.field2712 = this;
               class198 var5 = class169.field2717;
               synchronized(class169.field2717) {
                  class169.field2717.method3768(var4);
               }

               Object var10 = class169.field2716;
               synchronized(class169.field2716) {
                  if(0 == class169.field2718) {
                     class26.field648.method2833(new class169(), 5);
                  }

                  class169.field2718 = 600;
               }

               this.field2698 = var1;
            }
         }

         if(-1 == this.field2698) {
            this.field2701 = true;
         }

      }
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1564953793"
   )
   void method3294(int var1, int var2) {
      this.field2705 = var1;
      this.field2706 = var2;
      if(null != this.field2699) {
         int var3 = this.field2708;
         class133 var4 = this.field2699;
         byte[] var6 = null;
         class198 var7 = class169.field2717;
         synchronized(class169.field2717) {
            for(class168 var8 = (class168)class169.field2717.method3773(); null != var8; var8 = (class168)class169.field2717.method3772()) {
               if((long)var3 == var8.field3112 && var8.field2711 == var4 && 0 == var8.field2709) {
                  var6 = var8.field2710;
                  break;
               }
            }
         }

         if(var6 != null) {
            this.method3320(var4, var3, var6, true);
         } else {
            byte[] var11 = var4.method2793(var3);
            this.method3320(var4, var3, var11, true);
         }
      } else {
         class108.method2378(this, 255, this.field2708, this.field2705, (byte)0, true);
      }

   }

   @ObfuscatedName("cm")
   public int method3295() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2695.length; ++var3) {
         if(super.field2684[var3] > 0) {
            var1 += 100;
            var2 += this.method3303(var3);
         }
      }

      if(0 == var1) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("cg")
   int method3303(int var1) {
      return null != super.field2695[var1]?100:(this.field2707[var1]?100:class1.method7(this.field2708, var1));
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2129860153"
   )
   static final void method3305(boolean var0) {
      client.field347 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!client.field347) {
         var1 = client.field293.method2489();
         var2 = client.field293.method2487();
         var3 = client.field293.method2455();
         class135.field2100 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class135.field2100[var4][var5] = client.field293.method2458();
            }
         }

         class29.field678 = new int[var3];
         class12.field192 = new int[var3];
         class94.field1626 = new int[var3];
         class22.field599 = new byte[var3][];
         class162.field2656 = new byte[var3][];
         boolean var13 = false;
         if((var1 / 8 == 48 || 49 == var1 / 8) && var2 / 8 == 48) {
            var13 = true;
         }

         if(48 == var1 / 8 && var2 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (6 + var1) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (6 + var2) / 8; ++var6) {
               var7 = (var5 << 8) + var6;
               if(!var13 || 49 != var6 && var6 != 149 && 147 != var6 && 50 != var5 && (49 != var5 || var6 != 47)) {
                  class29.field678[var3] = var7;
                  class12.field192[var3] = class24.field623.method3248("m" + var5 + "_" + var6);
                  class94.field1626[var3] = class24.field623.method3248("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class161.method3146(var1, var2);
      } else {
         var1 = client.field293.method2487();
         var2 = client.field293.method2455();
         var3 = client.field293.method2455();
         client.field293.method2688();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field293.method2689(1);
                  if(var7 == 1) {
                     client.field526[var4][var5][var6] = client.field293.method2689(26);
                  } else {
                     client.field526[var4][var5][var6] = -1;
                  }
               }
            }
         }

         client.field293.method2690();
         class135.field2100 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class135.field2100[var4][var5] = client.field293.method2458();
            }
         }

         class29.field678 = new int[var3];
         class12.field192 = new int[var3];
         class94.field1626 = new int[var3];
         class22.field599 = new byte[var3][];
         class162.field2656 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field526[var4][var5][var6];
                  if(-1 != var7) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = var9 / 8 + (var8 / 8 << 8);

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(var10 == class29.field678[var11]) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class29.field678[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class12.field192[var3] = class24.field623.method3248("m" + var11 + "_" + var12);
                        class94.field1626[var3] = class24.field623.method3248("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class161.method3146(var2, var1);
      }

   }

   public class167(class133 var1, class133 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2700 = var1;
      this.field2699 = var2;
      this.field2708 = var3;
      this.field2702 = var6;
      class136.method2869(this, this.field2708);
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(Lclass133;I[BZI)V",
      garbageValue = "-257264300"
   )
   public void method3320(class133 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(this.field2699 == var1) {
         if(this.field2701) {
            throw new RuntimeException();
         }

         if(null == var3) {
            class108.method2378(this, 255, this.field2708, this.field2705, (byte)0, true);
            return;
         }

         field2704.reset();
         field2704.update(var3, 0, var3.length);
         var5 = (int)field2704.getValue();
         class118 var6 = new class118(class24.method594(var3));
         int var7 = var6.method2453();
         if(5 != var7 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2708 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.method2458();
         }

         if(var5 != this.field2705 || var8 != this.field2706) {
            class108.method2378(this, 255, this.field2708, this.field2705, (byte)0, true);
            return;
         }

         this.method3212(var3);
         this.method3293();
      } else {
         if(!var4 && var2 == this.field2698) {
            this.field2701 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field2707[var2] = false;
            if(this.field2702 || var4) {
               class108.method2378(this, this.field2708, var2, super.field2682[var2], (byte)2, var4);
            }

            return;
         }

         field2704.reset();
         field2704.update(var3, 0, var3.length - 2);
         var5 = (int)field2704.getValue();
         int var9 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
         if(var5 != super.field2682[var2] || super.field2697[var2] != var9) {
            this.field2707[var2] = false;
            if(this.field2702 || var4) {
               class108.method2378(this, this.field2708, var2, super.field2682[var2], (byte)2, var4);
            }

            return;
         }

         this.field2707[var2] = true;
         if(var4) {
            super.field2695[var2] = class97.method2168(var3);
         }
      }

   }
}
