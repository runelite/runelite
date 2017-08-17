import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("Task")
public class Task {
   @ObfuscatedName("x")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 75321087
   )
   @Export("type")
   int type;
   @ObfuscatedName("c")
   public int field2232;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lea;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("l")
   Object field2233;
   @ObfuscatedName("w")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
