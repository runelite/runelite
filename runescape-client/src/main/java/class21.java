import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class21 {
   @ObfuscatedName("g")
   @Export("offsetsY")
   public static int[] offsetsY;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-1834504326"
   )
   static final void method163(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2770(var0, var1, var2);
      int[] var8 = Region.method2770(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "888837968"
   )
   public static int method158(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & '?');
         } else {
            var0[var4++] = (byte)(224 | var6 >> '\f');
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & '?');
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "26225"
   )
   static final void method162() {
      for(int var0 = 0; var0 < Client.pendingNpcFlagsCount; ++var0) {
         int var1 = Client.pendingNpcFlagsIndices[var0];
         NPC var2 = Client.cachedNPCs[var1];
         int var3 = Client.secretPacketBuffer2.readUnsignedByte();
         if((var3 & 32) != 0) {
            var2.overhead = Client.secretPacketBuffer2.readString();
            var2.field1225 = 100;
         }

         int var4;
         int var5;
         int var6;
         if((var3 & 64) != 0) {
            var4 = Client.secretPacketBuffer2.method3259();
            if(var4 == 65535) {
               var4 = -1;
            }

            var5 = Client.secretPacketBuffer2.method3250();
            if(var4 == var2.animation && var4 != -1) {
               var6 = NPCComposition.getAnimation(var4).replyMode;
               if(var6 == 1) {
                  var2.actionFrame = 0;
                  var2.field1243 = 0;
                  var2.actionAnimationDisable = var5;
                  var2.field1245 = 0;
               }

               if(var6 == 2) {
                  var2.field1245 = 0;
               }
            } else if(var4 == -1 || var2.animation == -1 || NPCComposition.getAnimation(var4).forcedPriority >= NPCComposition.getAnimation(var2.animation).forcedPriority) {
               var2.animation = var4;
               var2.actionFrame = 0;
               var2.field1243 = 0;
               var2.actionAnimationDisable = var5;
               var2.field1245 = 0;
               var2.field1213 = var2.queueSize;
            }
         }

         if((var3 & 1) != 0) {
            var2.graphic = Client.secretPacketBuffer2.method3259();
            var4 = Client.secretPacketBuffer2.method3268();
            var2.field1250 = var4 >> 16;
            var2.graphicsDelay = (var4 & 65535) + Client.gameCycle;
            var2.field1215 = 0;
            var2.field1248 = 0;
            if(var2.graphicsDelay > Client.gameCycle) {
               var2.field1215 = -1;
            }

            if(var2.graphic == 65535) {
               var2.graphic = -1;
            }
         }

         int var7;
         if((var3 & 2) != 0) {
            var4 = Client.secretPacketBuffer2.method3248();
            int var8;
            int var9;
            int var10;
            if(var4 > 0) {
               for(var5 = 0; var5 < var4; ++var5) {
                  var7 = -1;
                  var8 = -1;
                  var9 = -1;
                  var6 = Client.secretPacketBuffer2.getUSmart();
                  if(var6 == 32767) {
                     var6 = Client.secretPacketBuffer2.getUSmart();
                     var8 = Client.secretPacketBuffer2.getUSmart();
                     var7 = Client.secretPacketBuffer2.getUSmart();
                     var9 = Client.secretPacketBuffer2.getUSmart();
                  } else if(var6 != 32766) {
                     var8 = Client.secretPacketBuffer2.getUSmart();
                  } else {
                     var6 = -1;
                  }

                  var10 = Client.secretPacketBuffer2.getUSmart();
                  var2.method1528(var6, var8, var7, var9, Client.gameCycle, var10);
               }
            }

            var5 = Client.secretPacketBuffer2.readUnsignedShortOb1();
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = Client.secretPacketBuffer2.getUSmart();
                  var8 = Client.secretPacketBuffer2.getUSmart();
                  if(var8 != 32767) {
                     var9 = Client.secretPacketBuffer2.getUSmart();
                     var10 = Client.secretPacketBuffer2.method3248();
                     int var11 = var8 > 0?Client.secretPacketBuffer2.method3248():var10;
                     var2.method1529(var7, Client.gameCycle, var8, var9, var10, var11);
                  } else {
                     var2.method1531(var7);
                  }
               }
            }
         }

         if((var3 & 8) != 0) {
            var2.interacting = Client.secretPacketBuffer2.method3259();
            if(var2.interacting == 65535) {
               var2.interacting = -1;
            }
         }

         if((var3 & 4) != 0) {
            var4 = Client.secretPacketBuffer2.method3259();
            var5 = Client.secretPacketBuffer2.readUnsignedShort();
            var6 = var2.x - (var4 - class22.baseX * 411265 - class22.baseX * 411265) * 64;
            var7 = var2.y - (var5 - class273.baseY - class273.baseY) * 64;
            if(var6 != 0 || var7 != 0) {
               var2.field1249 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 16) != 0) {
            var2.composition = class17.getNpcDefinition(Client.secretPacketBuffer2.method3258());
            var2.field1221 = var2.composition.field3555;
            var2.field1262 = var2.composition.field3562;
            var2.field1217 = var2.composition.field3573;
            var2.field1218 = var2.composition.field3578;
            var2.field1219 = var2.composition.field3563;
            var2.field1220 = var2.composition.field3564;
            var2.idlePoseAnimation = var2.composition.field3549;
            var2.field1253 = var2.composition.field3585;
            var2.field1227 = var2.composition.field3560;
         }
      }

   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "649780656"
   )
   static final String method160(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class24.getColTags(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class24.getColTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class24.getColTags(16776960) + var1 + "</col>");
   }
}
