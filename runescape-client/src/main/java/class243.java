import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
public class class243 {
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = -129207273
   )
   static int field2960;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-789360915"
   )
   public static void method4618() {
      class35.field485.method4043(5);
      class35.field484.method4043(5);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "106"
   )
   static final void method4617(String var0) {
      class19.sendGameMessage(30, "", var0);
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(Lbd;B)Z",
      garbageValue = "1"
   )
   static boolean method4614(Player var0) {
      if(Client.field988 == 0) {
         return false;
      } else if(TotalQuantityComparator.localPlayer == var0) {
         return Projectile.method1955();
      } else {
         boolean var1 = class266.method4849() || MessageNode.method1132() && var0.isFriend();
         if(!var1) {
            boolean var2 = (Client.field988 & 2) != 0;
            var1 = var2 && var0.isClanMember();
         }

         return var1;
      }
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1294273057"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      Huffman.method3510();
      ++Client.field899.field1477;
      if(Client.field899.field1477 >= 50 || var0) {
         Client.field899.field1477 = 0;
         if(!Client.socketError && Client.field899.getSocket() != null) {
            PacketNode var1 = class31.method285(ClientPacket.field2451, Client.field899.field1470);
            Client.field899.method2082(var1);

            try {
               Client.field899.method2080();
            } catch (IOException var3) {
               Client.socketError = true;
            }
         }

      }
   }
}
