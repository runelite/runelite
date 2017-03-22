import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
@Implements("CipherBuffer")
public final class CipherBuffer extends Buffer {
   @ObfuscatedName("y")
   static final int[] field2111 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1702703027
   )
   int field2113;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = -1691785607
   )
   static int field2114;
   @ObfuscatedName("g")
   @Export("cipher")
   ISAACCipher cipher;

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-29"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-35"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1739649523"
   )
   public int method3080(int var1) {
      return var1 * 8 - this.field2113;
   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "32767"
   )
   static void method3081(int var0) {
      for(class133 var1 = (class133)Client.widgetFlags.method2391(); null != var1; var1 = (class133)Client.widgetFlags.method2392()) {
         if((long)var0 == (var1.hash >> 48 & 65535L)) {
            var1.unlink();
         }
      }

   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "450287798"
   )
   public void method3082() {
      super.offset = (7 + this.field2113) / 8;
   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1991355414"
   )
   public void method3085() {
      this.field2113 = super.offset * 8;
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "0"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-7590209"
   )
   public int method3097(int var1) {
      int var2 = this.field2113 >> 3;
      int var3 = 8 - (this.field2113 & 7);
      int var4 = 0;

      for(this.field2113 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2111[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var1 == var3) {
         var4 += super.payload[var2] & field2111[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2111[var1];
      }

      return var4;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public CipherBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)Lclass189;",
      garbageValue = "93"
   )
   public static class189 method3098(int var0) {
      class189 var1 = (class189)class189.field2783.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class189.field2780.getConfigData(15, var0);
         var1 = new class189();
         if(null != var2) {
            var1.method3465(new Buffer(var2));
         }

         class189.field2783.put(var1, (long)var0);
         return var1;
      }
   }
}
