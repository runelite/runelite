import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("br")
@Implements("SoundEffect")
public class SoundEffect {
   @ObfuscatedName("q")
   int field973;
   @ObfuscatedName("c")
   SoundEffect1[] field974;
   @ObfuscatedName("n")
   int field975;

   @ObfuscatedName("c")
   public class55 method991() {
      byte[] var1 = this.method997();
      return new class55(22050, var1, this.field975 * 22050 / 1000, this.field973 * 22050 / 1000);
   }

   SoundEffect(Buffer var1) {
      this.field974 = new SoundEffect1[10];

      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.readUnsignedByte();
         if(var3 != 0) {
            --var1.offset;
            this.field974[var2] = new SoundEffect1();
            this.field974[var2].method1386(var1);
         }
      }

      this.field975 = var1.readUnsignedShort();
      this.field973 = var1.readUnsignedShort();
   }

   @ObfuscatedName("n")
   public final int method992() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field974[var2] != null && this.field974[var2].field1133 / 20 < var1) {
            var1 = this.field974[var2].field1133 / 20;
         }
      }

      if(this.field975 < this.field973 && this.field975 / 20 < var1) {
         var1 = this.field975 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field974[var2] != null) {
               this.field974[var2].field1133 -= var1 * 20;
            }
         }

         if(this.field975 < this.field973) {
            this.field975 -= var1 * 20;
            this.field973 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("d")
   public static SoundEffect method993(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      return var3 == null?null:new SoundEffect(new Buffer(var3));
   }

   @ObfuscatedName("q")
   final byte[] method997() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field974[var2] != null && this.field974[var2].field1145 + this.field974[var2].field1133 > var1) {
            var1 = this.field974[var2].field1145 + this.field974[var2].field1133;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = var1 * 22050 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field974[var4] != null) {
               int var5 = this.field974[var4].field1145 * 22050 / 1000;
               int var6 = this.field974[var4].field1133 * 22050 / 1000;
               int[] var7 = this.field974[var4].method1385(var5, this.field974[var4].field1145);

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
