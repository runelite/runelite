import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class168 {
   @ObfuscatedName("f")
   static int[] field2193;
   @ObfuscatedName("ef")
   static ModIcon[] field2195;

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-223248201"
   )
   static final void method3099() {
      int var0 = class45.field908;
      int[] var1 = class45.field903;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(null != var3) {
            ChatMessages.method833(var3, 1);
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "128951216"
   )
   static void method3100(int var0) {
      if(var0 == -1 && !Client.field525) {
         class172.method3180();
      } else if(var0 != -1 && Client.field414 != var0 && Client.field373 != 0 && !Client.field525) {
         class184 var1 = class204.field3079;
         int var2 = Client.field373;
         class138.field1914 = 1;
         class145.field2014 = var1;
         class30.field693 = var0;
         class138.field1915 = 0;
         ItemLayer.field1220 = var2;
         ItemLayer.field1221 = false;
         class138.field1916 = 2;
      }

      Client.field414 = var0;
   }
}
