import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class33 {
   @ObfuscatedName("k")
   static int[] field451;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      longValue = -6566925207704575115L
   )
   static long field452;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 1511626629
   )
   static int field448;
   @ObfuscatedName("n")
   String field446;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 4017207
   )
   int field447;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -404324197
   )
   int field450;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   Size field449;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILk;)V"
   )
   class33(String var1, int var2, int var3, Size var4) {
      this.field446 = var1;
      this.field447 = var2;
      this.field450 = var3;
      this.field449 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lil;IB)Lkm;",
      garbageValue = "6"
   )
   public static IndexedSprite method346(IndexDataBase var0, int var1) {
      if(!ItemContainer.method1098(var0, var1)) {
         return null;
      } else {
         IndexedSprite var3 = new IndexedSprite();
         var3.width = class299.field3868;
         var3.originalHeight = class299.field3867;
         var3.offsetX = class299.field3870[0];
         var3.offsetY = class299.offsetsY[0];
         var3.originalWidth = class54.field635[0];
         var3.height = UrlRequester.field2099[0];
         var3.palette = class299.field3869;
         var3.pixels = class188.spritePixels[0];
         class139.method2922();
         return var3;
      }
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "642107592"
   )
   static void method344() {
      if(Client.field974 >= 0 && Client.cachedPlayers[Client.field974] != null) {
         ItemContainer.method1097(Client.cachedPlayers[Client.field974], false);
      }

   }

   @ObfuscatedName("kz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "-79"
   )
   @Export("isIgnored")
   static boolean isIgnored(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = WorldMapData.cleanUsername(var0, GrandExchangeOffer.jagexLoginType);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(WorldMapData.cleanUsername(var3.name, GrandExchangeOffer.jagexLoginType))) {
               return true;
            }

            if(var1.equalsIgnoreCase(WorldMapData.cleanUsername(var3.previousName, GrandExchangeOffer.jagexLoginType))) {
               return true;
            }
         }

         return false;
      }
   }
}
