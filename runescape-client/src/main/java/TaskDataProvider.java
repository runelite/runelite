import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("TaskDataProvider")
public interface TaskDataProvider {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Ldd;",
      garbageValue = "384581081"
   )
   @Export("taskData")
   AbstractSoundSystem taskData();
}
