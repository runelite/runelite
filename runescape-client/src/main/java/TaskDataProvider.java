import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("TaskDataProvider")
public interface TaskDataProvider {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Ldo;",
      garbageValue = "284237156"
   )
   @Export("taskData")
   AbstractSoundSystem taskData();
}
