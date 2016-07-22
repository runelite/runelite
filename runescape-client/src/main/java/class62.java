import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public class class62 {
   @ObfuscatedName("w")
   class170 field1286;
   @ObfuscatedName("e")
   class199 field1287 = new class199(256);
   @ObfuscatedName("o")
   class199 field1288 = new class199(256);
   @ObfuscatedName("q")
   static class13 field1289;
   @ObfuscatedName("m")
   class170 field1291;
   @ObfuscatedName("dw")
   static int[] field1295;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass65;",
      garbageValue = "-470768991"
   )
   class65 method1335(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class65 var7 = (class65)this.field1288.method3856(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class61 var8 = class61.method1324(this.field1291, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1319();
            this.field1288.method3849(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1305.length;
            }

            return var7;
         }
      }
   }

   public class62(class170 var1, class170 var2) {
      this.field1291 = var1;
      this.field1286 = var2;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)[Lclass81;",
      garbageValue = "483334554"
   )
   public static class81[] method1336(class170 var0, String var1, String var2) {
      int var3 = var0.method3319(var1);
      int var4 = var0.method3368(var3, var2);
      return class34.method726(var0, var3, var4);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass65;",
      garbageValue = "-971989186"
   )
   public class65 method1337(int var1, int[] var2) {
      if(this.field1286.method3306() == 1) {
         return this.method1338(0, var1, var2);
      } else if(this.field1286.method3317(var1) == 1) {
         return this.method1338(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass65;",
      garbageValue = "-81593712"
   )
   class65 method1338(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class65 var7 = (class65)this.field1288.method3856(var5);
      if(var7 != null) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class73 var8 = (class73)this.field1287.method3856(var5);
         if(var8 == null) {
            var8 = class73.method1631(this.field1286, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1287.method3849(var8, var5);
         }

         var7 = var8.method1632(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.method3990();
            this.field1288.method3849(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I[IB)Lclass65;",
      garbageValue = "-116"
   )
   public class65 method1342(int var1, int[] var2) {
      if(this.field1291.method3306() == 1) {
         return this.method1335(0, var1, var2);
      } else if(this.field1291.method3317(var1) == 1) {
         return this.method1335(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }
}
