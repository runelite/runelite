import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bw")
public class class53 {
   @ObfuscatedName("c")
   class70[] field981 = new class70[10];
   @ObfuscatedName("f")
   int field982;
   @ObfuscatedName("h")
   int field983;

   @ObfuscatedName("c")
   public class55 method918() {
      byte[] var1 = this.method920();
      return new class55(22050, var1, 22050 * this.field982 / 1000, 22050 * this.field983 / 1000);
   }

   @ObfuscatedName("f")
   public final int method919() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field981[var2] != null && this.field981[var2].field1150 / 20 < var1) {
            var1 = this.field981[var2].field1150 / 20;
         }
      }

      if(this.field982 < this.field983 && this.field982 / 20 < var1) {
         var1 = this.field982 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field981[var2] != null) {
               this.field981[var2].field1150 -= var1 * 20;
            }
         }

         if(this.field982 < this.field983) {
            this.field982 -= var1 * 20;
            this.field983 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("g")
   final byte[] method920() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field981[var2] != null && this.field981[var2].field1162 + this.field981[var2].field1150 > var1) {
            var1 = this.field981[var2].field1162 + this.field981[var2].field1150;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field981[var4] != null) {
               int var5 = this.field981[var4].field1162 * 22050 / 1000;
               int var6 = this.field981[var4].field1150 * 22050 / 1000;
               int[] var7 = this.field981[var4].method1335(var5, this.field981[var4].field1162);

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
            this.field981[var2] = new class70();
            this.field981[var2].method1334(var1);
         }
      }

      this.field982 = var1.readUnsignedShort();
      this.field983 = var1.readUnsignedShort();
   }

   @ObfuscatedName("s")
   public static class53 method921(class182 var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      return var3 == null?null:new class53(new Buffer(var3));
   }
}
