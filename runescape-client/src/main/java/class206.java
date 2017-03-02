import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
public class class206 {
   @ObfuscatedName("l")
   static char[] field3088;
   @ObfuscatedName("b")
   static char[] field3089 = new char[64];
   @ObfuscatedName("i")
   static int[] field3090;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = -1438280213
   )
   @Export("cameraX")
   static int cameraX;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "8230"
   )
   public static void method3919() {
      Widget.field2190.reset();
      Widget.field2191.reset();
      Widget.field2221.reset();
      Widget.field2273.reset();
   }

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3089[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3089[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3089[var0] = (char)(var0 + 48 - 52);
      }

      field3089[62] = 43;
      field3089[63] = 47;
      field3088 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3088[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3088[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3088[var0] = (char)(var0 + 48 - 52);
      }

      field3088[62] = 42;
      field3088[63] = 45;
      field3090 = new int[128];

      for(var0 = 0; var0 < field3090.length; ++var0) {
         field3090[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3090[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3090[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3090[var0] = 52 + (var0 - 48);
      }

      int[] var2 = field3090;
      field3090[43] = 62;
      var2[42] = 62;
      int[] var1 = field3090;
      field3090[47] = 63;
      var1[45] = 63;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1424619017"
   )
   static final void method3924() {
      for(int var0 = 0; var0 < Client.field325; ++var0) {
         int var1 = Client.field393[var0];
         NPC var2 = Client.cachedNPCs[var1];
         int var3 = Client.field329.readUnsignedByte();
         if((var3 & 64) != 0) {
            var2.overhead = Client.field329.readString();
            var2.field606 = 100;
         }

         if((var3 & 16) != 0) {
            var2.composition = ChatLineBuffer.getNpcDefinition(Client.field329.readUnsignedShort());
            var2.field634 = var2.composition.field3012;
            var2.field654 = var2.composition.field3038;
            var2.field627 = var2.composition.field3036;
            var2.field624 = var2.composition.field3019;
            var2.field611 = var2.composition.field3020;
            var2.field612 = var2.composition.field3021;
            var2.idlePoseAnimation = var2.composition.field3018;
            var2.field607 = var2.composition.field3016;
            var2.field608 = var2.composition.field3017;
         }

         int var4;
         int var5;
         int var6;
         int var7;
         if((var3 & 2) != 0) {
            var4 = Client.field329.method3057();
            var5 = Client.field329.method2894();
            var6 = var2.x - (var4 - MessageNode.baseX - MessageNode.baseX) * 64;
            var7 = var2.y - 64 * (var5 - class2.baseY - class2.baseY);
            if(var6 != 0 || var7 != 0) {
               var2.field610 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 32) != 0) {
            var2.interacting = Client.field329.readUnsignedShort();
            if(var2.interacting == '\uffff') {
               var2.interacting = -1;
            }
         }

         if((var3 & 8) != 0) {
            var2.graphic = Client.field329.method2894();
            var4 = Client.field329.method3015();
            var2.field642 = var4 >> 16;
            var2.field641 = (var4 & '\uffff') + Client.gameCycle;
            var2.field639 = 0;
            var2.field628 = 0;
            if(var2.field641 > Client.gameCycle) {
               var2.field639 = -1;
            }

            if(var2.graphic == '\uffff') {
               var2.graphic = -1;
            }
         }

         if((var3 & 1) != 0) {
            var4 = Client.field329.method2894();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = Client.field329.method2884();
            if(var2.animation == var4 && var4 != -1) {
               var6 = XClanMember.getAnimation(var4).replyMode;
               if(var6 == 1) {
                  var2.actionFrame = 0;
                  var2.field635 = 0;
                  var2.actionAnimationDisable = var5;
                  var2.field637 = 0;
               }

               if(var6 == 2) {
                  var2.field637 = 0;
               }
            } else if(var4 == -1 || var2.animation == -1 || XClanMember.getAnimation(var4).forcedPriority >= XClanMember.getAnimation(var2.animation).forcedPriority) {
               var2.animation = var4;
               var2.actionFrame = 0;
               var2.field635 = 0;
               var2.actionAnimationDisable = var5;
               var2.field637 = 0;
               var2.field660 = var2.field655;
            }
         }

         if((var3 & 4) != 0) {
            var4 = Client.field329.readUnsignedByte();
            int var8;
            int var9;
            int var10;
            if(var4 > 0) {
               for(var5 = 0; var5 < var4; ++var5) {
                  var7 = -1;
                  var8 = -1;
                  var9 = -1;
                  var6 = Client.field329.method2991();
                  if(var6 == 32767) {
                     var6 = Client.field329.method2991();
                     var8 = Client.field329.method2991();
                     var7 = Client.field329.method2991();
                     var9 = Client.field329.method2991();
                  } else if(var6 != 32766) {
                     var8 = Client.field329.method2991();
                  } else {
                     var6 = -1;
                  }

                  var10 = Client.field329.method2991();
                  var2.method641(var6, var8, var7, var9, Client.gameCycle, var10);
               }
            }

            var5 = Client.field329.readUnsignedByte();
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = Client.field329.method2991();
                  var8 = Client.field329.method2991();
                  if(var8 != 32767) {
                     var9 = Client.field329.method2991();
                     var10 = Client.field329.method2884();
                     int var11 = var8 > 0?Client.field329.method2885():var10;
                     var2.method626(var7, Client.gameCycle, var8, var9, var10, var11);
                  } else {
                     var2.method627(var7);
                  }
               }
            }
         }
      }

   }

   class206() throws Throwable {
      throw new Error();
   }
}
