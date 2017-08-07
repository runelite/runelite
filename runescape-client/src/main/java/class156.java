import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class156 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ldo;"
   )
   static CacheFile field2230;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ldo;"
   )
   public static CacheFile field2231;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ldo;"
   )
   public static CacheFile field2232;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -618175705
   )
   static int field2229;
   @ObfuscatedName("b")
   @Export("osName")
   static String osName;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Ldo;"
   )
   public static CacheFile[] field2227;
   @ObfuscatedName("m")
   @Export("cacheLocations")
   static String[] cacheLocations;
   @ObfuscatedName("y")
   static File field2228;

   static {
      field2230 = null;
      field2231 = null;
      field2232 = null;
   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-213164764"
   )
   static final void method2995() {
      if(Client.field1040 > 0) {
         class27.method223();
      } else {
         WorldMapType1.setGameState(40);
         class22.field341 = GZipDecompressor.rssocket;
         GZipDecompressor.rssocket = null;
      }
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "-136949931"
   )
   static final void method2987(String var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(2);
      Client.secretPacketBuffer1.putByte(class45.getLength(var0) + 1);
      Client.secretPacketBuffer1.putString(var0);
      Client.secretPacketBuffer1.putByte(var1);
   }
}
