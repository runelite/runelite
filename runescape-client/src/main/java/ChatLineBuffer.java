import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("p")
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("gh")
   static SpritePixels field1558;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1612574659
   )
   @Export("length")
   int length;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)LMessageNode;",
      garbageValue = "-48"
   )
   MessageNode method1847(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-2237"
   )
   int method1848() {
      return this.length;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)LMessageNode;",
      garbageValue = "-1970851807"
   )
   MessageNode method1851(int var1, String var2, String var3, String var4) {
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
         var5.method3641();
         var5.method1088(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Lclass251;",
      garbageValue = "1"
   )
   public static class251 method1859(int var0) {
      class251 var1 = (class251)class251.field3388.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class251.field3389.getConfigData(11, var0);
         var1 = new class251();
         if(var2 != null) {
            var1.method4467(new Buffer(var2));
         }

         var1.method4455();
         class251.field3388.put(var1, (long)var0);
         return var1;
      }
   }
}
