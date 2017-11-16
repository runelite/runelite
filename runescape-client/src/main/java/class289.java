import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kv")
public class class289 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   public static CombatInfoList field3803;
   @ObfuscatedName("aa")
   @Export("clientInstance")
   @ObfuscatedSignature(
      signature = "Lclient;"
   )
   static Client clientInstance;

   static {
      field3803 = new CombatInfoList();
   }
}
