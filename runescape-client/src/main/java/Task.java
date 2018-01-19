import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("Task")
public class Task {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("h")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1378470907
   )
   @Export("type")
   int type;
   @ObfuscatedName("s")
   @Export("intArgument")
   public int intArgument;
   @ObfuscatedName("b")
   @Export("objectArgument")
   Object objectArgument;
   @ObfuscatedName("e")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
