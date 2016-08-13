import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public class class62 {
   @ObfuscatedName("l")
   class170 field1285;
   @ObfuscatedName("r")
   XHashTable field1286 = new XHashTable(256);
   @ObfuscatedName("e")
   XHashTable field1287 = new XHashTable(256);
   @ObfuscatedName("g")
   class170 field1288;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass65;",
      garbageValue = "1068931854"
   )
   class65 method1383(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class65 var7 = (class65)this.field1287.method3936(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class73 var8 = (class73)this.field1286.method3936(var5);
         if(var8 == null) {
            var8 = class73.method1652(this.field1288, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1286.method3940(var8, var5);
         }

         var7 = var8.method1653(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1287.method3940(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass65;",
      garbageValue = "637554530"
   )
   class65 method1385(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class65 var7 = (class65)this.field1287.method3936(var5);
      if(null != var7) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class61 var8 = class61.method1380(this.field1285, var1, var2);
         if(null == var8) {
            return null;
         } else {
            var7 = var8.method1369();
            this.field1287.method3940(var7, var5);
            if(null != var3) {
               var3[0] -= var7.field1304.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass65;",
      garbageValue = "671785125"
   )
   public class65 method1386(int var1, int[] var2) {
      if(this.field1285.method3406() == 1) {
         return this.method1385(0, var1, var2);
      } else if(this.field1285.method3405(var1) == 1) {
         return this.method1385(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass65;",
      garbageValue = "1750891036"
   )
   public class65 method1387(int var1, int[] var2) {
      if(this.field1288.method3406() == 1) {
         return this.method1383(0, var1, var2);
      } else if(this.field1288.method3405(var1) == 1) {
         return this.method1383(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   public class62(class170 var1, class170 var2) {
      this.field1285 = var1;
      this.field1288 = var2;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1856162610"
   )
   static final void method1397() {
      for(class31 var0 = (class31)Client.field429.method3980(); var0 != null; var0 = (class31)Client.field429.method3970()) {
         if(var0.field718 == VertexNormal.plane && !var0.field725) {
            if(Client.gameCycle >= var0.field717) {
               var0.method688(Client.field370);
               if(var0.field725) {
                  var0.unlink();
               } else {
                  class136.region.method2003(var0.field718, var0.field719, var0.field727, var0.field728, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }
}
