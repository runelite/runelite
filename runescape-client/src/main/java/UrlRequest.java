import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
@Implements("UrlRequest")
public class UrlRequest {
   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   @Export("__ey_bx")
   static IndexedSprite[] __ey_bx;
   @ObfuscatedName("m")
   @Export("url")
   final URL url;
   @ObfuscatedName("f")
   @Export("isDone0")
   volatile boolean isDone0;
   @ObfuscatedName("q")
   @Export("response0")
   volatile byte[] response0;

   UrlRequest(URL var1) {
      this.url = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1588021801"
   )
   @Export("isDone")
   public boolean isDone() {
      return this.isDone0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-25"
   )
   @Export("getResponse")
   public byte[] getResponse() {
      return this.response0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-476632347"
   )
   public static boolean method3271(char var0) {
      return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }
}
