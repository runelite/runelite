import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class33 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -66709267
   )
   int field468;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1840648357
   )
   int field469;
   @ObfuscatedName("i")
   String field470;
   @ObfuscatedName("v")
   class24 field471;
   @ObfuscatedName("ep")
   static Font field473;
   @ObfuscatedName("y")
   static SpritePixels field474;

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-60"
   )
   static final void method338(boolean var0) {
      for(int var1 = 0; var1 < Client.field968; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field950[var1]];
         int var3 = (Client.field950[var1] << 14) + 536870912;
         if(var2 != null && var2.vmethod1691() && var2.composition.isVisible == var0 && var2.composition.method4649()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1268 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field1033[var4][var5] == Client.field1034) {
                     continue;
                  }

                  Client.field1033[var4][var5] = Client.field1034;
               }

               if(!var2.composition.field3559) {
                  var3 -= Integer.MIN_VALUE;
               }

               class1.region.method2685(FaceNormal.plane, var2.x, var2.y, class21.method139(var2.field1268 * 64 - 64 + var2.x, var2.field1268 * 64 - 64 + var2.y, FaceNormal.plane), var2.field1268 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1262);
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "559816273"
   )
   public static boolean method339(File var0, boolean var1) {
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

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "1549037975"
   )
   static final boolean method340(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field982 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1201.method3937(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1201.method3938(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1201.method3939(false);
         }

         if(var1 == 325) {
            Client.field1201.method3939(true);
         }

         if(var1 == 326) {
            Client.secretPacketBuffer1.putOpcode(46);
            Client.field1201.method3961(Client.secretPacketBuffer1);
            return true;
         } else {
            return false;
         }
      }
   }

   class33(String var1, int var2, int var3, class24 var4) {
      this.field470 = var1;
      this.field469 = var2;
      this.field468 = var3;
      this.field471 = var4;
   }
}
