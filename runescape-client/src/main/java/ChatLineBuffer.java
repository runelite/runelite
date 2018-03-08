import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "[Lbo;"
   )
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1577513953
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Lbo;",
      garbageValue = "1"
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Lbo;",
      garbageValue = "-2048842757"
   )
   @Export("getMessage")
   MessageNode getMessage(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "758473611"
   )
   @Export("size")
   int size() {
      return this.length;
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-94"
   )
   static void method2054() {
      if(Client.field967) {
         class62.method1112(WorldMapData.localPlayer, false);
      }

   }
}
