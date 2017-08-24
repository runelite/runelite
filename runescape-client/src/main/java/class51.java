import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class51 implements class102 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 806238525
   )
   static int field671;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Ldz;",
      garbageValue = "1851896695"
   )
   public AbstractSoundSystem vmethod1926() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "468306971"
   )
   static final int method817() {
      return Client.menuOptionCount - 1;
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-49"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      WorldMapType3.method239();
      ++Client.audioEffectCount;
      if(Client.audioEffectCount >= 50 || var0) {
         Client.audioEffectCount = 0;
         if(!Client.socketError && ScriptEvent.rssocket != null) {
            Client.secretPacketBuffer1.putOpcode(80);

            try {
               ScriptEvent.rssocket.queueForWrite(Client.secretPacketBuffer1.payload, 0, Client.secretPacketBuffer1.offset);
               Client.secretPacketBuffer1.offset = 0;
            } catch (IOException var2) {
               Client.socketError = true;
            }
         }

      }
   }
}
