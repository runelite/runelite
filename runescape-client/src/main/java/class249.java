import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
public class class249 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("NetCache_socket")
   public static class159 NetCache_socket;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1680320083
   )
   public static int field3321;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("NetCache_pendingPriorityWrites")
   public static HashTable NetCache_pendingPriorityWrites;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1499132799
   )
   @Export("NetCache_pendingPriorityWritesCount")
   public static int NetCache_pendingPriorityWritesCount;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("NetCache_pendingPriorityResponses")
   public static HashTable NetCache_pendingPriorityResponses;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1237623359
   )
   @Export("NetCache_pendingPriorityResponsesCount")
   public static int NetCache_pendingPriorityResponsesCount;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   @Export("NetCache_pendingWritesQueue")
   public static Node2LinkedList NetCache_pendingWritesQueue;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("NetCache_pendingWrites")
   public static HashTable NetCache_pendingWrites;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 802173707
   )
   @Export("NetCache_pendingWritesCount")
   public static int NetCache_pendingWritesCount;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("NetCache_pendingResponses")
   public static HashTable NetCache_pendingResponses;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1900325037
   )
   @Export("NetCache_pendingResponsesCount")
   public static int NetCache_pendingResponsesCount;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("NetCache_responseHeaderBuffer")
   public static Buffer NetCache_responseHeaderBuffer;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 104223031
   )
   public static int field3332;
   @ObfuscatedName("f")
   @Export("NetCache_crc")
   static CRC32 NetCache_crc;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "[Lio;"
   )
   @Export("NetCache_indexCaches")
   static IndexData[] NetCache_indexCaches;
   @ObfuscatedName("u")
   public static byte field3335;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1394993845
   )
   public static int field3336;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 825989703
   )
   public static int field3337;

   static {
      field3321 = 0;
      NetCache_pendingPriorityWrites = new HashTable(4096);
      NetCache_pendingPriorityWritesCount = 0;
      NetCache_pendingPriorityResponses = new HashTable(32);
      NetCache_pendingPriorityResponsesCount = 0;
      NetCache_pendingWritesQueue = new Node2LinkedList();
      NetCache_pendingWrites = new HashTable(4096);
      NetCache_pendingWritesCount = 0;
      NetCache_pendingResponses = new HashTable(4096);
      NetCache_pendingResponsesCount = 0;
      NetCache_responseHeaderBuffer = new Buffer(8);
      field3332 = 0;
      NetCache_crc = new CRC32();
      NetCache_indexCaches = new IndexData[256];
      field3335 = 0;
      field3336 = 0;
      field3337 = 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgj;IIIIIIB)V",
      garbageValue = "-89"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class61.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class61.tileHeights[0][var2];
                  int var11 = var2 + var4 + 932731;
                  int var12 = var3 + var5 + 556238;
                  int var13 = Preferences.getSmoothNoise(var11 + 45365, 91923 + var12, 4) - 128 + (Preferences.getSmoothNoise(10294 + var11, 37821 + var12, 2) - 128 >> 1) + (Preferences.getSmoothNoise(var11, var12, 1) - 128 >> 2);
                  var13 = (int)(0.3D * (double)var13) + 35;
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = -var13 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.readUnsignedByte();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -var14 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - var14 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class61.field687[var1][var2][var3] = var0.readByte();
               class61.field688[var1][var2][var3] = (byte)((var7 - 2) / 4);
               IndexFile.field2159[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class61.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class25.field352[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }
}
