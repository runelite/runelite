import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
public class class272 {
   @ObfuscatedName("gj")
   public static final int[] field3709;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "17"
   )
   public static final boolean method4895(String var0, String var1, String var2, String var3) {
      return var0 != null && var2 != null?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }

   static {
      field3709 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 28, 0, -2, 0, 0, 0, -1, 0, 0, 6, 2, 0, 0, 4, 1, -2, 0, 0, 0, 0, 0, -1, 0, 0, 0, 8, 5, 0, 0, 4, 0, 5, 0, 0, 0, 0, 0, -2, 0, 0, 0, 5, 0, 7, 0, 0, 0, 0, 15, 6, 0, 0, -2, 0, 0, 0, 0, 6, 0, 0, 2, 0, 0, 0, 6, 0, 0, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -2, -2, 5, 2, 0, 0, 0, 0, 0, 0, 6, 10, 2, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 6, 0, 0, 2, 0, -2, 0, 0, 0, 0, 4, 0, 0, 0, 0, 6, 0, 4, 0, 0, -2, 0, 8, 0, 0, 0, 2, 0, 0, 0, 0, 0, 8, 0, 0, 0, -1, -2, 0, 0, 7, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 2, 4, 8, 0, 0, 0, 4, 6, 14, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, -2, 4, 0, 0, -1, 0, -2, 0, 0, 0, 0, 5, 0, -2, -1, 6, 0, 0, 0, 0, 0, 3, 0, 0, -1, 1, 2, 0, 0, 6, 0, -2, 0, 1, 12, 0, 0, 2, 0, 0, 0, 0};
   }
}
