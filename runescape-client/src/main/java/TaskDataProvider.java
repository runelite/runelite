import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("TaskDataProvider")
public interface TaskDataProvider {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Ldw;",
      garbageValue = "212856446"
   )
   @Export("taskData")
   AbstractSoundSystem taskData();
}
