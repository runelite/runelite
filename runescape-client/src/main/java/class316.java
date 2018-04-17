import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("la")
public final class class316 {
   @ObfuscatedName("o")
   public static final char[] field3924;
   @ObfuscatedName("i")
   static ScheduledExecutorService field3925;

   static {
      field3924 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1642597799"
   )
   public static void method5617() {
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
   }
}
