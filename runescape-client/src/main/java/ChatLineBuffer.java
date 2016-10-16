import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("z")
   @Export("lines")
   MessageNode[] lines = new MessageNode[100];
   @ObfuscatedName("o")
   static int[] field665;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -738812035
   )
   @Export("length")
   int length;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "972714617"
   )
   MessageNode method660(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)LMessageNode;",
      garbageValue = "2107069589"
   )
   MessageNode method662(int var1, String var2, String var3, String var4) {
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
         var5.method3894();
         var5.method749(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "16776960"
   )
   int method664() {
      return this.length;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;B)[LModIcon;",
      garbageValue = "21"
   )
   public static ModIcon[] method670(class170 var0, String var1, String var2) {
      int var3 = var0.method3265(var1);
      int var4 = var0.method3266(var3, var2);
      return class0.method1(var0, var3, var4);
   }
}
