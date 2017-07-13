import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ev")
@Implements("Task")
public class Task {
   @ObfuscatedName("v")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -766116845
   )
   @Export("type")
   int type;
   @ObfuscatedName("l")
   public int field2222;
   @ObfuscatedName("a")
   @Export("task")
   Task task;
   @ObfuscatedName("s")
   Object field2219;
   @ObfuscatedName("w")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
