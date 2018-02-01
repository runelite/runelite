import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("Task")
public class Task {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("j")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 701363265
   )
   @Export("type")
   int type;
   @ObfuscatedName("t")
   @Export("intArgument")
   public int intArgument;
   @ObfuscatedName("r")
   @Export("objectArgument")
   Object objectArgument;
   @ObfuscatedName("m")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
