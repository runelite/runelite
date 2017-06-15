import java.awt.FontMetrics;
import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
public class class238 {
   @ObfuscatedName("p")
   public static RSSocket field3258;
   @ObfuscatedName("i")
   static Node2LinkedList field3259;
   @ObfuscatedName("t")
   static XHashTable field3260;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2143355021
   )
   public static int field3261;
   @ObfuscatedName("z")
   static XHashTable field3262;
   @ObfuscatedName("o")
   static XHashTable field3263;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1117941151
   )
   static int field3264;
   @ObfuscatedName("f")
   static XHashTable field3265;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 172578517
   )
   static int field3266;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 461071169
   )
   public static int field3267;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1280087603
   )
   public static int field3268;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1141909575
   )
   public static int field3269;
   @ObfuscatedName("g")
   static Buffer field3270;
   @ObfuscatedName("r")
   static CRC32 field3271;
   @ObfuscatedName("l")
   static Buffer field3272;
   @ObfuscatedName("h")
   static IndexData[] field3273;
   @ObfuscatedName("d")
   static byte field3274;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -626195793
   )
   public static int field3275;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -966780787
   )
   public static int field3276;
   @ObfuscatedName("ap")
   static FontMetrics field3277;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 7595135634736416329L
   )
   static long field3278;

   static {
      field3266 = 0;
      field3260 = new XHashTable(4096);
      field3267 = 0;
      field3262 = new XHashTable(32);
      field3269 = 0;
      field3259 = new Node2LinkedList();
      field3265 = new XHashTable(4096);
      field3261 = 0;
      field3263 = new XHashTable(4096);
      field3268 = 0;
      field3270 = new Buffer(8);
      field3264 = 0;
      field3271 = new CRC32();
      field3273 = new IndexData[256];
      field3274 = 0;
      field3275 = 0;
      field3276 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "1693908992"
   )
   public static void method4138(IndexDataBase var0) {
      class240.field3288 = var0;
   }
}
