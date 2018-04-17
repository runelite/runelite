import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("ac")
   static FontMetrics field1479;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Lbv;"
   )
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1201043193
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lbv;",
      garbageValue = "2069748508"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Lbv;",
      garbageValue = "151077776"
   )
   @Export("getMessage")
   MessageNode getMessage(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1010255618"
   )
   @Export("size")
   int size() {
      return this.length;
   }
}
