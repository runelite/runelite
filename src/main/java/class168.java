import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class168 extends class167 {
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1314876329
   )
   int field2709 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 36350851
   )
   int field2710;
   @ObfuscatedName("h")
   class134 field2711;
   @ObfuscatedName("n")
   boolean field2712 = false;
   @ObfuscatedName("g")
   volatile boolean[] field2713;
   @ObfuscatedName("b")
   static CRC32 field2714 = new CRC32();
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 2076310353
   )
   int field2715;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1508155381
   )
   int field2716;
   @ObfuscatedName("k")
   class134 field2717;
   @ObfuscatedName("r")
   volatile boolean field2719 = false;

   @ObfuscatedName("cv")
   int method3360(int var1) {
      if(null != super.field2698[var1]) {
         return 100;
      } else if(this.field2713[var1]) {
         return 100;
      } else {
         int var3 = this.field2710;
         long var4 = (long)(var1 + (var3 << 16));
         int var2;
         if(class21.field590 != null && var4 == class21.field590.field3123) {
            var2 = class13.field213.field2011 * 99 / (class13.field213.field2012.length - class21.field590.field2756) + 1;
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("bk")
   public int method3361() {
      if(this.field2719) {
         return 100;
      } else if(super.field2698 != null) {
         return 99;
      } else {
         int var2 = this.field2710;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(null != class21.field590 && var3 == class21.field590.field3123) {
            var1 = class13.field213.field2011 * 99 / (class13.field213.field2012.length - class21.field590.field2756) + 1;
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

   @ObfuscatedName("x")
   void vmethod3362(int var1) {
      class151.method3171(this.field2710, var1);
   }

   @ObfuscatedName("bq")
   void method3364(int var1, int var2) {
      this.field2715 = var1;
      this.field2716 = var2;
      if(this.field2717 != null) {
         class99.method2190(this.field2710, this.field2717, this);
      } else {
         class162.method3223(this, 255, this.field2710, this.field2715, (byte)0, true);
      }

   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "511449891"
   )
   void method3365(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2719) {
            throw new RuntimeException();
         }

         if(this.field2717 != null) {
            class130.method2833(this.field2710, var2, this.field2717);
         }

         this.method3308(var2);
         this.method3367();
      } else {
         var2[var2.length - 2] = (byte)(super.field2699[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2699[var1];
         if(null != this.field2711) {
            class130.method2833(var1, var2, this.field2711);
            this.field2713[var1] = true;
         }

         if(var4) {
            super.field2698[var1] = class111.method2434(var2);
         }
      }

   }

   @ObfuscatedName("bt")
   void method3367() {
      this.field2713 = new boolean[super.field2698.length];

      int var1;
      for(var1 = 0; var1 < this.field2713.length; ++var1) {
         this.field2713[var1] = false;
      }

      if(this.field2711 == null) {
         this.field2719 = true;
      } else {
         this.field2709 = -1;

         for(var1 = 0; var1 < this.field2713.length; ++var1) {
            if(super.field2700[var1] > 0) {
               class134 var2 = this.field2711;
               class169 var4 = new class169();
               var4.field2723 = 1;
               var4.field3123 = (long)var1;
               var4.field2722 = var2;
               var4.field2720 = this;
               class199 var5 = class170.field2729;
               synchronized(class170.field2729) {
                  class170.field2729.method3834(var4);
               }

               Object var10 = class170.field2726;
               synchronized(class170.field2726) {
                  if(0 == class170.field2728) {
                     class123.field2036.method2889(new class170(), 5);
                  }

                  class170.field2728 = 600;
               }

               this.field2709 = var1;
            }
         }

         if(this.field2709 == -1) {
            this.field2719 = true;
         }

      }
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(Lclass134;I[BZI)V",
      garbageValue = "-455080911"
   )
   public void method3368(class134 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(this.field2717 == var1) {
         if(this.field2719) {
            throw new RuntimeException();
         } else if(var3 == null) {
            class162.method3223(this, 255, this.field2710, this.field2715, (byte)0, true);
         } else {
            field2714.reset();
            field2714.update(var3, 0, var3.length);
            var5 = (int)field2714.getValue();
            class119 var9 = new class119(class89.method2077(var3));
            int var7 = var9.method2506();
            if(var7 != 5 && var7 != 6) {
               throw new RuntimeException(var7 + "," + this.field2710 + "," + var2);
            } else {
               int var8 = 0;
               if(var7 >= 6) {
                  var8 = var9.method2511();
               }

               if(this.field2715 != var5 || this.field2716 != var8) {
                  class162.method3223(this, 255, this.field2710, this.field2715, (byte)0, true);
               } else {
                  this.method3308(var3);
                  this.method3367();
               }
            }
         }
      } else {
         if(!var4 && this.field2709 == var2) {
            this.field2719 = true;
         }

         if(var3 != null && var3.length > 2) {
            field2714.reset();
            field2714.update(var3, 0, var3.length - 2);
            var5 = (int)field2714.getValue();
            int var6 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
            if(var5 == super.field2707[var2] && super.field2699[var2] == var6) {
               this.field2713[var2] = true;
               if(var4) {
                  super.field2698[var2] = class111.method2434(var3);
               }

            } else {
               this.field2713[var2] = false;
               if(this.field2712 || var4) {
                  class162.method3223(this, this.field2710, var2, super.field2707[var2], (byte)2, var4);
               }

            }
         } else {
            this.field2713[var2] = false;
            if(this.field2712 || var4) {
               class162.method3223(this, this.field2710, var2, super.field2707[var2], (byte)2, var4);
            }

         }
      }
   }

   @ObfuscatedName("cs")
   public int method3369() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2698.length; ++var3) {
         if(super.field2700[var3] > 0) {
            var1 += 100;
            var2 += this.method3360(var3);
         }
      }

      if(0 == var1) {
         return 100;
      } else {
         var3 = 100 * var2 / var1;
         return var3;
      }
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "331679165"
   )
   static void method3372() {
      for(class3 var0 = (class3)client.field455.method3805(); null != var0; var0 = (class3)client.field455.method3809()) {
         int var1 = var0.field74;
         if(class39.method817(var1)) {
            boolean var2 = true;
            class173[] var3 = class173.field2830[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].field2766;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.field3123;
               class173 var5 = class52.method1115(var4);
               if(null != var5) {
                  class134.method2877(var5);
               }
            }
         }
      }

   }

   public class168(class134 var1, class134 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2711 = var1;
      this.field2717 = var2;
      this.field2710 = var3;
      this.field2712 = var6;
      class163.method3262(this, this.field2710);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "74"
   )
   void vmethod3389(int var1) {
      if(this.field2711 != null && this.field2713 != null && this.field2713[var1]) {
         class99.method2190(var1, this.field2711, this);
      } else {
         class162.method3223(this, this.field2710, var1, super.field2707[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("j")
   static class168 method3392(int var0, boolean var1, boolean var2, boolean var3) {
      class134 var4 = null;
      if(class149.field2260 != null) {
         var4 = new class134(var0, class149.field2260, class177.field2920[var0], 1000000);
      }

      return new class168(var4, class101.field1770, var0, var1, var2, var3);
   }

   @ObfuscatedName("w")
   static int method3394(int var0, int var1) {
      class15 var2 = (class15)class15.field234.method3806((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.field229.length?var2.field229[var1]:0);
   }
}
