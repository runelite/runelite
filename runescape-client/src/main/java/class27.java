import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public enum class27 implements RSEnum {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   field390(3, (byte)0),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   field377(1, (byte)1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   field378(2, (byte)2),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   field379(0, (byte)3);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field386;
   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   static IndexData field382;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -446137621
   )
   final int field388;
   @ObfuscatedName("x")
   final byte field381;

   class27(int var3, byte var4) {
      this.field388 = var3;
      this.field381 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "369425307"
   )
   public int rsOrdinal() {
      return this.field381;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Liy;II)V",
      garbageValue = "1014514753"
   )
   static void method242(IndexData var0, int var1) {
      if(class56.field640 != null) {
         class56.field640.offset = var1 * 8 + 5;
         int var2 = class56.field640.readInt();
         int var3 = class56.field640.readInt();
         var0.setInformation(var2, var3);
      } else {
         ClanMember.method1227((IndexData)null, 255, 255, 0, (byte)0, true);
         class245.field3328[var1] = var0;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILcw;ZI)I",
      garbageValue = "675137499"
   )
   static int method241(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         class56.intStackSize -= 3;
         var3 = class82.intStack[class56.intStackSize];
         var4 = class82.intStack[class56.intStackSize + 1];
         int var5 = class82.intStack[class56.intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = PendingSpawn.method1612(var3);
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
                  class285.field3789 = var12;
               } else {
                  Friend.field768 = var12;
               }

               WorldMapData.method394(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?class285.field3789:Friend.field768;
            Widget var10 = PendingSpawn.method1612(var9.id);
            var10.children[var9.index] = null;
            WorldMapData.method394(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = PendingSpawn.method1612(class82.intStack[--class56.intStackSize]);
            var9.children = null;
            WorldMapData.method394(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = PendingSpawn.method1612(class82.intStack[--class56.intStackSize]);
               if(var9 != null) {
                  class82.intStack[++class56.intStackSize - 1] = 1;
                  if(var2) {
                     class285.field3789 = var9;
                  } else {
                     Friend.field768 = var9;
                  }
               } else {
                  class82.intStack[++class56.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class56.intStackSize -= 2;
            var3 = class82.intStack[class56.intStackSize];
            var4 = class82.intStack[class56.intStackSize + 1];
            Widget var11 = class189.method3613(var3, var4);
            if(var11 != null && var4 != -1) {
               class82.intStack[++class56.intStackSize - 1] = 1;
               if(var2) {
                  class285.field3789 = var11;
               } else {
                  Friend.field768 = var11;
               }
            } else {
               class82.intStack[++class56.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "679012037"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[Ignore.plane][var0][var1];
      if(var2 == null) {
         class56.region.method2908(Ignore.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = class250.getItemDefinition(var6.id);
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
            class56.region.method2908(Ignore.plane, var0, var1);
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
            class56.region.addItemPile(Ignore.plane, var0, var1, class70.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, Ignore.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;I)V",
      garbageValue = "-1279122464"
   )
   static void method234(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = class189.method3613(var1, var2);
      if(var5 != null) {
         if(var5.field2826 != null) {
            ScriptEvent var6 = new ScriptEvent();
            var6.widget = var5;
            var6.field789 = var0;
            var6.field793 = var4;
            var6.field791 = var5.field2826;
            class111.method2177(var6);
         }

         boolean var8 = true;
         if(var5.contentType > 0) {
            var8 = Ignore.method1167(var5);
         }

         if(var8) {
            if(class115.method2210(Preferences.getWidgetConfig(var5), var0 - 1)) {
               class170 var7;
               if(var0 == 1) {
                  var7 = Actor.method1628(class167.field2319, Client.field952.field1478);
                  var7.field2423.putInt(var1);
                  var7.field2423.putShort(var2);
                  var7.field2423.putShort(var3);
                  Client.field952.method1951(var7);
               }

               if(var0 == 2) {
                  var7 = Actor.method1628(class167.field2372, Client.field952.field1478);
                  var7.field2423.putInt(var1);
                  var7.field2423.putShort(var2);
                  var7.field2423.putShort(var3);
                  Client.field952.method1951(var7);
               }

               if(var0 == 3) {
                  var7 = Actor.method1628(class167.field2392, Client.field952.field1478);
                  var7.field2423.putInt(var1);
                  var7.field2423.putShort(var2);
                  var7.field2423.putShort(var3);
                  Client.field952.method1951(var7);
               }

               if(var0 == 4) {
                  var7 = Actor.method1628(class167.field2322, Client.field952.field1478);
                  var7.field2423.putInt(var1);
                  var7.field2423.putShort(var2);
                  var7.field2423.putShort(var3);
                  Client.field952.method1951(var7);
               }

               if(var0 == 5) {
                  var7 = Actor.method1628(class167.field2323, Client.field952.field1478);
                  var7.field2423.putInt(var1);
                  var7.field2423.putShort(var2);
                  var7.field2423.putShort(var3);
                  Client.field952.method1951(var7);
               }

               if(var0 == 6) {
                  var7 = Actor.method1628(class167.field2324, Client.field952.field1478);
                  var7.field2423.putInt(var1);
                  var7.field2423.putShort(var2);
                  var7.field2423.putShort(var3);
                  Client.field952.method1951(var7);
               }

               if(var0 == 7) {
                  var7 = Actor.method1628(class167.field2398, Client.field952.field1478);
                  var7.field2423.putInt(var1);
                  var7.field2423.putShort(var2);
                  var7.field2423.putShort(var3);
                  Client.field952.method1951(var7);
               }

               if(var0 == 8) {
                  var7 = Actor.method1628(class167.field2326, Client.field952.field1478);
                  var7.field2423.putInt(var1);
                  var7.field2423.putShort(var2);
                  var7.field2423.putShort(var3);
                  Client.field952.method1951(var7);
               }

               if(var0 == 9) {
                  var7 = Actor.method1628(class167.field2327, Client.field952.field1478);
                  var7.field2423.putInt(var1);
                  var7.field2423.putShort(var2);
                  var7.field2423.putShort(var3);
                  Client.field952.method1951(var7);
               }

               if(var0 == 10) {
                  var7 = Actor.method1628(class167.field2351, Client.field952.field1478);
                  var7.field2423.putInt(var1);
                  var7.field2423.putShort(var2);
                  var7.field2423.putShort(var3);
                  Client.field952.method1951(var7);
               }

            }
         }
      }
   }
}
