import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
@Implements("Task")
public class Task {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfk;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("a")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1053401491
   )
   @Export("type")
   int type;
   @ObfuscatedName("l")
   @Export("intArgument")
   public int intArgument;
   @ObfuscatedName("y")
   @Export("objectArgument")
   Object objectArgument;
   @ObfuscatedName("g")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
