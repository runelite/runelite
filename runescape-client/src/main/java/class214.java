import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
public class class214 {
   @ObfuscatedName("f")
   public static class205 field3177 = new class205();

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "1951208999"
   )
   static void method4011(int var0, String var1) {
      int var2 = class34.field763;
      int[] var3 = class34.field758;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(null != var6 && class34.localPlayer != var6 && null != var6.name && var6.name.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               Client.field397.method2768(28);
               Client.field397.method2627(var3[var5]);
               Client.field397.method2557(0);
            } else if(var0 == 4) {
               Client.field397.method2768(191);
               Client.field397.method2557(0);
               Client.field397.method2567(var3[var5]);
            } else if(var0 == 6) {
               Client.field397.method2768(48);
               Client.field397.method2559(0);
               Client.field397.method2519(var3[var5]);
            } else if(var0 == 7) {
               Client.field397.method2768(179);
               Client.field397.method2559(0);
               Client.field397.method2627(var3[var5]);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class190.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }
}
