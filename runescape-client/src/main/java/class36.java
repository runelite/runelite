import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class36 {
   @ObfuscatedName("w")
   static final class36 field516;
   @ObfuscatedName("i")
   static final class36 field526;
   @ObfuscatedName("am")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("r")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 623444973
   )
   final int field525;

   static {
      field526 = new class36(0);
      field516 = new class36(1);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class36(int var1) {
      this.field525 = var1;
   }
}
