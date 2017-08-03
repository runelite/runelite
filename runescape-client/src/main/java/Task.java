import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
@Implements("Task")
public class Task {
   @ObfuscatedName("e")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 57259315
   )
   @Export("type")
   int type;
   @ObfuscatedName("v")
   public int field2202;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("t")
   Object field2200;
   @ObfuscatedName("i")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
