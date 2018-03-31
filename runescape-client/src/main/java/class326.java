import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lc")
public class class326 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("classInfos")
   public static CombatInfoList classInfos;

   static {
      classInfos = new CombatInfoList();
   }
}
