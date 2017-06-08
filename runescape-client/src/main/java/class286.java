import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kb")
public class class286 {
   @ObfuscatedName("f")
   public static int[] field3790;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1542505197
   )
   static int field3791;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -933009211
   )
   static int field3792;
   @ObfuscatedName("m")
   public static int[] field3793;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1431928489"
   )
   public static boolean method5182(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }
}
