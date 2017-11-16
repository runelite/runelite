import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("el")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("t")
   static ScheduledExecutorService field2035;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -796082737
   )
   @Export("x")
   int x;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1454597047
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -651486251
   )
   @Export("z")
   int z;
}
