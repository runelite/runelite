import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class162 {
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = 1379177357
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("n")
   static final String[] field2147 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("g")
   static Calendar field2148;
   @ObfuscatedName("ek")
   static SpritePixels[] field2150;
   @ObfuscatedName("x")
   static final String[][] field2153 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1961358165"
   )
   static final void method3180(boolean var0) {
      while(true) {
         if(Client.field334.method3149(Client.field335) >= 27) {
            int var1 = Client.field334.method3147(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(Client.cachedNPCs[var1] == null) {
                  Client.cachedNPCs[var1] = new NPC();
                  var2 = true;
               }

               NPC var3 = Client.cachedNPCs[var1];
               Client.field285[++Client.field328 - 1] = var1;
               var3.field622 = Client.gameCycle;
               int var4 = Client.field334.method3147(1);
               if(var4 == 1) {
                  Client.field331[++Client.field513 - 1] = var1;
               }

               int var5;
               if(var0) {
                  var5 = Client.field334.method3147(8);
                  if(var5 > 127) {
                     var5 -= 256;
                  }
               } else {
                  var5 = Client.field334.method3147(5);
                  if(var5 > 15) {
                     var5 -= 32;
                  }
               }

               int var6;
               if(var0) {
                  var6 = Client.field334.method3147(8);
                  if(var6 > 127) {
                     var6 -= 256;
                  }
               } else {
                  var6 = Client.field334.method3147(5);
                  if(var6 > 15) {
                     var6 -= 32;
                  }
               }

               var3.composition = class159.getNpcDefinition(Client.field334.method3147(14));
               int var7 = Client.field334.method3147(1);
               int var8 = Client.field417[Client.field334.method3147(3)];
               if(var2) {
                  var3.field654 = var3.angle = var8;
               }

               var3.field607 = var3.composition.field3040;
               var3.field656 = var3.composition.field3035;
               if(var3.field656 == 0) {
                  var3.angle = 0;
               }

               var3.field632 = var3.composition.field3011;
               var3.field612 = var3.composition.field3019;
               var3.field603 = var3.composition.field3029;
               var3.field614 = var3.composition.field3021;
               var3.idlePoseAnimation = var3.composition.field3015;
               var3.field610 = var3.composition.field3016;
               var3.field621 = var3.composition.field3017;
               var3.method796(WidgetNode.localPlayer.pathX[0] + var5, var6 + WidgetNode.localPlayer.pathY[0], var7 == 1);
               continue;
            }
         }

         Client.field334.method3148();
         return;
      }
   }

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2148 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass110;ZI)V",
      garbageValue = "-1628006623"
   )
   public static void method3183(class110 var0, boolean var1) {
      if(class185.field2757 != null) {
         try {
            class185.field2757.method2139();
         } catch (Exception var6) {
            ;
         }

         class185.field2757 = null;
      }

      class185.field2757 = var0;
      class172.method3331(var1);
      class185.field2758.offset = 0;
      class210.field3130 = null;
      ChatMessages.field939 = null;
      class185.field2746 = 0;

      while(true) {
         class181 var2 = (class181)class185.field2766.method2440();
         if(var2 == null) {
            while(true) {
               var2 = (class181)class185.field2759.method2440();
               if(null == var2) {
                  if(class185.field2763 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.method2873(4);
                        var7.method2873(class185.field2763);
                        var7.method2872(0);
                        class185.field2757.method2148(var7.payload, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class185.field2757.method2139();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class185.field2747;
                        class185.field2757 = null;
                     }
                  }

                  class185.field2764 = 0;
                  class185.field2748 = WallObject.method1985();
                  return;
               }

               class185.field2756.method2390(var2);
               class185.field2754.method2438(var2, var2.hash);
               ++class185.field2755;
               --class185.field2751;
            }
         }

         class185.field2749.method2438(var2, var2.hash);
         ++class185.field2750;
         --class185.field2752;
      }
   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIB)V",
      garbageValue = "4"
   )
   static final void method3184(Widget var0, int var1, int var2, int var3) {
      class164 var4 = var0.method3289(false);
      if(var4 != null) {
         if(Client.field526 < 3) {
            Projectile.field884.method4220(var1, var2, var4.field2160, var4.field2155, 25, 25, Client.mapAngle, 256, var4.field2157, var4.field2156);
         } else {
            Rasterizer2D.method4031(var1, var2, 0, var4.field2157, var4.field2156);
         }

      }
   }

   class162() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2097017893"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(null == class22.worldServersDownload) {
            class22.worldServersDownload = new class26(class114.field1793, new URL(XClanMember.field278));
         } else {
            byte[] var0 = class22.worldServersDownload.method617();
            if(var0 != null) {
               Buffer var1 = new Buffer(var0);
               World.field675 = var1.readUnsignedShort();
               CombatInfoListHolder.worldList = new World[World.field675];

               World var3;
               for(int var2 = 0; var2 < World.field675; var3.index = var2++) {
                  var3 = CombatInfoListHolder.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.readInt();
                  var3.address = var1.readString();
                  var3.activity = var1.readString();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.readShort();
               }

               class7.method100(CombatInfoListHolder.worldList, 0, CombatInfoListHolder.worldList.length - 1, World.field678, World.field684);
               class22.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class22.worldServersDownload = null;
      }

      return false;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;B)LModIcon;",
      garbageValue = "32"
   )
   public static ModIcon method3186(class182 var0, String var1, String var2) {
      int var3 = var0.method3426(var1);
      int var4 = var0.method3370(var3, var2);
      return class72.method1484(var0, var3, var4);
   }
}
