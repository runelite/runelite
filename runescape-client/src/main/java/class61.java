import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bs")
public class class61 {
   @ObfuscatedName("e")
   int field1263;
   @ObfuscatedName("g")
   int field1265;
   @ObfuscatedName("h")
   class74[] field1266 = new class74[10];

   class61(Buffer var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.method2544();
         if(var3 != 0) {
            --var1.offset;
            this.field1266[var2] = new class74();
            this.field1266[var2].method1601(var1);
         }
      }

      this.field1263 = var1.method2546();
      this.field1265 = var1.method2546();
   }

   @ObfuscatedName("h")
   public class65 method1284() {
      byte[] var1 = this.method1292();
      return new class65(22050, var1, 22050 * this.field1263 / 1000, 22050 * this.field1265 / 1000);
   }

   @ObfuscatedName("e")
   public final int method1285() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1266[var2] != null && this.field1266[var2].field1391 / 20 < var1) {
            var1 = this.field1266[var2].field1391 / 20;
         }
      }

      if(this.field1263 < this.field1265 && this.field1263 / 20 < var1) {
         var1 = this.field1263 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field1266[var2] != null) {
               this.field1266[var2].field1391 -= var1 * 20;
            }
         }

         if(this.field1263 < this.field1265) {
            this.field1263 -= var1 * 20;
            this.field1265 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("g")
   final byte[] method1292() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1266[var2] != null && this.field1266[var2].field1390 + this.field1266[var2].field1391 > var1) {
            var1 = this.field1266[var2].field1390 + this.field1266[var2].field1391;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field1266[var4] != null) {
               int var5 = this.field1266[var4].field1390 * 22050 / 1000;
               int var6 = this.field1266[var4].field1391 * 22050 / 1000;
               int[] var7 = this.field1266[var4].method1598(var5, this.field1266[var4].field1390);

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

   @ObfuscatedName("i")
   public static class61 method1293(class170 var0, int var1, int var2) {
      byte[] var3 = var0.method3292(var1, var2);
      return var3 == null?null:new class61(new Buffer(var3));
   }
}
