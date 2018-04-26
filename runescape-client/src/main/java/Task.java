import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
@Implements("Task")
public class Task {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("n")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 415830547
   )
   @Export("type")
   int type;
   @ObfuscatedName("s")
   @Export("intArgument")
   public int intArgument;
   @ObfuscatedName("y")
   @Export("objectArgument")
   Object objectArgument;
   @ObfuscatedName("c")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
