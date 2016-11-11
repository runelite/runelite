import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public final class class92 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2070950415
   )
   int field1602;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1560654019
   )
   int field1603;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -961195667
   )
   int field1604;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1410844351
   )
   int field1606;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1048161575
   )
   int field1608;
   @ObfuscatedName("u")
   boolean field1609 = true;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -33573341
   )
   int field1612;

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class92(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1608 = var1;
      this.field1602 = var2;
      this.field1612 = var3;
      this.field1603 = var4;
      this.field1604 = var5;
      this.field1606 = var6;
      this.field1609 = var7;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "-855456001"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field1167.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class129.field2096.method3292(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(null != var2) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method1134();
         if(var1.field1203 != -1) {
            var1.method1164(getItemDefinition(var1.field1203), getItemDefinition(var1.note));
         }

         if(var1.field1185 != -1) {
            var1.method1118(getItemDefinition(var1.field1185), getItemDefinition(var1.field1211));
         }

         if(var1.field1212 != -1) {
            var1.method1119(getItemDefinition(var1.field1212), getItemDefinition(var1.field1213));
         }

         if(!class229.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field1210 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.field1209 = 0;
         }

         ItemComposition.field1167.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1338416082"
   )
   static final void method2137(boolean var0) {
      while(true) {
         if(Client.field347.method2789(Client.field348) >= 27) {
            int var1 = Client.field347.method2787(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(Client.cachedNPCs[var1] == null) {
                  Client.cachedNPCs[var1] = new NPC();
                  var2 = true;
               }

               NPC var3 = Client.cachedNPCs[var1];
               Client.field342[++Client.field341 - 1] = var1;
               var3.field884 = Client.gameCycle;
               int var4;
               if(var0) {
                  var4 = Client.field347.method2787(8);
                  if(var4 > 127) {
                     var4 -= 256;
                  }
               } else {
                  var4 = Client.field347.method2787(5);
                  if(var4 > 15) {
                     var4 -= 32;
                  }
               }

               var3.composition = Friend.getNpcDefinition(Client.field347.method2787(14));
               int var5 = Client.field431[Client.field347.method2787(3)];
               if(var2) {
                  var3.angle = var5 * 1274109597;
                  var3.field886 = var5;
               }

               int var6 = Client.field347.method2787(1);
               if(var6 == 1) {
                  Client.field555[++Client.field343 - 1] = var1;
               }

               int var7 = Client.field347.method2787(1);
               int var8;
               if(var0) {
                  var8 = Client.field347.method2787(8);
                  if(var8 > 127) {
                     var8 -= 256;
                  }
               } else {
                  var8 = Client.field347.method2787(5);
                  if(var8 > 15) {
                     var8 -= 32;
                  }
               }

               var3.field839 = var3.composition.field910;
               var3.field888 = var3.composition.field933;
               if(var3.field888 == 0) {
                  var3.angle = 0;
               }

               var3.field859 = var3.composition.field916;
               var3.field844 = var3.composition.field930;
               var3.field845 = var3.composition.field918;
               var3.field846 = var3.composition.field907;
               var3.idlePoseAnimation = var3.composition.field934;
               var3.field862 = var3.composition.field921;
               var3.field842 = var3.composition.field915;
               var3.method742(var4 + class138.localPlayer.pathX[0], class138.localPlayer.pathY[0] + var8, var7 == 1);
               continue;
            }
         }

         Client.field347.method2790();
         return;
      }
   }
}
