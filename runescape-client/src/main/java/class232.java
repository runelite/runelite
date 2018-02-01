import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
public enum class232 implements MouseWheel {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2909(0, 0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2893(1, 0),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2892(2, 0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2895(3, 0),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2896(9, 2),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2901(4, 1),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2908(5, 1),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2899(6, 1),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2902(7, 1),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2894(8, 1),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2915(12, 2),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2900(13, 2),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2917(14, 2),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2905(15, 2),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2906(16, 2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2907(17, 2),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2897(18, 2),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2898(19, 2),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2910(20, 2),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2911(21, 2),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2912(10, 2),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2913(11, 2),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   field2914(22, 3);

   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   static Task field2904;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -357155287
   )
   public final int field2903;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class232(int var3, int var4) {
      this.field2903 = var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int rsOrdinal() {
      return this.field2903;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "1592037728"
   )
   static void method4328(int var0, String var1) {
      int var2 = class92.playerIndexesCount;
      int[] var3 = class92.playerIndices;
      boolean var4 = false;
      Name var5 = new Name(var1, class34.loginType);

      for(int var6 = 0; var6 < var2; ++var6) {
         Player var7 = Client.cachedPlayers[var3[var6]];
         if(var7 != null && var7 != class36.localPlayer && var7.name != null && var7.name.equals(var5)) {
            PacketNode var8;
            if(var0 == 1) {
               var8 = class35.method501(ClientPacket.field2363, Client.field867.field1439);
               var8.packetBuffer.writeShortLE(var3[var6]);
               var8.packetBuffer.method3430(0);
               Client.field867.method2021(var8);
            } else if(var0 == 4) {
               var8 = class35.method501(ClientPacket.field2288, Client.field867.field1439);
               var8.packetBuffer.method3397(0);
               var8.packetBuffer.putShort(var3[var6]);
               Client.field867.method2021(var8);
            } else if(var0 == 6) {
               var8 = class35.method501(ClientPacket.field2319, Client.field867.field1439);
               var8.packetBuffer.writeIntLE16(var3[var6]);
               var8.packetBuffer.method3397(0);
               Client.field867.method2021(var8);
            } else if(var0 == 7) {
               var8 = class35.method501(ClientPacket.field2332, Client.field867.field1439);
               var8.packetBuffer.putByte(0);
               var8.packetBuffer.writeIntLE16(var3[var6]);
               Client.field867.method2021(var8);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class240.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }
}
