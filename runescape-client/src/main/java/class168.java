import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class168 {
   @ObfuscatedName("k")
   public static final char[] field2705 = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = -678621973
   )
   static int field2706;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1553624383"
   )
   static void method3270() {
      Client.field324.offset = 0;
      Client.field314.offset = 0;
      Client.packetOpcode = -1;
      Client.field331 = 1;
      Client.field332 = -1;
      Client.field430 = -1;
      Client.field276 = 0;
      Client.field329 = 0;
      Client.field304 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field516 = 0;
      Client.flagX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      class165.localPlayer = null;

      for(var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
         NPC var1 = Client.cachedNPCs[var0];
         if(var1 != null) {
            var1.interacting = -1;
            var1.field852 = false;
         }
      }

      class144.method3014();
      class127.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field485[var0] = true;
      }

      class23.method590();
   }
}
