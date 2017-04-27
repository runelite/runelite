import java.awt.Component;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
public class class199 extends CacheableNode {
   @ObfuscatedName("q")
   public static int[] field2877;
   @ObfuscatedName("c")
   public static NodeCache field2878 = new NodeCache(64);
   @ObfuscatedName("n")
   class142 field2879;
   @ObfuscatedName("s")
   public static class183 field2881;
   @ObfuscatedName("br")
   static IndexData field2882;
   @ObfuscatedName("d")
   public static IndexDataBase field2883;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-15237"
   )
   public void method3601() {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "23"
   )
   public void method3602(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3612(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1811266246"
   )
   public int method3604(int var1, int var2) {
      return IndexData.method3408(this.field2879, var1, var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-514205239"
   )
   public String method3605(int var1, String var2) {
      return class164.method3100(this.field2879, var1, var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "569128978"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class132.worldServersDownload == null) {
            class132.worldServersDownload = new class26(class45.field896, new URL(class7.field64));
         } else {
            byte[] var0 = class132.worldServersDownload.method575();
            if(var0 != null) {
               Buffer var1 = new Buffer(var0);
               World.field669 = var1.readUnsignedShort();
               World.worldList = new World[World.field669];

               World var3;
               for(int var2 = 0; var2 < World.field669; var3.index = var2++) {
                  var3 = World.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.readInt();
                  var3.address = var1.readString();
                  var3.activity = var1.readString();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.readShort();
               }

               class26.method574(World.worldList, 0, World.worldList.length - 1, World.field676, World.field675);
               class132.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class132.worldServersDownload = null;
      }

      return false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;LIndexDataBase;LIndexDataBase;ZII)V",
      garbageValue = "598155257"
   )
   static void method3611(Component var0, IndexDataBase var1, IndexDataBase var2, boolean var3, int var4) {
      if(class41.field836) {
         if(var4 == 4) {
            class41.loginIndex = 4;
         }

      } else {
         class41.loginIndex = var4;
         Rasterizer2D.method4123();
         byte[] var5 = var1.method3311("title.jpg", "");
         class41.field815 = new SpritePixels(var5, var0);
         class41.field816 = class41.field815.method4218();
         if((Client.flags & 536870912) != 0) {
            class41.field844 = class173.method3258(var2, "logo_deadman_mode", "");
         } else {
            class41.field844 = class173.method3258(var2, "logo", "");
         }

         class41.field813 = class173.method3258(var2, "titlebox", "");
         class41.field814 = class173.method3258(var2, "titlebutton", "");
         class126.field1909 = class210.method4011(var2, "runes", "");
         class13.field143 = class210.method4011(var2, "title_mute", "");
         class39.field797 = class173.method3258(var2, "options_radio_buttons,0", "");
         class41.field831 = class173.method3258(var2, "options_radio_buttons,2", "");
         class31.field697 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class31.field697[var6] = var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field697[var6 + 64] = var6 * 1024 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field697[var6 + 128] = var6 * 4 + 16776960;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field697[var6 + 192] = 16777215;
         }

         class41.field811 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field811[var6] = var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field811[var6 + 64] = var6 * 4 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field811[var6 + 128] = var6 * 262144 + '\uffff';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field811[var6 + 192] = 16777215;
         }

         class183.field2706 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class183.field2706[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class183.field2706[var6 + 64] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class183.field2706[var6 + 128] = var6 * 1024 + 16711935;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class183.field2706[var6 + 192] = 16777215;
         }

         class61.field1072 = new int[256];
         class94.field1580 = new int['耀'];
         class32.field729 = new int['耀'];
         class59.method1138((ModIcon)null);
         class2.field24 = new int['耀'];
         class133.field1983 = new int['耀'];
         if(var3) {
            class41.username = "";
            class41.password = "";
         }

         class122.authCodeForLogin = 0;
         class94.authCode = "";
         class41.field843 = true;
         class41.worldSelectShown = false;
         if(!Actor.field656.field691) {
            IndexData var9 = class18.indexTrack1;
            int var7 = var9.method3296("scape main");
            int var8 = var9.method3310(var7, "");
            class159.field2063 = 1;
            class159.field2067 = var9;
            PacketBuffer.field1989 = var7;
            class190.field2791 = var8;
            class159.field2069 = 255;
            class15.field164 = false;
            WallObject.field1543 = 2;
         } else {
            GameEngine.method2202(2);
         }

         class112.method2101(false);
         class41.field836 = true;
         class41.field821 = (class187.field2760 - Client.field293) / 2;
         class41.loginWindowX = class41.field821 + 202;
         class41.field815.method4295(class41.field821, 0);
         class41.field816.method4295(class41.field821 + 382, 0);
         class41.field844.method4170(class41.field821 + 382 - class41.field844.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1310741570"
   )
   void method3612(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field2879 = class180.method3283(var1, this.field2879);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;III)Z",
      garbageValue = "-1283136065"
   )
   static boolean method3620(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class172.method3255(var3);
         return true;
      }
   }
}
