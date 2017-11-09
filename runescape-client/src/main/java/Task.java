import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("Task")
public class Task {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("v")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2022471267
   )
   @Export("type")
   int type;
   @ObfuscatedName("e")
   public int field2144;
   @ObfuscatedName("l")
   Object field2145;
   @ObfuscatedName("b")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
