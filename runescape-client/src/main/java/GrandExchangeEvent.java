import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
   @ObfuscatedName("ag")
   static int[] field282;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2070108189
   )
   @Export("world")
   public final int world;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 8120113880925916591L
   )
   public final long field274;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "La;"
   )
   @Export("grandExchangeOffer")
   public final GrandExchangeOffer grandExchangeOffer;
   @ObfuscatedName("r")
   @Export("string1")
   String string1;
   @ObfuscatedName("h")
   @Export("string2")
   String string2;

   @ObfuscatedSignature(
      signature = "(Lgv;BI)V"
   )
   GrandExchangeEvent(Buffer var1, byte var2, int var3) {
      this.string1 = var1.readString();
      this.string2 = var1.readString();
      this.world = var1.readUnsignedShort();
      this.field274 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.grandExchangeOffer = new GrandExchangeOffer();
      this.grandExchangeOffer.method101(2);
      this.grandExchangeOffer.method104(var2);
      this.grandExchangeOffer.price = var4;
      this.grandExchangeOffer.totalQuantity = var5;
      this.grandExchangeOffer.quantitySold = 0;
      this.grandExchangeOffer.spent = 0;
      this.grandExchangeOffer.itemId = var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1383475312"
   )
   public String method83() {
      return this.string1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1132957032"
   )
   public String method78() {
      return this.string2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgr;II)Z",
      garbageValue = "1321132501"
   )
   @Export("decodeRegionHash")
   static boolean decodeRegionHash(PacketBuffer var0, int var1) {
      int var2 = var0.getBits(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.getBits(1) != 0) {
            decodeRegionHash(var0, var1);
         }

         var3 = var0.getBits(13);
         var4 = var0.getBits(13);
         boolean var12 = var0.getBits(1) == 1;
         if(var12) {
            class94.field1413[++class94.field1403 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field842 = var1;
            if(class94.field1404[var1] != null) {
               var6.decodeApperance(class94.field1404[var1]);
            }

            var6.orientation = class94.Players_orientations[var1];
            var6.interacting = class94.Players_targetIndices[var1];
            var7 = class94.Players_regions[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.pathTraversed[0] = class94.field1401[var1];
            var6.field856 = (byte)var8;
            var6.method1154((var9 << 13) + var3 - class175.baseX, (var10 << 13) + var4 - GraphicsObject.baseY);
            var6.field858 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class94.Players_regions[var1];
         class94.Players_regions[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class94.Players_regions[var1];
            var7 = (var11 >> 28) + var4 & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class94.Players_regions[var1] = (var8 << 14) + var9 + (var7 << 28);
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class94.Players_regions[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var11 + var7 & 255;
            class94.Players_regions[var1] = (var9 << 14) + var10 + (var8 << 28);
            return false;
         }
      }
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "18"
   )
   static void method77() {
      ItemContainer.method1097(GrandExchangeOffer.localPlayer, false);
   }
}
