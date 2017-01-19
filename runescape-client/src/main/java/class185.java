import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public class class185 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -836157337
   )
   public static int field2747 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 836474721
   )
   public static int field2748 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 1856595886775407821L
   )
   public static long field2749;
   @ObfuscatedName("h")
   public static XHashTable field2750 = new XHashTable(4096);
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1593982517
   )
   public static int field2751 = 0;
   @ObfuscatedName("g")
   public static XHashTable field2752 = new XHashTable(32);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1761494481
   )
   public static int field2753 = 0;
   @ObfuscatedName("u")
   public static Node2LinkedList field2754 = new Node2LinkedList();
   @ObfuscatedName("c")
   public static class110 field2755;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 115900599
   )
   public static int field2756 = 0;
   @ObfuscatedName("r")
   public static XHashTable field2757 = new XHashTable(4096);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 160997417
   )
   public static int field2758 = 0;
   @ObfuscatedName("w")
   public static Buffer field2759 = new Buffer(8);
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 558905725
   )
   public static int field2760 = 0;
   @ObfuscatedName("z")
   static CRC32 field2761 = new CRC32();
   @ObfuscatedName("t")
   public static byte field2763 = 0;
   @ObfuscatedName("d")
   static class184[] field2764 = new class184[256];
   @ObfuscatedName("b")
   public static XHashTable field2765 = new XHashTable(4096);
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1031961013
   )
   public static int field2767 = 0;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1295431123"
   )
   static final boolean method3298(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "87"
   )
   public static void method3319() {
      Overlay.field3046.reset();
   }
}
