import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public abstract class class156 {
   @ObfuscatedName("i")
   static boolean field2132 = false;
   @ObfuscatedName("p")
   static String field2133;
   @ObfuscatedName("mf")
   @Export("clanMembers")
   static XClanMember[] clanMembers;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-57"
   )
   abstract byte[] vmethod3076();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-932194466"
   )
   abstract void vmethod3077(byte[] var1);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-161548112"
   )
   static void method3086() {
      if(CombatInfoListHolder.loadWorlds()) {
         class41.worldSelectShown = true;
      }

   }
}
