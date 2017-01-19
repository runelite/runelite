import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("c")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("ag")
   static SpritePixels[] field222;
   @ObfuscatedName("h")
   static class182 field224;
   @ObfuscatedName("s")
   @Export("name")
   String name;

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-3"
   )
   static final void method166() {
      int[] var0 = class45.field896;

      int var1;
      for(var1 = 0; var1 < class45.field894; ++var1) {
         Player var4 = Client.cachedPlayers[var0[var1]];
         if(null != var4 && var4.field649 > 0) {
            --var4.field649;
            if(var4.field649 == 0) {
               var4.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.field332; ++var1) {
         int var2 = Client.field333[var1];
         NPC var3 = Client.cachedNPCs[var2];
         if(null != var3 && var3.field649 > 0) {
            --var3.field649;
            if(var3.field649 == 0) {
               var3.overhead = null;
            }
         }
      }

   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1282523616"
   )
   static final void method167() {
      for(class25 var0 = (class25)Client.field359.method2330(); var0 != null; var0 = (class25)Client.field359.method2346()) {
         if(var0.field588 > 0) {
            --var0.field588;
         }

         boolean var1;
         int var2;
         int var3;
         ObjectComposition var4;
         if(var0.field588 == 0) {
            if(var0.field580 >= 0) {
               var2 = var0.field580;
               var3 = var0.field591;
               var4 = class143.getObjectDefinition(var2);
               if(var3 == 11) {
                  var3 = 10;
               }

               if(var3 >= 5 && var3 <= 8) {
                  var3 = 4;
               }

               var1 = var4.method3485(var3);
               if(!var1) {
                  continue;
               }
            }

            WidgetNode.method159(var0.field584, var0.field578, var0.field579, var0.field583, var0.field580, var0.field582, var0.field591);
            var0.unlink();
         } else {
            if(var0.field586 > 0) {
               --var0.field586;
            }

            if(var0.field586 == 0 && var0.field579 >= 1 && var0.field583 >= 1 && var0.field579 <= 102 && var0.field583 <= 102) {
               if(var0.field581 >= 0) {
                  var2 = var0.field581;
                  var3 = var0.field592;
                  var4 = class143.getObjectDefinition(var2);
                  if(var3 == 11) {
                     var3 = 10;
                  }

                  if(var3 >= 5 && var3 <= 8) {
                     var3 = 4;
                  }

                  var1 = var4.method3485(var3);
                  if(!var1) {
                     continue;
                  }
               }

               WidgetNode.method159(var0.field584, var0.field578, var0.field579, var0.field583, var0.field581, var0.field585, var0.field592);
               var0.field586 = -1;
               if(var0.field580 == var0.field581 && var0.field580 == -1) {
                  var0.unlink();
               } else if(var0.field580 == var0.field581 && var0.field582 == var0.field585 && var0.field591 == var0.field592) {
                  var0.unlink();
               }
            }
         }
      }

   }
}
