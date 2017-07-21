import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
public enum class232 implements RSEnum {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   field3161("runescape", "RuneScape", 0),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   field3160("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   field3166("game3", "Game 3", 2),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   field3162("game4", "Game 4", 3),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   field3163("game5", "Game 5", 4),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   field3164("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("s")
   public final String field3159;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -251857401
   )
   final int field3165;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 2029261165
   )
   static int field3168;

   class232(String var3, String var4, int var5) {
      this.field3159 = var3;
      this.field3165 = var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1443879177"
   )
   public int rsOrdinal() {
      return this.field3165;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgk;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "279658673"
   )
   static String method4001(class186 var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.method3439((long)var1);
         return var3 == null?var2:(String)var3.value;
      }
   }
}
