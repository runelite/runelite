import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class54 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Lcg;"
   )
   @Export("worldList")
   static World[] worldList;

   static {
      ImageIO.setUseCache(false);
   }
}
