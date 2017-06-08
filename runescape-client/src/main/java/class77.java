import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class77 {
   @ObfuscatedName("j")
   DataInputStream field1216;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 807155665
   )
   int field1217;
   @ObfuscatedName("i")
   byte[] field1219;
   @ObfuscatedName("p")
   class153 field1220;
   @ObfuscatedName("m")
   byte[] field1221;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1777960377
   )
   int field1222;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = -3005504869311883321L
   )
   long field1223;
   @ObfuscatedName("cq")
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1904932419
   )
   int field1225;

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1041218090"
   )
   static final void method1483(int var0) {
      class40.method543();

      for(class82 var4 = (class82)class82.field1325.method3622(); var4 != null; var4 = (class82)class82.field1325.method3608()) {
         if(var4.field1336 != null) {
            var4.method1576();
         }
      }

      int var1 = Item.method1741(var0).field3292;
      if(var1 != 0) {
         int var2 = class211.widgetSettings[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class136.method2599(0.9D);
               ((TextureProvider)class136.field2039).method2400(0.9D);
            }

            if(var2 == 2) {
               class136.method2599(0.8D);
               ((TextureProvider)class136.field2039).method2400(0.8D);
            }

            if(var2 == 3) {
               class136.method2599(0.7D);
               ((TextureProvider)class136.field2039).method2400(0.7D);
            }

            if(var2 == 4) {
               class136.method2599(0.6D);
               ((TextureProvider)class136.field2039).method2400(0.6D);
            }

            class5.method15();
         }

         if(var1 == 3) {
            short var5 = 0;
            if(var2 == 0) {
               var5 = 255;
            }

            if(var2 == 1) {
               var5 = 192;
            }

            if(var2 == 2) {
               var5 = 128;
            }

            if(var2 == 3) {
               var5 = 64;
            }

            if(var2 == 4) {
               var5 = 0;
            }

            if(Client.field1030 != var5) {
               if(Client.field1030 == 0 && Client.field1153 != -1) {
                  class182.method3430(class54.indexTrack1, Client.field1153, 0, var5, false);
                  Client.field1154 = false;
               } else if(var5 == 0) {
                  class203.field2517.method3728();
                  class203.field2515 = 1;
                  class203.field2516 = null;
                  Client.field1154 = false;
               } else {
                  class44.method613(var5);
               }

               Client.field1030 = var5;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field1155 = 127;
            }

            if(var2 == 1) {
               Client.field1155 = 96;
            }

            if(var2 == 2) {
               Client.field1155 = 64;
            }

            if(var2 == 3) {
               Client.field1155 = 32;
            }

            if(var2 == 4) {
               Client.field1155 = 0;
            }
         }

         if(var1 == 5) {
            Client.field1052 = var2;
         }

         if(var1 == 6) {
            Client.field1078 = var2;
         }

         if(var1 == 9) {
            Client.field1079 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field1005 = 127;
            }

            if(var2 == 1) {
               Client.field1005 = 96;
            }

            if(var2 == 2) {
               Client.field1005 = 64;
            }

            if(var2 == 3) {
               Client.field1005 = 32;
            }

            if(var2 == 4) {
               Client.field1005 = 0;
            }
         }

         if(var1 == 17) {
            Client.field1025 = var2 & '\uffff';
         }

         class91[] var3;
         if(var1 == 18) {
            var3 = new class91[]{class91.field1414, class91.field1412, class91.field1410, class91.field1411};
            Client.field998 = (class91)Projectile.method1737(var3, var2);
            if(Client.field998 == null) {
               Client.field998 = class91.field1412;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field1044 = -1;
            } else {
               Client.field1044 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            var3 = new class91[]{class91.field1414, class91.field1412, class91.field1410, class91.field1411};
            Client.field939 = (class91)Projectile.method1737(var3, var2);
            if(Client.field939 == null) {
               Client.field939 = class91.field1412;
            }
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "56"
   )
   byte[] method1484() throws IOException {
      if(class134.method2587() > this.field1223) {
         throw new IOException();
      } else {
         if(this.field1217 == 0) {
            if(this.field1220.field2236 == 2) {
               throw new IOException();
            }

            if(this.field1220.field2236 == 1) {
               this.field1216 = (DataInputStream)this.field1220.field2240;
               this.field1217 = 1;
            }
         }

         if(this.field1217 == 1) {
            this.field1225 += this.field1216.read(this.field1219, this.field1225, this.field1219.length - this.field1225);
            if(this.field1225 == 4) {
               int var1 = (new Buffer(this.field1219)).readInt();
               this.field1221 = new byte[var1];
               this.field1217 = 2;
            }
         }

         if(this.field1217 == 2) {
            this.field1222 += this.field1216.read(this.field1221, this.field1222, this.field1221.length - this.field1222);
            if(this.field1221.length == this.field1222) {
               return this.field1221;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1017161952"
   )
   static int method1485(int var0, int var1) {
      Overlay var2 = class5.method17(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.field3600 >= 0) {
         return var2.field3600 | -16777216;
      } else if(var2.texture >= 0) {
         int var3 = class51.method748(class136.field2039.vmethod2887(var2.texture), 96);
         return class136.colorPalette[var3] | -16777216;
      } else if(var2.color == 16711935) {
         return var1;
      } else {
         int var4 = var2.hue;
         int var5 = var2.saturation;
         int var6 = var2.lightness;
         if(var6 > 179) {
            var5 /= 2;
         }

         if(var6 > 192) {
            var5 /= 2;
         }

         if(var6 > 217) {
            var5 /= 2;
         }

         if(var6 > 243) {
            var5 /= 2;
         }

         int var7 = (var5 / 32 << 7) + (var4 / 4 << 10) + var6 / 2;
         int var8 = class51.method748(var7, 96);
         return class136.colorPalette[var8] | -16777216;
      }
   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "564131390"
   )
   static void method1488() {
      Client.secretPacketBuffer1.putOpcode(53);
      Client.secretPacketBuffer1.putByte(class140.method2868());
      Client.secretPacketBuffer1.putShort(class174.field2408);
      Client.secretPacketBuffer1.putShort(class2.field21);
   }

   class77(class154 var1, URL var2) {
      this.field1219 = new byte[4];
      this.field1220 = var1.method2946(var2);
      this.field1217 = 0;
      this.field1223 = class134.method2587() + 30000L;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)J",
      garbageValue = "329032500"
   )
   static long method1490(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(var5 + 1 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var1 % 37L && var1 != 0L) {
         var1 /= 37L;
      }

      return var1;
   }
}
