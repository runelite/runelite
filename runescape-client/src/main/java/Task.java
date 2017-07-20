import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("Task")
public class Task {
   @ObfuscatedName("g")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 830886255
   )
   @Export("type")
   int type;
   @ObfuscatedName("s")
   public int field2190;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("x")
   Object field2184;
   @ObfuscatedName("p")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
