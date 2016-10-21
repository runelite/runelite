import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("e")
   @Export("lines")
   MessageNode[] lines = new MessageNode[100];
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2137584495
   )
   @Export("length")
   int length;
   @ObfuscatedName("s")
   static int[] field685;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "417020642"
   )
   MessageNode method657(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2040320688"
   )
   int method659() {
      return this.length;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Lclass43;",
      garbageValue = "-1919953979"
   )
   public static class43 method661(int var0) {
      class43 var1 = (class43)class43.field975.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class43.field981.method3304(1, var0);
         var1 = new class43();
         if(null != var2) {
            var1.method862(new Buffer(var2), var0);
         }

         var1.method861();
         class43.field975.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1078464900"
   )
   static final int method667(int var0, int var1) {
      int var2 = class164.method3217(var0 + '넵', var1 + 91923, 4) - 128 + (class164.method3217(10294 + var0, var1 + '鎽', 2) - 128 >> 1) + (class164.method3217(var0, var1, 1) - 128 >> 2);
      var2 = 35 + (int)((double)var2 * 0.3D);
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)LMessageNode;",
      garbageValue = "16"
   )
   MessageNode method668(int var1, String var2, String var3, String var4) {
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
         var5.method3968();
         var5.method751(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }
}
