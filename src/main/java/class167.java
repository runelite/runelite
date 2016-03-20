import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class167 extends class166 {
   @ObfuscatedName("w")
   boolean field2674 = false;
   @ObfuscatedName("o")
   static CRC32 field2675 = new CRC32();
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -767045875
   )
   int field2676;
   @ObfuscatedName("q")
   volatile boolean field2677 = false;
   @ObfuscatedName("d")
   class133 field2678;
   @ObfuscatedName("x")
   class133 field2679;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1472135069
   )
   int field2680;
   @ObfuscatedName("k")
   volatile boolean[] field2681;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 994568021
   )
   int field2682;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -124342355
   )
   int field2683 = -1;

   public class167(class133 var1, class133 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2679 = var1;
      this.field2678 = var2;
      this.field2676 = var3;
      this.field2674 = var6;
      class46.method969(this, this.field2676);
   }

   @ObfuscatedName("r")
   void vmethod3357(int var1) {
      int var2 = this.field2676;
      long var3 = (long)((var2 << 16) + var1);
      class171 var5 = (class171)class170.field2718.method3824(var3);
      if(var5 != null) {
         class170.field2709.method3909(var5);
      }

   }

   @ObfuscatedName("cf")
   void method3359(int var1, int var2) {
      this.field2680 = var1;
      this.field2682 = var2;
      if(this.field2678 != null) {
         class135.method2910(this.field2676, this.field2678, this);
      } else {
         class8.method128(this, 255, this.field2676, this.field2680, (byte)0, true);
      }

   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(Lclass133;I[BZI)V",
      garbageValue = "-1832496582"
   )
   void method3361(class133 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2678) {
         if(this.field2677) {
            throw new RuntimeException();
         }

         if(null == var3) {
            class8.method128(this, 255, this.field2676, this.field2680, (byte)0, true);
            return;
         }

         field2675.reset();
         field2675.update(var3, 0, var3.length);
         var5 = (int)field2675.getValue();
         class118 var6 = new class118(class143.method3110(var3));
         int var7 = var6.method2579();
         if(5 != var7 && 6 != var7) {
            throw new RuntimeException(var7 + "," + this.field2676 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.method2517();
         }

         if(var5 != this.field2680 || this.field2682 != var8) {
            class8.method128(this, 255, this.field2676, this.field2680, (byte)0, true);
            return;
         }

         this.method3343(var3);
         this.method3362();
      } else {
         if(!var4 && var2 == this.field2683) {
            this.field2677 = true;
         }

         if(null == var3 || var3.length <= 2) {
            this.field2681[var2] = false;
            if(this.field2674 || var4) {
               class8.method128(this, this.field2676, var2, super.field2656[var2], (byte)2, var4);
            }

            return;
         }

         field2675.reset();
         field2675.update(var3, 0, var3.length - 2);
         var5 = (int)field2675.getValue();
         int var9 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(super.field2656[var2] != var5 || var9 != super.field2661[var2]) {
            this.field2681[var2] = false;
            if(this.field2674 || var4) {
               class8.method128(this, this.field2676, var2, super.field2656[var2], (byte)2, var4);
            }

            return;
         }

         this.field2681[var2] = true;
         if(var4) {
            super.field2666[var2] = class3.method51(var3);
         }
      }

   }

   @ObfuscatedName("ch")
   void method3362() {
      this.field2681 = new boolean[super.field2666.length];

      int var1;
      for(var1 = 0; var1 < this.field2681.length; ++var1) {
         this.field2681[var1] = false;
      }

      if(null == this.field2679) {
         this.field2677 = true;
      } else {
         this.field2683 = -1;

         for(var1 = 0; var1 < this.field2681.length; ++var1) {
            if(super.field2662[var1] > 0) {
               class133 var2 = this.field2679;
               class168 var4 = new class168();
               var4.field2688 = 1;
               var4.field3111 = (long)var1;
               var4.field2689 = var2;
               var4.field2690 = this;
               class198 var5 = class169.field2696;
               synchronized(class169.field2696) {
                  class169.field2696.method3855(var4);
               }

               class113.method2449();
               this.field2683 = var1;
            }
         }

         if(-1 == this.field2683) {
            this.field2677 = true;
         }

      }
   }

   @ObfuscatedName("cd")
   int method3363(int var1) {
      return super.field2666[var1] != null?100:(this.field2681[var1]?100:class106.method2394(this.field2676, var1));
   }

   @ObfuscatedName("l")
   void vmethod3369(int var1) {
      if(this.field2679 != null && null != this.field2681 && this.field2681[var1]) {
         class135.method2910(var1, this.field2679, this);
      } else {
         class8.method128(this, this.field2676, var1, super.field2656[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("co")
   void method3373(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2677) {
            throw new RuntimeException();
         }

         if(this.field2678 != null) {
            int var5 = this.field2676;
            class133 var6 = this.field2678;
            class168 var7 = new class168();
            var7.field2688 = 0;
            var7.field3111 = (long)var5;
            var7.field2687 = var2;
            var7.field2689 = var6;
            class198 var8 = class169.field2696;
            synchronized(class169.field2696) {
               class169.field2696.method3855(var7);
            }

            class113.method2449();
         }

         this.method3343(var2);
         this.method3362();
      } else {
         var2[var2.length - 2] = (byte)(super.field2661[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2661[var1];
         if(null != this.field2679) {
            class133 var13 = this.field2679;
            class168 var14 = new class168();
            var14.field2688 = 0;
            var14.field3111 = (long)var1;
            var14.field2687 = var2;
            var14.field2689 = var13;
            class198 var15 = class169.field2696;
            synchronized(class169.field2696) {
               class169.field2696.method3855(var14);
            }

            class113.method2449();
            this.field2681[var1] = true;
         }

         if(var4) {
            super.field2666[var1] = class3.method51(var2);
         }
      }

   }

   @ObfuscatedName("cy")
   public int method3374() {
      if(this.field2677) {
         return 100;
      } else if(null != super.field2666) {
         return 99;
      } else {
         int var2 = this.field2676;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(null != class106.field1868 && class106.field1868.field3111 == var3) {
            var1 = 1 + class76.field1388.field1979 * 99 / (class76.field1388.field1980.length - class106.field1868.field2728);
         } else {
            var1 = 0;
         }

         int var5 = var1;
         if(var1 >= 100) {
            var5 = 99;
         }

         return var5;
      }
   }

   @ObfuscatedName("cg")
   public int method3381() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2666.length; ++var3) {
         if(super.field2662[var3] > 0) {
            var1 += 100;
            var2 += this.method3363(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = 100 * var2 / var1;
         return var3;
      }
   }
}
