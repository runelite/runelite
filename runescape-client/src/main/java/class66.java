import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class66 {
   @ObfuscatedName("c")
   static final class66 field823;
   @ObfuscatedName("bf")
   static String field824;
   @ObfuscatedName("e")
   static final class66 field825;
   @ObfuscatedName("v")
   static final class66 field826;
   @ObfuscatedName("i")
   static final class66 field827;

   @ObfuscatedName("eq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1642469705"
   )
   static final void method1077() {
      if(ScriptState.rssocket != null) {
         ScriptState.rssocket.method2981();
         ScriptState.rssocket = null;
      }

      class10.method48();
      class1.region.method2674();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method3022();
      }

      System.gc();
      class84.method1668(2);
      Client.field1166 = -1;
      Client.field1123 = false;

      for(class82 var1 = (class82)class82.field1348.method3576(); var1 != null; var1 = (class82)class82.field1348.method3578()) {
         if(var1.field1341 != null) {
            class158.field2288.method1871(var1.field1341);
            var1.field1341 = null;
         }

         if(var1.field1353 != null) {
            class158.field2288.method1871(var1.field1353);
            var1.field1353 = null;
         }
      }

      class82.field1348.method3569();
      class249.setGameState(10);
   }

   static {
      field827 = new class66();
      field823 = new class66();
      field825 = new class66();
      field826 = new class66();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-495709031"
   )
   public static void method1078(int var0) {
      if(class203.field2514 != 0) {
         class151.field2229 = var0;
      } else {
         class203.field2511.method3668(var0);
      }

   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-47"
   )
   static final void method1079(int var0, int var1, int var2, int var3) {
      Client.field1023 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class96.field1507;
      int[] var7 = class96.field1508;

      int var8;
      for(var8 = 0; var8 < var6 + Client.field968; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = Client.cachedPlayers[var7[var8]];
            if(var7[var8] == Client.field1059) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = Client.cachedNPCs[Client.field950[var8 - var6]];
         }

         class204.method3782((Actor)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class204.method3782(Client.cachedPlayers[Client.field1059], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < Client.field1023; ++var8) {
         int var18 = Client.field1025[var8];
         int var10 = Client.field1095[var8];
         int var11 = Client.field998[var8];
         int var12 = Client.field1027[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(var10 + 2 > Client.field1095[var14] - Client.field1027[var14] && var10 - var12 < Client.field1095[var14] + 2 && var18 - var11 < Client.field1025[var14] + Client.field998[var14] && var18 + var11 > Client.field1025[var14] - Client.field998[var14] && Client.field1095[var14] - Client.field1027[var14] < var10) {
                  var10 = Client.field1095[var14] - Client.field1027[var14];
                  var13 = true;
               }
            }
         }

         Client.field1124 = Client.field1025[var8];
         Client.field1093 = Client.field1095[var8] = var10;
         String var19 = Client.field1032[var8];
         if(Client.field1092 == 0) {
            int var15 = 16776960;
            if(Client.field1017[var8] < 6) {
               var15 = Client.field1145[Client.field1017[var8]];
            }

            if(Client.field1017[var8] == 6) {
               var15 = Client.field1034 % 20 < 10?16711680:16776960;
            }

            if(Client.field1017[var8] == 7) {
               var15 = Client.field1034 % 20 < 10?255:'\uffff';
            }

            if(Client.field1017[var8] == 8) {
               var15 = Client.field1034 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(Client.field1017[var8] == 9) {
               var16 = 150 - Client.field1024[var8];
               if(var16 < 50) {
                  var15 = var16 * 1280 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16776960 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 5 + '\uff00';
               }
            }

            if(Client.field1017[var8] == 10) {
               var16 = 150 - Client.field1024[var8];
               if(var16 < 50) {
                  var15 = var16 * 5 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16711935 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 327680 + 255 - (var16 - 100) * 5;
               }
            }

            if(Client.field1017[var8] == 11) {
               var16 = 150 - Client.field1024[var8];
               if(var16 < 50) {
                  var15 = 16777215 - var16 * 327685;
               } else if(var16 < 100) {
                  var15 = (var16 - 50) * 327685 + '\uff00';
               } else if(var16 < 150) {
                  var15 = 16777215 - (var16 - 100) * 327680;
               }
            }

            if(Client.field1030[var8] == 0) {
               XClanMember.field922.method4736(var19, var0 + Client.field1124, var1 + Client.field1093, var15, 0);
            }

            if(Client.field1030[var8] == 1) {
               XClanMember.field922.method4738(var19, Client.field1124 + var0, Client.field1093 + var1, var15, 0, Client.field1034);
            }

            if(Client.field1030[var8] == 2) {
               XClanMember.field922.method4739(var19, var0 + Client.field1124, var1 + Client.field1093, var15, 0, Client.field1034);
            }

            if(Client.field1030[var8] == 3) {
               XClanMember.field922.method4740(var19, Client.field1124 + var0, var1 + Client.field1093, var15, 0, Client.field1034, 150 - Client.field1024[var8]);
            }

            if(Client.field1030[var8] == 4) {
               var16 = (150 - Client.field1024[var8]) * (XClanMember.field922.method4728(var19) + 100) / 150;
               Rasterizer2D.method4956(var0 + Client.field1124 - 50, var1, Client.field1124 + var0 + 50, var1 + var3);
               XClanMember.field922.method4737(var19, var0 + Client.field1124 + 50 - var16, Client.field1093 + var1, var15, 0);
               Rasterizer2D.method4940(var0, var1, var0 + var2, var1 + var3);
            }

            if(Client.field1030[var8] == 5) {
               var16 = 150 - Client.field1024[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               Rasterizer2D.method4956(var0, Client.field1093 + var1 - XClanMember.field922.field3652 - 1, var0 + var2, var1 + Client.field1093 + 5);
               XClanMember.field922.method4736(var19, var0 + Client.field1124, Client.field1093 + var1 + var17, var15, 0);
               Rasterizer2D.method4940(var0, var1, var2 + var0, var1 + var3);
            }
         } else {
            XClanMember.field922.method4736(var19, var0 + Client.field1124, Client.field1093 + var1, 16776960, 0);
         }
      }

   }
}
