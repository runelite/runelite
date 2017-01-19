import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("c")
   @Export("lines")
   MessageNode[] lines = new MessageNode[100];
   @ObfuscatedName("k")
   public static short[] field963;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 790983645
   )
   @Export("length")
   int length;
   @ObfuscatedName("h")
   @Export("underlayIds")
   static byte[][][] underlayIds;
   @ObfuscatedName("g")
   public static class182 field967;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "-1051186251"
   )
   MessageNode method858(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1878256770"
   )
   int method859() {
      return this.length;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)LMessageNode;",
      garbageValue = "-418431228"
   )
   MessageNode method863(int var1, String var2, String var3, String var4) {
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
         var5.method2361();
         var5.method176(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }
}
