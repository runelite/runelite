import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
final class class18 implements Comparator {
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("socket")
   static Task socket;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = 306736361
   )
   @Export("myWorldPort")
   static int myWorldPort;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lt;Lt;I)I",
      garbageValue = "1380564075"
   )
   int method129(class14 var1, class14 var2) {
      return var1.method82().compareTo(var2.method82());
   }

   public int compare(Object var1, Object var2) {
      return this.method129((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   static void method139() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3492(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3493()) {
         int var1 = var0.id;
         if(class9.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class239.method4167(var4);
               if(var5 != null) {
                  class21.method156(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lip;IIIZI)V",
      garbageValue = "-337685251"
   )
   public static void method136(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class203.field2471 = 1;
      class222.field2815 = var0;
      class203.field2468 = var1;
      class203.field2473 = var2;
      WorldMapType2.field513 = var3;
      class203.field2474 = var4;
      ChatLineBuffer.field1524 = 10000;
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1889448231"
   )
   static final void method138() {
      int var0 = Player.field902 * 128 + 64;
      int var1 = class40.field550 * 128 + 64;
      int var2 = class23.getTileHeight(var0, var1, class10.plane) - WorldMapData.field448;
      if(class73.cameraX < var0) {
         class73.cameraX += Friend.field798 * (var0 - class73.cameraX) / 1000 + DecorativeObject.field2136;
         if(class73.cameraX > var0) {
            class73.cameraX = var0;
         }
      }

      if(class73.cameraX > var0) {
         class73.cameraX -= Friend.field798 * (class73.cameraX - var0) / 1000 + DecorativeObject.field2136;
         if(class73.cameraX < var0) {
            class73.cameraX = var0;
         }
      }

      if(WidgetNode.cameraZ < var2) {
         WidgetNode.cameraZ += (var2 - WidgetNode.cameraZ) * Friend.field798 / 1000 + DecorativeObject.field2136;
         if(WidgetNode.cameraZ > var2) {
            WidgetNode.cameraZ = var2;
         }
      }

      if(WidgetNode.cameraZ > var2) {
         WidgetNode.cameraZ -= Friend.field798 * (WidgetNode.cameraZ - var2) / 1000 + DecorativeObject.field2136;
         if(WidgetNode.cameraZ < var2) {
            WidgetNode.cameraZ = var2;
         }
      }

      if(Client.cameraY < var1) {
         Client.cameraY += DecorativeObject.field2136 + Friend.field798 * (var1 - Client.cameraY) / 1000;
         if(Client.cameraY > var1) {
            Client.cameraY = var1;
         }
      }

      if(Client.cameraY > var1) {
         Client.cameraY -= Friend.field798 * (Client.cameraY - var1) / 1000 + DecorativeObject.field2136;
         if(Client.cameraY < var1) {
            Client.cameraY = var1;
         }
      }

      var0 = class12.field258 * 128 + 64;
      var1 = class96.field1481 * 128 + 64;
      var2 = class23.getTileHeight(var0, var1, class10.plane) - class177.field2380;
      int var3 = var0 - class73.cameraX;
      int var4 = var2 - WidgetNode.cameraZ;
      int var5 = var1 - Client.cameraY;
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class10.cameraPitch < var7) {
         class10.cameraPitch += (var7 - class10.cameraPitch) * class22.field333 / 1000 + class269.field3659;
         if(class10.cameraPitch > var7) {
            class10.cameraPitch = var7;
         }
      }

      if(class10.cameraPitch > var7) {
         class10.cameraPitch -= class22.field333 * (class10.cameraPitch - var7) / 1000 + class269.field3659;
         if(class10.cameraPitch < var7) {
            class10.cameraPitch = var7;
         }
      }

      int var9 = var8 - class236.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class236.cameraYaw += class269.field3659 + var9 * class22.field333 / 1000;
         class236.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         class236.cameraYaw -= -var9 * class22.field333 / 1000 + class269.field3659;
         class236.cameraYaw &= 2047;
      }

      int var10 = var8 - class236.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class236.cameraYaw = var8;
      }

   }
}
