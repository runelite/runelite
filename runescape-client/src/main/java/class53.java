import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bd")
public class class53 {
   @ObfuscatedName("g")
   int field983;
   @ObfuscatedName("m")
   class70[] field984 = new class70[10];
   @ObfuscatedName("b")
   int field985;

   class53(Buffer var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.readUnsignedByte();
         if(var3 != 0) {
            --var1.offset;
            this.field984[var2] = new class70();
            this.field984[var2].method1346(var1);
         }
      }

      this.field985 = var1.readUnsignedShort();
      this.field983 = var1.readUnsignedShort();
   }

   @ObfuscatedName("m")
   public class55 method944() {
      byte[] var1 = this.method946();
      return new class55(22050, var1, 22050 * this.field985 / 1000, 22050 * this.field983 / 1000);
   }

   @ObfuscatedName("g")
   final byte[] method946() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field984[var2] != null && this.field984[var2].field1166 + this.field984[var2].field1167 > var1) {
            var1 = this.field984[var2].field1166 + this.field984[var2].field1167;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field984[var4] != null) {
               int var5 = this.field984[var4].field1166 * 22050 / 1000;
               int var6 = this.field984[var4].field1167 * 22050 / 1000;
               int[] var7 = this.field984[var4].method1344(var5, this.field984[var4].field1166);

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

   @ObfuscatedName("b")
   public final int method954() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field984[var2] != null && this.field984[var2].field1167 / 20 < var1) {
            var1 = this.field984[var2].field1167 / 20;
         }
      }

      if(this.field985 < this.field983 && this.field985 / 20 < var1) {
         var1 = this.field985 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field984[var2] != null) {
               this.field984[var2].field1167 -= var1 * 20;
            }
         }

         if(this.field985 < this.field983) {
            this.field985 -= var1 * 20;
            this.field983 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("o")
   public static class53 method955(class182 var0, int var1, int var2) {
      byte[] var3 = var0.method3203(var1, var2);
      return var3 == null?null:new class53(new Buffer(var3));
   }
}
