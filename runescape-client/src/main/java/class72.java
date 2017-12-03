import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
public class class72 extends class168 {
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 1833818685
   )
   static int field804;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIILfp;B)Z",
      garbageValue = "-63"
   )
   public boolean vmethod3167(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2223 && var3 == super.field2224;
   }
}
