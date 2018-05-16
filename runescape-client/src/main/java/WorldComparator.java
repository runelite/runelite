import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("WorldComparator")
final class WorldComparator implements Comparator {
   @ObfuscatedName("oe")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   @Export("clanMemberManager")
   static ClanMemberManager clanMemberManager;
   @ObfuscatedName("k")
   static int[] field4;
   @ObfuscatedName("dh")
   @Export("host")
   static String host;
   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "[Llh;"
   )
   @Export("mapscene")
   static IndexedSprite[] mapscene;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lq;Lq;B)I",
      garbageValue = "1"
   )
   int method1(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.world < var2.world?-1:(var2.world == var1.world?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method1((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-2164"
   )
   public static boolean method0() {
      try {
         if(class217.field2486 == 2) {
            if(Ignore.field3644 == null) {
               Ignore.field3644 = Track1.getMusicFile(class26.field236, WorldMapDecoration.field167, class217.field2487);
               if(Ignore.field3644 == null) {
                  return false;
               }
            }

            if(class59.field557 == null) {
               class59.field557 = new class98(class217.field2490, class217.field2482);
            }

            if(class217.field2485.method4229(Ignore.field3644, class217.field2484, class59.field557, 22050)) {
               class217.field2485.method4230();
               class217.field2485.method4302(class21.field185);
               class217.field2485.method4327(Ignore.field3644, class178.field2317);
               class217.field2486 = 0;
               Ignore.field3644 = null;
               class59.field557 = null;
               class26.field236 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class217.field2485.method4236();
         class217.field2486 = 0;
         Ignore.field3644 = null;
         class59.field557 = null;
         class26.field236 = null;
      }

      return false;
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-924175041"
   )
   static void method9() {
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
                  Client.menuBooleanArray[var3] = Client.menuBooleanArray[var3 + 1];
               }
            }

            --var0;
            --Client.menuOptionCount;
         }
      }

      class24.method463(class139.field1897 / 2 + class35.menuX, class59.menuY);
   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "([Lhl;IS)V",
      garbageValue = "-27903"
   )
   static final void method2(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method2(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  class76.method1849(var4.id, var1);
               }
            }

            ScriptEvent var5;
            if(var1 == 0 && var3.onDialogAbortListener != null) {
               var5 = new ScriptEvent();
               var5.source = var3;
               var5.params = var3.onDialogAbortListener;
               FriendManager.method1728(var5);
            }

            if(var1 == 1 && var3.onSubChangeListener != null) {
               if(var3.index >= 0) {
                  Widget var6 = OwnWorldComparator.getWidget(var3.id);
                  if(var6 == null || var6.children == null || var3.index >= var6.children.length || var3 != var6.children[var3.index]) {
                     continue;
                  }
               }

               var5 = new ScriptEvent();
               var5.source = var3;
               var5.params = var3.onSubChangeListener;
               FriendManager.method1728(var5);
            }
         }
      }

   }
}
