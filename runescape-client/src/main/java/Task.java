import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
@Implements("Task")
public class Task {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("v")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1512804163
   )
   @Export("type")
   int type;
   @ObfuscatedName("b")
   public int field2138;
   @ObfuscatedName("t")
   Object field2139;
   @ObfuscatedName("p")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
