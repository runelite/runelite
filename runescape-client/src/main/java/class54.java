import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
public class class54 {
   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "Lcb;"
   )
   static class89 field669;

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1491893349"
   )
   static final void method752() {
      for(int var0 = 0; var0 < Client.field953; ++var0) {
         int var1 = Client.npcIndices[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            class82.method1554(var2, var2.composition.field3532);
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZZI)I",
      garbageValue = "1143291701"
   )
   public static int method753(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = class238.field3225 + class238.field3238 + var2;
      return var3;
   }
}
