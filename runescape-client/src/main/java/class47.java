import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class47 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   public static IndexDataBase field592;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 255578759
   )
   public int field590;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   public Coordinates field589;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   public Coordinates field593;

   @ObfuscatedSignature(
      signature = "(ILhd;Lhd;)V"
   )
   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field590 = var1;
      this.field589 = var2;
      this.field593 = var3;
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1909314997"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class45.plane][var0][var1];
      if(var2 == null) {
         class29.region.method2687(class45.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = class83.getItemDefinition(var6.id);
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
            class29.region.method2687(class45.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var6.id != var5.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class29.region.addItemPile(class45.plane, var0, var1, Actor.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class45.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "744635069"
   )
   static int method718(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         WorldMapType2.intStackSize -= 3;
         var3 = class83.intStack[WorldMapType2.intStackSize];
         var4 = class83.intStack[WorldMapType2.intStackSize + 1];
         int var5 = class83.intStack[WorldMapType2.intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = class61.method1038(var3);
            if(var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.index = var5;
               var12.hasScript = true;
               var6.children[var5] = var12;
               if(var2) {
                  class83.field1336 = var12;
               } else {
                  class1.field9 = var12;
               }

               class48.method749(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?class83.field1336:class1.field9;
            Widget var10 = class61.method1038(var9.id);
            var10.children[var9.index] = null;
            class48.method749(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = class61.method1038(class83.intStack[--WorldMapType2.intStackSize]);
            var9.children = null;
            class48.method749(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = class61.method1038(class83.intStack[--WorldMapType2.intStackSize]);
               if(var9 != null) {
                  class83.intStack[++WorldMapType2.intStackSize - 1] = 1;
                  if(var2) {
                     class83.field1336 = var9;
                  } else {
                     class1.field9 = var9;
                  }
               } else {
                  class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            WorldMapType2.intStackSize -= 2;
            var3 = class83.intStack[WorldMapType2.intStackSize];
            var4 = class83.intStack[WorldMapType2.intStackSize + 1];
            Widget var11 = class12.method70(var3, var4);
            if(var11 != null && var4 != -1) {
               class83.intStack[++WorldMapType2.intStackSize - 1] = 1;
               if(var2) {
                  class83.field1336 = var11;
               } else {
                  class1.field9 = var11;
               }
            } else {
               class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "1959893192"
   )
   static int method715(int var0, Script var1, boolean var2) {
      if(var0 == 5306) {
         int[] var3 = class83.intStack;
         int var4 = ++WorldMapType2.intStackSize - 1;
         int var5 = Client.isResized?2:1;
         var3[var4] = var5;
         return 1;
      } else {
         int var6;
         if(var0 == 5307) {
            var6 = class83.intStack[--WorldMapType2.intStackSize];
            if(var6 == 1 || var6 == 2) {
               class1.method1(var6);
            }

            return 1;
         } else if(var0 == 5308) {
            class83.intStack[++WorldMapType2.intStackSize - 1] = class23.preferences.screenType;
            return 1;
         } else if(var0 != 5309) {
            return 2;
         } else {
            var6 = class83.intStack[--WorldMapType2.intStackSize];
            if(var6 == 1 || var6 == 2) {
               class23.preferences.screenType = var6;
               PendingSpawn.method1475();
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(Lca;II)V",
      garbageValue = "1366239204"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      class48.method750(var0.x, var0.y, var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZZI)I",
      garbageValue = "-859377721"
   )
   public static int method717(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = class238.field3257 + class238.field3272 + var2;
      return var3;
   }
}
