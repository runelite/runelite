import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dt")
@Implements("SoundEffect")
public class SoundEffect {
   @ObfuscatedName("p")
   SoundEffect1[] field1575;
   @ObfuscatedName("j")
   int field1576;
   @ObfuscatedName("i")
   int field1577;

   SoundEffect(Buffer var1) {
      this.field1575 = new SoundEffect1[10];

      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.readUnsignedByte();
         if(var3 != 0) {
            --var1.offset;
            this.field1575[var2] = new SoundEffect1();
            this.field1575[var2].method2325(var1);
         }
      }

      this.field1577 = var1.readUnsignedShort();
      this.field1576 = var1.readUnsignedShort();
   }

   @ObfuscatedName("p")
   public class107 method1920() {
      byte[] var1 = this.method1932();
      return new class107(22050, var1, this.field1577 * 22050 / 1000, this.field1576 * 22050 / 1000);
   }

   @ObfuscatedName("i")
   public final int method1921() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1575[var2] != null && this.field1575[var2].field1747 / 20 < var1) {
            var1 = this.field1575[var2].field1747 / 20;
         }
      }

      if(this.field1577 < this.field1576 && this.field1577 / 20 < var1) {
         var1 = this.field1577 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field1575[var2] != null) {
               this.field1575[var2].field1747 -= var1 * 20;
            }
         }

         if(this.field1577 < this.field1576) {
            this.field1577 -= var1 * 20;
            this.field1576 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("n")
   public static SoundEffect method1922(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      return var3 == null?null:new SoundEffect(new Buffer(var3));
   }

   @ObfuscatedName("j")
   final byte[] method1932() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1575[var2] != null && this.field1575[var2].field1746 + this.field1575[var2].field1747 > var1) {
            var1 = this.field1575[var2].field1746 + this.field1575[var2].field1747;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = var1 * 22050 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field1575[var4] != null) {
               int var5 = this.field1575[var4].field1746 * 22050 / 1000;
               int var6 = this.field1575[var4].field1747 * 22050 / 1000;
               int[] var7 = this.field1575[var4].method2322(var5, this.field1575[var4].field1746);

               for(int var8 = 0; var8 < var5; ++var8) {
                  int var9 = var3[var8 + var6] + (var7[var8] >> 8);
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
}
