import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class150 extends class297 {
   @ObfuscatedName("c")
   final boolean field2125;

   public class150(boolean var1) {
      this.field2125 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;B)I",
      garbageValue = "-68"
   )
   int method3128(ChatPlayer var1, ChatPlayer var2) {
      return Client.world == var1.world && var2.world == Client.world?(this.field2125?var1.method5260().method5441(var2.method5260()):var2.method5260().method5441(var1.method5260())):this.method5288(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3128((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILcx;ZB)I",
      garbageValue = "14"
   )
   static int method3133(int var0, Script var1, boolean var2) {
      if(var0 == 3200) {
         SceneTilePaint.intStackSize -= 3;
         Permission.method4531(class81.intStack[SceneTilePaint.intStackSize], class81.intStack[SceneTilePaint.intStackSize + 1], class81.intStack[SceneTilePaint.intStackSize + 2]);
         return 1;
      } else if(var0 != 3201) {
         if(var0 == 3202) {
            SceneTilePaint.intStackSize -= 2;
            class95.method2006(class81.intStack[SceneTilePaint.intStackSize], class81.intStack[SceneTilePaint.intStackSize + 1]);
            return 1;
         } else {
            return 2;
         }
      } else {
         int var3 = class81.intStack[--SceneTilePaint.intStackSize];
         if(var3 == -1 && !Client.field1090) {
            class229.field2679.method4150();
            class229.field2680 = 1;
            class61.field714 = null;
         } else if(var3 != -1 && var3 != Client.field1089 && Client.field1044 != 0 && !Client.field1090) {
            CacheFile.method2509(2, class1.indexTrack1, var3, 0, Client.field1044, false);
         }

         Client.field1089 = var3;
         return 1;
      }
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(B)Lli;",
      garbageValue = "23"
   )
   static RenderOverview method3134() {
      return ScriptState.renderOverview;
   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1874926418"
   )
   static final void method3132() {
      if(Client.field903 > 0) {
         FriendManager.method1722();
      } else {
         Client.field1050.method5211();
         MapIconReference.setGameState(40);
         ContextMenuRow.field1324 = Client.field902.getSocket();
         Client.field902.method2038();
      }
   }
}
