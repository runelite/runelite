import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("MapIconReference")
public class MapIconReference {
   @ObfuscatedName("ck")
   @Export("middleMouseMovesCamera")
   static boolean middleMouseMovesCamera;
   @ObfuscatedName("ew")
   @ObfuscatedSignature(
      signature = "Leq;"
   )
   @Export("urlRequester")
   static UrlRequester urlRequester;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 51946197
   )
   @Export("areaId")
   public int areaId;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   public Coordinates field590;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   public Coordinates field591;

   @ObfuscatedSignature(
      signature = "(ILix;Lix;)V"
   )
   public MapIconReference(int var1, Coordinates var2, Coordinates var3) {
      this.areaId = var1;
      this.field590 = var2;
      this.field591 = var3;
   }
}
