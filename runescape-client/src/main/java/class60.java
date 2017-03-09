import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
public class class60 {
   @ObfuscatedName("j")
   class182 field1087;
   @ObfuscatedName("c")
   XHashTable field1088 = new XHashTable(256);
   @ObfuscatedName("x")
   class182 field1089;
   @ObfuscatedName("d")
   XHashTable field1091 = new XHashTable(256);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II[IS)Lclass55;",
      garbageValue = "2999"
   )
   class55 method1216(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class55 var7 = (class55)this.field1091.method2405(var5);
      if(null != var7) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class53 var8 = class53.method1060(this.field1089, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1051();
            this.field1091.method2403(var7, var5);
            if(null != var3) {
               var3[0] -= var7.field1035.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I[IS)Lclass55;",
      garbageValue = "128"
   )
   public class55 method1217(int var1, int[] var2) {
      if(this.field1087.method3317() == 1) {
         return this.method1223(0, var1, var2);
      } else if(this.field1087.method3316(var1) == 1) {
         return this.method1223(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I[IB)Lclass55;",
      garbageValue = "12"
   )
   public class55 method1219(int var1, int[] var2) {
      if(this.field1089.method3317() == 1) {
         return this.method1216(0, var1, var2);
      } else if(this.field1089.method3316(var1) == 1) {
         return this.method1216(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass55;",
      garbageValue = "-244612493"
   )
   class55 method1223(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class55 var7 = (class55)this.field1091.method2405(var5);
      if(null != var7) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class54 var8 = (class54)this.field1088.method2405(var5);
         if(var8 == null) {
            var8 = class54.method1071(this.field1087, var1, var2);
            if(null == var8) {
               return null;
            }

            this.field1088.method2403(var8, var5);
         }

         var7 = var8.method1088(var3);
         if(null == var7) {
            return null;
         } else {
            var8.unlink();
            this.field1091.method2403(var7, var5);
            return var7;
         }
      }
   }

   public class60(class182 var1, class182 var2) {
      this.field1089 = var1;
      this.field1087 = var2;
   }
}
