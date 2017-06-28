import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class1 {
   @ObfuscatedName("m")
   static final class1 field1;
   @ObfuscatedName("t")
   static final class1 field3;
   @ObfuscatedName("ae")
   static java.awt.Font field4;
   @ObfuscatedName("z")
   static final class1 field5;
   @ObfuscatedName("j")
   static final class1 field6;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 91411141
   )
   final int field7;
   @ObfuscatedName("p")
   static final class1 field8;
   @ObfuscatedName("e")
   static final class1 field10;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1839408321
   )
   @Export("canvasHeight")
   protected static int canvasHeight;
   @ObfuscatedName("w")
   static final class1 field12;
   @ObfuscatedName("gp")
   static ModIcon[] field13;

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "16180521"
   )
   static final void method0(boolean var0) {
      Client.field1029 = 0;
      Client.field1096 = 0;
      MessageNode.method1055();
      WidgetNode.method1031(var0);

      int var1;
      int var2;
      for(var1 = 0; var1 < Client.field1096; ++var1) {
         var2 = Client.field946[var1];
         NPC var3 = Client.cachedNPCs[var2];
         int var4 = Client.secretPacketBuffer2.readUnsignedByte();
         int var5;
         int var6;
         int var7;
         int var8;
         if((var4 & 16) != 0) {
            var5 = Client.secretPacketBuffer2.readUnsignedShortOb1();
            var6 = Client.secretPacketBuffer2.readUnsignedShort();
            var7 = var3.x - (var5 - class19.baseX - class19.baseX) * 64;
            var8 = var3.y - (var6 - class21.baseY - class21.baseY) * 64;
            if(var7 != 0 || var8 != 0) {
               var3.field1236 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }

         if((var4 & 2) != 0) {
            var5 = Client.secretPacketBuffer2.readUnsignedByte();
            int var9;
            int var10;
            int var11;
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var8 = -1;
                  var9 = -1;
                  var10 = -1;
                  var7 = Client.secretPacketBuffer2.method3046();
                  if(var7 == 32767) {
                     var7 = Client.secretPacketBuffer2.method3046();
                     var9 = Client.secretPacketBuffer2.method3046();
                     var8 = Client.secretPacketBuffer2.method3046();
                     var10 = Client.secretPacketBuffer2.method3046();
                  } else if(var7 != 32766) {
                     var9 = Client.secretPacketBuffer2.method3046();
                  } else {
                     var7 = -1;
                  }

                  var11 = Client.secretPacketBuffer2.method3046();
                  var3.method1443(var7, var9, var8, var10, Client.gameCycle, var11);
               }
            }

            var6 = Client.secretPacketBuffer2.readUnsignedByte();
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = Client.secretPacketBuffer2.method3046();
                  var9 = Client.secretPacketBuffer2.method3046();
                  if(var9 != 32767) {
                     var10 = Client.secretPacketBuffer2.method3046();
                     var11 = Client.secretPacketBuffer2.readUnsignedByteNegated();
                     int var12 = var9 > 0?Client.secretPacketBuffer2.readUnsignedByte():var11;
                     var3.method1445(var8, Client.gameCycle, var9, var10, var11, var12);
                  } else {
                     var3.method1446(var8);
                  }
               }
            }
         }

         if((var4 & 1) != 0) {
            var3.composition = class158.getNpcDefinition(Client.secretPacketBuffer2.readShortLE());
            var3.field1212 = var3.composition.field3559;
            var3.field1227 = var3.composition.field3582;
            var3.field1216 = var3.composition.field3565;
            var3.field1217 = var3.composition.field3560;
            var3.field1218 = var3.composition.field3567;
            var3.field1219 = var3.composition.field3568;
            var3.idlePoseAnimation = var3.composition.field3558;
            var3.field1214 = var3.composition.field3563;
            var3.field1215 = var3.composition.field3564;
         }

         if((var4 & 8) != 0) {
            var3.overhead = Client.secretPacketBuffer2.readString();
            var3.field1234 = 100;
         }

         if((var4 & 32) != 0) {
            var3.interacting = Client.secretPacketBuffer2.readUnsignedShortOb2();
            if(var3.interacting == '\uffff') {
               var3.interacting = -1;
            }
         }

         if((var4 & 4) != 0) {
            var3.graphic = Client.secretPacketBuffer2.readUnsignedShortOb1();
            var5 = Client.secretPacketBuffer2.readIntOb3();
            var3.field1239 = var5 >> 16;
            var3.field1248 = Client.gameCycle + (var5 & '\uffff');
            var3.field1221 = 0;
            var3.field1247 = 0;
            if(var3.field1248 > Client.gameCycle) {
               var3.field1221 = -1;
            }

            if(var3.graphic == '\uffff') {
               var3.graphic = -1;
            }
         }

         if((var4 & 64) != 0) {
            var5 = Client.secretPacketBuffer2.readUnsignedShortOb1();
            if(var5 == '\uffff') {
               var5 = -1;
            }

            var6 = Client.secretPacketBuffer2.readUnsignedByteNegated();
            if(var5 == var3.animation && var5 != -1) {
               var7 = GameEngine.getAnimation(var5).replyMode;
               if(var7 == 1) {
                  var3.actionFrame = 0;
                  var3.field1242 = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field1244 = 0;
               }

               if(var7 == 2) {
                  var3.field1244 = 0;
               }
            } else if(var5 == -1 || var3.animation == -1 || GameEngine.getAnimation(var5).forcedPriority >= GameEngine.getAnimation(var3.animation).forcedPriority) {
               var3.animation = var5;
               var3.actionFrame = 0;
               var3.field1242 = 0;
               var3.actionAnimationDisable = var6;
               var3.field1244 = 0;
               var3.field1267 = var3.queueSize;
            }
         }
      }

      for(var1 = 0; var1 < Client.field1029; ++var1) {
         var2 = Client.field1030[var1];
         if(Client.cachedNPCs[var2].field1240 != Client.gameCycle) {
            Client.cachedNPCs[var2].composition = null;
            Client.cachedNPCs[var2] = null;
         }
      }

      if(Client.packetLength != Client.secretPacketBuffer2.offset) {
         throw new RuntimeException(Client.secretPacketBuffer2.offset + "," + Client.packetLength);
      } else {
         for(var1 = 0; var1 < Client.field930; ++var1) {
            if(Client.cachedNPCs[Client.npcIndices[var1]] == null) {
               throw new RuntimeException(var1 + "," + Client.field930);
            }
         }

      }
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "3"
   )
   class1(int var1) {
      this.field7 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IILclass163;LCollisionData;I)Z",
      garbageValue = "-2053552401"
   )
   static final boolean method1(int var0, int var1, class163 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class162.field2314[var6][var7] = 99;
      class162.field2311[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class162.field2315[var10] = var0;
      int var12 = var10 + 1;
      class162.field2316[var10] = var1;
      int[][] var13 = var3.flags;

      while(var11 != var12) {
         var4 = class162.field2315[var11];
         var5 = class162.field2316[var11];
         var11 = var11 + 1 & 4095;
         int var14 = var4 - var8;
         int var15 = var5 - var9;
         int var16 = var4 - var3.x;
         int var17 = var5 - var3.y;
         if(var2.vmethod2950(2, var4, var5, var3)) {
            class164.field2331 = var4;
            class162.field2310 = var5;
            return true;
         }

         int var18 = class162.field2311[var14][var15] + 1;
         if(var14 > 0 && class162.field2314[var14 - 1][var15] == 0 && (var13[var16 - 1][var17] & 19136782) == 0 && (var13[var16 - 1][var17 + 1] & 19136824) == 0) {
            class162.field2315[var12] = var4 - 1;
            class162.field2316[var12] = var5;
            var12 = var12 + 1 & 4095;
            class162.field2314[var14 - 1][var15] = 2;
            class162.field2311[var14 - 1][var15] = var18;
         }

         if(var14 < 126 && class162.field2314[var14 + 1][var15] == 0 && (var13[var16 + 2][var17] & 19136899) == 0 && (var13[var16 + 2][var17 + 1] & 19136992) == 0) {
            class162.field2315[var12] = var4 + 1;
            class162.field2316[var12] = var5;
            var12 = var12 + 1 & 4095;
            class162.field2314[var14 + 1][var15] = 8;
            class162.field2311[var14 + 1][var15] = var18;
         }

         if(var15 > 0 && class162.field2314[var14][var15 - 1] == 0 && (var13[var16][var17 - 1] & 19136782) == 0 && (var13[var16 + 1][var17 - 1] & 19136899) == 0) {
            class162.field2315[var12] = var4;
            class162.field2316[var12] = var5 - 1;
            var12 = var12 + 1 & 4095;
            class162.field2314[var14][var15 - 1] = 1;
            class162.field2311[var14][var15 - 1] = var18;
         }

         if(var15 < 126 && class162.field2314[var14][var15 + 1] == 0 && (var13[var16][var17 + 2] & 19136824) == 0 && (var13[var16 + 1][var17 + 2] & 19136992) == 0) {
            class162.field2315[var12] = var4;
            class162.field2316[var12] = var5 + 1;
            var12 = var12 + 1 & 4095;
            class162.field2314[var14][var15 + 1] = 4;
            class162.field2311[var14][var15 + 1] = var18;
         }

         if(var14 > 0 && var15 > 0 && class162.field2314[var14 - 1][var15 - 1] == 0 && (var13[var16 - 1][var17] & 19136830) == 0 && (var13[var16 - 1][var17 - 1] & 19136782) == 0 && (var13[var16][var17 - 1] & 19136911) == 0) {
            class162.field2315[var12] = var4 - 1;
            class162.field2316[var12] = var5 - 1;
            var12 = var12 + 1 & 4095;
            class162.field2314[var14 - 1][var15 - 1] = 3;
            class162.field2311[var14 - 1][var15 - 1] = var18;
         }

         if(var14 < 126 && var15 > 0 && class162.field2314[var14 + 1][var15 - 1] == 0 && (var13[var16 + 1][var17 - 1] & 19136911) == 0 && (var13[var16 + 2][var17 - 1] & 19136899) == 0 && (var13[var16 + 2][var17] & 19136995) == 0) {
            class162.field2315[var12] = var4 + 1;
            class162.field2316[var12] = var5 - 1;
            var12 = var12 + 1 & 4095;
            class162.field2314[var14 + 1][var15 - 1] = 9;
            class162.field2311[var14 + 1][var15 - 1] = var18;
         }

         if(var14 > 0 && var15 < 126 && class162.field2314[var14 - 1][var15 + 1] == 0 && (var13[var16 - 1][var17 + 1] & 19136830) == 0 && (var13[var16 - 1][var17 + 2] & 19136824) == 0 && (var13[var16][var17 + 2] & 19137016) == 0) {
            class162.field2315[var12] = var4 - 1;
            class162.field2316[var12] = var5 + 1;
            var12 = var12 + 1 & 4095;
            class162.field2314[var14 - 1][var15 + 1] = 6;
            class162.field2311[var14 - 1][var15 + 1] = var18;
         }

         if(var14 < 126 && var15 < 126 && class162.field2314[var14 + 1][var15 + 1] == 0 && (var13[var16 + 1][var17 + 2] & 19137016) == 0 && (var13[var16 + 2][var17 + 2] & 19136992) == 0 && (var13[var16 + 2][var17 + 1] & 19136995) == 0) {
            class162.field2315[var12] = var4 + 1;
            class162.field2316[var12] = var5 + 1;
            var12 = var12 + 1 & 4095;
            class162.field2314[var14 + 1][var15 + 1] = 12;
            class162.field2311[var14 + 1][var15 + 1] = var18;
         }
      }

      class164.field2331 = var4;
      class162.field2310 = var5;
      return false;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "941598375"
   )
   public static String method2(CharSequence var0) {
      String var1 = class239.method4141(class95.method1672(var0));
      if(var1 == null) {
         var1 = "";
      }

      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;III)Z",
      garbageValue = "-606072652"
   )
   public static boolean method3(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         ISAACCipher.method3321(var3);
         return true;
      }
   }

   static {
      field8 = new class1(3);
      field1 = new class1(5);
      field10 = new class1(2);
      field3 = new class1(4);
      field12 = new class1(6);
      field5 = new class1(1);
      field6 = new class1(0);
   }
}
