import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("by")
public class class58 {
   @ObfuscatedName("r")
   class71[] field1208 = new class71[10];
   @ObfuscatedName("f")
   int field1209;
   @ObfuscatedName("s")
   int field1210;

   class58(class118 var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.method2579();
         if(var3 != 0) {
            --var1.field1979;
            this.field1208[var2] = new class71();
            this.field1208[var2].method1606(var1);
         }
      }

      this.field1209 = var1.method2514();
      this.field1210 = var1.method2514();
   }

   @ObfuscatedName("f")
   public final int method1265() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1208[var2] != null && this.field1208[var2].field1335 / 20 < var1) {
            var1 = this.field1208[var2].field1335 / 20;
         }
      }

      if(this.field1209 < this.field1210 && this.field1209 / 20 < var1) {
         var1 = this.field1209 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field1208[var2] != null) {
               this.field1208[var2].field1335 -= var1 * 20;
            }
         }

         if(this.field1209 < this.field1210) {
            this.field1209 -= var1 * 20;
            this.field1210 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("s")
   final byte[] method1266() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1208[var2] != null && this.field1208[var2].field1336 + this.field1208[var2].field1335 > var1) {
            var1 = this.field1208[var2].field1336 + this.field1208[var2].field1335;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field1208[var4] != null) {
               int var5 = this.field1208[var4].field1336 * 22050 / 1000;
               int var6 = this.field1208[var4].field1335 * 22050 / 1000;
               int[] var7 = this.field1208[var4].method1600(var5, this.field1208[var4].field1336);

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

   @ObfuscatedName("r")
   public class62 method1270() {
      byte[] var1 = this.method1266();
      return new class62(22050, var1, 22050 * this.field1209 / 1000, 22050 * this.field1210 / 1000);
   }

   @ObfuscatedName("a")
   public static class58 method1272(class166 var0, int var1, int var2) {
      byte[] var3 = var0.method3263(var1, var2);
      return var3 == null?null:new class58(new class118(var3));
   }
}
