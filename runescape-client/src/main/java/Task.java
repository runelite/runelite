import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("Task")
public class Task {
   @ObfuscatedName("g")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1712001535
   )
   @Export("type")
   int type;
   @ObfuscatedName("p")
   public int field2222;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("e")
   Object field2223;
   @ObfuscatedName("d")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
