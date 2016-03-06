package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("br")
public class class58 {
   @ObfuscatedName("a")
   int field1216;
   @ObfuscatedName("l")
   class71[] field1217 = new class71[10];
   @ObfuscatedName("i")
   int field1219;

   class58(class118 var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.method2453();
         if(var3 != 0) {
            --var1.field1998;
            this.field1217[var2] = new class71();
            this.field1217[var2].method1557(var1);
         }
      }

      this.field1216 = var1.method2455();
      this.field1219 = var1.method2455();
   }

   @ObfuscatedName("i")
   final byte[] method1241() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1217[var2] != null && this.field1217[var2].field1344 + this.field1217[var2].field1350 > var1) {
            var1 = this.field1217[var2].field1344 + this.field1217[var2].field1350;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field1217[var4] != null) {
               int var5 = this.field1217[var4].field1344 * 22050 / 1000;
               int var6 = this.field1217[var4].field1350 * 22050 / 1000;
               int[] var7 = this.field1217[var4].method1555(var5, this.field1217[var4].field1344);

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

   @ObfuscatedName("a")
   public final int method1242() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1217[var2] != null && this.field1217[var2].field1350 / 20 < var1) {
            var1 = this.field1217[var2].field1350 / 20;
         }
      }

      if(this.field1216 < this.field1219 && this.field1216 / 20 < var1) {
         var1 = this.field1216 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field1217[var2] != null) {
               this.field1217[var2].field1350 -= var1 * 20;
            }
         }

         if(this.field1216 < this.field1219) {
            this.field1216 -= var1 * 20;
            this.field1219 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("j")
   public static class58 method1247(class166 var0, int var1, int var2) {
      byte[] var3 = var0.method3214(var1, var2);
      return var3 == null?null:new class58(new class118(var3));
   }

   @ObfuscatedName("l")
   public class62 method1252() {
      byte[] var1 = this.method1241();
      return new class62(22050, var1, 22050 * this.field1216 / 1000, 22050 * this.field1219 / 1000);
   }
}
