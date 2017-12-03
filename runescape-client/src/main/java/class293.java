import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kv")
public class class293 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("classInfos")
   public static CombatInfoList classInfos;

   static {
      classInfos = new CombatInfoList();
   }
}
