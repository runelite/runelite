import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public final class class125 extends Buffer {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -901641641
   )
   int field2053;
   @ObfuscatedName("h")
   static final int[] field2054 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("k")
   class126 field2055;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -1257185177
   )
   @Export("cameraPitch")
   static int cameraPitch;

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "1"
   )
   public void method2747(int[] var1) {
      this.field2055 = new class126(var1);
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1074229799"
   )
   public void method2748(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.field2055.method2782());
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1727465133"
   )
   public int method2749() {
      return super.payload[++super.offset - 1] - this.field2055.method2782() & 255;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "1400"
   )
   public void method2750() {
      this.field2053 = super.offset * 8;
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-899147362"
   )
   public void method2751() {
      super.offset = (this.field2053 + 7) / 8;
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "2"
   )
   public int method2753(int var1) {
      return var1 * 8 - this.field2053;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class125(int var1) {
      super(var1);
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-86"
   )
   public int method2762(int var1) {
      int var2 = this.field2053 >> 3;
      int var3 = 8 - (this.field2053 & 7);
      int var4 = 0;

      for(this.field2053 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2054[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var1 == var3) {
         var4 += super.payload[var2] & field2054[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2054[var1];
      }

      return var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass56;",
      garbageValue = "-944523627"
   )
   public static class56 method2774(int var0) {
      class56 var1 = (class56)class56.field1203.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class56.field1198.method3272(16, var0);
         var1 = new class56();
         if(var2 != null) {
            var1.method1137(new Buffer(var2));
         }

         class56.field1203.put(var1, (long)var0);
         return var1;
      }
   }
}
