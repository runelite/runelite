import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("am")
   static int[] field230;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1871082685
   )
   @Export("type")
   int type;
   @ObfuscatedName("g")
   @Export("name")
   String name;
   @ObfuscatedName("h")
   @Export("sender")
   String sender;
   @ObfuscatedName("v")
   @Export("value")
   String value;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1394102869
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 1995946803
   )
   static int field237;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1422299407
   )
   @Export("id")
   int id = class1.method14();

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1662010682"
   )
   void method199(int var1, String var2, String var3, String var4) {
      this.id = class1.method14();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1871649558"
   )
   public static void method201(boolean var0) {
      if(null != class185.field2774) {
         try {
            Buffer var1 = new Buffer(4);
            var1.method2815(var0?2:3);
            var1.method2713(0);
            class185.field2774.method2016(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class185.field2774.method2027();
            } catch (Exception var3) {
               ;
            }

            ++class185.field2763;
            class185.field2774 = null;
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "28"
   )
   static int method203(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      return null == var1?0:var1.method884();
   }

   MessageNode(int var1, String var2, String var3, String var4) {
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }
}
