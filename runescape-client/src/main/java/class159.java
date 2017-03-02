import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public final class class159 extends Buffer {
   @ObfuscatedName("r")
   static final int[] field2120 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("ee")
   static SpritePixels[] field2121;
   @ObfuscatedName("q")
   static int[] field2122;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1123083917
   )
   int field2123;
   @ObfuscatedName("a")
   class160 field2124;

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "0"
   )
   public int method3119(int var1) {
      int var2 = this.field2123 >> 3;
      int var3 = 8 - (this.field2123 & 7);
      int var4 = 0;

      for(this.field2123 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2120[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2120[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2120[var1];
      }

      return var4;
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "1801812533"
   )
   public void method3120(int[] var1) {
      this.field2124 = new class160(var1);
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1438855367"
   )
   public int method3122() {
      return super.payload[++super.offset - 1] - this.field2124.method3157() & 255;
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "88359010"
   )
   public void method3124(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.field2124.method3157());
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "18"
   )
   public void method3125() {
      super.offset = (7 + this.field2123) / 8;
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-174636788"
   )
   public int method3126(int var1) {
      return var1 * 8 - this.field2123;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class159(int var1) {
      super(var1);
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1900835135"
   )
   public void method3141() {
      this.field2123 = super.offset * 8;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "31"
   )
   public static boolean method3142(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!class215.field3175.method3378(var0)) {
         return false;
      } else {
         int var1 = class215.field3175.method3398(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(null == Widget.widgets[var0]) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == Widget.widgets[var0][var2]) {
                  byte[] var3 = class215.field3175.getConfigData(var0, var2);
                  if(null != var3) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method3262(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method3278(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1006352953"
   )
   static final byte[] method3143(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 >= 0 && (class182.field2722 == 0 || var3 <= class182.field2722)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method2867(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.readInt();
            if(var4 < 0 || class182.field2722 != 0 && var4 > class182.field2722) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var4];
               if(var2 == 1) {
                  class147.method2809(var5, var4, var0, var3, 9);
               } else {
                  class182.field2716.method2782(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }
}
