import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class64 {
   @ObfuscatedName("g")
   @Export("worldServersDownload")
   static class77 worldServersDownload;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "2147483647"
   )
   static String method1058(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)[Lclass239;",
      garbageValue = "590226687"
   )
   static class239[] method1059() {
      return new class239[]{class239.field3275, class239.field3274, class239.field3276};
   }
}
