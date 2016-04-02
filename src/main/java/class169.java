import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class169 extends class208 {
   @ObfuscatedName("pg")
   static class134 field2698;
   @ObfuscatedName("w")
   byte[] field2699;
   @ObfuscatedName("f")
   class134 field2700;
   @ObfuscatedName("s")
   class168 field2701;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1972215597
   )
   int field2703;
   @ObfuscatedName("ep")
   static class78[] field2704;

   @ObfuscatedName("e")
   static boolean method3352() {
      try {
         if(null == class27.field652) {
            class27.field652 = new class18(class125.field2028, new URL(class142.field2165));
         } else {
            byte[] var0 = class27.field652.method185();
            if(null != var0) {
               class119 var1 = new class119(var0);
               class25.field616 = var1.method2700();
               class25.field615 = new class25[class25.field616];

               class25 var3;
               for(int var2 = 0; var2 < class25.field616; var3.field627 = var2++) {
                  var3 = class25.field615[var2] = new class25();
                  var3.field620 = var1.method2700();
                  var3.field621 = var1.method2528();
                  var3.field623 = var1.method2531();
                  var3.field624 = var1.method2531();
                  var3.field625 = var1.method2523();
                  var3.field622 = var1.method2526();
               }

               class27.method647(class25.field615, 0, class25.field615.length - 1, class25.field619, class25.field618);
               class27.field652 = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class27.field652 = null;
      }

      return false;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILclass134;Lclass168;I)V",
      garbageValue = "1322111038"
   )
   static void method3353(int var0, class134 var1, class168 var2) {
      byte[] var3 = null;
      class199 var4 = class170.field2708;
      synchronized(class170.field2708) {
         for(class169 var5 = (class169)class170.field2708.method3825(); var5 != null; var5 = (class169)class170.field2708.method3827()) {
            if(var5.field3115 == (long)var0 && var1 == var5.field2700 && 0 == var5.field2703) {
               var3 = var5.field2699;
               break;
            }
         }
      }

      if(null != var3) {
         var2.method3327(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2851(var0);
         var2.method3327(var1, var0, var8, true);
      }
   }
}
