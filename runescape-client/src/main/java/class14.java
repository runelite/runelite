import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class14 {
   @ObfuscatedName("ep")
   static class81[] field187;
   @ObfuscatedName("e")
   int[] field189;
   @ObfuscatedName("o")
   String[] field190;
   @ObfuscatedName("m")
   class23 field192;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2128883755
   )
   int field193 = -1;

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(Lclass176;B)V",
      garbageValue = "54"
   )
   static void method161(class176 var0) {
      class176 var1 = var0.field2836 == -1?null:class34.method720(var0.field2836);
      int var2;
      int var3;
      if(var1 == null) {
         var2 = class12.field174;
         var3 = class19.field264;
      } else {
         var2 = var1.field2926;
         var3 = var1.field2877;
      }

      class77.method1689(var0, var2, var3, false);
      class78.method1728(var0, var2, var3);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2084842975"
   )
   static void method162(int var0, int var1, int var2, int var3) {
      class15 var4 = (class15)class15.field204.method3856((long)var0);
      if(var4 == null) {
         var4 = new class15();
         class15.field204.method3849(var4, (long)var0);
      }

      if(var4.field206.length <= var1) {
         int[] var5 = new int[1 + var1];
         int[] var6 = new int[1 + var1];

         int var7;
         for(var7 = 0; var7 < var4.field206.length; ++var7) {
            var5[var7] = var4.field206[var7];
            var6[var7] = var4.field199[var7];
         }

         for(var7 = var4.field206.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.field206 = var5;
         var4.field199 = var6;
      }

      var4.field206[var1] = var2;
      var4.field199[var1] = var3;
   }
}
