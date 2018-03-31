import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("WorldComparator")
final class WorldComparator implements Comparator {
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = -1023693073
   )
   static int field261;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -285390263
   )
   @Export("indexedSpriteCount")
   static int indexedSpriteCount;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ldl;"
   )
   public static class110 field260;
   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "[Lla;"
   )
   @Export("crossSprites")
   static SpritePixels[] crossSprites;
   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "Lbx;"
   )
   @Export("localPlayer")
   static Player localPlayer;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ll;Ll;I)I",
      garbageValue = "-645015399"
   )
   int method80(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.world < var2.world?-1:(var2.world == var1.world?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method80((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Ljq;",
      garbageValue = "417172781"
   )
   public static VarCInt method81(int var0) {
      VarCInt var1 = (VarCInt)VarCInt.field3474.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarCInt.field3473.getConfigData(19, var0);
         var1 = new VarCInt();
         if(var2 != null) {
            var1.method4774(new Buffer(var2));
         }

         VarCInt.field3474.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-98314917"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class237.plane][var0][var1];
      if(var2 == null) {
         class308.region.removeGroundItemPile(class237.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = GameObject.getItemDefinition(var6.id);
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
            class308.region.removeGroundItemPile(class237.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var5.id != var6.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class308.region.addItemPile(class237.plane, var0, var1, class5.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class237.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("kb")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1778532542"
   )
   static void method75(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class20.field319; ++var4) {
         ItemComposition var5 = GameObject.getItemDefinition(var4);
         if((!var1 || var5.isTradable) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               GroundObject.field1789 = -1;
               class23.field340 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class23.field340 = var2;
      Preferences.field1243 = 0;
      GroundObject.field1789 = var3;
      String[] var8 = new String[GroundObject.field1789];

      for(int var9 = 0; var9 < GroundObject.field1789; ++var9) {
         var8[var9] = GameObject.getItemDefinition(var2[var9]).name;
      }

      class173.method3341(var8, class23.field340);
   }
}
