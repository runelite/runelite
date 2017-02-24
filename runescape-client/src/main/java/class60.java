import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class60 {
   @ObfuscatedName("q")
   class182 field1098;
   @ObfuscatedName("d")
   class182 field1099;
   @ObfuscatedName("h")
   XHashTable field1100 = new XHashTable(256);
   @ObfuscatedName("p")
   XHashTable field1101 = new XHashTable(256);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass55;",
      garbageValue = "1132156649"
   )
   class55 method1193(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class55 var7 = (class55)this.field1101.method2399(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class53 var8 = class53.method1039(this.field1098, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1040();
            this.field1101.method2400(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1044.length;
            }

            return var7;
         }
      }
   }

   public class60(class182 var1, class182 var2) {
      this.field1098 = var1;
      this.field1099 = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "-1025743957"
   )
   public class55 method1194(int var1, int[] var2) {
      if(this.field1098.method3314() == 1) {
         return this.method1193(0, var1, var2);
      } else if(this.field1098.method3313(var1) == 1) {
         return this.method1193(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II[IS)Lclass55;",
      garbageValue = "180"
   )
   class55 method1195(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class55 var7 = (class55)this.field1101.method2399(var5);
      if(var7 != null) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class54 var8 = (class54)this.field1100.method2399(var5);
         if(null == var8) {
            var8 = class54.method1056(this.field1099, var1, var2);
            if(null == var8) {
               return null;
            }

            this.field1100.method2400(var8, var5);
         }

         var7 = var8.method1057(var3);
         if(null == var7) {
            return null;
         } else {
            var8.unlink();
            this.field1101.method2400(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "456154450"
   )
   public class55 method1199(int var1, int[] var2) {
      if(this.field1099.method3314() == 1) {
         return this.method1195(0, var1, var2);
      } else if(this.field1099.method3313(var1) == 1) {
         return this.method1195(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-443260406"
   )
   public static boolean method1205(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
