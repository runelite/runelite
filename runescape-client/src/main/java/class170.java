import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class170 extends Node {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[Lfg;"
   )
   static class170[] field2425;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -885501379
   )
   static int field2422;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfo;"
   )
   public class167 field2424;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 670145281
   )
   public int field2426;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 371546937
   )
   public int field2427;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   public PacketBuffer field2423;

   static {
      field2425 = new class170[300];
      field2422 = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "93"
   )
   public void method3193() {
      if(field2422 < field2425.length) {
         field2425[++field2422 - 1] = this;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2087511887"
   )
   public static void method3194() {
      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var0 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILcw;ZB)I",
      garbageValue = "10"
   )
   static int method3195(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = PendingSpawn.method1612(class82.intStack[--class56.intStackSize]);
      } else {
         var3 = var2?class285.field3789:Friend.field768;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class82.intStack[--class56.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method4163(var4, class82.scriptStringStack[--class24.scriptStringStackSize]);
            return 1;
         } else {
            --class24.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class56.intStackSize -= 2;
         var4 = class82.intStack[class56.intStackSize];
         int var5 = class82.intStack[class56.intStackSize + 1];
         var3.dragParent = class189.method3613(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2804 = class82.intStack[--class56.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2789 = class82.intStack[--class56.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2803 = class82.intStack[--class56.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class82.scriptStringStack[--class24.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class82.scriptStringStack[--class24.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }
}
