import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class170 {
   @ObfuscatedName("t")
   static boolean field2194;
   @ObfuscatedName("q")
   static File field2189;
   @ObfuscatedName("i")
   static Hashtable field2190;
   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   @Export("rssocket")
   static class169 rssocket;

   static {
      field2194 = false;
      field2190 = new Hashtable(16);
   }
}
