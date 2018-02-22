import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lt")
public class class317 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   @Export("classInfos")
   public static CombatInfoList classInfos;
   @ObfuscatedName("g")
   public static byte[][][] field3873;

   static {
      classInfos = new CombatInfoList();
   }
}
