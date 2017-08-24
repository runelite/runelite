import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
@Implements("Task")
public class Task {
   @ObfuscatedName("o")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 786931487
   )
   @Export("type")
   int type;
   @ObfuscatedName("q")
   public int field2238;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lez;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("b")
   Object field2234;
   @ObfuscatedName("k")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
