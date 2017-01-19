import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("World")
public class World {
   @ObfuscatedName("u")
   static int[] field673 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("x")
   @Export("worldServersDownload")
   static class26 worldServersDownload;
   @ObfuscatedName("a")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("w")
   @Export("activity")
   String activity;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 334759783
   )
   static int field678 = 0;
   @ObfuscatedName("l")
   static int[] field679;
   @ObfuscatedName("b")
   static int[] field680 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1157298907
   )
   @Export("id")
   int id;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 203680079
   )
   static int field682 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 464378853
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -266896077
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("j")
   @Export("address")
   String address;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -243159205
   )
   @Export("location")
   int location;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 571252885
   )
   @Export("index")
   int index;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-38"
   )
   boolean method598() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-39"
   )
   boolean method599() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "76"
   )
   boolean method600() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2051118844"
   )
   boolean method609() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "929839569"
   )
   boolean method621() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-112046650"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         var1 = Client.field352.method2759();
         var2 = Client.field352.method2757();
         var3 = Client.field352.readUnsignedShort();
         class49.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class49.xteaKeys[var4][var5] = Client.field352.method2727();
            }
         }

         class143.mapRegions = new int[var3];
         class112.field1769 = new int[var3];
         RSCanvas.field1759 = new int[var3];
         class137.field1918 = new byte[var3][];
         FileOnDisk.field1194 = new byte[var3][];
         boolean var13 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var1 / 8 == 48) {
            var13 = true;
         }

         if(var2 / 8 == 48 && var1 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var2 - 6) / 8; var5 <= (var2 + 6) / 8; ++var5) {
            for(var6 = (var1 - 6) / 8; var6 <= (var1 + 6) / 8; ++var6) {
               var7 = (var5 << 8) + var6;
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class143.mapRegions[var3] = var7;
                  class112.field1769[var3] = class1.field16.method3197("m" + var5 + "_" + var6);
                  RSCanvas.field1759[var3] = class1.field16.method3197("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         MessageNode.method177(var2, var1);
      } else {
         var1 = Client.field352.readUnsignedShort();
         var2 = Client.field352.method2758();
         var3 = Client.field352.readUnsignedShort();
         Client.field352.method2982();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field352.method2973(1);
                  if(var7 == 1) {
                     Client.field548[var4][var5][var6] = Client.field352.method2973(26);
                  } else {
                     Client.field548[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.field352.method2967();
         class49.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class49.xteaKeys[var4][var5] = Client.field352.method2727();
            }
         }

         class143.mapRegions = new int[var3];
         class112.field1769 = new int[var3];
         RSCanvas.field1759 = new int[var3];
         class137.field1918 = new byte[var3][];
         FileOnDisk.field1194 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field548[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = (var8 / 8 << 8) + var9 / 8;

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(class143.mapRegions[var11] == var10) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class143.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class112.field1769[var3] = class1.field16.method3197("m" + var11 + "_" + var12);
                        RSCanvas.field1759[var3] = class1.field16.method3197("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         MessageNode.method177(var1, var2);
      }

   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-797528415"
   )
   static final void method633(int var0, int var1, int var2, int var3) {
      if(Client.field390 == 1) {
         class22.field250[Client.field401 / 100].method3971(Client.field540 - 8, Client.field486 - 8);
      }

      if(Client.field390 == 2) {
         class22.field250[Client.field401 / 100 + 4].method3971(Client.field540 - 8, Client.field486 - 8);
      }

      Client.field383 = 0;
      int var4 = class22.baseX + (XItemContainer.localPlayer.x >> 7);
      int var5 = (XItemContainer.localPlayer.y >> 7) + class103.baseY;
      if(var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
         Client.field383 = 1;
      }

      if(var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
         Client.field383 = 1;
      }

      if(Client.field383 == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
         Client.field383 = 0;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1425801464"
   )
   boolean method634() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(LSequence;IIII)V",
      garbageValue = "632105569"
   )
   static void method635(Sequence var0, int var1, int var2, int var3) {
      if(Client.field505 < 50 && Client.field551 != 0) {
         if(null != var0.field3064 && var1 < var0.field3064.length) {
            int var4 = var0.field3064[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field565[Client.field505] = var5;
               Client.field502[Client.field505] = var6;
               Client.field537[Client.field505] = 0;
               Client.field420[Client.field505] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field538[Client.field505] = var7 + (var8 << 16) + (var9 << 8);
               ++Client.field505;
            }
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1879691888"
   )
   public static boolean method636(int var0) {
      return (var0 & 1) != 0;
   }
}
