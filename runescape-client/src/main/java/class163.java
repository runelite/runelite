import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public abstract class class163 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2129138697
   )
   public int field2320;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -913312833
   )
   public int field2321;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2038947913
   )
   public int field2322;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -132645097
   )
   public int field2323;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "1848577048"
   )
   protected abstract boolean vmethod2950(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "88494786"
   )
   public static int method2955(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }
}
