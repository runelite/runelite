import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class7 {
   @ObfuscatedName("a")
   public static boolean field232;
   @ObfuscatedName("j")
   public static boolean field227;
   @ObfuscatedName("n")
   public static boolean field228;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lu;"
   )
   public static class11 field229;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   public static CombatInfoList field226;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -1958417285
   )
   @Export("cameraY")
   static int cameraY;

   static {
      field232 = false;
      field227 = false;
      field228 = false;
      field229 = class11.field273;
      field226 = new CombatInfoList();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "920067345"
   )
   @Export("getString")
   public static String getString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class266.field3663[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "535304772"
   )
   static void method35() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3538(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3539()) {
         int var1 = var0.id;
         if(class33.loadWidget(var1)) {
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
               Widget var5 = class61.method1038(var4);
               if(var5 != null) {
                  class48.method749(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1099255461"
   )
   static void method22() {
      class61.field747 = 99;
      Item.underlayIds = new byte[4][104][104];
      class61.overlayIds = new byte[4][104][104];
      class12.overlayPaths = new byte[4][104][104];
      class61.overlayRotations = new byte[4][104][104];
      class9.field249 = new int[4][105][105];
      class61.field750 = new byte[4][105][105];
      FileRequest.field3211 = new int[105][105];
      class61.blendedHue = new int[104];
      class98.blendedSaturation = new int[104];
      class10.field256 = new int[104];
      class61.field763 = new int[104];
      Varcs.field1508 = new int[104];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "-1208209535"
   )
   public static boolean method28(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1764429601"
   )
   static final void method25() {
      if(Client.field1133 != class45.plane) {
         Client.field1133 = class45.plane;
         XItemContainer.method1078(class45.plane);
      }

   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1225913186"
   )
   static void method34(int var0, String var1) {
      int var2 = class96.field1499;
      int[] var3 = class96.field1492;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(var6 != null && var6 != Script.localPlayer && var6.name != null && var6.name.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               Client.secretPacketBuffer1.putOpcode(143);
               Client.secretPacketBuffer1.putByte(0);
               Client.secretPacketBuffer1.putShortOb2(var3[var5]);
            } else if(var0 == 4) {
               Client.secretPacketBuffer1.putOpcode(49);
               Client.secretPacketBuffer1.putShort(var3[var5]);
               Client.secretPacketBuffer1.putShortLE(0);
            } else if(var0 == 6) {
               Client.secretPacketBuffer1.putOpcode(20);
               Client.secretPacketBuffer1.putShortLE(0);
               Client.secretPacketBuffer1.putShort(var3[var5]);
            } else if(var0 == 7) {
               Client.secretPacketBuffer1.putOpcode(93);
               Client.secretPacketBuffer1.method3164(0);
               Client.secretPacketBuffer1.putLEShortA(var3[var5]);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         WidgetNode.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }
}
