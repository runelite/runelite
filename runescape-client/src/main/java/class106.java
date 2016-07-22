import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
@Implements("Frames")
public class class106 extends class207 {
   @ObfuscatedName("f")
   static String field1839;
   @ObfuscatedName("m")
   class91[] field1841;

   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IZ)V",
      garbageValue = "0"
   )
   public class106(class170 var1, class170 var2, int var3, boolean var4) {
      class202 var5 = new class202();
      int var6 = var1.method3317(var3);
      this.field1841 = new class91[var6];
      int[] var7 = var1.method3353(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3304(var3, var7[var8]);
         class105 var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(class105 var12 = (class105)var5.method3882(); var12 != null; var12 = (class105)var5.method3891()) {
            if(var11 == var12.field1829) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13 = var2.method3310(var11, 0);
            var10 = new class105(var11, var13);
            var5.method3877(var10);
         }

         this.field1841[var7[var8]] = new class91(var9, var10);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "444776132"
   )
   public boolean method2360(int var1) {
      return this.field1841[var1].field1615;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)[Lclass83;",
      garbageValue = "-26"
   )
   static class83[] method2364() {
      class83[] var0 = new class83[class79.field1456];

      for(int var1 = 0; var1 < class79.field1456; ++var1) {
         class83 var2 = var0[var1] = new class83();
         var2.field1496 = class79.field1457;
         var2.field1501 = class79.field1458;
         var2.field1498 = class79.field1459[var1];
         var2.field1499 = class79.field1460[var1];
         var2.field1500 = class79.field1463[var1];
         var2.field1497 = class117.field2021[var1];
         var2.field1495 = class79.field1462;
         var2.field1494 = class10.field151[var1];
      }

      class18.method191();
      return var0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1225545092"
   )
   static void method2365() {
      for(class24 var0 = (class24)class24.field624.method3882(); var0 != null; var0 = (class24)class24.field624.method3891()) {
         if(var0.field615 != null) {
            var0.method582();
         }
      }

   }
}
