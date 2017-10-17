import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class37 {
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("fz")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("fk")
   static byte[][] field529;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   static IndexedSprite field527;

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-36706974"
   )
   static final void method493() {
      Client.secretPacketBuffer2.bitAccess();
      int var0 = Client.secretPacketBuffer2.getBits(8);
      int var1;
      if(var0 < Client.npcIndexesCount) {
         for(var1 = var0; var1 < Client.npcIndexesCount; ++var1) {
            Client.field1037[++Client.field1036 - 1] = Client.npcIndices[var1];
         }
      }

      if(var0 > Client.npcIndexesCount) {
         throw new RuntimeException("");
      } else {
         Client.npcIndexesCount = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = Client.npcIndices[var1];
            NPC var3 = Client.cachedNPCs[var2];
            int var4 = Client.secretPacketBuffer2.getBits(1);
            if(var4 == 0) {
               Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
               var3.field1256 = Client.gameCycle;
            } else {
               int var5 = Client.secretPacketBuffer2.getBits(2);
               if(var5 == 0) {
                  Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
                  var3.field1256 = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(var5 == 1) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
                     var3.field1256 = Client.gameCycle;
                     var6 = Client.secretPacketBuffer2.getBits(3);
                     var3.method1753(var6, (byte)1);
                     var7 = Client.secretPacketBuffer2.getBits(1);
                     if(var7 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
                     var3.field1256 = Client.gameCycle;
                     var6 = Client.secretPacketBuffer2.getBits(3);
                     var3.method1753(var6, (byte)2);
                     var7 = Client.secretPacketBuffer2.getBits(3);
                     var3.method1753(var7, (byte)2);
                     int var8 = Client.secretPacketBuffer2.getBits(1);
                     if(var8 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     Client.field1037[++Client.field1036 - 1] = var2;
                  }
               }
            }
         }

      }
   }
}
