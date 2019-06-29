import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ky")
@Implements("Usernamed")
public interface Usernamed {
   @ObfuscatedName("kr")
   @ObfuscatedSignature(
      signature = "(B)Lkp;",
      garbageValue = "-87"
   )
   @Export("username")
   Username username();
}
