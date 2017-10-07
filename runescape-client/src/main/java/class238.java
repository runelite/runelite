import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
public class class238 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1541399361
   )
   public static int field3257;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1149179185
   )
   public static int field3252;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   public static HashTable field3259;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 740684121
   )
   public static int field3271;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   public static HashTable field3251;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   public static Node2LinkedList field3258;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("currentRequest")
   public static FileRequest currentRequest;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 532267269
   )
   public static int field3255;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   public static HashTable field3256;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 3919691914862641059L
   )
   public static long field3268;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 836154213
   )
   public static int field3253;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   public static HashTable field3261;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1450329009
   )
   public static int field3254;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Lij;"
   )
   static IndexData[] field3260;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1496817713
   )
   public static int field3262;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   public static RSSocket field3265;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   public static Buffer field3270;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 849855347
   )
   public static int field3266;
   @ObfuscatedName("c")
   static CRC32 field3267;
   @ObfuscatedName("z")
   public static byte field3269;
   @ObfuscatedName("i")
   static boolean field3263;

   static {
      field3252 = 0;
      field3251 = new HashTable(4096);
      field3255 = 0;
      field3256 = new HashTable(32);
      field3253 = 0;
      field3258 = new Node2LinkedList();
      field3259 = new HashTable(4096);
      field3254 = 0;
      field3261 = new HashTable(4096);
      field3262 = 0;
      field3270 = new Buffer(8);
      field3266 = 0;
      field3267 = new CRC32();
      field3260 = new IndexData[256];
      field3269 = 0;
      field3257 = 0;
      field3271 = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1048650421"
   )
   public static boolean method4362(int var0) {
      return var0 >= class221.field2826.field2838 && var0 <= class221.field2836.field2838;
   }
}
