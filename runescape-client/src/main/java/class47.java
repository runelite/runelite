import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class47 {
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = 1759095677
   )
   static int field620;
   @ObfuscatedName("z")
   @Export("blendedSaturation")
   static int[] blendedSaturation;
   @ObfuscatedName("ck")
   public static char field618;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2101651201
   )
   public int field615;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public Coordinates field616;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public Coordinates field617;

   @ObfuscatedSignature(
      signature = "(ILhg;Lhg;)V"
   )
   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field615 = var1;
      this.field616 = var2;
      this.field617 = var3;
   }
}
