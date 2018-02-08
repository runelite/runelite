import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kq")
public class class304 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   @Export("classInfos")
   public static CombatInfoList classInfos;

   static {
      classInfos = new CombatInfoList();
   }
}
