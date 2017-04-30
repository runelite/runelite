import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class16 extends class152 {
   @ObfuscatedName("c")
   String field170;
   @ObfuscatedName("n")
   short field171;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1995072713
   )
   int field172;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 154579537
   )
   public static int field176;
   @ObfuscatedName("bb")
   static IndexData field177;

   class16(String var1, int var2) {
      this.field172 = (int)(class72.method1421() / 1000L);
      this.field170 = var1;
      this.field171 = (short)var2;
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "78"
   )
   static void method190() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[var3 + 1];
                  Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                  Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "93214998"
   )
   static int method191(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class200.field2894:Script.field942;
      if(var0 == 1800) {
         class32.field720[++class32.field715 - 1] = CombatInfo2.method3540(class103.method1988(var3));
         return 1;
      } else if(var0 != 1801) {
         if(var0 == 1802) {
            if(var3.name == null) {
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
            } else {
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = class32.field720[--class32.field715];
         --var4;
         if(var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.actions[var4];
         } else {
            class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;ZI)V",
      garbageValue = "-937864347"
   )
   public static void method192(IndexDataBase var0, IndexDataBase var1, boolean var2) {
      ObjectComposition.field2967 = var0;
      ObjectComposition.field2925 = var1;
      ObjectComposition.field2947 = var2;
   }
}
