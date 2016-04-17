import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class157 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "8"
   )
   public static void method3264(int var0, int var1) {
      class47 var3 = (class47)class47.field1073.method3840((long)var0);
      class47 var2;
      if(null != var3) {
         var2 = var3;
      } else {
         byte[] var4 = class109.field1907.method3403(14, var0);
         var3 = new class47();
         if(null != var4) {
            var3.method1071(new class119(var4));
         }

         class47.field1073.method3842(var3, (long)var0);
         var2 = var3;
      }

      int var8 = var2.field1074;
      int var5 = var2.field1075;
      int var6 = var2.field1076;
      int var7 = class176.field2909[var6 - var5];
      if(var1 < 0 || var1 > var7) {
         var1 = 0;
      }

      var7 <<= var5;
      class176.field2905[var8] = class176.field2905[var8] & ~var7 | var1 << var5 & var7;
   }
}
