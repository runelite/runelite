import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("Task")
public class Task {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("u")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 243075415
   )
   @Export("type")
   int type;
   @ObfuscatedName("t")
   @Export("intArgument")
   public int intArgument;
   @ObfuscatedName("f")
   @Export("objectArgument")
   Object objectArgument;
   @ObfuscatedName("g")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
