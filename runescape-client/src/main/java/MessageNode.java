import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("d")
   @Export("sender")
   String sender;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 127908363
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      intValue = -549021293
   )
   static int field218;
   @ObfuscatedName("q")
   @Export("name")
   String name;
   @ObfuscatedName("k")
   @Export("value")
   String value;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1882603271
   )
   @Export("type")
   int type;
   @ObfuscatedName("bt")
   @Export("host")
   static String host;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -752682087
   )
   @Export("id")
   int id;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "2088408994"
   )
   static SpritePixels method200() {
      SpritePixels var0 = new SpritePixels();
      var0.maxWidth = class225.field3214;
      var0.maxHeight = NPC.field761;
      var0.offsetX = class225.field3216[0];
      var0.offsetY = class225.field3215[0];
      var0.width = class22.field231[0];
      var0.height = class225.field3218[0];
      int var1 = var0.width * var0.height;
      byte[] var2 = class48.field949[0];
      var0.image = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.image[var3] = class183.field2719[var2[var3] & 255];
      }

      class225.field3216 = null;
      class225.field3215 = null;
      class22.field231 = null;
      class225.field3218 = null;
      class183.field2719 = null;
      class48.field949 = null;
      return var0;
   }

   MessageNode(int var1, String var2, String var3, String var4) {
      int var5 = ++class47.field934 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "1027175761"
   )
   static String method203(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field424 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field424 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field424 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field424 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field424 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class47.field927 != null) {
         var3 = "/p=" + class47.field927;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field353 + "/a=" + class146.field2022 + var3 + "/";
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-578679981"
   )
   static void method204(String var0, String var1, String var2) {
      class41.loginMessage1 = var0;
      class41.loginMessage2 = var1;
      class41.loginMessage3 = var2;
   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Ljava/lang/String;",
      garbageValue = "-825282394"
   )
   static String method205(Widget var0) {
      int var2 = class36.method724(var0);
      int var1 = var2 >> 11 & 63;
      return var1 == 0?null:(var0.field2275 != null && var0.field2275.trim().length() != 0?var0.field2275:null);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-847133267"
   )
   void method206(int var1, String var2, String var3, String var4) {
      int var5 = ++class47.field934 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }
}
