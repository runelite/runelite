import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
@Implements("Task")
public class Task {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfm;"
   )
   @Export("next")
   Task next;
   @ObfuscatedName("o")
   @Export("status")
   public volatile int status;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1097728571
   )
   @Export("type")
   int type;
   @ObfuscatedName("g")
   @Export("intArgument")
   public int intArgument;
   @ObfuscatedName("l")
   @Export("objectArgument")
   Object objectArgument;
   @ObfuscatedName("e")
   @Export("result")
   public volatile Object result;

   Task() {
      this.status = 0;
   }
}
