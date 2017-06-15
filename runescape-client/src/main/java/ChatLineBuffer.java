import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("m")
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1177989537
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)LMessageNode;",
      garbageValue = "14"
   )
   MessageNode method1765(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-3"
   )
   int method1766() {
      return this.length;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-33547177"
   )
   static void method1770() {
      class96.field1487 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class96.field1498[var0] = null;
         class96.field1494[var0] = 1;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)LMessageNode;",
      garbageValue = "-1356112776"
   )
   MessageNode method1771(int var1, String var2, String var3, String var4) {
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
         var5.method3520();
         var5.method1053(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-5"
   )
   static final void method1777(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1109; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var1 + var3) {
            Client.field1111[var4] = true;
         }
      }

   }
}
