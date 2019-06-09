import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class48 {
   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Lij;",
      garbageValue = "-818052349"
   )
   public static PlayerType[] method865() {
      return new PlayerType[]{PlayerType.PlayerType_normal, PlayerType.PlayerType_ironman, PlayerType.PlayerType_hardcoreIronman, PlayerType.PlayerType_ultimateIronman, PlayerType.PlayerType_playerModerator, PlayerType.PlayerType_jagexModerator};
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "643714573"
   )
   static final void method868() {
      if(Client.__client_fd > 0) {
         TextureProvider.method2773();
      } else {
         Client.timer.__f_454();
         GameShell.updateGameState(40);
         ClientParameter.__ji_fp = Client.packetWriter.getSocket();
         Client.packetWriter.removeSocket();
      }
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(Lho;I)Lho;",
      garbageValue = "-1926681563"
   )
   static Widget method869(Widget var0) {
      Widget var2 = var0;
      int var3 = WorldMapRegion.method568(class1.getWidgetClickMask(var0));
      Widget var1;
      if(var3 == 0) {
         var1 = null;
      } else {
         int var4 = 0;

         while(true) {
            if(var4 >= var3) {
               var1 = var2;
               break;
            }

            var2 = Huffman.getWidget(var2.parentId);
            if(var2 == null) {
               var1 = null;
               break;
            }

            ++var4;
         }
      }

      Widget var5 = var1;
      if(var1 == null) {
         var5 = var0.parent;
      }

      return var5;
   }
}
