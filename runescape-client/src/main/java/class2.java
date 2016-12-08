import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public class class2 {
   @ObfuscatedName("h")
   String field15;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -2751133652962353487L
   )
   public final long field16;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 74447235
   )
   public final int field17;
   @ObfuscatedName("g")
   String field18;
   @ObfuscatedName("b")
   public final XGrandExchangeOffer field19;
   @ObfuscatedName("a")
   static int[] field21;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-643120053"
   )
   public String method17() {
      return this.field15;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;III)Lclass208;",
      garbageValue = "1750151619"
   )
   public static class208 method18(class182 var0, class182 var1, int var2, int var3) {
      if(!Friend.method170(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.method3203(var2, var3);
         class208 var4;
         if(var5 == null) {
            var4 = null;
         } else {
            class208 var6 = new class208(var5, class211.field3125, class225.field3217, FaceNormal.field1557, FileOnDisk.field1199, class225.field3215, XGrandExchangeOffer.field36);
            class176.method3182();
            var4 = var6;
         }

         return var4;
      }
   }

   class2(Buffer var1, byte var2, int var3) {
      this.field18 = var1.method2780();
      this.field15 = var1.method2780();
      this.field17 = var1.readUnsignedShort();
      this.field16 = var1.method2732();
      int var4 = var1.method2731();
      int var5 = var1.method2731();
      this.field19 = new XGrandExchangeOffer();
      this.field19.method55(2);
      this.field19.method46(var2);
      this.field19.price = var4;
      this.field19.totalQuantity = var5;
      this.field19.quantitySold = 0;
      this.field19.spent = 0;
      this.field19.itemId = var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "311774160"
   )
   public String method24() {
      return this.field18;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2057138022"
   )
   public static boolean method25(int var0) {
      if(class88.validInterfaces[var0]) {
         return true;
      } else if(!Ignore.field216.method3206(var0)) {
         return false;
      } else {
         int var1 = Ignore.field216.method3245(var0);
         if(var1 == 0) {
            class88.validInterfaces[var0] = true;
            return true;
         } else {
            if(null == Widget.widgets[var0]) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = Ignore.field216.method3203(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = (var0 << 16) + var2;
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method3107(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method3106(new Buffer(var3));
                     }
                  }
               }
            }

            class88.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static void method26() {
      Client.field330.offset = 0;
      Client.field332.offset = 0;
      Client.packetOpcode = -1;
      Client.field337 = -1;
      Client.field410 = -1;
      Client.field339 = -1;
      Client.field523 = 0;
      Client.field335 = 0;
      Client.field305 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field520 = 0;
      Client.flagX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      class5.localPlayer = null;

      for(var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
         NPC var1 = Client.cachedNPCs[var0];
         if(null != var1) {
            var1.interacting = -1;
            var1.field631 = false;
         }
      }

      class45.method802();
      class20.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field308[var0] = true;
      }

      Client.field330.method2967(92);
      Client.field330.method2815(class47.method871());
      Client.field330.method2712(TextureProvider.field1200);
      Client.field330.method2712(class94.field1584);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "67685147"
   )
   public static int method27(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-986834196"
   )
   static void method29(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class225.field3218 = var1.readUnsignedShort();
      class211.field3125 = new int[class225.field3218];
      class225.field3217 = new int[class225.field3218];
      FaceNormal.field1557 = new int[class225.field3218];
      FileOnDisk.field1199 = new int[class225.field3218];
      XGrandExchangeOffer.field36 = new byte[class225.field3218][];
      var1.offset = var0.length - 7 - class225.field3218 * 8;
      class204.field3077 = var1.readUnsignedShort();
      class225.field3216 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class225.field3218; ++var3) {
         class211.field3125[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3218; ++var3) {
         class225.field3217[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3218; ++var3) {
         FaceNormal.field1557[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3218; ++var3) {
         FileOnDisk.field1199[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class225.field3218 * 8 - (var2 - 1) * 3;
      class225.field3215 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class225.field3215[var3] = var1.read24BitInt();
         if(class225.field3215[var3] == 0) {
            class225.field3215[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class225.field3218; ++var3) {
         int var4 = FaceNormal.field1557[var3];
         int var5 = FileOnDisk.field1199[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         XGrandExchangeOffer.field36[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var10 * var4 + var9] = var1.readByte();
               }
            }
         }
      }

   }
}
