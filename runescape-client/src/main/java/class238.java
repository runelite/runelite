import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
public class class238 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 611729479
   )
   public static int field3251;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1970363361
   )
   public static int field3237;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   public static XHashTable field3241;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2136181301
   )
   public static int field3252;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   public static XHashTable field3236;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   public static Node2LinkedList field3240;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -730578129
   )
   public static int field3234;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   public static XHashTable field3246;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 8692593935689875395L
   )
   public static long field3242;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 86022979
   )
   public static int field3238;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   public static XHashTable field3233;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 813075237
   )
   public static int field3244;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1513243915
   )
   public static int field3243;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Lib;"
   )
   static IndexData[] field3249;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   public static RSSocket field3235;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   public static Buffer field3239;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 160362195
   )
   public static int field3247;
   @ObfuscatedName("n")
   static CRC32 field3248;
   @ObfuscatedName("m")
   public static byte field3250;
   @ObfuscatedName("o")
   static boolean field3245;

   static {
      field3237 = 0;
      field3236 = new XHashTable(4096);
      field3234 = 0;
      field3246 = new XHashTable(32);
      field3238 = 0;
      field3240 = new Node2LinkedList();
      field3241 = new XHashTable(4096);
      field3243 = 0;
      field3233 = new XHashTable(4096);
      field3244 = 0;
      field3239 = new Buffer(8);
      field3247 = 0;
      field3248 = new CRC32();
      field3249 = new IndexData[256];
      field3250 = 0;
      field3251 = 0;
      field3252 = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfy;I)I",
      garbageValue = "1862997463"
   )
   static int method4236(PacketBuffer var0) {
      int var1 = var0.getBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.getBits(5);
      } else if(var1 == 2) {
         var2 = var0.getBits(8);
      } else {
         var2 = var0.getBits(11);
      }

      return var2;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(ILhy;ZB)V",
      garbageValue = "-117"
   )
   static void method4243(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = class14.method80().method5218(var0);
      int var4 = class224.localPlayer.field881;
      int var5 = (class224.localPlayer.x >> 7) + class33.baseX;
      int var6 = (class224.localPlayer.y >> 7) + class17.baseY;
      Coordinates var7 = new Coordinates(var4, var5, var6);
      class14.method80().method5253(var3, var7, var1, var2);
   }
}
