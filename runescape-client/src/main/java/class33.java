import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class33 {
   @ObfuscatedName("az")
   @Export("worldSelectShown")
   static boolean field757;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -942529295
   )
   static int field758 = 0;
   @ObfuscatedName("c")
   static class83 field759;
   @ObfuscatedName("h")
   static class83 field760;
   @ObfuscatedName("a")
   static class81 field761;
   @ObfuscatedName("u")
   static class83 field762;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 568837685
   )
   @Export("loginWindowX")
   static int field765;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1036466563
   )
   static int field766;
   @ObfuscatedName("t")
   static int[] field767;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1760393797
   )
   static int field768;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 164660823
   )
   static int field769;
   @ObfuscatedName("af")
   static class162 field770;
   @ObfuscatedName("ah")
   static int[] field771;
   @ObfuscatedName("ad")
   @Export("loginMessage1")
   static String field772;
   @ObfuscatedName("e")
   static boolean field773;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -786858025
   )
   static int field774;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 728400689
   )
   static int field775;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1013183315
   )
   static int field776;
   @ObfuscatedName("ap")
   static String field777;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1799342597
   )
   @Export("loginIndex")
   static int field778;
   @ObfuscatedName("aw")
   static String field779;
   @ObfuscatedName("aq")
   static String field780;
   @ObfuscatedName("aa")
   @Export("loginMessage2")
   static String field781;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1402423439
   )
   static int field783;
   @ObfuscatedName("ag")
   @Export("username")
   static String field784;
   @ObfuscatedName("m")
   static int[] field785;
   @ObfuscatedName("ai")
   @Export("authCode")
   static String field786;
   @ObfuscatedName("ar")
   static boolean field787;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 77788123
   )
   @Export("loginIndex2")
   static int field788;
   @ObfuscatedName("at")
   @Export("loginMessage3")
   static String field791;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 2138242613
   )
   static int field792;
   @ObfuscatedName("mc")
   static class81 field793;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZB)Z",
      garbageValue = "96"
   )
   public static boolean method680(File var0, boolean var1) {
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

   static {
      field765 = 202 + field758;
      field767 = new int[256];
      field769 = 0;
      field783 = 0;
      field768 = 0;
      field766 = 0;
      field774 = 0;
      field775 = 0;
      field776 = 10;
      field777 = "";
      field778 = 0;
      field779 = "";
      field772 = "";
      field781 = "";
      field791 = "";
      field784 = "";
      field780 = "";
      field770 = class162.field2649;
      field787 = true;
      field788 = 0;
      field757 = false;
      field792 = -1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-8"
   )
   static void method716() {
      class34.field804 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class34.field798[var0] = null;
         class34.field799[var0] = 1;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Lclass81;",
      garbageValue = "-1598911354"
   )
   @Export("createSprite")
   public static final class81 method717(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var3 << 42) + ((long)var4 << 40) + ((long)var2 << 38) + ((long)var1 << 16) + (long)var0;
      class81 var8;
      if(!var5) {
         var8 = (class81)class55.field1179.method3834(var6);
         if(var8 != null) {
            return var8;
         }
      }

      class55 var9 = class9.method108(var0);
      if(var1 > 1 && var9.field1211 != null) {
         int var10 = -1;

         for(int var19 = 0; var19 < 10; ++var19) {
            if(var1 >= var9.field1212[var19] && var9.field1212[var19] != 0) {
               var10 = var9.field1211[var19];
            }
         }

         if(var10 != -1) {
            var9 = class9.method108(var10);
         }
      }

      class108 var20 = var9.method1160(1);
      if(var20 == null) {
         return null;
      } else {
         class81 var11 = null;
         if(var9.field1190 != -1) {
            var11 = method717(var9.field1225, 10, 1, 0, 0, true);
            if(var11 == null) {
               return null;
            }
         } else if(var9.field1223 != -1) {
            var11 = method717(var9.field1222, var1, var2, var3, 0, false);
            if(var11 == null) {
               return null;
            }
         } else if(var9.field1214 != -1) {
            var11 = method717(var9.field1224, var1, 0, 0, 0, false);
            if(var11 == null) {
               return null;
            }
         }

         int[] var12 = class82.field1482;
         int var13 = class82.field1478;
         int var14 = class82.field1477;
         int[] var15 = new int[4];
         class82.method1885(var15);
         var8 = new class81(36, 32);
         class82.method1932(var8.field1476, 36, 32);
         class82.method1887();
         class94.method2184();
         class94.method2227(16, 16);
         class94.field1635 = false;
         if(var9.field1214 != -1) {
            var11.method1873(0, 0);
         }

         int var16 = var9.field1195;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = class94.field1655[var9.field1200] * var16 >> 16;
         int var18 = class94.field1653[var9.field1200] * var16 >> 16;
         var20.method2381();
         var20.method2422(0, var9.field1186, var9.field1191, var9.field1200, var9.field1192, var20.field1529 / 2 + var17 + var9.field1193, var18 + var9.field1193);
         if(var9.field1223 != -1) {
            var11.method1873(0, 0);
         }

         if(var2 >= 1) {
            var8.method1790(1);
         }

         if(var2 >= 2) {
            var8.method1790(16777215);
         }

         if(var3 != 0) {
            var8.method1791(var3);
         }

         class82.method1932(var8.field1476, 36, 32);
         if(var9.field1190 != -1) {
            var11.method1873(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.field1194 == 1) {
            class55.field1219.method4177(class26.method592(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            class55.field1179.method3836(var8, var6);
         }

         class82.method1932(var12, var13, var14);
         class82.method1912(var15);
         class94.method2184();
         class94.field1635 = true;
         return var8;
      }
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1819437840"
   )
   static final void method718() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < client.field435 - 1; ++var1) {
            if(client.field438[var1] < 1000 && client.field438[1 + var1] > 1000) {
               String var2 = client.field441[var1];
               client.field441[var1] = client.field441[1 + var1];
               client.field441[1 + var1] = var2;
               String var3 = client.field440[var1];
               client.field440[var1] = client.field440[1 + var1];
               client.field440[var1 + 1] = var3;
               int var4 = client.field438[var1];
               client.field438[var1] = client.field438[1 + var1];
               client.field438[var1 + 1] = var4;
               var4 = client.field436[var1];
               client.field436[var1] = client.field436[1 + var1];
               client.field436[1 + var1] = var4;
               var4 = client.field437[var1];
               client.field437[var1] = client.field437[1 + var1];
               client.field437[var1 + 1] = var4;
               var4 = client.field303[var1];
               client.field303[var1] = client.field303[var1 + 1];
               client.field303[1 + var1] = var4;
               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)[Lclass81;",
      garbageValue = "288642119"
   )
   static class81[] method720(class170 var0, int var1, int var2) {
      return !class42.method884(var0, var1, var2)?null:class138.method2990();
   }
}
