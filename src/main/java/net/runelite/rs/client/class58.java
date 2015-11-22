package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ba")
public class class58 {
   @ObfuscatedName("l")
   int field1195;
   @ObfuscatedName("m")
   class71[] field1196 = new class71[10];
   @ObfuscatedName("f")
   int field1197;

   class58(class118 var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.method2536();
         if(var3 != 0) {
            --var1.field1981;
            this.field1196[var2] = new class71();
            this.field1196[var2].method1588(var1);
         }
      }

      this.field1197 = var1.method2538();
      this.field1195 = var1.method2538();
   }

   @ObfuscatedName("f")
   public final int method1282() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1196[var2] != null && this.field1196[var2].field1325 / 20 < var1) {
            var1 = this.field1196[var2].field1325 / 20;
         }
      }

      if(this.field1197 < this.field1195 && this.field1197 / 20 < var1) {
         var1 = this.field1197 / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.field1196[var2] != null) {
               this.field1196[var2].field1325 -= var1 * 20;
            }
         }

         if(this.field1197 < this.field1195) {
            this.field1197 -= var1 * 20;
            this.field1195 -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("m")
   public class62 method1283() {
      byte[] var1 = this.method1290();
      return new class62(22050, var1, 22050 * this.field1197 / 1000, 22050 * this.field1195 / 1000);
   }

   @ObfuscatedName("j")
   public static class58 method1285(class166 var0, int var1, int var2) {
      byte[] var3 = var0.method3352(var1, var2);
      return var3 == null?null:new class58(new class118(var3));
   }

   @ObfuscatedName("l")
   final byte[] method1290() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.field1196[var2] != null && this.field1196[var2].field1324 + this.field1196[var2].field1325 > var1) {
            var1 = this.field1196[var2].field1324 + this.field1196[var2].field1325;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.field1196[var4] != null) {
               int var5 = this.field1196[var4].field1324 * 22050 / 1000;
               int var6 = this.field1196[var4].field1325 * 22050 / 1000;
               int[] var7 = this.field1196[var4].method1583(var5, this.field1196[var4].field1324);

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
