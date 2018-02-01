import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class221 extends CacheableNode {
   @ObfuscatedName("qu")
   @ObfuscatedSignature(
      signature = "Lbh;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1112064235
   )
   public final int field2686;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -720771321
   )
   public final int field2684;
   @ObfuscatedName("w")
   public final int[] field2683;
   @ObfuscatedName("s")
   public final int[] field2685;

   class221(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2686 = var1;
      this.field2684 = var2;
      this.field2683 = var3;
      this.field2685 = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-168967528"
   )
   public boolean method4175(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2685.length) {
         int var3 = this.field2685[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2683[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "41"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class94.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class94.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
      class94.messages.put(var5, (long)var5.id);
      class94.field1401.add(var5);
      Client.chatCycle = Client.cycleCntr;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lik;Ljava/lang/String;Ljava/lang/String;B)Lkh;",
      garbageValue = "-45"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite var5;
      if(!class160.method3147(var0, var3, var4)) {
         var5 = null;
      } else {
         IndexedSprite var7 = new IndexedSprite();
         var7.width = class310.field3891;
         var7.originalHeight = class310.field3898;
         var7.offsetX = class310.field3892[0];
         var7.offsetY = class310.offsetsY[0];
         var7.originalWidth = class310.field3895[0];
         var7.height = class310.field3896[0];
         var7.palette = class310.field3897;
         var7.pixels = class160.spritePixels[0];
         class47.method698();
         var5 = var7;
      }

      return var5;
   }
}
