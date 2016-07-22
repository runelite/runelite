import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bm")
public class class61 {
   @ObfuscatedName("w")
   class74[] field1281 = new class74[10];
   @ObfuscatedName("e")
   int field1283;
   @ObfuscatedName("o")
   int field1284;

   class61(class122 var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.method2556();
         if(var3 != 0) {
            --var1.field2045;
            this.field1281[var2] = new class74();
            this.field1281[var2].method1655(var1);
         }
      }

      this.field1283 = var1.method2706();
      this.field1284 = var1.method2706();
   }

   @ObfuscatedName("w")
   public class65 method1319() {
      byte[] var1 = this.method1332();
      return new class65(22050, var1, 22050 * this.field1283 / 1000, 22050 * this.field1284 / 1000);
   }

   @ObfuscatedName("e")
   public final int method1320() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1281[var2] != null && this.field1281[var2].field1411 / 20 < var1) {
            var1 = this.field1281[var2].field1411 / 20;
         }
      }

      if(this.field1283 < this.field1284 && this.field1283 / 20 < var1) {
         var1 = this.field1283 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field1281[var2] != null) {
               this.field1281[var2].field1411 -= var1 * 20;
            }
         }

         if(this.field1283 < this.field1284) {
            this.field1283 -= var1 * 20;
            this.field1284 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("m")
   public static class61 method1324(class170 var0, int var1, int var2) {
      byte[] var3 = var0.method3304(var1, var2);
      return var3 == null?null:new class61(new class122(var3));
   }

   @ObfuscatedName("o")
   final byte[] method1332() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1281[var2] != null && this.field1281[var2].field1410 + this.field1281[var2].field1411 > var1) {
            var1 = this.field1281[var2].field1410 + this.field1281[var2].field1411;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field1281[var4] != null) {
               int var5 = this.field1281[var4].field1410 * 22050 / 1000;
               int var6 = this.field1281[var4].field1411 * 22050 / 1000;
               int[] var7 = this.field1281[var4].method1654(var5, this.field1281[var4].field1410);

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
