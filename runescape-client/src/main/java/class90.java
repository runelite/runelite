import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
public class class90 {
   @ObfuscatedName("i")
   static final BigInteger field1396;
   @ObfuscatedName("h")
   static final BigInteger field1397;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = 744690931
   )
   static int field1399;
   @ObfuscatedName("v")
   @Export("widgets")
   public static Widget[][] widgets;
   @ObfuscatedName("q")
   @Export("underlayIds")
   static byte[][][] underlayIds;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LScript;",
      garbageValue = "-491896793"
   )
   static Script method1746(int var0) {
      Script var1 = (Script)Script.field1534.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class66.indexScripts.getConfigData(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = class19.method144(var2);
            Script.field1534.put(var1, (long)var0);
            return var1;
         }
      }
   }

   static {
      field1396 = new BigInteger("10001", 16);
      field1397 = new BigInteger("ab934ec01c6870d05e6581fb2a9d35d4eab63761956fe2f2d900ea4cb1ab450318ae3dfa1eb46c75f97d6e7c892784add604e2cd114219346bec511e1745ef543a3d69b9eba7a708763a3a41367bd5ed5354a90890c3b1990fad64511cebf5edddffbcfc44d94a0e223ded2c3196e6e9ae79f18c400da68a6ff42498fc1aea53", 16);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;I)V",
      garbageValue = "1656378841"
   )
   static void method1747(Font var0, Font var1) {
      if(RSSocket.field2257 == null) {
         RSSocket.field2257 = XItemContainer.method1083(class77.indexSprites, "sl_back", "");
      }

      if(Buffer.field2378 == null) {
         Buffer.field2378 = class56.method826(class77.indexSprites, "sl_flags", "");
      }

      if(class45.field584 == null) {
         class45.field584 = class56.method826(class77.indexSprites, "sl_arrows", "");
      }

      if(class100.field1544 == null) {
         class100.field1544 = class56.method826(class77.indexSprites, "sl_stars", "");
      }

      Rasterizer2D.method5042(class92.field1416, 23, 765, 480, 0);
      Rasterizer2D.method5010(class92.field1416, 0, 125, 23, 12425273, 9135624);
      Rasterizer2D.method5010(class92.field1416 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method4817("Select a world", class92.field1416 + 62, 15, 0, -1);
      if(class100.field1544 != null) {
         class100.field1544[1].method5101(class92.field1416 + 140, 1);
         var1.method4889("Members only world", class92.field1416 + 152, 10, 16777215, -1);
         class100.field1544[0].method5101(class92.field1416 + 140, 12);
         var1.method4889("Free world", class92.field1416 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(class45.field584 != null) {
         int var2 = class92.field1416 + 280;
         if(World.field1270[0] == 0 && World.field1269[0] == 0) {
            class45.field584[2].method5101(var2, 4);
         } else {
            class45.field584[0].method5101(var2, 4);
         }

         if(World.field1270[0] == 0 && World.field1269[0] == 1) {
            class45.field584[3].method5101(var2 + 15, 4);
         } else {
            class45.field584[1].method5101(var2 + 15, 4);
         }

         var0.method4889("World", var2 + 32, 17, 16777215, -1);
         int var3 = class92.field1416 + 390;
         if(World.field1270[0] == 1 && World.field1269[0] == 0) {
            class45.field584[2].method5101(var3, 4);
         } else {
            class45.field584[0].method5101(var3, 4);
         }

         if(World.field1270[0] == 1 && World.field1269[0] == 1) {
            class45.field584[3].method5101(var3 + 15, 4);
         } else {
            class45.field584[1].method5101(var3 + 15, 4);
         }

         var0.method4889("Players", var3 + 32, 17, 16777215, -1);
         var4 = class92.field1416 + 500;
         if(World.field1270[0] == 2 && World.field1269[0] == 0) {
            class45.field584[2].method5101(var4, 4);
         } else {
            class45.field584[0].method5101(var4, 4);
         }

         if(World.field1270[0] == 2 && World.field1269[0] == 1) {
            class45.field584[3].method5101(var4 + 15, 4);
         } else {
            class45.field584[1].method5101(var4 + 15, 4);
         }

         var0.method4889("Location", var4 + 32, 17, 16777215, -1);
         var5 = class92.field1416 + 610;
         if(World.field1270[0] == 3 && World.field1269[0] == 0) {
            class45.field584[2].method5101(var5, 4);
         } else {
            class45.field584[0].method5101(var5, 4);
         }

         if(World.field1270[0] == 3 && World.field1269[0] == 1) {
            class45.field584[3].method5101(var5 + 15, 4);
         } else {
            class45.field584[1].method5101(var5 + 15, 4);
         }

         var0.method4889("Type", var5 + 32, 17, 16777215, -1);
      }

      Rasterizer2D.method5042(class92.field1416 + 708, 4, 50, 16, 0);
      var1.method4817("Cancel", class92.field1416 + 708 + 25, 16, 16777215, -1);
      class92.field1446 = -1;
      if(RSSocket.field2257 != null) {
         byte var21 = 88;
         byte var22 = 19;
         var4 = 765 / (var21 + 1);
         var5 = 480 / (var22 + 1);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if((var4 - 1) * var5 >= World.field1267) {
               --var4;
            }

            if(var4 * (var5 - 1) >= World.field1267) {
               --var5;
            }

            if(var4 * (var5 - 1) >= World.field1267) {
               --var5;
            }
         } while(var6 != var5 || var4 != var7);

         var6 = (765 - var4 * var21) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var5 * var22) / (var5 + 1);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var4 * var21 - (var4 - 1) * var6) / 2;
         int var9 = (480 - var22 * var5 - var7 * (var5 - 1)) / 2;
         int var10 = var9 + 23;
         int var11 = class92.field1416 + var8;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.field1267; ++var14) {
            World var15 = World.worldList[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.playerCount);
            if(var15.playerCount == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.playerCount > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method1555()) {
               if(var15.method1549()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method1554()) {
               var19 = 16711680;
               if(var15.method1549()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method1552()) {
               if(var15.method1549()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method1549()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class59.field721 >= var11 && class59.field722 >= var10 && class59.field721 < var11 + var21 && class59.field722 < var22 + var10 && var16) {
               class92.field1446 = var14;
               RSSocket.field2257[var18].method5136(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               RSSocket.field2257[var18].method5130(var11, var10);
            }

            if(Buffer.field2378 != null) {
               Buffer.field2378[(var15.method1549()?8:0) + var15.location].method5101(var11 + 29, var10);
            }

            var0.method4817(Integer.toString(var15.id), var11 + 15, var22 / 2 + var10 + 5, var19, -1);
            var1.method4817(var17, var11 + 60, var22 / 2 + var10 + 5, 268435455, -1);
            var10 += var22 + var7;
            ++var12;
            if(var12 >= var5) {
               var10 = var9 + 23;
               var11 += var21 + var6;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method4809(World.worldList[class92.field1446].activity) + 6;
            int var20 = var1.field3638 + 8;
            Rasterizer2D.method5042(class59.field721 - var14 / 2, class59.field722 + 20 + 5, var14, var20, 16777120);
            Rasterizer2D.method5012(class59.field721 - var14 / 2, class59.field722 + 20 + 5, var14, var20, 0);
            var1.method4817(World.worldList[class92.field1446].activity, class59.field721, var1.field3638 + class59.field722 + 20 + 5 + 4, 0, -1);
         }
      }

      class40.field541.vmethod5083(0, 0);
   }
}
