import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
public class class245 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   @Export("NetCache_socket")
   public static RSSocket NetCache_socket;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1687862061
   )
   public static int field3336;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 4332361165556637533L
   )
   public static long field3334;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("NetCache_pendingPriorityWrites")
   public static HashTable NetCache_pendingPriorityWrites;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1743666739
   )
   @Export("NetCache_pendingPriorityWritesCount")
   public static int NetCache_pendingPriorityWritesCount;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("NetCache_pendingPriorityResponses")
   public static HashTable NetCache_pendingPriorityResponses;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1541821165
   )
   @Export("NetCache_pendingPriorityResponsesCount")
   public static int NetCache_pendingPriorityResponsesCount;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("NetCache_pendingWritesQueue")
   public static Node2LinkedList NetCache_pendingWritesQueue;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("NetCache_pendingWrites")
   public static HashTable NetCache_pendingWrites;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 471445881
   )
   @Export("NetCache_pendingWritesCount")
   public static int NetCache_pendingWritesCount;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("NetCache_pendingResponses")
   public static HashTable NetCache_pendingResponses;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -969525747
   )
   @Export("NetCache_pendingResponsesCount")
   public static int NetCache_pendingResponsesCount;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   @Export("NetCache_responseHeaderBuffer")
   public static Buffer NetCache_responseHeaderBuffer;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   @Export("NetCache_responseArchiveBuffer")
   public static Buffer NetCache_responseArchiveBuffer;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -268889211
   )
   public static int field3326;
   @ObfuscatedName("e")
   @Export("NetCache_crc")
   public static CRC32 NetCache_crc;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   @Export("NetCache_reference")
   public static Buffer NetCache_reference;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "[Liv;"
   )
   @Export("NetCache_indexCaches")
   public static IndexData[] NetCache_indexCaches;
   @ObfuscatedName("i")
   public static byte field3340;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 952028285
   )
   public static int field3325;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1056779177
   )
   public static int field3342;

   static {
      field3336 = 0;
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
      field3326 = 0;
      NetCache_crc = new CRC32();
      NetCache_indexCaches = new IndexData[256];
      field3340 = 0;
      field3325 = 0;
      field3342 = 0;
   }
}
