import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public class class139 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   static Widget field2008;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   public static void method2870() {
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1571961185"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      NPC.method1648();
      ++Client.field888.field1455;
      if(Client.field888.field1455 >= 50 || var0) {
         Client.field888.field1455 = 0;
         if(!Client.socketError && Client.field888.getSocket() != null) {
            PacketNode var1 = FileSystem.method4252(ClientPacket.field2328, Client.field888.field1449);
            Client.field888.method1862(var1);

            try {
               Client.field888.method1861();
            } catch (IOException var3) {
               Client.socketError = true;
            }
         }

      }
   }
}
