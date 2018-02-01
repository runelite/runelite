import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public class class54 {
   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZB)[B",
      garbageValue = "14"
   )
   @Export("toByteArray")
   public static byte[] toByteArray(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof AbstractByteBuffer) {
         AbstractByteBuffer var2 = (AbstractByteBuffer)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-55"
   )
   static final void method775() {
      if(Client.gameCycle == Client.field949) {
         if(class234.clanMemberManager != null) {
            class234.clanMemberManager.method5047();
         }

         for(int var0 = 0; var0 < class92.playerIndexesCount; ++var0) {
            Player var1 = Client.cachedPlayers[class92.playerIndices[var0]];
            var1.method1133();
         }
      }

   }
}
