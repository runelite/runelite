import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
public class class88 {
   @ObfuscatedName("w")
   static final BigInteger field1374;
   @ObfuscatedName("k")
   static final BigInteger field1369;
   @ObfuscatedName("t")
   static int[] field1365;
   @ObfuscatedName("ay")
   static int[] field1368;

   static {
      field1374 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1369 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lit;Lit;I)I",
      garbageValue = "1265375680"
   )
   static int method1727(IndexDataBase var0, IndexDataBase var1) {
      int var2 = 0;
      if(var0.method4134("title.jpg", "")) {
         ++var2;
      }

      if(var1.method4134("logo", "")) {
         ++var2;
      }

      if(var1.method4134("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method4134("titlebox", "")) {
         ++var2;
      }

      if(var1.method4134("titlebutton", "")) {
         ++var2;
      }

      if(var1.method4134("runes", "")) {
         ++var2;
      }

      if(var1.method4134("title_mute", "")) {
         ++var2;
      }

      if(var1.method4134("options_radio_buttons,0", "")) {
         ++var2;
      }

      if(var1.method4134("options_radio_buttons,2", "")) {
         ++var2;
      }

      var1.method4134("sl_back", "");
      var1.method4134("sl_flags", "");
      var1.method4134("sl_arrows", "");
      var1.method4134("sl_stars", "");
      var1.method4134("sl_button", "");
      return var2;
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "976031924"
   )
   static void method1723() {
      Client.secretPacketBuffer1.offset = 0;
      Client.secretPacketBuffer2.offset = 0;
      Client.packetType = -1;
      Client.lastFrameId = -1;
      Client.secondLastFrameId = -1;
      Client.thridLastFrameId = -1;
      Client.packetLength = 0;
      Client.field968 = 0;
      Client.field931 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field1138 = 0;
      Client.destinationX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      class54.localPlayer = null;

      for(var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
         NPC var1 = Client.cachedNPCs[var0];
         if(var1 != null) {
            var1.interacting = -1;
            var1.field1242 = false;
         }
      }

      XItemContainer.itemContainers = new XHashTable(32);
      WorldMapType1.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1107[var0] = true;
      }

      XGrandExchangeOffer.method113();
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-563920381"
   )
   static final void method1728() {
      Client.secretPacketBuffer1.putOpcode(59);
      Client.secretPacketBuffer1.putByte(0);
   }
}
