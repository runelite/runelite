import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("j")
   @Export("value")
   String value;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 158464881
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1662384491
   )
   @Export("type")
   int type;
   @ObfuscatedName("c")
   @Export("name")
   String name;
   @ObfuscatedName("v")
   @Export("sender")
   String sender;
   @ObfuscatedName("cl")
   static class227 field800;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1638783803
   )
   @Export("id")
   int id = class52.method1078();
   @ObfuscatedName("bc")
   static class171 field802;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1969438505
   )
   static int field803;
   @ObfuscatedName("ew")
   static SpritePixels[] field804;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 1175392687
   )
   protected static int field806;
   @ObfuscatedName("b")
   static Widget field808;

   MessageNode(int var1, String var2, String var3, String var4) {
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1469016465"
   )
   void method757(int var1, String var2, String var3, String var4) {
      this.id = class52.method1078();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "2108805881"
   )
   static final boolean method761(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else {
         boolean var1 = var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
         if(var1) {
            return true;
         } else {
            char[] var2 = class167.field2702;

            int var3;
            char var4;
            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3];
               if(var4 == var0) {
                  return true;
               }
            }

            var2 = class167.field2703;

            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3];
               if(var0 == var4) {
                  return true;
               }
            }

            return false;
         }
      }
   }
}
