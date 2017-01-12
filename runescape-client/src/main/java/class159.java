import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public final class class159 extends Buffer {
   @ObfuscatedName("g")
   class160 field2107;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 785514477
   )
   int field2109;
   @ObfuscatedName("z")
   static final int[] field2112 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "511129140"
   )
   public void method3028(int[] var1) {
      this.field2107 = new class160(var1);
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1409564426"
   )
   public void method3029(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.field2107.method3063());
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "50"
   )
   public int method3030() {
      return super.payload[++super.offset - 1] - this.field2107.method3063() & 255;
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-770348276"
   )
   public void method3031() {
      this.field2109 = super.offset * 8;
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-80"
   )
   public int method3032(int var1) {
      int var2 = this.field2109 >> 3;
      int var3 = 8 - (this.field2109 & 7);
      int var4 = 0;

      for(this.field2109 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2112[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var1 == var3) {
         var4 += super.payload[var2] & field2112[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2112[var1];
      }

      return var4;
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "3641355"
   )
   public int method3033(int var1) {
      return 8 * var1 - this.field2109;
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1270684898"
   )
   public void method3040() {
      super.offset = (this.field2109 + 7) / 8;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class159(int var1) {
      super(var1);
   }
}
