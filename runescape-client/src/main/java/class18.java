import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
final class class18 implements Comparator {
   @ObfuscatedName("ck")
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -1115497397
   )
   //@Export("packetId")
   static int packetId;
   @ObfuscatedName("fu")
   @Export("mapRegions")
   @Hook("mapRegionsChanged")
   static int[] mapRegions;
   @ObfuscatedName("a")
   public static class234 field327;
   @ObfuscatedName("x")
   public static class112 field328;

   public int compare(Object var1, Object var2) {
      return this.method150((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;B)I",
      garbageValue = "102"
   )
   int method150(class14 var1, class14 var2) {
      return var1.method92().compareTo(var2.method92());
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1942942547"
   )
   static final int method157() {
      return class134.field2001;
   }
}
