package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bi")
public class class59 {
   @ObfuscatedName("f")
   class195 field1201 = new class195(256);
   @ObfuscatedName("l")
   class195 field1202 = new class195(256);
   @ObfuscatedName("m")
   class166 field1208;
   @ObfuscatedName("j")
   class166 field1209;

   @ObfuscatedName("l")
   public class62 method1293(int var1, int[] var2) {
      if(this.field1208.method3361() == 1) {
         return this.method1295(0, var1, var2);
      } else if(this.field1208.method3322(var1) == 1) {
         return this.method1295(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("j")
   class62 method1294(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class62 var7 = (class62)this.field1202.method3836(var5);
      if(null != var7) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class58 var8 = class58.method1285(this.field1209, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1283();
            this.field1202.method3839(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1219.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("m")
   class62 method1295(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class62 var7 = (class62)this.field1202.method3836(var5);
      if(null != var7) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class70 var8 = (class70)this.field1201.method3836(var5);
         if(var8 == null) {
            var8 = class70.method1560(this.field1208, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1201.method3839(var8, var5);
         }

         var7 = var8.method1577(var3);
         if(null == var7) {
            return null;
         } else {
            var8.method3965();
            this.field1202.method3839(var7, var5);
            return var7;
         }
      }
   }

   public class59(class166 var1, class166 var2) {
      this.field1209 = var1;
      this.field1208 = var2;
   }

   @ObfuscatedName("f")
   public class62 method1306(int var1, int[] var2) {
      if(this.field1209.method3361() == 1) {
         return this.method1294(0, var1, var2);
      } else if(this.field1209.method3322(var1) == 1) {
         return this.method1294(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("qa")
   protected static final void method1308() {
      class45.field1026.vmethod3155();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         class143.field2182[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         class143.field2183[var0] = 0L;
      }

      class102.field1751 = 0;
   }
}
