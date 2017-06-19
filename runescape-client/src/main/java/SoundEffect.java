import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("du")
@Implements("SoundEffect")
public class SoundEffect {
   @ObfuscatedName("t")
   @Export("end")
   int end;
   @ObfuscatedName("m")
   @Export("instruments")
   AudioInstrument[] instruments;
   @ObfuscatedName("e")
   @Export("start")
   int start;

   @ObfuscatedName("t")
   final byte[] method1837() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.instruments[var2] != null && this.instruments[var2].field1726 + this.instruments[var2].field1732 > var1) {
            var1 = this.instruments[var2].field1726 + this.instruments[var2].field1732;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = var1 * 22050 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.instruments[var4] != null) {
               int var5 = this.instruments[var4].field1726 * 22050 / 1000;
               int var6 = this.instruments[var4].field1732 * 22050 / 1000;
               int[] var7 = this.instruments[var4].method2223(var5, this.instruments[var4].field1726);

               for(int var8 = 0; var8 < var5; ++var8) {
                  int var9 = (var7[var8] >> 8) + var3[var8 + var6];
                  if((var9 + 128 & -256) != 0) {
                     var9 = var9 >> 31 ^ 127;
                  }

                  var3[var8 + var6] = (byte)var9;
               }
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("e")
   public final int method1838() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.instruments[var2] != null && this.instruments[var2].field1732 / 20 < var1) {
            var1 = this.instruments[var2].field1732 / 20;
         }
      }

      if(this.start < this.end && this.start / 20 < var1) {
         var1 = this.start / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.instruments[var2] != null) {
               this.instruments[var2].field1732 -= var1 * 20;
            }
         }

         if(this.start < this.end) {
            this.start -= var1 * 20;
            this.end -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("m")
   public class107 method1839() {
      byte[] var1 = this.method1837();
      return new class107(22050, var1, this.start * 22050 / 1000, this.end * 22050 / 1000);
   }

   SoundEffect(Buffer var1) {
      this.instruments = new AudioInstrument[10];

      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.readUnsignedByte();
         if(var3 != 0) {
            --var1.offset;
            this.instruments[var2] = new AudioInstrument();
            this.instruments[var2].method2225(var1);
         }
      }

      this.start = var1.readUnsignedShort();
      this.end = var1.readUnsignedShort();
   }

   @ObfuscatedName("p")
   public static SoundEffect method1843(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      return var3 == null?null:new SoundEffect(new Buffer(var3));
   }
}
