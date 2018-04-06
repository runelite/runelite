import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
final class class18 implements Comparator {
   @ObfuscatedName("e")
   @Export("tt")
   static int[] tt;
   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "[Lll;"
   )
   @Export("scrollbarSprites")
   static IndexedSprite[] scrollbarSprites;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ll;Ll;I)I",
      garbageValue = "-1368132884"
   )
   int method140(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.method81().compareTo(var2.method81());
   }

   public int compare(Object var1, Object var2) {
      return this.method140((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BS)[B",
      garbageValue = "23957"
   )
   static byte[] method146(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1637460256"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[BoundingBox3DDrawMode.plane][var0][var1];
      if(var2 == null) {
         class255.region.removeGroundItemPile(BoundingBox3DDrawMode.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = class47.getItemDefinition(var6.id);
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
            class255.region.removeGroundItemPile(BoundingBox3DDrawMode.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var5.id != var6.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class255.region.addItemPile(BoundingBox3DDrawMode.plane, var0, var1, class265.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, BoundingBox3DDrawMode.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1514362645"
   )
   static final void method142(int var0) {
      class250.method4503();

      for(class80 var1 = (class80)class80.field1263.getFront(); var1 != null; var1 = (class80)class80.field1263.getNext()) {
         if(var1.field1272 != null) {
            var1.method1794();
         }
      }

      int var4 = class150.method3119(var0).configType;
      if(var4 != 0) {
         int var2 = class237.clientVarps[var0];
         if(var4 == 1) {
            if(var2 == 1) {
               Graphics3D.setBrightness(0.9D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.9D);
            }

            if(var2 == 2) {
               Graphics3D.setBrightness(0.8D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.8D);
            }

            if(var2 == 3) {
               Graphics3D.setBrightness(0.7D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.7D);
            }

            if(var2 == 4) {
               Graphics3D.setBrightness(0.6D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var4 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != Client.field996) {
               if(Client.field996 == 0 && Client.field1026 != -1) {
                  PacketNode.method3442(PacketBuffer.indexTrack1, Client.field1026, 0, var3, false);
                  Client.field1102 = false;
               } else if(var3 == 0) {
                  class155.method3165();
                  Client.field1102 = false;
               } else {
                  class319.method5650(var3);
               }

               Client.field996 = var3;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               Client.field1075 = 127;
            }

            if(var2 == 1) {
               Client.field1075 = 96;
            }

            if(var2 == 2) {
               Client.field1075 = 64;
            }

            if(var2 == 3) {
               Client.field1075 = 32;
            }

            if(var2 == 4) {
               Client.field1075 = 0;
            }
         }

         if(var4 == 5) {
            Client.field1004 = var2;
         }

         if(var4 == 6) {
            Client.field1031 = var2;
         }

         if(var4 == 9) {
            Client.field1096 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               Client.field951 = 127;
            }

            if(var2 == 1) {
               Client.field951 = 96;
            }

            if(var2 == 2) {
               Client.field951 = 64;
            }

            if(var2 == 3) {
               Client.field951 = 32;
            }

            if(var2 == 4) {
               Client.field951 = 0;
            }
         }

         if(var4 == 17) {
            Client.field1048 = var2 & 65535;
         }

         if(var4 == 18) {
            Client.playerAttackOption = (AttackOption)Permission.forOrdinal(class45.method667(), var2);
            if(Client.playerAttackOption == null) {
               Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               Client.field1112 = -1;
            } else {
               Client.field1112 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            Client.npcAttackOption = (AttackOption)Permission.forOrdinal(class45.method667(), var2);
            if(Client.npcAttackOption == null) {
               Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

      }
   }
}
