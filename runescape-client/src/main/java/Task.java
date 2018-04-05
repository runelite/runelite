import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
@Implements("Task")
public class Task {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfo;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("h")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1041416563
   )
   @Export("type")
   int type;
   @ObfuscatedName("z")
   @Export("intArgument")
   public int intArgument;
   @ObfuscatedName("i")
   @Export("objectArgument")
   Object objectArgument;
   @ObfuscatedName("u")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
