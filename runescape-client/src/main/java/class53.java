import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bv")
public class class53 {
   @ObfuscatedName("x")
   class70[] field977 = new class70[10];
   @ObfuscatedName("i")
   int field978;
   @ObfuscatedName("a")
   int field979;

   @ObfuscatedName("i")
   public final int method950() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field977[var2] != null && this.field977[var2].field1157 / 20 < var1) {
            var1 = this.field977[var2].field1157 / 20;
         }
      }

      if(this.field978 < this.field979 && this.field978 / 20 < var1) {
         var1 = this.field978 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field977[var2] != null) {
               this.field977[var2].field1157 -= var1 * 20;
            }
         }

         if(this.field978 < this.field979) {
            this.field978 -= var1 * 20;
            this.field979 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("a")
   final byte[] method951() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field977[var2] != null && this.field977[var2].field1156 + this.field977[var2].field1157 > var1) {
            var1 = this.field977[var2].field1156 + this.field977[var2].field1157;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field977[var4] != null) {
               int var5 = this.field977[var4].field1156 * 22050 / 1000;
               int var6 = this.field977[var4].field1157 * 22050 / 1000;
               int[] var7 = this.field977[var4].method1325(var5, this.field977[var4].field1156);

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

   class53(Buffer var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.readUnsignedByte();
         if(var3 != 0) {
            --var1.offset;
            this.field977[var2] = new class70();
            this.field977[var2].method1327(var1);
         }
      }

      this.field978 = var1.readUnsignedShort();
      this.field979 = var1.readUnsignedShort();
   }

   @ObfuscatedName("x")
   public class55 method953() {
      byte[] var1 = this.method951();
      return new class55(22050, var1, 22050 * this.field978 / 1000, 22050 * this.field979 / 1000);
   }

   @ObfuscatedName("u")
   public static class53 method955(class182 var0, int var1, int var2) {
      byte[] var3 = var0.method3272(var1, var2);
      return var3 == null?null:new class53(new Buffer(var3));
   }
}
