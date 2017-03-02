import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bj")
public class class53 {
   @ObfuscatedName("i")
   int field970;
   @ObfuscatedName("l")
   class70[] field971 = new class70[10];
   @ObfuscatedName("t")
   int field973;

   @ObfuscatedName("b")
   public static class53 method1046(class182 var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      return var3 == null?null:new class53(new Buffer(var3));
   }

   @ObfuscatedName("t")
   final byte[] method1048() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field971[var2] != null && this.field971[var2].field1143 + this.field971[var2].field1148 > var1) {
            var1 = this.field971[var2].field1143 + this.field971[var2].field1148;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field971[var4] != null) {
               int var5 = this.field971[var4].field1143 * 22050 / 1000;
               int var6 = this.field971[var4].field1148 * 22050 / 1000;
               int[] var7 = this.field971[var4].method1420(var5, this.field971[var4].field1143);

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

   @ObfuscatedName("i")
   public final int method1049() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field971[var2] != null && this.field971[var2].field1148 / 20 < var1) {
            var1 = this.field971[var2].field1148 / 20;
         }
      }

      if(this.field970 < this.field973 && this.field970 / 20 < var1) {
         var1 = this.field970 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field971[var2] != null) {
               this.field971[var2].field1148 -= var1 * 20;
            }
         }

         if(this.field970 < this.field973) {
            this.field970 -= var1 * 20;
            this.field973 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("l")
   public class55 method1052() {
      byte[] var1 = this.method1048();
      return new class55(22050, var1, 22050 * this.field970 / 1000, 22050 * this.field973 / 1000);
   }

   class53(Buffer var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.readUnsignedByte();
         if(var3 != 0) {
            --var1.offset;
            this.field971[var2] = new class70();
            this.field971[var2].method1430(var1);
         }
      }

      this.field970 = var1.readUnsignedShort();
      this.field973 = var1.readUnsignedShort();
   }
}
