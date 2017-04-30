import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class61 {
   @ObfuscatedName("c")
   IndexDataBase field1068;
   @ObfuscatedName("n")
   XHashTable field1069;
   @ObfuscatedName("d")
   IndexDataBase field1070;
   @ObfuscatedName("q")
   XHashTable field1071;
   @ObfuscatedName("a")
   static int[] field1072;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II[IS)Lclass55;",
      garbageValue = "10658"
   )
   class55 method1160(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class55 var7 = (class55)this.field1071.method2773(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.method993(this.field1070, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method991();
            this.field1071.method2774(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1012.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass55;",
      garbageValue = "50425512"
   )
   class55 method1161(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class55 var7 = (class55)this.field1071.method2773(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class54 var8 = (class54)this.field1069.method2773(var5);
         if(var8 == null) {
            var8 = class54.method1011(this.field1068, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1069.method2774(var8, var5);
         }

         var7 = var8.method1013(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1071.method2774(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "-1418793050"
   )
   public class55 method1169(int var1, int[] var2) {
      if(this.field1070.method3306() == 1) {
         return this.method1160(0, var1, var2);
      } else if(this.field1070.method3305(var1) == 1) {
         return this.method1160(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "-143476729"
   )
   public class55 method1173(int var1, int[] var2) {
      if(this.field1068.method3306() == 1) {
         return this.method1161(0, var1, var2);
      } else if(this.field1068.method3305(var1) == 1) {
         return this.method1161(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   public class61(IndexDataBase var1, IndexDataBase var2) {
      this.field1069 = new XHashTable(256);
      this.field1071 = new XHashTable(256);
      this.field1070 = var1;
      this.field1068 = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1621218008"
   )
   public static int method1174(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }
}
