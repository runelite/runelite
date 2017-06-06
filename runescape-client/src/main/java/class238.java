import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ih")
public class class238 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1246184993
   )
   static int field3250;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -6145251187203763529L
   )
   static long field3251;
   @ObfuscatedName("v")
   static XHashTable field3252;
   @ObfuscatedName("f")
   static XHashTable field3253;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -759874923
   )
   static int field3255;
   @ObfuscatedName("x")
   static Node2LinkedList field3256;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1932032927
   )
   static int field3258;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1459556007
   )
   static int field3259;
   @ObfuscatedName("w")
   static byte field3260;
   @ObfuscatedName("j")
   static Buffer field3261;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 58520581
   )
   static int field3262;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1086548325
   )
   public static int field3263;
   @ObfuscatedName("d")
   static CRC32 field3264;
   @ObfuscatedName("g")
   static IndexData[] field3265;
   @ObfuscatedName("y")
   static XHashTable field3266;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1977385529
   )
   public static int field3267;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -666479007
   )
   static int field3268;
   @ObfuscatedName("a")
   static XHashTable field3269;

   static {
      field3268 = 0;
      field3252 = new XHashTable(4096);
      field3259 = 0;
      field3266 = new XHashTable(32);
      field3255 = 0;
      field3256 = new Node2LinkedList();
      field3253 = new XHashTable(4096);
      field3258 = 0;
      field3269 = new XHashTable(4096);
      field3250 = 0;
      field3261 = new Buffer(8);
      field3262 = 0;
      field3264 = new CRC32();
      field3265 = new IndexData[256];
      field3260 = 0;
      field3267 = 0;
      field3263 = 0;
   }
}
