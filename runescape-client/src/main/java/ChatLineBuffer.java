import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("z")
   static byte[][][] field1546;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Lbs;"
   )
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -858493693
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lbs;",
      garbageValue = "-1399294280"
   )
   @Export("addMessage")
   MessageNode addMessage(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.unlinkDual();
         var5.setMessage(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lbs;",
      garbageValue = "1239067906"
   )
   MessageNode method1907(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-674817479"
   )
   int method1902() {
      return this.length;
   }
}
