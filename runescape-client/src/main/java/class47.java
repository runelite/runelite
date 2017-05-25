import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class47 {
   @ObfuscatedName("u")
   public class212 field596;
   @ObfuscatedName("h")
   public class212 field597;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -705845037
   )
   public int field598;

   public class47(int var1, class212 var2, class212 var3) {
      this.field598 = var1;
      this.field597 = var2;
      this.field596 = var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "116771477"
   )
   public static boolean method713(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
