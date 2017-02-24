import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class184 extends class182 {
   @ObfuscatedName("pl")
   static class30 field2735;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2129942813
   )
   int field2736;
   @ObfuscatedName("l")
   volatile boolean field2737 = false;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 452263509
   )
   int field2738;
   @ObfuscatedName("g")
   volatile boolean[] field2739;
   @ObfuscatedName("e")
   static CRC32 field2740 = new CRC32();
   @ObfuscatedName("a")
   class116 field2741;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1200690725
   )
   int field2742;
   @ObfuscatedName("w")
   class116 field2743;
   @ObfuscatedName("x")
   boolean field2744 = false;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 162050445
   )
   int field2745 = -1;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-708414522"
   )
   void vmethod3393(int var1) {
      int var2 = this.field2736;
      long var3 = (long)(var1 + (var2 << 16));
      class181 var5 = (class181)class185.field2754.method2399(var3);
      if(var5 != null) {
         class185.field2753.method2346(var5);
      }

   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1567183623"
   )
   public int method3394() {
      if(this.field2737) {
         return 100;
      } else if(super.field2718 != null) {
         return 99;
      } else {
         int var2 = this.field2736;
         long var3 = (long)(16711680 + var2);
         int var1;
         if(null != class181.field2706 && var3 == class181.field2706.hash) {
            var1 = class142.field2001.offset * 99 / (class142.field2001.payload.length - class181.field2706.field2702) + 1;
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

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1411430505"
   )
   void method3395(int var1, int var2) {
      this.field2738 = var1;
      this.field2742 = var2;
      if(this.field2741 != null) {
         int var3 = this.field2736;
         class116 var4 = this.field2741;
         byte[] var6 = null;
         Deque var7 = class183.field2730;
         synchronized(class183.field2730) {
            for(class180 var8 = (class180)class183.field2730.method2458(); var8 != null; var8 = (class180)class183.field2730.method2472()) {
               if((long)var3 == var8.hash && var8.field2697 == var4 && var8.field2701 == 0) {
                  var6 = var8.field2696;
                  break;
               }
            }
         }

         if(var6 != null) {
            this.method3397(var4, var3, var6, true);
         } else {
            byte[] var11 = var4.method2293(var3);
            this.method3397(var4, var3, var11, true);
         }
      } else {
         MessageNode.method211(this, 255, this.field2736, this.field2738, (byte)0, true);
      }

   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(Lclass116;I[BZB)V",
      garbageValue = "14"
   )
   void method3397(class116 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(this.field2741 == var1) {
         if(this.field2737) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            MessageNode.method211(this, 255, this.field2736, this.field2738, (byte)0, true);
            return;
         }

         field2740.reset();
         field2740.update(var3, 0, var3.length);
         var5 = (int)field2740.getValue();
         Buffer var6 = new Buffer(class16.method188(var3));
         int var7 = var6.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2736 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.method2965();
         }

         if(this.field2738 != var5 || this.field2742 != var8) {
            MessageNode.method211(this, 255, this.field2736, this.field2738, (byte)0, true);
            return;
         }

         this.method3301(var3);
         this.method3403();
      } else {
         if(!var4 && this.field2745 == var2) {
            this.field2737 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field2739[var2] = false;
            if(this.field2744 || var4) {
               MessageNode.method211(this, this.field2736, var2, super.field2712[var2], (byte)2, var4);
            }

            return;
         }

         field2740.reset();
         field2740.update(var3, 0, var3.length - 2);
         var5 = (int)field2740.getValue();
         int var9 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.field2712[var2] || var9 != super.field2713[var2]) {
            this.field2739[var2] = false;
            if(this.field2744 || var4) {
               MessageNode.method211(this, this.field2736, var2, super.field2712[var2], (byte)2, var4);
            }

            return;
         }

         this.field2739[var2] = true;
         if(var4) {
            super.field2718[var2] = Ignore.method205(var3, false);
         }
      }

   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "2113470059"
   )
   void method3398(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2737) {
            throw new RuntimeException();
         }

         if(this.field2741 != null) {
            int var5 = this.field2736;
            class116 var6 = this.field2741;
            class180 var7 = new class180();
            var7.field2701 = 0;
            var7.hash = (long)var5;
            var7.field2696 = var2;
            var7.field2697 = var6;
            Deque var8 = class183.field2730;
            synchronized(class183.field2730) {
               class183.field2730.method2453(var7);
            }

            Object var21 = class183.field2732;
            synchronized(class183.field2732) {
               if(class183.field2729 == 0) {
                  class33.field775.method2025(new class183(), 5);
               }

               class183.field2729 = 600;
            }
         }

         this.method3301(var2);
         this.method3403();
      } else {
         var2[var2.length - 2] = (byte)(super.field2713[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2713[var1];
         if(this.field2743 != null) {
            class116 var13 = this.field2743;
            class180 var18 = new class180();
            var18.field2701 = 0;
            var18.hash = (long)var1;
            var18.field2696 = var2;
            var18.field2697 = var13;
            Deque var19 = class183.field2730;
            synchronized(class183.field2730) {
               class183.field2730.method2453(var18);
            }

            Object var20 = class183.field2732;
            synchronized(class183.field2732) {
               if(class183.field2729 == 0) {
                  class33.field775.method2025(new class183(), 5);
               }

               class183.field2729 = 600;
            }

            this.field2739[var1] = true;
         }

         if(var4) {
            super.field2718[var1] = Ignore.method205(var2, false);
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1987192516"
   )
   void vmethod3400(int var1) {
      if(null != this.field2743 && this.field2739 != null && this.field2739[var1]) {
         class116 var2 = this.field2743;
         byte[] var4 = null;
         Deque var5 = class183.field2730;
         synchronized(class183.field2730) {
            for(class180 var6 = (class180)class183.field2730.method2458(); null != var6; var6 = (class180)class183.field2730.method2472()) {
               if((long)var1 == var6.hash && var2 == var6.field2697 && var6.field2701 == 0) {
                  var4 = var6.field2696;
                  break;
               }
            }
         }

         if(var4 != null) {
            this.method3397(var2, var1, var4, true);
         } else {
            byte[] var9 = var2.method2293(var1);
            this.method3397(var2, var1, var9, true);
         }
      } else {
         MessageNode.method211(this, this.field2736, var1, super.field2712[var1], (byte)2, true);
      }

   }

   public class184(class116 var1, class116 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2743 = var1;
      this.field2741 = var2;
      this.field2736 = var3;
      this.field2744 = var6;
      int var8 = this.field2736;
      if(class185.field2761 != null) {
         class185.field2761.offset = var8 * 8 + 5;
         int var9 = class185.field2761.method2965();
         int var10 = class185.field2761.method2965();
         this.method3395(var9, var10);
      } else {
         MessageNode.method211((class184)null, 255, 255, 0, (byte)0, true);
         class185.field2746[var8] = this;
      }

   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-30"
   )
   public int method3401() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2718.length; ++var3) {
         if(super.field2717[var3] > 0) {
            var1 += 100;
            var2 += this.method3412(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = 100 * var2 / var1;
         return var3;
      }
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2015356848"
   )
   void method3403() {
      this.field2739 = new boolean[super.field2718.length];

      int var1;
      for(var1 = 0; var1 < this.field2739.length; ++var1) {
         this.field2739[var1] = false;
      }

      if(null == this.field2743) {
         this.field2737 = true;
      } else {
         this.field2745 = -1;

         for(var1 = 0; var1 < this.field2739.length; ++var1) {
            if(super.field2717[var1] > 0) {
               class116 var2 = this.field2743;
               class180 var4 = new class180();
               var4.field2701 = 1;
               var4.hash = (long)var1;
               var4.field2697 = var2;
               var4.field2695 = this;
               Deque var5 = class183.field2730;
               synchronized(class183.field2730) {
                  class183.field2730.method2453(var4);
               }

               Object var10 = class183.field2732;
               synchronized(class183.field2732) {
                  if(class183.field2729 == 0) {
                     class33.field775.method2025(new class183(), 5);
                  }

                  class183.field2729 = 600;
               }

               this.field2745 = var1;
            }
         }

         if(this.field2745 == -1) {
            this.field2737 = true;
         }

      }
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1486272678"
   )
   int method3412(int var1) {
      if(super.field2718[var1] != null) {
         return 100;
      } else if(this.field2739[var1]) {
         return 100;
      } else {
         int var3 = this.field2736;
         long var4 = (long)((var3 << 16) + var1);
         int var2;
         if(class181.field2706 != null && class181.field2706.hash == var4) {
            var2 = 1 + class142.field2001.offset * 99 / (class142.field2001.payload.length - class181.field2706.field2702);
         } else {
            var2 = 0;
         }

         return var2;
      }
   }
}
