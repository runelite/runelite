import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -1971724139
   )
   int field1198;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1352509351
   )
   @Export("y")
   int y;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1474080607
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -382680711
   )
   int field1201;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1886162207
   )
   int field1202;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1585005225
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1379329681
   )
   int field1204;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1332667447
   )
   int field1205;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -899478649
   )
   int field1206;
   @ObfuscatedName("aq")
   boolean field1207;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 2141474591
   )
   int field1208;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 172235203
   )
   int field1209;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -89684325
   )
   int field1210;
   @ObfuscatedName("ai")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("ao")
   boolean field1212;
   @ObfuscatedName("am")
   @Export("inSequence")
   boolean inSequence;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -2042146261
   )
   int field1214;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 2003628233
   )
   int field1215;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1550568149
   )
   int field1216;
   @ObfuscatedName("ak")
   byte field1217;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 421056233
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("an")
   int[] field1219;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -1147319217
   )
   int field1220;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1942053249
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("bz")
   int[] field1222;
   @ObfuscatedName("bd")
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 197076459
   )
   int field1224;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -1529320683
   )
   int field1225;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1682810557
   )
   int field1226;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1784397095
   )
   int field1227;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1595786061
   )
   int field1228;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 1825690449
   )
   int field1229;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 541285199
   )
   int field1230;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -111598595
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -1981787831
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("ab")
   int[] field1233;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 735240905
   )
   int field1234;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -1472683007
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 1461556695
   )
   int field1236;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -1653662865
   )
   int field1237;
   @ObfuscatedName("au")
   int[] field1238;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -2097757705
   )
   int field1239;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 822980733
   )
   @Export("animation")
   @Hook("animationChanged")
   int animation;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -479888883
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 2596373
   )
   int field1242;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 946240609
   )
   int field1243;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -2001324205
   )
   int field1244;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1319066505
   )
   int field1245;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1012159919
   )
   @Export("x")
   int x;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 1398051175
   )
   int field1247;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 840407707
   )
   int field1248;
   @ObfuscatedName("bf")
   boolean field1249;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -2004820323
   )
   int field1250;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 623457183
   )
   int field1251;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -1470995525
   )
   int field1252;
   @ObfuscatedName("cg")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("ca")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("cs")
   byte[] field1255;
   @ObfuscatedName("aa")
   int[] field1256;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -903838837
   )
   int field1257;

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-980493216"
   )
   final void method1525(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.field1238[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class254 var12 = class149.method2942(var1);
         var10 = var12.field3422;
         var11 = var12.field3426;
      }

      int var14;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var14 = 0;
         if(var10 == 0) {
            var14 = this.field1238[0];
         } else if(var10 == 1) {
            var14 = this.field1219[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.field1238[var13] < var14) {
                  var9 = var13;
                  var14 = this.field1238[var13];
               }
            } else if(var10 == 1 && this.field1219[var13] < var14) {
               var9 = var13;
               var14 = this.field1219[var13];
            }
         }

         if(var10 == 1 && var14 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field1217 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1217;
            this.field1217 = (byte)((this.field1217 + 1) % 4);
            if(this.field1238[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1256[var9] = var1;
         this.field1219[var9] = var2;
         this.field1233[var9] = var3;
         this.field1222[var9] = var4;
         this.field1238[var9] = var6 + var5 + var11;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-10354564"
   )
   final void method1526(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = class23.method164(var1);
      CombatInfoListHolder var8 = null;
      CombatInfoListHolder var9 = null;
      int var10 = var7.field3358;
      int var11 = 0;

      CombatInfoListHolder var12;
      for(var12 = (CombatInfoListHolder)this.combatInfoList.method3620(); var12 != null; var12 = (CombatInfoListHolder)this.combatInfoList.method3625()) {
         ++var11;
         if(var12.combatInfo2.field3354 == var7.field3354) {
            var12.method1697(var2 + var4, var5, var6, var3);
            return;
         }

         if(var12.combatInfo2.field3357 <= var7.field3357) {
            var8 = var12;
         }

         if(var12.combatInfo2.field3358 > var10) {
            var9 = var12;
            var10 = var12.combatInfo2.field3358;
         }
      }

      if(var9 != null || var11 < 4) {
         var12 = new CombatInfoListHolder(var7);
         if(var8 == null) {
            this.combatInfoList.method3619(var12);
         } else {
            CombatInfoList.method3627(var12, var8);
         }

         var12.method1697(var4 + var2, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-98"
   )
   final void method1527(int var1) {
      CombatInfo2 var2 = class23.method164(var1);

      for(CombatInfoListHolder var3 = (CombatInfoListHolder)this.combatInfoList.method3620(); var3 != null; var3 = (CombatInfoListHolder)this.combatInfoList.method3625()) {
         if(var2 == var3.combatInfo2) {
            var3.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-740818925"
   )
   boolean vmethod1721() {
      return false;
   }

   Actor() {
      this.field1207 = false;
      this.field1202 = 1;
      this.idlePoseAnimation = -1;
      this.field1204 = -1;
      this.field1205 = -1;
      this.field1227 = -1;
      this.field1251 = -1;
      this.field1208 = -1;
      this.field1226 = -1;
      this.field1210 = -1;
      this.overhead = null;
      this.inSequence = false;
      this.field1214 = 100;
      this.field1215 = 0;
      this.field1216 = 0;
      this.field1217 = 0;
      this.field1256 = new int[4];
      this.field1219 = new int[4];
      this.field1238 = new int[4];
      this.field1233 = new int[4];
      this.field1222 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1249 = false;
      this.field1230 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.field1229 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.field1220 = 0;
      this.actionAnimationDisable = 0;
      this.field1234 = 0;
      this.graphic = -1;
      this.field1228 = 0;
      this.field1237 = 0;
      this.field1245 = 0;
      this.field1248 = 200;
      this.field1250 = 0;
      this.field1209 = 32;
      this.field1252 = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.field1255 = new byte[10];
      this.field1257 = 0;
      this.field1236 = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-63"
   )
   public static int method1539(int var0) {
      Varbit var1 = class12.method60(var0);
      int var2 = var1.configId;
      int var3 = var1.leastSignificantBit;
      int var4 = var1.mostSignificantBit;
      int var5 = class211.field2597[var4 - var3];
      return class211.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "103"
   )
   static final boolean method1543(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field986 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1162.method4034(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1162.method4008(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1162.method4009(false);
         }

         if(var1 == 325) {
            Client.field1162.method4009(true);
         }

         if(var1 == 326) {
            Client.secretPacketBuffer1.putOpcode(3);
            Client.field1162.method4018(Client.secretPacketBuffer1);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "210073872"
   )
   final void method1544() {
      this.field1252 = 0;
      this.field1236 = 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LRSSocket;ZI)V",
      garbageValue = "-233871360"
   )
   public static void method1545(RSSocket var0, boolean var1) {
      if(class238.field3257 != null) {
         try {
            class238.field3257.method3048();
         } catch (Exception var6) {
            ;
         }

         class238.field3257 = null;
      }

      class238.field3257 = var0;
      class91.method1753(var1);
      class238.field3252.offset = 0;
      class56.field674 = null;
      class24.field362 = null;
      class238.field3248 = 0;

      while(true) {
         class234 var2 = (class234)class238.field3245.method3606();
         if(var2 == null) {
            while(true) {
               var2 = (class234)class238.field3250.method3606();
               if(var2 == null) {
                  if(class238.field3254 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.putByte(4);
                        var7.putByte(class238.field3254);
                        var7.putShort(0);
                        class238.field3257.queueForWrite(var7.payload, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class238.field3257.method3048();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class238.field3241;
                        class238.field3257 = null;
                     }
                  }

                  class238.field3251 = 0;
                  class238.field3240 = class226.method4147();
                  return;
               }

               class238.field3247.method3540(var2);
               class238.field3259.method3617(var2, var2.hash);
               ++class238.field3249;
               --class238.field3256;
            }
         }

         class238.field3243.method3617(var2, var2.hash);
         ++class238.field3244;
         --class238.field3246;
      }
   }
}
