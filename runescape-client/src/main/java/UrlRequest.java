import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("UrlRequest")
public class UrlRequest {
   @ObfuscatedName("b")
   @Export("url")
   final URL url;
   @ObfuscatedName("q")
   @Export("isDone0")
   volatile boolean isDone0;
   @ObfuscatedName("o")
   @Export("response0")
   volatile byte[] response0;

   UrlRequest(URL var1) {
      this.url = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "21841"
   )
   @Export("isDone")
   public boolean isDone() {
      return this.isDone0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1517432602"
   )
   @Export("getResponse")
   public byte[] getResponse() {
      return this.response0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "1"
   )
   public static int method3092(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-1175"
   )
   public static void method3093() {
      KitDefinition.identKits.reset();
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "74"
   )
   static final void method3089() {
      int var0 = class92.playerIndexesCount;
      int[] var1 = class92.playerIndices;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(var3 != null) {
            class131.method2799(var3, 1);
         }
      }

   }
}
