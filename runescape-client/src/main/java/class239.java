import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
public class class239 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1916892269
   )
   public static int field3252;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1240563293
   )
   public static int field3251;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   static XHashTable field3245;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 885327075
   )
   public static int field3253;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   public static XHashTable field3238;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static Node2LinkedList field3242;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1767848641
   )
   public static int field3249;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   public static XHashTable field3236;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 8406309574622174911L
   )
   public static long field3239;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -91512781
   )
   public static int field3241;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   public static XHashTable field3240;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1771835607
   )
   public static int field3235;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "[Lid;"
   )
   public static IndexData[] field3250;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1384064565
   )
   public static int field3246;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   public static RSSocket field3237;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   public static Buffer field3247;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1986190889
   )
   public static int field3248;
   @ObfuscatedName("t")
   public static CRC32 field3244;
   @ObfuscatedName("b")
   public static byte field3243;

   static {
      field3251 = 0;
      field3238 = new XHashTable(4096);
      field3249 = 0;
      field3236 = new XHashTable(32);
      field3241 = 0;
      field3242 = new Node2LinkedList();
      field3245 = new XHashTable(4096);
      field3235 = 0;
      field3240 = new XHashTable(4096);
      field3246 = 0;
      field3247 = new Buffer(8);
      field3248 = 0;
      field3244 = new CRC32();
      field3250 = new IndexData[256];
      field3243 = 0;
      field3252 = 0;
      field3253 = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)[Ljo;",
      garbageValue = "1"
   )
   public static Parameters[] method4258() {
      return new Parameters[]{Parameters.field3703, Parameters.field3705, Parameters.field3701, Parameters.field3707, Parameters.field3695, Parameters.field3696, Parameters.field3699, Parameters.field3693, Parameters.field3704, Parameters.field3698, Parameters.field3702, Parameters.field3706, Parameters.field3694, Parameters.field3697, Parameters.field3700};
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1990699812"
   )
   static int method4245(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return class89.currentRequest != null && class89.currentRequest.hash == var2?class266.field3650.offset * 99 / (class266.field3650.payload.length - class89.currentRequest.padding) + 1:0;
   }
}
