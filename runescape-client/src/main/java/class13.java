import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class13 {
   @ObfuscatedName("ec")
   static SpritePixels[] field130;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = 803944361
   )
   static int field136;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "16"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      if(null == var4) {
         var4 = new ChatLineBuffer();
         class47.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method868(var0, var1, var2, var3);
      class47.field944.method2283(var5, (long)var5.id);
      class47.field940.method2429(var5);
      Client.field361 = Client.field471;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1112423957"
   )
   static boolean method164(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "929277339"
   )
   static final void method165(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field567 == -1) {
            Client.field567 = var0.textureId;
            Client.field561 = var0.field2331;
         }

         if(Client.field284.isFemale) {
            var0.textureId = Client.field567;
         } else {
            var0.textureId = Client.field561;
         }

      } else if(var1 == 325) {
         if(Client.field567 == -1) {
            Client.field567 = var0.textureId;
            Client.field561 = var0.field2331;
         }

         if(Client.field284.isFemale) {
            var0.textureId = Client.field561;
         } else {
            var0.textureId = Client.field567;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }
}
