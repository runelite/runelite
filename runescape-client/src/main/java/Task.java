import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
@Implements("Task")
public class Task {
   @ObfuscatedName("w")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1657418445
   )
   @Export("type")
   int type;
   @ObfuscatedName("v")
   public int field2212;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("z")
   Object field2209;
   @ObfuscatedName("r")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
