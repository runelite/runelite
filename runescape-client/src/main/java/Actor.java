import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -668311719
   )
   @Export("x")
   int x;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -639886065
   )
   @Export("y")
   int y;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -335203931
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("aq")
   boolean field1201;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1872809039
   )
   int field1147;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 434782623
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1473663571
   )
   int field1152;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1237956799
   )
   int field1153;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -988209391
   )
   int field1154;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1505518289
   )
   int field1155;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -2146168593
   )
   int field1156;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -256480151
   )
   int field1157;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -77532785
   )
   int field1158;
   @ObfuscatedName("ad")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("an")
   boolean field1160;
   @ObfuscatedName("ai")
   @Export("inSequence")
   boolean inSequence;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 792803111
   )
   int field1177;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -704930753
   )
   int field1163;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -926523625
   )
   int field1164;
   @ObfuscatedName("ao")
   byte field1165;
   @ObfuscatedName("av")
   int[] field1196;
   @ObfuscatedName("ab")
   @Export("hitsplatTypes")
   int[] hitsplatTypes;
   @ObfuscatedName("az")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("at")
   int[] field1162;
   @ObfuscatedName("bj")
   int[] field1170;
   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -1519201681
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("bk")
   boolean field1173;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 301920375
   )
   int field1174;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 2061727783
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -20138517
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 368673457
   )
   int field1146;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1408809497
   )
   @Export("animation")
   @Hook("animationChanged")
   int animation;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 135949829
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -359524929
   )
   int field1180;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -261419251
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 1108631047
   )
   int field1182;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -1561797361
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -1474904225
   )
   int field1184;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1932010597
   )
   int field1185;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -581675809
   )
   @Export("graphicsDelay")
   int graphicsDelay;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -522365741
   )
   int field1187;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 1534764277
   )
   int field1188;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -1336433263
   )
   int field1178;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -2108868799
   )
   int field1190;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1865204745
   )
   int field1166;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -1869019317
   )
   int field1176;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -95883183
   )
   int field1193;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 824394633
   )
   int field1194;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -210838777
   )
   int field1195;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 2142258075
   )
   int field1179;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -781830063
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = 1423500207
   )
   int field1198;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -1212231005
   )
   int field1199;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 2109489259
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("cy")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("cb")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("cj")
   byte[] field1203;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -1269759145
   )
   int field1204;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -1681456001
   )
   int field1159;

   Actor() {
      this.field1201 = false;
      this.field1147 = 1;
      this.idlePoseAnimation = -1;
      this.field1152 = -1;
      this.field1153 = -1;
      this.field1154 = -1;
      this.field1155 = -1;
      this.field1156 = -1;
      this.field1157 = -1;
      this.field1158 = -1;
      this.overhead = null;
      this.inSequence = false;
      this.field1177 = 100;
      this.field1163 = 0;
      this.field1164 = 0;
      this.field1165 = 0;
      this.field1196 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1162 = new int[4];
      this.field1170 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1173 = false;
      this.field1174 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.field1146 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.field1180 = 0;
      this.actionAnimationDisable = 0;
      this.field1182 = 0;
      this.graphic = -1;
      this.field1184 = 0;
      this.field1185 = 0;
      this.field1195 = 0;
      this.field1179 = 200;
      this.field1198 = 0;
      this.field1199 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.field1203 = new byte[10];
      this.field1204 = 0;
      this.field1159 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "120"
   )
   @Export("hasConfig")
   boolean hasConfig() {
      return false;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-695530853"
   )
   final void method1574() {
      this.queueSize = 0;
      this.field1159 = 0;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-78"
   )
   final void method1580(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.hitsplatCycles[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class261 var12 = class64.method1105(var1);
         var10 = var12.field3492;
         var11 = var12.field3491;
      }

      int var14;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var14 = 0;
         if(var10 == 0) {
            var14 = this.hitsplatCycles[0];
         } else if(var10 == 1) {
            var14 = this.hitsplatTypes[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.hitsplatCycles[var13] < var14) {
                  var9 = var13;
                  var14 = this.hitsplatCycles[var13];
               }
            } else if(var10 == 1 && this.hitsplatTypes[var13] < var14) {
               var9 = var13;
               var14 = this.hitsplatTypes[var13];
            }
         }

         if(var10 == 1 && var14 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field1165 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1165;
            this.field1165 = (byte)((this.field1165 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1196[var9] = var1;
         this.hitsplatTypes[var9] = var2;
         this.field1162[var9] = var3;
         this.field1170[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-471467339"
   )
   final void method1578(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var8 = (CombatInfo2)CombatInfo2.field3432.get((long)var1);
      CombatInfo2 var7;
      if(var8 != null) {
         var7 = var8;
      } else {
         byte[] var9 = CombatInfo2.field3442.getConfigData(33, var1);
         var8 = new CombatInfo2();
         if(var9 != null) {
            var8.method4547(new Buffer(var9));
         }

         CombatInfo2.field3432.put(var8, (long)var1);
         var7 = var8;
      }

      var8 = var7;
      CombatInfoListHolder var14 = null;
      CombatInfoListHolder var10 = null;
      int var11 = var7.field3437;
      int var12 = 0;

      CombatInfoListHolder var13;
      for(var13 = (CombatInfoListHolder)this.combatInfoList.method3723(); var13 != null; var13 = (CombatInfoListHolder)this.combatInfoList.method3720()) {
         ++var12;
         if(var13.combatInfo2.field3439 == var8.field3439) {
            var13.method1729(var2 + var4, var5, var6, var3);
            return;
         }

         if(var13.combatInfo2.field3444 <= var8.field3444) {
            var14 = var13;
         }

         if(var13.combatInfo2.field3437 > var11) {
            var10 = var13;
            var11 = var13.combatInfo2.field3437;
         }
      }

      if(var10 != null || var12 < 4) {
         var13 = new CombatInfoListHolder(var8);
         if(var14 == null) {
            this.combatInfoList.method3727(var13);
         } else {
            CombatInfoList.method3721(var13, var14);
         }

         var13.method1729(var2 + var4, var5, var6, var3);
         if(var12 >= 4) {
            var10.unlink();
         }

      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2072992790"
   )
   final void method1579(int var1) {
      CombatInfo2 var3 = (CombatInfo2)CombatInfo2.field3432.get((long)var1);
      CombatInfo2 var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = CombatInfo2.field3442.getConfigData(33, var1);
         var3 = new CombatInfo2();
         if(var4 != null) {
            var3.method4547(new Buffer(var4));
         }

         CombatInfo2.field3432.put(var3, (long)var1);
         var2 = var3;
      }

      var3 = var2;

      for(CombatInfoListHolder var5 = (CombatInfoListHolder)this.combatInfoList.method3723(); var5 != null; var5 = (CombatInfoListHolder)this.combatInfoList.method3720()) {
         if(var3 == var5.combatInfo2) {
            var5.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lid;Lid;Ljava/lang/String;Ljava/lang/String;I)Ljp;",
      garbageValue = "-868297462"
   )
   public static Font method1576(IndexDataBase var0, IndexDataBase var1, String var2, String var3) {
      int var4 = var0.getFile(var2);
      int var5 = var0.getChild(var4, var3);
      return class278.method5092(var0, var1, var4, var5);
   }
}
