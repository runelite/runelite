import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("n")
   static final int[] field2522;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1481163043
   )
   @Export("bitPosition")
   int bitPosition;

   static {
      field2522 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1027144822"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(Lga;B)V",
      garbageValue = "-92"
   )
   public void method3568(ISAACCipher var1) {
      this.cipher = var1;
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1753156422"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1762083404"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-513039549"
   )
   public boolean method3563() {
      int var1 = super.payload[super.offset] - this.cipher.method3601() & 255;
      return var1 >= 128;
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-254298097"
   )
   public int method3564() {
      int var1 = super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
      return var1 < 128?var1:(var1 - 128 << 8) + (super.payload[++super.offset - 1] - this.cipher.nextInt() & 255);
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-49"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "442383076"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2522[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2522[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2522[var1];
      }

      return var4;
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-653688328"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "-24331"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Liq;",
      garbageValue = "194627087"
   )
   public static class258 method3597(int var0) {
      class258 var1 = (class258)class258.field3440.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class258.field3446.getConfigData(11, var0);
         var1 = new class258();
         if(var2 != null) {
            var1.method4612(new Buffer(var2));
         }

         var1.method4615();
         class258.field3440.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lkl;I)Ljava/lang/String;",
      garbageValue = "322587445"
   )
   public static String method3598(CharSequence var0, class298 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && TextureProvider.method2512(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && TextureProvider.method2512(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1 && var4 <= class61.method1126(var1)) {
            StringBuilder var5 = new StringBuilder(var4);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               if(BaseVarType.method14(var7)) {
                  char var8 = MilliTimer.method3036(var7);
                  if(var8 != 0) {
                     var5.append(var8);
                  }
               }
            }

            if(var5.length() == 0) {
               return null;
            } else {
               return var5.toString();
            }
         } else {
            return null;
         }
      }
   }
}
