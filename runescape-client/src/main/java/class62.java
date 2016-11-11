import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
public class class62 {
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = -1578633151
   )
   public static int field1267;
   @ObfuscatedName("h")
   class170 field1268;
   @ObfuscatedName("i")
   class170 field1269;
   @ObfuscatedName("g")
   XHashTable field1270 = new XHashTable(256);
   @ObfuscatedName("e")
   XHashTable field1272 = new XHashTable(256);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass65;",
      garbageValue = "-697330459"
   )
   public class65 method1294(int var1, int[] var2) {
      if(this.field1268.method3300() == 1) {
         return this.method1296(0, var1, var2);
      } else if(this.field1268.method3299(var1) == 1) {
         return this.method1296(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II[IB)Lclass65;",
      garbageValue = "93"
   )
   class65 method1295(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class65 var7 = (class65)this.field1270.method3812(var5);
      if(var7 != null) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class61 var8 = class61.method1293(this.field1269, var1, var2);
         if(null == var8) {
            return null;
         } else {
            var7 = var8.method1284();
            this.field1270.method3813(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1288.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass65;",
      garbageValue = "1226914256"
   )
   class65 method1296(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class65 var7 = (class65)this.field1270.method3812(var5);
      if(null != var7) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class73 var8 = (class73)this.field1272.method3812(var5);
         if(null == var8) {
            var8 = class73.method1572(this.field1268, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1272.method3813(var8, var5);
         }

         var7 = var8.method1593(var3);
         if(null == var7) {
            return null;
         } else {
            var8.unlink();
            this.field1270.method3813(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass65;",
      garbageValue = "-952207102"
   )
   public class65 method1297(int var1, int[] var2) {
      if(this.field1269.method3300() == 1) {
         return this.method1295(0, var1, var2);
      } else if(this.field1269.method3299(var1) == 1) {
         return this.method1295(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   public class62(class170 var1, class170 var2) {
      this.field1269 = var1;
      this.field1268 = var2;
   }
}
