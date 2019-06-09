import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("ModelData0")
public class ModelData0 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 3311945626287518857L
   )
   @Export("currentTimeMsLast")
   static long currentTimeMsLast;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   @Export("NetCache_currentResponse")
   public static NetFileRequest NetCache_currentResponse;
}
