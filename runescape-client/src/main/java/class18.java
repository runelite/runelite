import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class18 {
   @ObfuscatedName("f")
   static int[] field257;
   @ObfuscatedName("r")
   class149 field258;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1077677473
   )
   int field259;
   @ObfuscatedName("z")
   byte[] field260 = new byte[4];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 111556825
   )
   int field261;
   @ObfuscatedName("j")
   DataInputStream field262;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1361350119
   )
   int field263;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -2210656246963884771L
   )
   long field264;
   @ObfuscatedName("b")
   byte[] field267;

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-1421067620"
   )
   static final void method194(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class175.method3419(var0)) {
         class11.field170 = null;
         Player.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(null != class11.field170) {
            Player.gameDraw(class11.field170, -1412584499, var1, var2, var3, var4, Frames.field1827, Projectile.field123, var7);
            class11.field170 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field484[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field484[var8] = true;
            }
         }

      }
   }

   class18(class139 var1, URL var2) {
      this.field258 = var1.method2929(var2);
      this.field259 = 0;
      this.field264 = class34.method713() + 30000L;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "2112987392"
   )
   byte[] method197() throws IOException {
      if(class34.method713() > this.field264) {
         throw new IOException();
      } else {
         if(this.field259 == 0) {
            if(this.field258.field2266 == 2) {
               throw new IOException();
            }

            if(this.field258.field2266 == 1) {
               this.field262 = (DataInputStream)this.field258.field2270;
               this.field259 = 1;
            }
         }

         int var1;
         if(this.field259 == 1) {
            var1 = this.field262.available();
            if(var1 > 0) {
               if(this.field261 + var1 > 4) {
                  var1 = 4 - this.field261;
               }

               this.field261 += this.field262.read(this.field260, this.field261, var1);
               if(this.field261 == 4) {
                  int var2 = (new Buffer(this.field260)).method2561();
                  this.field267 = new byte[var2];
                  this.field259 = 2;
               }
            }
         }

         if(this.field259 == 2) {
            var1 = this.field262.available();
            if(var1 > 0) {
               if(this.field263 + var1 > this.field267.length) {
                  var1 = this.field267.length - this.field263;
               }

               this.field263 += this.field262.read(this.field267, this.field263, var1);
               if(this.field263 == this.field267.length) {
                  return this.field267;
               }
            }
         }

         return null;
      }
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;B)V",
      garbageValue = "1"
   )
   static void method198(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = class166.method3265(var1, var2);
      if(var5 != null) {
         if(null != var5.field2804) {
            class0 var6 = new class0();
            var6.field7 = var5;
            var6.field11 = var0;
            var6.field9 = var4;
            var6.field8 = var5.field2804;
            class158.method3201(var6, 200000);
         }

         boolean var10 = true;
         if(var5.contentType > 0) {
            var10 = class118.method2499(var5);
         }

         if(var10) {
            int var8 = class132.method2880(var5);
            int var9 = var0 - 1;
            boolean var7 = (var8 >> 1 + var9 & 1) != 0;
            if(var7) {
               if(var0 == 1) {
                  Client.field323.method2818(105);
                  Client.field323.method2544(var1);
                  Client.field323.method2542(var2);
                  Client.field323.method2542(var3);
               }

               if(var0 == 2) {
                  Client.field323.method2818(115);
                  Client.field323.method2544(var1);
                  Client.field323.method2542(var2);
                  Client.field323.method2542(var3);
               }

               if(var0 == 3) {
                  Client.field323.method2818(232);
                  Client.field323.method2544(var1);
                  Client.field323.method2542(var2);
                  Client.field323.method2542(var3);
               }

               if(var0 == 4) {
                  Client.field323.method2818(94);
                  Client.field323.method2544(var1);
                  Client.field323.method2542(var2);
                  Client.field323.method2542(var3);
               }

               if(var0 == 5) {
                  Client.field323.method2818(181);
                  Client.field323.method2544(var1);
                  Client.field323.method2542(var2);
                  Client.field323.method2542(var3);
               }

               if(var0 == 6) {
                  Client.field323.method2818(215);
                  Client.field323.method2544(var1);
                  Client.field323.method2542(var2);
                  Client.field323.method2542(var3);
               }

               if(var0 == 7) {
                  Client.field323.method2818(109);
                  Client.field323.method2544(var1);
                  Client.field323.method2542(var2);
                  Client.field323.method2542(var3);
               }

               if(var0 == 8) {
                  Client.field323.method2818(255);
                  Client.field323.method2544(var1);
                  Client.field323.method2542(var2);
                  Client.field323.method2542(var3);
               }

               if(var0 == 9) {
                  Client.field323.method2818(51);
                  Client.field323.method2544(var1);
                  Client.field323.method2542(var2);
                  Client.field323.method2542(var3);
               }

               if(var0 == 10) {
                  Client.field323.method2818(175);
                  Client.field323.method2544(var1);
                  Client.field323.method2542(var2);
                  Client.field323.method2542(var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;I)V",
      garbageValue = "-1653664809"
   )
   public static void method199(class170 var0, class170 var1) {
      KitDefinition.field1036 = var0;
      KitDefinition.field1038 = var1;
      KitDefinition.field1034 = KitDefinition.field1036.method3299(3);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1441695222"
   )
   static void method200(int var0, String var1) {
      int var2 = class34.field760;
      int[] var3 = class34.field755;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(var6 != null && class48.localPlayer != var6 && null != var6.name && var6.name.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               Client.field323.method2818(176);
               Client.field323.method2589(var3[var5]);
               Client.field323.method2582(0);
            } else if(var0 == 4) {
               Client.field323.method2818(104);
               Client.field323.method2661(var3[var5]);
               Client.field323.method2582(0);
            } else if(var0 == 6) {
               Client.field323.method2818(241);
               Client.field323.method2758(0);
               Client.field323.method2588(var3[var5]);
            } else if(var0 == 7) {
               Client.field323.method2818(219);
               Client.field323.method2715(0);
               Client.field323.method2661(var3[var5]);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class23.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }
}
