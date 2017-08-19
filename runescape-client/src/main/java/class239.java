import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
public class class239 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1365176013
   )
   public static int field3255;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1750472895
   )
   public static int field3237;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   public static HashTable field3239;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1167829465
   )
   public static int field3256;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   public static HashTable field3250;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   public static Node2LinkedList field3243;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1365407123
   )
   public static int field3240;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   @Export("currentRequest")
   public static FileRequest currentRequest;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   public static HashTable field3241;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -9032892039466249519L
   )
   public static long field3252;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1804690489
   )
   public static int field3242;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   public static HashTable field3253;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 103642023
   )
   public static int field3245;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "[Lil;"
   )
   public static IndexData[] field3236;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 327433949
   )
   public static int field3247;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   public static RSSocket field3246;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   public static Buffer field3238;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -715067237
   )
   public static int field3251;
   @ObfuscatedName("t")
   public static CRC32 field3249;
   @ObfuscatedName("u")
   public static byte field3254;
   @ObfuscatedName("i")
   public static boolean field3248;

   static {
      field3237 = 0;
      field3250 = new HashTable(4096);
      field3240 = 0;
      field3241 = new HashTable(32);
      field3242 = 0;
      field3243 = new Node2LinkedList();
      field3239 = new HashTable(4096);
      field3245 = 0;
      field3253 = new HashTable(4096);
      field3247 = 0;
      field3238 = new Buffer(8);
      field3251 = 0;
      field3249 = new CRC32();
      field3236 = new IndexData[256];
      field3254 = 0;
      field3255 = 0;
      field3256 = 0;
   }
}
