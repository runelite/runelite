import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("x")
   @Export("progress")
   byte progress;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1684438103
   )
   @Export("price")
   public int price;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 179622269
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1795701103
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1872696803
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1179570091
   )
   @Export("spent")
   public int spent;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1419269721"
   )
   void method4010(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1470295072"
   )
   public int method4013() {
      return this.progress & 7;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int method4014() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "740209497"
   )
   void method4015(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   public XGrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.method2557();
      this.itemId = var1.method2551();
      this.price = var1.method2561();
      this.totalQuantity = var1.method2561();
      this.quantitySold = var1.method2561();
      this.spent = var1.method2561();
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "281581010"
   )
   @Export("generateMenuActionsForPlayer")
   static final void generateMenuActionsForPlayer(Player var0, int var1, int var2, int var3) {
      if(var0 != class48.localPlayer) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.field32 == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + Buffer.method2675(var0.combatLevel, class48.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field32 + ")" + var0.actions[2];
            }

            int var5;
            if(Client.field432 == 1) {
               XItemContainer.addMenuEntry("Use", Client.field433 + " " + "->" + " " + class154.method3185(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field404) {
               if((class171.field2749 & 8) == 8) {
                  XItemContainer.addMenuEntry(Client.field437, Client.field438 + " " + "->" + " " + class154.method3185(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(null != Client.field408[var5]) {
                     short var6 = 0;
                     if(Client.field408[var5].equalsIgnoreCase("Attack")) {
                        if(Client.field415 == class21.field577) {
                           continue;
                        }

                        if(Client.field415 == class21.field575 || Client.field415 == class21.field574 && var0.combatLevel > class48.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(class48.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class48.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.field409[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = Client.field407[var5] + var6;
                     XItemContainer.addMenuEntry(Client.field408[var5], class154.method3185(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class154.method3185(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
