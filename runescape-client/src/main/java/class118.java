import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public class class118 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -3391822168699084311L
   )
   static long field2024;
   @ObfuscatedName("v")
   public static class231[] field2025;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1517197527"
   )
   public static int method2483(int var0) {
      var0 = (var0 >>> 1 & 1431655765) + (var0 & 1431655765);
      var0 = (var0 & 858993459) + (var0 >>> 2 & 858993459);
      var0 = (var0 >>> 4) + var0 & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
      garbageValue = "2"
   )
   static String method2485(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field514 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field514 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field514 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field514 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field514 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(null != class4.field79) {
         var3 = "/p=" + class4.field79;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field310 + "/a=" + Client.field344 + var3 + "/";
   }
}
