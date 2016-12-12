import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class210 {
   @ObfuscatedName("w")
   static ModIcon[] field3113;
   @ObfuscatedName("i")
   public static class145 field3114;

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "-25252"
   )
   static final void method3868(boolean var0) {
      Client.field517 = 0;
      Client.field324 = 0;
      Client.field544.method2977();
      int var1 = Client.field544.method2978(8);
      int var2;
      if(var1 < Client.field322) {
         for(var2 = var1; var2 < Client.field322; ++var2) {
            Client.field412[++Client.field517 - 1] = Client.field323[var2];
         }
      }

      if(var1 > Client.field322) {
         throw new RuntimeException("");
      } else {
         Client.field322 = 0;

         int var5;
         int var6;
         int var7;
         int var8;
         for(var2 = 0; var2 < var1; ++var2) {
            int var10 = Client.field323[var2];
            NPC var4 = Client.cachedNPCs[var10];
            var5 = Client.field544.method2978(1);
            if(var5 == 0) {
               Client.field323[++Client.field322 - 1] = var10;
               var4.field647 = Client.gameCycle;
            } else {
               var6 = Client.field544.method2978(2);
               if(var6 == 0) {
                  Client.field323[++Client.field322 - 1] = var10;
                  var4.field647 = Client.gameCycle;
                  Client.field405[++Client.field324 - 1] = var10;
               } else if(var6 == 1) {
                  Client.field323[++Client.field322 - 1] = var10;
                  var4.field647 = Client.gameCycle;
                  var7 = Client.field544.method2978(3);
                  var4.method686(var7, (byte)1);
                  var8 = Client.field544.method2978(1);
                  if(var8 == 1) {
                     Client.field405[++Client.field324 - 1] = var10;
                  }
               } else if(var6 == 2) {
                  Client.field323[++Client.field322 - 1] = var10;
                  var4.field647 = Client.gameCycle;
                  var7 = Client.field544.method2978(3);
                  var4.method686(var7, (byte)2);
                  var8 = Client.field544.method2978(3);
                  var4.method686(var8, (byte)2);
                  int var9 = Client.field544.method2978(1);
                  if(var9 == 1) {
                     Client.field405[++Client.field324 - 1] = var10;
                  }
               } else if(var6 == 3) {
                  Client.field412[++Client.field517 - 1] = var10;
               }
            }
         }

         while(Client.field544.method2988(Client.field485) >= 27) {
            var1 = Client.field544.method2978(15);
            if(var1 == 32767) {
               break;
            }

            boolean var12 = false;
            if(null == Client.cachedNPCs[var1]) {
               Client.cachedNPCs[var1] = new NPC();
               var12 = true;
            }

            NPC var3 = Client.cachedNPCs[var1];
            Client.field323[++Client.field322 - 1] = var1;
            var3.field647 = Client.gameCycle;
            int var11 = Client.field544.method2978(1);
            if(var0) {
               var5 = Client.field544.method2978(8);
               if(var5 > 127) {
                  var5 -= 256;
               }
            } else {
               var5 = Client.field544.method2978(5);
               if(var5 > 15) {
                  var5 -= 32;
               }
            }

            var6 = Client.field544.method2978(1);
            if(var6 == 1) {
               Client.field405[++Client.field324 - 1] = var1;
            }

            var3.composition = TextureProvider.getNpcDefinition(Client.field544.method2978(14));
            if(var0) {
               var7 = Client.field544.method2978(8);
               if(var7 > 127) {
                  var7 -= 256;
               }
            } else {
               var7 = Client.field544.method2978(5);
               if(var7 > 15) {
                  var7 -= 32;
               }
            }

            var8 = Client.field417[Client.field544.method2978(3)];
            if(var12) {
               var3.field649 = var3.angle = var8;
            }

            var3.field640 = var3.composition.field3012;
            var3.field651 = var3.composition.field2998;
            if(var3.field651 == 0) {
               var3.angle = 0;
            }

            var3.field622 = var3.composition.field3003;
            var3.field646 = var3.composition.field3011;
            var3.field623 = var3.composition.field3001;
            var3.field609 = var3.composition.field3013;
            var3.idlePoseAnimation = var3.composition.field3007;
            var3.field656 = var3.composition.field3002;
            var3.field604 = var3.composition.field3010;
            var3.method677(class39.localPlayer.pathX[0] + var5, var7 + class39.localPlayer.pathY[0], var11 == 1);
         }

         Client.field544.method2982();
         class16.method177();

         for(var1 = 0; var1 < Client.field517; ++var1) {
            var2 = Client.field412[var1];
            if(Client.cachedNPCs[var2].field647 != Client.gameCycle) {
               Client.cachedNPCs[var2].composition = null;
               Client.cachedNPCs[var2] = null;
            }
         }

         if(Client.field544.offset != Client.field485) {
            throw new RuntimeException(Client.field544.offset + "," + Client.field485);
         } else {
            for(var1 = 0; var1 < Client.field322; ++var1) {
               if(Client.cachedNPCs[Client.field323[var1]] == null) {
                  throw new RuntimeException(var1 + "," + Client.field322);
               }
            }

         }
      }
   }
}
