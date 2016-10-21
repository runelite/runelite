import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class62 {
   @ObfuscatedName("t")
   XHashTable field1260 = new XHashTable(256);
   @ObfuscatedName("n")
   XHashTable field1262 = new XHashTable(256);
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -468849855
   )
   static int field1263;
   @ObfuscatedName("e")
   class170 field1265;
   @ObfuscatedName("f")
   class170 field1266;
   @ObfuscatedName("bs")
   static class171 field1267;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass65;",
      garbageValue = "-1903005368"
   )
   class65 method1303(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class65 var7 = (class65)this.field1260.method3849(var5);
      if(null != var7) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class61 var8 = class61.method1299(this.field1266, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1288();
            this.field1260.method3850(var7, var5);
            if(null != var3) {
               var3[0] -= var7.field1278.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass65;",
      garbageValue = "2086309321"
   )
   class65 method1304(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class65 var7 = (class65)this.field1260.method3849(var5);
      if(null != var7) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class73 var8 = (class73)this.field1262.method3849(var5);
         if(var8 == null) {
            var8 = class73.method1589(this.field1265, var1, var2);
            if(null == var8) {
               return null;
            }

            this.field1262.method3850(var8, var5);
         }

         var7 = var8.method1594(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1260.method3850(var7, var5);
            return var7;
         }
      }
   }

   public class62(class170 var1, class170 var2) {
      this.field1266 = var1;
      this.field1265 = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass65;",
      garbageValue = "637733288"
   )
   public class65 method1305(int var1, int[] var2) {
      if(this.field1265.method3295() == 1) {
         return this.method1304(0, var1, var2);
      } else if(this.field1265.method3321(var1) == 1) {
         return this.method1304(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)LSequence;",
      garbageValue = "1665659291"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field990.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = Sequence.field1003.method3304(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.method879(new Buffer(var2));
         }

         var1.method881();
         Sequence.field990.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I[IB)Lclass65;",
      garbageValue = "127"
   )
   public class65 method1319(int var1, int[] var2) {
      if(this.field1266.method3295() == 1) {
         return this.method1303(0, var1, var2);
      } else if(this.field1266.method3321(var1) == 1) {
         return this.method1303(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }
}
