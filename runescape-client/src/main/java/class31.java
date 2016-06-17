import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class31 {
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1029388575
   )
   static int field694;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1778300449
   )
   static int field695 = 0;
   @ObfuscatedName("c")
   static class80 field696;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1070334363
   )
   static int field697;
   @ObfuscatedName("y")
   static class78 field699;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 994791441
   )
   static int field700;
   @ObfuscatedName("b")
   static boolean field701;
   @ObfuscatedName("ac")
   static String field705;
   @ObfuscatedName("f")
   static int[] field706;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1332001053
   )
   static int field707;
   @ObfuscatedName("j")
   static class80 field708;
   @ObfuscatedName("az")
   static String field709;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -2015006309
   )
   static int field710;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1325617137
   )
   @Export("loginWindowX")
   static int field711;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1997582033
   )
   static int field712;
   @ObfuscatedName("d")
   static class80 field714;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 775660057
   )
   @Export("loginIndex")
   static int field715;
   @ObfuscatedName("as")
   static String field716;
   @ObfuscatedName("ar")
   @Export("loginMessage1")
   static String field717;
   @ObfuscatedName("aq")
   @Export("loginMessage2")
   static String field718;
   @ObfuscatedName("aa")
   @Export("loginMessage3")
   static String field719;
   @ObfuscatedName("x")
   static class80[] field720;
   @ObfuscatedName("h")
   static int[] field721;
   @ObfuscatedName("ak")
   static class159 field722;
   @ObfuscatedName("at")
   static boolean field723;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -953932899
   )
   @Export("loginIndex2")
   static int field724;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -811858823
   )
   static int field725;
   @ObfuscatedName("ay")
   @Export("username")
   static String field726;
   @ObfuscatedName("ao")
   @Export("worldSelectShown")
   static boolean field727;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 1034116059
   )
   static int field728;
   @ObfuscatedName("r")
   static class78 field730;

   static {
      field711 = field695 + 202;
      field721 = new int[256];
      field725 = 0;
      field707 = 0;
      field694 = 0;
      field710 = 0;
      field697 = 0;
      field712 = 0;
      field700 = 10;
      field709 = "";
      field715 = 0;
      field705 = "";
      field717 = "";
      field718 = "";
      field719 = "";
      field726 = "";
      field716 = "";
      field722 = class159.field2594;
      field723 = true;
      field724 = 0;
      field727 = false;
      field728 = -1;
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "22"
   )
   static final void method666(String var0) {
      if(null != var0) {
         String var1 = class39.method796(var0, client.field289);
         if(null != var1) {
            for(int var2 = 0; var2 < client.field340; ++var2) {
               class17 var3 = client.field556[var2];
               String var4 = var3.field243;
               String var5 = class39.method796(var4, client.field289);
               boolean var6;
               if(var0 != null && var4 != null) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --client.field340;

                  for(int var7 = var2; var7 < client.field340; ++var7) {
                     client.field556[var7] = client.field556[var7 + 1];
                  }

                  client.field492 = client.field359;
                  client.field331.method2781(188);
                  client.field331.method2650(class4.method41(var0));
                  client.field331.method2505(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lclass136;Ljava/awt/Component;III)Lclass56;",
      garbageValue = "-797667918"
   )
   public static final class56 method669(class136 var0, Component var1, int var2, int var3) {
      if(class56.field1153 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class69 var7 = new class69();
            var7.field1148 = new int[(class21.field581?2:1) * 256];
            var7.field1158 = var3;
            var7.vmethod1535(var1);
            var7.field1152 = 1024 + (var3 & -1024);
            if(var7.field1152 > 16384) {
               var7.field1152 = 16384;
            }

            var7.vmethod1517(var7.field1152);
            if(class107.field1863 > 0 && null == class56.field1159) {
               class56.field1159 = new class72();
               class56.field1159.field1327 = var0;
               var0.method2917(class56.field1159, class107.field1863);
            }

            if(class56.field1159 != null) {
               if(null != class56.field1159.field1317[var2]) {
                  throw new IllegalArgumentException();
               }

               class56.field1159.field1317[var2] = var7;
            }

            return var7;
         } catch (Throwable var6) {
            try {
               class54 var4 = new class54(var0, var2);
               var4.field1148 = new int[256 * (class21.field581?2:1)];
               var4.field1158 = var3;
               var4.vmethod1535(var1);
               var4.field1152 = 16384;
               var4.vmethod1517(var4.field1152);
               if(class107.field1863 > 0 && class56.field1159 == null) {
                  class56.field1159 = new class72();
                  class56.field1159.field1327 = var0;
                  var0.method2917(class56.field1159, class107.field1863);
               }

               if(class56.field1159 != null) {
                  if(class56.field1159.field1317[var2] != null) {
                     throw new IllegalArgumentException();
                  }

                  class56.field1159.field1317[var2] = var4;
               }

               return var4;
            } catch (Throwable var5) {
               return new class56();
            }
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "([Lclass173;II)V",
      garbageValue = "178436374"
   )
   static final void method705(class173[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class173 var3 = var0[var2];
         if(var3 != null) {
            if(var3.field2833 == 0) {
               if(null != var3.field2872) {
                  method705(var3.field2872, var1);
               }

               class3 var4 = (class3)client.field448.method3807((long)var3.field2748);
               if(null != var4) {
                  class32.method720(var4.field60, var1);
               }
            }

            class0 var5;
            if(var1 == 0 && var3.field2835 != null) {
               var5 = new class0();
               var5.field10 = var3;
               var5.field12 = var3.field2835;
               class90.method2092(var5, 200000);
            }

            if(var1 == 1 && var3.field2856 != null) {
               if(var3.field2749 >= 0) {
                  class173 var6 = class161.method3205(var3.field2748);
                  if(var6 == null || null == var6.field2872 || var3.field2749 >= var6.field2872.length || var3 != var6.field2872[var3.field2749]) {
                     continue;
                  }
               }

               var5 = new class0();
               var5.field10 = var3;
               var5.field12 = var3.field2856;
               class90.method2092(var5, 200000);
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)Lclass103;",
      garbageValue = "1"
   )
   @Export("getFrames")
   static class103 method706(int var0) {
      class103 var1 = (class103)class42.field961.method3764((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         class167 var3 = class42.field962;
         class167 var4 = class42.field963;
         boolean var5 = true;
         int[] var6 = var3.method3307(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method3298(var0, var6[var7]);
            if(var8 == null) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method3298(var9, 0);
               if(var10 == null) {
                  var5 = false;
               }
            }
         }

         class103 var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new class103(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         Object var10000 = null;
         return var2;
      }
   }
}
