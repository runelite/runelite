import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
public class class288 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   @Export("huffman")
   public static Huffman huffman;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-1867174616"
   )
   public static String method5457(CharSequence var0) {
      String var1 = NetWriter.method2045(class222.method4356(var0));
      if(var1 == null) {
         var1 = "";
      }

      return var1;
   }
}
