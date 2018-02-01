import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
public class class304 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   @Export("classInfos")
   public static CombatInfoList classInfos;
   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   @Export("indexCache13")
   static IndexData indexCache13;

   static {
      classInfos = new CombatInfoList();
   }
}
