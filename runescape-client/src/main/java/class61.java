import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public final class class61 {
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = 1238668055
   )
   static int field701;
   @ObfuscatedName("i")
   public static String field699;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 214541341
   )
   static int field698;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "603406969"
   )
   static String method1092() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class95.messages.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }
}
