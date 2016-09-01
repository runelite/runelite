import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
public final class class125 extends Buffer {
   @ObfuscatedName("f")
   static final int[] field2069 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1619123867
   )
   int field2071;
   @ObfuscatedName("p")
   class126 field2072;

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-2110978283"
   )
   public void method2817(int[] var1) {
      this.field2072 = new class126(var1);
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1296928369"
   )
   public void method2818(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.field2072.method2835());
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "725296690"
   )
   public int method2819() {
      return super.payload[++super.offset - 1] - this.field2072.method2835() & 255;
   }

   @ObfuscatedName("x")
   public static final void method2820(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            class24.method577(var0 - 1L);
            class24.method577(1L);
         } else {
            class24.method577(var0);
         }

      }
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2061759632"
   )
   public void method2822() {
      super.offset = (this.field2071 + 7) / 8;
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "44"
   )
   public int method2823(int var1) {
      return 8 * var1 - this.field2071;
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-883416563"
   )
   public void method2824() {
      this.field2071 = super.offset * 8;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class125(int var1) {
      super(var1);
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "0"
   )
   public int method2827(int var1) {
      int var2 = this.field2071 >> 3;
      int var3 = 8 - (this.field2071 & 7);
      int var4 = 0;

      for(this.field2071 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2069[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var1 == var3) {
         var4 += super.payload[var2] & field2069[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2069[var1];
      }

      return var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "1801330945"
   )
   public static void method2831(class170 var0) {
      class50.field1091 = var0;
   }
}
