import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
@Implements("Task")
public class Task {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("e")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1534636827
   )
   @Export("type")
   int type;
   @ObfuscatedName("k")
   @Export("intArgument")
   public int intArgument;
   @ObfuscatedName("s")
   @Export("objectArgument")
   Object objectArgument;
   @ObfuscatedName("p")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
