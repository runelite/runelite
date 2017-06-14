import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public class class149 implements class178 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1110571027
   )
   public final int field2206;
   @ObfuscatedName("p")
   public static final class149 field2207;
   @ObfuscatedName("i")
   public static final class149 field2208;
   @ObfuscatedName("j")
   public static final class149 field2209;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1319097509
   )
   final int field2210;
   @ObfuscatedName("n")
   public static final class149 field2212;
   @ObfuscatedName("bn")
   static String field2213;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class149(int var1, int var2) {
      this.field2206 = var1;
      this.field2210 = var2;
   }

   static {
      field2212 = new class149(3, 0);
      field2207 = new class149(1, 1);
      field2208 = new class149(2, 2);
      field2209 = new class149(0, 3);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1469137335"
   )
   public int vmethod5059() {
      return this.field2210;
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(IIB)Lclass163;",
      garbageValue = "-43"
   )
   static class163 method2908(int var0, int var1) {
      Client.field1194.field2319 = var0;
      Client.field1194.field2320 = var1;
      Client.field1194.field2321 = 1;
      Client.field1194.field2324 = 1;
      return Client.field1194;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IS)Lclass231;",
      garbageValue = "-14600"
   )
   public static class231 method2909(int var0) {
      class231[] var1 = new class231[]{class231.field3188, class231.field3186, class231.field3185, class231.field3187};
      class231[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class231 var4 = var2[var3];
         if(var4.field3189 == var0) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1097586455"
   )
   static final void method2910() {
      for(int var0 = 0; var0 < Client.field954; ++var0) {
         int var1 = Client.field955[var0];
         NPC var2 = Client.cachedNPCs[var1];
         int var3 = Client.secretPacketBuffer2.readUnsignedByte();
         int var4;
         int var5;
         int var6;
         int var7;
         if((var3 & 4) != 0) {
            var4 = Client.secretPacketBuffer2.method3188();
            int var8;
            int var9;
            int var10;
            if(var4 > 0) {
               for(var5 = 0; var5 < var4; ++var5) {
                  var7 = -1;
                  var8 = -1;
                  var9 = -1;
                  var6 = Client.secretPacketBuffer2.method3172();
                  if(var6 == 32767) {
                     var6 = Client.secretPacketBuffer2.method3172();
                     var8 = Client.secretPacketBuffer2.method3172();
                     var7 = Client.secretPacketBuffer2.method3172();
                     var9 = Client.secretPacketBuffer2.method3172();
                  } else if(var6 != 32766) {
                     var8 = Client.secretPacketBuffer2.method3172();
                  } else {
                     var6 = -1;
                  }

                  var10 = Client.secretPacketBuffer2.method3172();
                  var2.method1502(var6, var8, var7, var9, Client.gameCycle, var10);
               }
            }

            var5 = Client.secretPacketBuffer2.method3186();
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = Client.secretPacketBuffer2.method3172();
                  var8 = Client.secretPacketBuffer2.method3172();
                  if(var8 != 32767) {
                     var9 = Client.secretPacketBuffer2.method3172();
                     var10 = Client.secretPacketBuffer2.method3188();
                     int var11 = var8 > 0?Client.secretPacketBuffer2.method3186():var10;
                     var2.method1495(var7, Client.gameCycle, var8, var9, var10, var11);
                  } else {
                     var2.method1506(var7);
                  }
               }
            }
         }

         if((var3 & 8) != 0) {
            var2.interacting = Client.secretPacketBuffer2.method3195();
            if(var2.interacting == '\uffff') {
               var2.interacting = -1;
            }
         }

         if((var3 & 2) != 0) {
            var4 = Client.secretPacketBuffer2.readUnsignedShort();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = Client.secretPacketBuffer2.method3187();
            if(var4 == var2.animation && var4 != -1) {
               var6 = class169.getAnimation(var4).replyMode;
               if(var6 == 1) {
                  var2.actionFrame = 0;
                  var2.field1260 = 0;
                  var2.actionAnimationDisable = var5;
                  var2.field1228 = 0;
               }

               if(var6 == 2) {
                  var2.field1228 = 0;
               }
            } else if(var4 == -1 || var2.animation == -1 || class169.getAnimation(var4).forcedPriority >= class169.getAnimation(var2.animation).forcedPriority) {
               var2.animation = var4;
               var2.actionFrame = 0;
               var2.field1260 = 0;
               var2.actionAnimationDisable = var5;
               var2.field1228 = 0;
               var2.field1285 = var2.queueSize;
            }
         }

         if((var3 & 16) != 0) {
            var4 = Client.secretPacketBuffer2.readUnsignedShort();
            var5 = Client.secretPacketBuffer2.method3195();
            var6 = var2.x - (var4 - class61.baseX - class61.baseX) * 64;
            var7 = var2.y - (var5 - class23.baseY - class23.baseY) * 64;
            if(var6 != 0 || var7 != 0) {
               var2.field1254 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 32) != 0) {
            var2.overhead = Client.secretPacketBuffer2.readString();
            var2.field1266 = 100;
         }

         if((var3 & 1) != 0) {
            var2.graphic = Client.secretPacketBuffer2.method3195();
            var4 = Client.secretPacketBuffer2.method3173();
            var2.field1279 = var4 >> 16;
            var2.field1256 = (var4 & '\uffff') + Client.gameCycle;
            var2.field1264 = 0;
            var2.field1249 = 0;
            if(var2.field1256 > Client.gameCycle) {
               var2.field1264 = -1;
            }

            if(var2.graphic == '\uffff') {
               var2.graphic = -1;
            }
         }

         if((var3 & 64) != 0) {
            var2.composition = class217.getNpcDefinition(Client.secretPacketBuffer2.method3196());
            var2.field1230 = var2.composition.field3577;
            var2.field1242 = var2.composition.field3564;
            var2.field1234 = var2.composition.field3579;
            var2.field1235 = var2.composition.field3571;
            var2.field1265 = var2.composition.field3572;
            var2.field1237 = var2.composition.field3573;
            var2.idlePoseAnimation = var2.composition.field3574;
            var2.field1232 = var2.composition.field3568;
            var2.field1248 = var2.composition.field3569;
         }
      }

   }
}
