import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public class class56 {
   @ObfuscatedName("e")
   public static Applet field664;
   @ObfuscatedName("n")
   public static String field661;
   @ObfuscatedName("oz")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   static SpritePixels field667;
   @ObfuscatedName("fg")
   @Export("mapRegions")
   @Hook("mapRegionsChanged")
   static int[] mapRegions;
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      longValue = -5967048604218227405L
   )
   static long field665;

   static {
      field664 = null;
      field661 = null;
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "56"
   )
   static final void method811(boolean var0) {
      Client.field1025 = 0;
      Client.pendingNpcFlagsCount = 0;
      Client.secretPacketBuffer2.bitAccess();
      int var1 = Client.secretPacketBuffer2.getBits(8);
      int var2;
      if(var1 < Client.field952) {
         for(var2 = var1; var2 < Client.field952; ++var2) {
            Client.field1026[++Client.field1025 - 1] = Client.npcIndices[var2];
         }
      }

      if(var1 > Client.field952) {
         throw new RuntimeException("");
      } else {
         Client.field952 = 0;

         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = Client.npcIndices[var2];
            NPC var4 = Client.cachedNPCs[var3];
            int var5 = Client.secretPacketBuffer2.getBits(1);
            if(var5 == 0) {
               Client.npcIndices[++Client.field952 - 1] = var3;
               var4.field1245 = Client.gameCycle;
            } else {
               int var6 = Client.secretPacketBuffer2.getBits(2);
               if(var6 == 0) {
                  Client.npcIndices[++Client.field952 - 1] = var3;
                  var4.field1245 = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
               } else {
                  int var7;
                  int var8;
                  if(var6 == 1) {
                     Client.npcIndices[++Client.field952 - 1] = var3;
                     var4.field1245 = Client.gameCycle;
                     var7 = Client.secretPacketBuffer2.getBits(3);
                     var4.method1708(var7, (byte)1);
                     var8 = Client.secretPacketBuffer2.getBits(1);
                     if(var8 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
                     }
                  } else if(var6 == 2) {
                     Client.npcIndices[++Client.field952 - 1] = var3;
                     var4.field1245 = Client.gameCycle;
                     var7 = Client.secretPacketBuffer2.getBits(3);
                     var4.method1708(var7, (byte)2);
                     var8 = Client.secretPacketBuffer2.getBits(3);
                     var4.method1708(var8, (byte)2);
                     int var9 = Client.secretPacketBuffer2.getBits(1);
                     if(var9 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
                     }
                  } else if(var6 == 3) {
                     Client.field1026[++Client.field1025 - 1] = var3;
                  }
               }
            }
         }

         KeyFocusListener.method765(var0);
         class20.method156();

         for(var1 = 0; var1 < Client.field1025; ++var1) {
            var2 = Client.field1026[var1];
            if(Client.cachedNPCs[var2].field1245 != Client.gameCycle) {
               Client.cachedNPCs[var2].composition = null;
               Client.cachedNPCs[var2] = null;
            }
         }

         if(Client.packetLength != Client.secretPacketBuffer2.offset) {
            throw new RuntimeException(Client.secretPacketBuffer2.offset + "," + Client.packetLength);
         } else {
            for(var1 = 0; var1 < Client.field952; ++var1) {
               if(Client.cachedNPCs[Client.npcIndices[var1]] == null) {
                  throw new RuntimeException(var1 + "," + Client.field952);
               }
            }

         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lit;I)V",
      garbageValue = "-1747602930"
   )
   public static void method817(IndexDataBase var0) {
      InvType.field3265 = var0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "26624748"
   )
   public static boolean method816(int var0) {
      return (var0 >> 30 & 1) != 0;
   }
}
