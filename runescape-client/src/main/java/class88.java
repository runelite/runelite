import java.awt.Font;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
public class class88 {
   @ObfuscatedName("ax")
   static class110 field1536;
   @ObfuscatedName("qs")
   protected static Font field1537;
   @ObfuscatedName("p")
   static Widget field1538;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "630352795"
   )
   static String method1854() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class47.field944.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }
}
