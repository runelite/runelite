import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("ad")
   static int[] field699;
   @ObfuscatedName("g")
   @Export("lines")
   MessageNode[] lines = new MessageNode[100];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 295762615
   )
   @Export("length")
   int length;
   @ObfuscatedName("lh")
   static class133 field706;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-37"
   )
   int method669() {
      return this.length;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "823588420"
   )
   MessageNode method670(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)LMessageNode;",
      garbageValue = "-86023179"
   )
   MessageNode method674(int var1, String var2, String var3, String var4) {
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
         var5.method4045();
         var5.method780(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lclass53;",
      garbageValue = "-1870535716"
   )
   public static class53 method679(int var0) {
      class53 var1 = (class53)class53.field1167.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class53.field1164.method3411(15, var0);
         var1 = new class53();
         if(var2 != null) {
            var1.method1134(new Buffer(var2));
         }

         class53.field1167.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "4032"
   )
   static final boolean method680(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }
}
