import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public class class112 {
   @ObfuscatedName("e")
   XHashTable field1680;
   @ObfuscatedName("c")
   IndexDataBase field1681;
   @ObfuscatedName("i")
   IndexDataBase field1682;
   @ObfuscatedName("v")
   XHashTable field1683;
   @ObfuscatedName("gu")
   static ModIcon[] field1685;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I[IB)Lclass107;",
      garbageValue = "-95"
   )
   public class107 method2071(int var1, int[] var2) {
      if(this.field1682.method4121() == 1) {
         return this.method2076(0, var1, var2);
      } else if(this.field1682.method4187(var1) == 1) {
         return this.method2076(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II[IB)Lclass107;",
      garbageValue = "-78"
   )
   class107 method2073(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class107 var7 = (class107)this.field1683.method3520(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class106 var8 = (class106)this.field1680.method3520(var5);
         if(var8 == null) {
            var8 = class106.method1980(this.field1681, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1680.method3516(var8, var5);
         }

         var7 = var8.method1956(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1683.method3516(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass107;",
      garbageValue = "37610194"
   )
   public class107 method2074(int var1, int[] var2) {
      if(this.field1681.method4121() == 1) {
         return this.method2073(0, var1, var2);
      } else if(this.field1681.method4187(var1) == 1) {
         return this.method2073(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   public class112(IndexDataBase var1, IndexDataBase var2) {
      this.field1680 = new XHashTable(256);
      this.field1683 = new XHashTable(256);
      this.field1682 = var1;
      this.field1681 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass107;",
      garbageValue = "250909940"
   )
   class107 method2076(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class107 var7 = (class107)this.field1683.method3520(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.method1944(this.field1682, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1933();
            this.field1683.method3516(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1620.length;
            }

            return var7;
         }
      }
   }
}
