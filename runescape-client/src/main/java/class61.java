import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("by")
public class class61 {
   @ObfuscatedName("g")
   class74[] field1280 = new class74[10];
   @ObfuscatedName("r")
   int field1282;
   @ObfuscatedName("e")
   int field1283;

   class61(Buffer var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.method2633();
         if(var3 != 0) {
            --var1.offset;
            this.field1280[var2] = new class74();
            this.field1280[var2].method1676(var1);
         }
      }

      this.field1282 = var1.method2635();
      this.field1283 = var1.method2635();
   }

   @ObfuscatedName("g")
   public class65 method1369() {
      byte[] var1 = this.method1371();
      return new class65(22050, var1, 22050 * this.field1282 / 1000, 22050 * this.field1283 / 1000);
   }

   @ObfuscatedName("r")
   public final int method1370() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1280[var2] != null && this.field1280[var2].field1408 / 20 < var1) {
            var1 = this.field1280[var2].field1408 / 20;
         }
      }

      if(this.field1282 < this.field1283 && this.field1282 / 20 < var1) {
         var1 = this.field1282 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field1280[var2] != null) {
               this.field1280[var2].field1408 -= var1 * 20;
            }
         }

         if(this.field1282 < this.field1283) {
            this.field1282 -= var1 * 20;
            this.field1283 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("e")
   final byte[] method1371() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1280[var2] != null && this.field1280[var2].field1407 + this.field1280[var2].field1408 > var1) {
            var1 = this.field1280[var2].field1407 + this.field1280[var2].field1408;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field1280[var4] != null) {
               int var5 = this.field1280[var4].field1407 * 22050 / 1000;
               int var6 = this.field1280[var4].field1408 * 22050 / 1000;
               int[] var7 = this.field1280[var4].method1680(var5, this.field1280[var4].field1407);

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

   @ObfuscatedName("l")
   public static class61 method1380(class170 var0, int var1, int var2) {
      byte[] var3 = var0.method3411(var1, var2);
      return var3 == null?null:new class61(new Buffer(var3));
   }
}
