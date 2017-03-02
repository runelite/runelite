import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class38 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1126981497
   )
   int field790;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 940009959
   )
   int field791;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -153130005
   )
   int field792;
   @ObfuscatedName("t")
   String field793;
   @ObfuscatedName("bg")
   static ModIcon field795;
   @ObfuscatedName("n")
   static class182 field796;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1389612261
   )
   int field797;

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "7915"
   )
   static final void method808(boolean var0) {
      Client.field408 = 0;
      Client.field325 = 0;
      Client.field329.method3141();
      int var1 = Client.field329.method3119(8);
      int var2;
      if(var1 < Client.field323) {
         for(var2 = var1; var2 < Client.field323; ++var2) {
            Client.field409[++Client.field408 - 1] = Client.field324[var2];
         }
      }

      if(var1 > Client.field323) {
         throw new RuntimeException("");
      } else {
         Client.field323 = 0;

         int var5;
         int var6;
         int var7;
         int var8;
         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = Client.field324[var2];
            NPC var4 = Client.cachedNPCs[var3];
            var5 = Client.field329.method3119(1);
            if(var5 == 0) {
               Client.field324[++Client.field323 - 1] = var3;
               var4.field617 = Client.gameCycle;
            } else {
               var6 = Client.field329.method3119(2);
               if(var6 == 0) {
                  Client.field324[++Client.field323 - 1] = var3;
                  var4.field617 = Client.gameCycle;
                  Client.field393[++Client.field325 - 1] = var3;
               } else if(var6 == 1) {
                  Client.field324[++Client.field323 - 1] = var3;
                  var4.field617 = Client.gameCycle;
                  var7 = Client.field329.method3119(3);
                  var4.method789(var7, (byte)1);
                  var8 = Client.field329.method3119(1);
                  if(var8 == 1) {
                     Client.field393[++Client.field325 - 1] = var3;
                  }
               } else if(var6 == 2) {
                  Client.field324[++Client.field323 - 1] = var3;
                  var4.field617 = Client.gameCycle;
                  var7 = Client.field329.method3119(3);
                  var4.method789(var7, (byte)2);
                  var8 = Client.field329.method3119(3);
                  var4.method789(var8, (byte)2);
                  int var9 = Client.field329.method3119(1);
                  if(var9 == 1) {
                     Client.field393[++Client.field325 - 1] = var3;
                  }
               } else if(var6 == 3) {
                  Client.field409[++Client.field408 - 1] = var3;
               }
            }
         }

         while(Client.field329.method3126(Client.field330) >= 27) {
            var1 = Client.field329.method3119(15);
            if(var1 == 32767) {
               break;
            }

            boolean var12 = false;
            if(null == Client.cachedNPCs[var1]) {
               Client.cachedNPCs[var1] = new NPC();
               var12 = true;
            }

            NPC var10 = Client.cachedNPCs[var1];
            Client.field324[++Client.field323 - 1] = var1;
            var10.field617 = Client.gameCycle;
            var10.composition = ChatLineBuffer.getNpcDefinition(Client.field329.method3119(14));
            int var11 = Client.field358[Client.field329.method3119(3)];
            if(var12) {
               var10.field652 = var10.angle = var11;
            }

            var5 = Client.field329.method3119(1);
            if(var5 == 1) {
               Client.field393[++Client.field325 - 1] = var1;
            }

            if(var0) {
               var6 = Client.field329.method3119(8);
               if(var6 > 127) {
                  var6 -= 256;
               }
            } else {
               var6 = Client.field329.method3119(5);
               if(var6 > 15) {
                  var6 -= 32;
               }
            }

            var7 = Client.field329.method3119(1);
            if(var0) {
               var8 = Client.field329.method3119(8);
               if(var8 > 127) {
                  var8 -= 256;
               }
            } else {
               var8 = Client.field329.method3119(5);
               if(var8 > 15) {
                  var8 -= 32;
               }
            }

            var10.field634 = var10.composition.field3012;
            var10.field654 = var10.composition.field3038;
            if(var10.field654 == 0) {
               var10.angle = 0;
            }

            var10.field627 = var10.composition.field3036;
            var10.field624 = var10.composition.field3019;
            var10.field611 = var10.composition.field3020;
            var10.field612 = var10.composition.field3021;
            var10.idlePoseAnimation = var10.composition.field3018;
            var10.field607 = var10.composition.field3016;
            var10.field608 = var10.composition.field3017;
            var10.method780(var8 + class9.localPlayer.pathX[0], class9.localPlayer.pathY[0] + var6, var7 == 1);
         }

         Client.field329.method3125();
         class206.method3924();

         for(var1 = 0; var1 < Client.field408; ++var1) {
            var2 = Client.field409[var1];
            if(Client.cachedNPCs[var2].field617 != Client.gameCycle) {
               Client.cachedNPCs[var2].composition = null;
               Client.cachedNPCs[var2] = null;
            }
         }

         if(Client.field329.offset != Client.field330) {
            throw new RuntimeException(Client.field329.offset + "," + Client.field330);
         } else {
            for(var1 = 0; var1 < Client.field323; ++var1) {
               if(Client.cachedNPCs[Client.field324[var1]] == null) {
                  throw new RuntimeException(var1 + "," + Client.field323);
               }
            }

         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-272655214"
   )
   public static final boolean method809() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         if(class105.field1693 == class105.field1708) {
            return false;
         } else {
            class20.field211 = class105.field1705[class105.field1708];
            class3.field32 = class105.field1704[class105.field1708];
            class105.field1708 = class105.field1708 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "-1434972745"
   )
   public static int method810(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var1 + var6);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var3[var4 + var6] = -128;
            } else if(var7 == 8218) {
               var3[var6 + var4] = -126;
            } else if(var7 == 402) {
               var3[var6 + var4] = -125;
            } else if(var7 == 8222) {
               var3[var6 + var4] = -124;
            } else if(var7 == 8230) {
               var3[var6 + var4] = -123;
            } else if(var7 == 8224) {
               var3[var6 + var4] = -122;
            } else if(var7 == 8225) {
               var3[var4 + var6] = -121;
            } else if(var7 == 710) {
               var3[var6 + var4] = -120;
            } else if(var7 == 8240) {
               var3[var4 + var6] = -119;
            } else if(var7 == 352) {
               var3[var6 + var4] = -118;
            } else if(var7 == 8249) {
               var3[var6 + var4] = -117;
            } else if(var7 == 338) {
               var3[var4 + var6] = -116;
            } else if(var7 == 381) {
               var3[var4 + var6] = -114;
            } else if(var7 == 8216) {
               var3[var6 + var4] = -111;
            } else if(var7 == 8217) {
               var3[var6 + var4] = -110;
            } else if(var7 == 8220) {
               var3[var6 + var4] = -109;
            } else if(var7 == 8221) {
               var3[var6 + var4] = -108;
            } else if(var7 == 8226) {
               var3[var4 + var6] = -107;
            } else if(var7 == 8211) {
               var3[var6 + var4] = -106;
            } else if(var7 == 8212) {
               var3[var4 + var6] = -105;
            } else if(var7 == 732) {
               var3[var6 + var4] = -104;
            } else if(var7 == 8482) {
               var3[var4 + var6] = -103;
            } else if(var7 == 353) {
               var3[var4 + var6] = -102;
            } else if(var7 == 8250) {
               var3[var4 + var6] = -101;
            } else if(var7 == 339) {
               var3[var6 + var4] = -100;
            } else if(var7 == 382) {
               var3[var4 + var6] = -98;
            } else if(var7 == 376) {
               var3[var6 + var4] = -97;
            } else {
               var3[var4 + var6] = 63;
            }
         } else {
            var3[var4 + var6] = (byte)var7;
         }
      }

      return var5;
   }
}
