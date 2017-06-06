import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
public class class73 extends class163 {
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = 396487599
   )
   static int field883;
   @ObfuscatedName("am")
   static ModIcon[] field887;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;B)Z",
      garbageValue = "-54"
   )
   public boolean vmethod3055(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2335 && super.field2333 == var3;
   }
}
