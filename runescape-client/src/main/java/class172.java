import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class172 {
   @ObfuscatedName("dc")
   @Export("region")
   static Region region;

   class172() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "0"
   )
   static void method3254(int var0, int var1, int var2, int var3) {
      for(class31 var4 = (class31)class31.field709.method2828(); var4 != null; var4 = (class31)class31.field709.method2830()) {
         if(var4.field704 != -1 || var4.field708 != null) {
            int var5 = 0;
            if(var1 > var4.field701) {
               var5 += var1 - var4.field701;
            } else if(var1 < var4.field699) {
               var5 += var4.field699 - var1;
            }

            if(var2 > var4.field702) {
               var5 += var2 - var4.field702;
            } else if(var2 < var4.field700) {
               var5 += var4.field700 - var2;
            }

            if(var5 - 64 <= var4.field703 && Client.field527 != 0 && var0 == var4.field698) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field703 - var5) * Client.field527 / var4.field703;
               if(var4.field705 == null) {
                  if(var4.field704 >= 0) {
                     SoundEffect var11 = SoundEffect.method993(class199.field2882, var4.field704, 0);
                     if(var11 != null) {
                        class55 var8 = var11.method991().method1036(class118.field1848);
                        class66 var9 = class66.method1286(var8, 100, var6);
                        var9.method1281(-1);
                        class114.field1791.method935(var9);
                        var4.field705 = var9;
                     }
                  }
               } else {
                  var4.field705.method1203(var6);
               }

               if(var4.field710 == null) {
                  if(var4.field708 != null && (var4.field712 -= var3) <= 0) {
                     int var7 = (int)(Math.random() * (double)var4.field708.length);
                     SoundEffect var12 = SoundEffect.method993(class199.field2882, var4.field708[var7], 0);
                     if(var12 != null) {
                        class55 var13 = var12.method991().method1036(class118.field1848);
                        class66 var10 = class66.method1286(var13, 100, var6);
                        var10.method1281(0);
                        class114.field1791.method935(var10);
                        var4.field710 = var10;
                        var4.field712 = var4.field713 + (int)(Math.random() * (double)(var4.field707 - var4.field713));
                     }
                  }
               } else {
                  var4.field710.method1203(var6);
                  if(!var4.field710.linked()) {
                     var4.field710 = null;
                  }
               }
            } else {
               if(var4.field705 != null) {
                  class114.field1791.method945(var4.field705);
                  var4.field705 = null;
               }

               if(var4.field710 != null) {
                  class114.field1791.method945(var4.field710);
                  var4.field710 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "78"
   )
   public static void method3255(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class229.field3250 = var1.readUnsignedShort();
      class199.field2877 = new int[class229.field3250];
      class229.field3252 = new int[class229.field3250];
      class229.field3254 = new int[class229.field3250];
      class36.field772 = new int[class229.field3250];
      class229.field3253 = new byte[class229.field3250][];
      var1.offset = var0.length - 7 - class229.field3250 * 8;
      class229.field3255 = var1.readUnsignedShort();
      class229.field3251 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class229.field3250; ++var3) {
         class199.field2877[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class229.field3250; ++var3) {
         class229.field3252[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class229.field3250; ++var3) {
         class229.field3254[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class229.field3250; ++var3) {
         class36.field772[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class229.field3250 * 8 - (var2 - 1) * 3;
      class229.field3249 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class229.field3249[var3] = var1.read24BitInt();
         if(class229.field3249[var3] == 0) {
            class229.field3249[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class229.field3250; ++var3) {
         int var4 = class229.field3254[var3];
         int var5 = class36.field772[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class229.field3253[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var4 * var10] = var1.readByte();
               }
            }
         }
      }

   }
}
