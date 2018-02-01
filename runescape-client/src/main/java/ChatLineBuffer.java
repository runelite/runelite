import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Lbl;"
   )
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1969048231
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lbl;",
      garbageValue = "536400510"
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
      signature = "(IB)Lbl;",
      garbageValue = "76"
   )
   @Export("getMessage")
   MessageNode getMessage(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-2924"
   )
   @Export("size")
   int size() {
      return this.length;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BB)Ljava/lang/String;",
      garbageValue = "37"
   )
   public static String method2017(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < var2 + 0; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class292.field3771[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class292.field3771[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class292.field3771[(var6 & 15) << 2 | var7 >>> 6]).append(class292.field3771[var7 & 63]);
            } else {
               var3.append(class292.field3771[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class292.field3771[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)[Lir;",
      garbageValue = "125"
   )
   public static JagexGame[] method2010() {
      return new JagexGame[]{JagexGame.field3266, JagexGame.field3267, JagexGame.field3269, JagexGame.field3265, JagexGame.field3268, JagexGame.field3272};
   }
}
