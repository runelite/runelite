import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class18 extends Node {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1306840557
   )
   static int field185;
   @ObfuscatedName("df")
   static byte[][] field186;
   @ObfuscatedName("f")
   Widget field187;
   @ObfuscatedName("i")
   Object[] field188;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1484670691
   )
   int field189;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1893856409
   )
   int field190;
   @ObfuscatedName("e")
   boolean field191;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1890481185
   )
   int field192;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -105426931
   )
   int field193;
   @ObfuscatedName("v")
   String field194;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 793557277
   )
   int field195;
   @ObfuscatedName("a")
   Widget field196;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1423316071
   )
   int field198;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2115121419"
   )
   static void method186() {
      Client.field294.offset = 0;
      Client.field544.offset = 0;
      Client.packetOpcode = -1;
      Client.field319 = -1;
      Client.field466 = -1;
      Client.field336 = -1;
      Client.field485 = 0;
      Client.field332 = 0;
      Client.field300 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field522 = 0;
      Client.flagX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      class39.localPlayer = null;

      for(var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
         NPC var1 = Client.cachedNPCs[var0];
         if(null != var1) {
            var1.interacting = -1;
            var1.field625 = false;
         }
      }

      class11.method150();
      XGrandExchangeOffer.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field524[var0] = true;
      }

      FrameMap.method1689();
   }
}
