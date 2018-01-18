import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
final class class5 implements class0 {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "263163621"
   )
   public static final void method13() {
      while(true) {
         BoundingBox var0 = (BoundingBox)class7.boundingBoxes.removeLast();
         if(var0 == null) {
            return;
         }

         var0.draw();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "-1902253482"
   )
   static void method14(int var0, boolean var1, int var2, boolean var3) {
      if(World.worldList != null) {
         BaseVarType.method8(0, World.worldList.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lil;Ljava/lang/String;Ljava/lang/String;I)[Lkg;",
      garbageValue = "1101878301"
   )
   @Export("getSprites")
   public static SpritePixels[] getSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return IndexDataBase.method4397(var0, var3, var4);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "-1115972280"
   )
   static int method11(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = UrlRequester.getWidget(class82.intStack[--class82.intStackSize]);
      } else {
         var3 = var2?class82.field1267:CombatInfo1.field1216;
      }

      String var4 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
         int var6 = class82.intStack[--class82.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class82.intStack[--class82.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 's') {
            var8[var7] = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class82.intStack[--class82.intStackSize]);
         }
      }

      var7 = class82.intStack[--class82.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2844 = var8;
      } else if(var0 == 1401) {
         var3.field2847 = var8;
      } else if(var0 == 1402) {
         var3.field2854 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2820 = var8;
      } else if(var0 == 1406) {
         var3.field2856 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2862 = var8;
      } else if(var0 == 1410) {
         var3.field2852 = var8;
      } else if(var0 == 1411) {
         var3.field2845 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2836 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2876 = var8;
      } else if(var0 == 1419) {
         var3.field2865 = var8;
      } else if(var0 == 1420) {
         var3.field2755 = var8;
      } else if(var0 == 1421) {
         var3.field2834 = var8;
      } else if(var0 == 1422) {
         var3.field2859 = var8;
      } else if(var0 == 1423) {
         var3.field2878 = var8;
      } else if(var0 == 1424) {
         var3.field2870 = var8;
      } else if(var0 == 1425) {
         var3.field2872 = var8;
      } else if(var0 == 1426) {
         var3.field2873 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2871 = var8;
      }

      var3.field2890 = true;
      return 1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "1067062154"
   )
   static int method15(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 5504) {
         class82.intStackSize -= 2;
         var3 = class82.intStack[class82.intStackSize];
         int var4 = class82.intStack[class82.intStackSize + 1];
         if(!Client.field1101) {
            Client.field1092 = var3;
            Client.mapAngle = var4;
         }

         return 1;
      } else if(var0 == 5505) {
         class82.intStack[++class82.intStackSize - 1] = Client.field1092;
         return 1;
      } else if(var0 == 5506) {
         class82.intStack[++class82.intStackSize - 1] = Client.mapAngle;
         return 1;
      } else if(var0 == 5530) {
         var3 = class82.intStack[--class82.intStackSize];
         if(var3 < 0) {
            var3 = 0;
         }

         Client.field1023 = var3;
         return 1;
      } else if(var0 == 5531) {
         class82.intStack[++class82.intStackSize - 1] = Client.field1023;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("km")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1252213953"
   )
   public static void method12(int var0, int var1, int var2) {
      PacketNode var3 = class235.method4272(ClientPacket.field2379, Client.field915.field1462);
      var3.packetBuffer.putShort(var0);
      var3.packetBuffer.method3361(var2);
      var3.packetBuffer.writeIntLE(var1);
      Client.field915.method1898(var3);
   }
}
