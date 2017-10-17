import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("cn")
   public static char field1546;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 1462660465
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Lbm;"
   )
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1475713077
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lbm;",
      garbageValue = "10833127"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IS)Lbm;",
      garbageValue = "-20723"
   )
   MessageNode method1940(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-124"
   )
   int method1938() {
      return this.length;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1153741484"
   )
   public static boolean method1945(int var0) {
      return var0 == class221.field2837.field2838;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lit;I)V",
      garbageValue = "1650578553"
   )
   public static void method1936(IndexDataBase var0) {
      InvType.field3283 = var0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1729797070"
   )
   @Export("adjustHSLListness0")
   static final int adjustHSLListness0(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
