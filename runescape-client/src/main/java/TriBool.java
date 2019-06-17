import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kd")
@Implements("TriBool")
public class TriBool {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("TriBool_unknown")
   public static final TriBool TriBool_unknown;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("TriBool_true")
   public static final TriBool TriBool_true;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("TriBool_false")
   public static final TriBool TriBool_false;
   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   @Export("urlRequester")
   static UrlRequester urlRequester;

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1009406649"
   )
   static void method5560() {
      if(Client.combatTargetPlayerIndex >= 0 && Client.players[Client.combatTargetPlayerIndex] != null) {
         WorldMapCacheName.addPlayerToScene(Client.players[Client.combatTargetPlayerIndex], false);
      }

   }

   static {
      TriBool_unknown = new TriBool();
      TriBool_true = new TriBool();
      TriBool_false = new TriBool();
   }
}
