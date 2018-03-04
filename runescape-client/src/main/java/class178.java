import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public abstract class class178 {
   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("slStarSprites")
   static IndexedSprite[] slStarSprites;
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexCache4")
   static IndexData indexCache4;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2084893001
   )
   public int field2282;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 987598907
   )
   public int field2279;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 505783573
   )
   public int field2280;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -856605283
   )
   public int field2281;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILfb;I)Z",
      garbageValue = "740500381"
   )
   public abstract boolean vmethod3470(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-2"
   )
   public static void method3472() {
      CombatInfo2.field3527.reset();
      CombatInfo2.field3517.reset();
   }
}
