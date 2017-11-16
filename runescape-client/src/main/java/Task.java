import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
@Implements("Task")
public class Task {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("x")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2115394685
   )
   @Export("type")
   int type;
   @ObfuscatedName("u")
   public int field2129;
   @ObfuscatedName("t")
   Object field2131;
   @ObfuscatedName("k")
   @Export("value")
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
