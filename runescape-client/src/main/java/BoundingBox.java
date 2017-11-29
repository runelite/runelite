import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("BoundingBox")
public abstract class BoundingBox extends Node {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 49293133
   )
   static int field239;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "106"
   )
   @Export("draw")
   abstract void draw();

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILce;ZB)I",
      garbageValue = "4"
   )
   static int method55(int var0, Script var1, boolean var2) {
      if(var0 == 3200) {
         GrandExchangeEvents.intStackSize -= 3;
         class46.method706(class82.intStack[GrandExchangeEvents.intStackSize], class82.intStack[GrandExchangeEvents.intStackSize + 1], class82.intStack[GrandExchangeEvents.intStackSize + 2]);
         return 1;
      } else if(var0 != 3201) {
         if(var0 == 3202) {
            GrandExchangeEvents.intStackSize -= 2;
            CombatInfoListHolder.method1730(class82.intStack[GrandExchangeEvents.intStackSize], class82.intStack[GrandExchangeEvents.intStackSize + 1]);
            return 1;
         } else {
            return 2;
         }
      } else {
         int var3 = class82.intStack[--GrandExchangeEvents.intStackSize];
         if(var3 == -1 && !Client.field1095) {
            Ignore.method1126();
         } else if(var3 != -1 && var3 != Client.field1090 && Client.field1113 != 0 && !Client.field1095) {
            IndexData var4 = RSCanvas.indexTrack1;
            int var5 = Client.field1113;
            class210.field2598 = 1;
            class3.field22 = var4;
            BoundingBox2D.field237 = var3;
            class210.field2599 = 0;
            class111.field1588 = var5;
            class20.field322 = false;
            class164.field2216 = 2;
         }

         Client.field1090 = var3;
         return 1;
      }
   }
}
