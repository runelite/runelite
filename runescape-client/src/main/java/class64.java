import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public class class64 {
   @ObfuscatedName("ma")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   static SocialStatus field727;
   @ObfuscatedName("fs")
   @Export("mapRegions")
   @Hook("mapRegionsChanged")
   static int[] mapRegions;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1115035234"
   )
   static void method1033(String var0, String var1, String var2) {
      class91.loginMessage1 = var0;
      class91.loginMessage2 = var1;
      class91.loginMessage3 = var2;
   }
}
