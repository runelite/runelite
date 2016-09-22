import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("d")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("v")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};
   @ObfuscatedName("a")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "406786012"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(Client.gameState != var0) {
         if(Client.gameState == 0) {
            class51.method1071();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.field290 = 0;
            Client.field315 = 0;
            Client.field316 = 0;
         }

         if(var0 != 20 && var0 != 40 && class10.field163 != null) {
            class10.field163.method3039();
            class10.field163 = null;
         }

         if(Client.gameState == 25) {
            Client.field340 = 0;
            Client.field289 = 0;
            Client.field390 = 1;
            Client.field338 = 0;
            Client.field339 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class170.method3331(class79.canvas, Client.field311, ItemComposition.field1230, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class170.method3331(class79.canvas, Client.field311, ItemComposition.field1230, false, 4);
            } else {
               class136.method2891();
            }
         } else {
            class170.method3331(class79.canvas, Client.field311, ItemComposition.field1230, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "433373266"
   )
   static final void method177(boolean var0) {
      WidgetNode.method41();
      ++Client.field329;
      if(Client.field329 >= 50 || var0) {
         Client.field329 = 0;
         if(!Client.field334 && BufferProvider.field1475 != null) {
            Client.field323.method2801(148);

            try {
               BufferProvider.field1475.method3025(Client.field323.payload, 0, Client.field323.offset);
               Client.field323.offset = 0;
            } catch (IOException var2) {
               Client.field334 = true;
            }
         }

      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1116966083"
   )
   static final void method179() {
      int[] var0 = class34.field780;

      int var1;
      for(var1 = 0; var1 < class34.field779; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(null != var2 && var2.field855 > 0) {
            --var2.field855;
            if(var2.field855 == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.field319; ++var1) {
         int var4 = Client.field320[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(var3 != null && var3.field855 > 0) {
            --var3.field855;
            if(var3.field855 == 0) {
               var3.overhead = null;
            }
         }
      }

   }
}
