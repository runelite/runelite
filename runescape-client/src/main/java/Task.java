import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
@Implements("Task")
public class Task {
   @ObfuscatedName("q")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -965570195
   )
   @Export("type")
   int type;
   @ObfuscatedName("r")
   public int field2240;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("g")
   Object field2234;
   @ObfuscatedName("v")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
