import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public final class class125 extends Buffer {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1565320311
   )
   int field2072;
   @ObfuscatedName("h")
   static final int[] field2073 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("u")
   class126 field2075;
   @ObfuscatedName("w")
   static String[] field2076;

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "57"
   )
   public void method2804(int[] var1) {
      this.field2075 = new class126(var1);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class125(int var1) {
      super(var1);
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2124715701"
   )
   public void method2806() {
      this.field2072 = super.offset * 8;
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-371063754"
   )
   public int method2807(int var1) {
      int var2 = this.field2072 >> 3;
      int var3 = 8 - (this.field2072 & 7);
      int var4 = 0;

      for(this.field2072 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2073[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var1 == var3) {
         var4 += super.payload[var2] & field2073[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2073[var1];
      }

      return var4;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-151026850"
   )
   public static void method2808(boolean var0) {
      if(null != class174.field2769) {
         try {
            Buffer var1 = new Buffer(4);
            var1.method2556(var0?2:3);
            var1.method2558(0);
            class174.field2769.method3027(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class174.field2769.method3020();
            } catch (Exception var3) {
               ;
            }

            ++class174.field2778;
            class174.field2769 = null;
         }

      }
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1775185124"
   )
   public int method2820() {
      return super.payload[++super.offset - 1] - this.field2075.method2844() & 255;
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1501035922"
   )
   public int method2824(int var1) {
      return var1 * 8 - this.field2072;
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-561411231"
   )
   public void method2827() {
      super.offset = (this.field2072 + 7) / 8;
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "119"
   )
   public void method2828(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.field2075.method2844());
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LWorld;I)V",
      garbageValue = "84184325"
   )
   @Export("selectWorld")
   static void selectWorld(World var0) {
      if(var0.method621() != Client.isMembers) {
         Client.isMembers = var0.method621();
         VertexNormal.method2269(var0.method621());
      }

      class124.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      Client.field317 = Client.field279 == 0?'ꩊ':'鱀' + var0.id;
      MessageNode.field803 = Client.field279 == 0?443:'썐' + var0.id;
      class119.field2041 = Client.field317;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-2090651807"
   )
   public static int method2833(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2058[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }
}
