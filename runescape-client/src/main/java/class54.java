import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
public class class54 {
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = -1170918911
   )
   static int field682;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   @Export("identKit_ref")
   public static IndexDataBase identKit_ref;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[Lda;"
   )
   public static CacheFile[] field685;
   @ObfuscatedName("r")
   @Export("underlayIds")
   static byte[][][] underlayIds;

   static {
      ImageIO.setUseCache(false);
   }
}
