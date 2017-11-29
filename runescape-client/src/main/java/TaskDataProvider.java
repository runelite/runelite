import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("TaskDataProvider")
public interface TaskDataProvider {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Ldo;",
      garbageValue = "814951557"
   )
   @Export("taskData")
   AbstractSoundSystem taskData();
}
