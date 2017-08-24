import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("font_p12full")
   static Font font_p12full;
   @ObfuscatedName("g")
   static int[] field532;
   @ObfuscatedName("en")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   static class263 field539;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1672588379
   )
   int field535;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1837370507
   )
   int field540;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1197658253
   )
   int field531;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1904394135
   )
   int field536;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1879522541
   )
   int field533;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -778165479
   )
   int field534;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "59"
   )
   public boolean vmethod747(int var1, int var2) {
      return var1 >> 6 == this.field540 && var2 >> 6 == this.field536;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "1746025354"
   )
   public boolean vmethod746(int var1, int var2, int var3) {
      return var1 >= this.field535 && var1 < this.field531 + this.field535?var2 >> 6 == this.field533 && var3 >> 6 == this.field534:false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lam;I)V",
      garbageValue = "2013920575"
   )
   public void vmethod745(WorldMapData var1) {
      if(var1.field462 > this.field540) {
         var1.field462 = this.field540;
      }

      if(var1.field468 < this.field540) {
         var1.field468 = this.field540;
      }

      if(var1.field456 > this.field536) {
         var1.field456 = this.field536;
      }

      if(var1.field465 < this.field536) {
         var1.field465 = this.field536;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Lhs;",
      garbageValue = "1278074658"
   )
   public Coordinates vmethod771(int var1, int var2) {
      if(!this.vmethod747(var1, var2)) {
         return null;
      } else {
         int var3 = this.field533 * 64 - this.field540 * 64 + var1;
         int var4 = this.field534 * 64 - this.field536 * 64 + var2;
         return new Coordinates(this.field535, var3, var4);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1584803853"
   )
   public int[] vmethod757(int var1, int var2, int var3) {
      if(!this.vmethod746(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field540 * 64 - this.field533 * 64 + var2, var3 + (this.field536 * 64 - this.field534 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "51"
   )
   void method535() {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-1644047401"
   )
   public void vmethod751(Buffer var1) {
      this.field535 = var1.readUnsignedByte();
      this.field531 = var1.readUnsignedByte();
      this.field533 = var1.readUnsignedShort();
      this.field534 = var1.readUnsignedShort();
      this.field540 = var1.readUnsignedShort();
      this.field536 = var1.readUnsignedShort();
      this.method535();
   }

   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1755752356"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class87.clientInstance.method918();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field975 = 0;
            Client.field1175 = 0;
            if(var0 != 20) {
               class81.method1615(false);
            }
         }

         if(var0 != 20 && var0 != 40 && class206.field2565 != null) {
            class206.field2565.close();
            class206.field2565 = null;
         }

         if(Client.gameState == 25) {
            Client.field1002 = 0;
            Client.field998 = 0;
            Client.field999 = 1;
            Client.field1033 = 0;
            Client.field1128 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class91.method1757(InvType.field3283, GrandExchangeOffer.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class91.method1757(InvType.field3283, GrandExchangeOffer.indexSprites, false, 4);
            } else if(class91.field1443) {
               class91.field1464 = null;
               class17.field317 = null;
               class91.field1437 = null;
               class19.field336 = null;
               class88.field1405 = null;
               class43.logoSprite = null;
               class91.titlemuteSprite = null;
               class262.field3624 = null;
               TextureProvider.field1790 = null;
               class41.field572 = null;
               Script.field1549 = null;
               class25.field383 = null;
               class73.field895 = null;
               WorldMapType1.field446 = null;
               NPC.field1379 = null;
               class223.field2846 = null;
               field532 = null;
               class81.field1340 = null;
               class81.field1341 = null;
               class19.field335 = null;
               Coordinates.field2615 = null;
               class5.field37 = null;
               class170.method3216(2);
               class18.sendConInfo(true);
               class91.field1443 = false;
            }
         } else {
            class91.method1757(InvType.field3283, GrandExchangeOffer.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(Lhx;I)Z",
      garbageValue = "-1553862478"
   )
   static boolean method548(Widget var0) {
      if(Client.field1101) {
         if(Coordinates.getWidgetConfig(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }
}
