import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class214 {
   @ObfuscatedName("e")
   public static class205 field3177 = new class205();
   @ObfuscatedName("eg")
   static class83[] field3178;

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(Lclass3;ZI)V",
      garbageValue = "963485895"
   )
   static final void method4018(class3 var0, boolean var1) {
      int var2 = var0.field60;
      int var3 = (int)var0.field3161;
      var0.method4000();
      int var5;
      if(var1 && var2 != -1 && class176.field2785[var2]) {
         class176.field2834.method3359(var2);
         if(class176.field2811[var2] != null) {
            boolean var6 = true;

            for(var5 = 0; var5 < class176.field2811[var2].length; ++var5) {
               if(null != class176.field2811[var2][var5]) {
                  if(class176.field2811[var2][var5].field2796 != 2) {
                     class176.field2811[var2][var5] = null;
                  } else {
                     var6 = false;
                  }
               }
            }

            if(var6) {
               class176.field2811[var2] = null;
            }

            class176.field2785[var2] = false;
         }
      }

      for(class204 var4 = (class204)client.field414.method3867(); null != var4; var4 = (class204)client.field414.method3868()) {
         if((long)var2 == (var4.field3161 >> 48 & 65535L)) {
            var4.method4000();
         }
      }

      class176 var7 = class19.method212(var3);
      if(null != var7) {
         class51.method1124(var7);
      }

      class126.method2895();
      if(client.field454 != -1) {
         var5 = client.field454;
         if(class10.method112(var5)) {
            class28.method647(class176.field2811[var5], 1);
         }
      }

   }
}
