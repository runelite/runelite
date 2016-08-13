import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class175 extends CacheableNode {
   @ObfuscatedName("e")
   public static File field2791;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1659724695
   )
   int field2792;
   @ObfuscatedName("r")
   byte field2793;
   @ObfuscatedName("u")
   public static short[][] field2794;
   @ObfuscatedName("l")
   class171 field2795;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "182130360"
   )
   static boolean method3546(String var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }
}
