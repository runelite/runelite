import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bh")
@Implements("SoundEffect")
public class SoundEffect {
   @ObfuscatedName("u")
   int field1006;
   @ObfuscatedName("i")
   SoundEffect1[] field1008 = new SoundEffect1[10];
   @ObfuscatedName("h")
   int field1009;

   SoundEffect(Buffer var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.readUnsignedByte();
         if(var3 != 0) {
            --var1.offset;
            this.field1008[var2] = new SoundEffect1();
            this.field1008[var2].method1408(var1);
         }
      }

      this.field1006 = var1.readUnsignedShort();
      this.field1009 = var1.readUnsignedShort();
   }

   @ObfuscatedName("u")
   public final int method1003() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1008[var2] != null && this.field1008[var2].field1188 / 20 < var1) {
            var1 = this.field1008[var2].field1188 / 20;
         }
      }

      if(this.field1006 < this.field1009 && this.field1006 / 20 < var1) {
         var1 = this.field1006 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field1008[var2] != null) {
               this.field1008[var2].field1188 -= var1 * 20;
            }
         }

         if(this.field1006 < this.field1009) {
            this.field1006 -= var1 * 20;
            this.field1009 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("r")
   final byte[] method1007() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1008[var2] != null && this.field1008[var2].field1176 + this.field1008[var2].field1188 > var1) {
            var1 = this.field1008[var2].field1176 + this.field1008[var2].field1188;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = var1 * 22050 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field1008[var4] != null) {
               int var5 = this.field1008[var4].field1176 * 22050 / 1000;
               int var6 = this.field1008[var4].field1188 * 22050 / 1000;
               int[] var7 = this.field1008[var4].method1402(var5, this.field1008[var4].field1176);

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
   public class55 method1008() {
      byte[] var1 = this.method1007();
      return new class55(22050, var1, this.field1006 * 22050 / 1000, this.field1009 * 22050 / 1000);
   }

   @ObfuscatedName("f")
   public static SoundEffect method1013(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      return var3 == null?null:new SoundEffect(new Buffer(var3));
   }
}
