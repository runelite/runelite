import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public final class class125 extends class122 {
   @ObfuscatedName("x")
   class126 field2067;
   @ObfuscatedName("k")
   static final int[] field2068 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -279134629
   )
   int field2069;
   @ObfuscatedName("rm")
   protected static boolean field2070;

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class125(int var1) {
      super(var1);
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "-32"
   )
   public void method2796(int[] var1) {
      this.field2067 = new class126(var1);
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "34"
   )
   public void method2797(int var1) {
      super.field2047[++super.field2045 - 1] = (byte)(var1 + this.field2067.method2831());
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1568586825"
   )
   public void method2799() {
      this.field2069 = super.field2045 * 8;
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-84"
   )
   public void method2800() {
      super.field2045 = (7 + this.field2069) / 8;
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-123"
   )
   public int method2801(int var1) {
      return var1 * 8 - this.field2069;
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "56"
   )
   public int method2805() {
      return super.field2047[++super.field2045 - 1] - this.field2067.method2831() & 255;
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1935401161"
   )
   public int method2813(int var1) {
      int var2 = this.field2069 >> 3;
      int var3 = 8 - (this.field2069 & 7);
      int var4 = 0;

      for(this.field2069 += var1; var1 > var3; var3 = 8) {
         var4 += (super.field2047[var2++] & field2068[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.field2047[var2] & field2068[var3];
      } else {
         var4 += super.field2047[var2] >> var3 - var1 & field2068[var1];
      }

      return var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "43022231"
   )
   public static byte[] method2820(Object var0, boolean var1) {
      if(null == var0) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof class128) {
         class128 var2 = (class128)var0;
         return var2.vmethod2842();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(III)Lclass110;",
      garbageValue = "2105551447"
   )
   static class110 method2821(int var0, int var1) {
      client.field550.field1940 = var0;
      client.field550.field1938 = var1;
      client.field550.field1939 = 1;
      client.field550.field1941 = 1;
      return client.field550;
   }
}
