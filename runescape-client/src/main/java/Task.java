import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("Task")
public class Task {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("f")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -759807313
   )
   @Export("type")
   int type;
   @ObfuscatedName("h")
   @Export("intArgument")
   public int intArgument;
   @ObfuscatedName("x")
   @Export("objectArgument")
   Object objectArgument;
   @ObfuscatedName("j")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
