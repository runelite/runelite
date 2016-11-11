import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public final class class125 extends Buffer {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1971508017
   )
   int field2063;
   @ObfuscatedName("m")
   class126 field2064;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = -346274905
   )
   static int field2065;
   @ObfuscatedName("j")
   static final int[] field2066 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1654030168"
   )
   public void method2783(int[] var1) {
      this.field2064 = new class126(var1);
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1055200466"
   )
   public void method2786() {
      this.field2063 = super.offset * 8;
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1060499368"
   )
   public int method2787(int var1) {
      int var2 = this.field2063 >> 3;
      int var3 = 8 - (this.field2063 & 7);
      int var4 = 0;

      for(this.field2063 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2066[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var1 == var3) {
         var4 += super.payload[var2] & field2066[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2066[var1];
      }

      return var4;
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "52"
   )
   public int method2788() {
      return super.payload[++super.offset - 1] - this.field2064.method2808() & 255;
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "5"
   )
   public int method2789(int var1) {
      return var1 * 8 - this.field2063;
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-93"
   )
   public void method2790() {
      super.offset = (7 + this.field2063) / 8;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class125(int var1) {
      super(var1);
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-107"
   )
   public void method2801(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.field2064.method2808());
   }

   @ObfuscatedName("pi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2033346758"
   )
   protected static final void method2806() {
      FrameMap.field1824 = null;
      World.field684 = null;
      class171.field2746 = null;
   }
}
