import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1651933103
   )
   static int field1470;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -2123886963
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("kx")
   @ObfuscatedSignature(
      signature = "Lcc;"
   )
   @Export("topContextMenuRow")
   static ContextMenuRow topContextMenuRow;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Lbk;"
   )
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -860360207
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lbk;",
      garbageValue = "-406297879"
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Lbk;",
      garbageValue = "2"
   )
   @Export("getMessage")
   MessageNode getMessage(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "948241019"
   )
   @Export("size")
   int size() {
      return this.length;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "4"
   )
   static final int method2023(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & 16711935) * var2 + var3 * (var0 & 16711935) & -16711936) + ((var0 & 65280) * var3 + (var1 & 65280) * var2 & 16711680) >> 8;
   }
}
