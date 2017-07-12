import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
final class class12 implements Comparator {
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      longValue = 1733588494741998649L
   )
   static long field272;
   @ObfuscatedName("dr")
   @Export("vorbisIndex")
   static IndexData vorbisIndex;
   @ObfuscatedName("ah")
   static int[] field270;
   @ObfuscatedName("og")
   static byte field271;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "-586781839"
   )
   int method52(class14 var1, class14 var2) {
      return var1.field291 < var2.field291?-1:(var2.field291 == var1.field291?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method52((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)LSpritePixels;",
      garbageValue = "-689833724"
   )
   public static SpritePixels method59(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return ObjectComposition.method4574(var0, var3, var4);
   }
}
