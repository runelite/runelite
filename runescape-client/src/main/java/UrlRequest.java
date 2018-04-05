import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("UrlRequest")
public class UrlRequest {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("widgetIndex")
   public static IndexDataBase widgetIndex;
   @ObfuscatedName("x")
   public static short[][] field2135;
   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   static Widget field2137;
   @ObfuscatedName("o")
   @Export("url")
   final URL url;
   @ObfuscatedName("k")
   @Export("isDone0")
   volatile boolean isDone0;
   @ObfuscatedName("t")
   @Export("response0")
   volatile byte[] response0;

   UrlRequest(URL var1) {
      this.url = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "57934443"
   )
   @Export("isDone")
   public boolean isDone() {
      return this.isDone0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(S)[B",
      garbageValue = "12318"
   )
   @Export("getResponse")
   public byte[] getResponse() {
      return this.response0;
   }
}
