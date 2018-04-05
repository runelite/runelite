import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
public class class88 {
   @ObfuscatedName("o")
   static final BigInteger field1345;
   @ObfuscatedName("k")
   static final BigInteger field1346;

   static {
      field1345 = new BigInteger("10001", 16);
      field1346 = new BigInteger("8c2fa7b0d382137893318d3fda891138e957d00298df52ce53b5e53fda1eafb9dfa623bdc78fe87c2dcabd04698b27c446a72aee861ceed45c85e7c10db182d95e3514b67d44e92e1df9c10a3136207ffd9df0956fe4507fb969ab0abb4e19b876b16752f90de888c88e393a769c0c13977ee81c79549e9a690f112230ff4303", 16);
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1598147844"
   )
   static final void method1893(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class189.loadWidget(var0)) {
         class66.field785 = null;
         GameCanvas.gameDraw(MouseRecorder.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class66.field785 != null) {
            GameCanvas.gameDraw(class66.field785, -1412584499, var1, var2, var3, var4, CombatInfoListHolder.field1310, GrandExchangeEvent.field300, var7);
            class66.field785 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1072[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1072[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(Lin;I)V",
      garbageValue = "-1994717479"
   )
   static final void method1894(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field1044 == -1) {
            Client.field1044 = var0.spriteId;
            Client.field1138 = var0.field2858;
         }

         if(Client.field1132.isFemale) {
            var0.spriteId = Client.field1044;
         } else {
            var0.spriteId = Client.field1138;
         }

      } else if(var1 == 325) {
         if(Client.field1044 == -1) {
            Client.field1044 = var0.spriteId;
            Client.field1138 = var0.field2858;
         }

         if(Client.field1132.isFemale) {
            var0.spriteId = Client.field1138;
         } else {
            var0.spriteId = Client.field1044;
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
