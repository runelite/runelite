import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("u")
   static final int[] field2405;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 397441943
   )
   @Export("bitPosition")
   int bitPosition;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lfj;"
   )
   @Export("cipher")
   ISAACCipher cipher;

   static {
      field2405 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "607671651"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "116"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-917357743"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2112764119"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2405[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2405[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2405[var1];
      }

      return var4;
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1475397433"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "113849151"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "11671569"
   )
   static final int method3425(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return (var3 * (var0 & 16711935) + (var1 & 16711935) * var2 & -16711936) + ((var1 & '\uff00') * var2 + (var0 & '\uff00') * var3 & 16711680) >> 8;
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1161954612"
   )
   static final void method3427(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var2 - var0;
      int var7 = var3 - var1;
      int var8 = var6 >= 0?var6:-var6;
      int var9 = var7 >= 0?var7:-var7;
      int var10 = var8;
      if(var8 < var9) {
         var10 = var9;
      }

      if(var10 != 0) {
         int var11 = (var6 << 16) / var10;
         int var12 = (var7 << 16) / var10;
         if(var12 <= var11) {
            var11 = -var11;
         } else {
            var12 = -var12;
         }

         int var13 = var5 * var12 >> 17;
         int var14 = var5 * var12 + 1 >> 17;
         int var15 = var5 * var11 >> 17;
         int var16 = var5 * var11 + 1 >> 17;
         var0 -= Rasterizer2D.draw_region_x;
         var1 -= Rasterizer2D.drawingAreaTop;
         int var17 = var0 + var13;
         int var18 = var0 - var14;
         int var19 = var0 + var6 - var14;
         int var20 = var0 + var13 + var6;
         int var21 = var15 + var1;
         int var22 = var1 - var16;
         int var23 = var7 + var1 - var16;
         int var24 = var15 + var7 + var1;
         Graphics3D.setRasterClippingEnabled(var17, var18, var19);
         Graphics3D.rasterFlat(var21, var22, var23, var17, var18, var19, var4);
         Graphics3D.setRasterClippingEnabled(var17, var19, var20);
         Graphics3D.rasterFlat(var21, var23, var24, var17, var19, var20, var4);
      }
   }

   @ObfuscatedName("n")
   public static String method3414(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class269.field3660[(int)(var6 - 37L * var0)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }
}
