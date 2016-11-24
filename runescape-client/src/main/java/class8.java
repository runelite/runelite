import java.awt.Image;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class8 {
   @ObfuscatedName("z")
   static ModIcon field69;
   @ObfuscatedName("qw")
   protected static Image field71;
   @ObfuscatedName("av")
   static int[] field72;
   @ObfuscatedName("y")
   static boolean field77;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "44"
   )
   static int method105(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2405((long)var0);
      return null == var2?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }
}
