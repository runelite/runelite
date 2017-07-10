import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class157 {
   @ObfuscatedName("a")
   static Hashtable field2267;
   @ObfuscatedName("w")
   public static File field2268;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -1263400921
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("k")
   static class111 field2270;
   @ObfuscatedName("i")
   public static boolean field2271;

   static {
      field2271 = false;
      field2267 = new Hashtable(16);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1565187458"
   )
   public static boolean method2963(int var0) {
      return (var0 >> 30 & 1) != 0;
   }
}
