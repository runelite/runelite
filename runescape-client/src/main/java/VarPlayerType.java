import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jg")
@Implements("VarPlayerType")
public class VarPlayerType extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("varplayer_ref")
   static IndexDataBase varplayer_ref;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("varplayers")
   static NodeCache varplayers;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1487086871
   )
   @Export("configType")
   public int configType;

   static {
      varplayers = new NodeCache(64);
   }

   VarPlayerType() {
      this.configType = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "-592925851"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.decode(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgn;II)V",
      garbageValue = "1329605689"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      if(var2 == 5) {
         this.configType = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(ZLgu;S)V",
      garbageValue = "-22263"
   )
   static final void method4722(boolean var0, PacketBuffer var1) {
      Client.field926 = 0;
      Client.pendingNpcFlagsCount = 0;
      PacketBuffer var2 = Client.field863.packetBuffer;
      var2.bitAccess();
      int var3 = var2.getBits(8);
      int var4;
      if(var3 < Client.npcIndexesCount) {
         for(var4 = var3; var4 < Client.npcIndexesCount; ++var4) {
            Client.field892[++Client.field926 - 1] = Client.npcIndices[var4];
         }
      }

      if(var3 > Client.npcIndexesCount) {
         throw new RuntimeException("");
      } else {
         Client.npcIndexesCount = 0;

         for(var4 = 0; var4 < var3; ++var4) {
            int var5 = Client.npcIndices[var4];
            NPC var6 = Client.cachedNPCs[var5];
            int var7 = var2.getBits(1);
            if(var7 == 0) {
               Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
               var6.npcCycle = Client.gameCycle;
            } else {
               int var8 = var2.getBits(2);
               if(var8 == 0) {
                  Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                  var6.npcCycle = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
               } else {
                  int var9;
                  int var10;
                  if(var8 == 1) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                     var6.npcCycle = Client.gameCycle;
                     var9 = var2.getBits(3);
                     var6.method1834(var9, (byte)1);
                     var10 = var2.getBits(1);
                     if(var10 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
                     }
                  } else if(var8 == 2) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                     var6.npcCycle = Client.gameCycle;
                     var9 = var2.getBits(3);
                     var6.method1834(var9, (byte)2);
                     var10 = var2.getBits(3);
                     var6.method1834(var10, (byte)2);
                     int var11 = var2.getBits(1);
                     if(var11 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
                     }
                  } else if(var8 == 3) {
                     Client.field892[++Client.field926 - 1] = var5;
                  }
               }
            }
         }

         class33.updateNpcs(var0, var1);
         class54.method809(var1);

         int var12;
         for(var12 = 0; var12 < Client.field926; ++var12) {
            var3 = Client.field892[var12];
            if(Client.cachedNPCs[var3].npcCycle != Client.gameCycle) {
               Client.cachedNPCs[var3].composition = null;
               Client.cachedNPCs[var3] = null;
            }
         }

         if(var1.offset != Client.field863.packetLength) {
            throw new RuntimeException(var1.offset + "," + Client.field863.packetLength);
         } else {
            for(var12 = 0; var12 < Client.npcIndexesCount; ++var12) {
               if(Client.cachedNPCs[Client.npcIndices[var12]] == null) {
                  throw new RuntimeException(var12 + "," + Client.npcIndexesCount);
               }
            }

         }
      }
   }
}
