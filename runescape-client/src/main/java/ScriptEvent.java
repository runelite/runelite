import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "[Lks;"
   )
   @Export("mapscene")
   static IndexedSprite[] mapscene;
   @ObfuscatedName("b")
   Object[] field785;
   @ObfuscatedName("s")
   boolean field776;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 57216937
   )
   int field778;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 308434281
   )
   int field775;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2114628987
   )
   int field783;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   Widget field781;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -194344963
   )
   int field782;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -827700595
   )
   int field780;
   @ObfuscatedName("n")
   String field784;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1011112015
   )
   int field779;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   class226 field786;

   public ScriptEvent() {
      this.field786 = class226.field2861;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;I)V",
      garbageValue = "-479584732"
   )
   public void method1032(Object[] var1) {
      this.field785 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lhf;I)V",
      garbageValue = "975527755"
   )
   public void method1033(class226 var1) {
      this.field786 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1234788646"
   )
   static final void method1035(int var0) {
      class133.field1902[++class133.field1907 - 1] = var0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZZI)Lks;",
      garbageValue = "-1073304201"
   )
   static IndexedSprite method1042(boolean var0, boolean var1) {
      return var0?(var1?ChatLineBuffer.field1453:RSCanvas.field617):(var1?Permission.field3241:class91.field1351);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "-1531990348"
   )
   static int method1039(int var0, Script var1, boolean var2) {
      if(var0 == 5306) {
         class82.intStack[++class82.intStackSize - 1] = PendingSpawn.method1494();
         return 1;
      } else {
         int var3;
         if(var0 == 5307) {
            var3 = class82.intStack[--class82.intStackSize];
            if(var3 == 1 || var3 == 2) {
               World.method1532(var3);
            }

            return 1;
         } else if(var0 == 5308) {
            class82.intStack[++class82.intStackSize - 1] = class70.preferences.screenType;
            return 1;
         } else if(var0 != 5309) {
            return 2;
         } else {
            var3 = class82.intStack[--class82.intStackSize];
            if(var3 == 1 || var3 == 2) {
               class70.preferences.screenType = var3;
               GameEngine.method925();
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   static final void method1036() {
      if(Client.field906 > 0) {
         class12.method64();
      } else {
         Client.field976.method4925();
         class2.setGameState(40);
         ClanMember.field857 = Client.field905.method1873();
         Client.field905.method1858();
      }
   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "935648144"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class28.plane][var0][var1];
      if(var2 == null) {
         Client.region.method2709(class28.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = class139.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            Client.region.method2709(class28.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var6.id != var5.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            Client.region.addItemPile(class28.plane, var0, var1, class18.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class28.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(Lhx;I)Z",
      garbageValue = "-1285019091"
   )
   static final boolean method1041(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = class139.method2860(var0, var1);
            int var3 = var0.field2819[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(Lhx;I)V",
      garbageValue = "-1390720190"
   )
   static void method1038(Widget var0) {
      if(var0.loopCycle == Client.field866) {
         Client.field1052[var0.boundsIndex] = true;
      }

   }
}
