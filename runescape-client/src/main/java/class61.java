import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bx")
public class class61 {
   @ObfuscatedName("t")
   int field1253;
   @ObfuscatedName("z")
   class74[] field1254 = new class74[10];
   @ObfuscatedName("y")
   int field1256;

   class61(Buffer var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.method2481();
         if(var3 != 0) {
            --var1.offset;
            this.field1254[var2] = new class74();
            this.field1254[var2].method1574(var1);
         }
      }

      this.field1253 = var1.method2668();
      this.field1256 = var1.method2668();
   }

   @ObfuscatedName("z")
   public class65 method1245() {
      byte[] var1 = this.method1250();
      return new class65(22050, var1, 22050 * this.field1253 / 1000, 22050 * this.field1256 / 1000);
   }

   @ObfuscatedName("t")
   public final int method1246() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1254[var2] != null && this.field1254[var2].field1379 / 20 < var1) {
            var1 = this.field1254[var2].field1379 / 20;
         }
      }

      if(this.field1253 < this.field1256 && this.field1253 / 20 < var1) {
         var1 = this.field1253 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field1254[var2] != null) {
               this.field1254[var2].field1379 -= var1 * 20;
            }
         }

         if(this.field1253 < this.field1256) {
            this.field1253 -= var1 * 20;
            this.field1256 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("y")
   final byte[] method1250() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1254[var2] != null && this.field1254[var2].field1363 + this.field1254[var2].field1379 > var1) {
            var1 = this.field1254[var2].field1363 + this.field1254[var2].field1379;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field1254[var4] != null) {
               int var5 = this.field1254[var4].field1363 * 22050 / 1000;
               int var6 = this.field1254[var4].field1379 * 22050 / 1000;
               int[] var7 = this.field1254[var4].method1572(var5, this.field1254[var4].field1363);

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

   @ObfuscatedName("s")
   public static class61 method1254(class170 var0, int var1, int var2) {
      byte[] var3 = var0.method3272(var1, var2);
      return var3 == null?null:new class61(new Buffer(var3));
   }
}
