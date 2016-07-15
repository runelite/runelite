import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bh")
public class class61 {
   @ObfuscatedName("h")
   int field1276;
   @ObfuscatedName("l")
   class74[] field1277 = new class74[10];
   @ObfuscatedName("c")
   int field1278;

   class61(class122 var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.method2610();
         if(var3 != 0) {
            --var1.field2061;
            this.field1277[var2] = new class74();
            this.field1277[var2].method1658(var1);
         }
      }

      this.field1278 = var1.method2612();
      this.field1276 = var1.method2612();
   }

   @ObfuscatedName("l")
   public class65 method1342() {
      byte[] var1 = this.method1344();
      return new class65(22050, var1, 22050 * this.field1278 / 1000, 22050 * this.field1276 / 1000);
   }

   @ObfuscatedName("c")
   public final int method1343() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1277[var2] != null && this.field1277[var2].field1407 / 20 < var1) {
            var1 = this.field1277[var2].field1407 / 20;
         }
      }

      if(this.field1278 < this.field1276 && this.field1278 / 20 < var1) {
         var1 = this.field1278 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field1277[var2] != null) {
               this.field1277[var2].field1407 -= var1 * 20;
            }
         }

         if(this.field1278 < this.field1276) {
            this.field1278 -= var1 * 20;
            this.field1276 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("h")
   final byte[] method1344() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1277[var2] != null && this.field1277[var2].field1409 + this.field1277[var2].field1407 > var1) {
            var1 = this.field1277[var2].field1409 + this.field1277[var2].field1407;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field1277[var4] != null) {
               int var5 = this.field1277[var4].field1409 * 22050 / 1000;
               int var6 = this.field1277[var4].field1407 * 22050 / 1000;
               int[] var7 = this.field1277[var4].method1652(var5, this.field1277[var4].field1409);

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

   @ObfuscatedName("e")
   public static class61 method1356(class170 var0, int var1, int var2) {
      byte[] var3 = var0.method3340(var1, var2);
      return var3 == null?null:new class61(new class122(var3));
   }
}
