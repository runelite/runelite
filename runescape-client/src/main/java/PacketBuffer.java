import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("r")
   static final int[] field2391;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -136948795
   )
   @Export("bitPosition")
   int bitPosition;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   @Export("cipher")
   ISAACCipher cipher;

   static {
      field2391 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1685181099"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1392731469"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "87"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-879395635"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-706504315"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2391[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2391[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2391[var1];
      }

      return var4;
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1998443209"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "1910691026"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1182126144"
   )
   public static void method3450() {
      VarPlayerType.varplayers.reset();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1818711900"
   )
   public static int method3457(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1480568174"
   )
   static void method3448() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(class18.method133(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
                  Client.field1013[var1] = Client.field1013[var1 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "4"
   )
   public static int method3459(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }
}
