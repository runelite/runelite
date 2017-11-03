import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public final class class60 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static IndexDataBase field762;
   @ObfuscatedName("ey")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   static class147 field763;

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "480"
   )
   static final void method1028() {
      if(Client.field977 > 0) {
         ChatLineBuffer.method1916();
      } else {
         Client.field979.method4995();
         class72.setGameState(40);
         class17.field324 = class15.rssocket2;
         class15.rssocket2 = null;
      }
   }
}
