import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public class class59 {
   @ObfuscatedName("db")
   static int[] field1184;
   @ObfuscatedName("b")
   class167 field1185;
   @ObfuscatedName("j")
   class196 field1186 = new class196(256);
   @ObfuscatedName("d")
   class196 field1187 = new class196(256);
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = 99665473
   )
   @Export("cameraZ")
   static int field1188;
   @ObfuscatedName("g")
   class167 field1189;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II[IB)Lclass62;",
      garbageValue = "-42"
   )
   class62 method1263(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class62 var7 = (class62)this.field1187.method3807(var5);
      if(var7 != null) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class70 var8 = (class70)this.field1186.method3807(var5);
         if(var8 == null) {
            var8 = class70.method1552(this.field1189, var1, var2);
            if(null == var8) {
               return null;
            }

            this.field1186.method3797(var8, var5);
         }

         var7 = var8.method1553(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.method3916();
            this.field1187.method3797(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass62;",
      garbageValue = "764411825"
   )
   public class62 method1265(int var1, int[] var2) {
      if(this.field1189.method3277() == 1) {
         return this.method1263(0, var1, var2);
      } else if(this.field1189.method3276(var1) == 1) {
         return this.method1263(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II[IB)Lclass62;",
      garbageValue = "-66"
   )
   class62 method1269(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class62 var7 = (class62)this.field1187.method3807(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class58 var8 = class58.method1251(this.field1185, var1, var2);
         if(null == var8) {
            return null;
         } else {
            var7 = var8.method1257();
            this.field1187.method3797(var7, var5);
            if(null != var3) {
               var3[0] -= var7.field1198.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-2099288148"
   )
   static final int method1271(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = var2 / 2 + (var0 / 4 << 10) + (var1 / 32 << 7);
      return var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass62;",
      garbageValue = "-2113024885"
   )
   public class62 method1275(int var1, int[] var2) {
      if(this.field1185.method3277() == 1) {
         return this.method1269(0, var1, var2);
      } else if(this.field1185.method3276(var1) == 1) {
         return this.method1269(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   public class59(class167 var1, class167 var2) {
      this.field1185 = var1;
      this.field1189 = var2;
   }
}
