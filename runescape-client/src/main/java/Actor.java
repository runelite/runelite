import java.awt.Component;
import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("aj")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -1214667081
   )
   int field601 = 0;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -2004086661
   )
   @Export("interacting")
   int interacting = -1;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 2128681877
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1468176267
   )
   @Export("animation")
   int animation = -1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -533949819
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation = -1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 625445699
   )
   int field606 = 100;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 2092561437
   )
   int field607 = -1;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1794331305
   )
   int field608 = -1;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1888686221
   )
   int field609 = 200;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1842555419
   )
   int field610 = -1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1583842773
   )
   int field611 = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1598600911
   )
   int field612 = -1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1688043085
   )
   int field613 = -1;
   @ObfuscatedName("aa")
   @Export("overhead")
   String overhead = null;
   @ObfuscatedName("ar")
   boolean field615;
   @ObfuscatedName("ag")
   @Export("inSequence")
   boolean inSequence = false;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 326242273
   )
   int field617 = 0;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -948432809
   )
   @Export("actionFrame")
   int actionFrame = 0;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -297223133
   )
   int field619 = 0;
   @ObfuscatedName("ax")
   byte field620 = 0;
   @ObfuscatedName("av")
   int[] field621 = new int[4];
   @ObfuscatedName("az")
   int[] field622 = new int[4];
   @ObfuscatedName("ao")
   int[] field623 = new int[4];
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 237432937
   )
   int field624 = -1;
   @ObfuscatedName("by")
   int[] field625 = new int[4];
   @ObfuscatedName("bj")
   @Export("combatInfoList")
   CombatInfoList combatInfoList = new CombatInfoList();
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 882749985
   )
   int field627 = -1;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1172991419
   )
   int field628 = 0;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -25339987
   )
   int field629 = 0;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 2097557529
   )
   @Export("poseAnimation")
   int poseAnimation = -1;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -260797199
   )
   @Export("y")
   int y;
   @ObfuscatedName("aw")
   boolean field632 = false;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 556373863
   )
   int field633;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1685707371
   )
   int field634 = 1;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -564496643
   )
   int field635 = 0;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 2047435373
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable = 0;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -387321373
   )
   int field637 = 0;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 657465045
   )
   @Export("graphic")
   int graphic = -1;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -1348420179
   )
   int field639 = 0;
   @ObfuscatedName("cw")
   @Export("pathY")
   int[] pathY = new int[10];
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 128720245
   )
   int field641;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1730253865
   )
   int field642;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 140609029
   )
   int field643;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -1995383197
   )
   int field644;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -1449006715
   )
   int field645;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -587701195
   )
   int field646;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 1163982719
   )
   int field647;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1910794999
   )
   int field648 = 0;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1413432153
   )
   int field649;
   @ObfuscatedName("bl")
   boolean field650 = false;
   @ObfuscatedName("aq")
   int[] field651 = new int[4];
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 1387419977
   )
   int field652;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1020096435
   )
   @Export("poseFrame")
   int poseFrame = 0;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -2069840625
   )
   int field654 = 32;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -186099385
   )
   int field655 = 0;
   @ObfuscatedName("ci")
   @Export("pathX")
   int[] pathX = new int[10];
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1736701935
   )
   @Export("x")
   int x;
   @ObfuscatedName("cz")
   byte[] field658 = new byte[10];
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 1443311259
   )
   int field659 = 0;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 1894481471
   )
   int field660 = 0;

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1149199430"
   )
   final void method622() {
      this.field655 = 0;
      this.field660 = 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-274573938"
   )
   boolean vmethod795() {
      return false;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1767541389"
   )
   final void method626(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = class49.method971(var1);
      CombatInfoListHolder var8 = null;
      CombatInfoListHolder var9 = null;
      int var10 = var7.field2841;
      int var11 = 0;

      CombatInfoListHolder var12;
      for(var12 = (CombatInfoListHolder)this.combatInfoList.method2455(); null != var12; var12 = (CombatInfoListHolder)this.combatInfoList.method2437()) {
         ++var11;
         if(var12.combatInfo2.field2842 == var7.field2842) {
            var12.method775(var4 + var2, var5, var6, var3);
            return;
         }

         if(var12.combatInfo2.field2836 <= var7.field2836) {
            var8 = var12;
         }

         if(var12.combatInfo2.field2841 > var10) {
            var9 = var12;
            var10 = var12.combatInfo2.field2841;
         }
      }

      if(var9 != null || var11 < 4) {
         var12 = new CombatInfoListHolder(var7);
         if(null == var8) {
            this.combatInfoList.method2433(var12);
         } else {
            CombatInfoList.method2434(var12, var8);
         }

         var12.method775(var4 + var2, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1058597638"
   )
   final void method627(int var1) {
      CombatInfo2 var2 = class49.method971(var1);

      for(CombatInfoListHolder var3 = (CombatInfoListHolder)this.combatInfoList.method2455(); var3 != null; var3 = (CombatInfoListHolder)this.combatInfoList.method2437()) {
         if(var3.combatInfo2 == var2) {
            var3.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1917773355"
   )
   static int method632() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "887498513"
   )
   static void method637() {
      int var0 = class2.field21;
      int var1 = class20.field216;
      if(FaceNormal.field1553 < var0) {
         var0 = FaceNormal.field1553;
      }

      if(class85.field1445 < var1) {
         var1 = class85.field1445;
      }

      if(WallObject.field1551 != null) {
         try {
            Client var2 = Client.field279;
            Object[] var3 = new Object[]{Integer.valueOf(method632())};
            JSObject.getWindow(var2).call("resize", var3);
         } catch (Throwable var4) {
            ;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1269048214"
   )
   public static void method638(Component var0) {
      var0.addMouseListener(class115.mouse);
      var0.addMouseMotionListener(class115.mouse);
      var0.addFocusListener(class115.mouse);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1410499959"
   )
   static int method639(int var0, Script var1, boolean var2) {
      Widget var3 = class140.method2681(class32.field729[--class101.field1648]);
      if(var0 == 2800) {
         class32.field729[++class101.field1648 - 1] = class0.method10(class8.method112(var3));
         return 1;
      } else if(var0 != 2801) {
         if(var0 == 2802) {
            if(var3.name == null) {
               class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
            } else {
               class32.scriptStringStack[++World.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = class32.field729[--class101.field1648];
         --var4;
         if(null != var3.actions && var4 < var3.actions.length && var3.actions[var4] != null) {
            class32.scriptStringStack[++World.scriptStringStackSize - 1] = var3.actions[var4];
         } else {
            class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "-1739338045"
   )
   public static boolean method640(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "9799274"
   )
   final void method641(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.field623[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class196 var14 = NPCComposition.method3832(var1);
         var10 = var14.field2886;
         var11 = var14.field2882;
      }

      int var12;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var12 = 0;
         if(var10 == 0) {
            var12 = this.field623[0];
         } else if(var10 == 1) {
            var12 = this.field622[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.field623[var13] < var12) {
                  var9 = var13;
                  var12 = this.field623[var13];
               }
            } else if(var10 == 1 && this.field622[var13] < var12) {
               var9 = var13;
               var12 = this.field622[var13];
            }
         }

         if(var10 == 1 && var12 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field620 = 0;
         }

         for(var12 = 0; var12 < 4; ++var12) {
            byte var15 = this.field620;
            this.field620 = (byte)((1 + this.field620) % 4);
            if(this.field623[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field621[var9] = var1;
         this.field622[var9] = var2;
         this.field651[var9] = var3;
         this.field625[var9] = var4;
         this.field623[var9] = var6 + var11 + var5;
      }
   }
}
