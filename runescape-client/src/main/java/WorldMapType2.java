import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 567282533
   )
   int field529;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1456868853
   )
   int field530;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1377362851
   )
   int field531;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 599581849
   )
   int field532;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 379531369
   )
   int field534;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 545201039
   )
   int field536;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;I)V",
      garbageValue = "-466828627"
   )
   public void vmethod680(WorldMapData var1) {
      if(var1.field459 > this.field529) {
         var1.field459 = this.field529;
      }

      if(var1.field465 < this.field529) {
         var1.field465 = this.field529;
      }

      if(var1.field466 > this.field532) {
         var1.field466 = this.field532;
      }

      if(var1.field458 < this.field532) {
         var1.field458 = this.field532;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "108"
   )
   public boolean vmethod679(int var1, int var2) {
      return var1 >> 6 == this.field529 && this.field532 == var2 >> 6;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "630255391"
   )
   public int[] vmethod682(int var1, int var2, int var3) {
      if(!this.vmethod678(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{var2 + (this.field529 * 64 - this.field536 * 64), this.field532 * 64 - this.field530 * 64 + var3};
         return var4;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-612549021"
   )
   public static boolean method497(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1739504092"
   )
   void method498() {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-2095092414"
   )
   public boolean vmethod678(int var1, int var2, int var3) {
      return var1 >= this.field531 && var1 < this.field531 + this.field534?var2 >> 6 == this.field536 && this.field530 == var3 >> 6:false;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1315256502"
   )
   public void vmethod684(Buffer var1) {
      this.field531 = var1.readUnsignedByte();
      this.field534 = var1.readUnsignedByte();
      this.field536 = var1.readUnsignedShort();
      this.field530 = var1.readUnsignedShort();
      this.field529 = var1.readUnsignedShort();
      this.field532 = var1.readUnsignedShort();
      this.method498();
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1946732194"
   )
   static void method508(int var0) {
      Client.field1119 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      if(class241.method4167() == 1) {
         class220.field2817.method795(765, 503);
      } else {
         class220.field2817.method795(7680, 2160);
      }

      if(Client.gameState >= 25) {
         class66.method1024();
      }

   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-320881442"
   )
   static boolean method510(Widget var0) {
      if(Client.field1076) {
         if(class15.method92(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "-1537373407"
   )
   public Coordinates vmethod685(int var1, int var2) {
      if(!this.vmethod679(var1, var2)) {
         return null;
      } else {
         int var3 = this.field536 * 64 - this.field529 * 64 + var1;
         int var4 = this.field530 * 64 - this.field532 * 64 + var2;
         return new Coordinates(this.field531, var3, var4);
      }
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1634563983"
   )
   static void method512(int var0) {
      for(class198 var1 = (class198)Client.widgetFlags.method3435(); var1 != null; var1 = (class198)Client.widgetFlags.method3429()) {
         if((long)var0 == (var1.hash >> 48 & 65535L)) {
            var1.unlink();
         }
      }

   }
}
