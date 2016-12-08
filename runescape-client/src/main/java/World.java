import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("World")
public class World {
   @ObfuscatedName("c")
   static int[] field675 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("aw")
   static class102 field678;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 569720573
   )
   static int field679 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2110975057
   )
   static int field680 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -583317359
   )
   @Export("id")
   int id;
   @ObfuscatedName("k")
   @Export("worldServersDownload")
   static class26 worldServersDownload;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1066789791
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("f")
   @Export("address")
   String address;
   @ObfuscatedName("p")
   @Export("activity")
   String activity;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1672302939
   )
   @Export("location")
   int location;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 269085923
   )
   @Export("index")
   int index;
   @ObfuscatedName("h")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("dw")
   static byte[][] field692;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 520287367
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("r")
   static class20 field695;
   @ObfuscatedName("u")
   static int[] field696 = new int[]{0, 1, 2, 3};

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1121180583"
   )
   boolean method596() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "44084456"
   )
   boolean method597() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-688372330"
   )
   boolean method598() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "55"
   )
   boolean method600() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("m")
   static final void method607(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-126"
   )
   boolean method610() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-3265"
   )
   boolean method616() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIIIII)V",
      garbageValue = "1935229749"
   )
   static final void method630(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field368) {
         Client.field369 = 32;
      } else {
         Client.field369 = 0;
      }

      Client.field368 = false;
      int var7;
      if(class115.field1822 == 1 || !class148.field2047 && class115.field1822 == 4) {
         if(var5 >= var1 && var5 < 16 + var1 && var6 >= var2 && var6 < 16 + var2) {
            var0.scrollY -= 4;
            class97.method1886(var0);
         } else if(var5 >= var1 && var5 < 16 + var1 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.scrollY += 4;
            class97.method1886(var0);
         } else if(var5 >= var1 - Client.field369 && var5 < var1 + 16 + Client.field369 && var6 >= 16 + var2 && var6 < var3 + var2 - 16) {
            var7 = (var3 - 32) * var3 / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = (var4 - var3) * var8 / var9;
            class97.method1886(var0);
            Client.field368 = true;
         }
      }

      if(Client.field482 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var2 + var3) {
            var0.scrollY += Client.field482 * 45;
            class97.method1886(var0);
         }
      }

   }
}
