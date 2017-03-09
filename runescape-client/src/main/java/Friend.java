import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("de")
   @Export("region")
   static Region region;
   @ObfuscatedName("j")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("h")
   boolean field172;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2105847697
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("w")
   boolean field174;
   @ObfuscatedName("x")
   @Export("name")
   String name;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -437873073
   )
   @Export("world")
   int world;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-293761218"
   )
   public static boolean method199() {
      return class138.field1920 != 0?true:class138.field1919.method2537();
   }
}
