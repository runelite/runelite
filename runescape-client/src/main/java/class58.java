import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bn")
public class class58 {
   @ObfuscatedName("m")
   int field1193;
   @ObfuscatedName("h")
   class71[] field1194 = new class71[10];
   @ObfuscatedName("z")
   int field1195;

   class58(class119 var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.method2500();
         if(var3 != 0) {
            --var1.field1971;
            this.field1194[var2] = new class71();
            this.field1194[var2].method1559(var1);
         }
      }

      this.field1193 = var1.method2502();
      this.field1195 = var1.method2502();
   }

   @ObfuscatedName("j")
   public static class58 method1237(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3217(var1, var2);
      return var3 == null?null:new class58(new class119(var3));
   }

   @ObfuscatedName("z")
   final byte[] method1238() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1194[var2] != null && this.field1194[var2].field1323 + this.field1194[var2].field1320 > var1) {
            var1 = this.field1194[var2].field1323 + this.field1194[var2].field1320;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field1194[var4] != null) {
               int var5 = this.field1194[var4].field1323 * 22050 / 1000;
               int var6 = this.field1194[var4].field1320 * 22050 / 1000;
               int[] var7 = this.field1194[var4].method1557(var5, this.field1194[var4].field1323);

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

   @ObfuscatedName("m")
   public final int method1245() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1194[var2] != null && this.field1194[var2].field1320 / 20 < var1) {
            var1 = this.field1194[var2].field1320 / 20;
         }
      }

      if(this.field1193 < this.field1195 && this.field1193 / 20 < var1) {
         var1 = this.field1193 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field1194[var2] != null) {
               this.field1194[var2].field1320 -= var1 * 20;
            }
         }

         if(this.field1193 < this.field1195) {
            this.field1193 -= var1 * 20;
            this.field1195 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("h")
   public class62 method1246() {
      byte[] var1 = this.method1238();
      return new class62(22050, var1, 22050 * this.field1193 / 1000, 22050 * this.field1195 / 1000);
   }
}
