package net.runelite.rs.client;

import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fg")
public class class167 extends class166 {
   @ObfuscatedName("c")
   volatile boolean[] field2672;
   @ObfuscatedName("q")
   class133 field2673;
   @ObfuscatedName("b")
   static CRC32 field2674 = new CRC32();
   @ObfuscatedName("d")
   volatile boolean field2675 = false;
   @ObfuscatedName("v")
   class133 field2676;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1694313013
   )
   int field2677;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1563523287
   )
   int field2678;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 849454699
   )
   int field2680;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1540661841
   )
   int field2681 = -1;
   @ObfuscatedName("o")
   boolean field2682 = false;

   @ObfuscatedName("l")
   public static boolean method3400(int var0) {
      if(class172.field2725[var0]) {
         return true;
      } else if(!class172.field2726.method3315(var0)) {
         return false;
      } else {
         int var1 = class172.field2726.method3322(var0);
         if(0 == var1) {
            class172.field2725[var0] = true;
            return true;
         } else {
            if(class172.field2857[var0] == null) {
               class172.field2857[var0] = new class172[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(class172.field2857[var0][var2] == null) {
                  byte[] var3 = class172.field2726.method3352(var0, var2);
                  if(var3 != null) {
                     class172.field2857[var0][var2] = new class172();
                     class172.field2857[var0][var2].field2734 = (var2 + (var0 << 16)) * -1;
                     if(-1 == var3[0]) {
                        class172.field2857[var0][var2].method3463(new class118(var3));
                     } else {
                        class172.field2857[var0][var2].method3462(new class118(var3));
                     }
                  }
               }
            }

            class172.field2725[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("cd")
   public int method3401() {
      if(this.field2675) {
         return 100;
      } else if(null != super.field2670) {
         return 99;
      } else {
         int var2 = this.field2677;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(null != class47.field1054 && class47.field1054.field3104 == var3) {
            var1 = 1 + class170.field2708.field1981 * 99 / (class170.field2708.field1980.length - class47.field1054.field2721);
         } else {
            var1 = 0;
         }

         int var4 = var1;
         if(var1 >= 100) {
            var4 = 99;
         }

         return var4;
      }
   }

   @ObfuscatedName("m")
   void vmethod3402(int var1) {
      int var2 = this.field2677;
      long var3 = (long)((var2 << 16) + var1);
      class171 var5 = (class171)class170.field2716.method3836(var3);
      if(var5 != null) {
         class170.field2707.method3933(var5);
      }

   }

   @ObfuscatedName("s")
   void vmethod3403(int var1) {
      if(this.field2676 != null && null != this.field2672 && this.field2672[var1]) {
         class124.method2839(var1, this.field2676, this);
      } else {
         class46.method1011(this, this.field2677, var1, super.field2658[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cl")
   void method3404(int var1, int var2) {
      this.field2678 = var1;
      this.field2680 = var2;
      if(this.field2673 != null) {
         class124.method2839(this.field2677, this.field2673, this);
      } else {
         class46.method1011(this, 255, this.field2677, this.field2678, (byte)0, true);
      }

   }

   @ObfuscatedName("ce")
   void method3405(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2675) {
            throw new RuntimeException();
         }

         if(null != this.field2673) {
            int var5 = this.field2677;
            class133 var6 = this.field2673;
            class168 var7 = new class168();
            var7.field2684 = 0;
            var7.field3104 = (long)var5;
            var7.field2685 = var2;
            var7.field2683 = var6;
            class198 var8 = class169.field2694;
            synchronized(class169.field2694) {
               class169.field2694.method3868(var7);
            }

            class103.method2328();
         }

         this.method3360(var2);
         this.method3407();
      } else {
         var2[var2.length - 2] = (byte)(super.field2659[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2659[var1];
         if(null != this.field2676) {
            class133 var13 = this.field2676;
            class168 var14 = new class168();
            var14.field2684 = 0;
            var14.field3104 = (long)var1;
            var14.field2685 = var2;
            var14.field2683 = var13;
            class198 var15 = class169.field2694;
            synchronized(class169.field2694) {
               class169.field2694.method3868(var14);
            }

            class103.method2328();
            this.field2672[var1] = true;
         }

         if(var4) {
            super.field2670[var1] = class43.method958(var2);
         }
      }

   }

   @ObfuscatedName("ct")
   public void method3406(class133 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(this.field2673 == var1) {
         if(this.field2675) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class46.method1011(this, 255, this.field2677, this.field2678, (byte)0, true);
            return;
         }

         field2674.reset();
         field2674.update(var3, 0, var3.length);
         var5 = (int)field2674.getValue();
         class118 var9 = new class118(class26.method678(var3));
         int var7 = var9.method2536();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2677 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.method2541();
         }

         if(this.field2678 != var5 || this.field2680 != var8) {
            class46.method1011(this, 255, this.field2677, this.field2678, (byte)0, true);
            return;
         }

         this.method3360(var3);
         this.method3407();
      } else {
         if(!var4 && var2 == this.field2681) {
            this.field2675 = true;
         }

         if(null == var3 || var3.length <= 2) {
            this.field2672[var2] = false;
            if(this.field2682 || var4) {
               class46.method1011(this, this.field2677, var2, super.field2658[var2], (byte)2, var4);
            }

            return;
         }

         field2674.reset();
         field2674.update(var3, 0, var3.length - 2);
         var5 = (int)field2674.getValue();
         int var6 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
         if(var5 != super.field2658[var2] || super.field2659[var2] != var6) {
            this.field2672[var2] = false;
            if(this.field2682 || var4) {
               class46.method1011(this, this.field2677, var2, super.field2658[var2], (byte)2, var4);
            }

            return;
         }

         this.field2672[var2] = true;
         if(var4) {
            super.field2670[var2] = class43.method958(var3);
         }
      }

   }

   @ObfuscatedName("cc")
   void method3407() {
      this.field2672 = new boolean[super.field2670.length];

      int var1;
      for(var1 = 0; var1 < this.field2672.length; ++var1) {
         this.field2672[var1] = false;
      }

      if(null == this.field2676) {
         this.field2675 = true;
      } else {
         this.field2681 = -1;

         for(var1 = 0; var1 < this.field2672.length; ++var1) {
            if(super.field2660[var1] > 0) {
               class45.method992(var1, this.field2676, this);
               this.field2681 = var1;
            }
         }

         if(this.field2681 == -1) {
            this.field2675 = true;
         }

      }
   }

   @ObfuscatedName("ck")
   int method3408(int var1) {
      if(super.field2670[var1] != null) {
         return 100;
      } else if(this.field2672[var1]) {
         return 100;
      } else {
         int var3 = this.field2677;
         long var4 = (long)((var3 << 16) + var1);
         int var2;
         if(class47.field1054 != null && class47.field1054.field3104 == var4) {
            var2 = 1 + class170.field2708.field1981 * 99 / (class170.field2708.field1980.length - class47.field1054.field2721);
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("cn")
   public int method3409() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2670.length; ++var3) {
         if(super.field2660[var3] > 0) {
            var1 += 100;
            var2 += this.method3408(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = 100 * var2 / var1;
         return var3;
      }
   }

   public class167(class133 var1, class133 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2676 = var1;
      this.field2673 = var2;
      this.field2677 = var3;
      this.field2682 = var6;
      int var8 = this.field2677;
      if(null != class170.field2711) {
         class170.field2711.field1981 = 5 + var8 * 8;
         int var9 = class170.field2711.method2541();
         int var10 = class170.field2711.method2541();
         this.method3404(var9, var10);
      } else {
         class46.method1011((class167)null, 255, 255, 0, (byte)0, true);
         class170.field2712[var8] = this;
      }

   }
}
