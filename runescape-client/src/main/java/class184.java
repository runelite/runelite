import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
public class class184 extends class182 {
   @ObfuscatedName("b")
   class116 field2735;
   @ObfuscatedName("v")
   boolean field2736 = false;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -138820591
   )
   int field2737;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 247187699
   )
   int field2738;
   @ObfuscatedName("k")
   volatile boolean field2739 = false;
   @ObfuscatedName("u")
   volatile boolean[] field2740;
   @ObfuscatedName("a")
   class116 field2741;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -306909199
   )
   int field2742;
   @ObfuscatedName("t")
   static CRC32 field2743 = new CRC32();
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1186094365
   )
   int field2744 = -1;

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "16"
   )
   public int method3424() {
      if(this.field2739) {
         return 100;
      } else if(null != super.field2717) {
         return 99;
      } else {
         int var1 = class108.method2087(255, this.field2737);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1993074564"
   )
   void vmethod3425(int var1) {
      Renderable.method1919(this.field2737, var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-839099042"
   )
   void vmethod3426(int var1) {
      if(this.field2741 != null && this.field2740 != null && this.field2740[var1]) {
         class142.method2747(var1, this.field2741, this);
      } else {
         class88.method1906(this, this.field2737, var1, super.field2711[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "121"
   )
   void method3427(int var1, int var2) {
      this.field2738 = var1;
      this.field2742 = var2;
      if(null != this.field2735) {
         class142.method2747(this.field2737, this.field2735, this);
      } else {
         class88.method1906(this, 255, this.field2737, this.field2738, (byte)0, true);
      }

   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(Lclass116;I[BZI)V",
      garbageValue = "-1699792935"
   )
   void method3430(class116 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2735) {
         if(this.field2739) {
            throw new RuntimeException();
         } else if(null == var3) {
            class88.method1906(this, 255, this.field2737, this.field2738, (byte)0, true);
         } else {
            field2743.reset();
            field2743.update(var3, 0, var3.length);
            var5 = (int)field2743.getValue();
            Buffer var6 = new Buffer(XGrandExchangeOffer.method50(var3));
            int var7 = var6.method3033();
            if(var7 != 5 && var7 != 6) {
               throw new RuntimeException(var7 + "," + this.field2737 + "," + var2);
            } else {
               int var8 = 0;
               if(var7 >= 6) {
                  var8 = var6.method2995();
               }

               if(this.field2738 != var5 || var8 != this.field2742) {
                  class88.method1906(this, 255, this.field2737, this.field2738, (byte)0, true);
               } else {
                  this.method3327(var3);
                  this.method3432();
               }
            }
         }
      } else {
         if(!var4 && var2 == this.field2744) {
            this.field2739 = true;
         }

         if(null != var3 && var3.length > 2) {
            field2743.reset();
            field2743.update(var3, 0, var3.length - 2);
            var5 = (int)field2743.getValue();
            int var9 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
            if(var5 == super.field2711[var2] && var9 == super.field2707[var2]) {
               this.field2740[var2] = true;
               if(var4) {
                  super.field2717[var2] = TextureProvider.method1484(var3, false);
               }

            } else {
               this.field2740[var2] = false;
               if(this.field2736 || var4) {
                  class88.method1906(this, this.field2737, var2, super.field2711[var2], (byte)2, var4);
               }

            }
         } else {
            this.field2740[var2] = false;
            if(this.field2736 || var4) {
               class88.method1906(this, this.field2737, var2, super.field2711[var2], (byte)2, var4);
            }

         }
      }
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "771333117"
   )
   void method3432() {
      this.field2740 = new boolean[super.field2717.length];

      int var1;
      for(var1 = 0; var1 < this.field2740.length; ++var1) {
         this.field2740[var1] = false;
      }

      if(null == this.field2741) {
         this.field2739 = true;
      } else {
         this.field2744 = -1;

         for(var1 = 0; var1 < this.field2740.length; ++var1) {
            if(super.field2713[var1] > 0) {
               class116 var2 = this.field2741;
               class180 var4 = new class180();
               var4.field2699 = 1;
               var4.hash = (long)var1;
               var4.field2701 = var2;
               var4.field2702 = this;
               Deque var5 = class183.field2731;
               synchronized(class183.field2731) {
                  class183.field2731.method2454(var4);
               }

               class36.method750();
               this.field2744 = var1;
            }
         }

         if(this.field2744 == -1) {
            this.field2739 = true;
         }

      }
   }

   public class184(class116 var1, class116 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2741 = var1;
      this.field2735 = var2;
      this.field2737 = var3;
      this.field2736 = var6;
      int var8 = this.field2737;
      if(class112.field1766 != null) {
         class112.field1766.offset = 5 + var8 * 8;
         int var9 = class112.field1766.method2995();
         int var10 = class112.field1766.method2995();
         this.method3427(var9, var10);
      } else {
         class88.method1906((class184)null, 255, 255, 0, (byte)0, true);
         class185.field2760[var8] = this;
      }

   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1851265529"
   )
   int method3443(int var1) {
      return super.field2717[var1] != null?100:(this.field2740[var1]?100:class108.method2087(this.field2737, var1));
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(I[BZZB)V",
      garbageValue = "106"
   )
   void method3445(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2739) {
            throw new RuntimeException();
         }

         if(this.field2735 != null) {
            class37.method767(this.field2737, var2, this.field2735);
         }

         this.method3327(var2);
         this.method3432();
      } else {
         var2[var2.length - 2] = (byte)(super.field2707[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2707[var1];
         if(null != this.field2741) {
            class37.method767(var1, var2, this.field2741);
            this.field2740[var1] = true;
         }

         if(var4) {
            super.field2717[var1] = TextureProvider.method1484(var2, false);
         }
      }

   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1473188228"
   )
   public int method3454() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2717.length; ++var3) {
         if(super.field2713[var3] > 0) {
            var1 += 100;
            var2 += this.method3443(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }
}
