import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bp")
public class class53 {
   @ObfuscatedName("h")
   int field1005;
   @ObfuscatedName("d")
   class70[] field1006 = new class70[10];
   @ObfuscatedName("p")
   int field1008;

   class53(Buffer var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.readUnsignedByte();
         if(var3 != 0) {
            --var1.offset;
            this.field1006[var2] = new class70();
            this.field1006[var2].method1422(var1);
         }
      }

      this.field1005 = var1.readUnsignedShort();
      this.field1008 = var1.readUnsignedShort();
   }

   @ObfuscatedName("q")
   public static class53 method1039(class182 var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      return var3 == null?null:new class53(new Buffer(var3));
   }

   @ObfuscatedName("d")
   public class55 method1040() {
      byte[] var1 = this.method1044();
      return new class55(22050, var1, 22050 * this.field1005 / 1000, 22050 * this.field1008 / 1000);
   }

   @ObfuscatedName("h")
   public final int method1042() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1006[var2] != null && this.field1006[var2].field1171 / 20 < var1) {
            var1 = this.field1006[var2].field1171 / 20;
         }
      }

      if(this.field1005 < this.field1008 && this.field1005 / 20 < var1) {
         var1 = this.field1005 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field1006[var2] != null) {
               this.field1006[var2].field1171 -= var1 * 20;
            }
         }

         if(this.field1005 < this.field1008) {
            this.field1005 -= var1 * 20;
            this.field1008 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("p")
   final byte[] method1044() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1006[var2] != null && this.field1006[var2].field1179 + this.field1006[var2].field1171 > var1) {
            var1 = this.field1006[var2].field1179 + this.field1006[var2].field1171;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field1006[var4] != null) {
               int var5 = this.field1006[var4].field1179 * 22050 / 1000;
               int var6 = this.field1006[var4].field1171 * 22050 / 1000;
               int[] var7 = this.field1006[var4].method1420(var5, this.field1006[var4].field1179);

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
}
