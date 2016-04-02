import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class168 extends class167 {
   @ObfuscatedName("q")
   class134 field2688;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1382364177
   )
   int field2689;
   @ObfuscatedName("b")
   class134 field2690;
   @ObfuscatedName("d")
   boolean field2691 = false;
   @ObfuscatedName("z")
   volatile boolean[] field2692;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1152613717
   )
   int field2693;
   @ObfuscatedName("t")
   volatile boolean field2694 = false;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 657884115
   )
   int field2695;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1995697555
   )
   int field2696 = -1;
   @ObfuscatedName("v")
   static CRC32 field2697 = new CRC32();

   @ObfuscatedName("bg")
   public int method3323() {
      if(this.field2694) {
         return 100;
      } else if(super.field2678 != null) {
         return 99;
      } else {
         int var2 = this.field2689;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(null != class171.field2724 && var3 == class171.field2724.field3115) {
            var1 = class28.field667.field1976 * 99 / (class28.field667.field1980.length - class171.field2724.field2739) + 1;
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

   @ObfuscatedName("w")
   void vmethod3324(int var1) {
      int var2 = this.field2689;
      long var3 = (long)(var1 + (var2 << 16));
      class172 var5 = (class172)class171.field2720.method3788(var3);
      if(null != var5) {
         class171.field2719.method3876(var5);
      }

   }

   @ObfuscatedName("m")
   void vmethod3325(int var1) {
      if(null != this.field2690 && null != this.field2692 && this.field2692[var1]) {
         class169.method3353(var1, this.field2690, this);
      } else {
         class40.method794(this, this.field2689, var1, super.field2672[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(Lclass134;I[BZB)V",
      garbageValue = "23"
   )
   void method3327(class134 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2688) {
         if(this.field2694) {
            throw new RuntimeException();
         } else if(null == var3) {
            class40.method794(this, 255, this.field2689, this.field2693, (byte)0, true);
         } else {
            field2697.reset();
            field2697.update(var3, 0, var3.length);
            var5 = (int)field2697.getValue();
            class119 var9 = new class119(class111.method2447(var3));
            int var7 = var9.method2523();
            if(var7 != 5 && 6 != var7) {
               throw new RuntimeException(var7 + "," + this.field2689 + "," + var2);
            } else {
               int var8 = 0;
               if(var7 >= 6) {
                  var8 = var9.method2528();
               }

               if(this.field2693 != var5 || this.field2695 != var8) {
                  class40.method794(this, 255, this.field2689, this.field2693, (byte)0, true);
               } else {
                  this.method3319(var3);
                  this.method3329();
               }
            }
         }
      } else {
         if(!var4 && var2 == this.field2696) {
            this.field2694 = true;
         }

         if(null != var3 && var3.length > 2) {
            field2697.reset();
            field2697.update(var3, 0, var3.length - 2);
            var5 = (int)field2697.getValue();
            int var6 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
            if(var5 == super.field2672[var2] && super.field2673[var2] == var6) {
               this.field2692[var2] = true;
               if(var4) {
                  super.field2678[var2] = class36.method734(var3);
               }

            } else {
               this.field2692[var2] = false;
               if(this.field2691 || var4) {
                  class40.method794(this, this.field2689, var2, super.field2672[var2], (byte)2, var4);
               }

            }
         } else {
            this.field2692[var2] = false;
            if(this.field2691 || var4) {
               class40.method794(this, this.field2689, var2, super.field2672[var2], (byte)2, var4);
            }

         }
      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-25"
   )
   void method3329() {
      this.field2692 = new boolean[super.field2678.length];

      int var1;
      for(var1 = 0; var1 < this.field2692.length; ++var1) {
         this.field2692[var1] = false;
      }

      if(this.field2690 == null) {
         this.field2694 = true;
      } else {
         this.field2696 = -1;

         for(var1 = 0; var1 < this.field2692.length; ++var1) {
            if(super.field2674[var1] > 0) {
               class134 var2 = this.field2690;
               class169 var4 = new class169();
               var4.field2703 = 1;
               var4.field3115 = (long)var1;
               var4.field2700 = var2;
               var4.field2701 = this;
               class199 var5 = class170.field2708;
               synchronized(class170.field2708) {
                  class170.field2708.method3834(var4);
               }

               Object var10 = class170.field2709;
               synchronized(class170.field2709) {
                  if(0 == class170.field2707) {
                     class125.field2028.method2888(new class170(), 5);
                  }

                  class170.field2707 = 600;
               }

               this.field2696 = var1;
            }
         }

         if(this.field2696 == -1) {
            this.field2694 = true;
         }

      }
   }

   @ObfuscatedName("bb")
   int method3331(int var1) {
      if(super.field2678[var1] != null) {
         return 100;
      } else if(this.field2692[var1]) {
         return 100;
      } else {
         int var3 = this.field2689;
         long var4 = (long)(var1 + (var3 << 16));
         int var2;
         if(null != class171.field2724 && var4 == class171.field2724.field3115) {
            var2 = 1 + class28.field667.field1976 * 99 / (class28.field667.field1980.length - class171.field2724.field2739);
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   public class168(class134 var1, class134 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2690 = var1;
      this.field2688 = var2;
      this.field2689 = var3;
      this.field2691 = var6;
      int var8 = this.field2689;
      if(null != class171.field2722) {
         class171.field2722.field1976 = 8 * var8 + 5;
         int var9 = class171.field2722.method2528();
         int var10 = class171.field2722.method2528();
         this.method3340(var9, var10);
      } else {
         class40.method794((class168)null, 255, 255, 0, (byte)0, true);
         class171.field2729[var8] = this;
      }

   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "-1455527212"
   )
   public void method3335(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2694) {
            throw new RuntimeException();
         }

         if(null != this.field2688) {
            class150.method3147(this.field2689, var2, this.field2688);
         }

         this.method3319(var2);
         this.method3329();
      } else {
         var2[var2.length - 2] = (byte)(super.field2673[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2673[var1];
         if(this.field2690 != null) {
            class150.method3147(var1, var2, this.field2690);
            this.field2692[var1] = true;
         }

         if(var4) {
            super.field2678[var1] = class36.method734(var2);
         }
      }

   }

   @ObfuscatedName("ba")
   public void method3340(int var1, int var2) {
      this.field2693 = var1;
      this.field2695 = var2;
      if(this.field2688 != null) {
         class169.method3353(this.field2689, this.field2688, this);
      } else {
         class40.method794(this, 255, this.field2689, this.field2693, (byte)0, true);
      }

   }

   @ObfuscatedName("bz")
   public int method3344() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2678.length; ++var3) {
         if(super.field2674[var3] > 0) {
            var1 += 100;
            var2 += this.method3331(var3);
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
