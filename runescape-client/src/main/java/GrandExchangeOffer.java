import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;
   @ObfuscatedName("b")
   @Export("progress")
   byte progress;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1660235255
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2122070301
   )
   @Export("price")
   public int price;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1447864947
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 209646151
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1046179393
   )
   @Export("spent")
   public int spent;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lgn;Z)V",
      garbageValue = "0"
   )
   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "791466396"
   )
   @Export("status")
   public int status() {
      return this.progress & 7;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1546326135"
   )
   @Export("type")
   public int type() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-908897606"
   )
   void method105(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1985438027"
   )
   void method106(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1397319442"
   )
   static int method120() {
      return ++class94.field1400 - 1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lie;I)V",
      garbageValue = "-987335018"
   )
   public static void method110(IndexDataBase var0) {
      class264.field3415 = var0;
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1201509173"
   )
   static final void method112(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != class230.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = GameObject.region.method2941(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = GameObject.region.method2910(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = GameObject.region.method2911(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = GameObject.region.method2912(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = GameObject.region.getObjectFlags(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               GameObject.region.removeBoundaryObject(var0, var2, var3);
               var12 = Preferences.getObjectDefinition(var13);
               if(var12.clipType != 0) {
                  Client.collisionMaps[var0].removeWall(var2, var3, var14, var15, var12.blocksProjectile);
               }
            }

            if(var1 == 1) {
               GameObject.region.removeWallDecoration(var0, var2, var3);
            }

            if(var1 == 2) {
               GameObject.region.method2902(var0, var2, var3);
               var12 = Preferences.getObjectDefinition(var13);
               if(var2 + var12.width > 103 || var3 + var12.width > 103 || var2 + var12.length > 103 || var3 + var12.length > 103) {
                  return;
               }

               if(var12.clipType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var12.width, var12.length, var15, var12.blocksProjectile);
               }
            }

            if(var1 == 3) {
               GameObject.region.removeFloorDecoration(var0, var2, var3);
               var12 = Preferences.getObjectDefinition(var13);
               if(var12.clipType == 1) {
                  Client.collisionMaps[var0].method3389(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class61.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Nameable.method5187(var0, var11, var2, var3, var4, var5, var6, GameObject.region, Client.collisionMaps[var0]);
         }
      }

   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "([Lim;Lim;ZI)V",
      garbageValue = "1046256389"
   )
   static void method119(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class92.method1939(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class92.method1939(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(class2.loadWidget(var6)) {
            class92.method1939(Widget.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
