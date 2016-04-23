import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public class class76 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1405533395
   )
   static int field1364;
   @ObfuscatedName("z")
   static int[] field1366;
   @ObfuscatedName("x")
   static int[] field1367;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1902325423
   )
   static int field1368;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = 1139425037
   )
   static int field1369;
   @ObfuscatedName("e")
   public static class167 field1370;
   @ObfuscatedName("i")
   static int[] field1371;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "44"
   )
   static boolean method1671() {
      try {
         if(null == class17.field245) {
            class17.field245 = new class18(class142.field2153, new URL(class14.field201));
         } else {
            byte[] var0 = class17.field245.method195();
            if(var0 != null) {
               class119 var1 = new class119(var0);
               class25.field614 = var1.method2502();
               class25.field616 = new class25[class25.field614];

               class25 var3;
               for(int var2 = 0; var2 < class25.field614; var3.field624 = var2++) {
                  var3 = class25.field616[var2] = new class25();
                  var3.field618 = var1.method2502();
                  var3.field613 = var1.method2505();
                  var3.field627 = var1.method2508();
                  var3.field620 = var1.method2508();
                  var3.field623 = var1.method2500();
                  var3.field625 = var1.method2501();
               }

               client.method553(class25.field616, 0, class25.field616.length - 1, class25.field617, class25.field622);
               class17.field245 = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class17.field245 = null;
      }

      return false;
   }
}
