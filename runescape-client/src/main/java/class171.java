import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class171 extends class170 {
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1626732823
   )
   int field2741;
   @ObfuscatedName("t")
   class137 field2742;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1001601011
   )
   int field2743;
   @ObfuscatedName("q")
   boolean field2745 = false;
   @ObfuscatedName("a")
   volatile boolean[] field2746;
   @ObfuscatedName("b")
   static CRC32 field2747 = new CRC32();
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 716345245
   )
   int field2748;
   @ObfuscatedName("n")
   volatile boolean field2749 = false;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 390097083
   )
   int field2750 = -1;
   @ObfuscatedName("c")
   class137 field2751;

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method3383() {
      if(this.field2749) {
         return 100;
      } else if(null != super.field2733) {
         return 99;
      } else {
         int var2 = this.field2743;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(null != class174.field2771 && var3 == class174.field2771.field3167) {
            var1 = 1 + class117.field2020.field2045 * 99 / (class117.field2020.field2047.length - class174.field2771.field2781);
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-60"
   )
   void vmethod3385(int var1) {
      if(this.field2742 != null && this.field2746 != null && this.field2746[var1]) {
         class137 var2 = this.field2742;
         byte[] var4 = null;
         class202 var5 = class173.field2759;
         synchronized(class173.field2759) {
            for(class172 var6 = (class172)class173.field2759.method3882(); null != var6; var6 = (class172)class173.field2759.method3891()) {
               if((long)var1 == var6.field3167 && var2 == var6.field2754 && var6.field2753 == 0) {
                  var4 = var6.field2755;
                  break;
               }
            }
         }

         if(var4 != null) {
            this.method3396(var2, var1, var4, true);
         } else {
            byte[] var9 = var2.method2914(var1);
            this.method3396(var2, var1, var9, true);
         }
      } else {
         class158.method3214(this, this.field2743, var1, super.field2738[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "789359295"
   )
   public void method3387(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2749) {
            throw new RuntimeException();
         }

         if(null != this.field2751) {
            class142.method2999(this.field2743, var2, this.field2751);
         }

         this.method3366(var2);
         this.method3411();
      } else {
         var2[var2.length - 2] = (byte)(super.field2739[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2739[var1];
         if(this.field2742 != null) {
            class142.method2999(var1, var2, this.field2742);
            this.field2746[var1] = true;
         }

         if(var4) {
            super.field2733[var1] = class132.method2879(var2, false);
         }
      }

   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-60"
   )
   int method3389(int var1) {
      if(null != super.field2733[var1]) {
         return 100;
      } else if(this.field2746[var1]) {
         return 100;
      } else {
         int var3 = this.field2743;
         long var4 = (long)((var3 << 16) + var1);
         int var2;
         if(null != class174.field2771 && class174.field2771.field3167 == var4) {
            var2 = 1 + class117.field2020.field2045 * 99 / (class117.field2020.field2047.length - class174.field2771.field2781);
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1623103617"
   )
   public int method3390() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2733.length; ++var3) {
         if(super.field2726[var3] > 0) {
            var1 += 100;
            var2 += this.method3389(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = 100 * var2 / var1;
         return var3;
      }
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1416769929"
   )
   public void method3394(int var1, int var2) {
      this.field2748 = var1;
      this.field2741 = var2;
      if(null != this.field2751) {
         int var3 = this.field2743;
         class137 var4 = this.field2751;
         byte[] var6 = null;
         class202 var7 = class173.field2759;
         synchronized(class173.field2759) {
            for(class172 var8 = (class172)class173.field2759.method3882(); var8 != null; var8 = (class172)class173.field2759.method3891()) {
               if((long)var3 == var8.field3167 && var4 == var8.field2754 && var8.field2753 == 0) {
                  var6 = var8.field2755;
                  break;
               }
            }
         }

         if(var6 != null) {
            this.method3396(var4, var3, var6, true);
         } else {
            byte[] var11 = var4.method2914(var3);
            this.method3396(var4, var3, var11, true);
         }
      } else {
         class158.method3214(this, 255, this.field2743, this.field2748, (byte)0, true);
      }

   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(Lclass137;I[BZB)V",
      garbageValue = "-27"
   )
   public void method3396(class137 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2751) {
         if(this.field2749) {
            throw new RuntimeException();
         } else if(var3 == null) {
            class158.method3214(this, 255, this.field2743, this.field2748, (byte)0, true);
         } else {
            field2747.reset();
            field2747.update(var3, 0, var3.length);
            var5 = (int)field2747.getValue();
            class122 var6 = new class122(class156.method3200(var3));
            int var7 = var6.method2556();
            if(var7 != 5 && var7 != 6) {
               throw new RuntimeException(var7 + "," + this.field2743 + "," + var2);
            } else {
               int var8 = 0;
               if(var7 >= 6) {
                  var8 = var6.method2577();
               }

               if(this.field2748 != var5 || var8 != this.field2741) {
                  class158.method3214(this, 255, this.field2743, this.field2748, (byte)0, true);
               } else {
                  this.method3366(var3);
                  this.method3411();
               }
            }
         }
      } else {
         if(!var4 && this.field2750 == var2) {
            this.field2749 = true;
         }

         if(var3 != null && var3.length > 2) {
            field2747.reset();
            field2747.update(var3, 0, var3.length - 2);
            var5 = (int)field2747.getValue();
            int var9 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
            if(var5 == super.field2738[var2] && var9 == super.field2739[var2]) {
               this.field2746[var2] = true;
               if(var4) {
                  super.field2733[var2] = class132.method2879(var3, false);
               }

            } else {
               this.field2746[var2] = false;
               if(this.field2745 || var4) {
                  class158.method3214(this, this.field2743, var2, super.field2738[var2], (byte)2, var4);
               }

            }
         } else {
            this.field2746[var2] = false;
            if(this.field2745 || var4) {
               class158.method3214(this, this.field2743, var2, super.field2738[var2], (byte)2, var4);
            }

         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "81"
   )
   void vmethod3403(int var1) {
      class170.method3326(this.field2743, var1);
   }

   public class171(class137 var1, class137 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2742 = var1;
      this.field2751 = var2;
      this.field2743 = var3;
      this.field2745 = var6;
      int var8 = this.field2743;
      if(class167.field2716 != null) {
         class167.field2716.field2045 = 8 * var8 + 5;
         int var9 = class167.field2716.method2577();
         int var10 = class167.field2716.method2577();
         this.method3394(var9, var10);
      } else {
         class158.method3214((class171)null, 255, 255, 0, (byte)0, true);
         class174.field2769[var8] = this;
      }

   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1197933063"
   )
   void method3411() {
      this.field2746 = new boolean[super.field2733.length];

      int var1;
      for(var1 = 0; var1 < this.field2746.length; ++var1) {
         this.field2746[var1] = false;
      }

      if(null == this.field2742) {
         this.field2749 = true;
      } else {
         this.field2750 = -1;

         for(var1 = 0; var1 < this.field2746.length; ++var1) {
            if(super.field2726[var1] > 0) {
               class54.method1131(var1, this.field2742, this);
               this.field2750 = var1;
            }
         }

         if(this.field2750 == -1) {
            this.field2749 = true;
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1787911387"
   )
   @Export("setGameState")
   static void method3414(int var0) {
      if(client.field280 != var0) {
         if(client.field280 == 0) {
            class17.field233 = null;
            class147.field2264 = null;
            class7.field124 = null;
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            client.field304 = 0;
            client.field305 = 0;
            client.field420 = 0;
         }

         if(var0 != 20 && var0 != 40 && null != class177.field2937) {
            class177.field2937.method3050();
            class177.field2937 = null;
         }

         if(client.field280 == 25) {
            client.field416 = 0;
            client.field325 = 0;
            client.field326 = 1;
            client.field459 = 0;
            client.field521 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               client.method361(class112.field1965, class40.field895, class42.field993, true, client.field280 == 11?4:0);
            } else if(var0 == 11) {
               client.method361(class112.field1965, class40.field895, class42.field993, false, 4);
            } else {
               class20.method556();
            }
         } else {
            client.method361(class112.field1965, class40.field895, class42.field993, true, 0);
         }

         client.field280 = var0;
      }
   }
}
