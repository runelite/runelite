import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class11 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   public static final class11 field251;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   public static final class11 field250;
   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   static Task field252;

   static {
      field251 = new class11();
      field250 = new class11();
   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)V",
      garbageValue = "-115"
   )
   static final void method62(String var0, int var1) {
      PacketNode var2 = class18.method133(ClientPacket.field2327, Client.field905.field1460);
      var2.packetBuffer.putByte(class23.getLength(var0) + 1);
      var2.packetBuffer.putString(var0);
      var2.packetBuffer.method3212(var1);
      Client.field905.method1855(var2);
   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "([BII)V",
      garbageValue = "2055860307"
   )
   static void method63(byte[] var0, int var1) {
      if(Client.field983 == null) {
         Client.field983 = new byte[24];
      }

      class190.method3506(var0, var1, Client.field983, 0, 24);
   }
}
