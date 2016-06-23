import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ba")
public class class58 {
   @ObfuscatedName("u")
   class71[] field1221 = new class71[10];
   @ObfuscatedName("b")
   int field1222;
   @ObfuscatedName("x")
   int field1223;

   class58(class119 var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.method2554();
         if(var3 != 0) {
            --var1.field1998;
            this.field1221[var2] = new class71();
            this.field1221[var2].method1623(var1);
         }
      }

      this.field1223 = var1.method2556();
      this.field1222 = var1.method2556();
   }

   @ObfuscatedName("u")
   public class62 method1308() {
      byte[] var1 = this.method1310();
      return new class62(22050, var1, 22050 * this.field1223 / 1000, 22050 * this.field1222 / 1000);
   }

   @ObfuscatedName("x")
   public final int method1309() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1221[var2] != null && this.field1221[var2].field1353 / 20 < var1) {
            var1 = this.field1221[var2].field1353 / 20;
         }
      }

      if(this.field1223 < this.field1222 && this.field1223 / 20 < var1) {
         var1 = this.field1223 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field1221[var2] != null) {
               this.field1221[var2].field1353 -= var1 * 20;
            }
         }

         if(this.field1223 < this.field1222) {
            this.field1223 -= var1 * 20;
            this.field1222 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("b")
   final byte[] method1310() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1221[var2] != null && this.field1221[var2].field1357 + this.field1221[var2].field1353 > var1) {
            var1 = this.field1221[var2].field1357 + this.field1221[var2].field1353;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field1221[var4] != null) {
               int var5 = this.field1221[var4].field1357 * 22050 / 1000;
               int var6 = this.field1221[var4].field1353 * 22050 / 1000;
               int[] var7 = this.field1221[var4].method1630(var5, this.field1221[var4].field1357);

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

   @ObfuscatedName("f")
   public static class58 method1314(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3286(var1, var2);
      return var3 == null?null:new class58(new class119(var3));
   }
}
