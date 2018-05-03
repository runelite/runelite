import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
public class class197 {
   @ObfuscatedName("c")
   public static short[] field2591;
   @ObfuscatedName("h")
   static final int[] field2594;
   @ObfuscatedName("i")
   static final int[] field2595;

   static {
      field2594 = new int[2048];
      field2595 = new int[2048];
      double var0 = 0.0030679615757712823D;

      for(int var2 = 0; var2 < 2048; ++var2) {
         field2594[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
         field2595[var2] = (int)(65536.0D * Math.cos((double)var2 * var0));
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILcr;ZB)I",
      garbageValue = "29"
   )
   static int method3823(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class81.intStack[--class171.intStackSize];
         var3 = UnitPriceComparator.getWidget(var4);
      } else {
         var3 = var2?class49.field604:class81.field1270;
      }

      if(var0 == 1100) {
         class171.intStackSize -= 2;
         var3.scrollX = class81.intStack[class171.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class81.intStack[class171.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         TotalQuantityComparator.method100(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class81.intStack[--class171.intStackSize];
         TotalQuantityComparator.method100(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.filled = class81.intStack[--class171.intStackSize] == 1;
         TotalQuantityComparator.method100(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class81.intStack[--class171.intStackSize];
         TotalQuantityComparator.method100(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.lineWidth = class81.intStack[--class171.intStackSize];
         TotalQuantityComparator.method100(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class81.intStack[--class171.intStackSize];
         TotalQuantityComparator.method100(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class81.intStack[--class171.intStackSize];
         TotalQuantityComparator.method100(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.spriteTiling = class81.intStack[--class171.intStackSize] == 1;
         TotalQuantityComparator.method100(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class81.intStack[--class171.intStackSize];
         TotalQuantityComparator.method100(var3);
         return 1;
      } else if(var0 == 1109) {
         class171.intStackSize -= 6;
         var3.offsetX2d = class81.intStack[class171.intStackSize];
         var3.offsetY2d = class81.intStack[class171.intStackSize + 1];
         var3.rotationX = class81.intStack[class171.intStackSize + 2];
         var3.rotationZ = class81.intStack[class171.intStackSize + 3];
         var3.rotationY = class81.intStack[class171.intStackSize + 4];
         var3.modelZoom = class81.intStack[class171.intStackSize + 5];
         TotalQuantityComparator.method100(var3);
         return 1;
      } else {
         int var10;
         if(var0 == 1110) {
            var10 = class81.intStack[--class171.intStackSize];
            if(var10 != var3.field2868) {
               var3.field2868 = var10;
               var3.field2943 = 0;
               var3.field2896 = 0;
               TotalQuantityComparator.method100(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2878 = class81.intStack[--class171.intStackSize] == 1;
            TotalQuantityComparator.method100(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class81.scriptStringStack[--class81.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               TotalQuantityComparator.method100(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class81.intStack[--class171.intStackSize];
            TotalQuantityComparator.method100(var3);
            return 1;
         } else if(var0 == 1114) {
            class171.intStackSize -= 3;
            var3.field2870 = class81.intStack[class171.intStackSize];
            var3.field2947 = class81.intStack[class171.intStackSize + 1];
            var3.field2883 = class81.intStack[class171.intStackSize + 2];
            TotalQuantityComparator.method100(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class81.intStack[--class171.intStackSize] == 1;
            TotalQuantityComparator.method100(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class81.intStack[--class171.intStackSize];
            TotalQuantityComparator.method100(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class81.intStack[--class171.intStackSize];
            TotalQuantityComparator.method100(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class81.intStack[--class171.intStackSize] == 1;
            TotalQuantityComparator.method100(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class81.intStack[--class171.intStackSize] == 1;
            TotalQuantityComparator.method100(var3);
            return 1;
         } else if(var0 == 1120) {
            class171.intStackSize -= 2;
            var3.scrollWidth = class81.intStack[class171.intStackSize];
            var3.scrollHeight = class81.intStack[class171.intStackSize + 1];
            TotalQuantityComparator.method100(var3);
            if(var4 != -1 && var3.type == 0) {
               class33.method372(GZipDecompressor.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            var10 = var3.id;
            int var6 = var3.index;
            PacketNode var11 = AbstractSoundSystem.method2350(ClientPacket.field2431, Client.field911.field1460);
            var11.packetBuffer.method3634(var6);
            var11.packetBuffer.method3644(var10);
            Client.field911.method2135(var11);
            Client.field1017 = var3;
            TotalQuantityComparator.method100(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2857 = class81.intStack[--class171.intStackSize];
            TotalQuantityComparator.method100(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2847 = class81.intStack[--class171.intStackSize];
            TotalQuantityComparator.method100(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2853 = class81.intStack[--class171.intStackSize];
            TotalQuantityComparator.method100(var3);
            return 1;
         } else if(var0 == 1125) {
            var10 = class81.intStack[--class171.intStackSize];
            class329[] var9 = new class329[]{class329.field3974, class329.field3971, class329.field3972, class329.field3976, class329.field3973};
            class329 var7 = (class329)class185.forOrdinal(var9, var10);
            if(var7 != null) {
               var3.field2854 = var7;
               TotalQuantityComparator.method100(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class81.intStack[--class171.intStackSize] == 1;
            var3.field2830 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1060921300"
   )
   static int method3822(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return Buffer.currentRequest != null && Buffer.currentRequest.hash == var2?Frames.NetCache_responseArchiveBuffer.offset * 99 / (Frames.NetCache_responseArchiveBuffer.payload.length - Buffer.currentRequest.padding) + 1:0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "92"
   )
   static final void method3821(String var0) {
      StringBuilder var10000 = new StringBuilder();
      Object var10001 = null;
      var10000 = var10000.append("Please remove ").append(var0);
      var10001 = null;
      String var1 = var10000.append(" from your ignore list first").toString();
      ChatPlayer.sendGameMessage(30, "", var1);
   }
}
