import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class232 implements class178 {
   @ObfuscatedName("m")
   static final class232 field3199;
   @ObfuscatedName("j")
   public final String field3200;
   @ObfuscatedName("e")
   static final class232 field3201;
   @ObfuscatedName("t")
   static final class232 field3202;
   @ObfuscatedName("w")
   static final class232 field3203;
   @ObfuscatedName("p")
   static final class232 field3205;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1150411343
   )
   final int field3206;
   @ObfuscatedName("z")
   public static final class232 field3207;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = 1515035611
   )
   @Export("spellTargetFlags")
   static int spellTargetFlags;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "665522131"
   )
   public int vmethod4906() {
      return this.field3206;
   }

   static {
      field3205 = new class232("runescape", "RuneScape", 0);
      field3199 = new class232("stellardawn", "Stellar Dawn", 1);
      field3201 = new class232("game3", "Game 3", 2);
      field3202 = new class232("game4", "Game 4", 3);
      field3203 = new class232("game5", "Game 5", 4);
      field3207 = new class232("oldscape", "RuneScape 2007", 5);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class232(String var1, String var2, int var3) {
      this.field3200 = var1;
      this.field3206 = var3;
   }
}
