import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class171 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1775492369
   )
   public static int field2431;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   public static IndexDataBase field2428;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-11"
   )
   public static boolean method3220(int var0) {
      return (var0 >> 21 & 1) != 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-978006508"
   )
   public static void method3218() {
      class258.field3455.reset();
   }
}
