import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class191 {
   @ObfuscatedName("k")
   static int[] field3076;

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "2132554716"
   )
   static void method3747(int var0, String var1) {
      int var2 = class32.field731;
      int[] var3 = class32.field732;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         class2 var6 = client.field387[var3[var5]];
         if(var6 != null && var6 != class20.field572 && null != var6.field45 && var6.field45.equalsIgnoreCase(var1)) {
            if(1 == var0) {
               client.field321.method2762(216);
               client.field321.method2708(0);
               client.field321.method2554(var3[var5]);
            } else if(4 == var0) {
               client.field321.method2762(151);
               client.field321.method2546(0);
               client.field321.method2556(var3[var5]);
            } else if(var0 == 6) {
               client.field321.method2762(52);
               client.field321.method2556(var3[var5]);
               client.field321.method2565(0);
            } else if(var0 == 7) {
               client.field321.method2762(77);
               client.field321.method2548(var3[var5]);
               client.field321.method2565(0);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class87.method2092(4, "", "Unable to find " + var1);
      }

   }
}
