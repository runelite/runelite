import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eh")
@Implements("Task")
public class Task {
   @ObfuscatedName("j")
   @Export("value")
   public volatile Object value;
   @ObfuscatedName("i")
   @Export("task")
   Task task;
   @ObfuscatedName("s")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -660246521
   )
   @Export("type")
   int type;
   @ObfuscatedName("v")
   public int field2245;
   @ObfuscatedName("y")
   Object field2246;

   Task() {
      this.status = 0;
   }
}
