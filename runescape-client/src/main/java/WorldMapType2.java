import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 1317786693
   )
   static int field523;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = 980576723
   )
   static int field522;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1485973535
   )
   int field520;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2059035963
   )
   int field524;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2131791553
   )
   int field517;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 899194385
   )
   int field521;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -482684731
   )
   int field518;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1346691421
   )
   int field516;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-39567884"
   )
   public boolean vmethod705(int var1, int var2) {
      return var1 >> 6 == this.field520 && var2 >> 6 == this.field521;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2062801574"
   )
   public boolean vmethod704(int var1, int var2, int var3) {
      return var1 >= this.field524 && var1 < this.field517 + this.field524?var2 >> 6 == this.field518 && var3 >> 6 == this.field516:false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lae;B)V",
      garbageValue = "-3"
   )
   public void vmethod703(WorldMapData var1) {
      if(var1.field457 > this.field520) {
         var1.field457 = this.field520;
      }

      if(var1.field460 < this.field520) {
         var1.field460 = this.field520;
      }

      if(var1.field453 > this.field521) {
         var1.field453 = this.field521;
      }

      if(var1.field462 < this.field521) {
         var1.field462 = this.field521;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Lhq;",
      garbageValue = "578346769"
   )
   public Coordinates vmethod728(int var1, int var2) {
      if(!this.vmethod705(var1, var2)) {
         return null;
      } else {
         int var3 = this.field518 * 64 - this.field520 * 64 + var1;
         int var4 = var2 + (this.field516 * 64 - this.field521 * 64);
         return new Coordinates(this.field524, var3, var4);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-670381390"
   )
   public int[] vmethod706(int var1, int var2, int var3) {
      if(!this.vmethod704(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field520 * 64 - this.field518 * 64 + var2, var3 + (this.field521 * 64 - this.field516 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-36"
   )
   void method509() {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfh;B)V",
      garbageValue = "0"
   )
   public void vmethod716(Buffer var1) {
      this.field524 = var1.readUnsignedByte();
      this.field517 = var1.readUnsignedByte();
      this.field518 = var1.readUnsignedShort();
      this.field516 = var1.readUnsignedShort();
      this.field520 = var1.readUnsignedShort();
      this.field521 = var1.readUnsignedShort();
      this.method509();
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lhg;B)Ljava/lang/String;",
      garbageValue = "100"
   )
   static String method527(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + Player.method1155(class14.method78(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var4 = "";
            if(class74.field877 != null) {
               var4 = IndexFile.method3049(class74.field877.field2212);
               if(class74.field877.value != null) {
                  var4 = (String)class74.field877.value;
               }
            }

            var0 = var0.substring(0, var2) + var4 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2033094920"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }
}
