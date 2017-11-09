import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
public enum class239 implements RSEnum {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   field3255("runescape", "RuneScape", 0),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   field3256("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   field3257("game3", "Game 3", 2),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   field3258("game4", "Game 4", 3),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   field3263("game5", "Game 5", 4),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   field3260("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 61320803
   )
   static int field3259;
   @ObfuscatedName("e")
   public final String field3261;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1687907787
   )
   final int field3262;

   class239(String var3, String var4, int var5) {
      this.field3261 = var3;
      this.field3262 = var5;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "369425307"
   )
   public int rsOrdinal() {
      return this.field3262;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZZI)I",
      garbageValue = "-487339094"
   )
   public static int method4274(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class245.field3323 + class245.field3320;
      return var3;
   }
}
