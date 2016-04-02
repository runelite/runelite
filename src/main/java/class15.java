import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("l")
@Implements("XItemContainer")
public class class15 extends class208 {
   @ObfuscatedName("e")
   @Export("itemContainers")
   static class196 field216 = new class196(32);
   @ObfuscatedName("f")
   @Export("stackSizes")
   int[] field217 = new int[]{0};
   @ObfuscatedName("ci")
   static class146 field218;
   @ObfuscatedName("w")
   @Export("itemIds")
   int[] field219 = new int[]{-1};
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = -385501027
   )
   static int field221;

   @ObfuscatedName("dk")
   static void method177(int var0) {
      class177.field2910 = new class30();
      class177.field2910.field690 = client.field494[var0];
      class177.field2910.field682 = client.field422[var0];
      class177.field2910.field683 = client.field301[var0];
      class177.field2910.field684 = client.field391[var0];
      class177.field2910.field681 = client.field425[var0];
   }
}
