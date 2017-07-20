import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
public class class238 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1891706057
   )
   public static int field3240;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1771074653
   )
   public static int field3229;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   public static XHashTable field3227;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 295162567
   )
   public static int field3241;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   public static XHashTable field3224;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   public static Node2LinkedList field3232;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   @Export("currentRequest")
   public static FileRequest currentRequest;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 354672287
   )
   public static int field3225;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   public static XHashTable field3233;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 18000550360069087L
   )
   public static long field3223;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1091411351
   )
   public static int field3238;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   public static XHashTable field3231;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1864044107
   )
   public static int field3221;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "[Lix;"
   )
   public static IndexData[] field3242;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1730041669
   )
   public static int field3228;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   public static RSSocket field3226;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   public static Buffer field3234;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1977859723
   )
   public static int field3235;
   @ObfuscatedName("l")
   public static CRC32 field3222;
   @ObfuscatedName("j")
   public static byte field3239;

   static {
      field3229 = 0;
      field3224 = new XHashTable(4096);
      field3225 = 0;
      field3233 = new XHashTable(32);
      field3238 = 0;
      field3232 = new Node2LinkedList();
      field3227 = new XHashTable(4096);
      field3221 = 0;
      field3231 = new XHashTable(4096);
      field3228 = 0;
      field3234 = new Buffer(8);
      field3235 = 0;
      field3222 = new CRC32();
      field3242 = new IndexData[256];
      field3239 = 0;
      field3240 = 0;
      field3241 = 0;
   }
}
