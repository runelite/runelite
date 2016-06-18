import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public final class class122 extends class119 {
   @ObfuscatedName("u")
   static final int[] field1999 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1350214415
   )
   int field2001;
   @ObfuscatedName("l")
   class123 field2003;

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "472442967"
   )
   public void method2780(int[] var1) {
      this.field2003 = new class123(var1);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class122(int var1) {
      super(var1);
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-39"
   )
   public void method2781(int var1) {
      super.field1982[++super.field1976 - 1] = (byte)(var1 + this.field2003.method2811());
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-75"
   )
   public int method2784(int var1) {
      int var2 = this.field2001 >> 3;
      int var3 = 8 - (this.field2001 & 7);
      int var4 = 0;

      for(this.field2001 += var1; var1 > var3; var3 = 8) {
         var4 += (super.field1982[var2++] & field1999[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var1 == var3) {
         var4 += super.field1982[var2] & field1999[var3];
      } else {
         var4 += super.field1982[var2] >> var3 - var1 & field1999[var1];
      }

      return var4;
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1002253143"
   )
   public void method2785() {
      super.field1976 = (7 + this.field2001) / 8;
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "0"
   )
   public int method2786(int var1) {
      return var1 * 8 - this.field2001;
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-439444011"
   )
   public int method2787() {
      return super.field1982[++super.field1976 - 1] - this.field2003.method2811() & 255;
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-837828591"
   )
   public void method2792() {
      this.field2001 = super.field1976 * 8;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass42;IIIB)V",
      garbageValue = "18"
   )
   static void method2808(class42 var0, int var1, int var2, int var3) {
      if(client.field504 < 50 && client.field365 != 0) {
         if(null != var0.field970 && var1 < var0.field970.length) {
            int var4 = var0.field970[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               client.field530[client.field504] = var5;
               client.field531[client.field504] = var6;
               client.field532[client.field504] = 0;
               client.field534[client.field504] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               client.field480[client.field504] = (var9 << 8) + (var8 << 16) + var7;
               ++client.field504;
            }
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIS)I",
      garbageValue = "10413"
   )
   static int method2809(int var0, int var1, int var2) {
      return (class5.field69[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class5.field69[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }
}
