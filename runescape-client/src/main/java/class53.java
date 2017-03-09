import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bd")
public class class53 {
   @ObfuscatedName("c")
   int field995;
   @ObfuscatedName("j")
   class70[] field996 = new class70[10];
   @ObfuscatedName("d")
   int field998;

   @ObfuscatedName("j")
   public class55 method1051() {
      byte[] var1 = this.method1054();
      return new class55(22050, var1, 22050 * this.field995 / 1000, 22050 * this.field998 / 1000);
   }

   class53(Buffer var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.readUnsignedByte();
         if(var3 != 0) {
            --var1.offset;
            this.field996[var2] = new class70();
            this.field996[var2].method1437(var1);
         }
      }

      this.field995 = var1.readUnsignedShort();
      this.field998 = var1.readUnsignedShort();
   }

   @ObfuscatedName("c")
   public final int method1052() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field996[var2] != null && this.field996[var2].field1171 / 20 < var1) {
            var1 = this.field996[var2].field1171 / 20;
         }
      }

      if(this.field995 < this.field998 && this.field995 / 20 < var1) {
         var1 = this.field995 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field996[var2] != null) {
               this.field996[var2].field1171 -= var1 * 20;
            }
         }

         if(this.field995 < this.field998) {
            this.field995 -= var1 * 20;
            this.field998 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("d")
   final byte[] method1054() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field996[var2] != null && this.field996[var2].field1173 + this.field996[var2].field1171 > var1) {
            var1 = this.field996[var2].field1173 + this.field996[var2].field1171;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field996[var4] != null) {
               int var5 = this.field996[var4].field1173 * 22050 / 1000;
               int var6 = this.field996[var4].field1171 * 22050 / 1000;
               int[] var7 = this.field996[var4].method1434(var5, this.field996[var4].field1173);

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
   public static class53 method1060(class182 var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      return var3 == null?null:new class53(new Buffer(var3));
   }
}
