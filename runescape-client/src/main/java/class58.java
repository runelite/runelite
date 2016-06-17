import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bp")
public class class58 {
   @ObfuscatedName("g")
   class71[] field1180 = new class71[10];
   @ObfuscatedName("j")
   int field1181;
   @ObfuscatedName("d")
   int field1183;

   class58(class119 var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.method2514();
         if(var3 != 0) {
            --var1.field1976;
            this.field1180[var2] = new class71();
            this.field1180[var2].method1592(var1);
         }
      }

      this.field1181 = var1.method2516();
      this.field1183 = var1.method2516();
   }

   @ObfuscatedName("d")
   final byte[] method1249() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1180[var2] != null && this.field1180[var2].field1307 + this.field1180[var2].field1310 > var1) {
            var1 = this.field1180[var2].field1307 + this.field1180[var2].field1310;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field1180[var4] != null) {
               int var5 = this.field1180[var4].field1307 * 22050 / 1000;
               int var6 = this.field1180[var4].field1310 * 22050 / 1000;
               int[] var7 = this.field1180[var4].method1586(var5, this.field1180[var4].field1307);

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

   @ObfuscatedName("j")
   public final int method1250() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1180[var2] != null && this.field1180[var2].field1310 / 20 < var1) {
            var1 = this.field1180[var2].field1310 / 20;
         }
      }

      if(this.field1181 < this.field1183 && this.field1181 / 20 < var1) {
         var1 = this.field1181 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field1180[var2] != null) {
               this.field1180[var2].field1310 -= var1 * 20;
            }
         }

         if(this.field1181 < this.field1183) {
            this.field1181 -= var1 * 20;
            this.field1183 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("b")
   public static class58 method1251(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3266(var1, var2);
      return var3 == null?null:new class58(new class119(var3));
   }

   @ObfuscatedName("g")
   public class62 method1257() {
      byte[] var1 = this.method1249();
      return new class62(22050, var1, 22050 * this.field1181 / 1000, 22050 * this.field1183 / 1000);
   }
}
