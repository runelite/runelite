import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bm")
public class class53 {
   @ObfuscatedName("y")
   class70[] field986 = new class70[10];
   @ObfuscatedName("r")
   int field987;
   @ObfuscatedName("o")
   int field988;

   @ObfuscatedName("y")
   public class55 method980() {
      byte[] var1 = this.method981();
      return new class55(22050, var1, 22050 * this.field988 / 1000, 22050 * this.field987 / 1000);
   }

   class53(Buffer var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.readUnsignedByte();
         if(var3 != 0) {
            --var1.offset;
            this.field986[var2] = new class70();
            this.field986[var2].method1378(var1);
         }
      }

      this.field988 = var1.readUnsignedShort();
      this.field987 = var1.readUnsignedShort();
   }

   @ObfuscatedName("r")
   final byte[] method981() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field986[var2] != null && this.field986[var2].field1174 + this.field986[var2].field1171 > var1) {
            var1 = this.field986[var2].field1174 + this.field986[var2].field1171;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field986[var4] != null) {
               int var5 = this.field986[var4].field1174 * 22050 / 1000;
               int var6 = this.field986[var4].field1171 * 22050 / 1000;
               int[] var7 = this.field986[var4].method1384(var5, this.field986[var4].field1174);

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

   @ObfuscatedName("o")
   public final int method982() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field986[var2] != null && this.field986[var2].field1171 / 20 < var1) {
            var1 = this.field986[var2].field1171 / 20;
         }
      }

      if(this.field988 < this.field987 && this.field988 / 20 < var1) {
         var1 = this.field988 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field986[var2] != null) {
               this.field986[var2].field1171 -= var1 * 20;
            }
         }

         if(this.field988 < this.field987) {
            this.field988 -= var1 * 20;
            this.field987 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("k")
   public static class53 method986(class182 var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      return var3 == null?null:new class53(new Buffer(var3));
   }
}
