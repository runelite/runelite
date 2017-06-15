import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1617006571
   )
   @Export("world")
   int world;
   @ObfuscatedName("z")
   boolean field792;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -505498701
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("m")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("w")
   boolean field795;
   @ObfuscatedName("p")
   @Export("name")
   String name;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-2138741852"
   )
   public static int method1023(String var0) {
      return var0.length() + 1;
   }
}
