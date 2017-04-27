import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public final class class85 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1568294149
   )
   int field1442;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2041030787
   )
   int field1443;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1887326795
   )
   int field1444;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -135738669
   )
   int field1446;
   @ObfuscatedName("p")
   boolean field1447 = true;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1600556051
   )
   int field1448;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1380594629
   )
   int field1449;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = -1364494207
   )
   @Export("clanChatCount")
   static int clanChatCount;

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-40"
   )
   static void method1713() {
      if(Client.field440) {
         Widget var0 = class0.method13(XClanMember.field269, Client.field441);
         if(var0 != null && var0.field2334 != null) {
            class18 var1 = new class18();
            var1.field189 = var0;
            var1.field196 = var0.field2334;
            Script.method910(var1, 200000);
         }

         Client.field440 = false;
         class124.method2350(var0);
      }
   }

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class85(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1448 = var1;
      this.field1443 = var2;
      this.field1446 = var3;
      this.field1442 = var4;
      this.field1449 = var5;
      this.field1444 = var6;
      this.field1447 = var7;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Lclass180;",
      garbageValue = "-1819208623"
   )
   public static class180 method1714(int var0) {
      class180[] var1 = class122.method2312();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class180 var3 = var1[var2];
         if(var3.field2675 == var0) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "([LWidget;IS)V",
      garbageValue = "15925"
   )
   static final void method1715(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !ChatMessages.method857(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript && ChatMessages.method857(var3) && ChatMessages.field920 != var3) {
                  continue;
               }

               method1715(var0, var3.id);
               if(var3.children != null) {
                  method1715(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2773((long)var3.id);
               if(var4 != null) {
                  var5 = var4.id;
                  if(class112.method2112(var5)) {
                     method1715(class133.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2254 != -1 || var3.field2255 != -1) {
                  boolean var7 = class175.method3264(var3);
                  if(var7) {
                     var5 = var3.field2255;
                  } else {
                     var5 = var3.field2254;
                  }

                  if(var5 != -1) {
                     Sequence var6 = NPCComposition.getAnimation(var5);

                     for(var3.field2214 += Client.field358; var3.field2214 > var6.frameLenghts[var3.field2329]; class124.method2350(var3)) {
                        var3.field2214 -= var6.frameLenghts[var3.field2329];
                        ++var3.field2329;
                        if(var3.field2329 >= var6.frameIDs.length) {
                           var3.field2329 -= var6.frameStep;
                           if(var3.field2329 < 0 || var3.field2329 >= var6.frameIDs.length) {
                              var3.field2329 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2260 != 0 && !var3.hasScript) {
                  int var8 = var3.field2260 >> 16;
                  var5 = var3.field2260 << 16 >> 16;
                  var8 *= Client.field358;
                  var5 *= Client.field358;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var3.rotationZ + var5 & 2047;
                  class124.method2350(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-947820815"
   )
   static void method1716(int var0, int var1) {
      class38 var2 = Client.field487;
      class99.menuAction(var2.field788, var2.field786, var2.field785, var2.field787, var2.field784, var2.field784, var0, var1);
      Client.field487 = null;
   }
}
