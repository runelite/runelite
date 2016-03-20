import java.awt.Frame;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bu")
public class class59 {
   @ObfuscatedName("f")
   class195 field1211 = new class195(256);
   @ObfuscatedName("r")
   class166 field1212;
   @ObfuscatedName("s")
   class195 field1214 = new class195(256);
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = 1582988911
   )
   static int field1215;
   @ObfuscatedName("qw")
   protected static Frame field1217;
   @ObfuscatedName("a")
   class166 field1220;

   public class59(class166 var1, class166 var2) {
      this.field1220 = var1;
      this.field1212 = var2;
   }

   @ObfuscatedName("r")
   class62 method1276(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class62 var7 = (class62)this.field1214.method3824(var5);
      if(null != var7) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class70 var8 = (class70)this.field1211.method3824(var5);
         if(var8 == null) {
            var8 = class70.method1595(this.field1212, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1211.method3831(var8, var5);
         }

         var7 = var8.method1575(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.method3946();
            this.field1214.method3831(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("f")
   public class62 method1277(int var1, int[] var2) {
      if(this.field1220.method3287() == 1) {
         return this.method1281(0, var1, var2);
      } else if(this.field1220.method3273(var1) == 1) {
         return this.method1281(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("s")
   public static boolean method1278(int var0) {
      return 0 != (var0 >> 29 & 1);
   }

   @ObfuscatedName("s")
   public class62 method1279(int var1, int[] var2) {
      if(this.field1212.method3287() == 1) {
         return this.method1276(0, var1, var2);
      } else if(this.field1212.method3273(var1) == 1) {
         return this.method1276(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("a")
   class62 method1281(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class62 var7 = (class62)this.field1214.method3824(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class58 var8 = class58.method1272(this.field1220, var1, var2);
         if(null == var8) {
            return null;
         } else {
            var7 = var8.method1270();
            this.field1214.method3831(var7, var5);
            if(null != var3) {
               var3[0] -= var7.field1231.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("az")
   static final void method1289(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class4.method52(var0, var1, class48.field1078) - var2;
         var0 -= class44.field1037;
         var3 -= class30.field713;
         var1 -= class17.field254;
         int var4 = class90.field1572[class15.field219];
         int var5 = class90.field1578[class15.field219];
         int var6 = class90.field1572[class13.field193];
         int var7 = class90.field1578[class13.field193];
         int var8 = var7 * var0 + var6 * var1 >> 16;
         var1 = var1 * var7 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var1 * var4 >> 16;
         var1 = var3 * var4 + var5 * var1 >> 16;
         if(var1 >= 50) {
            client.field400 = (client.field559 / 2 + client.field347 * var0 / var1) * -1;
            client.field401 = (client.field347 * var8 / var1 + client.field560 / 2) * -1;
         } else {
            client.field400 = 1;
            client.field401 = 1;
         }

      } else {
         client.field400 = 1;
         client.field401 = 1;
      }
   }
}
