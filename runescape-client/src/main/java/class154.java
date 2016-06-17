import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public class class154 implements class112 {
   @ObfuscatedName("b")
   public static final class154 field2268 = new class154("runescape", "RuneScape", 0);
   @ObfuscatedName("g")
   public static final class154 field2269 = new class154("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("j")
   public static final class154 field2270 = new class154("game3", "Game 3", 2);
   @ObfuscatedName("d")
   public static final class154 field2271 = new class154("game4", "Game 4", 3);
   @ObfuscatedName("x")
   public static final class154 field2272 = new class154("game5", "Game 5", 4);
   @ObfuscatedName("r")
   public final String field2274;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1612024779
   )
   final int field2275;
   @ObfuscatedName("y")
   public static final class154 field2277 = new class154("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("ek")
   static class78[] field2279;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "635328182"
   )
   public static boolean method3171(CharSequence var0) {
      return class24.method591(var0, 10, true);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class154(String var1, String var2, int var3) {
      this.field2274 = var1;
      this.field2275 = var3;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "4104"
   )
   public static boolean method3174(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "977914203"
   )
   public int vmethod3185() {
      return this.field2275;
   }
}
