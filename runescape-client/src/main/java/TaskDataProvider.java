import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("TaskDataProvider")
public interface TaskDataProvider {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Ldf;",
      garbageValue = "956750753"
   )
   @Export("taskData")
   AbstractSoundSystem taskData();
}
