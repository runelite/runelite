import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class3 implements Enumerated {
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = 1608439891
   )
   @Export("__w_qs")
   static int __w_qs;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   static final class3 field20;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   static final class3 field14;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   static final class3 field15;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1621503295
   )
   final int field13;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -393250053
   )
   public final int field17;
   @ObfuscatedName("u")
   public final Class field18;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lm;"
   )
   public final class0 field19;

   static {
      field20 = new class3(2, 0, Integer.class, new class1());
      field14 = new class3(0, 1, Long.class, new class2());
      field15 = new class3(1, 2, String.class, new class4());
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;Lm;)V"
   )
   class3(int var1, int var2, Class var3, class0 var4) {
      this.field13 = var1;
      this.field17 = var2;
      this.field18 = var3;
      this.field19 = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   public int rsOrdinal() {
      return this.field17;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;I)Ljava/lang/Object;",
      garbageValue = "1915331486"
   )
   public Object method31(Buffer var1) {
      return this.field19.vmethod46(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)[Lw;",
      garbageValue = "23"
   )
   public static class3[] method34() {
      return new class3[]{field15, field20, field14};
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "772942762"
   )
   static int method36() {
      return 11;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "729662922"
   )
   public static void method41() {
      while(true) {
         NodeDeque var1 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         IndexStoreAction var0;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            var0 = (IndexStoreAction)IndexStoreActionHandler.IndexStoreActionHandler_responseQueue.removeLast();
         }

         if(var0 == null) {
            return;
         }

         var0.indexCache.load(var0.indexStore, (int)var0.key, var0.data, false);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "653716649"
   )
   static void method42(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = ItemContainer.worlds[var6];
         ItemContainer.worlds[var6] = ItemContainer.worlds[var1];
         ItemContainer.worlds[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = ItemContainer.worlds[var9];
            int var12 = WorldMapLabel.compareWorlds(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = WorldMapLabel.compareWorlds(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = ItemContainer.worlds[var9];
               ItemContainer.worlds[var9] = ItemContainer.worlds[var7];
               ItemContainer.worlds[var7++] = var14;
            }
         }

         ItemContainer.worlds[var1] = ItemContainer.worlds[var7];
         ItemContainer.worlds[var7] = var8;
         method42(var0, var7 - 1, var2, var3, var4, var5);
         method42(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(ZLhx;B)V",
      garbageValue = "1"
   )
   @Export("updateNpcs")
   static final void updateNpcs(boolean var0, PacketBuffer var1) {
      Client.__client_ky = 0;
      Client.__client_fw = 0;
      PacketBuffer var2 = Client.packetWriter.packetBuffer;
      var2.importIndex();
      int var3 = var2.readBits(8);
      int var4;
      if(var3 < Client.npcCount) {
         for(var4 = var3; var4 < Client.npcCount; ++var4) {
            Client.__client_kd[++Client.__client_ky - 1] = Client.npcIndices[var4];
         }
      }

      if(var3 > Client.npcCount) {
         throw new RuntimeException("");
      } else {
         Client.npcCount = 0;

         int var5;
         int var7;
         int var8;
         int var9;
         for(var4 = 0; var4 < var3; ++var4) {
            var5 = Client.npcIndices[var4];
            Npc var6 = Client.npcs[var5];
            var7 = var2.readBits(1);
            if(var7 == 0) {
               Client.npcIndices[++Client.npcCount - 1] = var5;
               var6.npcCycle = Client.cycle;
            } else {
               var8 = var2.readBits(2);
               if(var8 == 0) {
                  Client.npcIndices[++Client.npcCount - 1] = var5;
                  var6.npcCycle = Client.cycle;
                  Client.__client_fg[++Client.__client_fw - 1] = var5;
               } else {
                  int var10;
                  if(var8 == 1) {
                     Client.npcIndices[++Client.npcCount - 1] = var5;
                     var6.npcCycle = Client.cycle;
                     var9 = var2.readBits(3);
                     var6.__m_162(var9, (byte)1);
                     var10 = var2.readBits(1);
                     if(var10 == 1) {
                        Client.__client_fg[++Client.__client_fw - 1] = var5;
                     }
                  } else if(var8 == 2) {
                     Client.npcIndices[++Client.npcCount - 1] = var5;
                     var6.npcCycle = Client.cycle;
                     var9 = var2.readBits(3);
                     var6.__m_162(var9, (byte)2);
                     var10 = var2.readBits(3);
                     var6.__m_162(var10, (byte)2);
                     int var11 = var2.readBits(1);
                     if(var11 == 1) {
                        Client.__client_fg[++Client.__client_fw - 1] = var5;
                     }
                  } else if(var8 == 3) {
                     Client.__client_kd[++Client.__client_ky - 1] = var5;
                  }
               }
            }
         }

         int var12;
         while(var1.bitsRemaining(Client.packetWriter.serverPacket0Length) >= 27) {
            var12 = var1.readBits(15);
            if(var12 == 32767) {
               break;
            }

            boolean var15 = false;
            if(Client.npcs[var12] == null) {
               Client.npcs[var12] = new Npc();
               var15 = true;
            }

            Npc var13 = Client.npcs[var12];
            Client.npcIndices[++Client.npcCount - 1] = var12;
            var13.npcCycle = Client.cycle;
            if(var0) {
               var5 = var1.readBits(8);
               if(var5 > 127) {
                  var5 -= 256;
               }
            } else {
               var5 = var1.readBits(5);
               if(var5 > 15) {
                  var5 -= 32;
               }
            }

            int var14 = var1.readBits(1);
            var7 = Client.__client_kn[var1.readBits(3)];
            if(var15) {
               var13.orientation = var13.__ac = var7;
            }

            var8 = var1.readBits(1);
            if(var8 == 1) {
               Client.__client_fg[++Client.__client_fw - 1] = var12;
            }

            if(var0) {
               var9 = var1.readBits(8);
               if(var9 > 127) {
                  var9 -= 256;
               }
            } else {
               var9 = var1.readBits(5);
               if(var9 > 15) {
                  var9 -= 32;
               }
            }

            var13.definition = ObjectDefinition.getNpcDefinition(var1.readBits(14));
            var13.size = var13.definition.size;
            var13.__cj = var13.definition.__av;
            if(var13.__cj == 0) {
               var13.__ac = 0;
            }

            var13.walkSequence = var13.definition.walkSequence;
            var13.walkTurnSequence = var13.definition.walkTurnSequence;
            var13.walkTurnLeftSequence = var13.definition.walkTurnLeftSequence;
            var13.walkTurnRightSequence = var13.definition.walkTurnRightSequence;
            var13.idleSequence = var13.definition.idleSequence;
            var13.turnLeftSequence = var13.definition.turnLeftSequence;
            var13.turnRightSequence = var13.definition.turnRightSequence;
            var13.__f_163(Canvas.localPlayer.pathX[0] + var5, Canvas.localPlayer.pathY[0] + var9, var14 == 1);
         }

         var1.exportIndex();
         WorldComparator.method67(var1);

         for(var12 = 0; var12 < Client.__client_ky; ++var12) {
            var3 = Client.__client_kd[var12];
            if(Client.npcs[var3].npcCycle != Client.cycle) {
               Client.npcs[var3].definition = null;
               Client.npcs[var3] = null;
            }
         }

         if(var1.index != Client.packetWriter.serverPacket0Length) {
            throw new RuntimeException(var1.index + "," + Client.packetWriter.serverPacket0Length);
         } else {
            for(var12 = 0; var12 < Client.npcCount; ++var12) {
               if(Client.npcs[Client.npcIndices[var12]] == null) {
                  throw new RuntimeException(var12 + "," + Client.npcCount);
               }
            }

         }
      }
   }
}
