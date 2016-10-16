import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class190 extends Node {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -739201667
   )
   int field3055;
   @ObfuscatedName("y")
   class188 field3056;
   @ObfuscatedName("t")
   class65 field3057;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -858217287
   )
   int field3058;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2036010527
   )
   int field3059;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -431356487
   )
   int field3060;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -169859855
   )
   int field3061;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1145126175
   )
   int field3062;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -957985165
   )
   int field3063;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -230763107
   )
   int field3064;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1797625439
   )
   int field3065;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -555314385
   )
   int field3066;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 785053353
   )
   int field3067;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1134279153
   )
   int field3068;
   @ObfuscatedName("z")
   class184 field3069;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1584147439
   )
   int field3070;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1742734059
   )
   int field3071;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1102301647
   )
   int field3072;
   @ObfuscatedName("o")
   class67 field3073;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -611464529
   )
   int field3074;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -56955741
   )
   int field3075;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   void method3731() {
      this.field3069 = null;
      this.field3057 = null;
      this.field3056 = null;
      this.field3073 = null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BI)Lclass227;",
      garbageValue = "-1093359800"
   )
   public static class227 method3732(byte[] var0) {
      if(null == var0) {
         return null;
      } else {
         class227 var1 = new class227(var0, class79.field1419, XClanMember.field612, class79.field1420, class8.field129, class117.field2002, class220.field3211);
         class23.method571();
         return var1;
      }
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "354617918"
   )
   static final void method3733(boolean var0) {
      Client.field393 = 0;
      Client.field308 = 0;
      Client.field312.method2750();
      int var1 = Client.field312.method2762(8);
      int var2;
      if(var1 < Client.field309) {
         for(var2 = var1; var2 < Client.field309; ++var2) {
            Client.field394[++Client.field393 - 1] = Client.field307[var2];
         }
      }

      if(var1 > Client.field309) {
         throw new RuntimeException("");
      } else {
         Client.field309 = 0;

         int var5;
         int var6;
         int var7;
         int var8;
         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = Client.field307[var2];
            NPC var4 = Client.cachedNPCs[var3];
            var5 = Client.field312.method2762(1);
            if(var5 == 0) {
               Client.field307[++Client.field309 - 1] = var3;
               var4.field801 = Client.gameCycle;
            } else {
               var6 = Client.field312.method2762(2);
               if(var6 == 0) {
                  Client.field307[++Client.field309 - 1] = var3;
                  var4.field801 = Client.gameCycle;
                  Client.field418[++Client.field308 - 1] = var3;
               } else if(var6 == 1) {
                  Client.field307[++Client.field309 - 1] = var3;
                  var4.field801 = Client.gameCycle;
                  var7 = Client.field312.method2762(3);
                  var4.method734(var7, (byte)1);
                  var8 = Client.field312.method2762(1);
                  if(var8 == 1) {
                     Client.field418[++Client.field308 - 1] = var3;
                  }
               } else if(var6 == 2) {
                  Client.field307[++Client.field309 - 1] = var3;
                  var4.field801 = Client.gameCycle;
                  var7 = Client.field312.method2762(3);
                  var4.method734(var7, (byte)2);
                  var8 = Client.field312.method2762(3);
                  var4.method734(var8, (byte)2);
                  int var9 = Client.field312.method2762(1);
                  if(var9 == 1) {
                     Client.field418[++Client.field308 - 1] = var3;
                  }
               } else if(var6 == 3) {
                  Client.field394[++Client.field393 - 1] = var3;
               }
            }
         }

         while(Client.field312.method2753(Client.field313) >= 27) {
            var1 = Client.field312.method2762(15);
            if(var1 == 32767) {
               break;
            }

            boolean var12 = false;
            if(null == Client.cachedNPCs[var1]) {
               Client.cachedNPCs[var1] = new NPC();
               var12 = true;
            }

            NPC var10 = Client.cachedNPCs[var1];
            Client.field307[++Client.field309 - 1] = var1;
            var10.field801 = Client.gameCycle;
            int var11 = Client.field312.method2762(1);
            if(var11 == 1) {
               Client.field418[++Client.field308 - 1] = var1;
            }

            if(var0) {
               var5 = Client.field312.method2762(8);
               if(var5 > 127) {
                  var5 -= 256;
               }
            } else {
               var5 = Client.field312.method2762(5);
               if(var5 > 15) {
                  var5 -= 32;
               }
            }

            var6 = Client.field312.method2762(1);
            if(var0) {
               var7 = Client.field312.method2762(8);
               if(var7 > 127) {
                  var7 -= 256;
               }
            } else {
               var7 = Client.field312.method2762(5);
               if(var7 > 15) {
                  var7 -= 32;
               }
            }

            var8 = Client.field398[Client.field312.method2762(3)];
            if(var12) {
               var10.angle = var8 * 1672533163;
               var10.field852 = var8;
            }

            var10.composition = class127.getNpcDefinition(Client.field312.method2762(14));
            var10.field805 = var10.composition.field902;
            var10.field854 = var10.composition.field896;
            if(var10.field854 == 0) {
               var10.angle = 0;
            }

            var10.field813 = var10.composition.field899;
            var10.field802 = var10.composition.field879;
            var10.field808 = var10.composition.field888;
            var10.field861 = var10.composition.field882;
            var10.idlePoseAnimation = var10.composition.field876;
            var10.field807 = var10.composition.field877;
            var10.field806 = var10.composition.field878;
            var10.method744(var7 + TextureProvider.localPlayer.pathX[0], var5 + TextureProvider.localPlayer.pathY[0], var6 == 1);
         }

         Client.field312.method2751();
         class14.method171();

         for(var1 = 0; var1 < Client.field393; ++var1) {
            var2 = Client.field394[var1];
            if(Client.cachedNPCs[var2].field801 != Client.gameCycle) {
               Client.cachedNPCs[var2].composition = null;
               Client.cachedNPCs[var2] = null;
            }
         }

         if(Client.field312.offset != Client.field313) {
            throw new RuntimeException(Client.field312.offset + "," + Client.field313);
         } else {
            for(var1 = 0; var1 < Client.field309; ++var1) {
               if(Client.cachedNPCs[Client.field307[var1]] == null) {
                  throw new RuntimeException(var1 + "," + Client.field309);
               }
            }

         }
      }
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "250068075"
   )
   static void method3734() {
      if(Client.field270) {
         Widget var0 = class163.method3174(class144.field2208, Client.field269);
         if(var0 != null && null != var0.field2883) {
            class0 var1 = new class0();
            var1.field2 = var0;
            var1.field5 = var0.field2883;
            MessageNode.method754(var1);
         }

         Client.field270 = false;
         class32.method685(var0);
      }
   }
}
