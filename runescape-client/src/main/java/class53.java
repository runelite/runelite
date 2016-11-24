import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bt")
public class class53 {
   @ObfuscatedName("m")
   int field975;
   @ObfuscatedName("d")
   class70[] field976 = new class70[10];
   @ObfuscatedName("h")
   int field978;

   @ObfuscatedName("d")
   public class55 method969() {
      byte[] var1 = this.method971();
      return new class55(22050, var1, 22050 * this.field975 / 1000, 22050 * this.field978 / 1000);
   }

   @ObfuscatedName("m")
   public final int method970() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field976[var2] != null && this.field976[var2].field1160 / 20 < var1) {
            var1 = this.field976[var2].field1160 / 20;
         }
      }

      if(this.field975 < this.field978 && this.field975 / 20 < var1) {
         var1 = this.field975 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field976[var2] != null) {
               this.field976[var2].field1160 -= var1 * 20;
            }
         }

         if(this.field975 < this.field978) {
            this.field975 -= var1 * 20;
            this.field978 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("h")
   final byte[] method971() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field976[var2] != null && this.field976[var2].field1156 + this.field976[var2].field1160 > var1) {
            var1 = this.field976[var2].field1156 + this.field976[var2].field1160;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field976[var4] != null) {
               int var5 = this.field976[var4].field1156 * 22050 / 1000;
               int var6 = this.field976[var4].field1160 * 22050 / 1000;
               int[] var7 = this.field976[var4].method1395(var5, this.field976[var4].field1156);

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

   @ObfuscatedName("n")
   public static class53 method975(class182 var0, int var1, int var2) {
      byte[] var3 = var0.method3329(var1, var2);
      return var3 == null?null:new class53(new Buffer(var3));
   }

   class53(Buffer var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.method3033();
         if(var3 != 0) {
            --var1.offset;
            this.field976[var2] = new class70();
            this.field976[var2].method1397(var1);
         }
      }

      this.field975 = var1.method3097();
      this.field978 = var1.method3097();
   }
}
