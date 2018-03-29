import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
@Implements("Task")
public class Task {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("k")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 880916215
   )
   @Export("type")
   int type;
   @ObfuscatedName("z")
   @Export("intArgument")
   public int intArgument;
   @ObfuscatedName("p")
   @Export("objectArgument")
   Object objectArgument;
   @ObfuscatedName("w")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
