import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class1 {
   @ObfuscatedName("p")
   static final class1 field1;
   @ObfuscatedName("i")
   static final class1 field2;
   @ObfuscatedName("j")
   static final class1 field3;
   @ObfuscatedName("f")
   static final class1 field4;
   @ObfuscatedName("c")
   static final class1 field5;
   @ObfuscatedName("n")
   static final class1 field6;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1651437473
   )
   final int field7;
   @ObfuscatedName("m")
   static final class1 field8;
   @ObfuscatedName("t")
   public static Buffer field10;
   @ObfuscatedName("d")
   static int[] field12;

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-468198924"
   )
   static final void method0(int var0, int var1, int var2, boolean var3) {
      if(class73.method1095(var0)) {
         class47.method690(Widget.widgets[var0], -1, var1, var2, var3);
      }
   }

   static {
      field6 = new class1(2);
      field1 = new class1(4);
      field2 = new class1(3);
      field3 = new class1(6);
      field4 = new class1(1);
      field8 = new class1(0);
      field5 = new class1(5);
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "2"
   )
   static final void method1(String var0) {
      if(var0 != null) {
         String var1 = CollisionData.method3023(var0, class13.field281);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
               Ignore var3 = Client.ignores[var2];
               String var4 = var3.name;
               String var5 = CollisionData.method3023(var4, class13.field281);
               boolean var6;
               if(var0 != null && var4 != null) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --Client.ignoreCount;

                  for(int var7 = var2; var7 < Client.ignoreCount; ++var7) {
                     Client.ignores[var7] = Client.ignores[var7 + 1];
                  }

                  Client.field1109 = Client.field1110;
                  Client.secretPacketBuffer1.putOpcode(140);
                  Client.secretPacketBuffer1.putByte(Script.method1836(var0));
                  Client.secretPacketBuffer1.method3150(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2"
   )
   class1(int var1) {
      this.field7 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;I)V",
      garbageValue = "-1893859963"
   )
   static final void method2(PacketBuffer var0) {
      var0.method3399();
      int var1 = Client.localInteractingIndex;
      Player var2 = class168.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field892 = var1;
      int var3 = var0.method3400(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class61.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method1111() << 6);
      var2.pathY[0] = var6 - class23.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method1111() << 6);
      class92.plane = var2.field891 = var4;
      if(class96.field1497[var1] != null) {
         var2.method1109(class96.field1497[var1]);
      }

      class96.field1499 = 0;
      class96.field1501[++class96.field1499 - 1] = var1;
      class96.field1503[var1] = 0;
      class96.field1502 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.method3400(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class96.field1504[var7] = var11 + (var9 << 28) + (var10 << 14);
            class96.field1505[var7] = 0;
            class96.field1495[var7] = -1;
            class96.field1511[++class96.field1502 - 1] = var7;
            class96.field1503[var7] = 0;
         }
      }

      var0.method3401();
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "-1206267559"
   )
   static void method3(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2659 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2659 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2659 == 2) {
         var0.width = var1 * var0.originalWidth >> 14;
      }

      if(var0.field2660 == 0) {
         var0.height = var0.field2782;
      } else if(var0.field2660 == 1) {
         var0.height = var2 - var0.field2782;
      } else if(var0.field2660 == 2) {
         var0.height = var2 * var0.field2782 >> 14;
      }

      if(var0.field2659 == 4) {
         var0.width = var0.field2749 * var0.height / var0.field2670;
      }

      if(var0.field2660 == 4) {
         var0.height = var0.width * var0.field2670 / var0.field2749;
      }

      if(Client.field1086 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field1088 = var0;
      }

      if(var3 && var0.field2761 != null && (var4 != var0.width || var5 != var0.height)) {
         class69 var6 = new class69();
         var6.field824 = var0;
         var6.field833 = var0.field2761;
         Client.field1115.method3634(var6);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;III)[LSpritePixels;",
      garbageValue = "754402999"
   )
   static SpritePixels[] method4(IndexDataBase var0, int var1, int var2) {
      if(!class112.method2092(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels[] var4 = new SpritePixels[class286.field3792];

         for(int var5 = 0; var5 < class286.field3792; ++var5) {
            SpritePixels var6 = var4[var5] = new SpritePixels();
            var6.maxWidth = NPC.field1377;
            var6.maxHeight = class286.field3791;
            var6.offsetX = class95.field1493[var5];
            var6.offsetY = class286.field3790[var5];
            var6.width = class286.field3793[var5];
            var6.height = class241.field3293[var5];
            int var7 = var6.height * var6.width;
            byte[] var8 = class31.field449[var5];
            var6.image = new int[var7];

            for(int var9 = 0; var9 < var7; ++var9) {
               var6.image[var9] = class174.field2410[var8[var9] & 255];
            }
         }

         VertexNormal.method2592();
         return var4;
      }
   }
}
