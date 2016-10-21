import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bw")
public class class61 {
   @ObfuscatedName("e")
   class74[] field1255 = new class74[10];
   @ObfuscatedName("t")
   int field1256;
   @ObfuscatedName("n")
   int field1257;

   @ObfuscatedName("n")
   public final int method1287() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1255[var2] != null && this.field1255[var2].field1384 / 20 < var1) {
            var1 = this.field1255[var2].field1384 / 20;
         }
      }

      if(this.field1257 < this.field1256 && this.field1257 / 20 < var1) {
         var1 = this.field1257 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field1255[var2] != null) {
               this.field1255[var2].field1384 -= var1 * 20;
            }
         }

         if(this.field1257 < this.field1256) {
            this.field1257 -= var1 * 20;
            this.field1256 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   class61(Buffer var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.method2656();
         if(var3 != 0) {
            --var1.offset;
            this.field1255[var2] = new class74();
            this.field1255[var2].method1618(var1);
         }
      }

      this.field1257 = var1.method2535();
      this.field1256 = var1.method2535();
   }

   @ObfuscatedName("e")
   public class65 method1288() {
      byte[] var1 = this.method1290();
      return new class65(22050, var1, 22050 * this.field1257 / 1000, 22050 * this.field1256 / 1000);
   }

   @ObfuscatedName("t")
   final byte[] method1290() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1255[var2] != null && this.field1255[var2].field1371 + this.field1255[var2].field1384 > var1) {
            var1 = this.field1255[var2].field1371 + this.field1255[var2].field1384;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field1255[var4] != null) {
               int var5 = this.field1255[var4].field1371 * 22050 / 1000;
               int var6 = this.field1255[var4].field1384 * 22050 / 1000;
               int[] var7 = this.field1255[var4].method1616(var5, this.field1255[var4].field1371);

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
   public static class61 method1299(class170 var0, int var1, int var2) {
      byte[] var3 = var0.method3304(var1, var2);
      return var3 == null?null:new class61(new Buffer(var3));
   }
}
