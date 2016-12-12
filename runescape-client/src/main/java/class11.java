import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class11 {
   @ObfuscatedName("f")
   int[] field111;
   @ObfuscatedName("k")
   String[] field112;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -39054893
   )
   int field115 = -1;
   @ObfuscatedName("g")
   static byte[][][] field117;
   @ObfuscatedName("i")
   class48 field118;
   @ObfuscatedName("ce")
   static class208 field119;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-7"
   )
   static void method150() {
      XItemContainer.itemContainers = new XHashTable(32);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-974690025"
   )
   static final void method151(Actor var0, int var1) {
      class159.method2992(var0.x, var0.y, var1);
   }
}
