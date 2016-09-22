import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class18 {
   @ObfuscatedName("jy")
   static Widget[] field249;
   @ObfuscatedName("d")
   class149 field250;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 308537325
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("r")
   byte[] field252 = new byte[4];
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1080052273
   )
   int field253;
   @ObfuscatedName("t")
   byte[] field254;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1259877637
   )
   int field255;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 755916927
   )
   int field256;
   @ObfuscatedName("ej")
   static ModIcon[] field257;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -3370367973004572633L
   )
   long field258;
   @ObfuscatedName("pk")
   static class224 field260;
   @ObfuscatedName("v")
   DataInputStream field264;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1321636967"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class133.worldServersDownload == null) {
            class133.worldServersDownload = new class18(class126.field2103, new URL(class164.field2707));
         } else {
            byte[] var0 = class133.worldServersDownload.method199();
            if(null != var0) {
               Buffer var1 = new Buffer(var0);
               World.field659 = var1.method2717();
               World.worldList = new World[World.field659];

               World var3;
               for(int var2 = 0; var2 < World.field659; var3.index = var2++) {
                  var3 = World.worldList[var2] = new World();
                  var3.id = var1.method2717();
                  var3.mask = var1.method2533();
                  var3.address = var1.method2530();
                  var3.activity = var1.method2530();
                  var3.location = var1.method2528();
                  var3.playerCount = var1.method2618();
               }

               ChatLineBuffer.method670(World.worldList, 0, World.worldList.length - 1, World.field660, World.field661);
               class133.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class133.worldServersDownload = null;
      }

      return false;
   }

   class18(class139 var1, URL var2) {
      this.field250 = var1.method2915(var2);
      this.field256 = 0;
      this.field258 = class5.method63() + 30000L;
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(LWidget;IIB)V",
      garbageValue = "-5"
   )
   static void method197(Widget var0, int var1, int var2) {
      if(var0.field2866 == 0) {
         var0.relativeX = var0.field2830;
      } else if(var0.field2866 == 1) {
         var0.relativeX = var0.field2830 + (var1 - var0.width) / 2;
      } else if(var0.field2866 == 2) {
         var0.relativeX = var1 - var0.width - var0.field2830;
      } else if(var0.field2866 == 3) {
         var0.relativeX = var1 * var0.field2830 >> 14;
      } else if(var0.field2866 == 4) {
         var0.relativeX = (var1 - var0.width) / 2 + (var0.field2830 * var1 >> 14);
      } else {
         var0.relativeX = var1 - var0.width - (var1 * var0.field2830 >> 14);
      }

      if(var0.field2822 == 0) {
         var0.relativeY = var0.field2896;
      } else if(var0.field2822 == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.field2896;
      } else if(var0.field2822 == 2) {
         var0.relativeY = var2 - var0.height - var0.field2896;
      } else if(var0.field2822 == 3) {
         var0.relativeY = var0.field2896 * var2 >> 14;
      } else if(var0.field2822 == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var2 * var0.field2896 >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var0.field2896 * var2 >> 14);
      }

      if(Client.field558 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1247392786"
   )
   public static int method198(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "30"
   )
   byte[] method199() throws IOException {
      if(class5.method63() > this.field258) {
         throw new IOException();
      } else {
         if(this.field256 == 0) {
            if(this.field250.field2284 == 2) {
               throw new IOException();
            }

            if(this.field250.field2284 == 1) {
               this.field264 = (DataInputStream)this.field250.field2287;
               this.field256 = 1;
            }
         }

         int var1;
         if(this.field256 == 1) {
            var1 = this.field264.available();
            if(var1 > 0) {
               if(var1 + this.field253 > 4) {
                  var1 = 4 - this.field253;
               }

               this.field253 += this.field264.read(this.field252, this.field253, var1);
               if(this.field253 == 4) {
                  int var2 = (new Buffer(this.field252)).method2533();
                  this.field254 = new byte[var2];
                  this.field256 = 2;
               }
            }
         }

         if(this.field256 == 2) {
            var1 = this.field264.available();
            if(var1 > 0) {
               if(this.field255 + var1 > this.field254.length) {
                  var1 = this.field254.length - this.field255;
               }

               this.field255 += this.field264.read(this.field254, this.field255, var1);
               if(this.field255 == this.field254.length) {
                  return this.field254;
               }
            }
         }

         return null;
      }
   }
}
