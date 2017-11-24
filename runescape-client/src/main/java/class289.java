import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kk")
public class class289 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static CombatInfoList field3806;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 1589273571
   )
   @Export("cameraY")
   static int cameraY;

   static {
      field3806 = new CombatInfoList();
   }
}
