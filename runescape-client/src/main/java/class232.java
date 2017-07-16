import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public enum class232 implements RSEnum {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   field3195("runescape", "RuneScape", 0),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   field3196("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   field3194("game3", "Game 3", 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   field3197("game4", "Game 4", 3),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   field3192("game5", "Game 5", 4),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   field3193("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("l")
   public final String field3198;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -117502167
   )
   final int field3199;

   class232(String var3, String var4, int var5) {
      this.field3198 = var3;
      this.field3199 = var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1952293135"
   )
   public int rsOrdinal() {
      return this.field3199;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1740284050"
   )
   public static int method4077(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
