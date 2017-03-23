import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class20 implements Runnable {
   @ObfuscatedName("r")
   int[] field226 = new int[500];
   @ObfuscatedName("i")
   Object field227 = new Object();
   @ObfuscatedName("f")
   boolean field228 = true;
   @ObfuscatedName("h")
   int[] field229 = new int[500];
   @ObfuscatedName("cf")
   static RSSocket field233;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1278901
   )
   int field234 = 0;
   @ObfuscatedName("o")
   public static class182 field235;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Lclass186;",
      garbageValue = "59"
   )
   public static class186 method181(int var0) {
      class186 var1 = (class186)class186.field2784.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class186.field2783.getConfigData(5, var0);
         var1 = new class186();
         if(var2 != null) {
            var1.method3478(new Buffer(var2));
         }

         class186.field2784.put(var1, (long)var0);
         return var1;
      }
   }

   public void run() {
      for(; this.field228; class115.method2300(50L)) {
         Object var1 = this.field227;
         synchronized(this.field227) {
            if(this.field234 < 500) {
               this.field229[this.field234] = class115.field1817;
               this.field226[this.field234] = class115.field1818;
               ++this.field234;
            }
         }
      }

   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1695865908"
   )
   static final void method185(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.field455 != 0 || Client.field458) {
         int var2 = World.method635();
         String var3;
         if(Client.field455 == 1 && Client.menuOptionCount < 2) {
            var3 = "Use" + " " + Client.field457 + " " + "->";
         } else if(Client.field458 && Client.menuOptionCount < 2) {
            var3 = Client.field326 + " " + Client.field527 + " " + "->";
         } else {
            String var4;
            if(var2 < 0) {
               var4 = "";
            } else if(Client.menuTargets[var2].length() > 0) {
               var4 = Client.menuOptions[var2] + " " + Client.menuTargets[var2];
            } else {
               var4 = Client.menuOptions[var2];
            }

            var3 = var4;
         }

         if(Client.menuOptionCount > 2) {
            var3 = var3 + XItemContainer.method153(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
         }

         class63.field1119.method3909(var3, var0 + 4, 15 + var1, 16777215, 0, Client.gameCycle / 1000);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-90"
   )
   static void method186(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field699[var5] != var0) {
            var2[var4] = World.field699[var5];
            var3[var4] = World.field698[var5];
            ++var4;
         }
      }

      World.field699 = var2;
      World.field698 = var3;
      class3.method25(World.worldList, 0, World.worldList.length - 1, World.field699, World.field698);
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "778713301"
   )
   static final void method187(Widget var0, int var1, int var2) {
      if(null == Client.field476 && !Client.isMenuOpen) {
         if(null != var0) {
            Widget var4 = DecorativeObject.method1956(var0);
            if(null == var4) {
               var4 = var0.parent;
            }

            if(null != var4) {
               Client.field476 = var0;
               var4 = DecorativeObject.method1956(var0);
               if(null == var4) {
                  var4 = var0.parent;
               }

               Client.field477 = var4;
               Client.field478 = var1;
               Client.field479 = var2;
               class44.field912 = 0;
               Client.field487 = false;
               int var5 = World.method635();
               if(var5 != -1) {
                  GameObject.field1645 = new class38();
                  GameObject.field1645.field820 = Client.menuActionParams0[var5];
                  GameObject.field1645.field816 = Client.menuActionParams1[var5];
                  GameObject.field1645.field817 = Client.menuTypes[var5];
                  GameObject.field1645.field818 = Client.menuIdentifiers[var5];
                  GameObject.field1645.field819 = Client.menuOptions[var5];
               }

               return;
            }
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass189;",
      garbageValue = "1094155329"
   )
   public static class189 method188(int var0) {
      class189 var1 = (class189)class189.field2799.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class189.field2801.getConfigData(15, var0);
         var1 = new class189();
         if(null != var2) {
            var1.method3503(new Buffer(var2));
         }

         class189.field2799.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "469546424"
   )
   static final void method189() {
      class88.method1921();
      FloorUnderlayDefinition.field2821.reset();
      KitDefinition.field2830.reset();
      class149.method2834();
      NPCComposition.field3026.reset();
      NPCComposition.npcModelCache.reset();
      ItemComposition.field2952.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      Sequence.field3058.reset();
      Sequence.field3071.reset();
      Spotanim.field2804.reset();
      Spotanim.field2818.reset();
      Varbit.field2856.reset();
      CombatInfoListHolder.method732();
      class47.method919();
      ObjectComposition.method3677();
      ItemLayer.method1492();
      Widget.field2260.reset();
      Widget.field2214.reset();
      Widget.field2215.reset();
      Widget.field2323.reset();
      ((TextureProvider)class84.field1472).method1467();
      Script.field968.reset();
      class157.field2137.method3349();
      ChatLineBuffer.field988.method3349();
      class37.field805.method3349();
      class116.field1830.method3349();
      class205.field3096.method3349();
      Client.field586.method3349();
      CollisionData.field1857.method3349();
      FileOnDisk.field1217.method3349();
      class171.field2367.method3349();
      WallObject.field1581.method3349();
      Friend.field162.method3349();
      Projectile.field877.method3349();
   }
}
