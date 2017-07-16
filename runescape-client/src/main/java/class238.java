import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
public class class238 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -925169405
   )
   public static int field3258;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1523340189
   )
   public static int field3253;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   public static XHashTable field3260;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -618498043
   )
   public static int field3252;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   public static XHashTable field3255;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   public static Node2LinkedList field3259;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -902905159
   )
   public static int field3272;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   public static XHashTable field3269;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 7278569845670085851L
   )
   public static long field3254;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1940519003
   )
   public static int field3257;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   public static XHashTable field3262;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1450828023
   )
   public static int field3263;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -260113921
   )
   public static int field3256;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "[Lig;"
   )
   static IndexData[] field3267;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   public static RSSocket field3264;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   public static Buffer field3266;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -395343811
   )
   public static int field3265;
   @ObfuscatedName("f")
   static CRC32 field3261;
   @ObfuscatedName("i")
   public static byte field3268;

   static {
      field3253 = 0;
      field3255 = new XHashTable(4096);
      field3272 = 0;
      field3269 = new XHashTable(32);
      field3257 = 0;
      field3259 = new Node2LinkedList();
      field3260 = new XHashTable(4096);
      field3256 = 0;
      field3262 = new XHashTable(4096);
      field3263 = 0;
      field3266 = new Buffer(8);
      field3265 = 0;
      field3261 = new CRC32();
      field3267 = new IndexData[256];
      field3268 = 0;
      field3258 = 0;
      field3252 = 0;
   }
}
