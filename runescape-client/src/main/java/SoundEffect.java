import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dr")
@Implements("SoundEffect")
public class SoundEffect {
   @ObfuscatedName("c")
   SoundEffect1[] field1582;
   @ObfuscatedName("e")
   int field1584;
   @ObfuscatedName("v")
   int field1585;

   @ObfuscatedName("c")
   public class107 method1933() {
      byte[] var1 = this.method1942();
      return new class107(22050, var1, this.field1584 * 22050 / 1000, this.field1585 * 22050 / 1000);
   }

   @ObfuscatedName("v")
   final byte[] method1942() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1582[var2] != null && this.field1582[var2].field1758 + this.field1582[var2].field1749 > var1) {
            var1 = this.field1582[var2].field1758 + this.field1582[var2].field1749;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = var1 * 22050 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field1582[var4] != null) {
               int var5 = this.field1582[var4].field1758 * 22050 / 1000;
               int var6 = this.field1582[var4].field1749 * 22050 / 1000;
               int[] var7 = this.field1582[var4].method2310(var5, this.field1582[var4].field1758);

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

   SoundEffect(Buffer var1) {
      this.field1582 = new SoundEffect1[10];

      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.readUnsignedByte();
         if(var3 != 0) {
            --var1.offset;
            this.field1582[var2] = new SoundEffect1();
            this.field1582[var2].method2313(var1);
         }
      }

      this.field1584 = var1.readUnsignedShort();
      this.field1585 = var1.readUnsignedShort();
   }

   @ObfuscatedName("i")
   public static SoundEffect method1944(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      return var3 == null?null:new SoundEffect(new Buffer(var3));
   }

   @ObfuscatedName("e")
   public final int method1945() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1582[var2] != null && this.field1582[var2].field1749 / 20 < var1) {
            var1 = this.field1582[var2].field1749 / 20;
         }
      }

      if(this.field1584 < this.field1585 && this.field1584 / 20 < var1) {
         var1 = this.field1584 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field1582[var2] != null) {
               this.field1582[var2].field1749 -= var1 * 20;
            }
         }

         if(this.field1584 < this.field1585) {
            this.field1584 -= var1 * 20;
            this.field1585 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }
}
