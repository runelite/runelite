import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("qz")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   static MachineInfo field1564;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "[Lbv;"
   )
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1659541879
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lbv;",
      garbageValue = "831095492"
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Lbv;",
      garbageValue = "-1504323529"
   )
   MessageNode method1882(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "663358989"
   )
   int method1885() {
      return this.length;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgd;III)I",
      garbageValue = "-1508904160"
   )
   static int method1892(IterableHashTable var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         IntegerNode var3 = (IntegerNode)var0.get((long)var1);
         return var3 == null?var2:var3.value;
      }
   }
}
