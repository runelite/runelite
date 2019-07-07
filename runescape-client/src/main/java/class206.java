import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class206 {
   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1763054678"
   )
   @Export("getTapToDrop")
   static boolean getTapToDrop() {
      return Client.tapToDrop;
   }
}
