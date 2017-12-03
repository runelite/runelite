import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("TaskDataProvider")
public interface TaskDataProvider {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Ldn;",
      garbageValue = "524047309"
   )
   @Export("taskData")
   AbstractSoundSystem taskData();
}
