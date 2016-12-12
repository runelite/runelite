import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class149 {
   @ObfuscatedName("f")
   static class182 field2041;
   @ObfuscatedName("pf")
   static class30 field2044;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILclass116;Lclass184;I)V",
      garbageValue = "1753321542"
   )
   static void method2735(int var0, class116 var1, class184 var2) {
      class180 var3 = new class180();
      var3.field2692 = 1;
      var3.hash = (long)var0;
      var3.field2693 = var1;
      var3.field2694 = var2;
      Deque var4 = class183.field2726;
      synchronized(class183.field2726) {
         class183.field2726.method2376(var3);
      }

      class104.method1975();
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   static final void method2736() {
      Client.field407 = 0;
      int var0 = (class39.localPlayer.x >> 7) + class15.baseX;
      int var1 = (class39.localPlayer.y >> 7) + class20.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field407 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field407 = 1;
      }

      if(Client.field407 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field407 = 0;
      }

   }
}
