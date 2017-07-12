import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public abstract class class163 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2082235101
   )
   public int field2325;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 179654461
   )
   public int field2323;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1528964497
   )
   public int field2324;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -523635057
   )
   public int field2322;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "1110658456"
   )
   protected abstract boolean vmethod3051(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "49"
   )
   public static boolean method3052(char var0) {
      return var0 >= 32 && var0 <= 126?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }
}
