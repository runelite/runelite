import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class171 extends class170 {
   @ObfuscatedName("k")
   volatile boolean field2730 = false;
   @ObfuscatedName("m")
   class137 field2731;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1514864225
   )
   int field2732;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1793174503
   )
   int field2733 = -1;
   @ObfuscatedName("n")
   boolean field2734 = false;
   @ObfuscatedName("d")
   volatile boolean[] field2735;
   @ObfuscatedName("y")
   class137 field2736;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1642120583
   )
   int field2737;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 523787791
   )
   int field2738;
   @ObfuscatedName("s")
   static CRC32 field2739 = new CRC32();

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-4"
   )
   public void method3427(int var1, int var2) {
      this.field2737 = var1;
      this.field2738 = var2;
      if(this.field2731 != null) {
         int var3 = this.field2732;
         class137 var4 = this.field2731;
         byte[] var6 = null;
         class202 var7 = class173.field2750;
         synchronized(class173.field2750) {
            for(class172 var8 = (class172)class173.field2750.method3899(); null != var8; var8 = (class172)class173.field2750.method3918()) {
               if(var8.field3161 == (long)var3 && var4 == var8.field2742 && var8.field2745 == 0) {
                  var6 = var8.field2747;
                  break;
               }
            }
         }

         if(var6 != null) {
            this.method3430(var4, var3, var6, true);
         } else {
            byte[] var11 = var4.method2980(var3);
            this.method3430(var4, var3, var11, true);
         }
      } else {
         class85.method1984(this, 255, this.field2732, this.field2737, (byte)0, true);
      }

   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1710161044"
   )
   int method3428(int var1) {
      if(null != super.field2717[var1]) {
         return 100;
      } else if(this.field2735[var1]) {
         return 100;
      } else {
         int var3 = this.field2732;
         long var4 = (long)((var3 << 16) + var1);
         int var2;
         if(class13.field217 != null && var4 == class13.field217.field3161) {
            var2 = 1 + class17.field259.field2061 * 99 / (class17.field259.field2054.length - class13.field217.field2779);
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "-2065718600"
   )
   public void method3429(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2730) {
            throw new RuntimeException();
         }

         if(this.field2731 != null) {
            class4.method44(this.field2732, var2, this.field2731);
         }

         this.method3347(var2);
         this.method3431();
      } else {
         var2[var2.length - 2] = (byte)(super.field2712[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2712[var1];
         if(null != this.field2736) {
            class4.method44(var1, var2, this.field2736);
            this.field2735[var1] = true;
         }

         if(var4) {
            super.field2717[var1] = class42.method888(var2, false);
         }
      }

   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(Lclass137;I[BZI)V",
      garbageValue = "-1015148176"
   )
   void method3430(class137 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2731) {
         if(this.field2730) {
            throw new RuntimeException();
         } else if(null == var3) {
            class85.method1984(this, 255, this.field2732, this.field2737, (byte)0, true);
         } else {
            field2739.reset();
            field2739.update(var3, 0, var3.length);
            var5 = (int)field2739.getValue();
            class122 var6 = new class122(class59.method1325(var3));
            int var7 = var6.method2610();
            if(var7 != 5 && var7 != 6) {
               throw new RuntimeException(var7 + "," + this.field2732 + "," + var2);
            } else {
               int var8 = 0;
               if(var7 >= 6) {
                  var8 = var6.method2614();
               }

               if(var5 != this.field2737 || var8 != this.field2738) {
                  class85.method1984(this, 255, this.field2732, this.field2737, (byte)0, true);
               } else {
                  this.method3347(var3);
                  this.method3431();
               }
            }
         }
      } else {
         if(!var4 && this.field2733 == var2) {
            this.field2730 = true;
         }

         if(var3 != null && var3.length > 2) {
            field2739.reset();
            field2739.update(var3, 0, var3.length - 2);
            var5 = (int)field2739.getValue();
            int var9 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
            if(super.field2710[var2] == var5 && var9 == super.field2712[var2]) {
               this.field2735[var2] = true;
               if(var4) {
                  super.field2717[var2] = class42.method888(var3, false);
               }

            } else {
               this.field2735[var2] = false;
               if(this.field2734 || var4) {
                  class85.method1984(this, this.field2732, var2, super.field2710[var2], (byte)2, var4);
               }

            }
         } else {
            this.field2735[var2] = false;
            if(this.field2734 || var4) {
               class85.method1984(this, this.field2732, var2, super.field2710[var2], (byte)2, var4);
            }

         }
      }
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "538062055"
   )
   void method3431() {
      this.field2735 = new boolean[super.field2717.length];

      int var1;
      for(var1 = 0; var1 < this.field2735.length; ++var1) {
         this.field2735[var1] = false;
      }

      if(null == this.field2736) {
         this.field2730 = true;
      } else {
         this.field2733 = -1;

         for(var1 = 0; var1 < this.field2735.length; ++var1) {
            if(super.field2722[var1] > 0) {
               class137 var2 = this.field2736;
               class172 var4 = new class172();
               var4.field2745 = 1;
               var4.field3161 = (long)var1;
               var4.field2742 = var2;
               var4.field2740 = this;
               class202 var5 = class173.field2750;
               synchronized(class173.field2750) {
                  class173.field2750.method3895(var4);
               }

               class125.method2862();
               this.field2733 = var1;
            }
         }

         if(this.field2733 == -1) {
            this.field2730 = true;
         }

      }
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1414389488"
   )
   public int method3433() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2717.length; ++var3) {
         if(super.field2722[var3] > 0) {
            var1 += 100;
            var2 += this.method3428(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   public class171(class137 var1, class137 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2736 = var1;
      this.field2731 = var2;
      this.field2732 = var3;
      this.field2734 = var6;
      int var8 = this.field2732;
      if(class43.field1017 != null) {
         class43.field1017.field2061 = 5 + 8 * var8;
         int var9 = class43.field1017.method2614();
         int var10 = class43.field1017.method2614();
         this.method3427(var9, var10);
      } else {
         class85.method1984((class171)null, 255, 255, 0, (byte)0, true);
         class174.field2757[var8] = this;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1362594641"
   )
   void vmethod3442(int var1) {
      if(this.field2736 != null && null != this.field2735 && this.field2735[var1]) {
         class137 var2 = this.field2736;
         byte[] var4 = null;
         class202 var5 = class173.field2750;
         synchronized(class173.field2750) {
            for(class172 var6 = (class172)class173.field2750.method3899(); null != var6; var6 = (class172)class173.field2750.method3918()) {
               if((long)var1 == var6.field3161 && var6.field2742 == var2 && var6.field2745 == 0) {
                  var4 = var6.field2747;
                  break;
               }
            }
         }

         if(var4 != null) {
            this.method3430(var2, var1, var4, true);
         } else {
            byte[] var9 = var2.method2980(var1);
            this.method3430(var2, var1, var9, true);
         }
      } else {
         class85.method1984(this, this.field2732, var1, super.field2710[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-933642715"
   )
   public int method3445() {
      if(this.field2730) {
         return 100;
      } else if(super.field2717 != null) {
         return 99;
      } else {
         int var2 = this.field2732;
         long var3 = (long)(16711680 + var2);
         int var1;
         if(class13.field217 != null && var3 == class13.field217.field3161) {
            var1 = 1 + class17.field259.field2061 * 99 / (class17.field259.field2054.length - class13.field217.field2779);
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-673460376"
   )
   void vmethod3457(int var1) {
      class3.method37(this.field2732, var1);
   }
}
