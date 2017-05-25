import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dr")
@Implements("SoundEffect")
public class SoundEffect {
   @ObfuscatedName("u")
   int field1563;
   @ObfuscatedName("h")
   SoundEffect1[] field1564;
   @ObfuscatedName("q")
   int field1566;

   SoundEffect(Buffer var1) {
      this.field1564 = new SoundEffect1[10];

      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.readUnsignedByte();
         if(var3 != 0) {
            --var1.offset;
            this.field1564[var2] = new SoundEffect1();
            this.field1564[var2].method2345(var1);
         }
      }

      this.field1563 = var1.readUnsignedShort();
      this.field1566 = var1.readUnsignedShort();
   }

   @ObfuscatedName("u")
   public final int method1963() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1564[var2] != null && this.field1564[var2].field1727 / 20 < var1) {
            var1 = this.field1564[var2].field1727 / 20;
         }
      }

      if(this.field1563 < this.field1566 && this.field1563 / 20 < var1) {
         var1 = this.field1563 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field1564[var2] != null) {
               this.field1564[var2].field1727 -= var1 * 20;
            }
         }

         if(this.field1563 < this.field1566) {
            this.field1563 -= var1 * 20;
            this.field1566 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("q")
   final byte[] method1964() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1564[var2] != null && this.field1564[var2].field1721 + this.field1564[var2].field1727 > var1) {
            var1 = this.field1564[var2].field1721 + this.field1564[var2].field1727;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = var1 * 22050 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field1564[var4] != null) {
               int var5 = this.field1564[var4].field1721 * 22050 / 1000;
               int var6 = this.field1564[var4].field1727 * 22050 / 1000;
               int[] var7 = this.field1564[var4].method2344(var5, this.field1564[var4].field1721);

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

   @ObfuscatedName("h")
   public class107 method1966() {
      byte[] var1 = this.method1964();
      return new class107(22050, var1, this.field1563 * 22050 / 1000, this.field1566 * 22050 / 1000);
   }

   @ObfuscatedName("i")
   public static SoundEffect method1970(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      return var3 == null?null:new SoundEffect(new Buffer(var3));
   }
}
