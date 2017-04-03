import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
final class class0 implements Comparator {
   @ObfuscatedName("r")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("q")
   static int[] field2;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1037026417
   )
   static int field3;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 914184865
   )
   static int field4;
   @ObfuscatedName("u")
   public static IndexDataBase field5;

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "2"
   )
   int method0(class2 var1, class2 var2) {
      return var1.field22 < var2.field22?-1:(var2.field22 == var1.field22?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method0((class2)var1, (class2)var2);
   }
}
