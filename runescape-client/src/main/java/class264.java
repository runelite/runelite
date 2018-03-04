import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jv")
public class class264 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   @Export("NetCache_socket")
   public static class169 NetCache_socket;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1060865487
   )
   public static int field3407;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -5026884098954421215L
   )
   public static long field3414;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("NetCache_pendingPriorityWrites")
   public static HashTable NetCache_pendingPriorityWrites;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 322107395
   )
   @Export("NetCache_pendingPriorityWritesCount")
   public static int NetCache_pendingPriorityWritesCount;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("NetCache_pendingPriorityResponses")
   public static HashTable NetCache_pendingPriorityResponses;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1775089981
   )
   @Export("NetCache_pendingPriorityResponsesCount")
   public static int NetCache_pendingPriorityResponsesCount;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("NetCache_pendingWritesQueue")
   public static Node2LinkedList NetCache_pendingWritesQueue;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("NetCache_pendingWrites")
   public static HashTable NetCache_pendingWrites;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1689803525
   )
   @Export("NetCache_pendingWritesCount")
   public static int NetCache_pendingWritesCount;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("NetCache_pendingResponses")
   public static HashTable NetCache_pendingResponses;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -643663023
   )
   @Export("NetCache_pendingResponsesCount")
   public static int NetCache_pendingResponsesCount;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("NetCache_responseHeaderBuffer")
   public static Buffer NetCache_responseHeaderBuffer;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("NetCache_responseArchiveBuffer")
   public static Buffer NetCache_responseArchiveBuffer;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 742200297
   )
   public static int field3412;
   @ObfuscatedName("b")
   @Export("NetCache_crc")
   public static CRC32 NetCache_crc;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "[Ljs;"
   )
   @Export("NetCache_indexCaches")
   public static IndexData[] NetCache_indexCaches;
   @ObfuscatedName("l")
   public static byte field3422;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1619644399
   )
   public static int field3423;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 582234941
   )
   public static int field3421;

   static {
      field3407 = 0;
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
      field3412 = 0;
      NetCache_crc = new CRC32();
      NetCache_indexCaches = new IndexData[256];
      field3422 = 0;
      field3423 = 0;
      field3421 = 0;
   }
}
