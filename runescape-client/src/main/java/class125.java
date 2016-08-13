import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public final class class125 extends Buffer {
   @ObfuscatedName("eh")
   static SpritePixels[] field2066;
   @ObfuscatedName("b")
   static final int[] field2067 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1652549435
   )
   int field2068;
   @ObfuscatedName("nd")
   static class59 field2069;
   @ObfuscatedName("pb")
   public static class139 field2070;
   @ObfuscatedName("n")
   class126 field2074;

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "917305190"
   )
   public int method2895(int var1) {
      return var1 * 8 - this.field2068;
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-23"
   )
   public int method2898() {
      return super.payload[++super.offset - 1] - this.field2074.method2927() & 255;
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1438605732"
   )
   public void method2899() {
      this.field2068 = super.offset * 8;
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-329548918"
   )
   public void method2900() {
      super.offset = (this.field2068 + 7) / 8;
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1963775429"
   )
   public void method2903(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.field2074.method2927());
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
      signature = "(II)I",
      garbageValue = "2049501691"
   )
   public int method2907(int var1) {
      int var2 = this.field2068 >> 3;
      int var3 = 8 - (this.field2068 & 7);
      int var4 = 0;

      for(this.field2068 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2067[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var1 == var3) {
         var4 += super.payload[var2] & field2067[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2067[var1];
      }

      return var4;
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "487549112"
   )
   public void method2908(int[] var1) {
      this.field2074 = new class126(var1);
   }
}
