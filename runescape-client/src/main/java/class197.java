import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class197 {
   @ObfuscatedName("x")
   static final int[] field2588;
   @ObfuscatedName("y")
   static final int[] field2595;

   static {
      field2588 = new int[2048];
      field2595 = new int[2048];
      double var0 = 0.0030679615757712823D;

      for(int var2 = 0; var2 < 2048; ++var2) {
         field2588[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
         field2595[var2] = (int)(65536.0D * Math.cos(var0 * (double)var2));
      }

   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-677649719"
   )
   static final void method3746() {
      CombatInfo1.method1672();
      if(GameEngine.clanMemberManager != null) {
         GameEngine.clanMemberManager.method5461();
      }

   }
}
