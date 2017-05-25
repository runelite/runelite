import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class56 {
   @ObfuscatedName("h")
   static String field673;
   @ObfuscatedName("x")
   static class234 field674;
   @ObfuscatedName("k")
   static ModIcon field676;
   @ObfuscatedName("a")
   public static IndexDataBase field677;
   @ObfuscatedName("i")
   static Applet field678;

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-1240348961"
   )
   static final void method817(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field1163 == -1) {
            Client.field1163 = var0.spriteId;
            Client.field1055 = var0.field2678;
         }

         if(Client.field1162.isFemale) {
            var0.spriteId = Client.field1163;
         } else {
            var0.spriteId = Client.field1055;
         }

      } else if(var1 == 325) {
         if(Client.field1163 == -1) {
            Client.field1163 = var0.spriteId;
            Client.field1055 = var0.field2678;
         }

         if(Client.field1162.isFemale) {
            var0.spriteId = Client.field1055;
         } else {
            var0.spriteId = Client.field1163;
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

   static {
      field678 = null;
      field673 = null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "-2115669398"
   )
   public static ModIcon[] method826(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method4189(var1);
      int var4 = var0.method4190(var3, var2);
      ModIcon[] var5;
      if(!class228.method4155(var0, var3, var4)) {
         var5 = null;
      } else {
         ModIcon[] var7 = new ModIcon[class286.field3786];

         for(int var8 = 0; var8 < class286.field3786; ++var8) {
            ModIcon var9 = var7[var8] = new ModIcon();
            var9.width = class286.field3784;
            var9.originalHeight = class286.field3787;
            var9.offsetX = class286.field3785[var8];
            var9.offsetY = class286.field3783[var8];
            var9.originalWidth = class252.field3387[var8];
            var9.height = class267.field3667[var8];
            var9.palette = class87.field1355;
            var9.pixels = MessageNode.field843[var8];
         }

         class286.field3785 = null;
         class286.field3783 = null;
         class252.field3387 = null;
         class267.field3667 = null;
         class87.field1355 = null;
         MessageNode.field843 = null;
         var5 = var7;
      }

      return var5;
   }
}
