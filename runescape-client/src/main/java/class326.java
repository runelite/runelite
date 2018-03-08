import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lm")
public class class326 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   @Export("classInfos")
   public static CombatInfoList classInfos;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1822852083
   )
   static int field3956;

   static {
      classInfos = new CombatInfoList();
   }
}
