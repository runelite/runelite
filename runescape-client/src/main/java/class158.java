import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class158 {
   @ObfuscatedName("i")
   public static boolean field2260;
   @ObfuscatedName("a")
   static Hashtable field2261;
   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   static IndexedSprite[] field2262;
   @ObfuscatedName("j")
   public static File field2265;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 2134596897
   )
   @Export("cameraY")
   static int cameraY;

   static {
      field2260 = false;
      field2261 = new Hashtable(16);
   }
}
