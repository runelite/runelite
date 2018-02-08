import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("Task")
public class Task {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("i")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -241591595
   )
   @Export("type")
   int type;
   @ObfuscatedName("t")
   @Export("intArgument")
   public int intArgument;
   @ObfuscatedName("d")
   @Export("objectArgument")
   Object objectArgument;
   @ObfuscatedName("z")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
