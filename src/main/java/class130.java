import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public class class130 {
   @ObfuscatedName("h")
   public static final class130 field2036 = new class130(1);
   @ObfuscatedName("m")
   static final class130 field2037 = new class130(2);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -399253897
   )
   public final int field2038;
   @ObfuscatedName("j")
   static final class130 field2040 = new class130(0);

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class130(int var1) {
      this.field2038 = var1;
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(Lclass3;ZI)V",
      garbageValue = "1"
   )
   static final void method2798(class3 var0, boolean var1) {
      int var2 = var0.field65;
      int var3 = (int)var0.field3122;
      var0.method3883();
      int var5;
      if(var2 != -1 && class173.field2792[var2]) {
         class173.field2736.method3260(var2);
         if(null != class173.field2735[var2]) {
            boolean var4 = true;

            for(var5 = 0; var5 < class173.field2735[var2].length; ++var5) {
               if(null != class173.field2735[var2][var5]) {
                  if(class173.field2735[var2][var5].field2820 != 2) {
                     class173.field2735[var2][var5] = null;
                  } else {
                     var4 = false;
                  }
               }
            }

            if(var4) {
               class173.field2735[var2] = null;
            }

            class173.field2792[var2] = false;
         }
      }

      class209.method3890(var2);
      class173 var6 = class141.method2959(var3);
      if(null != var6) {
         class2.method28(var6);
      }

      class6.method101();
      if(client.field433 != -1) {
         var5 = client.field433;
         if(class107.method2374(var5)) {
            class4.method38(class173.field2735[var5], 1);
         }
      }

   }
}
