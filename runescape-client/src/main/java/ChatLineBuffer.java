import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("s")
   static int[] field1458;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Lbx;"
   )
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 528648965
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lbx;",
      garbageValue = "-2133375856"
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Lbx;",
      garbageValue = "2022353157"
   )
   MessageNode method1940(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1088046528"
   )
   int method1941() {
      return this.length;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1032473279"
   )
   public static boolean method1947(int var0) {
      return (var0 & 1) != 0;
   }
}
