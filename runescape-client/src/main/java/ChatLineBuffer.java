import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Lbb;"
   )
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1416661767
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Lbb;",
      garbageValue = "-95"
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Lbb;",
      garbageValue = "-10"
   )
   MessageNode method1917(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-7970"
   )
   int method1908() {
      return this.length;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-124899442"
   )
   static byte[] method1912(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1023197937"
   )
   static final void method1916() {
      if(class15.rssocket2 != null) {
         class15.rssocket2.close();
         class15.rssocket2 = null;
      }

      WorldMapType2.method521();
      class3.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      class164.method3140(2);
      Client.field1150 = -1;
      Client.field1151 = false;
      class27.method218();
      class72.setGameState(10);
   }
}
