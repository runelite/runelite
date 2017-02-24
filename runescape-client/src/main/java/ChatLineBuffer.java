import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 561271019
   )
   static int field986;
   @ObfuscatedName("d")
   @Export("lines")
   MessageNode[] lines = new MessageNode[100];
   @ObfuscatedName("j")
   static ModIcon[] field989;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1906419993
   )
   @Export("length")
   int length;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "-80561739"
   )
   MessageNode method975(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)LMessageNode;",
      garbageValue = "-1778926735"
   )
   MessageNode method978(int var1, String var2, String var3, String var4) {
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
         var5.method2484();
         var5.method212(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-606055250"
   )
   int method979() {
      return this.length;
   }
}
