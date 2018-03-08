import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
@Implements("Task")
public class Task {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("l")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1650498841
   )
   @Export("type")
   int type;
   @ObfuscatedName("e")
   @Export("intArgument")
   public int intArgument;
   @ObfuscatedName("x")
   @Export("objectArgument")
   Object objectArgument;
   @ObfuscatedName("p")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
