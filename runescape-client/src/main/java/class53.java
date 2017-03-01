import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bf")
public class class53 {
   @ObfuscatedName("n")
   class70[] field995 = new class70[10];
   @ObfuscatedName("g")
   int field997;
   @ObfuscatedName("v")
   int field998;

   class53(Buffer var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.readUnsignedByte();
         if(var3 != 0) {
            --var1.offset;
            this.field995[var2] = new class70();
            this.field995[var2].method1455(var1);
         }
      }

      this.field997 = var1.readUnsignedShort();
      this.field998 = var1.readUnsignedShort();
   }

   @ObfuscatedName("n")
   public class55 method1058() {
      byte[] var1 = this.method1062();
      return new class55(22050, var1, 22050 * this.field997 / 1000, 22050 * this.field998 / 1000);
   }

   @ObfuscatedName("g")
   public final int method1059() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field995[var2] != null && this.field995[var2].field1180 / 20 < var1) {
            var1 = this.field995[var2].field1180 / 20;
         }
      }

      if(this.field997 < this.field998 && this.field997 / 20 < var1) {
         var1 = this.field997 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field995[var2] != null) {
               this.field995[var2].field1180 -= var1 * 20;
            }
         }

         if(this.field997 < this.field998) {
            this.field997 -= var1 * 20;
            this.field998 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("v")
   final byte[] method1062() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field995[var2] != null && this.field995[var2].field1179 + this.field995[var2].field1180 > var1) {
            var1 = this.field995[var2].field1179 + this.field995[var2].field1180;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field995[var4] != null) {
               int var5 = this.field995[var4].field1179 * 22050 / 1000;
               int var6 = this.field995[var4].field1180 * 22050 / 1000;
               int[] var7 = this.field995[var4].method1453(var5, this.field995[var4].field1179);

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

   @ObfuscatedName("x")
   public static class53 method1064(class182 var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      return var3 == null?null:new class53(new Buffer(var3));
   }
}
