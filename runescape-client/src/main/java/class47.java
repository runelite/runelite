import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class47 {
   @ObfuscatedName("mc")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   @Export("chatMessages")
   static Varcs chatMessages;
   @ObfuscatedName("aq")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -13931039
   )
   @Export("authCodeForLogin")
   static int authCodeForLogin;
   @ObfuscatedName("kg")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   static Widget field602;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 871549235
   )
   public int field600;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   public Coordinates field597;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   public Coordinates field598;

   @ObfuscatedSignature(
      signature = "(ILhq;Lhq;)V"
   )
   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field600 = var1;
      this.field597 = var2;
      this.field598 = var3;
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-124"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      class35.method495();
      ++Client.audioEffectCount;
      if(Client.audioEffectCount >= 50 || var0) {
         Client.audioEffectCount = 0;
         if(!Client.socketError && GZipDecompressor.rssocket != null) {
            Client.secretPacketBuffer1.putOpcode(98);

            try {
               GZipDecompressor.rssocket.queueForWrite(Client.secretPacketBuffer1.payload, 0, Client.secretPacketBuffer1.offset);
               Client.secretPacketBuffer1.offset = 0;
            } catch (IOException var2) {
               Client.socketError = true;
            }
         }

      }
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1365276847"
   )
   static final void method700() {
      int[] var0 = class97.field1494;

      int var1;
      for(var1 = 0; var1 < class97.field1493; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(var2 != null && var2.field1221 > 0) {
            --var2.field1221;
            if(var2.field1221 == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.field952; ++var1) {
         int var4 = Client.npcIndices[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(var3 != null && var3.field1221 > 0) {
            --var3.field1221;
            if(var3.field1221 == 0) {
               var3.overhead = null;
            }
         }
      }

   }
}
