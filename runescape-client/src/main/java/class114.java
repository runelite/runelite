import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public class class114 {
   @ObfuscatedName("e")
   public static int[] field1675;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   static Font field1673;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1268044521
   )
   int field1672;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 223668797
   )
   int field1667;
   @ObfuscatedName("v")
   int[][] field1670;

   public class114(int var1, int var2) {
      if(var2 != var1) {
         int var4 = var1;
         int var5 = var2;
         if(var2 > var1) {
            var4 = var2;
            var5 = var1;
         }

         while(var5 != 0) {
            int var6 = var4 % var5;
            var4 = var5;
            var5 = var6;
         }

         var1 /= var4;
         var2 /= var4;
         this.field1672 = var1;
         this.field1667 = var2;
         this.field1670 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1670[var7];
            double var9 = (double)var7 / (double)var1 + 6.0D;
            int var11 = (int)Math.floor(var9 - 7.0D + 1.0D);
            if(var11 < 0) {
               var11 = 0;
            }

            int var12 = (int)Math.ceil(var9 + 7.0D);
            if(var12 > 14) {
               var12 = 14;
            }

            for(double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
               double var15 = ((double)var11 - var9) * 3.141592653589793D;
               double var17 = var13;
               if(var15 < -1.0E-4D || var15 > 1.0E-4D) {
                  var17 = var13 * (Math.sin(var15) / var15);
               }

               var17 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * ((double)var11 - var9));
               var8[var11] = (int)Math.floor(0.5D + 65536.0D * var17);
            }
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "-96"
   )
   byte[] method2156(byte[] var1) {
      if(this.field1670 != null) {
         int var2 = (int)((long)this.field1667 * (long)var1.length / (long)this.field1672) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1670[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var7 * var8[var9];
            }

            var5 += this.field1667;
            var9 = var5 / this.field1672;
            var4 += var9;
            var5 -= var9 * this.field1672;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + 32768 >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-116"
   )
   int method2157(int var1) {
      if(this.field1670 != null) {
         var1 = (int)((long)this.field1667 * (long)var1 / (long)this.field1672);
      }

      return var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2084724504"
   )
   int method2160(int var1) {
      if(this.field1670 != null) {
         var1 = (int)((long)var1 * (long)this.field1667 / (long)this.field1672) + 6;
      }

      return var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "116"
   )
   public static void method2167(int var0, int var1) {
      Varbit var3 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var8 = Varbit.varbit_ref.getConfigData(14, var0);
         var3 = new Varbit();
         if(var8 != null) {
            var3.decode(new Buffer(var8));
         }

         Varbit.varbits.put(var3, (long)var0);
         var2 = var3;
      }

      int var4 = var2.configId;
      int var5 = var2.leastSignificantBit;
      int var6 = var2.mostSignificantBit;
      int var7 = class211.field2596[var6 - var5];
      if(var1 < 0 || var1 > var7) {
         var1 = 0;
      }

      var7 <<= var5;
      class211.widgetSettings[var4] = class211.widgetSettings[var4] & ~var7 | var1 << var5 & var7;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1769652951"
   )
   static int method2168(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return class238.currentRequest != null && class238.currentRequest.hash == var2?ScriptEvent.field858.offset * 99 / (ScriptEvent.field858.payload.length - class238.currentRequest.padding) + 1:0;
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(Lbe;B)V",
      garbageValue = "-95"
   )
   static final void method2166(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = class3.region.method2775(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = class3.region.method2749(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = class3.region.method2850(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = class3.region.method2746(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = class3.region.method2747(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1204 = var2;
      var0.field1199 = var3;
      var0.field1198 = var4;
   }
}
