import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("ag")
   @Export("inSequence")
   boolean inSequence = false;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -379664271
   )
   @Export("y")
   int y;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1596394219
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("ak")
   boolean field626;
   @ObfuscatedName("am")
   boolean field627 = false;
   @ObfuscatedName("cz")
   @Export("pathY")
   int[] pathY = new int[10];
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -1614612307
   )
   int field629 = 200;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1199271135
   )
   int field630 = -1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 385689613
   )
   int field631 = -1;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 1411430505
   )
   @Export("poseAnimation")
   int poseAnimation = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1238302137
   )
   int field633 = -1;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -459219853
   )
   int field634 = -1;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -685562189
   )
   int field635 = 0;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -170302341
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1338864325
   )
   @Export("x")
   int x;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1457645189
   )
   int field638 = 100;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -212254813
   )
   int field639;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1027139017
   )
   int field640 = 0;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -235191025
   )
   int field641 = 0;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 693608473
   )
   int field642 = 0;
   @ObfuscatedName("ay")
   int[] field643 = new int[4];
   @ObfuscatedName("av")
   int[] field644 = new int[4];
   @ObfuscatedName("af")
   int[] field645 = new int[4];
   @ObfuscatedName("ax")
   int[] field646 = new int[4];
   @ObfuscatedName("bn")
   int[] field647 = new int[4];
   @ObfuscatedName("bp")
   @Export("combatInfoList")
   CombatInfoList combatInfoList = new CombatInfoList();
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 325299061
   )
   @Export("interacting")
   int interacting = -1;
   @ObfuscatedName("bj")
   boolean field650 = false;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1870888687
   )
   int field651 = -1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1481929083
   )
   int field652 = -1;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 759559069
   )
   @Export("poseFrame")
   int poseFrame = 0;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -86566189
   )
   int field654 = 32;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 925404749
   )
   @Export("animation")
   int animation = -1;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 17214121
   )
   @Export("actionFrame")
   int actionFrame = 0;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1863803851
   )
   int field657 = 1;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1429848335
   )
   @Export("graphic")
   int graphic = -1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1609675927
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation = -1;
   @ObfuscatedName("az")
   byte field660 = 0;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -1025988623
   )
   int field661 = 0;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -360235189
   )
   int field662 = 0;
   @ObfuscatedName("ap")
   @Export("overhead")
   String overhead = null;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1176564337
   )
   int field664;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1518099791
   )
   int field665;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 2066770385
   )
   int field666;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 1623903171
   )
   int field667;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -1743598895
   )
   int field668;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1400550981
   )
   int field669;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -421570047
   )
   int field670;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 1664706247
   )
   int field671;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -1607979357
   )
   int field672 = 0;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 121541257
   )
   int field673 = 0;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 1046268545
   )
   int field674;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -1935525279
   )
   int field675 = 0;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -737830195
   )
   int field676 = -1;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 331852643
   )
   int field677 = 0;
   @ObfuscatedName("cw")
   @Export("pathX")
   int[] pathX = new int[10];
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -944719339
   )
   int field679 = -1;
   @ObfuscatedName("ch")
   byte[] field680 = new byte[10];
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 1775057845
   )
   int field681 = 0;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 674933491
   )
   int field682 = 0;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = 1742300683
   )
   protected static int field683;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = 265856953
   )
   @Export("cameraPitch")
   static int cameraPitch;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-848141872"
   )
   boolean vmethod803() {
      return false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-129813953"
   )
   final void method616(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.field645[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class196 var14 = Script.method970(var1);
         var10 = var14.field2885;
         var11 = var14.field2876;
      }

      int var12;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var12 = 0;
         if(var10 == 0) {
            var12 = this.field645[0];
         } else if(var10 == 1) {
            var12 = this.field644[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.field645[var13] < var12) {
                  var9 = var13;
                  var12 = this.field645[var13];
               }
            } else if(var10 == 1 && this.field644[var13] < var12) {
               var9 = var13;
               var12 = this.field644[var13];
            }
         }

         if(var10 == 1 && var12 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field660 = 0;
         }

         for(var12 = 0; var12 < 4; ++var12) {
            byte var15 = this.field660;
            this.field660 = (byte)((1 + this.field660) % 4);
            if(this.field645[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field643[var9] = var1;
         this.field644[var9] = var2;
         this.field646[var9] = var3;
         this.field647[var9] = var4;
         this.field645[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-466505347"
   )
   final void method621(int var1) {
      CombatInfo2 var2 = class33.method781(var1);

      for(CombatInfoListHolder var3 = (CombatInfoListHolder)this.combatInfoList.method2420(); var3 != null; var3 = (CombatInfoListHolder)this.combatInfoList.method2415()) {
         if(var2 == var3.combatInfo2) {
            var3.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1995700521"
   )
   final void method624() {
      this.field673 = 0;
      this.field682 = 0;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "747186555"
   )
   final void method631(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = class33.method781(var1);
      CombatInfoListHolder var8 = null;
      CombatInfoListHolder var9 = null;
      int var10 = var7.field2844;
      int var11 = 0;

      CombatInfoListHolder var12;
      for(var12 = (CombatInfoListHolder)this.combatInfoList.method2420(); null != var12; var12 = (CombatInfoListHolder)this.combatInfoList.method2415()) {
         ++var11;
         if(var7.field2841 == var12.combatInfo2.field2841) {
            var12.method789(var2 + var4, var5, var6, var3);
            return;
         }

         if(var12.combatInfo2.field2843 <= var7.field2843) {
            var8 = var12;
         }

         if(var12.combatInfo2.field2844 > var10) {
            var9 = var12;
            var10 = var12.combatInfo2.field2844;
         }
      }

      if(var9 != null || var11 < 4) {
         var12 = new CombatInfoListHolder(var7);
         if(null == var8) {
            this.combatInfoList.method2422(var12);
         } else {
            CombatInfoList.method2429(var12, var8);
         }

         var12.method789(var2 + var4, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-33"
   )
   static final void method632(boolean var0) {
      class7.method91();
      ++Client.field354;
      if(Client.field354 >= 50 || var0) {
         Client.field354 = 0;
         if(!Client.field387 && class149.field2036 != null) {
            Client.field348.method3073(8);

            try {
               class149.field2036.method2114(Client.field348.payload, 0, Client.field348.offset);
               Client.field348.offset = 0;
            } catch (IOException var2) {
               Client.field387 = true;
            }
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;I)Ljava/lang/String;",
      garbageValue = "1392122247"
   )
   static String method633(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class101) {
         class101 var2 = (class101)var0;
         var1 = var2.field1658 + " | ";
         var0 = var2.field1659;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while(true) {
         while(true) {
            String var7 = var5.readLine();
            if(var7 == null) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, var8 + 1);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(var8 + 1, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(5 + var11);
                  var1 = var1 + var10 + ' ';
                  continue;
               }

               var7 = var7.substring(0, var8);
            }

            var7 = var7.trim();
            var7 = var7.substring(var7.lastIndexOf(32) + 1);
            var7 = var7.substring(var7.lastIndexOf(9) + 1);
            var1 = var1 + var7 + ' ';
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-82"
   )
   public static int method634(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return 1 + var0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1678627083"
   )
   public static void method635() {
      Sequence.field3054.reset();
      Sequence.field3055.reset();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1303006513"
   )
   static void method636() {
      Ignore.field223 = null;
      class225.field3233 = null;
      class225.field3234 = null;
      class41.field862 = null;
      class160.field2146 = null;
      class11.field129 = null;
   }
}
