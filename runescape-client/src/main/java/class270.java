import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
public final class class270 {
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = -1726632277
   )
   static int field3689;

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "15"
   )
   static final void method4894(int var0, int var1, int var2, int var3) {
      if(Client.cursorState == 1) {
         IndexData.field3258[Client.field967 / 100].method5042(Client.field1190 - 8, Client.field1034 - 8);
      }

      if(Client.cursorState == 2) {
         IndexData.field3258[Client.field967 / 100 + 4].method5042(Client.field1190 - 8, Client.field1034 - 8);
      }

      Client.field1045 = 0;
      int var4 = (XItemContainer.localPlayer.x >> 7) + KeyFocusListener.baseX;
      int var5 = (XItemContainer.localPlayer.y >> 7) + class266.baseY;
      if(var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
         Client.field1045 = 1;
      }

      if(var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
         Client.field1045 = 1;
      }

      if(Client.field1045 == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
         Client.field1045 = 0;
      }

   }
}
