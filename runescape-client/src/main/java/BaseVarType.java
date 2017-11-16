import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("BaseVarType")
public enum BaseVarType implements class185 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   @Export("INTEGER")
   INTEGER(2, 0, Integer.class, new class2()),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   @Export("LONG")
   LONG(1, 1, Long.class, new class3()),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   @Export("STRING")
   STRING(0, 2, String.class, new class5());

   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2048696935
   )
   final int field20;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1936524225
   )
   final int field18;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;Lb;)V"
   )
   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.field20 = var3;
      this.field18 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-4"
   )
   public int rsOrdinal() {
      return this.field18;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lbv;B)V",
      garbageValue = "-88"
   )
   public static void method11(ScriptEvent var0) {
      PlayerComposition.method3988(var0, 200000);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILeo;[Lfy;I)V",
      garbageValue = "-1642368980"
   )
   static final void method6(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.getUSmart();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.getUSmart();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
               ObjectComposition var21 = ClientPacket.getObjectDefinition(var11);
               int var24 = var16 & 7;
               int var25 = var15 & 7;
               int var27 = var21.sizeX;
               int var28 = var21.sizeY;
               int var29;
               if((var20 & 1) == 1) {
                  var29 = var27;
                  var27 = var28;
                  var28 = var29;
               }

               int var26 = var7 & 3;
               int var23;
               if(var26 == 0) {
                  var23 = var24;
               } else if(var26 == 1) {
                  var23 = var25;
               } else if(var26 == 2) {
                  var23 = 7 - var24 - (var27 - 1);
               } else {
                  var23 = 7 - var25 - (var28 - 1);
               }

               var29 = var2 + var23;
               int var32 = var16 & 7;
               int var33 = var15 & 7;
               int var35 = var21.sizeX;
               int var36 = var21.sizeY;
               int var37;
               if((var20 & 1) == 1) {
                  var37 = var35;
                  var35 = var36;
                  var36 = var37;
               }

               int var34 = var7 & 3;
               int var31;
               if(var34 == 0) {
                  var31 = var33;
               } else if(var34 == 1) {
                  var31 = 7 - var32 - (var35 - 1);
               } else if(var34 == 2) {
                  var31 = 7 - var33 - (var36 - 1);
               } else {
                  var31 = var32;
               }

               var37 = var31 + var3;
               if(var29 > 0 && var37 > 0 && var29 < 103 && var37 < 103) {
                  int var38 = var1;
                  if((class61.tileSettings[1][var29][var37] & 2) == 2) {
                     var38 = var1 - 1;
                  }

                  CollisionData var39 = null;
                  if(var38 >= 0) {
                     var39 = var9[var38];
                  }

                  class22.addObject(var1, var29, var37, var11, var20 + var7 & 3, var19, var8, var39);
               }
            }
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-170017801"
   )
   static int method9(int var0) {
      MessageNode var1 = (MessageNode)class96.field1425.get((long)var0);
      return var1 == null?-1:(var1.previous == class96.field1424.field2574?-1:((MessageNode)var1.previous).id);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1608206227"
   )
   static void method14(String var0, String var1, String var2) {
      class91.loginMessage1 = var0;
      class91.loginMessage2 = var1;
      class91.loginMessage3 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "62"
   )
   static final int method10(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-61"
   )
   static final void method12() {
      for(int var0 = 0; var0 < Client.field1031; ++var0) {
         --Client.field1086[var0];
         if(Client.field1086[var0] >= -10) {
            SoundEffect var9 = Client.audioEffects[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = SoundEffect.getTrack(class23.field326, Client.field956[var0], 0);
               if(var9 == null) {
                  continue;
               }

               Client.field1086[var0] += var9.calculateDelay();
               Client.audioEffects[var0] = var9;
            }

            if(Client.field1086[var0] < 0) {
               int var2;
               if(Client.field1092[var0] != 0) {
                  int var3 = (Client.field1092[var0] & 255) * 128;
                  int var4 = Client.field1092[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - class275.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field1092[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - class275.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var7 + var5 - 128;
                  if(var8 > var3) {
                     Client.field1086[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field1051 / var3;
               } else {
                  var2 = Client.field1085;
               }

               if(var2 > 0) {
                  class106 var10 = var9.method1936().method1991(class39.field497);
                  class116 var11 = class116.method2145(var10, 100, var2);
                  var11.method2191(Client.field986[var0] - 1);
                  Client.field1087.method1914(var11);
               }

               Client.field1086[var0] = -100;
            }
         } else {
            --Client.field1031;

            for(int var1 = var0; var1 < Client.field1031; ++var1) {
               Client.field956[var1] = Client.field956[var1 + 1];
               Client.audioEffects[var1] = Client.audioEffects[var1 + 1];
               Client.field986[var1] = Client.field986[var1 + 1];
               Client.field1086[var1] = Client.field1086[var1 + 1];
               Client.field1092[var1] = Client.field1092[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field1084 && !class29.method219()) {
         if(Client.field945 != 0 && Client.field1083 != -1) {
            class226.method4079(class45.indexTrack1, Client.field1083, 0, Client.field945, false);
         }

         Client.field1084 = false;
      }

   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(Lhx;B)Z",
      garbageValue = "75"
   )
   static final boolean method13(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field906 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1119.method3983(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1119.method3984(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1119.method3985(false);
         }

         if(var1 == 325) {
            Client.field1119.method3985(true);
         }

         if(var1 == 326) {
            PacketNode var4 = class18.method133(ClientPacket.field2338, Client.field905.field1460);
            Client.field1119.method3986(var4.packetBuffer);
            Client.field905.method1855(var4);
            return true;
         } else {
            return false;
         }
      }
   }
}
