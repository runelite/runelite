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
   static int field1146;
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
   public final int field1147;
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
      this.field1147 = var2;
      this.field18 = var3;
      this.field19 = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.field1147;
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
      while (true) {
         NodeDeque var0 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
         ArchiveDiskAction var1;
         synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
            var1 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_responseQueue.removeLast();
         }

         if (var1 == null) {
            return;
         }

         var1.archive.load(var1.archiveDisk, (int)var1.key, var1.data, false);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "653716649"
   )
   @Export("doWorldSorting")
   static void doWorldSorting(int lowestUnsorted, int highestUnsorted, int primaryMode, boolean primaryReversed, int secondaryMode, boolean secondaryReversed) {
      if (lowestUnsorted < highestUnsorted) {
         int var6 = (lowestUnsorted + highestUnsorted) / 2;
         int var7 = lowestUnsorted;
         World var8 = ItemContainer.worlds[var6];
         ItemContainer.worlds[var6] = ItemContainer.worlds[highestUnsorted];
         ItemContainer.worlds[highestUnsorted] = var8;

         for (int var9 = lowestUnsorted; var9 < highestUnsorted; ++var9) {
            World var10 = ItemContainer.worlds[var9];
            int var11 = WorldMapLabel.compareWorlds(var10, var8, primaryMode, primaryReversed);
            int var12;
            if (var11 != 0) {
               if (primaryReversed) {
                  var12 = -var11;
               } else {
                  var12 = var11;
               }
            } else if (secondaryMode == -1) {
               var12 = 0;
            } else {
               int var13 = WorldMapLabel.compareWorlds(var10, var8, secondaryMode, secondaryReversed);
               if (secondaryReversed) {
                  var12 = -var13;
               } else {
                  var12 = var13;
               }
            }

            if (var12 <= 0) {
               World var14 = ItemContainer.worlds[var9];
               ItemContainer.worlds[var9] = ItemContainer.worlds[var7];
               ItemContainer.worlds[var7++] = var14;
            }
         }

         ItemContainer.worlds[highestUnsorted] = ItemContainer.worlds[var7];
         ItemContainer.worlds[var7] = var8;
         doWorldSorting(lowestUnsorted, var7 - 1, primaryMode, primaryReversed, secondaryMode, secondaryReversed);
         doWorldSorting(var7 + 1, highestUnsorted, primaryMode, primaryReversed, secondaryMode, secondaryReversed);
      }

   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(ZLhx;B)V",
      garbageValue = "1"
   )
   @Export("updateNpcs")
   static final void updateNpcs(boolean var0, PacketBuffer var1) {
      Client.field211 = 0;
      Client.field173 = 0;
      PacketBuffer var2 = Client.packetWriter.packetBuffer;
      var2.importIndex();
      int var3 = var2.readBits(8);
      int var4;
      if (var3 < Client.npcCount) {
         for (var4 = var3; var4 < Client.npcCount; ++var4) {
            Client.field212[++Client.field211 - 1] = Client.npcIndices[var4];
         }
      }

      if (var3 > Client.npcCount) {
         throw new RuntimeException("");
      } else {
         Client.npcCount = 0;

         int var5;
         int var6;
         int var7;
         int var8;
         for (var4 = 0; var4 < var3; ++var4) {
            var5 = Client.npcIndices[var4];
            NPC var9 = Client.npcs[var5];
            var6 = var2.readBits(1);
            if (var6 == 0) {
               Client.npcIndices[++Client.npcCount - 1] = var5;
               var9.npcCycle = Client.cycle;
            } else {
               var7 = var2.readBits(2);
               if (var7 == 0) {
                  Client.npcIndices[++Client.npcCount - 1] = var5;
                  var9.npcCycle = Client.cycle;
                  Client.field174[++Client.field173 - 1] = var5;
               } else {
                  int var10;
                  if (var7 == 1) {
                     Client.npcIndices[++Client.npcCount - 1] = var5;
                     var9.npcCycle = Client.cycle;
                     var8 = var2.readBits(3);
                     var9.method227(var8, (byte)1);
                     var10 = var2.readBits(1);
                     if (var10 == 1) {
                        Client.field174[++Client.field173 - 1] = var5;
                     }
                  } else if (var7 == 2) {
                     Client.npcIndices[++Client.npcCount - 1] = var5;
                     var9.npcCycle = Client.cycle;
                     var8 = var2.readBits(3);
                     var9.method227(var8, (byte)2);
                     var10 = var2.readBits(3);
                     var9.method227(var10, (byte)2);
                     int var11 = var2.readBits(1);
                     if (var11 == 1) {
                        Client.field174[++Client.field173 - 1] = var5;
                     }
                  } else if (var7 == 3) {
                     Client.field212[++Client.field211 - 1] = var5;
                  }
               }
            }
         }

         int var13;
         while (var1.bitsRemaining(Client.packetWriter.serverPacket0Length) >= 27) {
            var13 = var1.readBits(15);
            if (var13 == 32767) {
               break;
            }

            boolean var14 = false;
            if (Client.npcs[var13] == null) {
               Client.npcs[var13] = new NPC();
               var14 = true;
            }

            NPC var15 = Client.npcs[var13];
            Client.npcIndices[++Client.npcCount - 1] = var13;
            var15.npcCycle = Client.cycle;
            if (var0) {
               var5 = var1.readBits(8);
               if (var5 > 127) {
                  var5 -= 256;
               }
            } else {
               var5 = var1.readBits(5);
               if (var5 > 15) {
                  var5 -= 32;
               }
            }

            int var12 = var1.readBits(1);
            var6 = Client.field213[var1.readBits(3)];
            if (var14) {
               var15.orientation = var15.field9 = var6;
            }

            var7 = var1.readBits(1);
            if (var7 == 1) {
               Client.field174[++Client.field173 - 1] = var13;
            }

            if (var0) {
               var8 = var1.readBits(8);
               if (var8 > 127) {
                  var8 -= 256;
               }
            } else {
               var8 = var1.readBits(5);
               if (var8 > 15) {
                  var8 -= 32;
               }
            }

            var15.definition = ObjectDefinition.getNpcDefinition(var1.readBits(14));
            var15.size = var15.definition.size;
            var15.field23 = var15.definition.field639;
            if (var15.field23 == 0) {
               var15.field9 = 0;
            }

            var15.walkSequence = var15.definition.walkSequence;
            var15.walkBackSequence = var15.definition.walkBackSequence;
            var15.walkLeftSequence = var15.definition.walkLeftSequence;
            var15.walkRightSequence = var15.definition.walkRightSequence;
            var15.readySequence = var15.definition.readySequence;
            var15.turnLeftSequence = var15.definition.turnLeftSequence;
            var15.turnRightSequence = var15.definition.turnRightSequence;
            var15.method228(Canvas.localPlayer.pathX[0] + var5, Canvas.localPlayer.pathY[0] + var8, var12 == 1);
         }

         var1.exportIndex();
         GrandExchangeOfferWorldComparator.method67(var1);

         for (var13 = 0; var13 < Client.field211; ++var13) {
            var3 = Client.field212[var13];
            if (Client.npcs[var3].npcCycle != Client.cycle) {
               Client.npcs[var3].definition = null;
               Client.npcs[var3] = null;
            }
         }

         if (var1.index != Client.packetWriter.serverPacket0Length) {
            throw new RuntimeException(var1.index + "," + Client.packetWriter.serverPacket0Length);
         } else {
            for (var13 = 0; var13 < Client.npcCount; ++var13) {
               if (Client.npcs[Client.npcIndices[var13]] == null) {
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
