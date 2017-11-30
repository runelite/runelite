import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("itemContainers")
   static HashTable itemContainers;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[Lcp;"
   )
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   static JagexGame field721;
   @ObfuscatedName("w")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("e")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgh;Lgr;B)Lgr;",
      garbageValue = "-22"
   )
   @Export("readStringIntParameters")
   static final IterableHashTable readStringIntParameters(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = class173.nextPowerOfTwo(var2);
         var1 = new IterableHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new ObjectNode(var0.readString());
         } else {
            var6 = new IntegerNode(var0.readInt());
         }

         var1.put((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "485193461"
   )
   static final void method1031() {
      int var0 = UrlRequest.localPlayer.x;
      int var1 = UrlRequest.localPlayer.y;
      if(class72.field804 - var0 < -500 || class72.field804 - var0 > 500 || SceneTilePaint.field1932 - var1 < -500 || SceneTilePaint.field1932 - var1 > 500) {
         class72.field804 = var0;
         SceneTilePaint.field1932 = var1;
      }

      if(var0 != class72.field804) {
         class72.field804 += (var0 - class72.field804) / 16;
      }

      if(var1 != SceneTilePaint.field1932) {
         SceneTilePaint.field1932 += (var1 - SceneTilePaint.field1932) / 16;
      }

      int var2;
      int var3;
      if(MouseInput.mouseCurrentButton == 4 && class34.field455) {
         var2 = MouseInput.field682 * -469125321 - Client.field916;
         Client.field901 = var2 * 2;
         Client.field916 = var2 != -1 && var2 != 1?(Client.field916 + MouseInput.field682 * -469125321) / 2:MouseInput.field682 * -469125321;
         var3 = Client.field915 - MouseInput.field679;
         Client.field987 = var3 * 2;
         Client.field915 = var3 != -1 && var3 != 1?(Client.field915 + MouseInput.field679) / 2:MouseInput.field679;
      } else {
         if(KeyFocusListener.field593[96]) {
            Client.field987 += (-24 - Client.field987) / 2;
         } else if(KeyFocusListener.field593[97]) {
            Client.field987 += (24 - Client.field987) / 2;
         } else {
            Client.field987 /= 2;
         }

         if(KeyFocusListener.field593[98]) {
            Client.field901 += (12 - Client.field901) / 2;
         } else if(KeyFocusListener.field593[99]) {
            Client.field901 += (-12 - Client.field901) / 2;
         } else {
            Client.field901 /= 2;
         }

         Client.field916 = MouseInput.field682 * -469125321;
         Client.field915 = MouseInput.field679;
      }

      Client.mapAngle = Client.field987 / 2 + Client.mapAngle & 2047;
      Client.field998 += Client.field901 / 2;
      if(Client.field998 < 128) {
         Client.field998 = 128;
      }

      if(Client.field998 > 383) {
         Client.field998 = 383;
      }

      var2 = class72.field804 >> 7;
      var3 = SceneTilePaint.field1932 >> 7;
      int var4 = WorldMapType2.getTileHeight(class72.field804, SceneTilePaint.field1932, BoundingBox2D.plane);
      int var5 = 0;
      int var6;
      if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
         for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
            for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
               int var8 = BoundingBox2D.plane;
               if(var8 < 3 && (class61.tileSettings[1][var6][var7] & 2) == 2) {
                  ++var8;
               }

               int var9 = var4 - class61.tileHeights[var8][var6][var7];
               if(var9 > var5) {
                  var5 = var9;
               }
            }
         }
      }

      var6 = var5 * 192;
      if(var6 > 98048) {
         var6 = 98048;
      }

      if(var6 < 32768) {
         var6 = 32768;
      }

      if(var6 > Client.field920) {
         Client.field920 += (var6 - Client.field920) / 24;
      } else if(var6 < Client.field920) {
         Client.field920 += (var6 - Client.field920) / 80;
      }

   }
}
