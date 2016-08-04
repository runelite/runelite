import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class171 extends class170 {
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 2103639827
   )
   int field2743;
   @ObfuscatedName("j")
   class137 field2744;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1548209213
   )
   int field2745;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 527248343
   )
   int field2746;
   @ObfuscatedName("t")
   volatile boolean field2747 = false;
   @ObfuscatedName("a")
   volatile boolean[] field2748;
   @ObfuscatedName("y")
   boolean field2749 = false;
   @ObfuscatedName("v")
   class137 field2750;
   @ObfuscatedName("c")
   static CRC32 field2751 = new CRC32();
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1845133191
   )
   int field2752 = -1;
   @ObfuscatedName("er")
   static class81 field2754;

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(Lclass137;I[BZB)V",
      garbageValue = "-23"
   )
   void method3483(class137 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2744) {
         if(this.field2747) {
            throw new RuntimeException();
         }

         if(null == var3) {
            class126.method2919(this, 255, this.field2745, this.field2746, (byte)0, true);
            return;
         }

         field2751.reset();
         field2751.update(var3, 0, var3.length);
         var5 = (int)field2751.getValue();
         class122 var6 = new class122(class124.method2893(var3));
         int var7 = var6.method2633();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2745 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.method2620();
         }

         if(var5 != this.field2746 || this.field2743 != var8) {
            class126.method2919(this, 255, this.field2745, this.field2746, (byte)0, true);
            return;
         }

         this.method3393(var3);
         this.method3490();
      } else {
         if(!var4 && var2 == this.field2752) {
            this.field2747 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field2748[var2] = false;
            if(this.field2749 || var4) {
               class126.method2919(this, this.field2745, var2, super.field2736[var2], (byte)2, var4);
            }

            return;
         }

         field2751.reset();
         field2751.update(var3, 0, var3.length - 2);
         var5 = (int)field2751.getValue();
         int var9 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(super.field2736[var2] != var5 || super.field2729[var2] != var9) {
            this.field2748[var2] = false;
            if(this.field2749 || var4) {
               class126.method2919(this, this.field2745, var2, super.field2736[var2], (byte)2, var4);
            }

            return;
         }

         this.field2748[var2] = true;
         if(var4) {
            super.field2734[var2] = class52.method1131(var3, false);
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-366929248"
   )
   void vmethod3485(int var1) {
      class0.method3(this.field2745, var1);
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1660690086"
   )
   void method3487(int var1, int var2) {
      this.field2746 = var1;
      this.field2743 = var2;
      if(null != this.field2744) {
         class117.method2560(this.field2745, this.field2744, this);
      } else {
         class126.method2919(this, 255, this.field2745, this.field2746, (byte)0, true);
      }

   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "1946748906"
   )
   void method3488(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2747) {
            throw new RuntimeException();
         }

         if(this.field2744 != null) {
            int var5 = this.field2745;
            class137 var6 = this.field2744;
            class172 var7 = new class172();
            var7.field2757 = 0;
            var7.field3175 = (long)var5;
            var7.field2755 = var2;
            var7.field2759 = var6;
            class202 var8 = class173.field2765;
            synchronized(class173.field2765) {
               class173.field2765.method3963(var7);
            }

            Object var21 = class173.field2763;
            synchronized(class173.field2763) {
               if(class173.field2767 == 0) {
                  class125.field2070.method3029(new class173(), 5);
               }

               class173.field2767 = 600;
            }
         }

         this.method3393(var2);
         this.method3490();
      } else {
         var2[var2.length - 2] = (byte)(super.field2729[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2729[var1];
         if(this.field2750 != null) {
            class137 var13 = this.field2750;
            class172 var18 = new class172();
            var18.field2757 = 0;
            var18.field3175 = (long)var1;
            var18.field2755 = var2;
            var18.field2759 = var13;
            class202 var19 = class173.field2765;
            synchronized(class173.field2765) {
               class173.field2765.method3963(var18);
            }

            Object var20 = class173.field2763;
            synchronized(class173.field2763) {
               if(class173.field2767 == 0) {
                  class125.field2070.method3029(new class173(), 5);
               }

               class173.field2767 = 600;
            }

            this.field2748[var1] = true;
         }

         if(var4) {
            super.field2734[var1] = class52.method1131(var2, false);
         }
      }

   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "98"
   )
   void method3490() {
      this.field2748 = new boolean[super.field2734.length];

      int var1;
      for(var1 = 0; var1 < this.field2748.length; ++var1) {
         this.field2748[var1] = false;
      }

      if(null == this.field2750) {
         this.field2747 = true;
      } else {
         this.field2752 = -1;

         for(var1 = 0; var1 < this.field2748.length; ++var1) {
            if(super.field2742[var1] > 0) {
               class137 var2 = this.field2750;
               class172 var4 = new class172();
               var4.field2757 = 1;
               var4.field3175 = (long)var1;
               var4.field2759 = var2;
               var4.field2758 = this;
               class202 var5 = class173.field2765;
               synchronized(class173.field2765) {
                  class173.field2765.method3963(var4);
               }

               Object var10 = class173.field2763;
               synchronized(class173.field2763) {
                  if(class173.field2767 == 0) {
                     class125.field2070.method3029(new class173(), 5);
                  }

                  class173.field2767 = 600;
               }

               this.field2752 = var1;
            }
         }

         if(this.field2752 == -1) {
            this.field2747 = true;
         }

      }
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1620690681"
   )
   int method3491(int var1) {
      if(null != super.field2734[var1]) {
         return 100;
      } else if(this.field2748[var1]) {
         return 100;
      } else {
         int var3 = this.field2745;
         long var4 = (long)((var3 << 16) + var1);
         int var2;
         if(class174.field2780 != null && class174.field2780.field3175 == var4) {
            var2 = class159.field2368.field2050 * 99 / (class159.field2368.field2051.length - class174.field2780.field2793) + 1;
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-3236"
   )
   public int method3492() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2734.length; ++var3) {
         if(super.field2742[var3] > 0) {
            var1 += 100;
            var2 += this.method3491(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = 100 * var2 / var1;
         return var3;
      }
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-26"
   )
   public int method3494() {
      if(this.field2747) {
         return 100;
      } else if(null != super.field2734) {
         return 99;
      } else {
         int var1 = class114.method2543(255, this.field2745);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   public class171(class137 var1, class137 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2750 = var1;
      this.field2744 = var2;
      this.field2745 = var3;
      this.field2749 = var6;
      class116.method2555(this, this.field2745);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "585180784"
   )
   void vmethod3508(int var1) {
      if(this.field2750 != null && this.field2748 != null && this.field2748[var1]) {
         class117.method2560(var1, this.field2750, this);
      } else {
         class126.method2919(this, this.field2745, var1, super.field2736[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(IS)Ljava/lang/String;",
      garbageValue = "242"
   )
   static final String method3511(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }
}
