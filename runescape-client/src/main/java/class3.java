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
   public int ordinal() {
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
         NodeDeque var0 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         NodeDeque var2 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         IndexStoreAction var1;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            var1 = (IndexStoreAction)IndexStoreActionHandler.IndexStoreActionHandler_responseQueue.removeLast();
         }

         if(var1 == null) {
            return;
         }

         var1.indexCache.load(var1.indexStore, (int)var1.key, var1.data, false);
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
            World var10 = ItemContainer.worlds[var9];
            int var11 = WorldMapLabel.compareWorlds(var10, var8, var2, var3);
            int var12;
            if(var11 != 0) {
               if(var3) {
                  var12 = -var11;
               } else {
                  var12 = var11;
               }
            } else if(var4 == -1) {
               var12 = 0;
            } else {
               int var13 = WorldMapLabel.compareWorlds(var10, var8, var4, var5);
               if(var5) {
                  var12 = -var13;
               } else {
                  var12 = var13;
               }
            }

            if(var12 <= 0) {
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
         int var6;
         int var7;
         int var8;
         for(var4 = 0; var4 < var3; ++var4) {
            var5 = Client.npcIndices[var4];
            NPC var9 = Client.npcs[var5];
            var6 = var2.readBits(1);
            if(var6 == 0) {
               Client.npcIndices[++Client.npcCount - 1] = var5;
               var9.npcCycle = Client.cycle;
            } else {
               var7 = var2.readBits(2);
               if(var7 == 0) {
                  Client.npcIndices[++Client.npcCount - 1] = var5;
                  var9.npcCycle = Client.cycle;
                  Client.__client_fg[++Client.__client_fw - 1] = var5;
               } else {
                  int var10;
                  if(var7 == 1) {
                     Client.npcIndices[++Client.npcCount - 1] = var5;
                     var9.npcCycle = Client.cycle;
                     var8 = var2.readBits(3);
                     var9.__m_162(var8, (byte)1);
                     var10 = var2.readBits(1);
                     if(var10 == 1) {
                        Client.__client_fg[++Client.__client_fw - 1] = var5;
                     }
                  } else if(var7 == 2) {
                     Client.npcIndices[++Client.npcCount - 1] = var5;
                     var9.npcCycle = Client.cycle;
                     var8 = var2.readBits(3);
                     var9.__m_162(var8, (byte)2);
                     var10 = var2.readBits(3);
                     var9.__m_162(var10, (byte)2);
                     int var11 = var2.readBits(1);
                     if(var11 == 1) {
                        Client.__client_fg[++Client.__client_fw - 1] = var5;
                     }
                  } else if(var7 == 3) {
                     Client.__client_kd[++Client.__client_ky - 1] = var5;
                  }
               }
            }
         }

         int var13;
         while(var1.bitsRemaining(Client.packetWriter.serverPacket0Length) >= 27) {
            var13 = var1.readBits(15);
            if(var13 == 32767) {
               break;
            }

            boolean var14 = false;
            if(Client.npcs[var13] == null) {
               Client.npcs[var13] = new NPC();
               var14 = true;
            }

            NPC var15 = Client.npcs[var13];
            Client.npcIndices[++Client.npcCount - 1] = var13;
            var15.npcCycle = Client.cycle;
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

            int var12 = var1.readBits(1);
            var6 = Client.__client_kn[var1.readBits(3)];
            if(var14) {
               var15.orientation = var15.__ac = var6;
            }

            var7 = var1.readBits(1);
            if(var7 == 1) {
               Client.__client_fg[++Client.__client_fw - 1] = var13;
            }

            if(var0) {
               var8 = var1.readBits(8);
               if(var8 > 127) {
                  var8 -= 256;
               }
            } else {
               var8 = var1.readBits(5);
               if(var8 > 15) {
                  var8 -= 32;
               }
            }

            var15.definition = ObjectDefinition.getNpcDefinition(var1.readBits(14));
            var15.size = var15.definition.size;
            var15.__cj = var15.definition.__av;
            if(var15.__cj == 0) {
               var15.__ac = 0;
            }

            var15.walkSequence = var15.definition.walkSequence;
            var15.walkTurnSequence = var15.definition.walkTurnSequence;
            var15.walkTurnLeftSequence = var15.definition.walkTurnLeftSequence;
            var15.walkTurnRightSequence = var15.definition.walkTurnRightSequence;
            var15.idleSequence = var15.definition.idleSequence;
            var15.turnLeftSequence = var15.definition.turnLeftSequence;
            var15.turnRightSequence = var15.definition.turnRightSequence;
            var15.__f_163(Canvas.localPlayer.pathX[0] + var5, Canvas.localPlayer.pathY[0] + var8, var12 == 1);
         }

         var1.exportIndex();
         WorldComparator.method67(var1);

         for(var13 = 0; var13 < Client.__client_ky; ++var13) {
            var3 = Client.__client_kd[var13];
            if(Client.npcs[var3].npcCycle != Client.cycle) {
               Client.npcs[var3].definition = null;
               Client.npcs[var3] = null;
            }
         }

         if(var1.index != Client.packetWriter.serverPacket0Length) {
            throw new RuntimeException(var1.index + "," + Client.packetWriter.serverPacket0Length);
         } else {
            for(var13 = 0; var13 < Client.npcCount; ++var13) {
               if(Client.npcs[Client.npcIndices[var13]] == null) {
                  throw new RuntimeException(var13 + "," + Client.npcCount);
               }
            }

         }
      }
   }

   static {
      field20 = new class3(2, 0, Integer.class, new class1());
      field14 = new class3(0, 1, Long.class, new class2());
      field15 = new class3(1, 2, String.class, new class4());
   }
}
