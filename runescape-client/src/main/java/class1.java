import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public class class1 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   static final class1 field8;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   static final class1 field1;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   static final class1 field2;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   static final class1 field0;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   static final class1 field4;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   static final class1 field10;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   static final class1 field6;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ldb;"
   )
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1832470093
   )
   final int field7;

   static {
      field8 = new class1(5);
      field1 = new class1(3);
      field2 = new class1(1);
      field0 = new class1(2);
      field4 = new class1(4);
      field10 = new class1(0);
      field6 = new class1(6);
   }

   class1(int var1) {
      this.field7 = var1;
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1542256661"
   )
   static final void method0() {
      Client.field915.close();
      class175.method3264();
      class45.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      class214.field2631 = 1;
      class214.field2632 = null;
      Ignore.field810 = -1;
      class262.field3474 = -1;
      class35.field477 = 0;
      class214.field2627 = false;
      FontName.field3711 = 2;
      Client.field1091 = -1;
      Client.field991 = false;

      for(class81 var1 = (class81)class81.field1247.getFront(); var1 != null; var1 = (class81)class81.field1247.getNext()) {
         if(var1.field1249 != null) {
            class89.field1328.method1924(var1.field1249);
            var1.field1249 = null;
         }

         if(var1.field1250 != null) {
            class89.field1328.method1924(var1.field1250);
            var1.field1250 = null;
         }
      }

      class81.field1247.clear();
      ClanMember.setGameState(10);
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-178914566"
   )
   static final void method1() {
      if(Client.field1082 != class7.plane) {
         Client.field1082 = class7.plane;
         int var0 = class7.plane;
         int[] var1 = class234.minimapSprite.pixels;
         int var2 = var1.length;

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            var1[var3] = 0;
         }

         int var4;
         int var5;
         for(var3 = 1; var3 < 103; ++var3) {
            var4 = (103 - var3) * 2048 + 24628;

            for(var5 = 1; var5 < 103; ++var5) {
               if((class61.tileSettings[var0][var5][var3] & 24) == 0) {
                  class45.region.method2780(var1, var4, 512, var0, var5, var3);
               }

               if(var0 < 3 && (class61.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
                  class45.region.method2780(var1, var4, 512, var0 + 1, var5, var3);
               }

               var4 += 4;
            }
         }

         var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
         var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
         class234.minimapSprite.method5273();

         int var6;
         for(var5 = 1; var5 < 103; ++var5) {
            for(var6 = 1; var6 < 103; ++var6) {
               if((class61.tileSettings[var0][var6][var5] & 24) == 0) {
                  Ignore.method1114(var0, var6, var5, var3, var4);
               }

               if(var0 < 3 && (class61.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
                  Ignore.method1114(var0 + 1, var6, var5, var3, var4);
               }
            }
         }

         Client.field1083 = 0;

         for(var5 = 0; var5 < 104; ++var5) {
            for(var6 = 0; var6 < 104; ++var6) {
               int var7 = class45.region.method2775(class7.plane, var5, var6);
               if(var7 != 0) {
                  var7 = var7 >> 14 & 32767;
                  int var8 = NPC.getObjectDefinition(var7).mapIconId;
                  if(var8 >= 0) {
                     Client.mapIcons[Client.field1083] = Area.mapAreaType[var8].getMapIcon(false);
                     Client.field1088[Client.field1083] = var5;
                     Client.field1085[Client.field1083] = var6;
                     ++Client.field1083;
                  }
               }
            }
         }

         class35.rasterProvider.setRaster();
      }

   }
}
