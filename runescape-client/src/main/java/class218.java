import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class218 {
   @ObfuscatedName("b")
   public static class183 field3209;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;III)Lclass227;",
      garbageValue = "-2126236010"
   )
   public static class227 method3986(class170 var0, class170 var1, int var2, int var3) {
      if(!XClanMember.method604(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.method3305(var2, var3);
         class227 var4;
         if(var5 == null) {
            var4 = null;
         } else {
            class227 var6 = new class227(var5, class134.field2117, class79.field1438, class79.field1439, ChatLineBuffer.field693, class26.field634, class110.field1936);
            NPC.method745();
            var4 = var6;
         }

         return var4;
      }
   }
}
