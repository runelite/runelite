import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class25 {
   @ObfuscatedName("j")
   @Export("osName")
   static String osName;
   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   static IndexData field353;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = 1482173887
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 350477861
   )
   int field356;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   Coordinates field352;

   @ObfuscatedSignature(
      signature = "(ILhs;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field356 = var1;
      this.field352 = var2;
   }
}
